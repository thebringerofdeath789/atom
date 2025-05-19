package com.ipotensic.potensicpro.adapter;

import com.ipotensic.kernel.controllers.BaseController;

/* loaded from: classes2.dex */
public class MainPagerAdapter {
    private int pageNum;
    private BaseController[] pages;

    public MainPagerAdapter(BaseController... baseControllerArr) {
        this.pages = baseControllerArr;
        this.pageNum = baseControllerArr.length;
    }

    public void onTabChanged(int i) {
        for (int i2 = 0; i2 < this.pageNum; i2++) {
            BaseController baseController = this.pages[i2];
            if (i == i2) {
                baseController.setVisibility(0);
            } else {
                baseController.setVisibility(8);
            }
        }
    }
}
