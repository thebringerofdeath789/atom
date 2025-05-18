package com.ipotensic.kernel.model;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.VisionError;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.listener.OnSuccessListener;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.netty.Constant;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.SoundPoolPlayer;
import com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener;
import com.ipotensic.baselib.views.wheelview.widget.WheelView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.controllers.CameraSetController;
import com.ipotensic.kernel.controllers.MapVideoController;
import com.ipotensic.kernel.enums.CaptureUIType;
import com.ipotensic.kernel.enums.GalleryUIType;
import com.ipotensic.kernel.enums.Mode;
import com.ipotensic.kernel.model.RightControllerModel;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.utils.RecordTimer;
import com.ipotensic.kernel.view.ShortVideoCountDownView;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.enums.SdCardState;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.flight.data.recv.FlightRevRemoterStateData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.enums.CtrlType;
import com.logan.flight.type.Flight;
import java.util.Objects;

/* loaded from: classes2.dex */
public class RightControllerModel {
    public static final int NO_ID = -1;
    public static final String[] SHORT_VIDEO_PARAMS_FOLLOW = {"1min", "3min", "5min", "\u221e"};
    private Context context;
    private int currentParams1;
    private int currentParams2;
    private OnSuccessListener onCancelSelectResultListener;
    private OnSuccessListener onFlightStopTrackResultListener;
    private RecordTimer recordTimer;
    private OnRightControllerListener rightControllerListener;
    public final int[] SHORT_VIDEO_PARAMS_RECESS = {30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150};
    public final int[] SHORT_VIDEO_PARAMS_SKYWARD = {30, 40, 50, 60, 70, 80, 90, 100};
    private final int[] SHORT_VIDEO_PARAMS_REPEAT = {1, 2, 3};
    private final long RETRACT_TIMEOUT = 5000;
    private final long SWITCH_CAPTURE_MODE_TIMEOUT = SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private final long PRESS_REMOTER_KEY_MODE_TIMEOUT = 1000;
    private final long TAKING_PHOTO_TIMEOUT = Constant.DELAY_MILLIS;
    private final long EXECUTE_TIMEOUT = 500;
    private final long CLICK_INTERVAL = 300;
    private long lastClickTime = 0;
    public ObservableBoolean isCameraConnected = new ObservableBoolean(false);
    public ObservableBoolean isAtomPanTilt = new ObservableBoolean(false);
    public ObservableBoolean isAtomLT = new ObservableBoolean(false);
    public ObservableBoolean isAtomSE = new ObservableBoolean(false);
    public ObservableBoolean isRecording = new ObservableBoolean(false);
    public ObservableBoolean isTakingPhoto = new ObservableBoolean(false);
    public ObservableBoolean isTimePhotography = new ObservableBoolean(false);
    public ObservableBoolean isSwitchingMode = new ObservableBoolean(false);
    public ObservableBoolean isCameraSettingControllerShow = new ObservableBoolean(false);
    public ObservableBoolean isCameraHighTemp = new ObservableBoolean(false);
    public ObservableBoolean highTempWarning = new ObservableBoolean(false);
    public ObservableBoolean isRecordRedPointShow = new ObservableBoolean(false);
    public ObservableBoolean isTrackFunctionOpen = new ObservableBoolean(false);
    public ObservableBoolean isTrackingTarget = new ObservableBoolean(false);
    public ObservableBoolean isVideoTypeVisible = new ObservableBoolean(false);
    public ObservableBoolean isDemoVideoVisible = new ObservableBoolean(false);
    public ObservableBoolean isParams1Select = new ObservableBoolean(true);
    public ObservableBoolean isCountStart = new ObservableBoolean(false);
    public ObservableBoolean isExecuting = new ObservableBoolean(false);
    public ObservableBoolean isManualMode = new ObservableBoolean(false);
    public ObservableBoolean isPressRemoterKey = new ObservableBoolean(false);
    public ObservableBoolean isPointFly = new ObservableBoolean(true);
    public ObservableBoolean isEffectViewShow = new ObservableBoolean(false);
    public ObservableBoolean isSelectTargetTipsViewShow = new ObservableBoolean(false);
    public ObservableInt btnCaptureMode = new ObservableInt(CaptureUIType.CAPTURE_UI_PHOTO.ordinal());
    public ObservableInt btnGalleryMode = new ObservableInt(GalleryUIType.UI_TYPE_GALLERY.ordinal());
    public ObservableField<VisionExecuteType> videoType = new ObservableField<>(VisionExecuteType.TYPE_RECESS);
    public ObservableInt progressPercent = new ObservableInt(-1);
    public ObservableString recordTxt = new ObservableString("");
    public TrackTarget trackTarget = new TrackTarget();
    private long followRecordTime = 0;
    private Mode mapVideoMode = Mode.MODE_VIDEO;
    public MutableLiveData<Boolean> isJpgData = new MutableLiveData<>();
    public PhotoChildMode photoChildMode = new PhotoChildMode();
    private VisionExecuteType currentExecuteType = null;
    private final boolean isIndoorDebug = false;
    private final boolean[] params1Arr = {true, true, true, true, true, true};
    private final int[] params2Arr = new int[6];
    public final ScaleClickListener onSwitchModeClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.18
        AnonymousClass18() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                RightControllerModel.this.isSwitchingMode.set(true);
                if (RightControllerModel.this.isRecording.get()) {
                    RightControllerModel.this.rightControllerListener.onToast(R.string.stop_recording_first);
                } else {
                    RightControllerModel.this.rightControllerListener.onSwitchMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureMode.MODE_PHOTO : CaptureMode.MODE_REC);
                }
            }
        }
    };
    public final ScaleClickListener onCameraSettingClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.19
        AnonymousClass19() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (RightControllerModel.this.isAtomPanTilt.get()) {
                    RightControllerModel.this.rightControllerListener.onSwitchAutoOrManual();
                    return;
                }
                CameraSetController cameraSetController = (CameraSetController) EventDispatcher.get().getController(CameraSetController.class);
                if (cameraSetController == null || cameraSetController.getVisibility() != 0) {
                    RightControllerModel.this.rightControllerListener.onCamSettingClick();
                } else {
                    cameraSetController.setVisibility(8);
                }
            }
        }
    };
    public final ScaleClickListener onCaptureClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.20
        AnonymousClass20() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PHOTO.ordinal()) {
                    DDLog.e("\u6309\u952e\u72b6\u6001: \u70b9\u51fb\u62cd\u7167");
                    if (!CameraConfig.get().isSdCardAvailable()) {
                        if (RightControllerModel.this.rightControllerListener != null) {
                            RightControllerModel.this.rightControllerListener.onToast(R.string.no_sd_card);
                        }
                        EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD_TIP);
                        return;
                    } else {
                        if (!CameraConfig.get().isNeedFormatSdCard()) {
                            DDLog.e("\u70b9\u51fb\u62cd\u7167");
                            CameraCtrlPresenter.getInstance().takePhoto();
                            if (RightControllerModel.this.photoChildMode.isTimerMode()) {
                                return;
                            }
                            RightControllerModel.this.isTakingPhoto.set(true);
                            RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_TAKING_PHOTO);
                            PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.takingPhotoRunnable);
                            PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.takingPhotoRunnable, Constant.DELAY_MILLIS);
                            return;
                        }
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD);
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD_TIP);
                        return;
                    }
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORD.ordinal()) {
                    DDLog.e("\u6309\u952e\u72b6\u6001:\u70b9\u51fb\u5f55\u50cf");
                    DDLog.e("\u70b9\u51fb\u5f00\u59cb\u5f55\u50cf");
                    CameraCtrlPresenter.getInstance().startRecord();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORDING.ordinal()) {
                    DDLog.e("\u70b9\u51fb\u505c\u6b62\u5f55\u50cf");
                    CameraCtrlPresenter.getInstance().stopRecord();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_EXIT_TRACK.ordinal()) {
                    RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.20.1
                        @Override // com.ipotensic.baselib.listener.OnSuccessListener
                        public void onResult(boolean z) {
                        }

                        AnonymousClass1() {
                        }
                    });
                    RightControllerModel.this.sendCloseTrackCMD();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_GO.ordinal()) {
                    if (RightControllerModel.this.checkStateIsReadyWhenGo()) {
                        RightControllerModel.this.isCountStart.set(true);
                        RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN);
                        return;
                    } else {
                        RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.20.2
                            @Override // com.ipotensic.baselib.listener.OnSuccessListener
                            public void onResult(boolean z) {
                            }

                            AnonymousClass2() {
                            }
                        });
                        return;
                    }
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN.ordinal()) {
                    RightControllerModel.this.isCountStart.set(false);
                    if (RightControllerModel.this.isTrackingTarget.get()) {
                        RightControllerModel.this.isTrackingTarget.notifyChange();
                        return;
                    }
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PROGRESS.ordinal()) {
                    RightControllerModel.this.sendStopExecuteCMD();
                    RightControllerModel.this.sendStopExecuteToFlightCtrl();
                } else if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_CANCEL_BACK.ordinal()) {
                    RightControllerModel.this.sendStopExecuteToFlightCtrl();
                }
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$20$1 */
        class AnonymousClass1 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
            }

            AnonymousClass1() {
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$20$2 */
        class AnonymousClass2 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
            }

            AnonymousClass2() {
            }
        }
    };
    public final ScaleClickListener onShortVideoClickListener = new AnonymousClass21();
    public final ScaleClickListener onGalleryClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.22
        AnonymousClass22() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (!RightControllerModel.this.isTrackFunctionOpen.get()) {
                    RightControllerModel.this.rightControllerListener.onGalleryClicked();
                } else if (RightControllerModel.this.isFollowMode()) {
                    RightControllerModel.this.isVideoTypeVisible.set(!RightControllerModel.this.isVideoTypeVisible.get());
                } else if (RightControllerModel.this.btnGalleryMode.get() == GalleryUIType.UI_TYPE_FOLLOW_DISABLE.ordinal()) {
                    RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.22.1
                        AnonymousClass1() {
                        }

                        @Override // com.ipotensic.baselib.listener.OnSuccessListener
                        public void onResult(boolean z) {
                            if (z) {
                                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_ENABLE);
                                if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                                    RightControllerModel.this.isVideoTypeVisible.set(true);
                                }
                            }
                        }
                    });
                }
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$22$1 */
        class AnonymousClass1 implements OnSuccessListener {
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
                if (z) {
                    RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_ENABLE);
                    if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                        RightControllerModel.this.isVideoTypeVisible.set(true);
                    }
                }
            }
        }
    };
    public final ScaleClickListener typeRecessClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.23
        AnonymousClass23() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_RECESS);
        }
    };
    public final ScaleClickListener typeSkywardClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.24
        AnonymousClass24() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_SKYWARD);
        }
    };
    public final ScaleClickListener typeCircleClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.25
        AnonymousClass25() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_CIRCLE);
        }
    };
    public final ScaleClickListener typeScrewClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.26
        AnonymousClass26() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_SCREW);
        }
    };
    public final ScaleClickListener typeCometClickListener = new ScaleClickListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.27
        AnonymousClass27() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_COMET);
        }
    };
    public final OnWheelChangedListener wheelViewListener = new OnWheelChangedListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.29
        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelLoopFinished(WheelView wheelView) {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelScrolled(WheelView wheelView, int i) {
        }

        AnonymousClass29() {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelSelected(WheelView wheelView, int i) {
            if (RightControllerModel.this.isFollowMode()) {
                RightControllerModel.this.params2Arr[5] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
                RightControllerModel.this.params2Arr[0] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
                RightControllerModel.this.params2Arr[1] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
                RightControllerModel.this.params2Arr[2] = i;
            } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
                RightControllerModel.this.params2Arr[3] = i;
            } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_COMET) {
                RightControllerModel.this.params2Arr[4] = i;
            }
        }
    };
    public final ShortVideoCountDownView.OnCountDownListener countDownListener = new ShortVideoCountDownView.OnCountDownListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.30
        AnonymousClass30() {
        }

        @Override // com.ipotensic.kernel.view.ShortVideoCountDownView.OnCountDownListener
        public void onCounting(int i) {
            RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN);
            if (i == 3) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_THREE);
            } else if (i == 2) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_TWO);
            } else if (i == 1) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_ONE);
            }
        }

        @Override // com.ipotensic.kernel.view.ShortVideoCountDownView.OnCountDownListener
        public void onCountDownEnd() {
            int i = 0;
            RightControllerModel.this.isCountStart.set(false);
            if (RightControllerModel.this.checkStateIsReadyWhenGo()) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.SHORT_VIDEO_GO);
                if (RightControllerModel.this.isFollowMode()) {
                    int i2 = RightControllerModel.this.params2Arr[5];
                    int i3 = i2 == 3 ? 255 : i2;
                    if (i2 == 0) {
                        RightControllerModel.this.followRecordTime = 60000L;
                    } else if (i2 == 1) {
                        RightControllerModel.this.followRecordTime = 180000L;
                    } else if (i2 == 2) {
                        RightControllerModel.this.followRecordTime = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
                    } else if (i2 == 3) {
                        RightControllerModel.this.followRecordTime = -1L;
                    }
                    RightControllerModel.this.sendGoExecuteCMD(VisionExecuteType.TYPE_VISION_FOLLOW, 0, i3);
                    return;
                }
                boolean z = RightControllerModel.this.isParams1Select.get();
                if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_RECESS[RightControllerModel.this.params2Arr[0]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_SKYWARD[RightControllerModel.this.params2Arr[1]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[2]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[3]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_COMET) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[4]];
                }
                RightControllerModel rightControllerModel = RightControllerModel.this;
                rightControllerModel.sendGoExecuteCMD(rightControllerModel.videoType.get(), z ? 1 : 0, i);
                return;
            }
            RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.30.1
                @Override // com.ipotensic.baselib.listener.OnSuccessListener
                public void onResult(boolean z2) {
                }

                AnonymousClass1() {
                }
            });
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$30$1 */
        class AnonymousClass1 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z2) {
            }

            AnonymousClass1() {
            }
        }
    };
    private final Runnable switchModeRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.RightControllerModel.31
        AnonymousClass31() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isCameraConnected.get()) {
                RightControllerModel.this.isSwitchingMode.set(false);
            }
        }
    };
    private final Runnable selectModeRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.RightControllerModel.32
        AnonymousClass32() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isCameraConnected.get()) {
                RightControllerModel.this.isVideoTypeVisible.set(false);
            }
        }
    };
    private final Runnable takingPhotoRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.RightControllerModel.33
        AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isTakingPhoto.get()) {
                RightControllerModel.this.isTakingPhoto.set(false);
            }
        }
    };
    private final Runnable pressRemoterKeyRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.RightControllerModel.34
        AnonymousClass34() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RightControllerModel.this.isPressRemoterKey.set(false);
        }
    };

    public interface OnRightControllerListener {
        void hideEffectView();

        void onCamSettingClick();

        void onExecutingFollow();

        void onGalleryClicked();

        void onSwitchAutoOrManual();

        void onSwitchMode(CaptureMode captureMode);

        void onToast(int i);

        void oncePlayTeachVideo(VisionExecuteType visionExecuteType, MediaPlayer.OnCompletionListener onCompletionListener);

        void playSound(int i);

        void repeatPlayTeachVideo(VisionExecuteType visionExecuteType);

        void showEffectView();

        void showExecuteFailedDialog(boolean z);

        void showIntelligentGuide();

        void stopPlayTeachVideo();

        void updateWheelView(int[] iArr, int i, String str);

        void updateWheelViewInFollowMode(String[] strArr, int i);
    }

    public int isSupportZoom() {
        return -1;
    }

    public void onCountDownViewClick(View view) {
    }

    public boolean isJpg() {
        return this.isJpgData.getValue() != null && this.isJpgData.getValue().booleanValue();
    }

    public boolean isShowTimerPhotoButton() {
        return CameraConfig.get().isSupportTimerPhoto() && this.isCameraConnected.get() && FlightConfig.isAtomPanTilt() && isJpg() && !this.isTrackFunctionOpen.get() && (this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PHOTO.ordinal() || this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_TAKING_PHOTO.ordinal());
    }

    public RightControllerModel(Context context, OnRightControllerListener onRightControllerListener) {
        this.context = context;
        this.rightControllerListener = onRightControllerListener;
        this.isAtomPanTilt.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.1
            AnonymousClass1() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isAtomPanTilt.get()) {
                    return;
                }
                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_GALLERY);
            }
        });
        this.isVideoTypeVisible.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.2
            AnonymousClass2() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (!RightControllerModel.this.isVideoTypeVisible.get()) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                    if (RightControllerModel.this.isTrackingTarget.get()) {
                        RightControllerModel.this.isTrackingTarget.notifyChange();
                        return;
                    }
                    return;
                }
                if (RightControllerModel.this.isExecuting.get()) {
                    return;
                }
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
                DDLog.e("\u8bbe\u7f6e\u9000\u51fa3");
            }
        });
        this.isTrackingTarget.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.3
            AnonymousClass3() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isTrackingTarget.get()) {
                    RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_GO);
                    RightControllerModel.this.isVideoTypeVisible.set(false);
                    RightControllerModel.this.setParamsArray();
                } else if (!RightControllerModel.this.isExecuting.get() && RightControllerModel.this.isTrackFunctionOpen.get()) {
                    RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
                    DDLog.e("\u8bbe\u7f6e\u9000\u51fa4");
                }
                RightControllerModel.this.checkEffectViewShow();
                RightControllerModel.this.checkSelectTargetShow();
            }
        });
        this.videoType.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.4
            AnonymousClass4() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightControllerModel.this.setParamsArray();
            }
        });
        this.isCountStart.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.5
            AnonymousClass5() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                RightControllerModel.this.isCountStart.get();
            }
        });
        this.isTrackFunctionOpen.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.6
            final /* synthetic */ OnRightControllerListener val$rightControllerListener;

            AnonymousClass6(OnRightControllerListener onRightControllerListener2) {
                r2 = onRightControllerListener2;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                    RightControllerModel.this.isVideoTypeVisible.set(true);
                    RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
                    DDLog.e("\u8bbe\u7f6e\u9000\u51fa1");
                    r2.showEffectView();
                    RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_DISABLE);
                } else {
                    RightControllerModel.this.isVideoTypeVisible.set(false);
                    RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
                    r2.hideEffectView();
                    RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_GALLERY);
                    RightControllerModel.this.onCancelSelectResultListener = null;
                }
                RightControllerModel.this.checkEffectViewShow();
                RightControllerModel.this.checkSelectTargetShow();
            }
        });
        this.btnGalleryMode.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.7
            AnonymousClass7() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isFollowMode()) {
                    RightControllerModel.this.isVideoTypeVisible.set(false);
                }
                RightControllerModel.this.checkEffectViewShow();
                RightControllerModel.this.checkSelectTargetShow();
                Event event = new Event(EventID.EVENT_VISUAL_TARGET_IS_FOLLOW_MODE);
                event.obj = Boolean.valueOf(RightControllerModel.this.isFollowMode());
                EventDispatcher.get().sendEvent(event);
            }
        });
        this.isExecuting.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.8
            final /* synthetic */ OnRightControllerListener val$rightControllerListener;

            AnonymousClass8(OnRightControllerListener onRightControllerListener2) {
                r2 = onRightControllerListener2;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isExecuting.get()) {
                    RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_PROGRESS);
                    RightControllerModel.this.progressPercent.set(-1);
                    r2.hideEffectView();
                    if (RightControllerModel.this.isFollowMode()) {
                        r2.onExecutingFollow();
                    }
                } else if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                    r2.showEffectView();
                    RightControllerModel.this.isTrackingTarget.notifyChange();
                } else {
                    RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
                }
                RightControllerModel.this.checkEffectViewShow();
                RightControllerModel.this.checkSelectTargetShow();
            }
        });
        this.isCameraConnected.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.9
            AnonymousClass9() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isCameraConnected.get()) {
                    return;
                }
                RightControllerModel.this.trackTarget = new TrackTarget();
                RightControllerModel.this.isDemoVideoVisible.set(false);
                RightControllerModel.this.isVideoTypeVisible.set(false);
                RightControllerModel.this.isCameraHighTemp.set(false);
                RightControllerModel.this.isCountStart.set(false);
                RightControllerModel.this.isSwitchingMode.set(false);
                RightControllerModel.this.isRecording.set(false);
                RightControllerModel.this.isTimePhotography.set(false);
                RightControllerModel.this.isTakingPhoto.set(false);
                RightControllerModel.this.isExecuting.set(false);
                RightControllerModel.this.isTrackFunctionOpen.set(false);
                RightControllerModel.this.isPressRemoterKey.set(false);
                RightControllerModel.this.onFlightStopTrackResultListener = null;
            }
        });
        this.isVideoTypeVisible.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.10
            AnonymousClass10() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (!RightControllerModel.this.isVideoTypeVisible.get()) {
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                } else if (Conditions.isQuickShotTeachVideoPlayed(RightControllerModel.this.videoType.get(), RightControllerModel.this.isFollowMode())) {
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                    PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.selectModeRunnable, 5000L);
                } else {
                    RightControllerModel.this.isDemoVideoVisible.set(true);
                }
            }
        });
        this.isDemoVideoVisible.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.11
            final /* synthetic */ OnRightControllerListener val$rightControllerListener;

            AnonymousClass11(OnRightControllerListener onRightControllerListener2) {
                r2 = onRightControllerListener2;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                DDLog.e("isDemoVideoVisible 1:" + RightControllerModel.this.isDemoVideoVisible.get());
                if (RightControllerModel.this.isDemoVideoVisible.get()) {
                    if (RightControllerModel.this.isFollowMode()) {
                        if (SPHelper.getInstance().isFollowTeachVideoPlayed()) {
                            r2.repeatPlayTeachVideo(VisionExecuteType.TYPE_VISION_FOLLOW);
                        } else {
                            r2.oncePlayTeachVideo(VisionExecuteType.TYPE_VISION_FOLLOW, new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.1
                                AnonymousClass1() {
                                }

                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    RightControllerModel.this.isDemoVideoVisible.set(false);
                                }
                            });
                            SPHelper.getInstance().setFollowTeachVideoPlayed(true);
                        }
                    } else {
                        int i2 = AnonymousClass36.$SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[((VisionExecuteType) Objects.requireNonNull(RightControllerModel.this.videoType.get())).ordinal()];
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        if (i2 == 5) {
                                            if (SPHelper.getInstance().isRecessTeachVideoPlayed()) {
                                                r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                                            } else {
                                                r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.6
                                                    AnonymousClass6() {
                                                    }

                                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        RightControllerModel.this.isDemoVideoVisible.set(false);
                                                    }
                                                });
                                                SPHelper.getInstance().setRecessTeachVideoPlayed(true);
                                            }
                                        }
                                    } else if (SPHelper.getInstance().isSkywardTeachVideoPlayed()) {
                                        r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                                    } else {
                                        r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.5
                                            AnonymousClass5() {
                                            }

                                            @Override // android.media.MediaPlayer.OnCompletionListener
                                            public void onCompletion(MediaPlayer mediaPlayer) {
                                                RightControllerModel.this.isDemoVideoVisible.set(false);
                                            }
                                        });
                                        SPHelper.getInstance().setSkywardTeachVideoPlayed(true);
                                    }
                                } else if (SPHelper.getInstance().isCometTeachVideoPlayed()) {
                                    r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                                } else {
                                    r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.4
                                        AnonymousClass4() {
                                        }

                                        @Override // android.media.MediaPlayer.OnCompletionListener
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            RightControllerModel.this.isDemoVideoVisible.set(false);
                                        }
                                    });
                                    SPHelper.getInstance().setCometTeachVideoPlayed(true);
                                }
                            } else if (SPHelper.getInstance().isScrewTeachVideoPlayed()) {
                                r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                            } else {
                                r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.3
                                    AnonymousClass3() {
                                    }

                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        RightControllerModel.this.isDemoVideoVisible.set(false);
                                    }
                                });
                                SPHelper.getInstance().setScrewTeachVideoPlayed(true);
                            }
                        } else if (SPHelper.getInstance().isCircleTeachVideoPlayed()) {
                            r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                        } else {
                            r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.2
                                AnonymousClass2() {
                                }

                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    RightControllerModel.this.isDemoVideoVisible.set(false);
                                }
                            });
                            SPHelper.getInstance().setCircleTeachVideoPlayed(true);
                        }
                    }
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                    return;
                }
                r2.stopPlayTeachVideo();
                if (RightControllerModel.this.isVideoTypeVisible.get()) {
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                    PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.selectModeRunnable, 5000L);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$1 */
            class AnonymousClass1 implements MediaPlayer.OnCompletionListener {
                AnonymousClass1() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$2 */
            class AnonymousClass2 implements MediaPlayer.OnCompletionListener {
                AnonymousClass2() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$3 */
            class AnonymousClass3 implements MediaPlayer.OnCompletionListener {
                AnonymousClass3() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$4 */
            class AnonymousClass4 implements MediaPlayer.OnCompletionListener {
                AnonymousClass4() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$5 */
            class AnonymousClass5 implements MediaPlayer.OnCompletionListener {
                AnonymousClass5() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }

            /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$6 */
            class AnonymousClass6 implements MediaPlayer.OnCompletionListener {
                AnonymousClass6() {
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    RightControllerModel.this.isDemoVideoVisible.set(false);
                }
            }
        });
        this.isSwitchingMode.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.12
            AnonymousClass12() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isSwitchingMode.get()) {
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.switchModeRunnable);
                    PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.switchModeRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                } else {
                    PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.switchModeRunnable);
                }
            }
        });
        this.isTakingPhoto.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.13
            AnonymousClass13() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isTakingPhoto.get()) {
                    RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_TAKING_PHOTO);
                } else {
                    RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
                }
            }
        });
        setFlightType();
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$1 */
    class AnonymousClass1 extends Observable.OnPropertyChangedCallback {
        AnonymousClass1() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isAtomPanTilt.get()) {
                return;
            }
            RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_GALLERY);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$2 */
    class AnonymousClass2 extends Observable.OnPropertyChangedCallback {
        AnonymousClass2() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (!RightControllerModel.this.isVideoTypeVisible.get()) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
                if (RightControllerModel.this.isTrackingTarget.get()) {
                    RightControllerModel.this.isTrackingTarget.notifyChange();
                    return;
                }
                return;
            }
            if (RightControllerModel.this.isExecuting.get()) {
                return;
            }
            RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
            DDLog.e("\u8bbe\u7f6e\u9000\u51fa3");
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$3 */
    class AnonymousClass3 extends Observable.OnPropertyChangedCallback {
        AnonymousClass3() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isTrackingTarget.get()) {
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_GO);
                RightControllerModel.this.isVideoTypeVisible.set(false);
                RightControllerModel.this.setParamsArray();
            } else if (!RightControllerModel.this.isExecuting.get() && RightControllerModel.this.isTrackFunctionOpen.get()) {
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
                DDLog.e("\u8bbe\u7f6e\u9000\u51fa4");
            }
            RightControllerModel.this.checkEffectViewShow();
            RightControllerModel.this.checkSelectTargetShow();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$4 */
    class AnonymousClass4 extends Observable.OnPropertyChangedCallback {
        AnonymousClass4() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            RightControllerModel.this.setParamsArray();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$5 */
    class AnonymousClass5 extends Observable.OnPropertyChangedCallback {
        AnonymousClass5() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            RightControllerModel.this.isCountStart.get();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$6 */
    class AnonymousClass6 extends Observable.OnPropertyChangedCallback {
        final /* synthetic */ OnRightControllerListener val$rightControllerListener;

        AnonymousClass6(OnRightControllerListener onRightControllerListener2) {
            r2 = onRightControllerListener2;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                RightControllerModel.this.isVideoTypeVisible.set(true);
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
                DDLog.e("\u8bbe\u7f6e\u9000\u51fa1");
                r2.showEffectView();
                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_DISABLE);
            } else {
                RightControllerModel.this.isVideoTypeVisible.set(false);
                RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
                r2.hideEffectView();
                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_GALLERY);
                RightControllerModel.this.onCancelSelectResultListener = null;
            }
            RightControllerModel.this.checkEffectViewShow();
            RightControllerModel.this.checkSelectTargetShow();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$7 */
    class AnonymousClass7 extends Observable.OnPropertyChangedCallback {
        AnonymousClass7() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isFollowMode()) {
                RightControllerModel.this.isVideoTypeVisible.set(false);
            }
            RightControllerModel.this.checkEffectViewShow();
            RightControllerModel.this.checkSelectTargetShow();
            Event event = new Event(EventID.EVENT_VISUAL_TARGET_IS_FOLLOW_MODE);
            event.obj = Boolean.valueOf(RightControllerModel.this.isFollowMode());
            EventDispatcher.get().sendEvent(event);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$8 */
    class AnonymousClass8 extends Observable.OnPropertyChangedCallback {
        final /* synthetic */ OnRightControllerListener val$rightControllerListener;

        AnonymousClass8(OnRightControllerListener onRightControllerListener2) {
            r2 = onRightControllerListener2;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isExecuting.get()) {
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_PROGRESS);
                RightControllerModel.this.progressPercent.set(-1);
                r2.hideEffectView();
                if (RightControllerModel.this.isFollowMode()) {
                    r2.onExecutingFollow();
                }
            } else if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                r2.showEffectView();
                RightControllerModel.this.isTrackingTarget.notifyChange();
            } else {
                RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
            }
            RightControllerModel.this.checkEffectViewShow();
            RightControllerModel.this.checkSelectTargetShow();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$9 */
    class AnonymousClass9 extends Observable.OnPropertyChangedCallback {
        AnonymousClass9() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isCameraConnected.get()) {
                return;
            }
            RightControllerModel.this.trackTarget = new TrackTarget();
            RightControllerModel.this.isDemoVideoVisible.set(false);
            RightControllerModel.this.isVideoTypeVisible.set(false);
            RightControllerModel.this.isCameraHighTemp.set(false);
            RightControllerModel.this.isCountStart.set(false);
            RightControllerModel.this.isSwitchingMode.set(false);
            RightControllerModel.this.isRecording.set(false);
            RightControllerModel.this.isTimePhotography.set(false);
            RightControllerModel.this.isTakingPhoto.set(false);
            RightControllerModel.this.isExecuting.set(false);
            RightControllerModel.this.isTrackFunctionOpen.set(false);
            RightControllerModel.this.isPressRemoterKey.set(false);
            RightControllerModel.this.onFlightStopTrackResultListener = null;
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$10 */
    class AnonymousClass10 extends Observable.OnPropertyChangedCallback {
        AnonymousClass10() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (!RightControllerModel.this.isVideoTypeVisible.get()) {
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
            } else if (Conditions.isQuickShotTeachVideoPlayed(RightControllerModel.this.videoType.get(), RightControllerModel.this.isFollowMode())) {
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.selectModeRunnable, 5000L);
            } else {
                RightControllerModel.this.isDemoVideoVisible.set(true);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11 */
    class AnonymousClass11 extends Observable.OnPropertyChangedCallback {
        final /* synthetic */ OnRightControllerListener val$rightControllerListener;

        AnonymousClass11(OnRightControllerListener onRightControllerListener2) {
            r2 = onRightControllerListener2;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            DDLog.e("isDemoVideoVisible 1:" + RightControllerModel.this.isDemoVideoVisible.get());
            if (RightControllerModel.this.isDemoVideoVisible.get()) {
                if (RightControllerModel.this.isFollowMode()) {
                    if (SPHelper.getInstance().isFollowTeachVideoPlayed()) {
                        r2.repeatPlayTeachVideo(VisionExecuteType.TYPE_VISION_FOLLOW);
                    } else {
                        r2.oncePlayTeachVideo(VisionExecuteType.TYPE_VISION_FOLLOW, new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.1
                            AnonymousClass1() {
                            }

                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                RightControllerModel.this.isDemoVideoVisible.set(false);
                            }
                        });
                        SPHelper.getInstance().setFollowTeachVideoPlayed(true);
                    }
                } else {
                    int i2 = AnonymousClass36.$SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[((VisionExecuteType) Objects.requireNonNull(RightControllerModel.this.videoType.get())).ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 == 5) {
                                        if (SPHelper.getInstance().isRecessTeachVideoPlayed()) {
                                            r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                                        } else {
                                            r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.6
                                                AnonymousClass6() {
                                                }

                                                @Override // android.media.MediaPlayer.OnCompletionListener
                                                public void onCompletion(MediaPlayer mediaPlayer) {
                                                    RightControllerModel.this.isDemoVideoVisible.set(false);
                                                }
                                            });
                                            SPHelper.getInstance().setRecessTeachVideoPlayed(true);
                                        }
                                    }
                                } else if (SPHelper.getInstance().isSkywardTeachVideoPlayed()) {
                                    r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                                } else {
                                    r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.5
                                        AnonymousClass5() {
                                        }

                                        @Override // android.media.MediaPlayer.OnCompletionListener
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            RightControllerModel.this.isDemoVideoVisible.set(false);
                                        }
                                    });
                                    SPHelper.getInstance().setSkywardTeachVideoPlayed(true);
                                }
                            } else if (SPHelper.getInstance().isCometTeachVideoPlayed()) {
                                r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                            } else {
                                r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.4
                                    AnonymousClass4() {
                                    }

                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        RightControllerModel.this.isDemoVideoVisible.set(false);
                                    }
                                });
                                SPHelper.getInstance().setCometTeachVideoPlayed(true);
                            }
                        } else if (SPHelper.getInstance().isScrewTeachVideoPlayed()) {
                            r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                        } else {
                            r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.3
                                AnonymousClass3() {
                                }

                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    RightControllerModel.this.isDemoVideoVisible.set(false);
                                }
                            });
                            SPHelper.getInstance().setScrewTeachVideoPlayed(true);
                        }
                    } else if (SPHelper.getInstance().isCircleTeachVideoPlayed()) {
                        r2.repeatPlayTeachVideo(RightControllerModel.this.videoType.get());
                    } else {
                        r2.oncePlayTeachVideo(RightControllerModel.this.videoType.get(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.11.2
                            AnonymousClass2() {
                            }

                            @Override // android.media.MediaPlayer.OnCompletionListener
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                RightControllerModel.this.isDemoVideoVisible.set(false);
                            }
                        });
                        SPHelper.getInstance().setCircleTeachVideoPlayed(true);
                    }
                }
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                return;
            }
            r2.stopPlayTeachVideo();
            if (RightControllerModel.this.isVideoTypeVisible.get()) {
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.selectModeRunnable);
                PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.selectModeRunnable, 5000L);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$1 */
        class AnonymousClass1 implements MediaPlayer.OnCompletionListener {
            AnonymousClass1() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$2 */
        class AnonymousClass2 implements MediaPlayer.OnCompletionListener {
            AnonymousClass2() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$3 */
        class AnonymousClass3 implements MediaPlayer.OnCompletionListener {
            AnonymousClass3() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$4 */
        class AnonymousClass4 implements MediaPlayer.OnCompletionListener {
            AnonymousClass4() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$5 */
        class AnonymousClass5 implements MediaPlayer.OnCompletionListener {
            AnonymousClass5() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$11$6 */
        class AnonymousClass6 implements MediaPlayer.OnCompletionListener {
            AnonymousClass6() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                RightControllerModel.this.isDemoVideoVisible.set(false);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$36 */
    static /* synthetic */ class AnonymousClass36 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType;

        static {
            int[] iArr = new int[VisionExecuteType.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType = iArr;
            try {
                iArr[VisionExecuteType.TYPE_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_SCREW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_COMET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_SKYWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$VisionExecuteType[VisionExecuteType.TYPE_RECESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$12 */
    class AnonymousClass12 extends Observable.OnPropertyChangedCallback {
        AnonymousClass12() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isSwitchingMode.get()) {
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.switchModeRunnable);
                PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.switchModeRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } else {
                PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.switchModeRunnable);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$13 */
    class AnonymousClass13 extends Observable.OnPropertyChangedCallback {
        AnonymousClass13() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (RightControllerModel.this.isTakingPhoto.get()) {
                RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_TAKING_PHOTO);
            } else {
                RightControllerModel.this.setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
            }
        }
    }

    public void setFlightType() {
        this.isAtomPanTilt.set(FlightConfig.isAtomPanTilt());
        this.isAtomLT.set(FlightConfig.isAtomLT());
        this.isAtomSE.set(FlightConfig.is_Atom_SE_Series());
    }

    public void setCamTemp(boolean z) {
        this.isCameraHighTemp.set(!z);
    }

    public void onConfigMenu() {
        this.isCameraConnected.set(true);
        this.isJpgData.setValue(Boolean.valueOf(true ^ CameraConfig.get().isRaw()));
        if (this.isRecording.get()) {
            return;
        }
        setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
    }

    public void setCaptureModeSuccess() {
        PhoneConfig.mainHandler.removeCallbacks(this.takingPhotoRunnable);
        this.isTakingPhoto.set(false);
        this.isSwitchingMode.set(false);
        if (this.isTrackFunctionOpen.get()) {
            return;
        }
        setBtnCaptureMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureUIType.CAPTURE_UI_RECORD : CaptureUIType.CAPTURE_UI_PHOTO);
    }

    public void setBtnCaptureMode(CaptureUIType captureUIType) {
        this.btnCaptureMode.set(captureUIType.ordinal());
    }

    public void setBtnGalleryMode(GalleryUIType galleryUIType) {
        this.btnGalleryMode.set(galleryUIType.ordinal());
    }

    public void setVideoType(VisionExecuteType visionExecuteType) {
        boolean z = this.videoType.get() != visionExecuteType;
        this.videoType.set(visionExecuteType);
        if (z) {
            if (!Conditions.isQuickShotTeachVideoPlayed(visionExecuteType, false)) {
                if (this.isDemoVideoVisible.get()) {
                    this.isDemoVideoVisible.notifyChange();
                    return;
                } else {
                    this.isDemoVideoVisible.set(true);
                    return;
                }
            }
            this.isDemoVideoVisible.set(false);
        }
    }

    public void setParamsArray() {
        int i = 0;
        if (isFollowMode()) {
            this.isParams1Select.set(this.params1Arr[5]);
            i = this.params2Arr[5];
        } else if (this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
            this.isParams1Select.set(this.params1Arr[0]);
            i = this.params2Arr[0];
        } else if (this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
            this.isParams1Select.set(this.params1Arr[1]);
            i = this.params2Arr[1];
        } else if (this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
            this.isParams1Select.set(this.params1Arr[2]);
            i = this.params2Arr[2];
        } else if (this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
            this.isParams1Select.set(this.params1Arr[3]);
            i = this.params2Arr[3];
        } else if (this.videoType.get() == VisionExecuteType.TYPE_COMET) {
            this.isParams1Select.set(this.params1Arr[4]);
            i = this.params2Arr[4];
        }
        this.recordTxt.set("");
        if (isFollowMode()) {
            this.rightControllerListener.updateWheelViewInFollowMode(SHORT_VIDEO_PARAMS_FOLLOW, i);
            return;
        }
        if (this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
            this.rightControllerListener.updateWheelView(this.SHORT_VIDEO_PARAMS_RECESS, i, PhoneConfig.isFt ? "ft" : "m");
        } else if (this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
            this.rightControllerListener.updateWheelView(this.SHORT_VIDEO_PARAMS_SKYWARD, i, PhoneConfig.isFt ? "ft" : "m");
        } else {
            this.rightControllerListener.updateWheelView(this.SHORT_VIDEO_PARAMS_REPEAT, i, "");
        }
    }

    public void onCameraSettingControllerDismiss() {
        this.isCameraSettingControllerShow.set(false);
    }

    public void setIsTrackingTarget(boolean z) {
        OnSuccessListener onSuccessListener;
        this.isTrackingTarget.set(z);
        if (z || (onSuccessListener = this.onCancelSelectResultListener) == null) {
            return;
        }
        onSuccessListener.onResult(true);
        this.onCancelSelectResultListener = null;
    }

    public void startRecord(long j) {
        DDLog.e("\u5f00\u59cb\u5f55\u50cf \uff1a" + j);
        if (this.isRecording.get()) {
            return;
        }
        DDLog.e("\u5f00\u59cb\u5f55\u50cf2 \uff1a");
        this.isRecording.set(true);
        this.rightControllerListener.playSound(SoundPoolPlayer.RECORD_VOICE_ID);
        if (!this.isTrackFunctionOpen.get()) {
            RecordTimer recordTimer = new RecordTimer();
            this.recordTimer = recordTimer;
            recordTimer.start(j, new RecordTimer.OnRecordTimerListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.14
                AnonymousClass14() {
                }

                @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
                public void onTimeUpdate(long j2) {
                    RightControllerModel.this.recordTxt.set(FormatUtil.formatDuration(j2 * 1000));
                }

                @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
                public void onRedUpdate(long j2) {
                    if (j2 % 2 == 0) {
                        RightControllerModel.this.isRecordRedPointShow.set(true);
                    } else {
                        RightControllerModel.this.isRecordRedPointShow.set(false);
                    }
                }
            });
            setBtnCaptureMode(CaptureUIType.CAPTURE_UI_RECORDING);
            return;
        }
        if (isFollowMode()) {
            this.progressPercent.set(-1);
            setBtnCaptureMode(CaptureUIType.CAPTURE_UI_PROGRESS);
            RecordTimer recordTimer2 = new RecordTimer();
            this.recordTimer = recordTimer2;
            recordTimer2.start(0L, new RecordTimer.OnRecordTimerListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.15
                @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
                public void onRedUpdate(long j2) {
                }

                AnonymousClass15() {
                }

                @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
                public void onTimeUpdate(long j2) {
                    if (RightControllerModel.this.followRecordTime != -1) {
                        int i = (int) (((j2 * 1000) * 100) / RightControllerModel.this.followRecordTime);
                        if (i >= 100) {
                            RightControllerModel.this.sendStopExecuteCMD();
                            RightControllerModel.this.sendStopExecuteToFlightCtrl();
                            if (i > 102) {
                                RightControllerModel.this.stopCustomTimer();
                                return;
                            }
                            return;
                        }
                        if (RightControllerModel.this.progressPercent.get() != i) {
                            RightControllerModel.this.recordTxt.set(i + "%");
                            RightControllerModel.this.progressPercent.set(i);
                            return;
                        }
                        return;
                    }
                    RightControllerModel.this.recordTxt.set("");
                }
            });
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$14 */
    class AnonymousClass14 implements RecordTimer.OnRecordTimerListener {
        AnonymousClass14() {
        }

        @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
        public void onTimeUpdate(long j2) {
            RightControllerModel.this.recordTxt.set(FormatUtil.formatDuration(j2 * 1000));
        }

        @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
        public void onRedUpdate(long j2) {
            if (j2 % 2 == 0) {
                RightControllerModel.this.isRecordRedPointShow.set(true);
            } else {
                RightControllerModel.this.isRecordRedPointShow.set(false);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$15 */
    class AnonymousClass15 implements RecordTimer.OnRecordTimerListener {
        @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
        public void onRedUpdate(long j2) {
        }

        AnonymousClass15() {
        }

        @Override // com.ipotensic.kernel.utils.RecordTimer.OnRecordTimerListener
        public void onTimeUpdate(long j2) {
            if (RightControllerModel.this.followRecordTime != -1) {
                int i = (int) (((j2 * 1000) * 100) / RightControllerModel.this.followRecordTime);
                if (i >= 100) {
                    RightControllerModel.this.sendStopExecuteCMD();
                    RightControllerModel.this.sendStopExecuteToFlightCtrl();
                    if (i > 102) {
                        RightControllerModel.this.stopCustomTimer();
                        return;
                    }
                    return;
                }
                if (RightControllerModel.this.progressPercent.get() != i) {
                    RightControllerModel.this.recordTxt.set(i + "%");
                    RightControllerModel.this.progressPercent.set(i);
                    return;
                }
                return;
            }
            RightControllerModel.this.recordTxt.set("");
        }
    }

    public void stopRecord() {
        DDLog.e("\u505c\u6b62\u5f55\u50cf1");
        if (this.isRecording.get()) {
            DDLog.e("\u505c\u6b62\u5f55\u50cf2");
            this.isRecording.set(false);
            this.rightControllerListener.playSound(SoundPoolPlayer.RECORD_VOICE_ID);
            stopCustomTimer();
            if (!this.isTrackFunctionOpen.get()) {
                this.isRecordRedPointShow.set(false);
                setBtnCaptureMode(CaptureUIType.CAPTURE_UI_RECORD);
            } else {
                this.recordTxt.set("");
                setBtnCaptureMode(CaptureUIType.CAPTURE_UI_EXIT_TRACK);
            }
        }
    }

    public void stopCustomTimer() {
        RecordTimer recordTimer = this.recordTimer;
        if (recordTimer != null) {
            recordTimer.stop();
            this.recordTimer = null;
        }
    }

    public void startTakePhoto() {
        if (FlightConfig.isOldProduct()) {
            stopTakePhoto(true);
        } else {
            if (this.photoChildMode.isTimerMode()) {
                return;
            }
            this.isTakingPhoto.set(true);
            PhoneConfig.mainHandler.removeCallbacks(this.takingPhotoRunnable);
            PhoneConfig.mainHandler.postDelayed(this.takingPhotoRunnable, Constant.DELAY_MILLIS);
        }
    }

    public void stopTakePhoto(boolean z) {
        this.isTakingPhoto.set(false);
        PhoneConfig.mainHandler.removeCallbacks(this.takingPhotoRunnable);
        if (z) {
            this.rightControllerListener.playSound(SoundPoolPlayer.CAPTURE_VOICE_ID);
        }
    }

    public void playCaptureSound() {
        this.rightControllerListener.playSound(SoundPoolPlayer.CAPTURE_VOICE_ID);
    }

    public void onTrackFunctionOpen() {
        this.isTrackFunctionOpen.set(true);
    }

    public void onTrackFunctionClose() {
        this.isTrackFunctionOpen.set(false);
    }

    public void onTrackError(VisionError visionError) {
        DDLog.e("\u4e00\u952e\u77ed\u7247 \u62a5\u9519:" + visionError);
        if (visionError == VisionError.ERROR_TARGET_LOSE) {
            this.rightControllerListener.onToast(R.string.txt_short_video_lost_target);
        } else if (visionError == VisionError.ERROR_TARGET_TOO_CLOSE) {
            this.rightControllerListener.onToast(R.string.txt_short_video_target_too_close);
        } else if (visionError == VisionError.ERROR_GIMBAL_ANGLE_TOO_BIG) {
            this.rightControllerListener.onToast(R.string.txt_short_video_gimbal_angle_too_big);
        } else if (visionError == VisionError.ERROR_HEIGHT_TOO_LOW) {
            this.rightControllerListener.onToast(R.string.txt_short_video_height_too_low);
        } else if (visionError == VisionError.ERROR_GIMBAL_TOO_SMOOTH) {
            this.rightControllerListener.onToast(R.string.txt_short_video_gimbal_too_smooth);
        }
        onVisionError();
    }

    public void onVisionError() {
        this.isCountStart.set(false);
    }

    public void onExecuting() {
        this.isExecuting.set(true);
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$16 */
    class AnonymousClass16 implements OnSuccessListener {
        AnonymousClass16() {
        }

        @Override // com.ipotensic.baselib.listener.OnSuccessListener
        public void onResult(boolean z) {
            if (z) {
                RightControllerModel.this.isExecuting.set(false);
            }
        }
    }

    public void onExitExecuting() {
        cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.16
            AnonymousClass16() {
            }

            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
                if (z) {
                    RightControllerModel.this.isExecuting.set(false);
                }
            }
        });
    }

    public void setMapVideoMode(Mode mode) {
        this.mapVideoMode = mode;
        if (mode == Mode.MODE_MAP) {
            this.rightControllerListener.hideEffectView();
        } else if (this.isTrackFunctionOpen.get()) {
            if (this.isExecuting.get()) {
                if (isFollowMode()) {
                    this.rightControllerListener.onExecutingFollow();
                } else {
                    this.rightControllerListener.hideEffectView();
                }
            } else {
                this.rightControllerListener.showEffectView();
            }
        }
        checkEffectViewShow();
        checkSelectTargetShow();
    }

    public boolean isMapMode() {
        return this.mapVideoMode == Mode.MODE_MAP;
    }

    public boolean isVideoMode() {
        return this.mapVideoMode == Mode.MODE_VIDEO;
    }

    public void update(FlightRevStateData flightRevStateData) {
        if (this.isExecuting.get()) {
            if (flightRevStateData.isFlightExecutingShortVideo()) {
                if (!isFollowMode()) {
                    if (flightRevStateData.isShortVideoBack()) {
                        this.recordTxt.set(this.context.getString(R.string.txt_short_video_back));
                        setBtnCaptureMode(CaptureUIType.CAPTURE_UI_CANCEL_BACK);
                    } else {
                        int shortVideoPercent = flightRevStateData.getShortVideoPercent();
                        if (shortVideoPercent < 0) {
                            shortVideoPercent = 0;
                        }
                        if (shortVideoPercent > 100) {
                            shortVideoPercent = 100;
                        }
                        if (this.isRecording.get() && this.progressPercent.get() != shortVideoPercent) {
                            this.recordTxt.set(shortVideoPercent + "%");
                            this.progressPercent.set(shortVideoPercent);
                        }
                    }
                }
            } else {
                cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.17
                    AnonymousClass17() {
                    }

                    @Override // com.ipotensic.baselib.listener.OnSuccessListener
                    public void onResult(boolean z) {
                        if (z) {
                            RightControllerModel.this.isExecuting.set(false);
                            RightControllerModel.this.recordTxt.set("");
                        }
                    }
                });
            }
        }
        if (this.isTrackFunctionOpen.get() && (flightRevStateData.isLanding() || flightRevStateData.isReturning() || flightRevStateData.getMode() != 2 || !flightRevStateData.isAllowShortVideo())) {
            sendStopExecuteCMD();
            sendCloseTrackCMD();
            if (flightRevStateData.getMode() != 2) {
                this.rightControllerListener.onToast(R.string.txt_short_video_not_gps_mode);
            } else if (!flightRevStateData.isAllowShortVideo()) {
                this.rightControllerListener.onToast(R.string.quickshots_poor_gps_signal_exited_tips);
            }
        }
        if (this.isPointFly.get() && !flightRevStateData.isPointFly()) {
            this.isPointFly.set(false);
        } else if (!this.isPointFly.get() && flightRevStateData.isPointFly()) {
            this.isPointFly.set(true);
        }
        if (this.onFlightStopTrackResultListener != null) {
            if (flightRevStateData.isFlightExecutingShortVideo()) {
                sendStopCmdToFlightIfAtomV2(this.onFlightStopTrackResultListener);
            } else {
                this.onFlightStopTrackResultListener = null;
            }
        }
        if (this.isTrackFunctionOpen.get() || !flightRevStateData.isFlightExecutingShortVideo()) {
            return;
        }
        sendCloseTrackCMD();
        sendStopCmdToFlightIfAtomV2(null);
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$17 */
    class AnonymousClass17 implements OnSuccessListener {
        AnonymousClass17() {
        }

        @Override // com.ipotensic.baselib.listener.OnSuccessListener
        public void onResult(boolean z) {
            if (z) {
                RightControllerModel.this.isExecuting.set(false);
                RightControllerModel.this.recordTxt.set("");
            }
        }
    }

    public void update(FlightRevRemoterStateData flightRevRemoterStateData) {
        if (!this.isCameraConnected.get() || this.isTrackFunctionOpen.get()) {
            return;
        }
        if (flightRevRemoterStateData.getIsPressRecordButton() && this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PHOTO.ordinal()) {
            return;
        }
        if (flightRevRemoterStateData.getIsPressTakePhotoButton() && this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORD.ordinal()) {
            return;
        }
        if ((CameraConfig.get().isSdCardAvailable() && flightRevRemoterStateData.getIsPressRecordButton() && this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORD.ordinal()) || (CameraConfig.get().isSdCardAvailable() && flightRevRemoterStateData.getIsPressTakePhotoButton() && this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PHOTO.ordinal())) {
            DDLog.e("\u5f00\u59cb\u5f55\u5236");
            this.isPressRemoterKey.set(true);
            PhoneConfig.mainHandler.removeCallbacks(this.pressRemoterKeyRunnable);
            PhoneConfig.mainHandler.postDelayed(this.pressRemoterKeyRunnable, 1000L);
        }
    }

    public void reset() {
        this.isCameraConnected.set(false);
        stopCustomTimer();
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$18 */
    class AnonymousClass18 extends ScaleClickListener {
        AnonymousClass18() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                RightControllerModel.this.isSwitchingMode.set(true);
                if (RightControllerModel.this.isRecording.get()) {
                    RightControllerModel.this.rightControllerListener.onToast(R.string.stop_recording_first);
                } else {
                    RightControllerModel.this.rightControllerListener.onSwitchMode(CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC ? CaptureMode.MODE_PHOTO : CaptureMode.MODE_REC);
                }
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$19 */
    class AnonymousClass19 extends ScaleClickListener {
        AnonymousClass19() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (RightControllerModel.this.isAtomPanTilt.get()) {
                    RightControllerModel.this.rightControllerListener.onSwitchAutoOrManual();
                    return;
                }
                CameraSetController cameraSetController = (CameraSetController) EventDispatcher.get().getController(CameraSetController.class);
                if (cameraSetController == null || cameraSetController.getVisibility() != 0) {
                    RightControllerModel.this.rightControllerListener.onCamSettingClick();
                } else {
                    cameraSetController.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$20 */
    class AnonymousClass20 extends ScaleClickListener {
        AnonymousClass20() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PHOTO.ordinal()) {
                    DDLog.e("\u6309\u952e\u72b6\u6001: \u70b9\u51fb\u62cd\u7167");
                    if (!CameraConfig.get().isSdCardAvailable()) {
                        if (RightControllerModel.this.rightControllerListener != null) {
                            RightControllerModel.this.rightControllerListener.onToast(R.string.no_sd_card);
                        }
                        EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD_TIP);
                        return;
                    } else {
                        if (!CameraConfig.get().isNeedFormatSdCard()) {
                            DDLog.e("\u70b9\u51fb\u62cd\u7167");
                            CameraCtrlPresenter.getInstance().takePhoto();
                            if (RightControllerModel.this.photoChildMode.isTimerMode()) {
                                return;
                            }
                            RightControllerModel.this.isTakingPhoto.set(true);
                            RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_TAKING_PHOTO);
                            PhoneConfig.mainHandler.removeCallbacks(RightControllerModel.this.takingPhotoRunnable);
                            PhoneConfig.mainHandler.postDelayed(RightControllerModel.this.takingPhotoRunnable, Constant.DELAY_MILLIS);
                            return;
                        }
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD);
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD_TIP);
                        return;
                    }
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORD.ordinal()) {
                    DDLog.e("\u6309\u952e\u72b6\u6001:\u70b9\u51fb\u5f55\u50cf");
                    DDLog.e("\u70b9\u51fb\u5f00\u59cb\u5f55\u50cf");
                    CameraCtrlPresenter.getInstance().startRecord();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_RECORDING.ordinal()) {
                    DDLog.e("\u70b9\u51fb\u505c\u6b62\u5f55\u50cf");
                    CameraCtrlPresenter.getInstance().stopRecord();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_EXIT_TRACK.ordinal()) {
                    RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.20.1
                        @Override // com.ipotensic.baselib.listener.OnSuccessListener
                        public void onResult(boolean z) {
                        }

                        AnonymousClass1() {
                        }
                    });
                    RightControllerModel.this.sendCloseTrackCMD();
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_GO.ordinal()) {
                    if (RightControllerModel.this.checkStateIsReadyWhenGo()) {
                        RightControllerModel.this.isCountStart.set(true);
                        RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN);
                        return;
                    } else {
                        RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.20.2
                            @Override // com.ipotensic.baselib.listener.OnSuccessListener
                            public void onResult(boolean z) {
                            }

                            AnonymousClass2() {
                            }
                        });
                        return;
                    }
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN.ordinal()) {
                    RightControllerModel.this.isCountStart.set(false);
                    if (RightControllerModel.this.isTrackingTarget.get()) {
                        RightControllerModel.this.isTrackingTarget.notifyChange();
                        return;
                    }
                    return;
                }
                if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_PROGRESS.ordinal()) {
                    RightControllerModel.this.sendStopExecuteCMD();
                    RightControllerModel.this.sendStopExecuteToFlightCtrl();
                } else if (RightControllerModel.this.btnCaptureMode.get() == CaptureUIType.CAPTURE_UI_CANCEL_BACK.ordinal()) {
                    RightControllerModel.this.sendStopExecuteToFlightCtrl();
                }
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$20$1 */
        class AnonymousClass1 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
            }

            AnonymousClass1() {
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$20$2 */
        class AnonymousClass2 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
            }

            AnonymousClass2() {
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$21 */
    class AnonymousClass21 extends ScaleClickListener {
        AnonymousClass21() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (SPHelper.getInstance().getIntelligentMode()) {
                    SPHelper.getInstance().setIntelligentMode(false);
                    RightControllerModel.this.rightControllerListener.showIntelligentGuide();
                } else if (!FlightConfig.isAtomPanTilt() || !FlightConfig.enterPointFly) {
                    RightControllerModel.this.onClickShortVideo();
                } else {
                    new GeneralDialog(RightControllerModel.this.context, RightControllerModel.this.context.getString(R.string.dialog_quit_waypoint_flight_title), RightControllerModel.this.context.getString(R.string.dialog_quit_waypoint_flight_describe), new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.model.-$$Lambda$RightControllerModel$21$-G7fwnV8iWTe0Tk4Pl9yOuQTFKQ
                        public /* synthetic */ $$Lambda$RightControllerModel$21$G7fwnV8iWTe0Tk4Pl9yOuQTFKQ() {
                        }

                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public final void confirm() {
                            RightControllerModel.AnonymousClass21.this.lambda$click$1$RightControllerModel$21();
                        }
                    }).show();
                }
            }
        }

        public /* synthetic */ void lambda$click$1$RightControllerModel$21() {
            MapVideoController mapVideoController = (MapVideoController) EventDispatcher.get().getController(MapVideoController.class);
            if (mapVideoController != null) {
                mapVideoController.setExitWayPointFlight();
            }
            PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.model.-$$Lambda$RightControllerModel$21$JZ1YRSh3NmcEQ3hqryY89VLjF5I
                public /* synthetic */ $$Lambda$RightControllerModel$21$JZ1YRSh3NmcEQ3hqryY89VLjF5I() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    RightControllerModel.AnonymousClass21.this.lambda$click$0$RightControllerModel$21();
                }
            }, 200L);
        }

        public /* synthetic */ void lambda$click$0$RightControllerModel$21() {
            try {
                FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                if (flightRevStateData != null && !flightRevStateData.isPointFly()) {
                    RightControllerModel.this.onClickShortVideo();
                } else {
                    RightControllerModel.this.isPointFly.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.RightControllerModel.21.1
                        AnonymousClass1() {
                        }

                        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                        public void onPropertyChanged(Observable observable, int i) {
                            if (RightControllerModel.this.isPointFly.get()) {
                                return;
                            }
                            RightControllerModel.this.onClickShortVideo();
                            RightControllerModel.this.isPointFly.removeOnPropertyChangedCallback(this);
                        }
                    });
                }
            } catch (Exception e) {
                DDLog.e("RightControllerModel", "click btnOneKeyVideo exitPointFly exception " + e.getMessage());
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$21$1 */
        class AnonymousClass1 extends Observable.OnPropertyChangedCallback {
            AnonymousClass1() {
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (RightControllerModel.this.isPointFly.get()) {
                    return;
                }
                RightControllerModel.this.onClickShortVideo();
                RightControllerModel.this.isPointFly.removeOnPropertyChangedCallback(this);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$22 */
    class AnonymousClass22 extends ScaleClickListener {
        AnonymousClass22() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (RightControllerModel.this.isAllowClick()) {
                if (!RightControllerModel.this.isTrackFunctionOpen.get()) {
                    RightControllerModel.this.rightControllerListener.onGalleryClicked();
                } else if (RightControllerModel.this.isFollowMode()) {
                    RightControllerModel.this.isVideoTypeVisible.set(!RightControllerModel.this.isVideoTypeVisible.get());
                } else if (RightControllerModel.this.btnGalleryMode.get() == GalleryUIType.UI_TYPE_FOLLOW_DISABLE.ordinal()) {
                    RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.22.1
                        AnonymousClass1() {
                        }

                        @Override // com.ipotensic.baselib.listener.OnSuccessListener
                        public void onResult(boolean z) {
                            if (z) {
                                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_ENABLE);
                                if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                                    RightControllerModel.this.isVideoTypeVisible.set(true);
                                }
                            }
                        }
                    });
                }
            }
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$22$1 */
        class AnonymousClass1 implements OnSuccessListener {
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z) {
                if (z) {
                    RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_ENABLE);
                    if (RightControllerModel.this.isTrackFunctionOpen.get()) {
                        RightControllerModel.this.isVideoTypeVisible.set(true);
                    }
                }
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$23 */
    class AnonymousClass23 extends ScaleClickListener {
        AnonymousClass23() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_RECESS);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$24 */
    class AnonymousClass24 extends ScaleClickListener {
        AnonymousClass24() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_SKYWARD);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$25 */
    class AnonymousClass25 extends ScaleClickListener {
        AnonymousClass25() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_CIRCLE);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$26 */
    class AnonymousClass26 extends ScaleClickListener {
        AnonymousClass26() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_SCREW);
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$27 */
    class AnonymousClass27 extends ScaleClickListener {
        AnonymousClass27() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            RightControllerModel.this.setVideoType(VisionExecuteType.TYPE_COMET);
        }
    }

    public void onDemoVideoClick(View view) {
        this.isDemoVideoVisible.set(!r2.get());
    }

    public void onBlankClick(View view) {
        if (this.isDemoVideoVisible.get()) {
            this.isDemoVideoVisible.set(false);
        }
    }

    public void onParams1Click(View view) {
        this.isParams1Select.set(!r3.get());
        if (isFollowMode()) {
            this.params1Arr[5] = this.isParams1Select.get();
            return;
        }
        if (this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
            this.params1Arr[0] = this.isParams1Select.get();
            return;
        }
        if (this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
            this.params1Arr[1] = this.isParams1Select.get();
            return;
        }
        if (this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
            this.params1Arr[2] = this.isParams1Select.get();
        } else if (this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
            this.params1Arr[3] = this.isParams1Select.get();
        } else if (this.videoType.get() == VisionExecuteType.TYPE_COMET) {
            this.params1Arr[4] = this.isParams1Select.get();
        }
    }

    public void onClickShortVideo() {
        if (checkGimbalStates() && checkStateIsReady()) {
            if (this.isTrackFunctionOpen.get()) {
                if (isFollowMode()) {
                    cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.28
                        AnonymousClass28() {
                        }

                        @Override // com.ipotensic.baselib.listener.OnSuccessListener
                        public void onResult(boolean z) {
                            if (z) {
                                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_DISABLE);
                                if (RightControllerModel.this.isVideoTypeVisible.get()) {
                                    RightControllerModel.this.isVideoTypeVisible.notifyChange();
                                } else {
                                    RightControllerModel.this.isVideoTypeVisible.set(true);
                                }
                                if (RightControllerModel.this.isDemoVideoVisible.get()) {
                                    RightControllerModel.this.isDemoVideoVisible.notifyChange();
                                }
                            }
                        }
                    });
                    return;
                } else {
                    this.isVideoTypeVisible.set(!r0.get());
                    return;
                }
            }
            sendOpenTrackCMD();
            if (Conditions.isStableMode()) {
                return;
            }
            sendSetStableMode();
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$28 */
    class AnonymousClass28 implements OnSuccessListener {
        AnonymousClass28() {
        }

        @Override // com.ipotensic.baselib.listener.OnSuccessListener
        public void onResult(boolean z) {
            if (z) {
                RightControllerModel.this.setBtnGalleryMode(GalleryUIType.UI_TYPE_FOLLOW_DISABLE);
                if (RightControllerModel.this.isVideoTypeVisible.get()) {
                    RightControllerModel.this.isVideoTypeVisible.notifyChange();
                } else {
                    RightControllerModel.this.isVideoTypeVisible.set(true);
                }
                if (RightControllerModel.this.isDemoVideoVisible.get()) {
                    RightControllerModel.this.isDemoVideoVisible.notifyChange();
                }
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$29 */
    class AnonymousClass29 implements OnWheelChangedListener {
        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelLoopFinished(WheelView wheelView) {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelScrolled(WheelView wheelView, int i) {
        }

        AnonymousClass29() {
        }

        @Override // com.ipotensic.baselib.views.wheelview.contract.OnWheelChangedListener
        public void onWheelSelected(WheelView wheelView, int i) {
            if (RightControllerModel.this.isFollowMode()) {
                RightControllerModel.this.params2Arr[5] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
                RightControllerModel.this.params2Arr[0] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
                RightControllerModel.this.params2Arr[1] = i;
                return;
            }
            if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
                RightControllerModel.this.params2Arr[2] = i;
            } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
                RightControllerModel.this.params2Arr[3] = i;
            } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_COMET) {
                RightControllerModel.this.params2Arr[4] = i;
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$30 */
    class AnonymousClass30 implements ShortVideoCountDownView.OnCountDownListener {
        AnonymousClass30() {
        }

        @Override // com.ipotensic.kernel.view.ShortVideoCountDownView.OnCountDownListener
        public void onCounting(int i) {
            RightControllerModel.this.setBtnCaptureMode(CaptureUIType.CAPTURE_UI_CANCEL_COUNTDOWN);
            if (i == 3) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_THREE);
            } else if (i == 2) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_TWO);
            } else if (i == 1) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.COUNTDOWN_ONE);
            }
        }

        @Override // com.ipotensic.kernel.view.ShortVideoCountDownView.OnCountDownListener
        public void onCountDownEnd() {
            int i = 0;
            RightControllerModel.this.isCountStart.set(false);
            if (RightControllerModel.this.checkStateIsReadyWhenGo()) {
                RightControllerModel.this.rightControllerListener.playSound(SoundPoolPlayer.SHORT_VIDEO_GO);
                if (RightControllerModel.this.isFollowMode()) {
                    int i2 = RightControllerModel.this.params2Arr[5];
                    int i3 = i2 == 3 ? 255 : i2;
                    if (i2 == 0) {
                        RightControllerModel.this.followRecordTime = 60000L;
                    } else if (i2 == 1) {
                        RightControllerModel.this.followRecordTime = 180000L;
                    } else if (i2 == 2) {
                        RightControllerModel.this.followRecordTime = DefaultDrmSessionManager.DEFAULT_SESSION_KEEPALIVE_MS;
                    } else if (i2 == 3) {
                        RightControllerModel.this.followRecordTime = -1L;
                    }
                    RightControllerModel.this.sendGoExecuteCMD(VisionExecuteType.TYPE_VISION_FOLLOW, 0, i3);
                    return;
                }
                boolean z = RightControllerModel.this.isParams1Select.get();
                if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_RECESS) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_RECESS[RightControllerModel.this.params2Arr[0]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SKYWARD) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_SKYWARD[RightControllerModel.this.params2Arr[1]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_CIRCLE) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[2]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_SCREW) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[3]];
                } else if (RightControllerModel.this.videoType.get() == VisionExecuteType.TYPE_COMET) {
                    i = RightControllerModel.this.SHORT_VIDEO_PARAMS_REPEAT[RightControllerModel.this.params2Arr[4]];
                }
                RightControllerModel rightControllerModel = RightControllerModel.this;
                rightControllerModel.sendGoExecuteCMD(rightControllerModel.videoType.get(), z ? 1 : 0, i);
                return;
            }
            RightControllerModel.this.cancelSelectTarget(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.30.1
                @Override // com.ipotensic.baselib.listener.OnSuccessListener
                public void onResult(boolean z2) {
                }

                AnonymousClass1() {
                }
            });
        }

        /* renamed from: com.ipotensic.kernel.model.RightControllerModel$30$1 */
        class AnonymousClass1 implements OnSuccessListener {
            @Override // com.ipotensic.baselib.listener.OnSuccessListener
            public void onResult(boolean z2) {
            }

            AnonymousClass1() {
            }
        }
    }

    private int getExecuteType() {
        try {
            if (isFollowMode()) {
                return VisionExecuteType.TYPE_VISION_FOLLOW.value;
            }
            return this.videoType.get().value;
        } catch (Exception unused) {
            return VisionExecuteType.TYPE_RECESS.value;
        }
    }

    public boolean isAllowClick() {
        if (System.currentTimeMillis() - this.lastClickTime < 300) {
            return false;
        }
        this.lastClickTime = System.currentTimeMillis();
        return true;
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$31 */
    class AnonymousClass31 implements Runnable {
        AnonymousClass31() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isCameraConnected.get()) {
                RightControllerModel.this.isSwitchingMode.set(false);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$32 */
    class AnonymousClass32 implements Runnable {
        AnonymousClass32() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isCameraConnected.get()) {
                RightControllerModel.this.isVideoTypeVisible.set(false);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$33 */
    class AnonymousClass33 implements Runnable {
        AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RightControllerModel.this.isTakingPhoto.get()) {
                RightControllerModel.this.isTakingPhoto.set(false);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$34 */
    class AnonymousClass34 implements Runnable {
        AnonymousClass34() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RightControllerModel.this.isPressRemoterKey.set(false);
        }
    }

    public boolean checkStateIsReady() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (!flightRevStateData.isFlight()) {
            this.rightControllerListener.onToast(R.string.txt_short_video_not_fly_tips);
            return false;
        }
        if (flightRevStateData.getMode() != 2) {
            this.rightControllerListener.onToast(R.string.txt_short_video_not_gps_mode);
            return false;
        }
        if (flightRevStateData.isFollowing() || flightRevStateData.isPointFly() || flightRevStateData.isHotCircle() || flightRevStateData.isReturning() || flightRevStateData.isLanding()) {
            this.rightControllerListener.onToast(R.string.txt_short_video_intelligent_flight);
            return false;
        }
        if (flightRevStateData.isPlaneExceedLimitDistance() || flightRevStateData.isPlaneExceedLimitHigh()) {
            this.rightControllerListener.onToast(R.string.txt_short_video_flight_arrive_fence);
            return false;
        }
        if (FlightRevData.get().getFlightRevStateData().getPowerMode() == 1 || FlightRevData.get().getFlightRevStateData().getPowerMode() == 2) {
            this.rightControllerListener.onToast(R.string.txt_short_video_flight_low_power);
            return false;
        }
        if (!FlightRevData.get().getFlightRevStateData().isAllowShortVideo()) {
            this.rightControllerListener.onToast(R.string.quickshots_poor_gps_signal_unable_to_activate_tips);
            return false;
        }
        SdCardState sdCardState = CameraConfig.get().sdCardState;
        if (sdCardState == SdCardState.SD_CARD_NOT_EXIST) {
            this.rightControllerListener.onToast(R.string.txt_short_video_no_sd_card);
            return false;
        }
        if (sdCardState == SdCardState.SD_CARD_NEED_FORMAT) {
            this.rightControllerListener.onToast(R.string.txt_short_video_pls_format_sd_card);
            return false;
        }
        if (sdCardState == SdCardState.SD_CARD_NOT_ENOUGH_SPACE) {
            this.rightControllerListener.onToast(R.string.txt_short_video_sd_card_full);
            return false;
        }
        if (CameraConfig.get().isAllowCaptureInHighTemp()) {
            return true;
        }
        this.rightControllerListener.onToast(R.string.txt_short_video_high_temp);
        return false;
    }

    private boolean checkGimbalStates() {
        short error_status = FlightRevData.get().getGimbalStateData().getError_status();
        if (error_status == 1 || error_status == 2) {
            this.rightControllerListener.onToast(R.string.txt_error_gimbal_error);
            return false;
        }
        if (error_status == 4) {
            this.rightControllerListener.onToast(R.string.warning_flight_interface_the_gimbal_is_stuck_detailed_tips);
            return false;
        }
        if (error_status != 5) {
            return true;
        }
        this.rightControllerListener.onToast(R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips);
        return false;
    }

    public boolean checkStateIsReadyWhenGo() {
        TrackTarget trackTarget = this.trackTarget;
        if (trackTarget != null && !trackTarget.isSelected()) {
            this.rightControllerListener.onToast(R.string.txt_short_video_lost_target);
            return false;
        }
        VisionError checkConditionError = Conditions.checkConditionError(getExecuteType());
        if (checkConditionError != null) {
            if (checkConditionError == VisionError.ERROR_GIMBAL_TOO_SMOOTH || checkConditionError == VisionError.ERROR_GIMBAL_ANGLE_TOO_BIG) {
                this.rightControllerListener.showExecuteFailedDialog(isFollowMode());
            } else {
                onTrackError(checkConditionError);
            }
            return false;
        }
        return checkStateIsReady();
    }

    public boolean isFollowMode() {
        return this.isTrackFunctionOpen.get() && this.btnGalleryMode.get() == GalleryUIType.UI_TYPE_FOLLOW_ENABLE.ordinal();
    }

    public void checkEffectViewShow() {
        this.isEffectViewShow.set(this.isTrackFunctionOpen.get() && (!this.isExecuting.get() || (this.isExecuting.get() && isFollowMode())) && isVideoMode());
    }

    public void checkSelectTargetShow() {
        this.isSelectTargetTipsViewShow.set(this.isTrackFunctionOpen.get() && !this.isTrackingTarget.get() && isVideoMode() && !this.isExecuting.get());
    }

    public void onDestroy() {
        stopCustomTimer();
    }

    public void sendOpenTrackCMD() {
        CameraCtrlPresenter.getInstance().setTrackTarget(true);
    }

    public void sendCloseTrackCMD() {
        CameraCtrlPresenter.getInstance().setTrackTarget(false);
    }

    public void sendGoExecuteCMD(VisionExecuteType visionExecuteType, int i, int i2) {
        if (this.trackTarget.isSelected()) {
            DDLog.e("\u4e00\u952e\u77ed\u7247\u53d1\u9001go\u6307\u4ee4");
            this.currentExecuteType = visionExecuteType;
            this.currentParams1 = i;
            this.currentParams2 = i2;
            CameraCtrlPresenter.getInstance().executeShortVideo(visionExecuteType, i, i2);
        }
    }

    public void sendStopExecuteCMD() {
        if (FlightRevData.get().getFlightRevStateData().isFlightExecutingShortVideo()) {
            CameraCtrlPresenter.getInstance().executeShortVideo(VisionExecuteType.TYPE_EXIT, 0, 0);
        }
    }

    public void sendStopExecuteToFlightCtrl() {
        DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_VISION);
        DDLog.e("\u53d1\u9001\u505c\u6b62\u4e00\u952e\u77ed\u7247\u6307\u4ee4\u7ed9\u98de\u63a7:" + ParseUtil.byteToHexString(FlightSendData.get().getSendCtrlData().getBytes()));
    }

    public void cancelSelectTarget(OnSuccessListener onSuccessListener) {
        TrackTarget trackTarget = this.trackTarget;
        if (trackTarget == null || !trackTarget.isSelected() || this.trackTarget.getBboxes().size() < 1) {
            if (onSuccessListener != null) {
                onSuccessListener.onResult(true);
            }
        } else {
            this.onCancelSelectResultListener = onSuccessListener;
            TrackTarget.Box m24clone = this.trackTarget.getBboxes().get(0).m24clone();
            m24clone.setBbox_id(-1);
            m24clone.setClass_id(-1);
            CameraCtrlPresenter.getInstance().selectTarget(m24clone);
            sendStopCmdToFlightIfAtomV2(new OnSuccessListener() { // from class: com.ipotensic.kernel.model.RightControllerModel.35
                @Override // com.ipotensic.baselib.listener.OnSuccessListener
                public void onResult(boolean z) {
                }

                AnonymousClass35() {
                }
            });
        }
    }

    /* renamed from: com.ipotensic.kernel.model.RightControllerModel$35 */
    class AnonymousClass35 implements OnSuccessListener {
        @Override // com.ipotensic.baselib.listener.OnSuccessListener
        public void onResult(boolean z) {
        }

        AnonymousClass35() {
        }
    }

    public void sendStopCmdToFlightIfAtomV2(OnSuccessListener onSuccessListener) {
        if (FlightConfig.curFlight == Flight.Flight_ATOM_V2) {
            FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
            if (flightRevStateData.isLanding() || flightRevStateData.isReturning() || !flightRevStateData.isFlightExecutingShortVideo()) {
                return;
            }
            this.onFlightStopTrackResultListener = onSuccessListener;
            sendStopExecuteToFlightCtrl();
        }
    }

    public void sendSetStableMode() {
        FlightRevGimbalSettingData gimbalSettingData = FlightRevData.get().getGimbalSettingData();
        if (gimbalSettingData == null || !gimbalSettingData.isInit()) {
            return;
        }
        FlightSendData.get().getSendGimbalSettingData().init(0, (short) gimbalSettingData.getPitchSpeed(), true, gimbalSettingData.getFpvSmooth(), 0, gimbalSettingData.getTuningRoll(), gimbalSettingData.getTuningYaw(), 0);
        DataManager.getInstance().sendGimbalSettingData();
    }
}