package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityAircraftLogBinding implements ViewBinding {
    public final ImageView ivEmptyLog;
    private final ConstraintLayout rootView;
    public final RecyclerView rv;
    public final ViewToolbarBinding toolbar;
    public final TextView tvLogTips;
    public final TextView tvNoRecord;

    private ActivityAircraftLogBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, ViewToolbarBinding viewToolbarBinding, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivEmptyLog = imageView;
        this.rv = recyclerView;
        this.toolbar = viewToolbarBinding;
        this.tvLogTips = textView;
        this.tvNoRecord = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAircraftLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAircraftLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_aircraft_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAircraftLogBinding bind(View view) {
        int i = R.id.iv_empty_log;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_empty_log);
        if (imageView != null) {
            i = R.id.rv;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
            if (recyclerView != null) {
                i = R.id.toolbar;
                View findViewById = view.findViewById(R.id.toolbar);
                if (findViewById != null) {
                    ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById);
                    i = R.id.tv_log_tips;
                    TextView textView = (TextView) view.findViewById(R.id.tv_log_tips);
                    if (textView != null) {
                        i = R.id.tv_no_record;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_no_record);
                        if (textView2 != null) {
                            return new ActivityAircraftLogBinding((ConstraintLayout) view, imageView, recyclerView, bind, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
