package org.apache.poi.xslf.usermodel;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.PropertyFetcher;
import org.apache.poi.xslf.model.geom.CustomGeometry;
import org.apache.poi.xslf.model.geom.Outline;
import org.apache.poi.xslf.model.geom.Path;
import org.apache.poi.xslf.model.geom.PresetGeometries;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes5.dex */
public abstract class XSLFSimpleShape extends XSLFShape {
    private static CTOuterShadowEffect NO_SHADOW = CTOuterShadowEffect.Factory.newInstance();
    private CTNonVisualDrawingProps _nvPr;
    private CTPlaceholder _ph;
    private final XmlObject _shape;
    private final XSLFSheet _sheet;
    private CTShapeProperties _spPr;
    private CTShapeStyle _spStyle;

    public void drawContent(Graphics2D graphics2D) {
    }

    XSLFSimpleShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        this._shape = xmlObject;
        this._sheet = xSLFSheet;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public XmlObject getXmlObject() {
        return this._shape;
    }

    public XSLFSheet getSheet() {
        return this._sheet;
    }

    public void setShapeType(XSLFShapeType xSLFShapeType) {
        CTShape cTShape = (CTShape) getXmlObject();
        cTShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(xSLFShapeType.getIndex()));
    }

    public XSLFShapeType getShapeType() {
        return XSLFShapeType.forInt(((CTShape) getXmlObject()).getSpPr().getPrstGeom().getPrst().intValue());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public String getShapeName() {
        return getNvPr().getName();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public int getShapeId() {
        return (int) getNvPr().getId();
    }

    protected CTNonVisualDrawingProps getNvPr() {
        if (this._nvPr == null) {
            XmlObject[] selectPath = this._shape.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr");
            if (selectPath.length != 0) {
                this._nvPr = (CTNonVisualDrawingProps) selectPath[0];
            }
        }
        return this._nvPr;
    }

    protected CTShapeProperties getSpPr() {
        if (this._spPr == null) {
            for (XmlObject xmlObject : this._shape.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                if (xmlObject instanceof CTShapeProperties) {
                    this._spPr = (CTShapeProperties) xmlObject;
                }
            }
        }
        CTShapeProperties cTShapeProperties = this._spPr;
        if (cTShapeProperties != null) {
            return cTShapeProperties;
        }
        throw new IllegalStateException("CTShapeProperties was not found.");
    }

    protected CTShapeStyle getSpStyle() {
        if (this._spStyle == null) {
            for (XmlObject xmlObject : this._shape.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                if (xmlObject instanceof CTShapeStyle) {
                    this._spStyle = (CTShapeStyle) xmlObject;
                }
            }
        }
        return this._spStyle;
    }

    protected CTPlaceholder getCTPlaceholder() {
        if (this._ph == null) {
            XmlObject[] selectPath = this._shape.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr/p:ph");
            if (selectPath.length == 1) {
                this._ph = (CTPlaceholder) selectPath[0];
            }
        }
        return this._ph;
    }

    CTTransform2D getXfrm() {
        PropertyFetcher<CTTransform2D> propertyFetcher = new PropertyFetcher<CTTransform2D>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.1
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTShapeProperties spPr = xSLFSimpleShape.getSpPr();
                if (!spPr.isSetXfrm()) {
                    return false;
                }
                setValue(spPr.getXfrm());
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        return propertyFetcher.getValue();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = getXfrm();
        CTPoint2D off = xfrm.getOff();
        long x = off.getX();
        long y = off.getY();
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(Units.toPoints(x), Units.toPoints(y), Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTShapeProperties spPr = getSpPr();
        CTTransform2D xfrm = spPr.isSetXfrm() ? spPr.getXfrm() : spPr.addNewXfrm();
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setRotation(double d) {
        CTShapeProperties spPr = getSpPr();
        (spPr.isSetXfrm() ? spPr.getXfrm() : spPr.addNewXfrm()).setRot((int) (d * 60000.0d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public double getRotation() {
        return getXfrm().getRot() / 60000.0d;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipHorizontal(boolean z) {
        CTShapeProperties spPr = getSpPr();
        (spPr.isSetXfrm() ? spPr.getXfrm() : spPr.addNewXfrm()).setFlipH(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void setFlipVertical(boolean z) {
        CTShapeProperties spPr = getSpPr();
        (spPr.isSetXfrm() ? spPr.getXfrm() : spPr.addNewXfrm()).setFlipV(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipHorizontal() {
        return getXfrm().getFlipH();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public boolean getFlipVertical() {
        return getXfrm().getFlipV();
    }

    CTLineProperties getDefaultLineProperties() {
        if (getSpStyle() == null) {
            return null;
        }
        return this._sheet.getTheme().getXmlObject().getThemeElements().getFmtScheme().getLnStyleLst().getLnArray(((int) r0.getLnRef().getIdx()) - 1);
    }

    public void setLineColor(Color color) {
        CTShapeProperties spPr = getSpPr();
        if (color == null) {
            if (spPr.isSetLn() && spPr.getLn().isSetSolidFill()) {
                spPr.getLn().unsetSolidFill();
                return;
            }
            return;
        }
        CTLineProperties ln = spPr.isSetLn() ? spPr.getLn() : spPr.addNewLn();
        CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
        newInstance.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
        CTSolidColorFillProperties solidFill = ln.isSetSolidFill() ? ln.getSolidFill() : ln.addNewSolidFill();
        solidFill.setSrgbClr(newInstance);
        if (solidFill.isSetHslClr()) {
            solidFill.unsetHslClr();
        }
        if (solidFill.isSetPrstClr()) {
            solidFill.unsetPrstClr();
        }
        if (solidFill.isSetSchemeClr()) {
            solidFill.unsetSchemeClr();
        }
        if (solidFill.isSetScrgbClr()) {
            solidFill.unsetScrgbClr();
        }
        if (solidFill.isSetSysClr()) {
            solidFill.unsetSysClr();
        }
    }

    public Color getLineColor() {
        Color linePaint = new RenderableShape(this).getLinePaint(null);
        if (linePaint instanceof Color) {
            return linePaint;
        }
        return null;
    }

    public void setLineWidth(double d) {
        CTShapeProperties spPr = getSpPr();
        if (d == 0.0d) {
            if (spPr.isSetLn() && spPr.getLn().isSetW()) {
                spPr.getLn().unsetW();
                return;
            }
            return;
        }
        (spPr.isSetLn() ? spPr.getLn() : spPr.addNewLn()).setW(Units.toEMU(d));
    }

    public double getLineWidth() {
        PropertyFetcher<Double> propertyFetcher = new PropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.2
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTLineProperties ln = xSLFSimpleShape.getSpPr().getLn();
                if (ln == null) {
                    return false;
                }
                if (ln.isSetNoFill()) {
                    setValue(Double.valueOf(0.0d));
                    return true;
                }
                if (!ln.isSetW()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(ln.getW())));
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        if (propertyFetcher.getValue() == null) {
            CTLineProperties defaultLineProperties = getDefaultLineProperties();
            if (defaultLineProperties == null || !defaultLineProperties.isSetW()) {
                return 0.0d;
            }
            return Units.toPoints(defaultLineProperties.getW());
        }
        return propertyFetcher.getValue().doubleValue();
    }

    public void setLineDash(LineDash lineDash) {
        CTShapeProperties spPr = getSpPr();
        if (lineDash == null) {
            if (spPr.isSetLn() && spPr.getLn().isSetPrstDash()) {
                spPr.getLn().unsetPrstDash();
                return;
            }
            return;
        }
        CTPresetLineDashProperties newInstance = CTPresetLineDashProperties.Factory.newInstance();
        newInstance.setVal(STPresetLineDashVal.Enum.forInt(lineDash.ordinal() + 1));
        (spPr.isSetLn() ? spPr.getLn() : spPr.addNewLn()).setPrstDash(newInstance);
    }

    public LineDash getLineDash() {
        CTLineProperties defaultLineProperties;
        CTPresetLineDashProperties prstDash;
        PropertyFetcher<LineDash> propertyFetcher = new PropertyFetcher<LineDash>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.3
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTPresetLineDashProperties prstDash2;
                CTLineProperties ln = xSLFSimpleShape.getSpPr().getLn();
                if (ln == null || (prstDash2 = ln.getPrstDash()) == null) {
                    return false;
                }
                setValue(LineDash.values()[prstDash2.getVal().intValue() - 1]);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        LineDash value = propertyFetcher.getValue();
        return (value != null || (defaultLineProperties = getDefaultLineProperties()) == null || (prstDash = defaultLineProperties.getPrstDash()) == null) ? value : LineDash.values()[prstDash.getVal().intValue() - 1];
    }

    public void setLineCap(LineCap lineCap) {
        CTShapeProperties spPr = getSpPr();
        if (lineCap == null) {
            if (spPr.isSetLn() && spPr.getLn().isSetCap()) {
                spPr.getLn().unsetCap();
                return;
            }
            return;
        }
        (spPr.isSetLn() ? spPr.getLn() : spPr.addNewLn()).setCap(STLineCap.Enum.forInt(lineCap.ordinal() + 1));
    }

    public LineCap getLineCap() {
        CTLineProperties defaultLineProperties;
        STLineCap.Enum cap;
        PropertyFetcher<LineCap> propertyFetcher = new PropertyFetcher<LineCap>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.4
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                STLineCap.Enum cap2;
                CTLineProperties ln = xSLFSimpleShape.getSpPr().getLn();
                if (ln == null || (cap2 = ln.getCap()) == null) {
                    return false;
                }
                setValue(LineCap.values()[cap2.intValue() - 1]);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        LineCap value = propertyFetcher.getValue();
        return (value != null || (defaultLineProperties = getDefaultLineProperties()) == null || (cap = defaultLineProperties.getCap()) == null) ? value : LineCap.values()[cap.intValue() - 1];
    }

    public void setFillColor(Color color) {
        CTShapeProperties spPr = getSpPr();
        if (color == null) {
            if (spPr.isSetSolidFill()) {
                spPr.unsetSolidFill();
            }
            if (spPr.isSetNoFill()) {
                return;
            }
            spPr.addNewNoFill();
            return;
        }
        if (spPr.isSetNoFill()) {
            spPr.unsetNoFill();
        }
        CTSolidColorFillProperties solidFill = spPr.isSetSolidFill() ? spPr.getSolidFill() : spPr.addNewSolidFill();
        CTSRgbColor newInstance = CTSRgbColor.Factory.newInstance();
        newInstance.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
        solidFill.setSrgbClr(newInstance);
        if (solidFill.isSetHslClr()) {
            solidFill.unsetHslClr();
        }
        if (solidFill.isSetPrstClr()) {
            solidFill.unsetPrstClr();
        }
        if (solidFill.isSetSchemeClr()) {
            solidFill.unsetSchemeClr();
        }
        if (solidFill.isSetScrgbClr()) {
            solidFill.unsetScrgbClr();
        }
        if (solidFill.isSetSysClr()) {
            solidFill.unsetSysClr();
        }
    }

    public Color getFillColor() {
        Color fillPaint = new RenderableShape(this).getFillPaint(null);
        if (fillPaint instanceof Color) {
            return fillPaint;
        }
        return null;
    }

    public XSLFShadow getShadow() {
        CTShapeStyle spStyle;
        int idx;
        PropertyFetcher<CTOuterShadowEffect> propertyFetcher = new PropertyFetcher<CTOuterShadowEffect>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.5
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFSimpleShape xSLFSimpleShape) {
                CTShapeProperties spPr = xSLFSimpleShape.getSpPr();
                if (!spPr.isSetEffectLst()) {
                    return false;
                }
                CTOuterShadowEffect outerShdw = spPr.getEffectLst().getOuterShdw();
                if (outerShdw == null) {
                    outerShdw = XSLFSimpleShape.NO_SHADOW;
                }
                setValue(outerShdw);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        CTOuterShadowEffect value = propertyFetcher.getValue();
        if (value == null && (spStyle = getSpStyle()) != null && (idx = (int) spStyle.getEffectRef().getIdx()) != 0) {
            value = this._sheet.getTheme().getXmlObject().getThemeElements().getFmtScheme().getEffectStyleLst().getEffectStyleArray(idx - 1).getEffectLst().getOuterShdw();
        }
        if (value == null || value == NO_SHADOW) {
            return null;
        }
        return new XSLFShadow(value, this);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void draw(Graphics2D graphics2D) {
        new RenderableShape(this).render(graphics2D);
        Color lineColor = getLineColor();
        if (lineColor != null) {
            graphics2D.setPaint(lineColor);
            for (Outline outline : getDecorationOutlines(graphics2D)) {
                if (outline.getPath().isFilled()) {
                    graphics2D.fill(outline.getOutline());
                }
                if (outline.getPath().isStroked()) {
                    graphics2D.draw(outline.getOutline());
                }
            }
        }
    }

    boolean fetchShapeProperty(PropertyFetcher propertyFetcher) {
        XSLFSimpleShape placeholderByType;
        XSLFSimpleShape placeholder;
        boolean fetch = propertyFetcher.fetch(this);
        XSLFSheet masterSheet = getSheet().getMasterSheet();
        CTPlaceholder cTPlaceholder = getCTPlaceholder();
        if (masterSheet == null || cTPlaceholder == null) {
            return fetch;
        }
        if (!fetch && (placeholder = masterSheet.getPlaceholder(cTPlaceholder)) != null) {
            fetch = propertyFetcher.fetch(placeholder);
        }
        if (fetch) {
            return fetch;
        }
        int i = 2;
        if (cTPlaceholder.isSetType()) {
            int intValue = cTPlaceholder.getType().intValue();
            if (intValue == 1 || intValue == 3) {
                i = 1;
            } else if (intValue == 5 || intValue == 6 || intValue == 7) {
                i = cTPlaceholder.getType().intValue();
            }
        }
        XSLFSheet masterSheet2 = masterSheet.getMasterSheet();
        return (masterSheet2 == null || (placeholderByType = masterSheet2.getPlaceholderByType(i)) == null) ? fetch : propertyFetcher.fetch(placeholderByType);
    }

    CustomGeometry getGeometry() {
        CTShapeProperties spPr = getSpPr();
        PresetGeometries presetGeometries = PresetGeometries.getInstance();
        if (spPr.isSetPrstGeom()) {
            String str = spPr.getPrstGeom().getPrst().toString();
            CustomGeometry customGeometry = presetGeometries.get(str);
            if (customGeometry != null) {
                return customGeometry;
            }
            throw new IllegalStateException("Unknown shape geometry: " + str);
        }
        if (spPr.isSetCustGeom()) {
            return new CustomGeometry(spPr.getCustGeom());
        }
        return presetGeometries.get("rect");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFSimpleShape xSLFSimpleShape = (XSLFSimpleShape) xSLFShape;
        Color fillColor = xSLFSimpleShape.getFillColor();
        Color fillColor2 = getFillColor();
        if (fillColor != null && !fillColor.equals(fillColor2)) {
            setFillColor(fillColor);
        }
        if (getSpPr().isSetBlipFill()) {
            CTBlip blip = getSpPr().getBlipFill().getBlip();
            blip.setEmbed(getSheet().importBlip(blip.getEmbed(), xSLFSimpleShape.getSheet().getPackagePart()));
        }
        Color lineColor = xSLFSimpleShape.getLineColor();
        Color lineColor2 = getLineColor();
        if (lineColor != null && !lineColor.equals(lineColor2)) {
            setLineColor(lineColor);
        }
        double lineWidth = xSLFSimpleShape.getLineWidth();
        if (lineWidth != getLineWidth()) {
            setLineWidth(lineWidth);
        }
        LineDash lineDash = xSLFSimpleShape.getLineDash();
        LineDash lineDash2 = getLineDash();
        if (lineDash != null && lineDash != lineDash2) {
            setLineDash(lineDash);
        }
        LineCap lineCap = xSLFSimpleShape.getLineCap();
        LineCap lineCap2 = getLineCap();
        if (lineCap == null || lineCap == lineCap2) {
            return;
        }
        setLineCap(lineCap);
    }

    public void setLineHeadDecoration(LineDecoration lineDecoration) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (lineDecoration == null) {
            if (headEnd.isSetType()) {
                headEnd.unsetType();
                return;
            }
            return;
        }
        headEnd.setType(STLineEndType.Enum.forInt(lineDecoration.ordinal() + 1));
    }

    public LineDecoration getLineHeadDecoration() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetHeadEnd()) {
            return LineDecoration.NONE;
        }
        return ln.getHeadEnd().getType() == null ? LineDecoration.NONE : LineDecoration.values()[r0.intValue() - 1];
    }

    public void setLineHeadWidth(LineEndWidth lineEndWidth) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (lineEndWidth == null) {
            if (headEnd.isSetW()) {
                headEnd.unsetW();
                return;
            }
            return;
        }
        headEnd.setW(STLineEndWidth.Enum.forInt(lineEndWidth.ordinal() + 1));
    }

    public LineEndWidth getLineHeadWidth() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetHeadEnd()) {
            return LineEndWidth.MEDIUM;
        }
        return ln.getHeadEnd().getW() == null ? LineEndWidth.MEDIUM : LineEndWidth.values()[r0.intValue() - 1];
    }

    public void setLineHeadLength(LineEndLength lineEndLength) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (lineEndLength == null) {
            if (headEnd.isSetLen()) {
                headEnd.unsetLen();
                return;
            }
            return;
        }
        headEnd.setLen(STLineEndLength.Enum.forInt(lineEndLength.ordinal() + 1));
    }

    public LineEndLength getLineHeadLength() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetHeadEnd()) {
            return LineEndLength.MEDIUM;
        }
        return ln.getHeadEnd().getLen() == null ? LineEndLength.MEDIUM : LineEndLength.values()[r0.intValue() - 1];
    }

    public void setLineTailDecoration(LineDecoration lineDecoration) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (lineDecoration == null) {
            if (tailEnd.isSetType()) {
                tailEnd.unsetType();
                return;
            }
            return;
        }
        tailEnd.setType(STLineEndType.Enum.forInt(lineDecoration.ordinal() + 1));
    }

    public LineDecoration getLineTailDecoration() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetTailEnd()) {
            return LineDecoration.NONE;
        }
        return ln.getTailEnd().getType() == null ? LineDecoration.NONE : LineDecoration.values()[r0.intValue() - 1];
    }

    public void setLineTailWidth(LineEndWidth lineEndWidth) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (lineEndWidth == null) {
            if (tailEnd.isSetW()) {
                tailEnd.unsetW();
                return;
            }
            return;
        }
        tailEnd.setW(STLineEndWidth.Enum.forInt(lineEndWidth.ordinal() + 1));
    }

    public LineEndWidth getLineTailWidth() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetTailEnd()) {
            return LineEndWidth.MEDIUM;
        }
        return ln.getTailEnd().getW() == null ? LineEndWidth.MEDIUM : LineEndWidth.values()[r0.intValue() - 1];
    }

    public void setLineTailLength(LineEndLength lineEndLength) {
        CTLineProperties ln = getSpPr().getLn();
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (lineEndLength == null) {
            if (tailEnd.isSetLen()) {
                tailEnd.unsetLen();
                return;
            }
            return;
        }
        tailEnd.setLen(STLineEndLength.Enum.forInt(lineEndLength.ordinal() + 1));
    }

    public LineEndLength getLineTailLength() {
        CTLineProperties ln = getSpPr().getLn();
        if (ln == null || !ln.isSetTailEnd()) {
            return LineEndLength.MEDIUM;
        }
        return ln.getTailEnd().getLen() == null ? LineEndLength.MEDIUM : LineEndLength.values()[r0.intValue() - 1];
    }

    Outline getTailDecoration(Graphics2D graphics2D) {
        Path path;
        Shape shape;
        LineEndLength lineTailLength = getLineTailLength();
        LineEndWidth lineTailWidth = getLineTailWidth();
        double max = Math.max(2.5d, getLineWidth());
        Rectangle2D anchor = new RenderableShape(this).getAnchor(graphics2D);
        double x = anchor.getX() + anchor.getWidth();
        double y = anchor.getY() + anchor.getHeight();
        double atan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        double pow = Math.pow(2.0d, lineTailWidth.ordinal());
        double pow2 = Math.pow(2.0d, lineTailLength.ordinal());
        int i = AnonymousClass6.$SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration[getLineTailDecoration().ordinal()];
        if (i == 1) {
            Path path2 = new Path();
            Shape shape2 = new Ellipse2D.Double(0.0d, 0.0d, max * pow2, max * pow);
            Rectangle2D bounds2D = shape2.getBounds2D();
            affineTransform.translate(x - (bounds2D.getWidth() / 2.0d), y - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(atan, bounds2D.getX() + (bounds2D.getWidth() / 2.0d), bounds2D.getY() + (bounds2D.getHeight() / 2.0d));
            path = path2;
            shape = shape2;
        } else if (i == 2) {
            Path path3 = new Path();
            shape = new GeneralPath();
            double d = -max;
            float f = (float) (d * 3.0d);
            shape.moveTo(f, (float) (d * 2.0d));
            shape.lineTo(0.0f, 0.0f);
            shape.lineTo(f, (float) (max * 2.0d));
            affineTransform.translate(x, y);
            affineTransform.rotate(atan);
            path = path3;
        } else if (i != 3) {
            path = null;
            shape = null;
        } else {
            path = new Path();
            double ordinal = lineTailWidth.ordinal() + 1;
            double ordinal2 = lineTailLength.ordinal() + 1;
            Shape generalPath = new GeneralPath();
            double d2 = -max;
            float f2 = (float) (ordinal2 * d2);
            generalPath.moveTo(f2, (float) ((d2 * ordinal) / 2.0d));
            generalPath.lineTo(0.0f, 0.0f);
            generalPath.lineTo(f2, (float) ((max * ordinal) / 2.0d));
            generalPath.closePath();
            affineTransform.translate(x, y);
            affineTransform.rotate(atan);
            shape = generalPath;
        }
        if (shape != null) {
            shape = affineTransform.createTransformedShape(shape);
        }
        if (shape == null) {
            return null;
        }
        return new Outline(shape, path);
    }

    /* renamed from: org.apache.poi.xslf.usermodel.XSLFSimpleShape$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration;

        static {
            int[] iArr = new int[LineDecoration.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration = iArr;
            try {
                iArr[LineDecoration.OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration[LineDecoration.ARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration[LineDecoration.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration[LineDecoration.STEALTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    Outline getHeadDecoration(Graphics2D graphics2D) {
        Path path;
        Shape shape;
        LineEndLength lineHeadLength = getLineHeadLength();
        LineEndWidth lineHeadWidth = getLineHeadWidth();
        double max = Math.max(2.5d, getLineWidth());
        Rectangle2D anchor = new RenderableShape(this).getAnchor(graphics2D);
        double x = anchor.getX();
        double y = anchor.getY();
        double atan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        int i = AnonymousClass6.$SwitchMap$org$apache$poi$xslf$usermodel$LineDecoration[getLineHeadDecoration().ordinal()];
        if (i == 1) {
            path = new Path();
            double d = max * 1.0d;
            shape = new Ellipse2D.Double(0.0d, 0.0d, d, d);
            Rectangle2D bounds2D = shape.getBounds2D();
            affineTransform.translate(x - (bounds2D.getWidth() / 2.0d), y - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(atan, bounds2D.getX() + (bounds2D.getWidth() / 2.0d), bounds2D.getY() + (bounds2D.getHeight() / 2.0d));
        } else {
            if (i != 2) {
                if (i == 3) {
                    path = new Path();
                    double ordinal = lineHeadWidth.ordinal() + 1;
                    double ordinal2 = lineHeadLength.ordinal() + 1;
                    shape = new GeneralPath();
                    float f = (float) (ordinal2 * max);
                    shape.moveTo(f, (float) (((-max) * ordinal) / 2.0d));
                    shape.lineTo(0.0f, 0.0f);
                    shape.lineTo(f, (float) ((max * ordinal) / 2.0d));
                    shape.closePath();
                    affineTransform.translate(x, y);
                    affineTransform.rotate(atan);
                } else if (i != 4) {
                    path = null;
                    shape = null;
                }
            }
            path = new Path(false, true);
            shape = new GeneralPath();
            float f2 = (float) (3.0d * max * 1.0d);
            shape.moveTo(f2, (float) ((-max) * 1.0d * 2.0d));
            shape.lineTo(0.0f, 0.0f);
            shape.lineTo(f2, (float) (max * 1.0d * 2.0d));
            affineTransform.translate(x, y);
            affineTransform.rotate(atan);
        }
        if (shape != null) {
            shape = affineTransform.createTransformedShape(shape);
        }
        if (shape == null) {
            return null;
        }
        return new Outline(shape, path);
    }

    private List<Outline> getDecorationOutlines(Graphics2D graphics2D) {
        ArrayList arrayList = new ArrayList();
        Outline headDecoration = getHeadDecoration(graphics2D);
        if (headDecoration != null) {
            arrayList.add(headDecoration);
        }
        Outline tailDecoration = getTailDecoration(graphics2D);
        if (tailDecoration != null) {
            arrayList.add(tailDecoration);
        }
        return arrayList;
    }
}
