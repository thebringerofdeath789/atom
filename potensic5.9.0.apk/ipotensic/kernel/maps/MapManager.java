package com.ipotensic.kernel.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.FlightRecordAdapter;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.kernel.bean.FlightRecordBean;
import com.ipotensic.kernel.enums.Mode;
import com.ipotensic.kernel.maps.bean.CircleStyle;
import com.ipotensic.kernel.maps.bean.CommonLatLng;
import com.ipotensic.kernel.maps.bean.PolygonStyle;
import com.ipotensic.kernel.maps.mapbox.MapBoxMap;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.deleteview.SwipeItemLayout;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.send.SendMultiPointData;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.Style;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;

/* loaded from: classes2.dex */
public class MapManager implements View.OnClickListener, MapInfoListener, FlightRecordAdapter.OnItemClickListener {
    private static final String TAG = "MapManager";
    private FlightRecordAdapter adapter;
    private Context context;
    private View flightRecordView;
    private boolean isEnableMark;
    private boolean isPointFly;
    private ImageButton ivCancelFly;
    private ImageButton ivGo;
    private ImageButton ivLock;
    private ImageButton ivMapMark;
    private ImageButton ivMapSetHide;
    private ImageButton ivSatelliteMode;
    private ImageButton ivStandardMode;
    private ImageButton ivStandardNightMode;
    private ImageButton ivWayPointCancel;
    private ImageButton ivWayPointFly;
    private ImageButton ivWayPointStopFly;
    private BaseMap map;
    private View mapBtnView;
    private MapClickedListener mapClickedListener;
    private View mapView;
    private RecyclerView recyclerView;
    private ConstraintLayout viewCenterPosition;
    private ConstraintLayout viewMapSet;
    private ConstraintLayout viewMapType;
    private List<FlightRecordBean> recordList = new ArrayList();
    private boolean isStartRotate = false;

    public interface MapClickedListener {
        void lowPower();

        void noGpsMode();

        void onMapClicked();
    }

    public Object drawCircle(CircleStyle circleStyle) {
        return null;
    }

    public Object drawPolygon(PolygonStyle polygonStyle) {
        return null;
    }

    @Override // com.ipotensic.kernel.maps.MapInfoListener
    public void onLocationInfo(double d, double d2, short s, short s2, short s3) {
    }

    public void removeCircle(Object obj) {
    }

    public void removeCircle(ArrayList<Object> arrayList) {
    }

    public void removePolygon(Object obj) {
    }

    public void removePolygon(ArrayList<Object> arrayList) {
    }

    public void updateCircle(Object obj, CircleStyle circleStyle) {
    }

    public void updatePolygon(Object obj, PolygonStyle polygonStyle) {
    }

    public View setMap(AppCompatActivity appCompatActivity) {
        this.mapView = appCompatActivity.getLayoutInflater().inflate(R.layout.view_map_box, (ViewGroup) null, false);
        this.map = new MapBoxMap(appCompatActivity, (MapView) this.mapView);
        return this.mapView;
    }

    public BaseMap getMap() {
        return this.map;
    }

    public View getMapView() {
        return this.mapView;
    }

    public void setMapBtnView(View... viewArr) {
        View view = viewArr[0];
        this.mapBtnView = view;
        this.recyclerView = (RecyclerView) viewArr[1];
        this.flightRecordView = viewArr[2];
        MapScaleView mapScaleView = (MapScaleView) viewArr[3];
        this.context = view.getContext();
        initView();
        this.map.setView(this.mapBtnView, mapScaleView);
        this.map.setMapInfoListener(this);
    }

