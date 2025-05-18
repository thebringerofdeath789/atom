package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewAdapterWarnItemHeadBinding implements ViewBinding {
    public final ImageButton btnClose;
    public final LinearLayout rlTopView;
    private final LinearLayout rootView;

    private ViewAdapterWarnItemHeadBinding(LinearLayout linearLayout, ImageButton imageButton, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btnClose = imageButton;
        this.rlTopView = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterWarnItemHeadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterWarnItemHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_adapter_warn_item_head, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterWarnItemHeadBinding bind(View view) {
        int i = C1965R.id.btn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new ViewAdapterWarnItemHeadBinding(linearLayout, imageButton, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}