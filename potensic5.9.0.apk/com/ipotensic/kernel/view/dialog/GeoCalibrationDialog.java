package com.ipotensic.kernel.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.calibration.AtomMagCalibrationHelper;
import com.logan.flight.calibration.IMagCalibrationHelper;
import com.logan.flight.calibration.MiniMagCalibrationHelper;
import com.logan.flight.calibration.OnCalibrationResultListener;
import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.type.Flight;
import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes2.dex */
public class GeoCalibrationDialog extends BaseSyncDialog implements View.OnClickListener, EventDispatcher.OnEventListener {
    public static boolean neverShow = false;
    private Button btnStart;
    private Context context;
    private GeneralDialog failedDialog;
    private AnimationDrawable horizontalDrawable;
    private boolean isCalibrating;
    private boolean isGeoFault;
    private boolean isGeoHorizontalComplete;
    private boolean isGeoVerticalComplete;
    private ImageView ivCancel;
    private ImageView ivHorizontal;
    private ImageView ivVertical;
    private StartCalibrationListener listener;
    private View llHorizontal;
    private View llVertical;
    private IMagCalibrationHelper miniMagCalibrationHelper;
    private GeoCalResultDialog resultDialog;
    private TextView tvContentOne;
    private TextView tvContentTwo;
    private TextView tvGeoCalibrationTitle;
    private TextView tvMiniGeoTips;
    private AnimationDrawable verticalDrawable;

    public interface StartCalibrationListener {
        void start();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public void showResultDialog(MagCalibrationResult magCalibrationResult) {
    }

    public GeoCalibrationDialog(Context context, StartCalibrationListener startCalibrationListener) {
        super(context, C1965R.layout.view_dialog_geo_calibration);
        this.isGeoVerticalComplete = false;
        this.isGeoHorizontalComplete = false;
        this.isGeoFault = false;
        this.isCalibrating = false;
        this.resultDialog = null;
        this.listener = startCalibrationListener;
        this.context = context;
        setDialogSize();
    }

