package com.ipotensic.kernel.controllers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IShakeTestView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TestMaintainController extends BaseController implements View.OnClickListener {
    private static final String TAG = "TestMaintainController";
    private EditText etTestTime;
    private EditText etThreshold;
    private final Handler handler;
    private boolean isTesting;
    private Integer testTime;
    private float threshold;
    private TextView tvResult;
    private TextView tvTest;
    private TextView tvXAxis;
    private TextView tvYAxis;
    private TextView tvZAxis;
    private final List<Float> xLists;
    private final List<Float> yLists;
    private final List<Float> zLists;

    public TestMaintainController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.xLists = new ArrayList();
        this.yLists = new ArrayList();
        this.zLists = new ArrayList();
        this.testTime = 30;
        this.threshold = 0.2f;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.controllers.TestMaintainController.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    int i = message.arg1;
                    boolean z = false;
                    if (i > 0) {
                        TestMaintainController.this.tvTest.setText("倒计时:" + i + "S");
                        Message obtain = Message.obtain();
                        obtain.what = 0;
                        obtain.arg1 = i - 1;
                        TestMaintainController.this.handler.sendMessageDelayed(obtain, 1000L);
                        return;
                    }
                    TestMaintainController.this.isTesting = false;
                    TestMaintainController.this.tvTest.setText("重试");
                    TestMaintainController.this.tvResult.setVisibility(0);
                    TestMaintainController testMaintainController = TestMaintainController.this;
                    float result = testMaintainController.getResult(testMaintainController.xLists);
                    TestMaintainController testMaintainController2 = TestMaintainController.this;
                    float result2 = testMaintainController2.getResult(testMaintainController2.yLists);
                    TestMaintainController testMaintainController3 = TestMaintainController.this;
                    float result3 = testMaintainController3.getResult(testMaintainController3.zLists);
                    TestMaintainController.this.tvXAxis.setText("X轴:" + result);
                    TestMaintainController.this.tvYAxis.setText("Y轴:" + result2);
                    TestMaintainController.this.tvZAxis.setText("Z轴:" + result3);
                    if (result <= TestMaintainController.this.threshold && result2 <= TestMaintainController.this.threshold && result3 <= TestMaintainController.this.threshold) {
                        z = true;
                    }
                    if (z) {
                        TestMaintainController.this.tvResult.setText("PASS");
                        TestMaintainController.this.tvResult.setTextColor(ContextCompat.getColor(TestMaintainController.this.getContext(), R.color.color_connect_green));
                    } else {
                        TestMaintainController.this.tvResult.setText("FAIL");
                        TestMaintainController.this.tvResult.setTextColor(ContextCompat.getColor(TestMaintainController.this.getContext(), R.color.color_disconnect_red));
                    }
                }
            }
        };
        view.setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_MAINTAIN ? 0 : 8);
        if (PhoneConfig.PACK_TYPE == PackageType.TYPE_MAINTAIN) {
            initData();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            initData();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvTest = (TextView) view.findViewById(R.id.tv_test);
        this.tvResult = (TextView) view.findViewById(R.id.tv_result);
        this.tvXAxis = (TextView) view.findViewById(R.id.x_axis);
        this.tvYAxis = (TextView) view.findViewById(R.id.y_axis);
        this.tvZAxis = (TextView) view.findViewById(R.id.z_axis);
        this.etThreshold = (EditText) view.findViewById(R.id.et_threshold);
        this.etTestTime = (EditText) view.findViewById(R.id.et_test_time);
        this.etThreshold.addTextChangedListener(new TextWatcher() { // from class: com.ipotensic.kernel.controllers.TestMaintainController.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                try {
                    TestMaintainController.this.threshold = Float.parseFloat(obj);
                    SPHelper.getInstance().putFloat(SPHelper.KEY_MAINTAIN_THRESHOLD, TestMaintainController.this.threshold);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.etTestTime.addTextChangedListener(new TextWatcher() { // from class: com.ipotensic.kernel.controllers.TestMaintainController.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                try {
                    TestMaintainController.this.testTime = Integer.valueOf(Integer.parseInt(obj));
                    SPHelper.getInstance().putString(SPHelper.KEY_MAINTAIN_TEST_TIME, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.tvTest.setOnClickListener(this);
    }

    private void requestShakeTestData() {
        UserRequestPresenter.getInstance().getShakeTestValue(PhoneConfig.usrToken, new IShakeTestView() { // from class: com.ipotensic.kernel.controllers.TestMaintainController.3
            @Override // com.logan.user.view.IShakeTestView
            public void success(float f) {
                DDLog.d(TestMaintainController.TAG, "success:" + f);
                TestMaintainController.this.threshold = f;
                SPHelper.getInstance().putFloat(SPHelper.KEY_MAINTAIN_THRESHOLD, f);
                TestMaintainController.this.etThreshold.setText(String.valueOf(TestMaintainController.this.threshold));
            }

            @Override // com.logan.user.view.IShakeTestView
            public void fail(int i) {
                DDLog.d(TestMaintainController.TAG, "fail code:" + i);
                if (TestMaintainController.this.getBaseView().getVisibility() == 0) {
                    ToastUtil.toast(TestMaintainController.this.getContext(), "get shake test data fail");
                    float f = SPHelper.getInstance().getFloat(SPHelper.KEY_MAINTAIN_THRESHOLD);
                    if (f > 0.0f) {
                        TestMaintainController.this.threshold = f;
                        TestMaintainController.this.etThreshold.setText(String.valueOf(TestMaintainController.this.threshold));
                    }
                }
            }
        });
    }

    public void initData() {
        requestShakeTestData();
        String string = SPHelper.getInstance().getString(SPHelper.KEY_MAINTAIN_TEST_TIME);
        if (!TextUtils.isEmpty(string)) {
            try {
                this.testTime = Integer.valueOf(Integer.parseInt(string));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.etTestTime.setText(String.valueOf(this.testTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getResult(List<Float> list) {
        Iterator<Float> it = list.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        return f / this.xLists.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.etThreshold.clearFocus();
        this.etTestTime.clearFocus();
        if (view.getId() == R.id.tv_test) {
            if (FlightConfig.curFlight != null && FlightRevData.get().getFlightRevStateData().isFlight()) {
                if (this.isTesting) {
                    return;
                }
                this.isTesting = true;
                Message obtain = Message.obtain();
                obtain.what = 0;
                try {
                    obtain.arg1 = Integer.parseInt(this.etTestTime.getText().toString());
                } catch (Exception unused) {
                }
                this.handler.sendMessage(obtain);
                this.tvResult.setVisibility(8);
                return;
            }
            ToastUtil.toast(getContext(), "无人机必须在飞行状态");
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        UserRequestPresenter.getInstance().getShakeTestValue(PhoneConfig.usrToken, null);
        this.isTesting = false;
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestMaintainController$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GEO_CALIBRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        FlightRevGeoTestData geoTestData;
        super.onEvent(eventID, event);
        if (AnonymousClass5.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] == 1 && (geoTestData = FlightRevData.get().getGeoTestData()) != null && this.isTesting) {
            float xGyro = geoTestData.getXGyro();
            float yGyro = geoTestData.getYGyro();
            float zGyro = geoTestData.getZGyro();
            this.xLists.add(Float.valueOf(xGyro));
            this.yLists.add(Float.valueOf(yGyro));
            this.zLists.add(Float.valueOf(zGyro));
            this.tvXAxis.setText("X轴:" + xGyro);
            this.tvYAxis.setText("Y轴:" + yGyro);
            this.tvZAxis.setText("Z轴:" + zGyro);
            DDLog.d(TAG, "X=" + xGyro + ",Y=" + yGyro + ",Z=" + zGyro);
        }
    }
}
