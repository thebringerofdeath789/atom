package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.LogUtil;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ImageGridViewAdapter;
import com.ipotensic.kernel.view.ExpandableView;
import com.ipotensic.kernel.view.ExposureLevelView;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.data.CameraSupport;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.enums.SdCardState;
import com.logan.flight.FlightConfig;
import com.logan.flight.type.Flight;

/* loaded from: classes2.dex */
public class CameraSetController extends BaseController implements View.OnClickListener {
    private ConstraintLayout clPhotoResolution;
    private Context context;
    private ExposureLevelView exposureLevelView;
    private long firstClickTime;
    private GeneralDialog formatDialog;
    private boolean isInit;
    private boolean isPhotoSizeSetting;
    private boolean isVideoSegmentSetting;
    private boolean isVideoSizeSetting;
    private ExpandableView layoutPhotosSizes;
    private ExpandableView layoutVideoSegment;
    private ExpandableView layoutVideoSizes;
    private View lineFormat;
    private View linePhotoResolution;
    private View linePhotoSizes;
    private View lineVideoSegment;
    private View lineVideoSizes;
    private View lineWaterMark;
    private CameraControllerListener listener;
    private ImageGridViewAdapter photoSizeAdapter;
    ExposureLevelView.IChangeProgressListener progressListener;
    private GridView qulityGridView;
    private GridView ratioGridView;
    private ImageGridViewAdapter recordSizeAdapter;
    private SwitchButton slideBtnGrid;
    private SwitchButton slideBtnWaterMark;
    private TextView tvJpg;
    private TextView tvRaw;
    private ImageGridViewAdapter videoSegmentAdapter;
    private GridView videoSegmentView;
    private View viewBlank;
    private View viewFormat;
    private View viewWaterMark;

    public interface CameraControllerListener {
        void isShowGridLine(boolean z);

        void onFormatSdClicked();

        void onSetPhotoEv(double d);

        void onSetPhotoSize(String str, int i);

        void onSetPhotoWatermark(boolean z);

        void onSetRaw(boolean z);

        void onSetVideoEv(double d);

        void onSetVideoSegment(String str, int i);

        void onSetVideoSize(String str, int i);
    }