    private void initView() {
        ImageButton imageButton = (ImageButton) this.mapBtnView.findViewById(R.id.iv_map_position);
        ImageButton imageButton2 = (ImageButton) this.mapBtnView.findViewById(R.id.iv_map_type);
        this.ivLock = (ImageButton) this.mapBtnView.findViewById(R.id.iv_map_lock);
        this.ivMapSetHide = (ImageButton) this.mapBtnView.findViewById(R.id.iv_map_set_hide);
        this.ivMapMark = (ImageButton) this.mapBtnView.findViewById(R.id.iv_map_mark);
        this.ivGo = (ImageButton) this.mapBtnView.findViewById(R.id.iv_go);
        this.ivCancelFly = (ImageButton) this.mapBtnView.findViewById(R.id.iv_cancel_fly);
        ImageButton imageButton3 = (ImageButton) this.mapBtnView.findViewById(R.id.iv_waypoint_fly);
        this.ivWayPointFly = imageButton3;
        imageButton3.setVisibility((FlightConfig.isConnectFlight() && FlightConfig.isAtomPanTilt()) ? 0 : 8);
        this.ivWayPointCancel = (ImageButton) this.mapBtnView.findViewById(R.id.iv_waypoint_cancel);
        this.ivWayPointStopFly = (ImageButton) this.mapBtnView.findViewById(R.id.iv_waypoint_stop_fly);
        ImageButton imageButton4 = (ImageButton) this.mapBtnView.findViewById(R.id.btn_map_clear);
        ImageButton imageButton5 = (ImageButton) this.mapBtnView.findViewById(R.id.btn_map_mark);
        ImageButton imageButton6 = (ImageButton) this.mapBtnView.findViewById(R.id.btn_mark_save);
        ImageButton imageButton7 = (ImageButton) this.mapBtnView.findViewById(R.id.btn_map_show);
        this.viewCenterPosition = (ConstraintLayout) this.mapBtnView.findViewById(R.id.view_map_position);
        this.viewMapType = (ConstraintLayout) this.mapBtnView.findViewById(R.id.view_map_type);
        this.viewMapSet = (ConstraintLayout) this.mapBtnView.findViewById(R.id.view_map_set);
        ImageButton imageButton8 = (ImageButton) this.viewCenterPosition.findViewById(R.id.iv_fly_home_position);
        ImageButton imageButton9 = (ImageButton) this.viewCenterPosition.findViewById(R.id.iv_my_position);
        ImageButton imageButton10 = (ImageButton) this.viewCenterPosition.findViewById(R.id.iv_fly_position);
        this.ivStandardMode = (ImageButton) this.viewMapType.findViewById(R.id.iv_map_standard);
        this.ivSatelliteMode = (ImageButton) this.viewMapType.findViewById(R.id.iv_map_satellite);
        this.ivStandardNightMode = (ImageButton) this.viewMapType.findViewById(R.id.iv_map_night);
        imageButton8.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        this.ivLock.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        this.ivMapSetHide.setOnClickListener(this);
        this.ivMapMark.setOnClickListener(this);
        this.ivGo.setOnClickListener(this);
        this.ivCancelFly.setOnClickListener(this);
        this.ivWayPointFly.setOnClickListener(this);
        this.ivWayPointCancel.setOnClickListener(this);
        this.ivWayPointStopFly.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        this.viewCenterPosition.setOnClickListener(this);
        this.viewMapType.setOnClickListener(this);
        this.viewMapSet.setOnClickListener(this);
        imageButton9.setOnClickListener(this);
        imageButton10.setOnClickListener(this);
        this.ivStandardMode.setOnClickListener(this);
        this.ivSatelliteMode.setOnClickListener(this);
        this.ivStandardNightMode.setOnClickListener(this);
    }

    public void setMapBtnVisible(boolean z, boolean z2) {
        if (this.map == null) {
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            AnimationUtil.transOutRight(this.recyclerView);
            AnimationUtil.transInRight(this.mapBtnView);
        }
        View view = this.flightRecordView;
        if (view != null && view.getVisibility() == 0) {
            AnimationUtil.transOutRight(this.flightRecordView);
            AnimationUtil.transInRight(this.mapBtnView);
        }
        this.isPointFly = z;
        this.viewMapSet.setVisibility(z ? 0 : 8);
        if (z) {
            if (((MapBoxMap) this.map).getPoint().size() > 0) {
                showGoBtn(true);
            }
        } else {
            this.ivGo.setVisibility(8);
            this.map.clearMarkAndPoly(z2);
        }
        this.ivCancelFly.setVisibility(8);
        this.ivMapSetHide.setVisibility(8);
        if (this.viewMapSet.getVisibility() == 0) {
            this.viewMapType.setVisibility(8);
            this.viewCenterPosition.setVisibility(8);
        }
        if (FlightConfig.isAtomPanTilt()) {
            this.ivMapMark.setVisibility(8);
            this.ivWayPointFly.setVisibility(z ? 8 : 0);
            this.ivWayPointCancel.setVisibility(z ? 0 : 8);
            this.ivWayPointStopFly.setVisibility(8);
            setMarkEnable(z);
            return;
        }
        this.ivMapMark.setImageResource(R.mipmap.icon_map_mark_bg);
        this.ivMapMark.setVisibility(z ? 0 : 8);
        setMarkEnable(false);
    }

