package com.ipotensic.potensicpro.utils;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes2.dex */
public class KeyboardHelper {
    private Activity activity;
    private View content;
    private OnKeyboardStatusChangeListener onKeyboardStatusChangeListener;
    private Rect rect;
    private int screenHeight;
    private int windowBottom = -1;
    private int keyboardHeight = 0;
    private int blankHeight = 0;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ipotensic.potensicpro.utils.KeyboardHelper.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (KeyboardHelper.this.rect == null) {
                KeyboardHelper.this.rect = new Rect();
            }
            KeyboardHelper.this.activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(KeyboardHelper.this.rect);
            Log.d("KeyboardHelper", "onGlobalLayout: " + KeyboardHelper.this.rect + ", " + KeyboardHelper.this.windowBottom);
            Log.d("KeyboardHelper", "newBottom: " + KeyboardHelper.this.rect.bottom);
            int i = KeyboardHelper.this.rect.bottom;
            KeyboardHelper keyboardHelper = KeyboardHelper.this;
            keyboardHelper.keyboardHeight = keyboardHelper.windowBottom - i;
            Log.d("KeyboardHelper", "keyboardHeight: " + KeyboardHelper.this.keyboardHeight);
            if (KeyboardHelper.this.windowBottom != -1 && KeyboardHelper.this.windowBottom != i) {
                if (i < KeyboardHelper.this.windowBottom) {
                    if (KeyboardHelper.this.onKeyboardStatusChangeListener != null) {
                        KeyboardHelper.this.onKeyboardStatusChangeListener.onKeyboardPop(KeyboardHelper.this.keyboardHeight);
                    }
                } else if (KeyboardHelper.this.onKeyboardStatusChangeListener != null && Math.abs(KeyboardHelper.this.keyboardHeight) > KeyboardHelper.this.screenHeight / 4) {
                    KeyboardHelper.this.onKeyboardStatusChangeListener.onKeyboardClose(KeyboardHelper.this.keyboardHeight);
                }
            }
            KeyboardHelper.this.windowBottom = i;
        }
    };

    public interface OnKeyboardStatusChangeListener {
        void onKeyboardClose(int i);

        void onKeyboardPop(int i);
    }

    public KeyboardHelper(Activity activity) {
        this.activity = activity;
        activity.getWindow().setSoftInputMode(21);
        if (activity.getRequestedOrientation() != 1) {
            activity.setRequestedOrientation(1);
        }
        this.screenHeight = activity.getResources().getDisplayMetrics().heightPixels;
    }

    public void onCreate() {
        View findViewById = this.activity.findViewById(R.id.content);
        this.content = findViewById;
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void onDestroy() {
        this.content = this.activity.findViewById(R.id.content);
        if (Build.VERSION.SDK_INT < 16) {
            this.content.getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            this.content.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    public void setOnKeyboardStatusChangeListener(OnKeyboardStatusChangeListener onKeyboardStatusChangeListener) {
        this.onKeyboardStatusChangeListener = onKeyboardStatusChangeListener;
    }
}