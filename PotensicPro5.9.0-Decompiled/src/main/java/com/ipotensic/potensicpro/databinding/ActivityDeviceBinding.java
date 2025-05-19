package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityDeviceBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ViewStub stubConnect;
    public final ViewStub stubList;
    public final ViewStub stubMethod;

    private ActivityDeviceBinding(ConstraintLayout constraintLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3) {
        this.rootView = constraintLayout;
        this.stubConnect = viewStub;
        this.stubList = viewStub2;
        this.stubMethod = viewStub3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDeviceBinding bind(View view) {
        int i = R.id.stub_connect;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.stub_connect);
        if (viewStub != null) {
            i = R.id.stub_list;
            ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.stub_list);
            if (viewStub2 != null) {
                i = R.id.stub_method;
                ViewStub viewStub3 = (ViewStub) view.findViewById(R.id.stub_method);
                if (viewStub3 != null) {
                    return new ActivityDeviceBinding((ConstraintLayout) view, viewStub, viewStub2, viewStub3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
