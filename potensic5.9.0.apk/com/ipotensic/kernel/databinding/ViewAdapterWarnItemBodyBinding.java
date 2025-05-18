package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewAdapterWarnItemBodyBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvContent;

    private ViewAdapterWarnItemBodyBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ViewAdapterWarnItemBodyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterWarnItemBodyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_adapter_warn_item_body, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterWarnItemBodyBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ViewAdapterWarnItemBodyBinding(textView, textView);
    }
}