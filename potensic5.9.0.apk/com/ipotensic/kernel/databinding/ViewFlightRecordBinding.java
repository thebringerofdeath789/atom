package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewFlightRecordBinding implements ViewBinding {
    public final TextView edtSpeed;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;
    public final LinearLayout llDistance;
    public final LinearLayout llDuration;
    public final LinearLayout llHeight;
    public final LinearLayout llMileage;
    public final LinearLayout llSpeedHorizontal;
    private final ConstraintLayout rootView;
    public final TextView tvDate;
    public final TextView tvDuration;
    public final TextView tvHeight;
    public final TextView tvMileage;
    public final TextView tvPointFlight;

    private ViewFlightRecordBinding(ConstraintLayout constraintLayout, TextView textView, View view, View view2, View view3, View view4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.edtSpeed = textView;
        this.line1 = view;
        this.line2 = view2;
        this.line3 = view3;
        this.line4 = view4;
        this.llDistance = linearLayout;
        this.llDuration = linearLayout2;
        this.llHeight = linearLayout3;
        this.llMileage = linearLayout4;
        this.llSpeedHorizontal = linearLayout5;
        this.tvDate = textView2;
        this.tvDuration = textView3;
        this.tvHeight = textView4;
        this.tvMileage = textView5;
        this.tvPointFlight = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewFlightRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewFlightRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_flight_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewFlightRecordBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        int i = C1965R.id.edt_speed;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null && (findViewById = view.findViewById((i = C1965R.id.line1))) != null && (findViewById2 = view.findViewById((i = C1965R.id.line2))) != null && (findViewById3 = view.findViewById((i = C1965R.id.line3))) != null && (findViewById4 = view.findViewById((i = C1965R.id.line4))) != null) {
            i = C1965R.id.ll_distance;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                i = C1965R.id.ll_duration;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                if (linearLayout2 != null) {
                    i = C1965R.id.ll_height;
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                    if (linearLayout3 != null) {
                        i = C1965R.id.ll_mileage;
                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(i);
                        if (linearLayout4 != null) {
                            i = C1965R.id.ll_speed_horizontal;
                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(i);
                            if (linearLayout5 != null) {
                                i = C1965R.id.tv_date;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C1965R.id.tv_duration;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = C1965R.id.tv_height;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = C1965R.id.tv_mileage;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = C1965R.id.tv_point_flight;
                                                TextView textView6 = (TextView) view.findViewById(i);
                                                if (textView6 != null) {
                                                    return new ViewFlightRecordBinding((ConstraintLayout) view, textView, findViewById, findViewById2, findViewById3, findViewById4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView2, textView3, textView4, textView5, textView6);
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