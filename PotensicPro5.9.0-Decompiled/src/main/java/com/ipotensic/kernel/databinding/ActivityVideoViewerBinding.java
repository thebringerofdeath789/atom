package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ActivityVideoViewerBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ImageButton btnDelete;
    public final ImageButton btnDownload;
    public final ImageButton btnMediaInfo;
    public final ImageButton btnMediaShare;
    public final ConstraintLayout layoutBottom;
    public final ConstraintLayout layoutMain;
    public final ConstraintLayout layoutTop;
    public final LooperViewPager loopViewpager;
    private final ConstraintLayout rootView;
    public final TextView tvCurPageNum;
    public final TextView tvShowTips;
    public final TextView tvTips;

    private ActivityVideoViewerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LooperViewPager looperViewPager, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.btnDelete = imageButton;
        this.btnDownload = imageButton2;
        this.btnMediaInfo = imageButton3;
        this.btnMediaShare = imageButton4;
        this.layoutBottom = constraintLayout2;
        this.layoutMain = constraintLayout3;
        this.layoutTop = constraintLayout4;
        this.loopViewpager = looperViewPager;
        this.tvCurPageNum = textView;
        this.tvShowTips = textView2;
        this.tvTips = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVideoViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVideoViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_video_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityVideoViewerBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.btn_delete;
            ImageButton imageButton = (ImageButton) view.findViewById(i);
            if (imageButton != null) {
                i = R.id.btn_download;
                ImageButton imageButton2 = (ImageButton) view.findViewById(i);
                if (imageButton2 != null) {
                    i = R.id.btn_media_info;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                    if (imageButton3 != null) {
                        i = R.id.btn_media_share;
                        ImageButton imageButton4 = (ImageButton) view.findViewById(i);
                        if (imageButton4 != null) {
                            i = R.id.layout_bottom;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                            if (constraintLayout != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                i = R.id.layout_top;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout3 != null) {
                                    i = R.id.loop_viewpager;
                                    LooperViewPager looperViewPager = (LooperViewPager) view.findViewById(i);
                                    if (looperViewPager != null) {
                                        i = R.id.tv_cur_page_num;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            i = R.id.tvShowTips;
                                            TextView textView2 = (TextView) view.findViewById(i);
                                            if (textView2 != null) {
                                                i = R.id.tvTips;
                                                TextView textView3 = (TextView) view.findViewById(i);
                                                if (textView3 != null) {
                                                    return new ActivityVideoViewerBinding(constraintLayout2, imageView, imageButton, imageButton2, imageButton3, imageButton4, constraintLayout, constraintLayout2, constraintLayout3, looperViewPager, textView, textView2, textView3);
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
