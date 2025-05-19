package org.apache.poi.xslf.usermodel;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* loaded from: classes5.dex */
public class XSLFFreeformShape extends XSLFAutoShape {
    XSLFFreeformShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    public int setPath(GeneralPath generalPath) {
        CTPath2D newInstance = CTPath2D.Factory.newInstance();
        Rectangle2D bounds2D = generalPath.getBounds2D();
        int emu = Units.toEMU(bounds2D.getX());
        int emu2 = Units.toEMU(bounds2D.getY());
        PathIterator pathIterator = generalPath.getPathIterator(new AffineTransform());
        newInstance.setH(Units.toEMU(bounds2D.getHeight()));
        newInstance.setW(Units.toEMU(bounds2D.getWidth()));
        int i = 0;
        while (!pathIterator.isDone()) {
            double[] dArr = new double[6];
            int currentSegment = pathIterator.currentSegment(dArr);
            if (currentSegment == 0) {
                CTAdjPoint2D addNewPt = newInstance.addNewMoveTo().addNewPt();
                addNewPt.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                addNewPt.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
            } else if (currentSegment == 1) {
                CTAdjPoint2D addNewPt2 = newInstance.addNewLnTo().addNewPt();
                addNewPt2.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                addNewPt2.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
            } else {
                if (currentSegment == 3) {
                    CTPath2DCubicBezierTo addNewCubicBezTo = newInstance.addNewCubicBezTo();
                    CTAdjPoint2D addNewPt3 = addNewCubicBezTo.addNewPt();
                    addNewPt3.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    addNewPt3.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                    CTAdjPoint2D addNewPt4 = addNewCubicBezTo.addNewPt();
                    addNewPt4.setX(Integer.valueOf(Units.toEMU(dArr[2]) - emu));
                    addNewPt4.setY(Integer.valueOf(Units.toEMU(dArr[3]) - emu2));
                    CTAdjPoint2D addNewPt5 = addNewCubicBezTo.addNewPt();
                    addNewPt5.setX(Integer.valueOf(Units.toEMU(dArr[4]) - emu));
                    addNewPt5.setY(Integer.valueOf(Units.toEMU(dArr[5]) - emu2));
                    i += 3;
                } else if (currentSegment == 4) {
                    i++;
                    newInstance.addNewClose();
                }
                pathIterator.next();
            }
            i++;
            pathIterator.next();
        }
        getSpPr().getCustGeom().getPathLst().setPathArray(new CTPath2D[]{newInstance});
        setAnchor(bounds2D);
        return i;
    }

    public GeneralPath getPath() {
        int i;
        XmlObject[] xmlObjectArr;
        int i2;
        int i3;
        GeneralPath generalPath = new GeneralPath();
        Rectangle2D anchor = getAnchor();
        CTPath2D[] pathArray = getSpPr().getCustGeom().getPathLst().getPathArray();
        int length = pathArray.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            CTPath2D cTPath2D = pathArray[i5];
            double width = anchor.getWidth() / Units.toPoints(cTPath2D.getW());
            double height = anchor.getHeight() / Units.toPoints(cTPath2D.getH());
            XmlObject[] selectPath = cTPath2D.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
            int length2 = selectPath.length;
            int i6 = i4;
            while (i6 < length2) {
                XmlObject xmlObject = selectPath[i6];
                if (xmlObject instanceof CTPath2DMoveTo) {
                    CTAdjPoint2D pt = ((CTPath2DMoveTo) xmlObject).getPt();
                    generalPath.moveTo((float) (Units.toPoints(((Long) pt.getX()).longValue()) * width), (float) (Units.toPoints(((Long) pt.getY()).longValue()) * height));
                } else if (xmlObject instanceof CTPath2DLineTo) {
                    CTAdjPoint2D pt2 = ((CTPath2DLineTo) xmlObject).getPt();
                    generalPath.lineTo((float) Units.toPoints(((Long) pt2.getX()).longValue()), (float) Units.toPoints(((Long) pt2.getY()).longValue()));
                } else {
                    if (xmlObject instanceof CTPath2DCubicBezierTo) {
                        CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) xmlObject;
                        CTAdjPoint2D ptArray = cTPath2DCubicBezierTo.getPtArray(i4);
                        CTAdjPoint2D ptArray2 = cTPath2DCubicBezierTo.getPtArray(1);
                        CTAdjPoint2D ptArray3 = cTPath2DCubicBezierTo.getPtArray(2);
                        i2 = i5;
                        i3 = length2;
                        i = i6;
                        xmlObjectArr = selectPath;
                        generalPath.curveTo((float) (Units.toPoints(((Long) ptArray.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray2.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray2.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray3.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray3.getY()).longValue()) * height));
                    } else {
                        i = i6;
                        xmlObjectArr = selectPath;
                        i2 = i5;
                        i3 = length2;
                        if (xmlObject instanceof CTPath2DClose) {
                            generalPath.closePath();
                        }
                    }
                    i6 = i + 1;
                    length2 = i3;
                    selectPath = xmlObjectArr;
                    i5 = i2;
                    i4 = 0;
                }
                i = i6;
                xmlObjectArr = selectPath;
                i2 = i5;
                i3 = length2;
                i6 = i + 1;
                length2 = i3;
                selectPath = xmlObjectArr;
                i5 = i2;
                i4 = 0;
            }
            i5++;
            i4 = 0;
        }
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(anchor.getX(), anchor.getY());
        return new GeneralPath(affineTransform.createTransformedShape(generalPath));
    }

    static CTShape prototype(int i) {
        CTShape newInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual addNewNvSpPr = newInstance.addNewNvSpPr();
        CTNonVisualDrawingProps addNewCNvPr = addNewNvSpPr.addNewCNvPr();
        addNewCNvPr.setName("Freeform " + i);
        addNewCNvPr.setId(i + 1);
        addNewNvSpPr.addNewCNvSpPr();
        addNewNvSpPr.addNewNvPr();
        CTCustomGeometry2D addNewCustGeom = newInstance.addNewSpPr().addNewCustGeom();
        addNewCustGeom.addNewAvLst();
        addNewCustGeom.addNewGdLst();
        addNewCustGeom.addNewAhLst();
        addNewCustGeom.addNewCxnLst();
        CTGeomRect addNewRect = addNewCustGeom.addNewRect();
        addNewRect.setR(InternalZipConstants.READ_MODE);
        addNewRect.setB("b");
        addNewRect.setT("t");
        addNewRect.setL("l");
        addNewCustGeom.addNewPathLst();
        return newInstance;
    }
}
