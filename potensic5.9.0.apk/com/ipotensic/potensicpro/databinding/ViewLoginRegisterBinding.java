package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewLoginRegisterBinding implements ViewBinding {
    public final Button btnRegister;
    public final CheckBox checkbox;
    public final ConstraintLayout clBottom;
    public final ConstraintLayout clContent;
    public final EditText editRegisterPassword;
    public final EditText editRegisterUsername;
    private final ConstraintLayout rootView;
    public final TextView tvChooseCountry;
    public final TextView tvCodeTitle;
    public final TextView tvEmailErrorTips;
    public final TextView tvLogin;
    public final TextView tvLogo;
    public final TextView tvPasswordErrorTips;
    public final TextView tvUserAgreementContent;

    private ViewLoginRegisterBinding(ConstraintLayout constraintLayout, Button button, CheckBox checkBox, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btnRegister = button;
        this.checkbox = checkBox;
        this.clBottom = constraintLayout2;
        this.clContent = constraintLayout3;
        this.editRegisterPassword = editText;
        this.editRegisterUsername = editText2;
        this.tvChooseCountry = textView;
        this.tvCodeTitle = textView2;
        this.tvEmailErrorTips = textView3;
        this.tvLogin = textView4;
        this.tvLogo = textView5;
        this.tvPasswordErrorTips = textView6;
        this.tvUserAgreementContent = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLoginRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLoginRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_login_register, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLoginRegisterBinding bind(View view) {
        int i = C2640R.id.btn_register;
        Button button = (Button) view.findViewById(C2640R.id.btn_register);
        if (button != null) {
            i = C2640R.id.checkbox;
            CheckBox checkBox = (CheckBox) view.findViewById(C2640R.id.checkbox);
            if (checkBox != null) {
                i = C2640R.id.cl_bottom;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C2640R.id.cl_bottom);
                if (constraintLayout != null) {
                    i = C2640R.id.cl_content;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C2640R.id.cl_content);
                    if (constraintLayout2 != null) {
                        i = C2640R.id.edit_register_password;
                        EditText editText = (EditText) view.findViewById(C2640R.id.edit_register_password);
                        if (editText != null) {
                            i = C2640R.id.edit_register_username;
                            EditText editText2 = (EditText) view.findViewById(C2640R.id.edit_register_username);
                            if (editText2 != null) {
                                i = C2640R.id.tv_choose_country;
                                TextView textView = (TextView) view.findViewById(C2640R.id.tv_choose_country);
                                if (textView != null) {
                                    i = C2640R.id.tv_code_title;
                                    TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_code_title);
                                    if (textView2 != null) {
                                        i = C2640R.id.tv_email_error_tips;
                                        TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_email_error_tips);
                                        if (textView3 != null) {
                                            i = C2640R.id.tv_login;
                                            TextView textView4 = (TextView) view.findViewById(C2640R.id.tv_login);
                                            if (textView4 != null) {
                                                i = C2640R.id.tv_logo;
                                                TextView textView5 = (TextView) view.findViewById(C2640R.id.tv_logo);
                                                if (textView5 != null) {
                                                    i = C2640R.id.tv_password_error_tips;
                                                    TextView textView6 = (TextView) view.findViewById(C2640R.id.tv_password_error_tips);
                                                    if (textView6 != null) {
                                                        i = C2640R.id.tv_user_agreement_content;
                                                        TextView textView7 = (TextView) view.findViewById(C2640R.id.tv_user_agreement_content);
                                                        if (textView7 != null) {
                                                            return new ViewLoginRegisterBinding((ConstraintLayout) view, button, checkBox, constraintLayout, constraintLayout2, editText, editText2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}