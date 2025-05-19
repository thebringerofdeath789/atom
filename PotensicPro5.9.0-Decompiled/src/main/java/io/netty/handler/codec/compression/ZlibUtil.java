package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
final class ZlibUtil {
    static void fail(Inflater inflater, String str, int i) {
        throw inflaterException(inflater, str, i);
    }

    static void fail(Deflater deflater, String str, int i) {
        throw deflaterException(deflater, str, i);
    }

    static DecompressionException inflaterException(Inflater inflater, String str, int i) {
        return new DecompressionException(str + " (" + i + PropertyUtils.MAPPED_DELIM2 + (inflater.msg != null ? ": " + inflater.msg : ""));
    }

    static CompressionException deflaterException(Deflater deflater, String str, int i) {
        return new CompressionException(str + " (" + i + PropertyUtils.MAPPED_DELIM2 + (deflater.msg != null ? ": " + deflater.msg : ""));
    }

    /* renamed from: io.netty.handler.codec.compression.ZlibUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.GZIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static JZlib.WrapperType convertWrapperType(ZlibWrapper zlibWrapper) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i == 1) {
            return JZlib.W_NONE;
        }
        if (i == 2) {
            return JZlib.W_ZLIB;
        }
        if (i == 3) {
            return JZlib.W_GZIP;
        }
        if (i == 4) {
            return JZlib.W_ANY;
        }
        throw new Error();
    }

    static int wrapperOverhead(ZlibWrapper zlibWrapper) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 10;
        }
        if (i == 4) {
            return 2;
        }
        throw new Error();
    }

    private ZlibUtil() {
    }
}
