package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class LoginModuleEditText extends AppCompatEditText {
    private Context context;
    private Drawable lock;
    private Drawable unlock;

    public LoginModuleEditText(Context context) {
        super(context, null);
    }

    public LoginModuleEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public LoginModuleEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    private void initView() {
        this.lock = this.context.getResources().getDrawable(R.mipmap.img_icon_pwd_lock);
        this.unlock = this.context.getResources().getDrawable(R.mipmap.img_icon_pwd_unlock);
        addTextChangedListener(new TextWatcher() { // from class: com.ipotensic.potensicpro.view.LoginModuleEditText.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                LoginModuleEditText.this.setDrawable();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDrawable() {
        if (length() < 1) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.lock, (Drawable) null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.unlock, (Drawable) null);
        }
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        super.addTextChangedListener(textWatcher);
    }
}