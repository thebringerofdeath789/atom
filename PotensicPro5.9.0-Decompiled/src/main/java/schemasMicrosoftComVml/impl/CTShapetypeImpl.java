package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
import schemasMicrosoftComOfficeOffice.CTComplex;
import schemasMicrosoftComOfficeOffice.CTExtrusion;
import schemasMicrosoftComOfficeOffice.CTLock;
import schemasMicrosoftComOfficeOffice.CTSignatureLine;
import schemasMicrosoftComOfficeOffice.CTSkew;
import schemasMicrosoftComOfficeOffice.STBWMode;
import schemasMicrosoftComOfficeOffice.STBWMode$Enum;
import schemasMicrosoftComOfficeOffice.STConnectorType;
import schemasMicrosoftComOfficeOffice.STConnectorType$Enum;
import schemasMicrosoftComOfficeOffice.STHrAlign;
import schemasMicrosoftComOfficeOffice.STHrAlign$Enum;
import schemasMicrosoftComOfficeOffice.STInsetMode;
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComOfficeOffice.STTrueFalseBlank;
import schemasMicrosoftComOfficeOffice.STTrueFalseBlank$Enum;
import schemasMicrosoftComOfficePowerpoint.CTRel;
import schemasMicrosoftComOfficeWord.CTAnchorLock;
import schemasMicrosoftComOfficeWord.CTBorder;
import schemasMicrosoftComOfficeWord.CTWrap;
import schemasMicrosoftComVml.CTFill;
import schemasMicrosoftComVml.CTFormulas;
import schemasMicrosoftComVml.CTHandles;
import schemasMicrosoftComVml.CTImageData;
import schemasMicrosoftComVml.CTPath;
import schemasMicrosoftComVml.CTShadow;
import schemasMicrosoftComVml.CTShapetype;
import schemasMicrosoftComVml.CTStroke;
import schemasMicrosoftComVml.CTTextPath;
import schemasMicrosoftComVml.CTTextbox;
import schemasMicrosoftComVml.STColorType;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTShapetypeImpl extends XmlComplexContentImpl implements CTShapetype {
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
    private static final QName COMPLEX$46 = new QName("urn:schemas-microsoft-com:office:office", "complex");
    private static final QName ID$48 = new QName("", TtmlNode.ATTR_ID);
    private static final QName STYLE$50 = new QName("", TtmlNode.TAG_STYLE);
    private static final QName HREF$52 = new QName("", "href");
    private static final QName TARGET$54 = new QName("", "target");
    private static final QName CLASS1$56 = new QName("", JamXmlElements.CLASS);
    private static final QName TITLE$58 = new QName("", "title");
    private static final QName ALT$60 = new QName("", "alt");
    private static final QName COORDSIZE$62 = new QName("", "coordsize");
    private static final QName COORDORIGIN$64 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$66 = new QName("", "wrapcoords");
    private static final QName PRINT$68 = new QName("", "print");
    private static final QName SPID$70 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$72 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$74 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$76 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$78 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$80 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$82 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$84 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$86 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$88 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$90 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$92 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$94 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$96 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$98 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$100 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$106 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$108 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$112 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$114 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$116 = new QName("", "chromakey");
    private static final QName FILLED$118 = new QName("", TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
    private static final QName FILLCOLOR$120 = new QName("", "fillcolor");
    private static final QName OPACITY$122 = new QName("", "opacity");
    private static final QName STROKED$124 = new QName("", "stroked");
    private static final QName STROKECOLOR$126 = new QName("", "strokecolor");
    private static final QName STROKEWEIGHT$128 = new QName("", "strokeweight");
    private static final QName INSETPEN$130 = new QName("", "insetpen");
    private static final QName SPT$132 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$134 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$136 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$138 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$140 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$142 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$144 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$146 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$148 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$150 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$152 = new QName("urn:schemas-microsoft-com:office:office", "clip");
    private static final QName ADJ$154 = new QName("", "adj");
    private static final QName PATH2$156 = new QName("", "path");
    private static final QName MASTER$158 = new QName("urn:schemas-microsoft-com:office:office", "master");

    public CTShapetypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder addNewBorderbottom() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder addNewBorderleft() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder addNewBorderright() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder addNewBordertop() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTCallout addNewCallout() {
        CTCallout add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTClientData addNewClientData() {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTClipPath addNewClippath() {
        CTClipPath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTComplex addNewComplex() {
        CTComplex add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(COMPLEX$46);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTExtrusion addNewExtrusion() {
        CTExtrusion add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTFill addNewFill() {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().add_element_user(FILL$6);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTHandles addNewHandles() {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().add_element_user(HANDLES$4);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTImageData addNewImagedata() {
        CTImageData add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTLock addNewLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().add_element_user(LOCK$24);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTPath addNewPath() {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().add_element_user(PATH$0);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTShadow addNewShadow() {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().add_element_user(SHADOW$10);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTSkew addNewSkew() {
        CTSkew add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SKEW$18);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTStroke addNewStroke() {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().add_element_user(STROKE$8);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTRel addNewTextdata() {
        CTRel add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTWrap addNewWrap() {
        CTWrap add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(WRAP$30);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getAdj() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ADJ$154);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWINCELL$94);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWOVERLAP$96);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALT$60);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTAnchorLock> getAnchorlockList() {
        1AnchorlockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorlockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTBorder> getBorderbottomList() {
        1BorderbottomList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderbottomList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTBorder> getBorderleftList() {
        1BorderleftList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderleftList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERLEFTCOLOR$102);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTBorder> getBorderrightList() {
        1BorderrightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderrightList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTBorder> getBordertopList() {
        1BordertopList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BordertopList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERTOPCOLOR$100);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BULLET$82);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BUTTON$78);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode$Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWMODE$136);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode$Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWNORMAL$140);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode$Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWPURE$138);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTCallout> getCalloutList() {
        1CalloutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalloutList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CHROMAKEY$116);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLASS1$56);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTClientData> getClientDataList() {
        1ClientDataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClientDataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLIP$152);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTClipPath> getClippathList() {
        1ClippathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClippathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLIPTOWRAP$150);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTComplex getComplex() {
        synchronized (monitor()) {
            check_orphaned();
            CTComplex find_element_user = get_store().find_element_user(COMPLEX$46, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STConnectorType$Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STConnectorType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDORIGIN$64);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDSIZE$62);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUT$108);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUTMRU$112);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMNODEKIND$110);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTExtrusion> getExtrusionList() {
        1ExtrusionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtrusionList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTFill> getFillList() {
        1FillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLCOLOR$120);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLED$118);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORCEDASH$142);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTFormulas> getFormulasList() {
        1FormulasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulasList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTHandles> getHandlesList() {
        1HandlesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HandlesList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HR$84);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STHrAlign$Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HREF$52);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRNOSHADE$88);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRPCT$90);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRSTD$86);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$48);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTImageData> getImagedataList() {
        1ImagedataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImagedataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSETPEN$130);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getMaster() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MASTER$158);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalseBlank$Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OLE$146);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalseBlank$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OLEICON$144);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ONED$72);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY$122);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getPath2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PATH2$156);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTPath> getPathList() {
        1PathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PREFERRELATIVE$148);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRINT$68);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REGROUPID$74);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTShadow> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTSignatureLine> getSignaturelineList() {
        1SignaturelineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignaturelineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTSkew> getSkewList() {
        1SkewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SkewList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPID$70);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPT$132);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTStroke> getStrokeList() {
        1StrokeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrokeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKECOLOR$126);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKED$124);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKEWEIGHT$128);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$50);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGET$54);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTTextbox> getTextboxList() {
        1TextboxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextboxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTRel> getTextdataList() {
        1TextdataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextdataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTTextPath> getTextpathList() {
        1TextpathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextpathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TITLE$58);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERDRAWN$98);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse$Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERHIDDEN$80);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public List<CTWrap> getWrapList() {
        1WrapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WrapList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WRAPCOORDS$66);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder insertNewBorderleft(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder insertNewBorderright(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTBorder insertNewBordertop(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTCallout insertNewCallout(int i) {
        CTCallout insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTClipPath insertNewClippath(int i) {
        CTClipPath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTFill insertNewFill(int i) {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().insert_element_user(FILL$6, i);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTImageData insertNewImagedata(int i) {
        CTImageData insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTLock insertNewLock(int i) {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().insert_element_user(LOCK$24, i);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTPath insertNewPath(int i) {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().insert_element_user(PATH$0, i);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTSkew insertNewSkew(int i) {
        CTSkew insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().insert_element_user(STROKE$8, i);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTRel insertNewTextdata(int i) {
        CTRel insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public CTWrap insertNewWrap(int i) {
        CTWrap insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetAdj() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJ$154) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$94) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$96) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$60) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$104) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$102) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$106) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$100) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$82) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$78) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$136) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$140) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$138) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$116) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$56) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$152) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$150) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetComplex() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COMPLEX$46) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$134) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$64) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$62) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$108) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$112) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$110) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$120) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$118) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$142) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$84) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$92) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$52) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$88) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$90) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$86) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$48) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$114) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$130) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetMaster() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MASTER$158) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$146) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$144) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$72) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$122) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetPath2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH2$156) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$148) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$68) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$74) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$70) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$132) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$126) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$124) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$128) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$50) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$54) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$58) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$98) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$80) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$66) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setAdj(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setAllowincell(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setAllowoverlap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAnchorLockArr, ANCHORLOCK$32);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERBOTTOM$36);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERLEFT$38);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERRIGHT$40);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERTOP$34);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBullet(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setButton(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBwmode(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBwnormal(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setBwpure(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCalloutArr, CALLOUT$22);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setClip(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTClipPathArr, CLIPPATH$26);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setCliptowrap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setComplex(CTComplex cTComplex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPLEX$46;
            CTComplex find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTComplex) get_store().add_element_user(qName);
            }
            find_element_user.set(cTComplex);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setConnectortype(STConnectorType$Enum sTConnectorType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTConnectorType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setDoubleclicknotify(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTExtrusionArr, EXTRUSION$20);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setFillArray(CTFill[] cTFillArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFillArr, FILL$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setFilled(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setForcedash(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFormulasArr, FORMULAS$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHandlesArr, HANDLES$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHr(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHralign(STHrAlign$Enum sTHrAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTHrAlign$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHrnoshade(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setHrstd(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTImageDataArr, IMAGEDATA$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setInsetpen(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$24);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setMaster(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setOle(STTrueFalseBlank$Enum sTTrueFalseBlank$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalseBlank$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setOleicon(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setOned(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setPath2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setPathArray(CTPath[] cTPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPathArr, PATH$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setPreferrelative(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setPrint(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setShadowArray(CTShadow[] cTShadowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShadowArr, SHADOW$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSignatureLineArr, SIGNATURELINE$28);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setSkewArray(CTSkew[] cTSkewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSkewArr, SKEW$18);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrokeArr, STROKE$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setStroked(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextboxArr, TEXTBOX$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setTextdataArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRelArr, TEXTDATA$44);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextPathArr, TEXTPATH$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setUserdrawn(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setUserhidden(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
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

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setWrapArray(CTWrap[] cTWrapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTWrapArr, WRAP$30);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfAnchorlockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfBorderbottomArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfBorderleftArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfBorderrightArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfBordertopArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERTOP$34);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfCalloutArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CALLOUT$22);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfClientDataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfClippathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIPPATH$26);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfExtrusionArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXTRUSION$20);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILL$6);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfFormulasArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FORMULAS$2);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfHandlesArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HANDLES$4);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfImagedataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfLockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCK$24);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfPathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PATH$0);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfShadowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHADOW$10);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfSignaturelineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfSkewArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SKEW$18);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfStrokeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(STROKE$8);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfTextboxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTBOX$12);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfTextdataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTDATA$44);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfTextpathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTPATH$14);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public int sizeOfWrapArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WRAP$30);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetAdj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJ$154);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$94);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$96);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$60);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$104);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$102);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$106);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$100);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$82);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$78);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$136);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$140);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$138);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$116);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$56);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$152);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$150);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetComplex() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMPLEX$46, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$134);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$64);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$62);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$108);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$112);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$110);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$76);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$120);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$118);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$142);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$84);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$92);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$52);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$88);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$90);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$86);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$48);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$114);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$130);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetMaster() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MASTER$158);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$146);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$144);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$72);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$122);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetPath2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH2$156);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$148);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$68);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$74);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$70);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$132);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$126);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$124);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$128);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$50);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$54);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$58);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$98);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$80);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$66);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetAdj() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ADJ$154);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowincell() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWINCELL$94);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowoverlap() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$96);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetAlt() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ALT$60);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERBOTTOMCOLOR$104);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetBorderleftcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERLEFTCOLOR$102);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetBorderrightcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERRIGHTCOLOR$106);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetBordertopcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERTOPCOLOR$100);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetBullet() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BULLET$82);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetButton() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BUTTON$78);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode xgetBwmode() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWMODE$136);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode xgetBwnormal() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWNORMAL$140);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STBWMode xgetBwpure() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWPURE$138);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STColorType xgetChromakey() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(CHROMAKEY$116);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetClass1() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CLASS1$56);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetClip() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CLIP$152);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetCliptowrap() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$150);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STConnectorType xgetConnectortype() {
        STConnectorType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetCoordorigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDORIGIN$64);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetCoordsize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDSIZE$62);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUT$108);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUTMRU$112);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMNODEKIND$110);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetDoubleclicknotify() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$76);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STColorType xgetFillcolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(FILLCOLOR$120);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(FILLED$118);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetForcedash() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(FORCEDASH$142);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHr() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HR$84);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STHrAlign xgetHralign() {
        STHrAlign find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(HREF$52);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrnoshade() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRNOSHADE$88);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(HRPCT$90);
        }
        return xmlFloat;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrstd() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRSTD$86);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$48);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            sTInsetMode = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode == null) {
                sTInsetMode = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetMode;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse xgetInsetpen() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(INSETPEN$130);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetMaster() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(MASTER$158);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(OLE$146);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetOleicon() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(OLEICON$144);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetOned() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ONED$72);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetOpacity() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY$122);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetPath2() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PATH2$156);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetPreferrelative() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$148);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PRINT$68);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(REGROUPID$74);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetSpid() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SPID$70);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(SPT$132);
        }
        return xmlFloat;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STColorType xgetStrokecolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(STROKECOLOR$126);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public STTrueFalse xgetStroked() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(STROKED$124);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetStrokeweight() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STROKEWEIGHT$128);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$50);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetTarget() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TARGET$54);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TITLE$58);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserdrawn() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERDRAWN$98);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserhidden() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERHIDDEN$80);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public XmlString xgetWrapcoords() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(WRAPCOORDS$66);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetAdj(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$154;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetAllowincell(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$94;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetAllowoverlap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$96;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$60;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$104;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$102;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$106;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$100;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBullet(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$82;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetButton(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$78;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$136;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$140;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$138;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$116;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$56;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetClip(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$152;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetCliptowrap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$150;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$134;
            STConnectorType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTConnectorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$64;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$62;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$108;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$112;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$110;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetDoubleclicknotify(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$76;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$120;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$118;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetForcedash(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$142;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHr(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$84;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$92;
            STHrAlign find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTHrAlign);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$52;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHrnoshade(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$88;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$90;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qName);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetHrstd(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$86;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$48;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$114;
            STInsetMode sTInsetMode2 = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode2 == null) {
                sTInsetMode2 = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetMode2.set(sTInsetMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetInsetpen(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$130;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetMaster(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTER$158;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$146;
            STTrueFalseBlank find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetOleicon(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$144;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetOned(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$72;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$122;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetPath2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$156;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetPreferrelative(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$148;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$68;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$74;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$70;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$132;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qName);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$126;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetStroked(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$124;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$128;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$50;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$54;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$58;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetUserdrawn(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$98;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetUserhidden(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$80;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShapetype
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$66;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
