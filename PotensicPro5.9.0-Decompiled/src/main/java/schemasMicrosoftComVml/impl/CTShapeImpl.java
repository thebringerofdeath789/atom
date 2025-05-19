package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
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
import schemasMicrosoftComOfficeOffice.CTExtrusion;
import schemasMicrosoftComOfficeOffice.CTInk;
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
import schemasMicrosoftComOfficePowerpoint.CTEmpty;
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
import schemasMicrosoftComVml.CTShape;
import schemasMicrosoftComVml.CTStroke;
import schemasMicrosoftComVml.CTTextPath;
import schemasMicrosoftComVml.CTTextbox;
import schemasMicrosoftComVml.STColorType;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
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
    private static final QName INK$46 = new QName("urn:schemas-microsoft-com:office:office", "ink");
    private static final QName ISCOMMENT$48 = new QName("urn:schemas-microsoft-com:office:powerpoint", "iscomment");
    private static final QName ID$50 = new QName("", TtmlNode.ATTR_ID);
    private static final QName STYLE$52 = new QName("", TtmlNode.TAG_STYLE);
    private static final QName HREF$54 = new QName("", "href");
    private static final QName TARGET$56 = new QName("", "target");
    private static final QName CLASS1$58 = new QName("", JamXmlElements.CLASS);
    private static final QName TITLE$60 = new QName("", "title");
    private static final QName ALT$62 = new QName("", "alt");
    private static final QName COORDSIZE$64 = new QName("", "coordsize");
    private static final QName COORDORIGIN$66 = new QName("", "coordorigin");
    private static final QName WRAPCOORDS$68 = new QName("", "wrapcoords");
    private static final QName PRINT$70 = new QName("", "print");
    private static final QName SPID$72 = new QName("urn:schemas-microsoft-com:office:office", "spid");
    private static final QName ONED$74 = new QName("urn:schemas-microsoft-com:office:office", "oned");
    private static final QName REGROUPID$76 = new QName("urn:schemas-microsoft-com:office:office", "regroupid");
    private static final QName DOUBLECLICKNOTIFY$78 = new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify");
    private static final QName BUTTON$80 = new QName("urn:schemas-microsoft-com:office:office", "button");
    private static final QName USERHIDDEN$82 = new QName("urn:schemas-microsoft-com:office:office", "userhidden");
    private static final QName BULLET$84 = new QName("urn:schemas-microsoft-com:office:office", "bullet");
    private static final QName HR$86 = new QName("urn:schemas-microsoft-com:office:office", "hr");
    private static final QName HRSTD$88 = new QName("urn:schemas-microsoft-com:office:office", "hrstd");
    private static final QName HRNOSHADE$90 = new QName("urn:schemas-microsoft-com:office:office", "hrnoshade");
    private static final QName HRPCT$92 = new QName("urn:schemas-microsoft-com:office:office", "hrpct");
    private static final QName HRALIGN$94 = new QName("urn:schemas-microsoft-com:office:office", "hralign");
    private static final QName ALLOWINCELL$96 = new QName("urn:schemas-microsoft-com:office:office", "allowincell");
    private static final QName ALLOWOVERLAP$98 = new QName("urn:schemas-microsoft-com:office:office", "allowoverlap");
    private static final QName USERDRAWN$100 = new QName("urn:schemas-microsoft-com:office:office", "userdrawn");
    private static final QName BORDERTOPCOLOR$102 = new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor");
    private static final QName BORDERLEFTCOLOR$104 = new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor");
    private static final QName BORDERBOTTOMCOLOR$106 = new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor");
    private static final QName BORDERRIGHTCOLOR$108 = new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor");
    private static final QName DGMLAYOUT$110 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayout");
    private static final QName DGMNODEKIND$112 = new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind");
    private static final QName DGMLAYOUTMRU$114 = new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru");
    private static final QName INSETMODE$116 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");
    private static final QName CHROMAKEY$118 = new QName("", "chromakey");
    private static final QName FILLED$120 = new QName("", TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
    private static final QName FILLCOLOR$122 = new QName("", "fillcolor");
    private static final QName OPACITY$124 = new QName("", "opacity");
    private static final QName STROKED$126 = new QName("", "stroked");
    private static final QName STROKECOLOR$128 = new QName("", "strokecolor");
    private static final QName STROKEWEIGHT$130 = new QName("", "strokeweight");
    private static final QName INSETPEN$132 = new QName("", "insetpen");
    private static final QName SPT$134 = new QName("urn:schemas-microsoft-com:office:office", "spt");
    private static final QName CONNECTORTYPE$136 = new QName("urn:schemas-microsoft-com:office:office", "connectortype");
    private static final QName BWMODE$138 = new QName("urn:schemas-microsoft-com:office:office", "bwmode");
    private static final QName BWPURE$140 = new QName("urn:schemas-microsoft-com:office:office", "bwpure");
    private static final QName BWNORMAL$142 = new QName("urn:schemas-microsoft-com:office:office", "bwnormal");
    private static final QName FORCEDASH$144 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName OLEICON$146 = new QName("urn:schemas-microsoft-com:office:office", "oleicon");
    private static final QName OLE$148 = new QName("urn:schemas-microsoft-com:office:office", "ole");
    private static final QName PREFERRELATIVE$150 = new QName("urn:schemas-microsoft-com:office:office", "preferrelative");
    private static final QName CLIPTOWRAP$152 = new QName("urn:schemas-microsoft-com:office:office", "cliptowrap");
    private static final QName CLIP$154 = new QName("urn:schemas-microsoft-com:office:office", "clip");
    private static final QName TYPE$156 = new QName("", "type");
    private static final QName ADJ$158 = new QName("", "adj");
    private static final QName PATH2$160 = new QName("", "path");
    private static final QName GFXDATA$162 = new QName("urn:schemas-microsoft-com:office:office", "gfxdata");
    private static final QName EQUATIONXML$164 = new QName("", "equationxml");

    public CTShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ANCHORLOCK$32);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder addNewBorderbottom() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERBOTTOM$36);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder addNewBorderleft() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERLEFT$38);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder addNewBorderright() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERRIGHT$40);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder addNewBordertop() {
        CTBorder add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BORDERTOP$34);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTCallout addNewCallout() {
        CTCallout add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CALLOUT$22);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTClientData addNewClientData() {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().add_element_user(CLIENTDATA$42);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTClipPath addNewClippath() {
        CTClipPath add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CLIPPATH$26);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTExtrusion addNewExtrusion() {
        CTExtrusion add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTRUSION$20);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTFill addNewFill() {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().add_element_user(FILL$6);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().add_element_user(FORMULAS$2);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTHandles addNewHandles() {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().add_element_user(HANDLES$4);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTImageData addNewImagedata() {
        CTImageData add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(IMAGEDATA$16);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTInk addNewInk() {
        CTInk add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(INK$46);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTEmpty addNewIscomment() {
        CTEmpty add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ISCOMMENT$48);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTLock addNewLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().add_element_user(LOCK$24);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTPath addNewPath() {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().add_element_user(PATH$0);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTShadow addNewShadow() {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().add_element_user(SHADOW$10);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SIGNATURELINE$28);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTSkew addNewSkew() {
        CTSkew add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SKEW$18);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTStroke addNewStroke() {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().add_element_user(STROKE$8);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().add_element_user(TEXTBOX$12);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTRel addNewTextdata() {
        CTRel add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTDATA$44);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().add_element_user(TEXTPATH$14);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTWrap addNewWrap() {
        CTWrap add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(WRAP$30);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getAdj() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ADJ$158);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWINCELL$96);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALLOWOVERLAP$98);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getAlt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALT$62);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTAnchorLock> getAnchorlockList() {
        1AnchorlockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorlockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTBorder> getBorderbottomList() {
        1BorderbottomList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderbottomList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTBorder> getBorderleftList() {
        1BorderleftList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderleftList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERLEFTCOLOR$104);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTBorder> getBorderrightList() {
        1BorderrightList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BorderrightList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTBorder> getBordertopList() {
        1BordertopList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BordertopList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERTOPCOLOR$102);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getBullet() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BULLET$84);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getButton() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BUTTON$80);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode$Enum getBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWMODE$138);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode$Enum getBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWNORMAL$142);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode$Enum getBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWPURE$140);
            if (simpleValue == null) {
                return null;
            }
            return (STBWMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTCallout> getCalloutList() {
        1CalloutList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalloutList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CHROMAKEY$118);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getClass1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLASS1$58);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTClientData> getClientDataList() {
        AbstractList<CTClientData> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTClientData>() { // from class: schemasMicrosoftComVml.impl.CTShapeImpl.1ClientDataList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTClientData cTClientData) {
                    CTShapeImpl.this.insertNewClientData(i).set(cTClientData);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData get(int i) {
                    return CTShapeImpl.this.getClientDataArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData remove(int i) {
                    CTClientData clientDataArray = CTShapeImpl.this.getClientDataArray(i);
                    CTShapeImpl.this.removeClientData(i);
                    return clientDataArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTClientData set(int i, CTClientData cTClientData) {
                    CTClientData clientDataArray = CTShapeImpl.this.getClientDataArray(i);
                    CTShapeImpl.this.setClientDataArray(i, cTClientData);
                    return clientDataArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTShapeImpl.this.sizeOfClientDataArray();
                }
            };
        }
        return abstractList;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getClip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLIP$154);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTClipPath> getClippathList() {
        1ClippathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClippathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLIPTOWRAP$152);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STConnectorType$Enum getConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
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

    @Override // schemasMicrosoftComVml.CTShape
    public String getCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDORIGIN$66);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COORDSIZE$64);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public BigInteger getDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUT$110);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public BigInteger getDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMLAYOUTMRU$114);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public BigInteger getDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DGMNODEKIND$112);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getEquationxml() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EQUATIONXML$164);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTExtrusion> getExtrusionList() {
        1ExtrusionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtrusionList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTFill> getFillList() {
        1FillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLCOLOR$122);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse.Enum getFilled() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLED$120);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORCEDASH$144);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTFormulas> getFormulasList() {
        1FormulasList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FormulasList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public byte[] getGfxdata() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(GFXDATA$162);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTHandles> getHandlesList() {
        1HandlesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HandlesList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getHr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HR$86);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STHrAlign$Enum getHralign() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
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

    @Override // schemasMicrosoftComVml.CTShape
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HREF$54);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRNOSHADE$90);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public float getHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRPCT$92);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRSTD$88);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$50);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTImageData> getImagedataList() {
        1ImagedataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ImagedataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTInk getInkArray(int i) {
        CTInk find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(INK$46, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTInk[] getInkArray() {
        CTInk[] cTInkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INK$46, arrayList);
            cTInkArr = new CTInk[arrayList.size()];
            arrayList.toArray(cTInkArr);
        }
        return cTInkArr;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTInk> getInkList() {
        1InkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InkList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
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

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSETPEN$132);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTEmpty getIscommentArray(int i) {
        CTEmpty find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ISCOMMENT$48, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTEmpty[] getIscommentArray() {
        CTEmpty[] cTEmptyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ISCOMMENT$48, arrayList);
            cTEmptyArr = new CTEmpty[arrayList.size()];
            arrayList.toArray(cTEmptyArr);
        }
        return cTEmptyArr;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTEmpty> getIscommentList() {
        1IscommentList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IscommentList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTLock> getLockList() {
        1LockList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalseBlank$Enum getOle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OLE$148);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalseBlank$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OLEICON$146);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getOned() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ONED$74);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY$124);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getPath2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PATH2$160);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTPath> getPathList() {
        1PathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PREFERRELATIVE$150);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse.Enum getPrint() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRINT$70);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public BigInteger getRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REGROUPID$76);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTShadow> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTSignatureLine> getSignaturelineList() {
        1SignaturelineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SignaturelineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTSkew> getSkewList() {
        1SkewList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SkewList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getSpid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPID$72);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public float getSpt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPT$134);
            if (simpleValue == null) {
                return 0.0f;
            }
            return simpleValue.getFloatValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTStroke> getStrokeList() {
        1StrokeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrokeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKECOLOR$128);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse.Enum getStroked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKED$126);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKEWEIGHT$130);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$52);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGET$56);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTTextbox> getTextboxList() {
        1TextboxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextboxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTRel> getTextdataList() {
        1TextdataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextdataList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTTextPath> getTextpathList() {
        1TextpathList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextpathList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TITLE$60);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$156);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERDRAWN$100);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse$Enum getUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(USERHIDDEN$82);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public List<CTWrap> getWrapList() {
        1WrapList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WrapList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public String getWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WRAPCOORDS$68);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTAnchorLock insertNewAnchorlock(int i) {
        CTAnchorLock insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ANCHORLOCK$32, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder insertNewBorderbottom(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERBOTTOM$36, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder insertNewBorderleft(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERLEFT$38, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder insertNewBorderright(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERRIGHT$40, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTBorder insertNewBordertop(int i) {
        CTBorder insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BORDERTOP$34, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTCallout insertNewCallout(int i) {
        CTCallout insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CALLOUT$22, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTClientData insertNewClientData(int i) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().insert_element_user(CLIENTDATA$42, i);
        }
        return cTClientData;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTClipPath insertNewClippath(int i) {
        CTClipPath insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CLIPPATH$26, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTExtrusion insertNewExtrusion(int i) {
        CTExtrusion insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(EXTRUSION$20, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTFill insertNewFill(int i) {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().insert_element_user(FILL$6, i);
        }
        return cTFill;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTFormulas insertNewFormulas(int i) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().insert_element_user(FORMULAS$2, i);
        }
        return cTFormulas;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTHandles insertNewHandles(int i) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().insert_element_user(HANDLES$4, i);
        }
        return cTHandles;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTImageData insertNewImagedata(int i) {
        CTImageData insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(IMAGEDATA$16, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTInk insertNewInk(int i) {
        CTInk insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(INK$46, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTEmpty insertNewIscomment(int i) {
        CTEmpty insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ISCOMMENT$48, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTLock insertNewLock(int i) {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().insert_element_user(LOCK$24, i);
        }
        return cTLock;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTPath insertNewPath(int i) {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().insert_element_user(PATH$0, i);
        }
        return cTPath;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTShadow insertNewShadow(int i) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().insert_element_user(SHADOW$10, i);
        }
        return cTShadow;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTSignatureLine insertNewSignatureline(int i) {
        CTSignatureLine insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SIGNATURELINE$28, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTSkew insertNewSkew(int i) {
        CTSkew insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(SKEW$18, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTStroke insertNewStroke(int i) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().insert_element_user(STROKE$8, i);
        }
        return cTStroke;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTTextbox insertNewTextbox(int i) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().insert_element_user(TEXTBOX$12, i);
        }
        return cTTextbox;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTRel insertNewTextdata(int i) {
        CTRel insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TEXTDATA$44, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTTextPath insertNewTextpath(int i) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().insert_element_user(TEXTPATH$14, i);
        }
        return cTTextPath;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public CTWrap insertNewWrap(int i) {
        CTWrap insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(WRAP$30, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetAdj() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJ$158) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetAllowincell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWINCELL$96) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetAllowoverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALLOWOVERLAP$98) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetAlt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALT$62) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBorderbottomcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERBOTTOMCOLOR$106) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBorderleftcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERLEFTCOLOR$104) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBorderrightcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERRIGHTCOLOR$108) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBordertopcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERTOPCOLOR$102) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBullet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BULLET$84) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BUTTON$80) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBwmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$138) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBwnormal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWNORMAL$142) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetBwpure() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWPURE$140) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetChromakey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CHROMAKEY$118) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetClass1() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLASS1$58) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetClip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIP$154) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetCliptowrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLIPTOWRAP$152) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetConnectortype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTORTYPE$136) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetCoordorigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDORIGIN$66) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetCoordsize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COORDSIZE$64) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetDgmlayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUT$110) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetDgmlayoutmru() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMLAYOUTMRU$114) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetDgmnodekind() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DGMNODEKIND$112) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetDoubleclicknotify() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DOUBLECLICKNOTIFY$78) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetEquationxml() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EQUATIONXML$164) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetFillcolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLCOLOR$122) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetFilled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLED$120) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$144) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetGfxdata() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GFXDATA$162) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HR$86) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHralign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRALIGN$94) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$54) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHrnoshade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRNOSHADE$90) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHrpct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRPCT$92) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetHrstd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRSTD$88) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$50) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$116) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$132) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetOle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLE$148) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetOleicon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OLEICON$146) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetOned() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ONED$74) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$124) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetPath2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH2$160) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetPreferrelative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PREFERRELATIVE$150) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetPrint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRINT$70) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetRegroupid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REGROUPID$76) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetSpid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPID$72) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetSpt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPT$134) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetStrokecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKECOLOR$128) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetStroked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKED$126) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetStrokeweight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEWEIGHT$130) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$52) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetTarget() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TARGET$56) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$60) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$156) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetUserdrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$100) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetUserhidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERHIDDEN$82) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public boolean isSetWrapcoords() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAPCOORDS$68) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeAnchorlock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHORLOCK$32, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeBorderbottom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOTTOM$36, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeBorderleft(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERLEFT$38, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeBorderright(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERRIGHT$40, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeBordertop(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERTOP$34, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeCallout(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALLOUT$22, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeClientData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIENTDATA$42, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeClippath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLIPPATH$26, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeExtrusion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTRUSION$20, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$6, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeFormulas(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FORMULAS$2, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeHandles(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HANDLES$4, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeImagedata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(IMAGEDATA$16, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeInk(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INK$46, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeIscomment(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ISCOMMENT$48, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeLock(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCK$24, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$10, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeSignatureline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATURELINE$28, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeSkew(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SKEW$18, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeStroke(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STROKE$8, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeTextbox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTBOX$12, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeTextdata(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDATA$44, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeTextpath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTPATH$14, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void removeWrap(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAP$30, i);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setAdj(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$158;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setAllowincell(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$96;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setAllowoverlap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$98;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setAlt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$62;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAnchorLockArr, ANCHORLOCK$32);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERBOTTOM$36);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$106;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERLEFT$38);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$104;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERRIGHT$40);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$108;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderArr, BORDERTOP$34);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$102;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBullet(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$84;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setButton(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$80;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBwmode(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$138;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBwnormal(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$142;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setBwpure(STBWMode$Enum sTBWMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$140;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBWMode$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCalloutArr, CALLOUT$22);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setChromakey(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$118;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setClass1(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$58;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTClientDataArr, CLIENTDATA$42);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setClip(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$154;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTClipPathArr, CLIPPATH$26);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setCliptowrap(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$152;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setConnectortype(STConnectorType$Enum sTConnectorType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTConnectorType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$66;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$64;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$110;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$114;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$112;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setDoubleclicknotify(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$78;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setEquationxml(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUATIONXML$164;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTExtrusionArr, EXTRUSION$20);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setFillArray(CTFill[] cTFillArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFillArr, FILL$6);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$122;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setFilled(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$120;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setForcedash(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$144;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFormulasArr, FORMULAS$2);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setGfxdata(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GFXDATA$162;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTHandlesArr, HANDLES$4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHr(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$86;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHralign(STHrAlign$Enum sTHrAlign$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTHrAlign$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$54;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHrnoshade(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$90;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHrpct(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$92;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setHrstd(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$88;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTImageDataArr, IMAGEDATA$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setInkArray(int i, CTInk cTInk) {
        synchronized (monitor()) {
            check_orphaned();
            CTInk find_element_user = get_store().find_element_user(INK$46, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTInk);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setInkArray(CTInk[] cTInkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTInkArr, INK$46);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setInsetpen(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$132;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setIscommentArray(int i, CTEmpty cTEmpty) {
        synchronized (monitor()) {
            check_orphaned();
            CTEmpty find_element_user = get_store().find_element_user(ISCOMMENT$48, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTEmpty);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setIscommentArray(CTEmpty[] cTEmptyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTEmptyArr, ISCOMMENT$48);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setLockArray(CTLock[] cTLockArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLockArr, LOCK$24);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setOle(STTrueFalseBlank$Enum sTTrueFalseBlank$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$148;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalseBlank$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setOleicon(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$146;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setOned(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$74;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$124;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setPath2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$160;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setPathArray(CTPath[] cTPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPathArr, PATH$0);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setPreferrelative(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$150;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setPrint(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$70;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$76;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setShadowArray(CTShadow[] cTShadowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShadowArr, SHADOW$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSignatureLineArr, SIGNATURELINE$28);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setSkewArray(CTSkew[] cTSkewArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSkewArr, SKEW$18);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setSpid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$72;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setSpt(float f) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$134;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setFloatValue(f);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTStrokeArr, STROKE$8);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setStrokecolor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$128;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setStroked(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$126;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setStrokeweight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$130;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$52;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$56;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextboxArr, TEXTBOX$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setTextdataArray(CTRel[] cTRelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRelArr, TEXTDATA$44);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextPathArr, TEXTPATH$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$60;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$156;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setUserdrawn(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$100;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setUserhidden(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$82;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
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

    @Override // schemasMicrosoftComVml.CTShape
    public void setWrapArray(CTWrap[] cTWrapArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTWrapArr, WRAP$30);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$68;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfAnchorlockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ANCHORLOCK$32);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfBorderbottomArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERBOTTOM$36);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfBorderleftArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERLEFT$38);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfBorderrightArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERRIGHT$40);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfBordertopArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BORDERTOP$34);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfCalloutArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CALLOUT$22);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfClientDataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIENTDATA$42);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfClippathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLIPPATH$26);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfExtrusionArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXTRUSION$20);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILL$6);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfFormulasArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FORMULAS$2);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfHandlesArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HANDLES$4);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfImagedataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(IMAGEDATA$16);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfInkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INK$46);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfIscommentArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ISCOMMENT$48);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfLockArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCK$24);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfPathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PATH$0);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfShadowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHADOW$10);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfSignaturelineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SIGNATURELINE$28);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfSkewArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SKEW$18);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfStrokeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(STROKE$8);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfTextboxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTBOX$12);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfTextdataArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTDATA$44);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfTextpathArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTPATH$14);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public int sizeOfWrapArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WRAP$30);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetAdj() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJ$158);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWINCELL$96);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALLOWOVERLAP$98);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALT$62);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERBOTTOMCOLOR$106);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERLEFTCOLOR$104);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERRIGHTCOLOR$108);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERTOPCOLOR$102);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BULLET$84);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BUTTON$80);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBwmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$138);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBwnormal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWNORMAL$142);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetBwpure() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWPURE$140);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetChromakey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CHROMAKEY$118);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLASS1$58);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetClip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIP$154);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetCliptowrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLIPTOWRAP$152);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetConnectortype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTORTYPE$136);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDORIGIN$66);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COORDSIZE$64);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUT$110);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMLAYOUTMRU$114);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DGMNODEKIND$112);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DOUBLECLICKNOTIFY$78);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetEquationxml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EQUATIONXML$164);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLCOLOR$122);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLED$120);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$144);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetGfxdata() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GFXDATA$162);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HR$86);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRALIGN$94);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$54);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRNOSHADE$90);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRPCT$92);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRSTD$88);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$50);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$116);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$132);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetOle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLE$148);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetOleicon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OLEICON$146);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ONED$74);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$124);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetPath2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH2$160);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetPreferrelative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PREFERRELATIVE$150);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRINT$70);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REGROUPID$76);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPID$72);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetSpt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPT$134);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetStrokecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKECOLOR$128);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetStroked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKED$126);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetStrokeweight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEWEIGHT$130);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$52);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TARGET$56);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$60);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$156);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$100);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERHIDDEN$82);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAPCOORDS$68);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetAdj() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ADJ$158);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowincell() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWINCELL$96);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetAllowoverlap() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$98);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetAlt() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ALT$62);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERBOTTOMCOLOR$106);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetBorderleftcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERLEFTCOLOR$104);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetBorderrightcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERRIGHTCOLOR$108);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetBordertopcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(BORDERTOPCOLOR$102);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetBullet() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BULLET$84);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetButton() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BUTTON$80);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode xgetBwmode() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWMODE$138);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode xgetBwnormal() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWNORMAL$142);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STBWMode xgetBwpure() {
        STBWMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWPURE$140);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STColorType xgetChromakey() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(CHROMAKEY$118);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetClass1() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CLASS1$58);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetClip() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CLIP$154);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetCliptowrap() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(CLIPTOWRAP$152);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STConnectorType xgetConnectortype() {
        STConnectorType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STConnectorType) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetCoordorigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDORIGIN$66);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetCoordsize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(COORDSIZE$64);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlInteger xgetDgmlayout() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUT$110);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlInteger xgetDgmlayoutmru() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMLAYOUTMRU$114);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(DGMNODEKIND$112);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetDoubleclicknotify() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(DOUBLECLICKNOTIFY$78);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetEquationxml() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(EQUATIONXML$164);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STColorType xgetFillcolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(FILLCOLOR$122);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(FILLED$120);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetForcedash() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(FORCEDASH$144);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlBase64Binary xgetGfxdata() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(GFXDATA$162);
        }
        return xmlBase64Binary;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHr() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HR$86);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STHrAlign xgetHralign() {
        STHrAlign find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(HREF$54);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrnoshade() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRNOSHADE$90);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(HRPCT$92);
        }
        return xmlFloat;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetHrstd() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRSTD$88);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$50);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            sTInsetMode = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode == null) {
                sTInsetMode = (STInsetMode) get_default_attribute_value(qName);
            }
        }
        return sTInsetMode;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse xgetInsetpen() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(INSETPEN$132);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalseBlank xgetOle() {
        STTrueFalseBlank find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(OLE$148);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetOleicon() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(OLEICON$146);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetOned() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ONED$74);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetOpacity() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY$124);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetPath2() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PATH2$160);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetPreferrelative() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(PREFERRELATIVE$150);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PRINT$70);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(REGROUPID$76);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetSpid() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SPID$72);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlFloat xgetSpt() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(SPT$134);
        }
        return xmlFloat;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STColorType xgetStrokecolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(STROKECOLOR$128);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public STTrueFalse xgetStroked() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(STROKED$126);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetStrokeweight() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STROKEWEIGHT$130);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$52);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetTarget() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TARGET$56);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TITLE$60);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetType() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TYPE$156);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserdrawn() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERDRAWN$100);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetUserhidden() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(USERHIDDEN$82);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public XmlString xgetWrapcoords() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(WRAPCOORDS$68);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetAdj(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJ$158;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetAllowincell(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWINCELL$96;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetAllowoverlap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$98;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALT$62;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERBOTTOMCOLOR$106;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERLEFTCOLOR$104;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERRIGHTCOLOR$108;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERTOPCOLOR$102;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBullet(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BULLET$84;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetButton(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BUTTON$80;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBwmode(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$138;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBwnormal(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWNORMAL$142;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetBwpure(STBWMode sTBWMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWPURE$140;
            STBWMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBWMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBWMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetChromakey(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHROMAKEY$118;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLASS1$58;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetClip(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIP$154;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetCliptowrap(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIPTOWRAP$152;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetConnectortype(STConnectorType sTConnectorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTORTYPE$136;
            STConnectorType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STConnectorType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTConnectorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDORIGIN$66;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COORDSIZE$64;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetDgmlayout(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUT$110;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetDgmlayoutmru(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMLAYOUTMRU$114;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DGMNODEKIND$112;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetDoubleclicknotify(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOUBLECLICKNOTIFY$78;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetEquationxml(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EQUATIONXML$164;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLCOLOR$122;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLED$120;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetForcedash(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$144;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetGfxdata(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GFXDATA$162;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHr(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HR$86;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRALIGN$94;
            STHrAlign find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHrAlign) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTHrAlign);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$54;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHrnoshade(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRNOSHADE$90;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRPCT$92;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qName);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetHrstd(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRSTD$88;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$50;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETMODE$116;
            STInsetMode sTInsetMode2 = (STInsetMode) typeStore.find_attribute_user(qName);
            if (sTInsetMode2 == null) {
                sTInsetMode2 = (STInsetMode) get_store().add_attribute_user(qName);
            }
            sTInsetMode2.set(sTInsetMode);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetInsetpen(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$132;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetOle(STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLE$148;
            STTrueFalseBlank find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTrueFalseBlank) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetOleicon(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLEICON$146;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetOned(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ONED$74;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$124;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetPath2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH2$160;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetPreferrelative(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PREFERRELATIVE$150;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRINT$70;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REGROUPID$76;
            XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qName);
            if (xmlInteger2 == null) {
                xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qName);
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPID$72;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetSpt(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPT$134;
            XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qName);
            if (xmlFloat2 == null) {
                xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qName);
            }
            xmlFloat2.set(xmlFloat);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetStrokecolor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKECOLOR$128;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetStroked(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKED$126;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetStrokeweight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKEWEIGHT$130;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$52;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$56;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$60;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetType(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$156;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetUserdrawn(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$100;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetUserhidden(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERHIDDEN$82;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTShape
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPCOORDS$68;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
