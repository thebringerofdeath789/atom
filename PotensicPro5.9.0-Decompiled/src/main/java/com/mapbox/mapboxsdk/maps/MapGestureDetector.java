package com.mapbox.mapboxsdk.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.mapbox.android.gestures.AndroidGesturesManager;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.android.gestures.MultiFingerTapGestureDetector;
import com.mapbox.android.gestures.R;
import com.mapbox.android.gestures.RotateGestureDetector;
import com.mapbox.android.gestures.ShoveGestureDetector;
import com.mapbox.android.gestures.StandardGestureDetector;
import com.mapbox.android.gestures.StandardScaleGestureDetector;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.utils.MathUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
final class MapGestureDetector {
    private final AnnotationManager annotationManager;
    private final CameraChangeDispatcher cameraChangeDispatcher;
    private PointF constantFocalPoint;
    private boolean doubleTapRegistered;
    private AndroidGesturesManager gesturesManager;
    private final Projection projection;
    private Animator rotateAnimator;
    private Animator scaleAnimator;
    private final Transform transform;
    private final UiSettings uiSettings;
    private final CopyOnWriteArrayList<MapboxMap.OnMapClickListener> onMapClickListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnMapLongClickListener> onMapLongClickListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnFlingListener> onFlingListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnMoveListener> onMoveListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnRotateListener> onRotateListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnScaleListener> onScaleListenerList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<MapboxMap.OnShoveListener> onShoveListenerList = new CopyOnWriteArrayList<>();
    private PointF doubleTapFocalPoint = new PointF();
    private final List<Animator> scheduledAnimators = new ArrayList();
    private Handler animationsTimeoutHandler = new Handler();
    private final Runnable cancelAnimatorsRunnable = new Runnable() { // from class: com.mapbox.mapboxsdk.maps.MapGestureDetector.1
        @Override // java.lang.Runnable
        public void run() {
            MapGestureDetector.this.cancelAnimators();
        }
    };

    MapGestureDetector(Context context, Transform transform, Projection projection, UiSettings uiSettings, AnnotationManager annotationManager, CameraChangeDispatcher cameraChangeDispatcher) {
        this.annotationManager = annotationManager;
        this.transform = transform;
        this.projection = projection;
        this.uiSettings = uiSettings;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
        if (context != null) {
            initializeGesturesManager(new AndroidGesturesManager(context), true);
            initializeGestureListeners(context, true);
        }
    }

