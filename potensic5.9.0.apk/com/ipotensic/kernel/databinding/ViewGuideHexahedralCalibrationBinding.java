package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewGuideHexahedralCalibrationBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    private final ShadowLayout rootView;
    public final TextView tvDialogTitle;

    private ViewGuideHexahedralCalibrationBinding(ShadowLayout shadowLayout, Button button, Button button2, TextView textView) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.tvDialogTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewGuideHexahedralCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGuideHexahedralCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_guide_hexahedral_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGuideHexahedralCalibrationBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.tv_dialog_title;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new ViewGuideHexahedralCalibrationBinding((ShadowLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}