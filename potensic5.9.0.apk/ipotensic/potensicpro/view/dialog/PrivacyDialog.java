package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.UserPrivacyActivity;
import com.ipotensic.potensicpro.activities.UserProtocolActivity;

/* loaded from: classes2.dex */
public class PrivacyDialog extends BaseSyncDialog {
    private OnAgreeListener permissionListener;

    public interface OnAgreeListener {
        void onAgree();

        void onDisagree();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public PrivacyDialog(final Context context, OnAgreeListener onAgreeListener) {
        super(context, R.layout.view_dialog_privacy_portrait);
        this.permissionListener = onAgreeListener;
        try {
            TextView textView = (TextView) findViewById(R.id.tv_content);
            String string = context.getResources().getString(R.string.welcome_to_potensicpro_text);
            int indexOf = string.indexOf("\u300a");
            int lastIndexOf = string.lastIndexOf("\u300a");
            int indexOf2 = string.indexOf("\u300b");
            int lastIndexOf2 = string.lastIndexOf("\u300b");
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.ipotensic.potensicpro.view.dialog.PrivacyDialog.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    context.startActivity(new Intent(context, (Class<?>) UserProtocolActivity.class));
                }
            };
            ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.ipotensic.potensicpro.view.dialog.PrivacyDialog.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    context.startActivity(new Intent(context, (Class<?>) UserPrivacyActivity.class));
                }
            };
            SpannableString spannableString = new SpannableString(string);
            int i = indexOf2 + 1;
            spannableString.setSpan(new ForegroundColorSpan(-16776961), indexOf, i, 33);
            int i2 = lastIndexOf2 + 1;
            spannableString.setSpan(new ForegroundColorSpan(-16776961), lastIndexOf, i2, 33);
            spannableString.setSpan(clickableSpan, indexOf, i, 33);
            spannableString.setSpan(clickableSpan2, lastIndexOf, i2, 33);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableString);
        } catch (Exception unused) {
        }
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.PrivacyDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PrivacyDialog.this.permissionListener != null) {
                    PrivacyDialog.this.permissionListener.onAgree();
                }
                PrivacyDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.PrivacyDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PrivacyDialog.this.permissionListener != null) {
                    PrivacyDialog.this.permissionListener.onDisagree();
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            if (getContext().getResources().getConfiguration().orientation == 2) {
                attributes.width = -2;
                attributes.height = (int) (ScreenUtils.getScreenHeight(getContext()) * 0.8d);
            } else {
                attributes.width = (int) (ScreenUtils.getScreenWidth(getContext()) * 0.83d);
                attributes.height = -2;
            }
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }
}