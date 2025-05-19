package com.ipotensic.potensicpro.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.kernel.utils.MapUtil;
import com.ipotensic.potensicpro.R;
import com.logan.flight.FlightConfig;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.plugins.annotation.Circle;
import com.mapbox.mapboxsdk.plugins.annotation.CircleManager;
import com.mapbox.mapboxsdk.plugins.annotation.CircleOptions;
import com.mapbox.mapboxsdk.plugins.annotation.Line;
import com.mapbox.mapboxsdk.plugins.annotation.LineManager;
import com.mapbox.mapboxsdk.plugins.annotation.LineOptions;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.utils.ColorUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FindDroneViewModel extends AndroidViewModel {
    private static final String TAG = "FindDroneViewModel";
    public final String MARKER_IMAGE_DEVICE;
    public final String MARKER_IMAGE_HOME;
    public final String MARKER_IMAGE_PHONE;
    public final String MARKER_IMAGE_PHONE_UNCONNECT;
    public final String MARKER_TEXT_DISTANCE;
    public final String MARKER_TEXT_PLANE;
    public MutableLiveData<Circle> circle;
    public MutableLiveData<CircleManager> circleManager;
    public MutableLiveData<Double> curHomeLat;
    public MutableLiveData<Double> curHomeLng;
    public MutableLiveData<Double> curLat;
    public MutableLiveData<Double> curLng;
    public MutableLiveData<Double> curPlaneLat;
    public MutableLiveData<Double> curPlaneLng;
    public MutableLiveData<Float> deviceRotate;
    public MutableLiveData<Symbol> deviceSymbol;
    public MutableLiveData<Symbol> distanceSymbol;
    private List<LatLng> homeLatLngs;
    public MutableLiveData<Line> homeLine;
    public MutableLiveData<Symbol> homeSymbol;
    public MutableLiveData<Boolean> isFindingDrone;
    public MutableLiveData<Boolean> isStyleLoaded;
    public MutableLiveData<Line> line;
    public MutableLiveData<LineManager> lineManager;
    private List<LatLng> phoneLatLngs;
    private List<LatLng> planeHomeLatLngs;
    private List<LatLng> planePhoneLatLngs;
    public MutableLiveData<Symbol> planeSymbol;
    public MutableLiveData<Boolean> setStartBeep;
    public MutableLiveData<Boolean> showBeepBtn;
    public MutableLiveData<Boolean> startGps;
    public MutableLiveData<SymbolManager> symbolManager;
    public MutableLiveData<String> textStr;
    public MutableLiveData<Symbol> textSymbol;
    public MutableLiveData<Float> zoomScale;

    public FindDroneViewModel(Application application) {
        super(application);
        this.MARKER_IMAGE_DEVICE = "marker-image-device";
        this.MARKER_IMAGE_PHONE = "marker_image_plane";
        this.MARKER_IMAGE_PHONE_UNCONNECT = "marker_image_plane_unconnect";
        this.MARKER_IMAGE_HOME = "marker_image_home";
        this.MARKER_TEXT_PLANE = "marker-text-plane";
        this.MARKER_TEXT_DISTANCE = "marker-text-distance";
        this.setStartBeep = new MutableLiveData<>(false);
        this.isStyleLoaded = new MutableLiveData<>(false);
        Double valueOf = Double.valueOf(0.0d);
        this.curPlaneLat = new MutableLiveData<>(valueOf);
        this.curPlaneLng = new MutableLiveData<>(valueOf);
        this.curLat = new MutableLiveData<>(valueOf);
        this.curLng = new MutableLiveData<>(valueOf);
        this.curHomeLat = new MutableLiveData<>(valueOf);
        this.curHomeLng = new MutableLiveData<>(valueOf);
        this.deviceSymbol = new MutableLiveData<>();
        this.textSymbol = new MutableLiveData<>();
        this.homeSymbol = new MutableLiveData<>();
        this.planeSymbol = new MutableLiveData<>();
        this.distanceSymbol = new MutableLiveData<>();
        this.circleManager = new MutableLiveData<>();
        this.circle = new MutableLiveData<>();
        this.lineManager = new MutableLiveData<>();
        this.line = new MutableLiveData<>();
        this.homeLine = new MutableLiveData<>();
        this.symbolManager = new MutableLiveData<>();
        this.textStr = new MutableLiveData<>();
        this.zoomScale = new MutableLiveData<>(Float.valueOf(16.0f));
        this.deviceRotate = new MutableLiveData<>(Float.valueOf(0.0f));
        this.showBeepBtn = new MutableLiveData<>(false);
        this.startGps = new MutableLiveData<>(false);
        this.isFindingDrone = new MutableLiveData<>(false);
        this.phoneLatLngs = new ArrayList();
        this.homeLatLngs = new ArrayList();
        this.planePhoneLatLngs = new ArrayList();
        this.planeHomeLatLngs = new ArrayList();
    }

    public void drawCircle(float f) {
        if (this.circleManager.getValue() != null && this.isStyleLoaded.getValue().booleanValue()) {
            if (this.circle.getValue() == null) {
                this.circle.setValue(this.circleManager.getValue().create((CircleManager) new CircleOptions().withLatLng(new LatLng(this.curPlaneLat.getValue().doubleValue(), this.curPlaneLng.getValue().doubleValue())).withCircleColor(ColorUtils.colorToRgbaString(getApplication().getResources().getColor(R.color.color_map_mark_new)))));
            }
            this.circle.getValue().setCircleRadius(Float.valueOf(f));
            this.circleManager.getValue().update((CircleManager) this.circle.getValue());
        }
    }

    public void drawLine(MapboxMap mapboxMap, List<LatLng> list, boolean z) {
        if (this.lineManager.getValue() == null || mapboxMap == null || !this.isStyleLoaded.getValue().booleanValue()) {
            return;
        }
        if (z) {
            drawHomeLine(list);
        } else {
            drawPlaneLine(list);
        }
    }

    private void drawHomeLine(List<LatLng> list) {
        if (this.homeLine.getValue() != null) {
            this.lineManager.getValue().delete((LineManager) this.homeLine.getValue());
            this.homeLine.setValue(null);
        }
        if (this.homeLine.getValue() == null) {
            this.homeLine.setValue(this.lineManager.getValue().create((LineManager) new LineOptions().withLatLngs(list).withLineColor(ColorUtils.colorToRgbaString(getApplication().getResources().getColor(R.color.colorText)))));
        }
        this.homeLine.getValue().setLineWidth(Float.valueOf(2.0f));
        this.lineManager.getValue().update((LineManager) this.homeLine.getValue());
    }

    private void drawPlaneLine(List<LatLng> list) {
        if (this.line.getValue() != null) {
            this.lineManager.getValue().delete((LineManager) this.line.getValue());
            this.line.setValue(null);
        }
        if (this.line.getValue() == null) {
            this.line.setValue(this.lineManager.getValue().create((LineManager) new LineOptions().withLatLngs(list).withLineColor(ColorUtils.colorToRgbaString(getApplication().getResources().getColor(R.color.color_map_line)))));
        }
        this.line.getValue().setLineWidth(Float.valueOf(2.0f));
        this.lineManager.getValue().update((LineManager) this.line.getValue());
    }

    public void onLocationChanged(MapboxMap mapboxMap, double d, double d2) {
        if (d == 0.0d || d2 == 0.0d) {
            return;
        }
        this.curLat.setValue(Double.valueOf(d));
        this.curLng.setValue(Double.valueOf(d2));
        if (mapboxMap == null || this.symbolManager.getValue() == null) {
            return;
        }
        LatLng latLng = new LatLng(d, d2);
        if (this.isStyleLoaded.getValue().booleanValue()) {
            if (this.deviceSymbol.getValue() == null) {
                this.deviceSymbol.setValue(this.symbolManager.getValue().create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage("marker-image-device")));
                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(this.zoomScale.getValue().floatValue()).build()), 2000);
            }
            this.deviceSymbol.getValue().setLatLng(latLng);
            this.symbolManager.getValue().update((SymbolManager) this.deviceSymbol.getValue());
            if (this.curPlaneLat.getValue().doubleValue() == 0.0d || this.curPlaneLat.getValue().doubleValue() == -1.0d || this.curPlaneLng.getValue().doubleValue() == 0.0d || this.curPlaneLng.getValue().doubleValue() == -1.0d) {
                return;
            }
            this.phoneLatLngs.clear();
            LatLng latLng2 = new LatLng(this.curPlaneLat.getValue().doubleValue(), this.curPlaneLng.getValue().doubleValue());
            this.phoneLatLngs.add(latLng2);
            this.phoneLatLngs.add(latLng);
            drawLine(mapboxMap, this.phoneLatLngs, false);
            deviceTextDistance(latLng, latLng2);
        }
    }

    public void homeLocation(MapboxMap mapboxMap, double d, double d2) {
        if (this.symbolManager.getValue() == null) {
            return;
        }
        this.curHomeLat.setValue(Double.valueOf(d));
        this.curHomeLng.setValue(Double.valueOf(d2));
        if (d == 0.0d || d2 == 0.0d) {
            if (this.homeSymbol.getValue() != null) {
                this.symbolManager.getValue().delete((SymbolManager) this.homeSymbol.getValue());
                this.homeSymbol.setValue(null);
            }
            if (this.lineManager.getValue() == null || this.homeLine.getValue() == null) {
                return;
            }
            this.lineManager.getValue().delete((LineManager) this.homeLine.getValue());
            this.homeLine.setValue(null);
            return;
        }
        LatLng latLng = new LatLng(d, d2);
        if (this.isStyleLoaded.getValue().booleanValue()) {
            if (this.homeSymbol.getValue() == null) {
                this.homeSymbol.setValue(this.symbolManager.getValue().create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage("marker_image_home")));
            }
            this.homeSymbol.getValue().setLatLng(latLng);
            this.symbolManager.getValue().update((SymbolManager) this.homeSymbol.getValue());
            if (this.curPlaneLat.getValue().doubleValue() == 0.0d || this.curPlaneLat.getValue().doubleValue() == -1.0d || this.curPlaneLng.getValue().doubleValue() == 0.0d || this.curPlaneLng.getValue().doubleValue() == -1.0d) {
                return;
            }
            this.homeLatLngs.clear();
            this.homeLatLngs.add(latLng);
            this.homeLatLngs.add(new LatLng(this.curPlaneLat.getValue().doubleValue(), this.curPlaneLng.getValue().doubleValue()));
            drawLine(mapboxMap, this.homeLatLngs, true);
        }
    }

    public void flyAlwaysLocation(MapboxMap mapboxMap, double d, double d2) {
        if (this.symbolManager.getValue() == null || d > 90.0d || d < -90.0d || d == 0.0d || d2 == 0.0d) {
            return;
        }
        this.curPlaneLng.setValue(Double.valueOf(d2));
        this.curPlaneLat.setValue(Double.valueOf(d));
        LatLng latLng = new LatLng(d, d2);
        if (this.isStyleLoaded.getValue().booleanValue()) {
            if (this.planeSymbol.getValue() == null) {
                this.planeSymbol.setValue(this.symbolManager.getValue().create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconImage(FlightConfig.isConnectFlight() ? "marker_image_plane" : "marker_image_plane_unconnect")));
            }
            this.planeSymbol.getValue().setLatLng(latLng);
            this.symbolManager.getValue().update((SymbolManager) this.planeSymbol.getValue());
        }
        if (this.circleManager.getValue() != null) {
            this.circleManager.getValue().deleteAll();
            this.circle.setValue(null);
        }
        drawCircle(this.zoomScale.getValue().floatValue() * 2.0f);
        if (this.curLat.getValue().doubleValue() != 0.0d && this.curLng.getValue().doubleValue() != 0.0d) {
            LatLng latLng2 = new LatLng(this.curLat.getValue().doubleValue(), this.curLng.getValue().doubleValue());
            this.planePhoneLatLngs.clear();
            this.planePhoneLatLngs.add(latLng2);
            this.planePhoneLatLngs.add(latLng);
            drawLine(mapboxMap, this.planePhoneLatLngs, false);
        }
        if (this.curHomeLat.getValue().doubleValue() == 0.0d || this.curHomeLng.getValue().doubleValue() == 0.0d) {
            return;
        }
        LatLng latLng3 = new LatLng(this.curHomeLat.getValue().doubleValue(), this.curHomeLng.getValue().doubleValue());
        this.planeHomeLatLngs.clear();
        this.planeHomeLatLngs.add(latLng3);
        this.planeHomeLatLngs.add(latLng);
        drawLine(mapboxMap, this.planeHomeLatLngs, true);
    }

    public void flyTextLocation(double d, double d2) {
        this.textStr.setValue(String.format("%s", "(" + Double.valueOf(d).intValue() + "°，" + Double.valueOf(d2).intValue() + "°)"));
        if (this.symbolManager.getValue() == null || this.curPlaneLng.getValue().doubleValue() == 0.0d || this.curPlaneLat.getValue().doubleValue() == 0.0d) {
            return;
        }
        LatLng latLng = new LatLng(d, d2);
        if (this.isStyleLoaded.getValue().booleanValue()) {
            if (this.textSymbol.getValue() == null) {
                this.textSymbol.setValue(this.symbolManager.getValue().create((SymbolManager) new SymbolOptions().withLatLng(latLng).withIconOffset(new Float[]{Float.valueOf(88.0f), Float.valueOf(0.0f)}).withTextOffset(new Float[]{Float.valueOf(7.4f), Float.valueOf(0.0f)}).withTextField(this.textStr.getValue()).withTextColor("#ffffff").withTextSize(Float.valueOf(12.0f)).withIconImage("marker-text-plane")));
            }
            this.textSymbol.getValue().setLatLng(latLng);
            this.symbolManager.getValue().update((SymbolManager) this.textSymbol.getValue());
        }
    }

    public void deviceTextDistance(LatLng latLng, LatLng latLng2) {
        if (this.symbolManager.getValue() == null || this.curLng.getValue().doubleValue() == 0.0d || this.curLat.getValue().doubleValue() == 0.0d) {
            return;
        }
        if (this.distanceSymbol.getValue() != null) {
            this.symbolManager.getValue().delete((SymbolManager) this.distanceSymbol.getValue());
            this.distanceSymbol.setValue(null);
        }
        LatLng latLng3 = new LatLng(this.curLat.getValue().doubleValue(), this.curLng.getValue().doubleValue());
        if (this.isStyleLoaded.getValue().booleanValue()) {
            if (this.distanceSymbol.getValue() == null) {
                this.distanceSymbol.setValue(this.symbolManager.getValue().create((SymbolManager) new SymbolOptions().withLatLng(latLng3).withIconOffset(new Float[]{Float.valueOf(-40.0f), Float.valueOf(0.0f)}).withTextOffset(new Float[]{Float.valueOf(-3.3f), Float.valueOf(0.0f)}).withTextField(MapUtil.getMapPointsDistance(latLng, latLng2)).withTextColor("#ffffff").withTextSize(Float.valueOf(12.0f)).withIconImage("marker-text-distance")));
            }
            this.distanceSymbol.getValue().setLatLng(latLng3);
            this.symbolManager.getValue().update((SymbolManager) this.distanceSymbol.getValue());
        }
    }

    public void rotateMyLocationIcon(float f) {
        if (this.deviceSymbol.getValue() == null || this.symbolManager.getValue() == null) {
            return;
        }
        this.deviceSymbol.getValue().setIconRotate(Float.valueOf(f));
        this.symbolManager.getValue().update((SymbolManager) this.deviceSymbol.getValue());
    }

    public void deleteStyle() {
        if (this.symbolManager.getValue() != null) {
            this.symbolManager.getValue().deleteAll();
        }
        if (this.circleManager.getValue() != null) {
            this.circleManager.getValue().deleteAll();
        }
        if (this.lineManager.getValue() != null) {
            this.lineManager.getValue().deleteAll();
        }
        if (this.deviceSymbol.getValue() != null) {
            this.deviceSymbol.setValue(null);
        }
        if (this.planeSymbol.getValue() != null) {
            this.planeSymbol.setValue(null);
        }
        if (this.textSymbol.getValue() != null) {
            this.textSymbol.setValue(null);
        }
        if (this.homeSymbol.getValue() != null) {
            this.homeSymbol.setValue(null);
        }
        if (this.distanceSymbol.getValue() != null) {
            this.distanceSymbol.setValue(null);
        }
        if (this.circle.getValue() != null) {
            this.circle.setValue(null);
        }
        if (this.line.getValue() != null) {
            this.line.setValue(null);
        }
        if (this.homeLine.getValue() != null) {
            this.homeLine.setValue(null);
        }
    }
}
