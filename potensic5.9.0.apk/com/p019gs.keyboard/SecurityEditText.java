package com.p019gs.keyboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class SecurityEditText extends AppCompatEditText {
    private KeyboardDialog dialog;
    private KeyboardAttribute keyboardAttribute;

    public SecurityEditText(Context context) {
        this(context, null);
    }

    public SecurityEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1802R.attr.editTextStyle);
    }

    public SecurityEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1802R.styleable.SecurityEditText);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C1802R.styleable.SecurityEditText_chooserSelectedColor);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(C1802R.styleable.SecurityEditText_chooserUnselectedColor);
        Drawable drawable = obtainStyledAttributes.getDrawable(C1802R.styleable.SecurityEditText_chooserBackground);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C1802R.styleable.SecurityEditText_keyboardBackground);
        boolean z = obtainStyledAttributes.getBoolean(C1802R.styleable.SecurityEditText_keyPreview, true);
        obtainStyledAttributes.recycle();
        this.keyboardAttribute = new KeyboardAttribute(colorStateList, colorStateList2, drawable, drawable2, z);
        initialize();
    }

    private void initialize() {
        setClickable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            setShowSoftInputOnFocus(false);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(this, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            hideSystemKeyboard();
            showSoftInput();
        } else {
            hideSoftKeyboard();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (!isFocused()) {
            return false;
        }
        hideSystemKeyboard();
        showSoftInput();
        return false;
    }

    private void hideSystemKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void showSoftInput() {
        KeyboardDialog keyboardDialog = this.dialog;
        if (keyboardDialog == null) {
            this.dialog = KeyboardDialog.show(getContext(), this);
        } else {
            keyboardDialog.show();
        }
    }

    private void hideSoftKeyboard() {
        KeyboardDialog keyboardDialog = this.dialog;
        if (keyboardDialog != null) {
            keyboardDialog.dismiss();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocused()) {
            hideSystemKeyboard();
            showSoftInput();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isFocused()) {
            hideSoftKeyboard();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z && hasFocus()) {
            post(new Runnable() { // from class: com.gs.keyboard.-$$Lambda$SecurityEditText$Vx5Fb32VMIFLQWGjtbWKHjXMF60
                @Override // java.lang.Runnable
                public final void run() {
                    SecurityEditText.this.lambda$onWindowFocusChanged$0$SecurityEditText();
                }
            });
        }
    }

    public /* synthetic */ void lambda$onWindowFocusChanged$0$SecurityEditText() {
        hideSystemKeyboard();
        showSoftInput();
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            KeyboardDialog keyboardDialog = this.dialog;
            if (keyboardDialog == null || !keyboardDialog.isShowing()) {
                return true;
            }
            this.dialog.dismiss();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public KeyboardAttribute getKeyboardAttribute() {
        return this.keyboardAttribute;
    }
}