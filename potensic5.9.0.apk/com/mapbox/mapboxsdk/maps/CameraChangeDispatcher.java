package com.mapbox.mapboxsdk.maps;

import android.os.Handler;
import android.os.Message;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
class CameraChangeDispatcher implements MapboxMap.OnCameraMoveStartedListener, MapboxMap.OnCameraMoveListener, MapboxMap.OnCameraMoveCanceledListener, MapboxMap.OnCameraIdleListener {
    private static final int IDLE = 3;
    private static final int MOVE = 1;
    private static final int MOVE_CANCELED = 2;
    private static final int MOVE_STARTED = 0;
    private int moveStartedReason;
    private final CameraChangeHandler handler = new CameraChangeHandler(this);
    private boolean idle = true;
    private final CopyOnWriteArrayList<MapboxMap.OnCameraMoveStartedListener> onCameraMoveStarted = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnCameraMoveCanceledListener> onCameraMoveCanceled = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnCameraMoveListener> onCameraMove = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnCameraIdleListener> onCameraIdle = new CopyOnWriteArrayList<>();

    CameraChangeDispatcher() {
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int i) {
        this.moveStartedReason = i;
        this.handler.scheduleMessage(0);
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCameraMoveListener
    public void onCameraMove() {
        this.handler.scheduleMessage(1);
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCameraMoveCanceledListener
    public void onCameraMoveCanceled() {
        this.handler.scheduleMessage(2);
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCameraIdleListener
    public void onCameraIdle() {
        this.handler.scheduleMessage(3);
    }

    void addOnCameraIdleListener(MapboxMap.OnCameraIdleListener onCameraIdleListener) {
        this.onCameraIdle.add(onCameraIdleListener);
    }

    void removeOnCameraIdleListener(MapboxMap.OnCameraIdleListener onCameraIdleListener) {
        if (this.onCameraIdle.contains(onCameraIdleListener)) {
            this.onCameraIdle.remove(onCameraIdleListener);
        }
    }

    void addOnCameraMoveCancelListener(MapboxMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.onCameraMoveCanceled.add(onCameraMoveCanceledListener);
    }

    void removeOnCameraMoveCancelListener(MapboxMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (this.onCameraMoveCanceled.contains(onCameraMoveCanceledListener)) {
            this.onCameraMoveCanceled.remove(onCameraMoveCanceledListener);
        }
    }

    void addOnCameraMoveStartedListener(MapboxMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.onCameraMoveStarted.add(onCameraMoveStartedListener);
    }

    void removeOnCameraMoveStartedListener(MapboxMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (this.onCameraMoveStarted.contains(onCameraMoveStartedListener)) {
            this.onCameraMoveStarted.remove(onCameraMoveStartedListener);
        }
    }

    void addOnCameraMoveListener(MapboxMap.OnCameraMoveListener onCameraMoveListener) {
        this.onCameraMove.add(onCameraMoveListener);
    }

    void removeOnCameraMoveListener(MapboxMap.OnCameraMoveListener onCameraMoveListener) {
        if (this.onCameraMove.contains(onCameraMoveListener)) {
            this.onCameraMove.remove(onCameraMoveListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMoveStarted() {
        if (this.idle) {
            this.idle = false;
            if (this.onCameraMoveStarted.isEmpty()) {
                return;
            }
            Iterator<MapboxMap.OnCameraMoveStartedListener> it = this.onCameraMoveStarted.iterator();
            while (it.hasNext()) {
                it.next().onCameraMoveStarted(this.moveStartedReason);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMove() {
        if (this.onCameraMove.isEmpty() || this.idle) {
            return;
        }
        Iterator<MapboxMap.OnCameraMoveListener> it = this.onCameraMove.iterator();
        while (it.hasNext()) {
            it.next().onCameraMove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraMoveCancelled() {
        if (this.onCameraMoveCanceled.isEmpty() || this.idle) {
            return;
        }
        Iterator<MapboxMap.OnCameraMoveCanceledListener> it = this.onCameraMoveCanceled.iterator();
        while (it.hasNext()) {
            it.next().onCameraMoveCanceled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeOnCameraIdle() {
        if (this.idle) {
            return;
        }
        this.idle = true;
        if (this.onCameraIdle.isEmpty()) {
            return;
        }
        Iterator<MapboxMap.OnCameraIdleListener> it = this.onCameraIdle.iterator();
        while (it.hasNext()) {
            it.next().onCameraIdle();
        }
    }

    void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        this.onCameraMoveStarted.clear();
        this.onCameraMoveCanceled.clear();
        this.onCameraMove.clear();
        this.onCameraIdle.clear();
    }

    private static class CameraChangeHandler extends Handler {
        private WeakReference<CameraChangeDispatcher> dispatcherWeakReference;

        CameraChangeHandler(CameraChangeDispatcher cameraChangeDispatcher) {
            this.dispatcherWeakReference = new WeakReference<>(cameraChangeDispatcher);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraChangeDispatcher cameraChangeDispatcher = this.dispatcherWeakReference.get();
            if (cameraChangeDispatcher != null) {
                int i = message.what;
                if (i == 0) {
                    cameraChangeDispatcher.executeOnCameraMoveStarted();
                    return;
                }
                if (i == 1) {
                    cameraChangeDispatcher.executeOnCameraMove();
                } else if (i == 2) {
                    cameraChangeDispatcher.executeOnCameraMoveCancelled();
                } else {
                    if (i != 3) {
                        return;
                    }
                    cameraChangeDispatcher.executeOnCameraIdle();
                }
            }
        }

        void scheduleMessage(int i) {
            CameraChangeDispatcher cameraChangeDispatcher = this.dispatcherWeakReference.get();
            if (cameraChangeDispatcher != null) {
                if (i == 0) {
                    boolean z = !cameraChangeDispatcher.idle && (hasMessages(3) || hasMessages(2));
                    removeMessages(3);
                    removeMessages(2);
                    if (z) {
                        return;
                    }
                }
                Message message = new Message();
                message.what = i;
                sendMessage(message);
            }
        }
    }
}