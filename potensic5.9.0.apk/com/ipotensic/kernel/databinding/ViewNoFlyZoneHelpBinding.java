package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewNoFlyZoneHelpBinding implements ViewBinding {
    public final TextView quitMapExplain;
    public final RelativeLayout rootMapExplain;
    private final RelativeLayout rootView;
    public final RecyclerView rvMapExplain;

    private ViewNoFlyZoneHelpBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.quitMapExplain = textView;
        this.rootMapExplain = relativeLayout2;
        this.rvMapExplain = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewNoFlyZoneHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewNoFlyZoneHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_no_fly_zone_help, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewNoFlyZoneHelpBinding bind(View view) {
        int i = C1965R.id.quitMapExplain;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = C1965R.id.rvMapExplain;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i2);
            if (recyclerView != null) {
                return new ViewNoFlyZoneHelpBinding(relativeLayout, textView, relativeLayout, recyclerView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}