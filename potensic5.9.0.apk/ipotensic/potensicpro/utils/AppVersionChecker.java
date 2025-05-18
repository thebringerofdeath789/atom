package com.ipotensic.potensicpro.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.potensicpro.BuildConfig;
import com.ipotensic.potensicpro.models.MainViewModel;
import com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog;
import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IVersionView;

/* loaded from: classes2.dex */
public class AppVersionChecker implements IVersionView {
    private static volatile AppVersionChecker instance;
    private Activity context;
    private OnUpgradeListener onUpgradeListener;
    private VersionUpdateDialog updateDialog;
    private final String googlePlayNew = MainViewModel.googlePlayNew;
    private final String applicationId = "com.ipotensic.potensicpro";
    private boolean isCancelUpgrade = false;

    public interface OnUpgradeListener {
        void upgradeFinish();
    }

    private AppVersionChecker() {
    }

    public static AppVersionChecker getInstance() {
        if (instance == null) {
            synchronized (AppVersionChecker.class) {
                if (instance == null) {
                    instance = new AppVersionChecker();
                }
            }
        }
        return instance;
    }

    public void check(Activity activity, OnUpgradeListener onUpgradeListener) {
        this.context = activity;
        this.onUpgradeListener = onUpgradeListener;
        if (PhoneConfig.usrToken != null) {
            UserRequestPresenter.getInstance().checkAppVersionUpdate(PhoneConfig.usrToken, this);
        }
    }

    @Override // com.logan.user.view.IVersionView
    public void needToUpdate(RevUserAppVersionData.Version version) {
        if (version != null) {
            String appver = version.getAppver();
            int isforceupdate = version.getIsforceupdate();
            int enable = version.getEnable();
            final String down_url = version.getDown_url();
            String content = version.getContent();
            if (enable == 0) {
                if (this.context.isFinishing() || BaseSyncDialog.isShow) {
                    return;
                }
                VersionUpdateDialog versionUpdateDialog = new VersionUpdateDialog(this.context, appver, content, isforceupdate, new VersionUpdateDialog.OnItemClickListener() { // from class: com.ipotensic.potensicpro.utils.AppVersionChecker.1
                    @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
                    public void toUpdate() {
                        AppVersionChecker.this.downloadFromGooglePlay(down_url);
                    }

                    @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
                    public void cancel() {
                        AppVersionChecker.this.setUpgradeFinishListener();
                    }
                });
                this.updateDialog = versionUpdateDialog;
                versionUpdateDialog.show();
                return;
            }
            setUpgradeFinishListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpgradeFinishListener() {
        if (this.onUpgradeListener != null) {
            PhoneConfig.appUpgradeVersion = true;
            this.onUpgradeListener.upgradeFinish();
        }
    }

    @Override // com.logan.user.view.IVersionView
    public void getInfoError() {
        setUpgradeFinishListener();
    }

    public void downloadFromPGY(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.pgyer.com/1888"));
            context.startActivity(intent);
        } catch (Exception e) {
            DDLog.e("\u8df3\u8f6c\u5931\u8d25\uff1a" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFromGooglePlay(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.ipotensic.potensicpro"));
            intent.setPackage(MainViewModel.googlePlayNew);
            if (intent.resolveActivity(this.context.getPackageManager()) != null) {
                this.context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(BuildConfig.UpdateAppUrl));
            if (intent2.resolveActivity(this.context.getPackageManager()) != null) {
                this.context.startActivity(intent2);
                return;
            }
            VersionUpdateDialog versionUpdateDialog = this.updateDialog;
            if (versionUpdateDialog != null && versionUpdateDialog.isShowing()) {
                this.updateDialog.dismiss();
            }
            setUpgradeFinishListener();
        } catch (ActivityNotFoundException unused) {
            DDLog.e("GoogleMarket Intent not found");
        }
    }

    public void release() {
        VersionUpdateDialog versionUpdateDialog = this.updateDialog;
        if (versionUpdateDialog == null || !versionUpdateDialog.isShowing()) {
            return;
        }
        this.updateDialog.dismiss();
    }

    private void toBrowser(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.context.startActivity(intent);
    }
}