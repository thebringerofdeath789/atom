package org.apache.poi.xslf.model.geom;

import java.awt.geom.GeneralPath;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;

/* loaded from: classes5.dex */
public class MoveToCommand implements PathCommand {
    private String arg1;
    private String arg2;

    MoveToCommand(CTAdjPoint2D cTAdjPoint2D) {
        this.arg1 = cTAdjPoint2D.getX().toString();
        this.arg2 = cTAdjPoint2D.getY().toString();
    }

    MoveToCommand(String str, String str2) {
        this.arg1 = str;
        this.arg2 = str2;
    }

    @Override // org.apache.poi.xslf.model.geom.PathCommand
    public void execute(GeneralPath generalPath, Context context) {
        generalPath.moveTo((float) context.getValue(this.arg1), (float) context.getValue(this.arg2));
    }
}
