package com.ipotensic.baselib.listener;

import com.ipotensic.baselib.enums.NetworkType;

/* loaded from: classes2.dex */
public interface OnNetworkChangeListener {
    void onCellularStateChanged(boolean z);

    void onNetworkChanged(NetworkType networkType);
}