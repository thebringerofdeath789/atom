package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewLayoutTestGpsSignalBinding implements ViewBinding {
    public final RelativeLayout layoutTestGpsSignal;
    private final RelativeLayout rootView;
    public final RecyclerView rvBDCarrierRatio;
    public final RecyclerView rvGACarrierRatio;
    public final RecyclerView rvGLCarrierRatio;
    public final RecyclerView rvGPCarrierRatio;
    public final SwitchButton switchBtn;
    public final SwitchButton switchRecordBtn;
    public final TextView tvBDCarrierRatio;
    public final TextView tvDroneSn;
    public final TextView tvGACarrierRatio;
    public final TextView tvGLCarrierRatio;
    public final TextView tvGPCarrierRatio;
    public final TextView tvGPSInfo;
    public final TextView tvRecordData;
    public final TextView tvTitle;

    private ViewLayoutTestGpsSignalBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, SwitchButton switchButton, SwitchButton switchButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = relativeLayout;
        this.layoutTestGpsSignal = relativeLayout2;
        this.rvBDCarrierRatio = recyclerView;
        this.rvGACarrierRatio = recyclerView2;
        this.rvGLCarrierRatio = recyclerView3;
        this.rvGPCarrierRatio = recyclerView4;
        this.switchBtn = switchButton;
        this.switchRecordBtn = switchButton2;
        this.tvBDCarrierRatio = textView;
        this.tvDroneSn = textView2;
        this.tvGACarrierRatio = textView3;
        this.tvGLCarrierRatio = textView4;
        this.tvGPCarrierRatio = textView5;
        this.tvGPSInfo = textView6;
        this.tvRecordData = textView7;
        this.tvTitle = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTestGpsSignalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTestGpsSignalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_test_gps_signal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTestGpsSignalBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = C1965R.id.rvBDCarrierRatio;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            i = C1965R.id.rvGACarrierRatio;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
            if (recyclerView2 != null) {
                i = C1965R.id.rvGLCarrierRatio;
                RecyclerView recyclerView3 = (RecyclerView) view.findViewById(i);
                if (recyclerView3 != null) {
                    i = C1965R.id.rvGPCarrierRatio;
                    RecyclerView recyclerView4 = (RecyclerView) view.findViewById(i);
                    if (recyclerView4 != null) {
                        i = C1965R.id.switchBtn;
                        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
                        if (switchButton != null) {
                            i = C1965R.id.switchRecordBtn;
                            SwitchButton switchButton2 = (SwitchButton) view.findViewById(i);
                            if (switchButton2 != null) {
                                i = C1965R.id.tvBDCarrierRatio;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C1965R.id.tvDroneSn;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C1965R.id.tvGACarrierRatio;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C1965R.id.tvGLCarrierRatio;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                i = C1965R.id.tvGPCarrierRatio;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    i = C1965R.id.tvGPSInfo;
                                                    TextView textView6 = (TextView) view.findViewById(i);
                                                    if (textView6 != null) {
                                                        i = C1965R.id.tvRecordData;
                                                        TextView textView7 = (TextView) view.findViewById(i);
                                                        if (textView7 != null) {
                                                            i = C1965R.id.tvTitle;
                                                            TextView textView8 = (TextView) view.findViewById(i);
                                                            if (textView8 != null) {
                                                                return new ViewLayoutTestGpsSignalBinding(relativeLayout, relativeLayout, recyclerView, recyclerView2, recyclerView3, recyclerView4, switchButton, switchButton2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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