package com.mapbox.mapboxsdk.plugins.annotation;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.mapbox.android.gestures.AndroidGesturesManager;
import com.mapbox.android.gestures.MoveDistancesObject;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.geojson.Geometry;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class DraggableAnnotationController {
    private static DraggableAnnotationController INSTANCE;
    private List<AnnotationManager> annotationManagers;
    private Annotation draggedAnnotation;
    private AnnotationManager draggedAnnotationManager;
    private MapView mapView;
    private MapboxMap mapboxMap;
    private final int touchAreaMaxX;
    private final int touchAreaMaxY;
    private final int touchAreaShiftX;
    private final int touchAreaShiftY;

    public static DraggableAnnotationController getInstance(MapView mapView, MapboxMap mapboxMap) {
        DraggableAnnotationController draggableAnnotationController = INSTANCE;
        if (draggableAnnotationController == null || draggableAnnotationController.mapView != mapView || draggableAnnotationController.mapboxMap != mapboxMap) {
            INSTANCE = new DraggableAnnotationController(mapView, mapboxMap);
        }
        return INSTANCE;
    }

    private static void clearInstance() {
        DraggableAnnotationController draggableAnnotationController = INSTANCE;
        if (draggableAnnotationController != null) {
            draggableAnnotationController.mapView = null;
            draggableAnnotationController.mapboxMap = null;
            INSTANCE = null;
        }
    }

    DraggableAnnotationController(MapView mapView, MapboxMap mapboxMap) {
        this(mapView, mapboxMap, new AndroidGesturesManager(mapView.getContext(), false), mapView.getScrollX(), mapView.getScrollY(), mapView.getMeasuredWidth(), mapView.getMeasuredHeight());
    }

    public DraggableAnnotationController(MapView mapView, MapboxMap mapboxMap, final AndroidGesturesManager androidGesturesManager, int i, int i2, int i3, int i4) {
        this.annotationManagers = new ArrayList();
        this.mapView = mapView;
        this.mapboxMap = mapboxMap;
        this.touchAreaShiftX = i;
        this.touchAreaShiftY = i2;
        this.touchAreaMaxX = i3;
        this.touchAreaMaxY = i4;
        androidGesturesManager.setMoveGestureListener(new AnnotationMoveGestureListener());
        mapView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mapbox.mapboxsdk.plugins.annotation.DraggableAnnotationController.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Annotation annotation = DraggableAnnotationController.this.draggedAnnotation;
                androidGesturesManager.onTouchEvent(motionEvent);
                return (DraggableAnnotationController.this.draggedAnnotation == null && annotation == null) ? false : true;
            }
        });
    }

    void addAnnotationManager(AnnotationManager annotationManager) {
        this.annotationManagers.add(annotationManager);
    }

    void removeAnnotationManager(AnnotationManager annotationManager) {
        this.annotationManagers.remove(annotationManager);
        if (this.annotationManagers.isEmpty()) {
            clearInstance();
        }
    }

    void onSourceUpdated() {
        stopDragging(this.draggedAnnotation, this.draggedAnnotationManager);
    }

    boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
        Annotation queryMapForFeatures;
        for (AnnotationManager annotationManager : this.annotationManagers) {
            if (moveGestureDetector.getPointersCount() == 1 && (queryMapForFeatures = annotationManager.queryMapForFeatures(moveGestureDetector.getFocalPoint())) != null && startDragging(queryMapForFeatures, annotationManager)) {
                return true;
            }
        }
        return false;
    }

    boolean onMove(MoveGestureDetector moveGestureDetector) {
        if (this.draggedAnnotation != null && (moveGestureDetector.getPointersCount() > 1 || !this.draggedAnnotation.isDraggable())) {
            stopDragging(this.draggedAnnotation, this.draggedAnnotationManager);
            return true;
        }
        if (this.draggedAnnotation != null) {
            MoveDistancesObject moveObject = moveGestureDetector.getMoveObject(0);
            PointF pointF = new PointF(moveObject.getCurrentX() - this.touchAreaShiftX, moveObject.getCurrentY() - this.touchAreaShiftY);
            if (pointF.x < 0.0f || pointF.y < 0.0f || pointF.x > this.touchAreaMaxX || pointF.y > this.touchAreaMaxY) {
                stopDragging(this.draggedAnnotation, this.draggedAnnotationManager);
                return true;
            }
            Geometry offsetGeometry = this.draggedAnnotation.getOffsetGeometry(this.mapboxMap.getProjection(), moveObject, this.touchAreaShiftX, this.touchAreaShiftY);
            if (offsetGeometry != null) {
                this.draggedAnnotation.setGeometry(offsetGeometry);
                this.draggedAnnotationManager.internalUpdateSource();
                Iterator it = this.draggedAnnotationManager.getDragListeners().iterator();
                while (it.hasNext()) {
                    ((OnAnnotationDragListener) it.next()).onAnnotationDrag(this.draggedAnnotation);
                }
                return true;
            }
        }
        return false;
    }

    void onMoveEnd() {
        stopDragging(this.draggedAnnotation, this.draggedAnnotationManager);
    }

    boolean startDragging(Annotation annotation, AnnotationManager annotationManager) {
        if (!annotation.isDraggable()) {
            return false;
        }
        Iterator it = annotationManager.getDragListeners().iterator();
        while (it.hasNext()) {
            ((OnAnnotationDragListener) it.next()).onAnnotationDragStarted(annotation);
        }
        this.draggedAnnotation = annotation;
        this.draggedAnnotationManager = annotationManager;
        return true;
    }

    void stopDragging(Annotation annotation, AnnotationManager annotationManager) {
        if (annotation != null && annotationManager != null) {
            Iterator it = annotationManager.getDragListeners().iterator();
            while (it.hasNext()) {
                ((OnAnnotationDragListener) it.next()).onAnnotationDragFinished(annotation);
            }
        }
        this.draggedAnnotation = null;
        this.draggedAnnotationManager = null;
    }

    private class AnnotationMoveGestureListener implements MoveGestureDetector.OnMoveGestureListener {
        private AnnotationMoveGestureListener() {
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            return DraggableAnnotationController.this.onMoveBegin(moveGestureDetector);
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            return DraggableAnnotationController.this.onMove(moveGestureDetector);
        }

        @Override // com.mapbox.android.gestures.MoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
            DraggableAnnotationController.this.onMoveEnd();
        }
    }
}