package com.ipotensic.potensicpro.activities;

import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: PdfWebActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class PdfWebActivity$downloadPdf$1 implements Runnable {
    final /* synthetic */ String $url;
    final /* synthetic */ PdfWebActivity this$0;

    PdfWebActivity$downloadPdf$1(PdfWebActivity pdfWebActivity, String str) {
        this.this$0 = pdfWebActivity;
        this.$url = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            OkHttpUtil okHttpUtil = OkHttpUtil.getInstance();
            String str = this.$url;
            LocalFileManager localFileManager = LocalFileManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
            okHttpUtil.downloadFileSync(1000, str, localFileManager.getPDF_DIR(), this.this$0.getFileName(), System.currentTimeMillis(), new AnonymousClass1());
        } catch (Exception e) {
            DDLog.e("PdfWebActivity", "downloadPdf..." + e);
        }
    }

    /* compiled from: PdfWebActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"com/ipotensic/potensicpro/activities/PdfWebActivity$downloadPdf$1$1", "Lcom/ipotensic/baselib/okhttp/DownloadListener;", "notEnoughSpace", "", "onDownloadEnd", "filePath", "", "productclass", "onDownloadError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadProgress", NotificationCompat.CATEGORY_PROGRESS, "", "total", "", "onDownloadStart", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
    /* renamed from: com.ipotensic.potensicpro.activities.PdfWebActivity$downloadPdf$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DownloadListener {
        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String filePath, String productclass) {
        }

        AnonymousClass1() {
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadStart() {
            DDLog.e("PdfWebActivity", "onDownloadStart......");
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadProgress(float progress, long total) {
            DDLog.e("PdfWebActivity", "onDownloadProgress......" + progress + PropertyUtils.INDEXED_DELIM + total + PropertyUtils.INDEXED_DELIM2);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String filePath) {
            DDLog.e("PdfWebActivity", "onDownloadFinished......");
            PdfWebActivity$downloadPdf$1.this.this$0.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfWebActivity$downloadPdf$1$1$onDownloadEnd$1
                @Override // java.lang.Runnable
                public final void run() {
                    PdfWebActivity$downloadPdf$1.this.this$0.hideLoading();
                }
            });
            if (filePath != null) {
                PdfWebActivity$downloadPdf$1.this.this$0.goPdfPage(filePath);
            }
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadError(Exception e) {
            DDLog.e("PdfWebActivity", "onDownloadError......" + e);
            PdfWebActivity$downloadPdf$1.this.this$0.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfWebActivity$downloadPdf$1$1$onDownloadError$1
                @Override // java.lang.Runnable
                public final void run() {
                    PdfWebActivity$downloadPdf$1.this.this$0.hideLoading();
                    ToastUtil.toast(PdfWebActivity$downloadPdf$1.this.this$0, PdfWebActivity$downloadPdf$1.this.this$0.getResources().getString(R.string.dialog_download_failure));
                    OkHttpUtil.getInstance().cancelDownload();
                    LocalFileManager localFileManager = LocalFileManager.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
                    File file = new File(localFileManager.getPDF_DIR(), PdfWebActivity$downloadPdf$1.this.this$0.getFileName());
                    if (file.exists()) {
                        file.delete();
                    }
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void notEnoughSpace() {
            DDLog.e("PdfWebActivity", "notEnoughSpace......");
            PdfWebActivity$downloadPdf$1.this.this$0.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.PdfWebActivity$downloadPdf$1$1$notEnoughSpace$1
                @Override // java.lang.Runnable
                public final void run() {
                    PdfWebActivity$downloadPdf$1.this.this$0.hideLoading();
                }
            });
        }
    }
}
