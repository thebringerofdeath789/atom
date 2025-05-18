package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogFlightUpgradeBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final Button btnUpgrade;
    public final ConstraintLayout clUpgradeDialog;
    public final LinearLayout layoutBottom;
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

    private ViewDialogFlightUpgradeBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ScrollView scrollView, ViewStub viewStub, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.btnUpgrade = button3;
        this.clUpgradeDialog = constraintLayout2;
        this.layoutBottom = linearLayout;
        this.layoutTop = scrollView;
        this.stubUpgrading = viewStub;
        this.tvCodeTitle = textView;
        this.tvDetail = textView2;
        this.tvName = textView3;
        this.tvSize = textView4;
        this.tvUpdate = textView5;
        this.tvUpgradeConditions = textView6;
        this.tvUpgradePrecautions = textView7;
        this.tvVersion = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFlightUpgradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFlightUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_flight_upgrade, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFlightUpgradeBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.btn_upgrade;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = C1965R.id.layout_bottom;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        i = C1965R.id.layout_top;
                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                        if (scrollView != null) {
                            i = C1965R.id.stub_upgrading;
                            ViewStub viewStub = (ViewStub) view.findViewById(i);
                            if (viewStub != null) {
                                i = C1965R.id.tv_code_title;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C1965R.id.tv_detail;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C1965R.id.tv_name;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C1965R.id.tv_size;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                i = C1965R.id.tv_update;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    i = C1965R.id.tv_upgrade_conditions;
                                                    TextView textView6 = (TextView) view.findViewById(i);
                                                    if (textView6 != null) {
                                                        i = C1965R.id.tv_upgrade_precautions;
                                                        TextView textView7 = (TextView) view.findViewById(i);
                                                        if (textView7 != null) {
                                                            i = C1965R.id.tv_version;
                                                            TextView textView8 = (TextView) view.findViewById(i);
                                                            if (textView8 != null) {
                                                                return new ViewDialogFlightUpgradeBinding(constraintLayout, button, button2, button3, constraintLayout, linearLayout, scrollView, viewStub, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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