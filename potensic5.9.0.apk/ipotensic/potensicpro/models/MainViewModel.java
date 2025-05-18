package com.ipotensic.potensicpro.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IAppDumpLog;
import com.logan.user.view.IVersionView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MainViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/ipotensic/potensicpro/models/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "currentTab", "Landroidx/lifecycle/MutableLiveData;", "", "getCurrentTab", "()Landroidx/lifecycle/MutableLiveData;", "isAtomSeries", "", "kotlin.jvm.PlatformType", "unReadNum", "getUnReadNum", "updateFinishData", "getUpdateFinishData", "versionData", "Lcom/logan/user/model/rev/RevUserAppVersionData$Version;", "getVersionData", "checkAppVersionUpdate", "", "release", "uploadDumpLog", "Companion", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainViewModel extends ViewModel {
    public static final String applicationId = "com.ipotensic.potensicpro";
    public static final String googlePlayNew = "com.android.vending";
    private final MutableLiveData<RevUserAppVersionData.Version> versionData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> updateFinishData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isAtomSeries = new MutableLiveData<>(true);
    private final MutableLiveData<Integer> currentTab = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> unReadNum = new MutableLiveData<>(0);

    public final MutableLiveData<RevUserAppVersionData.Version> getVersionData() {
        return this.versionData;
    }

    public final MutableLiveData<Boolean> getUpdateFinishData() {
        return this.updateFinishData;
    }

    public final MutableLiveData<Boolean> isAtomSeries() {
        return this.isAtomSeries;
    }

    public final MutableLiveData<Integer> getCurrentTab() {
        return this.currentTab;
    }

    public final MutableLiveData<Integer> getUnReadNum() {
        return this.unReadNum;
    }

    public final void checkAppVersionUpdate() {
        if (PhoneConfig.usrToken != null) {
            UserRequestPresenter.getInstance().checkAppVersionUpdate(PhoneConfig.usrToken, new IVersionView() { // from class: com.ipotensic.potensicpro.models.MainViewModel$checkAppVersionUpdate$1
                @Override // com.logan.user.view.IVersionView
                public void needToUpdate(RevUserAppVersionData.Version version) {
                    if (version != null) {
                        if (version.getEnable() == 0) {
                            MainViewModel.this.getVersionData().setValue(version);
                        } else {
                            MainViewModel.this.getUpdateFinishData().setValue(true);
                        }
                    }
                }

                @Override // com.logan.user.view.IVersionView
                public void getInfoError() {
                    MainViewModel.this.getUpdateFinishData().setValue(true);
                }
            });
        }
    }

    public final void release() {
        UserRequestPresenter.getInstance().removeVersionView();
    }

    public final void uploadDumpLog() {
        File[] listFiles;
        LocalFileManager localFileManager = LocalFileManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
        File file = new File(localFileManager.getLogDir());
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (!(listFiles.length == 0)) {
                for (final File logFile : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(logFile, "logFile");
                    String name = logFile.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "logFile.name");
                    LocalFileManager localFileManager2 = LocalFileManager.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(localFileManager2, "LocalFileManager.getInstance()");
                    String crashLogNamePeriod = localFileManager2.getCrashLogNamePeriod();
                    Intrinsics.checkExpressionValueIsNotNull(crashLogNamePeriod, "LocalFileManager.getInstance().crashLogNamePeriod");
                    if (StringsKt.startsWith$default(name, crashLogNamePeriod, false, 2, (Object) null)) {
                        DDLog.w("\u65e5\u5fd7\u6587\u4ef6 \uff1a" + logFile.getAbsolutePath());
                        UserRequestPresenter.getInstance().appDumpLog(PhoneConfig.usrToken, logFile, new IAppDumpLog() { // from class: com.ipotensic.potensicpro.models.MainViewModel$uploadDumpLog$1
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

                            @Override // com.logan.user.view.IAppDumpLog
                            public void uploadedSuccess() {
                                logFile.delete();
                            }

                            @Override // com.logan.user.view.IAppDumpLog
                            public void fileIsExists() {
                                logFile.delete();
                            }
                        });
                        return;
                    }
                }
            }
        }
    }
}