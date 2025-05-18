package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityLoginBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ViewStub stubForgetPassword;
    public final ViewStub stubRegister;
    public final ViewStub stubSendSuccess;

    private ActivityLoginBinding(ConstraintLayout constraintLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3) {
        this.rootView = constraintLayout;
        this.stubForgetPassword = viewStub;
        this.stubRegister = viewStub2;
        this.stubSendSuccess = viewStub3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLoginBinding bind(View view) {
        int i = R.id.stub_forget_password;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.stub_forget_password);
        if (viewStub != null) {
            i = R.id.stub_register;
            ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.stub_register);
            if (viewStub2 != null) {
                i = R.id.stub_send_success;
                ViewStub viewStub3 = (ViewStub) view.findViewById(R.id.stub_send_success);
                if (viewStub3 != null) {
                    return new ActivityLoginBinding((ConstraintLayout) view, viewStub, viewStub2, viewStub3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}