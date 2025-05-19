package io.netty.handler.codec.http2;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public abstract class AbstractHttp2ConnectionHandlerBuilder<T extends Http2ConnectionHandler, B extends AbstractHttp2ConnectionHandlerBuilder<T, B>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2HeadersEncoder.SensitivityDetector DEFAULT_HEADER_SENSITIVITY_DETECTOR = Http2HeadersEncoder.NEVER_SENSITIVE;
    private Http2Connection connection;
    private Http2ConnectionDecoder decoder;
    private Http2ConnectionEncoder encoder;
    private Boolean encoderEnforceMaxConcurrentStreams;
    private Boolean encoderIgnoreMaxHeaderListSize;
    private Http2FrameListener frameListener;
    private Http2FrameLogger frameLogger;
    private Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector;
    private Boolean isServer;
    private Integer maxReservedStreams;
    private Boolean validateHeaders;
    private Http2Settings initialSettings = Http2Settings.defaultSettings();
    private long gracefulShutdownTimeoutMillis = Http2CodecUtil.DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS;
    private int initialHuffmanDecodeCapacity = 32;

    protected abstract T build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) throws Exception;

    protected final B self() {
        return this;
    }

    protected Http2Settings initialSettings() {
        return this.initialSettings;
    }

    protected B initialSettings(Http2Settings http2Settings) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "settings");
        return self();
    }

    protected Http2FrameListener frameListener() {
        return this.frameListener;
    }

    protected B frameListener(Http2FrameListener http2FrameListener) {
        this.frameListener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "frameListener");
        return self();
    }

    protected long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    protected B gracefulShutdownTimeoutMillis(long j) {
        if (j < -1) {
            throw new IllegalArgumentException("gracefulShutdownTimeoutMillis: " + j + " (expected: -1 for indefinite or >= 0)");
        }
        this.gracefulShutdownTimeoutMillis = j;
        return self();
    }

    protected boolean isServer() {
        Boolean bool = this.isServer;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    protected B server(boolean z) {
        enforceConstraint("server", RtspHeaders.CONNECTION, this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.isServer = Boolean.valueOf(z);
        return self();
    }

    protected int maxReservedStreams() {
        Integer num = this.maxReservedStreams;
        if (num != null) {
            return num.intValue();
        }
        return 100;
    }

    protected B maxReservedStreams(int i) {
        enforceConstraint("server", RtspHeaders.CONNECTION, this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.maxReservedStreams = Integer.valueOf(ObjectUtil.checkPositiveOrZero(i, "maxReservedStreams"));
        return self();
    }

    protected Http2Connection connection() {
        return this.connection;
    }

    protected B connection(Http2Connection http2Connection) {
        enforceConstraint(RtspHeaders.CONNECTION, "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint(RtspHeaders.CONNECTION, "server", this.isServer);
        enforceConstraint(RtspHeaders.CONNECTION, "codec", this.decoder);
        enforceConstraint(RtspHeaders.CONNECTION, "codec", this.encoder);
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, RtspHeaders.CONNECTION);
        return self();
    }

    protected Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    protected Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    protected B codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        enforceConstraint("codec", "server", this.isServer);
        enforceConstraint("codec", "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint("codec", RtspHeaders.CONNECTION, this.connection);
        enforceConstraint("codec", "frameLogger", this.frameLogger);
        enforceConstraint("codec", "validateHeaders", this.validateHeaders);
        enforceConstraint("codec", "headerSensitivityDetector", this.headerSensitivityDetector);
        enforceConstraint("codec", "encoderEnforceMaxConcurrentStreams", this.encoderEnforceMaxConcurrentStreams);
        ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        if (http2ConnectionDecoder.connection() != http2ConnectionEncoder.connection()) {
            throw new IllegalArgumentException("The specified encoder and decoder have different connections.");
        }
        this.decoder = http2ConnectionDecoder;
        this.encoder = http2ConnectionEncoder;
        return self();
    }

    protected boolean isValidateHeaders() {
        Boolean bool = this.validateHeaders;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    protected B validateHeaders(boolean z) {
        enforceNonCodecConstraints("validateHeaders");
        this.validateHeaders = Boolean.valueOf(z);
        return self();
    }

    protected Http2FrameLogger frameLogger() {
        return this.frameLogger;
    }

    protected B frameLogger(Http2FrameLogger http2FrameLogger) {
        enforceNonCodecConstraints("frameLogger");
        this.frameLogger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, "frameLogger");
        return self();
    }

    protected boolean encoderEnforceMaxConcurrentStreams() {
        Boolean bool = this.encoderEnforceMaxConcurrentStreams;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    protected B encoderEnforceMaxConcurrentStreams(boolean z) {
        enforceNonCodecConstraints("encoderEnforceMaxConcurrentStreams");
        this.encoderEnforceMaxConcurrentStreams = Boolean.valueOf(z);
        return self();
    }

    protected Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        Http2HeadersEncoder.SensitivityDetector sensitivityDetector = this.headerSensitivityDetector;
        return sensitivityDetector != null ? sensitivityDetector : DEFAULT_HEADER_SENSITIVITY_DETECTOR;
    }

    protected B headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        enforceNonCodecConstraints("headerSensitivityDetector");
        this.headerSensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "headerSensitivityDetector");
        return self();
    }

    protected B encoderIgnoreMaxHeaderListSize(boolean z) {
        enforceNonCodecConstraints("encoderIgnoreMaxHeaderListSize");
        this.encoderIgnoreMaxHeaderListSize = Boolean.valueOf(z);
        return self();
    }

    protected B initialHuffmanDecodeCapacity(int i) {
        enforceNonCodecConstraints("initialHuffmanDecodeCapacity");
        this.initialHuffmanDecodeCapacity = ObjectUtil.checkPositive(i, "initialHuffmanDecodeCapacity");
        return self();
    }

    protected T build() {
        Http2ConnectionEncoder http2ConnectionEncoder = this.encoder;
        if (http2ConnectionEncoder != null) {
            return buildFromCodec(this.decoder, http2ConnectionEncoder);
        }
        Http2Connection http2Connection = this.connection;
        if (http2Connection == null) {
            http2Connection = new DefaultHttp2Connection(isServer(), maxReservedStreams());
        }
        return buildFromConnection(http2Connection);
    }

    private T buildFromConnection(Http2Connection http2Connection) {
        Http2FrameWriter defaultHttp2FrameWriter;
        Long maxHeaderListSize = this.initialSettings.maxHeaderListSize();
        Http2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(new DefaultHttp2HeadersDecoder(isValidateHeaders(), maxHeaderListSize == null ? 8192L : maxHeaderListSize.longValue(), this.initialHuffmanDecodeCapacity));
        if (this.encoderIgnoreMaxHeaderListSize == null) {
            defaultHttp2FrameWriter = new DefaultHttp2FrameWriter(headerSensitivityDetector());
        } else {
            defaultHttp2FrameWriter = new DefaultHttp2FrameWriter(headerSensitivityDetector(), this.encoderIgnoreMaxHeaderListSize.booleanValue());
        }
        if (this.frameLogger != null) {
            Http2FrameReader http2InboundFrameLogger = new Http2InboundFrameLogger(defaultHttp2FrameReader, this.frameLogger);
            defaultHttp2FrameWriter = new Http2OutboundFrameLogger(defaultHttp2FrameWriter, this.frameLogger);
            defaultHttp2FrameReader = http2InboundFrameLogger;
        }
        Http2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(http2Connection, defaultHttp2FrameWriter);
        boolean encoderEnforceMaxConcurrentStreams = encoderEnforceMaxConcurrentStreams();
        if (encoderEnforceMaxConcurrentStreams) {
            if (http2Connection.isServer()) {
                defaultHttp2ConnectionEncoder.close();
                defaultHttp2FrameReader.close();
                throw new IllegalArgumentException("encoderEnforceMaxConcurrentStreams: " + encoderEnforceMaxConcurrentStreams + " not supported for server");
            }
            defaultHttp2ConnectionEncoder = new StreamBufferingEncoder(defaultHttp2ConnectionEncoder);
        }
        return buildFromCodec(new DefaultHttp2ConnectionDecoder(http2Connection, defaultHttp2ConnectionEncoder, defaultHttp2FrameReader), defaultHttp2ConnectionEncoder);
    }

    private T buildFromCodec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        try {
            T build = build(http2ConnectionDecoder, http2ConnectionEncoder, this.initialSettings);
            build.gracefulShutdownTimeoutMillis(this.gracefulShutdownTimeoutMillis);
            if (build.decoder().frameListener() == null) {
                build.decoder().frameListener(this.frameListener);
            }
            return build;
        } catch (Throwable th) {
            http2ConnectionEncoder.close();
            http2ConnectionDecoder.close();
            throw new IllegalStateException("failed to build a Http2ConnectionHandler", th);
        }
    }

    private void enforceNonCodecConstraints(String str) {
        enforceConstraint(str, "server/connection", this.decoder);
        enforceConstraint(str, "server/connection", this.encoder);
    }

    private static void enforceConstraint(String str, String str2, Object obj) {
        if (obj != null) {
            throw new IllegalStateException(str + "() cannot be called because " + str2 + "() has been called already.");
        }
    }
}
