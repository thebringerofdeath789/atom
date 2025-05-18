package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutTestFpvBinding implements ViewBinding {
    public final LinearLayout layoutConnectInfo;
    public final RelativeLayout layoutFpvTest;
    private final RelativeLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvBand;
    public final TextView tvFreqHopping;
    public final TextView tvLost;
    public final TextView tvMsg;
    public final TextView tvRssi;

    private ViewLayoutTestFpvBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.layoutConnectInfo = linearLayout;
        this.layoutFpvTest = relativeLayout2;
        this.scrollView = scrollView;
        this.tvBand = textView;
        this.tvFreqHopping = textView2;
        this.tvLost = textView3;
        this.tvMsg = textView4;
        this.tvRssi = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTestFpvBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTestFpvBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_test_fpv, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTestFpvBinding bind(View view) {
        int i = C1965R.id.layout_connect_info;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = C1965R.id.scroll_view;
            ScrollView scrollView = (ScrollView) view.findViewById(i);
            if (scrollView != null) {
                i = C1965R.id.tv_band;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_freq_hopping;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_lost;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            i = C1965R.id.tv_msg;
                            TextView textView4 = (TextView) view.findViewById(i);
                            if (textView4 != null) {
                                i = C1965R.id.tv_rssi;
                                TextView textView5 = (TextView) view.findViewById(i);
                                if (textView5 != null) {
                                    return new ViewLayoutTestFpvBinding(relativeLayout, linearLayout, relativeLayout, scrollView, textView, textView2, textView3, textView4, textView5);
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