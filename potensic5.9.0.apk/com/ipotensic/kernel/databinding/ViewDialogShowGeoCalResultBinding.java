package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogShowGeoCalResultBinding implements ViewBinding {
    public final ImageButton btnBack;
    private final RoundRelativeLayout rootView;
    public final TextView tvBiasResult0;
    public final TextView tvBiasResult1;
    public final TextView tvBiasResult2;
    public final TextView tvMgDbResult;
    public final TextView tvOffdiagResult0;
    public final TextView tvOffdiagResult1;
    public final TextView tvOffdiagResult2;
    public final TextView tvResult;
    public final TextView tvScaleResult0;
    public final TextView tvScaleResult1;
    public final TextView tvScaleResult2;
    public final TextView tvTime;

    private ViewDialogShowGeoCalResultBinding(RoundRelativeLayout roundRelativeLayout, ImageButton imageButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = roundRelativeLayout;
        this.btnBack = imageButton;
        this.tvBiasResult0 = textView;
        this.tvBiasResult1 = textView2;
        this.tvBiasResult2 = textView3;
        this.tvMgDbResult = textView4;
        this.tvOffdiagResult0 = textView5;
        this.tvOffdiagResult1 = textView6;
        this.tvOffdiagResult2 = textView7;
        this.tvResult = textView8;
        this.tvScaleResult0 = textView9;
        this.tvScaleResult1 = textView10;
        this.tvScaleResult2 = textView11;
        this.tvTime = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogShowGeoCalResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogShowGeoCalResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_show_geo_cal_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogShowGeoCalResultBinding bind(View view) {
        int i = C1965R.id.btn_back;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.tv_bias_result0;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1965R.id.tv_bias_result1;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C1965R.id.tv_bias_result2;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        i = C1965R.id.tv_mg_db_result;
                        TextView textView4 = (TextView) view.findViewById(i);
                        if (textView4 != null) {
                            i = C1965R.id.tv_offdiag_result0;
                            TextView textView5 = (TextView) view.findViewById(i);
                            if (textView5 != null) {
                                i = C1965R.id.tv_offdiag_result1;
                                TextView textView6 = (TextView) view.findViewById(i);
                                if (textView6 != null) {
                                    i = C1965R.id.tv_offdiag_result2;
                                    TextView textView7 = (TextView) view.findViewById(i);
                                    if (textView7 != null) {
                                        i = C1965R.id.tv_result;
                                        TextView textView8 = (TextView) view.findViewById(i);
                                        if (textView8 != null) {
                                            i = C1965R.id.tv_scale_result0;
                                            TextView textView9 = (TextView) view.findViewById(i);
                                            if (textView9 != null) {
                                                i = C1965R.id.tv_scale_result1;
                                                TextView textView10 = (TextView) view.findViewById(i);
                                                if (textView10 != null) {
                                                    i = C1965R.id.tv_scale_result2;
                                                    TextView textView11 = (TextView) view.findViewById(i);
                                                    if (textView11 != null) {
                                                        i = C1965R.id.tv_time;
                                                        TextView textView12 = (TextView) view.findViewById(i);
                                                        if (textView12 != null) {
                                                            return new ViewDialogShowGeoCalResultBinding((RoundRelativeLayout) view, imageButton, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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