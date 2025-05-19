package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingStickModeModel;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingStickModeBinding extends ViewDataBinding {
    public final Guideline baseLineLeft;
    public final Guideline baseLineRight;
    public final ImageButton btnExit;
    public final ImageButton ibBack;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    public final RelativeLayout layoutTop;

    @Bindable
    protected SettingStickModeModel mSettingStickMode;
    public final ShadowLayout shadowLayout;
    public final TextView tvBackward;
    public final TextView tvCodeTitle;
    public final TextView tvDown;
    public final TextView tvForward;
    public final TextView tvLeft;
    public final TextView tvLeftSide;
    public final TextView tvLeftStick;
    public final TextView tvMode1;
    public final TextView tvMode2;
    public final TextView tvRemoteRightStick;
    public final TextView tvRight;
    public final TextView tvRightSide;
    public final TextView tvTitle;
    public final TextView tvUp;

    public abstract void setSettingStickMode(SettingStickModeModel settingStickModeModel);

    protected ViewLayoutSettingStickModeBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, ShadowLayout shadowLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        super(obj, view, i);
        this.baseLineLeft = guideline;
        this.baseLineRight = guideline2;
        this.btnExit = imageButton;
        this.ibBack = imageButton2;
        this.ivLeft = imageView;
        this.ivRight = imageView2;
        this.layoutTop = relativeLayout;
        this.shadowLayout = shadowLayout;
        this.tvBackward = textView;
        this.tvCodeTitle = textView2;
        this.tvDown = textView3;
        this.tvForward = textView4;
        this.tvLeft = textView5;
        this.tvLeftSide = textView6;
        this.tvLeftStick = textView7;
        this.tvMode1 = textView8;
        this.tvMode2 = textView9;
        this.tvRemoteRightStick = textView10;
        this.tvRight = textView11;
        this.tvRightSide = textView12;
        this.tvTitle = textView13;
        this.tvUp = textView14;
    }

    public SettingStickModeModel getSettingStickMode() {
        return this.mSettingStickMode;
    }

    public static ViewLayoutSettingStickModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingStickModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingStickModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_stick_mode, viewGroup, z, obj);
    }

    public static ViewLayoutSettingStickModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingStickModeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingStickModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_stick_mode, null, false, obj);
    }

    public static ViewLayoutSettingStickModeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingStickModeBinding bind(View view, Object obj) {
        return (ViewLayoutSettingStickModeBinding) bind(obj, view, R.layout.view_layout_setting_stick_mode);
    }
}
