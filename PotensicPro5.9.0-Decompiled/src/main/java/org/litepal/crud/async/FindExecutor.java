package org.litepal.crud.async;

import org.litepal.crud.callback.FindCallback;

/* loaded from: classes5.dex */
public class FindExecutor extends AsyncExecutor {
    private FindCallback cb;

    public void listen(FindCallback findCallback) {
        this.cb = findCallback;
        execute();
    }

    public FindCallback getListener() {
        return this.cb;
    }
}
