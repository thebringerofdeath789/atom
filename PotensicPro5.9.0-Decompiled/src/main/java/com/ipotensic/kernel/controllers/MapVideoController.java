package com.ipotensic.kernel.controllers;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.guide.listener.AnimationListenerAdapter;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.controllers.PreviewController;
import com.ipotensic.kernel.enums.Mode;
import com.ipotensic.kernel.maps.BaseMap;
import com.ipotensic.kernel.maps.MapManager;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.services.OnLocationChangedListener;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.WindUtil;
import com.ipotensic.kernel.view.TwoFingerScaleView;
import com.ipotensic.kernel.view.attitude.AttitudeBallView;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.opengl.JfGLSurfaceView;
import com.logan.usb.AOAEngine;
import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes2.dex */
public class MapVideoController extends BaseController implements OnLocationChangedListener, AOAEngine.IEngineCallback {
    private static final String TAG = "MapVideoController";
    private AttitudeBallView attitudeBallView;
    private BaseMap baseMap;
    private Rect bigBounds;
    private ConstraintLayout.LayoutParams bigLayoutParams;
    private BlurTransController blurTransController;
    private ConstraintLayout crossLineController;
    private Mode curMode;
    private final float defaultZoom;
    private ImageView directViewIndicator;
    private Point endOffset;
    private ConstraintLayout flightRecordView;
    private boolean isAnimating;
    private boolean isWaypointEnterMap;
    private ImageView ivScale;
    private int lastValue;
    private View lastVisibleView;
    private RelativeLayout layoutScale;
    private TestLocationController locationController;
    private MapVideoControllerListener mMapVideoControllerListener;
    private ConstraintLayout mapBtnView;
    private RoundRelativeLayout mapContainer;
    private GeneralDialog mapGuideDialog;
    private MapManager mapManager;
    private View mapView;
    private PreviewController previewController;
    private RecyclerView recyclerView;
    private MapScaleView scaleView;
    private Rect smallBounds;
    private ConstraintLayout.LayoutParams smallLayoutParams;
    private View splashView;
    private Point startOffset;
    private TwoFingerScaleView twoFingerScaleView;
    private ImageView videoBg;
    private RoundRelativeLayout videoContainer;
    private JfGLSurfaceView videoView;
    private GeneralDialog waypointFlightGuideDialog;

    public interface MapVideoControllerListener {
        void lowPower();

        void onGpsMode();

        void onSwitch(Mode mode);
    }

