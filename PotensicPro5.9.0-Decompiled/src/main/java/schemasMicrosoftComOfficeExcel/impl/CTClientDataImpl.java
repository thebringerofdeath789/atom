package schemasMicrosoftComOfficeExcel.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import schemasMicrosoftComOfficeExcel.CTClientData;
import schemasMicrosoftComOfficeExcel.STCF;
import schemasMicrosoftComOfficeExcel.STCF$Enum;
import schemasMicrosoftComOfficeExcel.STObjectType;
import schemasMicrosoftComOfficeExcel.STTrueFalseBlank;

/* loaded from: classes6.dex */
public class CTClientDataImpl extends XmlComplexContentImpl implements CTClientData {
    private static final QName MOVEWITHCELLS$0 = new QName("urn:schemas-microsoft-com:office:excel", "MoveWithCells");
    private static final QName SIZEWITHCELLS$2 = new QName("urn:schemas-microsoft-com:office:excel", "SizeWithCells");
    private static final QName ANCHOR$4 = new QName("urn:schemas-microsoft-com:office:excel", "Anchor");
    private static final QName LOCKED$6 = new QName("urn:schemas-microsoft-com:office:excel", "Locked");
    private static final QName DEFAULTSIZE$8 = new QName("urn:schemas-microsoft-com:office:excel", "DefaultSize");
    private static final QName PRINTOBJECT$10 = new QName("urn:schemas-microsoft-com:office:excel", "PrintObject");
    private static final QName DISABLED$12 = new QName("urn:schemas-microsoft-com:office:excel", "Disabled");
    private static final QName AUTOFILL$14 = new QName("urn:schemas-microsoft-com:office:excel", "AutoFill");
    private static final QName AUTOLINE$16 = new QName("urn:schemas-microsoft-com:office:excel", "AutoLine");
    private static final QName AUTOPICT$18 = new QName("urn:schemas-microsoft-com:office:excel", "AutoPict");
    private static final QName FMLAMACRO$20 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaMacro");
    private static final QName TEXTHALIGN$22 = new QName("urn:schemas-microsoft-com:office:excel", "TextHAlign");
    private static final QName TEXTVALIGN$24 = new QName("urn:schemas-microsoft-com:office:excel", "TextVAlign");
    private static final QName LOCKTEXT$26 = new QName("urn:schemas-microsoft-com:office:excel", "LockText");
    private static final QName JUSTLASTX$28 = new QName("urn:schemas-microsoft-com:office:excel", "JustLastX");
    private static final QName SECRETEDIT$30 = new QName("urn:schemas-microsoft-com:office:excel", "SecretEdit");
    private static final QName DEFAULT$32 = new QName("urn:schemas-microsoft-com:office:excel", "Default");
    private static final QName HELP$34 = new QName("urn:schemas-microsoft-com:office:excel", "Help");
    private static final QName CANCEL$36 = new QName("urn:schemas-microsoft-com:office:excel", "Cancel");
    private static final QName DISMISS$38 = new QName("urn:schemas-microsoft-com:office:excel", "Dismiss");
    private static final QName ACCEL$40 = new QName("urn:schemas-microsoft-com:office:excel", "Accel");
    private static final QName ACCEL2$42 = new QName("urn:schemas-microsoft-com:office:excel", "Accel2");
    private static final QName ROW$44 = new QName("urn:schemas-microsoft-com:office:excel", "Row");
    private static final QName COLUMN$46 = new QName("urn:schemas-microsoft-com:office:excel", "Column");
    private static final QName VISIBLE$48 = new QName("urn:schemas-microsoft-com:office:excel", "Visible");
    private static final QName ROWHIDDEN$50 = new QName("urn:schemas-microsoft-com:office:excel", "RowHidden");
    private static final QName COLHIDDEN$52 = new QName("urn:schemas-microsoft-com:office:excel", "ColHidden");
    private static final QName VTEDIT$54 = new QName("urn:schemas-microsoft-com:office:excel", "VTEdit");
    private static final QName MULTILINE$56 = new QName("urn:schemas-microsoft-com:office:excel", "MultiLine");
    private static final QName VSCROLL$58 = new QName("urn:schemas-microsoft-com:office:excel", "VScroll");
    private static final QName VALIDIDS$60 = new QName("urn:schemas-microsoft-com:office:excel", "ValidIds");
    private static final QName FMLARANGE$62 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaRange");
    private static final QName WIDTHMIN$64 = new QName("urn:schemas-microsoft-com:office:excel", "WidthMin");
    private static final QName SEL$66 = new QName("urn:schemas-microsoft-com:office:excel", "Sel");
    private static final QName NOTHREED2$68 = new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD2");
    private static final QName SELTYPE$70 = new QName("urn:schemas-microsoft-com:office:excel", "SelType");
    private static final QName MULTISEL$72 = new QName("urn:schemas-microsoft-com:office:excel", "MultiSel");
    private static final QName LCT$74 = new QName("urn:schemas-microsoft-com:office:excel", "LCT");
    private static final QName LISTITEM$76 = new QName("urn:schemas-microsoft-com:office:excel", "ListItem");
    private static final QName DROPSTYLE$78 = new QName("urn:schemas-microsoft-com:office:excel", "DropStyle");
    private static final QName COLORED$80 = new QName("urn:schemas-microsoft-com:office:excel", "Colored");
    private static final QName DROPLINES$82 = new QName("urn:schemas-microsoft-com:office:excel", "DropLines");
    private static final QName CHECKED$84 = new QName("urn:schemas-microsoft-com:office:excel", "Checked");
    private static final QName FMLALINK$86 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaLink");
    private static final QName FMLAPICT$88 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaPict");
    private static final QName NOTHREED$90 = new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD");
    private static final QName FIRSTBUTTON$92 = new QName("urn:schemas-microsoft-com:office:excel", "FirstButton");
    private static final QName FMLAGROUP$94 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaGroup");
    private static final QName VAL$96 = new QName("urn:schemas-microsoft-com:office:excel", "Val");
    private static final QName MIN$98 = new QName("urn:schemas-microsoft-com:office:excel", "Min");
    private static final QName MAX$100 = new QName("urn:schemas-microsoft-com:office:excel", "Max");
    private static final QName INC$102 = new QName("urn:schemas-microsoft-com:office:excel", "Inc");
    private static final QName PAGE$104 = new QName("urn:schemas-microsoft-com:office:excel", "Page");
    private static final QName HORIZ$106 = new QName("urn:schemas-microsoft-com:office:excel", "Horiz");
    private static final QName DX$108 = new QName("urn:schemas-microsoft-com:office:excel", "Dx");
    private static final QName MAPOCX$110 = new QName("urn:schemas-microsoft-com:office:excel", "MapOCX");
    private static final QName CF$112 = new QName("urn:schemas-microsoft-com:office:excel", "CF");
    private static final QName CAMERA$114 = new QName("urn:schemas-microsoft-com:office:excel", "Camera");
    private static final QName RECALCALWAYS$116 = new QName("urn:schemas-microsoft-com:office:excel", "RecalcAlways");
    private static final QName AUTOSCALE$118 = new QName("urn:schemas-microsoft-com:office:excel", "AutoScale");
    private static final QName DDE$120 = new QName("urn:schemas-microsoft-com:office:excel", "DDE");
    private static final QName UIOBJ$122 = new QName("urn:schemas-microsoft-com:office:excel", "UIObj");
    private static final QName SCRIPTTEXT$124 = new QName("urn:schemas-microsoft-com:office:excel", "ScriptText");
    private static final QName SCRIPTEXTENDED$126 = new QName("urn:schemas-microsoft-com:office:excel", "ScriptExtended");
    private static final QName SCRIPTLANGUAGE$128 = new QName("urn:schemas-microsoft-com:office:excel", "ScriptLanguage");
    private static final QName SCRIPTLOCATION$130 = new QName("urn:schemas-microsoft-com:office:excel", "ScriptLocation");
    private static final QName FMLATXBX$132 = new QName("urn:schemas-microsoft-com:office:excel", "FmlaTxbx");
    private static final QName OBJECTTYPE$134 = new QName("", "ObjectType");

