package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewLoginLoginBinding implements ViewBinding {
    public final Button btnLogin;
    public final ConstraintLayout clBottom;
    public final ConstraintLayout clContent;
    public final EditText editLoginPassword;
    public final EditText editLoginUsername;
    public final ConstraintLayout layoutLogin;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvEmailErrorTips;
    public final TextView tvForgetPassword;
    public final TextView tvLogo;
    public final TextView tvPasswordErrorTips;
    public final TextView tvRegister;

    private ViewLoginLoginBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, EditText editText2, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnLogin = button;
        this.clBottom = constraintLayout2;
        this.clContent = constraintLayout3;
        this.editLoginPassword = editText;
        this.editLoginUsername = editText2;
        this.layoutLogin = constraintLayout4;
        this.tvCodeTitle = textView;
        this.tvEmailErrorTips = textView2;
        this.tvForgetPassword = textView3;
        this.tvLogo = textView4;
        this.tvPasswordErrorTips = textView5;
        this.tvRegister = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLoginLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLoginLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_login_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLoginLoginBinding bind(View view) {
        int i = R.id.btn_login;
        Button button = (Button) view.findViewById(R.id.btn_login);
        if (button != null) {
            i = R.id.cl_bottom;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_bottom);
            if (constraintLayout != null) {
                i = R.id.cl_content;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_content);
                if (constraintLayout2 != null) {
                    i = R.id.edit_login_password;
                    EditText editText = (EditText) view.findViewById(R.id.edit_login_password);
                    if (editText != null) {
                        i = R.id.edit_login_username;
                        EditText editText2 = (EditText) view.findViewById(R.id.edit_login_username);
                        if (editText2 != null) {
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                            i = R.id.tv_code_title;
                            TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                            if (textView != null) {
                                i = R.id.tv_email_error_tips;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_email_error_tips);
                                if (textView2 != null) {
                                    i = R.id.tv_forget_password;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_forget_password);
                                    if (textView3 != null) {
                                        i = R.id.tv_logo;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_logo);
                                        if (textView4 != null) {
                                            i = R.id.tv_password_error_tips;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_password_error_tips);
                                            if (textView5 != null) {
                                                i = R.id.tv_register;
                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_register);
                                                if (textView6 != null) {
                                                    return new ViewLoginLoginBinding(constraintLayout3, button, constraintLayout, constraintLayout2, editText, editText2, constraintLayout3, textView, textView2, textView3, textView4, textView5, textView6);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
