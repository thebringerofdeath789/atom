package com.ipotensic.potensicpro.activities;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class LoginSendSuccessController extends BaseController {
    private OnSendSuccessListener sendSuccessListener;
    private TextView tvTitle;

    public interface OnSendSuccessListener {
        void onBackClicked();
    }

    public LoginSendSuccessController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.LoginSendSuccessController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                LoginSendSuccessController.this.sendSuccessListener.onBackClicked();
            }
        };
        view.findViewById(R.id.btn_return).setOnClickListener(onClickListener);
        view.findViewById(R.id.btn_back).setOnClickListener(onClickListener);
        this.tvTitle = (TextView) view.findViewById(R.id.tv_code_title);
    }

    public void setSuccessEmail(String str) {
        this.tvTitle.setText(String.format(getContext().getResources().getString(R.string.email_sent), str));
    }

    public void setOnSendSuccessListener(OnSendSuccessListener onSendSuccessListener) {
        this.sendSuccessListener = onSendSuccessListener;
    }
}