package org.apache.poi.xwpf.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFactory;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFHeaderFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import schemasMicrosoftComOfficeOffice.STConnectType;
import schemasMicrosoftComVml.CTFormulas;
import schemasMicrosoftComVml.CTGroup;
import schemasMicrosoftComVml.CTH;
import schemasMicrosoftComVml.CTPath;
import schemasMicrosoftComVml.CTShape;
import schemasMicrosoftComVml.CTShapetype;
import schemasMicrosoftComVml.CTTextPath;
import schemasMicrosoftComVml.STExt;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes5.dex */
public class XWPFHeaderFooterPolicy {
    public static final STHdrFtr.Enum DEFAULT = STHdrFtr.DEFAULT;
    public static final STHdrFtr.Enum EVEN = STHdrFtr.EVEN;
    public static final STHdrFtr.Enum FIRST = STHdrFtr.FIRST;
    private XWPFFooter defaultFooter;
    private XWPFHeader defaultHeader;
    private XWPFDocument doc;
    private XWPFFooter evenPageFooter;
    private XWPFHeader evenPageHeader;
    private XWPFFooter firstPageFooter;
    private XWPFHeader firstPageHeader;

    public XWPFHeaderFooterPolicy(XWPFDocument xWPFDocument) throws IOException, XmlException {
        this(xWPFDocument, xWPFDocument.getDocument().getBody().getSectPr());
    }

    public XWPFHeaderFooterPolicy(XWPFDocument xWPFDocument, CTSectPr cTSectPr) throws IOException, XmlException {
        this.doc = xWPFDocument;
        int i = 0;
        while (true) {
            XWPFHeader xWPFHeader = null;
            if (i >= cTSectPr.sizeOfHeaderReferenceArray()) {
                break;
            }
            CTHdrFtrRef headerReferenceArray = cTSectPr.getHeaderReferenceArray(i);
            POIXMLDocumentPart relationById = xWPFDocument.getRelationById(headerReferenceArray.getId());
            if (relationById != null && (relationById instanceof XWPFHeader)) {
                xWPFHeader = (XWPFHeader) relationById;
            }
            assignHeader(xWPFHeader, headerReferenceArray.getType());
            i++;
        }
        for (int i2 = 0; i2 < cTSectPr.sizeOfFooterReferenceArray(); i2++) {
            CTHdrFtrRef footerReferenceArray = cTSectPr.getFooterReferenceArray(i2);
            POIXMLDocumentPart relationById2 = xWPFDocument.getRelationById(footerReferenceArray.getId());
            assignFooter((relationById2 == null || !(relationById2 instanceof XWPFFooter)) ? null : (XWPFFooter) relationById2, footerReferenceArray.getType());
        }
    }

    private void assignFooter(XWPFFooter xWPFFooter, STHdrFtr.Enum r3) {
        if (r3 == STHdrFtr.FIRST) {
            this.firstPageFooter = xWPFFooter;
        } else if (r3 == STHdrFtr.EVEN) {
            this.evenPageFooter = xWPFFooter;
        } else {
            this.defaultFooter = xWPFFooter;
        }
    }

    private void assignHeader(XWPFHeader xWPFHeader, STHdrFtr.Enum r3) {
        if (r3 == STHdrFtr.FIRST) {
            this.firstPageHeader = xWPFHeader;
        } else if (r3 == STHdrFtr.EVEN) {
            this.evenPageHeader = xWPFHeader;
        } else {
            this.defaultHeader = xWPFHeader;
        }
    }

    public XWPFHeader createHeader(STHdrFtr.Enum r2) throws IOException {
        return createHeader(r2, null);
    }

    public XWPFHeader createHeader(STHdrFtr.Enum r6, XWPFParagraph[] xWPFParagraphArr) throws IOException {
        XWPFRelation xWPFRelation = XWPFRelation.HEADER;
        int relationIndex = getRelationIndex(xWPFRelation);
        HdrDocument newInstance = HdrDocument.Factory.newInstance();
        XWPFHeader xWPFHeader = (XWPFHeader) this.doc.createRelationship(xWPFRelation, XWPFFactory.getInstance(), relationIndex);
        CTHdrFtr buildHdr = buildHdr(r6, "Header", xWPFHeader, xWPFParagraphArr);
        xWPFHeader.setHeaderFooter(buildHdr);
        OutputStream outputStream = xWPFHeader.getPackagePart().getOutputStream();
        newInstance.setHdr(buildHdr);
        XmlOptions commit = commit(xWPFHeader);
        assignHeader(xWPFHeader, r6);
        newInstance.save(outputStream, commit);
        outputStream.close();
        return xWPFHeader;
    }

