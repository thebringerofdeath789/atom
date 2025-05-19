package com.mapbox.mapboxsdk.net;

import com.mapbox.mapboxsdk.LibraryLoader;

/* loaded from: classes3.dex */
class NativeConnectivityListener implements ConnectivityListener {
    private boolean invalidated;
    private long nativePtr;

    protected native void finalize() throws Throwable;

    protected native void initialize();

    protected native void nativeOnConnectivityStateChanged(boolean z);

    static {
        LibraryLoader.load();
    }

    NativeConnectivityListener(long j) {
        this.nativePtr = j;
    }

    NativeConnectivityListener() {
        initialize();
    }

    @Override // com.mapbox.mapboxsdk.net.ConnectivityListener
    public void onNetworkStateChanged(boolean z) {
        nativeOnConnectivityStateChanged(z);
    }
}
