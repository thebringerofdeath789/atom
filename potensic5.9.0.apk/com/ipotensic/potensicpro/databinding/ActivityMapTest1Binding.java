package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.view.NumberProgressBar;
import com.ipotensic.potensicpro.C2640R;
import com.mapbox.mapboxsdk.maps.MapView;

/* loaded from: classes2.dex */
public final class ActivityMapTest1Binding implements ViewBinding {
    public final Button down;
    public final Button list;
    public final MapView mapView;
    public final NumberProgressBar progressBar;
    private final RelativeLayout rootView;

    private ActivityMapTest1Binding(RelativeLayout relativeLayout, Button button, Button button2, MapView mapView, NumberProgressBar numberProgressBar) {
        this.rootView = relativeLayout;
        this.down = button;
        this.list = button2;
        this.mapView = mapView;
        this.progressBar = numberProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMapTest1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMapTest1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_map_test1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMapTest1Binding bind(View view) {
        int i = C2640R.id.down;
        Button button = (Button) view.findViewById(C2640R.id.down);
        if (button != null) {
            i = C2640R.id.list;
            Button button2 = (Button) view.findViewById(C2640R.id.list);
            if (button2 != null) {
                i = C2640R.id.mapView;
                MapView mapView = (MapView) view.findViewById(C2640R.id.mapView);
                if (mapView != null) {
                    i = C2640R.id.progress_bar;
                    NumberProgressBar numberProgressBar = (NumberProgressBar) view.findViewById(C2640R.id.progress_bar);
                    if (numberProgressBar != null) {
                        return new ActivityMapTest1Binding((RelativeLayout) view, button, button2, mapView, numberProgressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}