package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z) {
        this(cls, z, 5);
    }

    public DefaultThreadFactory(String str, boolean z) {
        this(str, z, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i) {
        this(cls, false, i);
    }

    public DefaultThreadFactory(String str, int i) {
        this(str, false, i);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z, int i) {
        this(toPoolName(cls), z, i);
    }

    public static String toPoolName(Class<?> cls) {
        Objects.requireNonNull(cls, "poolType");
        String simpleClassName = StringUtil.simpleClassName(cls);
        int length = simpleClassName.length();
        if (length == 0) {
            return "unknown";
        }
        if (length != 1) {
            return (Character.isUpperCase(simpleClassName.charAt(0)) && Character.isLowerCase(simpleClassName.charAt(1))) ? Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1) : simpleClassName;
        }
        return simpleClassName.toLowerCase(Locale.US);
    }

    public DefaultThreadFactory(String str, boolean z, int i, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        Objects.requireNonNull(str, "poolName");
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("priority: " + i + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.prefix = str + NameUtil.HYPHEN + poolId.incrementAndGet() + NameUtil.HYPHEN;
        this.daemon = z;
        this.priority = i;
        this.threadGroup = threadGroup;
    }

    public DefaultThreadFactory(String str, boolean z, int i) {
        this(str, z, i, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = newThread(FastThreadLocalRunnable.wrap(runnable), this.prefix + this.nextId.incrementAndGet());
        try {
            boolean isDaemon = newThread.isDaemon();
            boolean z = this.daemon;
            if (isDaemon != z) {
                newThread.setDaemon(z);
            }
            int priority = newThread.getPriority();
            int i = this.priority;
            if (priority != i) {
                newThread.setPriority(i);
            }
        } catch (Exception unused) {
        }
        return newThread;
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }
}
