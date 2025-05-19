package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    public static final long DEFAULT_CHECK_INTERVAL = 1000;
    static final long DEFAULT_MAX_SIZE = 4194304;
    public static final long DEFAULT_MAX_TIME = 15000;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final long MINIMAL_WAIT = 10;
    protected volatile long checkInterval;
    protected volatile long maxTime;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    private volatile long readLimit;
    protected TrafficCounter trafficCounter;
    final int userDefinedWritabilityIndex;
    private volatile long writeLimit;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractTrafficShapingHandler.class);
    static final AttributeKey<Boolean> READ_SUSPENDED = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".READ_SUSPENDED");
    static final AttributeKey<Runnable> REOPEN_TASK = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".REOPEN_TASK");

    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        return j;
    }

    protected void doAccounting(TrafficCounter trafficCounter) {
    }

    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j) {
    }

    abstract void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise);

    protected int userDefinedWritabilityIndex() {
        return 1;
    }

    void setTrafficCounter(TrafficCounter trafficCounter) {
        this.trafficCounter = trafficCounter;
    }

    protected AbstractTrafficShapingHandler(long j, long j2, long j3, long j4) {
        this.maxTime = DEFAULT_MAX_TIME;
        this.checkInterval = 1000L;
        this.maxWriteDelay = 4000L;
        this.maxWriteSize = DEFAULT_MAX_SIZE;
        if (j4 <= 0) {
            throw new IllegalArgumentException("maxTime must be positive");
        }
        this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
        this.writeLimit = j;
        this.readLimit = j2;
        this.checkInterval = j3;
        this.maxTime = j4;
    }

    protected AbstractTrafficShapingHandler(long j, long j2, long j3) {
        this(j, j2, j3, DEFAULT_MAX_TIME);
    }

    protected AbstractTrafficShapingHandler(long j, long j2) {
        this(j, j2, 1000L, DEFAULT_MAX_TIME);
    }

    protected AbstractTrafficShapingHandler() {
        this(0L, 0L, 1000L, DEFAULT_MAX_TIME);
    }

    protected AbstractTrafficShapingHandler(long j) {
        this(0L, 0L, j, DEFAULT_MAX_TIME);
    }

    public void configure(long j, long j2, long j3) {
        configure(j, j2);
        configure(j3);
    }

    public void configure(long j, long j2) {
        this.writeLimit = j;
        this.readLimit = j2;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public void configure(long j) {
        this.checkInterval = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(this.checkInterval);
        }
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    public void setWriteLimit(long j) {
        this.writeLimit = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public void setReadLimit(long j) {
        this.readLimit = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public void setCheckInterval(long j) {
        this.checkInterval = j;
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            trafficCounter.configure(j);
        }
    }

    public void setMaxTimeWait(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxTime must be positive");
        }
        this.maxTime = j;
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public void setMaxWriteDelay(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxWriteDelay must be positive");
        }
        this.maxWriteDelay = j;
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public void setMaxWriteSize(long j) {
        this.maxWriteSize = j;
    }

    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        ReopenReadTimerTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelConfig config = this.ctx.channel().config();
            if (config.isAutoRead() || !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if (config.isAutoRead() && !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        AbstractTrafficShapingHandler.logger.debug("Unsuspend: " + config.isAutoRead() + NameUtil.COLON + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    } else {
                        AbstractTrafficShapingHandler.logger.debug("Normal unsuspend: " + config.isAutoRead() + NameUtil.COLON + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                this.ctx.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(false);
                config.setAutoRead(true);
                this.ctx.channel().read();
            } else {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    AbstractTrafficShapingHandler.logger.debug("Not unsuspend: " + config.isAutoRead() + NameUtil.COLON + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                this.ctx.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(false);
            }
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                AbstractTrafficShapingHandler.logger.debug("Unsuspend final status => " + config.isAutoRead() + NameUtil.COLON + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }
    }

    void releaseReadSuspended(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.attr(READ_SUSPENDED).set(false);
        channelHandlerContext.channel().config().setAutoRead(true);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext, this.trafficCounter.readTimeToWait(calculateSize, this.readLimit, this.maxTime, milliSecondFromNano), milliSecondFromNano);
            if (checkWaitReadTime >= MINIMAL_WAIT) {
                ChannelConfig config = channelHandlerContext.channel().config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read suspend: " + checkWaitReadTime + NameUtil.COLON + config.isAutoRead() + NameUtil.COLON + isHandlerActive(channelHandlerContext));
                }
                if (config.isAutoRead() && isHandlerActive(channelHandlerContext)) {
                    config.setAutoRead(false);
                    channelHandlerContext.attr(READ_SUSPENDED).set(true);
                    Attribute attr = channelHandlerContext.attr(REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new ReopenReadTimerTask(channelHandlerContext);
                        attr.set(runnable);
                    }
                    channelHandlerContext.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + NameUtil.COLON + isHandlerActive(channelHandlerContext) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        }
        informReadOperation(channelHandlerContext, milliSecondFromNano);
        channelHandlerContext.fireChannelRead(obj);
    }

    protected static boolean isHandlerActive(ChannelHandlerContext channelHandlerContext) {
        Boolean bool = (Boolean) channelHandlerContext.attr(READ_SUSPENDED).get();
        return bool == null || Boolean.FALSE.equals(bool);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        if (isHandlerActive(channelHandlerContext)) {
            channelHandlerContext.read();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, this.writeLimit, this.maxTime, milliSecondFromNano);
            if (writeTimeToWait >= MINIMAL_WAIT) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + NameUtil.COLON + channelHandlerContext.channel().config().isAutoRead() + NameUtil.COLON + isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, milliSecondFromNano, channelPromise);
                return;
            }
        }
        submitWrite(channelHandlerContext, obj, calculateSize, 0L, milliSecondFromNano, channelPromise);
    }

    @Deprecated
    protected void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, ChannelPromise channelPromise) {
        submitWrite(channelHandlerContext, obj, calculateSize(obj), j, TrafficCounter.milliSecondFromNano(), channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        setUserDefinedWritability(channelHandlerContext, true);
        super.channelRegistered(channelHandlerContext);
    }

    void setUserDefinedWritability(ChannelHandlerContext channelHandlerContext, boolean z) {
        ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        if (outboundBuffer != null) {
            outboundBuffer.setUserDefinedWritability(this.userDefinedWritabilityIndex, z);
        }
    }

    void checkWriteSuspend(ChannelHandlerContext channelHandlerContext, long j, long j2) {
        if (j2 > this.maxWriteSize || j > this.maxWriteDelay) {
            setUserDefinedWritability(channelHandlerContext, false);
        }
    }

    void releaseWriteSuspended(ChannelHandlerContext channelHandlerContext) {
        setUserDefinedWritability(channelHandlerContext, true);
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(290).append("TrafficShaping with Write Limit: ").append(this.writeLimit).append(" Read Limit: ").append(this.readLimit).append(" CheckInterval: ").append(this.checkInterval).append(" maxDelay: ").append(this.maxWriteDelay).append(" maxSize: ").append(this.maxWriteSize).append(" and Counter: ");
        TrafficCounter trafficCounter = this.trafficCounter;
        if (trafficCounter != null) {
            append.append(trafficCounter);
        } else {
            append.append("none");
        }
        return append.toString();
    }

    protected long calculateSize(Object obj) {
        int readableBytes;
        if (obj instanceof ByteBuf) {
            readableBytes = ((ByteBuf) obj).readableBytes();
        } else {
            if (!(obj instanceof ByteBufHolder)) {
                return -1L;
            }
            readableBytes = ((ByteBufHolder) obj).content().readableBytes();
        }
        return readableBytes;
    }
}
