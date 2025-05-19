package com.ipotensic.kernel.controllers;

import android.view.View;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.utils.SimpleLifeCycle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public abstract class BaseController extends SimpleLifeCycle implements EventDispatcher.OnEventListener {
    private AppCompatActivity appCompatActivity;
    private View baseView;
    private ViewStub viewStub;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Visible {
    }

    public abstract void initView(View view);

    public void onEvent(EventID eventID, Event event) {
    }

    @Override // com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onPause() {
    }

    @Override // com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onResume() {
    }

    public BaseController(AppCompatActivity appCompatActivity, View view) {
        this.appCompatActivity = appCompatActivity;
        appCompatActivity.getLifecycle().addObserver(this);
        EventDispatcher.get().registerEvent(appCompatActivity.getLifecycle(), this);
        if (view != null) {
            this.baseView = view;
            initView(view);
        }
    }

    public BaseController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        this.appCompatActivity = appCompatActivity;
        appCompatActivity.getLifecycle().addObserver(this);
        EventDispatcher.get().registerEvent(appCompatActivity.getLifecycle(), this);
        this.viewStub = viewStub;
    }

    public AppCompatActivity getContext() {
        return this.appCompatActivity;
    }

    public View getBaseView() {
        return this.baseView;
    }

    public void setVisibility(int i) {
        if (i == 0 || this.baseView != null) {
            ViewStub viewStub = this.viewStub;
            if (viewStub != null && this.baseView == null) {
                View inflate = viewStub.inflate();
                this.baseView = inflate;
                initView(inflate);
                return;
            }
            this.baseView.setVisibility(i);
        }
    }

    public int getVisibility() {
        View view = this.baseView;
        if (view == null) {
            return 8;
        }
        return view.getVisibility();
    }

    @Override // com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onCreate() {
        DDLog.e("oncreate controller:" + getClass().getSimpleName());
    }

    @Override // com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        DDLog.e("ondestroy controller:" + getClass().getSimpleName());
    }
}
