package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewCameraQuickSettingBinding implements ViewBinding {
    public final FrameLayout flCamera;
    public final RadioButton rbLeft;
    public final RadioButton rbRight;
    public final RadioGroup rgCamera;
    private final RelativeLayout rootView;

    private ViewCameraQuickSettingBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup) {
        this.rootView = relativeLayout;
        this.flCamera = frameLayout;
        this.rbLeft = radioButton;
        this.rbRight = radioButton2;
        this.rgCamera = radioGroup;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewCameraQuickSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCameraQuickSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_camera_quick_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCameraQuickSettingBinding bind(View view) {
        int i = R.id.fl_camera;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
        if (frameLayout != null) {
            i = R.id.rb_left;
            RadioButton radioButton = (RadioButton) view.findViewById(i);
            if (radioButton != null) {
                i = R.id.rb_right;
                RadioButton radioButton2 = (RadioButton) view.findViewById(i);
                if (radioButton2 != null) {
                    i = R.id.rg_camera;
                    RadioGroup radioGroup = (RadioGroup) view.findViewById(i);
                    if (radioGroup != null) {
                        return new ViewCameraQuickSettingBinding((RelativeLayout) view, frameLayout, radioButton, radioButton2, radioGroup);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}