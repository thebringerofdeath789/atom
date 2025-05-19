package com.ipotensic.potensicpro.utils;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FastClickListener implements View.OnClickListener {
    private List<Long> timeList = new ArrayList();

    public abstract void fastClicked();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.timeList.size() >= 2) {
            if (isAllowed()) {
                fastClicked();
            }
            this.timeList.clear();
            return;
        }
        this.timeList.add(Long.valueOf(System.currentTimeMillis()));
    }

    private boolean isAllowed() {
        int size = this.timeList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (i2 < size && this.timeList.get(i2).longValue() - this.timeList.get(i).longValue() > 1000) {
                return false;
            }
            i = i2;
        }
        return true;
    }
}
