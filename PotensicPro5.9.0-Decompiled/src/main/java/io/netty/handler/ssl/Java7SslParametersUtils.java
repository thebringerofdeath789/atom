package io.netty.handler.ssl;

import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

/* loaded from: classes4.dex */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints((AlgorithmConstraints) obj);
    }
}
