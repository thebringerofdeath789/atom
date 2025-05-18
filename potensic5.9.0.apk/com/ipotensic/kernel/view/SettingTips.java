package com.ipotensic.kernel.view;

import android.app.Activity;
import android.os.Handler;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class SettingTips {
    private static volatile SettingTips instance;
    private boolean beyondLimitDistanceFail;
    private boolean beyondLimitHeightFail;
    private GeneralDialog dialog;
    private boolean heightLowFollowOpenFail;
    private boolean isFirstGetSettingData = false;
    private boolean newModeBeyondLimitDistance;
    private boolean newModeBeyondLimitHeight;
    private boolean speedModeNewModeFail;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private String text6;

    private SettingTips() {
    }

    public static SettingTips getInstance() {
        if (instance == null) {
            synchronized (SettingTips.class) {
                if (instance == null) {
                    instance = new SettingTips();
                }
            }
        }
        return instance;
    }

    public void tips(Activity activity, FlightRevStateData flightRevStateData, KernelViewModel kernelViewModel) {
        if (!this.isFirstGetSettingData) {
            this.isFirstGetSettingData = true;
            this.newModeBeyondLimitDistance = flightRevStateData.isNewModeBeyondLimitDistance();
            this.newModeBeyondLimitHeight = flightRevStateData.isNewModeBeyondLimitHeight();
            this.speedModeNewModeFail = flightRevStateData.isSpeedModeNewModeFail();
            this.beyondLimitDistanceFail = flightRevStateData.isBeyondLimitDistanceFail();
            this.beyondLimitHeightFail = flightRevStateData.isBeyondLimitHeightFail();
            this.heightLowFollowOpenFail = flightRevStateData.isHeightLowFollowOpenFail();
            return;
        }
        boolean isPropellerGuardCover = flightRevStateData.isPropellerGuardCover();
        if (this.newModeBeyondLimitDistance != flightRevStateData.isNewModeBeyondLimitDistance() && !isPropellerGuardCover) {
            this.newModeBeyondLimitDistance = flightRevStateData.isNewModeBeyondLimitDistance();
            this.text1 = activity.getResources().getString(C1965R.string.setting_new_beyond_limit_distance);
        } else {
            this.text1 = null;
        }
        if (this.newModeBeyondLimitHeight != flightRevStateData.isNewModeBeyondLimitHeight() && !isPropellerGuardCover) {
            this.newModeBeyondLimitHeight = flightRevStateData.isNewModeBeyondLimitHeight();
            this.text2 = activity.getResources().getString(C1965R.string.setting_new_beyond_limit_height);
        } else {
            this.text2 = null;
        }
        if (this.speedModeNewModeFail != flightRevStateData.isSpeedModeNewModeFail()) {
            this.speedModeNewModeFail = flightRevStateData.isSpeedModeNewModeFail();
            this.text3 = activity.getResources().getString(C1965R.string.setting_new_speed_mode_fail);
        } else {
            this.text3 = null;
        }
        if (this.beyondLimitDistanceFail != flightRevStateData.isBeyondLimitDistanceFail()) {
            this.beyondLimitDistanceFail = flightRevStateData.isBeyondLimitDistanceFail();
            this.text4 = activity.getResources().getString(C1965R.string.setting_beyond_limit_distance);
        } else {
            this.text4 = null;
        }
        if (this.beyondLimitHeightFail != flightRevStateData.isBeyondLimitHeightFail()) {
            this.beyondLimitHeightFail = flightRevStateData.isBeyondLimitHeightFail();
            this.text5 = activity.getResources().getString(C1965R.string.setting_beyond_limit_height);
        } else {
            this.text5 = null;
        }
        if (this.heightLowFollowOpenFail != flightRevStateData.isHeightLowFollowOpenFail()) {
            this.heightLowFollowOpenFail = flightRevStateData.isHeightLowFollowOpenFail();
            this.text6 = activity.getResources().getString(C1965R.string.setting_height_low_follow_fail);
        } else {
            this.text6 = null;
        }
        String str = this.text1;
        if (str == null && this.text2 == null && this.text3 == null && this.text4 == null && this.text5 == null && this.text6 == null) {
            return;
        }
        showDialog(activity, str, this.text2, this.text3, this.text4, this.text5, this.text6);
    }

    private void showDialog(Activity activity, String... strArr) {
        if (BaseSyncDialog.isShow || activity.isFinishing() || !PhoneConfig.isKernelActivityRunning) {
            return;
        }
        GeneralDialog generalDialog = new GeneralDialog(activity, strArr);
        this.dialog = generalDialog;
        generalDialog.show();
        new Handler().postDelayed(new Runnable() { // from class: com.ipotensic.kernel.view.SettingTips.1
            @Override // java.lang.Runnable
            public void run() {
                if (SettingTips.this.dialog == null || !SettingTips.this.dialog.isShowing()) {
                    return;
                }
                SettingTips.this.dialog.dismiss();
            }
        }, 5000L);
    }

    public void disConnect() {
        this.isFirstGetSettingData = false;
        GeneralDialog generalDialog = this.dialog;
        if (generalDialog != null && generalDialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.text1 = null;
        this.text2 = null;
        this.text3 = null;
        this.text4 = null;
        this.text5 = null;
        this.text6 = null;
    }
}