package com.ipotensic.kernel.controllers;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.VisionError;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.listener.OnSuccessListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.SoundPoolPlayer;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutRightVisionControllerBinding;
import com.ipotensic.kernel.enums.CaptureUIType;
import com.ipotensic.kernel.enums.GalleryUIType;
import com.ipotensic.kernel.enums.Mode;
import com.ipotensic.kernel.interfaces.RightControllerListener;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.RightControllerModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.VideoViewPlayer;
import com.ipotensic.kernel.view.VisualEffectView;
import com.ipotensic.kernel.view.dialog.PitchWarnDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TimedPhotoUploadData;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.enums.CaptureMode;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevRemoterStateData;
import com.logan.h264.H264DecodeThread1;
import com.logan.usb.AOAEngine;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public class RightController extends BaseController {
    private static final long HIDE_DISC_TIME = 3000;
    private static final int MSG_HIDE_TIMER_DISC = 4;
    private static final int MSG_HIDE_ZOOM_DISC = 1;
    private static final int MSG_RESET_ZOOM_BUTTON = 0;
    private static final int MSG_SEND_TIMER_COMMAND = 5;
    private static final int MSG_SEND_ZOOM_COMMAND = 2;
    private static final int MSG_STOP_SEND_ZOOM_COMMAND = 6;
    private static final int MSG_TIMED_NOT_SUPPORT = 8;
    private static final int MSG_ZOOM_NOT_SUPPORT = 3;
    private static final long UNSELECT_ZOOM_BUTTON_TIME = 5000;
    private ViewLayoutRightVisionControllerBinding dataBinding;
    private final Handler handler;
    private boolean isFirstDispatch;
    private boolean isRequestTakePhotoMode;
    private KernelViewModel kernelViewModel;
    private float lastZoom;
    private int maxZoom;
    private int minZoom;
    private RightControllerModel model;
    private PitchWarnDialog pitchWarnDialog;
    private RightControllerListener rightControllerListener;
    private TextView tvSelectTargetTips;
    private VideoViewPlayer videoViewPlayer;
    private VisualEffectView visualEffectView;
    private float zoom;

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
    }

    public void onSwitchModeFailed() {
    }

    public void setWhetherOrClick(boolean z, boolean z2) {
    }

    public boolean hideZoomDiscWhenClickOutside(float f, float f2) {
        if (isInViewArea(f, f2, this.dataBinding.zoomControlView) || this.dataBinding.zoomControlView.getVisibility() != 0) {
            return false;
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(1);
        this.handler.removeMessages(2);
        return true;
    }

    private void hideViews() {
        this.dataBinding.zoomControlView.setVisibility(8);
        this.dataBinding.tvZoomScale.setVisibility(8);
        this.dataBinding.tvZoomScale.setSelected(false);
        this.dataBinding.timerControlView.setVisibility(8);
        this.dataBinding.tvTimerScale.setVisibility(8);
        this.dataBinding.tvTimerScale.setSelected(false);
        this.dataBinding.ivTimedCapturePhoto.setVisibility(8);
        if (this.model.photoChildMode.isTimeTaking) {
            this.dataBinding.btnCapture.setCaptureType(CaptureUIType.CAPTURE_UI_PHOTO);
        }
        updateTimeTakePhoto(new PhotoChildMode());
    }

    public boolean hideTimeDiscWhenClickOutside(float f, float f2) {
        if (isInViewArea(f, f2, this.dataBinding.timerControlView) || this.dataBinding.timerControlView.getVisibility() != 0) {
            return false;
        }
        this.handler.removeMessages(4);
        this.handler.sendEmptyMessage(4);
        return true;
    }

    private boolean isInViewArea(float f, float f2, View view) {
        return f > ((float) view.getLeft()) && f < ((float) view.getRight()) && f2 > ((float) view.getTop()) && f2 < ((float) view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getZoomText() {
        float keepOneDigit = UnitUtil.keepOneDigit(CameraConfig.get().getZoom());
        for (int i = this.minZoom; i <= this.maxZoom; i++) {
            if (i == keepOneDigit) {
                return i + "x";
            }
        }
        return keepOneDigit + "x";
    }

    public RightController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.lastZoom = 0.0f;
        this.zoom = 0.0f;
        this.maxZoom = 1;
        this.minZoom = 1;
        this.isFirstDispatch = true;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.controllers.RightController.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        RightController.this.dataBinding.tvZoomScale.setSelected(false);
                        break;
                    case 1:
                        RightController.this.dataBinding.zoomControlView.setVisibility(8);
                        RightController.this.controlZoomView();
                        RightController.this.controlTimerView();
                        RightController.this.dataBinding.tvZoomScale.setSelected(true);
                        RightController.this.dataBinding.tvZoomScale.setText(RightController.this.getZoomText());
                        sendEmptyMessageDelayed(0, 5000L);
                        break;
                    case 2:
                        if (RightController.this.lastZoom != RightController.this.zoom) {
                            RightController rightController = RightController.this;
                            rightController.lastZoom = rightController.zoom;
                            CameraCtrlPresenter.getInstance().setZoomRatio(RightController.this.zoom);
                        }
                        sendEmptyMessageDelayed(2, 33L);
                        break;
                    case 3:
                        if (RightController.this.model.isTrackFunctionOpen.get()) {
                            RightController.this.dataBinding.tvZoomScale.setSelected(false);
                            RightController.this.dataBinding.tvZoomScale.setVisibility(8);
                            break;
                        } else {
                            RightController.this.controlZoomView();
                            break;
                        }
                    case 4:
                        RightController.this.dataBinding.timerControlView.setVisibility(8);
                        RightController.this.controlTimerView();
                        RightController.this.controlZoomView();
                        PhotoChildMode value = RightController.this.kernelViewModel.getPhotoChildModeData().getValue();
                        if (value != null) {
                            RightController.this.dataBinding.tvTimerScale.setSelected(value.intervalTime > 0);
                            break;
                        }
                        break;
                    case 5:
                        CameraCtrlPresenter.getInstance().setTakePhotoMode(RightController.this.kernelViewModel.getPhotoChildModeData().getValue());
                        break;
                    case 6:
                        removeMessages(2);
                        break;
                    case 8:
                        if (RightController.this.model.isTrackFunctionOpen.get()) {
                            RightController.this.dataBinding.tvTimerScale.setVisibility(8);
                            break;
                        } else {
                            RightController.this.controlTimerView();
                            break;
                        }
                }
            }
        };
        this.visualEffectView = (VisualEffectView) getContext().findViewById(R.id.visual_show_view);
        this.tvSelectTargetTips = (TextView) getContext().findViewById(R.id.tv_select_target_tips);
        this.visualEffectView.init(new VisualEffectView.onDrawListener() { // from class: com.ipotensic.kernel.controllers.RightController.2
            @Override // com.ipotensic.kernel.view.VisualEffectView.onDrawListener
            public void onSelect(TrackTarget.Box box) {
                box.setMode((RightController.this.model.btnGalleryMode.get() == GalleryUIType.UI_TYPE_FOLLOW_ENABLE.ordinal() ? VisionExecuteType.TYPE_VISION_FOLLOW : VisionExecuteType.TYPE_RECESS).value);
                CameraCtrlPresenter.getInstance().selectTarget(box);
            }

            @Override // com.ipotensic.kernel.view.VisualEffectView.onDrawListener
            public void onDelete(TrackTarget.Box box) {
                RightController.this.model.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.controllers.RightController.2.1
                    @Override // com.ipotensic.baselib.listener.OnSuccessListener
                    public void onResult(boolean z) {
                    }
                });
            }

            @Override // com.ipotensic.kernel.view.VisualEffectView.onDrawListener
            public void onSingleClick() {
                if (RightController.this.model.isVideoTypeVisible.get()) {
                    RightController.this.model.isVideoTypeVisible.set(false);
                }
            }
        });
        this.dataBinding = (ViewLayoutRightVisionControllerBinding) DataBindingUtil.bind(view);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getContext()).get(KernelViewModel.class);
        RightControllerModel rightControllerModel = new RightControllerModel(getContext(), new RightControllerModel.OnRightControllerListener() { // from class: com.ipotensic.kernel.controllers.RightController.3
            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onToast(int i) {
                ToastUtil.toast(RightController.this.getContext(), RightController.this.getContext().getString(i));
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onSwitchMode(CaptureMode captureMode) {
                if (SPHelper.getInstance().getSwitchStatus()) {
                    SPHelper.getInstance().setSwitchStatus(false);
                    RightController rightController = RightController.this;
                    rightController.showGuide(rightController.dataBinding.btnSwitchCapture, R.string.guide_right_switch_status);
                } else {
                    if (!(AOAEngine.getInstance().getH264DecodeThread() instanceof H264DecodeThread1)) {
                        ((MapVideoController) EventDispatcher.get().getController(MapVideoController.class)).stopPlay();
                    }
                    CameraCtrlPresenter.getInstance().setCameraMode(captureMode);
                    EventDispatcher.get().sendEvent(EventID.EVENT_SHOW_BLUR_TRANS);
                }
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onCamSettingClick() {
                if (!SPHelper.getInstance().getCameraSetting()) {
                    RightController.this.model.isCameraSettingControllerShow.set(true);
                    if (RightController.this.rightControllerListener != null) {
                        RightController.this.rightControllerListener.onCameraSetClicked();
                        return;
                    }
                    return;
                }
                SPHelper.getInstance().setCameraSetting(false);
                RightController rightController = RightController.this;
                rightController.showGuide(rightController.dataBinding.btnCameraSetting, R.string.guide_camera_setting);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onSwitchAutoOrManual() {
                if (!SPHelper.getInstance().getCameraSetting()) {
                    if (RightController.this.rightControllerListener != null) {
                        RightController.this.rightControllerListener.onSwitchAutoOrManualModeClicked();
                    }
                } else {
                    SPHelper.getInstance().setCameraSetting(false);
                    RightController rightController = RightController.this;
                    rightController.showGuide(rightController.dataBinding.btnCameraSetting, R.string.guide_camera_setting);
                }
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onGalleryClicked() {
                if (!SPHelper.getInstance().getAirborneGallery()) {
                    if (RightController.this.rightControllerListener != null) {
                        RightController.this.rightControllerListener.onGalleryClicked();
                    }
                } else {
                    SPHelper.getInstance().setAirborneGallery(false);
                    RightController rightController = RightController.this;
                    rightController.showGuide(rightController.dataBinding.btnGallery, R.string.guide_right_gallery);
                }
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void showIntelligentGuide() {
                RightController rightController = RightController.this;
                rightController.showGuide(rightController.dataBinding.btnOneKeyVideo, R.string.guide_intelligent_mode);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void repeatPlayTeachVideo(VisionExecuteType visionExecuteType) {
                RightController.this.videoViewPlayer.repeatPlay(RightController.this.getContext(), visionExecuteType);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void oncePlayTeachVideo(VisionExecuteType visionExecuteType, MediaPlayer.OnCompletionListener onCompletionListener) {
                RightController.this.videoViewPlayer.oncePlay(RightController.this.getContext(), visionExecuteType, onCompletionListener);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void stopPlayTeachVideo() {
                RightController.this.videoViewPlayer.stop();
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void showExecuteFailedDialog(boolean z) {
                if (RightController.this.pitchWarnDialog == null || !RightController.this.pitchWarnDialog.isShowing()) {
                    RightController.this.pitchWarnDialog = new PitchWarnDialog(RightController.this.getContext(), z);
                    RightController.this.pitchWarnDialog.show();
                }
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void playSound(int i) {
                SoundPoolPlayer.getInstance().playVoice(RightController.this.getContext(), i);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void showEffectView() {
                RightController.this.visualEffectView.setCanDraw(true);
                RightController.this.visualEffectView.setPaintAble(true);
                RightController.this.visualEffectView.setFollowing(false);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void hideEffectView() {
                RightController.this.visualEffectView.setCanDraw(false);
                RightController.this.visualEffectView.setPaintAble(false);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void onExecutingFollow() {
                RightController.this.visualEffectView.setCanDraw(false);
                RightController.this.visualEffectView.setPaintAble(false);
                RightController.this.visualEffectView.setFollowing(true);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void updateWheelView(int[] iArr, int i, String str) {
                ArrayList arrayList = new ArrayList();
                for (int i2 : iArr) {
                    arrayList.add(i2 + str);
                }
                RightController.this.dataBinding.wheelView.setData(arrayList);
                RightController.this.dataBinding.wheelView.setDefaultPosition(i);
            }

            @Override // com.ipotensic.kernel.model.RightControllerModel.OnRightControllerListener
            public void updateWheelViewInFollowMode(String[] strArr, int i) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    arrayList.add(str);
                }
                RightController.this.dataBinding.wheelView.setData(arrayList);
                RightController.this.dataBinding.wheelView.setDefaultPosition(i);
            }
        });
        this.model = rightControllerModel;
        this.dataBinding.setModel(rightControllerModel);
        this.videoViewPlayer = new VideoViewPlayer(this.dataBinding.viewDemoVideo, this.dataBinding.tvTeachVideoTips);
        onPreviewSizeChanged();
        this.model.isEffectViewShow.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.4
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightController.this.visualEffectView.setVisibility(RightController.this.model.isEffectViewShow.get() ? 0 : 8);
            }
        });
        this.model.isSelectTargetTipsViewShow.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.5
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightController.this.tvSelectTargetTips.setVisibility(RightController.this.model.isSelectTargetTipsViewShow.get() ? 0 : 8);
            }
        });
        this.dataBinding.wheelView.setCyclicEnabled(false);
        this.dataBinding.wheelView.setIndicatorEnabled(false);
        this.dataBinding.wheelView.setAtmosphericEnabled(false);
        this.dataBinding.wheelView.setCurtainEnabled(false);
        this.dataBinding.wheelView.setCurvedEnabled(false);
        this.dataBinding.wheelView.setOnWheelChangedListener(this.model.wheelViewListener);
        controlZoomView();
        this.dataBinding.tvZoomScale.setOnClick(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$gbO3EHNeKeTKECJoeN43ucu4sxA
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$0$RightController((View) obj);
            }
        });
        this.dataBinding.tvZoomScale.setOnLongClick(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$lagKtR6V5eI5a8moqfF7xCsNkFk
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$1$RightController((View) obj);
            }
        });
        this.dataBinding.tvZoomScale.setOnTouchAction(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$OVbaMfZKeshyMEIsxmGq9eTLUrE
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$2$RightController((MotionEvent) obj);
            }
        });
        this.dataBinding.zoomControlView.setOnZoomChangedListener(new Function2() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$P5PClAJu7AvAnqTvfqGRxIsr7Z8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RightController.this.lambda$new$3$RightController((Float) obj, (Integer) obj2);
            }
        });
        this.dataBinding.tvTimerScale.setOnClick(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$MMXLhGMRe314uIJ15k5gZVlG8HY
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$4$RightController((View) obj);
            }
        });
        this.dataBinding.tvTimerScale.setOnLongClick(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$QIBvcI7xWKjF81EW1-FstjhpfOc
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$5$RightController((View) obj);
            }
        });
        this.dataBinding.tvTimerScale.setOnTouchAction(new Function1() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$Xi-KZsCcF2fsj4n4dtIwomIQ2ZA
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RightController.this.lambda$new$6$RightController((MotionEvent) obj);
            }
        });
        this.dataBinding.timerControlView.setOnTimeChangedListener(new Function2() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$LMfHUf5qBvmLQcCR-b0YDgMRmaY
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RightController.this.lambda$new$8$RightController((Integer) obj, (Integer) obj2);
            }
        });
        this.model.isTrackFunctionOpen.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.6
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightController.this.handler.sendEmptyMessage(3);
                RightController.this.handler.sendEmptyMessage(8);
                if (RightController.this.model.isTrackFunctionOpen.get()) {
                    return;
                }
                RightController.this.visualEffectView.clear();
            }
        });
        this.model.isJpgData.observe(getContext(), new Observer() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$jyzB6YgmD8A16gwIwNCV6_8QATI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RightController.this.lambda$new$9$RightController((Boolean) obj);
            }
        });
        this.model.isCameraConnected.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.7
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightController.this.controlTimerView();
            }
        });
        this.model.btnCaptureMode.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.8
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightController.this.controlTimerView();
            }
        });
        this.model.isTimePhotography.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.9
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightController.this.model.isTimePhotography.get()) {
                    RightController.this.dataBinding.tvTimerScale.setEnabled(false);
                    RightController.this.dataBinding.tvZoomScale.setEnabled(false);
                    RightController.this.dataBinding.llTimedInfo.setVisibility(0);
                    RightController.this.dataBinding.tvCountDown.setVisibility(0);
                    RightController.this.dataBinding.ivTimedCapturePhoto.setVisibility(0);
                    return;
                }
                RightController.this.dataBinding.tvTimerScale.setEnabled(true);
                RightController.this.dataBinding.tvZoomScale.setEnabled(true);
                RightController.this.dataBinding.llTimedInfo.setVisibility(8);
                RightController.this.dataBinding.tvCountDown.setVisibility(8);
                RightController.this.dataBinding.ivTimedCapturePhoto.setVisibility(8);
            }
        });
    }

    public /* synthetic */ Unit lambda$new$0$RightController(View view) {
        if (SPHelper.getInstance().getBoolean(SPHelper.KEY_ZOOM_SCALE, true)) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_ZOOM_SCALE, false);
            showGuide(this.dataBinding.tvZoomScale, R.string.guide_flight_interface_enter_digital_zoom_mode_tips);
            return null;
        }
        if (!isTakingPhoto() && !isTimePhotography()) {
            float zoom = CameraConfig.get().getZoom();
            int i = this.minZoom;
            while (true) {
                int i2 = this.maxZoom;
                if (i > i2) {
                    break;
                }
                float f = i;
                if (zoom < f) {
                    zoom = f;
                    break;
                }
                if (zoom == i2) {
                    zoom = this.minZoom;
                    break;
                }
                i++;
            }
            CameraCtrlPresenter.getInstance().setZoomRatio(zoom);
            view.setSelected(true);
            this.handler.removeMessages(0);
            this.handler.sendEmptyMessageDelayed(0, 5000L);
        }
        return null;
    }

    public /* synthetic */ Unit lambda$new$1$RightController(View view) {
        if (SPHelper.getInstance().getBoolean(SPHelper.KEY_ZOOM_SCALE, true)) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_ZOOM_SCALE, false);
            showGuide(this.dataBinding.tvZoomScale, R.string.guide_flight_interface_enter_digital_zoom_mode_tips);
            return null;
        }
        if (!isTakingPhoto() && !isTimePhotography() && this.maxZoom > 1) {
            this.dataBinding.tvZoomScale.setVisibility(8);
            this.dataBinding.tvTimerScale.setVisibility(8);
            this.dataBinding.zoomControlView.setZoom(CameraConfig.get().getZoom());
            this.dataBinding.zoomControlView.setVisibility(0);
            this.handler.sendEmptyMessageDelayed(1, HIDE_DISC_TIME);
        }
        return null;
    }

    public /* synthetic */ Unit lambda$new$2$RightController(MotionEvent motionEvent) {
        if (isTakingPhoto() || isTimePhotography() || this.maxZoom <= 1 || (this.isFirstDispatch && motionEvent.getX() > 0.0f)) {
            return null;
        }
        if (this.isFirstDispatch) {
            this.handler.removeMessages(1);
            this.handler.sendEmptyMessage(2);
            this.dataBinding.zoomControlView.updateDownXY(motionEvent);
            this.isFirstDispatch = false;
        }
        if (motionEvent.getAction() == 1) {
            this.isFirstDispatch = true;
        }
        this.dataBinding.zoomControlView.onTouchEvent(motionEvent);
        return null;
    }

    public /* synthetic */ Unit lambda$new$3$RightController(Float f, Integer num) {
        this.zoom = f.floatValue();
        if (1 == num.intValue()) {
            if (this.dataBinding.zoomControlView.getVisibility() == 0) {
                this.handler.sendEmptyMessageDelayed(1, HIDE_DISC_TIME);
            }
            this.handler.sendEmptyMessageDelayed(6, 35L);
            return null;
        }
        if (num.intValue() != 0) {
            return null;
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessage(2);
        return null;
    }

    public /* synthetic */ Unit lambda$new$4$RightController(View view) {
        if (SPHelper.getInstance().getBoolean(SPHelper.KEY_TIMED_PHOTOGRAPHY, true)) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_TIMED_PHOTOGRAPHY, false);
            showGuide(this.dataBinding.tvTimerScale, R.string.guide_flight_interface_enter_self_timer_mode_tips);
            return null;
        }
        if (view.isEnabled() && view.isSelected()) {
            view.setSelected(false);
            this.dataBinding.btnCapture.setTime(0);
            this.kernelViewModel.setSingleMode();
            this.handler.sendEmptyMessage(5);
        }
        return null;
    }

    public /* synthetic */ Unit lambda$new$5$RightController(View view) {
        if (SPHelper.getInstance().getBoolean(SPHelper.KEY_TIMED_PHOTOGRAPHY, true)) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_TIMED_PHOTOGRAPHY, false);
            showGuide(this.dataBinding.tvTimerScale, R.string.guide_flight_interface_enter_self_timer_mode_tips);
            return null;
        }
        if (!view.isEnabled()) {
            return null;
        }
        this.dataBinding.tvTimerScale.setVisibility(8);
        this.dataBinding.tvZoomScale.setVisibility(8);
        this.dataBinding.timerControlView.setVisibility(0);
        PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
        if (value != null) {
            this.dataBinding.timerControlView.setTime(value.intervalTime);
        }
        this.handler.sendEmptyMessageDelayed(4, HIDE_DISC_TIME);
        return null;
    }

    public /* synthetic */ Unit lambda$new$6$RightController(MotionEvent motionEvent) {
        if (!this.dataBinding.tvTimerScale.isEnabled()) {
            return null;
        }
        if (this.isFirstDispatch && motionEvent.getX() > 0.0f) {
            return null;
        }
        if (this.isFirstDispatch) {
            this.handler.removeMessages(4);
            this.dataBinding.timerControlView.updateDownXY(motionEvent);
            this.isFirstDispatch = false;
        }
        if (motionEvent.getAction() == 1) {
            this.isFirstDispatch = true;
        }
        this.dataBinding.timerControlView.onTouchEvent(motionEvent);
        return null;
    }

    public /* synthetic */ Unit lambda$new$8$RightController(final Integer num, Integer num2) {
        PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
        if (value != null) {
            if (num.intValue() > 0) {
                value.childMode = 1;
            } else {
                value.childMode = 0;
            }
            value.intervalTime = num.intValue();
        }
        if (1 == num2.intValue()) {
            if (this.dataBinding.timerControlView.getVisibility() == 0) {
                this.handler.sendEmptyMessageDelayed(4, HIDE_DISC_TIME);
            }
            this.handler.sendEmptyMessage(5);
        } else if (num2.intValue() == 0) {
            this.handler.removeMessages(4);
        }
        this.dataBinding.btnCapture.setTime(num.intValue());
        this.dataBinding.tvCameraTime.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$T_vCRmmttypSBlGJYyfqc98yIrg
            @Override // java.lang.Runnable
            public final void run() {
                RightController.this.lambda$null$7$RightController(num);
            }
        });
        return null;
    }

    public /* synthetic */ void lambda$null$7$RightController(Integer num) {
        this.dataBinding.tvCameraTime.setText(num + "s");
    }

    public /* synthetic */ void lambda$new$9$RightController(Boolean bool) {
        controlTimerView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void controlZoomView() {
        if (this.model.isCameraConnected.get() && FlightConfig.isAtomPanTilt() && this.maxZoom > 1 && !isTrackTargetOpen()) {
            this.dataBinding.tvZoomScale.setVisibility(0);
        } else {
            this.dataBinding.tvZoomScale.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void controlTimerView() {
        if (this.model.isShowTimerPhotoButton() && this.dataBinding.timerControlView.getVisibility() != 0) {
            this.dataBinding.tvTimerScale.setVisibility(0);
        } else {
            this.dataBinding.tvTimerScale.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuide(View view, final int i) {
        NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(view, new RelativeGuide(R.layout.guide_right, 3)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$RightController$HvzN2jrryrNND5Efbm2j_O70ND4
            @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
            public final void onLayoutInflated(View view2, Controller controller) {
                RightController.this.lambda$showGuide$10$RightController(i, view2, controller);
            }
        }).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.color_guide_bg))).show();
    }

    public /* synthetic */ void lambda$showGuide$10$RightController(int i, View view, Controller controller) {
        ((TextView) view.findViewById(R.id.tv_view)).setText(getContext().getResources().getString(i));
    }

    /* renamed from: com.ipotensic.kernel.controllers.RightController$13, reason: invalid class name */
    static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_MAP_VIDEO_MODE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_CAPTURE_MODE_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_CONFIG_MENU_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_CAMERA_SETTING_DISMISS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_RESULT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_PREVIEW_SIZE_CHANGED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_EXECUTE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_EXIT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UNIT_CHANGED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_CAMERA_HIGH_TEMP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_FULL.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_STATE_DATA.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_ZOOM_RADIO_SUCCESS.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_ZOOM_RADIO_SUCCESS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_PHOTO_MODE_SUCCESS.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_PHOTO_MODE_FAIL.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_PHOTO_MODE_SUCCESS.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_TIMED_PHOTO_UPLOAD.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_RECORD_SIZE_SUCCESS.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_TAKE_PHOTO_SIZE_SUCCESS.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_PHOTO_FORMAT_SUCCESS.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        switch (AnonymousClass13.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                this.model.setFlightType();
                break;
            case 2:
                this.model.setMapVideoMode((Mode) event.obj);
                break;
            case 3:
                this.model.setCaptureModeSuccess();
                updateMaxZoom();
                if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC) {
                    this.dataBinding.timerControlView.setVisibility(8);
                    break;
                }
                break;
            case 4:
                this.model.onConfigMenu();
                CameraCtrlPresenter.getInstance().getZoomRatio();
                this.isRequestTakePhotoMode = true;
                CameraCtrlPresenter.getInstance().getTakePhotoMode();
                updateMaxZoom();
                break;
            case 5:
                this.model.onCameraSettingControllerDismiss();
                break;
            case 6:
                this.model.onTrackFunctionOpen();
                break;
            case 7:
                this.model.onTrackFunctionClose();
                this.model.trackTarget = new TrackTarget();
                this.visualEffectView.setTrackTarget(null);
                break;
            case 8:
                TrackTarget trackTarget = (TrackTarget) event.obj;
                if (this.model.isTrackFunctionOpen.get()) {
                    this.model.trackTarget = trackTarget;
                    this.visualEffectView.setTrackTarget(trackTarget);
                    this.visualEffectView.setCanDraw(!trackTarget.isSelected());
                    this.model.setIsTrackingTarget(trackTarget.isSelected());
                    break;
                }
                break;
            case 9:
                onPreviewSizeChanged();
                break;
            case 10:
                this.model.onTrackError((VisionError) event.obj);
                break;
            case 11:
                this.model.onExecuting();
                break;
            case 12:
                this.model.onExitExecuting();
                break;
            case 13:
                this.model.update(FlightRevData.get().getFlightRevStateData());
                break;
            case 14:
                if (!FlightConfig.isConnectFlight()) {
                    this.model.reset();
                    this.visualEffectView.setTrackTarget(null);
                    PitchWarnDialog pitchWarnDialog = this.pitchWarnDialog;
                    if (pitchWarnDialog != null && pitchWarnDialog.isShowing()) {
                        this.pitchWarnDialog.dismiss();
                    }
                    this.handler.removeCallbacksAndMessages(null);
                    hideViews();
                    break;
                }
                break;
            case 16:
                this.model.highTempWarning.set(event.arg1 == 0);
                camHighTemp();
                break;
            case 17:
                this.model.stopTakePhoto(false);
                break;
            case 18:
                FlightRevRemoterStateData flightRevRemoterStateData = (FlightRevRemoterStateData) event.obj;
                if (flightRevRemoterStateData.getIsPressTakePhotoButton() || flightRevRemoterStateData.getIsPressRecordButton()) {
                    this.model.update(flightRevRemoterStateData);
                    break;
                }
                break;
            case 19:
                this.dataBinding.tvZoomScale.setText(getZoomText());
                break;
            case 20:
                this.zoom = CameraConfig.get().getZoom();
                this.dataBinding.tvZoomScale.setText(getZoomText());
                this.dataBinding.zoomControlView.setVisibility(8);
                break;
            case 21:
                PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
                boolean z = value != null ? value.isTimeTaking : false;
                PhotoChildMode photoChildMode = (PhotoChildMode) event.obj;
                photoChildMode.isTimeTaking = z;
                updateTimeTakePhoto(photoChildMode);
                break;
            case 22:
                this.isRequestTakePhotoMode = false;
                break;
            case 23:
                updateTimeTakePhoto((PhotoChildMode) event.obj);
                if (this.model.photoChildMode.isTimeTaking && !this.isRequestTakePhotoMode) {
                    this.dataBinding.btnCapture.setTimedTakingPhoto(true);
                }
                this.isRequestTakePhotoMode = false;
                break;
            case 24:
                TimedPhotoUploadData timedPhotoUploadData = (TimedPhotoUploadData) event.obj;
                this.dataBinding.tvCountDown.setText(timedPhotoUploadData.getCountDownString());
                this.dataBinding.tvPhotoCount.setText(timedPhotoUploadData.getPhotoCountString());
                if (this.kernelViewModel.getPhotoChildModeData().getValue() != null) {
                    if (timedPhotoUploadData.countDown != 1) {
                        CameraCtrlPresenter.getInstance().getSdCardStatus();
                        this.dataBinding.btnCapture.setTimedTakingPhoto(false);
                        break;
                    } else {
                        this.dataBinding.btnCapture.setTimedTakingPhoto(true);
                        break;
                    }
                }
                break;
            case 25:
            case 26:
                updateMaxZoom();
                break;
            case 27:
                this.model.isJpgData.setValue(Boolean.valueOf(!CameraConfig.get().isRaw()));
                break;
        }
    }

    private void updateTimeTakePhoto(PhotoChildMode photoChildMode) {
        this.kernelViewModel.getPhotoChildModeData().setValue(photoChildMode);
        this.model.photoChildMode = photoChildMode;
        this.dataBinding.tvTimerScale.setSelected(photoChildMode.isTimerMode());
        this.dataBinding.tvCameraTime.setText(photoChildMode.intervalTime + "s");
        this.dataBinding.btnCapture.setTime(photoChildMode.intervalTime);
        if (!this.model.isRecording.get()) {
            if (photoChildMode.isTimeTaking) {
                this.dataBinding.btnCapture.setCaptureType(CaptureUIType.CAPTURE_UI_TIMER_TAKING_PHOTO);
            } else if (photoChildMode.isTimerMode() && CameraConfig.get().isPhotoMode()) {
                this.dataBinding.btnCapture.setCaptureType(CaptureUIType.CAPTURE_UI_PHOTO);
            }
        }
        this.model.isTimePhotography.set(photoChildMode.isTimeTaking);
        controlTimerView();
    }

    private void updateMaxZoom() {
        this.maxZoom = CameraConfig.get().getMaxZoom();
        DDLog.w("maxZoom=" + this.maxZoom);
        if (this.maxZoom > 1) {
            this.dataBinding.zoomControlView.setMaxZoom(this.maxZoom);
        } else {
            this.dataBinding.zoomControlView.setVisibility(8);
        }
        controlZoomView();
    }

    public void updateZoom(float f, int i) {
        if (this.maxZoom <= 1 || isTakingPhoto() || isTimePhotography() || isTrackTargetOpen()) {
            this.handler.removeMessages(2);
            if (i == 1) {
                this.handler.sendEmptyMessageDelayed(0, 5000L);
                return;
            }
            return;
        }
        if (i == 0) {
            this.zoom = CameraConfig.get().getZoom();
            this.handler.removeMessages(0);
            this.handler.sendEmptyMessage(2);
            this.dataBinding.tvZoomScale.setSelected(true);
            return;
        }
        if (i == 2) {
            float tan = (float) ((43.2666015625d / Math.tan((((float) (Math.atan(43.2666d / (this.zoom * 26.7d)) * 2.0d)) + ((1.0f - f) * 2.0f)) / 2.0f)) / 26.700000762939453d);
            this.zoom = tan;
            int i2 = this.maxZoom;
            if (tan > i2) {
                this.zoom = i2;
            } else {
                int i3 = this.minZoom;
                if (tan < i3) {
                    this.zoom = i3;
                }
            }
            this.zoom = UnitUtil.keepTwoDigit(this.zoom);
            return;
        }
        this.zoom = UnitUtil.keepOneDigit(this.zoom);
        this.handler.sendEmptyMessageDelayed(0, 5000L);
        this.handler.sendEmptyMessageDelayed(6, 35L);
    }

    public void onPreviewSizeChanged() {
        if (PhoneConfig.previewSize != null) {
            DDLog.e("一键短片 宽高改变通知:" + PhoneConfig.previewSize.toString());
            this.visualEffectView.setPreviewVideoSize(PhoneConfig.previewSize.getWidth(), PhoneConfig.previewSize.getHeight());
        }
    }

    public View getGalleryView() {
        return this.dataBinding.btnGallery;
    }

    public void onSwitchMode(CaptureMode captureMode) {
        if (this.model.isRecording.get() || this.model.isTrackFunctionOpen.get()) {
            return;
        }
        this.model.setBtnCaptureMode(captureMode == CaptureMode.MODE_PHOTO ? CaptureUIType.CAPTURE_UI_PHOTO : CaptureUIType.CAPTURE_UI_RECORD);
    }

    public void startRecord() {
        startRecord(0);
    }

    public void startRecord(int i) {
        CameraCtrlPresenter.getInstance().startRequestSDSpace();
        this.model.startRecord(i);
    }

    public void stopRecord() {
        CameraCtrlPresenter.getInstance().stopRequestSDSpace();
        this.model.stopRecord();
    }

    public void camHighTemp() {
        boolean isAllowCaptureInHighTemp = CameraConfig.get().isAllowCaptureInHighTemp();
        if (!isAllowCaptureInHighTemp) {
            stopRecord();
        }
        this.model.setCamTemp(isAllowCaptureInHighTemp);
    }

    public void takePhoto() {
        if (this.dataBinding.timerControlView.getVisibility() == 0) {
            this.handler.removeMessages(4);
            this.handler.sendEmptyMessage(4);
        } else if (this.dataBinding.zoomControlView.getVisibility() == 0) {
            this.handler.removeMessages(1);
            this.handler.sendEmptyMessage(1);
            this.handler.removeMessages(2);
        }
        this.model.startTakePhoto();
    }

    public void takePhotoEnd() {
        if (this.model.photoChildMode.isTimerMode()) {
            return;
        }
        this.model.stopTakePhoto(true);
    }

    public void playCaptureSound() {
        this.model.playCaptureSound();
    }

    public boolean isRecording() {
        return this.model.isRecording.get();
    }

    public boolean isTimePhotography() {
        return this.model.isTimePhotography.get();
    }

    public boolean isTakingPhoto() {
        return this.model.isTakingPhoto.get();
    }

    public void setRightControllerListener(RightControllerListener rightControllerListener) {
        this.rightControllerListener = rightControllerListener;
    }

    public void switchToManualSettingMode(boolean z) {
        this.model.isManualMode.set(z);
    }

    public boolean isExecutingShortVideo() {
        return this.model.isExecuting.get();
    }

    public boolean isTrackTargetOpen() {
        return this.model.isTrackFunctionOpen.get();
    }

    public boolean isFollowMode() {
        return this.model.isFollowMode();
    }

    public void exitQuickShot(final SimpleResultListener<Boolean> simpleResultListener) {
        if (this.model.isTrackFunctionOpen.get()) {
            this.model.isTrackFunctionOpen.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.RightController.10
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i) {
                    if (RightController.this.model.isTrackFunctionOpen.get()) {
                        return;
                    }
                    SimpleResultListener simpleResultListener2 = simpleResultListener;
                    if (simpleResultListener2 != null) {
                        simpleResultListener2.onResult(true);
                    }
                    RightController.this.model.isTrackFunctionOpen.removeOnPropertyChangedCallback(this);
                }
            });
            this.model.sendStopExecuteCMD();
            this.model.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.controllers.RightController.11
                @Override // com.ipotensic.baselib.listener.OnSuccessListener
                public void onResult(boolean z) {
                }
            });
            this.model.sendStopCmdToFlightIfAtomV2(new OnSuccessListener() { // from class: com.ipotensic.kernel.controllers.RightController.12
                @Override // com.ipotensic.baselib.listener.OnSuccessListener
                public void onResult(boolean z) {
                }
            });
            this.model.sendCloseTrackCMD();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        RightControllerModel rightControllerModel = this.model;
        if (rightControllerModel != null) {
            rightControllerModel.onDestroy();
        }
        VideoViewPlayer videoViewPlayer = this.videoViewPlayer;
        if (videoViewPlayer != null) {
            videoViewPlayer.stop();
        }
        if (this.model.isTrackFunctionOpen.get()) {
            this.model.sendCloseTrackCMD();
        }
        if (this.model.isExecuting.get()) {
            this.model.sendStopExecuteCMD();
            this.model.sendStopExecuteToFlightCtrl();
        }
        this.handler.removeCallbacksAndMessages(null);
    }
}
