package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.mapbox.mapboxsdk.maps.MapView;

/* loaded from: classes2.dex */
public final class ActivityMapTestBinding implements ViewBinding {
    public final RelativeLayout mapContainer;
    public final MapView mapView;
    private final ConstraintLayout rootView;
    public final Button toBig;
    public final Button toSmall;

    private ActivityMapTestBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, MapView mapView, Button button, Button button2) {
        this.rootView = constraintLayout;
        this.mapContainer = relativeLayout;
        this.mapView = mapView;
        this.toBig = button;
        this.toSmall = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMapTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMapTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_map_test, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMapTestBinding bind(View view) {
        int i = R.id.map_container;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
        if (relativeLayout != null) {
            i = R.id.map_view;
            MapView mapView = (MapView) view.findViewById(i);
            if (mapView != null) {
                i = R.id.toBig;
                Button button = (Button) view.findViewById(i);
                if (button != null) {
                    i = R.id.toSmall;
                    Button button2 = (Button) view.findViewById(i);
                    if (button2 != null) {
                        return new ActivityMapTestBinding((ConstraintLayout) view, relativeLayout, mapView, button, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}