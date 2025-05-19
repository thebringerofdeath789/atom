package com.ipotensic.baselib.base;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.ipotensic.baselib.R;

/* loaded from: classes2.dex */
public abstract class BaseDialog extends Dialog {
    protected final int MATCH_PARENT;
    protected final int WRAP_CONTENT;
    private Context context;
    private boolean controlWindow;

    protected abstract void initView(Context context);

    public BaseDialog(Context context, int i) {
        super(context, R.style.CustomDialog);
        this.MATCH_PARENT = -1;
        this.WRAP_CONTENT = -2;
        this.controlWindow = true;
        this.context = context;
        init(context, i);
    }

    public BaseDialog(Context context, int i, int i2) {
        super(context, i2);
        this.MATCH_PARENT = -1;
        this.WRAP_CONTENT = -2;
        this.controlWindow = true;
        this.context = context;
        init(context, i);
    }

    private void init(Context context, int i) {
        setContentView(i);
        initView(context);
    }

    protected void setSize(int i, int i2) {
        getWindow().setLayout(i, i2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.controlWindow) {
            Window window = getWindow();
            focusNotAle(window);
            super.show();
            hideNavigationBar(window);
            clearFocusNotAle(window);
            return;
        }
        super.show();
    }

    protected void controlWindow(boolean z) {
        this.controlWindow = z;
    }

    public void hideNavigationBar(final Window window) {
        window.getDecorView().setSystemUiVisibility(2);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.ipotensic.baselib.base.-$$Lambda$BaseDialog$luDLjy-VmXZx3RP9WsNEa9PIjoQ
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    public void focusNotAle(Window window) {
        window.setFlags(8, 8);
    }

    public void clearFocusNotAle(Window window) {
        window.clearFlags(8);
    }
}
