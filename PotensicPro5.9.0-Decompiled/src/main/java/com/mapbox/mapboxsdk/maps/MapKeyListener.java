package com.mapbox.mapboxsdk.maps;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* loaded from: classes3.dex */
final class MapKeyListener {
    private TrackballLongPressTimeOut currentTrackballLongPressTimeOut;
    private final MapGestureDetector mapGestureDetector;
    private final Transform transform;
    private final UiSettings uiSettings;

    MapKeyListener(Transform transform, UiSettings uiSettings, MapGestureDetector mapGestureDetector) {
        this.transform = transform;
        this.uiSettings = uiSettings;
        this.mapGestureDetector = mapGestureDetector;
    }

    boolean onKeyDown(int i, KeyEvent keyEvent) {
        double d = keyEvent.getRepeatCount() >= 5 ? 50.0d : 10.0d;
        if (i != 66) {
            switch (i) {
                case 19:
                    if (this.uiSettings.isScrollGesturesEnabled()) {
                        this.transform.cancelTransitions();
                        this.transform.moveBy(0.0d, d, 0L);
                        break;
                    }
                    break;
                case 20:
                    if (this.uiSettings.isScrollGesturesEnabled()) {
                        this.transform.cancelTransitions();
                        this.transform.moveBy(0.0d, -d, 0L);
                        break;
                    }
                    break;
                case 21:
                    if (this.uiSettings.isScrollGesturesEnabled()) {
                        this.transform.cancelTransitions();
                        this.transform.moveBy(d, 0.0d, 0L);
                        break;
                    }
                    break;
                case 22:
                    if (this.uiSettings.isScrollGesturesEnabled()) {
                        this.transform.cancelTransitions();
                        this.transform.moveBy(-d, 0.0d, 0L);
                        break;
                    }
                    break;
            }
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if ((i != 23 && i != 66) || !this.uiSettings.isZoomGesturesEnabled()) {
            return false;
        }
        this.mapGestureDetector.zoomOutAnimated(new PointF(this.uiSettings.getWidth() / 2.0f, this.uiSettings.getHeight() / 2.0f), true);
        return true;
    }

    boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.isCanceled()) {
            return false;
        }
        if ((i != 23 && i != 66) || !this.uiSettings.isZoomGesturesEnabled()) {
            return false;
        }
        this.mapGestureDetector.zoomInAnimated(new PointF(this.uiSettings.getWidth() / 2.0f, this.uiSettings.getHeight() / 2.0f), true);
        return true;
    }

    boolean onTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            TrackballLongPressTimeOut trackballLongPressTimeOut = this.currentTrackballLongPressTimeOut;
            if (trackballLongPressTimeOut != null) {
                trackballLongPressTimeOut.cancel();
                this.currentTrackballLongPressTimeOut = null;
            }
            this.currentTrackballLongPressTimeOut = new TrackballLongPressTimeOut();
            new Handler(Looper.getMainLooper()).postDelayed(this.currentTrackballLongPressTimeOut, ViewConfiguration.getLongPressTimeout());
            return true;
        }
        if (actionMasked == 1) {
            if (!this.uiSettings.isZoomGesturesEnabled()) {
                return false;
            }
            if (this.currentTrackballLongPressTimeOut != null) {
                this.mapGestureDetector.zoomInAnimated(new PointF(this.uiSettings.getWidth() / 2.0f, this.uiSettings.getHeight() / 2.0f), true);
            }
            return true;
        }
        if (actionMasked == 2) {
            if (!this.uiSettings.isScrollGesturesEnabled()) {
                return false;
            }
            this.transform.cancelTransitions();
            this.transform.moveBy(motionEvent.getX() * (-10.0d), motionEvent.getY() * (-10.0d), 0L);
            return true;
        }
        if (actionMasked != 3) {
            return false;
        }
        TrackballLongPressTimeOut trackballLongPressTimeOut2 = this.currentTrackballLongPressTimeOut;
        if (trackballLongPressTimeOut2 != null) {
            trackballLongPressTimeOut2.cancel();
            this.currentTrackballLongPressTimeOut = null;
        }
        return true;
    }

    private class TrackballLongPressTimeOut implements Runnable {
        private boolean cancelled = false;

        TrackballLongPressTimeOut() {
        }

        public void cancel() {
            this.cancelled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                return;
            }
            MapKeyListener.this.mapGestureDetector.zoomOutAnimated(new PointF(MapKeyListener.this.uiSettings.getWidth() / 2.0f, MapKeyListener.this.uiSettings.getHeight() / 2.0f), true);
            MapKeyListener.this.currentTrackballLongPressTimeOut = null;
        }
    }
}
