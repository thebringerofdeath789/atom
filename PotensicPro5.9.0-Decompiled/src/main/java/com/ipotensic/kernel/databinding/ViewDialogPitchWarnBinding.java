package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogPitchWarnBinding implements ViewBinding {
    public final Button btnConfirm;
    public final ImageView imgTip;
    public final LinearLayout layoutTop;
    private final RoundRelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvTitle;

    private ViewDialogPitchWarnBinding(RoundRelativeLayout roundRelativeLayout, Button button, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = roundRelativeLayout;
        this.btnConfirm = button;
        this.imgTip = imageView;
        this.layoutTop = linearLayout;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogPitchWarnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogPitchWarnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_pitch_warn, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogPitchWarnBinding bind(View view) {
        int i = R.id.btn_confirm;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.img_tip;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.layout_top;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = R.id.tv_content;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new ViewDialogPitchWarnBinding((RoundRelativeLayout) view, button, imageView, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
