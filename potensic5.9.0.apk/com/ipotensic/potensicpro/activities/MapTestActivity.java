package com.ipotensic.potensicpro.activities;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.guide.listener.AnimationListenerAdapter;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.C2640R;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MapTestActivity extends Activity {
    private ConstraintLayout.LayoutParams bigLayoutParams;
    private int lastValue;
    private RelativeLayout mapContainer;
    private MapView mapView;
    private MapboxMap mapboxMap;
    private ConstraintLayout.LayoutParams smallLayoutParams;

    public Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public Bitmap getBlueMarkWithIndex(String str) {
        View inflate = LayoutInflater.from(this).inflate(C2640R.layout.view_layout_test_map_mark, (ViewGroup) null);
        ((TextView) inflate.findViewById(C2640R.id.txt)).setText(str);
        return convertViewToBitmap(inflate);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2640R.layout.activity_map_test);
        this.mapView = (MapView) findViewById(C2640R.id.map_view);
        this.mapContainer = (RelativeLayout) findViewById(C2640R.id.map_container);
        DDLog.m1684e("mapbox load listen...");
        this.mapView.addOnDidFinishLoadingMapListener(new MapView.OnDidFinishLoadingMapListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.1
            @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishLoadingMapListener
            public void onDidFinishLoadingMap() {
                DDLog.m1684e("mapbox load success :");
            }
        });
        this.mapView.addOnDidFailLoadingMapListener(new MapView.OnDidFailLoadingMapListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.2
            @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFailLoadingMapListener
            public void onDidFailLoadingMap(String str) {
                DDLog.m1684e("mapbox load failed :" + str);
            }
        });
        this.mapView.addOnCameraDidChangeListener(new MapView.OnCameraDidChangeListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.3
            @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
            public void onCameraDidChange(boolean z) {
                DDLog.m1684e("mapbox onCameraDidChange");
                if (MapTestActivity.this.mapboxMap != null) {
                    MapTestActivity.this.mapboxMap.getProjection().getVisibleRegion().latLngBounds.contains(new LatLng());
                }
            }
        });
        this.mapView.getMapAsync(new OnMapReadyCallback() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.4
            @Override // com.mapbox.mapboxsdk.maps.OnMapReadyCallback
            public void onMapReady(MapboxMap mapboxMap) {
                MapTestActivity.this.mapboxMap = mapboxMap;
                mapboxMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(39.89611652644421d, 116.36253823254393d)).zoom(13.0d).build()));
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.4.1
                    @Override // com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
                    public void onStyleLoaded(Style style) {
                    }
                });
            }
        });
        this.mapView.onCreate(bundle);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        this.bigLayoutParams = layoutParams;
        layoutParams.leftToLeft = 0;
        this.bigLayoutParams.rightToRight = 0;
        this.bigLayoutParams.topToTop = 0;
        this.bigLayoutParams.bottomToBottom = 0;
        this.bigLayoutParams.horizontalBias = 0.5f;
        this.bigLayoutParams.verticalBias = 0.5f;
        findViewById(C2640R.id.toSmall).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MapTestActivity mapTestActivity = MapTestActivity.this;
                mapTestActivity.animToSmall(mapTestActivity.mapContainer);
            }
        });
        findViewById(C2640R.id.toBig).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MapTestActivity mapTestActivity = MapTestActivity.this;
                mapTestActivity.animToBig(mapTestActivity.mapContainer, new AnimationListenerAdapter() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.6.1
                    @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        super.onAnimationStart(animation);
                    }

                    @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        super.onAnimationEnd(animation);
                    }
                });
            }
        });
        this.smallLayoutParams = (ConstraintLayout.LayoutParams) this.mapContainer.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animToBig(final View view, final Animation.AnimationListener animationListener) {
        try {
            animationListener.onAnimationStart(null);
            final ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(C2640R.dimen.kernel_map_left_margin);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(C2640R.dimen.kernel_map_bottom_margin);
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            final int i = layoutParams.leftMargin;
            final int i2 = layoutParams.bottomMargin;
            TypedValue typedValue = new TypedValue();
            getResources().getValue(C2640R.dimen.kernel_map_height_percent, typedValue, true);
            final int i3 = ((int) (typedValue.getFloat() * 1000)) + 1;
            final int measuredWidth = view.getMeasuredWidth();
            final int screenWidth = ScreenUtils.getScreenWidth(view.getContext());
            ValueAnimator ofInt = ValueAnimator.ofInt(i3, 1000);
            final int i4 = 1000;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.potensicpro.activities.MapTestActivity.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (intValue == MapTestActivity.this.lastValue) {
                        return;
                    }
                    MapTestActivity.this.lastValue = intValue;
                    DDLog.m1684e("value:" + intValue);
                    layoutParams.matchConstraintPercentHeight = intValue / i4;
                    ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                    int i5 = measuredWidth;
                    int i6 = screenWidth;
                    int i7 = i3;
                    layoutParams2.matchConstraintPercentWidth = (i5 + (((i6 - i5) * (intValue - i7)) / (i4 - i7))) / i6;
                    ConstraintLayout.LayoutParams layoutParams3 = layoutParams;
                    int i8 = i;
                    int i9 = i3;
                    layoutParams3.leftMargin = i8 - (((intValue - i9) * i8) / (i4 - i9));
                    ConstraintLayout.LayoutParams layoutParams4 = layoutParams;
                    int i10 = i2;
                    int i11 = i3;
                    layoutParams4.bottomMargin = i10 - (((intValue - i11) * i10) / (i4 - i11));
                    if (intValue == i4) {
                        view.setLayoutParams(MapTestActivity.this.bigLayoutParams);
                        animationListener.onAnimationEnd(null);
                    } else {
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
            ofInt.setDuration(1000L);
            ofInt.start();
        } catch (Exception e) {
            DDLog.m1684e("缩放动画出错:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animToSmall(View view) {
        view.setLayoutParams(this.smallLayoutParams);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mapView.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mapView.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mapView.onStop();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mapView.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mapView.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mapView.onLowMemory();
    }

    public static class MapLine {
        private LatLng latLngA;
        private LatLng latLngB;

        public LatLng getLatLngA() {
            return this.latLngA;
        }

        public void setLatLngA(LatLng latLng) {
            this.latLngA = latLng;
        }

        public LatLng getLatLngB() {
            return this.latLngB;
        }

        public void setLatLngB(LatLng latLng) {
            this.latLngB = latLng;
        }

        public void reset() {
            this.latLngA = null;
            this.latLngB = null;
        }

        public boolean isEmpty() {
            return this.latLngA == null || this.latLngB == null;
        }
    }

    public Marker addMark(MapboxMap mapboxMap, LatLng latLng, Icon icon) {
        return mapboxMap.addMarker(new MarkerOptions().position(latLng).icon(icon));
    }

    public Polyline addLine(MapboxMap mapboxMap, ArrayList<LatLng> arrayList) {
        return mapboxMap.addPolyline(new PolylineOptions().addAll(arrayList).color(ContextCompat.getColor(this, C2640R.color.red)).alpha(0.5f).width(2.0f));
    }

    public Polyline addBlueLine(MapboxMap mapboxMap, ArrayList<LatLng> arrayList) {
        return mapboxMap.addPolyline(new PolylineOptions().addAll(arrayList).color(ContextCompat.getColor(this, C2640R.color.mapbox_blue)).alpha(0.5f).width(2.0f));
    }
}