    public CTClientDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAccel(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ACCEL$40)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAccel2(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ACCEL2$42)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAnchor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ANCHOR$4)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAutoFill(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(AUTOFILL$14)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAutoLine(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(AUTOLINE$16)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAutoPict(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(AUTOPICT$18)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addAutoScale(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(AUTOSCALE$118)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addCF(STCF$Enum sTCF$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CF$112)).setEnumValue(sTCF$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addCamera(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CAMERA$114)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addCancel(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CANCEL$36)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addChecked(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(CHECKED$84)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addColHidden(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(COLHIDDEN$52)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addColored(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(COLORED$80)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addColumn(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(COLUMN$46)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDDE(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DDE$120)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDefault(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DEFAULT$32)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDefaultSize(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DEFAULTSIZE$8)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDisabled(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DISABLED$12)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDismiss(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DISMISS$38)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDropLines(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DROPLINES$82)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDropStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DROPSTYLE$78)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addDx(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(DX$108)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFirstButton(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FIRSTBUTTON$92)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaGroup(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLAGROUP$94)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaLink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLALINK$86)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLAMACRO$20)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaPict(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLAPICT$88)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaRange(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLARANGE$62)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addFmlaTxbx(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(FMLATXBX$132)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addHelp(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(HELP$34)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addHoriz(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(HORIZ$106)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addInc(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(INC$102)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addJustLastX(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(JUSTLASTX$28)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addLCT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LCT$74)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addListItem(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LISTITEM$76)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addLockText(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LOCKTEXT$26)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addLocked(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(LOCKED$6)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMapOCX(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MAPOCX$110)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMax(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MAX$100)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMin(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MIN$98)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMoveWithCells(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MOVEWITHCELLS$0)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMultiLine(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MULTILINE$56)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addMultiSel(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(MULTISEL$72)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewAccel() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(ACCEL$40);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewAccel2() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(ACCEL2$42);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewAnchor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(ANCHOR$4);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewAutoFill() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(AUTOFILL$14);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewAutoLine() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(AUTOLINE$16);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewAutoPict() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(AUTOPICT$18);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewAutoScale() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(AUTOSCALE$118);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF addNewCF() {
        STCF add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CF$112);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewCamera() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(CAMERA$114);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewCancel() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(CANCEL$36);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewChecked() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(CHECKED$84);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewColHidden() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(COLHIDDEN$52);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewColored() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(COLORED$80);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewColumn() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(COLUMN$46);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewDDE() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(DDE$120);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewDefault() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(DEFAULT$32);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewDefaultSize() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(DEFAULTSIZE$8);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewDisabled() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(DISABLED$12);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewDismiss() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(DISMISS$38);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewDropLines() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(DROPLINES$82);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewDropStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(DROPSTYLE$78);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewDx() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(DX$108);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewFirstButton() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(FIRSTBUTTON$92);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaGroup() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLAGROUP$94);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaLink() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLALINK$86);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaMacro() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLAMACRO$20);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaPict() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLAPICT$88);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaRange() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLARANGE$62);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewFmlaTxbx() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(FMLATXBX$132);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewHelp() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(HELP$34);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewHoriz() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(HORIZ$106);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewInc() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(INC$102);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewJustLastX() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(JUSTLASTX$28);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewLCT() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(LCT$74);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewListItem() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(LISTITEM$76);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewLockText() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(LOCKTEXT$26);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewLocked() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(LOCKED$6);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewMapOCX() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(MAPOCX$110);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewMax() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(MAX$100);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewMin() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(MIN$98);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewMoveWithCells() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(MOVEWITHCELLS$0);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewMultiLine() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(MULTILINE$56);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewMultiSel() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(MULTISEL$72);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewNoThreeD() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(NOTHREED$90);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewNoThreeD2() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(NOTHREED2$68);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewPage() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PAGE$104);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewPrintObject() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PRINTOBJECT$10);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewRecalcAlways() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(RECALCALWAYS$116);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewRow() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(ROW$44);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewRowHidden() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(ROWHIDDEN$50);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewScriptExtended() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(SCRIPTEXTENDED$126);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger addNewScriptLanguage() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().add_element_user(SCRIPTLANGUAGE$128);
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger addNewScriptLocation() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().add_element_user(SCRIPTLOCATION$130);
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewScriptText() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(SCRIPTTEXT$124);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewSecretEdit() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(SECRETEDIT$30);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewSel() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(SEL$66);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewSelType() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(SELTYPE$70);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewSizeWithCells() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(SIZEWITHCELLS$2);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewTextHAlign() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(TEXTHALIGN$22);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString addNewTextVAlign() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(TEXTVALIGN$24);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewUIObj() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(UIOBJ$122);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewVScroll() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(VSCROLL$58);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewVTEdit() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(VTEDIT$54);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewVal() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(VAL$96);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewValidIds() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(VALIDIDS$60);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank addNewVisible() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(VISIBLE$48);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger addNewWidthMin() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(WIDTHMIN$64);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addNoThreeD(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(NOTHREED$90)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addNoThreeD2(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(NOTHREED2$68)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addPage(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PAGE$104)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addPrintObject(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PRINTOBJECT$10)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addRecalcAlways(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(RECALCALWAYS$116)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addRow(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ROW$44)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addRowHidden(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(ROWHIDDEN$50)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addScriptExtended(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SCRIPTEXTENDED$126)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addScriptLanguage(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SCRIPTLANGUAGE$128)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addScriptLocation(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SCRIPTLOCATION$130)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addScriptText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SCRIPTTEXT$124)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addSecretEdit(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SECRETEDIT$30)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addSel(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SEL$66)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addSelType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SELTYPE$70)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addSizeWithCells(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(SIZEWITHCELLS$2)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addTextHAlign(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(TEXTHALIGN$22)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addTextVAlign(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(TEXTVALIGN$24)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addUIObj(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(UIOBJ$122)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addVScroll(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(VSCROLL$58)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addVTEdit(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(VTEDIT$54)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addVal(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(VAL$96)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addValidIds(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(VALIDIDS$60)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addVisible(STTrueFalseBlank.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(VISIBLE$48)).setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void addWidthMin(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(WIDTHMIN$64)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getAccel2Array(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ACCEL2$42, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getAccel2Array() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACCEL2$42, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getAccel2List() {
        1Accel2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1Accel2List(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getAccelArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ACCEL$40, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getAccelArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACCEL$40, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getAccelList() {
        1AccelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AccelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getAnchorArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ANCHOR$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getAnchorArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHOR$4, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getAnchorList() {
        1AnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getAutoFillArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOFILL$14, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoFillArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOFILL$14, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoFillList() {
        1AutoFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AutoFillList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getAutoLineArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOLINE$16, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoLineArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOLINE$16, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoLineList() {
        1AutoLineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AutoLineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getAutoPictArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOPICT$18, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoPictArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOPICT$18, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoPictList() {
        1AutoPictList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AutoPictList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getAutoScaleArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOSCALE$118, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoScaleArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOSCALE$118, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoScaleList() {
        1AutoScaleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AutoScaleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF$Enum getCFArray(int i) {
        STCF$Enum sTCF$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CF$112, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            sTCF$Enum = (STCF$Enum) simpleValue.getEnumValue();
        }
        return sTCF$Enum;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF$Enum[] getCFArray() {
        STCF$Enum[] sTCF$EnumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CF$112, arrayList);
            sTCF$EnumArr = new STCF$Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sTCF$EnumArr[i] = (STCF$Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return sTCF$EnumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STCF$Enum> getCFList() {
        1CFList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CFList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getCameraArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CAMERA$114, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getCameraArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CAMERA$114, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getCameraList() {
        1CameraList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CameraList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getCancelArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CANCEL$36, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getCancelArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CANCEL$36, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getCancelList() {
        1CancelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CancelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getCheckedArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CHECKED$84, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getCheckedArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHECKED$84, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getCheckedList() {
        1CheckedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CheckedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getColHiddenArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLHIDDEN$52, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getColHiddenArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLHIDDEN$52, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getColHiddenList() {
        1ColHiddenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColHiddenList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getColoredArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLORED$80, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getColoredArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLORED$80, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getColoredList() {
        1ColoredList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColoredList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getColumnArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLUMN$46, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getColumnArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLUMN$46, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getColumnList() {
        1ColumnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColumnList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getDDEArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DDE$120, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getDDEArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DDE$120, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getDDEList() {
        1DDEList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DDEList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getDefaultArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DEFAULT$32, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getDefaultArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEFAULT$32, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getDefaultList() {
        1DefaultList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DefaultList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getDefaultSizeArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DEFAULTSIZE$8, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getDefaultSizeArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEFAULTSIZE$8, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getDefaultSizeList() {
        1DefaultSizeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DefaultSizeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getDisabledArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DISABLED$12, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getDisabledArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DISABLED$12, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getDisabledList() {
        1DisabledList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DisabledList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getDismissArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DISMISS$38, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getDismissArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DISMISS$38, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getDismissList() {
        1DismissList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DismissList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getDropLinesArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DROPLINES$82, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getDropLinesArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPLINES$82, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getDropLinesList() {
        1DropLinesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DropLinesList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getDropStyleArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DROPSTYLE$78, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getDropStyleArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPSTYLE$78, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getDropStyleList() {
        1DropStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DropStyleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getDxArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DX$108, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getDxArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DX$108, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getDxList() {
        1DxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getFirstButtonArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FIRSTBUTTON$92, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getFirstButtonArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FIRSTBUTTON$92, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getFirstButtonList() {
        1FirstButtonList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FirstButtonList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaGroupArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAGROUP$94, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaGroupArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAGROUP$94, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaGroupList() {
        1FmlaGroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaGroupList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaLinkArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLALINK$86, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaLinkArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLALINK$86, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaLinkList() {
        1FmlaLinkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaLinkList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaMacroArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAMACRO$20, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaMacroArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAMACRO$20, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaMacroList() {
        1FmlaMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaMacroList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaPictArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAPICT$88, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaPictArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAPICT$88, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaPictList() {
        1FmlaPictList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaPictList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaRangeArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLARANGE$62, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaRangeArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLARANGE$62, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaRangeList() {
        1FmlaRangeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaRangeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getFmlaTxbxArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLATXBX$132, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getFmlaTxbxArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLATXBX$132, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getFmlaTxbxList() {
        1FmlaTxbxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FmlaTxbxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getHelpArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(HELP$34, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getHelpArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HELP$34, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getHelpList() {
        1HelpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HelpList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getHorizArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(HORIZ$106, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getHorizArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HORIZ$106, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getHorizList() {
        1HorizList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HorizList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getIncArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(INC$102, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getIncArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INC$102, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getIncList() {
        1IncList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IncList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getJustLastXArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(JUSTLASTX$28, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getJustLastXArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(JUSTLASTX$28, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getJustLastXList() {
        1JustLastXList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1JustLastXList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getLCTArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LCT$74, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getLCTArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LCT$74, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getLCTList() {
        1LCTList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LCTList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getListItemArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LISTITEM$76, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getListItemArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LISTITEM$76, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getListItemList() {
        1ListItemList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ListItemList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getLockTextArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LOCKTEXT$26, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getLockTextArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCKTEXT$26, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getLockTextList() {
        1LockTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockTextList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getLockedArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LOCKED$6, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getLockedArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCKED$6, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getLockedList() {
        1LockedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LockedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getMapOCXArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MAPOCX$110, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getMapOCXArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAPOCX$110, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getMapOCXList() {
        1MapOCXList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MapOCXList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getMaxArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MAX$100, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getMaxArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAX$100, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getMaxList() {
        1MaxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MaxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getMinArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MIN$98, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getMinArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MIN$98, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getMinList() {
        1MinList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MinList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getMoveWithCellsArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MOVEWITHCELLS$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getMoveWithCellsArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEWITHCELLS$0, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getMoveWithCellsList() {
        1MoveWithCellsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveWithCellsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getMultiLineArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MULTILINE$56, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getMultiLineArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MULTILINE$56, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getMultiLineList() {
        1MultiLineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MultiLineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getMultiSelArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MULTISEL$72, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getMultiSelArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MULTISEL$72, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getMultiSelList() {
        1MultiSelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MultiSelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getNoThreeD2Array(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NOTHREED2$68, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getNoThreeD2Array() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOTHREED2$68, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getNoThreeD2List() {
        1NoThreeD2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NoThreeD2List(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getNoThreeDArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NOTHREED$90, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getNoThreeDArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOTHREED$90, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getNoThreeDList() {
        1NoThreeDList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NoThreeDList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STObjectType.Enum getObjectType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OBJECTTYPE$134);
            if (simpleValue == null) {
                return null;
            }
            return (STObjectType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getPageArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PAGE$104, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getPageArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAGE$104, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getPageList() {
        1PageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PageList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getPrintObjectArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PRINTOBJECT$10, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getPrintObjectArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PRINTOBJECT$10, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getPrintObjectList() {
        1PrintObjectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PrintObjectList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getRecalcAlwaysArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(RECALCALWAYS$116, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getRecalcAlwaysArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RECALCALWAYS$116, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getRecalcAlwaysList() {
        1RecalcAlwaysList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RecalcAlwaysList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getRowArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ROW$44, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getRowArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROW$44, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getRowHiddenArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ROWHIDDEN$50, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getRowHiddenArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROWHIDDEN$50, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getRowHiddenList() {
        1RowHiddenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RowHiddenList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getRowList() {
        1RowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RowList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getScriptExtendedArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTEXTENDED$126, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getScriptExtendedArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTEXTENDED$126, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getScriptExtendedList() {
        1ScriptExtendedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ScriptExtendedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getScriptLanguageArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTLANGUAGE$128, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getScriptLanguageArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTLANGUAGE$128, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getScriptLanguageList() {
        1ScriptLanguageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ScriptLanguageList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getScriptLocationArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTLOCATION$130, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getScriptLocationArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTLOCATION$130, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getScriptLocationList() {
        1ScriptLocationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ScriptLocationList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getScriptTextArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTTEXT$124, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getScriptTextArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTTEXT$124, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getScriptTextList() {
        1ScriptTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ScriptTextList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getSecretEditArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SECRETEDIT$30, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getSecretEditArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SECRETEDIT$30, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getSecretEditList() {
        1SecretEditList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SecretEditList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getSelArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SEL$66, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getSelArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEL$66, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getSelList() {
        1SelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getSelTypeArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SELTYPE$70, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getSelTypeArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SELTYPE$70, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getSelTypeList() {
        1SelTypeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SelTypeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getSizeWithCellsArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SIZEWITHCELLS$2, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getSizeWithCellsArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIZEWITHCELLS$2, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getSizeWithCellsList() {
        1SizeWithCellsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SizeWithCellsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getTextHAlignArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TEXTHALIGN$22, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getTextHAlignArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTHALIGN$22, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getTextHAlignList() {
        1TextHAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextHAlignList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String getTextVAlignArray(int i) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TEXTVALIGN$24, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public String[] getTextVAlignArray() {
        String[] strArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTVALIGN$24, arrayList);
            strArr = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                strArr[i] = ((SimpleValue) arrayList.get(i)).getStringValue();
            }
        }
        return strArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<String> getTextVAlignList() {
        1TextVAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextVAlignList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getUIObjArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UIOBJ$122, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getUIObjArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UIOBJ$122, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getUIObjList() {
        1UIObjList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1UIObjList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getVScrollArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VSCROLL$58, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getVScrollArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VSCROLL$58, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getVScrollList() {
        1VScrollList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VScrollList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getVTEditArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VTEDIT$54, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getVTEditArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VTEDIT$54, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getVTEditList() {
        1VTEditList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VTEditList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getValArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VAL$96, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getValArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VAL$96, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getValList() {
        1ValList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ValList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getValidIdsArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VALIDIDS$60, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getValidIdsArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VALIDIDS$60, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getValidIdsList() {
        1ValidIdsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ValidIdsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum getVisibleArray(int i) {
        STTrueFalseBlank.Enum r4;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VISIBLE$48, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            r4 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
        }
        return r4;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank.Enum[] getVisibleArray() {
        STTrueFalseBlank.Enum[] enumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VISIBLE$48, arrayList);
            enumArr = new STTrueFalseBlank.Enum[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                enumArr[i] = (STTrueFalseBlank.Enum) ((SimpleValue) arrayList.get(i)).getEnumValue();
            }
        }
        return enumArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank.Enum> getVisibleList() {
        1VisibleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VisibleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger getWidthMinArray(int i) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(WIDTHMIN$64, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public BigInteger[] getWidthMinArray() {
        BigInteger[] bigIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WIDTHMIN$64, arrayList);
            bigIntegerArr = new BigInteger[arrayList.size()];
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                bigIntegerArr[i] = ((SimpleValue) arrayList.get(i)).getBigIntegerValue();
            }
        }
        return bigIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<BigInteger> getWidthMinList() {
        1WidthMinList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1WidthMinList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAccel(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ACCEL$40, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAccel2(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ACCEL2$42, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAnchor(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ANCHOR$4, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAutoFill(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(AUTOFILL$14, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAutoLine(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(AUTOLINE$16, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAutoPict(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(AUTOPICT$18, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertAutoScale(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(AUTOSCALE$118, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertCF(int i, STCF$Enum sTCF$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CF$112, i)).setEnumValue(sTCF$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertCamera(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CAMERA$114, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertCancel(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CANCEL$36, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertChecked(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(CHECKED$84, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertColHidden(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(COLHIDDEN$52, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertColored(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(COLORED$80, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertColumn(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(COLUMN$46, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDDE(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DDE$120, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDefault(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DEFAULT$32, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDefaultSize(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DEFAULTSIZE$8, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDisabled(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DISABLED$12, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDismiss(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DISMISS$38, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDropLines(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DROPLINES$82, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDropStyle(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DROPSTYLE$78, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertDx(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(DX$108, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFirstButton(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FIRSTBUTTON$92, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaGroup(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLAGROUP$94, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaLink(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLALINK$86, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaMacro(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLAMACRO$20, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaPict(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLAPICT$88, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaRange(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLARANGE$62, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertFmlaTxbx(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(FMLATXBX$132, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertHelp(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(HELP$34, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertHoriz(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(HORIZ$106, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertInc(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(INC$102, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertJustLastX(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(JUSTLASTX$28, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertLCT(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LCT$74, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertListItem(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LISTITEM$76, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertLockText(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LOCKTEXT$26, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertLocked(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(LOCKED$6, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMapOCX(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MAPOCX$110, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMax(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MAX$100, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMin(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MIN$98, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMoveWithCells(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MOVEWITHCELLS$0, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMultiLine(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MULTILINE$56, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertMultiSel(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(MULTISEL$72, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewAccel(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(ACCEL$40, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewAccel2(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(ACCEL2$42, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewAnchor(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(ANCHOR$4, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewAutoFill(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(AUTOFILL$14, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewAutoLine(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(AUTOLINE$16, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewAutoPict(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(AUTOPICT$18, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewAutoScale(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(AUTOSCALE$118, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF insertNewCF(int i) {
        STCF insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CF$112, i);
        }
        return insert_element_user;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewCamera(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(CAMERA$114, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewCancel(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(CANCEL$36, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewChecked(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(CHECKED$84, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewColHidden(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(COLHIDDEN$52, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewColored(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(COLORED$80, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewColumn(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(COLUMN$46, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewDDE(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(DDE$120, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewDefault(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(DEFAULT$32, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewDefaultSize(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(DEFAULTSIZE$8, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewDisabled(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(DISABLED$12, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewDismiss(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(DISMISS$38, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewDropLines(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(DROPLINES$82, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewDropStyle(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(DROPSTYLE$78, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewDx(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(DX$108, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewFirstButton(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(FIRSTBUTTON$92, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaGroup(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLAGROUP$94, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaLink(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLALINK$86, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaMacro(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLAMACRO$20, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaPict(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLAPICT$88, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaRange(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLARANGE$62, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewFmlaTxbx(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(FMLATXBX$132, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewHelp(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(HELP$34, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewHoriz(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(HORIZ$106, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewInc(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(INC$102, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewJustLastX(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(JUSTLASTX$28, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewLCT(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(LCT$74, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewListItem(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(LISTITEM$76, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewLockText(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(LOCKTEXT$26, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewLocked(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(LOCKED$6, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewMapOCX(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(MAPOCX$110, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewMax(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(MAX$100, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewMin(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(MIN$98, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewMoveWithCells(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(MOVEWITHCELLS$0, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewMultiLine(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(MULTILINE$56, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewMultiSel(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(MULTISEL$72, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewNoThreeD(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(NOTHREED$90, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewNoThreeD2(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(NOTHREED2$68, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewPage(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PAGE$104, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewPrintObject(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PRINTOBJECT$10, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewRecalcAlways(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(RECALCALWAYS$116, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewRow(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(ROW$44, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewRowHidden(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(ROWHIDDEN$50, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewScriptExtended(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(SCRIPTEXTENDED$126, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger insertNewScriptLanguage(int i) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().insert_element_user(SCRIPTLANGUAGE$128, i);
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger insertNewScriptLocation(int i) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().insert_element_user(SCRIPTLOCATION$130, i);
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewScriptText(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(SCRIPTTEXT$124, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewSecretEdit(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(SECRETEDIT$30, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewSel(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(SEL$66, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewSelType(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(SELTYPE$70, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewSizeWithCells(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(SIZEWITHCELLS$2, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewTextHAlign(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(TEXTHALIGN$22, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString insertNewTextVAlign(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(TEXTVALIGN$24, i);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewUIObj(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(UIOBJ$122, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewVScroll(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(VSCROLL$58, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewVTEdit(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(VTEDIT$54, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewVal(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(VAL$96, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewValidIds(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(VALIDIDS$60, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank insertNewVisible(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(VISIBLE$48, i);
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger insertNewWidthMin(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(WIDTHMIN$64, i);
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertNoThreeD(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(NOTHREED$90, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertNoThreeD2(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(NOTHREED2$68, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertPage(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PAGE$104, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertPrintObject(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PRINTOBJECT$10, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertRecalcAlways(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(RECALCALWAYS$116, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertRow(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ROW$44, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertRowHidden(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(ROWHIDDEN$50, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertScriptExtended(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SCRIPTEXTENDED$126, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertScriptLanguage(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SCRIPTLANGUAGE$128, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertScriptLocation(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SCRIPTLOCATION$130, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertScriptText(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SCRIPTTEXT$124, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertSecretEdit(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SECRETEDIT$30, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertSel(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SEL$66, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertSelType(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SELTYPE$70, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertSizeWithCells(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(SIZEWITHCELLS$2, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertTextHAlign(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(TEXTHALIGN$22, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertTextVAlign(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(TEXTVALIGN$24, i)).setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertUIObj(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(UIOBJ$122, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertVScroll(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(VSCROLL$58, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertVTEdit(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(VTEDIT$54, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertVal(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(VAL$96, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertValidIds(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(VALIDIDS$60, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertVisible(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(VISIBLE$48, i)).setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void insertWidthMin(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(WIDTHMIN$64, i)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAccel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACCEL$40, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAccel2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACCEL2$42, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHOR$4, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAutoFill(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOFILL$14, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAutoLine(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOLINE$16, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAutoPict(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOPICT$18, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeAutoScale(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUTOSCALE$118, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeCF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CF$112, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeCamera(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CAMERA$114, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeCancel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CANCEL$36, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeChecked(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHECKED$84, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeColHidden(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLHIDDEN$52, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeColored(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLORED$80, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeColumn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLUMN$46, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDDE(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DDE$120, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDefault(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULT$32, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDefaultSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULTSIZE$8, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDisabled(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISABLED$12, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDismiss(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DISMISS$38, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDropLines(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DROPLINES$82, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDropStyle(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DROPSTYLE$78, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeDx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DX$108, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFirstButton(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTBUTTON$92, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaGroup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLAGROUP$94, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaLink(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLALINK$86, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaMacro(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLAMACRO$20, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaPict(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLAPICT$88, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaRange(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLARANGE$62, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeFmlaTxbx(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FMLATXBX$132, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeHelp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HELP$34, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeHoriz(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HORIZ$106, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeInc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INC$102, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeJustLastX(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JUSTLASTX$28, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeLCT(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LCT$74, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeListItem(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LISTITEM$76, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeLockText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCKTEXT$26, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeLocked(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LOCKED$6, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMapOCX(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAPOCX$110, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMax(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAX$100, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMin(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MIN$98, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMoveWithCells(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEWITHCELLS$0, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMultiLine(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MULTILINE$56, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeMultiSel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MULTISEL$72, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeNoThreeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTHREED$90, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeNoThreeD2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOTHREED2$68, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removePage(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGE$104, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removePrintObject(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRINTOBJECT$10, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeRecalcAlways(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RECALCALWAYS$116, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeRow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROW$44, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeRowHidden(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROWHIDDEN$50, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeScriptExtended(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRIPTEXTENDED$126, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeScriptLanguage(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRIPTLANGUAGE$128, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeScriptLocation(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRIPTLOCATION$130, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeScriptText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCRIPTTEXT$124, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeSecretEdit(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECRETEDIT$30, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeSel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEL$66, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeSelType(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SELTYPE$70, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeSizeWithCells(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZEWITHCELLS$2, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeTextHAlign(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTHALIGN$22, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeTextVAlign(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTVALIGN$24, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeUIObj(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UIOBJ$122, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeVScroll(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VSCROLL$58, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeVTEdit(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VTEDIT$54, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeVal(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VAL$96, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeValidIds(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VALIDIDS$60, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeVisible(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VISIBLE$48, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void removeWidthMin(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WIDTHMIN$64, i);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAccel2Array(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ACCEL2$42, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAccel2Array(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, ACCEL2$42);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAccelArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ACCEL$40, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAccelArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, ACCEL$40);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAnchorArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ANCHOR$4, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAnchorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, ANCHOR$4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoFillArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOFILL$14, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoFillArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, AUTOFILL$14);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoLineArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOLINE$16, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoLineArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, AUTOLINE$16);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoPictArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOPICT$18, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoPictArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, AUTOPICT$18);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoScaleArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(AUTOSCALE$118, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setAutoScaleArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, AUTOSCALE$118);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCFArray(int i, STCF$Enum sTCF$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CF$112, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(sTCF$Enum);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCFArray(STCF$Enum[] sTCF$EnumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTCF$EnumArr, CF$112);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCameraArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CAMERA$114, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCameraArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, CAMERA$114);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCancelArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CANCEL$36, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCancelArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, CANCEL$36);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCheckedArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(CHECKED$84, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setCheckedArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, CHECKED$84);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColHiddenArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLHIDDEN$52, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColHiddenArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, COLHIDDEN$52);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColoredArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLORED$80, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColoredArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, COLORED$80);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColumnArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(COLUMN$46, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setColumnArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, COLUMN$46);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDDEArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DDE$120, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDDEArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, DDE$120);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDefaultArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DEFAULT$32, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDefaultArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, DEFAULT$32);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDefaultSizeArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DEFAULTSIZE$8, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDefaultSizeArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, DEFAULTSIZE$8);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDisabledArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DISABLED$12, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDisabledArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, DISABLED$12);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDismissArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DISMISS$38, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDismissArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, DISMISS$38);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDropLinesArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DROPLINES$82, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDropLinesArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, DROPLINES$82);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDropStyleArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DROPSTYLE$78, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDropStyleArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, DROPSTYLE$78);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDxArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DX$108, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setDxArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, DX$108);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFirstButtonArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FIRSTBUTTON$92, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFirstButtonArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, FIRSTBUTTON$92);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaGroupArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAGROUP$94, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaGroupArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLAGROUP$94);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaLinkArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLALINK$86, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaLinkArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLALINK$86);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaMacroArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAMACRO$20, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaMacroArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLAMACRO$20);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaPictArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLAPICT$88, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaPictArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLAPICT$88);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaRangeArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLARANGE$62, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaRangeArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLARANGE$62);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaTxbxArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(FMLATXBX$132, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setFmlaTxbxArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, FMLATXBX$132);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setHelpArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(HELP$34, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setHelpArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, HELP$34);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setHorizArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(HORIZ$106, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setHorizArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, HORIZ$106);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setIncArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(INC$102, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setIncArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, INC$102);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setJustLastXArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(JUSTLASTX$28, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setJustLastXArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, JUSTLASTX$28);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLCTArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LCT$74, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLCTArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, LCT$74);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setListItemArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LISTITEM$76, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setListItemArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, LISTITEM$76);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLockTextArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LOCKTEXT$26, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLockTextArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, LOCKTEXT$26);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLockedArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(LOCKED$6, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setLockedArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, LOCKED$6);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMapOCXArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MAPOCX$110, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMapOCXArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, MAPOCX$110);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMaxArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MAX$100, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMaxArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, MAX$100);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMinArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MIN$98, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMinArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, MIN$98);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMoveWithCellsArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MOVEWITHCELLS$0, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMoveWithCellsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, MOVEWITHCELLS$0);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMultiLineArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MULTILINE$56, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMultiLineArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, MULTILINE$56);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMultiSelArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(MULTISEL$72, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setMultiSelArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, MULTISEL$72);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setNoThreeD2Array(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NOTHREED2$68, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setNoThreeD2Array(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, NOTHREED2$68);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setNoThreeDArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(NOTHREED$90, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setNoThreeDArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, NOTHREED$90);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setObjectType(STObjectType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBJECTTYPE$134;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setPageArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PAGE$104, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setPageArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PAGE$104);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setPrintObjectArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PRINTOBJECT$10, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setPrintObjectArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PRINTOBJECT$10);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRecalcAlwaysArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(RECALCALWAYS$116, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, RECALCALWAYS$116);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRowArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ROW$44, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRowArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, ROW$44);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRowHiddenArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(ROWHIDDEN$50, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setRowHiddenArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, ROWHIDDEN$50);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptExtendedArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTEXTENDED$126, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptExtendedArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, SCRIPTEXTENDED$126);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptLanguageArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTLANGUAGE$128, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptLanguageArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, SCRIPTLANGUAGE$128);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptLocationArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTLOCATION$130, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptLocationArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, SCRIPTLOCATION$130);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptTextArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SCRIPTTEXT$124, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setScriptTextArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, SCRIPTTEXT$124);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSecretEditArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SECRETEDIT$30, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSecretEditArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, SECRETEDIT$30);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSelArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SEL$66, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSelArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, SEL$66);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSelTypeArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SELTYPE$70, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSelTypeArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, SELTYPE$70);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSizeWithCellsArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(SIZEWITHCELLS$2, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setSizeWithCellsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, SIZEWITHCELLS$2);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setTextHAlignArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TEXTHALIGN$22, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setTextHAlignArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, TEXTHALIGN$22);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setTextVAlignArray(int i, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TEXTVALIGN$24, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setTextVAlignArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, TEXTVALIGN$24);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setUIObjArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(UIOBJ$122, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setUIObjArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, UIOBJ$122);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVScrollArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VSCROLL$58, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVScrollArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, VSCROLL$58);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVTEditArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VTEDIT$54, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVTEditArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, VTEDIT$54);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setValArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VAL$96, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setValArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, VAL$96);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setValidIdsArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VALIDIDS$60, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setValidIdsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, VALIDIDS$60);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVisibleArray(int i, STTrueFalseBlank.Enum r5) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(VISIBLE$48, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setEnumValue(r5);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setVisibleArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, VISIBLE$48);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setWidthMinArray(int i, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(WIDTHMIN$64, i);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void setWidthMinArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, WIDTHMIN$64);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAccel2Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ACCEL2$42);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAccelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ACCEL$40);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAnchorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ANCHOR$4);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAutoFillArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(AUTOFILL$14);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAutoLineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(AUTOLINE$16);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAutoPictArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(AUTOPICT$18);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfAutoScaleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(AUTOSCALE$118);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfCFArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CF$112);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfCameraArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CAMERA$114);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfCancelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CANCEL$36);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfCheckedArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CHECKED$84);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfColHiddenArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COLHIDDEN$52);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfColoredArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COLORED$80);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfColumnArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COLUMN$46);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDDEArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DDE$120);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDefaultArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEFAULT$32);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDefaultSizeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DEFAULTSIZE$8);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDisabledArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DISABLED$12);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDismissArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DISMISS$38);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDropLinesArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DROPLINES$82);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDropStyleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DROPSTYLE$78);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfDxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DX$108);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFirstButtonArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FIRSTBUTTON$92);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaGroupArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLAGROUP$94);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaLinkArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLALINK$86);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaMacroArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLAMACRO$20);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaPictArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLAPICT$88);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaRangeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLARANGE$62);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfFmlaTxbxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FMLATXBX$132);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfHelpArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HELP$34);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfHorizArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HORIZ$106);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfIncArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(INC$102);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfJustLastXArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(JUSTLASTX$28);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfLCTArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LCT$74);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfListItemArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LISTITEM$76);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfLockTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCKTEXT$26);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfLockedArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LOCKED$6);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMapOCXArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MAPOCX$110);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMaxArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MAX$100);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMinArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MIN$98);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMoveWithCellsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MOVEWITHCELLS$0);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMultiLineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MULTILINE$56);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfMultiSelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(MULTISEL$72);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfNoThreeD2Array() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NOTHREED2$68);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfNoThreeDArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NOTHREED$90);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfPageArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PAGE$104);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfPrintObjectArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(PRINTOBJECT$10);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfRecalcAlwaysArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RECALCALWAYS$116);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfRowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ROW$44);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfRowHiddenArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ROWHIDDEN$50);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfScriptExtendedArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCRIPTEXTENDED$126);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfScriptLanguageArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCRIPTLANGUAGE$128);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfScriptLocationArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCRIPTLOCATION$130);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfScriptTextArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCRIPTTEXT$124);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfSecretEditArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SECRETEDIT$30);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfSelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SEL$66);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfSelTypeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SELTYPE$70);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfSizeWithCellsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SIZEWITHCELLS$2);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfTextHAlignArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTHALIGN$22);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfTextVAlignArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TEXTVALIGN$24);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfUIObjArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(UIOBJ$122);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfVScrollArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VSCROLL$58);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfVTEditArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VTEDIT$54);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfValArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VAL$96);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfValidIdsArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VALIDIDS$60);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfVisibleArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VISIBLE$48);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public int sizeOfWidthMinArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(WIDTHMIN$64);
        }
        return count_elements;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetAccel2Array(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(ACCEL2$42, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetAccel2Array() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACCEL2$42, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetAccel2List() {
        2Accel2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2Accel2List(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetAccelArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(ACCEL$40, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetAccelArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACCEL$40, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetAccelList() {
        2AccelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AccelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetAnchorArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(ANCHOR$4, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetAnchorArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHOR$4, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetAnchorList() {
        2AnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AnchorList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetAutoFillArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(AUTOFILL$14, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetAutoFillArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOFILL$14, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetAutoFillList() {
        2AutoFillList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AutoFillList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetAutoLineArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(AUTOLINE$16, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetAutoLineArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOLINE$16, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetAutoLineList() {
        2AutoLineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AutoLineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetAutoPictArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(AUTOPICT$18, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetAutoPictArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOPICT$18, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetAutoPictList() {
        2AutoPictList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AutoPictList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetAutoScaleArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(AUTOSCALE$118, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetAutoScaleArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUTOSCALE$118, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetAutoScaleList() {
        2AutoScaleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2AutoScaleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF xgetCFArray(int i) {
        STCF find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CF$112, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STCF[] xgetCFArray() {
        STCF[] stcfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CF$112, arrayList);
            stcfArr = new STCF[arrayList.size()];
            arrayList.toArray(stcfArr);
        }
        return stcfArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STCF> xgetCFList() {
        2CFList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2CFList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetCameraArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(CAMERA$114, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetCameraArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CAMERA$114, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetCameraList() {
        2CameraList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2CameraList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetCancelArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(CANCEL$36, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetCancelArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CANCEL$36, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetCancelList() {
        2CancelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2CancelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetCheckedArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(CHECKED$84, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetCheckedArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHECKED$84, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetCheckedList() {
        2CheckedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2CheckedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetColHiddenArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(COLHIDDEN$52, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetColHiddenArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLHIDDEN$52, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetColHiddenList() {
        2ColHiddenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ColHiddenList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetColoredArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(COLORED$80, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetColoredArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLORED$80, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetColoredList() {
        2ColoredList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ColoredList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetColumnArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(COLUMN$46, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetColumnArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLUMN$46, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetColumnList() {
        2ColumnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ColumnList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetDDEArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(DDE$120, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetDDEArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DDE$120, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetDDEList() {
        2DDEList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DDEList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetDefaultArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(DEFAULT$32, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetDefaultArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEFAULT$32, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetDefaultList() {
        2DefaultList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DefaultList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetDefaultSizeArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(DEFAULTSIZE$8, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetDefaultSizeArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEFAULTSIZE$8, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetDefaultSizeList() {
        2DefaultSizeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DefaultSizeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetDisabledArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(DISABLED$12, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetDisabledArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DISABLED$12, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetDisabledList() {
        2DisabledList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DisabledList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetDismissArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(DISMISS$38, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetDismissArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DISMISS$38, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetDismissList() {
        2DismissList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DismissList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetDropLinesArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(DROPLINES$82, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetDropLinesArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPLINES$82, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetDropLinesList() {
        2DropLinesList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DropLinesList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetDropStyleArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(DROPSTYLE$78, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetDropStyleArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DROPSTYLE$78, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetDropStyleList() {
        2DropStyleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DropStyleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetDxArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(DX$108, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetDxArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DX$108, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetDxList() {
        2DxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2DxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetFirstButtonArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(FIRSTBUTTON$92, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetFirstButtonArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FIRSTBUTTON$92, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetFirstButtonList() {
        2FirstButtonList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FirstButtonList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaGroupArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLAGROUP$94, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaGroupArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAGROUP$94, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaGroupList() {
        2FmlaGroupList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaGroupList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaLinkArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLALINK$86, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaLinkArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLALINK$86, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaLinkList() {
        2FmlaLinkList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaLinkList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaMacroArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLAMACRO$20, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaMacroArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAMACRO$20, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaMacroList() {
        2FmlaMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaMacroList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaPictArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLAPICT$88, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaPictArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLAPICT$88, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaPictList() {
        2FmlaPictList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaPictList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaRangeArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLARANGE$62, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaRangeArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLARANGE$62, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaRangeList() {
        2FmlaRangeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaRangeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetFmlaTxbxArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(FMLATXBX$132, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetFmlaTxbxArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FMLATXBX$132, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetFmlaTxbxList() {
        2FmlaTxbxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2FmlaTxbxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetHelpArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(HELP$34, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetHelpArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HELP$34, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetHelpList() {
        2HelpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2HelpList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetHorizArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(HORIZ$106, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetHorizArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HORIZ$106, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetHorizList() {
        2HorizList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2HorizList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetIncArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(INC$102, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetIncArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INC$102, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetIncList() {
        2IncList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2IncList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetJustLastXArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(JUSTLASTX$28, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetJustLastXArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(JUSTLASTX$28, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetJustLastXList() {
        2JustLastXList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2JustLastXList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetLCTArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LCT$74, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetLCTArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LCT$74, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetLCTList() {
        2LCTList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2LCTList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetListItemArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(LISTITEM$76, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetListItemArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LISTITEM$76, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetListItemList() {
        2ListItemList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ListItemList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetLockTextArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(LOCKTEXT$26, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetLockTextArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCKTEXT$26, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetLockTextList() {
        2LockTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2LockTextList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetLockedArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(LOCKED$6, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetLockedArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LOCKED$6, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetLockedList() {
        2LockedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2LockedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetMapOCXArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(MAPOCX$110, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetMapOCXArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAPOCX$110, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetMapOCXList() {
        2MapOCXList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MapOCXList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetMaxArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(MAX$100, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetMaxArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MAX$100, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetMaxList() {
        2MaxList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MaxList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetMinArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(MIN$98, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetMinArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MIN$98, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetMinList() {
        2MinList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MinList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetMoveWithCellsArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(MOVEWITHCELLS$0, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetMoveWithCellsArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEWITHCELLS$0, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetMoveWithCellsList() {
        2MoveWithCellsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MoveWithCellsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetMultiLineArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(MULTILINE$56, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetMultiLineArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MULTILINE$56, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetMultiLineList() {
        2MultiLineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MultiLineList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetMultiSelArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(MULTISEL$72, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetMultiSelArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MULTISEL$72, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetMultiSelList() {
        2MultiSelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2MultiSelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetNoThreeD2Array(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(NOTHREED2$68, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetNoThreeD2Array() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOTHREED2$68, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetNoThreeD2List() {
        2NoThreeD2List r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2NoThreeD2List(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetNoThreeDArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(NOTHREED$90, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetNoThreeDArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NOTHREED$90, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetNoThreeDList() {
        2NoThreeDList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2NoThreeDList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STObjectType xgetObjectType() {
        STObjectType sTObjectType;
        synchronized (monitor()) {
            check_orphaned();
            sTObjectType = (STObjectType) get_store().find_attribute_user(OBJECTTYPE$134);
        }
        return sTObjectType;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetPageArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(PAGE$104, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetPageArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAGE$104, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetPageList() {
        2PageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2PageList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetPrintObjectArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PRINTOBJECT$10, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetPrintObjectArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PRINTOBJECT$10, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetPrintObjectList() {
        2PrintObjectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2PrintObjectList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetRecalcAlwaysArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(RECALCALWAYS$116, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetRecalcAlwaysArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RECALCALWAYS$116, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetRecalcAlwaysList() {
        2RecalcAlwaysList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2RecalcAlwaysList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetRowArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(ROW$44, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetRowArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROW$44, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetRowHiddenArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(ROWHIDDEN$50, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetRowHiddenArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ROWHIDDEN$50, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetRowHiddenList() {
        2RowHiddenList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2RowHiddenList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetRowList() {
        2RowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2RowList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetScriptExtendedArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(SCRIPTEXTENDED$126, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetScriptExtendedArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTEXTENDED$126, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetScriptExtendedList() {
        2ScriptExtendedList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ScriptExtendedList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger xgetScriptLanguageArray(int i) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().find_element_user(SCRIPTLANGUAGE$128, i);
            if (xmlNonNegativeInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger[] xgetScriptLanguageArray() {
        XmlNonNegativeInteger[] xmlNonNegativeIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTLANGUAGE$128, arrayList);
            xmlNonNegativeIntegerArr = new XmlNonNegativeInteger[arrayList.size()];
            arrayList.toArray(xmlNonNegativeIntegerArr);
        }
        return xmlNonNegativeIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlNonNegativeInteger> xgetScriptLanguageList() {
        2ScriptLanguageList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ScriptLanguageList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger xgetScriptLocationArray(int i) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().find_element_user(SCRIPTLOCATION$130, i);
            if (xmlNonNegativeInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlNonNegativeInteger[] xgetScriptLocationArray() {
        XmlNonNegativeInteger[] xmlNonNegativeIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTLOCATION$130, arrayList);
            xmlNonNegativeIntegerArr = new XmlNonNegativeInteger[arrayList.size()];
            arrayList.toArray(xmlNonNegativeIntegerArr);
        }
        return xmlNonNegativeIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlNonNegativeInteger> xgetScriptLocationList() {
        2ScriptLocationList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ScriptLocationList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetScriptTextArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(SCRIPTTEXT$124, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetScriptTextArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCRIPTTEXT$124, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetScriptTextList() {
        2ScriptTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ScriptTextList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetSecretEditArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(SECRETEDIT$30, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetSecretEditArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SECRETEDIT$30, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetSecretEditList() {
        2SecretEditList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2SecretEditList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetSelArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(SEL$66, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetSelArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEL$66, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetSelList() {
        2SelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2SelList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetSelTypeArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(SELTYPE$70, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetSelTypeArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SELTYPE$70, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetSelTypeList() {
        2SelTypeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2SelTypeList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetSizeWithCellsArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(SIZEWITHCELLS$2, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetSizeWithCellsArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SIZEWITHCELLS$2, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetSizeWithCellsList() {
        2SizeWithCellsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2SizeWithCellsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetTextHAlignArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(TEXTHALIGN$22, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetTextHAlignArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTHALIGN$22, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetTextHAlignList() {
        2TextHAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2TextHAlignList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString xgetTextVAlignArray(int i) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(TEXTVALIGN$24, i);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlString[] xgetTextVAlignArray() {
        XmlString[] xmlStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTVALIGN$24, arrayList);
            xmlStringArr = new XmlString[arrayList.size()];
            arrayList.toArray(xmlStringArr);
        }
        return xmlStringArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlString> xgetTextVAlignList() {
        2TextVAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2TextVAlignList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetUIObjArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(UIOBJ$122, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetUIObjArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(UIOBJ$122, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetUIObjList() {
        2UIObjList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2UIObjList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetVScrollArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(VSCROLL$58, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetVScrollArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VSCROLL$58, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetVScrollList() {
        2VScrollList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2VScrollList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetVTEditArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(VTEDIT$54, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetVTEditArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VTEDIT$54, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetVTEditList() {
        2VTEditList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2VTEditList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetValArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(VAL$96, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetValArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VAL$96, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetValList() {
        2ValList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ValList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetValidIdsArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(VALIDIDS$60, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetValidIdsArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VALIDIDS$60, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetValidIdsList() {
        2ValidIdsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2ValidIdsList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank xgetVisibleArray(int i) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(VISIBLE$48, i);
            if (sTTrueFalseBlank == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public STTrueFalseBlank[] xgetVisibleArray() {
        STTrueFalseBlank[] sTTrueFalseBlankArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VISIBLE$48, arrayList);
            sTTrueFalseBlankArr = new STTrueFalseBlank[arrayList.size()];
            arrayList.toArray(sTTrueFalseBlankArr);
        }
        return sTTrueFalseBlankArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<STTrueFalseBlank> xgetVisibleList() {
        2VisibleList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2VisibleList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger xgetWidthMinArray(int i) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_element_user(WIDTHMIN$64, i);
            if (xmlInteger == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInteger;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public XmlInteger[] xgetWidthMinArray() {
        XmlInteger[] xmlIntegerArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(WIDTHMIN$64, arrayList);
            xmlIntegerArr = new XmlInteger[arrayList.size()];
            arrayList.toArray(xmlIntegerArr);
        }
        return xmlIntegerArr;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public List<XmlInteger> xgetWidthMinList() {
        2WidthMinList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 2WidthMinList(this);
        }
        return r1;
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAccel2Array(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(ACCEL2$42, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAccel2Array(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, ACCEL2$42);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAccelArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(ACCEL$40, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAccelArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, ACCEL$40);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAnchorArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(ANCHOR$4, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAnchorArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, ANCHOR$4);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoFillArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(AUTOFILL$14, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoFillArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, AUTOFILL$14);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoLineArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(AUTOLINE$16, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, AUTOLINE$16);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoPictArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(AUTOPICT$18, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoPictArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, AUTOPICT$18);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoScaleArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(AUTOSCALE$118, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetAutoScaleArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, AUTOSCALE$118);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCFArray(int i, STCF stcf) {
        synchronized (monitor()) {
            check_orphaned();
            STCF find_element_user = get_store().find_element_user(CF$112, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(stcf);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCFArray(STCF[] stcfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) stcfArr, CF$112);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCameraArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(CAMERA$114, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCameraArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, CAMERA$114);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCancelArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(CANCEL$36, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCancelArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, CANCEL$36);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCheckedArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(CHECKED$84, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetCheckedArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, CHECKED$84);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColHiddenArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(COLHIDDEN$52, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, COLHIDDEN$52);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColoredArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(COLORED$80, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColoredArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, COLORED$80);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColumnArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(COLUMN$46, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetColumnArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, COLUMN$46);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDDEArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(DDE$120, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDDEArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, DDE$120);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDefaultArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(DEFAULT$32, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDefaultArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, DEFAULT$32);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDefaultSizeArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(DEFAULTSIZE$8, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDefaultSizeArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, DEFAULTSIZE$8);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDisabledArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(DISABLED$12, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDisabledArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, DISABLED$12);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDismissArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(DISMISS$38, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDismissArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, DISMISS$38);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDropLinesArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(DROPLINES$82, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDropLinesArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, DROPLINES$82);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDropStyleArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(DROPSTYLE$78, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDropStyleArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, DROPSTYLE$78);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDxArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(DX$108, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetDxArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, DX$108);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFirstButtonArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(FIRSTBUTTON$92, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFirstButtonArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, FIRSTBUTTON$92);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaGroupArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLAGROUP$94, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaGroupArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLAGROUP$94);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaLinkArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLALINK$86, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaLinkArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLALINK$86);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaMacroArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLAMACRO$20, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaMacroArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLAMACRO$20);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaPictArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLAPICT$88, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaPictArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLAPICT$88);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaRangeArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLARANGE$62, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaRangeArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLARANGE$62);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaTxbxArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(FMLATXBX$132, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetFmlaTxbxArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, FMLATXBX$132);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetHelpArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(HELP$34, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetHelpArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, HELP$34);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetHorizArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(HORIZ$106, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetHorizArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, HORIZ$106);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetIncArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(INC$102, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetIncArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, INC$102);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetJustLastXArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(JUSTLASTX$28, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetJustLastXArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, JUSTLASTX$28);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLCTArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(LCT$74, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLCTArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, LCT$74);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetListItemArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(LISTITEM$76, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetListItemArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, LISTITEM$76);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLockTextArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(LOCKTEXT$26, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLockTextArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, LOCKTEXT$26);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLockedArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(LOCKED$6, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetLockedArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, LOCKED$6);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMapOCXArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(MAPOCX$110, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMapOCXArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, MAPOCX$110);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMaxArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(MAX$100, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMaxArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, MAX$100);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMinArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(MIN$98, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMinArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, MIN$98);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMoveWithCellsArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(MOVEWITHCELLS$0, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMoveWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, MOVEWITHCELLS$0);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMultiLineArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(MULTILINE$56, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMultiLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, MULTILINE$56);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMultiSelArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(MULTISEL$72, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetMultiSelArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, MULTISEL$72);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetNoThreeD2Array(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(NOTHREED2$68, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetNoThreeD2Array(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, NOTHREED2$68);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetNoThreeDArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(NOTHREED$90, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetNoThreeDArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, NOTHREED$90);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetObjectType(STObjectType sTObjectType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OBJECTTYPE$134;
            STObjectType sTObjectType2 = (STObjectType) typeStore.find_attribute_user(qName);
            if (sTObjectType2 == null) {
                sTObjectType2 = (STObjectType) get_store().add_attribute_user(qName);
            }
            sTObjectType2.set(sTObjectType);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetPageArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PAGE$104, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetPageArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PAGE$104);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetPrintObjectArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PRINTOBJECT$10, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetPrintObjectArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PRINTOBJECT$10);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRecalcAlwaysArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(RECALCALWAYS$116, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRecalcAlwaysArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, RECALCALWAYS$116);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRowArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(ROW$44, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRowArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, ROW$44);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRowHiddenArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(ROWHIDDEN$50, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetRowHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, ROWHIDDEN$50);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptExtendedArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(SCRIPTEXTENDED$126, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptExtendedArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, SCRIPTEXTENDED$126);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptLanguageArray(int i, XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().find_element_user(SCRIPTLANGUAGE$128, i);
            if (xmlNonNegativeInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptLanguageArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlNonNegativeIntegerArr, SCRIPTLANGUAGE$128);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptLocationArray(int i, XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().find_element_user(SCRIPTLOCATION$130, i);
            if (xmlNonNegativeInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptLocationArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlNonNegativeIntegerArr, SCRIPTLOCATION$130);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptTextArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(SCRIPTTEXT$124, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetScriptTextArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, SCRIPTTEXT$124);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSecretEditArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(SECRETEDIT$30, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSecretEditArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, SECRETEDIT$30);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSelArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(SEL$66, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSelArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, SEL$66);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSelTypeArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(SELTYPE$70, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSelTypeArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, SELTYPE$70);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSizeWithCellsArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(SIZEWITHCELLS$2, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetSizeWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, SIZEWITHCELLS$2);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetTextHAlignArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(TEXTHALIGN$22, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetTextHAlignArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, TEXTHALIGN$22);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetTextVAlignArray(int i, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(TEXTVALIGN$24, i);
            if (xmlString2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetTextVAlignArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, TEXTVALIGN$24);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetUIObjArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(UIOBJ$122, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetUIObjArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, UIOBJ$122);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVScrollArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(VSCROLL$58, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVScrollArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, VSCROLL$58);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVTEditArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(VTEDIT$54, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVTEditArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, VTEDIT$54);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetValArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(VAL$96, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetValArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, VAL$96);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetValidIdsArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(VALIDIDS$60, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetValidIdsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, VALIDIDS$60);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVisibleArray(int i, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            check_orphaned();
            STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(VISIBLE$48, i);
            if (sTTrueFalseBlank2 == null) {
                throw new IndexOutOfBoundsException();
            }
            sTTrueFalseBlank2.set(sTTrueFalseBlank);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetVisibleArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, VISIBLE$48);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetWidthMinArray(int i, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(WIDTHMIN$64, i);
            if (xmlInteger2 == null) {
                throw new IndexOutOfBoundsException();
            }
            xmlInteger2.set(xmlInteger);
        }
    }

    @Override // schemasMicrosoftComOfficeExcel.CTClientData
    public void xsetWidthMinArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, WIDTHMIN$64);
        }
    }
}
