package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.listener.OnKeyboardListener;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class CursorStringEditText extends AppCompatEditText {
    private float defaultValue;
    private OnInputFinishListener inputFinishListener;
    private float max;
    private float min;
    private int[] specials;

    public interface OnInputFinishListener {
        void onResult(View view, String str);
    }

    public CursorStringEditText(Context context) {
        super(context);
    }

    public CursorStringEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CursorStringEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInputFinishListener(final OnInputFinishListener onInputFinishListener) {
        this.inputFinishListener = onInputFinishListener;
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.ipotensic.kernel.view.-$$Lambda$CursorStringEditText$hcEzkFb7xNGZ4JvVnPz7EDYjilY
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CursorStringEditText.this.lambda$setInputFinishListener$0$CursorStringEditText(onInputFinishListener, textView, i, keyEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$setInputFinishListener$0$CursorStringEditText(OnInputFinishListener onInputFinishListener, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 0) {
            return false;
        }
        if (onInputFinishListener != null) {
            onInputFinishListener.onResult(this, getCurValue());
        }
        hideSystemUI();
        return false;
    }

    public String getCurValue() {
        try {
            String obj = getText().toString();
            if (!TextUtils.isEmpty(obj) && !obj.equals("-") && !obj.equals("+") && !obj.equals(".") && !obj.equals("-.") && !obj.equals("+.")) {
                if (obj.length() > 1 && obj.endsWith(".")) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                float parseFloat = Float.parseFloat(obj);
                float f = this.max;
                if (parseFloat > f) {
                    return String.valueOf(f);
                }
                float f2 = this.min;
                if (parseFloat < f2) {
                    return String.valueOf(f2);
                }
                return String.valueOf(parseFloat);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSystemUI() {
        if (getContext() instanceof FragmentActivity) {
            ((FragmentActivity) getContext()).getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void setKeyboardListener(FragmentActivity fragmentActivity, final View view) {
        new OnKeyboardListener(this, fragmentActivity.getWindow(), fragmentActivity.getLifecycle(), new OnKeyboardListener.OnKeyboardStatusChangeListener() { // from class: com.ipotensic.kernel.view.CursorStringEditText.1
            @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
            public void onKeyboardShow(int i, int i2) {
                if (i2 == 0) {
                    int[] iArr = new int[2];
                    CursorStringEditText.this.getLocationInWindow(iArr);
                    int i3 = iArr[1];
                    int height = (view.getHeight() - i) - CursorStringEditText.this.getHeight();
                    if (height > 0) {
                        float f = -(i3 - height);
                        if (f < 0.0f) {
                            view.setTranslationY(f);
                        }
                    }
                }
            }

            @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
            public void onKeyboardDismiss() {
                String obj;
                CursorStringEditText.this.clearFocus();
                try {
                    obj = CursorStringEditText.this.getText().toString();
                    if (obj.equals("") && CursorStringEditText.this.inputFinishListener != null) {
                        CursorStringEditText.this.inputFinishListener.onResult(CursorStringEditText.this, "");
                    }
                } catch (Exception e) {
                    DDLog.m1684e("获取输入失败 ：" + e);
                }
                if (!obj.equals("-") && !obj.equals("+") && !obj.equals(".") && !obj.equals("-.") && !obj.equals("+.")) {
                    if (obj.length() > 1 && obj.endsWith(".")) {
                        obj = obj.substring(0, obj.length() - 1);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        if (CursorStringEditText.this.inputFinishListener != null) {
                            CursorStringEditText.this.inputFinishListener.onResult(CursorStringEditText.this, null);
                        }
                    } else {
                        float parseFloat = Float.parseFloat(obj);
                        if (CursorStringEditText.this.min != -1.0f && CursorStringEditText.this.max != -1.0f) {
                            try {
                            } catch (NumberFormatException e2) {
                                DDLog.m1684e("输出出错:" + e2);
                            }
                            if (CursorStringEditText.this.isSpecial(parseFloat)) {
                                return;
                            }
                            if (parseFloat > CursorStringEditText.this.max) {
                                float unused = CursorStringEditText.this.max;
                                CursorStringEditText.this.setText(CursorStringEditText.this.max + "");
                            } else if (parseFloat < CursorStringEditText.this.min) {
                                float unused2 = CursorStringEditText.this.min;
                                CursorStringEditText.this.setText(CursorStringEditText.this.min + "");
                            }
                            if (CursorStringEditText.this.inputFinishListener != null) {
                                CursorStringEditText.this.inputFinishListener.onResult(CursorStringEditText.this, obj);
                            }
                        }
                    }
                    view.setTranslationY(0.0f);
                    CursorStringEditText.this.hideSystemUI();
                    return;
                }
                if (CursorStringEditText.this.inputFinishListener != null) {
                    CursorStringEditText.this.inputFinishListener.onResult(CursorStringEditText.this, null);
                }
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (i == i2) {
            setSelection(getText().length());
        }
    }

    public void setInputEnable(boolean z) {
        setFocusable(z);
        setFocusableInTouchMode(z);
        if (z) {
            setBackgroundResource(C1965R.mipmap.img_bg_white_input_stroke);
        } else {
            setBackgroundResource(C1965R.mipmap.img_bg_gray_input_stroke);
        }
    }

    public void setLimit(float f, float f2, float f3) {
        setInputType(12290);
        this.max = f;
        this.defaultValue = f2;
        this.min = f3;
        setTextWatcher();
    }

    public float getMax() {
        return this.max;
    }

    public float getMin() {
        return this.min;
    }

    public void setSpecial(int... iArr) {
        this.specials = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSpecial(float f) {
        int[] iArr = this.specials;
        if (iArr != null) {
            for (int i : iArr) {
                if (f == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    private void setTextWatcher() {
        addTextChangedListener(new TextWatcher() { // from class: com.ipotensic.kernel.view.CursorStringEditText.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    String obj = CursorStringEditText.this.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        return;
                    }
                    if (obj.length() > 1 && obj.endsWith(".")) {
                        obj = obj.substring(0, obj.length() - 2);
                    }
                    if (TextUtils.isEmpty(obj)) {
                        return;
                    }
                    float parseFloat = Float.parseFloat(obj);
                    if (CursorStringEditText.this.min == -1.0f || CursorStringEditText.this.max == -1.0f) {
                        return;
                    }
                    try {
                        if (CursorStringEditText.this.isSpecial(parseFloat)) {
                            return;
                        }
                        if (parseFloat > CursorStringEditText.this.max) {
                            CursorStringEditText.this.setText(CursorStringEditText.this.max + "");
                        }
                        if (parseFloat < CursorStringEditText.this.min) {
                            CursorStringEditText.this.setText(CursorStringEditText.this.min + "");
                        }
                    } catch (NumberFormatException e) {
                        DDLog.m1684e("输出出错:" + e);
                    }
                } catch (Exception e2) {
                    DDLog.m1684e("onTextChanged输出出错:" + e2);
                }
            }
        });
    }
}