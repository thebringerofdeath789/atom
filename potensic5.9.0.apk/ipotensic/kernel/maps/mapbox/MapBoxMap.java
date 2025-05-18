package com.ipotensic.kernel.maps.mapbox;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.DateUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.FlightRecordBean;
import com.ipotensic.kernel.bean.MultiPointBean;
import com.ipotensic.kernel.enums.Mode;
import com.ipotensic.kernel.maps.BaseMap;
import com.ipotensic.kernel.utils.MapUtil;
import com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog;
import com.ipotensic.kernel.view.dialog.SlideUnlockDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.send.SendMultiPointData;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.android.gestures.StandardScaleGestureDetector;
import com.mapbox.api.directions.v5.models.SpeedLimit;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.maps.UiSettings;
import com.mapbox.mapboxsdk.plugins.annotation.Circle;
import com.mapbox.mapboxsdk.plugins.annotation.CircleManager;
import com.mapbox.mapboxsdk.plugins.annotation.CircleOptions;
import com.mapbox.mapboxsdk.plugins.annotation.Line;
import com.mapbox.mapboxsdk.plugins.annotation.LineManager;
import com.mapbox.mapboxsdk.plugins.annotation.LineOptions;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.plugins.localization.LocalizationPlugin;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.mapboxsdk.utils.ColorUtils;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes2.dex */
public class MapBoxMap extends BaseMap<LatLng> implements OnMapReadyCallback, MapboxMap.OnMapClickListener, MapboxMap.OnScaleListener, MapView.OnCameraDidChangeListener, EventDispatcher.OnEventListener, MapboxMap.OnMoveListener {
    private CameraPosition.Builder builder;
    private CircleManager circleManager;
    private AppCompatActivity context;
    private double curLat;
    private double curLng;
    private LatLng deviceLatLng;
    private float deviceRotate;
    private Symbol deviceSymbol;
    private float directToNorth;
    private FlightRevHomePointData flightRevHomePointData;
    private double flyLat;
    private LatLng flyLatLng;
    private double flyLng;
    private LatLng homeLatLng;
    private Symbol homeSymbol;
    private boolean isHomePoint;
    private boolean isRotateStart;
    private View ivLock;
    private LineManager lineManager;
    private MapboxMap map;
    private MapView mapView;
    private Symbol planeSymbol;
    private SymbolManager pointSymbolManager;
    private Style style;
    private SymbolManager symbolManager;
    private Symbol systemSymbol;
    private UiSettings uiSettings;
    private float zoomScale = 15.0f;
    private final float defaultZoom = 15.0f;
    private final String MARKER_IMAGE_DEVICE = "marker-image-device";
    private final String MARKER_IMAGE_SYSTEM = "marker-image-system";
    private final String MARKER_IMAGE_DEVICE_PAIR = "marker-image-device-pair";
    private final String MARKER_IMAGE_PLANE = "marker-image-plane";
    private final String MARKER_IMAGE_PLANE_PAIR = "marker-image-plane-pair";
    private final String MARKER_IMAGE_POINT = "marker-image-point";
    private final String MARKER_IMAGE_HOME = "marker-image-home";
    private LatLng point = null;
    private ArrayList<LatLng> pointList = new ArrayList<>();
    private ArrayList<LatLng> removeList = new ArrayList<>();
    private ArrayList<SendMultiPointData.LatLng> sendFlightList = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();
    private float distanceTotal = 0.0f;
    private boolean isStyleLoaded = false;
    private String curStyle = Style.SATELLITE;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isAnimated = true;
    private boolean isMoveEnd = true;
    private AtomicBoolean isBeyondBound = new AtomicBoolean(true);
    private List<Symbol> symbolList = new ArrayList();
    private Runnable mapRunnable = new Runnable() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.2
        @Override // java.lang.Runnable
        public void run() {
            if (MapBoxMap.this.flyLat == 0.0d && MapBoxMap.this.flyLng == 0.0d) {
                MapBoxMap.this.isBeyondBound.set(true);
            } else {
                MapBoxMap.this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(MapBoxMap.this.flyLat, MapBoxMap.this.flyLng)).zoom(14.0d).build()), 2000);
                MapBoxMap.this.isBeyondBound.set(true);
            }
        }
    };
    private Style.OnStyleLoaded styleLoadedListener = new Style.OnStyleLoaded() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.5
        @Override // com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
        public void onStyleLoaded(Style style) {
            MapBoxMap.this.deletePointAndLine();
            MapBoxMap.this.initMapStyle(style);
            MapBoxMap.this.locationStart(FlightConfig.GPS.getLat(), FlightConfig.GPS.getLng());
            MapBoxMap.this.flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData();
            if (MapBoxMap.this.flightRevHomePointData.getLng() != 0.0d && MapBoxMap.this.flightRevHomePointData.getLat() != 0.0d) {
                MapBoxMap mapBoxMap = MapBoxMap.this;
                mapBoxMap.showHomePointLocation(mapBoxMap.flightRevHomePointData.getLat(), MapBoxMap.this.flightRevHomePointData.getLng());
            }
            MapBoxMap.this.againDrawPoint();
            if (MapBoxMap.this.isRotateStart) {
                MapBoxMap mapBoxMap2 = MapBoxMap.this;
                mapBoxMap2.updateCameraBearing(mapBoxMap2.deviceRotate);
                MapBoxMap.this.rotateMyLocationIcon(0.0f);
            } else {
                MapBoxMap mapBoxMap3 = MapBoxMap.this;
                mapBoxMap3.rotateMyLocationIcon(mapBoxMap3.deviceRotate);
            }
        }
    };

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
    public void onMove(MoveGestureDetector moveGestureDetector) {
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
    public void onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
    public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector) {
    }

    public MapBoxMap(AppCompatActivity appCompatActivity, MapView mapView) {
        this.mapView = mapView;
        this.context = appCompatActivity;
        init();
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void init() {
        this.mapView.getMapAsync(this);
        EventDispatcher.get().registerEvent(this.context.getLifecycle(), this);
    }

    @Override // com.mapbox.mapboxsdk.maps.OnMapReadyCallback
    public void onMapReady(MapboxMap mapboxMap) {
        this.map = mapboxMap;
        mapboxMap.setStyle(Style.SATELLITE, this.styleLoadedListener);
        mapboxMap.addOnMapClickListener(this);
        mapboxMap.addOnScaleListener(this);
        this.mapView.addOnCameraDidChangeListener(this);
        this.map.addOnMoveListener(this);
        showUIOnMap();
        this.scaleView.update(this.zoomScale, this.curLat);
        this.map.setMaxZoomPreference(18.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMapStyle(Style style) {
        this.style = style;
        try {
            new LocalizationPlugin(this.mapView, this.map, this.style).matchMapLanguageWithDeviceDefault();
        } catch (RuntimeException e) {
            DDLog.d("map", e.toString());
        }
        this.lineManager = new LineManager(this.mapView, this.map, this.style);
        this.circleManager = new CircleManager(this.mapView, this.map, this.style);
        SymbolManager symbolManager = new SymbolManager(this.mapView, this.map, this.style);
        this.symbolManager = symbolManager;
        symbolManager.setIconAllowOverlap(true);
        this.symbolManager.setTextAllowOverlap(true);
        SymbolManager symbolManager2 = new SymbolManager(this.mapView, this.map, this.style);
        this.pointSymbolManager = symbolManager2;
        symbolManager2.setIconAllowOverlap(true);
        this.pointSymbolManager.setTextAllowOverlap(true);
        this.pointSymbolManager.setIconPadding(Float.valueOf(5.0f));
        this.pointSymbolManager.setSymbolAvoidEdges(true);
        this.style.addImage("marker-image-device", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.icon_remoter_point_normal));
        this.style.addImage("marker-image-system", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.icon_fb_badges));
        this.style.addImage("marker-image-device-pair", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.icon_remoter_point_pair));
        this.style.addImage("marker-image-plane", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.icon_drone_enable_normal));
        this.style.addImage("marker-image-plane-pair", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.icon_drone_enable_pair));
        this.style.addImage("marker-image-home", BitmapUtils.getDrawableFromRes(this.context, R.mipmap.mapbox_marker_icon_home_position));
        this.isStyleLoaded = true;
    }

    private void showUIOnMap() {
        if (this.uiSettings == null) {
            UiSettings uiSettings = this.map.getUiSettings();
            this.uiSettings = uiSettings;
            uiSettings.setAllGesturesEnabled(false);
        }
        this.uiSettings.setRotateGesturesEnabled(false);
        this.uiSettings.setLogoEnabled(false);
        this.uiSettings.setTiltGesturesEnabled(false);
        this.uiSettings.setCompassEnabled(false);
    }

    public void setCurMode(Mode mode) {
        if (this.isStyleLoaded) {
            boolean isConnectFlight = FlightConfig.isConnectFlight();
            if (mode == Mode.MODE_MAP) {
                this.uiSettings.setAllGesturesEnabled(true);
                showUIOnMap();
            } else {
                this.uiSettings.setAllGesturesEnabled(false);
            }
            if (isConnectFlight && (this.flyLat != 0.0d || this.flyLng != 0.0d)) {
                Symbol symbol = this.planeSymbol;
                if (symbol == null || this.symbolManager == null) {
                    return;
                }
                symbol.setIconRotate(Float.valueOf(this.directToNorth));
                this.symbolManager.update((SymbolManager) this.planeSymbol);
                this.map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.flyLat, this.flyLng)).build()));
                return;
            }
            if (this.deviceSymbol == null || this.symbolManager == null) {
                return;
            }
            if (this.isRotateStart) {
                rotateMyLocationIcon(0.0f);
            } else {
                rotateMyLocationIcon(this.deviceRotate);
            }
            this.map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.curLat, this.curLng)).build()));
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void locationStart(double d, double d2) {
        this.curLat = d;
        this.curLng = d2;
        if (this.map == null || this.symbolManager == null) {
            return;
        }
        if (this.deviceLatLng == null) {
            this.deviceLatLng = new LatLng(d, d2);
        }
        this.deviceLatLng.setLatitude(d);
        this.deviceLatLng.setLongitude(d2);
        if (this.isStyleLoaded) {
            if (this.deviceSymbol == null) {
                setDrawDividerLine(this.deviceLatLng);
                this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(this.deviceLatLng).zoom(this.zoomScale).build()), 2000);
            }
            this.deviceSymbol.setLatLng(this.deviceLatLng);
            this.symbolManager.update(this.symbolList);
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void systemLocationStart(double d, double d2) {
        if (this.map == null || this.symbolManager == null || !this.isStyleLoaded) {
            return;
        }
        LatLng latLng = new LatLng(d, d2);
        if (this.systemSymbol == null) {
            this.systemSymbol = this.symbolManager.create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage("marker-image-system"));
        }
        this.systemSymbol.setLatLng(latLng);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void showMyLocation() {
        if (this.curLat == 0.0d || this.curLng == 0.0d || !this.isStyleLoaded) {
            return;
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.curLat, this.curLng)).zoom(15.0d).build()), 2000);
        setZoomScale(15.0f);
        this.zoomScale = 15.0f;
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void showFlyStartLocation() {
        FlightRevHomePointData flightRevHomePointData = this.flightRevHomePointData;
        if (flightRevHomePointData == null || flightRevHomePointData.getLat() == 0.0d || this.flightRevHomePointData.getLng() == 0.0d || !this.isStyleLoaded) {
            return;
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.flightRevHomePointData.getLat(), this.flightRevHomePointData.getLng())).zoom(15.0d).build()), 2000);
        setZoomScale(15.0f);
        this.zoomScale = 15.0f;
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void showFlyLocation() {
        if (this.flyLat == 0.0d || this.flyLng == 0.0d || !this.isStyleLoaded) {
            return;
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(this.flyLat, this.flyLng)).zoom(15.0d).build()), 2000);
        setZoomScale(15.0f);
        this.zoomScale = 15.0f;
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void flyAlwaysLocation(double d, double d2, float f) {
        if (this.map == null || this.symbolManager == null || d > 90.0d || d < -90.0d) {
            return;
        }
        this.directToNorth = f;
        this.flyLat = d;
        this.flyLng = d2;
        if (this.flyLatLng == null) {
            this.flyLatLng = new LatLng(d, d2);
        }
        this.flyLatLng.setLatitude(d);
        this.flyLatLng.setLongitude(d2);
        if (this.isStyleLoaded) {
            if (this.planeSymbol == null) {
                this.planeSymbol = this.symbolManager.create((SymbolManager) new SymbolOptions().withLatLng(this.flyLatLng).withIconRotate(Float.valueOf(f)).withIconImage("marker-image-plane"));
            }
            this.planeSymbol.setLatLng(this.flyLatLng);
            if (Math.abs(this.planeSymbol.getIconRotate().floatValue() - f) > 2.0f) {
                this.planeSymbol.setIconRotate(Float.valueOf(f));
            }
            this.symbolManager.update((SymbolManager) this.planeSymbol);
        }
        if (!(d == 0.0d && d2 == 0.0d) && FlightRevData.get().getFlightRevStateData().isFlight()) {
            checkOutside(this.flyLat, this.flyLng);
        }
    }

    private void checkPointFlyLine(double d, double d2) {
        ArrayList<Line> arrayList = this.lines;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.lines.size(); i++) {
            DDLog.e("pointFly - > " + this.lines.get(i).getLatLngs().contains(new LatLng(d, d2)) + ", lat -> " + d + ", lng -> " + d2);
        }
    }

    private synchronized void checkOutside(final double d, final double d2) {
        this.handler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MapBoxMap.this.map.getProjection().getVisibleRegion().latLngBounds.contains(new LatLng(d, d2)) && MapBoxMap.this.isBeyondBound.get() && MapBoxMap.this.isMoveEnd) {
                    MapBoxMap.this.isBeyondBound.set(false);
                    MapBoxMap.this.handler.removeCallbacks(MapBoxMap.this.mapRunnable);
                    MapBoxMap.this.handler.postDelayed(MapBoxMap.this.mapRunnable, 3000L);
                }
            }
        }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void drawPoint() {
        if (this.isStyleLoaded) {
            int i = (FlightConfig.curFlight == null || !FlightConfig.is_Atom_Series()) ? 15 : 30;
            if (this.pointList.size() >= i) {
                ToastUtil.showImageTop(this.context, String.format(this.context.getString(R.string.toast_map_max_num), Integer.valueOf(i)), R.mipmap.icon_toast_prompt);
                return;
            }
            if (FlightRevData.get().getFlightRevStateData().getMode() != 0 && FlightRevData.get().getFlightRevStateData().isReceiveGps()) {
                String format = String.format(this.context.getString(R.string.toast_map_point_tips), Integer.valueOf(FlightConfig.getMaxPointDistance()));
                LatLng latLng = this.homeLatLng;
                if (latLng == null) {
                    if (TurfMeasurement.distance(Point.fromLngLat(this.curLng, this.curLat), Point.fromLngLat(this.point.getLongitude(), this.point.getLatitude()), TurfConstants.UNIT_METERS) > FlightConfig.getMaxPointDistance()) {
                        ToastUtil.showImageTop(this.context, format, R.mipmap.icon_toast_prompt);
                        return;
                    }
                } else if (TurfMeasurement.distance(Point.fromLngLat(latLng.getLongitude(), this.homeLatLng.getLatitude()), Point.fromLngLat(this.point.getLongitude(), this.point.getLatitude()), TurfConstants.UNIT_METERS) > FlightConfig.getMaxPointDistance()) {
                    ToastUtil.showImageTop(this.context, format, R.mipmap.icon_toast_prompt);
                    return;
                }
            }
            this.pointList.add(this.point);
            setDrawPoint(this.point, this.pointList.size());
            this.removeList.add(this.point);
            if (this.removeList.size() > 1) {
                drawLine(this.removeList, true);
            }
            this.sendFlightList.add(new SendMultiPointData.LatLng(this.point.getLatitude(), this.point.getLongitude()));
            if (this.listener != null) {
                this.listener.showGoBtn(true);
            }
            FlightConfig.isPointFlyFinished = false;
        }
    }

    public String getMapMode() {
        return this.curStyle;
    }

    private void setDrawDividerLine(LatLng latLng) {
        Symbol create = this.symbolManager.create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage("marker-image-device"));
        this.deviceSymbol = create;
        this.symbolList.add(create);
    }

    private void setDrawPoint(LatLng latLng, int i) {
        if (!this.isStyleLoaded || this.pointSymbolManager == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.view_map_mark, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_num)).setText(String.valueOf(i));
        this.style.addImage("marker-image-point" + i, convertViewToBitmap(inflate));
        this.pointSymbolManager.create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage("marker-image-point" + i));
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void drawLine(ArrayList<LatLng> arrayList, boolean z) {
        if (!this.isStyleLoaded || this.lineManager == null) {
            return;
        }
        this.lines.add(this.lineManager.create((LineManager) new LineOptions().withLineJoin(Property.LINE_JOIN_BEVEL).withLatLngs(arrayList).withLineColor(ColorUtils.colorToRgbaString(this.context.getResources().getColor(R.color.map_fold_line))).withLineWidth(Float.valueOf(2.5f))));
        arrayList.remove(0);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void drawCircle(float f) {
        if (!this.isStyleLoaded || this.circleManager == null) {
            return;
        }
        Circle create = this.circleManager.create((CircleManager) new CircleOptions().withLatLng(new LatLng(this.flyLat, this.flyLng)).withCircleColor(ColorUtils.colorToRgbaString(this.context.getResources().getColor(R.color.color_map_circle))));
        create.setCircleRadius(Float.valueOf(f));
        this.circleManager.update((CircleManager) create);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onCreate(Bundle bundle) {
        try {
            this.mapView.onCreate(bundle);
        } catch (Exception unused) {
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onSaveInstanceState(Bundle bundle) {
        this.mapView.onSaveInstanceState(bundle);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onResume() {
        this.mapView.onResume();
        MapboxMap mapboxMap = this.map;
        if (mapboxMap != null) {
            mapboxMap.setStyle(this.curStyle, this.styleLoadedListener);
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onPause() {
        this.mapView.onPause();
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onLowMemory() {
        this.mapView.onLowMemory();
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void onDestroy() {
        this.mapView.setVisibility(8);
        this.mapView.onStop();
        this.mapView.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        try {
            this.lineManager.onDestroy();
        } catch (Exception unused) {
        }
        try {
            this.symbolManager.onDestroy();
        } catch (Exception unused2) {
        }
        try {
            this.pointSymbolManager.onDestroy();
        } catch (Exception unused3) {
        }
        try {
            this.circleManager.onDestroy();
        } catch (Exception unused4) {
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void clearMarkAndPoly(boolean z) {
        SymbolManager symbolManager;
        SymbolManager symbolManager2;
        DDLog.e("map", "\u6e05\u9664\u70b9");
        if (z) {
            ArrayList<LatLng> arrayList = this.pointList;
            if (arrayList != null) {
                arrayList.clear();
            }
            LineManager lineManager = this.lineManager;
            if (lineManager != null) {
                lineManager.delete(this.lines);
                this.lines.clear();
            }
            SymbolManager symbolManager3 = this.pointSymbolManager;
            if (symbolManager3 != null) {
                symbolManager3.deleteAll();
            }
            ArrayList<LatLng> arrayList2 = this.removeList;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            ArrayList<SendMultiPointData.LatLng> arrayList3 = this.sendFlightList;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            this.distanceTotal = 0.0f;
            FlightConfig.isPointFlyFinished = false;
        } else if (!FlightConfig.isConnectFlight()) {
            Symbol symbol = this.homeSymbol;
            if (symbol != null && (symbolManager2 = this.symbolManager) != null) {
                symbolManager2.delete((SymbolManager) symbol);
                this.homeSymbol = null;
            }
            Symbol symbol2 = this.planeSymbol;
            if (symbol2 != null && (symbolManager = this.symbolManager) != null) {
                symbolManager.delete((SymbolManager) symbol2);
                this.planeSymbol = null;
            }
            this.flyLat = 0.0d;
            this.flyLng = 0.0d;
        }
        if (this.listener != null) {
            this.listener.showGoBtn(false);
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void fly() {
        if (BaseSyncDialog.isShow) {
            return;
        }
        if (FlightRevData.get().getFlightRevStateData().isReturning()) {
            AppCompatActivity appCompatActivity = this.context;
            ToastUtil.toast(appCompatActivity, appCompatActivity.getString(R.string.returning_switch_mode_unavailable));
            EventDispatcher.get().sendEvent(EventID.AUDIO_RETURNING_NOT_AVAILABLE);
            return;
        }
        final FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        if (flightRevFlightInfoData.getVerticalDistance() < 5.0d) {
            AppCompatActivity appCompatActivity2 = this.context;
            ToastUtil.toast(appCompatActivity2, appCompatActivity2.getString(R.string.setting_height_low_follow_fail));
        } else if (FlightConfig.isOldProduct()) {
            AppCompatActivity appCompatActivity3 = this.context;
            new SlideUnlockDialog(appCompatActivity3, appCompatActivity3.getResources().getString(R.string.dialog_go), this.context.getResources().getString(R.string.dialog_go_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.3
                @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                public void dealEvent() {
                    if (flightRevFlightInfoData.getVerticalDistance() < 5.0d) {
                        ToastUtil.toast(MapBoxMap.this.context, MapBoxMap.this.context.getString(R.string.setting_height_low_follow_fail));
                    } else {
                        MapBoxMap.this.startSendFlightPoint();
                    }
                }
            }).show();
        } else {
            AppCompatActivity appCompatActivity4 = this.context;
            new MiniTakeoffSlideUnlockDialog(appCompatActivity4, appCompatActivity4.getResources().getString(R.string.dialog_go), this.context.getResources().getString(R.string.dialog_go_describe), true, false, new MiniTakeoffSlideUnlockDialog.SlideUnlockListener() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.4
                @Override // com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog.SlideUnlockListener
                public void takeOff(boolean z) {
                    if (flightRevFlightInfoData.getVerticalDistance() < 5.0d) {
                        ToastUtil.toast(MapBoxMap.this.context, MapBoxMap.this.context.getString(R.string.setting_height_low_follow_fail));
                    } else {
                        MapBoxMap.this.startSendFlightPoint();
                    }
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSendFlightPoint() {
        String format = String.format(this.context.getString(R.string.toast_map_point_tips), Integer.valueOf(FlightConfig.getMaxPointDistance()));
        if (this.sendFlightList.size() > 0) {
            LatLng latLng = this.homeLatLng;
            if (latLng != null) {
                Point fromLngLat = Point.fromLngLat(latLng.getLongitude(), this.homeLatLng.getLatitude());
                Iterator<LatLng> it = this.pointList.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (TurfMeasurement.distance(fromLngLat, Point.fromLngLat(next.getLongitude(), next.getLatitude()), TurfConstants.UNIT_METERS) > FlightConfig.getMaxPointDistance()) {
                        ToastUtil.showImageTop(this.context, format, R.mipmap.icon_toast_prompt);
                        return;
                    }
                }
            } else {
                Point fromLngLat2 = Point.fromLngLat(this.curLng, this.curLat);
                Iterator<LatLng> it2 = this.pointList.iterator();
                while (it2.hasNext()) {
                    LatLng next2 = it2.next();
                    if (TurfMeasurement.distance(fromLngLat2, Point.fromLngLat(next2.getLongitude(), next2.getLatitude()), TurfConstants.UNIT_METERS) > FlightConfig.getMaxPointDistance()) {
                        ToastUtil.showImageTop(this.context, format, R.mipmap.icon_toast_prompt);
                        return;
                    }
                }
            }
            this.listener.startFlight(this.sendFlightList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void againDrawPoint() {
        ArrayList<LatLng> arrayList = this.pointList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i = 0;
        while (i < this.pointList.size()) {
            int i2 = i + 1;
            setDrawPoint(this.pointList.get(i), i2);
            this.removeList.add(this.pointList.get(i));
            if (this.removeList.size() > 1) {
                drawLine(this.removeList, true);
            }
            i = i2;
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void setMapType(String str) {
        if (this.curStyle.equals(str)) {
            return;
        }
        this.curStyle = str;
        this.isStyleLoaded = false;
        this.map.setStyle(str, this.styleLoadedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deletePointAndLine() {
        LineManager lineManager = this.lineManager;
        if (lineManager != null) {
            lineManager.delete(this.lines);
            this.lines.clear();
        }
        SymbolManager symbolManager = this.pointSymbolManager;
        if (symbolManager != null) {
            symbolManager.deleteAll();
        }
        ArrayList<LatLng> arrayList = this.removeList;
        if (arrayList != null) {
            arrayList.clear();
        }
        SymbolManager symbolManager2 = this.symbolManager;
        if (symbolManager2 != null) {
            symbolManager2.deleteAll();
        }
        if (this.deviceSymbol != null) {
            this.deviceSymbol = null;
        }
        if (this.systemSymbol != null) {
            this.systemSymbol = null;
        }
        if (this.planeSymbol != null) {
            this.planeSymbol = null;
        }
        if (this.homeSymbol != null) {
            this.homeSymbol = null;
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void stopRotate() {
        this.isRotateStart = false;
        this.map.resetNorth();
        rotateMyLocationIcon(this.deviceRotate);
        View view = this.ivLock;
        if (view != null) {
            view.setRotation(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCameraBearing(float f) {
        if (this.builder == null) {
            this.builder = new CameraPosition.Builder();
        }
        this.map.animateCamera(CameraUpdateFactory.newCameraPosition(this.builder.bearing(f).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateMyLocationIcon(float f) {
        Symbol symbol = this.deviceSymbol;
        if (symbol == null || this.symbolManager == null) {
            return;
        }
        symbol.setIconRotate(Float.valueOf(f));
        this.symbolManager.update((SymbolManager) this.deviceSymbol);
    }

    private void checkIsPair() {
        FlightRevFlightInfoData flightRevFlightInfoData;
        if ((this.curLat == 0.0d && this.curLng == 0.0d) || (flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData()) == null) {
            return;
        }
        if ((flightRevFlightInfoData.getLat() == 0.0d && flightRevFlightInfoData.getLng() == 0.0d) || this.deviceSymbol == null || this.symbolManager == null || this.planeSymbol == null) {
            return;
        }
        if (MapUtil.isPair(new LatLng(this.curLat, this.curLng), new LatLng(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng()), (int) this.deviceRotate)) {
            if (!this.deviceSymbol.getIconImage().equals("marker-image-device-pair")) {
                this.deviceSymbol.setIconImage("marker-image-device-pair");
                this.symbolManager.update((SymbolManager) this.deviceSymbol);
            }
            if (this.planeSymbol.getIconImage().equals("marker-image-plane-pair")) {
                return;
            }
            this.planeSymbol.setIconImage("marker-image-plane-pair");
            this.symbolManager.update((SymbolManager) this.planeSymbol);
            return;
        }
        if (!this.deviceSymbol.getIconImage().equals("marker-image-device")) {
            this.deviceSymbol.setIconImage("marker-image-device");
            this.symbolManager.update((SymbolManager) this.deviceSymbol);
        }
        if (this.planeSymbol.getIconImage().equals("marker-image-plane")) {
            return;
        }
        this.planeSymbol.setIconImage("marker-image-plane");
        this.symbolManager.update((SymbolManager) this.planeSymbol);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void startRotate(View view) {
        this.ivLock = view;
        this.isRotateStart = true;
        updateCameraBearing(this.deviceRotate);
        rotateMyLocationIcon(0.0f);
        View view2 = this.ivLock;
        if (view2 != null) {
            view2.setRotation(360.0f - this.deviceRotate);
        }
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void saveMarkFlight() {
        if (this.pointList.size() == 0) {
            return;
        }
        FlightRecordBean flightRecordBean = new FlightRecordBean();
        for (int i = 0; i < this.pointList.size(); i++) {
            if (i < this.pointList.size() - 1) {
                int i2 = i + 1;
                this.distanceTotal = (float) (this.distanceTotal + TurfMeasurement.distance(Point.fromLngLat(this.pointList.get(i).getLongitude(), this.pointList.get(i).getLatitude()), Point.fromLngLat(this.pointList.get(i2).getLongitude(), this.pointList.get(i2).getLatitude()), TurfConstants.UNIT_METERS));
            }
            MultiPointBean multiPointBean = new MultiPointBean();
            multiPointBean.setLat(this.pointList.get(i).getLatitude());
            multiPointBean.setLng(this.pointList.get(i).getLongitude());
            multiPointBean.setFlightRecordBean_id(flightRecordBean.getId());
            flightRecordBean.getList().add(multiPointBean);
            multiPointBean.save();
        }
        flightRecordBean.setNum(this.pointList.size());
        flightRecordBean.saveAsync().listen(new SaveCallback() { // from class: com.ipotensic.kernel.maps.mapbox.MapBoxMap.6
            @Override // org.litepal.crud.callback.SaveCallback
            public void onFinish(boolean z) {
                if (z) {
                    FlightConfig.isPointFlyFinished = false;
                    ToastUtil.showImageTop(MapBoxMap.this.context, MapBoxMap.this.context.getResources().getString(R.string.toast_map_save), R.mipmap.icon_toast_successful);
                }
            }
        });
        flightRecordBean.setDate(DateUtils.getDate());
        flightRecordBean.setDuration(FlightConfig.flightFlyTime);
        flightRecordBean.setHeight(((int) FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance()) + "m");
        flightRecordBean.setMileage(getMapPointsDistance(this.distanceTotal));
        flightRecordBean.setSpeed(((int) FlightRevData.get().getFlightRevFlightInfoData().getHorizontalDistance()) + SpeedLimit.KMPH);
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void showRecordMarkFlight(List<MultiPointBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        clearMarkAndPoly(true);
        this.listener.showGoBtn(true);
        int i = 0;
        while (i < list.size()) {
            double lat = list.get(i).getLat();
            double lng = list.get(i).getLng();
            LatLng latLng = new LatLng(lat, lng);
            this.pointList.add(latLng);
            this.removeList.add(latLng);
            LatLng latLng2 = this.pointList.get(i);
            i++;
            setDrawPoint(latLng2, i);
            if (this.removeList.size() > 1) {
                drawLine(this.removeList, true);
            }
            this.sendFlightList.add(new SendMultiPointData.LatLng(lat, lng));
        }
    }

    public ArrayList<LatLng> getPoint() {
        return this.pointList;
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void showHomePointLocation(double d, double d2) {
        if (this.map == null || this.symbolManager == null) {
            return;
        }
        if (this.homeLatLng == null) {
            this.homeLatLng = new LatLng(d, d2);
        }
        this.homeLatLng.setLatitude(d);
        this.homeLatLng.setLongitude(d2);
        if (this.isStyleLoaded) {
            if (this.homeSymbol == null) {
                this.homeSymbol = this.symbolManager.create((SymbolManager) new SymbolOptions().withIconImage("marker-image-home").withLatLng(this.homeLatLng));
            }
            this.homeSymbol.setLatLng(this.homeLatLng);
            this.symbolManager.update((SymbolManager) this.homeSymbol);
        }
        this.isHomePoint = true;
    }

    @Override // com.ipotensic.kernel.maps.BaseMap
    public void setZoomScale(float f) {
        MapboxMap mapboxMap = this.map;
        if (mapboxMap != null) {
            try {
                this.scaleView.update(f, mapboxMap.getCameraPosition().target.getLatitude());
            } catch (Exception e) {
                DDLog.e("\u5730\u56fescale\u51fa\u9519 \uff1a" + e.getMessage());
            }
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMapClickListener
    public boolean onMapClick(LatLng latLng) {
        DDLog.e("map  -> \u70b9\u51fb\u4e8b\u4ef6");
        this.point = latLng;
        if (this.listener == null) {
            return false;
        }
        this.listener.mapClick();
        return false;
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnScaleListener
    public void onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
        MapboxMap mapboxMap = this.map;
        if (mapboxMap != null) {
            float f = (float) mapboxMap.getCameraPosition().zoom;
            this.zoomScale = f;
            setZoomScale(f);
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        View view;
        if (eventID == EventID.EVENT_DEVICE_ROTATE_CHANGED) {
            float floatValue = ((Float) event.obj).floatValue();
            this.deviceRotate = floatValue;
            if (this.isRotateStart) {
                updateCameraBearing(floatValue);
                rotateMyLocationIcon(0.0f);
            } else {
                rotateMyLocationIcon(floatValue);
            }
            checkIsPair();
            return;
        }
        if (eventID == EventID.EVENT_COMPASS_ROTATE_CHANGED) {
            if (!this.isRotateStart || (view = this.ivLock) == null) {
                return;
            }
            view.setRotation(((Float) event.obj).floatValue());
            return;
        }
        if (eventID == EventID.EVENT_FLIGHT_LAT_LNG) {
            FlightRevFlightInfoData flightRevFlightInfoData = (FlightRevFlightInfoData) event.obj;
            if (flightRevFlightInfoData.getLng() == 0.0d || flightRevFlightInfoData.getLat() == 0.0d) {
                return;
            }
            if (this.isRotateStart) {
                flyAlwaysLocation(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng(), flightRevFlightInfoData.getDirectToNorth() - this.deviceRotate);
            } else {
                flyAlwaysLocation(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng(), flightRevFlightInfoData.getDirectToNorth());
            }
            checkIsPair();
            return;
        }
        if (eventID == EventID.EVENT_HOME_LAT_LNG) {
            FlightRevHomePointData flightRevHomePointData = (FlightRevHomePointData) event.obj;
            this.flightRevHomePointData = flightRevHomePointData;
            if (flightRevHomePointData.getLng() == 0.0d || this.flightRevHomePointData.getLat() == 0.0d) {
                return;
            }
            showHomePointLocation(this.flightRevHomePointData.getLat(), this.flightRevHomePointData.getLng());
            return;
        }
        if (eventID != EventID.FLIGHT_CONNECT_STATE_CHANGED && eventID == EventID.EVENT_UNIT_CHANGED) {
            this.scaleView.update(this.zoomScale, this.curLat);
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        this.isAnimated = z;
        MapboxMap mapboxMap = this.map;
        if (mapboxMap != null) {
            float f = (float) mapboxMap.getCameraPosition().zoom;
            this.zoomScale = f;
            setZoomScale(f);
        }
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
    public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
        this.isMoveEnd = false;
    }

    @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
    public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
        this.isMoveEnd = true;
    }

    public void animateCamera(CameraUpdate cameraUpdate, int i) {
        MapboxMap mapboxMap = this.map;
        if (mapboxMap != null) {
            mapboxMap.animateCamera(cameraUpdate, i);
        }
    }
}