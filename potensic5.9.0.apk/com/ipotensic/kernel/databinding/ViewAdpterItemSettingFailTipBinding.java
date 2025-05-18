package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewAdpterItemSettingFailTipBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvMessageTip;

    private ViewAdpterItemSettingFailTipBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvMessageTip = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ViewAdpterItemSettingFailTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdpterItemSettingFailTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_adpter_item_setting_fail_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdpterItemSettingFailTipBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ViewAdpterItemSettingFailTipBinding(textView, textView);
    }
}