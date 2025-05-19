package com.ipotensic.kernel.services;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.bean.Gps;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.services.OrientationService;
import com.logan.flight.FlightConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: LocationService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ipotensic/kernel/services/LocationService;", "Lcom/ipotensic/kernel/services/ILocationService;", "()V", "bdLocationService", "Lcom/ipotensic/kernel/services/BDLocationService;", "locationChangedListener", "Lcom/ipotensic/kernel/services/OnLocationChangedListener;", "orientationService", "Lcom/ipotensic/kernel/services/OrientationService;", "systemLocationService", "Lcom/ipotensic/kernel/services/SystemLocationService;", "getCountryCode", "", "getRotate", "", "init", "isStart", "", "reStart", "setOnLocationChangedListener", "listener", TtmlNode.START, "stop", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class LocationService implements ILocationService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<LocationService>() { // from class: com.ipotensic.kernel.services.LocationService$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LocationService invoke() {
            return new LocationService(null);
        }
    });
    private final BDLocationService bdLocationService;
    private OnLocationChangedListener locationChangedListener;
    private OrientationService orientationService;
    private final SystemLocationService systemLocationService;

    public static final LocationService getInstance() {
        return INSTANCE.getInstance();
    }

    private LocationService() {
        this.bdLocationService = new BDLocationService();
        this.systemLocationService = new SystemLocationService();
    }

    public /* synthetic */ LocationService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LocationService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ipotensic/kernel/services/LocationService$Companion;", "", "()V", "instance", "Lcom/ipotensic/kernel/services/LocationService;", "instance$annotations", "getInstance", "()Lcom/ipotensic/kernel/services/LocationService;", "instance$delegate", "Lkotlin/Lazy;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "instance", "getInstance()Lcom/ipotensic/kernel/services/LocationService;"))};

        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        public final LocationService getInstance() {
            Lazy lazy = LocationService.instance$delegate;
            Companion companion = LocationService.INSTANCE;
            KProperty kProperty = $$delegatedProperties[0];
            return (LocationService) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void init() {
        this.bdLocationService.init();
        this.systemLocationService.init();
        if (this.orientationService == null) {
            OrientationService orientationService = new OrientationService(PhoneConfig.applicationContext);
            this.orientationService = orientationService;
            if (orientationService != null) {
                orientationService.setOnOrientationListener(new OrientationService.OnOrientationListener() { // from class: com.ipotensic.kernel.services.LocationService$init$1
                    @Override // com.ipotensic.kernel.services.OrientationService.OnOrientationListener
                    public final void onOrientationChanged(float f) {
                        OnLocationChangedListener onLocationChangedListener;
                        onLocationChangedListener = LocationService.this.locationChangedListener;
                        if (onLocationChangedListener != null) {
                            onLocationChangedListener.onPhoneOrientationChanged(f);
                        }
                    }
                });
            }
            OrientationService orientationService2 = this.orientationService;
            if (orientationService2 != null) {
                orientationService2.start();
            }
        }
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void start() {
        this.bdLocationService.start();
        this.systemLocationService.start();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void reStart() {
        this.bdLocationService.reStart();
        this.systemLocationService.reStart();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    /* renamed from: isStart */
    public boolean getIsRegister() {
        return this.bdLocationService.getIsRegister() && this.systemLocationService.getIsRegister();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void stop() {
        this.bdLocationService.stop();
        this.systemLocationService.stop();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public float getRotate() {
        OrientationService orientationService = this.orientationService;
        if (orientationService == null) {
            return 0.0f;
        }
        if (orientationService == null) {
            Intrinsics.throwNpe();
        }
        return orientationService.getRotate();
    }

    @Override // com.ipotensic.kernel.services.ILocationService
    public void setOnLocationChangedListener(OnLocationChangedListener listener) {
        this.locationChangedListener = listener;
        this.systemLocationService.setOnLocationChangedListener(listener);
        this.bdLocationService.setOnLocationChangedListener(listener);
    }

    public final void getCountryCode() {
        BDLocationService bDLocationService = this.bdLocationService;
        Gps gps = FlightConfig.GPS;
        Intrinsics.checkExpressionValueIsNotNull(gps, "FlightConfig.GPS");
        double lng = gps.getLng();
        Gps gps2 = FlightConfig.GPS;
        Intrinsics.checkExpressionValueIsNotNull(gps2, "FlightConfig.GPS");
        bDLocationService.testReGeo(lng, gps2.getLat());
    }
}
