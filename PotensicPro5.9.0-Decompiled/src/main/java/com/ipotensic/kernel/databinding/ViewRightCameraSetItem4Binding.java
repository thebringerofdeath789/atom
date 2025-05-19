package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewRightCameraSetItem4Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvFormat;
    public final TextView tvJpg;
    public final TextView tvRaw;

    private ViewRightCameraSetItem4Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvFormat = textView;
        this.tvJpg = textView2;
        this.tvRaw = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraSetItem4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraSetItem4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_right_camera_set_item4, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraSetItem4Binding bind(View view) {
        int i = R.id.tv_format;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tv_jpg;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.tv_raw;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null) {
                    return new ViewRightCameraSetItem4Binding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
