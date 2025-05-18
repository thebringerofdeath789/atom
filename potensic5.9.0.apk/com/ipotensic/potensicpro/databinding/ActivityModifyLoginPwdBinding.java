package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ActivityModifyLoginPwdBinding implements ViewBinding {
    public final Button btnConfirm;
    public final ImageButton btnReturn;
    public final EditText etConfirmNewPwd;
    public final EditText etNewPwd;
    public final EditText etOldPwd;
    private final ConstraintLayout rootView;
    public final TextView tvPwdErrorTips1;
    public final TextView tvPwdErrorTips2;
    public final TextView tvPwdErrorTips3;

    private ActivityModifyLoginPwdBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, EditText editText, EditText editText2, EditText editText3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnConfirm = button;
        this.btnReturn = imageButton;
        this.etConfirmNewPwd = editText;
        this.etNewPwd = editText2;
        this.etOldPwd = editText3;
        this.tvPwdErrorTips1 = textView;
        this.tvPwdErrorTips2 = textView2;
        this.tvPwdErrorTips3 = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityModifyLoginPwdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityModifyLoginPwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_modify_login_pwd, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityModifyLoginPwdBinding bind(View view) {
        int i = C2640R.id.btn_confirm;
        Button button = (Button) view.findViewById(C2640R.id.btn_confirm);
        if (button != null) {
            i = C2640R.id.btn_return;
            ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_return);
            if (imageButton != null) {
                i = C2640R.id.et_confirm_new_pwd;
                EditText editText = (EditText) view.findViewById(C2640R.id.et_confirm_new_pwd);
                if (editText != null) {
                    i = C2640R.id.et_new_pwd;
                    EditText editText2 = (EditText) view.findViewById(C2640R.id.et_new_pwd);
                    if (editText2 != null) {
                        i = C2640R.id.et_old_pwd;
                        EditText editText3 = (EditText) view.findViewById(C2640R.id.et_old_pwd);
                        if (editText3 != null) {
                            i = C2640R.id.tv_pwd_error_tips_1;
                            TextView textView = (TextView) view.findViewById(C2640R.id.tv_pwd_error_tips_1);
                            if (textView != null) {
                                i = C2640R.id.tv_pwd_error_tips_2;
                                TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_pwd_error_tips_2);
                                if (textView2 != null) {
                                    i = C2640R.id.tv_pwd_error_tips_3;
                                    TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_pwd_error_tips_3);
                                    if (textView3 != null) {
                                        return new ActivityModifyLoginPwdBinding((ConstraintLayout) view, button, imageButton, editText, editText2, editText3, textView, textView2, textView3);
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