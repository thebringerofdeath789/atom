package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.ExpandableView;
import com.ipotensic.kernel.view.ImageGridView;

/* loaded from: classes2.dex */
public final class ViewRightCameraSetBinding implements ViewBinding {
    public final ExpandableView evExpandable;
    public final ImageGridView gvQulity;
    public final ImageGridView gvRatio;
    public final ImageGridView gvVideo;
    public final ViewRightCameraSetItem1Binding include1;
    public final ViewRightCameraSetItem5Binding include5;
    public final ImageView ivSet;
    public final ExpandableView layoutPhotoSizes;
    public final ExpandableView layoutVideoSegment;
    public final ExpandableView layoutVideoSizes;
    public final View lineFormat;
    public final View linePhotoResolution;
    public final View linePhotoSizes;
    public final View lineVideoSegment;
    public final View lineVideoSizes;
    public final View lineWaterMark;
    public final LinearLayout llCameraSet;
    public final TextView photoResolutionTitle;
    public final ConstraintLayout rlPhotoResolution;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvPhotoResolution;
    public final ViewRightCameraSetItem4Binding viewFormat;
    public final ViewRightCameraSetItem2Binding viewWaterMark;

    private ViewRightCameraSetBinding(ConstraintLayout constraintLayout, ExpandableView expandableView, ImageGridView imageGridView, ImageGridView imageGridView2, ImageGridView imageGridView3, ViewRightCameraSetItem1Binding viewRightCameraSetItem1Binding, ViewRightCameraSetItem5Binding viewRightCameraSetItem5Binding, ImageView imageView, ExpandableView expandableView2, ExpandableView expandableView3, ExpandableView expandableView4, View view, View view2, View view3, View view4, View view5, View view6, LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout2, ScrollView scrollView, TextView textView2, ViewRightCameraSetItem4Binding viewRightCameraSetItem4Binding, ViewRightCameraSetItem2Binding viewRightCameraSetItem2Binding) {
        this.rootView = constraintLayout;
        this.evExpandable = expandableView;
        this.gvQulity = imageGridView;
        this.gvRatio = imageGridView2;
        this.gvVideo = imageGridView3;
        this.include1 = viewRightCameraSetItem1Binding;
        this.include5 = viewRightCameraSetItem5Binding;
        this.ivSet = imageView;
        this.layoutPhotoSizes = expandableView2;
        this.layoutVideoSegment = expandableView3;
        this.layoutVideoSizes = expandableView4;
        this.lineFormat = view;
        this.linePhotoResolution = view2;
        this.linePhotoSizes = view3;
        this.lineVideoSegment = view4;
        this.lineVideoSizes = view5;
        this.lineWaterMark = view6;
        this.llCameraSet = linearLayout;
        this.photoResolutionTitle = textView;
        this.rlPhotoResolution = constraintLayout2;
        this.scrollView = scrollView;
        this.tvPhotoResolution = textView2;
        this.viewFormat = viewRightCameraSetItem4Binding;
        this.viewWaterMark = viewRightCameraSetItem2Binding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_right_camera_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraSetBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        View findViewById5;
        View findViewById6;
        View findViewById7;
        View findViewById8;
        int i = C1965R.id.ev_expandable;
        ExpandableView expandableView = (ExpandableView) view.findViewById(i);
        if (expandableView != null) {
            i = C1965R.id.gv_qulity;
            ImageGridView imageGridView = (ImageGridView) view.findViewById(i);
            if (imageGridView != null) {
                i = C1965R.id.gv_ratio;
                ImageGridView imageGridView2 = (ImageGridView) view.findViewById(i);
                if (imageGridView2 != null) {
                    i = C1965R.id.gv_video;
                    ImageGridView imageGridView3 = (ImageGridView) view.findViewById(i);
                    if (imageGridView3 != null && (findViewById = view.findViewById((i = C1965R.id.include1))) != null) {
                        ViewRightCameraSetItem1Binding bind = ViewRightCameraSetItem1Binding.bind(findViewById);
                        i = C1965R.id.include5;
                        View findViewById9 = view.findViewById(i);
                        if (findViewById9 != null) {
                            ViewRightCameraSetItem5Binding bind2 = ViewRightCameraSetItem5Binding.bind(findViewById9);
                            i = C1965R.id.iv_set;
                            ImageView imageView = (ImageView) view.findViewById(i);
                            if (imageView != null) {
                                i = C1965R.id.layout_photo_sizes;
                                ExpandableView expandableView2 = (ExpandableView) view.findViewById(i);
                                if (expandableView2 != null) {
                                    i = C1965R.id.layout_video_segment;
                                    ExpandableView expandableView3 = (ExpandableView) view.findViewById(i);
                                    if (expandableView3 != null) {
                                        i = C1965R.id.layout_video_sizes;
                                        ExpandableView expandableView4 = (ExpandableView) view.findViewById(i);
                                        if (expandableView4 != null && (findViewById2 = view.findViewById((i = C1965R.id.line_format))) != null && (findViewById3 = view.findViewById((i = C1965R.id.line_photo_resolution))) != null && (findViewById4 = view.findViewById((i = C1965R.id.line_photo_sizes))) != null && (findViewById5 = view.findViewById((i = C1965R.id.line_video_segment))) != null && (findViewById6 = view.findViewById((i = C1965R.id.line_video_sizes))) != null && (findViewById7 = view.findViewById((i = C1965R.id.line_water_mark))) != null) {
                                            i = C1965R.id.ll_camera_set;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                            if (linearLayout != null) {
                                                i = C1965R.id.photo_resolution_title;
                                                TextView textView = (TextView) view.findViewById(i);
                                                if (textView != null) {
                                                    i = C1965R.id.rl_photo_resolution;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                                    if (constraintLayout != null) {
                                                        i = C1965R.id.scrollView;
                                                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                                                        if (scrollView != null) {
                                                            i = C1965R.id.tv_photo_resolution;
                                                            TextView textView2 = (TextView) view.findViewById(i);
                                                            if (textView2 != null && (findViewById8 = view.findViewById((i = C1965R.id.view_format))) != null) {
                                                                ViewRightCameraSetItem4Binding bind3 = ViewRightCameraSetItem4Binding.bind(findViewById8);
                                                                i = C1965R.id.view_water_mark;
                                                                View findViewById10 = view.findViewById(i);
                                                                if (findViewById10 != null) {
                                                                    return new ViewRightCameraSetBinding((ConstraintLayout) view, expandableView, imageGridView, imageGridView2, imageGridView3, bind, bind2, imageView, expandableView2, expandableView3, expandableView4, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7, linearLayout, textView, constraintLayout, scrollView, textView2, bind3, ViewRightCameraSetItem2Binding.bind(findViewById10));
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}