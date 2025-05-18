package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.ipotensic.baselib.base.BaseDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public class AircraftLogDialog extends BaseDialog {
    private OnClickListener listener;

    public interface OnClickListener {
        void onCancel();

        void onFinish(String str, String str2);
    }

    public AircraftLogDialog(Context context, OnClickListener onClickListener) {
        super(context, C2640R.layout.view_dialog_aircraft_log);
        this.listener = onClickListener;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.8d);
        attributes.height = -2;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        final EditText editText = (EditText) findViewById(C2640R.id.et_model);
        final EditText editText2 = (EditText) findViewById(C2640R.id.et_feedback);
        findViewById(C2640R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.AircraftLogDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AircraftLogDialog.this.dismiss();
                if (AircraftLogDialog.this.listener != null) {
                    AircraftLogDialog.this.listener.onCancel();
                }
            }
        });
        findViewById(C2640R.id.btn_finish).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.AircraftLogDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AircraftLogDialog.this.dismiss();
                String trim = editText.getText().toString().trim();
                String trim2 = editText2.getText().toString().trim();
                if (AircraftLogDialog.this.listener != null) {
                    AircraftLogDialog.this.listener.onFinish(trim, trim2);
                }
            }
        });
    }
}