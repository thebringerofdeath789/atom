package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogReturnGuideVideoBinding implements ViewBinding {
    public final ImageButton btnRthGuidePlay;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private ViewDialogReturnGuideVideoBinding(LinearLayout linearLayout, ImageButton imageButton, TextView textView) {
        this.rootView = linearLayout;
        this.btnRthGuidePlay = imageButton;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogReturnGuideVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogReturnGuideVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_return_guide_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogReturnGuideVideoBinding bind(View view) {
        int i = R.id.btn_rth_guide_play;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ViewDialogReturnGuideVideoBinding((LinearLayout) view, imageButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
