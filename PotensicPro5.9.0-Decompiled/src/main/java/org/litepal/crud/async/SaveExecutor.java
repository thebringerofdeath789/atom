package org.litepal.crud.async;

import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes5.dex */
public class SaveExecutor extends AsyncExecutor {
    private SaveCallback cb;

    public void listen(SaveCallback saveCallback) {
        this.cb = saveCallback;
        execute();
    }

    public SaveCallback getListener() {
        return this.cb;
    }
}
