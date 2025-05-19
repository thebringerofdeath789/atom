package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

/* loaded from: classes5.dex */
public class XWPFParagraph implements IBodyElement, IRunBody, ISDTContents, Paragraph {
    protected XWPFDocument document;
    private StringBuffer footnoteText = new StringBuffer();
    protected List<IRunElement> iruns;
    private final CTP paragraph;
    protected IBody part;
    protected List<XWPFRun> runs;

    public XWPFParagraph(CTP ctp, IBody iBody) {
        this.paragraph = ctp;
        this.part = iBody;
        XWPFDocument xWPFDocument = iBody.getXWPFDocument();
        this.document = xWPFDocument;
        Objects.requireNonNull(xWPFDocument);
        this.runs = new ArrayList();
        this.iruns = new ArrayList();
        buildRunsInOrderFromXml(ctp);
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            XmlCursor newCursor = it.next().getCTR().newCursor();
            newCursor.selectPath("child::*");
            while (newCursor.toNextSelection()) {
                XmlObject object = newCursor.getObject();
                if (object instanceof CTFtnEdnRef) {
                    CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) object;
                    this.footnoteText.append(" [").append(cTFtnEdnRef.getId()).append(": ");
                    Iterator<XWPFParagraph> it2 = (cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? this.document.getFootnoteByID(cTFtnEdnRef.getId().intValue()) : this.document.getEndnoteByID(cTFtnEdnRef.getId().intValue())).getParagraphs().iterator();
                    while (it2.hasNext()) {
                        this.footnoteText.append(it2.next().getText());
                    }
                    this.footnoteText.append("] ");
                }
            }
            newCursor.dispose();
        }
    }

    private void buildRunsInOrderFromXml(XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        newCursor.selectPath("child::*");
        while (newCursor.toNextSelection()) {
            XmlObject object = newCursor.getObject();
            if (object instanceof CTR) {
                XWPFRun xWPFRun = new XWPFRun((CTR) object, this);
                this.runs.add(xWPFRun);
                this.iruns.add(xWPFRun);
            }
            if (object instanceof CTHyperlink) {
                CTHyperlink cTHyperlink = (CTHyperlink) object;
                for (CTR ctr : cTHyperlink.getRArray()) {
                    XWPFHyperlinkRun xWPFHyperlinkRun = new XWPFHyperlinkRun(cTHyperlink, ctr, this);
                    this.runs.add(xWPFHyperlinkRun);
                    this.iruns.add(xWPFHyperlinkRun);
                }
            }
            if (object instanceof CTSdtBlock) {
                this.iruns.add(new XWPFSDT((CTSdtBlock) object, this.part));
            }
            if (object instanceof CTSdtRun) {
                this.iruns.add(new XWPFSDT((CTSdtRun) object, this.part));
            }
            if (object instanceof CTRunTrackChange) {
                for (CTR ctr2 : ((CTRunTrackChange) object).getRArray()) {
                    XWPFRun xWPFRun2 = new XWPFRun(ctr2, this);
                    this.runs.add(xWPFRun2);
                    this.iruns.add(xWPFRun2);
                }
            }
            if (object instanceof CTSimpleField) {
                for (CTR ctr3 : ((CTSimpleField) object).getRArray()) {
                    XWPFRun xWPFRun3 = new XWPFRun(ctr3, this);
                    this.runs.add(xWPFRun3);
                    this.iruns.add(xWPFRun3);
                }
            }
            if (object instanceof CTSmartTagRun) {
                buildRunsInOrderFromXml(object);
            }
        }
        newCursor.dispose();
    }

    @Internal
    public CTP getCTP() {
        return this.paragraph;
    }

    public List<XWPFRun> getRuns() {
        return Collections.unmodifiableList(this.runs);
    }

    public List<IRunElement> getIRuns() {
        return Collections.unmodifiableList(this.iruns);
    }

    public boolean isEmpty() {
        return !this.paragraph.getDomNode().hasChildNodes();
    }

    @Override // org.apache.poi.xwpf.usermodel.IRunBody
    public XWPFDocument getDocument() {
        return this.document;
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (IRunElement iRunElement : this.iruns) {
            if (iRunElement instanceof XWPFSDT) {
                stringBuffer.append(((XWPFSDT) iRunElement).getContent().getText());
            } else {
                stringBuffer.append(iRunElement.toString());
            }
        }
        stringBuffer.append(this.footnoteText);
        return stringBuffer.toString();
    }

    public String getStyleID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getPStyle() == null || this.paragraph.getPPr().getPStyle().getVal() == null) {
            return null;
        }
        return this.paragraph.getPPr().getPStyle().getVal();
    }

    public BigInteger getNumID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getNumId() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getNumId().getVal();
    }

    public BigInteger getNumIlvl() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getIlvl() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getIlvl().getVal();
    }

    public String getNumFmt() {
        XWPFNum num;
        CTLvl cTLvl;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTAbstractNum abstractNum = numbering.getAbstractNum(num.getCTNum().getAbstractNumId().getVal()).getAbstractNum();
            int i = 0;
            while (true) {
                if (i >= abstractNum.sizeOfLvlArray()) {
                    cTLvl = null;
                    break;
                }
                cTLvl = abstractNum.getLvlArray(i);
                if (cTLvl.getIlvl().equals(numIlvl)) {
                    break;
                }
                i++;
            }
            if (cTLvl != null && cTLvl.getNumFmt() != null && cTLvl.getNumFmt().getVal() != null) {
                return cTLvl.getNumFmt().getVal().toString();
            }
        }
        return null;
    }

    public String getNumLevelText() {
        XWPFNum num;
        CTDecimalNumber abstractNumId;
        BigInteger val;
        XWPFAbstractNum abstractNum;
        CTAbstractNum cTAbstractNum;
        CTLvl cTLvl;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTNum cTNum = num.getCTNum();
            if (cTNum == null || (abstractNumId = cTNum.getAbstractNumId()) == null || (val = abstractNumId.getVal()) == null || (abstractNum = numbering.getAbstractNum(val)) == null || (cTAbstractNum = abstractNum.getCTAbstractNum()) == null) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i >= cTAbstractNum.sizeOfLvlArray()) {
                    cTLvl = null;
                    break;
                }
                cTLvl = cTAbstractNum.getLvlArray(i);
                if (cTLvl != null && cTLvl.getIlvl() != null && cTLvl.getIlvl().equals(numIlvl)) {
                    break;
                }
                i++;
            }
            if (cTLvl != null && cTLvl.getLvlText() != null && cTLvl.getLvlText().getVal() != null) {
                return cTLvl.getLvlText().getVal().toString();
            }
        }
        return null;
    }

    public BigInteger getNumStartOverride() {
        XWPFNum num;
        CTNum cTNum;
        CTNumLvl cTNumLvl;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID == null || numbering == null || (num = numbering.getNum(numID)) == null || (cTNum = num.getCTNum()) == null) {
            return null;
        }
        BigInteger numIlvl = getNumIlvl();
        int i = 0;
        while (true) {
            if (i >= cTNum.sizeOfLvlOverrideArray()) {
                cTNumLvl = null;
                break;
            }
            cTNumLvl = cTNum.getLvlOverrideArray(i);
            if (cTNumLvl != null && cTNumLvl.getIlvl() != null && cTNumLvl.getIlvl().equals(numIlvl)) {
                break;
            }
            i++;
        }
        if (cTNumLvl != null && cTNumLvl.getStartOverride() != null) {
            return cTNumLvl.getStartOverride().getVal();
        }
        return null;
    }

    public void setNumID(BigInteger bigInteger) {
        if (this.paragraph.getPPr() == null) {
            this.paragraph.addNewPPr();
        }
        if (this.paragraph.getPPr().getNumPr() == null) {
            this.paragraph.getPPr().addNewNumPr();
        }
        if (this.paragraph.getPPr().getNumPr().getNumId() == null) {
            this.paragraph.getPPr().getNumPr().addNewNumId();
        }
        this.paragraph.getPPr().getNumPr().getNumId().setVal(bigInteger);
    }

    public String getParagraphText() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public String getPictureText() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().getPictureText());
        }
        return stringBuffer.toString();
    }

    public String getFootnoteText() {
        return this.footnoteText.toString();
    }

    public ParagraphAlignment getAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetJc()) ? ParagraphAlignment.LEFT : ParagraphAlignment.valueOf(cTPPr.getJc().getVal().intValue());
    }

    public void setAlignment(ParagraphAlignment paragraphAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetJc() ? cTPPr.getJc() : cTPPr.addNewJc()).setVal(STJc.Enum.forInt(paragraphAlignment.getValue()));
    }

    public int getFontAlignment() {
        return getAlignment().getValue();
    }

    public void setFontAlignment(int i) {
        setAlignment(ParagraphAlignment.valueOf(i));
    }

    public TextAlignment getVerticalAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetTextAlignment()) ? TextAlignment.AUTO : TextAlignment.valueOf(cTPPr.getTextAlignment().getVal().intValue());
    }

    public void setVerticalAlignment(TextAlignment textAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetTextAlignment() ? cTPPr.getTextAlignment() : cTPPr.addNewTextAlignment()).setVal(STTextAlignment.Enum.forInt(textAlignment.getValue()));
    }

    public void setBorderTop(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        if (cTPBrd == null) {
            throw new RuntimeException("invalid paragraph state");
        }
        CTBorder top = cTPBrd.isSetTop() ? cTPBrd.getTop() : cTPBrd.addNewTop();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetTop();
        } else {
            top.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderTop() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder top = cTPBrd != null ? cTPBrd.getTop() : null;
        return Borders.valueOf((top != null ? top.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderBottom(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder bottom = cTPBrd.isSetBottom() ? cTPBrd.getBottom() : cTPBrd.addNewBottom();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBottom();
        } else {
            bottom.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderBottom() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder bottom = cTPBrd != null ? cTPBrd.getBottom() : null;
        return Borders.valueOf((bottom != null ? bottom.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderLeft(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder left = cTPBrd.isSetLeft() ? cTPBrd.getLeft() : cTPBrd.addNewLeft();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetLeft();
        } else {
            left.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderLeft() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder left = cTPBrd != null ? cTPBrd.getLeft() : null;
        return Borders.valueOf((left != null ? left.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderRight(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder right = cTPBrd.isSetRight() ? cTPBrd.getRight() : cTPBrd.addNewRight();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetRight();
        } else {
            right.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderRight() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder right = cTPBrd != null ? cTPBrd.getRight() : null;
        return Borders.valueOf((right != null ? right.getVal() : STBorder.NONE).intValue());
    }

    public void setBorderBetween(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder between = cTPBrd.isSetBetween() ? cTPBrd.getBetween() : cTPBrd.addNewBetween();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBetween();
        } else {
            between.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public Borders getBorderBetween() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder between = cTPBrd != null ? cTPBrd.getBetween() : null;
        return Borders.valueOf((between != null ? between.getVal() : STBorder.NONE).intValue());
    }

    public void setPageBreak(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTOnOff pageBreakBefore = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : cTPPr.addNewPageBreakBefore();
        if (z) {
            pageBreakBefore.setVal(STOnOff.TRUE);
        } else {
            pageBreakBefore.setVal(STOnOff.FALSE);
        }
    }

    public boolean isPageBreak() {
        CTPPr cTPPr = getCTPPr();
        CTOnOff pageBreakBefore = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : null;
        return pageBreakBefore != null && pageBreakBefore.getVal().intValue() == 1;
    }

    public void setSpacingAfter(int i) {
        CTSpacing cTSpacing = getCTSpacing(true);
        if (cTSpacing != null) {
            cTSpacing.setAfter(new BigInteger("" + i));
        }
    }

    public int getSpacingAfter() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfter()) {
            return -1;
        }
        return cTSpacing.getAfter().intValue();
    }

    public void setSpacingAfterLines(int i) {
        getCTSpacing(true).setAfterLines(new BigInteger("" + i));
    }

    public int getSpacingAfterLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfterLines()) {
            return -1;
        }
        return cTSpacing.getAfterLines().intValue();
    }

    public void setSpacingBefore(int i) {
        getCTSpacing(true).setBefore(new BigInteger("" + i));
    }

    public int getSpacingBefore() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBefore()) {
            return -1;
        }
        return cTSpacing.getBefore().intValue();
    }

    public void setSpacingBeforeLines(int i) {
        getCTSpacing(true).setBeforeLines(new BigInteger("" + i));
    }

    public int getSpacingBeforeLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBeforeLines()) {
            return -1;
        }
        return cTSpacing.getBeforeLines().intValue();
    }

    public void setSpacingLineRule(LineSpacingRule lineSpacingRule) {
        getCTSpacing(true).setLineRule(STLineSpacingRule.Enum.forInt(lineSpacingRule.getValue()));
    }

    public LineSpacingRule getSpacingLineRule() {
        CTSpacing cTSpacing = getCTSpacing(false);
        return (cTSpacing == null || !cTSpacing.isSetLineRule()) ? LineSpacingRule.AUTO : LineSpacingRule.valueOf(cTSpacing.getLineRule().intValue());
    }

    public void setIndentationLeft(int i) {
        getCTInd(true).setLeft(new BigInteger("" + i));
    }

    public int getIndentationLeft() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetLeft()) {
            return -1;
        }
        return cTInd.getLeft().intValue();
    }

    public void setIndentationRight(int i) {
        getCTInd(true).setRight(new BigInteger("" + i));
    }

    public int getIndentationRight() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetRight()) {
            return -1;
        }
        return cTInd.getRight().intValue();
    }

    public void setIndentationHanging(int i) {
        getCTInd(true).setHanging(new BigInteger("" + i));
    }

    public int getIndentationHanging() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetHanging()) {
            return -1;
        }
        return cTInd.getHanging().intValue();
    }

    public void setIndentationFirstLine(int i) {
        getCTInd(true).setFirstLine(new BigInteger("" + i));
    }

    public int getIndentationFirstLine() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetFirstLine()) {
            return -1;
        }
        return cTInd.getFirstLine().intValue();
    }

    public int getIndentFromLeft() {
        return getIndentFromLeft();
    }

    public void setIndentFromLeft(int i) {
        setIndentationLeft(i);
    }

    public int getIndentFromRight() {
        return getIndentFromRight();
    }

    public void setIndentFromRight(int i) {
        setIndentationRight(i);
    }

    public int getFirstLineIndent() {
        return getIndentationFirstLine();
    }

    public void setFirstLineIndent(int i) {
        setIndentationFirstLine(i);
    }

    public void setWordWrapped(boolean z) {
        CTOnOff wordWrap = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : getCTPPr().addNewWordWrap();
        if (z) {
            wordWrap.setVal(STOnOff.TRUE);
        } else {
            wordWrap.unsetVal();
        }
    }

    @Deprecated
    public void setWordWrap(boolean z) {
        setWordWrapped(z);
    }

    public boolean isWordWrapped() {
        CTOnOff wordWrap = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : null;
        if (wordWrap != null) {
            return wordWrap.getVal() == STOnOff.ON || wordWrap.getVal() == STOnOff.TRUE || wordWrap.getVal() == STOnOff.X_1;
        }
        return false;
    }

    public boolean isWordWrap() {
        return isWordWrapped();
    }

    public void setStyle(String str) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.getPStyle() != null ? cTPPr.getPStyle() : cTPPr.addNewPStyle()).setVal(str);
    }

    public String getStyle() {
        CTPPr cTPPr = getCTPPr();
        CTString pStyle = cTPPr.isSetPStyle() ? cTPPr.getPStyle() : null;
        if (pStyle != null) {
            return pStyle.getVal();
        }
        return null;
    }

    private CTPBdr getCTPBrd(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTPBdr pBdr = cTPPr.isSetPBdr() ? cTPPr.getPBdr() : null;
        return (z && pBdr == null) ? cTPPr.addNewPBdr() : pBdr;
    }

    private CTSpacing getCTSpacing(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTSpacing spacing = cTPPr.getSpacing() == null ? null : cTPPr.getSpacing();
        return (z && spacing == null) ? cTPPr.addNewSpacing() : spacing;
    }

    private CTInd getCTInd(boolean z) {
        CTPPr cTPPr = getCTPPr();
        CTInd ind = cTPPr.getInd() == null ? null : cTPPr.getInd();
        return (z && ind == null) ? cTPPr.addNewInd() : ind;
    }

    private CTPPr getCTPPr() {
        return this.paragraph.getPPr() == null ? this.paragraph.addNewPPr() : this.paragraph.getPPr();
    }

    protected void addRun(CTR ctr) {
        int sizeOfRArray = this.paragraph.sizeOfRArray();
        this.paragraph.addNewR();
        this.paragraph.setRArray(sizeOfRArray, ctr);
    }

    public XWPFRun createRun() {
        XWPFRun xWPFRun = new XWPFRun(this.paragraph.addNewR(), this);
        this.runs.add(xWPFRun);
        this.iruns.add(xWPFRun);
        return xWPFRun;
    }

    public XWPFRun insertNewRun(int i) {
        if (i < 0 || i > this.paragraph.sizeOfRArray()) {
            return null;
        }
        XWPFRun xWPFRun = new XWPFRun(this.paragraph.insertNewR(i), this);
        int size = this.iruns.size();
        if (i < this.runs.size()) {
            int indexOf = this.iruns.indexOf(this.runs.get(i));
            if (indexOf != -1) {
                size = indexOf;
            }
        }
        this.iruns.add(size, xWPFRun);
        this.runs.add(i, xWPFRun);
        return xWPFRun;
    }

    public TextSegement searchText(String str, PositionInParagraph positionInParagraph) {
        int i;
        int i2;
        int i3;
        int i4;
        int run = positionInParagraph.getRun();
        int text = positionInParagraph.getText();
        int i5 = positionInParagraph.getChar();
        CTR[] rArray = this.paragraph.getRArray();
        int i6 = run;
        int i7 = 0;
        boolean z = false;
        int i8 = 0;
        while (i6 < rArray.length) {
            XmlCursor newCursor = rArray[i6].newCursor();
            newCursor.selectPath("./*");
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (newCursor.toNextSelection()) {
                XmlObject object = newCursor.getObject();
                if (object instanceof CTText) {
                    if (i9 >= text) {
                        String stringValue = ((CTText) object).getStringValue();
                        if (i6 == run) {
                            i = run;
                            i4 = i5;
                        } else {
                            i = run;
                            i4 = 0;
                        }
                        while (i4 < stringValue.length()) {
                            int i12 = text;
                            int i13 = i5;
                            if (stringValue.charAt(i4) == str.charAt(0) && i7 == 0) {
                                z = true;
                                i8 = i6;
                                i10 = i9;
                                i11 = i4;
                            }
                            if (stringValue.charAt(i4) == str.charAt(i7)) {
                                int i14 = i7 + 1;
                                if (i14 < str.length()) {
                                    i7 = i14;
                                } else if (z) {
                                    TextSegement textSegement = new TextSegement();
                                    textSegement.setBeginRun(i8);
                                    textSegement.setBeginText(i10);
                                    textSegement.setBeginChar(i11);
                                    textSegement.setEndRun(i6);
                                    textSegement.setEndText(i9);
                                    textSegement.setEndChar(i4);
                                    return textSegement;
                                }
                            } else {
                                i7 = 0;
                            }
                            i4++;
                            i5 = i13;
                            text = i12;
                        }
                    } else {
                        i = run;
                    }
                    i2 = text;
                    i3 = i5;
                    i9++;
                } else {
                    i = run;
                    i2 = text;
                    i3 = i5;
                    if (object instanceof CTProofErr) {
                        newCursor.removeXml();
                    } else if (!(object instanceof CTRPr)) {
                        i7 = 0;
                    }
                }
                i5 = i3;
                run = i;
                text = i2;
            }
            newCursor.dispose();
            i6++;
            text = text;
        }
        return null;
    }

    public String getText(TextSegement textSegement) {
        int beginRun = textSegement.getBeginRun();
        int beginText = textSegement.getBeginText();
        int beginChar = textSegement.getBeginChar();
        int endRun = textSegement.getEndRun();
        int endText = textSegement.getEndText();
        int endChar = textSegement.getEndChar();
        StringBuilder sb = new StringBuilder();
        CTR[] rArray = this.paragraph.getRArray();
        int i = beginRun;
        while (i <= endRun) {
            CTText[] tArray = rArray[i].getTArray();
            int length = tArray.length - 1;
            int i2 = i == beginRun ? beginText : 0;
            if (i == endRun) {
                length = endText;
            }
            while (i2 <= length) {
                String stringValue = tArray[i2].getStringValue();
                int length2 = stringValue.length() - 1;
                int i3 = (i2 == beginText && i == beginRun) ? beginChar : 0;
                if (i2 == endText && i == endRun) {
                    length2 = endChar;
                }
                sb.append(stringValue.substring(i3, length2 + 1));
                i2++;
            }
            i++;
        }
        return sb.toString();
    }

    public boolean removeRun(int i) {
        if (i < 0 || i >= this.paragraph.sizeOfRArray()) {
            return false;
        }
        XWPFRun xWPFRun = this.runs.get(i);
        this.runs.remove(i);
        this.iruns.remove(xWPFRun);
        getCTP().removeR(i);
        return true;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.PARAGRAPH;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public void addRun(XWPFRun xWPFRun) {
        if (this.runs.contains(xWPFRun)) {
            return;
        }
        this.runs.add(xWPFRun);
    }

    public XWPFRun getRun(CTR ctr) {
        for (int i = 0; i < getRuns().size(); i++) {
            if (getRuns().get(i).getCTR() == ctr) {
                return getRuns().get(i);
            }
        }
        return null;
    }
}
