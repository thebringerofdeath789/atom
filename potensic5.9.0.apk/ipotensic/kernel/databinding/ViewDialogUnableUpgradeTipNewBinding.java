package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogUnableUpgradeTipNewBinding implements ViewBinding {
    public final Button btnOk;
    public final ImageView ivPlane;
    public final ImageView ivRemote;
    public final ImageView ivSd;
    public final TextView linePlane;
    public final TextView lineRemote;
    public final TextView lineSd;
    private final ConstraintLayout rootView;
    public final TextView tvDialogTitle;
    public final TextView tvPlaneBatteryLow;
    public final TextView tvRemoteBatteryLow;
    public final TextView tvSdState;
    public final TextView tvUpgradeFirmware;

    private ViewDialogUnableUpgradeTipNewBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnOk = button;
        this.ivPlane = imageView;
        this.ivRemote = imageView2;
        this.ivSd = imageView3;
        this.linePlane = textView;
        this.lineRemote = textView2;
        this.lineSd = textView3;
        this.tvDialogTitle = textView4;
        this.tvPlaneBatteryLow = textView5;
        this.tvRemoteBatteryLow = textView6;
        this.tvSdState = textView7;
        this.tvUpgradeFirmware = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUnableUpgradeTipNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUnableUpgradeTipNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_unable_upgrade_tip_new, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUnableUpgradeTipNewBinding bind(View view) {
        int i = R.id.btn_ok;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.iv_plane;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.iv_remote;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = R.id.iv_sd;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = R.id.line_plane;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.line_remote;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = R.id.line_sd;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    i = R.id.tv_dialog_title;
                                    TextView textView4 = (TextView) view.findViewById(i);
                                    if (textView4 != null) {
                                        i = R.id.tv_plane_battery_low;
                                        TextView textView5 = (TextView) view.findViewById(i);
                                        if (textView5 != null) {
                                            i = R.id.tv_remote_battery_low;
                                            TextView textView6 = (TextView) view.findViewById(i);
                                            if (textView6 != null) {
                                                i = R.id.tv_sd_state;
                                                TextView textView7 = (TextView) view.findViewById(i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_upgrade_firmware;
                                                    TextView textView8 = (TextView) view.findViewById(i);
                                                    if (textView8 != null) {
                                                        return new ViewDialogUnableUpgradeTipNewBinding((ConstraintLayout) view, button, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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