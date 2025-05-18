package com.ipotensic.kernel.controllers;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.RockerTouchView;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevSettingData;

/* loaded from: classes2.dex */
public class RockController extends BaseController implements RockerTouchView.RockerViewChangeListener {
    private RockerTouchView leftRockerView;
    private RockerTouchView rightRockerView;

    public RockController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.leftRockerView = (RockerTouchView) view.findViewById(R.id.rocker_view_left);
        this.rightRockerView = (RockerTouchView) view.findViewById(R.id.rocker_view_right);
        this.leftRockerView.setRockerViewChangeListener(this);
        this.rightRockerView.setRockerViewChangeListener(this);
        this.leftRockerView.setLeft(true);
    }

    @Override // com.ipotensic.kernel.view.RockerTouchView.RockerViewChangeListener
    public void onPositionChanged(View view, int i, int i2) {
        if (view.getId() == R.id.rocker_view_left) {
            FlightSendData.get().getSend4AxisData().setRotate(getValue(i));
            FlightSendData.get().getSend4AxisData().setAccelerator(getValue(i2));
        } else if (view.getId() == R.id.rocker_view_right) {
            FlightSendData.get().getSend4AxisData().setLeftRight(getValue(i));
            FlightSendData.get().getSend4AxisData().setFrontBack(getValue(i2));
        }
    }

    private int getValue(int i) {
        return ((i * 125) / 100) + 125;
    }

    public void setMode(FlightRevSettingData flightRevSettingData) {
        if (flightRevSettingData.isAmericaRockerMode()) {
            this.leftRockerView.setOuterBgBitmap(R.mipmap.icon_mode1_left_rocker);
            this.rightRockerView.setOuterBgBitmap(R.mipmap.icon_mode1_right_rocker);
        } else {
            this.leftRockerView.setOuterBgBitmap(R.mipmap.icon_mode2_left_rocker);
            this.rightRockerView.setOuterBgBitmap(R.mipmap.icon_mode2_right_rocker);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            getBaseView().setVisibility(0);
        } else {
            getBaseView().setVisibility(8);
        }
    }
}