package com.ipotensic.kernel.view.kernel_dialog;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ScreenUtils;

/* loaded from: classes2.dex */
public abstract class BaseDlg {
    protected Activity activity;
    protected ViewGroup childView;
    private OnDismissListener dismissListener;
    protected ViewGroup parentView;
    private boolean isShowing = false;
    private boolean isCancelOnClickOutside = true;

    public interface OnDismissListener {
        void onDismiss(BaseDlg baseDlg);
    }

    public abstract int getLayoutId();

    public abstract void initView(ViewGroup viewGroup);

    public void init(Activity activity, ViewGroup viewGroup) {
        this.activity = activity;
        this.parentView = viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(getLayoutId(), viewGroup, false);
        this.childView = viewGroup2;
        this.parentView.addView(viewGroup2);
        this.parentView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.kernel_dialog.BaseDlg.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseDlg.this.isCancelOnClickOutside) {
                    BaseDlg.this.dismiss();
                }
            }
        });
        this.parentView.setOnKeyListener(new View.OnKeyListener() { // from class: com.ipotensic.kernel.view.kernel_dialog.BaseDlg.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                DDLog.m1684e("key code:" + (i == 4));
                return false;
            }
        });
        initView(this.childView);
    }

    public void setWindow(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.childView.getLayoutParams();
        if (this.childView.getResources().getConfiguration().orientation == 2) {
            layoutParams.width = (ScreenUtils.getScreenWidth(this.activity) * i) / 100;
            layoutParams.height = (ScreenUtils.getScreenHeight(this.activity) * i2) / 100;
        }
        this.childView.setLayoutParams(layoutParams);
    }

    public void show() {
        this.parentView.setVisibility(0);
        this.isShowing = true;
    }

    public void dismiss() {
        this.parentView.setVisibility(8);
        this.isShowing = false;
        OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void setCancelOnClickOutside(boolean z) {
        this.isCancelOnClickOutside = z;
    }

    public void setDismissListener(OnDismissListener onDismissListener) {
        this.dismissListener = onDismissListener;
    }
}