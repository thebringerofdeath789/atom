package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.mapbox.mapboxsdk.maps.MapView;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewMapBoxBinding implements ViewBinding {
    public final MapView mapView;
    private final MapView rootView;

    private ViewMapBoxBinding(MapView mapView, MapView mapView2) {
        this.rootView = mapView;
        this.mapView = mapView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MapView getRoot() {
        return this.rootView;
    }

    public static ViewMapBoxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map_box, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapBoxBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        MapView mapView = (MapView) view;
        return new ViewMapBoxBinding(mapView, mapView);
    }
}
