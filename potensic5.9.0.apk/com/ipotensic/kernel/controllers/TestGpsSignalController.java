package com.ipotensic.kernel.controllers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.recyclerview.RvCommonAdapter;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ItemGpsDebugLayoutBinding;
import com.ipotensic.kernel.view.SwitchButton;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevCtrlData;
import com.logan.flight.data.recv.FlightRevGpsSignalTest;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.enums.CtrlType;
import java.io.File;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: TestGpsSignalController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00108\u001a\u00020\u000fH\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0002J\b\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u00020\u000fH\u0002J\b\u0010>\u001a\u00020\u000fH\u0002J\b\u0010?\u001a\u00020:H\u0002J\u001e\u0010@\u001a\u00020\u000b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0018\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0002J\u0012\u0010G\u001a\u00020:2\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000f2\b\b\u0002\u0010K\u001a\u00020\u000bH\u0002J\b\u0010L\u001a\u00020:H\u0016J\u001c\u0010M\u001a\u00020:2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020EH\u0002J0\u0010T\u001a\u00020:2\b\u0010\u0004\u001a\u0004\u0018\u00010!2\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010V\u001a\u00020\u000bH\u0002J0\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J0\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010[\u001a\u00020EH\u0002J0\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J0\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010^\u001a\u00020EH\u0002J\n\u0010_\u001a\u0004\u0018\u00010EH\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, m2338d2 = {"Lcom/ipotensic/kernel/controllers/TestGpsSignalController;", "Lcom/ipotensic/kernel/controllers/BaseController;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "view", "Landroid/view/View;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/View;)V", "bdIDSignalList", "", "", "bdSignalAverageList", "", "bdSignalList", "currentBdSignalAverage", "Lkotlin/Pair;", "", "currentGlSignalAverage", "currentGpSignalAverage", "gaIDSignalList", "gaSignalList", "glIDSignalList", "glSignalList", "gpIDSignalList", "gpSignalList", "isRecord", "", "isRecordLog", "setRecordLog", "(Z)V", "rvBDAdapter", "Lcom/ipotensic/baselib/views/recyclerview/RvCommonAdapter;", "Lcom/ipotensic/kernel/databinding/ItemGpsDebugLayoutBinding;", "rvBDCarrierRatio", "Landroidx/recyclerview/widget/RecyclerView;", "rvGAAdapter", "rvGACarrierRatio", "rvGLAdapter", "rvGLCarrierRatio", "rvGPAdapter", "rvGPCarrierRatio", "signalGLAverageList", "signalGPAverageList", "switchBtn", "Lcom/ipotensic/kernel/view/SwitchButton;", "switchRecordBtn", "tvBDCarrierRatio", "Landroid/widget/TextView;", "tvDroneSn", "tvGACarrierRatio", "tvGLCarrierRatio", "tvGPCarrierRatio", "tvGPSInfo", "txtFile", "Ljava/io/File;", "txtRaf", "Ljava/io/RandomAccessFile;", "calculateBDAverageValue", "calculateCacheBDSignalAverageValue", "", "calculateCacheGLSignalAverageValue", "calculateCacheGPSignalAverageValue", "calculateGLAverageValue", "calculateGPAverageValue", "closeRecordLog", "findId", "data", "pos", "initRecordLog", "filePath", "", "fileName", "initView", "baseView", "keepDigitUp", "d", RtspHeaders.SCALE, "onDestroy", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "recordLog", "strContent", "setAdapterData", "rvAdapter", "size", "withAdapter2", "signalIdList", "signalList", "withBDAdapter", "withCurTime", "withGLAdapter", "withGPAdapter", "withTempDir", "writeData", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestGpsSignalController extends BaseController {
    private List<Byte> bdIDSignalList;
    private List<Integer> bdSignalAverageList;
    private List<Byte> bdSignalList;
    private Pair<Float, Float> currentBdSignalAverage;
    private Pair<Float, Float> currentGlSignalAverage;
    private Pair<Float, Float> currentGpSignalAverage;
    private List<Byte> gaIDSignalList;
    private List<Byte> gaSignalList;
    private List<Byte> glIDSignalList;
    private List<Byte> glSignalList;
    private List<Byte> gpIDSignalList;
    private List<Byte> gpSignalList;
    private boolean isRecordLog;
    private RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvBDAdapter;
    private RecyclerView rvBDCarrierRatio;
    private RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvGAAdapter;
    private RecyclerView rvGACarrierRatio;
    private RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvGLAdapter;
    private RecyclerView rvGLCarrierRatio;
    private RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvGPAdapter;
    private RecyclerView rvGPCarrierRatio;
    private List<Integer> signalGLAverageList;
    private List<Integer> signalGPAverageList;
    private SwitchButton switchBtn;
    private SwitchButton switchRecordBtn;
    private TextView tvBDCarrierRatio;
    private TextView tvDroneSn;
    private TextView tvGACarrierRatio;
    private TextView tvGLCarrierRatio;
    private TextView tvGPCarrierRatio;
    private TextView tvGPSInfo;
    private File txtFile;
    private RandomAccessFile txtRaf;

    @Metadata(m2336bv = {1, 0, 3}, m2339k = 3, m2340mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventID.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            iArr[EventID.FLIGHT_RECEIVE_CTRL_CMD.ordinal()] = 2;
            iArr[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 3;
            iArr[EventID.FLIGHT_RECEIVE_GPS_SIGNAL_TEST_DATA.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestGpsSignalController(AppCompatActivity activity, View view) {
        super(activity, view);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Float valueOf = Float.valueOf(0.0f);
        this.currentGpSignalAverage = new Pair<>(valueOf, valueOf);
        this.currentBdSignalAverage = new Pair<>(valueOf, valueOf);
        this.currentGlSignalAverage = new Pair<>(valueOf, valueOf);
        setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_GPS_SIGNAL ? 0 : 8);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View baseView) {
        SwitchButton switchButton;
        String flightSN;
        if (baseView != null) {
            View findViewById = baseView.findViewById(C1965R.id.tvDroneSn);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvDroneSn = (TextView) findViewById;
            View findViewById2 = baseView.findViewById(C1965R.id.switchBtn);
            if (findViewById2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.ipotensic.kernel.view.SwitchButton");
            }
            this.switchBtn = (SwitchButton) findViewById2;
            View findViewById3 = baseView.findViewById(C1965R.id.switchRecordBtn);
            if (findViewById3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.ipotensic.kernel.view.SwitchButton");
            }
            this.switchRecordBtn = (SwitchButton) findViewById3;
            View findViewById4 = baseView.findViewById(C1965R.id.tvGPSInfo);
            if (findViewById4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvGPSInfo = (TextView) findViewById4;
            View findViewById5 = baseView.findViewById(C1965R.id.tvGPCarrierRatio);
            if (findViewById5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvGPCarrierRatio = (TextView) findViewById5;
            View findViewById6 = baseView.findViewById(C1965R.id.rvGPCarrierRatio);
            if (findViewById6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            this.rvGPCarrierRatio = (RecyclerView) findViewById6;
            View findViewById7 = baseView.findViewById(C1965R.id.tvBDCarrierRatio);
            if (findViewById7 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvBDCarrierRatio = (TextView) findViewById7;
            View findViewById8 = baseView.findViewById(C1965R.id.rvBDCarrierRatio);
            if (findViewById8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            this.rvBDCarrierRatio = (RecyclerView) findViewById8;
            View findViewById9 = baseView.findViewById(C1965R.id.tvGACarrierRatio);
            if (findViewById9 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvGACarrierRatio = (TextView) findViewById9;
            View findViewById10 = baseView.findViewById(C1965R.id.rvGACarrierRatio);
            if (findViewById10 == null) {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            this.rvGACarrierRatio = (RecyclerView) findViewById10;
            View findViewById11 = baseView.findViewById(C1965R.id.tvGLCarrierRatio);
            if (findViewById11 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            this.tvGLCarrierRatio = (TextView) findViewById11;
            View findViewById12 = baseView.findViewById(C1965R.id.rvGLCarrierRatio);
            if (findViewById12 == null) {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            this.rvGLCarrierRatio = (RecyclerView) findViewById12;
            this.gpIDSignalList = new ArrayList();
            this.gpSignalList = new ArrayList();
            this.signalGPAverageList = new ArrayList();
            List<Byte> list = this.gpIDSignalList;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            List<Byte> list2 = this.gpSignalList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withGPAdapter = withGPAdapter(list, list2);
            this.rvGPAdapter = withGPAdapter;
            setAdapterData(this.rvGPCarrierRatio, withGPAdapter, 30);
            this.bdIDSignalList = new ArrayList();
            this.bdSignalList = new ArrayList();
            this.bdSignalAverageList = new ArrayList();
            List<Byte> list3 = this.bdIDSignalList;
            if (list3 == null) {
                Intrinsics.throwNpe();
            }
            List<Byte> list4 = this.bdSignalList;
            if (list4 == null) {
                Intrinsics.throwNpe();
            }
            RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withBDAdapter = withBDAdapter(list3, list4);
            this.rvBDAdapter = withBDAdapter;
            setAdapterData(this.rvBDCarrierRatio, withBDAdapter, 30);
            this.gaIDSignalList = new ArrayList();
            this.gaSignalList = new ArrayList();
            List<Byte> list5 = this.gaIDSignalList;
            if (list5 == null) {
                Intrinsics.throwNpe();
            }
            List<Byte> list6 = this.gaSignalList;
            if (list6 == null) {
                Intrinsics.throwNpe();
            }
            RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withAdapter2 = withAdapter2(list5, list6);
            this.rvGAAdapter = withAdapter2;
            setAdapterData(this.rvGACarrierRatio, withAdapter2, 20);
            this.glIDSignalList = new ArrayList();
            this.glSignalList = new ArrayList();
            this.signalGLAverageList = new ArrayList();
            List<Byte> list7 = this.glIDSignalList;
            if (list7 == null) {
                Intrinsics.throwNpe();
            }
            List<Byte> list8 = this.glSignalList;
            if (list8 == null) {
                Intrinsics.throwNpe();
            }
            RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withGLAdapter = withGLAdapter(list7, list8);
            this.rvGLAdapter = withGLAdapter;
            setAdapterData(this.rvGLCarrierRatio, withGLAdapter, 20);
            setRecordLog(false);
            SwitchButton switchButton2 = this.switchBtn;
            if (switchButton2 != null) {
                switchButton2.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$initView$$inlined$let$lambda$1
                    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
                    public void onDisableClick() {
                    }

                    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
                    public void onStateChanged(View view, boolean z) {
                        SwitchButton switchButton3;
                        if (FlightConfig.isConnectFlight()) {
                            if (z) {
                                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_GPS_SIGNAL_OPEN);
                                return;
                            } else {
                                DataManager.getInstance().sendCtrlData(CtrlType.TYPE_GPS_SIGNAL_CLOSE);
                                return;
                            }
                        }
                        switchButton3 = TestGpsSignalController.this.switchBtn;
                        if (switchButton3 != null) {
                            switchButton3.setChecked(false);
                        }
                        ToastUtil.toast(TestGpsSignalController.this.getContext(), TestGpsSignalController.this.getContext().getString(C1965R.string.txt_disconnect_set_fail));
                    }
                });
            }
            SwitchButton switchButton3 = this.switchRecordBtn;
            if (switchButton3 != null) {
                switchButton3.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$initView$$inlined$let$lambda$2
                    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
                    public void onDisableClick() {
                    }

                    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
                    public void onStateChanged(View view, boolean z) {
                        TestGpsSignalController.this.setRecordLog(z);
                    }
                });
            }
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevVersionData versionData = flightRevData.getFlightRevVersionData();
            Intrinsics.checkExpressionValueIsNotNull(versionData, "versionData");
            if (versionData.isInit() && (flightSN = versionData.getFlightSN()) != null) {
                TextView textView = this.tvDroneSn;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (!TextUtils.isEmpty(flightSN)) {
                    TextView textView2 = this.tvDroneSn;
                    if (textView2 != null) {
                        textView2.setText("飞行器SN码：" + flightSN);
                    }
                } else {
                    TextView textView3 = this.tvDroneSn;
                    if (textView3 != null) {
                        textView3.setText("飞行器SN码：N/A");
                    }
                }
            }
            FlightRevData flightRevData2 = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
            FlightRevCtrlData ctrlData = flightRevData2.getCtrlData();
            Intrinsics.checkExpressionValueIsNotNull(ctrlData, "ctrlData");
            if (ctrlData.getCtrlType() == CtrlType.TYPE_GPS_SIGNAL_OPEN) {
                SwitchButton switchButton4 = this.switchBtn;
                if (switchButton4 != null) {
                    switchButton4.setChecked(true);
                }
            } else if (ctrlData.getCtrlType() == CtrlType.TYPE_GPS_SIGNAL_CLOSE && (switchButton = this.switchBtn) != null) {
                switchButton.setChecked(false);
            }
            SwitchButton switchButton5 = this.switchRecordBtn;
            if (switchButton5 != null) {
                switchButton5.setChecked(this.isRecordLog);
            }
        }
    }

    private final void setAdapterData(RecyclerView view, RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvAdapter, int size) {
        if (view != null) {
            view.setAdapter(rvAdapter);
            view.getRecycledViewPool().setMaxRecycledViews(0, size);
            view.setItemViewCacheSize(size);
            view.setHasFixedSize(true);
            view.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
    }

    private final RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withGPAdapter(final List<Byte> signalIdList, final List<Byte> signalList) {
        AppCompatActivity context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        final AppCompatActivity appCompatActivity = context;
        return new RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding>(appCompatActivity, signalList) { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$withGPAdapter$1
            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            public /* bridge */ /* synthetic */ void convert(ItemGpsDebugLayoutBinding itemGpsDebugLayoutBinding, Byte b, int i) {
                convert(itemGpsDebugLayoutBinding, b.byteValue(), i);
            }

            protected void convert(ItemGpsDebugLayoutBinding holder, byte data, int position) {
                int findId;
                Pair pair;
                Pair pair2;
                Pair pair3;
                Pair pair4;
                Intrinsics.checkParameterIsNotNull(holder, "holder");
                TextView textView = holder.tvCarrierRatio;
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.tvCarrierRatio");
                StringBuilder append = new StringBuilder().append("卫星号:");
                findId = TestGpsSignalController.this.findId(signalIdList, position);
                textView.setText(append.append(findId).toString());
                TextView textView2 = holder.tvCarrierRatioValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.tvCarrierRatioValue");
                textView2.setText("载噪比:" + ((int) data));
                if (position < 6) {
                    pair = TestGpsSignalController.this.currentGpSignalAverage;
                    if (((Number) pair.getFirst()).floatValue() < 40.0f) {
                        pair2 = TestGpsSignalController.this.currentGpSignalAverage;
                        if (((Number) pair2.getFirst()).floatValue() < 38.0f) {
                            pair3 = TestGpsSignalController.this.currentGpSignalAverage;
                            if (((Number) pair3.getFirst()).floatValue() >= 37.0f) {
                                pair4 = TestGpsSignalController.this.currentGpSignalAverage;
                                if (((Number) pair4.getSecond()).floatValue() >= 38.0f) {
                                    holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                                    holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                                    return;
                                } else {
                                    holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                                    holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                                    return;
                                }
                            }
                            holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            return;
                        }
                        holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                        holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                        return;
                    }
                    holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    return;
                }
                holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
                holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            protected ItemGpsDebugLayoutBinding initView(ViewGroup parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                ItemGpsDebugLayoutBinding inflate = ItemGpsDebugLayoutBinding.inflate(LayoutInflater.from(TestGpsSignalController.this.getContext()), parent, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemGpsDebugLayoutBindin…(context), parent, false)");
                return inflate;
            }
        };
    }

    private final RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withGLAdapter(final List<Byte> signalIdList, final List<Byte> signalList) {
        AppCompatActivity context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        final AppCompatActivity appCompatActivity = context;
        return new RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding>(appCompatActivity, signalList) { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$withGLAdapter$1
            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            public /* bridge */ /* synthetic */ void convert(ItemGpsDebugLayoutBinding itemGpsDebugLayoutBinding, Byte b, int i) {
                convert(itemGpsDebugLayoutBinding, b.byteValue(), i);
            }

            protected void convert(ItemGpsDebugLayoutBinding holder, byte data, int position) {
                int findId;
                Pair pair;
                Pair pair2;
                Intrinsics.checkParameterIsNotNull(holder, "holder");
                TextView textView = holder.tvCarrierRatio;
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.tvCarrierRatio");
                StringBuilder append = new StringBuilder().append("卫星号:");
                findId = TestGpsSignalController.this.findId(signalIdList, position);
                textView.setText(append.append(findId).toString());
                TextView textView2 = holder.tvCarrierRatioValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.tvCarrierRatioValue");
                textView2.setText("载噪比:" + ((int) data));
                if (position < 2) {
                    pair = TestGpsSignalController.this.currentGlSignalAverage;
                    if (((Number) pair.getFirst()).floatValue() < 36.0f) {
                        pair2 = TestGpsSignalController.this.currentGlSignalAverage;
                        if (((Number) pair2.getFirst()).floatValue() >= 34.0f) {
                            holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                            holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                            return;
                        } else {
                            holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            return;
                        }
                    }
                    holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    return;
                }
                holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
                holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            protected ItemGpsDebugLayoutBinding initView(ViewGroup parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                ItemGpsDebugLayoutBinding inflate = ItemGpsDebugLayoutBinding.inflate(LayoutInflater.from(TestGpsSignalController.this.getContext()), parent, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemGpsDebugLayoutBindin…(context), parent, false)");
                return inflate;
            }
        };
    }

    private final RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withBDAdapter(final List<Byte> signalIdList, final List<Byte> signalList) {
        AppCompatActivity context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        final AppCompatActivity appCompatActivity = context;
        return new RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding>(appCompatActivity, signalList) { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$withBDAdapter$1
            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            public /* bridge */ /* synthetic */ void convert(ItemGpsDebugLayoutBinding itemGpsDebugLayoutBinding, Byte b, int i) {
                convert(itemGpsDebugLayoutBinding, b.byteValue(), i);
            }

            protected void convert(ItemGpsDebugLayoutBinding holder, byte data, int position) {
                int findId;
                Pair pair;
                Pair pair2;
                Intrinsics.checkParameterIsNotNull(holder, "holder");
                TextView textView = holder.tvCarrierRatio;
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.tvCarrierRatio");
                StringBuilder append = new StringBuilder().append("卫星号:");
                findId = TestGpsSignalController.this.findId(signalIdList, position);
                textView.setText(append.append(findId).toString());
                TextView textView2 = holder.tvCarrierRatioValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.tvCarrierRatioValue");
                textView2.setText("载噪比:" + ((int) data));
                if (position < 6) {
                    pair = TestGpsSignalController.this.currentBdSignalAverage;
                    if (((Number) pair.getFirst()).floatValue() < 38.0f) {
                        pair2 = TestGpsSignalController.this.currentBdSignalAverage;
                        if (((Number) pair2.getFirst()).floatValue() >= 36.0f) {
                            holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                            holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.aqua));
                            return;
                        } else {
                            holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.red));
                            return;
                        }
                    }
                    holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.color_zoom_green));
                    return;
                }
                holder.tvCarrierRatio.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
                holder.tvCarrierRatioValue.setTextColor(ContextCompat.getColor(TestGpsSignalController.this.getContext(), C1965R.color.white));
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            protected ItemGpsDebugLayoutBinding initView(ViewGroup parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                ItemGpsDebugLayoutBinding inflate = ItemGpsDebugLayoutBinding.inflate(LayoutInflater.from(TestGpsSignalController.this.getContext()), parent, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemGpsDebugLayoutBindin…(context), parent, false)");
                return inflate;
            }
        };
    }

    private final RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> withAdapter2(final List<Byte> signalIdList, final List<Byte> signalList) {
        AppCompatActivity context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        final AppCompatActivity appCompatActivity = context;
        return new RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding>(appCompatActivity, signalList) { // from class: com.ipotensic.kernel.controllers.TestGpsSignalController$withAdapter2$1
            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            public /* bridge */ /* synthetic */ void convert(ItemGpsDebugLayoutBinding itemGpsDebugLayoutBinding, Byte b, int i) {
                convert(itemGpsDebugLayoutBinding, b.byteValue(), i);
            }

            protected void convert(ItemGpsDebugLayoutBinding holder, byte data, int position) {
                int findId;
                Intrinsics.checkParameterIsNotNull(holder, "holder");
                TextView textView = holder.tvCarrierRatio;
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.tvCarrierRatio");
                StringBuilder append = new StringBuilder().append("卫星号:");
                findId = TestGpsSignalController.this.findId(signalIdList, position);
                textView.setText(append.append(findId).toString());
                TextView textView2 = holder.tvCarrierRatioValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.tvCarrierRatioValue");
                textView2.setText("载噪比:" + ((int) data));
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvCommonAdapter
            protected ItemGpsDebugLayoutBinding initView(ViewGroup parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                ItemGpsDebugLayoutBinding inflate = ItemGpsDebugLayoutBinding.inflate(LayoutInflater.from(TestGpsSignalController.this.getContext()), parent, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemGpsDebugLayoutBindin…(context), parent, false)");
                return inflate;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findId(List<Byte> data, int pos) {
        if (!data.isEmpty() && pos < data.size()) {
            return data.get(pos).byteValue();
        }
        return -1;
    }

    private final float calculateGPAverageValue() {
        List<Integer> list = this.signalGPAverageList;
        float f = 0.0f;
        if (list == null) {
            return 0.0f;
        }
        while (list.iterator().hasNext()) {
            f += ((Number) r2.next()).intValue();
        }
        return keepDigitUp(f / list.size(), 6);
    }

    private final float calculateBDAverageValue() {
        List<Integer> list = this.bdSignalAverageList;
        float f = 0.0f;
        if (list == null) {
            return 0.0f;
        }
        while (list.iterator().hasNext()) {
            f += ((Number) r2.next()).intValue();
        }
        return keepDigitUp(f / list.size(), 6);
    }

    private final float calculateGLAverageValue() {
        List<Integer> list = this.signalGLAverageList;
        float f = 0.0f;
        if (list == null) {
            return 0.0f;
        }
        while (list.iterator().hasNext()) {
            f += ((Number) r2.next()).intValue();
        }
        return keepDigitUp(f / list.size(), 6);
    }

    private final void calculateCacheGPSignalAverageValue() {
        List<Integer> list;
        List<Byte> list2 = this.gpSignalList;
        if (list2 == null || (list = this.signalGPAverageList) == null || !(!list2.isEmpty()) || list2.size() < 6) {
            return;
        }
        if (list.size() >= 30) {
            list.subList(0, 6).clear();
        }
        Iterator<T> it = list2.subList(0, 6).iterator();
        while (it.hasNext()) {
            list.add(Integer.valueOf(((Number) it.next()).byteValue()));
        }
    }

    private final void calculateCacheBDSignalAverageValue() {
        List<Integer> list;
        List<Byte> list2 = this.bdSignalList;
        if (list2 == null || (list = this.bdSignalAverageList) == null || !(!list2.isEmpty()) || list2.size() < 6) {
            return;
        }
        if (list.size() >= 30) {
            list.subList(0, 6).clear();
        }
        Iterator<T> it = list2.subList(0, 6).iterator();
        while (it.hasNext()) {
            list.add(Integer.valueOf(((Number) it.next()).byteValue()));
        }
    }

    private final void calculateCacheGLSignalAverageValue() {
        List<Integer> list;
        List<Byte> list2 = this.glSignalList;
        if (list2 == null || (list = this.signalGLAverageList) == null || !(!list2.isEmpty()) || list2.size() < 2) {
            return;
        }
        if (list.size() >= 10) {
            list.subList(0, 2).clear();
        }
        Iterator<T> it = list2.subList(0, 2).iterator();
        while (it.hasNext()) {
            list.add(Integer.valueOf(((Number) it.next()).byteValue()));
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        SwitchButton switchButton;
        Pair<Float, Float> pair;
        Boolean valueOf;
        Boolean valueOf2;
        Boolean valueOf3;
        Boolean valueOf4;
        SwitchButton switchButton2;
        super.onEvent(what, event);
        if (what == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[what.ordinal()];
        int i2 = 0;
        if (i == 1) {
            if (FlightConfig.isConnectFlight()) {
                SwitchButton switchButton3 = this.switchBtn;
                if (switchButton3 != null) {
                    switchButton3.setViewEnable(true);
                }
                TextView textView = this.tvDroneSn;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                return;
            }
            SwitchButton switchButton4 = this.switchBtn;
            if (switchButton4 != null) {
                switchButton4.setViewEnable(false);
            }
            SwitchButton switchButton5 = this.switchBtn;
            if (switchButton5 != null) {
                switchButton5.setChecked(false);
            }
            TextView textView2 = this.tvDroneSn;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 2) {
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevCtrlData ctrlData = flightRevData.getCtrlData();
            Intrinsics.checkExpressionValueIsNotNull(ctrlData, "ctrlData");
            if (ctrlData.getCtrlType() == CtrlType.TYPE_GPS_SIGNAL_OPEN) {
                SwitchButton switchButton6 = this.switchBtn;
                if (switchButton6 != null) {
                    switchButton6.setChecked(true);
                    return;
                }
                return;
            }
            if (ctrlData.getCtrlType() != CtrlType.TYPE_GPS_SIGNAL_CLOSE || (switchButton = this.switchBtn) == null) {
                return;
            }
            switchButton.setChecked(false);
            return;
        }
        if (i == 3) {
            FlightRevVersionData flightRevVersionData = (FlightRevVersionData) (event != null ? event.obj : null);
            if (flightRevVersionData == null || !flightRevVersionData.isInit()) {
                return;
            }
            String flightSN = flightRevVersionData.getFlightSN();
            if (!TextUtils.isEmpty(flightSN)) {
                TextView textView3 = this.tvDroneSn;
                if (textView3 != null) {
                    textView3.setText("飞行器SN码：" + flightSN);
                    return;
                }
                return;
            }
            TextView textView4 = this.tvDroneSn;
            if (textView4 != null) {
                textView4.setText("飞行器SN码：N/A");
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        FlightRevGpsSignalTest flightRevGpsSignalTest = (FlightRevGpsSignalTest) (event != null ? event.obj : null);
        if (flightRevGpsSignalTest == null || !flightRevGpsSignalTest.isInit()) {
            return;
        }
        SwitchButton switchButton7 = this.switchBtn;
        if (switchButton7 != null && !switchButton7.isChecked() && (switchButton2 = this.switchBtn) != null) {
            switchButton2.setChecked(true);
        }
        TextView textView5 = this.tvGPSInfo;
        if (textView5 != null) {
            textView5.setText(flightRevGpsSignalTest.toString() + "\t[当前时间:" + FormatUtil.formatTimeSss(System.currentTimeMillis()) + PropertyUtils.INDEXED_DELIM2);
        }
        List<Byte> list = this.gpIDSignalList;
        if (list != null) {
            list.clear();
        }
        List<Byte> list2 = this.gpSignalList;
        if (list2 != null) {
            list2.clear();
        }
        byte[] gp_signal_to_noise_ratio = flightRevGpsSignalTest.getGp_signal_to_noise_ratio();
        ArrayList arrayList = new ArrayList(gp_signal_to_noise_ratio.length);
        int length = gp_signal_to_noise_ratio.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            byte b = gp_signal_to_noise_ratio[i3];
            int i5 = i4 + 1;
            if (i4 % 2 == 0) {
                List<Byte> list3 = this.gpIDSignalList;
                if (list3 != null) {
                    valueOf4 = Boolean.valueOf(list3.add(Byte.valueOf(b)));
                }
                valueOf4 = null;
            } else {
                List<Byte> list4 = this.gpSignalList;
                if (list4 != null) {
                    valueOf4 = Boolean.valueOf(list4.add(Byte.valueOf(b)));
                }
                valueOf4 = null;
            }
            arrayList.add(valueOf4);
            i3++;
            i4 = i5;
        }
        calculateCacheGPSignalAverageValue();
        float calculateGPAverageValue = calculateGPAverageValue();
        if (calculateGPAverageValue >= 38.0f) {
            pair = new Pair<>(Float.valueOf(calculateGPAverageValue), this.currentGpSignalAverage.getFirst());
        } else if (calculateGPAverageValue < 37.0f) {
            pair = new Pair<>(Float.valueOf(calculateGPAverageValue), this.currentGpSignalAverage.getFirst());
        } else if (this.currentGpSignalAverage.getSecond().floatValue() > 0.0f) {
            pair = new Pair<>(Float.valueOf(calculateGPAverageValue), this.currentGpSignalAverage.getSecond());
        } else {
            pair = new Pair<>(Float.valueOf(calculateGPAverageValue), this.currentGpSignalAverage.getFirst());
        }
        this.currentGpSignalAverage = pair;
        TextView textView6 = this.tvGPCarrierRatio;
        if (textView6 != null) {
            textView6.setText("GP载噪比 [前六颗5秒平均值:" + calculateGPAverageValue + PropertyUtils.INDEXED_DELIM2);
        }
        RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvCommonAdapter = this.rvGPAdapter;
        if (rvCommonAdapter != null) {
            rvCommonAdapter.notifyDataSetChanged();
        }
        List<Byte> list5 = this.bdIDSignalList;
        if (list5 != null) {
            list5.clear();
        }
        List<Byte> list6 = this.bdSignalList;
        if (list6 != null) {
            list6.clear();
        }
        byte[] bd_signal_to_noise_ratio = flightRevGpsSignalTest.getBd_signal_to_noise_ratio();
        ArrayList arrayList2 = new ArrayList(bd_signal_to_noise_ratio.length);
        int length2 = bd_signal_to_noise_ratio.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length2) {
            byte b2 = bd_signal_to_noise_ratio[i6];
            int i8 = i7 + 1;
            if (i7 % 2 == 0) {
                List<Byte> list7 = this.bdIDSignalList;
                if (list7 != null) {
                    valueOf3 = Boolean.valueOf(list7.add(Byte.valueOf(b2)));
                }
                valueOf3 = null;
            } else {
                List<Byte> list8 = this.bdSignalList;
                if (list8 != null) {
                    valueOf3 = Boolean.valueOf(list8.add(Byte.valueOf(b2)));
                }
                valueOf3 = null;
            }
            arrayList2.add(valueOf3);
            i6++;
            i7 = i8;
        }
        calculateCacheBDSignalAverageValue();
        this.currentBdSignalAverage = new Pair<>(Float.valueOf(calculateBDAverageValue()), this.currentBdSignalAverage.getFirst());
        TextView textView7 = this.tvBDCarrierRatio;
        if (textView7 != null) {
            textView7.setText("BD载噪比 [前六颗5秒平均值:" + this.currentBdSignalAverage.getFirst().floatValue() + PropertyUtils.INDEXED_DELIM2);
        }
        RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvCommonAdapter2 = this.rvBDAdapter;
        if (rvCommonAdapter2 != null) {
            rvCommonAdapter2.notifyDataSetChanged();
        }
        List<Byte> list9 = this.gaIDSignalList;
        if (list9 != null) {
            list9.clear();
        }
        List<Byte> list10 = this.gaSignalList;
        if (list10 != null) {
            list10.clear();
        }
        byte[] ga_signal_to_noise_ratio = flightRevGpsSignalTest.getGa_signal_to_noise_ratio();
        ArrayList arrayList3 = new ArrayList(ga_signal_to_noise_ratio.length);
        int length3 = ga_signal_to_noise_ratio.length;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length3) {
            byte b3 = ga_signal_to_noise_ratio[i9];
            int i11 = i10 + 1;
            if (i10 % 2 == 0) {
                List<Byte> list11 = this.gaIDSignalList;
                if (list11 != null) {
                    valueOf2 = Boolean.valueOf(list11.add(Byte.valueOf(b3)));
                }
                valueOf2 = null;
            } else {
                List<Byte> list12 = this.gaSignalList;
                if (list12 != null) {
                    valueOf2 = Boolean.valueOf(list12.add(Byte.valueOf(b3)));
                }
                valueOf2 = null;
            }
            arrayList3.add(valueOf2);
            i9++;
            i10 = i11;
        }
        RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvCommonAdapter3 = this.rvGAAdapter;
        if (rvCommonAdapter3 != null) {
            rvCommonAdapter3.notifyDataSetChanged();
        }
        List<Byte> list13 = this.glIDSignalList;
        if (list13 != null) {
            list13.clear();
        }
        List<Byte> list14 = this.glSignalList;
        if (list14 != null) {
            list14.clear();
        }
        byte[] gl_signal_to_noise_ratio = flightRevGpsSignalTest.getGl_signal_to_noise_ratio();
        ArrayList arrayList4 = new ArrayList(gl_signal_to_noise_ratio.length);
        int length4 = gl_signal_to_noise_ratio.length;
        int i12 = 0;
        while (i2 < length4) {
            byte b4 = gl_signal_to_noise_ratio[i2];
            int i13 = i12 + 1;
            if (i12 % 2 == 0) {
                List<Byte> list15 = this.glIDSignalList;
                if (list15 != null) {
                    valueOf = Boolean.valueOf(list15.add(Byte.valueOf(b4)));
                }
                valueOf = null;
            } else {
                List<Byte> list16 = this.glSignalList;
                if (list16 != null) {
                    valueOf = Boolean.valueOf(list16.add(Byte.valueOf(b4)));
                }
                valueOf = null;
            }
            arrayList4.add(valueOf);
            i2++;
            i12 = i13;
        }
        calculateCacheGLSignalAverageValue();
        this.currentGlSignalAverage = new Pair<>(Float.valueOf(calculateGLAverageValue()), this.currentGlSignalAverage.getFirst());
        TextView textView8 = this.tvGLCarrierRatio;
        if (textView8 != null) {
            textView8.setText("GL载噪比 [前两颗5秒平均值:" + this.currentGlSignalAverage.getFirst().floatValue() + PropertyUtils.INDEXED_DELIM2);
        }
        RvCommonAdapter<Byte, ItemGpsDebugLayoutBinding> rvCommonAdapter4 = this.rvGLAdapter;
        if (rvCommonAdapter4 != null) {
            rvCommonAdapter4.notifyDataSetChanged();
        }
        if (this.isRecordLog) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TestGpsSignalController$onEvent$5(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String writeData() {
        StringBuffer append;
        StringBuffer append2;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) 12304 + FormatUtil.formatTimeSss(System.currentTimeMillis()) + "】\n");
            List<Byte> list = this.gpIDSignalList;
            int i = 0;
            if (list != null && list.size() >= 6) {
                stringBuffer.append("【GP】\n");
                List<Byte> subList = list.subList(0, 6);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
                int i2 = 0;
                for (Object obj : subList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    byte byteValue = ((Number) obj).byteValue();
                    if (i2 == 2) {
                        append2 = stringBuffer.append("卫星号:" + findId(list, i2) + " 载噪比:" + ((int) byteValue) + '\n');
                    } else {
                        append2 = stringBuffer.append("卫星号:" + findId(list, i2) + " 载噪比:" + ((int) byteValue) + "\t\t");
                    }
                    arrayList.add(append2);
                    i2 = i3;
                }
                ArrayList arrayList2 = arrayList;
            }
            List<Byte> list2 = this.glIDSignalList;
            if (list2 != null && list2.size() >= 4) {
                stringBuffer.append("\n【GL】\n");
                List<Byte> subList2 = list2.subList(0, 4);
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList2, 10));
                for (Object obj2 : subList2) {
                    int i4 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    byte byteValue2 = ((Number) obj2).byteValue();
                    if (i == 2) {
                        append = stringBuffer.append("卫星号:" + findId(list2, i) + " 载噪比:" + ((int) byteValue2) + '\n');
                    } else {
                        append = stringBuffer.append("卫星号:" + findId(list2, i) + " 载噪比:" + ((int) byteValue2) + "\t\t");
                    }
                    arrayList3.add(append);
                    i = i4;
                }
                ArrayList arrayList4 = arrayList3;
            }
            stringBuffer.append("\n");
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRecordLog(boolean z) {
        if (z) {
            initRecordLog(withTempDir(), withCurTime() + "-gpsdata.txt");
        } else {
            closeRecordLog();
        }
        this.isRecordLog = z;
    }

    private final void initRecordLog(String filePath, String fileName) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(filePath, fileName);
            this.txtFile = file2;
            if (file2 != null && !file2.exists()) {
                file2.createNewFile();
            }
            this.txtRaf = new RandomAccessFile(this.txtFile, "rwd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordLog(String strContent) {
        byte[] bytes;
        try {
            RandomAccessFile randomAccessFile = this.txtRaf;
            if (randomAccessFile != null) {
                String trimIndent = StringsKt.trimIndent(strContent);
                File file = this.txtFile;
                if (file == null) {
                    Intrinsics.throwNpe();
                }
                randomAccessFile.seek(file.length());
                Charset charset = Charsets.UTF_8;
                if (trimIndent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes2 = trimIndent.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                randomAccessFile.write(bytes2);
                String property = System.getProperty("line.separator");
                if (property != null) {
                    Charset charset2 = Charsets.UTF_8;
                    if (property == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    bytes = property.getBytes(charset2);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    if (bytes != null) {
                        randomAccessFile.write(bytes);
                    }
                }
                bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                randomAccessFile.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void closeRecordLog() {
        try {
            RandomAccessFile randomAccessFile = this.txtRaf;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.txtRaf = (RandomAccessFile) null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String withTempDir() {
        LocalFileManager localFileManager = LocalFileManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
        File file = new File(localFileManager.getGpsLogDir());
        if (!file.exists()) {
            file.mkdir();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "fold.absolutePath");
        return absolutePath;
    }

    private final String withCurTime() {
        String curTime = FormatUtil.getCurTime();
        Intrinsics.checkExpressionValueIsNotNull(curTime, "FormatUtil.getCurTime()");
        return curTime;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        closeRecordLog();
        DataManager.getInstance().sendCtrlData(CtrlType.TYPE_GPS_SIGNAL_CLOSE);
    }

    static /* synthetic */ float keepDigitUp$default(TestGpsSignalController testGpsSignalController, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return testGpsSignalController.keepDigitUp(f, i);
    }

    private final float keepDigitUp(float d, int scale) {
        return new BigDecimal(d).setScale(scale, 4).floatValue();
    }
}