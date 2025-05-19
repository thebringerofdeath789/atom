package com.ipotensic.potensicpro.utils;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class KeyHideUtil {
    public static void hideKey(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.ipotensic.potensicpro.utils.KeyHideUtil.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 66;
            }
        });
    }
}