    public XWPFFooter createFooter(STHdrFtr.Enum r2) throws IOException {
        return createFooter(r2, null);
    }

    public XWPFFooter createFooter(STHdrFtr.Enum r6, XWPFParagraph[] xWPFParagraphArr) throws IOException {
        XWPFRelation xWPFRelation = XWPFRelation.FOOTER;
        int relationIndex = getRelationIndex(xWPFRelation);
        FtrDocument newInstance = FtrDocument.Factory.newInstance();
        XWPFFooter xWPFFooter = (XWPFFooter) this.doc.createRelationship(xWPFRelation, XWPFFactory.getInstance(), relationIndex);
        CTHdrFtr buildFtr = buildFtr(r6, "Footer", xWPFFooter, xWPFParagraphArr);
        xWPFFooter.setHeaderFooter(buildFtr);
        OutputStream outputStream = xWPFFooter.getPackagePart().getOutputStream();
        newInstance.setFtr(buildFtr);
        XmlOptions commit = commit(xWPFFooter);
        assignFooter(xWPFFooter, r6);
        newInstance.save(outputStream, commit);
        outputStream.close();
        return xWPFFooter;
    }

    private int getRelationIndex(XWPFRelation xWPFRelation) {
        Iterator<POIXMLDocumentPart> it = this.doc.getRelations().iterator();
        int i = 1;
        while (it.hasNext()) {
            if (it.next().getPackageRelationship().getRelationshipType().equals(xWPFRelation.getRelation())) {
                i++;
            }
        }
        return i;
    }

    private CTHdrFtr buildFtr(STHdrFtr.Enum r1, String str, XWPFHeaderFooter xWPFHeaderFooter, XWPFParagraph[] xWPFParagraphArr) {
        CTHdrFtr buildHdrFtr = buildHdrFtr(str, xWPFParagraphArr, xWPFHeaderFooter);
        setFooterReference(r1, xWPFHeaderFooter);
        return buildHdrFtr;
    }

    private CTHdrFtr buildHdr(STHdrFtr.Enum r1, String str, XWPFHeaderFooter xWPFHeaderFooter, XWPFParagraph[] xWPFParagraphArr) {
        CTHdrFtr buildHdrFtr = buildHdrFtr(str, xWPFParagraphArr, xWPFHeaderFooter);
        setHeaderReference(r1, xWPFHeaderFooter);
        return buildHdrFtr;
    }

    private CTHdrFtr buildHdrFtr(String str, XWPFParagraph[] xWPFParagraphArr) {
        CTHdrFtr newInstance = CTHdrFtr.Factory.newInstance();
        if (xWPFParagraphArr != null) {
            for (int i = 0; i < xWPFParagraphArr.length; i++) {
                newInstance.addNewP();
                newInstance.setPArray(i, xWPFParagraphArr[i].getCTP());
            }
        } else {
            CTP addNewP = newInstance.addNewP();
            byte[] rsidR = this.doc.getDocument().getBody().getPArray(0).getRsidR();
            byte[] rsidRDefault = this.doc.getDocument().getBody().getPArray(0).getRsidRDefault();
            addNewP.setRsidP(rsidR);
            addNewP.setRsidRDefault(rsidRDefault);
            addNewP.addNewPPr().addNewPStyle().setVal(str);
        }
        return newInstance;
    }

