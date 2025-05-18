package com.ipotensic.kernel.maps.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.maps.bean.NoFlyZoneModel;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevVersionData;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: NoFlyZoneUtil.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m2338d2 = {"Lcom/ipotensic/kernel/maps/utils/NoFlyZoneUtil;", "", "()V", "FLAVOR", "", "NO_FLY_ZONE_BOUNDS_RADIUS", "", "NO_FLY_ZONE_DATA_DOWNLOAD_URL", "TAG", "isShowUpdateNoFlyZoneTip", "", OutputKeys.VERSION, "parseNoFlyZoneJson", "Ljava/util/ArrayList;", "Lcom/ipotensic/kernel/maps/bean/NoFlyZoneModel;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "withLevelFillColor", "", "level", "height", "", "(Landroid/content/Context;Ljava/lang/Integer;F)I", "withLevelStrokeColor", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class NoFlyZoneUtil {
    public static final String FLAVOR = "gaode";
    public static final NoFlyZoneUtil INSTANCE = new NoFlyZoneUtil();
    public static final double NO_FLY_ZONE_BOUNDS_RADIUS = 500000.0d;
    public static final String NO_FLY_ZONE_DATA_DOWNLOAD_URL = "https://cn.potensic.com/downloads.html";
    private static final String TAG = "NoFlyZoneUtil";

    private NoFlyZoneUtil() {
    }

    public final ArrayList<NoFlyZoneModel> parseNoFlyZoneJson(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            InputStream open = context.getAssets().open("CN.json");
            Intrinsics.checkExpressionValueIsNotNull(open, "context.assets.open(\"CN.json\")");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            Object fromJson = new Gson().fromJson(new String(bArr, Charsets.UTF_8), new TypeToken<ArrayList<NoFlyZoneModel>>() { // from class: com.ipotensic.kernel.maps.utils.NoFlyZoneUtil$parseNoFlyZoneJson$1
            }.getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(json, ob…FlyZoneModel>>() {}.type)");
            return (ArrayList) fromJson;
        } catch (Exception e) {
            DDLog.m1685e(TAG, "parseNoFlyZoneJson exception is " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public int withLevelStrokeColor(Context context, Integer level, float height) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (level != null && level.intValue() == 0) {
            return ContextCompat.getColor(context, C1965R.color.color_E6FF771E);
        }
        if (level != null && level.intValue() == 1) {
            return ContextCompat.getColor(context, C1965R.color.color_E60068D9);
        }
        if (level != null && level.intValue() == 2) {
            if (height > 0.0f) {
                return ContextCompat.getColor(context, C1965R.color.color_E6E4AF00);
            }
            return ContextCompat.getColor(context, C1965R.color.no_fly_stroke_color);
        }
        if (level != null && level.intValue() == 3) {
            return ContextCompat.getColor(context, C1965R.color.color_E6FF0312);
        }
        return ContextCompat.getColor(context, C1965R.color.no_fly_stroke_color);
    }

    public final int withLevelFillColor(Context context, Integer level, float height) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (level != null && level.intValue() == 0) {
            return ContextCompat.getColor(context, C1965R.color.color_29FF771E);
        }
        if (level != null && level.intValue() == 1) {
            return ContextCompat.getColor(context, C1965R.color.color_290068D9);
        }
        if (level != null && level.intValue() == 2) {
            if (height > 0.0f) {
                return ContextCompat.getColor(context, C1965R.color.color_29E4AF00);
            }
            return ContextCompat.getColor(context, C1965R.color.no_fly_fill_color);
        }
        if (level != null && level.intValue() == 3) {
            return ContextCompat.getColor(context, C1965R.color.color_29FF0312);
        }
        return ContextCompat.getColor(context, C1965R.color.no_fly_fill_color);
    }

    public final boolean isShowUpdateNoFlyZoneTip(String version) {
        Intrinsics.checkParameterIsNotNull(version, "version");
        if ((FlightConfig.isBigPackageAtomSEV3() && CommonUtil.hasNewVersion(version, "1.5.5")) || (FlightConfig.isBigPackageAtomV2() && CommonUtil.hasNewVersion(version, "2.0.0"))) {
            SPHelper sPHelper = SPHelper.getInstance();
            FlightRevData flightRevData = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
            FlightRevVersionData flightRevVersionData = flightRevData.getFlightRevVersionData();
            Intrinsics.checkExpressionValueIsNotNull(flightRevVersionData, "FlightRevData.get().flightRevVersionData");
            if (sPHelper.isShowUpdateNoFlyZoneData(flightRevVersionData.getFlightSN()) && LanguageHelper.getPhoneLanguageType() == 1) {
                return true;
            }
        }
        return false;
    }
}