package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.TopTabView;

/* loaded from: classes2.dex */
public final class ViewMainPageMediaBinding implements ViewBinding {
    public final ImageButton btnCloseNoPermission;
    public final ImageButton btnDelete;
    public final ImageButton btnSelect;
    public final ImageButton btnShare;
    public final ImageView imgNone;
    public final RelativeLayout layoutBottom;
    public final LinearLayout layoutNoPermission;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvGoSetting;
    public final TextView tvNoPermission;
    public final TextView tvSelect;
    public final View viewHead;
    public final TopTabView viewTopTab;

    private ViewMainPageMediaBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageView imageView, RelativeLayout relativeLayout, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, View view, TopTabView topTabView) {
        this.rootView = constraintLayout;
        this.btnCloseNoPermission = imageButton;
        this.btnDelete = imageButton2;
        this.btnSelect = imageButton3;
        this.btnShare = imageButton4;
        this.imgNone = imageView;
        this.layoutBottom = relativeLayout;
        this.layoutNoPermission = linearLayout;
        this.recyclerView = recyclerView;
        this.tvGoSetting = textView;
        this.tvNoPermission = textView2;
        this.tvSelect = textView3;
        this.viewHead = view;
        this.viewTopTab = topTabView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainPageMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainPageMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_main_page_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainPageMediaBinding bind(View view) {
        int i = R.id.btn_close_no_permission;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_close_no_permission);
        if (imageButton != null) {
            i = R.id.btn_delete;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_delete);
            if (imageButton2 != null) {
                i = R.id.btn_select;
                ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btn_select);
                if (imageButton3 != null) {
                    i = R.id.btn_share;
                    ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.btn_share);
                    if (imageButton4 != null) {
                        i = R.id.img_none;
                        ImageView imageView = (ImageView) view.findViewById(R.id.img_none);
                        if (imageView != null) {
                            i = R.id.layout_bottom;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_bottom);
                            if (relativeLayout != null) {
                                i = R.id.layout_no_permission;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_no_permission);
                                if (linearLayout != null) {
                                    i = R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                                    if (recyclerView != null) {
                                        i = R.id.tv_go_setting;
                                        TextView textView = (TextView) view.findViewById(R.id.tv_go_setting);
                                        if (textView != null) {
                                            i = R.id.tv_no_permission;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_no_permission);
                                            if (textView2 != null) {
                                                i = R.id.tv_select;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_select);
                                                if (textView3 != null) {
                                                    i = R.id.view_head;
                                                    View findViewById = view.findViewById(R.id.view_head);
                                                    if (findViewById != null) {
                                                        i = R.id.view_top_tab;
                                                        TopTabView topTabView = (TopTabView) view.findViewById(R.id.view_top_tab);
                                                        if (topTabView != null) {
                                                            return new ViewMainPageMediaBinding((ConstraintLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageView, relativeLayout, linearLayout, recyclerView, textView, textView2, textView3, findViewById, topTabView);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}