package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface DrmSession {
    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED = 0;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher);

    DrmSessionException getError();

    ExoMediaCrypto getMediaCrypto();

    byte[] getOfflineLicenseKeySetId();

    UUID getSchemeUuid();

    int getState();

    default boolean playClearSamplesWithoutKeys() {
        return false;
    }

    Map<String, String> queryKeyStatus();

    void release(DrmSessionEventListener.EventDispatcher eventDispatcher);

    static void replaceSession(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }
}
