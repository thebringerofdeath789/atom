package com.ipotensic.mediagallery;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/* loaded from: classes2.dex */
public class ToastUtil {
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static Toast sToast;

    public static void showToast(final Context context, final String str) {
        if (sToast == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                initToast(context, str);
            } else {
                handler.post(new Runnable() { // from class: com.ipotensic.mediagallery.ToastUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastUtil.initToast(context, str);
                    }
                });
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            sToast.setText(str);
            sToast.show();
        } else {
            handler.post(new Runnable() { // from class: com.ipotensic.mediagallery.ToastUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtil.sToast.setText(str);
                    ToastUtil.sToast.show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initToast(Context context, String str) {
        Toast makeText = Toast.makeText(context.getApplicationContext(), str, 0);
        sToast = makeText;
        makeText.setText(str);
    }
}
