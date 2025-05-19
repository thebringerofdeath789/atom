package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.net.imap.IMAPSClient;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_HOSTNAME_VALIDATION_FLAGS = 0;
    private static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private Object algorithmConstraints;
    private final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private boolean certificateSet;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile int destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    SSLHandshakeException handshakeException;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private final OpenSslKeyMaterialManager keyMaterialManager;
    private volatile long lastAccessed;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private final Certificate[] localCerts;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private long networkBIO;
    private boolean outboundClosed;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final boolean rejectRemoteInitiatedRenegotiation;
    private boolean renegotiationPending;
    private final OpenSslSession session;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<String> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslEngine.class);
    private static final SSLException BEGIN_HANDSHAKE_ENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("engine closed"), ReferenceCountedOpenSslEngine.class, "beginHandshake()");
    private static final SSLException HANDSHAKE_ENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("engine closed"), ReferenceCountedOpenSslEngine.class, "handshake()");
    private static final SSLException RENEGOTIATION_UNSUPPORTED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("renegotiation unsupported"), ReferenceCountedOpenSslEngine.class, "beginHandshake()");
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2};
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    private static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
    private static final AtomicIntegerFieldUpdater<ReferenceCountedOpenSslEngine> DESTROYED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ReferenceCountedOpenSslEngine.class, "destroyed");
    private static final SSLEngineResult NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);

    private enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    @Override // javax.net.ssl.SSLEngine
    public final Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z, boolean z2) {
        super(str, i);
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslEngine.this;
            }

            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
            }
        };
        this.clientAuth = ClientAuth.NONE;
        this.lastAccessed = -1L;
        boolean z3 = true;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        this.session = new OpenSslSession(referenceCountedOpenSslContext.sessionContext());
        boolean isClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = isClient;
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        this.rejectRemoteInitiatedRenegotiation = referenceCountedOpenSslContext.getRejectRemoteInitiatedRenegotiation();
        this.localCerts = referenceCountedOpenSslContext.keyCertChain;
        this.keyMaterialManager = referenceCountedOpenSslContext.keyMaterialManager();
        boolean z4 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z4;
        this.jdkCompatibilityMode = z;
        Lock readLock = referenceCountedOpenSslContext.ctxLock.readLock();
        readLock.lock();
        try {
            long j = referenceCountedOpenSslContext.ctx;
            if (referenceCountedOpenSslContext.isClient()) {
                z3 = false;
            }
            long newSSL = SSL.newSSL(j, z3);
            synchronized (this) {
                this.ssl = newSSL;
                try {
                    this.networkBIO = SSL.bioNewByteBuffer(newSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                    setClientAuth(isClient ? ClientAuth.NONE : referenceCountedOpenSslContext.clientAuth);
                    if (referenceCountedOpenSslContext.protocols != null) {
                        setEnabledProtocols(referenceCountedOpenSslContext.protocols);
                    }
                    if (isClient && str != null) {
                        SSL.setTlsExtHostName(this.ssl, str);
                    }
                    if (z4) {
                        SSL.enableOcsp(this.ssl);
                    }
                    if (!z) {
                        long j2 = this.ssl;
                        SSL.setMode(j2, SSL.getMode(j2) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                    }
                    calculateMaxWrapOverhead();
                } catch (Throwable th) {
                    SSL.freeSSL(this.ssl);
                    PlatformDependent.throwException(th);
                }
            }
            this.leak = z2 ? leakDetector.track(this) : null;
        } finally {
            readLock.unlock();
        }
    }

    public void setOcspResponse(byte[] bArr) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        }
        synchronized (this) {
            SSL.setOcspResponse(this.ssl, bArr);
        }
    }

    public byte[] getOcspResponse() {
        byte[] ocspResponse;
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        }
        synchronized (this) {
            ocspResponse = SSL.getOcspResponse(this.ssl);
        }
        return ocspResponse;
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i) {
        this.refCnt.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        return this.refCnt.release(i);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i = AnonymousClass2.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i == 1 || i == 2) {
            return null;
        }
        return this.session;
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    public final synchronized void shutdown() {
        if (DESTROYED_UPDATER.compareAndSet(this, 0, 1)) {
            this.engineMap.remove(this.ssl);
            SSL.freeSSL(this.ssl);
            this.networkBIO = 0L;
            this.ssl = 0L;
            this.outboundClosed = true;
            this.isInboundDone = true;
        }
        SSL.clearError();
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) {
        int writeToSSL;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            writeToSSL = SSL.writeToSSL(this.ssl, Buffer.address(byteBuffer) + position, i);
            if (writeToSSL > 0) {
                byteBuffer.position(position + writeToSSL);
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(i);
            try {
                byteBuffer.limit(position + i);
                directBuffer.setBytes(0, byteBuffer);
                byteBuffer.limit(limit);
                writeToSSL = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), i);
                if (writeToSSL > 0) {
                    byteBuffer.position(position + writeToSSL);
                } else {
                    byteBuffer.position(position);
                }
            } finally {
                directBuffer.release();
            }
        }
        return writeToSSL;
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, Buffer.address(byteBuffer) + position, i, false);
            return null;
        }
        ByteBuf directBuffer = this.alloc.directBuffer(i);
        try {
            int limit = byteBuffer.limit();
            byteBuffer.limit(position + i);
            directBuffer.writeBytes(byteBuffer);
            byteBuffer.position(position);
            byteBuffer.limit(limit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(directBuffer), i, false);
            return directBuffer;
        } catch (Throwable th) {
            directBuffer.release();
            PlatformDependent.throwException(th);
            return null;
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            int readFromSSL = SSL.readFromSSL(this.ssl, Buffer.address(byteBuffer) + position, byteBuffer.limit() - position);
            if (readFromSSL <= 0) {
                return readFromSSL;
            }
            byteBuffer.position(position + readFromSSL);
            return readFromSSL;
        }
        int limit = byteBuffer.limit();
        int min = Math.min(maxEncryptedPacketLength0(), limit - position);
        ByteBuf directBuffer = this.alloc.directBuffer(min);
        try {
            int readFromSSL2 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), min);
            if (readFromSSL2 > 0) {
                byteBuffer.limit(position + readFromSSL2);
                directBuffer.getBytes(directBuffer.readerIndex(), byteBuffer);
                byteBuffer.limit(limit);
            }
            return readFromSSL2;
        } finally {
            directBuffer.release();
        }
    }

    final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
    }

    final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    final int calculateMaxLengthForWrap(int i, int i2) {
        return (int) Math.min(this.maxWrapBufferSize, i + (this.maxWrapOverhead * i2));
    }

    final synchronized int sslPending() {
        return sslPending0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private boolean isBytesAvailableEnoughForWrap(int i, int i2, int i3) {
        return ((long) i) - (((long) this.maxWrapOverhead) * ((long) i3)) >= ((long) i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:239:0x0427 A[Catch: all -> 0x043f, TryCatch #5 {, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:19:0x002b, B:22:0x0029, B:34:0x007a, B:36:0x0081, B:37:0x0098, B:39:0x008a, B:43:0x00a6, B:45:0x00ad, B:46:0x00c4, B:48:0x00b6, B:52:0x00d3, B:54:0x00da, B:55:0x00f1, B:57:0x00e3, B:237:0x0420, B:239:0x0427, B:240:0x043e, B:241:0x0436, B:246:0x0120, B:248:0x0127, B:249:0x013e, B:251:0x0130, B:77:0x0185, B:79:0x018c, B:80:0x01a3, B:82:0x0195, B:90:0x01b4, B:92:0x01bb, B:93:0x01d2, B:95:0x01c4, B:101:0x01e2, B:103:0x01e9, B:104:0x0200, B:106:0x01f2, B:133:0x025e, B:135:0x0265, B:136:0x027c, B:138:0x026e, B:161:0x02fb, B:163:0x0302, B:164:0x0319, B:166:0x030b, B:181:0x0357, B:183:0x035e, B:184:0x0375, B:186:0x0367, B:190:0x037d, B:192:0x0384, B:193:0x039b, B:195:0x038d, B:199:0x03a7, B:201:0x03ae, B:202:0x03c5, B:204:0x03b7, B:208:0x03d1, B:210:0x03d8, B:211:0x03ef, B:213:0x03e1, B:221:0x02b4, B:223:0x02bb, B:224:0x02d2, B:226:0x02c4, B:229:0x03fc, B:231:0x0403, B:232:0x041a, B:234:0x040c), top: B:10:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0436 A[Catch: all -> 0x043f, TryCatch #5 {, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:19:0x002b, B:22:0x0029, B:34:0x007a, B:36:0x0081, B:37:0x0098, B:39:0x008a, B:43:0x00a6, B:45:0x00ad, B:46:0x00c4, B:48:0x00b6, B:52:0x00d3, B:54:0x00da, B:55:0x00f1, B:57:0x00e3, B:237:0x0420, B:239:0x0427, B:240:0x043e, B:241:0x0436, B:246:0x0120, B:248:0x0127, B:249:0x013e, B:251:0x0130, B:77:0x0185, B:79:0x018c, B:80:0x01a3, B:82:0x0195, B:90:0x01b4, B:92:0x01bb, B:93:0x01d2, B:95:0x01c4, B:101:0x01e2, B:103:0x01e9, B:104:0x0200, B:106:0x01f2, B:133:0x025e, B:135:0x0265, B:136:0x027c, B:138:0x026e, B:161:0x02fb, B:163:0x0302, B:164:0x0319, B:166:0x030b, B:181:0x0357, B:183:0x035e, B:184:0x0375, B:186:0x0367, B:190:0x037d, B:192:0x0384, B:193:0x039b, B:195:0x038d, B:199:0x03a7, B:201:0x03ae, B:202:0x03c5, B:204:0x03b7, B:208:0x03d1, B:210:0x03d8, B:211:0x03ef, B:213:0x03e1, B:221:0x02b4, B:223:0x02bb, B:224:0x02d2, B:226:0x02c4, B:229:0x03fc, B:231:0x0403, B:232:0x041a, B:234:0x040c), top: B:10:0x0013 }] */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r11, int r12, int r13, java.nio.ByteBuffer r14) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        if (isOutboundDone()) {
            if (isInboundDone()) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                shutdown();
            }
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i, i2);
        }
        return new SSLEngineResult(status, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) throws SSLException {
        return newResult(mayFinishHandshake(handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED ? getHandshakeStatus() : SSLEngineResult.HandshakeStatus.FINISHED), i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) throws SSLException {
        return newResult(status, mayFinishHandshake(handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED ? getHandshakeStatus() : SSLEngineResult.HandshakeStatus.FINISHED), i, i2);
    }

    private SSLException shutdownWithError(String str) {
        return shutdownWithError(str, SSL.getLastError());
    }

    private SSLException shutdownWithError(String str, String str2) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed: OpenSSL error: {}", str, str2);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(str2);
        }
        return new SSLHandshakeException(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0219, code lost:
    
        if (r13 == null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01aa, code lost:
    
        r13.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x01a8, code lost:
    
        if (r13 != null) goto L109;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r19, int r20, int r21, java.nio.ByteBuffer[] r22, int r23, int r24) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    private SSLEngineResult sslReadErrorResult(int i, int i2, int i3) throws SSLException {
        String errorString = SSL.getErrorString(i);
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            if (this.handshakeException == null && this.handshakeState != HandshakeState.FINISHED) {
                this.handshakeException = new SSLHandshakeException(errorString);
            }
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i2, i3);
        }
        throw shutdownWithError("SSL_read", errorString);
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (!this.rejectRemoteInitiatedRenegotiation || isDestroyed() || SSL.getHandshakeCount(this.ssl) <= 1) {
            return;
        }
        shutdown();
        throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        try {
        } finally {
            resetSingleSrcBuffer();
        }
        return unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        if (this.isInboundDone) {
            return;
        }
        this.isInboundDone = true;
        if (isOutboundDone()) {
            shutdown();
        }
        if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
            throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        if (this.handshakeState != HandshakeState.NOT_STARTED && !isDestroyed()) {
            if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        } else {
            shutdown();
        }
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int shutdownSSL = SSL.shutdownSSL(this.ssl);
        if (shutdownSSL >= 0) {
            return true;
        }
        int error = SSL.getError(this.ssl, shutdownSSL);
        if (error == SSL.SSL_ERROR_SYSCALL || error == SSL.SSL_ERROR_SSL) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("SSL_shutdown failed: OpenSSL error: {}", SSL.getLastError());
            }
            shutdown();
            return false;
        }
        SSL.clearError();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0) == 0) goto L9;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isOutboundDone() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.outboundClosed     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L15
            long r0 = r4.networkBIO     // Catch: java.lang.Throwable -> L18
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L13
            int r0 = io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0)     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L15
        L13:
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            monitor-exit(r4)
            return r0
        L18:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.isOutboundDone():boolean");
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[OpenSsl.AVAILABLE_CIPHER_SUITES.size()]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        synchronized (this) {
            if (!isDestroyed()) {
                String[] ciphers = SSL.getCiphers(this.ssl);
                if (ciphers == null) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                synchronized (this) {
                    for (int i = 0; i < ciphers.length; i++) {
                        String javaCipherSuite = toJavaCipherSuite(ciphers[i]);
                        if (javaCipherSuite != null) {
                            ciphers[i] = javaCipherSuite;
                        }
                    }
                }
                return ciphers;
            }
            return EmptyArrays.EMPTY_STRINGS;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str == null) {
                break;
            }
            String openSsl = CipherSuiteConverter.toOpenSsl(str);
            if (openSsl == null) {
                openSsl = str;
            }
            if (!OpenSsl.isCipherSuiteAvailable(openSsl)) {
                throw new IllegalArgumentException("unsupported cipher suite: " + str + PropertyUtils.MAPPED_DELIM + openSsl + PropertyUtils.MAPPED_DELIM2);
            }
            sb.append(openSsl);
            sb.append(NameUtil.COLON);
        }
        if (sb.length() == 0) {
            throw new IllegalArgumentException("empty cipher suites");
        }
        sb.setLength(sb.length() - 1);
        String sb2 = sb.toString();
        synchronized (this) {
            if (!isDestroyed()) {
                try {
                    SSL.setCipherSuites(this.ssl, sb2);
                } catch (Exception e) {
                    throw new IllegalStateException("failed to enable cipher suites: " + sb2, e);
                }
            } else {
                throw new IllegalStateException("failed to enable cipher suites: " + sb2);
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[OpenSsl.SUPPORTED_PROTOCOLS_SET.size()]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add("SSLv2Hello");
        synchronized (this) {
            if (!isDestroyed()) {
                int options = SSL.getOptions(this.ssl);
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1, "TLSv1")) {
                    arrayList.add("TLSv1");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_1, "TLSv1.1")) {
                    arrayList.add("TLSv1.1");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_2, "TLSv1.2")) {
                    arrayList.add("TLSv1.2");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
                    arrayList.add("SSLv2");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv3, "SSLv3")) {
                    arrayList.add("SSLv3");
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return (String[]) arrayList.toArray(new String[1]);
        }
    }

    private static boolean isProtocolEnabled(int i, int i2, String str) {
        return (i & i2) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException();
        }
        int length = OPENSSL_OP_NO_PROTOCOLS.length;
        int i = 0;
        for (String str : strArr) {
            if (!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                throw new IllegalArgumentException("Protocol " + str + " is not supported.");
            }
            if (str.equals("SSLv2")) {
                if (length > 0) {
                    length = 0;
                }
                if (i < 0) {
                    i = 0;
                }
            } else if (str.equals("SSLv3")) {
                if (length > 1) {
                    length = 1;
                }
                if (i < 1) {
                    i = 1;
                }
            } else if (str.equals("TLSv1")) {
                if (length > 2) {
                    length = 2;
                }
                if (i < 2) {
                    i = 2;
                }
            } else if (str.equals("TLSv1.1")) {
                if (length > 3) {
                    length = 3;
                }
                if (i < 3) {
                    i = 3;
                }
            } else if (str.equals("TLSv1.2")) {
                if (length > 4) {
                    length = 4;
                }
                if (i < 4) {
                    i = 4;
                }
            }
        }
        synchronized (this) {
            if (!isDestroyed()) {
                SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2);
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    i2 |= OPENSSL_OP_NO_PROTOCOLS[i3];
                }
                int i4 = i + 1;
                while (true) {
                    int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                    if (i4 < iArr.length) {
                        i2 |= iArr[i4];
                        i4++;
                    } else {
                        SSL.setOptions(this.ssl, i2);
                    }
                }
            } else {
                throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() throws SSLException {
        int i = AnonymousClass2.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    checkEngineClosed(BEGIN_HANDSHAKE_ENGINE_CLOSED);
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    calculateMaxWrapOverhead();
                } else if (i != 4) {
                    throw new Error();
                }
            }
            if (this.clientMode) {
                throw RENEGOTIATION_UNSUPPORTED;
            }
            int renegotiate = SSL.renegotiate(this.ssl);
            if (renegotiate == 1 && (renegotiate = SSL.doHandshake(this.ssl)) == 1) {
                SSL.setState(this.ssl, SSL.SSL_ST_ACCEPT);
                this.lastAccessed = System.currentTimeMillis();
            }
            int error = SSL.getError(this.ssl, renegotiate);
            if (error != SSL.SSL_ERROR_WANT_READ && error != SSL.SSL_ERROR_WANT_WRITE) {
                throw shutdownWithError("renegotiation failed");
            }
            this.renegotiationPending = true;
            this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
            this.lastAccessed = System.currentTimeMillis();
            return;
        }
        this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
        handshake();
        calculateMaxWrapOverhead();
    }

    private void checkEngineClosed(SSLException sSLException) throws SSLException {
        if (isDestroyed()) {
            throw sSLException;
        }
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        OpenSslKeyMaterialManager openSslKeyMaterialManager;
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed(HANDSHAKE_ENGINE_CLOSED);
        SSLHandshakeException sSLHandshakeException = this.handshakeException;
        if (sSLHandshakeException != null) {
            if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            this.handshakeException = null;
            shutdown();
            throw sSLHandshakeException;
        }
        this.engineMap.add(this);
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        if (!this.certificateSet && (openSslKeyMaterialManager = this.keyMaterialManager) != null) {
            this.certificateSet = true;
            openSslKeyMaterialManager.setKeyMaterial(this);
        }
        int doHandshake = SSL.doHandshake(this.ssl);
        if (doHandshake <= 0) {
            SSLHandshakeException sSLHandshakeException2 = this.handshakeException;
            if (sSLHandshakeException2 != null) {
                this.handshakeException = null;
                shutdown();
                throw sSLHandshakeException2;
            }
            int error = SSL.getError(this.ssl, doHandshake);
            if (error == SSL.SSL_ERROR_WANT_READ || error == SSL.SSL_ERROR_WANT_WRITE) {
                return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
            }
            throw shutdownWithError("SSL_do_handshake");
        }
        this.session.handshakeFinished();
        this.engineMap.remove(this.ssl);
        return SSLEngineResult.HandshakeStatus.FINISHED;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.handshakeState == HandshakeState.FINISHED) ? handshakeStatus : handshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return needPendingStatus() ? pendingStatus(SSL.bioLengthNonApplication(this.networkBIO)) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return needPendingStatus() ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private boolean needPendingStatus() {
        return (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed() || (this.handshakeState == HandshakeState.FINISHED && !isInboundDone() && !isOutboundDone())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char c = 0;
        if (str != null && !str.isEmpty()) {
            c = str.charAt(0);
        }
        return c != 'S' ? c != 'T' ? "UNKNOWN" : IMAPSClient.DEFAULT_PROTOCOL : "SSL";
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z) {
        if (z != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    public final synchronized void setVerify(int i, int i2) {
        SSL.setVerify(this.ssl, i, i2);
    }

    private void setClientAuth(ClientAuth clientAuth) {
        if (this.clientMode) {
            return;
        }
        synchronized (this) {
            if (this.clientAuth == clientAuth) {
                return;
            }
            int i = AnonymousClass2.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
            if (i == 1) {
                SSL.setVerify(this.ssl, 0, 10);
            } else if (i == 2) {
                SSL.setVerify(this.ssl, 2, 10);
            } else if (i == 3) {
                SSL.setVerify(this.ssl, 1, 10);
            } else {
                throw new Error(clientAuth.toString());
            }
            this.clientAuth = clientAuth;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z) {
        if (z) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        sSLParameters = super.getSSLParameters();
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
            Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
            if (javaVersion >= 8) {
                List<String> list = this.sniHostNames;
                if (list != null) {
                    Java8SslUtils.setSniHostNames(sSLParameters, list);
                }
                if (!isDestroyed()) {
                    Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                }
                Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
            }
        }
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            if (sSLParameters.getAlgorithmConstraints() != null) {
                throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
            }
            if (javaVersion >= 8) {
                if (!isDestroyed()) {
                    if (this.clientMode) {
                        List<String> sniHostNames = Java8SslUtils.getSniHostNames(sSLParameters);
                        Iterator<String> it = sniHostNames.iterator();
                        while (it.hasNext()) {
                            SSL.setTlsExtHostName(this.ssl, it.next());
                        }
                        this.sniHostNames = sniHostNames;
                    }
                    if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                        SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                    } else {
                        SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                    }
                }
                this.matchers = sSLParameters.getSNIMatchers();
            }
            String endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
            boolean z = (endpointIdentificationAlgorithm == null || endpointIdentificationAlgorithm.isEmpty()) ? false : true;
            SSL.setHostNameValidation(this.ssl, 0, z ? getPeerHost() : null);
            if (this.clientMode && z) {
                SSL.setVerify(this.ssl, 2, -1);
            }
            this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
            this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
        }
        super.setSSLParameters(sSLParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed != 0;
    }

    final boolean checkSniHostnameMatch(String str) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, str);
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    private final class OpenSslSession implements SSLSession {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        private String cipher;
        private long creationTime;
        private byte[] id;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;

        OpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                byte[] bArr = this.id;
                if (bArr == null) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return (byte[]) bArr.clone();
            }
        }

        @Override // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.creationTime == 0 && !ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.creationTime = SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
                }
            }
            return this.creationTime;
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j == -1 ? getCreationTime() : j;
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    SSL.setTimeout(ReferenceCountedOpenSslEngine.this.ssl, 0L);
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    return false;
                }
                return System.currentTimeMillis() - (SSL.getTimeout(ReferenceCountedOpenSslEngine.this.ssl) * 1000) < SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            Objects.requireNonNull(str, "name");
            Objects.requireNonNull(obj, "value");
            Map map = this.values;
            if (map == null) {
                map = new HashMap(2);
                this.values = map;
            }
            Object put = map.put(str, obj);
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueBound(new SSLSessionBindingEvent(this, str));
            }
            notifyUnbound(put, str);
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            Objects.requireNonNull(str, "name");
            Map<String, Object> map = this.values;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            Objects.requireNonNull(str, "name");
            Map<String, Object> map = this.values;
            if (map == null) {
                return;
            }
            notifyUnbound(map.remove(str), str);
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            Map<String, Object> map = this.values;
            if (map == null || map.isEmpty()) {
                return EmptyArrays.EMPTY_STRINGS;
            }
            return (String[]) map.keySet().toArray(new String[map.size()]);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(new SSLSessionBindingEvent(this, str));
            }
        }

        void handshakeFinished() throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.id = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = ReferenceCountedOpenSslEngine.this;
                    this.cipher = referenceCountedOpenSslEngine.toJavaCipherSuite(SSL.getCipherForSSL(referenceCountedOpenSslEngine.ssl));
                    this.protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                    initPeerCerts();
                    selectApplicationProtocol();
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } else {
                    throw new SSLException("Already closed");
                }
            }
        }

        private void initPeerCerts() {
            byte[][] peerCertChain = SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.ssl);
            if (ReferenceCountedOpenSslEngine.this.clientMode) {
                if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                    this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                    this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    return;
                } else {
                    this.peerCerts = new Certificate[peerCertChain.length];
                    this.x509PeerCerts = new X509Certificate[peerCertChain.length];
                    initCerts(peerCertChain, 0);
                    return;
                }
            }
            byte[] peerCertificate = SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.ssl);
            if (!ReferenceCountedOpenSslEngine.isEmpty(peerCertificate)) {
                if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                    this.peerCerts = new Certificate[]{new OpenSslX509Certificate(peerCertificate)};
                    this.x509PeerCerts = new X509Certificate[]{new OpenSslJavaxX509Certificate(peerCertificate)};
                    return;
                }
                Certificate[] certificateArr = new Certificate[peerCertChain.length + 1];
                this.peerCerts = certificateArr;
                this.x509PeerCerts = new X509Certificate[peerCertChain.length + 1];
                certificateArr[0] = new OpenSslX509Certificate(peerCertificate);
                this.x509PeerCerts[0] = new OpenSslJavaxX509Certificate(peerCertificate);
                initCerts(peerCertChain, 1);
                return;
            }
            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
            this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
        }

        private void initCerts(byte[][] bArr, int i) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i + i2;
                this.peerCerts[i3] = new OpenSslX509Certificate(bArr[i2]);
                this.x509PeerCerts[i3] = new OpenSslJavaxX509Certificate(bArr[i2]);
            }
        }

        private void selectApplicationProtocol() throws SSLException {
            ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.this.apn.selectedListenerFailureBehavior();
            List<String> protocols = ReferenceCountedOpenSslEngine.this.apn.protocols();
            int i = AnonymousClass2.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ReferenceCountedOpenSslEngine.this.apn.protocol().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    String alpnSelected = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
                        return;
                    }
                    return;
                }
                if (i == 3) {
                    String nextProtoNegotiated = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    if (nextProtoNegotiated != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                        return;
                    }
                    return;
                }
                if (i == 4) {
                    String alpnSelected2 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected2 == null) {
                        alpnSelected2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    }
                    if (alpnSelected2 != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected2);
                        return;
                    }
                    return;
                }
                throw new Error();
            }
        }

        private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
                return str;
            }
            int size = list.size();
            if (list.contains(str)) {
                return str;
            }
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                return list.get(size - 1);
            }
            throw new SSLException("unknown protocol " + str);
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
                certificateArr = (Certificate[]) this.peerCerts.clone();
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            if (ReferenceCountedOpenSslEngine.this.localCerts == null) {
                return null;
            }
            return (Certificate[]) ReferenceCountedOpenSslEngine.this.localCerts.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
                x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCerts;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getIssuerX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                String str = this.cipher;
                return str == null ? ReferenceCountedOpenSslEngine.INVALID_CIPHER : str;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String str = this.protocol;
            if (str == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    str = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                }
            }
            return str;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        void tryExpandApplicationBufferSize(int i) {
            if (i <= ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH || this.applicationBufferSize == ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE) {
                return;
            }
            this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
        }
    }

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr2;
            try {
                iArr2[ClientAuth.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.OPTIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[HandshakeState.values().length];
            $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }
}
