package com.ipotensic.baselib;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.ipotensic.baselib.base.BaseDialog;

/* loaded from: classes2.dex */
public class LoadingDialog extends BaseDialog {
    private ImageView imageView;

    public LoadingDialog(Context context) {
        super(context, C1819R.layout.view_dialog_loading);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.imageView = (ImageView) findViewById(C1819R.id.img);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        Glide.with(getContext()).load(Integer.valueOf(C1819R.mipmap.icon_gif_loading)).into((DrawableTypeRequest<Integer>) new GlideDrawableImageViewTarget(this.imageView));
        super.show();
    }
}