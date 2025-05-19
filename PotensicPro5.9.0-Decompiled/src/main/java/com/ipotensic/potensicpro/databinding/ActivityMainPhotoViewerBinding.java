package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityMainPhotoViewerBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ImageButton btnDelete;
    public final ImageButton btnMediaInfo;
    public final ImageButton btnMediaShare;
    public final ConstraintLayout layoutBottom;
    public final ConstraintLayout layoutMain;
    public final ConstraintLayout layoutTop;
    public final LooperViewPager loopViewpager;
    private final ConstraintLayout rootView;
    public final TextView tvDate;

    private ActivityMainPhotoViewerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LooperViewPager looperViewPager, TextView textView) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.btnDelete = imageButton;
        this.btnMediaInfo = imageButton2;
        this.btnMediaShare = imageButton3;
        this.layoutBottom = constraintLayout2;
        this.layoutMain = constraintLayout3;
        this.layoutTop = constraintLayout4;
        this.loopViewpager = looperViewPager;
        this.tvDate = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainPhotoViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainPhotoViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main_photo_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainPhotoViewerBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_back);
        if (imageView != null) {
            i = R.id.btn_delete;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_delete);
            if (imageButton != null) {
                i = R.id.btn_media_info;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_media_info);
                if (imageButton2 != null) {
                    i = R.id.btn_media_share;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btn_media_share);
                    if (imageButton3 != null) {
                        i = R.id.layout_bottom;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.layout_bottom);
                        if (constraintLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.layout_top;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.layout_top);
                            if (constraintLayout3 != null) {
                                i = R.id.loop_viewpager;
                                LooperViewPager looperViewPager = (LooperViewPager) view.findViewById(R.id.loop_viewpager);
                                if (looperViewPager != null) {
                                    i = R.id.tv_date;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_date);
                                    if (textView != null) {
                                        return new ActivityMainPhotoViewerBinding(constraintLayout2, imageView, imageButton, imageButton2, imageButton3, constraintLayout, constraintLayout2, constraintLayout3, looperViewPager, textView);
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
