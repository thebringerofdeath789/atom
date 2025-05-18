package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityFlightRecordBinding implements ViewBinding {
    public final CardView cardView2;
    public final ImageView ivEmpty;
    public final View line;
    public final LinearLayout llImg;
    private final ConstraintLayout rootView;
    public final RecyclerView rvView;
    public final ViewToolbarBinding toolbar;
    public final TextView tvEmpty;

    private ActivityFlightRecordBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, View view, LinearLayout linearLayout, RecyclerView recyclerView, ViewToolbarBinding viewToolbarBinding, TextView textView) {
        this.rootView = constraintLayout;
        this.cardView2 = cardView;
        this.ivEmpty = imageView;
        this.line = view;
        this.llImg = linearLayout;
        this.rvView = recyclerView;
        this.toolbar = viewToolbarBinding;
        this.tvEmpty = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFlightRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFlightRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_flight_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFlightRecordBinding bind(View view) {
        int i = R.id.cardView_2;
        CardView cardView = (CardView) view.findViewById(R.id.cardView_2);
        if (cardView != null) {
            i = R.id.iv_empty;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_empty);
            if (imageView != null) {
                i = R.id.line;
                View findViewById = view.findViewById(R.id.line);
                if (findViewById != null) {
                    i = R.id.ll_img;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_img);
                    if (linearLayout != null) {
                        i = R.id.rv_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view);
                        if (recyclerView != null) {
                            i = R.id.toolbar;
                            View findViewById2 = view.findViewById(R.id.toolbar);
                            if (findViewById2 != null) {
                                ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById2);
                                i = R.id.tv_empty;
                                TextView textView = (TextView) view.findViewById(R.id.tv_empty);
                                if (textView != null) {
                                    return new ActivityFlightRecordBinding((ConstraintLayout) view, cardView, imageView, findViewById, linearLayout, recyclerView, bind, textView);
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