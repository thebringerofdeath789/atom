package com.ipotensic.kernel.view.dialog;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.bean.TitleBean;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevCalibrationFeedbackData;

/* loaded from: classes2.dex */
public class HexahedralCalibrationDialog extends BaseSyncDialog {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ObjectAnimator backAnimator;
    private Context context;
    private ObjectAnimator downAnimator;
    private boolean isBack;
    private boolean isDown;
    private boolean isLeft;
    private boolean isLevel;
    private boolean isRight;
    private boolean isUp;
    private ImageView ivBack;
    private ImageView ivCalibrationBg;
    private ImageView ivDown;
    private ImageView ivLeft;
    private ImageView ivLevel;
    private ImageView ivRight;
    private ImageView ivUp;
    private ObjectAnimator leftAnimator;
    private ObjectAnimator levelAnimator;
    private ObjectAnimator rightAnimator;
    private TextView tvCalibrationTips;
    private TextView tvDescribe;
    private ObjectAnimator upAnimator;

    public HexahedralCalibrationDialog(Context context) {
        super(context, C1965R.layout.dialog_hexahedral_calibration);
        this.isLevel = false;
        this.isDown = false;
        this.isUp = false;
        this.isLeft = false;
        this.isRight = false;
        this.isBack = false;
        this.context = context;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (getContext().getResources().getConfiguration().orientation == 2) {
            attributes.height = (int) (ScreenUtils.getScreenHeight(this.context) * 0.8d);
            attributes.width = (int) (ScreenUtils.getScreenWidth(this.context) * 0.48d);
        } else {
            attributes.height = (int) (ScreenUtils.getScreenWidth(this.context) * 0.8d);
            attributes.width = (int) (ScreenUtils.getScreenHeight(this.context) * 0.48d);
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.ivLevel = (ImageView) findViewById(C1965R.id.iv_level);
        this.ivBack = (ImageView) findViewById(C1965R.id.iv_back);
        this.ivLeft = (ImageView) findViewById(C1965R.id.iv_left);
        this.ivRight = (ImageView) findViewById(C1965R.id.iv_right);
        this.ivDown = (ImageView) findViewById(C1965R.id.iv_down);
        this.ivUp = (ImageView) findViewById(C1965R.id.iv_up);
        this.tvDescribe = (TextView) findViewById(C1965R.id.tv_describe);
        this.ivCalibrationBg = (ImageView) findViewById(C1965R.id.iv_calibration_bg);
        this.tvCalibrationTips = (TextView) findViewById(C1965R.id.tv_calibration_tips);
    }

    private ObjectAnimator setAnimation(ImageView imageView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.2f);
        ofFloat.setDuration(500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public void updateData(boolean z) {
        FlightRevCalibrationFeedbackData revCalibrationFeedbackData = FlightRevData.get().getRevCalibrationFeedbackData();
        byte calibrationProcedure = revCalibrationFeedbackData.getCalibrationProcedure();
        Boolean isCalibrationSuccess = revCalibrationFeedbackData.isCalibrationSuccess();
        DDLog.m1685e("校准反馈信息 ", "step: " + ((int) calibrationProcedure) + ", isSuccess: " + isCalibrationSuccess);
        if (calibrationProcedure == 0) {
            if (this.levelAnimator == null) {
                ObjectAnimator animation = setAnimation(this.ivLevel);
                this.levelAnimator = animation;
                animation.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_level : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_level : C1965R.mipmap.icon_calibration_step_level);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_level));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_level_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", "level");
            this.isLevel = true;
        } else if (calibrationProcedure == 1) {
            if (this.downAnimator == null) {
                ObjectAnimator animation2 = setAnimation(this.ivDown);
                this.downAnimator = animation2;
                animation2.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_nose_down : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_nose_down : C1965R.mipmap.icon_calibration_step_down);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_nose_down));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_down_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", "down");
            this.isDown = true;
        } else if (calibrationProcedure == 2) {
            if (this.upAnimator == null) {
                ObjectAnimator animation3 = setAnimation(this.ivUp);
                this.upAnimator = animation3;
                animation3.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_nose_up : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_nose_up : C1965R.mipmap.icon_calibration_step_up);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_nose_up));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_up_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", "up");
            this.isUp = true;
        } else if (calibrationProcedure == 3) {
            if (this.leftAnimator == null) {
                ObjectAnimator animation4 = setAnimation(this.ivLeft);
                this.leftAnimator = animation4;
                animation4.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_left : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_left : C1965R.mipmap.icon_calibration_step_left);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_left));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_left_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", "left");
            this.isLeft = true;
        } else if (calibrationProcedure == 4) {
            if (this.rightAnimator == null) {
                ObjectAnimator animation5 = setAnimation(this.ivRight);
                this.rightAnimator = animation5;
                animation5.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_right : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_right : C1965R.mipmap.icon_calibration_step_right);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_right));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_right_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", "right");
            this.isRight = true;
        } else if (calibrationProcedure == 5) {
            if (this.backAnimator == null) {
                ObjectAnimator animation6 = setAnimation(this.ivBack);
                this.backAnimator = animation6;
                animation6.start();
            }
            this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_back : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_back : C1965R.mipmap.icon_calibration_step_back);
            this.tvDescribe.setVisibility(0);
            this.tvDescribe.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_back));
            this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_start_back_calibration_tips));
            DDLog.m1685e("校准反馈信息 ", TitleBean.TAG_BACK);
            this.isBack = true;
        }
        if (calibrationProcedure == 6) {
            if (revCalibrationFeedbackData.isLevel() && (this.isLevel || z)) {
                ObjectAnimator objectAnimator = this.levelAnimator;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                    this.levelAnimator = null;
                    this.ivLevel.clearAnimation();
                    this.ivLevel.setAlpha(1.0f);
                }
                this.ivLevel.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_level__calibration_tips));
                this.isLevel = false;
            }
            if (revCalibrationFeedbackData.isBack() && (this.isBack || z)) {
                ObjectAnimator objectAnimator2 = this.backAnimator;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                    this.backAnimator = null;
                    this.ivBack.clearAnimation();
                    this.ivBack.setAlpha(1.0f);
                }
                this.ivBack.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_back_calibration_tips));
                this.isBack = false;
            }
            if (revCalibrationFeedbackData.isLeft() && (this.isLeft || z)) {
                ObjectAnimator objectAnimator3 = this.leftAnimator;
                if (objectAnimator3 != null) {
                    objectAnimator3.cancel();
                    this.leftAnimator = null;
                    this.ivLeft.clearAnimation();
                    this.ivLeft.setAlpha(1.0f);
                }
                this.ivLeft.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_left_calibration_tips));
                this.isLeft = false;
            }
            if (revCalibrationFeedbackData.isRight() && (this.isRight || z)) {
                ObjectAnimator objectAnimator4 = this.rightAnimator;
                if (objectAnimator4 != null) {
                    objectAnimator4.cancel();
                    this.rightAnimator = null;
                    this.ivRight.clearAnimation();
                    this.ivRight.setAlpha(1.0f);
                }
                this.ivRight.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_right_calibration_tips));
                this.isRight = false;
            }
            if (revCalibrationFeedbackData.isNoseDown() && (this.isDown || z)) {
                ObjectAnimator objectAnimator5 = this.downAnimator;
                if (objectAnimator5 != null) {
                    objectAnimator5.cancel();
                    this.downAnimator = null;
                    this.ivDown.clearAnimation();
                    this.ivDown.setAlpha(1.0f);
                }
                this.ivDown.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_down_calibration_tips));
                this.isDown = false;
            }
            if (revCalibrationFeedbackData.isNoseUp() && (this.isUp || z)) {
                ObjectAnimator objectAnimator6 = this.upAnimator;
                if (objectAnimator6 != null) {
                    objectAnimator6.cancel();
                    this.upAnimator = null;
                    this.ivUp.clearAnimation();
                    this.ivUp.setAlpha(1.0f);
                }
                this.ivUp.setImageResource(C1965R.mipmap.icon_calibration_complete);
                this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_complete_up_calibration_tips));
                this.isUp = false;
            }
        }
        if (isCalibrationSuccess != null) {
            if (isCalibrationSuccess.booleanValue()) {
                ToastUtil.toast((Activity) this.context, getContext().getString(C1965R.string.sys_hexahedral_calibration_success));
                DDLog.m1685e("校准反馈信息 ", "校准完成");
            } else {
                ToastUtil.toast((Activity) this.context, getContext().getString(C1965R.string.sys_hexahedral_calibration_fail));
            }
            disconnect();
            reset();
        }
    }

    private void reset() {
        this.isLevel = false;
        this.isUp = false;
        this.isDown = false;
        this.isLeft = false;
        this.isRight = false;
        this.isBack = false;
    }

    public void disconnect() {
        ObjectAnimator objectAnimator = this.levelAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.levelAnimator = null;
            this.ivLevel.clearAnimation();
            this.ivLevel.setAlpha(1.0f);
        }
        ObjectAnimator objectAnimator2 = this.rightAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.rightAnimator = null;
            this.ivRight.clearAnimation();
            this.ivRight.setAlpha(1.0f);
        }
        ObjectAnimator objectAnimator3 = this.leftAnimator;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
            this.leftAnimator = null;
            this.ivLevel.clearAnimation();
            this.ivLevel.setAlpha(1.0f);
        }
        ObjectAnimator objectAnimator4 = this.upAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
            this.upAnimator = null;
            this.ivUp.clearAnimation();
            this.ivUp.setAlpha(1.0f);
        }
        ObjectAnimator objectAnimator5 = this.downAnimator;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
            this.downAnimator = null;
            this.ivDown.clearAnimation();
            this.ivDown.setAlpha(1.0f);
        }
        ObjectAnimator objectAnimator6 = this.backAnimator;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
            this.backAnimator = null;
            this.ivBack.clearAnimation();
            this.ivBack.setAlpha(1.0f);
        }
        this.ivLevel.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivBack.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivLeft.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivRight.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivDown.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivUp.setImageResource(C1965R.drawable.bg_hexahedral_calibration_indicator);
        this.ivCalibrationBg.setImageResource(FlightConfig.isP3SE() ? C1965R.mipmap.img_p3se_level : FlightConfig.isP5() ? C1965R.mipmap.img_p5se_level : C1965R.mipmap.icon_calibration_step_level);
        this.tvDescribe.setVisibility(4);
        this.tvCalibrationTips.setText(getContext().getString(C1965R.string.sys_hexahedral_calibration_step));
        dismiss();
    }
}