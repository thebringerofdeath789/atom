package com.ipotensic.potensicpro.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.State;
import com.ipotensic.potensicpro.C2640R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class ConnectStateView extends RelativeLayout implements EventDispatcher.OnEventListener, View.OnClickListener {
    private final int STATE_CHECK;
    private final int STATE_CONNECTED;
    private int connectState;
    private ImageView imgConnectStatus;
    private ImageView imgTopOut;
    private Handler mainHandler;
    private View.OnClickListener onClickListener;
    private State state;
    private OnConnectStateChangeListener stateChangeListener;
    private TextView tvBottom;

    public interface OnConnectStateChangeListener {
        void onStateChanged(State state);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public ConnectStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.STATE_CONNECTED = 1;
        this.STATE_CHECK = 2;
        this.connectState = 0;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.state = null;
        this.state = FlightConfig.isUsb() ? State.STATE_USB_NO_CONNECT : State.STATE_WIFI_NO_CONNECT;
        addView(LayoutInflater.from(context).inflate(C2640R.layout.view_layout_connect_state, (ViewGroup) null));
        this.imgTopOut = (ImageView) findViewById(C2640R.id.img_out);
        this.tvBottom = (TextView) findViewById(C2640R.id.tv_state);
        this.imgConnectStatus = (ImageView) findViewById(C2640R.id.img_connect_status);
        setState(this.state);
    }

    public void setConnectStateListener(OnConnectStateChangeListener onConnectStateChangeListener) {
        this.stateChangeListener = onConnectStateChangeListener;
    }

    public void setSearchState() {
        if (this.connectState != 2) {
            this.connectState = 2;
        }
        this.tvBottom.setText(getContext().getString(C2640R.string.connect_state_check));
        this.imgTopOut.setImageResource(C2640R.mipmap.img_icon_connect_state_check);
        setOnClickListener(this.onClickListener);
    }

    public void onAnimResume() {
        if (this.connectState != 1) {
            setSearchState();
        }
    }

    private void selfRotate(final View view) {
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(0.0f, 360.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.potensicpro.view.ConnectStateView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    view.setRotation(Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue())));
                } catch (Exception unused) {
                }
            }
        });
        ofFloat.start();
    }

    public void setGuideStep1() {
        this.imgTopOut.setAlpha(1.0f);
        this.tvBottom.setAlpha(1.0f);
        this.imgConnectStatus.setAlpha(0.3f);
    }

    public void setGuideStep2() {
        this.imgTopOut.setAlpha(0.3f);
        this.tvBottom.setAlpha(0.3f);
        this.imgConnectStatus.setAlpha(1.0f);
    }

    public void resetGuide() {
        this.imgTopOut.setAlpha(1.0f);
        this.tvBottom.setAlpha(1.0f);
        this.imgConnectStatus.setAlpha(1.0f);
    }

    public void setConnectedState() {
        if (this.connectState != 1) {
            this.connectState = 1;
        }
        this.tvBottom.setText(getContext().getString(C2640R.string.plane_connecting));
        this.imgTopOut.setImageResource(C2640R.mipmap.img_icon_connect_state_connected);
        setOnClickListener(null);
    }

    public void setCheckBtnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DDLog.m1684e("onDetachedFromWindow  6666");
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        State state;
        if (eventID == EventID.EVENT_CONNECT_STATE_CHANGED) {
            if (UsbConfig.isUsbConnected) {
                state = State.STATE_USB_CONNECT_REMOTER_FAIL;
                if (FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null) {
                    state = State.STATE_USB_CONNECT_REMOTER;
                }
                if (FlightRevData.get().getFlightRevUpgradeData().isUpgradeMode() && FlightRevData.get().getFlightRevConnectData().isWirelessConnected()) {
                    state = State.STATE_USB_FLIGHT_BOOTLOADER;
                }
                if (FlightConfig.isConnectFlight()) {
                    state = State.STATE_USB_CONNECT_FLIGHT;
                }
            } else {
                state = FlightConfig.isUsb() ? State.STATE_USB_NO_CONNECT : State.STATE_WIFI_NO_CONNECT;
                if (PhoneConfig.isConnectFlightWifi()) {
                    state = State.STATE_WIFI_CONNECT_FAIL;
                    if (FlightConfig.isConnectFlight()) {
                        state = State.STATE_WIFI_CONNECT_FLIGHT;
                    }
                    if (FlightRevData.get().getFlightRevStateData().isRemoterConnected()) {
                        state = State.STATE_WIFI_CONNECT_REMOTER;
                    }
                }
            }
            if (this.state != state) {
                setState(state);
            }
        }
    }

    public void setImageResource(int i) {
        this.imgConnectStatus.setImageResource(i);
    }

    public void setState(State state) {
        this.state = state;
        this.mainHandler.post(new Runnable() { // from class: com.ipotensic.potensicpro.view.ConnectStateView.2
            @Override // java.lang.Runnable
            public void run() {
                switch (C28573.$SwitchMap$com$ipotensic$baselib$enums$State[ConnectStateView.this.state.ordinal()]) {
                    case 1:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_usb_connect_status0);
                        break;
                    case 2:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_usb_connect_status0);
                        break;
                    case 3:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_usb_connect_status1);
                        break;
                    case 4:
                    case 5:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_usb_connect_status2);
                        break;
                    case 6:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_wifi_connect_status0);
                        break;
                    case 7:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_wifi_connect_status0);
                        break;
                    case 8:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_wifi_connect_status1);
                        break;
                    case 9:
                        ConnectStateView.this.imgConnectStatus.setImageResource(C2640R.mipmap.img_wifi_connect_status2);
                        break;
                }
                if (ConnectStateView.this.stateChangeListener != null) {
                    ConnectStateView.this.stateChangeListener.onStateChanged(ConnectStateView.this.state);
                }
            }
        });
    }

    /* renamed from: com.ipotensic.potensicpro.view.ConnectStateView$3 */
    static /* synthetic */ class C28573 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$State = iArr;
            try {
                iArr[State.STATE_USB_NO_CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_REMOTER_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_REMOTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_FLIGHT_BOOTLOADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_FLIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_NO_CONNECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_CONNECT_FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_CONNECT_FLIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_CONNECT_REMOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}