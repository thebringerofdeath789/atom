package com.logan.uom;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.livedata.DataChangedLiveData;
import com.ipotensic.baselib.mediadataretriever.utils.TimeUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevRecord;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.type.Flight;
import com.logan.uom.bean.UomRecord;
import com.logan.uom.bean.UomUploadBody;
import com.logan.uom.bean.UomUploadState;
import com.logan.uom.enums.FlightStatus;
import com.logan.uom.enums.UomState;
import com.logan.uom.listeners.OnUomHandleListener;
import com.logan.uom.listeners.OnUomUploadListener;
import com.logan.uom.utils.HttpRequest;
import com.logan.uom.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.litepal.LitePal;

/* compiled from: UomHandler.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002J\u001c\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0017H\u0002J\n\u0010(\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006-"}, m2338d2 = {"Lcom/logan/uom/UomHandler;", "Lcom/ipotensic/baselib/dispatcher/EventDispatcher$OnEventListener;", "()V", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sorties", "Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "", "sortiesListener", "Landroidx/lifecycle/Observer;", "sortiesRecords", "Ljava/util/ArrayList;", "Lcom/logan/uom/bean/UomRecord;", "Lkotlin/collections/ArrayList;", "sqlList", "Lcom/logan/uom/bean/UomUploadBody;", "uomHandleListener", "Lcom/logan/uom/listeners/OnUomHandleListener;", "getUomHandleListener", "()Lcom/logan/uom/listeners/OnUomHandleListener;", "setUomHandleListener", "(Lcom/logan/uom/listeners/OnUomHandleListener;)V", "deInit", "", "deleteThreeDaysAgoRecordsIfExist", "deleteThreeMonthAgoFlightRouteIfExist", "getUasModel", "", "flight", "Lcom/logan/flight/type/Flight;", "init", "isFlightTypeSupport", "", "isInFlying", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "saveTaskOnce", "takeFlightRoute", "takeRecordRoute", "uomState", "Lcom/logan/uom/enums/UomState;", "Companion", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class UomHandler implements EventDispatcher.OnEventListener {
    private static final int ONCE_UPLOAD_NUM = 500;
    private ArrayList<UomUploadBody> sqlList;
    private OnUomHandleListener uomHandleListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<UomHandler>() { // from class: com.logan.uom.UomHandler$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UomHandler invoke() {
            return new UomHandler();
        }
    });
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final DataChangedLiveData<Integer> sorties = new DataChangedLiveData<>();
    private final ArrayList<UomRecord> sortiesRecords = new ArrayList<>();
    private final Observer<Integer> sortiesListener = new UomHandler$sortiesListener$1(this);

    @Metadata(m2336bv = {1, 0, 3}, m2339k = 3, m2340mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Flight.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Flight.Flight_ATOM_SE_V2.ordinal()] = 1;
            iArr[Flight.Flight_ATOM_SE_V3.ordinal()] = 2;
            iArr[Flight.Flight_ATOM.ordinal()] = 3;
            iArr[Flight.Flight_ATOM_V2.ordinal()] = 4;
            iArr[Flight.Flight_ATOM_LT.ordinal()] = 5;
        }
    }

    public static final UomHandler getInstance() {
        return INSTANCE.getInstance();
    }

    /* compiled from: UomHandler.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m2338d2 = {"Lcom/logan/uom/UomHandler$Companion;", "", "()V", "ONCE_UPLOAD_NUM", "", "instance", "Lcom/logan/uom/UomHandler;", "instance$annotations", "getInstance", "()Lcom/logan/uom/UomHandler;", "instance$delegate", "Lkotlin/Lazy;", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/logan/uom/UomHandler;"))};

        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        public final UomHandler getInstance() {
            Lazy lazy = UomHandler.instance$delegate;
            Companion companion = UomHandler.INSTANCE;
            KProperty kProperty = $$delegatedProperties[0];
            return (UomHandler) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final OnUomHandleListener getUomHandleListener() {
        return this.uomHandleListener;
    }

    public final void setUomHandleListener(OnUomHandleListener onUomHandleListener) {
        this.uomHandleListener = onUomHandleListener;
    }

    public final void init() {
        EventDispatcher.get().registerEvent(this);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UomHandler$init$1(this, null), 3, null);
        ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.logan.uom.UomHandler$init$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect condition in loop: B:3:0x001e */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2() {
                /*
                    r2 = this;
                    com.logan.uom.UomHandler r0 = com.logan.uom.UomHandler.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = com.logan.uom.UomHandler.access$isRunning$p(r0)
                    r1 = 1
                    r0.set(r1)
                    com.logan.uom.UomHandler r0 = com.logan.uom.UomHandler.this
                    com.logan.uom.UomHandler.access$deleteThreeMonthAgoFlightRouteIfExist(r0)
                    com.logan.uom.UomHandler r0 = com.logan.uom.UomHandler.this
                    r0.deleteThreeDaysAgoRecordsIfExist()
                L14:
                    com.logan.uom.UomHandler r0 = com.logan.uom.UomHandler.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = com.logan.uom.UomHandler.access$isRunning$p(r0)
                    boolean r0 = r0.get()
                    if (r0 == 0) goto L2b
                    r0 = 2000(0x7d0, double:9.88E-321)
                    java.lang.Thread.sleep(r0)
                    com.logan.uom.UomHandler r0 = com.logan.uom.UomHandler.this
                    com.logan.uom.UomHandler.access$saveTaskOnce(r0)
                    goto L14
                L2b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.uom.UomHandler$init$2.invoke2():void");
            }
        }, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.logan.uom.enums.UomState] */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, com.logan.uom.enums.UomState] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.logan.uom.enums.UomState] */
    public final synchronized void saveTaskOnce() {
        ArrayList<UomUploadBody> arrayList;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (UomState) 0;
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context context = PhoneConfig.applicationContext;
        Intrinsics.checkExpressionValueIsNotNull(context, "PhoneConfig.applicationContext");
        if (networkUtils.isNetworkConnected(context)) {
            objectRef.element = UomState.NORMAL_NETWORK_AVAILABLE;
            final ArrayList<UomUploadBody> arrayList2 = this.sqlList;
            if (arrayList2 != null) {
                if (!(!arrayList2.isEmpty())) {
                    arrayList2 = null;
                }
                if (arrayList2 != null) {
                    if (arrayList2.size() > 500) {
                        final List take = CollectionsKt.take(arrayList2, 500);
                        HttpRequest httpRequest = HttpRequest.INSTANCE;
                        OnUomUploadListener onUomUploadListener = new OnUomUploadListener() { // from class: com.logan.uom.UomHandler$saveTaskOnce$$inlined$let$lambda$1
                            /* JADX WARN: Type inference failed for: r1v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onUploadSuccess() {
                                objectRef.element = UomState.NORMAL_UPLOAD;
                                Iterator it = take.iterator();
                                while (it.hasNext()) {
                                    ((UomUploadBody) it.next()).delete();
                                }
                                arrayList2.subList(0, 500).clear();
                            }

                            /* JADX WARN: Type inference failed for: r0v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onServerError(Integer serverErrCode) {
                                objectRef.element = UomState.ABNORMAL_SERVER_ERROR;
                            }

                            /* JADX WARN: Type inference failed for: r0v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onUploadFailed(Exception exc) {
                                objectRef.element = UomState.ABNORMAL_NO_NETWORK;
                            }
                        };
                        Object[] array = take.toArray(new UomUploadBody[0]);
                        if (array != null) {
                            UomUploadBody[] uomUploadBodyArr = (UomUploadBody[]) array;
                            httpRequest.uploadFlightRoute(onUomUploadListener, (UomUploadBody[]) Arrays.copyOf(uomUploadBodyArr, uomUploadBodyArr.length));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        HttpRequest httpRequest2 = HttpRequest.INSTANCE;
                        OnUomUploadListener onUomUploadListener2 = new OnUomUploadListener() { // from class: com.logan.uom.UomHandler$saveTaskOnce$$inlined$let$lambda$2
                            /* JADX WARN: Type inference failed for: r1v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onUploadSuccess() {
                                objectRef.element = UomState.NORMAL_UPLOAD;
                                Iterator it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    ((UomUploadBody) it.next()).delete();
                                }
                                arrayList2.clear();
                            }

                            /* JADX WARN: Type inference failed for: r0v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onServerError(Integer serverErrCode) {
                                objectRef.element = UomState.ABNORMAL_SERVER_ERROR;
                            }

                            /* JADX WARN: Type inference failed for: r0v0, types: [T, com.logan.uom.enums.UomState] */
                            @Override // com.logan.uom.listeners.OnUomUploadListener
                            public void onUploadFailed(Exception exc) {
                                objectRef.element = UomState.ABNORMAL_NO_NETWORK;
                            }
                        };
                        Object[] array2 = arrayList2.toArray(new UomUploadBody[0]);
                        if (array2 != null) {
                            UomUploadBody[] uomUploadBodyArr2 = (UomUploadBody[]) array2;
                            httpRequest2.uploadFlightRoute(onUomUploadListener2, (UomUploadBody[]) Arrays.copyOf(uomUploadBodyArr2, uomUploadBodyArr2.length));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                }
            }
            UomUploadBody takeFlightRoute = takeFlightRoute();
            if (takeFlightRoute != null && takeFlightRoute.save() && (arrayList = this.sqlList) != null) {
                arrayList.add(takeFlightRoute);
            }
        } else {
            objectRef.element = UomState.ABNORMAL_NO_NETWORK;
        }
        DDLog.m1684e("UOM状态 : " + ((UomState) objectRef.element));
        UomState uomState = (UomState) objectRef.element;
        if (uomState != null) {
            UomRecord takeRecordRoute = takeRecordRoute(uomState);
            if (takeRecordRoute != null) {
                takeRecordRoute.save();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UomHandler$saveTaskOnce$$inlined$let$lambda$3(uomState, null, this), 3, null);
        }
    }

    private final UomUploadBody takeFlightRoute() {
        FlightStatus flightStatus;
        long j;
        long j2;
        int i;
        int i2;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (isFlightTypeSupport() && isInFlying()) {
                FlightRevData flightRevData = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
                FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData.isInit()) {
                    FlightRevData flightRevData2 = FlightRevData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
                    FlightRevFlightInfoData flightRevFlightInfoData = flightRevData2.getFlightRevFlightInfoData();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData, "FlightRevData.get().flightRevFlightInfoData");
                    if (flightRevFlightInfoData.isInit()) {
                        FlightRevData flightRevData3 = FlightRevData.get();
                        Intrinsics.checkExpressionValueIsNotNull(flightRevData3, "FlightRevData.get()");
                        FlightRevRecord flightRecordData = flightRevData3.getFlightRecordData();
                        Intrinsics.checkExpressionValueIsNotNull(flightRecordData, "FlightRevData.get().flightRecordData");
                        if (flightRecordData.isInit()) {
                            FlightRevData flightRevData4 = FlightRevData.get();
                            Intrinsics.checkExpressionValueIsNotNull(flightRevData4, "FlightRevData.get()");
                            FlightRevVersionData flightRevVersionData = flightRevData4.getFlightRevVersionData();
                            Intrinsics.checkExpressionValueIsNotNull(flightRevVersionData, "FlightRevData.get().flightRevVersionData");
                            if (flightRevVersionData.isInit()) {
                                FlightRevData flightRevData5 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData5, "FlightRevData.get()");
                                FlightRevStateData flightRevStateData2 = flightRevData5.getFlightRevStateData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData2, "FlightRevData.get().flightRevStateData");
                                boolean isGpsMode = flightRevStateData2.isGpsMode();
                                FlightRevData flightRevData6 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData6, "FlightRevData.get()");
                                FlightRevStateData flightRevStateData3 = flightRevData6.getFlightRevStateData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData3, "FlightRevData.get().flightRevStateData");
                                if (flightRevStateData3.isTakeOff()) {
                                    flightStatus = FlightStatus.TakeOff;
                                } else {
                                    FlightRevData flightRevData7 = FlightRevData.get();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevData7, "FlightRevData.get()");
                                    FlightRevStateData flightRevStateData4 = flightRevData7.getFlightRevStateData();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevStateData4, "FlightRevData.get().flightRevStateData");
                                    flightStatus = flightRevStateData4.isLanding() ? FlightStatus.Land : FlightStatus.Inflight;
                                }
                                FlightRevData flightRevData8 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData8, "FlightRevData.get()");
                                FlightRevVersionData flightRevVersionData2 = flightRevData8.getFlightRevVersionData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevVersionData2, "FlightRevData.get().flightRevVersionData");
                                String flightSN = flightRevVersionData2.getFlightSN();
                                Intrinsics.checkExpressionValueIsNotNull(flightSN, "FlightRevData.get().flightRevVersionData.flightSN");
                                long currentTimeMillis = System.currentTimeMillis();
                                FlightRevData flightRevData9 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData9, "FlightRevData.get()");
                                int sorties = flightRevData9.getFlightRecordData().getSorties();
                                String name = flightStatus.name();
                                String name2 = FlightConfig.curFlight.name();
                                if (isGpsMode) {
                                    FlightRevData flightRevData10 = FlightRevData.get();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevData10, "FlightRevData.get()");
                                    FlightRevFlightInfoData flightRevFlightInfoData2 = flightRevData10.getFlightRevFlightInfoData();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData2, "FlightRevData.get().flightRevFlightInfoData");
                                    j = (long) (flightRevFlightInfoData2.getLng() * 10000000);
                                } else {
                                    j = 0;
                                }
                                if (isGpsMode) {
                                    FlightRevData flightRevData11 = FlightRevData.get();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevData11, "FlightRevData.get()");
                                    FlightRevFlightInfoData flightRevFlightInfoData3 = flightRevData11.getFlightRevFlightInfoData();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData3, "FlightRevData.get().flightRevFlightInfoData");
                                    j2 = (long) (flightRevFlightInfoData3.getLat() * 10000000);
                                } else {
                                    j2 = 0;
                                }
                                FlightRevData flightRevData12 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData12, "FlightRevData.get()");
                                FlightRevFlightInfoData flightRevFlightInfoData4 = flightRevData12.getFlightRevFlightInfoData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData4, "FlightRevData.get().flightRevFlightInfoData");
                                int verticalDistance = ((int) flightRevFlightInfoData4.getVerticalDistance()) * 10;
                                FlightRevData flightRevData13 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData13, "FlightRevData.get()");
                                FlightRevFlightInfoData flightRevFlightInfoData5 = flightRevData13.getFlightRevFlightInfoData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData5, "FlightRevData.get().flightRevFlightInfoData");
                                int altitude = flightRevFlightInfoData5.getAltitude() * 10;
                                FlightRevData flightRevData14 = FlightRevData.get();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevData14, "FlightRevData.get()");
                                FlightRevFlightInfoData flightRevFlightInfoData6 = flightRevData14.getFlightRevFlightInfoData();
                                Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData6, "FlightRevData.get().flightRevFlightInfoData");
                                int verticalSpeed = ((int) flightRevFlightInfoData6.getVerticalSpeed()) * 10;
                                if (isGpsMode) {
                                    FlightRevData flightRevData15 = FlightRevData.get();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevData15, "FlightRevData.get()");
                                    FlightRevFlightInfoData flightRevFlightInfoData7 = flightRevData15.getFlightRevFlightInfoData();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData7, "FlightRevData.get().flightRevFlightInfoData");
                                    i = ((int) flightRevFlightInfoData7.getHorizontalSpeed()) * 10;
                                } else {
                                    i = 0;
                                }
                                int i3 = i;
                                if (isGpsMode) {
                                    FlightRevData flightRevData16 = FlightRevData.get();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevData16, "FlightRevData.get()");
                                    FlightRevFlightInfoData flightRevFlightInfoData8 = flightRevData16.getFlightRevFlightInfoData();
                                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData8, "FlightRevData.get().flightRevFlightInfoData");
                                    i2 = flightRevFlightInfoData8.getDirectToNorth() * 10;
                                } else {
                                    i2 = -999;
                                }
                                return new UomUploadBody(flightSN, currentTimeMillis, sorties, name, name2, j, j2, verticalDistance, altitude, verticalSpeed, i3, i2);
                            }
                        }
                    }
                }
            }
            Result.m2647constructorimpl(Unit.INSTANCE);
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m2647constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r2.get(kotlin.collections.CollectionsKt.getLastIndex(r2)).getUomStateEnumName(), r7.name())) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.logan.uom.bean.UomRecord takeRecordRoute(com.logan.uom.enums.UomState r7) {
        /*
            r6 = this;
            java.lang.String r0 = "FlightRevData.get()"
            r1 = 0
            com.logan.uom.bean.UomRecord r1 = (com.logan.uom.bean.UomRecord) r1
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L92
            boolean r2 = r6.isFlightTypeSupport()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L8c
            boolean r2 = r6.isInFlying()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L8c
            java.util.ArrayList<com.logan.uom.bean.UomRecord> r2 = r6.sortiesRecords     // Catch: java.lang.Throwable -> L92
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L92
            if (r2 != 0) goto L3a
            java.util.ArrayList<com.logan.uom.bean.UomRecord> r2 = r6.sortiesRecords     // Catch: java.lang.Throwable -> L92
            r3 = r2
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L92
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r3)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L92
            com.logan.uom.bean.UomRecord r2 = (com.logan.uom.bean.UomRecord) r2     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r2.getUomStateEnumName()     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = r7.name()     // Catch: java.lang.Throwable -> L92
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)     // Catch: java.lang.Throwable -> L92
            r2 = r2 ^ 1
            if (r2 == 0) goto L8c
        L3a:
            com.logan.flight.data.FlightRevData r2 = com.logan.flight.data.FlightRevData.get()     // Catch: java.lang.Throwable -> L92
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)     // Catch: java.lang.Throwable -> L92
            com.logan.flight.data.recv.FlightRevRecord r2 = r2.getFlightRecordData()     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = "FlightRevData.get().flightRecordData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)     // Catch: java.lang.Throwable -> L92
            boolean r2 = r2.isInit()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L8c
            com.logan.flight.data.FlightRevData r2 = com.logan.flight.data.FlightRevData.get()     // Catch: java.lang.Throwable -> L92
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)     // Catch: java.lang.Throwable -> L92
            com.logan.flight.data.recv.FlightRevStateData r2 = r2.getFlightRevStateData()     // Catch: java.lang.Throwable -> L92
            java.lang.String r3 = "FlightRevData.get().flightRevStateData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)     // Catch: java.lang.Throwable -> L92
            boolean r2 = r2.isInit()     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L8c
            com.logan.uom.bean.UomRecord r2 = new com.logan.uom.bean.UomRecord     // Catch: java.lang.Throwable -> L92
            java.lang.String r7 = r7.name()     // Catch: java.lang.Throwable -> L92
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L92
            com.logan.flight.data.FlightRevData r5 = com.logan.flight.data.FlightRevData.get()     // Catch: java.lang.Throwable -> L92
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)     // Catch: java.lang.Throwable -> L92
            com.logan.flight.data.recv.FlightRevRecord r0 = r5.getFlightRecordData()     // Catch: java.lang.Throwable -> L92
            int r0 = r0.getSorties()     // Catch: java.lang.Throwable -> L92
            r2.<init>(r7, r3, r0)     // Catch: java.lang.Throwable -> L92
            java.util.ArrayList<com.logan.uom.bean.UomRecord> r7 = r6.sortiesRecords     // Catch: java.lang.Throwable -> L89
            r7.add(r2)     // Catch: java.lang.Throwable -> L89
            r1 = r2
            goto L8c
        L89:
            r7 = move-exception
            r1 = r2
            goto L93
        L8c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L92
            kotlin.Result.m2647constructorimpl(r7)     // Catch: java.lang.Throwable -> L92
            goto L9c
        L92:
            r7 = move-exception
        L93:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            kotlin.Result.m2647constructorimpl(r7)
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.logan.uom.UomHandler.takeRecordRoute(com.logan.uom.enums.UomState):com.logan.uom.bean.UomRecord");
    }

    public final boolean isFlightTypeSupport() {
        Flight lastFlight = FlightConfig.getLastFlight();
        return lastFlight == Flight.Flight_ATOM_SE_V2 || lastFlight == Flight.Flight_ATOM_SE_V3 || lastFlight == Flight.Flight_ATOM || lastFlight == Flight.Flight_ATOM_V2 || lastFlight == Flight.Flight_ATOM_LT;
    }

    public final String getUasModel(Flight flight) {
        Intrinsics.checkParameterIsNotNull(flight, "flight");
        int i = WhenMappings.$EnumSwitchMapping$0[flight.ordinal()];
        return (i == 1 || i == 2) ? UomConfig.UAS_MODEL_ATOM_SE : (i == 3 || i == 4 || i != 5) ? UomConfig.UAS_MODEL_ATOM : UomConfig.UAS_MODEL_ATOM_LT;
    }

    private final boolean isInFlying() {
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
        if (flightRevStateData.isInit()) {
            FlightRevData flightRevData2 = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
            FlightRevStateData flightRevStateData2 = flightRevData2.getFlightRevStateData();
            Intrinsics.checkExpressionValueIsNotNull(flightRevStateData2, "FlightRevData.get().flightRevStateData");
            if (!flightRevStateData2.isFlight()) {
                FlightRevData flightRevData3 = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData3, "FlightRevData.get()");
                FlightRevStateData flightRevStateData3 = flightRevData3.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData3, "FlightRevData.get().flightRevStateData");
                if (!flightRevStateData3.isTakeOff()) {
                    FlightRevData flightRevData4 = FlightRevData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevData4, "FlightRevData.get()");
                    FlightRevStateData flightRevStateData4 = flightRevData4.getFlightRevStateData();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevStateData4, "FlightRevData.get().flightRevStateData");
                    if (!flightRevStateData4.isLanding()) {
                        FlightRevData flightRevData5 = FlightRevData.get();
                        Intrinsics.checkExpressionValueIsNotNull(flightRevData5, "FlightRevData.get()");
                        FlightRevStateData flightRevStateData5 = flightRevData5.getFlightRevStateData();
                        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData5, "FlightRevData.get().flightRevStateData");
                        if (flightRevStateData5.isReturning()) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void deleteThreeDaysAgoRecordsIfExist() {
        ArrayList<UomRecord> arrayList = new ArrayList(LitePal.findAll(UomRecord.class, new long[0]));
        long daysAgoMillis = TimeUtil.getDaysAgoMillis(3);
        for (UomRecord uomRecord : arrayList) {
            if (uomRecord.getUomStateChangedTime() < daysAgoMillis) {
                uomRecord.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteThreeMonthAgoFlightRouteIfExist() {
        ArrayList<UomUploadBody> arrayList = new ArrayList<>(LitePal.findAll(UomUploadBody.class, new long[0]));
        this.sqlList = arrayList;
        if (arrayList != null) {
            final long daysAgoMillis = TimeUtil.getDaysAgoMillis(91);
            CollectionsKt.removeAll((List) arrayList, (Function1) new Function1<UomUploadBody, Boolean>() { // from class: com.logan.uom.UomHandler$deleteThreeMonthAgoFlightRouteIfExist$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(UomUploadBody uomUploadBody) {
                    return Boolean.valueOf(invoke2(uomUploadBody));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(UomUploadBody it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.getTimeMillis() < daysAgoMillis;
                }
            });
        }
    }

    public final void deInit() {
        EventDispatcher.get().unRegisterEvent(this);
        this.isRunning.set(false);
        this.sorties.removeObserver(this.sortiesListener);
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        OnUomHandleListener onUomHandleListener;
        if (what == EventID.FLIGHT_RECEIVE_RECORD_DATA) {
            FlightRevRecord flightRevRecord = (FlightRevRecord) (event != null ? event.obj : null);
            if (flightRevRecord != null) {
                this.sorties.setValue(Integer.valueOf(flightRevRecord.getSorties()));
                if (isInFlying() && isFlightTypeSupport() && (onUomHandleListener = this.uomHandleListener) != null) {
                    int sorties = flightRevRecord.getSorties();
                    NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                    Context context = PhoneConfig.applicationContext;
                    Intrinsics.checkExpressionValueIsNotNull(context, "PhoneConfig.applicationContext");
                    onUomHandleListener.onUomUploadStateCallback(new UomUploadState(sorties, networkUtils.isNetworkConnected(context)));
                }
            }
        }
    }
}