    private CTHdrFtr buildHdrFtr(String str, XWPFParagraph[] xWPFParagraphArr, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtr _getHdrFtr = xWPFHeaderFooter._getHdrFtr();
        if (xWPFParagraphArr != null) {
            for (int i = 0; i < xWPFParagraphArr.length; i++) {
                _getHdrFtr.addNewP();
                _getHdrFtr.setPArray(i, xWPFParagraphArr[i].getCTP());
            }
        } else {
            CTP addNewP = _getHdrFtr.addNewP();
            byte[] rsidR = this.doc.getDocument().getBody().getPArray(0).getRsidR();
            byte[] rsidRDefault = this.doc.getDocument().getBody().getPArray(0).getRsidRDefault();
            addNewP.setRsidP(rsidR);
            addNewP.setRsidRDefault(rsidRDefault);
            addNewP.addNewPPr().addNewPStyle().setVal(str);
        }
        return _getHdrFtr;
    }

    private void setFooterReference(STHdrFtr.Enum r2, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtrRef addNewFooterReference = this.doc.getDocument().getBody().getSectPr().addNewFooterReference();
        addNewFooterReference.setType(r2);
        addNewFooterReference.setId(xWPFHeaderFooter.getPackageRelationship().getId());
    }

    private void setHeaderReference(STHdrFtr.Enum r2, XWPFHeaderFooter xWPFHeaderFooter) {
        CTHdrFtrRef addNewHeaderReference = this.doc.getDocument().getBody().getSectPr().addNewHeaderReference();
        addNewHeaderReference.setType(r2);
        addNewHeaderReference.setId(xWPFHeaderFooter.getPackageRelationship().getId());
    }

    private XmlOptions commit(XWPFHeaderFooter xWPFHeaderFooter) {
        XmlOptions xmlOptions = new XmlOptions(POIXMLDocumentPart.DEFAULT_XML_OPTIONS);
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        hashMap.put("urn:schemas-microsoft-com:office:office", "o");
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        hashMap.put("urn:schemas-microsoft-com:vml", "v");
        hashMap.put(PackageNamespaces.MARKUP_COMPATIBILITY, "ve");
        hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        hashMap.put("urn:schemas-microsoft-com:office:word", "w10");
        hashMap.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        return xmlOptions;
    }

    public XWPFHeader getFirstPageHeader() {
        return this.firstPageHeader;
    }

    public XWPFFooter getFirstPageFooter() {
        return this.firstPageFooter;
    }

    public XWPFHeader getOddPageHeader() {
        return this.defaultHeader;
    }

    public XWPFFooter getOddPageFooter() {
        return this.defaultFooter;
    }

    public XWPFHeader getEvenPageHeader() {
        return this.evenPageHeader;
    }

    public XWPFFooter getEvenPageFooter() {
        return this.evenPageFooter;
    }

    public XWPFHeader getDefaultHeader() {
        return this.defaultHeader;
    }

    public XWPFFooter getDefaultFooter() {
        return this.defaultFooter;
    }

    public XWPFHeader getHeader(int i) {
        XWPFHeader xWPFHeader;
        XWPFHeader xWPFHeader2;
        return (i != 1 || (xWPFHeader2 = this.firstPageHeader) == null) ? (i % 2 != 0 || (xWPFHeader = this.evenPageHeader) == null) ? this.defaultHeader : xWPFHeader : xWPFHeader2;
    }

    public XWPFFooter getFooter(int i) {
        XWPFFooter xWPFFooter;
        XWPFFooter xWPFFooter2;
        return (i != 1 || (xWPFFooter2 = this.firstPageFooter) == null) ? (i % 2 != 0 || (xWPFFooter = this.evenPageFooter) == null) ? this.defaultFooter : xWPFFooter : xWPFFooter2;
    }