    public void onGoBtnCancel(boolean z) {
        BaseMap baseMap = this.map;
        if (baseMap == null || ((MapBoxMap) baseMap).getPoint().size() == 0 || !FlightRevData.get().getFlightRevStateData().isFlight()) {
            return;
        }
        this.isPointFly = !z;
        this.ivGo.setVisibility(z ? 8 : 0);
        this.viewMapSet.setVisibility(z ? 8 : 0);
        this.ivMapSetHide.setVisibility(8);
        this.ivMapMark.setImageResource(R.mipmap.icon_map_mark_bg);
        if (FlightConfig.isAtomPanTilt()) {
            this.ivCancelFly.setVisibility(8);
            this.ivMapMark.setVisibility(8);
            this.ivWayPointStopFly.setVisibility(z ? 0 : 8);
            this.ivWayPointCancel.setVisibility(z ? 8 : 0);
            setMarkEnable(!z);
        } else {
            this.ivCancelFly.setVisibility((!z || FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
            this.ivMapMark.setVisibility(z ? 8 : 0);
            setMarkEnable(false);
        }
        if (this.viewMapSet.getVisibility() == 0) {
            this.viewMapType.setVisibility(8);
            this.viewCenterPosition.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_map_position) {
            ConstraintLayout constraintLayout = this.viewCenterPosition;
            constraintLayout.setVisibility(constraintLayout.getVisibility() != 0 ? 0 : 8);
            this.viewMapType.setVisibility(8);
            this.viewMapSet.setVisibility(8);
            if (this.isPointFly) {
                this.ivMapSetHide.setVisibility(0);
                return;
            }
            return;
        }
        if (id == R.id.iv_map_type) {
            ConstraintLayout constraintLayout2 = this.viewMapType;
            constraintLayout2.setVisibility(constraintLayout2.getVisibility() != 0 ? 0 : 8);
            this.viewCenterPosition.setVisibility(8);
            this.viewMapSet.setVisibility(8);
            if (this.isPointFly) {
                this.ivMapSetHide.setVisibility(0);
            }
            String mapMode = ((MapBoxMap) this.map).getMapMode();
            this.ivStandardMode.setBackground(mapMode.equals(Style.MAPBOX_STREETS) ? this.context.getDrawable(R.mipmap.icon_map_style_select) : null);
            this.ivSatelliteMode.setBackground(mapMode.equals(Style.SATELLITE) ? this.context.getDrawable(R.mipmap.icon_map_style_select) : null);
            this.ivStandardNightMode.setBackground(mapMode.equals(Style.TRAFFIC_NIGHT) ? this.context.getDrawable(R.mipmap.icon_map_style_select) : null);
            return;
        }
        if (id == R.id.iv_map_set_hide) {
            this.viewCenterPosition.setVisibility(8);
            this.viewMapType.setVisibility(8);
            this.ivMapSetHide.setVisibility(8);
            this.viewMapSet.setVisibility(0);
            return;
        }
        if (id == R.id.btn_map_show) {
            this.viewMapSet.setVisibility(8);
            this.ivMapSetHide.setVisibility(0);
            return;
        }
        if (id == R.id.iv_map_lock) {
            boolean z = !this.isStartRotate;
            this.isStartRotate = z;
            this.ivLock.setImageResource(z ? R.mipmap.icon_compass_nor : R.mipmap.icon_map_lock);
            if (this.isStartRotate) {
                this.map.startRotate(this.ivLock);
                return;
            } else {
                this.map.stopRotate();
                return;
            }
        }
        if (id == R.id.iv_map_mark) {
            boolean z2 = !this.isEnableMark;
            this.isEnableMark = z2;
            this.ivMapMark.setImageResource(z2 ? R.mipmap.icon_map_check_mark : R.mipmap.icon_map_mark_bg);
            return;
        }
        if (id == R.id.iv_go) {
            if (Conditions.isTrackTargetOpen()) {
                return;
            }
            this.map.fly();
            return;
        }
        if (id == R.id.iv_cancel_fly) {
            if (BaseSyncDialog.isShow) {
                return;
            }
            Context context = this.context;
            new GeneralDialog(context, context.getString(R.string.dialog_quit_cur_mode), this.context.getString(R.string.dialog_quit_cur_mode_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.maps.MapManager.1
                AnonymousClass1() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                    if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                        FlightSendData.get().setPointFly();
                        FlightConfig.isInterruptFly = true;
                    }
                }
            }).show();
            return;
        }
        if (id == R.id.iv_my_position) {
            if (checkPermissionTip(PhoneConfig.runningActivity)) {
                this.map.showMyLocation();
                this.viewCenterPosition.setVisibility(8);
                return;
            }
            return;
        }
        if (id == R.id.iv_fly_position) {
            this.map.showFlyLocation();
            this.viewCenterPosition.setVisibility(8);
            return;
        }
        if (id == R.id.iv_fly_home_position) {
            this.map.showFlyStartLocation();
            this.viewCenterPosition.setVisibility(8);
            return;
        }
        if (id == R.id.iv_map_standard) {
            this.viewMapType.setVisibility(8);
            this.map.setMapType(Style.MAPBOX_STREETS);
            return;
        }
        if (id == R.id.iv_map_satellite) {
            this.viewMapType.setVisibility(8);
            this.map.setMapType(Style.SATELLITE);
            return;
        }
        if (id == R.id.iv_map_night) {
            this.viewMapType.setVisibility(8);
            this.map.setMapType(Style.TRAFFIC_NIGHT);
            return;
        }
        if (id == R.id.btn_map_clear) {
            this.map.clearMarkAndPoly(true);
            return;
        }
        if (id == R.id.btn_map_mark) {
            LitePal.findAllAsync(FlightRecordBean.class, new long[0]).listen(new FindMultiCallback() { // from class: com.ipotensic.kernel.maps.MapManager.2
                AnonymousClass2() {
                }

                @Override // org.litepal.crud.callback.FindMultiCallback
                public <T> void onFinish(List<T> list) {
                    MapManager.this.recordList = list;
                    Collections.sort(MapManager.this.recordList);
                    if (MapManager.this.recordList.size() > 0) {
                        MapManager.this.showRecycleView();
                    }
                }
            });
            return;
        }
        if (id == R.id.btn_mark_save) {
            if (!FlightConfig.isPointFlyFinished || FlightConfig.isInterruptFly) {
                return;
            }
            this.map.saveMarkFlight();
            return;
        }
        if (id == R.id.iv_waypoint_fly) {
            DDLog.e(TAG, "\u65b0\u7248\u822a\u70b9\u6a21\u5f0f");
            if (Conditions.isTrackTargetOpen()) {
                Context context2 = this.context;
                new GeneralDialog(context2, context2.getString(R.string.dialog_quit_quickshot_mode_title), this.context.getString(R.string.dialog_quit_quickshot_mode_describe), new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.maps.-$$Lambda$MapManager$q-U8QJHUfvjivrSGbg6N87p0KHg
                    public /* synthetic */ $$Lambda$MapManager$qU8QJHUfvjivrSGbg6N87p0KHg() {
                    }

                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public final void confirm() {
                        MapManager.this.lambda$onClick$0$MapManager();
                    }
                }).show();
                return;
            } else {
                if (setWayPointFlightConditions()) {
                    EventDispatcher.get().sendEvent(EventID.FLIGHT_WAYPOINT_CONTROL, true);
                    this.ivWayPointFly.setVisibility(8);
                    this.ivWayPointCancel.setVisibility(0);
                    FlightConfig.enterPointFly = true;
                    return;
                }
                return;
            }
        }
        if (id == R.id.iv_waypoint_cancel) {
            EventDispatcher.get().sendEvent(EventID.FLIGHT_WAYPOINT_CONTROL, false);
            FlightConfig.enterPointFly = false;
            if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                FlightSendData.get().setPointFly();
                FlightConfig.isInterruptFly = true;
                return;
            }
            return;
        }
        if (id == R.id.iv_waypoint_stop_fly) {
            Context context3 = this.context;
            new GeneralDialog(context3, context3.getString(R.string.dialog_quit_cur_mode), this.context.getString(R.string.dialog_quit_cur_mode_describe), (String) null, (String) null, false, 2, (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.maps.MapManager.3
                AnonymousClass3() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                    if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                        MapManager.this.setExitWayPointFlight(true);
                    }
                }
            }).show();
        }
    }

    /* renamed from: com.ipotensic.kernel.maps.MapManager$1 */
    class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                FlightSendData.get().setPointFly();
                FlightConfig.isInterruptFly = true;
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.maps.MapManager$2 */
    class AnonymousClass2 implements FindMultiCallback {
        AnonymousClass2() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public <T> void onFinish(List<T> list) {
            MapManager.this.recordList = list;
            Collections.sort(MapManager.this.recordList);
            if (MapManager.this.recordList.size() > 0) {
                MapManager.this.showRecycleView();
            }
        }
    }

    public /* synthetic */ void lambda$onClick$0$MapManager() {
        if (setWayPointFlightConditions()) {
            EventDispatcher.get().sendEvent(EventID.EXIT_QUICK_SHOT);
            EventDispatcher.get().sendEvent(EventID.FLIGHT_WAYPOINT_CONTROL, true);
            this.ivWayPointFly.setVisibility(8);
            this.ivWayPointCancel.setVisibility(0);
            FlightConfig.enterPointFly = true;
        }
    }

    /* renamed from: com.ipotensic.kernel.maps.MapManager$3 */
    class AnonymousClass3 implements GeneralDialog.ClickConfirmListener {
        AnonymousClass3() {
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
                MapManager.this.setExitWayPointFlight(true);
            }
        }
    }

    public void showWayPointFlyBtn(Boolean bool) {
        this.ivWayPointFly.setVisibility((bool.booleanValue() && FlightConfig.isAtomPanTilt()) ? 0 : 8);
    }

    public void showMyLocation() {
        BaseMap baseMap = this.map;
        if (baseMap != null) {
            baseMap.showMyLocation();
        }
    }

    public void setCurMapMode(Mode mode) {
        BaseMap baseMap = this.map;
        if (baseMap != null) {
            ((MapBoxMap) baseMap).setCurMode(mode);
        }
    }

    public void showRecycleView() {
        AnimationUtil.transOutRight(this.mapBtnView);
        AnimationUtil.transInRight(this.recyclerView);
        this.recyclerView.bringToFront();
        this.recyclerView.setLayoutManager(new MyLinearLayoutManager(this.context, 1, false));
        this.recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this.context));
        FlightRecordAdapter flightRecordAdapter = new FlightRecordAdapter(this.context);
        this.adapter = flightRecordAdapter;
        this.recyclerView.setAdapter(flightRecordAdapter);
        this.adapter.setData(this.recordList);
        this.adapter.setOnItemClickListener(this);
    }

    @Override // com.ipotensic.kernel.adapter.FlightRecordAdapter.OnItemClickListener
    public void onItemClick(int i) {
        try {
            if (this.recyclerView.getVisibility() == 0) {
                this.recyclerView.setVisibility(8);
                AnimationUtil.transInRight(this.flightRecordView);
                this.flightRecordView.bringToFront();
            }
            TextView textView = (TextView) this.flightRecordView.findViewById(R.id.tv_date);
            TextView textView2 = (TextView) this.flightRecordView.findViewById(R.id.edt_speed);
            TextView textView3 = (TextView) this.flightRecordView.findViewById(R.id.tv_height);
            TextView textView4 = (TextView) this.flightRecordView.findViewById(R.id.tv_mileage);
            TextView textView5 = (TextView) this.flightRecordView.findViewById(R.id.tv_duration);
            List<FlightRecordBean> list = this.recordList;
            if (list != null && list.size() > 0) {
                textView.setText(this.recordList.get(i).getDate());
                textView5.setText(getFlightTime(this.recordList.get(i).getDuration()));
                if (SPHelper.getInstance().isFt()) {
                    textView2.setText(String.format(this.context.getString(R.string.units_mph), Double.valueOf(Double.parseDouble(this.recordList.get(i).getSpeed().substring(0, r0.length() - 4)) * 0.6213712d)));
                    String height = this.recordList.get(i).getHeight();
                    textView3.setText(String.format(this.context.getString(R.string.units_ft), Double.valueOf(Double.parseDouble(height.substring(0, height.length() - 1)) * 3.28083989501d)));
                    String mileage = this.recordList.get(i).getMileage();
                    if (mileage.endsWith("km")) {
                        textView4.setText(String.format(this.context.getString(R.string.units_mi), Double.valueOf(Double.parseDouble(mileage.substring(0, mileage.length() - 2)) * 0.6213712d)));
                    } else {
                        textView4.setText(String.format(this.context.getString(R.string.units_ft), Double.valueOf(Double.parseDouble(mileage.substring(0, mileage.length() - 1)) * 3.28083989501d)));
                    }
                } else {
                    textView2.setText(this.recordList.get(i).getSpeed());
                    textView3.setText(this.recordList.get(i).getHeight());
                    textView4.setText(this.recordList.get(i).getMileage());
                }
            }
            this.map.showRecordMarkFlight(new FlightRecordBean().getMultiPointBeans(this.recordList.get(i).getId()));
        } catch (Exception e) {
            DDLog.e("\u70b9\u51fb\u5730\u56fe\u9519\u8bef:" + e.getMessage());
        }
    }

    @Override // com.ipotensic.kernel.adapter.FlightRecordAdapter.OnItemClickListener
    public void isEmpty(boolean z) {
        AnimationUtil.transOutRight(this.recyclerView);
        AnimationUtil.transInRight(this.mapBtnView);
    }

    private String getFlightTime(long j) {
        long j2 = j / 1000;
        if (j2 >= 60) {
            return (j2 / 60) + "min";
        }
        return j2 + "s";
    }

    public void onLocationChanged(double d, double d2) {
        BaseMap baseMap = this.map;
        if (baseMap != null) {
            baseMap.locationStart(d, d2);
        }
    }

    public void onSystemLocationChanged(double d, double d2) {
        BaseMap baseMap = this.map;
        if (baseMap != null) {
            baseMap.systemLocationStart(d, d2);
        }
    }

    @Override // com.ipotensic.kernel.maps.MapInfoListener
    public void startFlight(ArrayList<SendMultiPointData.LatLng> arrayList) {
        if (FlightRevData.get().getFlightRevStateData().getMode() != 2) {
            MapClickedListener mapClickedListener = this.mapClickedListener;
            if (mapClickedListener != null) {
                mapClickedListener.noGpsMode();
                return;
            }
            return;
        }
        if (FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() <= 20) {
            MapClickedListener mapClickedListener2 = this.mapClickedListener;
            if (mapClickedListener2 != null) {
                mapClickedListener2.lowPower();
                return;
            }
            return;
        }
        if (setIntelligentFlightConditions()) {
            FlightSendData.get().setPointFly();
            Handler handler = new Handler();
            AnonymousClass4 anonymousClass4 = new Runnable() { // from class: com.ipotensic.kernel.maps.MapManager.4
                final /* synthetic */ ArrayList val$list;

                AnonymousClass4(ArrayList arrayList2) {
                    r2 = arrayList2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    FlightSendData.get().getSendMultiPointData().setPoints(r2);
                    DataManager.getInstance().startSendMultiPointData();
                }
            };
            handler.postDelayed(anonymousClass4, 200L);
            handler.postDelayed(anonymousClass4, 500L);
            handler.postDelayed(anonymousClass4, 1000L);
            FlightConfig.isInterruptFly = false;
        }
    }

    /* renamed from: com.ipotensic.kernel.maps.MapManager$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ ArrayList val$list;

        AnonymousClass4(ArrayList arrayList2) {
            r2 = arrayList2;
        }

        @Override // java.lang.Runnable
        public void run() {
            FlightSendData.get().getSendMultiPointData().setPoints(r2);
            DataManager.getInstance().startSendMultiPointData();
        }
    }

    private boolean setIntelligentFlightConditions() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return flightRevStateData != null && flightRevStateData.isFlight() && flightRevStateData.isReceiveGps() && !flightRevStateData.isLowPowerMode();
    }

    private boolean setWayPointFlightConditions() {
        if (!FlightRevData.get().getFlightRevStateData().isFlight()) {
            Context context = this.context;
            ToastUtil.toast((Activity) context, context.getString(R.string.waypoint_not_flight));
            return false;
        }
        if (FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() <= 20) {
            Context context2 = this.context;
            ToastUtil.toast((Activity) context2, context2.getString(R.string.waypoint_low_battery));
            return false;
        }
        if (FlightRevData.get().getFlightRevStateData().isReturning()) {
            Context context3 = this.context;
            ToastUtil.toast((Activity) context3, context3.getString(R.string.returning_waypoint_flight_unavailable));
            return false;
        }
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (flightRevStateData == null) {
            return true;
        }
        if (flightRevStateData.getMode() == 2) {
            if (FlightConfig.GPS.getAccuracy() > 70) {
                Context context4 = this.context;
                ToastUtil.toast((Activity) context4, context4.getString(R.string.gps_accuracy_low_waypoint_flight));
                return false;
            }
            if (FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() >= 5.0d) {
                return true;
            }
            Context context5 = this.context;
            ToastUtil.toast((Activity) context5, context5.getString(R.string.setting_height_low_waypoint_flight));
            return false;
        }
        Context context6 = this.context;
        ToastUtil.toast((Activity) context6, context6.getString(R.string.toast_gps_tips));
        return false;
    }

    public void exitWayPointFlightConditions(FlightRevStateData flightRevStateData) {
        if (flightRevStateData == null || !flightRevStateData.isPointFly()) {
            return;
        }
        if (FlightConfig.GPS.getAccuracy() > 70) {
            Context context = this.context;
            ToastUtil.toast((Activity) context, context.getString(R.string.gps_accuracy_low_exit_waypoint_flight));
            setExitWayPointFlight(false);
        } else if (flightRevStateData.isPlaneExceedLimitDistance() || flightRevStateData.isPlaneExceedLimitHigh()) {
            Context context2 = this.context;
            ToastUtil.toast((Activity) context2, context2.getString(R.string.waypoint_flight_arrive_fence));
            setExitWayPointFlight(false);
        } else if (FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() < 5.0d) {
            Context context3 = this.context;
            ToastUtil.toast((Activity) context3, context3.getString(R.string.setting_height_low_waypoint_follow_fail));
            setExitWayPointFlight(false);
        }
    }

    public void setExitWayPointFlight(boolean z) {
        if (FlightRevData.get().getFlightRevStateData().isPointFly()) {
            FlightSendData.get().setPointFly();
            FlightConfig.isInterruptFly = true;
        }
        if (!z) {
            FlightConfig.enterPointFly = false;
            EventDispatcher.get().sendEvent(EventID.FLIGHT_WAYPOINT_CONTROL, false);
        } else {
            EventDispatcher.get().sendEvent(EventID.FLIGHT_WAYPOINT_CONTROL, true);
        }
        ImageButton imageButton = this.ivWayPointFly;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 8 : 0);
        }
        ImageButton imageButton2 = this.ivWayPointCancel;
        if (imageButton2 != null) {
            imageButton2.setVisibility(z ? 0 : 8);
        }
        ImageButton imageButton3 = this.ivWayPointStopFly;
        if (imageButton3 != null) {
            imageButton3.setVisibility(8);
        }
    }

    public void setMapClickedListener(MapClickedListener mapClickedListener) {
        this.mapClickedListener = mapClickedListener;
    }

    @Override // com.ipotensic.kernel.maps.MapInfoListener
    public void mapClick() {
        MapClickedListener mapClickedListener = this.mapClickedListener;
        if (mapClickedListener != null) {
            mapClickedListener.onMapClicked();
        }
    }

    @Override // com.ipotensic.kernel.maps.MapInfoListener
    public void showGoBtn(boolean z) {
        if (z) {
            if (!FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevFlightInfoData().isGpsWeak()) {
                return;
            }
            this.ivGo.setVisibility(0);
            return;
        }
        this.ivGo.setVisibility(8);
    }

    public boolean isEnableMark() {
        return this.isEnableMark;
    }

    public void setMarkEnable(boolean z) {
        this.isEnableMark = z;
    }

    /* renamed from: com.ipotensic.kernel.maps.MapManager$5 */
    class AnonymousClass5 implements SimpleResultListener<Boolean> {
        @Override // com.ipotensic.baselib.listener.SimpleResultListener
        public void onResult(Boolean bool) {
        }

        AnonymousClass5() {
        }
    }

    public boolean checkPermissionTip(BaseActivity baseActivity) {
        PermissionUtil.requestLocationPermissionAndGpsEnable(baseActivity, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.maps.MapManager.5
            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
            }

            AnonymousClass5() {
            }
        });
        return PermissionUtil.hasLocationPermission(baseActivity);
    }

    public Boolean isPointInPolygon(CommonLatLng commonLatLng, Object obj) {
        return false;
    }

    public Boolean isPolygonVisibleRegion(ArrayList<CommonLatLng> arrayList) {
        return false;
    }

    public Boolean isCircleVisibleRegion(CommonLatLng commonLatLng, Double d) {
        return false;
    }

    public Boolean isPolygonBounds(ArrayList<CommonLatLng> arrayList, Object obj) {
        return false;
    }

    public Boolean isCircleBounds(CommonLatLng commonLatLng, Double d, Object obj) {
        return false;
    }
}