package com.ipotensic.kernel.controllers;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevPTZFeedbackData;

/* loaded from: classes2.dex */
public class PtzCalibrationController extends BaseController implements View.OnClickListener {
    private float curValue;
    private ConstraintLayout layoutPtzCal;
    private TextView tvPtzValue;

    public PtzCalibrationController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        view.findViewById(C1965R.id.btn_ptz_plus).setOnClickListener(this);
        view.findViewById(C1965R.id.btn_ptz_sub).setOnClickListener(this);
        this.tvPtzValue = (TextView) view.findViewById(C1965R.id.tv_ptz_value);
        this.layoutPtzCal = (ConstraintLayout) view.findViewById(C1965R.id.layout_ptz_micro_cal);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1965R.id.btn_ptz_plus) {
            float keepOneDigit = UnitUtil.keepOneDigit(this.curValue + 0.1f);
            FlightSendData.get().getSendPTZData().init(keepOneDigit > 3.0f ? 30 : (int) (keepOneDigit * 10.0f));
        } else if (view.getId() == C1965R.id.btn_ptz_sub) {
            float keepOneDigit2 = UnitUtil.keepOneDigit(this.curValue - 0.1f);
            FlightSendData.get().getSendPTZData().init(keepOneDigit2 < -3.0f ? -30 : (int) (keepOneDigit2 * 10.0f));
        }
        DataManager.getInstance().startSendPTZData();
    }

    public void update(FlightRevPTZFeedbackData flightRevPTZFeedbackData) {
        if (getBaseView() == null) {
            return;
        }
        float keepOneDigit = UnitUtil.keepOneDigit(flightRevPTZFeedbackData.getTrimValue() * 0.1f);
        this.curValue = keepOneDigit;
        TextView textView = this.tvPtzValue;
        if (textView != null) {
            if (keepOneDigit > 0.0f) {
                textView.setText("+" + this.curValue);
            } else if (keepOneDigit == 0.0f) {
                textView.setText(SessionDescription.SUPPORTED_SDP_VERSION);
            } else {
                textView.setText(this.curValue + "");
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        if (i == 0 && FlightConfig.is_Atom_Series()) {
            return;
        }
        super.setVisibility(i);
        if (i == 0 || getBaseView() != null) {
            if (i == 0) {
                AnimationUtil.transInBottom(getBaseView());
            } else {
                AnimationUtil.transOutBottom(getBaseView());
            }
        }
    }

    public void disConnect() {
        TextView textView = this.tvPtzValue;
        if (textView != null) {
            textView.setText("N/A");
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.PtzCalibrationController$1 */
    static /* synthetic */ class C21631 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (C21631.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] == 1 && this.layoutPtzCal != null) {
            if (FlightConfig.is_Atom_Series()) {
                this.layoutPtzCal.setVisibility(4);
            } else {
                this.layoutPtzCal.setVisibility(0);
            }
        }
    }
}