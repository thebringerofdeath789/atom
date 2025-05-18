package com.ipotensic.kernel.bean;

import android.view.View;

/* loaded from: classes2.dex */
public class ErrorBean {
    private int id;
    private View view;

    public ErrorBean(View view, int i) {
        this.view = view;
        this.id = i;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getId() {
        return this.id;
    }

    public boolean equals(int i) {
        return this.id == i;
    }
}