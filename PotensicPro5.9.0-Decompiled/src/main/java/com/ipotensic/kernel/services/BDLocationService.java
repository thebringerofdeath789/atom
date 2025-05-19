package com.ipotensic.kernel.services;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.google.gson.JsonObject;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.bean.MyLatLng;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.CoordTransformer;
import com.ipotensic.kernel.utils.MapUtil;
import com.logan.flight.FlightConfig;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class BDLocationService implements ILocationService, OnNetworkChangeListener {
    private BDLocation curLocation;
    private LocationClientOption locationOpt;
    private OnLocationChangedListener onLocationChangedListener;
    private final String TAG = getClass().getSimpleName();
    private LocationClient client = null;
    private BDAbstractLocationListener listener = new BDAbstractLocationListener() { // from class: com.ipotensic.kernel.services.BDLocationService.1
        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null) {
                if (bDLocation.getLatitude() == Double.MIN_VALUE || bDLocation.getLongitude() == Double.MIN_VALUE) {
                    if (BDLocationService.this.client == null || !BDLocationService.this.client.isStarted()) {
                        return;
                    }
                    BDLocationService.this.client.requestLocation();
                    BDLocationService.this.client.requestOfflineLocation();
                    return;
                }
                if (bDLocation.getLocType() != 167) {
                    BDLocationService.this.refresh(bDLocation);
                }
            }
        }
    };

    @Override // com.ipotensic.kernel.services.ILocationService
    public float getRotate() {
        return 0.0f;
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onCellularStateChanged(boolean z) {
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void init() {
        try {
            if (this.client == null) {
                LocationClient.setAgreePrivacy(true);
                this.client = new LocationClient(PhoneConfig.applicationContext);
                LocationClientOption locationClientOption = new LocationClientOption();
                this.locationOpt = locationClientOption;
                locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                this.locationOpt.setCoorType("gcj02");
                this.locationOpt.setScanSpan(1000);
                this.locationOpt.setIsNeedLocationDescribe(true);
                this.locationOpt.setNeedDeviceDirect(true);
                this.locationOpt.setLocationNotify(true);
                this.locationOpt.setIgnoreKillProcess(true);
                this.locationOpt.setIsNeedLocationDescribe(true);
                this.locationOpt.setIsNeedLocationPoiList(true);
                this.locationOpt.SetIgnoreCacheException(false);
                this.locationOpt.setOpenGps(true);
                this.locationOpt.setIsNeedAltitude(true);
                this.locationOpt.setIsNeedAddress(true);
                this.client.setLocOption(this.locationOpt);
                this.client.registerLocationListener(this.listener);
                NetworkStateReceiver.getInstance().addCallback(this);
            }
            refresh(null);
        } catch (Exception e) {
            DDLog.e(this.TAG, "开启定位出错:" + e.getMessage());
        }
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void start() {
        DDLog.e(this.TAG, "开始定位...");
        if (this.client == null) {
            init();
        }
        LocationClient locationClient = this.client;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.client.start();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void reStart() {
        stop();
        start();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void stop() {
        DDLog.e(this.TAG, "停止定位");
        LocationClient locationClient = this.client;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        this.client.stop();
        this.client = null;
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onNetworkChanged(NetworkType networkType) {
        reStart();
    }

    private void gcj02ToWgs84(BDLocation bDLocation) {
        MyLatLng gcj02ToWgs84 = CoordTransformer.gcj02ToWgs84(bDLocation.getLatitude(), bDLocation.getLongitude());
        bDLocation.setLatitude(gcj02ToWgs84.getLat());
        bDLocation.setLongitude(gcj02ToWgs84.getLng());
    }

    public void testReGeo(double d, double d2) {
        MapboxGeocoding.builder().accessToken(PhoneConfig.applicationContext.getString(R.string.mapbox_access_token)).query(Point.fromLngLat(d, d2)).geocodingTypes(GeocodingCriteria.TYPE_COUNTRY).build().enqueueCall(new Callback<GeocodingResponse>() { // from class: com.ipotensic.kernel.services.BDLocationService.2
            @Override // retrofit2.Callback
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                CarmenFeature carmenFeature;
                JsonObject properties;
                if (response.body() == null || response.body().features() == null || response.body().features().isEmpty() || (carmenFeature = response.body().features().get(0)) == null || (properties = carmenFeature.properties()) == null) {
                    return;
                }
                String removeSpecialCharacters = MapUtil.removeSpecialCharacters(properties.get("short_code").toString());
                SPHelper.getInstance().setCountryCode(removeSpecialCharacters.toUpperCase());
                EventDispatcher.get().sendEvent(EventID.EVENT_UPDATE_COUNTRY_CODE, removeSpecialCharacters.toUpperCase());
                DDLog.e("国家简写：" + removeSpecialCharacters.toUpperCase());
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<GeocodingResponse> call, Throwable th) {
                DDLog.e("国家 请求失败：" + th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(final BDLocation bDLocation) {
        boolean z;
        if (bDLocation == null) {
            double[] lastLocation = SPHelper.getInstance().getLastLocation();
            if (lastLocation != null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLatitude(lastLocation[0]);
                bDLocation2.setLongitude(lastLocation[1]);
                bDLocation = bDLocation2;
            } else {
                bDLocation = this.client.getLastKnownLocation();
                if (bDLocation == null) {
                    return;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.curLocation = bDLocation;
        SPHelper.getInstance().setLastLocation(bDLocation.getLatitude(), bDLocation.getLongitude());
        int locationWhere = bDLocation.getLocationWhere();
        if (locationWhere == 1) {
            PhoneConfig.isInChinaHomeland = true;
            gcj02ToWgs84(bDLocation);
        } else if (locationWhere == 0) {
            PhoneConfig.isInChinaHomeland = false;
        }
        if (bDLocation.getRadius() < 70.0f) {
            if (FlightConfig.GPS.getLat() != 0.0d) {
                TurfMeasurement.distance(Point.fromLngLat(FlightConfig.GPS.getLng(), FlightConfig.GPS.getLat()), Point.fromLngLat(bDLocation.getLongitude(), bDLocation.getLatitude()), TurfConstants.UNIT_METERS);
            }
            FlightConfig.GPS.setAccuracy((short) bDLocation.getRadius());
            FlightConfig.GPS.setAltitude((short) bDLocation.getAltitude());
            FlightConfig.GPS.setLat(bDLocation.getLatitude());
            FlightConfig.GPS.setLng(bDLocation.getLongitude());
            FlightConfig.GPS.setLastLocation(z);
        }
        DDLog.e(this.TAG, "当前位置:" + bDLocation.getLatitude() + "," + bDLocation.getLongitude() + "," + bDLocation.getRadius());
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.services.BDLocationService.3
            @Override // java.lang.Runnable
            public void run() {
                if (BDLocationService.this.onLocationChangedListener != null) {
                    BDLocationService.this.onLocationChangedListener.onBDLocationChanged(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getRadius());
                }
            }
        });
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void setOnLocationChangedListener(OnLocationChangedListener onLocationChangedListener) {
        this.onLocationChangedListener = onLocationChangedListener;
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    /* renamed from: isStart */
    public boolean getIsRegister() {
        LocationClient locationClient = this.client;
        return locationClient != null && locationClient.isStarted();
    }
}
