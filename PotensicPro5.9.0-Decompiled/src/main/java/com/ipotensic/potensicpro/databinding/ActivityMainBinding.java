package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.BottomTabView;

/* loaded from: classes2.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final BottomTabView bottomView;
    private final ConstraintLayout rootView;
    public final ViewStub stubMe;
    public final ViewStub stubMedia;

    private ActivityMainBinding(ConstraintLayout constraintLayout, BottomTabView bottomTabView, ViewStub viewStub, ViewStub viewStub2) {
        this.rootView = constraintLayout;
        this.bottomView = bottomTabView;
        this.stubMe = viewStub;
        this.stubMedia = viewStub2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.bottom_view;
        BottomTabView bottomTabView = (BottomTabView) view.findViewById(R.id.bottom_view);
        if (bottomTabView != null) {
            i = R.id.stub_me;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.stub_me);
            if (viewStub != null) {
                i = R.id.stub_media;
                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.stub_media);
                if (viewStub2 != null) {
                    return new ActivityMainBinding((ConstraintLayout) view, bottomTabView, viewStub, viewStub2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
