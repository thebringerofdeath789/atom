package com.ipotensic.baselib.listener;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MultiScaleClickListener implements View.OnClickListener {
    private final int ANIM_TIME = 150;
    private int VALID_TIME = 300;
    private List<ClickItem> clickItems = new ArrayList();

    public abstract void click(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        checkRemove();
        if (System.currentTimeMillis() - getFirstClickTime(view) > this.VALID_TIME) {
            click(view);
            view.animate().scaleX(0.9f).scaleY(0.9f).alpha(0.9f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.MultiScaleClickListener.1
                @Override // java.lang.Runnable
                public void run() {
                    view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.ipotensic.baselib.listener.MultiScaleClickListener.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.clearAnimation();
                        }
                    }).start();
                }
            }).start();
            addOnlyOne(view, System.currentTimeMillis());
        }
    }

    private long getFirstClickTime(View view) {
        for (ClickItem clickItem : this.clickItems) {
            if (view.getId() == clickItem.getId()) {
                return clickItem.getClickTime();
            }
        }
        return 0L;
    }

    private void addOnlyOne(View view, long j) {
        boolean z = false;
        for (ClickItem clickItem : this.clickItems) {
            if (view.getId() == clickItem.getId()) {
                clickItem.setClickTime(j);
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.clickItems.add(new ClickItem(view.getId(), j));
    }

    private void checkRemove() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<ClickItem> it = this.clickItems.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (currentTimeMillis - it.next().getClickTime() < this.VALID_TIME) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.clickItems.clear();
    }

    private class ClickItem {
        private long clickTime;
        private int id;

        public ClickItem(int i, long j) {
            this.id = i;
            this.clickTime = j;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public long getClickTime() {
            return this.clickTime;
        }

        public void setClickTime(long j) {
            this.clickTime = j;
        }
    }
}
