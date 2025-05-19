package com.ipotensic.kernel.controllers;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.UpDownSlideView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightSendData;

/* loaded from: classes2.dex */
public class SlideController extends BaseController {
    private UpDownSlideView slideView;

    public SlideController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        UpDownSlideView upDownSlideView = (UpDownSlideView) view.findViewById(R.id.view_slide);
        this.slideView = upDownSlideView;
        upDownSlideView.setSlideListener(new UpDownSlideView.OnSlideListener() { // from class: com.ipotensic.kernel.controllers.SlideController.1
            @Override // com.ipotensic.kernel.view.UpDownSlideView.OnSlideListener
            public void onSlideValue(int i) {
                FlightSendData.get().getSend4AxisData().setGimbal(i);
            }
        });
        this.slideView.setVisibility(FlightConfig.is_Atom_Series() ? 8 : 0);
    }

    /* renamed from: com.ipotensic.kernel.controllers.SlideController$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
        if (AnonymousClass2.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] != 1) {
            return;
        }
        this.slideView.setVisibility(FlightConfig.is_Atom_Series() ? 8 : 0);
    }
}
