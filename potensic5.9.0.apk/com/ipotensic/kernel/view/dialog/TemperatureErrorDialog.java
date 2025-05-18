package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class TemperatureErrorDialog extends BaseSyncDialog {
    public static int MAX_WORK_TEMPERATURE = 60;
    public static final int MIN_WORK_TEMPERATURE = 5;
    private final ImageView ivTemperatureError;
    TemperatureErrorType mErrorType;
    int mTemperature;
    private OnBackClickListener onBackClickListener;
    private final TextView tvTemperature;
    private final TextView tvTemperatureErrorNotice;

    public interface OnBackClickListener {
        void onBackClicked();
    }

    public enum TemperatureErrorType {
        UNDEFINE,
        HIGH,
        LOW
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public TemperatureErrorDialog(Context context) {
        super(context, C1965R.layout.view_dialog_temperature_error);
        this.mTemperature = Integer.MAX_VALUE;
        this.mErrorType = TemperatureErrorType.UNDEFINE;
        this.ivTemperatureError = (ImageView) findViewById(C1965R.id.iv_battery_temperature_error);
        this.tvTemperature = (TextView) findViewById(C1965R.id.tv_battery_temperature);
        this.tvTemperatureErrorNotice = (TextView) findViewById(C1965R.id.tv_battery_temperature_error_notice);
    }

    public void updateTemperatureError(int i, TemperatureErrorType temperatureErrorType) {
        if (i != this.mTemperature) {
            this.mTemperature = i;
            updateTemperatureValue(i);
        }
        if (temperatureErrorType != this.mErrorType) {
            this.mErrorType = temperatureErrorType;
            updateTemperatureErrorType(temperatureErrorType);
        }
    }

    private void updateTemperatureValue(int i) {
        this.tvTemperature.setText(i + "℃");
    }

    private void updateTemperatureErrorType(TemperatureErrorType temperatureErrorType) {
        String format;
        this.ivTemperatureError.setImageResource(temperatureErrorType == TemperatureErrorType.HIGH ? C1965R.mipmap.icon_high_temperature : C1965R.mipmap.icon_low_temperature);
        if (temperatureErrorType == TemperatureErrorType.HIGH) {
            format = getContext().getString(C1965R.string.battery_temperature_need_lower);
        } else {
            format = String.format(getContext().getString(C1965R.string.battery_temperature_need_higher), 5);
        }
        this.tvTemperatureErrorNotice.setText(format);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            dismiss();
            this.onBackClickListener.onBackClicked();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}