package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends Exception implements Bundleable {
    public static final Bundleable.Creator<ExoPlaybackException> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlaybackException$KFOeU7ntqCoPsM8H3_a4aK4-9bw
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            ExoPlaybackException fromBundle;
            fromBundle = ExoPlaybackException.fromBundle(bundle);
            return fromBundle;
        }
    };
    private static final int FIELD_CAUSE_CLASS_NAME = 8;
    private static final int FIELD_CAUSE_MESSAGE = 9;
    private static final int FIELD_IS_RECOVERABLE = 7;
    private static final int FIELD_MESSAGE = 0;
    private static final int FIELD_RENDERER_FORMAT = 4;
    private static final int FIELD_RENDERER_FORMAT_SUPPORT = 5;
    private static final int FIELD_RENDERER_INDEX = 3;
    private static final int FIELD_RENDERER_NAME = 2;
    private static final int FIELD_TIME_STAMP_MS = 6;
    private static final int FIELD_TYPE = 1;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    final boolean isRecoverable;
    public final MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, iOException);
    }

    public static ExoPlaybackException createForRenderer(Exception exc) {
        return new ExoPlaybackException(1, exc, null, null, -1, null, 4, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th, String str, int i, Format format, int i2) {
        return createForRenderer(th, str, i, format, i2, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable th, String str, int i, Format format, int i2, boolean z) {
        if (format == null) {
            i2 = 4;
        }
        return new ExoPlaybackException(1, th, null, str, i, format, i2, z);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, runtimeException);
    }

    public static ExoPlaybackException createForRemote(String str) {
        return new ExoPlaybackException(3, str);
    }

    private ExoPlaybackException(int i, Throwable th) {
        this(i, th, null, null, -1, null, 4, false);
    }

    private ExoPlaybackException(int i, String str) {
        this(i, null, str, null, -1, null, 4, false);
    }

    private ExoPlaybackException(int i, Throwable th, String str, String str2, int i2, Format format, int i3, boolean z) {
        this(deriveMessage(i, str, str2, i2, format, i3), th, i, str2, i2, format, i3, null, SystemClock.elapsedRealtime(), z);
    }

    private ExoPlaybackException(String str, Throwable th, int i, String str2, int i2, Format format, int i3, MediaPeriodId mediaPeriodId, long j, boolean z) {
        super(str, th);
        boolean z2 = true;
        if (z && i != 1) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        this.type = i;
        this.cause = th;
        this.rendererName = str2;
        this.rendererIndex = i2;
        this.rendererFormat = format;
        this.rendererFormatSupport = i3;
        this.mediaPeriodId = mediaPeriodId;
        this.timestampMs = j;
        this.isRecoverable = z;
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException) Assertions.checkNotNull(this.cause);
    }

    public Exception getRendererException() {
        Assertions.checkState(this.type == 1);
        return (Exception) Assertions.checkNotNull(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException) Assertions.checkNotNull(this.cause);
    }

    ExoPlaybackException copyWithMediaPeriodId(MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.castNonNull(getMessage()), this.cause, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, this.timestampMs, this.isRecoverable);
    }

    private static String deriveMessage(int i, String str, String str2, int i2, Format format, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            String valueOf = String.valueOf(format);
            String formatSupportString = C.getFormatSupportString(i3);
            str3 = new StringBuilder(String.valueOf(str2).length() + 53 + String.valueOf(valueOf).length() + String.valueOf(formatSupportString).length()).append(str2).append(" error, index=").append(i2).append(", format=").append(valueOf).append(", format_supported=").append(formatSupportString).toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String valueOf2 = String.valueOf(str3);
        return new StringBuilder(String.valueOf(valueOf2).length() + 2 + String.valueOf(str).length()).append(valueOf2).append(": ").append(str).toString();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), getMessage());
        bundle.putInt(keyForField(1), this.type);
        bundle.putString(keyForField(2), this.rendererName);
        bundle.putInt(keyForField(3), this.rendererIndex);
        bundle.putParcelable(keyForField(4), this.rendererFormat);
        bundle.putInt(keyForField(5), this.rendererFormatSupport);
        bundle.putLong(keyForField(6), this.timestampMs);
        bundle.putBoolean(keyForField(7), this.isRecoverable);
        if (this.cause != null) {
            bundle.putString(keyForField(8), this.cause.getClass().getName());
            bundle.putString(keyForField(9), this.cause.getMessage());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExoPlaybackException fromBundle(Bundle bundle) {
        int i = bundle.getInt(keyForField(1), 2);
        String string = bundle.getString(keyForField(2));
        int i2 = bundle.getInt(keyForField(3), -1);
        Format format = (Format) bundle.getParcelable(keyForField(4));
        int i3 = bundle.getInt(keyForField(5), 4);
        long j = bundle.getLong(keyForField(6), SystemClock.elapsedRealtime());
        boolean z = bundle.getBoolean(keyForField(7), false);
        String string2 = bundle.getString(keyForField(0));
        if (string2 == null) {
            string2 = deriveMessage(i, null, string, i2, format, i3);
        }
        String str = string2;
        String string3 = bundle.getString(keyForField(8));
        String string4 = bundle.getString(keyForField(9));
        Throwable th = null;
        if (!TextUtils.isEmpty(string3)) {
            try {
                Class<?> cls = Class.forName(string3, true, ExoPlaybackException.class.getClassLoader());
                if (Throwable.class.isAssignableFrom(cls)) {
                    th = createThrowable(cls, string4);
                }
            } catch (Throwable unused) {
                th = createRemoteException(string4);
            }
        }
        return new ExoPlaybackException(str, th, i, string, i2, format, i3, null, j, z);
    }

    private static Throwable createThrowable(Class<?> cls, String str) throws Exception {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    private static RemoteException createRemoteException(String str) {
        return new RemoteException(str);
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
