package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.MiniTakeoffSlideUnlockView;

/* loaded from: classes2.dex */
public final class ViewDialogMiniSlideTakeoffBinding implements ViewBinding {
    public final ImageButton btnCloseTakeoff;
    public final MiniTakeoffSlideUnlockView btnMiniSlideUnlockTakeoff;
    private final ShadowLayout rootView;
    public final TextView tvMiniTakeoffContent;
    public final TextView tvMiniTakeoffTitle;

    private ViewDialogMiniSlideTakeoffBinding(ShadowLayout shadowLayout, ImageButton imageButton, MiniTakeoffSlideUnlockView miniTakeoffSlideUnlockView, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnCloseTakeoff = imageButton;
        this.btnMiniSlideUnlockTakeoff = miniTakeoffSlideUnlockView;
        this.tvMiniTakeoffContent = textView;
        this.tvMiniTakeoffTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogMiniSlideTakeoffBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogMiniSlideTakeoffBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_mini_slide_takeoff, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogMiniSlideTakeoffBinding bind(View view) {
        int i = R.id.btn_close_takeoff;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.btn_mini_slide_unlock_takeoff;
            MiniTakeoffSlideUnlockView miniTakeoffSlideUnlockView = (MiniTakeoffSlideUnlockView) view.findViewById(i);
            if (miniTakeoffSlideUnlockView != null) {
                i = R.id.tv_mini_takeoff_content;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.tv_mini_takeoff_title;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new ViewDialogMiniSlideTakeoffBinding((ShadowLayout) view, imageButton, miniTakeoffSlideUnlockView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
