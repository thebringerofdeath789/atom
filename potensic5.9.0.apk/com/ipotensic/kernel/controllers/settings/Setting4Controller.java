package com.ipotensic.kernel.controllers.settings;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.view.BatteryProgressView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevBatteryData;

/* loaded from: classes2.dex */
public class Setting4Controller extends BaseController implements View.OnClickListener {
    private BatteryProgressView batteryProgressView;
    private LinearLayout llVoltage;
    private float totalVoltage;
    private TextView tvBatteryType;
    private TextView tvCapacity;
    private TextView tvCurrent;
    private TextView tvCycleTime;
    private TextView tvFlightTime;
    private TextView tvTemperature;
    private TextView tvVoltage;

    public Setting4Controller(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        view.findViewById(C1965R.id.iv_back).setOnClickListener(this);
        this.tvTemperature = (TextView) view.findViewById(C1965R.id.tv_temperature);
        this.tvCurrent = (TextView) view.findViewById(C1965R.id.tv_current);
        this.tvBatteryType = (TextView) view.findViewById(C1965R.id.tv_battery_type);
        this.tvCycleTime = (TextView) view.findViewById(C1965R.id.tv_cycle_times);
        this.tvFlightTime = (TextView) view.findViewById(C1965R.id.tv_estimated_flight_time);
        this.tvCapacity = (TextView) view.findViewById(C1965R.id.tv_battery_capacity);
        this.batteryProgressView = (BatteryProgressView) view.findViewById(C1965R.id.battery_progress_view);
        this.tvVoltage = (TextView) view.findViewById(C1965R.id.tv_voltage);
    }

    public void updateData() {
        if (getBaseView() == null) {
            return;
        }
        FlightRevBatteryData flightRevBatteryData = FlightRevData.get().getFlightRevBatteryData();
        if (FlightConfig.isConnectFlight()) {
            float firstVoltage = flightRevBatteryData.getFirstVoltage() + flightRevBatteryData.getSecondVoltage() + flightRevBatteryData.getThirdVoltage() + flightRevBatteryData.getFourthVoltage();
            this.totalVoltage = firstVoltage;
            this.totalVoltage = UnitUtil.double2Float(firstVoltage);
            this.tvTemperature.setText(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getTemperature()), " °C"));
            this.tvCurrent.setText(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getCurCur()), " mA"));
            this.tvBatteryType.setText(flightRevBatteryData.getBatteryType() + "s");
            this.tvCycleTime.setText(String.format("%d", Integer.valueOf(flightRevBatteryData.getLoopNum())));
            this.tvFlightTime.setText(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getRemainFlightTime()), " min"));
            this.tvCapacity.setText(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getRemainCapacity()), " mAh"));
            this.tvVoltage.setText(this.totalVoltage + " V");
            this.batteryProgressView.setProgress(FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery());
            return;
        }
        this.tvTemperature.setText(getContext().getString(C1965R.string.test_data));
        this.tvCurrent.setText(getContext().getString(C1965R.string.test_data));
        this.tvBatteryType.setText(getContext().getString(C1965R.string.test_data));
        this.tvCycleTime.setText(getContext().getString(C1965R.string.test_data));
        this.tvFlightTime.setText(getContext().getString(C1965R.string.test_data));
        this.tvCapacity.setText(getContext().getString(C1965R.string.test_data));
        this.tvVoltage.setText(getContext().getString(C1965R.string.test_data));
        this.batteryProgressView.disconnect();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting4Controller$1 */
    static /* synthetic */ class C22961 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_BATTERY_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C22961.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1 || i == 2) {
            updateData();
        }
    }
}