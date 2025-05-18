package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewDeviceListBinding implements ViewBinding {
    public final ImageButton btnClose;
    public final ConstraintLayout layoutDeviceList;
    private final ConstraintLayout rootView;
    public final RecyclerView ryView;
    public final TextView tvChooseDevice;

    private ViewDeviceListBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnClose = imageButton;
        this.layoutDeviceList = constraintLayout2;
        this.ryView = recyclerView;
        this.tvChooseDevice = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_device_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDeviceListBinding bind(View view) {
        int i = C2640R.id.btn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_close);
        if (imageButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = C2640R.id.ry_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C2640R.id.ry_view);
            if (recyclerView != null) {
                i = C2640R.id.tv_choose_device;
                TextView textView = (TextView) view.findViewById(C2640R.id.tv_choose_device);
                if (textView != null) {
                    return new ViewDeviceListBinding(constraintLayout, imageButton, constraintLayout, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}