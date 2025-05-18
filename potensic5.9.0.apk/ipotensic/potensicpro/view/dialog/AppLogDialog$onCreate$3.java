package com.ipotensic.potensicpro.view.dialog;

import android.net.Uri;
import android.view.View;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.share2.FileUtil;
import com.ipotensic.baselib.share2.Share2;
import com.ipotensic.baselib.share2.ShareContentType;
import com.ipotensic.mediagallery.ToastUtil;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: AppLogDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/potensicpro/view/dialog/AppLogDialog$onCreate$3", "Lcom/ipotensic/baselib/listener/ScaleClickListener;", "click", "", "view", "Landroid/view/View;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AppLogDialog$onCreate$3 extends ScaleClickListener {
    AppLogDialog$onCreate$3() {
    }

    @Override // com.ipotensic.baselib.listener.ScaleClickListener
    public void click(View view) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        Iterator it = AppLogDialog.this.fileItems.iterator();
        while (it.hasNext()) {
            AppLogDialog.FileItem fileItem = (AppLogDialog.FileItem) it.next();
            if (fileItem.isSelect()) {
                arrayList.add(FileUtil.getFileUri(AppLogDialog.this.getContext(), ShareContentType.FILE, fileItem.getFile()));
            }
        }
        if (arrayList.isEmpty()) {
            ToastUtil.showToast(AppLogDialog.this.getContext(), "\u8bf7\u9009\u62e9\u9700\u8981\u5206\u4eab\u7684\u6587\u4ef6!!");
        } else {
            new Share2.Builder(AppLogDialog.this.getActivity()).setContentType(ShareContentType.FILE).setIsSingle(false).setShareFileUriList(arrayList).setTitle("SHARE WITH FRIENDS").build().shareBySystem();
        }
    }
}