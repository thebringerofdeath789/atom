package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.ConnectStateView;

/* loaded from: classes2.dex */
public final class ViewMainPageDeviceBinding implements ViewBinding {
    public final TextView btnEnterDevice;
    public final ImageButton btnMenu;
    public final View guideModelSelect;
    public final ImageView ivDeviceType;
    public final ImageView ivLogo;
    public final ConstraintLayout layoutDevice;
    public final ViewMainMenuBinding layoutMenu;
    public final LinearLayout llTop;
    private final ConstraintLayout rootView;
    public final TextView tvCheckUpgrade;
    public final TextView tvChoose;
    public final ConnectStateView tvConnectState;
    public final View viewBlank;
    public final View viewEnterBg;

    private ViewMainPageDeviceBinding(ConstraintLayout constraintLayout, TextView textView, ImageButton imageButton, View view, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ViewMainMenuBinding viewMainMenuBinding, LinearLayout linearLayout, TextView textView2, TextView textView3, ConnectStateView connectStateView, View view2, View view3) {
        this.rootView = constraintLayout;
        this.btnEnterDevice = textView;
        this.btnMenu = imageButton;
        this.guideModelSelect = view;
        this.ivDeviceType = imageView;
        this.ivLogo = imageView2;
        this.layoutDevice = constraintLayout2;
        this.layoutMenu = viewMainMenuBinding;
        this.llTop = linearLayout;
        this.tvCheckUpgrade = textView2;
        this.tvChoose = textView3;
        this.tvConnectState = connectStateView;
        this.viewBlank = view2;
        this.viewEnterBg = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainPageDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainPageDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_main_page_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainPageDeviceBinding bind(View view) {
        int i = R.id.btn_enter_device;
        TextView textView = (TextView) view.findViewById(R.id.btn_enter_device);
        if (textView != null) {
            i = R.id.btn_menu;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_menu);
            if (imageButton != null) {
                i = R.id.guide_model_select;
                View findViewById = view.findViewById(R.id.guide_model_select);
                if (findViewById != null) {
                    i = R.id.iv_device_type;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_device_type);
                    if (imageView != null) {
                        i = R.id.iv_logo;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_logo);
                        if (imageView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R.id.layout_menu;
                            View findViewById2 = view.findViewById(R.id.layout_menu);
                            if (findViewById2 != null) {
                                ViewMainMenuBinding bind = ViewMainMenuBinding.bind(findViewById2);
                                i = R.id.ll_top;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_top);
                                if (linearLayout != null) {
                                    i = R.id.tv_check_upgrade;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_check_upgrade);
                                    if (textView2 != null) {
                                        i = R.id.tv_choose;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_choose);
                                        if (textView3 != null) {
                                            i = R.id.tv_connect_state;
                                            ConnectStateView connectStateView = (ConnectStateView) view.findViewById(R.id.tv_connect_state);
                                            if (connectStateView != null) {
                                                i = R.id.view_blank;
                                                View findViewById3 = view.findViewById(R.id.view_blank);
                                                if (findViewById3 != null) {
                                                    i = R.id.view_enter_bg;
                                                    View findViewById4 = view.findViewById(R.id.view_enter_bg);
                                                    if (findViewById4 != null) {
                                                        return new ViewMainPageDeviceBinding(constraintLayout, textView, imageButton, findViewById, imageView, imageView2, constraintLayout, bind, linearLayout, textView2, textView3, connectStateView, findViewById3, findViewById4);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}