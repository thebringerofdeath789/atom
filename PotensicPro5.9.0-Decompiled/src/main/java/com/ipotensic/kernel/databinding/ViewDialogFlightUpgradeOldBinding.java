package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogFlightUpgradeOldBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    public final ConstraintLayout clUpgradeDialog;
    public final ImageView ivCancel;
    public final ConstraintLayout layoutBottom;
    public final ScrollView layoutTop;
    private final ConstraintLayout rootView;
    public final ViewStub stubUpgrading;
    public final TextView tvCodeTitle;
    public final TextView tvDetail;
    public final TextView tvName;
    public final TextView tvSize;
    public final TextView tvUpdate;
    public final TextView tvUpgradeConditions;
    public final TextView tvUpgradePrecautions;
    public final TextView tvVersion;

    private ViewDialogFlightUpgradeOldBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView, ConstraintLayout constraintLayout3, ScrollView scrollView, ViewStub viewStub, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.clUpgradeDialog = constraintLayout2;
        this.ivCancel = imageView;
        this.layoutBottom = constraintLayout3;
        this.layoutTop = scrollView;
        this.stubUpgrading = viewStub;
        this.tvCodeTitle = textView3;
        this.tvDetail = textView4;
        this.tvName = textView5;
        this.tvSize = textView6;
        this.tvUpdate = textView7;
        this.tvUpgradeConditions = textView8;
        this.tvUpgradePrecautions = textView9;
        this.tvVersion = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFlightUpgradeOldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFlightUpgradeOldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_flight_upgrade_old, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFlightUpgradeOldBinding bind(View view) {
        int i = R.id.btn_cancel;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.btn_confirm;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.iv_cancel;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = R.id.layout_bottom;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout2 != null) {
                        i = R.id.layout_top;
                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                        if (scrollView != null) {
                            i = R.id.stub_upgrading;
                            ViewStub viewStub = (ViewStub) view.findViewById(i);
                            if (viewStub != null) {
                                i = R.id.tv_code_title;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    i = R.id.tv_detail;
                                    TextView textView4 = (TextView) view.findViewById(i);
                                    if (textView4 != null) {
                                        i = R.id.tv_name;
                                        TextView textView5 = (TextView) view.findViewById(i);
                                        if (textView5 != null) {
                                            i = R.id.tv_size;
                                            TextView textView6 = (TextView) view.findViewById(i);
                                            if (textView6 != null) {
                                                i = R.id.tv_update;
                                                TextView textView7 = (TextView) view.findViewById(i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_upgrade_conditions;
                                                    TextView textView8 = (TextView) view.findViewById(i);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_upgrade_precautions;
                                                        TextView textView9 = (TextView) view.findViewById(i);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_version;
                                                            TextView textView10 = (TextView) view.findViewById(i);
                                                            if (textView10 != null) {
                                                                return new ViewDialogFlightUpgradeOldBinding(constraintLayout, textView, textView2, constraintLayout, imageView, constraintLayout2, scrollView, viewStub, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
