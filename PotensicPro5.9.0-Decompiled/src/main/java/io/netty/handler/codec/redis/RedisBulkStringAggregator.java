package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

/* loaded from: classes3.dex */
public final class RedisBulkStringAggregator extends MessageAggregator<RedisMessage, BulkStringHeaderRedisMessage, BulkStringRedisContent, FullBulkStringRedisMessage> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, int i, ChannelPipeline channelPipeline) throws Exception {
        return null;
    }

    public RedisBulkStringAggregator() {
        super(536870912);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(RedisMessage redisMessage) throws Exception {
        return (redisMessage instanceof BulkStringHeaderRedisMessage) && !isAggregated(redisMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(RedisMessage redisMessage) throws Exception {
        return redisMessage instanceof BulkStringRedisContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(BulkStringRedisContent bulkStringRedisContent) throws Exception {
        return bulkStringRedisContent instanceof LastBulkStringRedisContent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(RedisMessage redisMessage) throws Exception {
        return redisMessage instanceof FullBulkStringRedisMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, int i) throws Exception {
        return bulkStringHeaderRedisMessage.bulkStringLength() > i;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public FullBulkStringRedisMessage beginAggregation(BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, ByteBuf byteBuf) throws Exception {
        return new FullBulkStringRedisMessage(byteBuf);
    }
}
