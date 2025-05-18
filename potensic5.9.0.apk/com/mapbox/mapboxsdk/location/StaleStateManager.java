package com.mapbox.mapboxsdk.location;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
class StaleStateManager {
    private long delayTime;
    private final OnLocationStaleListener innerOnLocationStaleListeners;
    private boolean isEnabled;
    private boolean isStale = true;
    private final int staleStateMessage = 1;
    private final StaleMessageHandler handler = new StaleMessageHandler();

    StaleStateManager(OnLocationStaleListener onLocationStaleListener, LocationComponentOptions locationComponentOptions) {
        this.innerOnLocationStaleListeners = onLocationStaleListener;
        this.isEnabled = locationComponentOptions.enableStaleState();
        this.delayTime = locationComponentOptions.staleStateTimeout();
    }

    void setEnabled(boolean z) {
        if (z) {
            setState(this.isStale);
        } else if (this.isEnabled) {
            onStop();
            this.innerOnLocationStaleListeners.onStaleStateChange(false);
        }
        this.isEnabled = z;
    }

    boolean isStale() {
        return this.isStale;
    }

    void updateLatestLocationTime() {
        setState(false);
        postTheCallback();
    }

    void setDelayTime(long j) {
        this.delayTime = j;
        if (this.handler.hasMessages(1)) {
            postTheCallback();
        }
    }

    void onStart() {
        if (this.isStale) {
            return;
        }
        postTheCallback();
    }

    void onStop() {
        this.handler.removeCallbacksAndMessages(null);
    }

    private void postTheCallback() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.sendEmptyMessageDelayed(1, this.delayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(boolean z) {
        if (z != this.isStale) {
            this.isStale = z;
            if (this.isEnabled) {
                this.innerOnLocationStaleListeners.onStaleStateChange(z);
            }
        }
    }

    private static class StaleMessageHandler extends Handler {
        private final WeakReference<StaleStateManager> managerWeakReference;

        private StaleMessageHandler(StaleStateManager staleStateManager) {
            this.managerWeakReference = new WeakReference<>(staleStateManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            StaleStateManager staleStateManager = this.managerWeakReference.get();
            if (staleStateManager != null) {
                staleStateManager.setState(true);
            }
        }
    }
}