    public CameraSetController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.isInit = false;
        this.firstClickTime = 0L;
        this.progressListener = new ExposureLevelView.IChangeProgressListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.6
            @Override // com.ipotensic.kernel.view.ExposureLevelView.IChangeProgressListener
            public void ChangeProgress(float f) {
                DDLog.e("相机 progress:" + f);
                if (CameraConfig.get().getCaptureMode() != null) {
                    if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_REC) {
                        if (CameraSetController.this.listener != null) {
                            double d = f;
                            if (CameraConfig.get().getRecordEV() == d) {
                                return;
                            }
                            CameraSetController.this.listener.onSetVideoEv(d);
                            return;
                        }
                        return;
                    }
                    if (CameraSetController.this.listener != null) {
                        double d2 = f;
                        if (CameraConfig.get().getPhotoEV() == d2) {
                            return;
                        }
                        CameraSetController.this.listener.onSetPhotoEv(d2);
                    }
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.context = view.getContext();
        view.findViewById(R.id.iv_right_bg).setOnClickListener(this);
        View findViewById = view.findViewById(R.id.view_blank);
        this.viewBlank = findViewById;
        findViewById.setOnClickListener(this);
        SwitchButton switchButton = (SwitchButton) view.findViewById(R.id.slideBtn_grid);
        this.slideBtnGrid = switchButton;
        switchButton.setChecked(SPHelper.getInstance().isPreviewShowLine());
        this.slideBtnGrid.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.1
            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onDisableClick() {
            }

            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onStateChanged(View view2, boolean z) {
                SPHelper.getInstance().setPreviewShowLine(z);
                CameraSetController.this.listener.isShowGridLine(z);
            }
        });
        ExposureLevelView exposureLevelView = new ExposureLevelView(view);
        this.exposureLevelView = exposureLevelView;
        exposureLevelView.setChangeProgressListener(this.progressListener);
        view.findViewById(R.id.tv_sd_format).setOnClickListener(this);
        this.videoSegmentView = (GridView) view.findViewById(R.id.gv_video);
        this.qulityGridView = (GridView) view.findViewById(R.id.gv_qulity);
        this.ratioGridView = (GridView) view.findViewById(R.id.gv_ratio);
        this.tvJpg = (TextView) view.findViewById(R.id.tv_jpg);
        this.tvRaw = (TextView) view.findViewById(R.id.tv_raw);
        int i = 1000;
        boolean z = false;
        this.tvJpg.setOnClickListener(new ScaleClickListener(i, z) { // from class: com.ipotensic.kernel.controllers.CameraSetController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (CameraConfig.get().isRaw()) {
                    CameraSetController.this.setPhotoFormat(false);
                    CameraSetController.this.listener.onSetRaw(false);
                }
            }
        });
        this.tvRaw.setOnClickListener(new ScaleClickListener(i, z) { // from class: com.ipotensic.kernel.controllers.CameraSetController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (CameraConfig.get().isRaw()) {
                    return;
                }
                CameraSetController.this.setPhotoFormat(true);
                CameraSetController.this.listener.onSetRaw(true);
            }
        });
        SwitchButton switchButton2 = (SwitchButton) view.findViewById(R.id.slideBtn_water_mark);
        this.slideBtnWaterMark = switchButton2;
        switchButton2.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.4
            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onDisableClick() {
            }

            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onStateChanged(View view2, boolean z2) {
                if (CameraSetController.this.firstClickTime > System.currentTimeMillis()) {
                    CameraSetController.this.firstClickTime = 0L;
                }
                if (System.currentTimeMillis() - CameraSetController.this.firstClickTime > SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                    CameraSetController.this.listener.onSetPhotoWatermark(z2);
                    CameraSetController.this.firstClickTime = System.currentTimeMillis();
                }
                CameraSetController.this.slideBtnWaterMark.setViewEnable(false);
                CameraSetController.this.slideBtnWaterMark.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.CameraSetController.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraSetController.this.slideBtnWaterMark.setViewEnable(true);
                    }
                }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        });
        this.lineWaterMark = view.findViewById(R.id.line_water_mark);
        this.viewWaterMark = view.findViewById(R.id.view_water_mark);
        this.lineFormat = view.findViewById(R.id.line_format);
        this.viewFormat = view.findViewById(R.id.view_format);
        this.linePhotoSizes = view.findViewById(R.id.line_photo_sizes);
        this.lineVideoSizes = view.findViewById(R.id.line_video_sizes);
        this.lineVideoSegment = view.findViewById(R.id.line_video_segment);
        this.layoutPhotosSizes = (ExpandableView) view.findViewById(R.id.layout_photo_sizes);
        this.layoutVideoSizes = (ExpandableView) view.findViewById(R.id.layout_video_sizes);
        this.layoutVideoSegment = (ExpandableView) view.findViewById(R.id.layout_video_segment);
        this.clPhotoResolution = (ConstraintLayout) view.findViewById(R.id.rl_photo_resolution);
        this.linePhotoResolution = view.findViewById(R.id.line_photo_resolution);
        this.isInit = true;
        onConfigMenu();
    }

    public void onSwitchMode(CaptureMode captureMode) {
        if (this.isInit) {
            if (captureMode == CaptureMode.MODE_REC) {
                this.layoutVideoSegment.setVisibility(0);
                this.lineVideoSegment.setVisibility(0);
                this.lineVideoSizes.setVisibility(0);
                this.layoutVideoSizes.setVisibility(0);
                this.linePhotoSizes.setVisibility(8);
                this.layoutPhotosSizes.setVisibility(8);
                ExposureLevelView exposureLevelView = this.exposureLevelView;
                if (exposureLevelView != null) {
                    exposureLevelView.uploadProgress(CameraConfig.get().getRecordEV());
                }
                setVideoSegmentSuccess();
                setRecordSizeSuccess();
                setTakePhotoSizeSuccess();
                this.slideBtnWaterMark.setChecked(CameraConfig.get().isVideoOsdShow());
                this.clPhotoResolution.setVisibility(8);
                this.linePhotoResolution.setVisibility(8);
            } else {
                this.clPhotoResolution.setVisibility(FlightConfig.getLastFlight() == Flight.Flight_P5 ? 0 : 8);
                this.linePhotoResolution.setVisibility(FlightConfig.getLastFlight() == Flight.Flight_P5 ? 0 : 8);
                this.layoutVideoSegment.setVisibility(8);
                this.lineVideoSegment.setVisibility(8);
                this.lineVideoSizes.setVisibility(8);
                this.layoutVideoSizes.setVisibility(8);
                this.linePhotoSizes.setVisibility((CameraConfig.get().isATOMSECamera() || FlightConfig.getLastFlight() == Flight.Flight_P5) ? 8 : 0);
                this.layoutPhotosSizes.setVisibility((CameraConfig.get().isATOMSECamera() || FlightConfig.getLastFlight() == Flight.Flight_P5) ? 8 : 0);
                ExposureLevelView exposureLevelView2 = this.exposureLevelView;
                if (exposureLevelView2 != null) {
                    exposureLevelView2.uploadProgress(CameraConfig.get().getPhotoEV());
                }
                if (CameraConfig.get().isATOMSECamera()) {
                    this.layoutPhotosSizes.setVisibility(8);
                    this.linePhotoSizes.setVisibility(8);
                    setPhotoFormat(CameraConfig.get().isRaw());
                }
            }
            boolean z = captureMode == CaptureMode.MODE_REC;
            this.lineWaterMark.setVisibility((CameraConfig.get().isATOMSECamera() && z) ? 0 : 8);
            this.viewWaterMark.setVisibility((CameraConfig.get().isATOMSECamera() && z) ? 0 : 8);
            this.lineFormat.setVisibility((!CameraConfig.get().isATOMSECamera() || z) ? 8 : 0);
            this.viewFormat.setVisibility((!CameraConfig.get().isATOMSECamera() || z) ? 8 : 0);
        }
    }

    public void closeSlideGridBtn() {
        this.slideBtnGrid.setChecked(false);
    }

    public void setPhotoFormat(boolean z) {
        int color;
        int color2;
        boolean z2 = !z;
        TextView textView = this.tvJpg;
        if (z2) {
            color = getContext().getResources().getColor(R.color.white);
        } else {
            color = getContext().getResources().getColor(R.color.color_white_seventy_percent);
        }
        textView.setTextColor(color);
        TextView textView2 = this.tvRaw;
        if (z2) {
            color2 = getContext().getResources().getColor(R.color.color_white_seventy_percent);
        } else {
            color2 = getContext().getResources().getColor(R.color.white);
        }
        textView2.setTextColor(color2);
        this.tvJpg.setBackgroundResource(z2 ? R.mipmap.img_format_switch_left_select : R.mipmap.img_format_switch_left);
        this.tvRaw.setBackgroundResource(z2 ? R.mipmap.img_format_switch_right : R.mipmap.img_format_switch_right_select);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        DDLog.e("更新:" + LogUtil.printMethodCaller());
        if (i == 0 || getBaseView() != null) {
            if (i == 0) {
                this.viewBlank.setVisibility(0);
                onSwitchMode(CameraConfig.get().getCaptureMode());
            } else if (i == 4) {
                this.isVideoSizeSetting = false;
                this.isPhotoSizeSetting = false;
                this.isVideoSegmentSetting = false;
            } else {
                this.isVideoSizeSetting = false;
                this.isPhotoSizeSetting = false;
                this.isVideoSegmentSetting = false;
                EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_SETTING_DISMISS);
            }
        }
    }

    public void setEV(double d) {
        ExposureLevelView exposureLevelView = this.exposureLevelView;
        if (exposureLevelView != null) {
            exposureLevelView.uploadProgress(d);
        }
    }

    public void sdCardPullOut() {
        GeneralDialog generalDialog = this.formatDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.formatDialog.dismiss();
        this.formatDialog = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.view_blank) {
            if (getBaseView().getVisibility() == 0) {
                this.viewBlank.setVisibility(4);
                setVisibility(8);
                EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_SETTING_DISMISS);
                return;
            }
            return;
        }
        if (id == R.id.tv_sd_format) {
            RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
            if (rightController == null || !rightController.isRecording()) {
                if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST) {
                    Context context = this.context;
                    ToastUtil.toast((Activity) context, context.getString(R.string.no_sd_card));
                    EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD_TIP);
                    return;
                } else {
                    Context context2 = this.context;
                    GeneralDialog generalDialog = new GeneralDialog(context2, context2.getResources().getString(R.string.dialog_sd_format), this.context.getResources().getString(R.string.dialog_sd_format_describe), (String) null, (String) null, false, 2, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.5
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                            RightController rightController2 = (RightController) EventDispatcher.get().getController(RightController.class);
                            if ((rightController2 == null || !rightController2.isRecording()) && CameraSetController.this.listener != null) {
                                CameraSetController.this.listener.onFormatSdClicked();
                            }
                        }
                    });
                    this.formatDialog = generalDialog;
                    generalDialog.show();
                    return;
                }
            }
            return;
        }
        int i = R.id.iv_right_bg;
    }

    public void setRecordSizeSuccess() {
        this.isVideoSizeSetting = false;
        ImageGridViewAdapter imageGridViewAdapter = this.recordSizeAdapter;
        if (imageGridViewAdapter != null) {
            imageGridViewAdapter.setCurIndex(CameraConfig.get().supportVideoSizes.getSupportList());
        }
    }

    public void setTakePhotoSizeSuccess() {
        this.isPhotoSizeSetting = false;
        ImageGridViewAdapter imageGridViewAdapter = this.photoSizeAdapter;
        if (imageGridViewAdapter != null) {
            imageGridViewAdapter.setCurIndex(CameraConfig.get().supportPhotoSizes.getSupportList());
        }
    }

    public void setVideoSegmentSuccess() {
        this.isVideoSegmentSetting = false;
        ImageGridViewAdapter imageGridViewAdapter = this.videoSegmentAdapter;
        if (imageGridViewAdapter != null) {
            imageGridViewAdapter.setCurIndex(CameraConfig.get().supportSplitSizes.getSupportList());
        }
    }

    public void setCameraControllerListener(CameraControllerListener cameraControllerListener) {
        this.listener = cameraControllerListener;
    }

    public void setRecordSizeFailed(String str) {
        this.isVideoSizeSetting = false;
    }

    public void setTakePhotoSizeFailed(String str) {
        this.isPhotoSizeSetting = false;
    }

    public void setVideoSegmentFailed(String str) {
        this.isVideoSegmentSetting = false;
    }

    public void setRecordEv() {
        ExposureLevelView exposureLevelView = this.exposureLevelView;
        if (exposureLevelView != null) {
            exposureLevelView.uploadProgress(CameraConfig.get().getRecordEV());
        }
    }

    public void setTakePhotoEv() {
        ExposureLevelView exposureLevelView = this.exposureLevelView;
        if (exposureLevelView != null) {
            exposureLevelView.uploadProgress(CameraConfig.get().getPhotoEV());
        }
    }

    public void onConfigMenu() {
        if (getContext() == null || !this.isInit) {
            return;
        }
        ImageGridViewAdapter imageGridViewAdapter = new ImageGridViewAdapter(getContext(), CameraSupport.SupportType.TYPE_PHOTO_SIZE, CameraConfig.get().supportPhotoSizes.getSupportList());
        this.photoSizeAdapter = imageGridViewAdapter;
        this.qulityGridView.setAdapter((ListAdapter) imageGridViewAdapter);
        this.photoSizeAdapter.setOnItemClickedListener(new ImageGridViewAdapter.OnItemClickedListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.7
            @Override // com.ipotensic.kernel.adapter.ImageGridViewAdapter.OnItemClickedListener
            public void onItemClicked(int i) {
                if (CameraSetController.this.listener == null || CameraSetController.this.isPhotoSizeSetting) {
                    return;
                }
                CameraSetController.this.isPhotoSizeSetting = true;
                CameraSetController.this.listener.onSetPhotoSize(CameraConfig.get().supportPhotoSizes.getSupportList().get(i).getRealValueForWifi(), CameraConfig.get().supportPhotoSizes.getSupportList().get(i).getRealValueForUsb());
            }
        });
        ImageGridViewAdapter imageGridViewAdapter2 = new ImageGridViewAdapter(getContext(), CameraSupport.SupportType.TYPE_SPLIT_VIDEO, CameraConfig.get().supportSplitSizes.getSupportList());
        this.videoSegmentAdapter = imageGridViewAdapter2;
        this.videoSegmentView.setAdapter((ListAdapter) imageGridViewAdapter2);
        this.videoSegmentAdapter.setOnItemClickedListener(new ImageGridViewAdapter.OnItemClickedListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.8
            @Override // com.ipotensic.kernel.adapter.ImageGridViewAdapter.OnItemClickedListener
            public void onItemClicked(int i) {
                if (CameraSetController.this.listener == null || CameraSetController.this.isVideoSegmentSetting) {
                    return;
                }
                CameraSetController.this.isVideoSegmentSetting = true;
                CameraSetController.this.listener.onSetVideoSegment(CameraConfig.get().supportSplitSizes.getSupportList().get(i).getRealValueForWifi(), CameraConfig.get().supportSplitSizes.getSupportList().get(i).getRealValueForUsb());
            }
        });
        ImageGridViewAdapter imageGridViewAdapter3 = new ImageGridViewAdapter(getContext(), CameraSupport.SupportType.TYPE_VIDEO_SIZE, CameraConfig.get().supportVideoSizes.getSupportList());
        this.recordSizeAdapter = imageGridViewAdapter3;
        this.ratioGridView.setAdapter((ListAdapter) imageGridViewAdapter3);
        this.recordSizeAdapter.setOnItemClickedListener(new ImageGridViewAdapter.OnItemClickedListener() { // from class: com.ipotensic.kernel.controllers.CameraSetController.9
            @Override // com.ipotensic.kernel.adapter.ImageGridViewAdapter.OnItemClickedListener
            public void onItemClicked(int i) {
                if (CameraSetController.this.listener == null || CameraSetController.this.isVideoSizeSetting) {
                    return;
                }
                CameraSetController.this.isVideoSizeSetting = true;
                try {
                    CameraSetController.this.listener.onSetVideoSize(CameraConfig.get().supportVideoSizes.getSupportList().get(i).getRealValueForWifi(), CameraConfig.get().supportVideoSizes.getSupportList().get(i).getRealValueForUsb());
                } catch (Exception e) {
                    DDLog.e("record size 出错:" + e.getMessage());
                }
            }
        });
    }
}
