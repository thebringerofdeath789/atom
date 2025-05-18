package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.WebActivity;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.kernel.utils.AnimationUtil;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: PdfWebActivity.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m2338d2 = {"Lcom/ipotensic/potensicpro/activities/PdfWebActivity;", "Lcom/ipotensic/baselib/base/WebActivity;", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "downloadPdf", "", "url", "goPdfPage", "filePath", "loadPdf", "onBackPressed", "showLoading", "Companion", "app__GooglePalyRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class PdfWebActivity extends WebActivity {
    private static final String TAG = "PdfWebActivity";
    private HashMap _$_findViewCache;
    private String fileName;

    @Override // com.ipotensic.baselib.base.WebActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.ipotensic.baselib.base.WebActivity
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    @Override // com.ipotensic.baselib.base.WebActivity
    public void loadPdf(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        try {
            String substring = url.substring(StringsKt.lastIndexOf$default((CharSequence) url, InternalZipConstants.ZIP_FILE_SEPARATOR, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            this.fileName = substring;
            this.fileName = URLDecoder.decode(substring, "UTF-8");
            DDLog.m1683d(TAG, "fileName=" + this.fileName);
            StringBuilder sb = new StringBuilder();
            LocalFileManager localFileManager = LocalFileManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
            File file = new File(sb.append(localFileManager.getPDF_DIR()).append(File.separator).append(this.fileName).toString());
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                goPdfPage(absolutePath);
            } else {
                downloadPdf(url);
            }
        } catch (Exception e) {
            DDLog.m1685e(TAG, "Exception=" + e);
        }
    }

    private final void downloadPdf(String url) {
        showLoading();
        new Thread(new PdfWebActivity$downloadPdf$1(this, url)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goPdfPage(String filePath) {
        Intent intent = new Intent(this, (Class<?>) PdfShowActivity.class);
        intent.putExtra(PdfShowActivity.FILE_PATH, new File(filePath));
        startActivity(intent);
    }

    @Override // com.ipotensic.baselib.base.WebActivity
    public void showLoading() {
        super.showLoading();
        AnimationUtil.selfRotate(getProgressBar());
    }

    @Override // com.ipotensic.baselib.base.WebActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        OkHttpUtil.getInstance().cancelDownload();
        hideLoading();
    }
}