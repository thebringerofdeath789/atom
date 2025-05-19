package io.netty.channel;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes3.dex */
public final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelId.class);
    private static final AtomicInteger nextSequence = new AtomicInteger();
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data;
    private final int hashCode;
    private transient String longValue;
    private transient String shortValue;

    static {
        int i;
        String str = SystemPropertyUtil.get("io.netty.processId");
        int i2 = -1;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i < 0) {
                logger.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i));
                }
                i2 = i;
            }
        }
        if (i2 < 0) {
            i2 = defaultProcessId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(i2));
            }
        }
        PROCESS_ID = i2;
        byte[] bArr = null;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        if (str2 != null) {
            try {
                bArr = MacAddressUtil.parseMAC(str2);
            } catch (Exception e) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2, e);
            }
            if (bArr != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            }
        }
        if (bArr == null) {
            bArr = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger3 = logger;
            if (internalLogger3.isDebugEnabled()) {
                internalLogger3.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(bArr));
            }
        }
        MACHINE_ID = bArr;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:2|3)|(2:4|5)|6|(1:8)|9|10|(2:12|13)(1:15)) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int defaultProcessId() {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<io.netty.channel.DefaultChannelId> r2 = io.netty.channel.DefaultChannelId.class
            java.lang.ClassLoader r2 = io.netty.util.internal.PlatformDependent.getClassLoader(r2)     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "java.lang.management.ManagementFactory"
            java.lang.Class r3 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r4 = "java.lang.management.RuntimeMXBean"
            java.lang.Class r4 = java.lang.Class.forName(r4, r0, r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = "getRuntimeMXBean"
            java.lang.Class<?>[] r6 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L33
            java.lang.reflect.Method r3 = r3.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L33
            java.lang.Object[] r5 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r3.invoke(r1, r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = "getName"
            java.lang.Class<?>[] r6 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L33
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L33
            java.lang.Object[] r5 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L33
            goto L61
        L33:
            r3 = move-exception
            goto L37
        L35:
            r3 = move-exception
            r2 = r1
        L37:
            io.netty.util.internal.logging.InternalLogger r4 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r5 = "Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?"
            r4.debug(r5, r3)
            java.lang.String r3 = "android.os.Process"
            java.lang.Class r0 = java.lang.Class.forName(r3, r0, r2)     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "myPid"
            java.lang.Class<?>[] r3 = io.netty.util.internal.EmptyArrays.EMPTY_CLASSES     // Catch: java.lang.Throwable -> L57
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Throwable -> L57
            java.lang.Object[] r2 = io.netty.util.internal.EmptyArrays.EMPTY_OBJECTS     // Catch: java.lang.Throwable -> L57
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L57
            goto L61
        L57:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.String r2 = "Could not invoke Process.myPid(); not Android?"
            r1.debug(r2, r0)
            java.lang.String r3 = ""
        L61:
            r0 = 64
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L6e
            r1 = 0
            java.lang.String r3 = r3.substring(r1, r0)
        L6e:
            int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L73
            goto L74
        L73:
            r0 = -1
        L74:
            if (r0 >= 0) goto L89
            java.util.Random r0 = io.netty.util.internal.PlatformDependent.threadLocalRandom()
            int r0 = r0.nextInt()
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.DefaultChannelId.logger
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Failed to find the current process ID from '{}'; using a random value: {}"
            r1.warn(r4, r3, r2)
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.DefaultChannelId.defaultProcessId():int");
    }

    private DefaultChannelId() {
        byte[] bArr = MACHINE_ID;
        byte[] bArr2 = new byte[bArr.length + 4 + 4 + 8 + 4];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        writeInt(writeLong(writeInt(writeInt(bArr.length + 0, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(bArr2);
    }

    private int writeInt(int i, int i2) {
        byte[] bArr = this.data;
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        return i6;
    }

    private int writeLong(int i, long j) {
        byte[] bArr = this.data;
        int i2 = i + 1;
        bArr[i] = (byte) (j >>> 56);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >>> 48);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >>> 40);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >>> 32);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >>> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >>> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j >>> 8);
        int i9 = i8 + 1;
        bArr[i8] = (byte) j;
        return i9;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.data;
        String hexDump = ByteBufUtil.hexDump(bArr, bArr.length - 4, 4);
        this.shortValue = hexDump;
        return hexDump;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str != null) {
            return str;
        }
        String newLongValue = newLongValue();
        this.longValue = newLongValue;
        return newLongValue;
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, MACHINE_ID.length), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    private int appendHexDumpField(StringBuilder sb, int i, int i2) {
        sb.append(ByteBufUtil.hexDump(this.data, i, i2));
        sb.append(NameUtil.HYPHEN);
        return i + i2;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (this == channelId) {
            return 0;
        }
        if (channelId instanceof DefaultChannelId) {
            byte[] bArr = ((DefaultChannelId) channelId).data;
            int length = this.data.length;
            int length2 = bArr.length;
            int min = Math.min(length, length2);
            for (int i = 0; i < min; i++) {
                byte b = this.data[i];
                byte b2 = bArr[i];
                if (b != b2) {
                    return (b & 255) - (b2 & 255);
                }
            }
            return length - length2;
        }
        return asLongText().compareTo(channelId.asLongText());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId defaultChannelId = (DefaultChannelId) obj;
        return this.hashCode == defaultChannelId.hashCode && Arrays.equals(this.data, defaultChannelId.data);
    }

    public String toString() {
        return asShortText();
    }
}
