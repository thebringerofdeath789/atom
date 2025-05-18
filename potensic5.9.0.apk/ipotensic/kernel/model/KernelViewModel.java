package com.ipotensic.kernel.model;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.bean.Gps;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.livedata.SingleLiveData;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.DroneNoticeBean;
import com.ipotensic.kernel.bean.ErrorCode;
import com.ipotensic.kernel.controllers.MapVideoController;
import com.ipotensic.kernel.enums.CountryCode;
import com.ipotensic.kernel.maps.bean.CircleStyle;
import com.ipotensic.kernel.maps.bean.CommonLatLng;
import com.ipotensic.kernel.maps.bean.NoFlyZoneModel;
import com.ipotensic.kernel.maps.bean.NoFlyZoneSubModel;
import com.ipotensic.kernel.maps.utils.NoFlyZoneUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.utils.SortUtils;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.data.PhotoChildMode;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.send.SendFlightSetData;
import com.logan.flight.enums.CommonMsgType;
import com.logan.uom.UomHandler;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00a5\u00012\u00020\u0001:\u0002\u00a5\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\b\b\u0002\u0010y\u001a\u00020q2\b\b\u0002\u0010z\u001a\u00020\u001d2\b\b\u0002\u0010{\u001a\u00020\u0013J\u0018\u0010\b\u001a\u00020v2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH\u0002J\t\u0010\u0080\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u001dH\u0002J\u0007\u0010\u0083\u0001\u001a\u00020\u001dJ\t\u0010\u0084\u0001\u001a\u00020vH\u0002J\u0019\u0010\u0085\u0001\u001a\u00020v2\u0006\u0010|\u001a\u00020}2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020vJ\u0007\u0010\u0089\u0001\u001a\u00020\u001dJ\u0007\u0010\u008a\u0001\u001a\u00020\u001dJ\u0007\u0010\u008b\u0001\u001a\u00020\u0013J\u0010\u0010\u008c\u0001\u001a\u00020v2\u0007\u0010\u008d\u0001\u001a\u00020\u0013J\u0007\u0010\u008e\u0001\u001a\u00020\u001dJ\u0007\u0010\u008f\u0001\u001a\u00020\u001dJ\u000f\u0010\u0090\u0001\u001a\u00020v2\u0006\u0010w\u001a\u00020xJ\u0007\u0010\u0091\u0001\u001a\u00020vJ\u0007\u0010\u0092\u0001\u001a\u00020vJ\u0007\u0010\u0093\u0001\u001a\u00020vJ\u0013\u0010\u0094\u0001\u001a\u00020v2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u0007\u0010\u0097\u0001\u001a\u00020vJ\u000f\u0010\u0098\u0001\u001a\u00020v2\u0006\u0010|\u001a\u00020}J\u001a\u0010\u0099\u0001\u001a\u00020v2\u0006\u0010|\u001a\u00020}2\u0007\u0010\u009a\u0001\u001a\u00020dH\u0002J\t\u0010\u009b\u0001\u001a\u00020vH\u0002J\t\u0010\u009c\u0001\u001a\u00020vH\u0002J\u0007\u0010\u009d\u0001\u001a\u00020vJ\u0007\u0010\u009e\u0001\u001a\u00020vJ\u0007\u0010\u009f\u0001\u001a\u00020vJ\u0011\u0010\u00a0\u0001\u001a\u00020v2\b\u0010\u00a1\u0001\u001a\u00030\u00a2\u0001J \u0010\u00a3\u0001\u001a\u00020v2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u00a4\u0001\u001a\u00020\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010/R\u001f\u00100\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00130\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R(\u00102\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00130\u00130\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\u0018R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0011\u00106\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u000508\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001f\u0010;\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u001d0\u001d0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0007R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001d\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020>0D\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR!\u0010G\u001a\u0012\u0012\u0004\u0012\u00020I0Hj\b\u0012\u0004\u0012\u00020I`J\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u001d\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020>0D\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010FR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0007R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0007R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0011R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010_X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0011R\u000e\u0010c\u001a\u00020dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010\u0007R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010lX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0007R\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020q0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010\u0007R\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020q0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010\u0007\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/ipotensic/kernel/model/KernelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addLongTip", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ipotensic/kernel/bean/DroneNoticeBean;", "getAddLongTip", "()Landroidx/lifecycle/MutableLiveData;", "addNoFlyZoneData", "Lcom/ipotensic/kernel/maps/bean/NoFlyZoneSubModel;", "getAddNoFlyZoneData", "beginnerModeJob", "Lkotlinx/coroutines/Job;", "closeSetting", "Lcom/ipotensic/baselib/livedata/SingleLiveData;", "Ljava/lang/Void;", "getCloseSetting", "()Lcom/ipotensic/baselib/livedata/SingleLiveData;", "compassCalibrate", "", "getCompassCalibrate", "findingDrone", "getFindingDrone", "setFindingDrone", "(Landroidx/lifecycle/MutableLiveData;)V", "formatSdcard", "getFormatSdcard", "fpvSignal", "Lkotlin/Pair;", "", "getFpvSignal", "()Lkotlin/Pair;", "setFpvSignal", "(Lkotlin/Pair;)V", "getBigPackageVersion", "getGetBigPackageVersion", "gimbalAdjustment", "getGimbalAdjustment", "gimbalCalibrate", "getGimbalCalibrate", "heightTag", "getHeightTag", "()I", "setHeightTag", "(I)V", "isFlightUnlock", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "isLoadNoFlyZone", "kotlin.jvm.PlatformType", "isPropellerGuardCover", "setPropellerGuardCover", "isRemoterConnected", "isReturnOrLanding", "isShowBatterySafetyDialog", "longTipList", "", "getLongTipList", "()Ljava/util/List;", "maxHeight", "getMaxHeight", "noFlyZoneBounds", "", "getNoFlyZoneBounds", "()Ljava/lang/Object;", "setNoFlyZoneBounds", "(Ljava/lang/Object;)V", "noFlyZoneCircle", "", "getNoFlyZoneCircle", "()Ljava/util/Map;", "noFlyZoneData", "Ljava/util/ArrayList;", "Lcom/ipotensic/kernel/maps/bean/NoFlyZoneModel;", "Lkotlin/collections/ArrayList;", "getNoFlyZoneData", "()Ljava/util/ArrayList;", "noFlyZonePolygon", "getNoFlyZonePolygon", "over120Data", "getOver120Data", "pairDrone", "getPairDrone", "photoChildModeData", "Lcom/logan/camera/data/PhotoChildMode;", "getPhotoChildModeData", "remoterCalibrate", "getRemoterCalibrate", "removeLongTip", "getRemoveLongTip", "removeNoFlyZoneData", "getRemoveNoFlyZoneData", "sdcardPullOut", "getSdcardPullOut", "sendEnterSwoopReturnTimer", "Lcom/ipotensic/baselib/utils/CancelRunnable;", "sendExitSwoopReturnTimer", "setRecordSizeSuccess", "getSetRecordSizeSuccess", "startExitSwoopReturnTime", "", "startSendSwoopReturnTime", "stickMode", "getStickMode", "swoopReturnCountTime", "swoopReturnCountTimer", "Landroid/os/CountDownTimer;", "swoopReturnDialog", "Lcom/ipotensic/kernel/view/dialog/GeneralDialog;", "unLockDialog", "uomUploadRecord", "getUomUploadRecord", "updateFlightSN", "", "getUpdateFlightSN", "updateRemoteSN", "getUpdateRemoteSN", "addDroneLongTip", "", "errorCode", "Lcom/ipotensic/kernel/bean/ErrorCode;", "param", "index", "isNeedPrompt", "context", "Landroid/content/Context;", "controller", "Lcom/ipotensic/kernel/controllers/MapVideoController;", "checkAutoFlying", "checkFlightIsReady", "checkRemoterIsReady", "compassCalibration", "enterSwoopReturn", "executeSwoopReturn", "flightRevStateData", "Lcom/logan/flight/data/recv/FlightRevStateData;", "exitSwoopReturn", "gimbalCalibration", "gimbalFineTuning", "isSupportUom", "onConnect", "isConnect", "pairDroneAgain", "remoteCalibration", "removeDroneLongTip", "removeNoFlyZone", "resetPGCoverBeginnerMode", "sendSettings", "setNewerModeData", "data", "Lcom/logan/flight/data/send/SendFlightSetData;", "setSingleMode", "showUnlockDialog", "startSwoopReturnCountTimer", RtspHeaders.Values.TIME, "stopSendEnterSwoopData", "stopSendExitSwoopData", "stopSwoopReturnCountTimer", "update120Data", "updateBeginnerMode", "updateFpvSignal", "fpvState", "Lcom/logan/flight/data/recv/FlightRevConnectData;", "updateNoFlyZone", "isAdd", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelViewModel extends ViewModel {
    public static final int NO_ID = -1;
    private Job beginnerModeJob;
    private int heightTag;
    private Object noFlyZoneBounds;
    private CancelRunnable sendEnterSwoopReturnTimer;
    private CancelRunnable sendExitSwoopReturnTimer;
    private long startExitSwoopReturnTime;
    private long startSendSwoopReturnTime;
    private CountDownTimer swoopReturnCountTimer;
    private GeneralDialog swoopReturnDialog;
    private GeneralDialog unLockDialog;
    private final SingleLiveData<Void> closeSetting = new SingleLiveData<>();
    private final MutableLiveData<Boolean> compassCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> gimbalCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> gimbalAdjustment = new MutableLiveData<>();
    private final MutableLiveData<Boolean> remoterCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> uomUploadRecord = new MutableLiveData<>();
    private final MutableLiveData<Boolean> pairDrone = new MutableLiveData<>();
    private final MutableLiveData<Boolean> stickMode = new MutableLiveData<>();
    private final SingleLiveData<Void> formatSdcard = new SingleLiveData<>();
    private final SingleLiveData<Void> sdcardPullOut = new SingleLiveData<>();
    private final MutableLiveData<Boolean> isReturnOrLanding = new MutableLiveData<>();
    private final ObservableBoolean isShowBatterySafetyDialog = new ObservableBoolean(false);
    private final ObservableBoolean isFlightUnlock = new ObservableBoolean(true);
    private final MutableLiveData<Boolean> over120Data = new MutableLiveData<>();
    private MutableLiveData<Integer> swoopReturnCountTime = new MutableLiveData<>();
    private final MutableLiveData<PhotoChildMode> photoChildModeData = new MutableLiveData<>();
    private MutableLiveData<Boolean> findingDrone = new MutableLiveData<>(false);
    private final SingleLiveData<Void> setRecordSizeSuccess = new SingleLiveData<>();
    private final MutableLiveData<Boolean> isRemoterConnected = new MutableLiveData<>(false);
    private final MutableLiveData<String> updateFlightSN = new MutableLiveData<>();
    private final MutableLiveData<String> updateRemoteSN = new MutableLiveData<>();
    private final SingleLiveData<Void> getBigPackageVersion = new SingleLiveData<>();
    private Pair<Integer, Integer> fpvSignal = new Pair<>(0, 0);
    private final MutableLiveData<Integer> maxHeight = new MutableLiveData<>(Integer.valueOf(FlightConfig.getMaxHeight()));
    private final ArrayList<NoFlyZoneModel> noFlyZoneData = new ArrayList<>();
    private final MutableLiveData<NoFlyZoneSubModel> addNoFlyZoneData = new MutableLiveData<>();
    private final MutableLiveData<NoFlyZoneSubModel> removeNoFlyZoneData = new MutableLiveData<>();
    private final Map<NoFlyZoneSubModel, Object> noFlyZoneCircle = new HashMap();
    private final Map<NoFlyZoneSubModel, Object> noFlyZonePolygon = new HashMap();
    private final MutableLiveData<Boolean> isLoadNoFlyZone = new MutableLiveData<>(false);
    private final List<DroneNoticeBean> longTipList = new ArrayList();
    private final MutableLiveData<DroneNoticeBean> addLongTip = new MutableLiveData<>();
    private final MutableLiveData<DroneNoticeBean> removeLongTip = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPropellerGuardCover = new MutableLiveData<>(false);

    public final SingleLiveData<Void> getCloseSetting() {
        return this.closeSetting;
    }

    public final MutableLiveData<Boolean> getCompassCalibrate() {
        return this.compassCalibrate;
    }

    public final MutableLiveData<Boolean> getGimbalCalibrate() {
        return this.gimbalCalibrate;
    }

    public final MutableLiveData<Boolean> getGimbalAdjustment() {
        return this.gimbalAdjustment;
    }

    public final MutableLiveData<Boolean> getRemoterCalibrate() {
        return this.remoterCalibrate;
    }

    public final MutableLiveData<Boolean> getUomUploadRecord() {
        return this.uomUploadRecord;
    }

    public final MutableLiveData<Boolean> getPairDrone() {
        return this.pairDrone;
    }

    public final MutableLiveData<Boolean> getStickMode() {
        return this.stickMode;
    }

    public final SingleLiveData<Void> getFormatSdcard() {
        return this.formatSdcard;
    }

    public final SingleLiveData<Void> getSdcardPullOut() {
        return this.sdcardPullOut;
    }

    public final MutableLiveData<Boolean> isReturnOrLanding() {
        return this.isReturnOrLanding;
    }

    /* renamed from: isShowBatterySafetyDialog, reason: from getter */
    public final ObservableBoolean getIsShowBatterySafetyDialog() {
        return this.isShowBatterySafetyDialog;
    }

    /* renamed from: isFlightUnlock, reason: from getter */
    public final ObservableBoolean getIsFlightUnlock() {
        return this.isFlightUnlock;
    }

    public final MutableLiveData<Boolean> getOver120Data() {
        return this.over120Data;
    }

    public final int getHeightTag() {
        return this.heightTag;
    }

    public final void setHeightTag(int i) {
        this.heightTag = i;
    }

    public final MutableLiveData<PhotoChildMode> getPhotoChildModeData() {
        return this.photoChildModeData;
    }

    public final MutableLiveData<Boolean> getFindingDrone() {
        return this.findingDrone;
    }

    public final void setFindingDrone(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.findingDrone = mutableLiveData;
    }

    public final SingleLiveData<Void> getSetRecordSizeSuccess() {
        return this.setRecordSizeSuccess;
    }

    public final MutableLiveData<Boolean> isRemoterConnected() {
        return this.isRemoterConnected;
    }

    public final MutableLiveData<String> getUpdateFlightSN() {
        return this.updateFlightSN;
    }

    public final MutableLiveData<String> getUpdateRemoteSN() {
        return this.updateRemoteSN;
    }

    public final SingleLiveData<Void> getGetBigPackageVersion() {
        return this.getBigPackageVersion;
    }

    public final Pair<Integer, Integer> getFpvSignal() {
        return this.fpvSignal;
    }

    public final void setFpvSignal(Pair<Integer, Integer> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<set-?>");
        this.fpvSignal = pair;
    }

    public final MutableLiveData<Integer> getMaxHeight() {
        return this.maxHeight;
    }

    public final ArrayList<NoFlyZoneModel> getNoFlyZoneData() {
        return this.noFlyZoneData;
    }

    public final MutableLiveData<NoFlyZoneSubModel> getAddNoFlyZoneData() {
        return this.addNoFlyZoneData;
    }

    public final MutableLiveData<NoFlyZoneSubModel> getRemoveNoFlyZoneData() {
        return this.removeNoFlyZoneData;
    }

    public final Map<NoFlyZoneSubModel, Object> getNoFlyZoneCircle() {
        return this.noFlyZoneCircle;
    }

    public final Map<NoFlyZoneSubModel, Object> getNoFlyZonePolygon() {
        return this.noFlyZonePolygon;
    }

    public final MutableLiveData<Boolean> isLoadNoFlyZone() {
        return this.isLoadNoFlyZone;
    }

    public final Object getNoFlyZoneBounds() {
        return this.noFlyZoneBounds;
    }

    public final void setNoFlyZoneBounds(Object obj) {
        this.noFlyZoneBounds = obj;
    }

    public final List<DroneNoticeBean> getLongTipList() {
        return this.longTipList;
    }

    public final MutableLiveData<DroneNoticeBean> getAddLongTip() {
        return this.addLongTip;
    }

    public final MutableLiveData<DroneNoticeBean> getRemoveLongTip() {
        return this.removeLongTip;
    }

    public final MutableLiveData<Boolean> isPropellerGuardCover() {
        return this.isPropellerGuardCover;
    }

    public final void setPropellerGuardCover(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.isPropellerGuardCover = mutableLiveData;
    }

    public final void setSingleMode() {
        PhotoChildMode value = this.photoChildModeData.getValue();
        if (value != null) {
            value.intervalTime = 0;
        }
        PhotoChildMode value2 = this.photoChildModeData.getValue();
        if (value2 != null) {
            value2.childMode = 0;
        }
    }

    public final void updateFpvSignal(FlightRevConnectData fpvState) {
        Intrinsics.checkParameterIsNotNull(fpvState, "fpvState");
        this.fpvSignal = new Pair<>(Integer.valueOf(fpvState.getRssiRange()), this.fpvSignal.getFirst());
    }

    public final int compassCalibration() {
        DDLog.e("\u6307\u5357\u9488\u6821\u51c6");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkFlightIsReady = checkFlightIsReady();
        if (checkFlightIsReady != -1) {
            return checkFlightIsReady;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData stateData = flightRevData.getFlightRevStateData();
        if (FlightConfig.is_Atom_Series()) {
            Intrinsics.checkExpressionValueIsNotNull(stateData, "stateData");
            if (!stateData.isOutdoor()) {
                return R.string.settings_calibration_compass_calibration_failed_tips_outside_calibrate;
            }
            if (stateData.isGeomagneticFault()) {
                return R.string.error_geo_fault;
            }
            return (stateData.isUnLock() || stateData.isFlight()) ? R.string.txt_error_flighting_unavailable : checkFlightIsReady;
        }
        DDLog.e("\u4e0d\u662fatom\u7cfb\u5217");
        return checkFlightIsReady;
    }

    public final int gimbalCalibration() {
        DDLog.e("\u4e91\u53f0\u6821\u51c6");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkFlightIsReady = checkFlightIsReady();
        if (checkFlightIsReady != -1) {
            return checkFlightIsReady;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevGimbalStateData gimbalStateData = flightRevData.getGimbalStateData();
        Intrinsics.checkExpressionValueIsNotNull(gimbalStateData, "FlightRevData.get().gimbalStateData");
        short error_status = gimbalStateData.getError_status();
        if (error_status == 1 || error_status == 2) {
            return R.string.txt_error_gimbal_error;
        }
        if (error_status == 3) {
            FlightRevData flightRevData2 = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
            FlightRevStateData flightRevStateData = flightRevData2.getFlightRevStateData();
            Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
            if (flightRevStateData.isUnLock()) {
                return R.string.txt_error_flighting_unavailable;
            }
        } else {
            if (error_status == 4) {
                return R.string.warning_the_gimbal_is_stuck_briefly_tips;
            }
            if (error_status == 5) {
                return R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips;
            }
        }
        FlightRevData flightRevData3 = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData3, "FlightRevData.get()");
        FlightRevStateData flightRevStateData2 = flightRevData3.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData2, "FlightRevData.get().flightRevStateData");
        return flightRevStateData2.isUnLock() ? R.string.txt_error_flighting_unavailable : checkFlightIsReady;
    }

    public final int gimbalFineTuning() {
        DDLog.e("\u4e91\u53f0\u5fae\u8c03\u6821\u51c6");
        if (!FlightConfig.isConnectFlight()) {
            return R.string.toast_unconnected_tips;
        }
        if (Conditions.isTrackTargetOpen()) {
            return R.string.txt_pls_exit_short_video_first;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevGimbalStateData gimbalStateData = flightRevData.getGimbalStateData();
        Intrinsics.checkExpressionValueIsNotNull(gimbalStateData, "FlightRevData.get().gimbalStateData");
        switch (gimbalStateData.getError_status()) {
            case 1:
            case 2:
                return R.string.txt_error_gimbal_error;
            case 3:
                return R.string.txt_error_gimbal_need_calibration;
            case 4:
                return R.string.warning_the_gimbal_is_stuck_briefly_tips;
            case 5:
                return R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips;
            case 6:
                return R.string.txt_error_gimbal_angle_too_big;
            default:
                return -1;
        }
    }

    public final int remoteCalibration() {
        DDLog.e("\u9065\u63a7\u5668\u6821\u51c6");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkRemoterIsReady = checkRemoterIsReady();
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
        return flightRevStateData.isFlight() ? R.string.txt_error_flighting_unavailable : checkRemoterIsReady;
    }

    public final int pairDroneAgain() {
        DDLog.e("\u5bf9\u9891\u6821\u51c6");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkRemoterIsReady = checkRemoterIsReady();
        return (checkRemoterIsReady == -1 && FlightConfig.isConnectFlight()) ? R.string.plane_connecting : checkRemoterIsReady;
    }

    private final int checkRemoterIsReady() {
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevConnectData flightRevConnectData = flightRevData.getFlightRevConnectData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevConnectData, "FlightRevData.get().flightRevConnectData");
        if (!flightRevConnectData.isRemoterConnected()) {
            return R.string.txt_pls_connect_remoter;
        }
        if (Conditions.isFlying() && Conditions.isRecording()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    private final int checkAutoFlying() {
        if (Conditions.isFlying() || Conditions.isInShortVideo() || Conditions.isPointFly() || Conditions.isTakingOff() || Conditions.isReturning() || Conditions.isLanding()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    private final int checkFlightIsReady() {
        if (!FlightConfig.isConnectFlight()) {
            return R.string.toast_unconnected_tips;
        }
        if (Conditions.isFlying() && Conditions.isRecording()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    public final void update120Data() {
        int i;
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevSettingData settingData = flightRevData.getFlightRevSettingData();
        Intrinsics.checkExpressionValueIsNotNull(settingData, "settingData");
        int limitHeight = settingData.getLimitHeight();
        FlightRevData flightRevData2 = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
        FlightRevFlightInfoData flightRevFlightInfoData = flightRevData2.getFlightRevFlightInfoData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData, "FlightRevData.get().flightRevFlightInfoData");
        double verticalDistance = flightRevFlightInfoData.getVerticalDistance();
        String code = CountryCode.JP.getCode();
        SPHelper sPHelper = SPHelper.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(sPHelper, "SPHelper.getInstance()");
        if (!Intrinsics.areEqual(code, sPHelper.getCountryCode())) {
            String code2 = CountryCode.KR.getCode();
            SPHelper sPHelper2 = SPHelper.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(sPHelper2, "SPHelper.getInstance()");
            if (!Intrinsics.areEqual(code2, sPHelper2.getCountryCode())) {
                i = 120;
                if (verticalDistance <= i && limitHeight > i) {
                    if (this.heightTag < i) {
                        this.heightTag = i;
                        this.over120Data.setValue(true);
                        return;
                    }
                    return;
                }
                if (verticalDistance <= i - 3 || this.heightTag == 0) {
                }
                this.heightTag = 0;
                this.over120Data.setValue(false);
                return;
            }
        }
        i = 150;
        if (verticalDistance <= i) {
        }
        if (verticalDistance <= i - 3) {
        }
    }

    public final void executeSwoopReturn(Context context, FlightRevStateData flightRevStateData) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(flightRevStateData, "flightRevStateData");
        if (!Intrinsics.areEqual((Object) this.isReturnOrLanding.getValue(), (Object) true)) {
            return;
        }
        if (flightRevStateData.getSwoopReturnCountDown() > 0) {
            if (this.swoopReturnDialog != null) {
                return;
            }
            final KernelViewModel kernelViewModel = this;
            DDLog.e("\u4fef\u51b2\u8fd4\u822aswoopReturnDialog show");
            kernelViewModel.startSwoopReturnCountTimer(context, flightRevStateData.getSwoopReturnCountDown());
            GeneralDialog generalDialog = new GeneralDialog(context, context.getString(R.string.enter_descending_return_title), context.getString(R.string.descending_return_tips), context.getString(R.string.dialog_confirm) + "(" + kernelViewModel.swoopReturnCountTime.getValue() + "s)", new GeneralDialog.DialogListener() { // from class: com.ipotensic.kernel.model.KernelViewModel$executeSwoopReturn$1$1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void cancel() {
                    DDLog.e("\u4fef\u51b2\u8fd4\u822aswoopReturnDialog onCancel");
                    if (!FlightConfig.isConnectFlight()) {
                        KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                    } else {
                        KernelViewModel.this.exitSwoopReturn();
                    }
                    KernelViewModel.this.stopSwoopReturnCountTimer();
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void confirm() {
                    DDLog.e("\u4fef\u51b2\u8fd4\u822aswoopReturnDialog onConfirm");
                    if (FlightConfig.isConnectFlight()) {
                        KernelViewModel.this.enterSwoopReturn();
                    } else {
                        KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                    }
                    KernelViewModel.this.stopSwoopReturnCountTimer();
                }
            });
            kernelViewModel.swoopReturnDialog = generalDialog;
            if (generalDialog != null) {
                generalDialog.show();
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        GeneralDialog generalDialog2 = this.swoopReturnDialog;
        if (generalDialog2 != null) {
            if (generalDialog2.isShowing()) {
                enterSwoopReturn();
                generalDialog2.dismiss();
            }
            this.swoopReturnDialog = (GeneralDialog) null;
        }
    }

    private final void startSwoopReturnCountTimer(final Context context, final long time) {
        if (this.swoopReturnCountTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        DDLog.e("\u4fef\u51b2\u8fd4\u822astartSwoopReturnCountTime " + time);
        final long j = time * 1000;
        final long j2 = 1000;
        CountDownTimer countDownTimer = new CountDownTimer(j, j2) { // from class: com.ipotensic.kernel.model.KernelViewModel$startSwoopReturnCountTimer$$inlined$run$lambda$1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                MutableLiveData mutableLiveData;
                GeneralDialog generalDialog;
                Button button;
                MutableLiveData mutableLiveData2;
                mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
                mutableLiveData.setValue(Integer.valueOf((int) (j3 / 1000)));
                generalDialog = KernelViewModel.this.swoopReturnDialog;
                if (generalDialog == null || (button = generalDialog.confirmBtn) == null) {
                    return;
                }
                StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
                mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
                button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MutableLiveData mutableLiveData;
                GeneralDialog generalDialog;
                GeneralDialog generalDialog2;
                Button button;
                MutableLiveData mutableLiveData2;
                DDLog.e("\u4fef\u51b2\u8fd4\u822astartSwoopReturnCountTimer onFinish");
                mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
                mutableLiveData.setValue(0);
                generalDialog = KernelViewModel.this.swoopReturnDialog;
                if (generalDialog != null && (button = generalDialog.confirmBtn) != null) {
                    StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
                    mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
                    button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
                }
                if (!FlightConfig.isConnectFlight()) {
                    generalDialog2 = KernelViewModel.this.swoopReturnDialog;
                    if (generalDialog2 != null) {
                        generalDialog2.dismiss();
                    }
                    KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                }
                KernelViewModel.this.swoopReturnCountTimer = (CountDownTimer) null;
            }
        };
        kernelViewModel.swoopReturnCountTimer = countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void stopSwoopReturnCountTimer() {
        CountDownTimer countDownTimer = this.swoopReturnCountTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.swoopReturnCountTimer = (CountDownTimer) null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterSwoopReturn() {
        if (this.sendEnterSwoopReturnTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        kernelViewModel.startSendSwoopReturnTime = System.currentTimeMillis();
        CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$enterSwoopReturn$1$1
            @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
            public void run() {
                FlightRevData flightRevData = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
                FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData.isSwoopReturn()) {
                    KernelViewModel.this.stopSendEnterSwoopData();
                    return;
                }
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.ENTER_SWOOP_RETURN);
                DataManager.getInstance().sendGeneralData();
            }
        };
        kernelViewModel.sendEnterSwoopReturnTimer = cancelRunnable;
        if (cancelRunnable != null) {
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(kernelViewModel.sendEnterSwoopReturnTimer, 0L, 40L, TimeUnit.MILLISECONDS));
        }
        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$enterSwoopReturn$1$2
            @Override // java.lang.Runnable
            public final void run() {
                KernelViewModel.this.stopSendEnterSwoopData();
            }
        }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        DDLog.e("\u4fef\u51b2\u8fd4\u822a startSendEnterSwoopData");
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSendEnterSwoopData() {
        ScheduledFuture future;
        DDLog.e("\u4fef\u51b2\u8fd4\u822a stopSendEnterSwoopData");
        CancelRunnable cancelRunnable = this.sendEnterSwoopReturnTimer;
        if (cancelRunnable == null || (future = cancelRunnable.getFuture()) == null) {
            return;
        }
        future.cancel(true);
        this.sendEnterSwoopReturnTimer = (CancelRunnable) null;
    }

    public final void exitSwoopReturn() {
        DDLog.e("\u9000\u51fa\u4fef\u51b2\u8fd4\u822astartSendExitSwoopData");
        if (this.sendExitSwoopReturnTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        kernelViewModel.startExitSwoopReturnTime = System.currentTimeMillis();
        CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$exitSwoopReturn$1$1
            @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
            public void run() {
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.EXIT_SWOOP_RETURN);
                DataManager.getInstance().sendGeneralData();
            }
        };
        kernelViewModel.sendExitSwoopReturnTimer = cancelRunnable;
        if (cancelRunnable != null) {
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(kernelViewModel.sendExitSwoopReturnTimer, 0L, 40L, TimeUnit.MILLISECONDS));
        }
        Boolean.valueOf(PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$exitSwoopReturn$1$2
            @Override // java.lang.Runnable
            public final void run() {
                KernelViewModel.this.stopSendExitSwoopData();
            }
        }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSendExitSwoopData() {
        ScheduledFuture future;
        DDLog.e("\u4fef\u51b2\u8fd4\u822astopSendExitSwoopData");
        CancelRunnable cancelRunnable = this.sendExitSwoopReturnTimer;
        if (cancelRunnable == null || (future = cancelRunnable.getFuture()) == null) {
            return;
        }
        future.cancel(true);
        this.swoopReturnDialog = (GeneralDialog) null;
        this.sendExitSwoopReturnTimer = (CancelRunnable) null;
    }

    public final void showUnlockDialog(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (FlightConfig.isConnectFlight()) {
            if (this.unLockDialog == null) {
                this.unLockDialog = new GeneralDialog(context, true, context.getString(R.string.find_my_drone_fail_to_unlock_title), context.getString(R.string.find_my_drone_fail_to_unlock_tips), context.getString(R.string.i_get_it), (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.model.KernelViewModel$showUnlockDialog$1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public final void confirm() {
                    }
                });
            }
            GeneralDialog generalDialog = this.unLockDialog;
            if (generalDialog != null) {
                generalDialog.show();
            }
        }
    }

    public final void onConnect(boolean isConnect) {
        GeneralDialog generalDialog;
        if (isConnect || (generalDialog = this.unLockDialog) == null || !generalDialog.isShowing()) {
            return;
        }
        generalDialog.dismiss();
        this.unLockDialog = (GeneralDialog) null;
    }

    public final void sendSettings() {
        if (FlightConfig.isConnectFlight()) {
            FlightSendData flightSendData = FlightSendData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
            SendFlightSetData sendFlightSetData = flightSendData.getSendFlightSetData();
            Intrinsics.checkExpressionValueIsNotNull(sendFlightSetData, "FlightSendData.get().sendFlightSetData");
            if (sendFlightSetData.isSettingChanged()) {
                DataManager.getInstance().startSendSetting();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addNoFlyZoneData(Context context, MapVideoController controller) {
        this.noFlyZoneData.addAll(NoFlyZoneUtil.INSTANCE.parseNoFlyZoneJson(context));
        Gps gps = FlightConfig.GPS;
        Intrinsics.checkExpressionValueIsNotNull(gps, "FlightConfig.GPS");
        if (gps.getLat() != 0.0d) {
            Gps gps2 = FlightConfig.GPS;
            Intrinsics.checkExpressionValueIsNotNull(gps2, "FlightConfig.GPS");
            if (gps2.getLng() != 0.0d) {
                Gps gps3 = FlightConfig.GPS;
                Intrinsics.checkExpressionValueIsNotNull(gps3, "FlightConfig.GPS");
                double lat = gps3.getLat();
                Gps gps4 = FlightConfig.GPS;
                Intrinsics.checkExpressionValueIsNotNull(gps4, "FlightConfig.GPS");
                this.noFlyZoneBounds = controller.drawCircle(new CircleStyle(new CommonLatLng(lat, gps4.getLng()), Double.valueOf(500000.0d), Float.valueOf(0.0f), null, null, null));
            }
        }
    }

    public final void updateNoFlyZone(Context context, MapVideoController controller, boolean isAdd) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(controller, "controller");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new KernelViewModel$updateNoFlyZone$1(this, isAdd, context, controller, null), 2, null);
    }

    public final void removeNoFlyZone() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new KernelViewModel$removeNoFlyZone$1(this, null), 2, null);
    }

    public static /* synthetic */ void addDroneLongTip$default(KernelViewModel kernelViewModel, ErrorCode errorCode, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        kernelViewModel.addDroneLongTip(errorCode, str, i, z);
    }

    public final void addDroneLongTip(ErrorCode errorCode, String param, int index, boolean isNeedPrompt) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        Intrinsics.checkParameterIsNotNull(param, "param");
        DroneNoticeBean droneNoticeBean = new DroneNoticeBean(errorCode, param, 0L, null, isNeedPrompt, false, 0, 108, null);
        if (this.longTipList.contains(droneNoticeBean)) {
            return;
        }
        this.longTipList.add(index, droneNoticeBean);
        Collections.sort(this.longTipList, new SortUtils.TipLevelComparator());
        this.addLongTip.setValue(droneNoticeBean);
    }

    public final void removeDroneLongTip(ErrorCode errorCode) {
        Intrinsics.checkParameterIsNotNull(errorCode, "errorCode");
        DroneNoticeBean droneNoticeBean = new DroneNoticeBean(errorCode, null, 0L, null, false, false, 0, 126, null);
        if (this.longTipList.contains(droneNoticeBean)) {
            this.longTipList.remove(droneNoticeBean);
            this.removeLongTip.setValue(droneNoticeBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNewerModeData(SendFlightSetData data) {
        data.setNewerMode(true);
        data.setReturnHeight(30);
        data.setHeightLimit(30);
        data.setDistanceLimit(30);
        data.setSpeedMode(0);
    }

    public final void updateBeginnerMode() {
        Job launch$default;
        if (this.beginnerModeJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new KernelViewModel$updateBeginnerMode$1(this, null), 2, null);
            this.beginnerModeJob = launch$default;
        }
    }

    public final void resetPGCoverBeginnerMode() {
        Job job = this.beginnerModeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.beginnerModeJob = (Job) null;
    }

    public final boolean isSupportUom() {
        SPHelper sPHelper = SPHelper.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(sPHelper, "SPHelper.getInstance()");
        sPHelper.getFlightCurVersion();
        return PhoneConfig.isDownloadFromChinaMarket && UomHandler.INSTANCE.getInstance().isFlightTypeSupport();
    }
}