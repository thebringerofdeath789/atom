package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewAdapterWarnItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvNum;

    private ViewAdapterWarnItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.tvContent = textView;
        this.tvNum = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterWarnItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterWarnItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_warn_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterWarnItemBinding bind(View view) {
        int i = R.id.tv_content;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tv_num;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new ViewAdapterWarnItemBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
