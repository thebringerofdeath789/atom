package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewWarnBinding implements ViewBinding {
    public final ImageButton btnWarnClose;
    public final ImageButton btnWarnView;
    public final RelativeLayout llTopView;
    private final FrameLayout rootView;
    public final RecyclerView rvWarnList;
    public final ShadowLayout shadowLayout;

    private ViewWarnBinding(FrameLayout frameLayout, ImageButton imageButton, ImageButton imageButton2, RelativeLayout relativeLayout, RecyclerView recyclerView, ShadowLayout shadowLayout) {
        this.rootView = frameLayout;
        this.btnWarnClose = imageButton;
        this.btnWarnView = imageButton2;
        this.llTopView = relativeLayout;
        this.rvWarnList = recyclerView;
        this.shadowLayout = shadowLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewWarnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewWarnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_warn, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewWarnBinding bind(View view) {
        int i = R.id.btn_warn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.btn_warn_view;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.ll_top_view;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                if (relativeLayout != null) {
                    i = R.id.rv_warn_list;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                    if (recyclerView != null) {
                        i = R.id.shadow_layout;
                        ShadowLayout shadowLayout = (ShadowLayout) view.findViewById(i);
                        if (shadowLayout != null) {
                            return new ViewWarnBinding((FrameLayout) view, imageButton, imageButton2, relativeLayout, recyclerView, shadowLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}