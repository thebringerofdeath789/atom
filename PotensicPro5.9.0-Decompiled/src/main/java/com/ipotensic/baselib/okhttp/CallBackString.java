package com.ipotensic.baselib.okhttp;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.configs.PhoneConfig;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: classes2.dex */
public abstract class CallBackString<T> {
    public static Handler mMainHandler = new Handler(Looper.getMainLooper());

    public abstract void onFailure(int i, Exception exc);

    public abstract T onParseResponse(int i, String str) throws Exception;

    public abstract void onResponse(int i, T t);

    public void onError(final int i, final Exception exc) {
        mMainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.okhttp.CallBackString.1
            @Override // java.lang.Runnable
            public void run() {
                CallBackString.this.onFailure(i, exc);
            }
        });
    }

    public void onSuccess(final int i, Call call, Response response) {
        final Resources resources = PhoneConfig.applicationContext.getResources();
        try {
            final String string = response.body().string();
            if (string == null) {
                onError(i, new Exception(resources.getString(R.string.request_error)));
                return;
            }
            DDLog.w("请求结果 requestcode : " + i + ", result : " + string);
            final T onParseResponse = onParseResponse(i, string);
            mMainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.okhttp.CallBackString.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Object obj = onParseResponse;
                    if (obj == null) {
                        CallBackString.this.onFailure(i, new Exception(resources.getString(R.string.request_error)));
                        return;
                    }
                    try {
                        CallBackString.this.onResponse(i, obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        DDLog.e("解析出错   requstCode:" + i + " , " + string + " , " + e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            onError(i, e);
            DDLog.e("请求错误:" + e.getMessage());
        }
    }
}
