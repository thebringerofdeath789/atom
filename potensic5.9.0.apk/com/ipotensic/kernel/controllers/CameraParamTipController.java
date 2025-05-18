package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.common.collect.Lists;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.listener.AnimationListenerAdapter;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.CameraSetController;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.HorizontalWheelView;
import com.ipotensic.kernel.view.ResolutionAndFpsSelectView;
import com.logan.camera.CameraConfig;
import com.logan.camera.data.CameraSupport;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.enums.SdCardState;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import java.util.HashSet;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class CameraParamTipController extends BaseController {
    private static final String NOT_APPLICABLE = "N/A";
    private static final String TAG = "CameraParamTipController";
    private static final int TIME_BACKGROUND_DISMISS = 3000;
    private CameraSetController.CameraControllerListener cameraSetListener;
    private final Runnable dismissBackgroundRunnable;
    private AlphaAnimation enterAnimation;

    /* renamed from: ev */
    private double f2186ev;
    private final Handler handler;
    private int highTempMark;
    private Boolean isStart;
    private boolean isTimeTaking;
    private boolean isTimedMode;
    private ImageView ivEvIcon;
    private ImageView ivHighTemp;
    private ImageView ivSd;
    private ImageView ivSplitIsoSs;
    private ImageView ivSplitLineEv;
    private ImageView ivSplitSsWb;
    private LinearLayout llWvEvItemWrapper;
    private ManualSettingItemClickListener manualSettingItemClickListener;
    private AlphaAnimation outerAnimation;
    private String resolution;
    private ResolutionAndFpsSelectView resolutionAndFpsSelectView;
    private RelativeLayout rlFirst;
    private final Runnable runnable;
    private String sdSpaceSizes;
    private int showToastTag;
    private StrokeTextView tvEvValue;
    private StrokeTextView tvIsoValue;
    private StrokeTextView tvResolution;
    private StrokeTextView tvSdValue;
    private StrokeTextView tvSsValue;
    private StrokeTextView tvWhiteBalanceValue;
    private HorizontalWheelView wvEvItem;

    public interface ManualSettingItemClickListener {
        void onAdvancedItemClick();

        void onGeneralItemClick();
    }

    public CameraParamTipController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.highTempMark = -1;
        this.handler = new Handler(Looper.getMainLooper());
        this.isStart = null;
        this.dismissBackgroundRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$CameraParamTipController$nnWFz0TDTnQdrGnMtR6ScengMtg
            @Override // java.lang.Runnable
            public final void run() {
                CameraParamTipController.this.lambda$new$1$CameraParamTipController();
            }
        };
        this.runnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.9
            @Override // java.lang.Runnable
            public void run() {
                if (CameraParamTipController.this.isStart != null) {
                    if (CameraParamTipController.this.isStart.booleanValue()) {
                        CameraParamTipController cameraParamTipController = CameraParamTipController.this;
                        cameraParamTipController.alphaIn(cameraParamTipController.ivHighTemp);
                    } else {
                        CameraParamTipController cameraParamTipController2 = CameraParamTipController.this;
                        cameraParamTipController2.alphaOut(cameraParamTipController2.ivHighTemp);
                    }
                    CameraParamTipController.this.isStart = Boolean.valueOf(!r0.isStart.booleanValue());
                    CameraParamTipController.this.handler.postDelayed(CameraParamTipController.this.runnable, 1000L);
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        findAllChildView();
        this.tvResolution.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.1
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view2) {
                if (CameraParamTipController.this.hasViewBeenClicked(view2)) {
                    if (!CameraConfig.get().isPhotoMode() || FlightConfig.isAtomLT()) {
                        return;
                    }
                    CameraParamTipController.this.cameraSetListener.onSetRaw(true ^ CameraConfig.get().isRaw());
                    return;
                }
                CameraParamTipController cameraParamTipController = CameraParamTipController.this;
                cameraParamTipController.setFirstTextGreenOthersGray(cameraParamTipController.tvResolution, CameraParamTipController.this.tvSdValue, CameraParamTipController.this.tvEvValue);
                CameraParamTipController.this.tvResolution.setText(CameraParamTipController.this.resolution);
                CameraParamTipController.this.dismissEvScrollView();
                if (CameraConfig.get().isRecodeMode()) {
                    CameraParamTipController.this.resolutionAndFpsSelectView.showResolutionAndFpsScrollView(CameraParamTipController.this.getSupportResolutionAndFps(), CameraParamTipController.this.getWheelViewSize(), CameraParamTipController.this.resolution);
                }
            }
        });
        this.tvEvValue.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.2
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view2) {
                if (CameraParamTipController.this.hasViewBeenClicked(view2)) {
                    return;
                }
                CameraParamTipController cameraParamTipController = CameraParamTipController.this;
                cameraParamTipController.setFirstTextGreenOthersGray(cameraParamTipController.tvEvValue, CameraParamTipController.this.tvSdValue, CameraParamTipController.this.tvResolution);
                CameraParamTipController.this.dismissResolutionAndFpsScrollView();
                CameraParamTipController.this.showEvScrollView();
            }
        });
        this.tvSdValue.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.3
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view2) {
                if (CameraParamTipController.this.hasViewBeenClicked(view2)) {
                    if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST) {
                        return;
                    }
                    boolean isCurrentShowSdCapacity = CameraParamTipController.this.isCurrentShowSdCapacity();
                    StrokeTextView strokeTextView = CameraParamTipController.this.tvSdValue;
                    CameraParamTipController cameraParamTipController = CameraParamTipController.this;
                    strokeTextView.setText(isCurrentShowSdCapacity ? cameraParamTipController.getPhotoOrVideoCapacity() : cameraParamTipController.getSdCapacity());
                    CameraParamTipController.this.setShowSdCapacity(!isCurrentShowSdCapacity);
                    return;
                }
                CameraParamTipController cameraParamTipController2 = CameraParamTipController.this;
                cameraParamTipController2.setFirstTextGreenOthersGray(cameraParamTipController2.tvSdValue, CameraParamTipController.this.tvEvValue, CameraParamTipController.this.tvResolution);
                CameraParamTipController.this.dismissEvScrollView();
                CameraParamTipController.this.dismissResolutionAndFpsScrollView();
            }
        });
        this.wvEvItem.setOnWheelViewListener(new OnWheelScrolledListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.4
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (CameraParamTipController.this.noViewClicked()) {
                    return;
                }
                CaptureMode captureMode = CameraConfig.get().getCaptureMode();
                try {
                    double parseDouble = Double.parseDouble(str);
                    if (captureMode == CaptureMode.MODE_PHOTO) {
                        CameraParamTipController.this.cameraSetListener.onSetPhotoEv(parseDouble);
                    } else {
                        CameraParamTipController.this.cameraSetListener.onSetVideoEv(parseDouble);
                    }
                } catch (Exception e) {
                    DDLog.m1686e(CameraParamTipController.TAG, "设置ev值转换成double出错", e);
                    ToastUtil.toast(CameraParamTipController.this.getContext(), CameraParamTipController.this.getContext().getString(C1965R.string.dialog_failure));
                }
            }
        });
        this.resolutionAndFpsSelectView.setOnWheelViewListener(new OnWheelScrolledListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.5
            @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
            public void onSelected(int i, String str) {
                if (CameraParamTipController.this.noViewClicked()) {
                    return;
                }
                CameraParamTipController.this.sendSetVideoSizeByResolutionFps(str);
            }
        });
        setManualParamClickListener();
    }

    public void updateResolutionAndFp() {
        StrokeTextView strokeTextView = this.tvResolution;
        if (strokeTextView == null || strokeTextView.getVisibility() != 0) {
            return;
        }
        this.tvResolution.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$CameraParamTipController$BtGpKo9AYqrvz1YGZ1h1UhaJQ0M
            @Override // java.lang.Runnable
            public final void run() {
                CameraParamTipController.this.lambda$updateResolutionAndFp$0$CameraParamTipController();
            }
        }, 10L);
    }

    public /* synthetic */ void lambda$updateResolutionAndFp$0$CameraParamTipController() {
        this.resolutionAndFpsSelectView.updateFpsWheelView(getWheelViewSize());
    }

    private void setManualParamClickListener() {
        this.tvWhiteBalanceValue.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.6
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view) {
            }
        });
        this.tvSsValue.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.7
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view) {
            }
        });
        this.tvIsoValue.setOnClickListener(new OnValidClickListener() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.8
            @Override // com.ipotensic.kernel.controllers.CameraParamTipController.OnValidClickListener
            void onValidClick(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWheelViewSize() {
        return (this.rlFirst.getWidth() - this.rlFirst.getPaddingStart()) - this.rlFirst.getPaddingEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSetVideoSizeByResolutionFps(String str) {
        int sendValueOfResolutionFps = getSendValueOfResolutionFps(str);
        if (Conditions.isRecording()) {
            return;
        }
        this.cameraSetListener.onSetVideoSize(null, sendValueOfResolutionFps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, HashSet<String>> getSupportResolutionAndFps() {
        return CameraConfig.get().supportVideoSizes.getSupportResolutionAndFps();
    }

    public void setCameraControllerListener(CameraSetController.CameraControllerListener cameraControllerListener) {
        this.cameraSetListener = cameraControllerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEvScrollView() {
        this.wvEvItem.setItems(getWheelViewSize(), Lists.newArrayList("-2.0", "-1.5", "-1.0", "-0.5", "0.0", "+0.5", "+1.0", "+1.5", "+2.0"), getEvDefaultSelectValue());
        this.llWvEvItemWrapper.setVisibility(0);
        this.ivSplitLineEv.setVisibility(0);
    }

    private int getEvDefaultSelectValue() {
        return (int) ((this.f2186ev * 2.0d) + 4.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissEvScrollView() {
        this.llWvEvItemWrapper.setVisibility(8);
        this.ivSplitLineEv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissResolutionAndFpsScrollView() {
        this.resolutionAndFpsSelectView.dismiss();
    }

    private void findAllChildView() {
        this.rlFirst = (RelativeLayout) findView(C1965R.id.rl_first);
        this.tvEvValue = (StrokeTextView) findView(C1965R.id.tv_ev_value);
        this.tvSdValue = (StrokeTextView) findView(C1965R.id.tv_sd_remain_time);
        this.tvResolution = (StrokeTextView) findView(C1965R.id.tv_resolution_or_format);
        this.ivSd = (ImageView) findView(C1965R.id.iv_sd);
        this.wvEvItem = (HorizontalWheelView) findView(C1965R.id.wv_ev_item);
        this.ivSplitLineEv = (ImageView) findView(C1965R.id.iv_split_line_ev);
        this.llWvEvItemWrapper = (LinearLayout) findView(C1965R.id.ll_wv_et_item_wrapper);
        this.ivEvIcon = (ImageView) findView(C1965R.id.iv_ev_icon);
        this.tvWhiteBalanceValue = (StrokeTextView) findView(C1965R.id.tv_white_balance_value);
        this.tvSsValue = (StrokeTextView) findView(C1965R.id.tv_ss_value);
        this.tvIsoValue = (StrokeTextView) findView(C1965R.id.tv_iso_value);
        this.ivSplitSsWb = (ImageView) findView(C1965R.id.iv_split_ss_wb);
        this.ivSplitIsoSs = (ImageView) findView(C1965R.id.iv_split_iso_ss);
        this.ivHighTemp = (ImageView) findView(C1965R.id.iv_high_temp);
        LinearLayout linearLayout = (LinearLayout) findView(C1965R.id.ll_wv_resolution_item_wrapper);
        LinearLayout linearLayout2 = (LinearLayout) findView(C1965R.id.ll_wv_fps_item_wrapper);
        HorizontalWheelView horizontalWheelView = (HorizontalWheelView) findView(C1965R.id.wv_resolution_item);
        HorizontalWheelView horizontalWheelView2 = (HorizontalWheelView) findView(C1965R.id.wv_fps_item);
        this.resolutionAndFpsSelectView = new ResolutionAndFpsSelectView(linearLayout, linearLayout2, (ImageView) findView(C1965R.id.view_resolution_fps_split), this.ivSplitLineEv, horizontalWheelView, horizontalWheelView2);
        horizontalWheelView.setControlFrequency(true);
        horizontalWheelView2.setControlFrequency(true);
    }

    private <T extends View> T findView(int i) {
        return (T) getBaseView().findViewById(i);
    }

    public void update() {
        String currentValue;
        DDLog.m1684e("录像/拍照模式1 = " + CameraConfig.get().getCaptureMode());
        if (CameraConfig.get().getCaptureMode() != null) {
            CaptureMode captureMode = CameraConfig.get().getCaptureMode();
            DDLog.m1684e("录像/拍照模式2 = " + captureMode);
            if (captureMode == CaptureMode.MODE_REC) {
                String currentValue2 = CameraConfig.get().supportVideoSizes.getCurrentValue();
                this.resolution = getValidDataOrNA(currentValue2);
                DDLog.m1684e("分辨率 rec_res:" + currentValue2 + ", resolution:" + this.resolution);
                this.f2186ev = CameraConfig.get().getRecordEV();
                DDLog.m1684e("ev ev:" + this.f2186ev);
            } else if (captureMode == CaptureMode.MODE_PHOTO) {
                if (FlightConfig.is_Atom_Series()) {
                    currentValue = (!CameraConfig.get().isRaw() || FlightConfig.isAtomLT()) ? "JPG" : "RAW+JPG";
                } else {
                    currentValue = CameraConfig.get().supportPhotoSizes.getCurrentValue();
                }
                this.resolution = getValidDataOrNA(currentValue);
                DDLog.m1684e("分辨率 rec_res:" + currentValue + ", resolution:" + this.resolution);
                this.f2186ev = CameraConfig.get().getPhotoEV();
                DDLog.m1684e("ev ev1:" + this.f2186ev);
            }
            DDLog.m1684e("录像/拍照 卡状态 = " + CameraConfig.get().sdCardState);
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST) {
                this.sdSpaceSizes = NOT_APPLICABLE;
            } else if ((CameraConfig.get().isATOMSECamera() || FlightConfig.isAtomLT()) && !isCurrentShowSdCapacity()) {
                this.sdSpaceSizes = getPhotoOrVideoCapacity();
            } else {
                this.sdSpaceSizes = getSdCapacity();
            }
            if (isManualMode()) {
                showManualData();
            }
            DDLog.m1684e("刷新参数1");
            setAllValidData();
            this.ivSd.setImageResource(C1965R.mipmap.img_sd);
            this.ivEvIcon.setImageResource(C1965R.mipmap.icon_er);
            return;
        }
        DDLog.m1684e("刷新参数2");
        setAllNotApplicableData();
        this.ivSd.setImageResource(C1965R.mipmap.img_sd_dis);
        this.ivEvIcon.setImageResource(C1965R.mipmap.icon_er_dis);
    }

    public void updateManualSettingValue() {
        showManualData();
    }

    public void setEv(String str) {
        StrokeTextView strokeTextView = this.tvEvValue;
        if (strokeTextView != null) {
            setTextWhite(strokeTextView, str);
        }
    }

    public void setEvPosition(int i) {
        double d = (i - 4) / 2.0f;
        this.f2186ev = d;
        setEv(getShowEvValue(d));
        this.wvEvItem.refreshItemView(i);
        this.wvEvItem.setSelection(i);
    }

    private void showManualData() {
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        if (manualModeInfo == null) {
            return;
        }
        int i = manualModeInfo.isoValue;
        if (i != 0) {
            setTextWhite(this.tvIsoValue, "ISO " + i);
        }
        int i2 = manualModeInfo.ssUp;
        int i3 = manualModeInfo.ssDown;
        if (i2 != 0 && i3 != 0) {
            setTextWhite(this.tvSsValue, "SS " + i2 + InternalZipConstants.ZIP_FILE_SEPARATOR + i3);
        }
        int i4 = manualModeInfo.wbValue;
        if (i4 != 0) {
            setTextWhite(this.tvWhiteBalanceValue, "WB " + i4 + "K");
        }
    }

    private String getValidDataOrNA(String str) {
        return TextUtils.isEmpty(str) ? NOT_APPLICABLE : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSdCapacity() {
        long sdFreeSpace = CameraConfig.get().getSdFreeSpace();
        long sdTotalSpace = CameraConfig.get().getSdTotalSpace();
        if (sdTotalSpace == 0) {
            return getContext().getString(C1965R.string.n_a);
        }
        return FormatUtil.getSdCardSpaceRatio(sdFreeSpace, sdTotalSpace);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPhotoOrVideoCapacity() {
        if (!CameraConfig.get().isGetConfigMenu) {
            return getContext().getString(C1965R.string.n_a);
        }
        if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_PHOTO) {
            DDLog.m1691w("拍照 剩余拍照数 = " + CameraConfig.get().getRecordRemain());
            return CameraConfig.get().getPhotoRemain() + " P";
        }
        DDLog.m1691w("录像 剩余录像时间 = " + CameraConfig.get().getRecordRemain());
        return FormatUtil.secondToHHmmss(CameraConfig.get().getRecordRemain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentShowSdCapacity() {
        return SPHelper.getInstance().showSdCapacity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowSdCapacity(boolean z) {
        SPHelper.getInstance().setCurrentShowSdCapacity(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirstTextGreenOthersGray(TextView... textViewArr) {
        for (int i = 0; i < textViewArr.length; i++) {
            if (i == 0) {
                setTextGreen(textViewArr[i]);
            } else {
                setTextGray(textViewArr[i]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGrayBackgroundInFixedTime() {
        dismissBackgroundInFixedTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasViewBeenClicked(View view) {
        return isTextGreen((TextView) view);
    }

    public /* synthetic */ void lambda$new$1$CameraParamTipController() {
        this.rlFirst.setBackground(null);
        dismissEvScrollView();
        dismissResolutionAndFpsScrollView();
        update();
    }

    public void dismissBackgroundImmediately() {
        if (noViewClicked()) {
            return;
        }
        PhoneConfig.mainHandler.removeCallbacks(this.dismissBackgroundRunnable);
        this.dismissBackgroundRunnable.run();
    }

    private void dismissBackgroundInFixedTime() {
        PhoneConfig.mainHandler.removeCallbacks(this.dismissBackgroundRunnable);
        PhoneConfig.mainHandler.postDelayed(this.dismissBackgroundRunnable, 3000L);
    }

    private void setAllNotApplicableData() {
        DDLog.m1684e("刷新参数5: ");
        setTextGray(this.tvResolution);
        this.tvResolution.setText(NOT_APPLICABLE);
        setTextGray(this.tvEvValue, NOT_APPLICABLE);
        setTextGray(this.tvSdValue, NOT_APPLICABLE);
        setTextGray(this.tvIsoValue, "ISO N/A");
        setTextGray(this.tvSsValue, "SS N/A");
        setTextGray(this.tvWhiteBalanceValue, "WB N/A");
    }

    private void setTextGray(TextView textView, String str) {
        textView.setText(str);
        setTextGray(textView);
    }

    public void controlPhotoFormatView(boolean z) {
        this.isTimedMode = z;
        this.tvResolution.setEnabled(true);
        if (!this.isTimeTaking && z && CameraConfig.get().isPhotoMode()) {
            setTextGray(this.tvResolution);
            this.tvResolution.setEnabled(false);
        } else if (CameraConfig.get().getCaptureMode() != null) {
            setTextWhite(this.tvResolution);
        }
    }

    public void setIsTimeTaking(boolean z) {
        this.isTimeTaking = z;
        if (z) {
            setTextWhite(this.tvResolution);
            this.rlFirst.setAlpha(0.5f);
            this.tvWhiteBalanceValue.setAlpha(0.5f);
            this.tvSsValue.setAlpha(0.5f);
            this.tvIsoValue.setAlpha(0.5f);
            return;
        }
        this.rlFirst.setAlpha(1.0f);
        this.tvWhiteBalanceValue.setAlpha(1.0f);
        this.tvSsValue.setAlpha(1.0f);
        this.tvIsoValue.setAlpha(1.0f);
        controlPhotoFormatView(this.isTimedMode);
    }

    private void setTextGray(TextView textView) {
        textView.setTextColor(getContext().getColor(C1965R.color.color_gray));
    }

    private void setAllValidData() {
        if (noViewClicked()) {
            DDLog.m1684e("刷新参数3aaa：" + this.resolution);
            controlPhotoFormatView(this.isTimedMode);
            this.tvResolution.setText(this.resolution);
            if (!CameraConfig.get().isManualMode()) {
                setTextWhite(this.tvEvValue, getShowEvValue(this.f2186ev));
            }
            setTextWhite(this.tvSdValue, this.sdSpaceSizes);
            return;
        }
        DDLog.m1684e("刷新参数4aaa: " + this.resolution);
        this.tvResolution.setText(this.resolution);
        if (!CameraConfig.get().isManualMode()) {
            this.tvEvValue.setText(getShowEvValue(this.f2186ev));
        }
        this.tvSdValue.setText(this.sdSpaceSizes);
    }

    private String getShowEvValue(double d) {
        if (d < 0.0d) {
            return String.valueOf(d);
        }
        if (d > 0.0d) {
            return "+" + d;
        }
        return StringUtils.SPACE + d;
    }

    public boolean noViewClicked() {
        return this.rlFirst.getBackground() == null;
    }

    private void setTextWhite(TextView textView, String str) {
        textView.setText(str);
        setTextWhite(textView);
    }

    private void setTextWhite(TextView textView) {
        textView.setTextColor(getContext().getColor(C1965R.color.colorWhite));
    }

    private void setTextGreen(TextView textView) {
        textView.setTextColor(getGreenColor());
    }

    private boolean isTextGreen(TextView textView) {
        return textView.getCurrentTextColor() == getGreenColor();
    }

    private int getGreenColor() {
        return getContext().getColor(C1965R.color.text_color_camera_param_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFlightAndCameraAvailable() {
        return FlightConfig.isConnectFlight() && CameraConfig.get().getCaptureMode() != null;
    }

    private int getSendValueOfResolutionFps(String str) {
        return CameraSupport.getSendValueFromResolutionFps(str);
    }

    public void showManualParam() {
        ViewUtils.show(this.tvIsoValue, this.tvWhiteBalanceValue, this.tvSsValue, this.ivSplitIsoSs, this.ivSplitSsWb);
    }

    public void hideManualParam() {
        ViewUtils.dismiss(this.tvIsoValue, this.tvWhiteBalanceValue, this.tvSsValue, this.ivSplitIsoSs, this.ivSplitSsWb);
    }

    public boolean isManualMode() {
        return this.tvIsoValue.getVisibility() == 0;
    }

    public void setManualSettingItemClickListener(ManualSettingItemClickListener manualSettingItemClickListener) {
        this.manualSettingItemClickListener = manualSettingItemClickListener;
    }

    private abstract class OnValidClickListener implements View.OnClickListener {
        abstract void onValidClick(View view);

        private OnValidClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraParamTipController.this.isTimeTaking || !CameraParamTipController.this.isFlightAndCameraAvailable() || isRecordingOrTakingPhoto() || !FlightConfig.is_Atom_Series() || Conditions.isTrackTargetOpen()) {
                return;
            }
            if (CameraConfig.get().getManualModeInfo() == null || !CameraConfig.get().getManualModeInfo().isManualMode) {
                CameraParamTipController.this.rlFirst.setBackgroundResource(C1965R.drawable.bg_camera_param_tips);
                onValidClick(view);
                CameraParamTipController.this.showGrayBackgroundInFixedTime();
                return;
            }
            int id = view.getId();
            if (id == C1965R.id.tv_ev_value || id == C1965R.id.tv_sd_remain_time || id == C1965R.id.tv_resolution_or_format) {
                CameraParamTipController.this.manualSettingItemClickListener.onGeneralItemClick();
            } else {
                CameraParamTipController.this.manualSettingItemClickListener.onAdvancedItemClick();
            }
        }

        private boolean isRecordingOrTakingPhoto() {
            RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
            if (rightController == null) {
                return false;
            }
            return rightController.isRecording() || rightController.isTakingPhoto();
        }
    }

    public abstract class OnWheelScrolledListener implements HorizontalWheelView.OnWheelViewListener {
        public OnWheelScrolledListener() {
        }

        @Override // com.ipotensic.kernel.view.HorizontalWheelView.OnWheelViewListener
        public void onTouch() {
            CameraParamTipController.this.showGrayBackgroundInFixedTime();
        }
    }

    private synchronized void show(int i) {
        if (PhoneConfig.isKernelActivityPause) {
            remove();
            return;
        }
        if (i == -1) {
            remove();
        } else if (i == 0) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag == 0) {
                this.showToastTag = 1;
                ToastUtil.toast(getContext(), getContext().getString(C1965R.string.tips_cam_temperature_too_high));
            }
        } else if (i == 1) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag < 2) {
                this.showToastTag = 2;
                ToastUtil.toast((Activity) getContext(), getContext().getString(C1965R.string.tips_cam_stop_record), getContext().getResources().getColor(C1965R.color.text_mini_geo_color));
            }
        } else if (i == 2) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag < 3) {
                this.showToastTag = 3;
                ToastUtil.toast((Activity) getContext(), getContext().getString(C1965R.string.tips_flight_auto_shut_down), getContext().getResources().getColor(C1965R.color.toast_red));
            }
        }
    }

    public void remove() {
        if (this.isStart != null) {
            this.isStart = null;
            this.showToastTag = 0;
            this.handler.removeCallbacks(this.runnable);
            alphaOut(this.ivHighTemp);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (eventID == EventID.EVENT_CAMERA_HIGH_TEMP) {
            this.highTempMark = event.arg1;
            if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                remove();
            } else {
                DDLog.m1684e("相机温度：highTempMark = " + this.highTempMark + ", isCaptureEnable = " + CameraConfig.get().isAllowCaptureInHighTemp() + ", 温度：" + event.arg2);
                show(this.highTempMark);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alphaIn(final View view) {
        if (this.enterAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.enterAnimation = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.enterAnimation.setInterpolator(new DecelerateInterpolator());
        }
        view.startAnimation(this.enterAnimation);
        this.enterAnimation.setAnimationListener(new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.10
            @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                view.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alphaOut(final View view) {
        if (this.outerAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.outerAnimation = alphaAnimation;
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            this.outerAnimation.setDuration(200L);
        }
        view.startAnimation(this.outerAnimation);
        this.outerAnimation.setAnimationListener(new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.CameraParamTipController.11
            @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                view.setVisibility(4);
            }
        });
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }
}