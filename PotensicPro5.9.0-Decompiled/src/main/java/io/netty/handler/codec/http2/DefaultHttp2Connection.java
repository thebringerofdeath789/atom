package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.UnaryPromiseNotifier;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultHttp2Connection implements Http2Connection {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultHttp2Connection.class);
    final ActiveStreams activeStreams;
    Promise<Void> closePromise;
    final ConnectionStream connectionStream;
    final List<Http2Connection.Listener> listeners;
    final DefaultEndpoint<Http2LocalFlowController> localEndpoint;
    final PropertyKeyRegistry propertyKeyRegistry;
    final DefaultEndpoint<Http2RemoteFlowController> remoteEndpoint;
    final IntObjectMap<Http2Stream> streamMap;

    interface Event {
        void process();
    }

    public DefaultHttp2Connection(boolean z) {
        this(z, 100);
    }

    public DefaultHttp2Connection(boolean z, int i) {
        IntObjectHashMap intObjectHashMap = new IntObjectHashMap();
        this.streamMap = intObjectHashMap;
        this.propertyKeyRegistry = new PropertyKeyRegistry();
        ConnectionStream connectionStream = new ConnectionStream();
        this.connectionStream = connectionStream;
        ArrayList arrayList = new ArrayList(4);
        this.listeners = arrayList;
        this.activeStreams = new ActiveStreams(arrayList);
        this.localEndpoint = new DefaultEndpoint<>(z, z ? Integer.MAX_VALUE : i);
        this.remoteEndpoint = new DefaultEndpoint<>(!z, i);
        intObjectHashMap.put(connectionStream.id(), (int) connectionStream);
    }

    final boolean isClosed() {
        return this.closePromise != null;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Future<Void> close(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        Promise<Void> promise2 = this.closePromise;
        if (promise2 == null) {
            this.closePromise = promise;
        } else if (promise2 != promise) {
            if ((promise instanceof ChannelPromise) && ((ChannelPromise) promise2).isVoid()) {
                this.closePromise = promise;
            } else {
                this.closePromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new UnaryPromiseNotifier(promise));
            }
        }
        if (isStreamMapEmpty()) {
            promise.trySuccess(null);
            return promise;
        }
        Iterator<IntObjectMap.PrimitiveEntry<Http2Stream>> it = this.streamMap.entries().iterator();
        if (this.activeStreams.allowModifications()) {
            this.activeStreams.incrementPendingIterations();
            while (it.hasNext()) {
                try {
                    DefaultStream defaultStream = (DefaultStream) it.next().value();
                    if (defaultStream.id() != 0) {
                        defaultStream.close(it);
                    }
                } finally {
                    this.activeStreams.decrementPendingIterations();
                }
            }
        } else {
            while (it.hasNext()) {
                Http2Stream value = it.next().value();
                if (value.id() != 0) {
                    value.close();
                }
            }
        }
        return this.closePromise;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void addListener(Http2Connection.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void removeListener(Http2Connection.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean isServer() {
        return this.localEndpoint.isServer();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream connectionStream() {
        return this.connectionStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream stream(int i) {
        return this.streamMap.get(i);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean streamMayHaveExisted(int i) {
        return this.remoteEndpoint.mayHaveCreatedStream(i) || this.localEndpoint.mayHaveCreatedStream(i);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public int numActiveStreams() {
        return this.activeStreams.size();
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
        return this.activeStreams.forEachActiveStream(http2StreamVisitor);
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2LocalFlowController> local() {
        return this.localEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.Endpoint<Http2RemoteFlowController> remote() {
        return this.remoteEndpoint;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwayReceived() {
        return ((DefaultEndpoint) this.localEndpoint).lastStreamKnownByPeer >= 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwayReceived(final int i, long j, ByteBuf byteBuf) {
        this.localEndpoint.lastStreamKnownByPeer(i);
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            try {
                this.listeners.get(i2).onGoAwayReceived(i, j, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwayReceived.", th);
            }
        }
        try {
            forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.1
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    if (http2Stream.id() <= i || !DefaultHttp2Connection.this.localEndpoint.isValidStreamId(http2Stream.id())) {
                        return true;
                    }
                    http2Stream.close();
                    return true;
                }
            });
        } catch (Http2Exception e) {
            PlatformDependent.throwException(e);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public boolean goAwaySent() {
        return ((DefaultEndpoint) this.remoteEndpoint).lastStreamKnownByPeer >= 0;
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public void goAwaySent(final int i, long j, ByteBuf byteBuf) {
        this.remoteEndpoint.lastStreamKnownByPeer(i);
        for (int i2 = 0; i2 < this.listeners.size(); i2++) {
            try {
                this.listeners.get(i2).onGoAwaySent(i, j, byteBuf);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onGoAwaySent.", th);
            }
        }
        try {
            forEachActiveStream(new Http2StreamVisitor() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.2
                @Override // io.netty.handler.codec.http2.Http2StreamVisitor
                public boolean visit(Http2Stream http2Stream) {
                    if (http2Stream.id() <= i || !DefaultHttp2Connection.this.remoteEndpoint.isValidStreamId(http2Stream.id())) {
                        return true;
                    }
                    http2Stream.close();
                    return true;
                }
            });
        } catch (Http2Exception e) {
            PlatformDependent.throwException(e);
        }
    }

    private boolean isStreamMapEmpty() {
        return this.streamMap.size() == 1;
    }

    void removeStream(DefaultStream defaultStream, Iterator<?> it) {
        boolean z = true;
        if (it == null) {
            if (this.streamMap.remove(defaultStream.id()) == null) {
                z = false;
            }
        } else {
            it.remove();
        }
        if (z) {
            for (int i = 0; i < this.listeners.size(); i++) {
                try {
                    this.listeners.get(i).onStreamRemoved(defaultStream);
                } catch (Throwable th) {
                    logger.error("Caught Throwable from listener onStreamRemoved.", th);
                }
            }
            if (this.closePromise == null || !isStreamMapEmpty()) {
                return;
            }
            this.closePromise.trySuccess(null);
        }
    }

    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2Connection$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static Http2Stream.State activeState(int i, Http2Stream.State state, boolean z, boolean z2) throws Http2Exception {
        int i2 = AnonymousClass3.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[state.ordinal()];
        if (i2 == 1) {
            return z2 ? z ? Http2Stream.State.HALF_CLOSED_LOCAL : Http2Stream.State.HALF_CLOSED_REMOTE : Http2Stream.State.OPEN;
        }
        if (i2 == 2) {
            return Http2Stream.State.HALF_CLOSED_REMOTE;
        }
        if (i2 == 3) {
            return Http2Stream.State.HALF_CLOSED_LOCAL;
        }
        throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Attempting to open a stream in an invalid state: " + state, new Object[0]);
    }

    void notifyHalfClosed(Http2Stream http2Stream) {
        for (int i = 0; i < this.listeners.size(); i++) {
            try {
                this.listeners.get(i).onStreamHalfClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", th);
            }
        }
    }

    void notifyClosed(Http2Stream http2Stream) {
        for (int i = 0; i < this.listeners.size(); i++) {
            try {
                this.listeners.get(i).onStreamClosed(http2Stream);
            } catch (Throwable th) {
                logger.error("Caught Throwable from listener onStreamClosed.", th);
            }
        }
    }

    @Override // io.netty.handler.codec.http2.Http2Connection
    public Http2Connection.PropertyKey newKey() {
        return this.propertyKeyRegistry.newKey();
    }

    final DefaultPropertyKey verifyKey(Http2Connection.PropertyKey propertyKey) {
        return ((DefaultPropertyKey) ObjectUtil.checkNotNull((DefaultPropertyKey) propertyKey, "key")).verifyConnection(this);
    }

    private class DefaultStream implements Http2Stream {
        private static final byte META_STATE_RECV_HEADERS = 16;
        private static final byte META_STATE_RECV_TRAILERS = 32;
        private static final byte META_STATE_SENT_HEADERS = 2;
        private static final byte META_STATE_SENT_PUSHPROMISE = 8;
        private static final byte META_STATE_SENT_RST = 1;
        private static final byte META_STATE_SENT_TRAILERS = 4;
        private final int id;
        private byte metaState;
        private final PropertyMap properties = new PropertyMap();
        private Http2Stream.State state;

        DefaultStream(int i, Http2Stream.State state) {
            this.id = i;
            this.state = state;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final int id() {
            return this.id;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final Http2Stream.State state() {
            return this.state;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return (this.metaState & 1) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            this.metaState = (byte) (this.metaState | 1);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z) {
            if (!z) {
                this.metaState = (byte) (this.metaState | (isHeadersSent() ? (byte) 4 : (byte) 2));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            return (this.metaState & 2) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersSent() {
            return (this.metaState & 4) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersReceived(boolean z) {
            if (!z) {
                this.metaState = (byte) (this.metaState | (isHeadersReceived() ? (byte) 32 : (byte) 16));
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersReceived() {
            return (this.metaState & 16) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isTrailersReceived() {
            return (this.metaState & 32) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            this.metaState = (byte) (this.metaState | 8);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            return (this.metaState & 8) != 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v) {
            return (V) this.properties.add(DefaultHttp2Connection.this.verifyKey(propertyKey), v);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V getProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.get(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public final <V> V removeProperty(Http2Connection.PropertyKey propertyKey) {
            return (V) this.properties.remove(DefaultHttp2Connection.this.verifyKey(propertyKey));
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z) throws Http2Exception {
            this.state = DefaultHttp2Connection.activeState(this.id, this.state, isLocal(), z);
            if (!createdBy().canOpenStream()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Maximum active streams violated for this endpoint.", new Object[0]);
            }
            activate();
            return this;
        }

        void activate() {
            DefaultHttp2Connection.this.activeStreams.activate(this);
        }

        Http2Stream close(Iterator<?> it) {
            if (this.state == Http2Stream.State.CLOSED) {
                return this;
            }
            this.state = Http2Stream.State.CLOSED;
            DefaultEndpoint<? extends Http2FlowController> createdBy = createdBy();
            createdBy.numStreams--;
            DefaultHttp2Connection.this.activeStreams.deactivate(this, it);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            return close(null);
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            int i = AnonymousClass3.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_LOCAL;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i != 5) {
                close();
            }
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            int i = AnonymousClass3.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[this.state.ordinal()];
            if (i == 4) {
                this.state = Http2Stream.State.HALF_CLOSED_REMOTE;
                DefaultHttp2Connection.this.notifyHalfClosed(this);
            } else if (i != 6) {
                close();
            }
            return this;
        }

        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id) ? DefaultHttp2Connection.this.localEndpoint : DefaultHttp2Connection.this.remoteEndpoint;
        }

        final boolean isLocal() {
            return DefaultHttp2Connection.this.localEndpoint.isValidStreamId(this.id);
        }

        private class PropertyMap {
            Object[] values;

            private PropertyMap() {
                this.values = EmptyArrays.EMPTY_OBJECTS;
            }

            <V> V add(DefaultPropertyKey defaultPropertyKey, V v) {
                resizeIfNecessary(defaultPropertyKey.index);
                V v2 = (V) this.values[defaultPropertyKey.index];
                this.values[defaultPropertyKey.index] = v;
                return v2;
            }

            <V> V get(DefaultPropertyKey defaultPropertyKey) {
                int i = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i >= objArr.length) {
                    return null;
                }
                return (V) objArr[defaultPropertyKey.index];
            }

            <V> V remove(DefaultPropertyKey defaultPropertyKey) {
                int i = defaultPropertyKey.index;
                Object[] objArr = this.values;
                if (i >= objArr.length) {
                    return null;
                }
                V v = (V) objArr[defaultPropertyKey.index];
                this.values[defaultPropertyKey.index] = null;
                return v;
            }

            void resizeIfNecessary(int i) {
                Object[] objArr = this.values;
                if (i >= objArr.length) {
                    this.values = Arrays.copyOf(objArr, DefaultHttp2Connection.this.propertyKeyRegistry.size());
                }
            }
        }
    }

    private final class ConnectionStream extends DefaultStream {
        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream
        DefaultEndpoint<? extends Http2FlowController> createdBy() {
            return null;
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isResetSent() {
            return false;
        }

        ConnectionStream() {
            super(0, Http2Stream.State.IDLE);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream resetSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream open(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream close() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeLocalSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream closeRemoteSide() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream headersSent(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isHeadersSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public Http2Stream pushPromiseSent() {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.DefaultStream, io.netty.handler.codec.http2.Http2Stream
        public boolean isPushPromiseSent() {
            throw new UnsupportedOperationException();
        }
    }

    private final class DefaultEndpoint<F extends Http2FlowController> implements Http2Connection.Endpoint<F> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private F flowController;
        private int lastStreamKnownByPeer = -1;
        private int maxActiveStreams;
        private final int maxReservedStreams;
        private int maxStreams;
        private int nextReservationStreamId;
        private int nextStreamIdToCreate;
        int numActiveStreams;
        int numStreams;
        private boolean pushToAllowed;
        private final boolean server;

        DefaultEndpoint(boolean z, int i) {
            this.pushToAllowed = true;
            this.server = z;
            if (z) {
                this.nextStreamIdToCreate = 2;
                this.nextReservationStreamId = 0;
            } else {
                this.nextStreamIdToCreate = 1;
                this.nextReservationStreamId = 1;
            }
            this.pushToAllowed = true ^ z;
            this.maxActiveStreams = Integer.MAX_VALUE;
            this.maxReservedStreams = ObjectUtil.checkPositiveOrZero(i, "maxReservedStreams");
            updateMaxStreams();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int incrementAndGetNextStreamId() {
            int i = this.nextReservationStreamId;
            if (i < 0) {
                return i;
            }
            int i2 = i + 2;
            this.nextReservationStreamId = i2;
            return i2;
        }

        private void incrementExpectedStreamId(int i) {
            int i2 = this.nextReservationStreamId;
            if (i > i2 && i2 >= 0) {
                this.nextReservationStreamId = i;
            }
            this.nextStreamIdToCreate = i + 2;
            this.numStreams++;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isValidStreamId(int i) {
            if (i > 0) {
                return this.server == ((i & 1) == 0);
            }
            return false;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean mayHaveCreatedStream(int i) {
            return isValidStreamId(i) && i <= lastStreamCreated();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean canOpenStream() {
            return this.numActiveStreams < this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream createStream(int i, boolean z) throws Http2Exception {
            Http2Stream.State activeState = DefaultHttp2Connection.activeState(i, Http2Stream.State.IDLE, isLocal(), z);
            checkNewStreamAllowed(i, activeState);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i, activeState);
            incrementExpectedStreamId(i);
            addStream(defaultStream);
            defaultStream.activate();
            return defaultStream;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean created(Http2Stream http2Stream) {
            return (http2Stream instanceof DefaultStream) && ((DefaultStream) http2Stream).createdBy() == this;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean isServer() {
            return this.server;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public DefaultStream reservePushStream(int i, Http2Stream http2Stream) throws Http2Exception {
            if (http2Stream == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Parent stream missing", new Object[0]);
            }
            if (!isLocal() ? http2Stream.state().remoteSideOpen() : http2Stream.state().localSideOpen()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d is not open for sending push promise", Integer.valueOf(http2Stream.id()));
            }
            if (!opposite().allowPushTo()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server push not allowed to opposite endpoint", new Object[0]);
            }
            Http2Stream.State state = isLocal() ? Http2Stream.State.RESERVED_LOCAL : Http2Stream.State.RESERVED_REMOTE;
            checkNewStreamAllowed(i, state);
            DefaultStream defaultStream = DefaultHttp2Connection.this.new DefaultStream(i, state);
            incrementExpectedStreamId(i);
            addStream(defaultStream);
            return defaultStream;
        }

        private void addStream(DefaultStream defaultStream) {
            DefaultHttp2Connection.this.streamMap.put(defaultStream.id(), (int) defaultStream);
            for (int i = 0; i < DefaultHttp2Connection.this.listeners.size(); i++) {
                try {
                    DefaultHttp2Connection.this.listeners.get(i).onStreamAdded(defaultStream);
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamAdded.", th);
                }
            }
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void allowPushTo(boolean z) {
            if (z && this.server) {
                throw new IllegalArgumentException("Servers do not allow push");
            }
            this.pushToAllowed = z;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public boolean allowPushTo() {
            return this.pushToAllowed;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int numActiveStreams() {
            return this.numActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int maxActiveStreams() {
            return this.maxActiveStreams;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void maxActiveStreams(int i) {
            this.maxActiveStreams = i;
            updateMaxStreams();
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamCreated() {
            int i = this.nextStreamIdToCreate;
            if (i > 1) {
                return i - 2;
            }
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public int lastStreamKnownByPeer() {
            return this.lastStreamKnownByPeer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lastStreamKnownByPeer(int i) {
            this.lastStreamKnownByPeer = i;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public F flowController() {
            return this.flowController;
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public void flowController(F f) {
            this.flowController = (F) ObjectUtil.checkNotNull(f, "flowController");
        }

        @Override // io.netty.handler.codec.http2.Http2Connection.Endpoint
        public Http2Connection.Endpoint<? extends Http2FlowController> opposite() {
            return isLocal() ? DefaultHttp2Connection.this.remoteEndpoint : DefaultHttp2Connection.this.localEndpoint;
        }

        private void updateMaxStreams() {
            this.maxStreams = (int) Math.min(2147483647L, this.maxActiveStreams + this.maxReservedStreams);
        }

        private void checkNewStreamAllowed(int i, Http2Stream.State state) throws Http2Exception {
            if (DefaultHttp2Connection.this.goAwayReceived() && i > DefaultHttp2Connection.this.localEndpoint.lastStreamKnownByPeer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Cannot create stream %d since this endpoint has received a GOAWAY frame with last stream id %d.", Integer.valueOf(i), Integer.valueOf(DefaultHttp2Connection.this.localEndpoint.lastStreamKnownByPeer()));
            }
            if (!isValidStreamId(i)) {
                if (i < 0) {
                    throw new Http2NoMoreStreamIdsException();
                }
                Http2Error http2Error = Http2Error.PROTOCOL_ERROR;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.server ? "server" : "client";
                throw Http2Exception.connectionError(http2Error, "Request stream %d is not correct for %s connection", objArr);
            }
            int i2 = this.nextStreamIdToCreate;
            if (i < i2) {
                throw Http2Exception.closedStreamError(Http2Error.PROTOCOL_ERROR, "Request stream %d is behind the next expected stream %d", Integer.valueOf(i), Integer.valueOf(this.nextStreamIdToCreate));
            }
            if (i2 <= 0) {
                throw Http2Exception.connectionError(Http2Error.REFUSED_STREAM, "Stream IDs are exhausted for this endpoint.", new Object[0]);
            }
            boolean z = state == Http2Stream.State.RESERVED_LOCAL || state == Http2Stream.State.RESERVED_REMOTE;
            if ((!z && !canOpenStream()) || (z && this.numStreams >= this.maxStreams)) {
                throw Http2Exception.streamError(i, Http2Error.REFUSED_STREAM, "Maximum active streams violated for this endpoint.", new Object[0]);
            }
            if (DefaultHttp2Connection.this.isClosed()) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Attempted to create stream id %d after connection was closed", Integer.valueOf(i));
            }
        }

        private boolean isLocal() {
            return this == DefaultHttp2Connection.this.localEndpoint;
        }
    }

    private final class ActiveStreams {
        private final List<Http2Connection.Listener> listeners;
        private int pendingIterations;
        private final Queue<Event> pendingEvents = new ArrayDeque(4);
        private final Set<Http2Stream> streams = new LinkedHashSet();

        public ActiveStreams(List<Http2Connection.Listener> list) {
            this.listeners = list;
        }

        public int size() {
            return this.streams.size();
        }

        public void activate(final DefaultStream defaultStream) {
            if (allowModifications()) {
                addToActiveStreams(defaultStream);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.1
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.addToActiveStreams(defaultStream);
                    }
                });
            }
        }

        public void deactivate(final DefaultStream defaultStream, final Iterator<?> it) {
            if (allowModifications() || it != null) {
                removeFromActiveStreams(defaultStream, it);
            } else {
                this.pendingEvents.add(new Event() { // from class: io.netty.handler.codec.http2.DefaultHttp2Connection.ActiveStreams.2
                    @Override // io.netty.handler.codec.http2.DefaultHttp2Connection.Event
                    public void process() {
                        ActiveStreams.this.removeFromActiveStreams(defaultStream, it);
                    }
                });
            }
        }

        public Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception {
            incrementPendingIterations();
            try {
                for (Http2Stream http2Stream : this.streams) {
                    if (!http2StreamVisitor.visit(http2Stream)) {
                        return http2Stream;
                    }
                }
                return null;
            } finally {
                decrementPendingIterations();
            }
        }

        void addToActiveStreams(DefaultStream defaultStream) {
            if (this.streams.add(defaultStream)) {
                defaultStream.createdBy().numActiveStreams++;
                for (int i = 0; i < this.listeners.size(); i++) {
                    try {
                        this.listeners.get(i).onStreamActive(defaultStream);
                    } catch (Throwable th) {
                        DefaultHttp2Connection.logger.error("Caught Throwable from listener onStreamActive.", th);
                    }
                }
            }
        }

        void removeFromActiveStreams(DefaultStream defaultStream, Iterator<?> it) {
            if (this.streams.remove(defaultStream)) {
                DefaultEndpoint<? extends Http2FlowController> createdBy = defaultStream.createdBy();
                createdBy.numActiveStreams--;
                DefaultHttp2Connection.this.notifyClosed(defaultStream);
            }
            DefaultHttp2Connection.this.removeStream(defaultStream, it);
        }

        boolean allowModifications() {
            return this.pendingIterations == 0;
        }

        void incrementPendingIterations() {
            this.pendingIterations++;
        }

        void decrementPendingIterations() {
            this.pendingIterations--;
            if (!allowModifications()) {
                return;
            }
            while (true) {
                Event poll = this.pendingEvents.poll();
                if (poll == null) {
                    return;
                }
                try {
                    poll.process();
                } catch (Throwable th) {
                    DefaultHttp2Connection.logger.error("Caught Throwable while processing pending ActiveStreams$Event.", th);
                }
            }
        }
    }

    final class DefaultPropertyKey implements Http2Connection.PropertyKey {
        final int index;

        DefaultPropertyKey(int i) {
            this.index = i;
        }

        DefaultPropertyKey verifyConnection(Http2Connection http2Connection) {
            if (http2Connection == DefaultHttp2Connection.this) {
                return this;
            }
            throw new IllegalArgumentException("Using a key that was not created by this connection");
        }
    }

    private final class PropertyKeyRegistry {
        final List<DefaultPropertyKey> keys;

        private PropertyKeyRegistry() {
            this.keys = new ArrayList(4);
        }

        DefaultPropertyKey newKey() {
            DefaultPropertyKey defaultPropertyKey = DefaultHttp2Connection.this.new DefaultPropertyKey(this.keys.size());
            this.keys.add(defaultPropertyKey);
            return defaultPropertyKey;
        }

        int size() {
            return this.keys.size();
        }
    }
}
