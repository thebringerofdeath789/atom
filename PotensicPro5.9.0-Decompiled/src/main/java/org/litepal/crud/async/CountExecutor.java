package org.litepal.crud.async;

import org.litepal.crud.callback.CountCallback;

/* loaded from: classes5.dex */
public class CountExecutor extends AsyncExecutor {
    private CountCallback cb;

    public void listen(CountCallback countCallback) {
        this.cb = countCallback;
        execute();
    }

    public CountCallback getListener() {
        return this.cb;
    }
}
