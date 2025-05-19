package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;

/* loaded from: classes5.dex */
public class XSLFShadow extends XSLFSimpleShape {
    private XSLFSimpleShape _parent;

    XSLFShadow(CTOuterShadowEffect cTOuterShadowEffect, XSLFSimpleShape xSLFSimpleShape) {
        super(cTOuterShadowEffect, xSLFSimpleShape.getSheet());
        this._parent = xSLFSimpleShape;
    }

    public void fill(Graphics2D graphics2D, Shape shape) {
        double rotation = this._parent.getRotation();
        if (this._parent.getFlipVertical()) {
            rotation += 180.0d;
        }
        double angle = getAngle() - rotation;
        double distance = getDistance();
        double cos = Math.cos(Math.toRadians(angle)) * distance;
        double sin = distance * Math.sin(Math.toRadians(angle));
        graphics2D.translate(cos, sin);
        Color fillColor = getFillColor();
        if (fillColor != null) {
            graphics2D.setColor(fillColor);
            graphics2D.fill(shape);
        }
        graphics2D.translate(-cos, -sin);
    }

    public void draw(Graphics2D graphics2D, Shape shape) {
        double angle = getAngle();
        double distance = getDistance();
        double cos = Math.cos(Math.toRadians(angle)) * distance;
        double sin = distance * Math.sin(Math.toRadians(angle));
        graphics2D.translate(cos, sin);
        Color fillColor = getFillColor();
        if (fillColor != null) {
            graphics2D.setColor(fillColor);
            graphics2D.draw(shape);
        }
        graphics2D.translate(-cos, -sin);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public Rectangle2D getAnchor() {
        return this._parent.getAnchor();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public void setAnchor(Rectangle2D rectangle2D) {
        throw new IllegalStateException("You can't set anchor of a shadow");
    }

    public double getDistance() {
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect.isSetDist()) {
            return Units.toPoints(cTOuterShadowEffect.getDist());
        }
        return 0.0d;
    }

    public double getAngle() {
        if (((CTOuterShadowEffect) getXmlObject()).isSetDir()) {
            return r0.getDir() / 60000.0d;
        }
        return 0.0d;
    }

    public double getBlur() {
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect.isSetBlurRad()) {
            return Units.toPoints(cTOuterShadowEffect.getBlurRad());
        }
        return 0.0d;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public Color getFillColor() {
        XSLFTheme theme = getSheet().getTheme();
        CTOuterShadowEffect cTOuterShadowEffect = (CTOuterShadowEffect) getXmlObject();
        if (cTOuterShadowEffect == null) {
            return null;
        }
        return new XSLFColor(cTOuterShadowEffect, theme, cTOuterShadowEffect.getSchemeClr()).getColor();
    }
}
