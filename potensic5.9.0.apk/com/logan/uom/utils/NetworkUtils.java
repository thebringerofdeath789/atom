package com.logan.uom.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUtils.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m2338d2 = {"Lcom/logan/uom/utils/NetworkUtils;", "", "()V", "isNetworkConnected", "", "context", "Landroid/content/Context;", "UomTask_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();

    private NetworkUtils() {
    }

    public final boolean isNetworkConnected(Context context) {
        Object systemService;
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            systemService = context.getSystemService("connectivity");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m2647constructorimpl(ResultKt.createFailure(th));
        }
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            Result.m2647constructorimpl(Unit.INSTANCE);
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}