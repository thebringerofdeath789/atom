package com.ipotensic.baselib.guide.core;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.listener.OnPageChangedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Builder {
    Activity activity;
    boolean alwaysShow;
    View anchor;
    Fragment fragment;
    String label;
    OnGuideChangedListener onGuideChangedListener;
    OnPageChangedListener onPageChangedListener;
    androidx.fragment.app.Fragment v4Fragment;
    int showCounts = 1;
    List<GuidePage> guidePages = new ArrayList();

    public Builder(Activity activity) {
        this.activity = activity;
    }

    public Builder(Fragment fragment) {
        this.fragment = fragment;
        this.activity = fragment.getActivity();
    }

    public Builder(androidx.fragment.app.Fragment fragment) {
        this.v4Fragment = fragment;
        this.activity = fragment.getActivity();
    }

    public Builder anchor(View view) {
        this.anchor = view;
        return this;
    }

    public Builder setShowCounts(int i) {
        this.showCounts = i;
        return this;
    }

    public Builder alwaysShow(boolean z) {
        this.alwaysShow = z;
        return this;
    }

    public Builder addGuidePage(GuidePage guidePage) {
        this.guidePages.add(guidePage);
        return this;
    }

    public Builder setOnGuideChangedListener(OnGuideChangedListener onGuideChangedListener) {
        this.onGuideChangedListener = onGuideChangedListener;
        return this;
    }

    public Builder setOnPageChangedListener(OnPageChangedListener onPageChangedListener) {
        this.onPageChangedListener = onPageChangedListener;
        return this;
    }

    public Builder setLabel(String str) {
        this.label = str;
        return this;
    }

    public Controller build() {
        check();
        return new Controller(this);
    }

    public Controller show() {
        check();
        Controller controller = new Controller(this);
        controller.show();
        return controller;
    }

    public Controller show(boolean z) {
        check();
        Controller controller = new Controller(this);
        controller.show();
        controller.setGuideFinish(z);
        return controller;
    }

    private void check() {
        if (this.activity == null) {
            if (this.fragment != null || this.v4Fragment != null) {
                throw new IllegalStateException("activity is null, please make sure that fragment is showing when call NewbieGuide");
            }
        }
    }
}