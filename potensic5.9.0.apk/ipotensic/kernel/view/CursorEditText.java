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
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CursorEditText;

/* loaded from: classes2.dex */
public class CursorEditText extends AppCompatEditText {
    private int defaultValue;
    private OnInputFinishListener inputFinishListener;
    private boolean isNoLimit;
    private int max;
    private int min;
    private int[] specials;

    public interface OnInputFinishListener {
        void onResult(View view, int i);
    }

    public CursorEditText(Context context) {
        super(context);
    }

    public CursorEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CursorEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInputFinishListener(OnInputFinishListener onInputFinishListener) {
        this.inputFinishListener = onInputFinishListener;
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.ipotensic.kernel.view.-$$Lambda$CursorEditText$sEwB17HdRczI3JRBcfvL2-OqVr4
            public final /* synthetic */ CursorEditText.OnInputFinishListener f$1;

            public /* synthetic */ $$Lambda$CursorEditText$sEwB17HdRczI3JRBcfvL2OqVr4(CursorEditText.OnInputFinishListener onInputFinishListener2) {
                r2 = onInputFinishListener2;
            }

            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return CursorEditText.this.lambda$setInputFinishListener$0$CursorEditText(r2, textView, i, keyEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$setInputFinishListener$0$CursorEditText(OnInputFinishListener onInputFinishListener, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 0) {
            return false;
        }
        if (onInputFinishListener != null) {
            onInputFinishListener.onResult(this, getCurValue());
        }
        hideSystemUI();
        return false;
    }

    public void hideSystemUI() {
        if (getContext() instanceof FragmentActivity) {
            ((FragmentActivity) getContext()).getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void setKeyboardListener(FragmentActivity fragmentActivity, View view) {
        new OnKeyboardListener(this, fragmentActivity.getWindow(), fragmentActivity.getLifecycle(), new OnKeyboardListener.OnKeyboardStatusChangeListener() { // from class: com.ipotensic.kernel.view.CursorEditText.1
            final /* synthetic */ View val$rootView;

            AnonymousClass1(View view2) {
                r2 = view2;
            }

            @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
            public void onKeyboardShow(int i, int i2) {
                if (i2 == 0) {
                    int[] iArr = new int[2];
                    CursorEditText.this.getLocationInWindow(iArr);
                    int i3 = iArr[1];
                    int height = (r2.getHeight() - i) - CursorEditText.this.getHeight();
                    if (height > 0) {
                        float f = -(i3 - height);
                        if (f < 0.0f) {
                            r2.setTranslationY(f);
                        }
                    }
                }
            }

            @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
            public void onKeyboardDismiss() {
                CursorEditText.this.clearFocus();
                try {
                    if (TextUtils.isEmpty(CursorEditText.this.getText().toString())) {
                        CursorEditText.this.setText(CursorEditText.this.min + "");
                        if (CursorEditText.this.inputFinishListener != null) {
                            OnInputFinishListener onInputFinishListener = CursorEditText.this.inputFinishListener;
                            CursorEditText cursorEditText = CursorEditText.this;
                            onInputFinishListener.onResult(cursorEditText, cursorEditText.min);
                        }
                    } else {
                        int parseInt = Integer.parseInt(CursorEditText.this.getText().toString());
                        if (CursorEditText.this.min != -1 && CursorEditText.this.max != -1) {
                            try {
                                if (CursorEditText.this.isSpecial(parseInt)) {
                                    return;
                                }
                                if (parseInt > CursorEditText.this.max) {
                                    parseInt = CursorEditText.this.max;
                                    CursorEditText.this.setText(CursorEditText.this.max + "");
                                } else if (parseInt < CursorEditText.this.min) {
                                    parseInt = CursorEditText.this.min;
                                    CursorEditText.this.setText(CursorEditText.this.min + "");
                                }
                            } catch (NumberFormatException e) {
                                DDLog.e("\u8f93\u51fa\u51fa\u9519:" + e);
                            }
                        }
                        if (CursorEditText.this.inputFinishListener != null) {
                            CursorEditText.this.inputFinishListener.onResult(CursorEditText.this, parseInt);
                        }
                    }
                } catch (Exception e2) {
                    DDLog.e("\u83b7\u53d6\u8f93\u5165\u5931\u8d25 \uff1a" + e2);
                }
                r2.setTranslationY(0.0f);
                CursorEditText.this.hideSystemUI();
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.view.CursorEditText$1 */
    class AnonymousClass1 implements OnKeyboardListener.OnKeyboardStatusChangeListener {
        final /* synthetic */ View val$rootView;

        AnonymousClass1(View view2) {
            r2 = view2;
        }

        @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
        public void onKeyboardShow(int i, int i2) {
            if (i2 == 0) {
                int[] iArr = new int[2];
                CursorEditText.this.getLocationInWindow(iArr);
                int i3 = iArr[1];
                int height = (r2.getHeight() - i) - CursorEditText.this.getHeight();
                if (height > 0) {
                    float f = -(i3 - height);
                    if (f < 0.0f) {
                        r2.setTranslationY(f);
                    }
                }
            }
        }

        @Override // com.ipotensic.baselib.listener.OnKeyboardListener.OnKeyboardStatusChangeListener
        public void onKeyboardDismiss() {
            CursorEditText.this.clearFocus();
            try {
                if (TextUtils.isEmpty(CursorEditText.this.getText().toString())) {
                    CursorEditText.this.setText(CursorEditText.this.min + "");
                    if (CursorEditText.this.inputFinishListener != null) {
                        OnInputFinishListener onInputFinishListener = CursorEditText.this.inputFinishListener;
                        CursorEditText cursorEditText = CursorEditText.this;
                        onInputFinishListener.onResult(cursorEditText, cursorEditText.min);
                    }
                } else {
                    int parseInt = Integer.parseInt(CursorEditText.this.getText().toString());
                    if (CursorEditText.this.min != -1 && CursorEditText.this.max != -1) {
                        try {
                            if (CursorEditText.this.isSpecial(parseInt)) {
                                return;
                            }
                            if (parseInt > CursorEditText.this.max) {
                                parseInt = CursorEditText.this.max;
                                CursorEditText.this.setText(CursorEditText.this.max + "");
                            } else if (parseInt < CursorEditText.this.min) {
                                parseInt = CursorEditText.this.min;
                                CursorEditText.this.setText(CursorEditText.this.min + "");
                            }
                        } catch (NumberFormatException e) {
                            DDLog.e("\u8f93\u51fa\u51fa\u9519:" + e);
                        }
                    }
                    if (CursorEditText.this.inputFinishListener != null) {
                        CursorEditText.this.inputFinishListener.onResult(CursorEditText.this, parseInt);
                    }
                }
            } catch (Exception e2) {
                DDLog.e("\u83b7\u53d6\u8f93\u5165\u5931\u8d25 \uff1a" + e2);
            }
            r2.setTranslationY(0.0f);
            CursorEditText.this.hideSystemUI();
        }
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
        DDLog.e("set input able :" + z);
        setFocusable(z);
        setFocusableInTouchMode(z);
        if (z) {
            setBackgroundResource(R.mipmap.img_bg_white_input_stroke);
        } else {
            setBackgroundResource(R.mipmap.img_bg_gray_input_stroke);
        }
    }

    public void setLimit(int i, int i2, int i3) {
        this.max = i;
        this.defaultValue = i2;
        this.min = i3;
        setTextWatcher();
    }

    public void setNoLimit(boolean z, int i) {
        this.isNoLimit = z;
        if (z) {
            setInputType(1);
            setText("\u221e");
        } else {
            setInputType(2);
            setText(String.valueOf(i));
        }
    }

    public int getCurValue() {
        int parseInt;
        try {
            String obj = getText().toString();
            if (!TextUtils.isEmpty(obj) && (parseInt = Integer.parseInt(obj)) <= this.max) {
                if (parseInt >= this.min) {
                    return parseInt;
                }
            }
        } catch (Exception unused) {
        }
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public void setSpecial(int... iArr) {
        this.specials = iArr;
    }

    public boolean isSpecial(int i) {
        int[] iArr = this.specials;
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i == i2) {
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

    /* renamed from: com.ipotensic.kernel.view.CursorEditText$2 */
    class AnonymousClass2 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(CursorEditText.this.getText().toString()) || CursorEditText.this.isNoLimit) {
                return;
            }
            int parseInt = Integer.parseInt(CursorEditText.this.getText().toString());
            if (CursorEditText.this.min == -1 || CursorEditText.this.max == -1) {
                return;
            }
            try {
                if (!CursorEditText.this.isSpecial(parseInt) && parseInt > CursorEditText.this.max) {
                    CursorEditText.this.setText(CursorEditText.this.max + "");
                }
            } catch (NumberFormatException e) {
                DDLog.e("\u8f93\u51fa\u51fa\u9519:" + e);
            }
        }
    }

    private void setTextWatcher() {
        addTextChangedListener(new TextWatcher() { // from class: com.ipotensic.kernel.view.CursorEditText.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            AnonymousClass2() {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (TextUtils.isEmpty(CursorEditText.this.getText().toString()) || CursorEditText.this.isNoLimit) {
                    return;
                }
                int parseInt = Integer.parseInt(CursorEditText.this.getText().toString());
                if (CursorEditText.this.min == -1 || CursorEditText.this.max == -1) {
                    return;
                }
                try {
                    if (!CursorEditText.this.isSpecial(parseInt) && parseInt > CursorEditText.this.max) {
                        CursorEditText.this.setText(CursorEditText.this.max + "");
                    }
                } catch (NumberFormatException e) {
                    DDLog.e("\u8f93\u51fa\u51fa\u9519:" + e);
                }
            }
        });
    }
}