    private void onFlightOrientationChanged(float f) {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onGpsSystemClose() {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onGpsSystemOpen() {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onPhoneOrientationChanged(float f) {
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnectError() {
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnected() {
    }

    public MapVideoController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.curMode = Mode.MODE_VIDEO;
        this.startOffset = null;
        this.endOffset = null;
        this.smallBounds = null;
        this.bigBounds = null;
        this.smallLayoutParams = null;
        this.bigLayoutParams = null;
        this.isWaypointEnterMap = false;
        this.isAnimating = false;
        this.defaultZoom = 15.0f;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.curMode = Mode.MODE_VIDEO;
        this.videoContainer = (RoundRelativeLayout) view.findViewById(R.id.video_container);
        this.crossLineController = (ConstraintLayout) view.findViewById(R.id.rl_cross_line_container);
        this.videoContainer.setCornerRadius(35);
        this.ivScale = (ImageView) view.findViewById(R.id.iv_scale);
        this.layoutScale = (RelativeLayout) view.findViewById(R.id.layout_scale);
        this.twoFingerScaleView = (TwoFingerScaleView) view.findViewById(R.id.two_finger_scale_view);
        this.splashView = view.findViewById(R.id.view_splash);
        this.blurTransController = new BlurTransController(getContext(), view.findViewById(R.id.layout_blur));
        this.locationController = new TestLocationController(getContext(), view);
        this.videoContainer.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MapVideoController.this.curMode == Mode.MODE_VIDEO || MapVideoController.this.attitudeBallView.getVisibility() != 8) {
                    return;
                }
                MapVideoController.this.zoomToBigNoAnimation(Mode.MODE_VIDEO);
            }
        });
        this.videoContainer.setRoundMode(0);
        this.mapBtnView = (ConstraintLayout) view.findViewById(R.id.view_map_control);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.scaleView = (MapScaleView) view.findViewById(R.id.scaleView);
        this.flightRecordView = (ConstraintLayout) view.findViewById(R.id.view_flight_record_details);
        JfGLSurfaceView jfGLSurfaceView = (JfGLSurfaceView) view.findViewById(R.id.view_video);
        this.videoView = jfGLSurfaceView;
        jfGLSurfaceView.setYuvFrameReceiver(new JfGLSurfaceView.onYuvFrameReceiver() { // from class: com.ipotensic.kernel.controllers.MapVideoController.2
            @Override // com.logan.opengl.JfGLSurfaceView.onYuvFrameReceiver
            public void receiveYuv() {
                if (MapVideoController.this.videoBg == null || MapVideoController.this.videoBg.getVisibility() != 0) {
                    return;
                }
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.MapVideoController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MapVideoController.this.videoBg.setVisibility(8);
                    }
                });
            }
        });
        AttitudeBallView attitudeBallView = (AttitudeBallView) view.findViewById(R.id.attitude_view);
        this.attitudeBallView = attitudeBallView;
        attitudeBallView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MapVideoController.this.setAttitudeBallUI(false);
            }
        });
        this.previewController = new PreviewController(this.videoView);
        this.videoBg = (ImageView) view.findViewById(R.id.iv_main_bg);
        addMapView();
        LocationService.getInstance().setOnLocationChangedListener(this);
        DDLog.w("videoBg:" + this.videoBg.getVisibility());
        AOAEngine.getInstance().addConnectListener(this);
    }

    public AttitudeBallView getAttitudeBallView() {
        return this.attitudeBallView;
    }

    public ImageView getAttitudeBallVIndicator() {
        return this.directViewIndicator;
    }

    public View getSplashView() {
        return this.splashView;
    }

    public boolean isMapMode() {
        return this.curMode == Mode.MODE_MAP;
    }

    public boolean isVideoMode() {
        return this.curMode == Mode.MODE_VIDEO;
    }

    private void animToBig(final View view, final Animation.AnimationListener animationListener) {
        try {
            this.isAnimating = true;
            animationListener.onAnimationStart(null);
            JfGLSurfaceView jfGLSurfaceView = this.videoView;
            if (jfGLSurfaceView != null) {
                jfGLSurfaceView.setAnimating(true);
            }
            final ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.kernel_map_left_margin);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.kernel_map_bottom_margin);
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            final int i = layoutParams.leftMargin;
            final int i2 = layoutParams.bottomMargin;
            TypedValue typedValue = new TypedValue();
            getContext().getResources().getValue(R.dimen.kernel_map_height_percent, typedValue, true);
            final int i3 = ((int) (typedValue.getFloat() * 1000)) + 1;
            final int width = this.smallBounds.width();
            final int width2 = this.bigBounds.width();
            this.smallBounds.height();
            this.bigBounds.height();
            ValueAnimator ofInt = ValueAnimator.ofInt(i3, 1000);
            final int i4 = 1000;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    System.currentTimeMillis();
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (intValue == MapVideoController.this.lastValue) {
                        return;
                    }
                    MapVideoController.this.lastValue = intValue;
                    int i5 = i3;
                    float f = (intValue - i5) / (r2 - i5);
                    float f2 = intValue / i4;
                    int i6 = width;
                    layoutParams.matchConstraintPercentWidth = (i6 + ((r4 - i6) * f)) / width2;
                    layoutParams.matchConstraintPercentHeight = f2;
                    ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                    int i7 = i;
                    layoutParams2.leftMargin = (int) (i7 - (i7 * f));
                    ConstraintLayout.LayoutParams layoutParams3 = layoutParams;
                    int i8 = i2;
                    layoutParams3.bottomMargin = (int) (i8 - (i8 * f));
                    if (intValue == i4) {
                        if (MapVideoController.this.videoView != null) {
                            MapVideoController.this.videoView.setAnimating(false);
                        }
                        view.setLayoutParams(MapVideoController.this.bigLayoutParams);
                        try {
                            animationListener.onAnimationEnd(null);
                        } catch (Exception unused) {
                        }
                        MapVideoController.this.isAnimating = false;
                        return;
                    }
                    view.setLayoutParams(layoutParams);
                }
            });
            ofInt.setDuration(280L);
            ofInt.start();
        } catch (Exception e) {
            DDLog.e("缩放动画出错:" + e.getMessage());
            this.isAnimating = false;
            JfGLSurfaceView jfGLSurfaceView2 = this.videoView;
            if (jfGLSurfaceView2 != null) {
                jfGLSurfaceView2.setAnimating(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animEnd(Mode mode) {
        this.curMode = mode;
        this.blurTransController.onMapVideoChanged();
        this.mapManager.setCurMapMode(mode);
        addDirectIndicateView();
        this.baseMap.setZoomScale(15.0f);
        if (SPHelper.getInstance().getFirstEnterMap() && FlightConfig.isConnectFlight() && isMapMode()) {
            GeneralDialog generalDialog = new GeneralDialog(getContext(), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.5
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                    SPHelper.getInstance().setFirstEnterMap(false);
                    MapVideoController.this.showWayPointGuide();
                }
            });
            this.mapGuideDialog = generalDialog;
            generalDialog.show();
            return;
        }
        showWayPointGuide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zoomToBigNoAnimation(final Mode mode) {
        if (this.isAnimating) {
            return;
        }
        checkConfig();
        EventDispatcher.get().sendEvent(EventID.EVENT_MAP_VIDEO_MODE_CHANGED, mode);
        if (mode == Mode.MODE_VIDEO) {
            DDLog.w("切换video 大图模式");
            animToBig(this.videoContainer, new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.MapVideoController.6
                @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Bitmap bitmap = MapVideoController.this.videoView.getBitmap();
                    if (bitmap != null) {
                        MapVideoController.this.ivScale.setImageBitmap(bitmap);
                        MapVideoController.this.layoutScale.setVisibility(0);
                    }
                    MapVideoController.this.mapBtnView.setVisibility(8);
                    MapVideoController.this.recyclerView.setVisibility(8);
                    MapVideoController.this.flightRecordView.setVisibility(8);
                    MapVideoController.this.scaleView.setVisibility(8);
                    MapVideoController.this.mMapVideoControllerListener.onSwitch(mode);
                    try {
                        if (MapVideoController.this.directViewIndicator != null) {
                            MapVideoController.this.videoContainer.removeView(MapVideoController.this.directViewIndicator);
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DDLog.e("JfRender anim end");
                    PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.MapVideoController.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MapVideoController.this.layoutScale.setVisibility(8);
                        }
                    }, 50L);
                    MapVideoController.this.twoFingerScaleView.setVisibility(0);
                    MapVideoController.this.baseMap.setZoomScale(15.0f);
                    MapVideoController.this.videoContainer.setRoundMode(0);
                    MapVideoController.this.crossLineController.bringToFront();
                    MapVideoController.this.mapContainer.setRoundMode(1);
                    MapVideoController.this.mapContainer.setLayoutParams(MapVideoController.this.smallLayoutParams);
                    MapVideoController.this.mapContainer.bringToFront();
                    MapVideoController.this.locationController.bringToFront();
                    MapVideoController.this.animEnd(mode);
                }
            });
        } else {
            DDLog.w("切换map 大图模式");
            animToBig(this.mapContainer, new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.MapVideoController.7
                @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    super.onAnimationStart(animation);
                    try {
                        if (MapVideoController.this.directViewIndicator != null) {
                            MapVideoController.this.mapContainer.removeView(MapVideoController.this.directViewIndicator);
                        }
                    } catch (Exception unused) {
                    }
                    MapVideoController.this.mMapVideoControllerListener.onSwitch(mode);
                    MapVideoController.this.mapManager.getMap().onPause();
                }

                @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MapVideoController.this.mapContainer.setRoundMode(0);
                    MapVideoController.this.videoContainer.setRoundMode(1);
                    MapVideoController.this.videoContainer.setLayoutParams(MapVideoController.this.smallLayoutParams);
                    MapVideoController.this.mapBtnView.setVisibility(0);
                    MapVideoController.this.scaleView.setVisibility(0);
                    MapVideoController.this.twoFingerScaleView.setVisibility(8);
                    MapVideoController.this.videoContainer.bringToFront();
                    MapVideoController.this.mapBtnView.bringToFront();
                    MapVideoController.this.scaleView.bringToFront();
                    MapVideoController.this.locationController.bringToFront();
                    MapVideoController.this.animEnd(mode);
                    MapVideoController.this.mapManager.getMap().onResume();
                    PermissionUtil.requestLocationPermissionAndGpsEnable((BaseActivity) MapVideoController.this.getContext(), new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.MapVideoController.7.1
                        @Override // com.ipotensic.baselib.listener.SimpleResultListener
                        public void onResult(Boolean bool) {
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkConfig() {
        if (this.smallBounds == null || this.startOffset == null || this.bigBounds == null || this.endOffset == null) {
            this.smallBounds = new Rect();
            Point point = new Point();
            this.startOffset = point;
            this.mapContainer.getGlobalVisibleRect(this.smallBounds, point);
            this.bigBounds = new Rect();
            Point point2 = new Point();
            this.endOffset = point2;
            this.videoContainer.getGlobalVisibleRect(this.bigBounds, point2);
            this.smallBounds.offset(-this.endOffset.x, -this.endOffset.y);
            this.bigBounds.offset(-this.endOffset.x, -this.endOffset.y);
            this.smallLayoutParams = (ConstraintLayout.LayoutParams) this.mapContainer.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            this.bigLayoutParams = layoutParams;
            layoutParams.leftToLeft = 0;
            this.bigLayoutParams.rightToRight = 0;
            this.bigLayoutParams.topToTop = 0;
            this.bigLayoutParams.bottomToBottom = 0;
            PhoneConfig.smallViewRect = this.smallBounds;
        }
    }

    private void addMapView() {
        MapManager mapManager = new MapManager();
        this.mapManager = mapManager;
        mapManager.setMapClickedListener(new MapManager.MapClickedListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.8
            @Override // com.ipotensic.kernel.maps.MapManager.MapClickedListener
            public void onMapClicked() {
                if (MapVideoController.this.curMode == Mode.MODE_MAP || MapVideoController.this.attitudeBallView.getVisibility() != 8) {
                    if (MapVideoController.this.recyclerView.getVisibility() == 0) {
                        AnimationUtil.transOutTop(MapVideoController.this.recyclerView);
                        AnimationUtil.transInRight(MapVideoController.this.mapBtnView);
                        return;
                    } else if (MapVideoController.this.flightRecordView.getVisibility() == 0) {
                        AnimationUtil.transOutTop(MapVideoController.this.flightRecordView);
                        AnimationUtil.transInRight(MapVideoController.this.mapBtnView);
                        return;
                    } else {
                        if (MapVideoController.this.mapManager.isEnableMark()) {
                            MapVideoController.this.baseMap.drawPoint();
                            return;
                        }
                        return;
                    }
                }
                MapVideoController.this.zoomToBigNoAnimation(Mode.MODE_MAP);
            }

            @Override // com.ipotensic.kernel.maps.MapManager.MapClickedListener
            public void noGpsMode() {
                if (MapVideoController.this.mMapVideoControllerListener != null) {
                    MapVideoController.this.mMapVideoControllerListener.onGpsMode();
                }
            }

            @Override // com.ipotensic.kernel.maps.MapManager.MapClickedListener
            public void lowPower() {
                if (MapVideoController.this.mMapVideoControllerListener != null) {
                    MapVideoController.this.mMapVideoControllerListener.lowPower();
                }
            }
        });
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) getBaseView().findViewById(R.id.map_container);
        this.mapContainer = roundRelativeLayout;
        roundRelativeLayout.setCornerRadius(35);
        View map = this.mapManager.setMap(getContext());
        this.mapView = map;
        this.mapContainer.addView(map);
        this.mapManager.setMapBtnView(this.mapBtnView, this.recyclerView, this.flightRecordView, this.scaleView);
        this.baseMap = this.mapManager.getMap();
        if (this.mapView != null) {
            this.mapContainer.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.MapVideoController.9
                @Override // java.lang.Runnable
                public void run() {
                    MapVideoController.this.checkConfig();
                }
            }, 100L);
            addDirectIndicateView();
        }
    }

    public RoundRelativeLayout getMapView() {
        return this.mapContainer;
    }

    public void setSmallViewGone() {
        RoundRelativeLayout roundRelativeLayout = this.mapContainer;
        if (roundRelativeLayout == null || this.attitudeBallView == null) {
            return;
        }
        if (roundRelativeLayout.getVisibility() == 0) {
            this.mapContainer.setVisibility(8);
            this.lastVisibleView = this.mapContainer;
        } else if (this.attitudeBallView.getVisibility() == 0) {
            this.attitudeBallView.setVisibility(8);
            this.lastVisibleView = this.attitudeBallView;
        }
    }

    public void setSmallViewVisible() {
        View view = this.lastVisibleView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttitudeBallUI(boolean z) {
        if (z) {
            if (this.curMode == Mode.MODE_VIDEO) {
                this.mapContainer.setVisibility(4);
            } else {
                setSurfaceViewVisible(false);
                this.videoBg.setVisibility(8);
                DDLog.w("videoBg:" + this.videoBg.getVisibility());
                this.videoContainer.setVisibility(4);
            }
            this.attitudeBallView.setVisibility(0);
            this.attitudeBallView.bringToFront();
            return;
        }
        if (this.curMode == Mode.MODE_VIDEO) {
            this.mapContainer.setVisibility(0);
        } else {
            DDLog.w("videoBg:" + this.videoBg.getVisibility());
            setSurfaceViewVisible(true);
            this.videoContainer.setVisibility(0);
        }
        this.attitudeBallView.setVisibility(8);
    }

    private void addDirectIndicateView() {
        if (this.directViewIndicator == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            ImageView imageView = new ImageView(getContext());
            this.directViewIndicator = imageView;
            imageView.setImageResource(R.mipmap.img_direct_view_indicate);
            this.directViewIndicator.setPadding(UnitUtil.dp2px(10), 0, 0, UnitUtil.dp2px(10));
            this.directViewIndicator.setLayoutParams(layoutParams);
            this.directViewIndicator.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.MapVideoController.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MapVideoController.this.directViewIndicator.clearAnimation();
                    MapVideoController.this.setAttitudeBallUI(true);
                }
            });
        }
        try {
            if (this.curMode == Mode.MODE_VIDEO) {
                try {
                    this.videoContainer.removeView(this.directViewIndicator);
                } catch (Exception unused) {
                }
                this.mapContainer.addView(this.directViewIndicator);
            } else {
                try {
                    this.mapContainer.removeView(this.directViewIndicator);
                } catch (Exception unused2) {
                }
                this.videoContainer.addView(this.directViewIndicator);
            }
        } catch (Exception unused3) {
        }
    }

    private void setSurfaceViewVisible(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        DDLog.w("setSurfaceViewVisible");
        if (z) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DDLog.w("videoBg surface gone:false");
        } else {
            layoutParams = new RelativeLayout.LayoutParams(1, 1);
            DDLog.w("videoBg surface gone:true");
        }
        this.videoView.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onCreate(bundle);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onResume() {
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onResume();
        }
        this.previewController.onResume();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onPause() {
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onPause();
        }
        this.previewController.onPause();
    }

    public void stopPlay() {
        PreviewController previewController = this.previewController;
        if (previewController != null) {
            previewController.stopPlay();
        }
    }

    public void onLowMemory() {
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onLowMemory();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onSaveInstanceState(bundle);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        AOAEngine.getInstance().removeListener(this);
        this.previewController.stopPlay();
        this.previewController.releasePlayer();
        this.previewController.onDestroy();
        this.attitudeBallView.deInit();
        BaseMap baseMap = this.baseMap;
        if (baseMap != null) {
            baseMap.onDestroy();
        }
        LocationService.getInstance().setOnLocationChangedListener(null);
    }

    public void setOnMapVideoControllerListener(MapVideoControllerListener mapVideoControllerListener) {
        this.mMapVideoControllerListener = mapVideoControllerListener;
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryDisconnected() {
        setBackground(false);
    }

    public void setGoBtnCancelVisible(boolean z) {
        this.mapManager.onGoBtnCancel(z);
    }

    public void mapBtnShow(boolean z, boolean z2) {
        if (z) {
            if (this.curMode == Mode.MODE_VIDEO) {
                this.mapView.setVisibility(0);
            } else {
                DDLog.w("videoBg:" + this.videoBg.getVisibility());
                setSurfaceViewVisible(true);
            }
            ImageView imageView = this.directViewIndicator;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            AttitudeBallView attitudeBallView = this.attitudeBallView;
            if (attitudeBallView != null) {
                attitudeBallView.setVisibility(8);
            }
        }
        if (z) {
            this.isWaypointEnterMap = true;
            setAttitudeBallUI(false);
            if (!FlightConfig.enterPointFly) {
                zoomToBigNoAnimation(Mode.MODE_MAP);
            } else {
                showWayPointGuide();
            }
        }
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.setMapBtnVisible(z, z2);
        }
    }

    public void showWayPointFlyBtn(Boolean bool) {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.showWayPointFlyBtn(bool);
        }
    }

    public void showMyLocation() {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.showMyLocation();
        }
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onBDLocationChanged(double d, double d2, float f) {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.onLocationChanged(d, d2);
        }
        TestLocationController testLocationController = this.locationController;
        if (testLocationController != null) {
            testLocationController.onBDLocationChanged(d, d2, f);
        }
        if (TextUtils.isEmpty(SPHelper.getInstance().getCountryCode())) {
            LocationService.getInstance().getCountryCode();
        }
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSystemLocationChanged(double d, double d2, float f) {
        MapManager mapManager;
        if (PhoneConfig.PACK_TYPE == PackageType.TYPE_LOCATION && (mapManager = this.mapManager) != null) {
            mapManager.onSystemLocationChanged(d, d2);
        }
        TestLocationController testLocationController = this.locationController;
        if (testLocationController != null) {
            testLocationController.onSystemLocationChanged(d, d2, f);
        }
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSatelliteCount(int i) {
        TestLocationController testLocationController = this.locationController;
        if (testLocationController != null) {
            testLocationController.onSatelliteCount(i);
        }
    }

    public void setBackground(boolean z) {
        if (this.attitudeBallView.getVisibility() == 0) {
            this.videoBg.setVisibility(8);
        }
        DDLog.w("videoBg:" + this.videoBg.getVisibility() + ", isConnect: " + z);
    }

    public void captureFrame(PreviewController.onFrameCaptureListener onframecapturelistener) {
        this.previewController.captureFrame(onframecapturelistener);
    }

    public void setMapScaleViewUnitType() {
        MapScaleView mapScaleView = this.scaleView;
        if (mapScaleView != null) {
            mapScaleView.setUnitType();
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.MapVideoController$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_HOME_LAT_LNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_DEVICE_ROTATE_CHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_WAYPOINT_CONTROL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EXIT_QUICK_SHOT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        FlightRevHomePointData flightRevHomePointData;
        super.onEvent(eventID, event);
        switch (AnonymousClass11.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                boolean booleanValue = ((Boolean) event.obj).booleanValue();
                if (!booleanValue) {
                    GeneralDialog generalDialog = this.mapGuideDialog;
                    if (generalDialog != null && generalDialog.isShowing()) {
                        this.mapGuideDialog.dismiss();
                        this.mapGuideDialog = null;
                    }
                    GeneralDialog generalDialog2 = this.waypointFlightGuideDialog;
                    if (generalDialog2 != null && generalDialog2.isShowing()) {
                        this.waypointFlightGuideDialog.dismiss();
                        this.waypointFlightGuideDialog = null;
                    }
                }
                showWayPointFlyBtn(Boolean.valueOf(booleanValue));
                AttitudeBallView attitudeBallView = this.attitudeBallView;
                if (attitudeBallView != null) {
                    attitudeBallView.setConnect(booleanValue);
                    this.attitudeBallView.setConnected(booleanValue);
                    break;
                }
                break;
            case 2:
                AttitudeBallView attitudeBallView2 = this.attitudeBallView;
                if (attitudeBallView2 != null) {
                    attitudeBallView2.setConnect(FlightConfig.isConnectFlight());
                    FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
                    if (flightRevFlightInfoData != null) {
                        this.attitudeBallView.setYawPitch((int) flightRevFlightInfoData.getAngleOfPitch());
                        this.attitudeBallView.setRotate((int) flightRevFlightInfoData.getAngleOfRoll());
                        this.attitudeBallView.setAngleToNorth(flightRevFlightInfoData.getDirectToNorth());
                        this.attitudeBallView.setRemoterAngel((int) LocationService.getInstance().getRotate());
                        double lat = FlightConfig.GPS.getLat();
                        double lng = FlightConfig.GPS.getLng();
                        if (lat != 0.0d && lng != 0.0d) {
                            this.attitudeBallView.setRemoterLatLng(new LatLng(lat, lng));
                        }
                    }
                    if (flightRevFlightInfoData != null) {
                        if (flightRevFlightInfoData.getLat() != 0.0d || flightRevFlightInfoData.getLng() != 0.0d) {
                            this.attitudeBallView.setFlightLatLng(new LatLng(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng()));
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (this.attitudeBallView != null && (flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData()) != null) {
                    if (flightRevHomePointData.getLat() != 0.0d || flightRevHomePointData.getLng() != 0.0d) {
                        this.attitudeBallView.setHomeLatLng(new LatLng(flightRevHomePointData.getLat(), flightRevHomePointData.getLng()));
                        break;
                    }
                }
                break;
            case 4:
                float floatValue = ((Float) event.obj).floatValue();
                AttitudeBallView attitudeBallView3 = this.attitudeBallView;
                if (attitudeBallView3 != null) {
                    attitudeBallView3.setRemoterAngel((int) (floatValue % 360.0f));
                    break;
                }
                break;
            case 5:
                FlightRevFlightInfoData flightRevFlightInfoData2 = (FlightRevFlightInfoData) event.obj;
                if (flightRevFlightInfoData2 != null) {
                    this.attitudeBallView.setWindSpeedAndDirection(WindUtil.windGrade(flightRevFlightInfoData2.getWindSpeed()), (float) flightRevFlightInfoData2.getWindDirection());
                    break;
                }
                break;
            case 6:
                DDLog.d(TAG, "onEvent id is FLIGHT_WAYPOINT_CONTROL");
                boolean booleanValue2 = ((Boolean) event.obj).booleanValue();
                mapBtnShow(booleanValue2, !booleanValue2);
                break;
            case 7:
                DDLog.d(TAG, "onEvent id is EXIT_QUICK_SHOT");
                RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
                if (rightController != null) {
                    rightController.exitQuickShot(null);
                    break;
                }
                break;
        }
    }

    public void exitWayPointFlightConditions(FlightRevStateData flightRevStateData) {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.exitWayPointFlightConditions(flightRevStateData);
        }
    }

    public void setExitWayPointFlight() {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            mapManager.setExitWayPointFlight(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWayPointGuide() {
        if (SPHelper.getInstance().getEnterMapOfWaypoint() && this.isWaypointEnterMap && isMapMode()) {
            SPHelper.getInstance().setEnterMapOfWaypoint(false);
            GeneralDialog generalDialog = new GeneralDialog(getContext(), FlightConfig.isAtomPanTilt() ? R.raw.waypoint_guide_atom : R.raw.waypoint_guide);
            this.waypointFlightGuideDialog = generalDialog;
            generalDialog.show();
        }
    }
}
