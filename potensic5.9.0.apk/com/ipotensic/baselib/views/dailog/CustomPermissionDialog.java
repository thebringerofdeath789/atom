package com.ipotensic.baselib.views.dailog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.ipotensic.baselib.C1819R;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;

/* loaded from: classes2.dex */
public class CustomPermissionDialog extends BaseSyncDialog {
    private Context context;
    private RequestPermissionListener permissionListener;
    private String title;

    public interface RequestPermissionListener {
        void grantPermission();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public CustomPermissionDialog(Context context, String str, String str2, String str3, String str4, RequestPermissionListener requestPermissionListener) {
        super(context, context.getResources().getConfiguration().orientation == 2 ? C1819R.layout.view_dialog_permission_landscape : C1819R.layout.view_dialog_permission_portrait);
        this.permissionListener = requestPermissionListener;
        this.context = context;
        setSize();
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(C1819R.id.tv_head);
        TextView textView2 = (TextView) findViewById(C1819R.id.tv_code_title);
        Button button = (Button) findViewById(C1819R.id.btn_cancel);
        Button button2 = (Button) findViewById(C1819R.id.btn_confirm);
        if (str != null) {
            textView.setText(str);
            textView.setVisibility(0);
        }
        textView2.setText(str2);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.CustomPermissionDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomPermissionDialog.this.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.CustomPermissionDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CustomPermissionDialog.this.permissionListener != null) {
                    CustomPermissionDialog.this.permissionListener.grantPermission();
                }
                CustomPermissionDialog.this.dismiss();
            }
        });
    }

    public CustomPermissionDialog(Context context, String str, RequestPermissionListener requestPermissionListener) {
        super(context, context.getResources().getConfiguration().orientation == 2 ? C1819R.layout.view_dialog_permission_landscape : C1819R.layout.view_dialog_permission_portrait);
        this.title = str;
        this.permissionListener = requestPermissionListener;
        this.context = context;
        setSize();
        setCanceledOnTouchOutside(false);
        ((TextView) findViewById(C1819R.id.tv_code_title)).setText(str);
        findViewById(C1819R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.CustomPermissionDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CustomPermissionDialog.this.permissionListener != null) {
                    CustomPermissionDialog.this.permissionListener.grantPermission();
                }
                CustomPermissionDialog.this.dismiss();
            }
        });
        findViewById(C1819R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.CustomPermissionDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomPermissionDialog.this.dismiss();
            }
        });
    }

    private void setSize() {
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        if (this.context.getResources().getConfiguration().orientation == 2) {
            setSize((screenWidth * 5) / 10, -2);
        } else {
            controlWindow(false);
            setSize((screenWidth * 9) / 10, -2);
        }
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