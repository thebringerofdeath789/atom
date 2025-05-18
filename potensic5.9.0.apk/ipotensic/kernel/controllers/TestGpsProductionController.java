package com.ipotensic.kernel.controllers;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.manager.TestGpsProductionCache;
import com.ipotensic.kernel.manager.TestGpsProductionRequest;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevGpsTestData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TestGpsProductionController extends BaseController {
    private static final int GPS_READY_TIMEOUT = 60000;
    private final int OFFLINE_TIMEOUT;
    private Button btnModel;
    private final Handler handler;
    private boolean isResultShow;
    private RelativeLayout layoutDetail;
    private TestGpsProductionCache modelCache;
    private final TestGpsProductionCache.OnCacheListener modelCacheListener;
    private TestGpsProductionRequest.NewestModelData newestModelData;
    private final Runnable offlineRunnable;
    private FileOutputStream outputStream;
    private TestGpsProductionCache testCache;
    private final TestGpsProductionCache.OnCacheListener testCacheListener;
    private TestType testType;
    private TextView tvState;

    public enum TestType {
        TYPE_MODEL,
        TYPE_TEST,
        TYPE_NONE
    }

    public TestGpsProductionController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.OFFLINE_TIMEOUT = 5000;
        this.isResultShow = false;
        this.newestModelData = null;
        this.handler = new Handler();
        this.testType = TestType.TYPE_NONE;
        this.offlineRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.1
            @Override // java.lang.Runnable
            public void run() {
                if (TestGpsProductionController.this.tvState == null || TestGpsProductionController.this.testType != TestType.TYPE_MODEL) {
                    return;
                }
                TestGpsProductionController.this.tvState.setText("\u91d1\u673a\u79bb\u7ebf");
            }
        };
        this.modelCacheListener = new AnonymousClass2();
        this.outputStream = null;
        this.testCacheListener = new AnonymousClass3();
        if (PhoneConfig.PACK_TYPE == PackageType.TYPE_MODEL) {
            setGpsTestType(TestType.TYPE_MODEL);
        } else if (PhoneConfig.PACK_TYPE == PackageType.TYPE_GPS) {
            setGpsTestType(TestType.TYPE_TEST);
        } else {
            setGpsTestType(TestType.TYPE_NONE);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.modelCache = new TestGpsProductionCache(30000L, this.modelCacheListener);
        this.testCache = new TestGpsProductionCache(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this.testCacheListener);
        finishSave();
        this.btnModel = (Button) view.findViewById(R.id.btn_model);
        this.tvState = (TextView) view.findViewById(R.id.tv_state);
        this.layoutDetail = (RelativeLayout) view.findViewById(R.id.layout_detail);
    }

    public void setGpsTestType(TestType testType) {
        this.testType = testType;
        if (testType == TestType.TYPE_MODEL) {
            this.btnModel.setBackgroundColor(getContext().getResources().getColor(R.color.color_connect_green));
            this.btnModel.setText("\u91d1\u673a\u7aef");
            this.layoutDetail.setVisibility(0);
            this.modelCache = new TestGpsProductionCache(30000L, this.modelCacheListener);
            setVisibility(0);
            return;
        }
        if (testType == TestType.TYPE_TEST) {
            this.btnModel.setBackgroundColor(getContext().getResources().getColor(R.color.color_connect_green));
            this.btnModel.setText("\u6d4b\u8bd5\u673a\u7aef");
            this.layoutDetail.setVisibility(0);
            this.testCache = new TestGpsProductionCache(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this.testCacheListener);
            finishSave();
            this.isResultShow = false;
            this.newestModelData = null;
            setVisibility(0);
            return;
        }
        if (testType == TestType.TYPE_NONE) {
            this.layoutDetail.setVisibility(8);
            setVisibility(8);
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GPS_TEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass4.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            FlightRevGpsTestData flightRevGpsTestData = (FlightRevGpsTestData) event.obj;
            if (flightRevGpsTestData != null) {
                if (!flightRevGpsTestData.isGpsReady()) {
                    if (this.testType == TestType.TYPE_TEST && flightRevGpsTestData.getTimeStamp() >= 60000) {
                        this.tvState.setText("GPS\u5b9a\u4f4d\u8d85\u65f6");
                    } else {
                        this.tvState.setText("GPS\u672a\u5b9a\u4f4d");
                    }
                } else {
                    this.modelCache.onRevGpsData(flightRevGpsTestData);
                    this.testCache.onRevGpsData(flightRevGpsTestData);
                }
            }
            this.handler.removeCallbacks(this.offlineRunnable);
            if (this.testType == TestType.TYPE_MODEL) {
                this.handler.postDelayed(this.offlineRunnable, 5000L);
                return;
            }
            return;
        }
        if (i == 2) {
            return;
        }
        if (i != 3) {
            return;
        }
        this.modelCache = new TestGpsProductionCache(30000L, this.modelCacheListener);
        this.testCache = new TestGpsProductionCache(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this.testCacheListener);
        finishSave();
        this.handler.removeCallbacks(this.offlineRunnable);
        this.isResultShow = false;
        this.newestModelData = null;
        if (FlightConfig.isConnectFlight()) {
            this.tvState.setText("\u672a\u6536\u5230\u98de\u63a7\u4e0b\u53d1\u7684GPS\u6570\u636e");
        } else {
            this.tvState.setText("\u672a\u8fde\u63a5\u98de\u673a");
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.offlineRunnable);
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$2, reason: invalid class name */
    class AnonymousClass2 implements TestGpsProductionCache.OnCacheListener {
        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calRealtime(long j, int i, float f, float f2) {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void longTimeGpsNotOpen() {
        }

        AnonymousClass2() {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void cacheRemainTime(int i) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_MODEL) {
                TestGpsProductionController.this.tvState.setText("\u6b63\u5728\u7f13\u5b58GPS\u6570\u636e...(\u5269\u4f59 " + i + "s )");
            }
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calResult(long j, int i, float f, float f2) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_MODEL) {
                TestGpsProductionController.this.tvState.setText("\u6301\u7eed\u4e0a\u4f20\u6570\u636e\u7ed9\u540e\u53f0\u4e2d...");
                TestGpsProductionRequest.uploadModelData(f, f2, i, new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(Boolean bool) {
                        if (bool.booleanValue()) {
                            DDLog.e("\u4e0a\u4f20\u6210\u529f");
                        } else {
                            DDLog.e("\u4e0a\u4f20\u5931\u8d25");
                            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ToastUtil.toast(TestGpsProductionController.this.getContext(), "\u4e0a\u4f20\u540e\u53f0\u6570\u636e\u5f02\u5e38!");
                                }
                            });
                        }
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(final Exception exc) {
                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ToastUtil.toast(TestGpsProductionController.this.getContext(), "\u4e0a\u4f20\u540e\u53f0\u6570\u636e\u5931\u8d25:" + exc.getMessage());
                            }
                        });
                    }
                });
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$3, reason: invalid class name */
    class AnonymousClass3 implements TestGpsProductionCache.OnCacheListener {
        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void longTimeGpsNotOpen() {
        }

        AnonymousClass3() {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void cacheRemainTime(int i) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_TEST) {
                TestGpsProductionController.this.tvState.setText("\u6b63\u5728\u7f13\u5b58GPS\u6570\u636e...(\u5269\u4f59 " + i + "s )");
            }
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calResult(long j, int i, float f, float f2) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_TEST) {
                if (TestGpsProductionController.this.newestModelData == null) {
                    TestGpsProductionController.this.tvState.setText("\u62c9\u53d6\u540e\u53f0\u91d1\u673a\u6570\u636e \u5bf9\u6bd4\u4e2d...");
                    TestGpsProductionRequest.getNewestModelData(new OnResultListener<TestGpsProductionRequest.NewestModelData>() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.3.1
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(TestGpsProductionRequest.NewestModelData newestModelData) {
                            if (newestModelData != null) {
                                if (newestModelData.getResult() != 0) {
                                    TestGpsProductionController.this.tvState.setText("\u91d1\u673a\u5df2\u79bb\u7ebf");
                                } else {
                                    TestGpsProductionController.this.newestModelData = newestModelData;
                                }
                            }
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(final Exception exc) {
                            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.3.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ToastUtil.toast(TestGpsProductionController.this.getContext(), "\u62c9\u53d6\u91d1\u673a\u6570\u636e\u5f02\u5e38\uff1a" + exc.getMessage());
                                }
                            });
                        }
                    });
                }
                if (TestGpsProductionController.this.newestModelData == null || TestGpsProductionController.this.isResultShow) {
                    return;
                }
                boolean z = f <= TestGpsProductionController.this.newestModelData.getStandard_values();
                if (z) {
                    TestGpsProductionRequest.uploadTestData(f, f2, i, z, new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.3.2
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(Exception exc) {
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(Boolean bool) {
                        }
                    });
                    TestGpsProductionController.this.tvState.setText("\u6d4b\u8bd5\u901a\u8fc7");
                    TestGpsProductionController.this.isResultShow = true;
                } else if (j > 100000) {
                    TestGpsProductionController.this.tvState.setText("\u6d4b\u8bd5\u4e0d\u901a\u8fc7 \u5e73\u5747\u503c: " + f + " , \u65b9\u5dee: " + f2);
                    TestGpsProductionController.this.isResultShow = true;
                }
            }
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calRealtime(long j, int i, float f, float f2) {
            try {
                if (TestGpsProductionController.this.outputStream == null) {
                    TestGpsProductionController.this.outputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getLogDir(), FormatUtil.getCurTime1() + "_sacc_averages.txt"));
                }
                TestGpsProductionController.this.outputStream.write((f + "\n").getBytes());
            } catch (Exception unused) {
            }
        }
    }

    private void finishSave() {
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.outputStream = null;
        }
    }
}