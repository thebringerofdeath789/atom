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
public final class ActivityLocationBinding implements ViewBinding {
    public final Button addfence;
    private final LinearLayout rootView;
    public final TextView textView1;

    private ActivityLocationBinding(LinearLayout linearLayout, Button button, TextView textView) {
        this.rootView = linearLayout;
        this.addfence = button;
        this.textView1 = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLocationBinding bind(View view) {
        int i = R.id.addfence;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.textView1;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ActivityLocationBinding((LinearLayout) view, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
