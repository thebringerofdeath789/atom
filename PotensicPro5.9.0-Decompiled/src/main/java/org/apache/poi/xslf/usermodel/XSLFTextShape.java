package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.TextBodyPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* loaded from: classes5.dex */
public abstract class XSLFTextShape extends XSLFSimpleShape implements Iterable<XSLFTextParagraph> {
    private boolean _isTextBroken;
    private final List<XSLFTextParagraph> _paragraphs;

    protected abstract CTTextBody getTextBody(boolean z);

    XSLFTextShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        super(xmlObject, xSLFSheet);
        this._paragraphs = new ArrayList();
        CTTextBody textBody = getTextBody(false);
        if (textBody != null) {
            for (CTTextParagraph cTTextParagraph : textBody.getPArray()) {
                this._paragraphs.add(new XSLFTextParagraph(cTTextParagraph, this));
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextParagraph> iterator() {
        return this._paragraphs.iterator();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (XSLFTextParagraph xSLFTextParagraph : this._paragraphs) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(xSLFTextParagraph.getText());
        }
        return sb.toString();
    }

    public void clearText() {
        this._paragraphs.clear();
        getTextBody(true).setPArray(null);
    }

    public void setText(String str) {
        clearText();
        addNewTextParagraph().addNewTextRun().setText(str);
    }

    public List<XSLFTextParagraph> getTextParagraphs() {
        return this._paragraphs;
    }

    public XSLFTextParagraph addNewTextParagraph() {
        XSLFTextParagraph xSLFTextParagraph = new XSLFTextParagraph(getTextBody(true).addNewP(), this);
        this._paragraphs.add(xSLFTextParagraph);
        return xSLFTextParagraph;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (verticalAlignment == null) {
                if (textBodyPr.isSetAnchor()) {
                    textBodyPr.unsetAnchor();
                    return;
                }
                return;
            }
            textBodyPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
        }
    }

