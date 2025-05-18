package com.ipotensic.potensicpro.activities;

import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.C2640R;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: MainAcademyController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m2338d2 = {"<anonymous>", "", "run"}, m2339k = 3, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MainAcademyController$downloadPdf$1 implements Runnable {
    final /* synthetic */ String $url;
    final /* synthetic */ MainAcademyController this$0;

    MainAcademyController$downloadPdf$1(MainAcademyController mainAcademyController, String str) {
        this.this$0 = mainAcademyController;
        this.$url = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        try {
            OkHttpUtil okHttpUtil = OkHttpUtil.getInstance();
            String str3 = this.$url;
            LocalFileManager localFileManager = LocalFileManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
            String pdf_dir = localFileManager.getPDF_DIR();
            str2 = this.this$0.fileName;
            okHttpUtil.downloadFileSync(1000, str3, pdf_dir, str2, System.currentTimeMillis(), new C27201());
        } catch (Exception e) {
            str = this.this$0.TAG;
            DDLog.m1685e(str, "downloadPdf..." + e);
        }
    }

    /* compiled from: MainAcademyController.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, m2338d2 = {"com/ipotensic/potensicpro/activities/MainAcademyController$downloadPdf$1$1", "Lcom/ipotensic/baselib/okhttp/DownloadListener;", "notEnoughSpace", "", "onDownloadEnd", "filePath", "", "productclass", "onDownloadError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadProgress", NotificationCompat.CATEGORY_PROGRESS, "", "total", "", "onDownloadStart", "app__GooglePalyRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
    /* renamed from: com.ipotensic.potensicpro.activities.MainAcademyController$downloadPdf$1$1 */
    public static final class C27201 implements DownloadListener {
        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String filePath, String productclass) {
        }

        C27201() {
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadStart() {
            String str;
            str = MainAcademyController$downloadPdf$1.this.this$0.TAG;
            DDLog.m1685e(str, "onDownloadStart......");
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadProgress(float progress, long total) {
            String str;
            str = MainAcademyController$downloadPdf$1.this.this$0.TAG;
            DDLog.m1685e(str, "onDownloadProgress......" + progress + PropertyUtils.INDEXED_DELIM + total + PropertyUtils.INDEXED_DELIM2);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String filePath) {
            String str;
            str = MainAcademyController$downloadPdf$1.this.this$0.TAG;
            DDLog.m1685e(str, "onDownloadFinished......");
            MainAcademyController$downloadPdf$1.this.this$0.getActivity().runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$downloadPdf$1$1$onDownloadEnd$1
                @Override // java.lang.Runnable
                public final void run() {
                    MainAcademyController$downloadPdf$1.this.this$0.hideLoading();
                }
            });
            if (filePath != null) {
                MainAcademyController$downloadPdf$1.this.this$0.goPdfPage(filePath);
            }
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadError(Exception e) {
            String str;
            str = MainAcademyController$downloadPdf$1.this.this$0.TAG;
            DDLog.m1685e(str, "onDownloadError......" + e);
            MainAcademyController$downloadPdf$1.this.this$0.getActivity().runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$downloadPdf$1$1$onDownloadError$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2;
                    MainAcademyController$downloadPdf$1.this.this$0.hideLoading();
                    ToastUtil.toast(MainAcademyController$downloadPdf$1.this.this$0.getActivity(), MainAcademyController$downloadPdf$1.this.this$0.getActivity().getString(C2640R.string.dialog_download_failure));
                    OkHttpUtil.getInstance().cancelDownload();
                    LocalFileManager localFileManager = LocalFileManager.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
                    String pdf_dir = localFileManager.getPDF_DIR();
                    str2 = MainAcademyController$downloadPdf$1.this.this$0.fileName;
                    File file = new File(pdf_dir, str2);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void notEnoughSpace() {
            String str;
            str = MainAcademyController$downloadPdf$1.this.this$0.TAG;
            DDLog.m1685e(str, "notEnoughSpace......");
            MainAcademyController$downloadPdf$1.this.this$0.getActivity().runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$downloadPdf$1$1$notEnoughSpace$1
                @Override // java.lang.Runnable
                public final void run() {
                    MainAcademyController$downloadPdf$1.this.this$0.hideLoading();
                }
            });
        }
    }
}