package com.mapbox.mapboxsdk.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.collection.LongSparseArray;
import com.mapbox.android.gestures.AndroidGesturesManager;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.exceptions.MapboxConfigurationException;
import com.mapbox.mapboxsdk.exceptions.MapboxLifecycleException;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.NativeMapView;
import com.mapbox.mapboxsdk.maps.renderer.MapRenderer;
import com.mapbox.mapboxsdk.maps.renderer.glsurfaceview.GLSurfaceViewMapRenderer;
import com.mapbox.mapboxsdk.maps.renderer.glsurfaceview.MapboxGLSurfaceView;
import com.mapbox.mapboxsdk.maps.renderer.textureview.TextureViewMapRenderer;
import com.mapbox.mapboxsdk.maps.widgets.CompassView;
import com.mapbox.mapboxsdk.net.ConnectivityReceiver;
import com.mapbox.mapboxsdk.storage.FileSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public class MapView extends FrameLayout implements NativeMapView.ViewCallback {
    private AttributionClickListener attributionClickListener;
    private final CameraChangeDispatcher cameraDispatcher;
    private CompassView compassView;
    private boolean created;
    private boolean destroyed;
    private final FocalPointInvalidator focalInvalidator;
    private PointF focalPoint;
    private final InitialRenderCallback initialRenderCallback;
    private boolean isStarted;
    private final MapCallback mapCallback;
    private final MapChangeReceiver mapChangeReceiver;
    private MapGestureDetector mapGestureDetector;
    private MapKeyListener mapKeyListener;
    private MapRenderer mapRenderer;
    private MapboxMap mapboxMap;
    MapboxMapOptions mapboxMapOptions;
    private NativeMap nativeMapView;
    private final List<View.OnTouchListener> onTouchListeners;
    private final GesturesManagerInteractionListener registerTouchListener;
    private View renderView;
    private Bundle savedInstanceState;

    public interface OnCameraDidChangeListener {
        void onCameraDidChange(boolean z);
    }

    public interface OnCameraIsChangingListener {
        void onCameraIsChanging();
    }

    public interface OnCameraWillChangeListener {
        void onCameraWillChange(boolean z);
    }

    public interface OnCanRemoveUnusedStyleImageListener {
        boolean onCanRemoveUnusedStyleImage(String str);
    }

    public interface OnDidBecomeIdleListener {
        void onDidBecomeIdle();
    }

    public interface OnDidFailLoadingMapListener {
        void onDidFailLoadingMap(String str);
    }

    public interface OnDidFinishLoadingMapListener {
        void onDidFinishLoadingMap();
    }

    public interface OnDidFinishLoadingStyleListener {
        void onDidFinishLoadingStyle();
    }

    public interface OnDidFinishRenderingFrameListener {
        void onDidFinishRenderingFrame(boolean z);
    }

    public interface OnDidFinishRenderingMapListener {
        void onDidFinishRenderingMap(boolean z);
    }

    public interface OnSourceChangedListener {
        void onSourceChangedListener(String str);
    }

    public interface OnStyleImageMissingListener {
        void onStyleImageMissing(String str);
    }

    public interface OnWillStartLoadingMapListener {
        void onWillStartLoadingMap();
    }

    public interface OnWillStartRenderingFrameListener {
        void onWillStartRenderingFrame();
    }

    public interface OnWillStartRenderingMapListener {
        void onWillStartRenderingMap();
    }

    public MapView(Context context) {
        super(context);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.onTouchListeners = new ArrayList();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        initialize(context, MapboxMapOptions.createFromAttributes(context));
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.onTouchListeners = new ArrayList();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        initialize(context, MapboxMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.onTouchListeners = new ArrayList();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        initialize(context, MapboxMapOptions.createFromAttributes(context, attributeSet));
    }

    public MapView(Context context, MapboxMapOptions mapboxMapOptions) {
        super(context);
        this.mapChangeReceiver = new MapChangeReceiver();
        this.mapCallback = new MapCallback();
        this.initialRenderCallback = new InitialRenderCallback();
        this.onTouchListeners = new ArrayList();
        this.focalInvalidator = new FocalPointInvalidator();
        this.registerTouchListener = new GesturesManagerInteractionListener();
        this.cameraDispatcher = new CameraChangeDispatcher();
        initialize(context, mapboxMapOptions == null ? MapboxMapOptions.createFromAttributes(context) : mapboxMapOptions);
    }

    protected void initialize(Context context, MapboxMapOptions mapboxMapOptions) {
        if (isInEditMode()) {
            return;
        }
        if (!Mapbox.hasInstance()) {
            throw new MapboxConfigurationException();
        }
        setForeground(new ColorDrawable(mapboxMapOptions.getForegroundLoadColor()));
        this.mapboxMapOptions = mapboxMapOptions;
        setContentDescription(context.getString(R.string.mapbox_mapActionDescription));
        setWillNotDraw(false);
        initialiseDrawingSurface(mapboxMapOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseMap() {
        Context context = getContext();
        this.focalInvalidator.addListener(createFocalPointChangeListener());
        Projection projection = new Projection(this.nativeMapView, this);
        UiSettings uiSettings = new UiSettings(projection, this.focalInvalidator, getPixelRatio(), this);
        LongSparseArray longSparseArray = new LongSparseArray();
        IconManager iconManager = new IconManager(this.nativeMapView);
        AnnotationManager annotationManager = new AnnotationManager(this, longSparseArray, iconManager, new AnnotationContainer(this.nativeMapView, longSparseArray), new MarkerContainer(this.nativeMapView, longSparseArray, iconManager), new PolygonContainer(this.nativeMapView, longSparseArray), new PolylineContainer(this.nativeMapView, longSparseArray), new ShapeAnnotationContainer(this.nativeMapView, longSparseArray));
        Transform transform = new Transform(this, this.nativeMapView, this.cameraDispatcher);
        ArrayList arrayList = new ArrayList();
        MapboxMap mapboxMap = new MapboxMap(this.nativeMapView, transform, uiSettings, projection, this.registerTouchListener, this.cameraDispatcher, arrayList);
        this.mapboxMap = mapboxMap;
        mapboxMap.injectAnnotationManager(annotationManager);
        this.mapGestureDetector = new MapGestureDetector(context, transform, projection, uiSettings, annotationManager, this.cameraDispatcher);
        this.mapKeyListener = new MapKeyListener(transform, uiSettings, this.mapGestureDetector);
        this.mapboxMap.injectLocationComponent(new LocationComponent(this.mapboxMap, transform, arrayList));
        setClickable(true);
        setLongClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestDisallowInterceptTouchEvent(true);
        this.nativeMapView.setReachability(Mapbox.isConnected().booleanValue());
        Bundle bundle = this.savedInstanceState;
        if (bundle == null) {
            this.mapboxMap.initialise(context, this.mapboxMapOptions);
        } else {
            this.mapboxMap.onRestoreInstanceState(bundle);
        }
        this.mapCallback.initialised();
    }

    protected CompassView initialiseCompassView() {
        CompassView compassView = new CompassView(getContext());
        this.compassView = compassView;
        addView(compassView);
        this.compassView.setTag("compassView");
        this.compassView.getLayoutParams().width = -2;
        this.compassView.getLayoutParams().height = -2;
        this.compassView.setContentDescription(getResources().getString(R.string.mapbox_compassContentDescription));
        this.compassView.injectCompassAnimationListener(createCompassAnimationListener(this.cameraDispatcher));
        this.compassView.setOnClickListener(createCompassClickListener(this.cameraDispatcher));
        return this.compassView;
    }

    protected ImageView initialiseAttributionView() {
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        imageView.setTag("attrView");
        imageView.getLayoutParams().width = -2;
        imageView.getLayoutParams().height = -2;
        imageView.setAdjustViewBounds(true);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(getResources().getString(R.string.mapbox_attributionsIconContentDescription));
        imageView.setImageDrawable(BitmapUtils.getDrawableFromRes(getContext(), R.drawable.mapbox_info_bg_selector));
        AttributionClickListener attributionClickListener = new AttributionClickListener(getContext(), this.mapboxMap);
        this.attributionClickListener = attributionClickListener;
        imageView.setOnClickListener(attributionClickListener);
        return imageView;
    }

    protected ImageView initialiseLogoView() {
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        imageView.setTag("logoView");
        imageView.getLayoutParams().width = -2;
        imageView.getLayoutParams().height = -2;
        imageView.setImageDrawable(BitmapUtils.getDrawableFromRes(getContext(), R.drawable.mapbox_logo_icon));
        return imageView;
    }

    private FocalPointChangeListener createFocalPointChangeListener() {
        return new FocalPointChangeListener() { // from class: com.mapbox.mapboxsdk.maps.MapView.1
            @Override // com.mapbox.mapboxsdk.maps.FocalPointChangeListener
            public void onFocalPointChanged(PointF pointF) {
                MapView.this.focalPoint = pointF;
            }
        };
    }

    private MapboxMap.OnCompassAnimationListener createCompassAnimationListener(final CameraChangeDispatcher cameraChangeDispatcher) {
        return new MapboxMap.OnCompassAnimationListener() { // from class: com.mapbox.mapboxsdk.maps.MapView.2
            @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCompassAnimationListener
            public void onCompassAnimation() {
                cameraChangeDispatcher.onCameraMove();
            }

            @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCompassAnimationListener
            public void onCompassAnimationFinished() {
                if (MapView.this.compassView != null) {
                    MapView.this.compassView.isAnimating(false);
                }
                cameraChangeDispatcher.onCameraIdle();
            }
        };
    }

    private View.OnClickListener createCompassClickListener(final CameraChangeDispatcher cameraChangeDispatcher) {
        return new View.OnClickListener() { // from class: com.mapbox.mapboxsdk.maps.MapView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MapView.this.mapboxMap == null || MapView.this.compassView == null) {
                    return;
                }
                if (MapView.this.focalPoint != null) {
                    MapView.this.mapboxMap.setFocalBearing(0.0d, MapView.this.focalPoint.x, MapView.this.focalPoint.y, 150L);
                } else {
                    MapView.this.mapboxMap.setFocalBearing(0.0d, MapView.this.mapboxMap.getWidth() / 2.0f, MapView.this.mapboxMap.getHeight() / 2.0f, 150L);
                }
                cameraChangeDispatcher.onCameraMoveStarted(3);
                MapView.this.compassView.isAnimating(true);
                MapView.this.compassView.postDelayed(MapView.this.compassView, 650L);
            }
        };
    }

    public void onCreate(Bundle bundle) {
        this.created = true;
        if (bundle == null) {
            TelemetryDefinition telemetry = Mapbox.getTelemetry();
            if (telemetry != null) {
                telemetry.onAppUserTurnstileEvent();
                return;
            }
            return;
        }
        if (bundle.getBoolean(MapboxConstants.STATE_HAS_SAVED_STATE)) {
            this.savedInstanceState = bundle;
        }
    }

    private void initialiseDrawingSurface(MapboxMapOptions mapboxMapOptions) {
        String localIdeographFontFamily = mapboxMapOptions.getLocalIdeographFontFamily();
        GlyphsRasterizationMode glyphsRasterizationMode = mapboxMapOptions.getGlyphsRasterizationMode();
        if (mapboxMapOptions.getTextureMode()) {
            TextureView textureView = new TextureView(getContext());
            this.mapRenderer = new TextureViewMapRenderer(getContext(), textureView, glyphsRasterizationMode, localIdeographFontFamily, mapboxMapOptions.getTranslucentTextureSurface()) { // from class: com.mapbox.mapboxsdk.maps.MapView.4
                @Override // com.mapbox.mapboxsdk.maps.renderer.textureview.TextureViewMapRenderer, com.mapbox.mapboxsdk.maps.renderer.MapRenderer
                protected void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    MapView.this.onSurfaceCreated();
                    super.onSurfaceCreated(gl10, eGLConfig);
                }
            };
            addView(textureView, 0);
            this.renderView = textureView;
        } else {
            MapboxGLSurfaceView mapboxGLSurfaceView = new MapboxGLSurfaceView(getContext());
            mapboxGLSurfaceView.setZOrderMediaOverlay(this.mapboxMapOptions.getRenderSurfaceOnTop());
            this.mapRenderer = new GLSurfaceViewMapRenderer(getContext(), mapboxGLSurfaceView, glyphsRasterizationMode, localIdeographFontFamily) { // from class: com.mapbox.mapboxsdk.maps.MapView.5
                @Override // com.mapbox.mapboxsdk.maps.renderer.glsurfaceview.GLSurfaceViewMapRenderer, com.mapbox.mapboxsdk.maps.renderer.MapRenderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    MapView.this.onSurfaceCreated();
                    super.onSurfaceCreated(gl10, eGLConfig);
                }
            };
            addView(mapboxGLSurfaceView, 0);
            this.renderView = mapboxGLSurfaceView;
        }
        this.nativeMapView = new NativeMapView(getContext(), getPixelRatio(), this.mapboxMapOptions.getCrossSourceCollisions(), this, this.mapChangeReceiver, this.mapRenderer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceCreated() {
        post(new Runnable() { // from class: com.mapbox.mapboxsdk.maps.MapView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MapView.this.destroyed || MapView.this.mapboxMap != null) {
                    return;
                }
                MapView.this.initialiseMap();
                MapView.this.mapboxMap.onStart();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.mapboxMap != null) {
            bundle.putBoolean(MapboxConstants.STATE_HAS_SAVED_STATE, true);
            this.mapboxMap.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        if (!this.created) {
            throw new MapboxLifecycleException();
        }
        if (!this.isStarted) {
            ConnectivityReceiver.instance(getContext()).activate();
            FileSource.getInstance(getContext()).activate();
            this.isStarted = true;
        }
        MapboxMap mapboxMap = this.mapboxMap;
        if (mapboxMap != null) {
            mapboxMap.onStart();
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onStart();
        }
    }

    public void onResume() {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onResume();
        }
    }

    public void onPause() {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onPause();
        }
    }

    public void onStop() {
        AttributionClickListener attributionClickListener = this.attributionClickListener;
        if (attributionClickListener != null) {
            attributionClickListener.onStop();
        }
        if (this.mapboxMap != null) {
            this.mapGestureDetector.cancelAnimators();
            this.mapboxMap.onStop();
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onStop();
        }
        if (this.isStarted) {
            ConnectivityReceiver.instance(getContext()).deactivate();
            FileSource.getInstance(getContext()).deactivate();
            this.isStarted = false;
        }
    }

    public void onDestroy() {
        this.destroyed = true;
        this.mapChangeReceiver.clear();
        this.mapCallback.onDestroy();
        this.initialRenderCallback.onDestroy();
        CompassView compassView = this.compassView;
        if (compassView != null) {
            compassView.resetAnimation();
        }
        MapboxMap mapboxMap = this.mapboxMap;
        if (mapboxMap != null) {
            mapboxMap.onDestroy();
        }
        NativeMap nativeMap = this.nativeMapView;
        if (nativeMap != null) {
            nativeMap.destroy();
            this.nativeMapView = null;
        }
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.onDestroy();
        }
        this.onTouchListeners.clear();
    }

    public void queueEvent(Runnable runnable) {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer == null) {
            throw new IllegalStateException("Calling MapView#queueEvent before mapRenderer is created.");
        }
        mapRenderer.queueEvent(runnable);
    }

    public void setMaximumFps(int i) {
        MapRenderer mapRenderer = this.mapRenderer;
        if (mapRenderer != null) {
            mapRenderer.setMaximumFps(i);
            return;
        }
        throw new IllegalStateException("Calling MapView#setMaximumFps before mapRenderer is created.");
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public View getRenderView() {
        return this.renderView;
    }

    public boolean addOnTouchListener(View.OnTouchListener onTouchListener) {
        return this.onTouchListeners.add(onTouchListener);
    }

    public boolean removeOnTouchListener(View.OnTouchListener onTouchListener) {
        return this.onTouchListeners.remove(onTouchListener);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((isGestureDetectorInitialized() && this.mapGestureDetector.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent)) {
            return true;
        }
        Iterator<View.OnTouchListener> it = this.onTouchListeners.iterator();
        while (it.hasNext()) {
            if (it.next().onTouch(this, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyLongPress(i, keyEvent) || super.onKeyLongPress(i, keyEvent);
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isKeyDetectorInitialized()) {
            return this.mapKeyListener.onTrackballEvent(motionEvent) || super.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isGestureDetectorInitialized()) {
            return this.mapGestureDetector.onGenericMotionEvent(motionEvent) || super.onGenericMotionEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onLowMemory() {
        NativeMap nativeMap = this.nativeMapView;
        if (nativeMap == null || this.mapboxMap == null || this.destroyed) {
            return;
        }
        nativeMap.onLowMemory();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        NativeMap nativeMap;
        if (isInEditMode() || (nativeMap = this.nativeMapView) == null) {
            return;
        }
        nativeMap.resizeView(i, i2);
    }

    public float getPixelRatio() {
        float pixelRatio = this.mapboxMapOptions.getPixelRatio();
        return pixelRatio == 0.0f ? getResources().getDisplayMetrics().density : pixelRatio;
    }

    @Override // com.mapbox.mapboxsdk.maps.NativeMapView.ViewCallback
    public Bitmap getViewContent() {
        return BitmapUtils.createBitmapFromView(this);
    }

    public void addOnCameraWillChangeListener(OnCameraWillChangeListener onCameraWillChangeListener) {
        this.mapChangeReceiver.addOnCameraWillChangeListener(onCameraWillChangeListener);
    }

    public void removeOnCameraWillChangeListener(OnCameraWillChangeListener onCameraWillChangeListener) {
        this.mapChangeReceiver.removeOnCameraWillChangeListener(onCameraWillChangeListener);
    }

    public void addOnCameraIsChangingListener(OnCameraIsChangingListener onCameraIsChangingListener) {
        this.mapChangeReceiver.addOnCameraIsChangingListener(onCameraIsChangingListener);
    }

    public void removeOnCameraIsChangingListener(OnCameraIsChangingListener onCameraIsChangingListener) {
        this.mapChangeReceiver.removeOnCameraIsChangingListener(onCameraIsChangingListener);
    }

    public void addOnCameraDidChangeListener(OnCameraDidChangeListener onCameraDidChangeListener) {
        this.mapChangeReceiver.addOnCameraDidChangeListener(onCameraDidChangeListener);
    }

    public void removeOnCameraDidChangeListener(OnCameraDidChangeListener onCameraDidChangeListener) {
        this.mapChangeReceiver.removeOnCameraDidChangeListener(onCameraDidChangeListener);
    }

    public void addOnWillStartLoadingMapListener(OnWillStartLoadingMapListener onWillStartLoadingMapListener) {
        this.mapChangeReceiver.addOnWillStartLoadingMapListener(onWillStartLoadingMapListener);
    }

    public void removeOnWillStartLoadingMapListener(OnWillStartLoadingMapListener onWillStartLoadingMapListener) {
        this.mapChangeReceiver.removeOnWillStartLoadingMapListener(onWillStartLoadingMapListener);
    }

    public void addOnDidFinishLoadingMapListener(OnDidFinishLoadingMapListener onDidFinishLoadingMapListener) {
        this.mapChangeReceiver.addOnDidFinishLoadingMapListener(onDidFinishLoadingMapListener);
    }

    public void removeOnDidFinishLoadingMapListener(OnDidFinishLoadingMapListener onDidFinishLoadingMapListener) {
        this.mapChangeReceiver.removeOnDidFinishLoadingMapListener(onDidFinishLoadingMapListener);
    }

    public void addOnDidFailLoadingMapListener(OnDidFailLoadingMapListener onDidFailLoadingMapListener) {
        this.mapChangeReceiver.addOnDidFailLoadingMapListener(onDidFailLoadingMapListener);
    }

    public void removeOnDidFailLoadingMapListener(OnDidFailLoadingMapListener onDidFailLoadingMapListener) {
        this.mapChangeReceiver.removeOnDidFailLoadingMapListener(onDidFailLoadingMapListener);
    }

    public void addOnWillStartRenderingFrameListener(OnWillStartRenderingFrameListener onWillStartRenderingFrameListener) {
        this.mapChangeReceiver.addOnWillStartRenderingFrameListener(onWillStartRenderingFrameListener);
    }

    public void removeOnWillStartRenderingFrameListener(OnWillStartRenderingFrameListener onWillStartRenderingFrameListener) {
        this.mapChangeReceiver.removeOnWillStartRenderingFrameListener(onWillStartRenderingFrameListener);
    }

    public void addOnDidFinishRenderingFrameListener(OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener) {
        this.mapChangeReceiver.addOnDidFinishRenderingFrameListener(onDidFinishRenderingFrameListener);
    }

    public void removeOnDidFinishRenderingFrameListener(OnDidFinishRenderingFrameListener onDidFinishRenderingFrameListener) {
        this.mapChangeReceiver.removeOnDidFinishRenderingFrameListener(onDidFinishRenderingFrameListener);
    }

    public void addOnWillStartRenderingMapListener(OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
        this.mapChangeReceiver.addOnWillStartRenderingMapListener(onWillStartRenderingMapListener);
    }

    public void removeOnWillStartRenderingMapListener(OnWillStartRenderingMapListener onWillStartRenderingMapListener) {
        this.mapChangeReceiver.removeOnWillStartRenderingMapListener(onWillStartRenderingMapListener);
    }

    public void addOnDidFinishRenderingMapListener(OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
        this.mapChangeReceiver.addOnDidFinishRenderingMapListener(onDidFinishRenderingMapListener);
    }

    public void removeOnDidFinishRenderingMapListener(OnDidFinishRenderingMapListener onDidFinishRenderingMapListener) {
        this.mapChangeReceiver.removeOnDidFinishRenderingMapListener(onDidFinishRenderingMapListener);
    }

    public void addOnDidBecomeIdleListener(OnDidBecomeIdleListener onDidBecomeIdleListener) {
        this.mapChangeReceiver.addOnDidBecomeIdleListener(onDidBecomeIdleListener);
    }

    public void removeOnDidBecomeIdleListener(OnDidBecomeIdleListener onDidBecomeIdleListener) {
        this.mapChangeReceiver.removeOnDidBecomeIdleListener(onDidBecomeIdleListener);
    }

    public void addOnDidFinishLoadingStyleListener(OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
        this.mapChangeReceiver.addOnDidFinishLoadingStyleListener(onDidFinishLoadingStyleListener);
    }

    public void removeOnDidFinishLoadingStyleListener(OnDidFinishLoadingStyleListener onDidFinishLoadingStyleListener) {
        this.mapChangeReceiver.removeOnDidFinishLoadingStyleListener(onDidFinishLoadingStyleListener);
    }

    public void addOnSourceChangedListener(OnSourceChangedListener onSourceChangedListener) {
        this.mapChangeReceiver.addOnSourceChangedListener(onSourceChangedListener);
    }

    public void removeOnSourceChangedListener(OnSourceChangedListener onSourceChangedListener) {
        this.mapChangeReceiver.removeOnSourceChangedListener(onSourceChangedListener);
    }

    public void addOnStyleImageMissingListener(OnStyleImageMissingListener onStyleImageMissingListener) {
        this.mapChangeReceiver.addOnStyleImageMissingListener(onStyleImageMissingListener);
    }

    public void removeOnStyleImageMissingListener(OnStyleImageMissingListener onStyleImageMissingListener) {
        this.mapChangeReceiver.removeOnStyleImageMissingListener(onStyleImageMissingListener);
    }

    public void addOnCanRemoveUnusedStyleImageListener(OnCanRemoveUnusedStyleImageListener onCanRemoveUnusedStyleImageListener) {
        this.mapChangeReceiver.addOnCanRemoveUnusedStyleImageListener(onCanRemoveUnusedStyleImageListener);
    }

    public void removeOnCanRemoveUnusedStyleImageListener(OnCanRemoveUnusedStyleImageListener onCanRemoveUnusedStyleImageListener) {
        this.mapChangeReceiver.removeOnCanRemoveUnusedStyleImageListener(onCanRemoveUnusedStyleImageListener);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        MapboxMap mapboxMap = this.mapboxMap;
        if (mapboxMap == null) {
            this.mapCallback.addOnMapReadyCallback(onMapReadyCallback);
        } else {
            onMapReadyCallback.onMapReady(mapboxMap);
        }
    }

    private boolean isGestureDetectorInitialized() {
        return this.mapGestureDetector != null;
    }

    private boolean isKeyDetectorInitialized() {
        return this.mapKeyListener != null;
    }

    MapboxMap getMapboxMap() {
        return this.mapboxMap;
    }

    void setMapboxMap(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
    }

    private class FocalPointInvalidator implements FocalPointChangeListener {
        private final List<FocalPointChangeListener> focalPointChangeListeners;

        private FocalPointInvalidator() {
            this.focalPointChangeListeners = new ArrayList();
        }

        void addListener(FocalPointChangeListener focalPointChangeListener) {
            this.focalPointChangeListeners.add(focalPointChangeListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.FocalPointChangeListener
        public void onFocalPointChanged(PointF pointF) {
            MapView.this.mapGestureDetector.setFocalPoint(pointF);
            Iterator<FocalPointChangeListener> it = this.focalPointChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onFocalPointChanged(pointF);
            }
        }
    }

    private class InitialRenderCallback implements OnDidFinishRenderingFrameListener {
        private int renderCount;

        InitialRenderCallback() {
            MapView.this.addOnDidFinishRenderingFrameListener(this);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishRenderingFrameListener
        public void onDidFinishRenderingFrame(boolean z) {
            if (MapView.this.mapboxMap == null || MapView.this.mapboxMap.getStyle() == null || !MapView.this.mapboxMap.getStyle().isFullyLoaded()) {
                return;
            }
            int i = this.renderCount + 1;
            this.renderCount = i;
            if (i == 3) {
                MapView.this.setForeground(null);
                MapView.this.removeOnDidFinishRenderingFrameListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDestroy() {
            MapView.this.removeOnDidFinishRenderingFrameListener(this);
        }
    }

    private class GesturesManagerInteractionListener implements MapboxMap.OnGesturesManagerInteractionListener {
        private GesturesManagerInteractionListener() {
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddMapClickListener(MapboxMap.OnMapClickListener onMapClickListener) {
            MapView.this.mapGestureDetector.addOnMapClickListener(onMapClickListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveMapClickListener(MapboxMap.OnMapClickListener onMapClickListener) {
            MapView.this.mapGestureDetector.removeOnMapClickListener(onMapClickListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddMapLongClickListener(MapboxMap.OnMapLongClickListener onMapLongClickListener) {
            MapView.this.mapGestureDetector.addOnMapLongClickListener(onMapLongClickListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveMapLongClickListener(MapboxMap.OnMapLongClickListener onMapLongClickListener) {
            MapView.this.mapGestureDetector.removeOnMapLongClickListener(onMapLongClickListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddFlingListener(MapboxMap.OnFlingListener onFlingListener) {
            MapView.this.mapGestureDetector.addOnFlingListener(onFlingListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveFlingListener(MapboxMap.OnFlingListener onFlingListener) {
            MapView.this.mapGestureDetector.removeOnFlingListener(onFlingListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddMoveListener(MapboxMap.OnMoveListener onMoveListener) {
            MapView.this.mapGestureDetector.addOnMoveListener(onMoveListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveMoveListener(MapboxMap.OnMoveListener onMoveListener) {
            MapView.this.mapGestureDetector.removeOnMoveListener(onMoveListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddRotateListener(MapboxMap.OnRotateListener onRotateListener) {
            MapView.this.mapGestureDetector.addOnRotateListener(onRotateListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveRotateListener(MapboxMap.OnRotateListener onRotateListener) {
            MapView.this.mapGestureDetector.removeOnRotateListener(onRotateListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddScaleListener(MapboxMap.OnScaleListener onScaleListener) {
            MapView.this.mapGestureDetector.addOnScaleListener(onScaleListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveScaleListener(MapboxMap.OnScaleListener onScaleListener) {
            MapView.this.mapGestureDetector.removeOnScaleListener(onScaleListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onAddShoveListener(MapboxMap.OnShoveListener onShoveListener) {
            MapView.this.mapGestureDetector.addShoveListener(onShoveListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void onRemoveShoveListener(MapboxMap.OnShoveListener onShoveListener) {
            MapView.this.mapGestureDetector.removeShoveListener(onShoveListener);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public AndroidGesturesManager getGesturesManager() {
            return MapView.this.mapGestureDetector.getGesturesManager();
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2) {
            MapView.this.mapGestureDetector.setGesturesManager(MapView.this.getContext(), androidGesturesManager, z, z2);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnGesturesManagerInteractionListener
        public void cancelAllVelocityAnimations() {
            MapView.this.mapGestureDetector.cancelAnimators();
        }
    }

    private class MapCallback implements OnDidFinishLoadingStyleListener, OnDidFinishRenderingFrameListener, OnDidFinishLoadingMapListener, OnCameraIsChangingListener, OnCameraDidChangeListener, OnDidFailLoadingMapListener {
        private final List<OnMapReadyCallback> onMapReadyCallbackList = new ArrayList();

        MapCallback() {
            MapView.this.addOnDidFinishLoadingStyleListener(this);
            MapView.this.addOnDidFinishRenderingFrameListener(this);
            MapView.this.addOnDidFinishLoadingMapListener(this);
            MapView.this.addOnCameraIsChangingListener(this);
            MapView.this.addOnCameraDidChangeListener(this);
            MapView.this.addOnDidFailLoadingMapListener(this);
        }

        void initialised() {
            MapView.this.mapboxMap.onPreMapReady();
            onMapReady();
            MapView.this.mapboxMap.onPostMapReady();
        }

        private void onMapReady() {
            if (this.onMapReadyCallbackList.size() > 0) {
                Iterator<OnMapReadyCallback> it = this.onMapReadyCallbackList.iterator();
                while (it.hasNext()) {
                    OnMapReadyCallback next = it.next();
                    if (next != null) {
                        next.onMapReady(MapView.this.mapboxMap);
                    }
                    it.remove();
                }
            }
        }

        void addOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback) {
            this.onMapReadyCallbackList.add(onMapReadyCallback);
        }

        void onDestroy() {
            this.onMapReadyCallbackList.clear();
            MapView.this.removeOnDidFinishLoadingStyleListener(this);
            MapView.this.removeOnDidFinishRenderingFrameListener(this);
            MapView.this.removeOnDidFinishLoadingMapListener(this);
            MapView.this.removeOnCameraIsChangingListener(this);
            MapView.this.removeOnCameraDidChangeListener(this);
            MapView.this.removeOnDidFailLoadingMapListener(this);
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishLoadingStyleListener
        public void onDidFinishLoadingStyle() {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onFinishLoadingStyle();
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFailLoadingMapListener
        public void onDidFailLoadingMap(String str) {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onFailLoadingStyle();
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishRenderingFrameListener
        public void onDidFinishRenderingFrame(boolean z) {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onUpdateFullyRendered();
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishLoadingMapListener
        public void onDidFinishLoadingMap() {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onUpdateRegionChange();
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraIsChangingListener
        public void onCameraIsChanging() {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onUpdateRegionChange();
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
        public void onCameraDidChange(boolean z) {
            if (MapView.this.mapboxMap != null) {
                MapView.this.mapboxMap.onUpdateRegionChange();
            }
        }
    }

    private static class AttributionClickListener implements View.OnClickListener {
        private final AttributionDialogManager defaultDialogManager;
        private UiSettings uiSettings;

        private AttributionClickListener(Context context, MapboxMap mapboxMap) {
            this.defaultDialogManager = new AttributionDialogManager(context, mapboxMap);
            this.uiSettings = mapboxMap.getUiSettings();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            getDialogManager().onClick(view);
        }

        public void onStop() {
            getDialogManager().onStop();
        }

        private AttributionDialogManager getDialogManager() {
            if (this.uiSettings.getAttributionDialogManager() != null) {
                return this.uiSettings.getAttributionDialogManager();
            }
            return this.defaultDialogManager;
        }
    }

    public static void setMapStrictModeEnabled(boolean z) {
        MapStrictMode.setStrictModeEnabled(z);
    }
}
