package com.ipotensic.baselib.notchtools;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.Window;
import com.ipotensic.baselib.notchtools.core.INotchSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;
import com.ipotensic.baselib.notchtools.helper.DeviceBrandTools;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;
import com.ipotensic.baselib.notchtools.helper.ThreadUtils;
import com.ipotensic.baselib.notchtools.phone.CommonScreen;
import com.ipotensic.baselib.notchtools.phone.HuaWeiNotchScreen;
import com.ipotensic.baselib.notchtools.phone.MiuiNotchScreen;
import com.ipotensic.baselib.notchtools.phone.OppoNotchScreen;
import com.ipotensic.baselib.notchtools.phone.PVersionNotchScreen;
import com.ipotensic.baselib.notchtools.phone.VivoNotchScreen;

/* loaded from: classes2.dex */
public class NotchTools implements INotchSupport {
    private static final int CURRENT_SDK = Build.VERSION.SDK_INT;
    public static final String NOTCH_CONTAINER = "notch_container";
    public static final int VERSION_P = 28;
    private static NotchTools sFullScreenTolls;
    private boolean mHasJudge;
    private boolean mIsNotchScreen;
    private INotchSupport notchScreenSupport = null;

    public static NotchTools getFullScreenTools() {
        if (sFullScreenTolls == null) {
            synchronized (NotchTools.class) {
                if (sFullScreenTolls == null) {
                    sFullScreenTolls = new NotchTools();
                }
            }
        }
        return sFullScreenTolls;
    }

    private NotchTools() {
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        if (!this.mHasJudge) {
            if (this.notchScreenSupport == null) {
                checkScreenSupportInit(window);
            }
            INotchSupport iNotchSupport = this.notchScreenSupport;
            if (iNotchSupport == null) {
                this.mHasJudge = true;
                this.mIsNotchScreen = false;
            } else {
                this.mIsNotchScreen = iNotchSupport.isNotchScreen(window);
            }
        }
        return this.mIsNotchScreen;
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getNotchHeight(Window window) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(window);
        }
        INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport == null) {
            return 0;
        }
        return iNotchSupport.getNotchHeight(window);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getStatusHeight(Window window) {
        return NotchStatusBarUtils.getStatusBarHeight(window.getContext());
    }

    public NotchTools showNavigation(boolean z) {
        NotchStatusBarUtils.sShowNavigation = z;
        return this;
    }

    public void fullScreenDontUseStatus(Activity activity) {
        fullScreenDontUseStatus(activity, null);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.fullScreenDontUseStatus(activity, onNotchCallBack);
        }
    }

    public void fullScreenDontUseStatusForPortrait(Activity activity) {
        fullScreenDontUseStatusForPortrait(activity, null);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(Activity activity, OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    public void fullScreenDontUseStatusForLandscape(Activity activity) {
        fullScreenDontUseStatusForLandscape(activity, null);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForLandscape(final Activity activity, final OnNotchCallBack onNotchCallBack) {
        ThreadUtils.post2UI(new Runnable() { // from class: com.ipotensic.baselib.notchtools.NotchTools.1
            @Override // java.lang.Runnable
            public void run() {
                if (NotchTools.this.notchScreenSupport == null) {
                    NotchTools.this.checkScreenSupportInit(activity.getWindow());
                }
                if (NotchTools.this.notchScreenSupport != null) {
                    NotchTools.this.notchScreenSupport.fullScreenDontUseStatusForLandscape(activity, onNotchCallBack);
                }
            }
        });
    }

    public void fullScreenUseStatus(Activity activity) {
        fullScreenUseStatus(activity, (OnNotchCallBack) null);
    }

    public void fullScreenUseStatus(Dialog dialog) {
        fullScreenUseStatus(dialog, (OnNotchCallBack) null);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(activity.getWindow());
        }
        INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.fullScreenUseStatus(activity, onNotchCallBack);
        }
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack) {
        if (this.notchScreenSupport == null) {
            checkScreenSupportInit(dialog.getWindow());
        }
        INotchSupport iNotchSupport = this.notchScreenSupport;
        if (iNotchSupport != null) {
            iNotchSupport.fullScreenUseStatus(dialog, onNotchCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScreenSupportInit(Window window) {
        if (this.notchScreenSupport != null) {
            return;
        }
        int i = CURRENT_SDK;
        if (i < 26) {
            this.notchScreenSupport = new CommonScreen();
            return;
        }
        if (i >= 28) {
            if (i >= 28) {
                this.notchScreenSupport = new PVersionNotchScreen();
                return;
            }
            return;
        }
        DeviceBrandTools deviceBrandTools = DeviceBrandTools.getInstance();
        if (deviceBrandTools.isHuaWei()) {
            this.notchScreenSupport = new HuaWeiNotchScreen();
            return;
        }
        if (deviceBrandTools.isMiui()) {
            this.notchScreenSupport = new MiuiNotchScreen();
            return;
        }
        if (deviceBrandTools.isVivo()) {
            this.notchScreenSupport = new VivoNotchScreen();
        } else if (deviceBrandTools.isOppo()) {
            this.notchScreenSupport = new OppoNotchScreen();
        } else {
            this.notchScreenSupport = new CommonScreen();
        }
    }
}