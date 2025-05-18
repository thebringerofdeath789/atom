package com.ipotensic.kernel.controllers;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.mapbox.api.directions.v5.models.SpeedLimit;

/* loaded from: classes2.dex */
public class BottomController extends BaseController {
    private static final String TAG = "BottomController";
    private String NA;
    private ImageView iv_H_speed;
    private ImageView iv_V_Speed;
    private ImageView iv_d;
    private ImageView iv_h;
    private StrokeTextView tvHDistance;
    private StrokeTextView tvHSpeed;
    private StrokeTextView tvVDistance;
    private StrokeTextView tvVSpeed;
    private StrokeTextView tv_H_M;
    private StrokeTextView tv_H_MS;
    private StrokeTextView tv_V_M;
    private StrokeTextView tv_V_MS;

    public BottomController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.iv_d = (ImageView) view.findViewById(R.id.iv_d);
        this.tv_H_M = (StrokeTextView) view.findViewById(R.id.tv_m);
        this.tvHDistance = (StrokeTextView) view.findViewById(R.id.tv_horizontal_distance);
        this.iv_H_speed = (ImageView) view.findViewById(R.id.iv_speed);
        this.tv_H_MS = (StrokeTextView) view.findViewById(R.id.tv_ms);
        this.tvHSpeed = (StrokeTextView) view.findViewById(R.id.tv_horizontal_speed);
        this.iv_h = (ImageView) view.findViewById(R.id.iv_h);
        this.tv_V_M = (StrokeTextView) view.findViewById(R.id.tv_m_height);
        this.tvVDistance = (StrokeTextView) view.findViewById(R.id.tv_height);
        this.iv_V_Speed = (ImageView) view.findViewById(R.id.iv_vertical_speed);
        this.tv_V_MS = (StrokeTextView) view.findViewById(R.id.tv_ms_height);
        this.tvVSpeed = (StrokeTextView) view.findViewById(R.id.tv_vertical_speed);
        this.NA = getContext().getString(R.string.test_data);
        setUpdateData();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            AnimationUtil.transInBottom(getBaseView());
            setUpdateData();
        } else {
            AnimationUtil.transOutBottom(getBaseView());
        }
    }

    public void setUpdateData() {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        Resources resources3;
        int i3;
        Resources resources4;
        int i4;
        Resources resources5;
        int i5;
        Resources resources6;
        int i6;
        Resources resources7;
        int i7;
        Resources resources8;
        int i8;
        this.iv_d.setImageResource(FlightConfig.isConnectFlight() ? R.mipmap.icon_distance : R.mipmap.icon_distance_dis);
        this.iv_h.setImageResource(FlightConfig.isConnectFlight() ? R.mipmap.icon_height : R.mipmap.icon_height_dis);
        StrokeTextView strokeTextView = this.tv_H_M;
        if (FlightConfig.isConnectFlight()) {
            resources = getContext().getResources();
            i = R.color.white;
        } else {
            resources = getContext().getResources();
            i = R.color.color_white_fifty_percent;
        }
        strokeTextView.setTextColor(resources.getColor(i));
        StrokeTextView strokeTextView2 = this.tv_H_MS;
        if (FlightConfig.isConnectFlight()) {
            resources2 = getContext().getResources();
            i2 = R.color.white;
        } else {
            resources2 = getContext().getResources();
            i2 = R.color.color_white_fifty_percent;
        }
        strokeTextView2.setTextColor(resources2.getColor(i2));
        StrokeTextView strokeTextView3 = this.tv_V_M;
        if (FlightConfig.isConnectFlight()) {
            resources3 = getContext().getResources();
            i3 = R.color.white;
        } else {
            resources3 = getContext().getResources();
            i3 = R.color.color_white_fifty_percent;
        }
        strokeTextView3.setTextColor(resources3.getColor(i3));
        StrokeTextView strokeTextView4 = this.tv_V_MS;
        if (FlightConfig.isConnectFlight()) {
            resources4 = getContext().getResources();
            i4 = R.color.white;
        } else {
            resources4 = getContext().getResources();
            i4 = R.color.color_white_fifty_percent;
        }
        strokeTextView4.setTextColor(resources4.getColor(i4));
        this.iv_V_Speed.setImageResource(FlightConfig.isConnectFlight() ? R.mipmap.icon_vertical_speed : R.mipmap.icon_vertical_speed_disable);
        this.iv_H_speed.setImageResource(FlightConfig.isConnectFlight() ? R.mipmap.icon_horizontal_speed : R.mipmap.icon_horizontal_speed_disable);
        StrokeTextView strokeTextView5 = this.tvHDistance;
        if (FlightConfig.isConnectFlight()) {
            resources5 = getContext().getResources();
            i5 = R.color.white;
        } else {
            resources5 = getContext().getResources();
            i5 = R.color.color_white_fifty_percent;
        }
        strokeTextView5.setTextColor(resources5.getColor(i5));
        StrokeTextView strokeTextView6 = this.tvHSpeed;
        if (FlightConfig.isConnectFlight()) {
            resources6 = getContext().getResources();
            i6 = R.color.white;
        } else {
            resources6 = getContext().getResources();
            i6 = R.color.color_white_fifty_percent;
        }
        strokeTextView6.setTextColor(resources6.getColor(i6));
        StrokeTextView strokeTextView7 = this.tvVDistance;
        if (FlightConfig.isConnectFlight()) {
            resources7 = getContext().getResources();
            i7 = R.color.white;
        } else {
            resources7 = getContext().getResources();
            i7 = R.color.color_white_fifty_percent;
        }
        strokeTextView7.setTextColor(resources7.getColor(i7));
        StrokeTextView strokeTextView8 = this.tvVSpeed;
        if (FlightConfig.isConnectFlight()) {
            resources8 = getContext().getResources();
            i8 = R.color.white;
        } else {
            resources8 = getContext().getResources();
            i8 = R.color.color_white_fifty_percent;
        }
        strokeTextView8.setTextColor(resources8.getColor(i8));
        if (SPHelper.getInstance().isFt()) {
            float double2Float = UnitUtil.double2Float(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalSpeed() * 2.23693632d);
            float double2Float2 = UnitUtil.double2Float(FlightRevData.get().getFlightRevFlightInfoData().getVerticalSpeed() * 2.23693632d);
            float double2Float3 = UnitUtil.double2Float(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalDistance() * 3.28083989501d);
            float double2Float4 = UnitUtil.double2Float(FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() * 3.28083989501d);
            this.tvHSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(double2Float) : this.NA);
            this.tvHDistance.setText(FlightConfig.isConnectFlight() ? String.valueOf(double2Float3) : this.NA);
            this.tvVDistance.setText(FlightConfig.isConnectFlight() ? String.valueOf(double2Float4) : this.NA);
            this.tvVSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(double2Float2) : this.NA);
            this.tv_H_MS.setText(getContext().getString(R.string.units_speed_imperial));
            this.tv_V_MS.setText(getContext().getString(R.string.units_speed_imperial));
            this.tv_V_M.setText(getContext().getString(R.string.units_distance_imperial));
            this.tv_H_M.setText(getContext().getString(R.string.units_distance_imperial));
            return;
        }
        if (SPHelper.getInstance().getBoolean(SPHelper.KEY_UNITS_KM, false)) {
            float keepOneDigit = UnitUtil.keepOneDigit((float) (FlightRevData.get().getFlightRevFlightInfoData().getHorizontalSpeed() * 3.6d));
            float keepOneDigit2 = UnitUtil.keepOneDigit((float) (FlightRevData.get().getFlightRevFlightInfoData().getVerticalSpeed() * 3.6d));
            this.tvHSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(keepOneDigit) : this.NA);
            this.tvVSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(keepOneDigit2) : this.NA);
            this.tv_H_MS.setText(SpeedLimit.KMPH);
            this.tv_V_MS.setText(SpeedLimit.KMPH);
        } else {
            this.tvHSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalSpeed()) : this.NA);
            this.tvVSpeed.setText(FlightConfig.isConnectFlight() ? String.valueOf(FlightRevData.get().getFlightRevFlightInfoData().getVerticalSpeed()) : this.NA);
            this.tv_H_MS.setText(getContext().getString(R.string.units_speed_metric));
            this.tv_V_MS.setText(getContext().getString(R.string.units_speed_metric));
        }
        this.tvHDistance.setText(FlightConfig.isConnectFlight() ? String.valueOf(FlightRevData.get().getFlightRevFlightInfoData().getHorizontalDistance()) : this.NA);
        this.tvVDistance.setText(FlightConfig.isConnectFlight() ? String.valueOf(FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance()) : this.NA);
        this.tv_V_M.setText(getContext().getString(R.string.units_distance_metric));
        this.tv_H_M.setText(getContext().getString(R.string.units_distance_metric));
    }

    public void setDisconnectValue() {
        this.tvHSpeed.setText(this.NA);
        this.tvHDistance.setText(this.NA);
        this.tvVDistance.setText(this.NA);
        this.tvVSpeed.setText(this.NA);
        this.tv_H_M.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tv_H_MS.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tv_V_M.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tv_V_MS.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.iv_V_Speed.setImageResource(R.mipmap.icon_vertical_speed_disable);
        this.iv_H_speed.setImageResource(R.mipmap.icon_horizontal_speed_disable);
        this.iv_d.setImageResource(R.mipmap.icon_distance_dis);
        this.iv_h.setImageResource(R.mipmap.icon_height_dis);
        this.tvHDistance.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tvHSpeed.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tvVDistance.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
        this.tvVSpeed.setTextColor(getContext().getResources().getColor(R.color.color_white_fifty_percent));
    }
}