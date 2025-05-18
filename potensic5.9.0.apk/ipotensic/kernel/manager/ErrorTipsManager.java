package com.ipotensic.kernel.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.AnimationUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorTipsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010'\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u001bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006+"}, d2 = {"Lcom/ipotensic/kernel/manager/ErrorTipsManager;", "", "mContext", "Landroid/content/Context;", "leftErrorTipView", "Landroid/widget/LinearLayout;", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "getLeftErrorTipView", "()Landroid/widget/LinearLayout;", "setLeftErrorTipView", "(Landroid/widget/LinearLayout;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "readyErrorList", "Ljava/util/ArrayDeque;", "", "getReadyErrorList", "()Ljava/util/ArrayDeque;", "runningErrorList", "getRunningErrorList", "enqueue", "", NotificationCompat.CATEGORY_MESSAGE, "text", "", "finish", "getChildView", "Landroid/view/View;", "context", TtmlNode.ATTR_ID, "isAdded", "", "isContain", "promoteAndExecute", "release", "stop", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ErrorTipsManager {
    public static final long DISMISS_TIME = 5000;
    public static final int MAX_SHOWING = 3;
    public static final int MSG_SHOW = -1;
    private final Handler handler;
    private LinearLayout leftErrorTipView;
    private Context mContext;
    private final ArrayDeque<Integer> readyErrorList;
    private final ArrayDeque<Integer> runningErrorList;

    public ErrorTipsManager(Context mContext, LinearLayout leftErrorTipView) {
        Intrinsics.checkParameterIsNotNull(mContext, "mContext");
        Intrinsics.checkParameterIsNotNull(leftErrorTipView, "leftErrorTipView");
        this.mContext = mContext;
        this.leftErrorTipView = leftErrorTipView;
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.ipotensic.kernel.manager.ErrorTipsManager$handler$1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message msg) {
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                if (msg.what == -1) {
                    ErrorTipsManager errorTipsManager = ErrorTipsManager.this;
                    View childView = errorTipsManager.getChildView(errorTipsManager.getMContext(), msg.arg1, msg.obj.toString());
                    ErrorTipsManager.this.getLeftErrorTipView().addView(childView);
                    AnimationUtil.transInLeft(childView);
                    return true;
                }
                ErrorTipsManager.this.finish(msg.what);
                return true;
            }
        });
        this.readyErrorList = new ArrayDeque<>();
        this.runningErrorList = new ArrayDeque<>();
    }

    public final LinearLayout getLeftErrorTipView() {
        return this.leftErrorTipView;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setLeftErrorTipView(LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.leftErrorTipView = linearLayout;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final ArrayDeque<Integer> getReadyErrorList() {
        return this.readyErrorList;
    }

    public final ArrayDeque<Integer> getRunningErrorList() {
        return this.runningErrorList;
    }

    public final View getChildView(Context context, int id, String text) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(text, "text");
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_layout_left_error_tip_item, (ViewGroup) this.leftErrorTipView, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont\u2026 leftErrorTipView, false)");
        TextView tvMsg = (TextView) inflate.findViewById(R.id.tv_tip_msg);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tip_title);
        tvMsg.setTypeface(PhoneConfig.typeface);
        textView.setTypeface(PhoneConfig.typeface);
        String str = text;
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkExpressionValueIsNotNull(tvMsg, "tvMsg");
            tvMsg.setText(str);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(tvMsg, "tvMsg");
            tvMsg.setText(context.getString(id));
        }
        inflate.setTag(Integer.valueOf(id));
        return inflate;
    }

    public final void enqueue(int msg, String text) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        synchronized (this) {
            this.readyErrorList.add(Integer.valueOf(msg));
        }
        promoteAndExecute(text);
    }

    private final boolean promoteAndExecute(String text) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Integer> it = this.readyErrorList.iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "readyErrorList.iterator()");
            loop0: while (true) {
                z = false;
                while (it.hasNext()) {
                    Integer msg = it.next();
                    if (this.runningErrorList.size() >= 3) {
                        break loop0;
                    }
                    it.remove();
                    if (this.runningErrorList.contains(msg)) {
                        Intrinsics.checkExpressionValueIsNotNull(msg, "msg");
                        arrayList.add(msg);
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(msg, "msg");
                        arrayList.add(msg);
                        this.runningErrorList.add(msg);
                    }
                    if (this.runningErrorList.size() > 0) {
                        z = true;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int intValue = ((Number) it2.next()).intValue();
            if (isAdded(intValue)) {
                this.handler.removeMessages(intValue);
            } else {
                Message obtain = Message.obtain();
                obtain.what = -1;
                obtain.arg1 = intValue;
                obtain.obj = text;
                this.handler.sendMessage(obtain);
            }
            this.handler.sendEmptyMessageDelayed(intValue, 5000L);
        }
        return z;
    }

    public final boolean isContain(int msg) {
        return this.readyErrorList.contains(Integer.valueOf(msg)) || this.runningErrorList.contains(Integer.valueOf(msg));
    }

    public final boolean isAdded(int msg) {
        int childCount = this.leftErrorTipView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.leftErrorTipView.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(child, "child");
            if (Intrinsics.areEqual(child.getTag(), Integer.valueOf(msg))) {
                return true;
            }
        }
        return false;
    }

    public final void finish(int msg) {
        LinearLayout linearLayout;
        synchronized (this) {
            try {
                LinearLayout linearLayout2 = this.leftErrorTipView;
                if ((linearLayout2 != null ? Integer.valueOf(linearLayout2.getChildCount()) : null).intValue() > 0 && (linearLayout = this.leftErrorTipView) != null) {
                    linearLayout.removeViewAt(0);
                }
                Boolean.valueOf(this.runningErrorList.remove(Integer.valueOf(msg)));
            } catch (Exception e) {
                DDLog.e("\u79fb\u9664view\u62a5\u9519:" + e.getMessage());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void stop() {
        synchronized (this) {
            this.readyErrorList.clear();
            this.runningErrorList.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.leftErrorTipView.removeAllViews();
        release();
    }

    public final void release() {
        this.handler.removeCallbacksAndMessages(null);
    }
}