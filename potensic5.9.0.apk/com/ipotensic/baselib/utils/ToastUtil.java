package com.ipotensic.baselib.utils;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import com.ipotensic.baselib.C1819R;
import com.ipotensic.baselib.xtoast.XToast;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ToastUtil {
    private static final int TIME = 3000;
    private static final int TIME2 = 5000;
    private static ArrayList<XToast> toasts = new ArrayList<>();

    public static synchronized void showImageTop(final Activity activity, final String str, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_top).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void showImageTop1(final Activity activity, final String str, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_top1).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void showPositionBottom(final Activity activity, final String str, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_top).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setGravity(80).show());
                    }
                }
            });
        }
    }

    public static synchronized void showPositionTopTest(final Activity activity, final String str, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_top_test).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setGravity(48).show());
                    }
                }
            });
        }
    }

    public static synchronized void showImageTop(final Activity activity, final String str, final String str2, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_top2).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setText(C1819R.id.tv_message, str2).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void showImageLeft(final Activity activity, final String str, final String str2, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.6
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_left).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setText(C1819R.id.tv_message, str2).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void showImageLeft2(final Activity activity, final String str, final String str2, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.7
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast_image_left2).setAnimStyle(R.style.Animation.Activity).setImageDrawable(C1819R.id.img_icon, i).setText(C1819R.id.tv_code_title, str).setText(C1819R.id.tv_message, str2).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void toast(final Activity activity, final String str) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.8
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast).setAnimStyle(R.style.Animation.Activity).setText(C1819R.id.tv_code_title, str).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void toast(final Activity activity, final String str, final long j) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.9
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration((int) j).setView(C1819R.layout.view_toast).setAnimStyle(R.style.Animation.Activity).setText(C1819R.id.tv_code_title, str).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void toast(final Activity activity, final String str, final int i) {
        synchronized (ToastUtil.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.baselib.utils.ToastUtil.10
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ToastUtil.toasts) {
                        ToastUtil.clear();
                        ToastUtil.toasts.add(new XToast(activity).setDuration(3000).setView(C1819R.layout.view_toast).setAnimStyle(R.style.Animation.Activity).setText(C1819R.id.tv_code_title, str).setTextColor(C1819R.id.tv_code_title, i).setGravity(17).show());
                    }
                }
            });
        }
    }

    public static synchronized void clear() {
        synchronized (ToastUtil.class) {
            if (toasts.size() > 0) {
                Iterator<XToast> it = toasts.iterator();
                while (it.hasNext()) {
                    XToast next = it.next();
                    if (next.isShow()) {
                        next.cancel();
                    }
                    it.remove();
                }
            }
        }
    }
}