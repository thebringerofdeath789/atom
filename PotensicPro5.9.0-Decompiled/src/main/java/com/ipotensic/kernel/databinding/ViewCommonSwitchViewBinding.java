package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewCommonSwitchViewBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SwitchButton switchBtn;
    public final TextView tvContent;
    public final TextView tvTitle;

    private ViewCommonSwitchViewBinding(RelativeLayout relativeLayout, SwitchButton switchButton, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.switchBtn = switchButton;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewCommonSwitchViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCommonSwitchViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_common_switch_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCommonSwitchViewBinding bind(View view) {
        int i = R.id.switch_btn;
        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
        if (switchButton != null) {
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewCommonSwitchViewBinding((RelativeLayout) view, switchButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
