package org.apache.poi.xslf.model.geom;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;

/* loaded from: classes5.dex */
public class ArcToCommand implements PathCommand {
    private String hr;
    private String stAng;
    private String swAng;
    private String wr;

    ArcToCommand(CTPath2DArcTo cTPath2DArcTo) {
        this.hr = cTPath2DArcTo.getHR().toString();
        this.wr = cTPath2DArcTo.getWR().toString();
        this.stAng = cTPath2DArcTo.getStAng().toString();
        this.swAng = cTPath2DArcTo.getSwAng().toString();
    }

    @Override // org.apache.poi.xslf.model.geom.PathCommand
    public void execute(GeneralPath generalPath, Context context) {
        double value = context.getValue(this.wr);
        double value2 = context.getValue(this.hr);
        double value3 = context.getValue(this.stAng) / 60000.0d;
        double value4 = context.getValue(this.swAng) / 60000.0d;
        Point2D currentPoint = generalPath.getCurrentPoint();
        generalPath.append(new Arc2D.Double((currentPoint.getX() - value) - (Math.cos(Math.toRadians(value3)) * value), (currentPoint.getY() - value2) - (Math.sin(Math.toRadians(value3)) * value2), value * 2.0d, value2 * 2.0d, -value3, -value4, 0), true);
    }
}
