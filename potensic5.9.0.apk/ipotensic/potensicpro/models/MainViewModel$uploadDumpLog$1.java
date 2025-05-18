package com.ipotensic.potensicpro.models;

import com.logan.user.view.IAppDumpLog;
import java.io.File;
import kotlin.Metadata;

/* compiled from: MainViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/ipotensic/potensicpro/models/MainViewModel$uploadDumpLog$1", "Lcom/logan/user/view/IAppDumpLog;", "fileIsExists", "", "missFiles", "tokenError", "uploadedFail", "uploadedFrequently", "uploadedSuccess", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainViewModel$uploadDumpLog$1 implements IAppDumpLog {
    final /* synthetic */ File $logFile;

    @Override // com.logan.user.view.IAppDumpLog
    public void missFiles() {
    }

    @Override // com.logan.user.view.IAppDumpLog
    public void tokenError() {
    }

    @Override // com.logan.user.view.IAppDumpLog
    public void uploadedFail() {
    }

    @Override // com.logan.user.view.IAppDumpLog
    public void uploadedFrequently() {
    }

    MainViewModel$uploadDumpLog$1(File file) {
        logFile = file;
    }

    @Override // com.logan.user.view.IAppDumpLog
    public void uploadedSuccess() {
        logFile.delete();
    }

    @Override // com.logan.user.view.IAppDumpLog
    public void fileIsExists() {
        logFile.delete();
    }
}