package com.ipotensic.kernel.controllers.settings;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.activitys.KernelActivity;
import com.ipotensic.kernel.activitys.MiniRepairActivity;
import com.ipotensic.kernel.activitys.RemoterCalActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevConnectData;

/* loaded from: classes2.dex */
public class Setting3Controller extends BaseController implements View.OnClickListener {
    private Context context;
    private boolean isSetting3Change;
    private ImageView ivArrowOne;
    private ImageView ivArrowTwo;
    private ImageView ivLeft;
    private ImageView ivRight;
    private ConstraintLayout layoutMiniRemoterCalibration;
    private ConstraintLayout layoutMiniRepair;
    private LinearLayout layoutRemoterSetting;
    private TextView tvBackward;
    private TextView tvDown;
    private TextView tvFlightTips;
    private TextView tvForward;
    private TextView tvLeft;
    private TextView tvLeftSide;
    private TextView tvMode1;
    private TextView tvMode2;
    private TextView tvNoAccessRemoterCalibration;
    private TextView tvNoAccessRepair;
    private TextView tvRemoterCalibration;
    private TextView tvRepairingAircraft;
    private TextView tvRight;
    private TextView tvRightSide;
    private TextView tvUp;

    private void dataChangeListener() {
    }

    public void dismiss() {
    }

    public Setting3Controller(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.isSetting3Change = false;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.context = view.getContext();
        view.findViewById(R.id.iv_back).setOnClickListener(this);
        this.tvMode1 = (TextView) view.findViewById(R.id.tv_mode_1);
        this.tvMode2 = (TextView) view.findViewById(R.id.tv_mode_2);
        this.tvFlightTips = (TextView) view.findViewById(R.id.tv_flight_tips);
        this.ivLeft = (ImageView) view.findViewById(R.id.iv_left);
        this.ivRight = (ImageView) view.findViewById(R.id.iv_right);
        this.tvUp = (TextView) view.findViewById(R.id.tv_up);
        this.tvDown = (TextView) view.findViewById(R.id.tv_down);
        this.tvLeft = (TextView) view.findViewById(R.id.tv_left);
        this.tvRight = (TextView) view.findViewById(R.id.tv_right);
        this.tvForward = (TextView) view.findViewById(R.id.tv_forward);
        this.tvBackward = (TextView) view.findViewById(R.id.tv_backward);
        this.tvLeftSide = (TextView) view.findViewById(R.id.tv_left_side);
        this.tvRightSide = (TextView) view.findViewById(R.id.tv_right_side);
        this.layoutMiniRepair = (ConstraintLayout) view.findViewById(R.id.layout_mini_repair);
        this.layoutRemoterSetting = (LinearLayout) view.findViewById(R.id.layout_remoter_setting);
        this.layoutMiniRemoterCalibration = (ConstraintLayout) view.findViewById(R.id.layout_remoter_calibration);
        this.tvNoAccessRepair = (TextView) view.findViewById(R.id.tv_no_access_repairing);
        this.tvNoAccessRemoterCalibration = (TextView) view.findViewById(R.id.tv_remoter_calibration_tips);
        this.ivArrowOne = (ImageView) view.findViewById(R.id.iv_arrow_one);
        this.ivArrowTwo = (ImageView) view.findViewById(R.id.iv_arrow_two);
        this.tvRepairingAircraft = (TextView) view.findViewById(R.id.tv_repairing_aircraft);
        this.tvRemoterCalibration = (TextView) view.findViewById(R.id.tv_remoter_calibration);
        setMiniPairVisible();
        initListener();
    }

