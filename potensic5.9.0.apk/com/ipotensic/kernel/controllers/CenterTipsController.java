package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class CenterTipsController extends BaseController {
    private ImageView ivTipIcon;
    private RelativeLayout layoutTipsView;
    private TextView tvTipTitle;

    public CenterTipsController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.layoutTipsView = (RelativeLayout) view.findViewById(C1965R.id.layout_center_tips);
        this.tvTipTitle = (TextView) view.findViewById(C1965R.id.tv_dialog_title);
        this.ivTipIcon = (ImageView) view.findViewById(C1965R.id.iv_icon);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (ScreenUtils.getScreenWidth((Activity) getContext()) * 0.4f);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        this.layoutTipsView.setLayoutParams(layoutParams);
    }

    private void show() {
        if (this.layoutTipsView.getVisibility() != 0) {
            this.layoutTipsView.setScaleX(0.0f);
            this.layoutTipsView.setScaleY(0.0f);
            this.layoutTipsView.setVisibility(0);
            this.layoutTipsView.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setDuration(400L).withEndAction(new Runnable() { // from class: com.ipotensic.kernel.controllers.CenterTipsController.1
                @Override // java.lang.Runnable
                public void run() {
                    CenterTipsController.this.layoutTipsView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.ipotensic.kernel.controllers.CenterTipsController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    }).start();
                }
            }).start();
        }
    }

    public void setBatteryFailTip(FlightRevStateData flightRevStateData) {
        if (this.layoutTipsView == null || BaseSyncDialog.isShow) {
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (FlightConfig.isOldProduct() && flightRevStateData.isReturnCountdown()) {
            this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
            this.tvTipTitle.setText(getContext().getString(C1965R.string.low_power_return_soon));
            show();
            z = true;
        }
        if (FlightConfig.isP1ProBattery() || !FlightConfig.isOldProduct()) {
            if (!flightRevStateData.isFlight()) {
                if (flightRevStateData.isIs1BatteryDamaged() || flightRevStateData.isIs2BatteryDamaged() || flightRevStateData.isBatteryJump() || flightRevStateData.isBatteryDiffPressure() || flightRevStateData.isBatteryBelowSevenPercent() || flightRevStateData.isBatteryAbnormalAlarm() || flightRevStateData.isBatteryJumpAbnormal() || flightRevStateData.isBatteryFullAbnormalAlarm()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_take_off);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.new_battery_fail_not_takeoff));
                    show();
                }
                z2 = z;
            } else {
                if (flightRevStateData.isIs1BatteryDamaged() || flightRevStateData.isIs2BatteryDamaged() || flightRevStateData.isBatteryBelowSevenPercent()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_take_landing);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.new_battery_fail_in_land));
                    show();
                    z = true;
                }
                if (flightRevStateData.isBatteryDiffPressure() || flightRevStateData.isBatteryAbnormalAlarm() || flightRevStateData.isBatteryJumpAbnormal() || flightRevStateData.isBatteryFullAbnormalAlarm()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.new_battery_fail_go_home));
                    show();
                    z = true;
                }
                if (flightRevStateData.isBatteryJump()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_jump));
                    show();
                    z = true;
                }
                if (flightRevStateData.isBatteryTempLow() || flightRevStateData.isBatteryTempHigh()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.img_battery_fail);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.new_battery_temp_fail_fly_careful));
                    show();
                }
                z2 = z;
            }
        } else if (!flightRevStateData.isFlight()) {
            if (flightRevStateData.isBatteryHighPress() && !flightRevStateData.isNewBattery()) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.icon_take_off);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.error_battery_no_takeoff_fault));
                show();
                z = true;
            }
            if (flightRevStateData.isNewBattery() && (flightRevStateData.isIs1BatteryDamaged() || flightRevStateData.isIs2BatteryDamaged())) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.img_battery_fail);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_in_land));
                show();
                z = true;
            }
            if (flightRevStateData.isBatteryDiffPressure()) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.icon_take_off);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.error_battery_no_takeoff_fault));
                show();
                z = true;
            }
            if (flightRevStateData.isBatteryAbnormalAlarm()) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.icon_take_off);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_capacity_abnormal_takeoff));
                show();
            }
            z2 = z;
        } else {
            if (flightRevStateData.isBatteryHighPress() && !flightRevStateData.isNewBattery()) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_1_pice));
                show();
                z = true;
            }
            if (flightRevStateData.isNewBattery()) {
                if (flightRevStateData.isIs1BatteryDamaged()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_1_pice));
                    show();
                    z = true;
                }
                if (flightRevStateData.isIs2BatteryDamaged()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.img_battery_fail_return);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_2_pice));
                    show();
                    z = true;
                }
                if (flightRevStateData.isBatteryJump() || flightRevStateData.isBatteryDiffPressure()) {
                    this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                    this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_fail_jump));
                    show();
                    z = true;
                }
            }
            if (flightRevStateData.isBatteryAbnormalAlarm()) {
                this.ivTipIcon.setImageResource(C1965R.mipmap.icon_go_home);
                this.tvTipTitle.setText(getContext().getString(C1965R.string.battery_capacity_abnormal_go_home));
                show();
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        dismiss();
    }

    public void dismiss() {
        RelativeLayout relativeLayout = this.layoutTipsView;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.layoutTipsView.setVisibility(8);
    }

    /* renamed from: com.ipotensic.kernel.controllers.CenterTipsController$2 */
    static /* synthetic */ class C21262 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C21262.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            setBatteryFailTip((FlightRevStateData) event.obj);
        } else {
            if (((Boolean) event.obj).booleanValue()) {
                return;
            }
            dismiss();
        }
    }
}