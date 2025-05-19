package org.apache.poi.xslf.usermodel;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hslf.model.TextPainter;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* loaded from: classes5.dex */
public class XSLFTextParagraph implements Iterable<XSLFTextRun> {
    private TextFragment _bullet;
    private List<TextFragment> _lines;
    private double _maxLineHeight;
    private final CTTextParagraph _p;
    private final List<XSLFTextRun> _runs = new ArrayList();
    private final XSLFTextShape _shape;

    XSLFTextParagraph(CTTextParagraph cTTextParagraph, XSLFTextShape xSLFTextShape) {
        this._p = cTTextParagraph;
        this._shape = xSLFTextShape;
        for (XmlObject xmlObject : cTTextParagraph.selectPath(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            if (xmlObject instanceof CTRegularTextRun) {
                this._runs.add(new XSLFTextRun((CTRegularTextRun) xmlObject, this));
            } else if (xmlObject instanceof CTTextLineBreak) {
                CTRegularTextRun newInstance = CTRegularTextRun.Factory.newInstance();
                newInstance.setRPr(((CTTextLineBreak) xmlObject).getRPr());
                newInstance.setT("\n");
                this._runs.add(new XSLFTextRun(newInstance, this));
            } else if (xmlObject instanceof CTTextField) {
                CTTextField cTTextField = (CTTextField) xmlObject;
                CTRegularTextRun newInstance2 = CTRegularTextRun.Factory.newInstance();
                newInstance2.setRPr(cTTextField.getRPr());
                newInstance2.setT(cTTextField.getT());
                this._runs.add(new XSLFTextRun(newInstance2, this));
            }
        }
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    String getRenderableText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getRenderableText());
        }
        return sb.toString();
    }

    @Internal
    public CTTextParagraph getXmlObject() {
        return this._p;
    }

    XSLFTextShape getParentShape() {
        return this._shape;
    }

    public List<XSLFTextRun> getTextRuns() {
        return this._runs;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextRun> iterator() {
        return this._runs.iterator();
    }

    public XSLFTextRun addNewTextRun() {
        CTRegularTextRun addNewR = this._p.addNewR();
        addNewR.addNewRPr().setLang("en-US");
        XSLFTextRun xSLFTextRun = new XSLFTextRun(addNewR, this);
        this._runs.add(xSLFTextRun);
        return xSLFTextRun;
    }

    public XSLFTextRun addLineBreak() {
        CTTextCharacterProperties addNewRPr = this._p.addNewBr().addNewRPr();
        if (this._runs.size() > 0) {
            addNewRPr.set(this._runs.get(r1.size() - 1).getRPr());
        }
        CTRegularTextRun newInstance = CTRegularTextRun.Factory.newInstance();
        newInstance.setRPr(addNewRPr);
        newInstance.setT("\n");
        XSLFLineBreak xSLFLineBreak = new XSLFLineBreak(newInstance, this, addNewRPr);
        this._runs.add(xSLFLineBreak);
        return xSLFLineBreak;
    }

    public TextAlign getTextAlign() {
        ParagraphPropertyFetcher<TextAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextAlign>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.1
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetAlgn()) {
                    return false;
                }
                setValue(TextAlign.values()[cTTextParagraphProperties.getAlgn().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue() == null ? TextAlign.LEFT : paragraphPropertyFetcher.getValue();
    }

    public void setTextAlign(TextAlign textAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (textAlign == null) {
            if (pPr.isSetAlgn()) {
                pPr.unsetAlgn();
                return;
            }
            return;
        }
        pPr.setAlgn(STTextAlignType.Enum.forInt(textAlign.ordinal() + 1));
    }

    public String getBulletFont() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.2
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuFont()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuFont().getTypeface());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletFont(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuFont() ? pPr.getBuFont() : pPr.addNewBuFont()).setTypeface(str);
    }

    public String getBulletCharacter() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.3
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuChar()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuChar().getChar());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletCharacter(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuChar() ? pPr.getBuChar() : pPr.addNewBuChar()).setChar(str);
    }

    public Color getBulletFontColor() {
        final XSLFTheme theme = getParentShape().getSheet().getTheme();
        ParagraphPropertyFetcher<Color> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Color>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.4
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuClr()) {
                    return false;
                }
                setValue(new XSLFColor(cTTextParagraphProperties.getBuClr(), theme, null).getColor());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public void setBulletFontColor(Color color) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTColor buClr = pPr.isSetBuClr() ? pPr.getBuClr() : pPr.addNewBuClr();
        (buClr.isSetSrgbClr() ? buClr.getSrgbClr() : buClr.addNewSrgbClr()).setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
    }

    public double getBulletFontSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.5
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuSzPct()) {
                    setValue(Double.valueOf(cTTextParagraphProperties.getBuSzPct().getVal() * 0.001d));
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuSzPts()) {
                    return false;
                }
                setValue(Double.valueOf((-cTTextParagraphProperties.getBuSzPts().getVal()) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 100.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void setBulletFontSize(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d >= 0.0d) {
            (pPr.isSetBuSzPct() ? pPr.getBuSzPct() : pPr.addNewBuSzPct()).setVal((int) (d * 1000.0d));
            if (pPr.isSetBuSzPts()) {
                pPr.unsetBuSzPts();
                return;
            }
            return;
        }
        (pPr.isSetBuSzPts() ? pPr.getBuSzPts() : pPr.addNewBuSzPts()).setVal((int) ((-d) * 100.0d));
        if (pPr.isSetBuSzPct()) {
            pPr.unsetBuSzPct();
        }
    }

    public void setIndent(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d == -1.0d) {
            if (pPr.isSetIndent()) {
                pPr.unsetIndent();
                return;
            }
            return;
        }
        pPr.setIndent(Units.toEMU(d));
    }

    public double getIndent() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.6
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetIndent()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getIndent())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void setLeftMargin(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d == -1.0d) {
            if (pPr.isSetMarL()) {
                pPr.unsetMarL();
                return;
            }
            return;
        }
        pPr.setMarL(Units.toEMU(d));
    }

    public double getLeftMargin() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.7
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetMarL()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarL())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getDefaultTabSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.8
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetDefTabSz()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getDefTabSz())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getTabStop(final int i) {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.9
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetTabLst()) {
                    return false;
                }
                if (i >= cTTextParagraphProperties.getTabLst().sizeOfTabArray()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(r3.getTabArray(i).getPos())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void addTabStop(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetTabLst() ? pPr.getTabLst() : pPr.addNewTabLst()).addNewTab().setPos(Units.toEMU(d));
    }

    public void setLineSpacing(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing newInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            newInstance.addNewSpcPct().setVal((int) (d * 1000.0d));
        } else {
            newInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setLnSpc(newInstance);
    }

    public double getLineSpacing() {
        CTTextNormalAutofit normAutofit;
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.10
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetLnSpc()) {
                    return false;
                }
                CTTextSpacing lnSpc = cTTextParagraphProperties.getLnSpc();
                if (lnSpc.isSetSpcPct()) {
                    setValue(Double.valueOf(lnSpc.getSpcPct().getVal() * 0.001d));
                    return true;
                }
                if (!lnSpc.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf((-lnSpc.getSpcPts().getVal()) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        double doubleValue = paragraphPropertyFetcher.getValue() == null ? 100.0d : paragraphPropertyFetcher.getValue().doubleValue();
        return (doubleValue <= 0.0d || (normAutofit = getParentShape().getTextBodyPr().getNormAutofit()) == null) ? doubleValue : doubleValue * (1.0d - (normAutofit.getLnSpcReduction() / 100000.0d));
    }

    public void setSpaceBefore(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing newInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            newInstance.addNewSpcPct().setVal((int) (d * 1000.0d));
        } else {
            newInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setSpcBef(newInstance);
    }

    public double getSpaceBefore() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.11
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcBef()) {
                    return false;
                }
                CTTextSpacing spcBef = cTTextParagraphProperties.getSpcBef();
                if (spcBef.isSetSpcPct()) {
                    setValue(Double.valueOf(spcBef.getSpcPct().getVal() * 0.001d));
                    return true;
                }
                if (!spcBef.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf((-spcBef.getSpcPts().getVal()) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void setSpaceAfter(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing newInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            newInstance.addNewSpcPct().setVal((int) (d * 1000.0d));
        } else {
            newInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setSpcAft(newInstance);
    }

    public double getSpaceAfter() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.12
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcAft()) {
                    return false;
                }
                CTTextSpacing spcAft = cTTextParagraphProperties.getSpcAft();
                if (spcAft.isSetSpcPct()) {
                    setValue(Double.valueOf(spcAft.getSpcPct().getVal() * 0.001d));
                    return true;
                }
                if (!spcAft.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf((-spcAft.getSpcPts().getVal()) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public void setLevel(int i) {
        (this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr()).setLvl(i);
    }

    public int getLevel() {
        CTTextParagraphProperties pPr = this._p.getPPr();
        if (pPr == null) {
            return 0;
        }
        return pPr.getLvl();
    }

    public boolean isBullet() {
        ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getLevel()) { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.13
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuNone()) {
                    setValue(false);
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuFont() && !cTTextParagraphProperties.isSetBuChar()) {
                    return false;
                }
                setValue(true);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return false;
        }
        return paragraphPropertyFetcher.getValue().booleanValue();
    }

    public void setBullet(boolean z) {
        if (isBullet() == z) {
            return;
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (!z) {
            pPr.addNewBuNone();
        } else {
            pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
            pPr.addNewBuChar().setChar("•");
        }
    }

    public void setBulletAutoNumber(ListAutoNumber listAutoNumber, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Start Number must be greater or equal that 1");
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextAutonumberBullet buAutoNum = pPr.isSetBuAutoNum() ? pPr.getBuAutoNum() : pPr.addNewBuAutoNum();
        buAutoNum.setType(STTextAutonumberScheme.Enum.forInt(listAutoNumber.ordinal() + 1));
        buAutoNum.setStartAt(i);
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }

    List<TextFragment> getTextLines() {
        return this._lines;
    }

    double getWrappingWidth(boolean z, Graphics2D graphics2D) {
        double leftInset = this._shape.getLeftInset();
        double rightInset = this._shape.getRightInset();
        Rectangle2D anchor = new RenderableShape(this._shape).getAnchor(graphics2D);
        double leftMargin = getLeftMargin();
        double indent = getIndent();
        if (!this._shape.getWordWrap()) {
            return this._shape.getSheet().getSlideShow().getPageSize().getWidth() - anchor.getX();
        }
        double width = ((anchor.getWidth() - leftInset) - rightInset) - leftMargin;
        if (!z) {
            return width;
        }
        if (isBullet()) {
            if (indent <= 0.0d) {
                return width;
            }
        } else if (indent <= 0.0d) {
            return indent < 0.0d ? width + leftMargin : width;
        }
        return width - indent;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double draw(java.awt.Graphics2D r30, double r31, double r33) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xslf.usermodel.XSLFTextParagraph.draw(java.awt.Graphics2D, double, double):double");
    }

    /* renamed from: org.apache.poi.xslf.usermodel.XSLFTextParagraph$14, reason: invalid class name */
    static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$TextAlign;

        static {
            int[] iArr = new int[TextAlign.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$TextAlign = iArr;
            try {
                iArr[TextAlign.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$TextAlign[TextAlign.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    AttributedString getAttributedString(Graphics2D graphics2D) {
        AttributedString attributedString = new AttributedString(getRenderableText());
        XSLFFontManager xSLFFontManager = (XSLFFontManager) graphics2D.getRenderingHint(XSLFRenderingHint.FONT_HANDLER);
        int i = 0;
        for (XSLFTextRun xSLFTextRun : this._runs) {
            int length = xSLFTextRun.getRenderableText().length();
            if (length != 0) {
                int i2 = length + i;
                attributedString.addAttribute(TextAttribute.FOREGROUND, xSLFTextRun.getFontColor(), i, i2);
                String fontFamily = xSLFTextRun.getFontFamily();
                Map map = (Map) graphics2D.getRenderingHint(TextPainter.KEY_FONTMAP);
                if (map != null && map.containsKey(fontFamily)) {
                    fontFamily = (String) map.get(fontFamily);
                }
                if (xSLFFontManager != null) {
                    fontFamily = xSLFFontManager.getRendererableFont(fontFamily, xSLFTextRun.getPitchAndFamily());
                }
                attributedString.addAttribute(TextAttribute.FAMILY, fontFamily, i, i2);
                attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf((float) xSLFTextRun.getFontSize()), i, i2);
                if (xSLFTextRun.isBold()) {
                    attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i, i2);
                }
                if (xSLFTextRun.isItalic()) {
                    attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i, i2);
                }
                if (xSLFTextRun.isUnderline()) {
                    attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i, i2);
                    attributedString.addAttribute(TextAttribute.INPUT_METHOD_UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL, i, i2);
                }
                if (xSLFTextRun.isStrikethrough()) {
                    attributedString.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, i, i2);
                }
                if (xSLFTextRun.isSubscript()) {
                    attributedString.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, i, i2);
                }
                if (xSLFTextRun.isSuperscript()) {
                    attributedString.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, i, i2);
                }
                i = i2;
            }
        }
        return attributedString;
    }

    private void ensureNotEmpty() {
        XSLFTextRun addNewTextRun = addNewTextRun();
        addNewTextRun.setText(StringUtils.SPACE);
        CTTextCharacterProperties endParaRPr = this._p.getEndParaRPr();
        if (endParaRPr == null || !endParaRPr.isSetSz()) {
            return;
        }
        addNewTextRun.setFontSize(endParaRPr.getSz() / 100);
    }

    List<TextFragment> breakText(Graphics2D graphics2D) {
        int position;
        this._lines = new ArrayList();
        boolean z = this._runs.size() == 0;
        if (this._runs.size() == 0) {
            ensureNotEmpty();
        }
        String renderableText = getRenderableText();
        if (renderableText.length() == 0) {
            return this._lines;
        }
        AttributedCharacterIterator iterator = getAttributedString(graphics2D).getIterator();
        LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(iterator, graphics2D.getFontRenderContext());
        do {
            int position2 = lineBreakMeasurer.getPosition();
            double wrappingWidth = getWrappingWidth(this._lines.size() == 0, graphics2D) + 1.0d;
            double d = wrappingWidth >= 0.0d ? wrappingWidth : 1.0d;
            int indexOf = renderableText.indexOf(10, position2 + 1);
            if (indexOf == -1) {
                indexOf = iterator.getEndIndex();
            }
            float f = (float) d;
            TextLayout nextLayout = lineBreakMeasurer.nextLayout(f, indexOf, true);
            if (nextLayout == null) {
                nextLayout = lineBreakMeasurer.nextLayout(f, indexOf, false);
            }
            if (nextLayout == null) {
                break;
            }
            position = lineBreakMeasurer.getPosition();
            if (position < iterator.getEndIndex() && renderableText.charAt(position) == '\n') {
                lineBreakMeasurer.setPosition(position + 1);
            }
            TextAlign textAlign = getTextAlign();
            if (textAlign == TextAlign.JUSTIFY || textAlign == TextAlign.JUSTIFY_LOW) {
                nextLayout = nextLayout.getJustifiedLayout(f);
            }
            AttributedString attributedString = new AttributedString(iterator, position2, position);
            if (z) {
                attributedString = null;
            }
            this._lines.add(new TextFragment(nextLayout, attributedString));
            this._maxLineHeight = Math.max(this._maxLineHeight, r6.getHeight());
        } while (position != iterator.getEndIndex());
        if (isBullet() && !z) {
            String bulletCharacter = getBulletCharacter();
            String bulletFont = getBulletFont();
            if (bulletFont == null) {
                bulletFont = getTextRuns().get(0).getFontFamily();
            }
            if (bulletCharacter != null && bulletFont != null && this._lines.size() > 0) {
                AttributedString attributedString2 = new AttributedString(bulletCharacter);
                AttributedCharacterIterator iterator2 = this._lines.get(0)._str.getIterator();
                Object bulletFontColor = getBulletFontColor();
                TextAttribute textAttribute = TextAttribute.FOREGROUND;
                if (bulletFontColor == null) {
                    bulletFontColor = iterator2.getAttribute(TextAttribute.FOREGROUND);
                }
                attributedString2.addAttribute(textAttribute, bulletFontColor);
                attributedString2.addAttribute(TextAttribute.FAMILY, bulletFont);
                float floatValue = ((Float) iterator2.getAttribute(TextAttribute.SIZE)).floatValue();
                float bulletFontSize = (float) getBulletFontSize();
                attributedString2.addAttribute(TextAttribute.SIZE, Float.valueOf(bulletFontSize > 0.0f ? (float) (floatValue * bulletFontSize * 0.01d) : -bulletFontSize));
                this._bullet = new TextFragment(new TextLayout(attributedString2.getIterator(), graphics2D.getFontRenderContext()), attributedString2);
            }
        }
        return this._lines;
    }

    CTTextParagraphProperties getDefaultMasterStyle() {
        CTPlaceholder cTPlaceholder = this._shape.getCTPlaceholder();
        String str = "otherStyle";
        if (cTPlaceholder != null) {
            int intValue = cTPlaceholder.getType().intValue();
            if (intValue == 1 || intValue == 3) {
                str = "titleStyle";
            } else if (intValue != 5 && intValue != 6 && intValue != 7) {
                str = "bodyStyle";
            }
        }
        int level = getLevel();
        XSLFSheet sheet = this._shape.getSheet();
        while (sheet.getMasterSheet() != null) {
            sheet = sheet.getMasterSheet();
        }
        int i = level + 1;
        XmlObject[] selectPath = sheet.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txStyles/p:" + str + "/a:lvl" + i + "pPr");
        if (selectPath.length == 1) {
            return (CTTextParagraphProperties) selectPath[0];
        }
        XmlObject[] selectPath2 = sheet.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:notesStyle/a:lvl" + i + "pPr");
        if (selectPath2.length == 1) {
            return (CTTextParagraphProperties) selectPath2[0];
        }
        throw new IllegalArgumentException("Failed to fetch default style for " + str + " and level=" + level);
    }

    private <T> boolean fetchParagraphProperty(ParagraphPropertyFetcher<T> paragraphPropertyFetcher) {
        CTTextParagraphProperties defaultMasterStyle;
        CTTextParagraphProperties defaultParagraphStyle;
        boolean fetch = this._p.isSetPPr() ? paragraphPropertyFetcher.fetch(this._p.getPPr()) : false;
        if (fetch) {
            return fetch;
        }
        XSLFTextShape parentShape = getParentShape();
        boolean fetchShapeProperty = parentShape.fetchShapeProperty(paragraphPropertyFetcher);
        if (fetchShapeProperty) {
            return fetchShapeProperty;
        }
        boolean fetch2 = (parentShape.getCTPlaceholder() != null || (defaultParagraphStyle = getParentShape().getSheet().getSlideShow().getDefaultParagraphStyle(getLevel())) == null) ? fetchShapeProperty : paragraphPropertyFetcher.fetch(defaultParagraphStyle);
        return (fetch2 || (defaultMasterStyle = getDefaultMasterStyle()) == null) ? fetch2 : paragraphPropertyFetcher.fetch(defaultMasterStyle);
    }

    void copy(XSLFTextParagraph xSLFTextParagraph) {
        TextAlign textAlign = xSLFTextParagraph.getTextAlign();
        if (textAlign != getTextAlign()) {
            setTextAlign(textAlign);
        }
        boolean isBullet = xSLFTextParagraph.isBullet();
        if (isBullet != isBullet()) {
            setBullet(isBullet);
            if (isBullet) {
                String bulletFont = xSLFTextParagraph.getBulletFont();
                if (bulletFont != null && !bulletFont.equals(getBulletFont())) {
                    setBulletFont(bulletFont);
                }
                String bulletCharacter = xSLFTextParagraph.getBulletCharacter();
                if (bulletCharacter != null && !bulletCharacter.equals(getBulletCharacter())) {
                    setBulletCharacter(bulletCharacter);
                }
                Color bulletFontColor = xSLFTextParagraph.getBulletFontColor();
                if (bulletFontColor != null && !bulletFontColor.equals(getBulletFontColor())) {
                    setBulletFontColor(bulletFontColor);
                }
                double bulletFontSize = xSLFTextParagraph.getBulletFontSize();
                if (bulletFontSize != getBulletFontSize()) {
                    setBulletFontSize(bulletFontSize);
                }
            }
        }
        double leftMargin = xSLFTextParagraph.getLeftMargin();
        if (leftMargin != getLeftMargin()) {
            setLeftMargin(leftMargin);
        }
        double indent = xSLFTextParagraph.getIndent();
        if (indent != getIndent()) {
            setIndent(indent);
        }
        double spaceAfter = xSLFTextParagraph.getSpaceAfter();
        if (spaceAfter != getSpaceAfter()) {
            setSpaceAfter(spaceAfter);
        }
        double spaceBefore = xSLFTextParagraph.getSpaceBefore();
        if (spaceBefore != getSpaceBefore()) {
            setSpaceBefore(spaceBefore);
        }
        double lineSpacing = xSLFTextParagraph.getLineSpacing();
        if (lineSpacing != getLineSpacing()) {
            setLineSpacing(lineSpacing);
        }
        List<XSLFTextRun> textRuns = xSLFTextParagraph.getTextRuns();
        List<XSLFTextRun> textRuns2 = getTextRuns();
        for (int i = 0; i < textRuns.size(); i++) {
            textRuns2.get(i).copy(textRuns.get(i));
        }
    }
}
