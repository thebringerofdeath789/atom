package com.ipotensic.kernel.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.geofence.GeoFence;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class RemoteControlGeoCalDialog extends BaseSyncDialog {
    private Context context;
    private AnimationDrawable horizontalDrawable;
    private boolean isGeoFault;
    private boolean isGeoHorizontalComplete;
    private boolean isGeoVerticalComplete;
    private ImageView ivHorizontal;
    private ImageView ivVertical;
    private TextView tvGeoCalibrationTitle;
    private TextView tvOneStep;
    private TextView tvTipsContentOne;
    private AnimationDrawable verticalDrawable;

    public RemoteControlGeoCalDialog(Context context) {
        super(context, R.layout.view_dialog_geo_remote_control);
        this.isGeoVerticalComplete = false;
        this.isGeoHorizontalComplete = false;
        this.isGeoFault = false;
        this.context = context;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.context = context;
        this.tvOneStep = (TextView) findViewById(R.id.tv_one);
        this.tvGeoCalibrationTitle = (TextView) findViewById(R.id.tv_geo_calibration);
        this.ivHorizontal = (ImageView) findViewById(R.id.img_geo_horizontal);
        this.ivVertical = (ImageView) findViewById(R.id.img_geo_vertical);
        this.tvTipsContentOne = (TextView) findViewById(R.id.tv_content_one);
        this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
        this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
        if (FlightConfig.isP3SE()) {
            this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_p3se);
            this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_p3se);
            this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
            this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
            return;
        }
        if (FlightConfig.is_Atom_Series()) {
            if (FlightConfig.isAtomPanTilt()) {
                this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_atom);
                this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_atom);
            } else {
                this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_mini);
                this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_mini);
            }
            this.ivHorizontal.setBackgroundResource(R.mipmap.img_mini_calibration_bg);
            this.ivVertical.setBackgroundResource(R.mipmap.img_mini_calibration_bg);
            this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
            this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
            return;
        }
        if (FlightConfig.isP5()) {
            this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_p5se);
            this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_p5se);
            this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
            this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
        }
    }

    public void setUpdateData(FlightRevStateData flightRevStateData) {
        boolean isGeoCalibrationFailureFlag = flightRevStateData.isGeoCalibrationFailureFlag();
        if (flightRevStateData.isGeomagneticFault()) {
            if (this.isGeoFault || !BaseSyncDialog.isShow) {
                return;
            }
            this.isGeoFault = true;
            ToastUtil.toast((Activity) this.context, getContext().getString(R.string.error_geo_fault));
            reset();
            dismiss();
            return;
        }
        this.isGeoFault = false;
        if (flightRevStateData.isMagnetometerHorizontalCalibrating()) {
            if (!this.horizontalDrawable.isRunning()) {
                this.horizontalDrawable.start();
                if (!this.isGeoHorizontalComplete) {
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                }
                this.isGeoHorizontalComplete = true;
            }
        } else if (this.isGeoHorizontalComplete && isGeoCalibrationFailureFlag) {
            reset();
            dismiss();
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
        }
        if (flightRevStateData.isMagnetometerVerticalCalibrating()) {
            if (this.verticalDrawable.isRunning()) {
                return;
            }
            this.tvGeoCalibrationTitle.setText(getContext().getString(R.string.dialog_geo_title_vertical));
            this.horizontalDrawable.stop();
            this.verticalDrawable.start();
            this.ivHorizontal.setVisibility(4);
            this.ivVertical.setVisibility(0);
            this.tvTipsContentOne.setText(getContext().getString(R.string.dialog_geo_vertical_tips));
            this.tvOneStep.setText(GeoFence.BUNDLE_KEY_CUSTOMID);
            if (!this.isGeoVerticalComplete) {
                EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
            }
            this.isGeoVerticalComplete = true;
            return;
        }
        boolean z = this.isGeoVerticalComplete;
        if (z && isGeoCalibrationFailureFlag) {
            reset();
            dismiss();
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
        } else if (z) {
            ToastUtil.showImageTop((Activity) this.context, getContext().getString(R.string.toast_geo_calibration_finish), R.mipmap.icon_toast_successful);
            reset();
            dismiss();
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
        }
    }

    private void reset() {
        this.isGeoHorizontalComplete = false;
        this.isGeoVerticalComplete = false;
        this.tvOneStep.setText("1");
        this.tvGeoCalibrationTitle.setText(getContext().getString(R.string.dialog_geo_title_horizontal));
        this.horizontalDrawable.stop();
        this.verticalDrawable.stop();
        this.ivHorizontal.setVisibility(0);
        this.ivVertical.setVisibility(4);
        this.tvTipsContentOne.setText(getContext().getString(R.string.dialog_geo_horizontal_tips));
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
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
}