    private void setDialogSize() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        if (getContext().getResources().getConfiguration().orientation == 2) {
            attributes.width = (int) (ScreenUtils.getScreenWidth(this.context) * 0.45d);
            attributes.height = -2;
        } else {
            attributes.width = (int) (ScreenUtils.getScreenHeight(this.context) * 0.45d);
            attributes.height = (int) (ScreenUtils.getScreenWidth(this.context) * 0.7d);
        }
        window.setAttributes(attributes);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        setDialogSize();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.context = context;
        this.tvGeoCalibrationTitle = (TextView) findViewById(C1965R.id.tv_geo_calibration);
        this.ivHorizontal = (ImageView) findViewById(C1965R.id.img_geo_horizontal);
        this.ivVertical = (ImageView) findViewById(C1965R.id.img_geo_vertical);
        Button button = (Button) findViewById(C1965R.id.btn_start);
        this.btnStart = button;
        button.setOnClickListener(this);
        this.tvContentOne = (TextView) findViewById(C1965R.id.tv_content_one);
        this.tvContentTwo = (TextView) findViewById(C1965R.id.tv_content_two);
        this.llHorizontal = findViewById(C1965R.id.ll_horizontal);
        this.llVertical = findViewById(C1965R.id.ll_vertical);
        this.tvMiniGeoTips = (TextView) findViewById(C1965R.id.tv_mini_geo_tips);
        ImageView imageView = (ImageView) findViewById(C1965R.id.iv_cancel);
        this.ivCancel = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeoCalibrationDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeoCalibrationDialog.neverShow = true;
                GeoCalibrationDialog.this.dismiss();
                if (!FlightConfig.is_Atom_Series() || GeoCalibrationDialog.this.miniMagCalibrationHelper == null) {
                    return;
                }
                GeoCalibrationDialog.this.miniMagCalibrationHelper.release();
                GeoCalibrationDialog.this.miniMagCalibrationHelper.setCalibrationResultListener(null);
                GeoCalibrationDialog.this.miniMagCalibrationHelper = null;
            }
        });
        this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
        this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
        Flight lastFlight = FlightConfig.getLastFlight();
        if (lastFlight != null) {
            this.llHorizontal.setVisibility(0);
            this.llVertical.setVisibility(0);
            this.tvMiniGeoTips.setVisibility(8);
            if (lastFlight == Flight.Flight_P3SE || lastFlight == Flight.Flight_P3SE_V0) {
                this.ivHorizontal.setImageResource(C1965R.drawable.anim_geo_horizontal_p3se);
                this.ivVertical.setImageResource(C1965R.drawable.anim_geo_vertical_p3se);
                this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
                this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
                return;
            }
            if (FlightConfig.is_Atom_Series()) {
                if (FlightConfig.isAtomPanTilt()) {
                    this.ivHorizontal.setImageResource(C1965R.drawable.anim_geo_horizontal_atom);
                    this.ivVertical.setImageResource(C1965R.drawable.anim_geo_vertical_atom);
                } else {
                    this.ivHorizontal.setImageResource(C1965R.drawable.anim_geo_horizontal_mini);
                    this.ivVertical.setImageResource(C1965R.drawable.anim_geo_vertical_mini);
                }
                this.ivHorizontal.setBackgroundResource(C1965R.mipmap.img_mini_calibration_bg);
                this.ivVertical.setBackgroundResource(C1965R.mipmap.img_mini_calibration_bg);
                this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
                this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
                this.llHorizontal.setVisibility(8);
                this.llVertical.setVisibility(8);
                this.tvMiniGeoTips.setVisibility(0);
                this.tvMiniGeoTips.setText(getContext().getString(C1965R.string.setting_mini_geo_tip));
                return;
            }
            if (lastFlight == Flight.Flight_P5) {
                this.ivHorizontal.setImageResource(C1965R.drawable.anim_geo_horizontal_p5se);
                this.ivVertical.setImageResource(C1965R.drawable.anim_geo_vertical_p5se);
                this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
                this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
                this.llHorizontal.setVisibility(8);
                this.llVertical.setVisibility(8);
                this.tvMiniGeoTips.setVisibility(0);
                this.tvMiniGeoTips.setText(getContext().getString(C1965R.string.compass_calibration_tips));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1965R.id.btn_start) {
            if (FlightConfig.is_Atom_Series()) {
                if (Conditions.isNewMagCalSystem()) {
                    this.miniMagCalibrationHelper = new AtomMagCalibrationHelper();
                } else {
                    this.miniMagCalibrationHelper = new MiniMagCalibrationHelper();
                }
                this.miniMagCalibrationHelper.setCalibrationResultListener(new OnCalibrationResultListener() { // from class: com.ipotensic.kernel.view.dialog.GeoCalibrationDialog.2
                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onHorizontalCalibration() {
                        DDLog.m1684e("水平校准");
                        GeoCalibrationDialog.this.isCalibrating = true;
                        if (GeoCalibrationDialog.this.horizontalDrawable.isRunning()) {
                            return;
                        }
                        if (!GeoCalibrationDialog.this.isGeoHorizontalComplete) {
                            EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                        }
                        GeoCalibrationDialog.this.tvGeoCalibrationTitle.setText(GeoCalibrationDialog.this.getContext().getString(C1965R.string.dialog_geo_title_horizontal));
                        GeoCalibrationDialog.this.horizontalDrawable.start();
                        GeoCalibrationDialog.this.isGeoHorizontalComplete = true;
                        GeoCalibrationDialog.this.llHorizontal.setVisibility(0);
                        GeoCalibrationDialog.this.btnStart.setVisibility(8);
                        GeoCalibrationDialog.this.llVertical.setVisibility(8);
                        GeoCalibrationDialog.this.tvContentOne.setText(GeoCalibrationDialog.this.getContext().getString(C1965R.string.dialog_geo_horizontal_tips));
                        GeoCalibrationDialog.this.tvMiniGeoTips.setVisibility(8);
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onVerticalCalibration() {
                        DDLog.m1684e("垂直校准");
                        GeoCalibrationDialog.this.isCalibrating = true;
                        if (GeoCalibrationDialog.this.verticalDrawable.isRunning()) {
                            return;
                        }
                        DDLog.m1684e("垂直校准1");
                        if (!GeoCalibrationDialog.this.isGeoVerticalComplete) {
                            EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
                        }
                        GeoCalibrationDialog.this.tvGeoCalibrationTitle.setText(GeoCalibrationDialog.this.getContext().getString(C1965R.string.dialog_geo_title_vertical));
                        GeoCalibrationDialog.this.horizontalDrawable.stop();
                        GeoCalibrationDialog.this.verticalDrawable.start();
                        GeoCalibrationDialog.this.isGeoVerticalComplete = true;
                        GeoCalibrationDialog.this.ivHorizontal.setVisibility(8);
                        GeoCalibrationDialog.this.ivVertical.setVisibility(0);
                        GeoCalibrationDialog.this.llHorizontal.setVisibility(8);
                        GeoCalibrationDialog.this.llVertical.setVisibility(0);
                        GeoCalibrationDialog.this.tvContentTwo.setText(GeoCalibrationDialog.this.getContext().getString(C1965R.string.dialog_geo_vertical_tips));
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onRequestTimeout() {
                        GeoCalibrationDialog.this.isCalibrating = false;
                        GeoCalibrationDialog.this.onCalibrateResult(2);
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onResultSuccess(MagCalibrationResult magCalibrationResult) {
                        GeoCalibrationDialog.this.isCalibrating = false;
                        ToastUtil.showImageTop((Activity) GeoCalibrationDialog.this.context, GeoCalibrationDialog.this.context.getString(C1965R.string.toast_geo_calibration_finish), C1965R.mipmap.icon_toast_successful);
                        EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
                        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.GeoCalibrationDialog.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    GeoCalibrationDialog.this.reset();
                                    GeoCalibrationDialog.this.dismiss();
                                } catch (Exception e) {
                                    DDLog.m1684e("校准弹窗失败:" + e);
                                }
                            }
                        }, 1000L);
                        GeoCalibrationDialog.this.showResultDialog(magCalibrationResult);
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onResultFailed(MagCalibrationResult magCalibrationResult) {
                        GeoCalibrationDialog.this.isCalibrating = false;
                        GeoCalibrationDialog.this.onCalibrateResult(1);
                        GeoCalibrationDialog.this.showResultDialog(magCalibrationResult);
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onResultTimeout(MagCalibrationResult magCalibrationResult) {
                        GeoCalibrationDialog.this.isCalibrating = false;
                        GeoCalibrationDialog.this.onCalibrateResult(1);
                        GeoCalibrationDialog.this.showResultDialog(magCalibrationResult);
                    }

                    @Override // com.logan.flight.calibration.OnCalibrationResultListener
                    public void onRelease() {
                        GeoCalibrationDialog.this.isCalibrating = false;
                    }
                });
                this.miniMagCalibrationHelper.start();
                return;
            }
            this.listener.start();
        }
    }

    public void dismissResultDialog() {
        GeoCalResultDialog geoCalResultDialog = this.resultDialog;
        if (geoCalResultDialog == null || !geoCalResultDialog.isShowing()) {
            return;
        }
        this.resultDialog.dismiss();
        this.resultDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCalibrateResult(final int i) {
        reset();
        EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$GeoCalibrationDialog$neglmjUT02-KJ1F7Z24zAKDZguI
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GeoCalibrationDialog.this.lambda$onCalibrateResult$0$GeoCalibrationDialog(i, dialogInterface);
            }
        });
        dismiss();
    }

    public /* synthetic */ void lambda$onCalibrateResult$0$GeoCalibrationDialog(int i, DialogInterface dialogInterface) {
        setOnDismissListener(null);
        DDLog.m1684e("校准失败1 type=" + i);
        String string = this.context.getString(C1965R.string.f2141x7cdd925c);
        if (i == 2) {
            string = this.context.getString(C1965R.string.calibration_failed_tips_remote_controller_signal_weak);
        }
        String str = string;
        if (this.failedDialog == null) {
            Context context = this.context;
            this.failedDialog = new GeneralDialog(context, context.getString(C1965R.string.sys_calibration_geomagnetic), str, this.context.getString(C1965R.string.dialog_cancel), this.context.getString(C1965R.string.dialog_ok), false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.GeoCalibrationDialog.3
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }
            });
        }
        this.failedDialog.show();
    }

    public void setUpdateData(FlightRevStateData flightRevStateData) {
        if (FlightConfig.is_Atom_Series()) {
            return;
        }
        if (flightRevStateData.isGeomagneticFault()) {
            if (this.isGeoFault || !BaseSyncDialog.isShow) {
                return;
            }
            this.isGeoFault = true;
            ToastUtil.toast((Activity) this.context, getContext().getString(C1965R.string.error_geo_fault));
            reset();
            dismiss();
            return;
        }
        this.isGeoFault = false;
        if (flightRevStateData.isMagnetometerHorizontalCalibrating()) {
            if (!this.horizontalDrawable.isRunning()) {
                if (!this.isGeoHorizontalComplete) {
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                }
                this.tvGeoCalibrationTitle.setText(getContext().getString(C1965R.string.dialog_geo_title_horizontal));
                this.horizontalDrawable.start();
                this.isGeoHorizontalComplete = true;
                this.llHorizontal.setVisibility(0);
                this.btnStart.setVisibility(8);
                this.llVertical.setVisibility(8);
                this.tvContentOne.setText(getContext().getString(C1965R.string.dialog_geo_horizontal_tips));
                this.tvMiniGeoTips.setVisibility(8);
            }
        } else if (this.isGeoHorizontalComplete && flightRevStateData.isGeoCalibrationFailureFlag()) {
            calibrateFail();
        }
        if (flightRevStateData.isMagnetometerVerticalCalibrating()) {
            if (this.verticalDrawable.isRunning()) {
                return;
            }
            if (!this.isGeoVerticalComplete) {
                EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
            }
            this.tvGeoCalibrationTitle.setText(getContext().getString(C1965R.string.dialog_geo_title_vertical));
            this.horizontalDrawable.stop();
            this.verticalDrawable.start();
            this.isGeoVerticalComplete = true;
            this.ivHorizontal.setVisibility(8);
            this.ivVertical.setVisibility(0);
            this.llHorizontal.setVisibility(8);
            this.llVertical.setVisibility(0);
            this.tvContentTwo.setText(getContext().getString(C1965R.string.dialog_geo_vertical_tips));
            return;
        }
        if (this.isGeoVerticalComplete && flightRevStateData.isGeoCalibrationFailureFlag()) {
            calibrateFail();
        } else if (this.isGeoVerticalComplete) {
            reset();
            dismiss();
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
            ToastUtil.showImageTop((Activity) this.context, getContext().getString(C1965R.string.toast_geo_calibration_finish), C1965R.mipmap.icon_toast_successful);
        }
    }

    private void calibrateFail() {
        reset();
        dismiss();
        EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        DDLog.m1684e("校准结果:MagCalibrationResult reset:");
        setDialogSize();
        this.isGeoHorizontalComplete = false;
        this.isGeoVerticalComplete = false;
        this.tvGeoCalibrationTitle.setText(getContext().getString(C1965R.string.sys_calibration_geomagnetic));
        this.horizontalDrawable.stop();
        this.verticalDrawable.stop();
        this.btnStart.setVisibility(0);
        this.ivHorizontal.setVisibility(0);
        this.ivVertical.setVisibility(8);
        this.tvContentOne.setText(getContext().getString(C1965R.string.dialog_geo_calibration_tips_one));
        this.tvContentTwo.setText(getContext().getString(C1965R.string.dialog_geo_calibration_tips_two));
        Flight lastFlight = FlightConfig.getLastFlight();
        if (lastFlight != null) {
            if (FlightConfig.is_Atom_Series() || lastFlight == Flight.Flight_P5) {
                this.llVertical.setVisibility(8);
                this.llHorizontal.setVisibility(8);
                this.tvMiniGeoTips.setVisibility(0);
            } else {
                this.llHorizontal.setVisibility(0);
                this.llVertical.setVisibility(0);
                this.tvMiniGeoTips.setVisibility(8);
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        if (!neverShow) {
            DDLog.m1684e("校准11111");
            super.show();
        }
        GeneralDialog generalDialog = this.failedDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.failedDialog.dismiss();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        IMagCalibrationHelper iMagCalibrationHelper;
        super.onStop();
        if (!FlightConfig.is_Atom_Series() || (iMagCalibrationHelper = this.miniMagCalibrationHelper) == null) {
            return;
        }
        iMagCalibrationHelper.release();
        this.miniMagCalibrationHelper.setCalibrationResultListener(null);
        this.miniMagCalibrationHelper = null;
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        IMagCalibrationHelper iMagCalibrationHelper;
        if (FlightConfig.is_Atom_Series() && isShowing()) {
            int i = C26024.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
            if (i == 1) {
                FlightRevGeoTestData flightRevGeoTestData = (FlightRevGeoTestData) event.obj;
                IMagCalibrationHelper iMagCalibrationHelper2 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper2 == null || !iMagCalibrationHelper2.isStart()) {
                    return;
                }
                this.miniMagCalibrationHelper.calibration(flightRevGeoTestData);
                return;
            }
            if (i == 2) {
                FlightRevCalResultData flightRevCalResultData = (FlightRevCalResultData) event.obj;
                IMagCalibrationHelper iMagCalibrationHelper3 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper3 != null) {
                    iMagCalibrationHelper3.revData(flightRevCalResultData);
                    DDLog.m1684e("校准结果的结果1:" + flightRevCalResultData.toString());
                    return;
                }
                return;
            }
            if (i == 3) {
                if (((Boolean) event.obj).booleanValue()) {
                    return;
                }
                dismiss();
                IMagCalibrationHelper iMagCalibrationHelper4 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper4 != null) {
                    iMagCalibrationHelper4.release();
                    this.miniMagCalibrationHelper.setCalibrationResultListener(null);
                    this.miniMagCalibrationHelper = null;
                    return;
                }
                return;
            }
            if (i != 4) {
                if (i == 5 && (iMagCalibrationHelper = this.miniMagCalibrationHelper) != null) {
                    iMagCalibrationHelper.revData((FlightRevMagCalibrationResultData) event.obj);
                    return;
                }
                return;
            }
            IMagCalibrationHelper iMagCalibrationHelper5 = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper5 != null) {
                iMagCalibrationHelper5.revData((FlightRevFlightCtrlToAppNormal) event.obj);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.GeoCalibrationDialog$4 */
    static /* synthetic */ class C26024 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GEO_CALIBRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_CALIBRATION_RESULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_FLIGHT_CTRL_TO_APP_NORMAL_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MAG_CALIBRATION_RESULT_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        dismissResultDialog();
    }
}