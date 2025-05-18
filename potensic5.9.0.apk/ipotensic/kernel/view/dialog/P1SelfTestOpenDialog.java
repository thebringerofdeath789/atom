package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class P1SelfTestOpenDialog extends com.ipotensic.baselib.base.BaseDialog {
    private OnNumberCallback callback;

    public interface OnNumberCallback {
        void onNumber(int i);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public P1SelfTestOpenDialog(Context context, final OnNumberCallback onNumberCallback) {
        super(context, R.layout.view_dialog_p1self_test_open);
        this.callback = onNumberCallback;
        setSize((int) (ScreenUtils.getScreenWidth(getContext()) * 0.35d), -2);
        final EditText editText = (EditText) findViewById(R.id.edit_time);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    editText.setText("" + (Integer.valueOf(editText.getText().toString().trim()).intValue() + 1));
                } catch (Exception unused) {
                }
            }
        });
        findViewById(R.id.btn_sub).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    int intValue = Integer.valueOf(editText.getText().toString().trim()).intValue();
                    if (intValue > 1) {
                        editText.setText("" + (intValue - 1));
                    }
                } catch (Exception unused) {
                }
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                P1SelfTestOpenDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onNumberCallback.onNumber(Integer.parseInt(editText.getText().toString()));
                P1SelfTestOpenDialog.this.dismiss();
            }
        });
    }
}