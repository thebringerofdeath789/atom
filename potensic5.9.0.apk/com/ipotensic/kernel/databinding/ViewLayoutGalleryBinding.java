package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutGalleryBinding implements ViewBinding {
    public final ImageButton btnDelete;
    public final ImageButton btnDownload;
    public final ImageView btnReturn;
    public final ImageView imgNone;
    public final ConstraintLayout layoutBottom;
    public final ConstraintLayout layoutGalleryMain;
    public final ConstraintLayout layoutIndicator;
    public final ConstraintLayout layoutTop;
    public final View linePhotosTabBottom;
    public final View lineVideosTabBottom;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvPhotos;
    public final TextView tvSelect;
    public final TextView tvVideos;

    private ViewLayoutGalleryBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, View view, View view2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnDelete = imageButton;
        this.btnDownload = imageButton2;
        this.btnReturn = imageView;
        this.imgNone = imageView2;
        this.layoutBottom = constraintLayout2;
        this.layoutGalleryMain = constraintLayout3;
        this.layoutIndicator = constraintLayout4;
        this.layoutTop = constraintLayout5;
        this.linePhotosTabBottom = view;
        this.lineVideosTabBottom = view2;
        this.recyclerView = recyclerView;
        this.tvPhotos = textView;
        this.tvSelect = textView2;
        this.tvVideos = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutGalleryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutGalleryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_gallery, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutGalleryBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = C1965R.id.btn_delete;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.btn_download;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = C1965R.id.btn_return;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C1965R.id.img_none;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C1965R.id.layout_bottom;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                        if (constraintLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = C1965R.id.layout_indicator;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(i);
                            if (constraintLayout3 != null) {
                                i = C1965R.id.layout_top;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout4 != null && (findViewById = view.findViewById((i = C1965R.id.line_photos_tab_bottom))) != null && (findViewById2 = view.findViewById((i = C1965R.id.line_videos_tab_bottom))) != null) {
                                    i = C1965R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                                    if (recyclerView != null) {
                                        i = C1965R.id.tv_photos;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            i = C1965R.id.tv_select;
                                            TextView textView2 = (TextView) view.findViewById(i);
                                            if (textView2 != null) {
                                                i = C1965R.id.tv_videos;
                                                TextView textView3 = (TextView) view.findViewById(i);
                                                if (textView3 != null) {
                                                    return new ViewLayoutGalleryBinding(constraintLayout2, imageButton, imageButton2, imageView, imageView2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, findViewById, findViewById2, recyclerView, textView, textView2, textView3);
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