package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewItemFlightRecordHeadBinding implements ViewBinding {
    private final TextView rootView;

    private ViewItemFlightRecordHeadBinding(TextView textView) {
        this.rootView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ViewItemFlightRecordHeadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemFlightRecordHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_item_flight_record_head, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemFlightRecordHeadBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewItemFlightRecordHeadBinding((TextView) view);
    }
}