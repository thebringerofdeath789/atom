package com.ipotensic.kernel.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CalRockerView;
import com.logan.flight.DataManager;
import com.logan.flight.data.recv.FlightRevRemoterCalibrationData;

/* loaded from: classes2.dex */
public class RemoterCalActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private ImageView imgLeftWheel;
    private ImageView imgRightWheel;
    private ImageView imgWheelSegment;
    private ConstraintLayout layoutStep1;
    private ConstraintLayout layoutStep2;
    private CalRockerView leftRockerView;
    private FlightRevRemoterCalibrationData remoterCalibrationData;
    private CalRockerView rightRockerView;
    private TextView tvRockerTips;
    private TextView tvWheelTips;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        setContentView(R.layout.activity_remoter_calibration);
        this.leftRockerView = (CalRockerView) findViewById(R.id.cal_rocker_view_left);
        this.rightRockerView = (CalRockerView) findViewById(R.id.cal_rocker_view_right);
        this.tvRockerTips = (TextView) findViewById(R.id.tv_rocker_tips);
        this.tvWheelTips = (TextView) findViewById(R.id.tv_wheel_tips);
        this.imgWheelSegment = (ImageView) findViewById(R.id.img_wheel_segment);
        this.imgLeftWheel = (ImageView) findViewById(R.id.img_left_wheel);
        this.imgRightWheel = (ImageView) findViewById(R.id.img_right_wheel);
        this.layoutStep1 = (ConstraintLayout) findViewById(R.id.layout_cal_step1);
        this.layoutStep2 = (ConstraintLayout) findViewById(R.id.layout_cal_step2);
        this.leftRockerView.setLeftRocker(true);
        this.rightRockerView.setLeftRocker(false);
        findViewById(R.id.btn_start_cal).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.RemoterCalActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                DataManager.getInstance().openRemoterCalibration();
                RemoterCalActivity.this.showLoadingDialog();
            }
        });
        findViewById(R.id.iv_close).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.activitys.RemoterCalActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                RemoterCalActivity.this.quitAndExitActivity();
            }
        });
    }

    private void setAlpha(boolean z) {
        this.leftRockerView.setGray(z);
        this.rightRockerView.setGray(z);
        this.tvRockerTips.setAlpha(z ? 0.2f : 1.0f);
        this.tvWheelTips.setAlpha(z ? 0.2f : 1.0f);
        this.imgWheelSegment.setAlpha(z ? 0.2f : 1.0f);
    }

    private void setWheelState(FlightRevRemoterCalibrationData flightRevRemoterCalibrationData) {
        this.imgLeftWheel.setImageResource(flightRevRemoterCalibrationData.isLeftTrackWheelCalSuccess() ? R.mipmap.img_bg_track_wheel_left_enable : R.mipmap.img_bg_track_wheel_left_disable);
        this.imgRightWheel.setImageResource(flightRevRemoterCalibrationData.isRightTrackWheelCalSuccess() ? R.mipmap.img_bg_track_wheel_right_enable : R.mipmap.img_bg_track_wheel_right_disable);
    }

    /* renamed from: com.ipotensic.kernel.activitys.RemoterCalActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_CALIBRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData;
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData2;
        int i = AnonymousClass5.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            DDLog.e("遥控器校准结果: 飞机断开");
            quitAndExitActivity();
            return;
        }
        if (i != 2) {
            return;
        }
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData3 = (FlightRevRemoterCalibrationData) event.obj;
        if (flightRevRemoterCalibrationData3 != null) {
            DDLog.e("遥控器校准结果:" + flightRevRemoterCalibrationData3.toString());
            if (flightRevRemoterCalibrationData3.isStep2() && flightRevRemoterCalibrationData3.isRockerMove()) {
                setAlpha(true);
            }
            this.leftRockerView.setProgress(flightRevRemoterCalibrationData3);
            this.rightRockerView.setProgress(flightRevRemoterCalibrationData3);
            setWheelState(flightRevRemoterCalibrationData3);
            if (flightRevRemoterCalibrationData3.isStep2()) {
                dismissLoadingDialog();
                if (this.layoutStep2.getVisibility() != 0) {
                    this.layoutStep1.setVisibility(8);
                    this.layoutStep2.setVisibility(0);
                }
            }
            if (flightRevRemoterCalibrationData3.isStep0() && flightRevRemoterCalibrationData3.isCalSuccess() && ((flightRevRemoterCalibrationData2 = this.remoterCalibrationData) == null || !flightRevRemoterCalibrationData2.isCalSuccess())) {
                ToastUtil.showImageTop(this, getString(R.string.txt_remoter_calibration_success), R.mipmap.icon_toast_successful);
                PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.RemoterCalActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoterCalActivity.this.quitAndExitActivity();
                    }
                }, 1500L);
            }
            if (flightRevRemoterCalibrationData3.isCalFailed() && ((flightRevRemoterCalibrationData = this.remoterCalibrationData) == null || !flightRevRemoterCalibrationData.isCalFailed())) {
                DDLog.e("指南针校准  失败");
                ToastUtil.showImageTop(this, getString(R.string.txt_remoter_calibration_failed), R.mipmap.icon_calibration_fail);
                PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.activitys.RemoterCalActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoterCalActivity.this.quitAndExitActivity();
                    }
                }, 1500L);
            }
        }
        try {
            this.remoterCalibrationData = flightRevRemoterCalibrationData3.m28clone();
        } catch (Exception e) {
            DDLog.e("赋值失败:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitAndExitActivity() {
        DataManager.getInstance().closeRemoterCalibration();
        finish();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
