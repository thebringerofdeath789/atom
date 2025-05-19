package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.os.Build;
import com.ipotensic.baselib.base.BaseDialog;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class MainMenuDialog extends BaseDialog {
    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public MainMenuDialog(Context context) {
        super(context, R.layout.view_main_menu, R.style.ImageDetailDialog);
        setSize(-1, -1);
        if (Build.VERSION.SDK_INT < 19) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().setFlags(67108864, 67108864);
            getWindow().setFlags(134217728, 134217728);
        }
    }
}