    public void setMiniPairVisible() {
        if (this.layoutRemoterSetting == null || this.layoutMiniRepair == null || this.layoutMiniRemoterCalibration == null) {
            return;
        }
        FlightRevConnectData flightRevConnectData = FlightRevData.get().getFlightRevConnectData();
        if (!FlightConfig.isOldProduct()) {
            this.layoutRemoterSetting.setVisibility(0);
            if (flightRevConnectData.isRemoterConnected()) {
                this.tvNoAccessRepair.setVisibility(8);
                this.tvNoAccessRemoterCalibration.setVisibility(8);
                if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                    this.layoutMiniRemoterCalibration.setClickable(false);
                    this.layoutMiniRemoterCalibration.setEnabled(false);
                    this.tvRemoterCalibration.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                    this.ivArrowTwo.setImageResource(R.mipmap.icon_next_disable);
                } else {
                    this.layoutMiniRemoterCalibration.setClickable(true);
                    this.layoutMiniRemoterCalibration.setEnabled(true);
                    this.tvRemoterCalibration.setTextColor(getContext().getResources().getColor(R.color.white));
                    this.ivArrowTwo.setImageResource(R.mipmap.img_btn_function_open);
                }
                if (FlightConfig.isConnectFlight()) {
                    this.layoutMiniRepair.setClickable(false);
                    this.layoutMiniRepair.setEnabled(false);
                    this.tvRepairingAircraft.setTextColor(getContext().getResources().getColor(R.color.color_gray));
                    this.ivArrowOne.setImageResource(R.mipmap.icon_next_disable);
                    return;
                }
                this.layoutMiniRepair.setClickable(true);
                this.layoutMiniRepair.setEnabled(true);
                this.tvRepairingAircraft.setTextColor(getContext().getResources().getColor(R.color.white));
                this.ivArrowOne.setImageResource(R.mipmap.img_btn_function_open);
                return;
            }
            this.layoutMiniRemoterCalibration.setClickable(false);
            this.layoutMiniRemoterCalibration.setEnabled(false);
            this.tvRepairingAircraft.setTextColor(getContext().getResources().getColor(R.color.color_gray));
            this.layoutMiniRepair.setClickable(false);
            this.layoutMiniRepair.setEnabled(false);
            this.tvRemoterCalibration.setTextColor(getContext().getResources().getColor(R.color.color_gray));
            this.ivArrowOne.setImageResource(R.mipmap.icon_next_disable);
            this.ivArrowTwo.setImageResource(R.mipmap.icon_next_disable);
            this.tvNoAccessRepair.setVisibility(0);
            this.tvNoAccessRemoterCalibration.setVisibility(0);
            return;
        }
        this.layoutRemoterSetting.setVisibility(8);
    }

    public void updateData() {
        if (getBaseView() == null || this.isSetting3Change) {
            return;
        }
        this.isSetting3Change = true;
        FlightRevData.get().getFlightRevStateData().isFlight();
        if (FlightRevData.get().getFlightRevSettingData().isAmericaRockerMode()) {
            this.ivLeft.setImageResource(R.mipmap.icon_virtual_rocker_model1_left);
            this.ivRight.setImageResource(R.mipmap.icon_virtual_rocker_model1_right);
            this.tvMode1.setBackgroundResource(R.drawable.bg_setting_button_select_left);
            this.tvMode2.setBackgroundResource(R.drawable.bg_setting_model_default_right);
            this.tvUp.setText(this.context.getString(R.string.remote_up));
            this.tvDown.setText(this.context.getString(R.string.remote_down));
            this.tvForward.setText(this.context.getString(R.string.remote_forward));
            this.tvBackward.setText(this.context.getString(R.string.remote_backward));
            return;
        }
        this.ivLeft.setImageResource(R.mipmap.icon_virtual_rocker_model2_left);
        this.ivRight.setImageResource(R.mipmap.icon_virtual_rocker_model2_right);
        this.tvMode1.setBackgroundResource(R.drawable.bg_setting_model_default_left);
        this.tvMode2.setBackgroundResource(R.drawable.bg_setting_button_select_right);
        this.tvUp.setText(this.context.getString(R.string.remote_forward));
        this.tvDown.setText(this.context.getString(R.string.remote_backward));
        this.tvForward.setText(this.context.getString(R.string.remote_up));
        this.tvBackward.setText(this.context.getString(R.string.remote_down));
    }

    private void initListener() {
        this.tvMode2.setOnClickListener(this);
        this.tvMode1.setOnClickListener(this);
        this.ivLeft.setOnClickListener(this);
        this.ivRight.setOnClickListener(this);
        int i = 1000;
        this.layoutMiniRepair.setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.kernel.controllers.settings.Setting3Controller.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (FlightConfig.isConnectFlight() || !FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
                    return;
                }
                DDLog.e("开始发送对频");
                ((KernelActivity) Setting3Controller.this.getContext()).showLoadingDialog();
                MiniRepairActivity.isStartPair = false;
                DataManager.getInstance().sendMiniPair();
            }
        });
        this.layoutMiniRemoterCalibration.setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.kernel.controllers.settings.Setting3Controller.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (!FlightRevData.get().getFlightRevConnectData().isRemoterConnected() || FlightRevData.get().getFlightRevStateData().isFlight()) {
                    return;
                }
                ActivityHelper.getInstance().makeActivityOnlyOne(RemoterCalActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.settings.Setting3Controller.2.1
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        Setting3Controller.this.getContext().startActivity(new Intent(Setting3Controller.this.getContext(), (Class<?>) RemoterCalActivity.class));
                    }
                });
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_mode_2 || id == R.id.iv_right) {
            this.ivLeft.setImageResource(R.mipmap.icon_virtual_rocker_model2_left);
            this.ivRight.setImageResource(R.mipmap.icon_virtual_rocker_model2_right);
            this.tvMode1.setBackgroundResource(R.drawable.bg_setting_model_default_left);
            this.tvMode2.setBackgroundResource(R.drawable.bg_setting_button_select_right);
            this.tvUp.setText(this.context.getString(R.string.remote_forward));
            this.tvDown.setText(this.context.getString(R.string.remote_backward));
            this.tvForward.setText(this.context.getString(R.string.remote_up));
            this.tvBackward.setText(this.context.getString(R.string.remote_down));
            FlightSendData.get().getSendFlightSetData().setRockMode(false);
            return;
        }
        if (id == R.id.tv_mode_1 || id == R.id.iv_left) {
            this.ivLeft.setImageResource(R.mipmap.icon_virtual_rocker_model1_left);
            this.ivRight.setImageResource(R.mipmap.icon_virtual_rocker_model1_right);
            this.tvMode1.setBackgroundResource(R.drawable.bg_setting_button_select_left);
            this.tvMode2.setBackgroundResource(R.drawable.bg_setting_model_default_right);
            this.tvUp.setText(this.context.getString(R.string.remote_up));
            this.tvDown.setText(this.context.getString(R.string.remote_down));
            this.tvForward.setText(this.context.getString(R.string.remote_forward));
            this.tvBackward.setText(this.context.getString(R.string.remote_backward));
            FlightSendData.get().getSendFlightSetData().setRockMode(true);
            return;
        }
        if (id == R.id.iv_back) {
            this.isSetting3Change = false;
            EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting3Controller$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass3.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1 || i == 2) {
            setMiniPairVisible();
        }
    }
}
