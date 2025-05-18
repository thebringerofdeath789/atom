package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Item8Binding implements ViewBinding {
    public final CursorEditText etReturnHeightValue;
    public final LinearLayout layoutReturnHeight;
    public final ConstraintLayout layoutReturnHeightSetting;
    private final ConstraintLayout rootView;
    public final CustomSeekbar seekBarReturnHeight;
    public final TextView tvReturnHeight;
    public final TextView tvUnitReturnHeight;

    private ViewLayoutSetting1Item8Binding(ConstraintLayout constraintLayout, CursorEditText cursorEditText, LinearLayout linearLayout, ConstraintLayout constraintLayout2, CustomSeekbar customSeekbar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.etReturnHeightValue = cursorEditText;
        this.layoutReturnHeight = linearLayout;
        this.layoutReturnHeightSetting = constraintLayout2;
        this.seekBarReturnHeight = customSeekbar;
        this.tvReturnHeight = textView;
        this.tvUnitReturnHeight = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Item8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Item8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting1_item8, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Item8Binding bind(View view) {
        int i = R.id.et_return_height_value;
        CursorEditText cursorEditText = (CursorEditText) view.findViewById(i);
        if (cursorEditText != null) {
            i = R.id.layout_return_height;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.seekBar_return_height;
                CustomSeekbar customSeekbar = (CustomSeekbar) view.findViewById(i);
                if (customSeekbar != null) {
                    i = R.id.tv_return_height;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_unit_return_height;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new ViewLayoutSetting1Item8Binding(constraintLayout, cursorEditText, linearLayout, constraintLayout, customSeekbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}