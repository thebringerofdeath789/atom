package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogRepairMainBinding implements ViewBinding {
    public final Button btnOk;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvRepairTitle;

    private ViewDialogRepairMainBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnOk = button;
        this.tvContent = textView;
        this.tvRepairTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogRepairMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogRepairMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_repair_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogRepairMainBinding bind(View view) {
        int i = R.id.btn_ok;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_repair_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewDialogRepairMainBinding((LinearLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
