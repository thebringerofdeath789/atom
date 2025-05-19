package org.apache.poi.xslf.model.geom;

import java.awt.geom.GeneralPath;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;

/* loaded from: classes5.dex */
public class CurveToCommand implements PathCommand {
    private String arg1;
    private String arg2;
    private String arg3;
    private String arg4;
    private String arg5;
    private String arg6;

    CurveToCommand(CTAdjPoint2D cTAdjPoint2D, CTAdjPoint2D cTAdjPoint2D2, CTAdjPoint2D cTAdjPoint2D3) {
        this.arg1 = cTAdjPoint2D.getX().toString();
        this.arg2 = cTAdjPoint2D.getY().toString();
        this.arg3 = cTAdjPoint2D2.getX().toString();
        this.arg4 = cTAdjPoint2D2.getY().toString();
        this.arg5 = cTAdjPoint2D3.getX().toString();
        this.arg6 = cTAdjPoint2D3.getY().toString();
    }

    @Override // org.apache.poi.xslf.model.geom.PathCommand
    public void execute(GeneralPath generalPath, Context context) {
        generalPath.curveTo((float) context.getValue(this.arg1), (float) context.getValue(this.arg2), (float) context.getValue(this.arg3), (float) context.getValue(this.arg4), (float) context.getValue(this.arg5), (float) context.getValue(this.arg6));
    }
}
