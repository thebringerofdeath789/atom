package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
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
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComOfficePowerpoint.CTRel;
import schemasMicrosoftComOfficeWord.CTAnchorLock;
import schemasMicrosoftComOfficeWord.CTBorder;
import schemasMicrosoftComOfficeWord.CTWrap;
import schemasMicrosoftComVml.CTArc;
import schemasMicrosoftComVml.CTCurve;
import schemasMicrosoftComVml.CTFill;
import schemasMicrosoftComVml.CTFormulas;
import schemasMicrosoftComVml.CTGroup;
import schemasMicrosoftComVml.CTHandles;
import schemasMicrosoftComVml.CTImage;
import schemasMicrosoftComVml.CTImageData;
import schemasMicrosoftComVml.CTLine;
import schemasMicrosoftComVml.CTOval;
import schemasMicrosoftComVml.CTPath;
import schemasMicrosoftComVml.CTPolyLine;
import schemasMicrosoftComVml.CTRect;
import schemasMicrosoftComVml.CTRoundRect;
import schemasMicrosoftComVml.CTShadow;
import schemasMicrosoftComVml.CTShape;
import schemasMicrosoftComVml.CTShapetype;
import schemasMicrosoftComVml.CTStroke;
import schemasMicrosoftComVml.CTTextPath;
import schemasMicrosoftComVml.CTTextbox;
import schemasMicrosoftComVml.STColorType;
import schemasMicrosoftComVml.STEditAs;
import schemasMicrosoftComVml.STEditAs$Enum;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTGroupImpl extends XmlComplexContentImpl implements CTGroup {
    private static final QName PATH$0 = new QName("urn:schemas-microsoft-com:vml", "path");
    private static final QName FORMULAS$2 = new QName("urn:schemas-microsoft-com:vml", "formulas");
    private static final QName HANDLES$4 = new QName("urn:schemas-microsoft-com:vml", "handles");
    private static final QName FILL$6 = new QName("urn:schemas-microsoft-com:vml", "fill");
    private static final QName STROKE$8 = new QName("urn:schemas-microsoft-com:vml", "stroke");
    private static final QName SHADOW$10 = new QName("urn:schemas-microsoft-com:vml", "shadow");
    private static final QName TEXTBOX$12 = new QName("urn:schemas-microsoft-com:vml", "textbox");
    private static final QName TEXTPATH$14 = new QName("urn:schemas-microsoft-com:vml", "textpath");
    private static final QName IMAGEDATA$16 = new QName("urn:schemas-microsoft-com:vml", "imagedata");
    private static final QName SKEW$18 = new QName("urn:schemas-microsoft-com:office:office", "skew");
    private static final QName EXTRUSION$20 = new QName("urn:schemas-microsoft-com:office:office", "extrusion");
    private static final QName CALLOUT$22 = new QName("urn:schemas-microsoft-com:office:office", "callout");
    private static final QName LOCK$24 = new QName("urn:schemas-microsoft-com:office:office", "lock");
    private static final QName CLIPPATH$26 = new QName("urn:schemas-microsoft-com:office:office", "clippath");
    private static final QName SIGNATURELINE$28 = new QName("urn:schemas-microsoft-com:office:office", "signatureline");
    private static final QName WRAP$30 = new QName("urn:schemas-microsoft-com:office:word", "wrap");
    private static final QName ANCHORLOCK$32 = new QName("urn:schemas-microsoft-com:office:word", "anchorlock");
    private static final QName BORDERTOP$34 = new QName("urn:schemas-microsoft-com:office:word", "bordertop");
    private static final QName BORDERBOTTOM$36 = new QName("urn:schemas-microsoft-com:office:word", "borderbottom");
    private static final QName BORDERLEFT$38 = new QName("urn:schemas-microsoft-com:office:word", "borderleft");
    private static final QName BORDERRIGHT$40 = new QName("urn:schemas-microsoft-com:office:word", "borderright");
    private static final QName CLIENTDATA$42 = new QName("urn:schemas-microsoft-com:office:excel", "ClientData");
    private static final QName TEXTDATA$44 = new QName("urn:schemas-microsoft-com:office:powerpoint", "textdata");
    private static final QName GROUP$46 = new QName("urn:schemas-microsoft-com:vml", "group");
    private static final QName SHAPE$48 = new QName("urn:schemas-microsoft-com:vml", "shape");
    private static final QName SHAPETYPE$50 = new QName("urn:schemas-microsoft-com:vml", "shapetype");
    private static final QName ARC$52 = new QName("urn:schemas-microsoft-com:vml", "arc");
    private static final QName CURVE$54 = new QName("urn:schemas-microsoft-com:vml", "curve");
    private static final QName IMAGE$56 = new QName("urn:schemas-microsoft-com:vml", "image");
    private static final QName LINE$58 = new QName("urn:schemas-microsoft-com:vml", "line");
    private static final QName OVAL$60 = new QName("urn:schemas-microsoft-com:vml", "oval");
    private static final QName POLYLINE$62 = new QName("urn:schemas-microsoft-com:vml", DirectionsCriteria.GEOMETRY_POLYLINE);
    private static final QName RECT$64 = new QName("urn:schemas-microsoft-com:vml", "rect");
    private static final QName ROUNDRECT$66 = new QName("urn:schemas-microsoft-com:vml", "roundrect");
    private static final QName DIAGRAM$68 = new QName("urn:schemas-microsoft-com:office:office", "diagram");
    private static final QName ID$70 = new QName("", TtmlNode.ATTR_ID);
    private static final QName STYLE$72 = new QName("", TtmlNode.TAG_STYLE);
    private static final QName HREF$74 = new QName("", "href");
    private static final QName TARGET$76 = new QName("", "target");
    private static final QName CLASS1$78 = new QName("", JamXmlElements.CLASS);
    private static final QName TITLE$80 = new QName("", "title");
    private static final QName ALT$82 = new QName("", "alt");
    private static final QName COORDSIZE$84 = new QName("", "coordsize");
    private static final QName COORDORIGIN$86 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$88 = new QName("", "wrapcoords");
    private static final QName PRINT$90 = new QName("", "print");
    private static final QName SPID$92 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$94 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$96 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$98 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$100 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$102 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$104 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$106 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$108 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$110 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$112 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$114 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$116 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$118 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$120 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$122 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$124 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$126 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$128 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$130 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$132 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$134 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$136 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName FILLED$138 = new QName("", TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
    private static final QName FILLCOLOR$140 = new QName("", "fillcolor");
    private static final QName EDITAS$142 = new QName("", "editas");
    private static final QName TABLEPROPERTIES$144 = new QName("urn:schemas-microsoft-com:office:office", "tableproperties");
    private static final QName TABLELIMITS$146 = new QName("urn:schemas-microsoft-com:office:office", "tablelimits");

    public CTGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTArc addNewArc() {
        CTArc add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ARC$52);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder addNewBorderbottom() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder addNewBorderleft() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder addNewBorderright() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder addNewBordertop() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCallout addNewCallout() {
        CTCallout add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClientData addNewClientData() {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClipPath addNewClippath() {
        CTClipPath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCurve addNewCurve() {
        CTCurve add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CURVE$54);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTDiagram addNewDiagram() {
        CTDiagram add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DIAGRAM$68);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTExtrusion addNewExtrusion() {
        CTExtrusion add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFill addNewFill() {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().add_element_user(FILL$6);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTGroup addNewGroup() {
        CTGroup cTGroup;
        synchronized (monitor()) {
            check_orphaned();
            cTGroup = (CTGroup) get_store().add_element_user(GROUP$46);
        }
        return cTGroup;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTHandles addNewHandles() {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().add_element_user(HANDLES$4);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImage addNewImage() {
        CTImage add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(IMAGE$56);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImageData addNewImagedata() {
        CTImageData add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLine addNewLine() {
        CTLine add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LINE$58);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLock addNewLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().add_element_user(LOCK$24);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTOval addNewOval() {
        CTOval add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OVAL$60);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPath addNewPath() {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().add_element_user(PATH$0);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPolyLine addNewPolyline() {
        CTPolyLine add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(POLYLINE$62);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRect addNewRect() {
        CTRect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RECT$64);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRoundRect addNewRoundrect() {
        CTRoundRect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ROUNDRECT$66);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShadow addNewShadow() {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().add_element_user(SHADOW$10);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShape addNewShape() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(SHAPE$48);
        }
        return cTShape;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShapetype addNewShapetype() {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetype = (CTShapetype) get_store().add_element_user(SHAPETYPE$50);
        }
        return cTShapetype;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSkew addNewSkew() {
        CTSkew add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SKEW$18);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTStroke addNewStroke() {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().add_element_user(STROKE$8);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRel addNewTextdata() {
        CTRel add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTWrap addNewWrap() {
        CTWrap add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(WRAP$30);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWINCELL$116);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWOVERLAP$118);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALT$82);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTAnchorLock getAnchorlockArray(int i) {
        CTAnchorLock find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ANCHORLOCK$32, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTAnchorLock[] getAnchorlockArray() {
        CTAnchorLock[] cTAnchorLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHORLOCK$32, arrayList);
            cTAnchorLockArr = new CTAnchorLock[arrayList.size()];
            arrayList.toArray(cTAnchorLockArr);
        }
        return cTAnchorLockArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTAnchorLock> getAnchorlockList() {
        1AnchorlockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorlockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTArc getArcArray(int i) {
        CTArc find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ARC$52, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTArc[] getArcArray() {
        CTArc[] cTArcArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ARC$52, arrayList);
            cTArcArr = new CTArc[arrayList.size()];
            arrayList.toArray(cTArcArr);
        }
        return cTArcArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTArc> getArcList() {
        1ArcList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ArcList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder getBorderbottomArray(int i) {
        CTBorder find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BORDERBOTTOM$36, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder[] getBorderbottomArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOTTOM$36, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTBorder> getBorderbottomList() {
        1BorderbottomList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderbottomList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder getBorderleftArray(int i) {
        CTBorder find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BORDERLEFT$38, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder[] getBorderleftArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERLEFT$38, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTBorder> getBorderleftList() {
        1BorderleftList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderleftList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERLEFTCOLOR$124);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder getBorderrightArray(int i) {
        CTBorder find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BORDERRIGHT$40, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder[] getBorderrightArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERRIGHT$40, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTBorder> getBorderrightList() {
        1BorderrightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderrightList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder getBordertopArray(int i) {
        CTBorder find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BORDERTOP$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder[] getBordertopArray() {
        CTBorder[] cTBorderArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERTOP$34, arrayList);
            cTBorderArr = new CTBorder[arrayList.size()];
            arrayList.toArray(cTBorderArr);
        }
        return cTBorderArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTBorder> getBordertopList() {
        1BordertopList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BordertopList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERTOPCOLOR$122);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BULLET$104);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BUTTON$100);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCallout getCalloutArray(int i) {
        CTCallout find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CALLOUT$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCallout[] getCalloutArray() {
        CTCallout[] cTCalloutArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CALLOUT$22, arrayList);
            cTCalloutArr = new CTCallout[arrayList.size()];
            arrayList.toArray(cTCalloutArr);
        }
        return cTCalloutArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTCallout> getCalloutList() {
        1CalloutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalloutList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLASS1$78);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClientData getClientDataArray(int i) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().find_element_user(CLIENTDATA$42, i);
            if (cTClientData == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClientData[] getClientDataArray() {
        CTClientData[] cTClientDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIENTDATA$42, arrayList);
            cTClientDataArr = new CTClientData[arrayList.size()];
            arrayList.toArray(cTClientDataArr);
        }
        return cTClientDataArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTClientData> getClientDataList() {
        1ClientDataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClientDataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClipPath getClippathArray(int i) {
        CTClipPath find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CLIPPATH$26, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClipPath[] getClippathArray() {
        CTClipPath[] cTClipPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLIPPATH$26, arrayList);
            cTClipPathArr = new CTClipPath[arrayList.size()];
            arrayList.toArray(cTClipPathArr);
        }
        return cTClipPathArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTClipPath> getClippathList() {
        1ClippathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClippathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDORIGIN$86);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDSIZE$84);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCurve getCurveArray(int i) {
        CTCurve find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CURVE$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCurve[] getCurveArray() {
        CTCurve[] cTCurveArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CURVE$54, arrayList);
            cTCurveArr = new CTCurve[arrayList.size()];
            arrayList.toArray(cTCurveArr);
        }
        return cTCurveArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTCurve> getCurveList() {
        1CurveList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CurveList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUT$130);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUTMRU$134);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMNODEKIND$132);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTDiagram getDiagramArray(int i) {
        CTDiagram find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DIAGRAM$68, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTDiagram[] getDiagramArray() {
        CTDiagram[] cTDiagramArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DIAGRAM$68, arrayList);
            cTDiagramArr = new CTDiagram[arrayList.size()];
            arrayList.toArray(cTDiagramArr);
        }
        return cTDiagramArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTDiagram> getDiagramList() {
        1DiagramList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DiagramList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STEditAs$Enum getEditas() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EDITAS$142);
            if (simpleValue == null) {
                return null;
            }
            return (STEditAs$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTExtrusion getExtrusionArray(int i) {
        CTExtrusion find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(EXTRUSION$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTExtrusion[] getExtrusionArray() {
        CTExtrusion[] cTExtrusionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTRUSION$20, arrayList);
            cTExtrusionArr = new CTExtrusion[arrayList.size()];
            arrayList.toArray(cTExtrusionArr);
        }
        return cTExtrusionArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTExtrusion> getExtrusionList() {
        1ExtrusionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtrusionList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFill getFillArray(int i) {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().find_element_user(FILL$6, i);
            if (cTFill == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFill[] getFillArray() {
        CTFill[] cTFillArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILL$6, arrayList);
            cTFillArr = new CTFill[arrayList.size()];
            arrayList.toArray(cTFillArr);
        }
        return cTFillArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTFill> getFillList() {
        1FillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLCOLOR$140);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLED$138);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFormulas getFormulasArray(int i) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().find_element_user(FORMULAS$2, i);
            if (cTFormulas == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFormulas[] getFormulasArray() {
        CTFormulas[] cTFormulasArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FORMULAS$2, arrayList);
            cTFormulasArr = new CTFormulas[arrayList.size()];
            arrayList.toArray(cTFormulasArr);
        }
        return cTFormulasArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTFormulas> getFormulasList() {
        1FormulasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulasList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTGroup getGroupArray(int i) {
        CTGroup cTGroup;
        synchronized (monitor()) {
            check_orphaned();
            cTGroup = (CTGroup) get_store().find_element_user(GROUP$46, i);
            if (cTGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroup;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTGroup[] getGroupArray() {
        CTGroup[] cTGroupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUP$46, arrayList);
            cTGroupArr = new CTGroup[arrayList.size()];
            arrayList.toArray(cTGroupArr);
        }
        return cTGroupArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTGroup> getGroupList() {
        1GroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GroupList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTHandles getHandlesArray(int i) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().find_element_user(HANDLES$4, i);
            if (cTHandles == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTHandles[] getHandlesArray() {
        CTHandles[] cTHandlesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HANDLES$4, arrayList);
            cTHandlesArr = new CTHandles[arrayList.size()];
            arrayList.toArray(cTHandlesArr);
        }
        return cTHandlesArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTHandles> getHandlesList() {
        1HandlesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HandlesList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HR$106);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STHrAlign$Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STHrAlign$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HREF$74);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRNOSHADE$110);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRPCT$112);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRSTD$108);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$70);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImage getImageArray(int i) {
        CTImage find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(IMAGE$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImage[] getImageArray() {
        CTImage[] cTImageArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IMAGE$56, arrayList);
            cTImageArr = new CTImage[arrayList.size()];
            arrayList.toArray(cTImageArr);
        }
        return cTImageArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTImage> getImageList() {
        1ImageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImageList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImageData getImagedataArray(int i) {
        CTImageData find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(IMAGEDATA$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImageData[] getImagedataArray() {
        CTImageData[] cTImageDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(IMAGEDATA$16, arrayList);
            cTImageDataArr = new CTImageData[arrayList.size()];
            arrayList.toArray(cTImageDataArr);
        }
        return cTImageDataArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTImageData> getImagedataList() {
        1ImagedataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImagedataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STInsetMode.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLine getLineArray(int i) {
        CTLine find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LINE$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLine[] getLineArray() {
        CTLine[] cTLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LINE$58, arrayList);
            cTLineArr = new CTLine[arrayList.size()];
            arrayList.toArray(cTLineArr);
        }
        return cTLineArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTLine> getLineList() {
        1LineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLock getLockArray(int i) {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().find_element_user(LOCK$24, i);
            if (cTLock == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLock[] getLockArray() {
        CTLock[] cTLockArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCK$24, arrayList);
            cTLockArr = new CTLock[arrayList.size()];
            arrayList.toArray(cTLockArr);
        }
        return cTLockArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ONED$94);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTOval getOvalArray(int i) {
        CTOval find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(OVAL$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTOval[] getOvalArray() {
        CTOval[] cTOvalArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OVAL$60, arrayList);
            cTOvalArr = new CTOval[arrayList.size()];
            arrayList.toArray(cTOvalArr);
        }
        return cTOvalArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTOval> getOvalList() {
        1OvalList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OvalList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPath getPathArray(int i) {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().find_element_user(PATH$0, i);
            if (cTPath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPath[] getPathArray() {
        CTPath[] cTPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATH$0, arrayList);
            cTPathArr = new CTPath[arrayList.size()];
            arrayList.toArray(cTPathArr);
        }
        return cTPathArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTPath> getPathList() {
        1PathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPolyLine getPolylineArray(int i) {
        CTPolyLine find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(POLYLINE$62, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPolyLine[] getPolylineArray() {
        CTPolyLine[] cTPolyLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(POLYLINE$62, arrayList);
            cTPolyLineArr = new CTPolyLine[arrayList.size()];
            arrayList.toArray(cTPolyLineArr);
        }
        return cTPolyLineArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTPolyLine> getPolylineList() {
        1PolylineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PolylineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRINT$90);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRect getRectArray(int i) {
        CTRect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(RECT$64, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRect[] getRectArray() {
        CTRect[] cTRectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RECT$64, arrayList);
            cTRectArr = new CTRect[arrayList.size()];
            arrayList.toArray(cTRectArr);
        }
        return cTRectArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTRect> getRectList() {
        1RectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RectList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REGROUPID$96);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRoundRect getRoundrectArray(int i) {
        CTRoundRect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ROUNDRECT$66, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRoundRect[] getRoundrectArray() {
        CTRoundRect[] cTRoundRectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROUNDRECT$66, arrayList);
            cTRoundRectArr = new CTRoundRect[arrayList.size()];
            arrayList.toArray(cTRoundRectArr);
        }
        return cTRoundRectArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTRoundRect> getRoundrectList() {
        1RoundrectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RoundrectList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShadow getShadowArray(int i) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().find_element_user(SHADOW$10, i);
            if (cTShadow == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShadow[] getShadowArray() {
        CTShadow[] cTShadowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADOW$10, arrayList);
            cTShadowArr = new CTShadow[arrayList.size()];
            arrayList.toArray(cTShadowArr);
        }
        return cTShadowArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTShadow> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShape getShapeArray(int i) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().find_element_user(SHAPE$48, i);
            if (cTShape == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShape;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShape[] getShapeArray() {
        CTShape[] cTShapeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHAPE$48, arrayList);
            cTShapeArr = new CTShape[arrayList.size()];
            arrayList.toArray(cTShapeArr);
        }
        return cTShapeArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTShape> getShapeList() {
        1ShapeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShapeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShapetype getShapetypeArray(int i) {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetype = (CTShapetype) get_store().find_element_user(SHAPETYPE$50, i);
            if (cTShapetype == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShapetype;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShapetype[] getShapetypeArray() {
        CTShapetype[] cTShapetypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHAPETYPE$50, arrayList);
            cTShapetypeArr = new CTShapetype[arrayList.size()];
            arrayList.toArray(cTShapetypeArr);
        }
        return cTShapetypeArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTShapetype> getShapetypeList() {
        1ShapetypeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShapetypeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSignatureLine getSignaturelineArray(int i) {
        CTSignatureLine find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SIGNATURELINE$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSignatureLine[] getSignaturelineArray() {
        CTSignatureLine[] cTSignatureLineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIGNATURELINE$28, arrayList);
            cTSignatureLineArr = new CTSignatureLine[arrayList.size()];
            arrayList.toArray(cTSignatureLineArr);
        }
        return cTSignatureLineArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTSignatureLine> getSignaturelineList() {
        1SignaturelineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignaturelineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSkew getSkewArray(int i) {
        CTSkew find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(SKEW$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSkew[] getSkewArray() {
        CTSkew[] cTSkewArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SKEW$18, arrayList);
            cTSkewArr = new CTSkew[arrayList.size()];
            arrayList.toArray(cTSkewArr);
        }
        return cTSkewArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTSkew> getSkewList() {
        1SkewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SkewList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPID$92);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTStroke getStrokeArray(int i) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().find_element_user(STROKE$8, i);
            if (cTStroke == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTStroke[] getStrokeArray() {
        CTStroke[] cTStrokeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STROKE$8, arrayList);
            cTStrokeArr = new CTStroke[arrayList.size()];
            arrayList.toArray(cTStrokeArr);
        }
        return cTStrokeArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTStroke> getStrokeList() {
        1StrokeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrokeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$72);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getTablelimits() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TABLELIMITS$146);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getTableproperties() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TABLEPROPERTIES$144);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGET$76);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextbox getTextboxArray(int i) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().find_element_user(TEXTBOX$12, i);
            if (cTTextbox == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextbox[] getTextboxArray() {
        CTTextbox[] cTTextboxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTBOX$12, arrayList);
            cTTextboxArr = new CTTextbox[arrayList.size()];
            arrayList.toArray(cTTextboxArr);
        }
        return cTTextboxArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTTextbox> getTextboxList() {
        1TextboxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextboxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRel getTextdataArray(int i) {
        CTRel find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(TEXTDATA$44, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRel[] getTextdataArray() {
        CTRel[] cTRelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTDATA$44, arrayList);
            cTRelArr = new CTRel[arrayList.size()];
            arrayList.toArray(cTRelArr);
        }
        return cTRelArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTRel> getTextdataList() {
        1TextdataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextdataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextPath getTextpathArray(int i) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().find_element_user(TEXTPATH$14, i);
            if (cTTextPath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextPath[] getTextpathArray() {
        CTTextPath[] cTTextPathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTPATH$14, arrayList);
            cTTextPathArr = new CTTextPath[arrayList.size()];
            arrayList.toArray(cTTextPathArr);
        }
        return cTTextPathArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTTextPath> getTextpathList() {
        1TextpathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextpathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TITLE$80);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERDRAWN$120);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse$Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERHIDDEN$102);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTWrap getWrapArray(int i) {
        CTWrap find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(WRAP$30, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTWrap[] getWrapArray() {
        CTWrap[] cTWrapArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WRAP$30, arrayList);
            cTWrapArr = new CTWrap[arrayList.size()];
            arrayList.toArray(cTWrapArr);
        }
        return cTWrapArr;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public List<CTWrap> getWrapList() {
        1WrapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WrapList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WRAPCOORDS$88);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTArc insertNewArc(int i) {
        CTArc insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ARC$52, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder insertNewBorderleft(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder insertNewBorderright(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTBorder insertNewBordertop(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCallout insertNewCallout(int i) {
        CTCallout insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTClipPath insertNewClippath(int i) {
        CTClipPath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTCurve insertNewCurve(int i) {
        CTCurve insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CURVE$54, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTDiagram insertNewDiagram(int i) {
        CTDiagram insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DIAGRAM$68, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFill insertNewFill(int i) {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().insert_element_user(FILL$6, i);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTGroup insertNewGroup(int i) {
        CTGroup cTGroup;
        synchronized (monitor()) {
            check_orphaned();
            cTGroup = (CTGroup) get_store().insert_element_user(GROUP$46, i);
        }
        return cTGroup;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImage insertNewImage(int i) {
        CTImage insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(IMAGE$56, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTImageData insertNewImagedata(int i) {
        CTImageData insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLine insertNewLine(int i) {
        CTLine insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LINE$58, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTLock insertNewLock(int i) {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().insert_element_user(LOCK$24, i);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTOval insertNewOval(int i) {
        CTOval insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(OVAL$60, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPath insertNewPath(int i) {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().insert_element_user(PATH$0, i);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTPolyLine insertNewPolyline(int i) {
        CTPolyLine insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(POLYLINE$62, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRect insertNewRect(int i) {
        CTRect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(RECT$64, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRoundRect insertNewRoundrect(int i) {
        CTRoundRect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ROUNDRECT$66, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShape insertNewShape(int i) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().insert_element_user(SHAPE$48, i);
        }
        return cTShape;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTShapetype insertNewShapetype(int i) {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetype = (CTShapetype) get_store().insert_element_user(SHAPETYPE$50, i);
        }
        return cTShapetype;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTSkew insertNewSkew(int i) {
        CTSkew insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().insert_element_user(STROKE$8, i);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTRel insertNewTextdata(int i) {
        CTRel insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public CTWrap insertNewWrap(int i) {
        CTWrap insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$116) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$118) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$82) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$126) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$124) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$128) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$122) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$104) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$100) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$78) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$86) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$84) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$130) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$134) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$132) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$98) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetEditas() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EDITAS$142) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$140) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$138) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$106) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$114) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$74) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$110) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$112) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$108) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$70) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$136) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$94) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$90) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$96) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$92) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$72) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetTablelimits() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABLELIMITS$146) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetTableproperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TABLEPROPERTIES$144) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$76) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$80) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$120) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$102) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$88) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeArc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARC$52, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeCurve(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CURVE$54, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeDiagram(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIAGRAM$68, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUP$46, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeImage(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGE$56, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeLine(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LINE$58, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeOval(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OVAL$60, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removePolyline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(POLYLINE$62, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeRect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RECT$64, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeRoundrect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROUNDRECT$66, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeShape(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPE$48, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeShapetype(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPETYPE$50, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setAllowincell(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$116;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setAllowoverlap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$118;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$82;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setAnchorlockArray(int i, CTAnchorLock cTAnchorLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTAnchorLock find_element_user = get_store().find_element_user(ANCHORLOCK$32, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAnchorLock);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAnchorLockArr, ANCHORLOCK$32);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setArcArray(int i, CTArc cTArc) {
        synchronized (monitor()) {
            check_orphaned();
            CTArc find_element_user = get_store().find_element_user(ARC$52, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTArc);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setArcArray(CTArc[] cTArcArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTArcArr, ARC$52);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderbottomArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder find_element_user = get_store().find_element_user(BORDERBOTTOM$36, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBorder);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERBOTTOM$36);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$126;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderleftArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder find_element_user = get_store().find_element_user(BORDERLEFT$38, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBorder);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERLEFT$38);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$124;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderrightArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder find_element_user = get_store().find_element_user(BORDERRIGHT$40, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBorder);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERRIGHT$40);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$128;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBordertopArray(int i, CTBorder cTBorder) {
        synchronized (monitor()) {
            check_orphaned();
            CTBorder find_element_user = get_store().find_element_user(BORDERTOP$34, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBorder);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERTOP$34);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$122;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setBullet(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$104;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setButton(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$100;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCalloutArray(int i, CTCallout cTCallout) {
        synchronized (monitor()) {
            check_orphaned();
            CTCallout find_element_user = get_store().find_element_user(CALLOUT$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCallout);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCalloutArr, CALLOUT$22);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$78;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setClientDataArray(int i, CTClientData cTClientData) {
        synchronized (monitor()) {
            check_orphaned();
            CTClientData cTClientData2 = (CTClientData) get_store().find_element_user(CLIENTDATA$42, i);
            if (cTClientData2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTClientData2.set(cTClientData);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setClippathArray(int i, CTClipPath cTClipPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTClipPath find_element_user = get_store().find_element_user(CLIPPATH$26, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTClipPath);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTClipPathArr, CLIPPATH$26);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$86;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$84;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCurveArray(int i, CTCurve cTCurve) {
        synchronized (monitor()) {
            check_orphaned();
            CTCurve find_element_user = get_store().find_element_user(CURVE$54, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTCurve);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setCurveArray(CTCurve[] cTCurveArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCurveArr, CURVE$54);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$130;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$134;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$132;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDiagramArray(int i, CTDiagram cTDiagram) {
        synchronized (monitor()) {
            check_orphaned();
            CTDiagram find_element_user = get_store().find_element_user(DIAGRAM$68, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTDiagram);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDiagramArray(CTDiagram[] cTDiagramArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDiagramArr, DIAGRAM$68);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setDoubleclicknotify(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$98;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setEditas(STEditAs$Enum sTEditAs$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$142;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTEditAs$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setExtrusionArray(int i, CTExtrusion cTExtrusion) {
        synchronized (monitor()) {
            check_orphaned();
            CTExtrusion find_element_user = get_store().find_element_user(EXTRUSION$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTExtrusion);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTExtrusionArr, EXTRUSION$20);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFillArray(int i, CTFill cTFill) {
        synchronized (monitor()) {
            check_orphaned();
            CTFill cTFill2 = (CTFill) get_store().find_element_user(FILL$6, i);
            if (cTFill2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFill2.set(cTFill);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFillArray(CTFill[] cTFillArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFillArr, FILL$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$140;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFilled(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$138;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFormulasArray(int i, CTFormulas cTFormulas) {
        synchronized (monitor()) {
            check_orphaned();
            CTFormulas cTFormulas2 = (CTFormulas) get_store().find_element_user(FORMULAS$2, i);
            if (cTFormulas2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFormulas2.set(cTFormulas);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFormulasArr, FORMULAS$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setGroupArray(int i, CTGroup cTGroup) {
        synchronized (monitor()) {
            check_orphaned();
            CTGroup cTGroup2 = (CTGroup) get_store().find_element_user(GROUP$46, i);
            if (cTGroup2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGroup2.set(cTGroup);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setGroupArray(CTGroup[] cTGroupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGroupArr, GROUP$46);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHandlesArray(int i, CTHandles cTHandles) {
        synchronized (monitor()) {
            check_orphaned();
            CTHandles cTHandles2 = (CTHandles) get_store().find_element_user(HANDLES$4, i);
            if (cTHandles2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTHandles2.set(cTHandles);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHandlesArr, HANDLES$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHr(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$106;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHralign(STHrAlign$Enum sTHrAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTHrAlign$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$74;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHrnoshade(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$110;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$112;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setHrstd(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$108;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$70;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setImageArray(int i, CTImage cTImage) {
        synchronized (monitor()) {
            check_orphaned();
            CTImage find_element_user = get_store().find_element_user(IMAGE$56, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTImage);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setImageArray(CTImage[] cTImageArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTImageArr, IMAGE$56);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setImagedataArray(int i, CTImageData cTImageData) {
        synchronized (monitor()) {
            check_orphaned();
            CTImageData find_element_user = get_store().find_element_user(IMAGEDATA$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTImageData);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTImageDataArr, IMAGEDATA$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setLineArray(int i, CTLine cTLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTLine find_element_user = get_store().find_element_user(LINE$58, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTLine);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setLineArray(CTLine[] cTLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLineArr, LINE$58);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setLockArray(int i, CTLock cTLock) {
        synchronized (monitor()) {
            check_orphaned();
            CTLock cTLock2 = (CTLock) get_store().find_element_user(LOCK$24, i);
            if (cTLock2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLock2.set(cTLock);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$24);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setOned(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$94;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setOvalArray(int i, CTOval cTOval) {
        synchronized (monitor()) {
            check_orphaned();
            CTOval find_element_user = get_store().find_element_user(OVAL$60, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTOval);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setOvalArray(CTOval[] cTOvalArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTOvalArr, OVAL$60);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setPathArray(int i, CTPath cTPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath cTPath2 = (CTPath) get_store().find_element_user(PATH$0, i);
            if (cTPath2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2.set(cTPath);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setPathArray(CTPath[] cTPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPathArr, PATH$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setPolylineArray(int i, CTPolyLine cTPolyLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTPolyLine find_element_user = get_store().find_element_user(POLYLINE$62, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTPolyLine);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setPolylineArray(CTPolyLine[] cTPolyLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPolyLineArr, POLYLINE$62);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setPrint(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$90;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setRectArray(int i, CTRect cTRect) {
        synchronized (monitor()) {
            check_orphaned();
            CTRect find_element_user = get_store().find_element_user(RECT$64, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTRect);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setRectArray(CTRect[] cTRectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRectArr, RECT$64);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$96;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setRoundrectArray(int i, CTRoundRect cTRoundRect) {
        synchronized (monitor()) {
            check_orphaned();
            CTRoundRect find_element_user = get_store().find_element_user(ROUNDRECT$66, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTRoundRect);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setRoundrectArray(CTRoundRect[] cTRoundRectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRoundRectArr, ROUNDRECT$66);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShadowArray(int i, CTShadow cTShadow) {
        synchronized (monitor()) {
            check_orphaned();
            CTShadow cTShadow2 = (CTShadow) get_store().find_element_user(SHADOW$10, i);
            if (cTShadow2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShadow2.set(cTShadow);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShadowArray(CTShadow[] cTShadowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShadowArr, SHADOW$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShapeArray(int i, CTShape cTShape) {
        synchronized (monitor()) {
            check_orphaned();
            CTShape cTShape2 = (CTShape) get_store().find_element_user(SHAPE$48, i);
            if (cTShape2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShape2.set(cTShape);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShapeArray(CTShape[] cTShapeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShapeArr, SHAPE$48);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShapetypeArray(int i, CTShapetype cTShapetype) {
        synchronized (monitor()) {
            check_orphaned();
            CTShapetype cTShapetype2 = (CTShapetype) get_store().find_element_user(SHAPETYPE$50, i);
            if (cTShapetype2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShapetype2.set(cTShapetype);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setShapetypeArray(CTShapetype[] cTShapetypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShapetypeArr, SHAPETYPE$50);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setSignaturelineArray(int i, CTSignatureLine cTSignatureLine) {
        synchronized (monitor()) {
            check_orphaned();
            CTSignatureLine find_element_user = get_store().find_element_user(SIGNATURELINE$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSignatureLine);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSignatureLineArr, SIGNATURELINE$28);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setSkewArray(int i, CTSkew cTSkew) {
        synchronized (monitor()) {
            check_orphaned();
            CTSkew find_element_user = get_store().find_element_user(SKEW$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTSkew);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setSkewArray(CTSkew[] cTSkewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSkewArr, SKEW$18);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$92;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setStrokeArray(int i, CTStroke cTStroke) {
        synchronized (monitor()) {
            check_orphaned();
            CTStroke cTStroke2 = (CTStroke) get_store().find_element_user(STROKE$8, i);
            if (cTStroke2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStroke2.set(cTStroke);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrokeArr, STROKE$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$72;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTablelimits(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLELIMITS$146;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTableproperties(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLEPROPERTIES$144;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$76;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextboxArray(int i, CTTextbox cTTextbox) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextbox cTTextbox2 = (CTTextbox) get_store().find_element_user(TEXTBOX$12, i);
            if (cTTextbox2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextbox2.set(cTTextbox);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextboxArr, TEXTBOX$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextdataArray(int i, CTRel cTRel) {
        synchronized (monitor()) {
            check_orphaned();
            CTRel find_element_user = get_store().find_element_user(TEXTDATA$44, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTRel);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextdataArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRelArr, TEXTDATA$44);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextpathArray(int i, CTTextPath cTTextPath) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextPath cTTextPath2 = (CTTextPath) get_store().find_element_user(TEXTPATH$14, i);
            if (cTTextPath2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextPath2.set(cTTextPath);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextPathArr, TEXTPATH$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$80;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setUserdrawn(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$120;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setUserhidden(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$102;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setWrapArray(int i, CTWrap cTWrap) {
        synchronized (monitor()) {
            check_orphaned();
            CTWrap find_element_user = get_store().find_element_user(WRAP$30, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTWrap);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setWrapArray(CTWrap[] cTWrapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTWrapArr, WRAP$30);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$88;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfAnchorlockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfArcArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ARC$52);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfBorderbottomArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfBorderleftArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfBorderrightArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfBordertopArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERTOP$34);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfCalloutArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CALLOUT$22);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfClientDataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfClippathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIPPATH$26);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfCurveArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CURVE$54);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfDiagramArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DIAGRAM$68);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfExtrusionArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXTRUSION$20);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILL$6);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfFormulasArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FORMULAS$2);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GROUP$46);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfHandlesArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HANDLES$4);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfImageArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(IMAGE$56);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfImagedataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfLineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LINE$58);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfLockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCK$24);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfOvalArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OVAL$60);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfPathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PATH$0);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfPolylineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(POLYLINE$62);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfRectArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RECT$64);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfRoundrectArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ROUNDRECT$66);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfShadowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHADOW$10);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfShapeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHAPE$48);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfShapetypeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHAPETYPE$50);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfSignaturelineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfSkewArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SKEW$18);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfStrokeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(STROKE$8);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfTextboxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTBOX$12);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfTextdataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTDATA$44);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfTextpathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTPATH$14);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public int sizeOfWrapArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WRAP$30);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$116);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$118);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$82);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$126);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$124);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$128);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$122);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$104);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$100);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$78);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$86);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$84);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$130);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$134);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$132);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$98);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetEditas() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EDITAS$142);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$140);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$138);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$106);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$114);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$74);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$110);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$112);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$108);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$70);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$136);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$94);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$90);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$96);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$92);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$72);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetTablelimits() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABLELIMITS$146);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetTableproperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TABLEPROPERTIES$144);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$76);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$80);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$120);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$102);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$88);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowincell() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWINCELL$116);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowoverlap() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$118);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetAlt() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ALT$82);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERBOTTOMCOLOR$126);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetBorderleftcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERLEFTCOLOR$124);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetBorderrightcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERRIGHTCOLOR$128);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetBordertopcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERTOPCOLOR$122);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetBullet() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BULLET$104);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetButton() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BUTTON$100);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetClass1() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CLASS1$78);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetCoordorigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDORIGIN$86);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetCoordsize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDSIZE$84);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUT$130);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUTMRU$134);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMNODEKIND$132);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetDoubleclicknotify() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$98);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STEditAs xgetEditas() {
        STEditAs find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(EDITAS$142);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STColorType xgetFillcolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(FILLCOLOR$140);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(FILLED$138);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHr() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HR$106);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STHrAlign xgetHralign() {
        STHrAlign find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(HREF$74);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrnoshade() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRNOSHADE$110);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(HRPCT$112);
        }
        return xmlFloat;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrstd() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRSTD$108);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$70);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            sTInsetMode = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode == null) {
                sTInsetMode = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetMode;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetOned() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ONED$94);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PRINT$90);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(REGROUPID$96);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetSpid() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SPID$92);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$72);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetTablelimits() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TABLELIMITS$146);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetTableproperties() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TABLEPROPERTIES$144);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetTarget() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TARGET$76);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TITLE$80);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserdrawn() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERDRAWN$120);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserhidden() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERHIDDEN$102);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public XmlString xgetWrapcoords() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(WRAPCOORDS$88);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetAllowincell(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$116;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetAllowoverlap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$118;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$82;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$126;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$124;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$128;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$122;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetBullet(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$104;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetButton(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$100;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$78;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$86;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$84;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$130;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$134;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$132;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetDoubleclicknotify(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$98;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetEditas(STEditAs sTEditAs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$142;
            STEditAs find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STEditAs) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTEditAs);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$140;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$138;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHr(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$106;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$114;
            STHrAlign find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTHrAlign);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$74;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHrnoshade(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$110;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$112;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qName);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetHrstd(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$108;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$70;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$136;
            STInsetMode sTInsetMode2 = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode2 == null) {
                sTInsetMode2 = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetMode2.set(sTInsetMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetOned(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$94;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$90;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$96;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$92;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$72;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetTablelimits(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLELIMITS$146;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetTableproperties(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLEPROPERTIES$144;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$76;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$80;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetUserdrawn(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$120;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetUserhidden(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$102;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTGroup
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$88;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
