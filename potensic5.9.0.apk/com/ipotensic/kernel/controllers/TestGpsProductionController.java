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
import com.ipotensic.kernel.C1965R;
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
                TestGpsProductionController.this.tvState.setText("金机离线");
            }
        };
        this.modelCacheListener = new C21952();
        this.outputStream = null;
        this.testCacheListener = new C21963();
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
        this.btnModel = (Button) view.findViewById(C1965R.id.btn_model);
        this.tvState = (TextView) view.findViewById(C1965R.id.tv_state);
        this.layoutDetail = (RelativeLayout) view.findViewById(C1965R.id.layout_detail);
    }

    public void setGpsTestType(TestType testType) {
        this.testType = testType;
        if (testType == TestType.TYPE_MODEL) {
            this.btnModel.setBackgroundColor(getContext().getResources().getColor(C1965R.color.color_connect_green));
            this.btnModel.setText("金机端");
            this.layoutDetail.setVisibility(0);
            this.modelCache = new TestGpsProductionCache(30000L, this.modelCacheListener);
            setVisibility(0);
            return;
        }
        if (testType == TestType.TYPE_TEST) {
            this.btnModel.setBackgroundColor(getContext().getResources().getColor(C1965R.color.color_connect_green));
            this.btnModel.setText("测试机端");
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

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$4 */
    static /* synthetic */ class C21974 {
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
        int i = C21974.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            FlightRevGpsTestData flightRevGpsTestData = (FlightRevGpsTestData) event.obj;
            if (flightRevGpsTestData != null) {
                if (!flightRevGpsTestData.isGpsReady()) {
                    if (this.testType == TestType.TYPE_TEST && flightRevGpsTestData.getTimeStamp() >= 60000) {
                        this.tvState.setText("GPS定位超时");
                    } else {
                        this.tvState.setText("GPS未定位");
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
            this.tvState.setText("未收到飞控下发的GPS数据");
        } else {
            this.tvState.setText("未连接飞机");
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.offlineRunnable);
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$2 */
    class C21952 implements TestGpsProductionCache.OnCacheListener {
        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calRealtime(long j, int i, float f, float f2) {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void longTimeGpsNotOpen() {
        }

        C21952() {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void cacheRemainTime(int i) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_MODEL) {
                TestGpsProductionController.this.tvState.setText("正在缓存GPS数据...(剩余 " + i + "s )");
            }
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calResult(long j, int i, float f, float f2) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_MODEL) {
                TestGpsProductionController.this.tvState.setText("持续上传数据给后台中...");
                TestGpsProductionRequest.uploadModelData(f, f2, i, new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(Boolean bool) {
                        if (bool.booleanValue()) {
                            DDLog.m1684e("上传成功");
                        } else {
                            DDLog.m1684e("上传失败");
                            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ToastUtil.toast(TestGpsProductionController.this.getContext(), "上传后台数据异常!");
                                }
                            });
                        }
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(final Exception exc) {
                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.2.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ToastUtil.toast(TestGpsProductionController.this.getContext(), "上传后台数据失败:" + exc.getMessage());
                            }
                        });
                    }
                });
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.TestGpsProductionController$3 */
    class C21963 implements TestGpsProductionCache.OnCacheListener {
        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void longTimeGpsNotOpen() {
        }

        C21963() {
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void cacheRemainTime(int i) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_TEST) {
                TestGpsProductionController.this.tvState.setText("正在缓存GPS数据...(剩余 " + i + "s )");
            }
        }

        @Override // com.ipotensic.kernel.manager.TestGpsProductionCache.OnCacheListener
        public void calResult(long j, int i, float f, float f2) {
            if (TestGpsProductionController.this.testType == TestType.TYPE_TEST) {
                if (TestGpsProductionController.this.newestModelData == null) {
                    TestGpsProductionController.this.tvState.setText("拉取后台金机数据 对比中...");
                    TestGpsProductionRequest.getNewestModelData(new OnResultListener<TestGpsProductionRequest.NewestModelData>() { // from class: com.ipotensic.kernel.controllers.TestGpsProductionController.3.1
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(TestGpsProductionRequest.NewestModelData newestModelData) {
                            if (newestModelData != null) {
                                if (newestModelData.getResult() != 0) {
                                    TestGpsProductionController.this.tvState.setText("金机已离线");
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
                                    ToastUtil.toast(TestGpsProductionController.this.getContext(), "拉取金机数据异常：" + exc.getMessage());
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
                    TestGpsProductionController.this.tvState.setText("测试通过");
                    TestGpsProductionController.this.isResultShow = true;
                } else if (j > 100000) {
                    TestGpsProductionController.this.tvState.setText("测试不通过 平均值: " + f + " , 方差: " + f2);
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