package com.ipotensic.baselib.okhttp;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.configs.PhoneConfig;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: classes2.dex */
public abstract class CallBackUtil<T> {
    public static Handler mMainHandler = new Handler(Looper.getMainLooper());

    public abstract void onFailure(int i, Call call, Exception exc);

    public abstract T onParseResponse(int i, Call call, Response response);

    public abstract void onResponse(int i, T t);

    public void onUploadProgress(float f, long j) {
    }

    public void onError(final int i, final Call call, final Exception exc) {
        mMainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.okhttp.CallBackUtil.1
            @Override // java.lang.Runnable
            public void run() {
                CallBackUtil.this.onFailure(i, call, exc);
            }
        });
    }

    public void onSuccess(final int i, final Call call, Response response) {
        final Resources resources = PhoneConfig.applicationContext.getResources();
        final T onParseResponse = onParseResponse(i, call, response);
        mMainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.okhttp.CallBackUtil.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj = onParseResponse;
                if (obj == null) {
                    CallBackUtil.this.onFailure(i, call, new Exception(resources.getString(R.string.request_error)));
                } else {
                    CallBackUtil.this.onResponse(i, obj);
                }
            }
        });
    }
}