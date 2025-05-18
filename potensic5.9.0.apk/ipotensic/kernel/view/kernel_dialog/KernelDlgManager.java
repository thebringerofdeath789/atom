package com.ipotensic.kernel.view.kernel_dialog;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class KernelDlgManager {
    private static volatile KernelDlgManager instance;
    private Activity activity;
    private ViewGroup activityView;
    private RelativeLayout mainWindow;
    private boolean isAttached = false;
    private BaseDlg curDialog = null;

    protected KernelDlgManager() {
    }

    public static KernelDlgManager get() {
        if (instance == null) {
            synchronized (KernelDlgManager.class) {
                if (instance == null) {
                    KernelDlgManager kernelDlgManager = new KernelDlgManager();
                    instance = kernelDlgManager;
                    return kernelDlgManager;
                }
            }
        }
        return instance;
    }

    public void attach(Activity activity, int i) {
        this.activity = activity;
        this.activityView = (ViewGroup) activity.findViewById(i);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(activity);
        this.mainWindow = relativeLayout;
        relativeLayout.setBackgroundColor(activity.getResources().getColor(R.color.dialog_bg));
        this.mainWindow.setVisibility(0);
        this.activityView.addView(this.mainWindow, layoutParams);
        this.isAttached = true;
    }

    public void detach() {
        this.isAttached = false;
        ViewGroup viewGroup = this.activityView;
        if (viewGroup != null) {
            viewGroup.removeView(this.mainWindow);
        }
    }

    public <T extends BaseDlg> T create(Class<T> cls) {
        if (!this.isAttached) {
            return null;
        }
        this.mainWindow.removeAllViews();
        this.curDialog = null;
        try {
            T newInstance = cls.newInstance();
            newInstance.init(this.activity, this.mainWindow);
            this.curDialog = newInstance;
            return newInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isDialogShowing() {
        BaseDlg baseDlg = this.curDialog;
        return baseDlg != null && baseDlg.isShowing();
    }

    public void dismiss() {
        BaseDlg baseDlg = this.curDialog;
        if (baseDlg == null || !baseDlg.isShowing()) {
            return;
        }
        this.curDialog.dismiss();
    }
}