    public void createWatermark(String str) {
        XWPFParagraph[] xWPFParagraphArr = new XWPFParagraph[1];
        try {
            xWPFParagraphArr[0] = getWatermarkParagraph(str, 1);
            createHeader(DEFAULT, xWPFParagraphArr);
            xWPFParagraphArr[0] = getWatermarkParagraph(str, 2);
            createHeader(FIRST, xWPFParagraphArr);
            xWPFParagraphArr[0] = getWatermarkParagraph(str, 3);
            createHeader(EVEN, xWPFParagraphArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private XWPFParagraph getWatermarkParagraph(String str, int i) {
        CTP newInstance = CTP.Factory.newInstance();
        byte[] rsidR = this.doc.getDocument().getBody().getPArray(0).getRsidR();
        byte[] rsidRDefault = this.doc.getDocument().getBody().getPArray(0).getRsidRDefault();
        newInstance.setRsidP(rsidR);
        newInstance.setRsidRDefault(rsidRDefault);
        newInstance.addNewPPr().addNewPStyle().setVal("Header");
        CTR addNewR = newInstance.addNewR();
        addNewR.addNewRPr().addNewNoProof();
        CTPicture addNewPict = addNewR.addNewPict();
        CTGroup newInstance2 = CTGroup.Factory.newInstance();
        CTShapetype addNewShapetype = newInstance2.addNewShapetype();
        addNewShapetype.setId("_x0000_t136");
        addNewShapetype.setCoordsize("1600,21600");
        addNewShapetype.setSpt(136.0f);
        addNewShapetype.setAdj("10800");
        addNewShapetype.setPath2("m@7,0l@8,0m@5,21600l@6,21600e");
        CTFormulas addNewFormulas = addNewShapetype.addNewFormulas();
        addNewFormulas.addNewF().setEqn("sum #0 0 10800");
        addNewFormulas.addNewF().setEqn("prod #0 2 1");
        addNewFormulas.addNewF().setEqn("sum 21600 0 @1");
        addNewFormulas.addNewF().setEqn("sum 0 0 @2");
        addNewFormulas.addNewF().setEqn("sum 21600 0 @3");
        addNewFormulas.addNewF().setEqn("if @0 @3 0");
        addNewFormulas.addNewF().setEqn("if @0 21600 @1");
        addNewFormulas.addNewF().setEqn("if @0 0 @2");
        addNewFormulas.addNewF().setEqn("if @0 @4 21600");
        addNewFormulas.addNewF().setEqn("mid @5 @6");
        addNewFormulas.addNewF().setEqn("mid @8 @5");
        addNewFormulas.addNewF().setEqn("mid @7 @8");
        addNewFormulas.addNewF().setEqn("mid @6 @7");
        addNewFormulas.addNewF().setEqn("sum @6 0 @5");
        CTPath addNewPath = addNewShapetype.addNewPath();
        addNewPath.setTextpathok(STTrueFalse.T);
        addNewPath.setConnecttype(STConnectType.CUSTOM);
        addNewPath.setConnectlocs("@9,0;@10,10800;@11,21600;@12,10800");
        addNewPath.setConnectangles("270,180,90,0");
        CTTextPath addNewTextpath = addNewShapetype.addNewTextpath();
        addNewTextpath.setOn(STTrueFalse.T);
        addNewTextpath.setFitshape(STTrueFalse.T);
        CTH addNewH = addNewShapetype.addNewHandles().addNewH();
        addNewH.setPosition("#0,bottomRight");
        addNewH.setXrange("6629,14971");
        addNewShapetype.addNewLock().setExt(STExt.EDIT);
        CTShape addNewShape = newInstance2.addNewShape();
        addNewShape.setId("PowerPlusWaterMarkObject" + i);
        addNewShape.setSpid("_x0000_s102" + (i + 4));
        addNewShape.setType("#_x0000_t136");
        addNewShape.setStyle("position:absolute;margin-left:0;margin-top:0;width:415pt;height:207.5pt;z-index:-251654144;mso-wrap-edited:f;mso-position-horizontal:center;mso-position-horizontal-relative:margin;mso-position-vertical:center;mso-position-vertical-relative:margin");
        addNewShape.setWrapcoords("616 5068 390 16297 39 16921 -39 17155 7265 17545 7186 17467 -39 17467 18904 17467 10507 17467 8710 17545 18904 17077 18787 16843 18358 16297 18279 12554 19178 12476 20701 11774 20779 11228 21131 10059 21248 8811 21248 7563 20975 6316 20935 5380 19490 5146 14022 5068 2616 5068");
        addNewShape.setFillcolor("black");
        addNewShape.setStroked(STTrueFalse.FALSE);
        CTTextPath addNewTextpath2 = addNewShape.addNewTextpath();
        addNewTextpath2.setStyle("font-family:&quot;Cambria&quot;;font-size:1pt");
        addNewTextpath2.setString(str);
        addNewPict.set(newInstance2);
        return new XWPFParagraph(newInstance, this.doc);
    }
}
