package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public abstract class XSLFShape {
    public abstract void draw(Graphics2D graphics2D);

    public abstract Rectangle2D getAnchor();

    public abstract boolean getFlipHorizontal();

    public abstract boolean getFlipVertical();

    public abstract double getRotation();

    public abstract int getShapeId();

    public abstract String getShapeName();

    public abstract XmlObject getXmlObject();

    public abstract void setAnchor(Rectangle2D rectangle2D);

    public abstract void setFlipHorizontal(boolean z);

    public abstract void setFlipVertical(boolean z);

    public abstract void setRotation(double d);

    protected void applyTransform(Graphics2D graphics2D) {
        double d;
        double width;
        double height;
        Rectangle2D anchor = getAnchor();
        AffineTransform affineTransform = (AffineTransform) graphics2D.getRenderingHint(XSLFRenderingHint.GROUP_TRANSFORM);
        if (affineTransform != null) {
            anchor = affineTransform.createTransformedShape(anchor).getBounds2D();
        }
        double rotation = getRotation();
        if (rotation != 0.0d) {
            double centerX = anchor.getCenterX();
            double centerY = anchor.getCenterY();
            double d2 = ((rotation % 360.0d) + 360.0d) % 360.0d;
            int i = ((((int) d2) + 45) / 90) % 4;
            if (i == 1 || i == 3) {
                AffineTransform affineTransform2 = new AffineTransform();
                AffineTransform affineTransform3 = new AffineTransform(affineTransform);
                affineTransform2.translate(centerX, centerY);
                affineTransform2.rotate(Math.toRadians(i * 90));
                double d3 = -centerX;
                double d4 = -centerY;
                affineTransform2.translate(d3, d4);
                affineTransform3.translate(centerX, centerY);
                d = d2;
                affineTransform3.rotate(Math.toRadians((-i) * 90));
                affineTransform3.translate(d3, d4);
                affineTransform2.concatenate(affineTransform3);
                Rectangle2D bounds2D = affineTransform2.createTransformedShape(getAnchor()).getBounds2D();
                width = anchor.getWidth() == 0.0d ? 1.0d : anchor.getWidth() / bounds2D.getWidth();
                if (anchor.getHeight() != 0.0d) {
                    height = anchor.getHeight() / bounds2D.getHeight();
                    graphics2D.translate(centerX, centerY);
                    double d5 = i * 90;
                    graphics2D.rotate(Math.toRadians(d - d5));
                    graphics2D.scale(width, height);
                    graphics2D.rotate(Math.toRadians(d5));
                    graphics2D.translate(-centerX, -centerY);
                }
            } else {
                d = d2;
                width = 1.0d;
            }
            height = 1.0d;
            graphics2D.translate(centerX, centerY);
            double d52 = i * 90;
            graphics2D.rotate(Math.toRadians(d - d52));
            graphics2D.scale(width, height);
            graphics2D.rotate(Math.toRadians(d52));
            graphics2D.translate(-centerX, -centerY);
        }
        if (getFlipHorizontal()) {
            graphics2D.translate(anchor.getX() + anchor.getWidth(), anchor.getY());
            graphics2D.scale(-1.0d, 1.0d);
            graphics2D.translate(-anchor.getX(), -anchor.getY());
        }
        if (getFlipVertical()) {
            graphics2D.translate(anchor.getX(), anchor.getY() + anchor.getHeight());
            graphics2D.scale(1.0d, -1.0d);
            graphics2D.translate(-anchor.getX(), -anchor.getY());
        }
    }

    @Internal
    void copy(XSLFShape xSLFShape) {
        if (!getClass().isInstance(xSLFShape)) {
            throw new IllegalArgumentException("Can't copy " + xSLFShape.getClass().getSimpleName() + " into " + getClass().getSimpleName());
        }
        setAnchor(xSLFShape.getAnchor());
    }
}
