package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDeviceConnectBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final CardView cvConnectMethod;
    public final CardView cvEnterFlight;
    private final ConstraintLayout rootView;
    public final TextView tvConnectMethod;
    public final TextView tvEnterFlight;
    public final TextView tvNextStep;

    private ViewDeviceConnectBinding(ConstraintLayout constraintLayout, ImageButton imageButton, CardView cardView, CardView cardView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.cvConnectMethod = cardView;
        this.cvEnterFlight = cardView2;
        this.tvConnectMethod = textView;
        this.tvEnterFlight = textView2;
        this.tvNextStep = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceConnectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDeviceConnectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_device_connect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDeviceConnectBinding bind(View view) {
        int i = R.id.btn_back;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_back);
        if (imageButton != null) {
            i = R.id.cv_connect_method;
            CardView cardView = (CardView) view.findViewById(R.id.cv_connect_method);
            if (cardView != null) {
                i = R.id.cv_enter_flight;
                CardView cardView2 = (CardView) view.findViewById(R.id.cv_enter_flight);
                if (cardView2 != null) {
                    i = R.id.tv_connect_method;
                    TextView textView = (TextView) view.findViewById(R.id.tv_connect_method);
                    if (textView != null) {
                        i = R.id.tv_enter_flight;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_enter_flight);
                        if (textView2 != null) {
                            i = R.id.tv_next_step;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_next_step);
                            if (textView3 != null) {
                                return new ViewDeviceConnectBinding((ConstraintLayout) view, imageButton, cardView, cardView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}