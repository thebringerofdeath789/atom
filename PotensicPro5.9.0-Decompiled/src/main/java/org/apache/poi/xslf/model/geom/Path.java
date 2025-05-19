package org.apache.poi.xslf.model.geom;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;

/* loaded from: classes5.dex */
public class Path {
    boolean _fill;
    long _h;
    boolean _stroke;
    long _w;
    private final List<PathCommand> commands;

    public Path() {
        this(true, true);
    }

    public Path(boolean z, boolean z2) {
        this.commands = new ArrayList();
        this._w = -1L;
        this._h = -1L;
        this._fill = z;
        this._stroke = z2;
    }

    public Path(CTPath2D cTPath2D) {
        this._fill = cTPath2D.getFill() != STPathFillMode.NONE;
        this._stroke = cTPath2D.getStroke();
        this._w = cTPath2D.isSetW() ? cTPath2D.getW() : -1L;
        this._h = cTPath2D.isSetH() ? cTPath2D.getH() : -1L;
        this.commands = new ArrayList();
        for (XmlObject xmlObject : cTPath2D.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            if (xmlObject instanceof CTPath2DMoveTo) {
                this.commands.add(new MoveToCommand(((CTPath2DMoveTo) xmlObject).getPt()));
            } else if (xmlObject instanceof CTPath2DLineTo) {
                this.commands.add(new LineToCommand(((CTPath2DLineTo) xmlObject).getPt()));
            } else if (xmlObject instanceof CTPath2DArcTo) {
                this.commands.add(new ArcToCommand((CTPath2DArcTo) xmlObject));
            } else if (xmlObject instanceof CTPath2DQuadBezierTo) {
                CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) xmlObject;
                this.commands.add(new QuadToCommand(cTPath2DQuadBezierTo.getPtArray(0), cTPath2DQuadBezierTo.getPtArray(1)));
            } else if (xmlObject instanceof CTPath2DCubicBezierTo) {
                CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) xmlObject;
                this.commands.add(new CurveToCommand(cTPath2DCubicBezierTo.getPtArray(0), cTPath2DCubicBezierTo.getPtArray(1), cTPath2DCubicBezierTo.getPtArray(2)));
            } else if (xmlObject instanceof CTPath2DClose) {
                this.commands.add(new ClosePathCommand());
            } else {
                throw new IllegalStateException("Unsupported path segment: " + xmlObject);
            }
        }
    }

    public void addCommand(PathCommand pathCommand) {
        this.commands.add(pathCommand);
    }

    public GeneralPath getPath(Context context) {
        GeneralPath generalPath = new GeneralPath();
        Iterator<PathCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            it.next().execute(generalPath, context);
        }
        return generalPath;
    }

    public boolean isStroked() {
        return this._stroke;
    }

    public boolean isFilled() {
        return this._fill;
    }

    public long getW() {
        return this._w;
    }

    public long getH() {
        return this._h;
    }
}
