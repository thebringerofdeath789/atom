package org.dom4j.io;

import org.dom4j.ElementPath;

/* loaded from: classes5.dex */
class PruningDispatchHandler extends DispatchHandler {
    PruningDispatchHandler() {
    }

    @Override // org.dom4j.io.DispatchHandler, org.dom4j.ElementHandler
    public void onEnd(ElementPath elementPath) {
        super.onEnd(elementPath);
        if (getActiveHandlerCount() == 0) {
            elementPath.getCurrent().detach();
        }
    }
}
