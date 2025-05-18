package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.base.BaseDialog;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.utils.PhotoChooserUtil;

/* loaded from: classes2.dex */
public class PhotoChooseDialog extends BaseDialog {
    private AppCompatActivity activity;
    private PhotoChooserUtil.OnChooseListener listener;
    private PhotoChooserUtil photoChooserUtil;

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public PhotoChooseDialog(final AppCompatActivity appCompatActivity, final PhotoChooserUtil.OnChooseListener onChooseListener) {
        super(appCompatActivity, R.layout.view_dialog_header_choose);
        this.activity = appCompatActivity;
        this.listener = onChooseListener;
        findViewById(R.id.btn_take_photo).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.PhotoChooseDialog.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (PhotoChooseDialog.this.photoChooserUtil == null) {
                    PhotoChooseDialog.this.photoChooserUtil = new PhotoChooserUtil(appCompatActivity, onChooseListener);
                }
                PhotoChooseDialog.this.photoChooserUtil.takePhotoForCamera();
                PhotoChooseDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_upload_photo).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.PhotoChooseDialog.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (PhotoChooseDialog.this.photoChooserUtil == null) {
                    PhotoChooseDialog.this.photoChooserUtil = new PhotoChooserUtil(appCompatActivity, onChooseListener);
                }
                PhotoChooseDialog.this.photoChooserUtil.takePhotoForAlbum(true);
                PhotoChooseDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.PhotoChooseDialog.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                PhotoChooseDialog.this.dismiss();
            }
        });
        int navigationBarHeight = ScreenUtils.getNavigationBarHeight(getContext());
        navigationBarHeight = navigationBarHeight < 0 ? 0 : navigationBarHeight;
        Button button = (Button) findViewById(R.id.btn_cancel);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.bottomMargin = navigationBarHeight;
        button.setLayoutParams(layoutParams);
        windowDeploy();
    }

    private void windowDeploy() {
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.dialogWindowAnim);
        window.setBackgroundDrawableResource(R.color.colorTransparent);
        window.setLayout(-1, -2);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PhotoChooserUtil photoChooserUtil = this.photoChooserUtil;
        if (photoChooserUtil != null) {
            photoChooserUtil.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PhotoChooserUtil photoChooserUtil = this.photoChooserUtil;
        if (photoChooserUtil != null) {
            photoChooserUtil.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}