package org.litepal.crud.async;

import org.litepal.crud.callback.UpdateOrDeleteCallback;

/* loaded from: classes5.dex */
public class UpdateOrDeleteExecutor extends AsyncExecutor {
    private UpdateOrDeleteCallback cb;

    public void listen(UpdateOrDeleteCallback updateOrDeleteCallback) {
        this.cb = updateOrDeleteCallback;
        execute();
    }

    public UpdateOrDeleteCallback getListener() {
        return this.cb;
    }
}
