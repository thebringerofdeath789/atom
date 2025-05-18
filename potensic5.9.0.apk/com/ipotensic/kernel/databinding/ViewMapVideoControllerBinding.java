package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.TwoFingerScaleView;
import com.ipotensic.kernel.view.VisualEffectView;
import com.ipotensic.kernel.view.attitude.AttitudeBallView;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public final class ViewMapVideoControllerBinding implements ViewBinding {
    public final AttitudeBallView attitudeView;
    public final ImageView imgBlurTransBg;
    public final ImageView ivMainBg;
    public final ImageView ivScale;
    public final RelativeLayout layoutBlur;
    public final RelativeLayout layoutScale;
    public final ConstraintLayout layoutTest;
    public final RoundRelativeLayout mapContainer;
    public final ConstraintLayout mapVideoController;
    public final RecyclerView recyclerView;
    public final ConstraintLayout rlCrossLineContainer;
    private final ConstraintLayout rootView;
    public final MapScaleView scaleView;
    public final ViewStub stubCrossLine;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tvBdAcc;
    public final TextView tvCount;
    public final TextView tvSystemAcc;
    public final StrokeTextView tvTof;
    public final TwoFingerScaleView twoFingerScaleView;
    public final RoundRelativeLayout videoContainer;
    public final ViewFlightRecordBinding viewFlightRecordDetails;
    public final ViewMapBinding viewMapControl;
    public final ViewNoFlyZoneHelpBinding viewNoFlyZoneHelp;
    public final View viewSplash;
    public final JfGLSurfaceView viewVideo;
    public final VisualEffectView visualShowView;

    private ViewMapVideoControllerBinding(ConstraintLayout constraintLayout, AttitudeBallView attitudeBallView, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ConstraintLayout constraintLayout2, RoundRelativeLayout roundRelativeLayout, ConstraintLayout constraintLayout3, RecyclerView recyclerView, ConstraintLayout constraintLayout4, MapScaleView mapScaleView, ViewStub viewStub, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, StrokeTextView strokeTextView, TwoFingerScaleView twoFingerScaleView, RoundRelativeLayout roundRelativeLayout2, ViewFlightRecordBinding viewFlightRecordBinding, ViewMapBinding viewMapBinding, ViewNoFlyZoneHelpBinding viewNoFlyZoneHelpBinding, View view, JfGLSurfaceView jfGLSurfaceView, VisualEffectView visualEffectView) {
        this.rootView = constraintLayout;
        this.attitudeView = attitudeBallView;
        this.imgBlurTransBg = imageView;
        this.ivMainBg = imageView2;
        this.ivScale = imageView3;
        this.layoutBlur = relativeLayout;
        this.layoutScale = relativeLayout2;
        this.layoutTest = constraintLayout2;
        this.mapContainer = roundRelativeLayout;
        this.mapVideoController = constraintLayout3;
        this.recyclerView = recyclerView;
        this.rlCrossLineContainer = constraintLayout4;
        this.scaleView = mapScaleView;
        this.stubCrossLine = viewStub;
        this.tv1 = textView;
        this.tv2 = textView2;
        this.tvBdAcc = textView3;
        this.tvCount = textView4;
        this.tvSystemAcc = textView5;
        this.tvTof = strokeTextView;
        this.twoFingerScaleView = twoFingerScaleView;
        this.videoContainer = roundRelativeLayout2;
        this.viewFlightRecordDetails = viewFlightRecordBinding;
        this.viewMapControl = viewMapBinding;
        this.viewNoFlyZoneHelp = viewNoFlyZoneHelpBinding;
        this.viewSplash = view;
        this.viewVideo = jfGLSurfaceView;
        this.visualShowView = visualEffectView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapVideoControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapVideoControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_map_video_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapVideoControllerBinding bind(View view) {
        View findViewById;
        int i = C1965R.id.attitude_view;
        AttitudeBallView attitudeBallView = (AttitudeBallView) view.findViewById(i);
        if (attitudeBallView != null) {
            i = C1965R.id.img_blur_trans_bg;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1965R.id.iv_main_bg;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C1965R.id.iv_scale;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = C1965R.id.layout_blur;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                        if (relativeLayout != null) {
                            i = C1965R.id.layout_scale;
                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                            if (relativeLayout2 != null) {
                                i = C1965R.id.layout_test;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout != null) {
                                    i = C1965R.id.map_container;
                                    RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view.findViewById(i);
                                    if (roundRelativeLayout != null) {
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                        i = C1965R.id.recycler_view;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                                        if (recyclerView != null) {
                                            i = C1965R.id.rl_cross_line_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(i);
                                            if (constraintLayout3 != null) {
                                                i = C1965R.id.scaleView;
                                                MapScaleView mapScaleView = (MapScaleView) view.findViewById(i);
                                                if (mapScaleView != null) {
                                                    i = C1965R.id.stub_cross_line;
                                                    ViewStub viewStub = (ViewStub) view.findViewById(i);
                                                    if (viewStub != null) {
                                                        i = C1965R.id.tv1;
                                                        TextView textView = (TextView) view.findViewById(i);
                                                        if (textView != null) {
                                                            i = C1965R.id.tv2;
                                                            TextView textView2 = (TextView) view.findViewById(i);
                                                            if (textView2 != null) {
                                                                i = C1965R.id.tv_bd_acc;
                                                                TextView textView3 = (TextView) view.findViewById(i);
                                                                if (textView3 != null) {
                                                                    i = C1965R.id.tv_count;
                                                                    TextView textView4 = (TextView) view.findViewById(i);
                                                                    if (textView4 != null) {
                                                                        i = C1965R.id.tv_system_acc;
                                                                        TextView textView5 = (TextView) view.findViewById(i);
                                                                        if (textView5 != null) {
                                                                            i = C1965R.id.tvTof;
                                                                            StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(i);
                                                                            if (strokeTextView != null) {
                                                                                i = C1965R.id.two_finger_scale_view;
                                                                                TwoFingerScaleView twoFingerScaleView = (TwoFingerScaleView) view.findViewById(i);
                                                                                if (twoFingerScaleView != null) {
                                                                                    i = C1965R.id.video_container;
                                                                                    RoundRelativeLayout roundRelativeLayout2 = (RoundRelativeLayout) view.findViewById(i);
                                                                                    if (roundRelativeLayout2 != null && (findViewById = view.findViewById((i = C1965R.id.view_flight_record_details))) != null) {
                                                                                        ViewFlightRecordBinding bind = ViewFlightRecordBinding.bind(findViewById);
                                                                                        i = C1965R.id.view_map_control;
                                                                                        View findViewById2 = view.findViewById(i);
                                                                                        if (findViewById2 != null) {
                                                                                            ViewMapBinding bind2 = ViewMapBinding.bind(findViewById2);
                                                                                            i = C1965R.id.view_no_fly_zone_help;
                                                                                            View findViewById3 = view.findViewById(i);
                                                                                            if (findViewById3 != null) {
                                                                                                ViewNoFlyZoneHelpBinding bind3 = ViewNoFlyZoneHelpBinding.bind(findViewById3);
                                                                                                i = C1965R.id.view_splash;
                                                                                                View findViewById4 = view.findViewById(i);
                                                                                                if (findViewById4 != null) {
                                                                                                    i = C1965R.id.view_video;
                                                                                                    JfGLSurfaceView jfGLSurfaceView = (JfGLSurfaceView) view.findViewById(i);
                                                                                                    if (jfGLSurfaceView != null) {
                                                                                                        i = C1965R.id.visual_show_view;
                                                                                                        VisualEffectView visualEffectView = (VisualEffectView) view.findViewById(i);
                                                                                                        if (visualEffectView != null) {
                                                                                                            return new ViewMapVideoControllerBinding(constraintLayout2, attitudeBallView, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, constraintLayout, roundRelativeLayout, constraintLayout2, recyclerView, constraintLayout3, mapScaleView, viewStub, textView, textView2, textView3, textView4, textView5, strokeTextView, twoFingerScaleView, roundRelativeLayout2, bind, bind2, bind3, findViewById4, jfGLSurfaceView, visualEffectView);
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