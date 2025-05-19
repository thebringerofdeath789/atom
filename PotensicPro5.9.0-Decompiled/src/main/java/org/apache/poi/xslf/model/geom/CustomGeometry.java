package org.apache.poi.xslf.model.geom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* loaded from: classes5.dex */
public class CustomGeometry implements Iterable<Path> {
    List<Guide> adjusts = new ArrayList();
    List<Guide> guides = new ArrayList();
    List<Path> paths = new ArrayList();
    Path textBounds;

    public CustomGeometry(CTCustomGeometry2D cTCustomGeometry2D) {
        CTGeomGuideList avLst = cTCustomGeometry2D.getAvLst();
        if (avLst != null) {
            for (CTGeomGuide cTGeomGuide : avLst.getGdArray()) {
                this.adjusts.add(new AdjustValue(cTGeomGuide));
            }
        }
        CTGeomGuideList gdLst = cTCustomGeometry2D.getGdLst();
        if (gdLst != null) {
            for (CTGeomGuide cTGeomGuide2 : gdLst.getGdArray()) {
                this.guides.add(new Guide(cTGeomGuide2));
            }
        }
        CTPath2DList pathLst = cTCustomGeometry2D.getPathLst();
        if (pathLst != null) {
            for (CTPath2D cTPath2D : pathLst.getPathArray()) {
                this.paths.add(new Path(cTPath2D));
            }
        }
        if (cTCustomGeometry2D.isSetRect()) {
            CTGeomRect rect = cTCustomGeometry2D.getRect();
            Path path = new Path();
            this.textBounds = path;
            path.addCommand(new MoveToCommand(rect.getL().toString(), rect.getT().toString()));
            this.textBounds.addCommand(new LineToCommand(rect.getR().toString(), rect.getT().toString()));
            this.textBounds.addCommand(new LineToCommand(rect.getR().toString(), rect.getB().toString()));
            this.textBounds.addCommand(new LineToCommand(rect.getL().toString(), rect.getB().toString()));
            this.textBounds.addCommand(new ClosePathCommand());
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Path> iterator() {
        return this.paths.iterator();
    }

    public Path getTextBounds() {
        return this.textBounds;
    }
}