    public VerticalAlignment getVerticalAlignment() {
        TextBodyPropertyFetcher<VerticalAlignment> textBodyPropertyFetcher = new TextBodyPropertyFetcher<VerticalAlignment>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.1
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetAnchor()) {
                    return false;
                }
                setValue(VerticalAlignment.values()[cTTextBodyProperties.getAnchor().intValue() - 1]);
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        return textBodyPropertyFetcher.getValue() == null ? VerticalAlignment.TOP : textBodyPropertyFetcher.getValue();
    }

    public void setTextDirection(TextDirection textDirection) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (textDirection == null) {
                if (textBodyPr.isSetVert()) {
                    textBodyPr.unsetVert();
                    return;
                }
                return;
            }
            textBodyPr.setVert(STTextVerticalType.Enum.forInt(textDirection.ordinal() + 1));
        }
    }

    public TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null && (vert = textBodyPr.getVert()) != null) {
            return TextDirection.values()[vert.intValue() - 1];
        }
        return TextDirection.HORIZONTAL;
    }

    public double getBottomInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.2
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetBIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getBIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getLeftInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.3
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetLIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getLIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getRightInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.4
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetRIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getRIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getTopInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.5
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetTIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextBodyProperties.getTIns())));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public void setBottomInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetBIns();
            } else {
                textBodyPr.setBIns(Units.toEMU(d));
            }
        }
    }

    public void setLeftInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetLIns();
            } else {
                textBodyPr.setLIns(Units.toEMU(d));
            }
        }
    }

    public void setRightInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetRIns();
            } else {
                textBodyPr.setRIns(Units.toEMU(d));
            }
        }
    }

    public void setTopInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetTIns();
            } else {
                textBodyPr.setTIns(Units.toEMU(d));
            }
        }
    }

    public boolean getWordWrap() {
        TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.6
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetWrap()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextBodyProperties.getWrap() == STTextWrappingType.SQUARE));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return true;
        }
        return textBodyPropertyFetcher.getValue().booleanValue();
    }

    public void setWordWrap(boolean z) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            textBodyPr.setWrap(z ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
        }
    }

    public void setTextAutofit(TextAutofit textAutofit) {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (textBodyPr.isSetSpAutoFit()) {
                textBodyPr.unsetSpAutoFit();
            }
            if (textBodyPr.isSetNoAutofit()) {
                textBodyPr.unsetNoAutofit();
            }
            if (textBodyPr.isSetNormAutofit()) {
                textBodyPr.unsetNormAutofit();
            }
            int i = AnonymousClass7.$SwitchMap$org$apache$poi$xslf$usermodel$TextAutofit[textAutofit.ordinal()];
            if (i == 1) {
                textBodyPr.addNewNoAutofit();
            } else if (i == 2) {
                textBodyPr.addNewNormAutofit();
            } else {
                if (i != 3) {
                    return;
                }
                textBodyPr.addNewSpAutoFit();
            }
        }
    }

    public TextAutofit getTextAutofit() {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (textBodyPr.isSetNoAutofit()) {
                return TextAutofit.NONE;
            }
            if (textBodyPr.isSetNormAutofit()) {
                return TextAutofit.NORMAL;
            }
            if (textBodyPr.isSetSpAutoFit()) {
                return TextAutofit.SHAPE;
            }
        }
        return TextAutofit.NORMAL;
    }

    protected CTTextBodyProperties getTextBodyPr() {
        CTTextBody textBody = getTextBody(false);
        if (textBody == null) {
            return null;
        }
        return textBody.getBodyPr();
    }

    public Placeholder getTextType() {
        XmlObject[] selectPath = getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr/p:ph");
        if (selectPath.length != 1) {
            return null;
        }
        return Placeholder.values()[((CTPlaceholder) selectPath[0]).getType().intValue() - 1];
    }

    public void setPlaceholder(Placeholder placeholder) {
        CTApplicationNonVisualDrawingProps nvPr = ((CTShape) getXmlObject()).getNvSpPr().getNvPr();
        if (placeholder == null) {
            if (nvPr.isSetPh()) {
                nvPr.unsetPh();
                return;
            }
            return;
        }
        nvPr.addNewPh().setType(STPlaceholderType.Enum.forInt(placeholder.ordinal() + 1));
    }

    public double getTextHeight() {
        Graphics2D createGraphics = new BufferedImage(1, 1, 1).createGraphics();
        breakText(createGraphics);
        return drawParagraphs(createGraphics, 0.0d, 0.0d);
    }

    public Rectangle2D resizeToFitText() {
        Rectangle2D anchor = getAnchor();
        if (anchor.getWidth() == 0.0d) {
            throw new POIXMLException("Anchor of the shape was not set.");
        }
        anchor.setRect(anchor.getX(), anchor.getY(), anchor.getWidth(), getTextHeight() + 1.0d);
        setAnchor(anchor);
        return anchor;
    }

    private void breakText(Graphics2D graphics2D) {
        if (this._isTextBroken) {
            return;
        }
        Iterator<XSLFTextParagraph> it = this._paragraphs.iterator();
        while (it.hasNext()) {
            it.next().breakText(graphics2D);
        }
        this._isTextBroken = true;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public void drawContent(Graphics2D graphics2D) {
        AffineTransform affineTransform;
        double topInset;
        double d;
        breakText(graphics2D);
        Rectangle2D anchor = new RenderableShape(this).getAnchor(graphics2D);
        double x = anchor.getX() + getLeftInset();
        double y = anchor.getY();
        AffineTransform transform = graphics2D.getTransform();
        if (getFlipVertical()) {
            affineTransform = transform;
            graphics2D.translate(anchor.getX(), anchor.getY() + anchor.getHeight());
            graphics2D.scale(1.0d, -1.0d);
            graphics2D.translate(-anchor.getX(), -anchor.getY());
            double x2 = anchor.getX() + (anchor.getWidth() / 2.0d);
            double y2 = anchor.getY() + (anchor.getHeight() / 2.0d);
            graphics2D.translate(x2, y2);
            graphics2D.rotate(Math.toRadians(180.0d));
            graphics2D.translate(-x2, -y2);
        } else {
            affineTransform = transform;
        }
        if (getFlipHorizontal()) {
            graphics2D.translate(anchor.getX() + anchor.getWidth(), anchor.getY());
            graphics2D.scale(-1.0d, 1.0d);
            graphics2D.translate(-anchor.getX(), -anchor.getY());
        }
        double textHeight = getTextHeight();
        int i = AnonymousClass7.$SwitchMap$org$apache$poi$xslf$usermodel$VerticalAlignment[getVerticalAlignment().ordinal()];
        if (i == 1) {
            topInset = getTopInset();
        } else if (i == 2) {
            topInset = (anchor.getHeight() - textHeight) - getBottomInset();
        } else {
            d = y + getTopInset() + ((((anchor.getHeight() - textHeight) - getTopInset()) - getBottomInset()) / 2.0d);
            drawParagraphs(graphics2D, x, d);
            graphics2D.setTransform(affineTransform);
        }
        d = y + topInset;
        drawParagraphs(graphics2D, x, d);
        graphics2D.setTransform(affineTransform);
    }

    /* renamed from: org.apache.poi.xslf.usermodel.XSLFTextShape$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$TextAutofit;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$VerticalAlignment;

        static {
            int[] iArr = new int[VerticalAlignment.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$VerticalAlignment = iArr;
            try {
                iArr[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$VerticalAlignment[VerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$VerticalAlignment[VerticalAlignment.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TextAutofit.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$TextAutofit = iArr2;
            try {
                iArr2[TextAutofit.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$TextAutofit[TextAutofit.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$TextAutofit[TextAutofit.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private double drawParagraphs(Graphics2D graphics2D, double d, double d2) {
        double d3 = d2;
        for (int i = 0; i < this._paragraphs.size(); i++) {
            XSLFTextParagraph xSLFTextParagraph = this._paragraphs.get(i);
            List<TextFragment> textLines = xSLFTextParagraph.getTextLines();
            if (i > 0 && textLines.size() > 0) {
                double spaceBefore = xSLFTextParagraph.getSpaceBefore();
                d3 += spaceBefore > 0.0d ? spaceBefore * 0.01d * textLines.get(0).getHeight() : -spaceBefore;
            }
            d3 += xSLFTextParagraph.draw(graphics2D, d, d3);
            if (i < this._paragraphs.size() - 1) {
                double spaceAfter = xSLFTextParagraph.getSpaceAfter();
                d3 += spaceAfter > 0.0d ? spaceAfter * 0.01d * textLines.get(textLines.size() - 1).getHeight() : -spaceAfter;
            }
        }
        return d3 - d2;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
        boolean wordWrap = xSLFTextShape.getWordWrap();
        if (wordWrap != getWordWrap()) {
            setWordWrap(wordWrap);
        }
        double leftInset = xSLFTextShape.getLeftInset();
        if (leftInset != getLeftInset()) {
            setLeftInset(leftInset);
        }
        double rightInset = xSLFTextShape.getRightInset();
        if (rightInset != getRightInset()) {
            setRightInset(rightInset);
        }
        double topInset = xSLFTextShape.getTopInset();
        if (topInset != getTopInset()) {
            setTopInset(topInset);
        }
        double bottomInset = xSLFTextShape.getBottomInset();
        if (bottomInset != getBottomInset()) {
            setBottomInset(bottomInset);
        }
        VerticalAlignment verticalAlignment = xSLFTextShape.getVerticalAlignment();
        if (verticalAlignment != getVerticalAlignment()) {
            setVerticalAlignment(verticalAlignment);
        }
        List<XSLFTextParagraph> textParagraphs = xSLFTextShape.getTextParagraphs();
        List<XSLFTextParagraph> textParagraphs2 = getTextParagraphs();
        for (int i = 0; i < textParagraphs.size(); i++) {
            textParagraphs2.get(i).copy(textParagraphs.get(i));
        }
    }
}
