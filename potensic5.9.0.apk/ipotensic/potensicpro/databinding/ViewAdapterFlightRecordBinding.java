package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.view.deleteview.SwipeItemLayout;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewAdapterFlightRecordBinding implements ViewBinding {
    public final Button delete;
    public final TextView edtSpeed;
    public final LinearLayout llImg;
    private final SwipeItemLayout rootView;
    public final SwipeItemLayout swipeLayout;
    public final TextView tvDate;
    public final TextView tvDistance;
    public final TextView tvDuration;
    public final TextView tvHeight;

    private ViewAdapterFlightRecordBinding(SwipeItemLayout swipeItemLayout, Button button, TextView textView, LinearLayout linearLayout, SwipeItemLayout swipeItemLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = swipeItemLayout;
        this.delete = button;
        this.edtSpeed = textView;
        this.llImg = linearLayout;
        this.swipeLayout = swipeItemLayout2;
        this.tvDate = textView2;
        this.tvDistance = textView3;
        this.tvDuration = textView4;
        this.tvHeight = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SwipeItemLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterFlightRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterFlightRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_flight_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterFlightRecordBinding bind(View view) {
        int i = R.id.delete;
        Button button = (Button) view.findViewById(R.id.delete);
        if (button != null) {
            i = R.id.edt_speed;
            TextView textView = (TextView) view.findViewById(R.id.edt_speed);
            if (textView != null) {
                i = R.id.ll_img;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_img);
                if (linearLayout != null) {
                    SwipeItemLayout swipeItemLayout = (SwipeItemLayout) view;
                    i = R.id.tv_date;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_date);
                    if (textView2 != null) {
                        i = R.id.tv_distance;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_distance);
                        if (textView3 != null) {
                            i = R.id.tv_duration;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_duration);
                            if (textView4 != null) {
                                i = R.id.tv_height;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_height);
                                if (textView5 != null) {
                                    return new ViewAdapterFlightRecordBinding(swipeItemLayout, button, textView, linearLayout, swipeItemLayout, textView2, textView3, textView4, textView5);
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