package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogGeoRemoteControlBinding implements ViewBinding {
    public final ImageView imgGeoHorizontal;
    public final ImageView imgGeoVertical;
    private final ConstraintLayout rootView;
    public final TextView tvContentOne;
    public final TextView tvGeoCalibration;
    public final TextView tvOne;

    private ViewDialogGeoRemoteControlBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.imgGeoHorizontal = imageView;
        this.imgGeoVertical = imageView2;
        this.tvContentOne = textView;
        this.tvGeoCalibration = textView2;
        this.tvOne = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGeoRemoteControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGeoRemoteControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_geo_remote_control, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGeoRemoteControlBinding bind(View view) {
        int i = C1965R.id.img_geo_horizontal;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.img_geo_vertical;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.tv_content_one;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_geo_calibration;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_one;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            return new ViewDialogGeoRemoteControlBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}