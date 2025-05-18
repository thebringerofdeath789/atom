package com.ipotensic.potensicpro.activities;

import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MainAcademyController$downloadPdf$1$1$onDownloadError$1 implements Runnable {
    MainAcademyController$downloadPdf$1$1$onDownloadError$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        MainAcademyController$downloadPdf$1.this.this$0.hideLoading();
        ToastUtil.toast(MainAcademyController$downloadPdf$1.this.this$0.getActivity(), MainAcademyController$downloadPdf$1.this.this$0.getActivity().getString(R.string.dialog_download_failure));
        OkHttpUtil.getInstance().cancelDownload();
        LocalFileManager localFileManager = LocalFileManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
        String pdf_dir = localFileManager.getPDF_DIR();
        str = MainAcademyController$downloadPdf$1.this.this$0.fileName;
        File file = new File(pdf_dir, str);
        if (file.exists()) {
            file.delete();
        }
    }
}