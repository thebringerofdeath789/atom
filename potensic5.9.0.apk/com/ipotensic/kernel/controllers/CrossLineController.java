package com.ipotensic.kernel.controllers;

import android.util.Size;
import android.view.View;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CrossView;
import com.logan.flight.FlightConfig;

/* loaded from: classes2.dex */
public class CrossLineController extends BaseController {
    private CrossView crossView;

    public CrossLineController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.crossView = (CrossView) view.findViewById(C1965R.id.cross_view);
    }

    public void config() {
        if (this.crossView != null) {
            if (FlightConfig.isAtomPanTilt() || FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) {
                this.crossView.setCrossShow(SPHelper.getInstance().isPreviewShowCross());
                this.crossView.setPointShow(SPHelper.getInstance().isPreviewShowDot());
            } else {
                this.crossView.setCrossShow(false);
                this.crossView.setPointShow(false);
            }
            this.crossView.setNineGridShow(SPHelper.getInstance().isPreviewShowLine());
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            config();
            if (PhoneConfig.showSize != null) {
                reLayoutGrid(PhoneConfig.showSize);
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.CrossLineController$1 */
    static /* synthetic */ class C21271 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GUIDE_LINE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_PREVIEW_VIDEO_SHOW_AREA_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C21271.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1 || i == 2) {
            config();
        } else if (i == 3 && PhoneConfig.showSize != null) {
            reLayoutGrid(PhoneConfig.showSize);
        }
    }

    private void reLayoutGrid(Size size) {
        if (getBaseView() != null) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(size.getWidth(), -1);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            getBaseView().setLayoutParams(layoutParams);
        }
    }
}