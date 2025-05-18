package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class DeleteMediaDialog extends com.ipotensic.baselib.base.BaseDialog {
    private DeleteMediaListener listener;

    public interface DeleteMediaListener {
        void delete();
    }

    private void windowDeploy() {
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(C1965R.style.dialogWindowAnim);
        window.setBackgroundDrawableResource(C1965R.color.colorTransparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setLayout(-1, -2);
        window.setAttributes(attributes);
    }

    public DeleteMediaDialog(Context context, String str, DeleteMediaListener deleteMediaListener) {
        super(context, C1965R.layout.view_dialog_media_delete);
        this.listener = deleteMediaListener;
        ((Button) findViewById(C1965R.id.btn_delete)).setText(str);
        windowDeploy();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(C1965R.id.btn_delete).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.DeleteMediaDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeleteMediaDialog.this.listener.delete();
                DeleteMediaDialog.this.dismiss();
            }
        });
        findViewById(C1965R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.DeleteMediaDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeleteMediaDialog.this.dismiss();
            }
        });
    }
}