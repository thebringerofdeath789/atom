package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.MiniLandSlideUnlockView;

/* loaded from: classes2.dex */
public final class ViewDialogMiniSlideLandBinding implements ViewBinding {
    public final ImageButton btnCloseLand;
    public final MiniLandSlideUnlockView btnMiniSlideUnlockLand;
    private final ShadowLayout rootView;
    public final TextView tvCountDown;
    public final TextView tvMiniLandTitle;
    public final TextView tvMiniTakeoffContent;

    private ViewDialogMiniSlideLandBinding(ShadowLayout shadowLayout, ImageButton imageButton, MiniLandSlideUnlockView miniLandSlideUnlockView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = shadowLayout;
        this.btnCloseLand = imageButton;
        this.btnMiniSlideUnlockLand = miniLandSlideUnlockView;
        this.tvCountDown = textView;
        this.tvMiniLandTitle = textView2;
        this.tvMiniTakeoffContent = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogMiniSlideLandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogMiniSlideLandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_mini_slide_land, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogMiniSlideLandBinding bind(View view) {
        int i = R.id.btn_close_land;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.btn_mini_slide_unlock_land;
            MiniLandSlideUnlockView miniLandSlideUnlockView = (MiniLandSlideUnlockView) view.findViewById(i);
            if (miniLandSlideUnlockView != null) {
                i = R.id.tv_count_down;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.tv_mini_land_title;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = R.id.tv_mini_takeoff_content;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            return new ViewDialogMiniSlideLandBinding((ShadowLayout) view, imageButton, miniLandSlideUnlockView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
