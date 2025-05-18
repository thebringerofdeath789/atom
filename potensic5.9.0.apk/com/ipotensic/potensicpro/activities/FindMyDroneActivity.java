package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.services.OnLocationChangedListener;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.databinding.ActivityFindMyDroneBinding;
import com.ipotensic.potensicpro.viewmodel.FindDroneViewModel;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.data.WifiSignalData;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.enums.CommonMsgType;
import com.mapbox.android.core.BuildConfig;
import com.mapbox.android.gestures.StandardScaleGestureDetector;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.maps.UiSettings;
import com.mapbox.mapboxsdk.plugins.annotation.CircleManager;
import com.mapbox.mapboxsdk.plugins.annotation.LineManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.localization.LocalizationPlugin;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import java.util.Objects;

/* loaded from: classes2.dex */
public class FindMyDroneActivity extends BaseActivity implements View.OnClickListener, EventDispatcher.OnEventListener, OnLocationChangedListener, OnNetworkChangeListener {
    private static final String TAG = "FindMyDroneActivity";

    /* renamed from: NA */
    private String f2367NA;
    private ActivityFindMyDroneBinding binding;
    private ImageButton btnMapSatellite;
    private ImageButton btnMapShow;
    private CameraPosition.Builder builder;
    private ImageView ivMapLock;
    private ImageView ivMapSetHide;
    private ImageButton ivSatelliteMode;
    private ImageButton ivStandardMode;
    private ImageButton ivStandardNightMode;
    private ImageView ivWifi;
    private float mAngle;
    private MapboxMap map;
    private FindDroneViewModel model;
    private float planeWidth;
    protected float rotate;
    private AnimationDrawable speakerAnimDrawable;
    private Style style;
    private float textBgWidth;
    private TextView tvGps;
    private TextView tvRemainBattery;
    private GeneralDialog unLockDialog;
    private View viewMapPosition;
    private View viewMapSet;
    private View viewMapType;
    private long lastTime = 0;
    private final int TIME_SENSOR = 100;
    private float zoom = 16.0f;
    private int level = 0;
    private boolean isStartRotate = false;
    private String curStyle = Style.SATELLITE;
    private Style.OnStyleLoaded styleLoadedListener = new Style.OnStyleLoaded() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.5
        @Override // com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            FindMyDroneActivity.this.model.deleteStyle();
            FindMyDroneActivity.this.initMapStyle(style);
        }
    };
    private MapboxMap.OnScaleListener onScaleListener = new MapboxMap.OnScaleListener() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.6
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
        public void onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
        public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector) {
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
        public void onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            FindMyDroneActivity.this.model.zoomScale.setValue(Float.valueOf((float) FindMyDroneActivity.this.map.getCameraPosition().zoom));
            FindMyDroneActivity findMyDroneActivity = FindMyDroneActivity.this;
            findMyDroneActivity.setZoomScale(findMyDroneActivity.model.zoomScale.getValue().floatValue());
            if (FindMyDroneActivity.this.model.zoomScale.getValue().floatValue() < 13.0f) {
                if (FindMyDroneActivity.this.model.circleManager.getValue() != null) {
                    FindMyDroneActivity.this.model.circleManager.getValue().deleteAll();
                    FindMyDroneActivity.this.model.circle.setValue(null);
                    return;
                }
                return;
            }
            FindMyDroneActivity findMyDroneActivity2 = FindMyDroneActivity.this;
            findMyDroneActivity2.drawCircle(findMyDroneActivity2.model.zoomScale.getValue().floatValue() * 2.0f);
        }
    };

    static /* synthetic */ void lambda$showUnlockDialog$1() {
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

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSatelliteCount(int i) {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSystemLocationChanged(double d, double d2, float f) {
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        this.binding = (ActivityFindMyDroneBinding) DataBindingUtil.setContentView(this, C2640R.layout.activity_find_my_drone);
        FindDroneViewModel findDroneViewModel = (FindDroneViewModel) new ViewModelProvider(this).get(FindDroneViewModel.class);
        this.model = findDroneViewModel;
        this.binding.setFindDroneViewModel(findDroneViewModel);
        this.binding.setLifecycleOwner(this);
        initView();
        initMapView();
        setToolBar();
        initRequest();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(C2640R.id.toolbar);
        toolbar.findViewById(C2640R.id.iv_back).setOnClickListener(this);
        toolbar.findViewById(C2640R.id.iv_search).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                FindMyDroneActivity.this.startActivity(new Intent(FindMyDroneActivity.this, (Class<?>) DroneGuideActivity.class));
            }
        });
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        LocationService.getInstance().setOnLocationChangedListener(this);
        this.viewMapSet = findViewById(C2640R.id.view_map_set);
        findViewById(C2640R.id.iv_map_position).setOnClickListener(this);
        findViewById(C2640R.id.iv_map_type).setOnClickListener(this);
        this.viewMapPosition = findViewById(C2640R.id.view_map_position);
        ImageView imageView = (ImageView) findViewById(C2640R.id.iv_map_lock);
        this.ivMapLock = imageView;
        imageView.setOnClickListener(this);
        findViewById(C2640R.id.iv_my_position).setOnClickListener(this);
        findViewById(C2640R.id.iv_fly_position).setOnClickListener(this);
        this.viewMapType = findViewById(C2640R.id.view_map_type);
        ImageButton imageButton = (ImageButton) findViewById(C2640R.id.btn_map_show);
        this.btnMapShow = imageButton;
        imageButton.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(C2640R.id.iv_map_set_hide);
        this.ivMapSetHide = imageView2;
        imageView2.setOnClickListener(this);
        this.ivWifi = (ImageView) findViewById(C2640R.id.iv_signal_hd);
        this.tvGps = (TextView) findViewById(C2640R.id.tv_gps);
        this.tvRemainBattery = (TextView) findViewById(C2640R.id.tv_electricity);
        this.btnMapSatellite = (ImageButton) findViewById(C2640R.id.iv_map_satellite);
        this.binding.btnStartBeep.setOnClickListener(this);
        initStartBeep();
        this.f2367NA = getString(C2640R.string.test_data);
        ImageButton imageButton2 = (ImageButton) findViewById(C2640R.id.iv_map_standard);
        this.ivStandardMode = imageButton2;
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(C2640R.id.iv_map_satellite);
        this.ivSatelliteMode = imageButton3;
        imageButton3.setOnClickListener(this);
        ImageButton imageButton4 = (ImageButton) findViewById(C2640R.id.iv_map_night);
        this.ivStandardNightMode = imageButton4;
        imageButton4.setOnClickListener(this);
        this.model.isFindingDrone.observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$FindMyDroneActivity$_Q3_5M32L8liMCOxbHVLUFS6cJ8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FindMyDroneActivity.this.lambda$initView$0$FindMyDroneActivity((Boolean) obj);
            }
        });
        this.binding.ivSearch.setVisibility((FlightConfig.isAtomPanTilt() || FlightConfig.is_Atom_SE_Series() || FlightConfig.isAtomLT()) ? 0 : 8);
    }

    public /* synthetic */ void lambda$initView$0$FindMyDroneActivity(Boolean bool) {
        if (bool.booleanValue()) {
            showUnlockDialog();
        }
    }

    private void initMapView() {
        if (this.binding.mapView != null) {
            this.binding.mapView.getMapAsync(new OnMapReadyCallback() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.2
                @Override // com.mapbox.mapboxsdk.maps.OnMapReadyCallback
                public void onMapReady(MapboxMap mapboxMap) {
                    DDLog.m1685e("找飞机", "异步加载地图");
                    FindMyDroneActivity.this.map = mapboxMap;
                    mapboxMap.setStyle(FindMyDroneActivity.this.curStyle, FindMyDroneActivity.this.styleLoadedListener);
                    FindMyDroneActivity.this.showUIOnMap();
                    FindMyDroneActivity.this.map.addOnScaleListener(FindMyDroneActivity.this.onScaleListener);
                    FindMyDroneActivity.this.binding.mapView.addOnCameraDidChangeListener(new MapView.OnCameraDidChangeListener() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.2.1
                        @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
                        public void onCameraDidChange(boolean z) {
                            if (FindMyDroneActivity.this.map != null) {
                                FindMyDroneActivity.this.model.zoomScale.setValue(Float.valueOf((float) FindMyDroneActivity.this.map.getCameraPosition().zoom));
                                FindMyDroneActivity.this.setZoomScale(FindMyDroneActivity.this.model.zoomScale.getValue().floatValue());
                            }
                        }
                    });
                    FindMyDroneActivity.this.binding.scaleView.update(FindMyDroneActivity.this.model.zoomScale.getValue().floatValue(), FindMyDroneActivity.this.model.curLat.getValue().doubleValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUIOnMap() {
        UiSettings uiSettings = this.map.getUiSettings();
        uiSettings.setRotateGesturesEnabled(false);
        uiSettings.setLogoEnabled(false);
        uiSettings.setTiltGesturesEnabled(false);
        uiSettings.setCompassEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMapStyle(Style style) {
        this.style = style;
        try {
            new LocalizationPlugin(this.binding.mapView, this.map, this.style).matchMapLanguageWithDeviceDefault();
        } catch (RuntimeException e) {
            DDLog.m1683d("map", e.toString());
        }
        this.model.symbolManager.setValue(new SymbolManager(this.binding.mapView, this.map, this.style));
        this.model.circleManager.setValue(new CircleManager(this.binding.mapView, this.map, this.style));
        this.model.lineManager.setValue(new LineManager(this.binding.mapView, this.map, this.style));
        this.model.symbolManager.getValue().setIconAllowOverlap(true);
        this.model.symbolManager.getValue().setTextAllowOverlap(true);
        Style style2 = this.style;
        Objects.requireNonNull(this.model);
        style2.addImage("marker-image-device", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.mapbox_marker_icon_my_position));
        Style style3 = this.style;
        Objects.requireNonNull(this.model);
        style3.addImage("marker_image_plane", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.mapbox_marker_icon_plane_pos));
        Style style4 = this.style;
        Objects.requireNonNull(this.model);
        style4.addImage("marker_image_plane_unconnect", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.mapbox_marker_icon_plane_unconnect));
        Style style5 = this.style;
        Objects.requireNonNull(this.model);
        style5.addImage("marker-text-plane", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.mapbox_marker_icon_bg_text_new));
        Style style6 = this.style;
        Objects.requireNonNull(this.model);
        style6.addImage("marker_image_home", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.mapbox_marker_icon_home_position));
        Style style7 = this.style;
        Objects.requireNonNull(this.model);
        style7.addImage("marker-text-distance", BitmapUtils.getDrawableFromRes(this, C2640R.mipmap.map_text_distance));
        this.planeWidth = BitmapFactory.decodeResource(getResources(), C2640R.mipmap.mapbox_marker_icon_plane_pos).getWidth();
        this.textBgWidth = BitmapFactory.decodeResource(getResources(), C2640R.mipmap.mapbox_marker_icon_bg_text).getWidth();
        this.model.isStyleLoaded.setValue(true);
        this.model.curPlaneLng.setValue(Double.valueOf(SPHelper.getInstance().getLongitude()));
        this.model.curPlaneLat.setValue(Double.valueOf(SPHelper.getInstance().getLatitude()));
        flyTextLocation(this.model.curPlaneLat.getValue().doubleValue(), this.model.curPlaneLng.getValue().doubleValue());
        flyAlwaysLocation(this.model.curPlaneLat.getValue().doubleValue(), this.model.curPlaneLng.getValue().doubleValue());
        showMyLocation();
        this.model.curHomeLng.setValue(Double.valueOf(SPHelper.getInstance().getHomeLongitude()));
        this.model.curHomeLat.setValue(Double.valueOf(SPHelper.getInstance().getHomeLatitude()));
        homeLocation(this.model.curHomeLat.getValue().doubleValue(), this.model.curHomeLng.getValue().doubleValue());
    }

    private void initRequest() {
        NetworkStateReceiver.getInstance().addCallback(this);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        if (!FlightConfig.isUsb()) {
            CameraCtrlPresenter.getInstance().startGetWifiSignal();
        }
        this.model.deviceRotate.setValue(Float.valueOf(LocationService.getInstance().getRotate()));
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onNetworkChanged(NetworkType networkType) {
        if (PhoneConfig.isConnectFlightWifi() && !FlightConfig.isConnectFlight()) {
            DataManager.getInstance().connect();
        }
        DDLog.m1685e("找飞机", "网络状态改变：" + networkType);
        if (PhoneConfig.isConnectInternet()) {
            initMapView();
        }
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onCellularStateChanged(boolean z) {
        if (z) {
            initMapView();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2640R.id.btn_map_show /* 2131296416 */:
                this.viewMapSet.setVisibility(8);
                this.ivMapSetHide.setVisibility(0);
                break;
            case C2640R.id.btn_start_beep /* 2131296452 */:
                onClickStartBeep();
                break;
            case C2640R.id.iv_back /* 2131296743 */:
                finish();
                break;
            case C2640R.id.iv_fly_position /* 2131296781 */:
                showFlyStartLocation();
                this.viewMapPosition.setVisibility(8);
                break;
            case C2640R.id.iv_map_lock /* 2131296816 */:
                boolean z = !this.isStartRotate;
                this.isStartRotate = z;
                this.ivMapLock.setImageResource(z ? C2640R.mipmap.icon_compass_nor : C2640R.mipmap.icon_map_lock);
                if (this.isStartRotate) {
                    startRotate();
                    break;
                } else {
                    stopRotate();
                    break;
                }
            case C2640R.id.iv_map_night /* 2131296818 */:
                setMapType(Style.TRAFFIC_NIGHT);
                this.viewMapType.setVisibility(8);
                break;
            case C2640R.id.iv_map_position /* 2131296820 */:
                View view2 = this.viewMapPosition;
                view2.setVisibility(view2.getVisibility() != 0 ? 0 : 8);
                this.viewMapType.setVisibility(8);
                this.viewMapSet.setVisibility(8);
                this.ivMapSetHide.setVisibility(0);
                break;
            case C2640R.id.iv_map_satellite /* 2131296822 */:
                setMapType(Style.SATELLITE);
                this.viewMapType.setVisibility(8);
                break;
            case C2640R.id.iv_map_set_hide /* 2131296823 */:
                this.viewMapSet.setVisibility(0);
                this.ivMapSetHide.setVisibility(8);
                this.viewMapPosition.setVisibility(8);
                this.viewMapType.setVisibility(8);
                break;
            case C2640R.id.iv_map_standard /* 2131296824 */:
                setMapType(Style.MAPBOX_STREETS);
                this.viewMapType.setVisibility(8);
                break;
            case C2640R.id.iv_map_type /* 2131296825 */:
                View view3 = this.viewMapType;
                view3.setVisibility(view3.getVisibility() != 0 ? 0 : 8);
                this.viewMapPosition.setVisibility(8);
                this.viewMapSet.setVisibility(8);
                this.ivMapSetHide.setVisibility(0);
                this.ivStandardMode.setBackground(this.curStyle.equals(Style.MAPBOX_STREETS) ? getDrawable(C2640R.mipmap.icon_map_style_select) : null);
                this.ivSatelliteMode.setBackground(this.curStyle.equals(Style.SATELLITE) ? getDrawable(C2640R.mipmap.icon_map_style_select) : null);
                this.ivStandardNightMode.setBackground(this.curStyle.equals(Style.TRAFFIC_NIGHT) ? getDrawable(C2640R.mipmap.icon_map_style_select) : null);
                break;
            case C2640R.id.iv_my_position /* 2131296830 */:
                PermissionUtil.requestLocationPermissionAndGpsEnable(this, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.3
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            FindMyDroneActivity.this.showMyLocation();
                            FindMyDroneActivity.this.viewMapPosition.setVisibility(8);
                        }
                    }
                });
                break;
        }
    }

    private void setMapType(String str) {
        if (this.curStyle.equals(str)) {
            return;
        }
        this.curStyle = str;
        this.model.isStyleLoaded.setValue(false);
        this.map.setStyle(this.curStyle, this.styleLoadedListener);
    }

    private void startRotate() {
        updateCameraBearing(this.model.deviceRotate.getValue().floatValue());
        this.model.rotateMyLocationIcon(0.0f);
        ImageView imageView = this.ivMapLock;
        if (imageView != null) {
            imageView.setRotation(360.0f - this.model.deviceRotate.getValue().floatValue());
        }
    }

    private void stopRotate() {
        this.map.resetNorth();
        this.ivMapLock.setRotation(0.0f);
        FindDroneViewModel findDroneViewModel = this.model;
        findDroneViewModel.rotateMyLocationIcon(findDroneViewModel.deviceRotate.getValue().floatValue());
    }

    private void updateCameraBearing(float f) {
        if (this.builder == null) {
            this.builder = new CameraPosition.Builder();
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(this.builder.bearing(f).build()));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        DDLog.m1684e("找飞机 onStart");
        PermissionUtil.requestLocationPermissionAndGpsEnable(this, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.FindMyDroneActivity.4
            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
                if (bool.booleanValue()) {
                    if (!LocationService.getInstance().getIsRegister()) {
                        LocationService.getInstance().reStart();
                    }
                    DDLog.m1684e("找飞机 onStart222");
                    FindMyDroneActivity.this.showMyLocation();
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.binding.mapView.onResume();
        if (LocationService.getInstance().getIsRegister()) {
            return;
        }
        LocationService.getInstance().reStart();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.binding.mapView.onPause();
        LocationService.getInstance().stop();
        CameraCtrlPresenter.getInstance().stopGetWifiSignal();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CameraCtrlPresenter.getInstance().release();
        DataManager.getInstance().close();
        NetworkStateReceiver.getInstance().removeCallback(this);
        this.binding.mapView.setVisibility(8);
        this.binding.mapView.onStop();
        this.binding.mapView.onDestroy();
        LocationService.getInstance().setOnLocationChangedListener(null);
    }

    public void setZoomScale(float f) {
        this.binding.scaleView.update(f, this.map.getCameraPosition().target.getLatitude());
    }

    public void showFlyStartLocation() {
        DDLog.m1685e(TAG, "找飞机_showFlyStartLocation");
        if (this.binding.mapView.isDestroyed() || this.model.curPlaneLat.getValue().doubleValue() == 0.0d || this.model.curPlaneLng.getValue().doubleValue() == 0.0d || !this.model.isStyleLoaded.getValue().booleanValue()) {
            return;
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.model.curPlaneLat.getValue().doubleValue(), this.model.curPlaneLng.getValue().doubleValue())).zoom(this.zoom).build()), 2000);
        setZoomScale(this.zoom);
        this.model.zoomScale.setValue(Float.valueOf(this.zoom));
        drawCircle(this.model.zoomScale.getValue().floatValue() * 2.0f);
    }

    public void showMyLocation() {
        DDLog.m1684e("找飞机_定位到手机位置curLat：" + this.model.curLat.getValue() + ", curLng: " + this.model.curLng.getValue() + ", isStyleLoaded = " + this.model.isStyleLoaded.getValue());
        if (this.binding.mapView.isDestroyed() || this.map == null) {
            return;
        }
        if (this.model.curLat.getValue().doubleValue() == 0.0d || this.model.curLng.getValue().doubleValue() == 0.0d) {
            DDLog.m1684e("............找飞机.............");
            return;
        }
        if (this.model.isStyleLoaded.getValue().booleanValue()) {
            this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.model.curLat.getValue().doubleValue(), this.model.curLng.getValue().doubleValue())).zoom(this.zoom).build()), 2000);
            setZoomScale(this.zoom);
            this.model.zoomScale.setValue(Float.valueOf(this.zoom));
            if (this.model.deviceSymbol.getValue() == null) {
                onBDLocationChanged(this.model.curLat.getValue().doubleValue(), this.model.curLng.getValue().doubleValue(), 0.0f);
            }
        }
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onBDLocationChanged(double d, double d2, float f) {
        DDLog.m1684e("找飞机_我的位置实时定位lat：" + d + ", lng: " + d2 + ", isStyleLoaded = " + this.model.isStyleLoaded.getValue());
        if (this.binding.mapView.isDestroyed()) {
            return;
        }
        this.model.onLocationChanged(this.map, d, d2);
    }

    private void flyTextLocation(double d, double d2) {
        if (this.map == null) {
            return;
        }
        this.model.flyTextLocation(d, d2);
    }

    private void homeLocation(double d, double d2) {
        DDLog.m1684e("找飞机_home点位置定位lat: " + d + ", lng: " + d2);
        MapboxMap mapboxMap = this.map;
        if (mapboxMap == null) {
            return;
        }
        this.model.homeLocation(mapboxMap, d, d2);
    }

    public void flyAlwaysLocation(double d, double d2) {
        MapboxMap mapboxMap;
        DDLog.m1684e("找飞机_飞机实时定位lat:" + d + ", lng: " + d2);
        if (this.binding.mapView.isDestroyed() || (mapboxMap = this.map) == null) {
            return;
        }
        this.model.flyAlwaysLocation(mapboxMap, d, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawCircle(float f) {
        if (this.map == null) {
            return;
        }
        this.model.drawCircle(f);
    }

    private void setWifiStrength(int i) {
        if (i == -1) {
            return;
        }
        this.level = i;
        this.ivWifi.setImageLevel(i);
    }

    private void setGpsAndElectricity(int i, int i2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        if (i < 6) {
            this.tvGps.setTextColor(getResources().getColor(C2640R.color.colorRemainedBattery));
            this.tvGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(C2640R.mipmap.icon_gps_weak), (Drawable) null, (Drawable) null);
        } else {
            this.tvGps.setTextColor(getResources().getColor(C2640R.color.colorWhite));
            this.tvGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(C2640R.mipmap.icon_gps_enable), (Drawable) null, (Drawable) null);
        }
        this.tvGps.setText(String.format("%d", Integer.valueOf(i)));
        if (i2 <= 20) {
            this.tvRemainBattery.setTextColor(getResources().getColor(C2640R.color.colorRemainedBattery));
        } else {
            this.tvRemainBattery.setTextColor(getResources().getColor(C2640R.color.colorWhite));
        }
        this.tvRemainBattery.setText(String.format("%d%%", Integer.valueOf(i2)));
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        Drawable drawable;
        String str = TAG;
        DDLog.m1683d(str, "onEvent id " + eventID);
        if (this.binding.mapView.isDestroyed()) {
        }
        switch (C26887.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                setWifiStrength(((WifiSignalData) event.obj).getWifiRssiRange());
                break;
            case 2:
                boolean booleanValue = ((Boolean) event.obj).booleanValue();
                DDLog.m1685e("找飞机", "连接状态：" + booleanValue);
                if (this.model.circleManager.getValue() != null) {
                    this.model.circleManager.getValue().deleteAll();
                    this.model.circle.setValue(null);
                }
                if (this.model.lineManager.getValue() != null && this.model.line.getValue() != null) {
                    this.model.lineManager.getValue().delete((LineManager) this.model.line.getValue());
                    this.model.line.setValue(null);
                }
                if (this.model.lineManager.getValue() != null && this.model.homeLine.getValue() != null) {
                    this.model.lineManager.getValue().delete((LineManager) this.model.homeLine.getValue());
                    this.model.homeLine.setValue(null);
                }
                if (this.model.symbolManager.getValue() != null && this.model.planeSymbol.getValue() != null) {
                    this.model.symbolManager.getValue().delete((SymbolManager) this.model.planeSymbol.getValue());
                    this.model.planeSymbol.setValue(null);
                }
                if (this.model.symbolManager.getValue() != null && this.model.textSymbol.getValue() != null) {
                    this.model.symbolManager.getValue().delete((SymbolManager) this.model.textSymbol.getValue());
                    this.model.textSymbol.setValue(null);
                }
                if (this.model.symbolManager.getValue() != null && this.model.distanceSymbol.getValue() != null) {
                    this.model.symbolManager.getValue().delete((SymbolManager) this.model.distanceSymbol.getValue());
                    this.model.distanceSymbol.setValue(null);
                }
                if (this.model.symbolManager.getValue() != null && this.model.homeSymbol.getValue() != null) {
                    this.model.symbolManager.getValue().delete((SymbolManager) this.model.homeSymbol.getValue());
                    this.model.homeSymbol.setValue(null);
                }
                this.model.curPlaneLng.setValue(Double.valueOf(SPHelper.getInstance().getLongitude()));
                this.model.curPlaneLat.setValue(Double.valueOf(SPHelper.getInstance().getLatitude()));
                flyTextLocation(this.model.curPlaneLat.getValue().doubleValue(), this.model.curPlaneLng.getValue().doubleValue());
                flyAlwaysLocation(this.model.curPlaneLat.getValue().doubleValue(), this.model.curPlaneLng.getValue().doubleValue());
                this.model.curHomeLng.setValue(Double.valueOf(SPHelper.getInstance().getHomeLongitude()));
                this.model.curHomeLat.setValue(Double.valueOf(SPHelper.getInstance().getHomeLatitude()));
                homeLocation(this.model.curHomeLat.getValue().doubleValue(), this.model.curHomeLng.getValue().doubleValue());
                if (booleanValue) {
                    initRequest();
                    ConstraintLayout constraintLayout = this.binding.btnStartBeep;
                    if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                        drawable = getResources().getDrawable(C2640R.mipmap.map_button_beep_disable);
                    } else {
                        drawable = getResources().getDrawable(C2640R.mipmap.map_button_beep);
                    }
                    constraintLayout.setBackground(drawable);
                    break;
                } else {
                    TextView textView = this.tvGps;
                    if (textView != null) {
                        textView.setText(this.f2367NA);
                    }
                    TextView textView2 = this.tvRemainBattery;
                    if (textView2 != null) {
                        textView2.setText(this.f2367NA);
                    }
                    ImageView imageView = this.ivWifi;
                    if (imageView != null) {
                        imageView.setImageLevel(0);
                    }
                    this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_disable));
                    GeneralDialog generalDialog = this.unLockDialog;
                    if (generalDialog != null && generalDialog.isShowing()) {
                        this.unLockDialog.dismiss();
                        this.unLockDialog = null;
                        break;
                    }
                }
                break;
            case 3:
                FlightRevFlightInfoData flightRevFlightInfoData = (FlightRevFlightInfoData) event.obj;
                DDLog.m1684e("经纬度:" + flightRevFlightInfoData.getLat() + "," + flightRevFlightInfoData.getLng());
                setGpsAndElectricity(flightRevFlightInfoData.getSatellitesNum(), flightRevFlightInfoData.getRemainedBattery());
                if (flightRevFlightInfoData.getLat() == 0.0d && flightRevFlightInfoData.getLng() == 0.0d) {
                    if (!this.model.startGps.getValue().booleanValue()) {
                        this.model.startGps.setValue(true);
                        break;
                    }
                } else {
                    if (this.model.startGps.getValue().booleanValue()) {
                        DDLog.m1685e(str, "restart and refresh homeLocation");
                        this.model.startGps.setValue(false);
                        SPHelper.getInstance().setHomeLatitude((float) FlightRevData.get().getFlightRevHomePointData().getLat());
                        SPHelper.getInstance().setHomeLongitude((float) FlightRevData.get().getFlightRevHomePointData().getLng());
                        homeLocation(FlightRevData.get().getFlightRevHomePointData().getLat(), FlightRevData.get().getFlightRevHomePointData().getLng());
                    }
                    flyAlwaysLocation(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng());
                    flyTextLocation(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng());
                    break;
                }
                break;
            case 4:
                FlightRevHomePointData flightRevHomePointData = (FlightRevHomePointData) event.obj;
                SPHelper.getInstance().setHomeLatitude((float) flightRevHomePointData.getLat());
                SPHelper.getInstance().setHomeLongitude((float) flightRevHomePointData.getLng());
                DDLog.m1685e(str, "FLIGHT_RECEIVE_HOME_POINT lat =" + flightRevHomePointData.getLat() + ", lng = " + flightRevHomePointData.getLng());
                homeLocation(flightRevHomePointData.getLat(), flightRevHomePointData.getLng());
                break;
            case 5:
                this.model.deviceRotate.setValue(Float.valueOf(((Float) event.obj).floatValue()));
                if (this.isStartRotate) {
                    updateCameraBearing(this.model.deviceRotate.getValue().floatValue());
                    this.model.rotateMyLocationIcon(0.0f);
                    break;
                } else {
                    FindDroneViewModel findDroneViewModel = this.model;
                    findDroneViewModel.rotateMyLocationIcon(findDroneViewModel.deviceRotate.getValue().floatValue());
                    break;
                }
            case 6:
                float floatValue = ((Float) event.obj).floatValue();
                ImageView imageView2 = this.ivMapLock;
                if (imageView2 != null && this.isStartRotate) {
                    imageView2.setRotation(floatValue);
                    break;
                }
                break;
            case 7:
                if (FlightConfig.isUsb()) {
                    setWifiStrength(((FlightRevConnectData) event.obj).getRssiRange());
                    break;
                }
                break;
            case 8:
                if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevStateData().isUnLock()) {
                    this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_disable));
                    if (this.model.setStartBeep.getValue().booleanValue()) {
                        this.model.setStartBeep.setValue(false);
                        this.binding.tvStartBeep.setText(C2640R.string.btn_start_beep);
                        if (!CommonUtil.hasNewVersion(BuildConfig.VERSION_NAME, FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) {
                            ToastUtil.toast(this, getString(C2640R.string.toast_unlock_auto_stop_beep));
                        }
                        AnimationDrawable animationDrawable = this.speakerAnimDrawable;
                        if (animationDrawable != null && animationDrawable.isRunning()) {
                            this.speakerAnimDrawable.stop();
                        }
                    }
                }
                if (this.model.isFindingDrone.getValue().booleanValue() != FlightRevData.get().getFlightRevStateData().isFindingDrone()) {
                    this.model.isFindingDrone.setValue(Boolean.valueOf(FlightRevData.get().getFlightRevStateData().isFindingDrone()));
                }
                if (FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isUnLock()) {
                    if (FlightRevData.get().getFlightRevStateData().isEscBeep()) {
                        this.binding.tvStartBeep.setText(C2640R.string.btn_close_beep);
                        this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_new));
                        AnimationDrawable animationDrawable2 = this.speakerAnimDrawable;
                        if (animationDrawable2 != null && !animationDrawable2.isRunning()) {
                            this.speakerAnimDrawable.start();
                            break;
                        }
                    } else {
                        this.binding.tvStartBeep.setText(C2640R.string.btn_start_beep);
                        this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep));
                        AnimationDrawable animationDrawable3 = this.speakerAnimDrawable;
                        if (animationDrawable3 != null && animationDrawable3.isRunning()) {
                            this.speakerAnimDrawable.stop();
                            break;
                        }
                    }
                }
                break;
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.FindMyDroneActivity$7 */
    static /* synthetic */ class C26887 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_GET_WIFI_SIGNAL_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_HOME_POINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_DEVICE_ROTATE_CHANGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_COMPASS_ROTATE_CHANGED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void initStartBeep() {
        this.speakerAnimDrawable = (AnimationDrawable) this.binding.imgSpeakerBeep.getDrawable();
        if (FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isUnLock()) {
            this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep));
            if (FlightRevData.get().getFlightRevStateData().isEscBeep()) {
                this.model.setStartBeep.setValue(true);
                this.binding.tvStartBeep.setText(C2640R.string.btn_close_beep);
                this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_new));
                AnimationDrawable animationDrawable = this.speakerAnimDrawable;
                if (animationDrawable != null && !animationDrawable.isRunning()) {
                    this.speakerAnimDrawable.start();
                }
            }
        } else {
            this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_disable));
        }
        this.model.showBeepBtn.setValue(Boolean.valueOf(FlightConfig.isAtomPanTilt()));
    }

    private void onClickStartBeep() {
        if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevStateData().isUnLock()) {
            DDLog.m1692w(TAG, "onClickStartBeep isConnect and unLock");
            this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_disable));
            ToastUtil.toast(this, getString(C2640R.string.toast_unlock_to_start_beep));
            return;
        }
        if (FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isUnLock()) {
            String str = TAG;
            DDLog.m1692w(str, "onClickStartBeep isConnect and lock");
            if (this.model.setStartBeep.getValue().booleanValue()) {
                if (FlightRevData.get().getFlightRevStateData().isEscBeep()) {
                    FlightSendData.get().getSendGeneralData().setDataType(CommonMsgType.STOP_BEEP);
                    DataManager.getInstance().sendGeneralData();
                    this.model.setStartBeep.setValue(false);
                }
            } else {
                FlightSendData.get().getSendGeneralData().setDataType(CommonMsgType.START_BEEP);
                DataManager.getInstance().sendGeneralData();
                this.model.setStartBeep.setValue(true);
            }
            DDLog.m1692w(str, "发送飞控电调数据:" + ParseUtil.byteToHexString(FlightSendData.get().getSendGeneralData().getBytes()));
            return;
        }
        DDLog.m1692w(TAG, "onClickStartBeep case unConnect");
        this.binding.btnStartBeep.setBackground(getResources().getDrawable(C2640R.mipmap.map_button_beep_disable));
        ToastUtil.toast(this, getString(C2640R.string.toast_not_connect_to_start_beep));
    }

    private void showUnlockDialog() {
        if (FlightConfig.isConnectFlight()) {
            if (this.unLockDialog == null) {
                this.unLockDialog = new GeneralDialog((Context) this, false, getString(C2640R.string.find_my_drone_fail_to_unlock_title), getString(C2640R.string.find_my_drone_fail_to_unlock_tips), getString(C2640R.string.i_get_it), (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$FindMyDroneActivity$79ZDAKKGAU8h5Cck4XSxuEClPPw
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public final void confirm() {
                        FindMyDroneActivity.lambda$showUnlockDialog$1();
                    }
                });
            }
            this.unLockDialog.show();
        }
    }
}