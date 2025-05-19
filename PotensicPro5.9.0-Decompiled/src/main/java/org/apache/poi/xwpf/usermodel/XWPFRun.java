package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import com.baidu.geofence.GeoFence;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Internal;
import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class XWPFRun implements ISDTContents, IRunElement, CharacterRun {
    private IRunBody parent;
    private String pictureText;
    private List<XWPFPicture> pictures;
    private CTR run;

    public enum FontCharRange {
        ascii,
        cs,
        eastAsia,
        hAnsi
    }

    public void removeBreak() {
    }

    public void removeCarriageReturn() {
    }

    public void removeTab() {
    }

    public XWPFRun(CTR ctr, IRunBody iRunBody) {
        this.run = ctr;
        this.parent = iRunBody;
        for (CTDrawing cTDrawing : ctr.getDrawingArray()) {
            for (CTAnchor cTAnchor : cTDrawing.getAnchorArray()) {
                if (cTAnchor.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTAnchor.getDocPr().getId());
                }
            }
            for (CTInline cTInline : cTDrawing.getInlineArray()) {
                if (cTInline.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTInline.getDocPr().getId());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(ctr.getPictArray()));
        arrayList.addAll(Arrays.asList(ctr.getDrawingArray()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            for (XmlObject xmlObject : ((XmlObject) it.next()).selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t")) {
                NodeList childNodes = xmlObject.getDomNode().getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    if (childNodes.item(i) instanceof Text) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(childNodes.item(i).getNodeValue());
                    }
                }
            }
        }
        this.pictureText = sb.toString();
        this.pictures = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Iterator<CTPicture> it3 = getCTPictures((XmlObject) it2.next()).iterator();
            while (it3.hasNext()) {
                this.pictures.add(new XWPFPicture(it3.next(), this));
            }
        }
    }

    public XWPFRun(CTR ctr, XWPFParagraph xWPFParagraph) {
        this(ctr, (IRunBody) xWPFParagraph);
    }

    private List<CTPicture> getCTPictures(XmlObject xmlObject) {
        ArrayList arrayList = new ArrayList();
        XmlObject[] selectPath = xmlObject.selectPath("declare namespace pic='" + CTPicture.type.getName().getNamespaceURI() + "' .//pic:pic");
        int length = selectPath.length;
        for (int i = 0; i < length; i++) {
            XmlObject xmlObject2 = selectPath[i];
            if (xmlObject2 instanceof XmlAnyTypeImpl) {
                try {
                    xmlObject2 = CTPicture.Factory.parse(xmlObject2.toString());
                } catch (XmlException e) {
                    throw new POIXMLException(e);
                }
            }
            if (xmlObject2 instanceof CTPicture) {
                arrayList.add((CTPicture) xmlObject2);
            }
        }
        return arrayList;
    }

    @Internal
    public CTR getCTR() {
        return this.run;
    }

    public IRunBody getParent() {
        return this.parent;
    }

    public XWPFParagraph getParagraph() {
        IRunBody iRunBody = this.parent;
        if (iRunBody instanceof XWPFParagraph) {
            return (XWPFParagraph) iRunBody;
        }
        return null;
    }

    public XWPFDocument getDocument() {
        IRunBody iRunBody = this.parent;
        if (iRunBody != null) {
            return iRunBody.getDocument();
        }
        return null;
    }

    private boolean isCTOnOff(CTOnOff cTOnOff) {
        return !cTOnOff.isSetVal() || cTOnOff.getVal() == STOnOff.ON || cTOnOff.getVal() == STOnOff.TRUE;
    }

    public boolean isBold() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetB()) {
            return false;
        }
        return isCTOnOff(rPr.getB());
    }

    public void setBold(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetB() ? rPr.getB() : rPr.addNewB()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public String getColor() {
        if (this.run.isSetRPr()) {
            CTRPr rPr = this.run.getRPr();
            if (rPr.isSetColor()) {
                return rPr.getColor().xgetVal().getStringValue();
            }
        }
        return null;
    }

    public void setColor(String str) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetColor() ? rPr.getColor() : rPr.addNewColor()).setVal(str);
    }

    public String getText(int i) {
        if (this.run.sizeOfTArray() == 0) {
            return null;
        }
        return this.run.getTArray(i).getStringValue();
    }

    public String getPictureText() {
        return this.pictureText;
    }

    public void setText(String str) {
        setText(str, this.run.sizeOfTArray());
    }

    public void setText(String str, int i) {
        if (i > this.run.sizeOfTArray()) {
            throw new ArrayIndexOutOfBoundsException("Value too large for the parameter position in XWPFRun.setText(String value,int pos)");
        }
        CTText addNewT = (i >= this.run.sizeOfTArray() || i < 0) ? this.run.addNewT() : this.run.getTArray(i);
        addNewT.setStringValue(str);
        preserveSpaces(addNewT);
    }

    public boolean isItalic() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetI()) {
            return false;
        }
        return isCTOnOff(rPr.getI());
    }

    public void setItalic(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetI() ? rPr.getI() : rPr.addNewI()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public UnderlinePatterns getUnderline() {
        CTRPr rPr = this.run.getRPr();
        return (rPr == null || !rPr.isSetU() || rPr.getU().getVal() == null) ? UnderlinePatterns.NONE : UnderlinePatterns.valueOf(rPr.getU().getVal().intValue());
    }

    public void setUnderline(UnderlinePatterns underlinePatterns) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.getU() == null ? rPr.addNewU() : rPr.getU()).setVal(STUnderline.Enum.forInt(underlinePatterns.getValue()));
    }

    public boolean isStrikeThrough() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetStrike()) {
            return false;
        }
        return isCTOnOff(rPr.getStrike());
    }

    @Deprecated
    public boolean isStrike() {
        return isStrikeThrough();
    }

    public boolean isDoubleStrikeThrough() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetDstrike()) {
            return false;
        }
        return isCTOnOff(rPr.getDstrike());
    }

    public void setStrikeThrough(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetStrike() ? rPr.getStrike() : rPr.addNewStrike()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    @Deprecated
    public void setStrike(boolean z) {
        setStrikeThrough(z);
    }

    public void setDoubleStrikethrough(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetDstrike() ? rPr.getDstrike() : rPr.addNewDstrike()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public boolean isSmallCaps() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSmallCaps()) {
            return false;
        }
        return isCTOnOff(rPr.getSmallCaps());
    }

    public void setSmallCaps(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSmallCaps() ? rPr.getSmallCaps() : rPr.addNewSmallCaps()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public boolean isCapitalized() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetCaps()) {
            return false;
        }
        return isCTOnOff(rPr.getCaps());
    }

    public void setCapitalized(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetCaps() ? rPr.getCaps() : rPr.addNewCaps()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public boolean isShadowed() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetShadow()) {
            return false;
        }
        return isCTOnOff(rPr.getShadow());
    }

    public void setShadow(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetShadow() ? rPr.getShadow() : rPr.addNewShadow()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public boolean isImprinted() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetImprint()) {
            return false;
        }
        return isCTOnOff(rPr.getImprint());
    }

    public void setImprinted(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetImprint() ? rPr.getImprint() : rPr.addNewImprint()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public boolean isEmbossed() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetEmboss()) {
            return false;
        }
        return isCTOnOff(rPr.getEmboss());
    }

    public void setEmbossed(boolean z) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetEmboss() ? rPr.getEmboss() : rPr.addNewEmboss()).setVal(z ? STOnOff.TRUE : STOnOff.FALSE);
    }

    public VerticalAlign getSubscript() {
        CTRPr rPr = this.run.getRPr();
        return (rPr == null || !rPr.isSetVertAlign()) ? VerticalAlign.BASELINE : VerticalAlign.valueOf(rPr.getVertAlign().getVal().intValue());
    }

    public void setSubscript(VerticalAlign verticalAlign) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetVertAlign() ? rPr.getVertAlign() : rPr.addNewVertAlign()).setVal(STVerticalAlignRun.Enum.forInt(verticalAlign.getValue()));
    }

    public int getKerning() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetKern()) {
            return 0;
        }
        return rPr.getKern().getVal().intValue();
    }

    public void setKerning(int i) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetKern() ? rPr.getKern() : rPr.addNewKern()).setVal(BigInteger.valueOf(i));
    }

    public int getCharacterSpacing() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSpacing()) {
            return 0;
        }
        return rPr.getSpacing().getVal().intValue();
    }

    public void setCharacterSpacing(int i) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSpacing() ? rPr.getSpacing() : rPr.addNewSpacing()).setVal(BigInteger.valueOf(i));
    }

    public String getFontFamily() {
        return getFontFamily(null);
    }

    public String getFontName() {
        return getFontFamily();
    }

    public String getFontFamily(FontCharRange fontCharRange) {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetRFonts()) {
            return null;
        }
        CTFonts rFonts = rPr.getRFonts();
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange;
        if (fontCharRange == null) {
            fontCharRange = FontCharRange.ascii;
        }
        int i = iArr[fontCharRange.ordinal()];
        if (i == 2) {
            return rFonts.getCs();
        }
        if (i == 3) {
            return rFonts.getEastAsia();
        }
        if (i != 4) {
            return rFonts.getAscii();
        }
        return rFonts.getHAnsi();
    }

    /* renamed from: org.apache.poi.xwpf.usermodel.XWPFRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange;

        static {
            int[] iArr = new int[FontCharRange.values().length];
            $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange = iArr;
            try {
                iArr[FontCharRange.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.cs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.eastAsia.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.hAnsi.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void setFontFamily(String str) {
        setFontFamily(str, null);
    }

    public void setFontFamily(String str, FontCharRange fontCharRange) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        CTFonts rFonts = rPr.isSetRFonts() ? rPr.getRFonts() : rPr.addNewRFonts();
        if (fontCharRange == null) {
            rFonts.setAscii(str);
            if (!rFonts.isSetHAnsi()) {
                rFonts.setHAnsi(str);
            }
            if (!rFonts.isSetCs()) {
                rFonts.setCs(str);
            }
            if (rFonts.isSetEastAsia()) {
                return;
            }
            rFonts.setEastAsia(str);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[fontCharRange.ordinal()];
        if (i == 1) {
            rFonts.setAscii(str);
            return;
        }
        if (i == 2) {
            rFonts.setCs(str);
        } else if (i == 3) {
            rFonts.setEastAsia(str);
        } else {
            if (i != 4) {
                return;
            }
            rFonts.setHAnsi(str);
        }
    }

    public int getFontSize() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetSz()) {
            return -1;
        }
        return rPr.getSz().getVal().divide(new BigInteger(GeoFence.BUNDLE_KEY_CUSTOMID)).intValue();
    }

    public void setFontSize(int i) {
        BigInteger bigInteger = new BigInteger("" + i);
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetSz() ? rPr.getSz() : rPr.addNewSz()).setVal(bigInteger.multiply(new BigInteger(GeoFence.BUNDLE_KEY_CUSTOMID)));
    }

    public int getTextPosition() {
        CTRPr rPr = this.run.getRPr();
        if (rPr == null || !rPr.isSetPosition()) {
            return -1;
        }
        return rPr.getPosition().getVal().intValue();
    }

    public void setTextPosition(int i) {
        BigInteger bigInteger = new BigInteger("" + i);
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
        (rPr.isSetPosition() ? rPr.getPosition() : rPr.addNewPosition()).setVal(bigInteger);
    }

    public void addBreak() {
        this.run.addNewBr();
    }

    public void addBreak(BreakType breakType) {
        this.run.addNewBr().setType(STBrType.Enum.forInt(breakType.getValue()));
    }

    public void addBreak(BreakClear breakClear) {
        CTBr addNewBr = this.run.addNewBr();
        addNewBr.setType(STBrType.Enum.forInt(BreakType.TEXT_WRAPPING.getValue()));
        addNewBr.setClear(STBrClear.Enum.forInt(breakClear.getValue()));
    }

    public void addTab() {
        this.run.addNewTab();
    }

    public void addCarriageReturn() {
        this.run.addNewCr();
    }

    public XWPFPicture addPicture(InputStream inputStream, int i, String str, int i2, int i3) throws InvalidFormatException, IOException {
        XWPFDocument document = this.parent.getDocument();
        XWPFPictureData xWPFPictureData = (XWPFPictureData) document.getRelationById(document.addPictureData(inputStream, i));
        try {
            CTInline addNewInline = this.run.addNewDrawing().addNewInline();
            addNewInline.set(XmlToken.Factory.parse("<a:graphic xmlns:a=\"" + CTGraphicalObject.type.getName().getNamespaceURI() + "\"><a:graphicData uri=\"" + CTPicture.type.getName().getNamespaceURI() + "\"><pic:pic xmlns:pic=\"" + CTPicture.type.getName().getNamespaceURI() + "\" /></a:graphicData></a:graphic>"));
            addNewInline.setDistT(0L);
            addNewInline.setDistR(0L);
            addNewInline.setDistB(0L);
            addNewInline.setDistL(0L);
            CTNonVisualDrawingProps addNewDocPr = addNewInline.addNewDocPr();
            long reserveNew = getParent().getDocument().getDrawingIdManager().reserveNew();
            addNewDocPr.setId(reserveNew);
            addNewDocPr.setName("Drawing " + reserveNew);
            addNewDocPr.setDescr(str);
            CTPositiveSize2D addNewExtent = addNewInline.addNewExtent();
            long j = i2;
            addNewExtent.setCx(j);
            long j2 = i3;
            addNewExtent.setCy(j2);
            CTPicture cTPicture = getCTPictures(addNewInline.getGraphic().getGraphicData()).get(0);
            CTPictureNonVisual addNewNvPicPr = cTPicture.addNewNvPicPr();
            CTNonVisualDrawingProps addNewCNvPr = addNewNvPicPr.addNewCNvPr();
            addNewCNvPr.setId(0L);
            addNewCNvPr.setName("Picture " + reserveNew);
            addNewCNvPr.setDescr(str);
            addNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
            CTBlipFillProperties addNewBlipFill = cTPicture.addNewBlipFill();
            addNewBlipFill.addNewBlip().setEmbed(xWPFPictureData.getPackageRelationship().getId());
            addNewBlipFill.addNewStretch().addNewFillRect();
            CTShapeProperties addNewSpPr = cTPicture.addNewSpPr();
            CTTransform2D addNewXfrm = addNewSpPr.addNewXfrm();
            CTPoint2D addNewOff = addNewXfrm.addNewOff();
            addNewOff.setX(0L);
            addNewOff.setY(0L);
            CTPositiveSize2D addNewExt = addNewXfrm.addNewExt();
            addNewExt.setCx(j);
            addNewExt.setCy(j2);
            CTPresetGeometry2D addNewPrstGeom = addNewSpPr.addNewPrstGeom();
            addNewPrstGeom.setPrst(STShapeType.RECT);
            addNewPrstGeom.addNewAvLst();
            XWPFPicture xWPFPicture = new XWPFPicture(cTPicture, this);
            this.pictures.add(xWPFPicture);
            return xWPFPicture;
        } catch (XmlException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<XWPFPicture> getEmbeddedPictures() {
        return this.pictures;
    }

    static void preserveSpaces(XmlString xmlString) {
        String stringValue = xmlString.getStringValue();
        if (stringValue != null) {
            if (stringValue.startsWith(StringUtils.SPACE) || stringValue.endsWith(StringUtils.SPACE)) {
                XmlCursor newCursor = xmlString.newCursor();
                newCursor.toNextToken();
                newCursor.insertAttributeWithValue(new QName("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
                newCursor.dispose();
            }
        }
    }

    public String toString() {
        return text();
    }

    public String text() {
        StringBuilder sb;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        XmlCursor newCursor = this.run.newCursor();
        newCursor.selectPath("./*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if ((object instanceof CTText) && !"w:instrText".equals(object.getDomNode().getNodeName())) {
                stringBuffer.append(((CTText) object).getStringValue());
            }
            if (object instanceof CTFldChar) {
                CTFldChar cTFldChar = (CTFldChar) object;
                if (cTFldChar.getFldCharType() == STFldCharType.BEGIN && cTFldChar.getFfData() != null) {
                    Iterator<CTFFCheckBox> it = cTFldChar.getFfData().getCheckBoxList().iterator();
                    while (it.hasNext()) {
                        if (it.next().getDefault().getVal() == STOnOff.X_1) {
                            stringBuffer.append("|X|");
                        } else {
                            stringBuffer.append("|_|");
                        }
                    }
                }
            }
            if (object instanceof CTPTab) {
                stringBuffer.append("\t");
            }
            if (object instanceof CTBr) {
                stringBuffer.append("\n");
            }
            if (object instanceof CTEmpty) {
                String nodeName = object.getDomNode().getNodeName();
                if ("w:tab".equals(nodeName) || "tab".equals(nodeName)) {
                    stringBuffer.append("\t");
                }
                if ("w:br".equals(nodeName) || TtmlNode.TAG_BR.equals(nodeName)) {
                    stringBuffer.append("\n");
                }
                if ("w:cr".equals(nodeName) || "cr".equals(nodeName)) {
                    stringBuffer.append("\n");
                }
            }
            if (object instanceof CTFtnEdnRef) {
                CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) object;
                if (cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference")) {
                    sb = new StringBuilder();
                    str = "[footnoteRef:";
                } else {
                    sb = new StringBuilder();
                    str = "[endnoteRef:";
                }
                stringBuffer.append(sb.append(str).append(cTFtnEdnRef.getId().intValue()).append("]").toString());
            }
        }
        newCursor.dispose();
        String str2 = this.pictureText;
        if (str2 != null && str2.length() > 0) {
            stringBuffer.append("\n").append(this.pictureText);
        }
        return stringBuffer.toString();
    }
}
