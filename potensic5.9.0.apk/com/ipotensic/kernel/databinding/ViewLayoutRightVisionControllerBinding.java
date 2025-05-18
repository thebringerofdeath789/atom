package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.baselib.views.wheelview.widget.WheelView;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.RightControllerModel;
import com.ipotensic.kernel.view.CaptureProgressButton;
import com.ipotensic.kernel.view.DispatchTextView;
import com.ipotensic.kernel.view.OneKeyVideoButton;
import com.ipotensic.kernel.view.ShortVideoCountDownView;
import com.ipotensic.kernel.view.TimerControlView;
import com.ipotensic.kernel.view.VisionGalleryButton;
import com.ipotensic.kernel.view.ZoomControlView;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutRightVisionControllerBinding extends ViewDataBinding {
    public final View blankView;
    public final ImageButton btnCameraSetting;
    public final CaptureProgressButton btnCapture;
    public final ImageButton btnDemoVideoVisible;
    public final VisionGalleryButton btnGallery;
    public final OneKeyVideoButton btnOneKeyVideo;
    public final ImageButton btnParamsMode;
    public final ImageButton btnSwitchCapture;
    public final Guideline guideRight;
    public final ImageView imgBgParamsSetting;
    public final ImageView ivRecordRed;
    public final ImageView ivTimedCapturePhoto;
    public final LinearLayout layoutCircle;
    public final LinearLayout layoutComet;
    public final RoundRelativeLayout layoutDemoVideo;
    public final LinearLayout layoutRecess;
    public final LinearLayout layoutScrew;
    public final ConstraintLayout layoutShortVideo;
    public final LinearLayout layoutSkyward;
    public final LinearLayout layoutVideoType;
    public final LinearLayout llTimedInfo;

    @Bindable
    protected RightControllerModel mModel;
    public final TimerControlView timerControlView;
    public final TextView tvCameraTime;
    public final TextView tvCircle;
    public final TextView tvComet;
    public final TextView tvCountDown;
    public final TextView tvPhotoCount;
    public final TextView tvRecess;
    public final StrokeTextView tvRecordTips;
    public final TextView tvScrew;
    public final TextView tvSkyward;
    public final TextView tvTeachVideoTips;
    public final DispatchTextView tvTimerScale;
    public final DispatchTextView tvZoomScale;
    public final ShortVideoCountDownView viewCountdown;
    public final VideoView viewDemoVideo;
    public final WheelView wheelView;
    public final ZoomControlView zoomControlView;

    public abstract void setModel(RightControllerModel rightControllerModel);

    protected ViewLayoutRightVisionControllerBinding(Object obj, View view, int i, View view2, ImageButton imageButton, CaptureProgressButton captureProgressButton, ImageButton imageButton2, VisionGalleryButton visionGalleryButton, OneKeyVideoButton oneKeyVideoButton, ImageButton imageButton3, ImageButton imageButton4, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, RoundRelativeLayout roundRelativeLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TimerControlView timerControlView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, StrokeTextView strokeTextView, TextView textView7, TextView textView8, TextView textView9, DispatchTextView dispatchTextView, DispatchTextView dispatchTextView2, ShortVideoCountDownView shortVideoCountDownView, VideoView videoView, WheelView wheelView, ZoomControlView zoomControlView) {
        super(obj, view, i);
        this.blankView = view2;
        this.btnCameraSetting = imageButton;
        this.btnCapture = captureProgressButton;
        this.btnDemoVideoVisible = imageButton2;
        this.btnGallery = visionGalleryButton;
        this.btnOneKeyVideo = oneKeyVideoButton;
        this.btnParamsMode = imageButton3;
        this.btnSwitchCapture = imageButton4;
        this.guideRight = guideline;
        this.imgBgParamsSetting = imageView;
        this.ivRecordRed = imageView2;
        this.ivTimedCapturePhoto = imageView3;
        this.layoutCircle = linearLayout;
        this.layoutComet = linearLayout2;
        this.layoutDemoVideo = roundRelativeLayout;
        this.layoutRecess = linearLayout3;
        this.layoutScrew = linearLayout4;
        this.layoutShortVideo = constraintLayout;
        this.layoutSkyward = linearLayout5;
        this.layoutVideoType = linearLayout6;
        this.llTimedInfo = linearLayout7;
        this.timerControlView = timerControlView;
        this.tvCameraTime = textView;
        this.tvCircle = textView2;
        this.tvComet = textView3;
        this.tvCountDown = textView4;
        this.tvPhotoCount = textView5;
        this.tvRecess = textView6;
        this.tvRecordTips = strokeTextView;
        this.tvScrew = textView7;
        this.tvSkyward = textView8;
        this.tvTeachVideoTips = textView9;
        this.tvTimerScale = dispatchTextView;
        this.tvZoomScale = dispatchTextView2;
        this.viewCountdown = shortVideoCountDownView;
        this.viewDemoVideo = videoView;
        this.wheelView = wheelView;
        this.zoomControlView = zoomControlView;
    }

    public RightControllerModel getModel() {
        return this.mModel;
    }

    public static ViewLayoutRightVisionControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRightVisionControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutRightVisionControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_right_vision_controller, viewGroup, z, obj);
    }

    public static ViewLayoutRightVisionControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRightVisionControllerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutRightVisionControllerBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_right_vision_controller, null, false, obj);
    }

    public static ViewLayoutRightVisionControllerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRightVisionControllerBinding bind(View view, Object obj) {
        return (ViewLayoutRightVisionControllerBinding) bind(obj, view, C1965R.layout.view_layout_right_vision_controller);
    }
}