    private void initializeGestureListeners(Context context, boolean z) {
        if (z) {
            StandardGestureListener standardGestureListener = new StandardGestureListener(context.getResources().getDimension(R.dimen.mapbox_defaultScaleSpanSinceStartThreshold));
            MoveGestureListener moveGestureListener = new MoveGestureListener();
            ScaleGestureListener scaleGestureListener = new ScaleGestureListener(context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_density_constant), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_minimum_scale_speed), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_minimum_angled_scale_speed), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_minimum_scale_velocity));
            RotateGestureListener rotateGestureListener = new RotateGestureListener(context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_minimum_scale_span_when_rotating), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_density_constant), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_angular_velocity_multiplier), context.getResources().getDimension(com.mapbox.mapboxsdk.R.dimen.mapbox_minimum_angular_velocity), context.getResources().getDimension(R.dimen.mapbox_defaultScaleSpanSinceStartThreshold));
            ShoveGestureListener shoveGestureListener = new ShoveGestureListener();
            TapGestureListener tapGestureListener = new TapGestureListener();
            this.gesturesManager.setStandardGestureListener(standardGestureListener);
            this.gesturesManager.setMoveGestureListener(moveGestureListener);
            this.gesturesManager.setStandardScaleGestureListener(scaleGestureListener);
            this.gesturesManager.setRotateGestureListener(rotateGestureListener);
            this.gesturesManager.setShoveGestureListener(shoveGestureListener);
            this.gesturesManager.setMultiFingerTapGestureListener(tapGestureListener);
        }
    }

    private void initializeGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z) {
        if (z) {
            HashSet hashSet = new HashSet();
            hashSet.add(3);
            hashSet.add(1);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(3);
            hashSet2.add(2);
            HashSet hashSet3 = new HashSet();
            hashSet3.add(1);
            hashSet3.add(6);
            androidGesturesManager.setMutuallyExclusiveGestures(hashSet, hashSet2, hashSet3);
        }
        this.gesturesManager = androidGesturesManager;
        androidGesturesManager.getRotateGestureDetector().setAngleThreshold(3.0f);
    }

    void setFocalPoint(PointF pointF) {
        if (pointF == null && this.uiSettings.getFocalPoint() != null) {
            pointF = this.uiSettings.getFocalPoint();
        }
        this.constantFocalPoint = pointF;
    }

    boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getButtonState() != 0 && motionEvent.getButtonState() != 1) {
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            cancelAnimators();
            this.transform.setGestureInProgress(true);
        }
        boolean onTouchEvent = this.gesturesManager.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            doubleTapFinished();
            this.transform.setGestureInProgress(false);
            if (!this.scheduledAnimators.isEmpty()) {
                this.animationsTimeoutHandler.removeCallbacksAndMessages(null);
                Iterator<Animator> it = this.scheduledAnimators.iterator();
                while (it.hasNext()) {
                    it.next().start();
                }
                this.scheduledAnimators.clear();
            }
        } else if (actionMasked == 3) {
            this.scheduledAnimators.clear();
            this.transform.setGestureInProgress(false);
            doubleTapFinished();
        } else if (actionMasked == 5) {
            doubleTapFinished();
        }
        return onTouchEvent;
    }

    void cancelAnimators() {
        this.animationsTimeoutHandler.removeCallbacksAndMessages(null);
        this.scheduledAnimators.clear();
        cancelAnimator(this.scaleAnimator);
        cancelAnimator(this.rotateAnimator);
        dispatchCameraIdle();
    }

    private void cancelAnimator(Animator animator) {
        if (animator == null || !animator.isStarted()) {
            return;
        }
        animator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAnimator(Animator animator) {
        this.scheduledAnimators.add(animator);
        this.animationsTimeoutHandler.removeCallbacksAndMessages(null);
        this.animationsTimeoutHandler.postDelayed(this.cancelAnimatorsRunnable, 150L);
    }

    boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 2 || motionEvent.getActionMasked() != 8 || !this.uiSettings.isZoomGesturesEnabled()) {
            return false;
        }
        this.transform.cancelTransitions();
        this.transform.zoomBy(motionEvent.getAxisValue(9), new PointF(motionEvent.getX(), motionEvent.getY()));
        return true;
    }

    private final class StandardGestureListener extends StandardGestureDetector.SimpleStandardOnGestureListener {
        private final float doubleTapMovementThreshold;

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        StandardGestureListener(float f) {
            this.doubleTapMovementThreshold = f;
        }

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            MapGestureDetector.this.transform.cancelTransitions();
            return true;
        }

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            if (MapGestureDetector.this.annotationManager.onTap(pointF)) {
                return true;
            }
            if (MapGestureDetector.this.uiSettings.isDeselectMarkersOnTap()) {
                MapGestureDetector.this.annotationManager.deselectMarkers();
            }
            MapGestureDetector.this.notifyOnMapClickListeners(pointF);
            return true;
        }

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                MapGestureDetector.this.doubleTapFocalPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                MapGestureDetector.this.doubleTapStarted();
            }
            if (motionEvent.getActionMasked() == 1) {
                float abs = Math.abs(motionEvent.getX() - MapGestureDetector.this.doubleTapFocalPoint.x);
                float abs2 = Math.abs(motionEvent.getY() - MapGestureDetector.this.doubleTapFocalPoint.y);
                float f = this.doubleTapMovementThreshold;
                if (abs > f || abs2 > f || !MapGestureDetector.this.uiSettings.isZoomGesturesEnabled() || !MapGestureDetector.this.uiSettings.isDoubleTapGesturesEnabled()) {
                    return false;
                }
                if (MapGestureDetector.this.constantFocalPoint != null) {
                    MapGestureDetector mapGestureDetector = MapGestureDetector.this;
                    mapGestureDetector.doubleTapFocalPoint = mapGestureDetector.constantFocalPoint;
                }
                MapGestureDetector mapGestureDetector2 = MapGestureDetector.this;
                mapGestureDetector2.zoomInAnimated(mapGestureDetector2.doubleTapFocalPoint, false);
                return true;
            }
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            MapGestureDetector.this.notifyOnMapLongClickListeners(new PointF(motionEvent.getX(), motionEvent.getY()));
        }

        @Override // com.mapbox.android.gestures.StandardGestureDetector.SimpleStandardOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            double d;
            if (!MapGestureDetector.this.uiSettings.isScrollGesturesEnabled() || !MapGestureDetector.this.uiSettings.isFlingVelocityAnimationEnabled()) {
                return false;
            }
            float pixelRatio = MapGestureDetector.this.uiSettings.getPixelRatio();
            if (pixelRatio < 3.0f) {
                pixelRatio = 3.0f;
            }
            double hypot = Math.hypot(f / pixelRatio, f2 / pixelRatio);
            if (hypot < 300.0d) {
                return false;
            }
            double tilt = MapGestureDetector.this.transform.getTilt();
            double d2 = (tilt != 0.0d ? tilt / 10.0d : 0.0d) + 1.5d;
            double d3 = pixelRatio;
            double d4 = (f / d2) / d3;
            double d5 = (f2 / d2) / d3;
            long j = (long) (((hypot / 7.0d) / d2) + 500.0d);
            if (MapGestureDetector.this.uiSettings.isHorizontalScrollGesturesEnabled()) {
                d = d4;
            } else {
                if (Math.abs(Math.toDegrees(Math.atan(d4 / d5))) > 75.0d) {
                    return false;
                }
                d = 0.0d;
            }
            MapGestureDetector.this.transform.cancelTransitions();
            MapGestureDetector.this.notifyOnFlingListeners();
            MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            MapGestureDetector.this.transform.moveBy(d, d5, j);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapStarted() {
        this.gesturesManager.getMoveGestureDetector().setEnabled(false);
        this.doubleTapRegistered = true;
    }

    private void doubleTapFinished() {
        if (this.doubleTapRegistered) {
            this.gesturesManager.getMoveGestureDetector().setEnabled(true);
            this.doubleTapRegistered = false;
        }
    }

    private final class MoveGestureListener extends MoveGestureDetector.SimpleOnMoveGestureListener {
        private MoveGestureListener() {
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.SimpleOnMoveGestureListener, com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            if (!MapGestureDetector.this.uiSettings.isScrollGesturesEnabled()) {
                return false;
            }
            MapGestureDetector.this.cancelTransitionsIfRequired();
            MapGestureDetector.this.notifyOnMoveBeginListeners(moveGestureDetector);
            return true;
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.SimpleOnMoveGestureListener, com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            if (f != 0.0f || f2 != 0.0f) {
                MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
                if (!MapGestureDetector.this.uiSettings.isHorizontalScrollGesturesEnabled()) {
                    f = 0.0f;
                }
                MapGestureDetector.this.transform.moveBy(-f, -f2, 0L);
                MapGestureDetector.this.notifyOnMoveListeners(moveGestureDetector);
            }
            return true;
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.SimpleOnMoveGestureListener, com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
            MapGestureDetector.this.dispatchCameraIdle();
            MapGestureDetector.this.notifyOnMoveEndListeners(moveGestureDetector);
        }
    }

    private final class ScaleGestureListener extends StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener {
        private final float minimumAngledGestureSpeed;
        private final float minimumGestureSpeed;
        private final float minimumVelocity;
        private boolean quickZoom;
        private final double scaleVelocityRatioThreshold;
        private double screenHeight;
        private float spanSinceLast;
        private double startZoom;

        ScaleGestureListener(double d, float f, float f2, float f3) {
            this.minimumGestureSpeed = f;
            this.minimumAngledGestureSpeed = f2;
            this.minimumVelocity = f3;
            this.scaleVelocityRatioThreshold = d * 0.004d;
        }

        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener, com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            this.quickZoom = standardScaleGestureDetector.getPointersCount() == 1;
            if (!MapGestureDetector.this.uiSettings.isZoomGesturesEnabled()) {
                return false;
            }
            if (this.quickZoom) {
                if (!MapGestureDetector.this.uiSettings.isQuickZoomGesturesEnabled()) {
                    return false;
                }
                MapGestureDetector.this.gesturesManager.getMoveGestureDetector().setEnabled(false);
            } else {
                if (standardScaleGestureDetector.getPreviousSpan() <= 0.0f) {
                    return false;
                }
                float currentSpan = standardScaleGestureDetector.getCurrentSpan();
                float previousSpan = standardScaleGestureDetector.getPreviousSpan();
                double eventTime = standardScaleGestureDetector.getCurrentEvent().getEventTime();
                double eventTime2 = standardScaleGestureDetector.getPreviousEvent().getEventTime();
                if (eventTime == eventTime2) {
                    return false;
                }
                double abs = Math.abs(currentSpan - previousSpan) / (eventTime - eventTime2);
                if (abs < this.minimumGestureSpeed) {
                    return false;
                }
                if (!MapGestureDetector.this.gesturesManager.getRotateGestureDetector().isInProgress()) {
                    if (Math.abs(MapGestureDetector.this.gesturesManager.getRotateGestureDetector().getDeltaSinceLast()) > 0.4d && abs < this.minimumAngledGestureSpeed) {
                        return false;
                    }
                    if (MapGestureDetector.this.uiSettings.isDisableRotateWhenScaling()) {
                        MapGestureDetector.this.gesturesManager.getRotateGestureDetector().setEnabled(false);
                    }
                }
            }
            this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
            this.startZoom = MapGestureDetector.this.transform.getRawZoom();
            MapGestureDetector.this.cancelTransitionsIfRequired();
            MapGestureDetector.this.notifyOnScaleBeginListeners(standardScaleGestureDetector);
            this.spanSinceLast = Math.abs(standardScaleGestureDetector.getCurrentSpan() - standardScaleGestureDetector.getPreviousSpan());
            return true;
        }

        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener, com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            PointF scaleFocalPoint = getScaleFocalPoint(standardScaleGestureDetector);
            if (this.quickZoom) {
                double abs = Math.abs(standardScaleGestureDetector.getCurrentEvent().getY() - MapGestureDetector.this.doubleTapFocalPoint.y);
                boolean z = standardScaleGestureDetector.getCurrentEvent().getY() < MapGestureDetector.this.doubleTapFocalPoint.y;
                double normalize = MathUtils.normalize(abs, 0.0d, this.screenHeight, 0.0d, 4.0d);
                double d = this.startZoom;
                MapGestureDetector.this.transform.setZoom((z ? d - normalize : d + normalize) * MapGestureDetector.this.uiSettings.getZoomRate(), scaleFocalPoint);
            } else {
                MapGestureDetector.this.transform.zoomBy((Math.log(standardScaleGestureDetector.getScaleFactor()) / Math.log(1.5707963267948966d)) * 0.6499999761581421d * MapGestureDetector.this.uiSettings.getZoomRate(), scaleFocalPoint);
            }
            MapGestureDetector.this.notifyOnScaleListeners(standardScaleGestureDetector);
            this.spanSinceLast = Math.abs(standardScaleGestureDetector.getCurrentSpan() - standardScaleGestureDetector.getPreviousSpan());
            return true;
        }

        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener, com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2) {
            if (this.quickZoom) {
                MapGestureDetector.this.gesturesManager.getMoveGestureDetector().setEnabled(true);
            } else {
                MapGestureDetector.this.gesturesManager.getRotateGestureDetector().setEnabled(true);
            }
            MapGestureDetector.this.notifyOnScaleEndListeners(standardScaleGestureDetector);
            float abs = Math.abs(f) + Math.abs(f2);
            if (!MapGestureDetector.this.uiSettings.isScaleVelocityAnimationEnabled() || abs < this.minimumVelocity || this.spanSinceLast / abs < this.scaleVelocityRatioThreshold) {
                MapGestureDetector.this.dispatchCameraIdle();
                return;
            }
            double calculateScale = calculateScale(abs, standardScaleGestureDetector.isScalingOut());
            double rawZoom = MapGestureDetector.this.transform.getRawZoom();
            PointF scaleFocalPoint = getScaleFocalPoint(standardScaleGestureDetector);
            long log = (long) ((Math.log(Math.abs(calculateScale) + (1.0d / Math.pow(2.718281828459045d, 2.0d))) + 2.0d) * 150.0d);
            MapGestureDetector mapGestureDetector = MapGestureDetector.this;
            mapGestureDetector.scaleAnimator = mapGestureDetector.createScaleAnimator(rawZoom, calculateScale, scaleFocalPoint, log);
            MapGestureDetector mapGestureDetector2 = MapGestureDetector.this;
            mapGestureDetector2.scheduleAnimator(mapGestureDetector2.scaleAnimator);
        }

        private PointF getScaleFocalPoint(StandardScaleGestureDetector standardScaleGestureDetector) {
            if (MapGestureDetector.this.constantFocalPoint != null) {
                return MapGestureDetector.this.constantFocalPoint;
            }
            if (this.quickZoom) {
                return new PointF(MapGestureDetector.this.uiSettings.getWidth() / 2.0f, MapGestureDetector.this.uiSettings.getHeight() / 2.0f);
            }
            return standardScaleGestureDetector.getFocalPoint();
        }

        private double calculateScale(double d, boolean z) {
            double clamp = MathUtils.clamp(d * 2.5d * 1.0E-4d, 0.0d, 2.5d);
            return z ? -clamp : clamp;
        }
    }

    private final class RotateGestureListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        private final float angularVelocityMultiplier;
        private final float defaultSpanSinceStartThreshold;
        private final float minimumAngularVelocity;
        private final float minimumScaleSpanWhenRotating;
        private final double rotateVelocityRatioThreshold;

        RotateGestureListener(float f, double d, float f2, float f3, float f4) {
            this.minimumScaleSpanWhenRotating = f;
            this.angularVelocityMultiplier = f2;
            this.minimumAngularVelocity = f3;
            this.rotateVelocityRatioThreshold = d * 2.2000000000000003E-4d;
            this.defaultSpanSinceStartThreshold = f4;
        }

        @Override // com.mapbox.android.gestures.RotateGestureDetector.SimpleOnRotateGestureListener, com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            if (!MapGestureDetector.this.uiSettings.isRotateGesturesEnabled()) {
                return false;
            }
            float abs = Math.abs(rotateGestureDetector.getDeltaSinceLast());
            double eventTime = rotateGestureDetector.getCurrentEvent().getEventTime();
            double eventTime2 = rotateGestureDetector.getPreviousEvent().getEventTime();
            if (eventTime == eventTime2) {
                return false;
            }
            double d = abs / (eventTime - eventTime2);
            float abs2 = Math.abs(rotateGestureDetector.getDeltaSinceStart());
            if (d < 0.04d || ((d > 0.07d && abs2 < 5.0f) || ((d > 0.15d && abs2 < 7.0f) || (d > 0.5d && abs2 < 15.0f)))) {
                return false;
            }
            if (MapGestureDetector.this.uiSettings.isIncreaseScaleThresholdWhenRotating()) {
                MapGestureDetector.this.gesturesManager.getStandardScaleGestureDetector().setSpanSinceStartThreshold(this.minimumScaleSpanWhenRotating);
                MapGestureDetector.this.gesturesManager.getStandardScaleGestureDetector().interrupt();
            }
            MapGestureDetector.this.cancelTransitionsIfRequired();
            MapGestureDetector.this.notifyOnRotateBeginListeners(rotateGestureDetector);
            return true;
        }

        @Override // com.mapbox.android.gestures.RotateGestureDetector.SimpleOnRotateGestureListener, com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public boolean onRotate(RotateGestureDetector rotateGestureDetector, float f, float f2) {
            MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            double rawBearing = MapGestureDetector.this.transform.getRawBearing() + f;
            PointF rotateFocalPoint = getRotateFocalPoint(rotateGestureDetector);
            MapGestureDetector.this.transform.setBearing(rawBearing, rotateFocalPoint.x, rotateFocalPoint.y);
            MapGestureDetector.this.notifyOnRotateListeners(rotateGestureDetector);
            return true;
        }

        @Override // com.mapbox.android.gestures.RotateGestureDetector.SimpleOnRotateGestureListener, com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3) {
            if (MapGestureDetector.this.uiSettings.isIncreaseScaleThresholdWhenRotating()) {
                MapGestureDetector.this.gesturesManager.getStandardScaleGestureDetector().setSpanSinceStartThreshold(this.defaultSpanSinceStartThreshold);
            }
            MapGestureDetector.this.notifyOnRotateEndListeners(rotateGestureDetector);
            float clamp = MathUtils.clamp(f3 * this.angularVelocityMultiplier, -30.0f, 30.0f);
            double abs = Math.abs(rotateGestureDetector.getDeltaSinceLast()) / (Math.abs(f) + Math.abs(f2));
            if (!MapGestureDetector.this.uiSettings.isRotateVelocityAnimationEnabled() || Math.abs(clamp) < this.minimumAngularVelocity || (MapGestureDetector.this.gesturesManager.getStandardScaleGestureDetector().isInProgress() && abs < this.rotateVelocityRatioThreshold)) {
                MapGestureDetector.this.dispatchCameraIdle();
                return;
            }
            MapGestureDetector.this.rotateAnimator = createRotateAnimator(clamp, (long) ((Math.log(Math.abs(clamp) + (1.0d / Math.pow(2.718281828459045d, 2.0d))) + 2.0d) * 150.0d), getRotateFocalPoint(rotateGestureDetector));
            MapGestureDetector mapGestureDetector = MapGestureDetector.this;
            mapGestureDetector.scheduleAnimator(mapGestureDetector.rotateAnimator);
        }

        private PointF getRotateFocalPoint(RotateGestureDetector rotateGestureDetector) {
            if (MapGestureDetector.this.constantFocalPoint != null) {
                return MapGestureDetector.this.constantFocalPoint;
            }
            return rotateGestureDetector.getFocalPoint();
        }

        private Animator createRotateAnimator(float f, long j, final PointF pointF) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, 0.0f);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mapbox.mapboxsdk.maps.MapGestureDetector.RotateGestureListener.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MapGestureDetector.this.transform.setBearing(MapGestureDetector.this.transform.getRawBearing() + ((Float) valueAnimator.getAnimatedValue()).floatValue(), pointF.x, pointF.y, 0L);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.maps.MapGestureDetector.RotateGestureListener.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MapGestureDetector.this.transform.cancelTransitions();
                    MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    MapGestureDetector.this.transform.cancelTransitions();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MapGestureDetector.this.dispatchCameraIdle();
                }
            });
            return ofFloat;
        }
    }

    private final class ShoveGestureListener extends ShoveGestureDetector.SimpleOnShoveGestureListener {
        private ShoveGestureListener() {
        }

        @Override // com.mapbox.android.gestures.ShoveGestureDetector.SimpleOnShoveGestureListener, com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            if (!MapGestureDetector.this.uiSettings.isTiltGesturesEnabled()) {
                return false;
            }
            MapGestureDetector.this.cancelTransitionsIfRequired();
            MapGestureDetector.this.gesturesManager.getMoveGestureDetector().setEnabled(false);
            MapGestureDetector.this.notifyOnShoveBeginListeners(shoveGestureDetector);
            return true;
        }

        @Override // com.mapbox.android.gestures.ShoveGestureDetector.SimpleOnShoveGestureListener, com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            MapGestureDetector.this.transform.setTilt(Double.valueOf(MathUtils.clamp(MapGestureDetector.this.transform.getTilt() - (f * 0.1f), 0.0d, 60.0d)));
            MapGestureDetector.this.notifyOnShoveListeners(shoveGestureDetector);
            return true;
        }

        @Override // com.mapbox.android.gestures.ShoveGestureDetector.SimpleOnShoveGestureListener, com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            MapGestureDetector.this.dispatchCameraIdle();
            MapGestureDetector.this.gesturesManager.getMoveGestureDetector().setEnabled(true);
            MapGestureDetector.this.notifyOnShoveEndListeners(shoveGestureDetector);
        }
    }

    private final class TapGestureListener implements MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener {
        private TapGestureListener() {
        }

        @Override // com.mapbox.android.gestures.MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener
        public boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i) {
            PointF focalPoint;
            if (!MapGestureDetector.this.uiSettings.isZoomGesturesEnabled() || i != 2) {
                return false;
            }
            MapGestureDetector.this.transform.cancelTransitions();
            MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            if (MapGestureDetector.this.constantFocalPoint != null) {
                focalPoint = MapGestureDetector.this.constantFocalPoint;
            } else {
                focalPoint = multiFingerTapGestureDetector.getFocalPoint();
            }
            MapGestureDetector.this.zoomOutAnimated(focalPoint, false);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator createScaleAnimator(double d, double d2, final PointF pointF, long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat((float) d, (float) (d + d2));
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mapbox.mapboxsdk.maps.MapGestureDetector.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MapGestureDetector.this.transform.setZoom(((Float) valueAnimator.getAnimatedValue()).floatValue(), pointF);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.maps.MapGestureDetector.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MapGestureDetector.this.transform.cancelTransitions();
                MapGestureDetector.this.cameraChangeDispatcher.onCameraMoveStarted(1);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                MapGestureDetector.this.transform.cancelTransitions();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MapGestureDetector.this.dispatchCameraIdle();
            }
        });
        return ofFloat;
    }

    void zoomInAnimated(PointF pointF, boolean z) {
        zoomAnimated(true, pointF, z);
    }

    void zoomOutAnimated(PointF pointF, boolean z) {
        zoomAnimated(false, pointF, z);
    }

    private void zoomAnimated(boolean z, PointF pointF, boolean z2) {
        cancelAnimator(this.scaleAnimator);
        Animator createScaleAnimator = createScaleAnimator(this.transform.getRawZoom(), z ? 1.0d : -1.0d, pointF, 300L);
        this.scaleAnimator = createScaleAnimator;
        if (z2) {
            createScaleAnimator.start();
        } else {
            scheduleAnimator(createScaleAnimator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCameraIdle() {
        if (noGesturesInProgress()) {
            this.transform.invalidateCameraPosition();
            this.cameraChangeDispatcher.onCameraIdle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTransitionsIfRequired() {
        if (noGesturesInProgress()) {
            this.transform.cancelTransitions();
        }
    }

    private boolean noGesturesInProgress() {
        return ((this.uiSettings.isScrollGesturesEnabled() && this.gesturesManager.getMoveGestureDetector().isInProgress()) || (this.uiSettings.isZoomGesturesEnabled() && this.gesturesManager.getStandardScaleGestureDetector().isInProgress()) || ((this.uiSettings.isRotateGesturesEnabled() && this.gesturesManager.getRotateGestureDetector().isInProgress()) || (this.uiSettings.isTiltGesturesEnabled() && this.gesturesManager.getShoveGestureDetector().isInProgress()))) ? false : true;
    }

    void notifyOnMapClickListeners(PointF pointF) {
        Iterator<MapboxMap.OnMapClickListener> it = this.onMapClickListenerList.iterator();
        while (it.hasNext() && !it.next().onMapClick(this.projection.fromScreenLocation(pointF))) {
        }
    }

    void notifyOnMapLongClickListeners(PointF pointF) {
        Iterator<MapboxMap.OnMapLongClickListener> it = this.onMapLongClickListenerList.iterator();
        while (it.hasNext() && !it.next().onMapLongClick(this.projection.fromScreenLocation(pointF))) {
        }
    }

    void notifyOnFlingListeners() {
        Iterator<MapboxMap.OnFlingListener> it = this.onFlingListenerList.iterator();
        while (it.hasNext()) {
            it.next().onFling();
        }
    }

    void notifyOnMoveBeginListeners(MoveGestureDetector moveGestureDetector) {
        Iterator<MapboxMap.OnMoveListener> it = this.onMoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onMoveBegin(moveGestureDetector);
        }
    }

    void notifyOnMoveListeners(MoveGestureDetector moveGestureDetector) {
        Iterator<MapboxMap.OnMoveListener> it = this.onMoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onMove(moveGestureDetector);
        }
    }

    void notifyOnMoveEndListeners(MoveGestureDetector moveGestureDetector) {
        Iterator<MapboxMap.OnMoveListener> it = this.onMoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onMoveEnd(moveGestureDetector);
        }
    }

    void notifyOnRotateBeginListeners(RotateGestureDetector rotateGestureDetector) {
        Iterator<MapboxMap.OnRotateListener> it = this.onRotateListenerList.iterator();
        while (it.hasNext()) {
            it.next().onRotateBegin(rotateGestureDetector);
        }
    }

    void notifyOnRotateListeners(RotateGestureDetector rotateGestureDetector) {
        Iterator<MapboxMap.OnRotateListener> it = this.onRotateListenerList.iterator();
        while (it.hasNext()) {
            it.next().onRotate(rotateGestureDetector);
        }
    }

    void notifyOnRotateEndListeners(RotateGestureDetector rotateGestureDetector) {
        Iterator<MapboxMap.OnRotateListener> it = this.onRotateListenerList.iterator();
        while (it.hasNext()) {
            it.next().onRotateEnd(rotateGestureDetector);
        }
    }

    void notifyOnScaleBeginListeners(StandardScaleGestureDetector standardScaleGestureDetector) {
        Iterator<MapboxMap.OnScaleListener> it = this.onScaleListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScaleBegin(standardScaleGestureDetector);
        }
    }

    void notifyOnScaleListeners(StandardScaleGestureDetector standardScaleGestureDetector) {
        Iterator<MapboxMap.OnScaleListener> it = this.onScaleListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScale(standardScaleGestureDetector);
        }
    }

    void notifyOnScaleEndListeners(StandardScaleGestureDetector standardScaleGestureDetector) {
        Iterator<MapboxMap.OnScaleListener> it = this.onScaleListenerList.iterator();
        while (it.hasNext()) {
            it.next().onScaleEnd(standardScaleGestureDetector);
        }
    }

    void notifyOnShoveBeginListeners(ShoveGestureDetector shoveGestureDetector) {
        Iterator<MapboxMap.OnShoveListener> it = this.onShoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onShoveBegin(shoveGestureDetector);
        }
    }

    void notifyOnShoveListeners(ShoveGestureDetector shoveGestureDetector) {
        Iterator<MapboxMap.OnShoveListener> it = this.onShoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onShove(shoveGestureDetector);
        }
    }

    void notifyOnShoveEndListeners(ShoveGestureDetector shoveGestureDetector) {
        Iterator<MapboxMap.OnShoveListener> it = this.onShoveListenerList.iterator();
        while (it.hasNext()) {
            it.next().onShoveEnd(shoveGestureDetector);
        }
    }

    void addOnMapClickListener(MapboxMap.OnMapClickListener onMapClickListener) {
        this.onMapClickListenerList.add(onMapClickListener);
    }

    void removeOnMapClickListener(MapboxMap.OnMapClickListener onMapClickListener) {
        this.onMapClickListenerList.remove(onMapClickListener);
    }

    void addOnMapLongClickListener(MapboxMap.OnMapLongClickListener onMapLongClickListener) {
        this.onMapLongClickListenerList.add(onMapLongClickListener);
    }

    void removeOnMapLongClickListener(MapboxMap.OnMapLongClickListener onMapLongClickListener) {
        this.onMapLongClickListenerList.remove(onMapLongClickListener);
    }

    void addOnFlingListener(MapboxMap.OnFlingListener onFlingListener) {
        this.onFlingListenerList.add(onFlingListener);
    }

    void removeOnFlingListener(MapboxMap.OnFlingListener onFlingListener) {
        this.onFlingListenerList.remove(onFlingListener);
    }

    void addOnMoveListener(MapboxMap.OnMoveListener onMoveListener) {
        this.onMoveListenerList.add(onMoveListener);
    }

    void removeOnMoveListener(MapboxMap.OnMoveListener onMoveListener) {
        this.onMoveListenerList.remove(onMoveListener);
    }

    void addOnRotateListener(MapboxMap.OnRotateListener onRotateListener) {
        this.onRotateListenerList.add(onRotateListener);
    }

    void removeOnRotateListener(MapboxMap.OnRotateListener onRotateListener) {
        this.onRotateListenerList.remove(onRotateListener);
    }

    void addOnScaleListener(MapboxMap.OnScaleListener onScaleListener) {
        this.onScaleListenerList.add(onScaleListener);
    }

    void removeOnScaleListener(MapboxMap.OnScaleListener onScaleListener) {
        this.onScaleListenerList.remove(onScaleListener);
    }

    void addShoveListener(MapboxMap.OnShoveListener onShoveListener) {
        this.onShoveListenerList.add(onShoveListener);
    }

    void removeShoveListener(MapboxMap.OnShoveListener onShoveListener) {
        this.onShoveListenerList.remove(onShoveListener);
    }

    AndroidGesturesManager getGesturesManager() {
        return this.gesturesManager;
    }

    void setGesturesManager(Context context, AndroidGesturesManager androidGesturesManager, boolean z, boolean z2) {
        initializeGesturesManager(androidGesturesManager, z2);
        initializeGestureListeners(context, z);
    }
}
