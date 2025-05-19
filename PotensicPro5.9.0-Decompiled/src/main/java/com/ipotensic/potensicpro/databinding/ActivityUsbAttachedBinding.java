package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityUsbAttachedBinding implements ViewBinding {
    public final Button btnSend;
    private final RelativeLayout rootView;
    public final SurfaceView surface;

    private ActivityUsbAttachedBinding(RelativeLayout relativeLayout, Button button, SurfaceView surfaceView) {
        this.rootView = relativeLayout;
        this.btnSend = button;
        this.surface = surfaceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUsbAttachedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUsbAttachedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_usb_attached, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUsbAttachedBinding bind(View view) {
        int i = R.id.btn_send;
        Button button = (Button) view.findViewById(R.id.btn_send);
        if (button != null) {
            i = R.id.surface;
            SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.surface);
            if (surfaceView != null) {
                return new ActivityUsbAttachedBinding((RelativeLayout) view, button, surfaceView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
