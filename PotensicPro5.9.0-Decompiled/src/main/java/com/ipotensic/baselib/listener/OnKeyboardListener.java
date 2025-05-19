package com.ipotensic.baselib.listener;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class OnKeyboardListener {
    private final int MSG_TIME;
    private final int MSG_WHAT_1;
    private final int MSG_WHAT_2;
    private final Handler handler;
    private final Map<EditText, OnKeyboardStatusChangeListener> map;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private Rect rect;
    private Window window;
    private int windowBottom = -1;
    private int keyboardHeight = 0;
    private int keyboardDefaultHeight = 300;

    public interface OnKeyboardStatusChangeListener {
        void onKeyboardDismiss();

        void onKeyboardShow(int i, int i2);
    }

    public OnKeyboardListener(EditText editText, final Window window, Lifecycle lifecycle, OnKeyboardStatusChangeListener onKeyboardStatusChangeListener) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.map = concurrentHashMap;
        this.MSG_WHAT_1 = 1;
        this.MSG_WHAT_2 = 2;
        this.MSG_TIME = 100;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.baselib.listener.OnKeyboardListener.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    Iterator it = OnKeyboardListener.this.map.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        EditText editText2 = (EditText) it.next();
                        if (editText2.isFocused()) {
                            ((OnKeyboardStatusChangeListener) Objects.requireNonNull(OnKeyboardListener.this.map.get(editText2))).onKeyboardDismiss();
                            break;
                        }
                    }
                    removeMessages(2);
                    return;
                }
                int i2 = message.arg1;
                int i3 = message.arg2;
                Iterator it2 = OnKeyboardListener.this.map.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    EditText editText3 = (EditText) it2.next();
                    if (editText3.isFocused()) {
                        ((OnKeyboardStatusChangeListener) Objects.requireNonNull(OnKeyboardListener.this.map.get(editText3))).onKeyboardShow(i2, i3);
                        break;
                    }
                }
                removeMessages(1);
            }
        };
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ipotensic.baselib.listener.OnKeyboardListener.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                OnKeyboardListener.this.window.getDecorView().getWindowVisibleDisplayFrame(OnKeyboardListener.this.rect);
                int i = OnKeyboardListener.this.rect.bottom;
                OnKeyboardListener onKeyboardListener = OnKeyboardListener.this;
                onKeyboardListener.keyboardHeight = onKeyboardListener.windowBottom - i;
                if (OnKeyboardListener.this.windowBottom != -1 && OnKeyboardListener.this.windowBottom != i) {
                    if (i < OnKeyboardListener.this.windowBottom) {
                        if (OnKeyboardListener.this.keyboardDefaultHeight > OnKeyboardListener.this.keyboardHeight) {
                            OnKeyboardListener.this.handler.removeMessages(1);
                            OnKeyboardListener.this.handler.removeMessages(2);
                            Message message = new Message();
                            message.what = 1;
                            message.arg1 = OnKeyboardListener.this.keyboardHeight;
                            message.arg2 = 1;
                            OnKeyboardListener.this.handler.sendMessage(message);
                        } else {
                            OnKeyboardListener.this.handler.removeMessages(1);
                            OnKeyboardListener.this.handler.removeMessages(2);
                            Message message2 = new Message();
                            message2.what = 1;
                            message2.arg1 = OnKeyboardListener.this.keyboardHeight;
                            message2.arg2 = 0;
                            OnKeyboardListener.this.handler.sendMessage(message2);
                        }
                    } else {
                        OnKeyboardListener.this.handler.removeMessages(2);
                        OnKeyboardListener.this.handler.sendEmptyMessageDelayed(2, 100L);
                    }
                }
                OnKeyboardListener.this.windowBottom = i;
            }
        };
        this.onGlobalLayoutListener = onGlobalLayoutListener;
        this.window = window;
        this.rect = new Rect();
        if (!concurrentHashMap.containsKey(editText)) {
            concurrentHashMap.put(editText, onKeyboardStatusChangeListener);
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.baselib.listener.OnKeyboardListener.2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(OnKeyboardListener.this.onGlobalLayoutListener);
                }
            }
        });
    }
}
