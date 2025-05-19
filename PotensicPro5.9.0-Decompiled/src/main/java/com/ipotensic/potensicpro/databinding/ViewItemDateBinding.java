package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewItemDateBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvDate;

    private ViewItemDateBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvDate = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ViewItemDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_item_date, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemDateBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ViewItemDateBinding(textView, textView);
    }
}
