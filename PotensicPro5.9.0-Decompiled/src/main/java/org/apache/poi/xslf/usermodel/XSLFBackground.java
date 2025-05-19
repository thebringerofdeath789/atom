package org.apache.poi.xslf.usermodel;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;

/* loaded from: classes5.dex */
public class XSLFBackground extends XSLFSimpleShape {
    XSLFBackground(CTBackground cTBackground, XSLFSheet xSLFSheet) {
        super(cTBackground, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public Rectangle2D getAnchor() {
        Dimension pageSize = getSheet().getSlideShow().getPageSize();
        return new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public void draw(Graphics2D graphics2D) {
        Rectangle2D anchor = getAnchor();
        Paint paint = getPaint(graphics2D);
        if (paint != null) {
            graphics2D.setPaint(paint);
            graphics2D.fill(anchor);
        }
    }

    Paint getPaint(Graphics2D graphics2D) {
        RenderableShape renderableShape = new RenderableShape(this);
        CTBackground cTBackground = (CTBackground) getXmlObject();
        if (cTBackground.isSetBgPr()) {
            return renderableShape.getPaint(graphics2D, cTBackground.getBgPr(), null);
        }
        if (!cTBackground.isSetBgRef()) {
            return null;
        }
        CTStyleMatrixReference bgRef = cTBackground.getBgRef();
        CTSchemeColor schemeClr = bgRef.getSchemeClr();
        int idx = ((int) bgRef.getIdx()) - 1001;
        XSLFTheme theme = getSheet().getTheme();
        return renderableShape.selectPaint(graphics2D, theme.getXmlObject().getThemeElements().getFmtScheme().getBgFillStyleLst().selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)[idx], schemeClr, theme.getPackagePart());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public Color getFillColor() {
        Color paint = getPaint(null);
        if (paint instanceof Color) {
            return paint;
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    CTTransform2D getXfrm() {
        return CTTransform2D.Factory.newInstance();
    }
}
