package com.ipotensic.kernel.controllers;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevConnectData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.BooleanUtils;

/* compiled from: TestFpvController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ipotensic/kernel/controllers/TestFpvController;", "Lcom/ipotensic/kernel/controllers/BaseController;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "view", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/View;)V", "scrollView", "Landroid/widget/ScrollView;", "tvBand", "Landroid/widget/TextView;", "tvFpvPrint", "tvFreqHopping", "tvLost", "tvRssi", "initView", "", "baseView", "isScrollToBottom", "", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestFpvController extends BaseController {
    private ScrollView scrollView;
    private TextView tvBand;
    private TextView tvFpvPrint;
    private TextView tvFreqHopping;
    private TextView tvLost;
    private TextView tvRssi;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventID.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 1;
            iArr[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestFpvController(AppCompatActivity activity, View view) {
        super(activity, view);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(view, "view");
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View baseView) {
        if (baseView != null) {
            View findViewById = baseView.findViewById(R.id.tv_rssi);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvRssi = (TextView) findViewById;
            View findViewById2 = baseView.findViewById(R.id.tv_lost);
            if (findViewById2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvLost = (TextView) findViewById2;
            View findViewById3 = baseView.findViewById(R.id.tv_band);
            if (findViewById3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvBand = (TextView) findViewById3;
            View findViewById4 = baseView.findViewById(R.id.tv_freq_hopping);
            if (findViewById4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvFreqHopping = (TextView) findViewById4;
            View findViewById5 = baseView.findViewById(R.id.scroll_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "it.findViewById(R.id.scroll_view)");
            this.scrollView = (ScrollView) findViewById5;
            View findViewById6 = baseView.findViewById(R.id.tv_msg);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "it.findViewById(R.id.tv_msg)");
            this.tvFpvPrint = (TextView) findViewById6;
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        super.onEvent(what, event);
        if (what == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[what.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            TextView textView = this.tvRssi;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvRssi");
            }
            textView.setText("NA");
            TextView textView2 = this.tvLost;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLost");
            }
            textView2.setText("NA");
            TextView textView3 = this.tvBand;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBand");
            }
            textView3.setText("NA");
            TextView textView4 = this.tvFreqHopping;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvFreqHopping");
            }
            textView4.setText("NA");
            return;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevConnectData connectData = flightRevData.getFlightRevConnectData();
        TextView textView5 = this.tvRssi;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRssi");
        }
        Intrinsics.checkExpressionValueIsNotNull(connectData, "connectData");
        textView5.setText(String.valueOf(connectData.getRssi()));
        TextView textView6 = this.tvLost;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLost");
        }
        textView6.setText(String.valueOf(connectData.getChannel()));
        TextView textView7 = this.tvBand;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBand");
        }
        textView7.setText(connectData.isHighDbm() ? "\u9ad8\u529f\u7387" : "\u4f4e\u529f\u7387");
        TextView textView8 = this.tvFreqHopping;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFreqHopping");
        }
        textView8.setText(connectData.isSupportFreqHopping() ? BooleanUtils.TRUE : "false");
    }

    private final boolean isScrollToBottom() {
        try {
            ScrollView scrollView = this.scrollView;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            }
            View childView = scrollView.getChildAt(0);
            Intrinsics.checkExpressionValueIsNotNull(childView, "childView");
            int measuredHeight = childView.getMeasuredHeight();
            ScrollView scrollView2 = this.scrollView;
            if (scrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            }
            int scrollY = scrollView2.getScrollY();
            ScrollView scrollView3 = this.scrollView;
            if (scrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            }
            return measuredHeight <= scrollY + scrollView3.getHeight();
        } catch (Exception unused) {
            return false;
        }
    }
}