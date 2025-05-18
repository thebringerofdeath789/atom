package com.ipotensic.kernel.controllers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.FormView;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevGeneralData;
import com.logan.flight.data.send.SendGeneralData;
import com.logan.flight.enums.CommonMsgType;
import com.logan.flight.enums.GeneralCommand;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TestSixImuCalibrationController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0016J\u001c\u0010)\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0006\u0010.\u001a\u00020'J\u0016\u0010/\u001a\u00020'2\u000e\b\u0001\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u0016\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u000202J\u0012\u00106\u001a\u00020'2\b\u00107\u001a\u0004\u0018\u000108H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000bj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000bj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000bj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u00069"}, m2338d2 = {"Lcom/ipotensic/kernel/controllers/TestSixImuCalibrationController;", "Lcom/ipotensic/kernel/controllers/BaseController;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "view", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/View;)V", "btnExit", "Landroid/widget/Button;", "btnStartCal", "dataList", "Ljava/util/ArrayList;", "", "", "Lkotlin/collections/ArrayList;", "dataList1", "dataList2", "dataList3", "formView", "Lcom/ipotensic/kernel/view/FormView;", "isFinishAbove", "Landroidx/databinding/ObservableBoolean;", "isFinishBack", "isFinishBelow", "isFinishFront", "isFinishLeft", "isFinishRight", "isStartCalibration", "startTime", "", "tvAbove", "Landroid/widget/TextView;", "tvBack", "tvBelow", "tvFront", "tvLeft", "tvRight", "tvState", "initView", "", "baseView", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "sendStartCalibration", "sendStopCalibration", "resultListener", "Lcom/ipotensic/baselib/listener/SimpleResultListener;", "", "setSelectBg", "tv", "isSelect", "showXyz", "imuCalResult", "Lcom/logan/flight/data/recv/FlightRevGeneralData$ImuCalResult;", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestSixImuCalibrationController extends BaseController {
    private Button btnExit;
    private Button btnStartCal;
    private final ArrayList<List<String>> dataList;
    private final ArrayList<String> dataList1;
    private final ArrayList<String> dataList2;
    private final ArrayList<String> dataList3;
    private FormView formView;
    private final ObservableBoolean isFinishAbove;
    private final ObservableBoolean isFinishBack;
    private final ObservableBoolean isFinishBelow;
    private final ObservableBoolean isFinishFront;
    private final ObservableBoolean isFinishLeft;
    private final ObservableBoolean isFinishRight;
    private final ObservableBoolean isStartCalibration;
    private long startTime;
    private TextView tvAbove;
    private TextView tvBack;
    private TextView tvBelow;
    private TextView tvFront;
    private TextView tvLeft;
    private TextView tvRight;
    private TextView tvState;

    @Metadata(m2336bv = {1, 0, 3}, m2339k = 3, m2340mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventID.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventID.FLIGHT_RECEIVE_GENERAL_DATA.ordinal()] = 1;
            iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestSixImuCalibrationController(AppCompatActivity activity, View view) {
        super(activity, view);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(view, "view");
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.isStartCalibration = observableBoolean;
        ObservableBoolean observableBoolean2 = new ObservableBoolean(false);
        this.isFinishAbove = observableBoolean2;
        ObservableBoolean observableBoolean3 = new ObservableBoolean(false);
        this.isFinishBelow = observableBoolean3;
        ObservableBoolean observableBoolean4 = new ObservableBoolean(false);
        this.isFinishBack = observableBoolean4;
        ObservableBoolean observableBoolean5 = new ObservableBoolean(false);
        this.isFinishFront = observableBoolean5;
        ObservableBoolean observableBoolean6 = new ObservableBoolean(false);
        this.isFinishLeft = observableBoolean6;
        ObservableBoolean observableBoolean7 = new ObservableBoolean(false);
        this.isFinishRight = observableBoolean7;
        this.dataList1 = new ArrayList<>();
        this.dataList2 = new ArrayList<>();
        this.dataList3 = new ArrayList<>();
        this.dataList = new ArrayList<>();
        observableBoolean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (!TestSixImuCalibrationController.this.isStartCalibration.get()) {
                    TestSixImuCalibrationController.this.sendStopCalibration(new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$1$onPropertyChanged$1
                        @Override // com.ipotensic.baselib.listener.SimpleResultListener
                        public final void onResult(Boolean bool) {
                        }
                    });
                    TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setText("开启校准");
                    TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setTextColor(TestSixImuCalibrationController.this.getContext().getColor(C1965R.color.white));
                    TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setBackgroundResource(C1965R.drawable.bg_blue_solid_4_shape);
                    return;
                }
                TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setText("停止校准");
                TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setTextColor(TestSixImuCalibrationController.this.getContext().getColor(C1965R.color.color_disconnect_red));
                TestSixImuCalibrationController.access$getBtnStartCal$p(TestSixImuCalibrationController.this).setBackgroundResource(C1965R.drawable.bg_green_solid_4_shape);
            }
        });
        observableBoolean2.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.2
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvAbove$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishAbove.get());
            }
        });
        observableBoolean3.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.3
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvBelow$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishBelow.get());
            }
        });
        observableBoolean6.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.4
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvLeft$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishLeft.get());
            }
        });
        observableBoolean7.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.5
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvRight$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishRight.get());
            }
        });
        observableBoolean4.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.6
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvBack$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishBack.get());
            }
        });
        observableBoolean5.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController.7
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                TestSixImuCalibrationController testSixImuCalibrationController = TestSixImuCalibrationController.this;
                testSixImuCalibrationController.setSelectBg(TestSixImuCalibrationController.access$getTvFront$p(testSixImuCalibrationController), TestSixImuCalibrationController.this.isFinishFront.get());
            }
        });
    }

    public static final /* synthetic */ Button access$getBtnStartCal$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        Button button = testSixImuCalibrationController.btnStartCal;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnStartCal");
        }
        return button;
    }

    public static final /* synthetic */ TextView access$getTvAbove$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvAbove;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAbove");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvBack$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvBack;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBack");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvBelow$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvBelow;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvBelow");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvFront$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvFront;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFront");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvLeft$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvLeft;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLeft");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvRight$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvRight;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvRight");
        }
        return textView;
    }

    public static final /* synthetic */ TextView access$getTvState$p(TestSixImuCalibrationController testSixImuCalibrationController) {
        TextView textView = testSixImuCalibrationController.tvState;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvState");
        }
        return textView;
    }

    public final void setSelectBg(TextView tv2, boolean isSelect) {
        Intrinsics.checkParameterIsNotNull(tv2, "tv");
        tv2.setBackgroundColor(getContext().getColor(isSelect ? C1965R.color.color_connect_green : C1965R.color.color_gray));
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View baseView) {
        Intrinsics.checkParameterIsNotNull(baseView, "baseView");
        View findViewById = baseView.findViewById(C1965R.id.btn_start);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "baseView.findViewById(R.id.btn_start)");
        this.btnStartCal = (Button) findViewById;
        View findViewById2 = baseView.findViewById(C1965R.id.btn_quit);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "baseView.findViewById(R.id.btn_quit)");
        this.btnExit = (Button) findViewById2;
        View findViewById3 = baseView.findViewById(C1965R.id.tv_up);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "baseView.findViewById(R.id.tv_up)");
        this.tvAbove = (TextView) findViewById3;
        View findViewById4 = baseView.findViewById(C1965R.id.tv_below);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "baseView.findViewById(R.id.tv_below)");
        this.tvBelow = (TextView) findViewById4;
        View findViewById5 = baseView.findViewById(C1965R.id.tv_back);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "baseView.findViewById(R.id.tv_back)");
        this.tvBack = (TextView) findViewById5;
        View findViewById6 = baseView.findViewById(C1965R.id.tv_front);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "baseView.findViewById(R.id.tv_front)");
        this.tvFront = (TextView) findViewById6;
        View findViewById7 = baseView.findViewById(C1965R.id.tv_left);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "baseView.findViewById(R.id.tv_left)");
        this.tvLeft = (TextView) findViewById7;
        View findViewById8 = baseView.findViewById(C1965R.id.tv_right);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "baseView.findViewById(R.id.tv_right)");
        this.tvRight = (TextView) findViewById8;
        View findViewById9 = baseView.findViewById(C1965R.id.tv_state);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "baseView.findViewById(R.id.tv_state)");
        this.tvState = (TextView) findViewById9;
        View findViewById10 = baseView.findViewById(C1965R.id.form);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "baseView.findViewById(R.id.form)");
        this.formView = (FormView) findViewById10;
        baseView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add("X");
        arrayList.add("Y");
        arrayList.add("Z");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("ACC");
        arrayList2.add("GYRO");
        arrayList2.add("SCALE");
        arrayList2.add("OFFSET");
        FormView formView = this.formView;
        if (formView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formView");
        }
        formView.setTransverse(arrayList, "VALUE", "件");
        FormView formView2 = this.formView;
        if (formView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formView");
        }
        formView2.setLongitudinal(arrayList2, "ITEM", "");
        Button button = this.btnStartCal;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnStartCal");
        }
        button.setOnClickListener(new TestSixImuCalibrationController$initView$2(this, 500));
        Button button2 = this.btnExit;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnExit");
        }
        button2.setOnClickListener(new TestSixImuCalibrationController$initView$3(this, 500));
    }

    public final void sendStartCalibration() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$sendStartCalibration$1
            @Override // java.lang.Runnable
            public final void run() {
                for (int i = 0; i <= 5; i++) {
                    try {
                        if (!FlightConfig.isConnectFlight()) {
                            break;
                        }
                        FlightSendData flightSendData = FlightSendData.get();
                        Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                        flightSendData.getSendGeneralData().setDataType(CommonMsgType.STOP_IMU_CALIBRATION);
                        DataManager.getInstance().sendGeneralData();
                        Thread.sleep(20L);
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (FlightConfig.isConnectFlight()) {
                    FlightSendData flightSendData2 = FlightSendData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightSendData2, "FlightSendData.get()");
                    flightSendData2.getSendGeneralData().setDataType(CommonMsgType.START_IMU_CALIBRATION);
                    DataManager.getInstance().sendGeneralData();
                    StringBuilder append = new StringBuilder().append("发送IMU校准数据:");
                    FlightSendData flightSendData3 = FlightSendData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightSendData3, "FlightSendData.get()");
                    SendGeneralData sendGeneralData = flightSendData3.getSendGeneralData();
                    Intrinsics.checkExpressionValueIsNotNull(sendGeneralData, "FlightSendData.get().sendGeneralData");
                    DDLog.m1684e(append.append(ParseUtil.byteToHexString(sendGeneralData.getBytes())).toString());
                }
            }
        });
    }

    public final void sendStopCalibration(final SimpleResultListener<Boolean> resultListener) {
        Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$sendStopCalibration$1
            @Override // java.lang.Runnable
            public final void run() {
                for (int i = 0; i <= 5; i++) {
                    try {
                        if (!FlightConfig.isConnectFlight()) {
                            break;
                        }
                        DDLog.m1684e("发送imu校准结束");
                        FlightSendData flightSendData = FlightSendData.get();
                        Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                        flightSendData.getSendGeneralData().setDataType(CommonMsgType.STOP_IMU_CALIBRATION);
                        DataManager.getInstance().sendGeneralData();
                        Thread.sleep(50L);
                    } catch (Exception unused) {
                        return;
                    }
                }
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestSixImuCalibrationController$sendStopCalibration$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleResultListener.this.onResult(true);
                    }
                });
            }
        });
    }

    private final void showXyz(FlightRevGeneralData.ImuCalResult imuCalResult) {
        if (imuCalResult != null) {
            this.dataList1.clear();
            this.dataList1.add(String.valueOf(imuCalResult.getAcc_raw_x()));
            this.dataList1.add(String.valueOf(imuCalResult.getGyro_raw_x()));
            this.dataList1.add(String.valueOf(imuCalResult.getScale_x()));
            this.dataList1.add(String.valueOf(imuCalResult.getOffset_x()));
            this.dataList2.clear();
            this.dataList2.add(String.valueOf(imuCalResult.getAcc_raw_y()));
            this.dataList2.add(String.valueOf(imuCalResult.getGyro_raw_y()));
            this.dataList2.add(String.valueOf(imuCalResult.getScale_y()));
            this.dataList2.add(String.valueOf(imuCalResult.getOffset_y()));
            this.dataList3.clear();
            this.dataList3.add(String.valueOf(imuCalResult.getAcc_raw_z()));
            this.dataList3.add(String.valueOf(imuCalResult.getGyro_raw_z()));
            this.dataList3.add(String.valueOf(imuCalResult.getScale_z()));
            this.dataList3.add(String.valueOf(imuCalResult.getOffset_z()));
            this.dataList.clear();
            this.dataList.add(this.dataList1);
            this.dataList.add(this.dataList2);
            this.dataList.add(this.dataList3);
            FormView formView = this.formView;
            if (formView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("formView");
            }
            formView.setData(this.dataList);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        super.onEvent(what, event);
        if (what == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[what.ordinal()];
        if (i == 1) {
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevGeneralData revGeneralData = flightRevData.getRevGeneralData();
            if (revGeneralData.getCommand() == GeneralCommand.IMU_CAL_RESULT) {
                if (revGeneralData.getImuCalResult().get校准开启()) {
                    this.isStartCalibration.set(true);
                    TextView textView = this.tvState;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView.setText("校准中...");
                    TextView textView2 = this.tvState;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView2.setTextColor(getContext().getColor(C1965R.color.color_default_value_blue));
                } else if (revGeneralData.getImuCalResult().get校准完成()) {
                    this.isStartCalibration.set(false);
                    TextView textView3 = this.tvState;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView3.setText("校准成功");
                    TextView textView4 = this.tvState;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView4.setTextColor(getContext().getColor(C1965R.color.color_progress_green));
                } else if (revGeneralData.getImuCalResult().get校准失败()) {
                    this.isStartCalibration.set(false);
                    TextView textView5 = this.tvState;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView5.setText("校准失败");
                    TextView textView6 = this.tvState;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView6.setTextColor(getContext().getColor(C1965R.color.color_disconnect_red));
                } else if (revGeneralData.getImuCalResult().get校准超时()) {
                    this.isStartCalibration.set(false);
                    TextView textView7 = this.tvState;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView7.setText("校准失败(超时)");
                    TextView textView8 = this.tvState;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvState");
                    }
                    textView8.setTextColor(getContext().getColor(C1965R.color.color_disconnect_red));
                }
                this.isFinishAbove.set(revGeneralData.getImuCalResult().getIsAboveFinish());
                this.isFinishBelow.set(revGeneralData.getImuCalResult().getIsBelowFinish());
                this.isFinishLeft.set(revGeneralData.getImuCalResult().getIsLeftFinish());
                this.isFinishRight.set(revGeneralData.getImuCalResult().getIsRightFinish());
                this.isFinishBack.set(revGeneralData.getImuCalResult().getIsBackFinish());
                this.isFinishFront.set(revGeneralData.getImuCalResult().getIsFrontFinish());
                if (!revGeneralData.getImuCalResult().get校准开启()) {
                    showXyz(revGeneralData.getImuCalResult());
                    return;
                } else {
                    if (System.currentTimeMillis() - this.startTime > 500) {
                        this.startTime = System.currentTimeMillis();
                        showXyz(revGeneralData.getImuCalResult());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i == 2 && !FlightConfig.isConnectFlight()) {
            this.isStartCalibration.set(false);
            TextView textView9 = this.tvState;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvState");
            }
            textView9.setText("");
        }
    }
}