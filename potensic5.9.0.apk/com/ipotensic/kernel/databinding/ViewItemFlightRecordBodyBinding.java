package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.deleteview.SwipeItemLayout;

/* loaded from: classes2.dex */
public final class ViewItemFlightRecordBodyBinding implements ViewBinding {
    public final Button delete;
    public final LinearLayout itemLl;
    private final SwipeItemLayout rootView;
    public final SwipeItemLayout swipeLayout;
    public final TextView tvItem;

    private ViewItemFlightRecordBodyBinding(SwipeItemLayout swipeItemLayout, Button button, LinearLayout linearLayout, SwipeItemLayout swipeItemLayout2, TextView textView) {
        this.rootView = swipeItemLayout;
        this.delete = button;
        this.itemLl = linearLayout;
        this.swipeLayout = swipeItemLayout2;
        this.tvItem = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SwipeItemLayout getRoot() {
        return this.rootView;
    }

    public static ViewItemFlightRecordBodyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemFlightRecordBodyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_item_flight_record_body, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemFlightRecordBodyBinding bind(View view) {
        int i = C1965R.id.delete;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.item_ll;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                SwipeItemLayout swipeItemLayout = (SwipeItemLayout) view;
                i = C1965R.id.tv_item;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new ViewItemFlightRecordBodyBinding(swipeItemLayout, button, linearLayout, swipeItemLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}