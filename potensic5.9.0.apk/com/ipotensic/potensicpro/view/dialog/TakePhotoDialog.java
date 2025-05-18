package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import com.ipotensic.baselib.base.BaseDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public class TakePhotoDialog extends BaseDialog {
    private TakePhotoSelectListener listener;

    public interface TakePhotoSelectListener {
        void takePhoto();

        void uploadPhoto();
    }

    private void windowDeploy() {
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(C2640R.style.dialogWindowAnim);
        window.setBackgroundDrawableResource(C2640R.color.colorTransparent);
        window.setLayout(-1, -2);
    }

    public TakePhotoDialog(Context context, TakePhotoSelectListener takePhotoSelectListener) {
        super(context, C2640R.layout.view_dialog_take_photo);
        int navigationBarHeight = ScreenUtils.getNavigationBarHeight(getContext());
        navigationBarHeight = navigationBarHeight < 0 ? 0 : navigationBarHeight;
        Button button = (Button) findViewById(C2640R.id.btn_cancel);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.bottomMargin = navigationBarHeight;
        button.setLayoutParams(layoutParams);
        this.listener = takePhotoSelectListener;
        windowDeploy();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(C2640R.id.btn_take_photo).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TakePhotoDialog.this.listener.takePhoto();
                TakePhotoDialog.this.dismiss();
            }
        });
        findViewById(C2640R.id.btn_upload_photo).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TakePhotoDialog.this.listener.uploadPhoto();
                TakePhotoDialog.this.dismiss();
            }
        });
        findViewById(C2640R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.TakePhotoDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TakePhotoDialog.this.dismiss();
            }
        });
    }
}