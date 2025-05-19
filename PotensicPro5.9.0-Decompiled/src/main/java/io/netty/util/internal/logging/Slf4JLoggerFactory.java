package io.netty.util.internal.logging;

import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* loaded from: classes4.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    Slf4JLoggerFactory(boolean z) {
        if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return new Slf4JLogger(LoggerFactory.getLogger(str));
    }
}
