package org.apache.poi.xslf.model.geom;

import java.awt.geom.GeneralPath;

/* loaded from: classes5.dex */
public class ClosePathCommand implements PathCommand {
    ClosePathCommand() {
    }

    @Override // org.apache.poi.xslf.model.geom.PathCommand
    public void execute(GeneralPath generalPath, Context context) {
        generalPath.closePath();
    }
}
