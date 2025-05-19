package com.kk.taurus.threadpool;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class CancelableCountDownLatch extends CountDownLatch {
    public CancelableCountDownLatch(int i) {
        super(i);
    }

    public void cancel() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
