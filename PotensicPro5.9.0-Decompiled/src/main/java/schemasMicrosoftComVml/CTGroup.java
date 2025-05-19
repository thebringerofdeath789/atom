package schemasMicrosoftComVml;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;
import schemasMicrosoftComOfficeExcel.CTClientData;
import schemasMicrosoftComOfficeOffice.CTCallout;
import schemasMicrosoftComOfficeOffice.CTClipPath;
import schemasMicrosoftComOfficeOffice.CTDiagram;
import schemasMicrosoftComOfficeOffice.CTExtrusion;
import schemasMicrosoftComOfficeOffice.CTLock;
import schemasMicrosoftComOfficeOffice.CTSignatureLine;
import schemasMicrosoftComOfficeOffice.CTSkew;
import schemasMicrosoftComOfficeOffice.STHrAlign;
import schemasMicrosoftComOfficeOffice.STHrAlign$Enum;
import schemasMicrosoftComOfficeOffice.STInsetMode;
import schemasMicrosoftComOfficePowerpoint.CTRel;
import schemasMicrosoftComOfficeWord.CTAnchorLock;
import schemasMicrosoftComOfficeWord.CTBorder;
import schemasMicrosoftComOfficeWord.CTWrap;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public interface CTGroup extends XmlObject {
    public static final SchemaType type = (SchemaType) XmlBeans.typeSystemForClassLoader(CTGroup.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sE130CAA0A01A7CDE5A2B4FEB8B311707").resolveHandle("ctgroup2b13type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroup newInstance() {
            return (CTGroup) XmlBeans.getContextTypeLoader().newInstance(CTGroup.type, null);
        }

        public static CTGroup newInstance(XmlOptions xmlOptions) {
            return (CTGroup) XmlBeans.getContextTypeLoader().newInstance(CTGroup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(File file) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(file, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(file, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(InputStream inputStream) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(inputStream, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(Reader reader) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(reader, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(reader, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(String str) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(str, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(str, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(URL url) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(url, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(url, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(xMLInputStream, CTGroup.type, xmlOptions);
        }

        public static CTGroup parse(Node node) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(node, CTGroup.type, (XmlOptions) null);
        }

        public static CTGroup parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTGroup) XmlBeans.getContextTypeLoader().parse(node, CTGroup.type, xmlOptions);
        }
    }

    CTAnchorLock addNewAnchorlock();

    CTArc addNewArc();

    CTBorder addNewBorderbottom();

    CTBorder addNewBorderleft();

    CTBorder addNewBorderright();

    CTBorder addNewBordertop();

    CTCallout addNewCallout();

    CTClientData addNewClientData();

    CTClipPath addNewClippath();

    CTCurve addNewCurve();

    CTDiagram addNewDiagram();

    CTExtrusion addNewExtrusion();

    CTFill addNewFill();

    CTFormulas addNewFormulas();

    CTGroup addNewGroup();

    CTHandles addNewHandles();

    CTImage addNewImage();

    CTImageData addNewImagedata();

    CTLine addNewLine();

    CTLock addNewLock();

    CTOval addNewOval();

    CTPath addNewPath();

    CTPolyLine addNewPolyline();

    CTRect addNewRect();

    CTRoundRect addNewRoundrect();

    CTShadow addNewShadow();

    CTShape addNewShape();

    CTShapetype addNewShapetype();

    CTSignatureLine addNewSignatureline();

    CTSkew addNewSkew();

    CTStroke addNewStroke();

    CTTextbox addNewTextbox();

    CTRel addNewTextdata();

    CTTextPath addNewTextpath();

    CTWrap addNewWrap();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getAllowincell();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getAllowoverlap();

    String getAlt();

    CTAnchorLock getAnchorlockArray(int i);

    CTAnchorLock[] getAnchorlockArray();

    List<CTAnchorLock> getAnchorlockList();

    CTArc getArcArray(int i);

    CTArc[] getArcArray();

    List<CTArc> getArcList();

    CTBorder getBorderbottomArray(int i);

    CTBorder[] getBorderbottomArray();

    List<CTBorder> getBorderbottomList();

    String getBorderbottomcolor();

    CTBorder getBorderleftArray(int i);

    CTBorder[] getBorderleftArray();

    List<CTBorder> getBorderleftList();

    String getBorderleftcolor();

    CTBorder getBorderrightArray(int i);

    CTBorder[] getBorderrightArray();

    List<CTBorder> getBorderrightList();

    String getBorderrightcolor();

    CTBorder getBordertopArray(int i);

    CTBorder[] getBordertopArray();

    List<CTBorder> getBordertopList();

    String getBordertopcolor();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getBullet();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getButton();

    CTCallout getCalloutArray(int i);

    CTCallout[] getCalloutArray();

    List<CTCallout> getCalloutList();

    String getClass1();

    CTClientData getClientDataArray(int i);

    CTClientData[] getClientDataArray();

    List<CTClientData> getClientDataList();

    CTClipPath getClippathArray(int i);

    CTClipPath[] getClippathArray();

    List<CTClipPath> getClippathList();

    String getCoordorigin();

    String getCoordsize();

    CTCurve getCurveArray(int i);

    CTCurve[] getCurveArray();

    List<CTCurve> getCurveList();

    BigInteger getDgmlayout();

    BigInteger getDgmlayoutmru();

    BigInteger getDgmnodekind();

    CTDiagram getDiagramArray(int i);

    CTDiagram[] getDiagramArray();

    List<CTDiagram> getDiagramList();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getDoubleclicknotify();

    STEditAs$Enum getEditas();

    CTExtrusion getExtrusionArray(int i);

    CTExtrusion[] getExtrusionArray();

    List<CTExtrusion> getExtrusionList();

    CTFill getFillArray(int i);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    String getFillcolor();

    STTrueFalse.Enum getFilled();

    CTFormulas getFormulasArray(int i);

    CTFormulas[] getFormulasArray();

    List<CTFormulas> getFormulasList();

    CTGroup getGroupArray(int i);

    CTGroup[] getGroupArray();

    List<CTGroup> getGroupList();

    CTHandles getHandlesArray(int i);

    CTHandles[] getHandlesArray();

    List<CTHandles> getHandlesList();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getHr();

    STHrAlign$Enum getHralign();

    String getHref();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getHrnoshade();

    float getHrpct();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getHrstd();

    String getId();

    CTImage getImageArray(int i);

    CTImage[] getImageArray();

    List<CTImage> getImageList();

    CTImageData getImagedataArray(int i);

    CTImageData[] getImagedataArray();

    List<CTImageData> getImagedataList();

    STInsetMode.Enum getInsetmode();

    CTLine getLineArray(int i);

    CTLine[] getLineArray();

    List<CTLine> getLineList();

    CTLock getLockArray(int i);

    CTLock[] getLockArray();

    List<CTLock> getLockList();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getOned();

    CTOval getOvalArray(int i);

    CTOval[] getOvalArray();

    List<CTOval> getOvalList();

    CTPath getPathArray(int i);

    CTPath[] getPathArray();

    List<CTPath> getPathList();

    CTPolyLine getPolylineArray(int i);

    CTPolyLine[] getPolylineArray();

    List<CTPolyLine> getPolylineList();

    STTrueFalse.Enum getPrint();

    CTRect getRectArray(int i);

    CTRect[] getRectArray();

    List<CTRect> getRectList();

    BigInteger getRegroupid();

    CTRoundRect getRoundrectArray(int i);

    CTRoundRect[] getRoundrectArray();

    List<CTRoundRect> getRoundrectList();

    CTShadow getShadowArray(int i);

    CTShadow[] getShadowArray();

    List<CTShadow> getShadowList();

    CTShape getShapeArray(int i);

    CTShape[] getShapeArray();

    List<CTShape> getShapeList();

    CTShapetype getShapetypeArray(int i);

    CTShapetype[] getShapetypeArray();

    List<CTShapetype> getShapetypeList();

    CTSignatureLine getSignaturelineArray(int i);

    CTSignatureLine[] getSignaturelineArray();

    List<CTSignatureLine> getSignaturelineList();

    CTSkew getSkewArray(int i);

    CTSkew[] getSkewArray();

    List<CTSkew> getSkewList();

    String getSpid();

    CTStroke getStrokeArray(int i);

    CTStroke[] getStrokeArray();

    List<CTStroke> getStrokeList();

    String getStyle();

    String getTablelimits();

    String getTableproperties();

    String getTarget();

    CTTextbox getTextboxArray(int i);

    CTTextbox[] getTextboxArray();

    List<CTTextbox> getTextboxList();

    CTRel getTextdataArray(int i);

    CTRel[] getTextdataArray();

    List<CTRel> getTextdataList();

    CTTextPath getTextpathArray(int i);

    CTTextPath[] getTextpathArray();

    List<CTTextPath> getTextpathList();

    String getTitle();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getUserdrawn();

    schemasMicrosoftComOfficeOffice.STTrueFalse$Enum getUserhidden();

    CTWrap getWrapArray(int i);

    CTWrap[] getWrapArray();

    List<CTWrap> getWrapList();

    String getWrapcoords();

    CTAnchorLock insertNewAnchorlock(int i);

    CTArc insertNewArc(int i);

    CTBorder insertNewBorderbottom(int i);

    CTBorder insertNewBorderleft(int i);

    CTBorder insertNewBorderright(int i);

    CTBorder insertNewBordertop(int i);

    CTCallout insertNewCallout(int i);

    CTClientData insertNewClientData(int i);

    CTClipPath insertNewClippath(int i);

    CTCurve insertNewCurve(int i);

    CTDiagram insertNewDiagram(int i);

    CTExtrusion insertNewExtrusion(int i);

    CTFill insertNewFill(int i);

    CTFormulas insertNewFormulas(int i);

    CTGroup insertNewGroup(int i);

    CTHandles insertNewHandles(int i);

    CTImage insertNewImage(int i);

    CTImageData insertNewImagedata(int i);

    CTLine insertNewLine(int i);

    CTLock insertNewLock(int i);

    CTOval insertNewOval(int i);

    CTPath insertNewPath(int i);

    CTPolyLine insertNewPolyline(int i);

    CTRect insertNewRect(int i);

    CTRoundRect insertNewRoundrect(int i);

    CTShadow insertNewShadow(int i);

    CTShape insertNewShape(int i);

    CTShapetype insertNewShapetype(int i);

    CTSignatureLine insertNewSignatureline(int i);

    CTSkew insertNewSkew(int i);

    CTStroke insertNewStroke(int i);

    CTTextbox insertNewTextbox(int i);

    CTRel insertNewTextdata(int i);

    CTTextPath insertNewTextpath(int i);

    CTWrap insertNewWrap(int i);

    boolean isSetAllowincell();

    boolean isSetAllowoverlap();

    boolean isSetAlt();

    boolean isSetBorderbottomcolor();

    boolean isSetBorderleftcolor();

    boolean isSetBorderrightcolor();

    boolean isSetBordertopcolor();

    boolean isSetBullet();

    boolean isSetButton();

    boolean isSetClass1();

    boolean isSetCoordorigin();

    boolean isSetCoordsize();

    boolean isSetDgmlayout();

    boolean isSetDgmlayoutmru();

    boolean isSetDgmnodekind();

    boolean isSetDoubleclicknotify();

    boolean isSetEditas();

    boolean isSetFillcolor();

    boolean isSetFilled();

    boolean isSetHr();

    boolean isSetHralign();

    boolean isSetHref();

    boolean isSetHrnoshade();

    boolean isSetHrpct();

    boolean isSetHrstd();

    boolean isSetId();

    boolean isSetInsetmode();

    boolean isSetOned();

    boolean isSetPrint();

    boolean isSetRegroupid();

    boolean isSetSpid();

    boolean isSetStyle();

    boolean isSetTablelimits();

    boolean isSetTableproperties();

    boolean isSetTarget();

    boolean isSetTitle();

    boolean isSetUserdrawn();

    boolean isSetUserhidden();

    boolean isSetWrapcoords();

    void removeAnchorlock(int i);

    void removeArc(int i);

    void removeBorderbottom(int i);

    void removeBorderleft(int i);

    void removeBorderright(int i);

    void removeBordertop(int i);

    void removeCallout(int i);

    void removeClientData(int i);

    void removeClippath(int i);

    void removeCurve(int i);

    void removeDiagram(int i);

    void removeExtrusion(int i);

    void removeFill(int i);

    void removeFormulas(int i);

    void removeGroup(int i);

    void removeHandles(int i);

    void removeImage(int i);

    void removeImagedata(int i);

    void removeLine(int i);

    void removeLock(int i);

    void removeOval(int i);

    void removePath(int i);

    void removePolyline(int i);

    void removeRect(int i);

    void removeRoundrect(int i);

    void removeShadow(int i);

    void removeShape(int i);

    void removeShapetype(int i);

    void removeSignatureline(int i);

    void removeSkew(int i);

    void removeStroke(int i);

    void removeTextbox(int i);

    void removeTextdata(int i);

    void removeTextpath(int i);

    void removeWrap(int i);

    void setAllowincell(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setAllowoverlap(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setAlt(String str);

    void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock);

    void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr);

    void setArcArray(int i, CTArc cTArc);

    void setArcArray(CTArc[] cTArcArr);

    void setBorderbottomArray(int i, CTBorder cTBorder);

    void setBorderbottomArray(CTBorder[] cTBorderArr);

    void setBorderbottomcolor(String str);

    void setBorderleftArray(int i, CTBorder cTBorder);

    void setBorderleftArray(CTBorder[] cTBorderArr);

    void setBorderleftcolor(String str);

    void setBorderrightArray(int i, CTBorder cTBorder);

    void setBorderrightArray(CTBorder[] cTBorderArr);

    void setBorderrightcolor(String str);

    void setBordertopArray(int i, CTBorder cTBorder);

    void setBordertopArray(CTBorder[] cTBorderArr);

    void setBordertopcolor(String str);

    void setBullet(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setButton(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setCalloutArray(int i, CTCallout cTCallout);

    void setCalloutArray(CTCallout[] cTCalloutArr);

    void setClass1(String str);

    void setClientDataArray(int i, CTClientData cTClientData);

    void setClientDataArray(CTClientData[] cTClientDataArr);

    void setClippathArray(int i, CTClipPath cTClipPath);

    void setClippathArray(CTClipPath[] cTClipPathArr);

    void setCoordorigin(String str);

    void setCoordsize(String str);

    void setCurveArray(int i, CTCurve cTCurve);

    void setCurveArray(CTCurve[] cTCurveArr);

    void setDgmlayout(BigInteger bigInteger);

    void setDgmlayoutmru(BigInteger bigInteger);

    void setDgmnodekind(BigInteger bigInteger);

    void setDiagramArray(int i, CTDiagram cTDiagram);

    void setDiagramArray(CTDiagram[] cTDiagramArr);

    void setDoubleclicknotify(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setEditas(STEditAs$Enum sTEditAs$Enum);

    void setExtrusionArray(int i, CTExtrusion cTExtrusion);

    void setExtrusionArray(CTExtrusion[] cTExtrusionArr);

    void setFillArray(int i, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    void setFillcolor(String str);

    void setFilled(STTrueFalse.Enum r1);

    void setFormulasArray(int i, CTFormulas cTFormulas);

    void setFormulasArray(CTFormulas[] cTFormulasArr);

    void setGroupArray(int i, CTGroup cTGroup);

    void setGroupArray(CTGroup[] cTGroupArr);

    void setHandlesArray(int i, CTHandles cTHandles);

    void setHandlesArray(CTHandles[] cTHandlesArr);

    void setHr(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setHralign(STHrAlign$Enum sTHrAlign$Enum);

    void setHref(String str);

    void setHrnoshade(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setHrpct(float f);

    void setHrstd(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setId(String str);

    void setImageArray(int i, CTImage cTImage);

    void setImageArray(CTImage[] cTImageArr);

    void setImagedataArray(int i, CTImageData cTImageData);

    void setImagedataArray(CTImageData[] cTImageDataArr);

    void setInsetmode(STInsetMode.Enum r1);

    void setLineArray(int i, CTLine cTLine);

    void setLineArray(CTLine[] cTLineArr);

    void setLockArray(int i, CTLock cTLock);

    void setLockArray(CTLock[] cTLockArr);

    void setOned(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setOvalArray(int i, CTOval cTOval);

    void setOvalArray(CTOval[] cTOvalArr);

    void setPathArray(int i, CTPath cTPath);

    void setPathArray(CTPath[] cTPathArr);

    void setPolylineArray(int i, CTPolyLine cTPolyLine);

    void setPolylineArray(CTPolyLine[] cTPolyLineArr);

    void setPrint(STTrueFalse.Enum r1);

    void setRectArray(int i, CTRect cTRect);

    void setRectArray(CTRect[] cTRectArr);

    void setRegroupid(BigInteger bigInteger);

    void setRoundrectArray(int i, CTRoundRect cTRoundRect);

    void setRoundrectArray(CTRoundRect[] cTRoundRectArr);

    void setShadowArray(int i, CTShadow cTShadow);

    void setShadowArray(CTShadow[] cTShadowArr);

    void setShapeArray(int i, CTShape cTShape);

    void setShapeArray(CTShape[] cTShapeArr);

    void setShapetypeArray(int i, CTShapetype cTShapetype);

    void setShapetypeArray(CTShapetype[] cTShapetypeArr);

    void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine);

    void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr);

    void setSkewArray(int i, CTSkew cTSkew);

    void setSkewArray(CTSkew[] cTSkewArr);

    void setSpid(String str);

    void setStrokeArray(int i, CTStroke cTStroke);

    void setStrokeArray(CTStroke[] cTStrokeArr);

    void setStyle(String str);

    void setTablelimits(String str);

    void setTableproperties(String str);

    void setTarget(String str);

    void setTextboxArray(int i, CTTextbox cTTextbox);

    void setTextboxArray(CTTextbox[] cTTextboxArr);

    void setTextdataArray(int i, CTRel cTRel);

    void setTextdataArray(CTRel[] cTRelArr);

    void setTextpathArray(int i, CTTextPath cTTextPath);

    void setTextpathArray(CTTextPath[] cTTextPathArr);

    void setTitle(String str);

    void setUserdrawn(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setUserhidden(schemasMicrosoftComOfficeOffice.STTrueFalse$Enum sTTrueFalse$Enum);

    void setWrapArray(int i, CTWrap cTWrap);

    void setWrapArray(CTWrap[] cTWrapArr);

    void setWrapcoords(String str);

    int sizeOfAnchorlockArray();

    int sizeOfArcArray();

    int sizeOfBorderbottomArray();

    int sizeOfBorderleftArray();

    int sizeOfBorderrightArray();

    int sizeOfBordertopArray();

    int sizeOfCalloutArray();

    int sizeOfClientDataArray();

    int sizeOfClippathArray();

    int sizeOfCurveArray();

    int sizeOfDiagramArray();

    int sizeOfExtrusionArray();

    int sizeOfFillArray();

    int sizeOfFormulasArray();

    int sizeOfGroupArray();

    int sizeOfHandlesArray();

    int sizeOfImageArray();

    int sizeOfImagedataArray();

    int sizeOfLineArray();

    int sizeOfLockArray();

    int sizeOfOvalArray();

    int sizeOfPathArray();

    int sizeOfPolylineArray();

    int sizeOfRectArray();

    int sizeOfRoundrectArray();

    int sizeOfShadowArray();

    int sizeOfShapeArray();

    int sizeOfShapetypeArray();

    int sizeOfSignaturelineArray();

    int sizeOfSkewArray();

    int sizeOfStrokeArray();

    int sizeOfTextboxArray();

    int sizeOfTextdataArray();

    int sizeOfTextpathArray();

    int sizeOfWrapArray();

    void unsetAllowincell();

    void unsetAllowoverlap();

    void unsetAlt();

    void unsetBorderbottomcolor();

    void unsetBorderleftcolor();

    void unsetBorderrightcolor();

    void unsetBordertopcolor();

    void unsetBullet();

    void unsetButton();

    void unsetClass1();

    void unsetCoordorigin();

    void unsetCoordsize();

    void unsetDgmlayout();

    void unsetDgmlayoutmru();

    void unsetDgmnodekind();

    void unsetDoubleclicknotify();

    void unsetEditas();

    void unsetFillcolor();

    void unsetFilled();

    void unsetHr();

    void unsetHralign();

    void unsetHref();

    void unsetHrnoshade();

    void unsetHrpct();

    void unsetHrstd();

    void unsetId();

    void unsetInsetmode();

    void unsetOned();

    void unsetPrint();

    void unsetRegroupid();

    void unsetSpid();

    void unsetStyle();

    void unsetTablelimits();

    void unsetTableproperties();

    void unsetTarget();

    void unsetTitle();

    void unsetUserdrawn();

    void unsetUserhidden();

    void unsetWrapcoords();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowincell();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowoverlap();

    XmlString xgetAlt();

    XmlString xgetBorderbottomcolor();

    XmlString xgetBorderleftcolor();

    XmlString xgetBorderrightcolor();

    XmlString xgetBordertopcolor();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetBullet();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetButton();

    XmlString xgetClass1();

    XmlString xgetCoordorigin();

    XmlString xgetCoordsize();

    XmlInteger xgetDgmlayout();

    XmlInteger xgetDgmlayoutmru();

    XmlInteger xgetDgmnodekind();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetDoubleclicknotify();

    STEditAs xgetEditas();

    STColorType xgetFillcolor();

    STTrueFalse xgetFilled();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetHr();

    STHrAlign xgetHralign();

    XmlString xgetHref();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrnoshade();

    XmlFloat xgetHrpct();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrstd();

    XmlString xgetId();

    STInsetMode xgetInsetmode();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetOned();

    STTrueFalse xgetPrint();

    XmlInteger xgetRegroupid();

    XmlString xgetSpid();

    XmlString xgetStyle();

    XmlString xgetTablelimits();

    XmlString xgetTableproperties();

    XmlString xgetTarget();

    XmlString xgetTitle();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserdrawn();

    schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserhidden();

    XmlString xgetWrapcoords();

    void xsetAllowincell(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetAllowoverlap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetAlt(XmlString xmlString);

    void xsetBorderbottomcolor(XmlString xmlString);

    void xsetBorderleftcolor(XmlString xmlString);

    void xsetBorderrightcolor(XmlString xmlString);

    void xsetBordertopcolor(XmlString xmlString);

    void xsetBullet(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetButton(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetClass1(XmlString xmlString);

    void xsetCoordorigin(XmlString xmlString);

    void xsetCoordsize(XmlString xmlString);

    void xsetDgmlayout(XmlInteger xmlInteger);

    void xsetDgmlayoutmru(XmlInteger xmlInteger);

    void xsetDgmnodekind(XmlInteger xmlInteger);

    void xsetDoubleclicknotify(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetEditas(STEditAs sTEditAs);

    void xsetFillcolor(STColorType sTColorType);

    void xsetFilled(STTrueFalse sTTrueFalse);

    void xsetHr(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetHralign(STHrAlign sTHrAlign);

    void xsetHref(XmlString xmlString);

    void xsetHrnoshade(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetHrpct(XmlFloat xmlFloat);

    void xsetHrstd(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetId(XmlString xmlString);

    void xsetInsetmode(STInsetMode sTInsetMode);

    void xsetOned(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetPrint(STTrueFalse sTTrueFalse);

    void xsetRegroupid(XmlInteger xmlInteger);

    void xsetSpid(XmlString xmlString);

    void xsetStyle(XmlString xmlString);

    void xsetTablelimits(XmlString xmlString);

    void xsetTableproperties(XmlString xmlString);

    void xsetTarget(XmlString xmlString);

    void xsetTitle(XmlString xmlString);

    void xsetUserdrawn(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetUserhidden(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse);

    void xsetWrapcoords(XmlString xmlString);
}
