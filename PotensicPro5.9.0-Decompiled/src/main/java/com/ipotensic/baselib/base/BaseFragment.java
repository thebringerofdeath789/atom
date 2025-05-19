package com.ipotensic.baselib.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LoadingDialog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;

/* loaded from: classes2.dex */
public abstract class BaseFragment extends Fragment implements View.OnTouchListener, EventDispatcher.OnEventListener {
    private static final String TAG = "BaseFragment";
    private LoadingDialog loadingDialog;

    public void onBackPressed() {
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOnTouchListener(this);
    }

    protected void showLoadingDialog() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(getContext());
        }
        if (this.loadingDialog.isShowing()) {
            return;
        }
        this.loadingDialog.show();
    }

    protected Dialog getLoadingDialog() {
        return this.loadingDialog;
    }

    protected void dismissLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog == null || !loadingDialog.isShowing()) {
            return;
        }
        this.loadingDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        this.loadingDialog = null;
        DDLog.e("fragment 销毁 :" + getClass().getSimpleName());
    }
}
