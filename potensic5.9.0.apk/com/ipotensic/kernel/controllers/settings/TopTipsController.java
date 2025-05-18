package com.ipotensic.kernel.controllers.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.audio.AacUtil;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.BaseController;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevStateData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: TopTipsController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m2338d2 = {"Lcom/ipotensic/kernel/controllers/settings/TopTipsController;", "Lcom/ipotensic/kernel/controllers/BaseController;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "baseView", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/View;)V", "countDownNum", "", "handler", "Landroid/os/Handler;", "isShowLandingTip", "", "ivClose", "Landroid/widget/ImageView;", "onClose", "Lkotlin/Function0;", "", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "setOnClose", "(Lkotlin/jvm/functions/Function0;)V", "tvContent", "Landroid/widget/TextView;", "tvCountDown", "windCount", "close", "initView", "isWinTips", "onDestroy", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "setContent", "idRes", "Companion", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TopTipsController extends BaseController {
    public static final int TIME_COUNT_DOWN = 5;
    private int countDownNum;
    private final Handler handler;
    private boolean isShowLandingTip;
    private ImageView ivClose;
    private Function0<Unit> onClose;
    private TextView tvContent;
    private TextView tvCountDown;
    private int windCount;

    @Metadata(m2336bv = {1, 0, 3}, m2339k = 3, m2340mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventID.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 1;
            iArr[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 2;
            iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopTipsController(AppCompatActivity activity, View baseView) {
        super(activity, baseView);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(baseView, "baseView");
        this.countDownNum = 5;
        final Looper mainLooper = Looper.getMainLooper();
        this.handler = new Handler(mainLooper) { // from class: com.ipotensic.kernel.controllers.settings.TopTipsController$handler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                int i;
                int i2;
                int i3;
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                TextView access$getTvCountDown$p = TopTipsController.access$getTvCountDown$p(TopTipsController.this);
                StringBuilder append = new StringBuilder().append(PropertyUtils.MAPPED_DELIM);
                i = TopTipsController.this.countDownNum;
                access$getTvCountDown$p.setText(append.append(i).append("s)").toString());
                i2 = TopTipsController.this.countDownNum;
                if (i2 <= 0) {
                    TopTipsController.this.close();
                    return;
                }
                TopTipsController topTipsController = TopTipsController.this;
                i3 = topTipsController.countDownNum;
                topTipsController.countDownNum = i3 - 1;
                sendEmptyMessageDelayed(0, 1000L);
            }
        };
    }

    public static final /* synthetic */ TextView access$getTvCountDown$p(TopTipsController topTipsController) {
        TextView textView = topTipsController.tvCountDown;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCountDown");
        }
        return textView;
    }

    public final Function0<Unit> getOnClose() {
        return this.onClose;
    }

    public final void setOnClose(Function0<Unit> function0) {
        this.onClose = function0;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View baseView) {
        Intrinsics.checkParameterIsNotNull(baseView, "baseView");
        View findViewById = baseView.findViewById(C1965R.id.tv_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "baseView.findViewById(R.id.tv_content)");
        this.tvContent = (TextView) findViewById;
        View findViewById2 = baseView.findViewById(C1965R.id.tv_count_down);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "baseView.findViewById(R.id.tv_count_down)");
        this.tvCountDown = (TextView) findViewById2;
        View findViewById3 = baseView.findViewById(C1965R.id.iv_close);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "baseView.findViewById(R.id.iv_close)");
        ImageView imageView = (ImageView) findViewById3;
        this.ivClose = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.settings.TopTipsController$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopTipsController.this.close();
            }
        });
    }

    public final void setContent(int idRes) {
        if (getVisibility() == 8) {
            DDLog.m1684e("isReturning22 windCount " + this.windCount);
            TextView textView = this.tvContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            }
            textView.setText(idRes);
            this.countDownNum = 5;
            this.handler.sendEmptyMessage(0);
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close() {
        if (isWinTips()) {
            this.windCount = 0;
            FlightConfig.windStrongStartTime = System.currentTimeMillis();
            DDLog.m1684e("isReturning33 windCount " + this.windCount);
        }
        Function0<Unit> function0 = this.onClose;
        if (function0 != null) {
            function0.invoke();
        }
        setVisibility(8);
        this.handler.removeMessages(0);
    }

    private final boolean isWinTips() {
        TextView textView = this.tvContent;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
        }
        if (!Intrinsics.areEqual(textView.getText(), getContext().getString(C1965R.string.dialog_return_strong_wind_tips))) {
            TextView textView2 = this.tvContent;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            }
            if (!Intrinsics.areEqual(textView2.getText(), getContext().getString(C1965R.string.dialog_strong_wind_tips))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        Intrinsics.checkParameterIsNotNull(what, "what");
        super.onEvent(what, event);
        int i = WhenMappings.$EnumSwitchMapping$0[what.ordinal()];
        if (i == 1) {
            if (System.currentTimeMillis() - FlightConfig.windStrongStartTime < AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND) {
                this.windCount = 0;
                return;
            }
            if (event == null) {
                Intrinsics.throwNpe();
            }
            Object obj = event.obj;
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.logan.flight.data.recv.FlightRevFlightInfoData");
            }
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevStateData revStateData = flightRevData.getFlightRevStateData();
            if (((FlightRevFlightInfoData) obj).getWindSpeed() >= 10) {
                int i2 = this.windCount + 1;
                this.windCount = i2;
                if (i2 >= 12) {
                    DDLog.m1684e("windCount " + this.windCount);
                    Intrinsics.checkExpressionValueIsNotNull(revStateData, "revStateData");
                    if (!revStateData.isFlight() || revStateData.isLanding()) {
                        return;
                    }
                    if (revStateData.isReturning()) {
                        setContent(C1965R.string.dialog_return_strong_wind_tips);
                        return;
                    } else {
                        setContent(C1965R.string.dialog_strong_wind_tips);
                        return;
                    }
                }
                return;
            }
            this.windCount = 0;
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            if (event == null) {
                Intrinsics.throwNpe();
            }
            Object obj2 = event.obj;
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            if (((Boolean) obj2).booleanValue()) {
                return;
            }
            close();
            FlightConfig.windStrongStartTime = 0L;
            this.isShowLandingTip = false;
            return;
        }
        if (event == null) {
            Intrinsics.throwNpe();
        }
        Object obj3 = event.obj;
        if (obj3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.logan.flight.data.recv.FlightRevStateData");
        }
        FlightRevStateData flightRevStateData = (FlightRevStateData) obj3;
        if (FlightConfig.is_Atom_Series()) {
            if (flightRevStateData.isLanding()) {
                FlightRevData flightRevData2 = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
                if (!flightRevData2.getNoFlyZoneData().getIsLocatedNoFlyZone()) {
                    if (getVisibility() != 8 || this.isShowLandingTip) {
                        return;
                    }
                    this.isShowLandingTip = true;
                    setContent(C1965R.string.rocker_controller_landing);
                    return;
                }
            }
            this.isShowLandingTip = false;
            if (getVisibility() == 0) {
                TextView textView = this.tvContent;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvContent");
                }
                if (Intrinsics.areEqual(textView.getText(), getContext().getString(C1965R.string.rocker_controller_landing))) {
                    close();
                }
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (isWinTips() && getVisibility() == 0) {
            FlightConfig.windStrongStartTime = 0L;
        }
        this.handler.removeMessages(0);
    }
}