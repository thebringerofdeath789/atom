package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public class VersionUpdateDialog extends BaseSyncDialog implements View.OnClickListener {
    private Button btnCancel;
    private Button btnOk;
    private Button btnUpdate;
    private OnItemClickListener listener;
    private LinearLayout llBottom;
    private ScrollView svContent;
    private TextView tvContent;
    private TextView tvVersion;
    private String[] updateContent;

    public interface OnItemClickListener {
        void cancel();

        void toUpdate();
    }

    public VersionUpdateDialog(Context context, String str, String str2, int i, OnItemClickListener onItemClickListener) {
        super(context, C2640R.layout.view_dialog_app_update);
        this.listener = onItemClickListener;
        if (i == 0) {
            this.llBottom.setVisibility(8);
            this.btnOk.setVisibility(0);
            this.tvContent.setVisibility(0);
            this.tvContent.setText(context.getString(C2640R.string.update_version_too_low));
            this.tvVersion.setText(context.getString(C2640R.string.update_app));
            this.svContent.setVisibility(0);
        } else {
            this.llBottom.setVisibility(0);
            this.btnOk.setVisibility(8);
            this.tvContent.setVisibility(0);
            this.svContent.setVisibility(0);
            this.tvVersion.setText(String.format("%s %s%s", context.getString(C2640R.string.update_find_new_version), "V", str));
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.updateContent = str2.split("\n");
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.updateContent;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < this.updateContent.length && i2 < 5; i2++) {
                sb.append(this.updateContent[i2] + "\n");
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        this.tvContent.append("\n" + sb2);
        DDLog.m1684e("content1111:" + this.tvContent.getText().toString());
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.tvContent = (TextView) findViewById(C2640R.id.tv_content);
        this.tvVersion = (TextView) findViewById(C2640R.id.tv_version);
        this.llBottom = (LinearLayout) findViewById(C2640R.id.ll_bottom);
        this.svContent = (ScrollView) findViewById(C2640R.id.sv_content);
        this.btnCancel = (Button) findViewById(C2640R.id.btn_cancel);
        this.btnUpdate = (Button) findViewById(C2640R.id.btn_update);
        this.btnOk = (Button) findViewById(C2640R.id.btn_ok);
        this.btnCancel.setOnClickListener(this);
        this.btnUpdate.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2640R.id.btn_ok) {
            dismiss();
            OnItemClickListener onItemClickListener = this.listener;
            if (onItemClickListener != null) {
                onItemClickListener.toUpdate();
                return;
            }
            return;
        }
        if (id == C2640R.id.btn_cancel) {
            dismiss();
            OnItemClickListener onItemClickListener2 = this.listener;
            if (onItemClickListener2 != null) {
                onItemClickListener2.cancel();
                return;
            }
            return;
        }
        if (id == C2640R.id.btn_update) {
            dismiss();
            OnItemClickListener onItemClickListener3 = this.listener;
            if (onItemClickListener3 != null) {
                onItemClickListener3.toUpdate();
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        setCanceledOnTouchOutside(false);
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenHeight(getContext()) * 0.8d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.8d), -2);
        }
    }
}