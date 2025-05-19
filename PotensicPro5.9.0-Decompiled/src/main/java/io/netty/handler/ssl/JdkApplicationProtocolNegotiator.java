package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;

@Deprecated
/* loaded from: classes4.dex */
public interface JdkApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {

    public interface ProtocolSelectionListener {
        void selected(String str) throws Exception;

        void unsupported();
    }

    public interface ProtocolSelectionListenerFactory {
        ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list);
    }

    public interface ProtocolSelector {
        String select(List<String> list) throws Exception;

        void unsupported();
    }

    public interface ProtocolSelectorFactory {
        ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set);
    }

    public interface SslEngineWrapperFactory {
        SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z);
    }

    ProtocolSelectionListenerFactory protocolListenerFactory();

    ProtocolSelectorFactory protocolSelectorFactory();

    SslEngineWrapperFactory wrapperFactory();

    public static abstract class AllocatorAwareSslEngineWrapperFactory implements SslEngineWrapperFactory {
        abstract SSLEngine wrapSslEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z);

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.SslEngineWrapperFactory
        public final SSLEngine wrapSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
            return wrapSslEngine(sSLEngine, ByteBufAllocator.DEFAULT, jdkApplicationProtocolNegotiator, z);
        }
    }
}
