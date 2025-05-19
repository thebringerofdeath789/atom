package schemasMicrosoftComVml.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigDecimal;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import schemasMicrosoftComOfficeOffice.CTStrokeChild;
import schemasMicrosoftComOfficeOffice.STTrueFalse$Enum;
import schemasMicrosoftComVml.CTStroke;
import schemasMicrosoftComVml.STColorType;
import schemasMicrosoftComVml.STFillType;
import schemasMicrosoftComVml.STFillType$Enum;
import schemasMicrosoftComVml.STImageAspect;
import schemasMicrosoftComVml.STImageAspect$Enum;
import schemasMicrosoftComVml.STStrokeArrowLength;
import schemasMicrosoftComVml.STStrokeArrowLength$Enum;
import schemasMicrosoftComVml.STStrokeArrowType;
import schemasMicrosoftComVml.STStrokeArrowType$Enum;
import schemasMicrosoftComVml.STStrokeArrowWidth;
import schemasMicrosoftComVml.STStrokeArrowWidth$Enum;
import schemasMicrosoftComVml.STStrokeEndCap;
import schemasMicrosoftComVml.STStrokeEndCap$Enum;
import schemasMicrosoftComVml.STStrokeJoinStyle;
import schemasMicrosoftComVml.STStrokeLineStyle;
import schemasMicrosoftComVml.STStrokeLineStyle$Enum;
import schemasMicrosoftComVml.STTrueFalse;

/* loaded from: classes6.dex */
public class CTStrokeImpl extends XmlComplexContentImpl implements CTStroke {
    private static final QName LEFT$0 = new QName("urn:schemas-microsoft-com:office:office", "left");
    private static final QName TOP$2 = new QName("urn:schemas-microsoft-com:office:office", "top");
    private static final QName RIGHT$4 = new QName("urn:schemas-microsoft-com:office:office", "right");
    private static final QName BOTTOM$6 = new QName("urn:schemas-microsoft-com:office:office", "bottom");
    private static final QName COLUMN$8 = new QName("urn:schemas-microsoft-com:office:office", JamXmlElements.COLUMN);
    private static final QName ID$10 = new QName("", TtmlNode.ATTR_ID);
    private static final QName ON$12 = new QName("", "on");
    private static final QName WEIGHT$14 = new QName("", "weight");
    private static final QName COLOR$16 = new QName("", TtmlNode.ATTR_TTS_COLOR);
    private static final QName OPACITY$18 = new QName("", "opacity");
    private static final QName LINESTYLE$20 = new QName("", "linestyle");
    private static final QName MITERLIMIT$22 = new QName("", "miterlimit");
    private static final QName JOINSTYLE$24 = new QName("", "joinstyle");
    private static final QName ENDCAP$26 = new QName("", "endcap");
    private static final QName DASHSTYLE$28 = new QName("", "dashstyle");
    private static final QName FILLTYPE$30 = new QName("", "filltype");
    private static final QName SRC$32 = new QName("", "src");
    private static final QName IMAGEASPECT$34 = new QName("", "imageaspect");
    private static final QName IMAGESIZE$36 = new QName("", "imagesize");
    private static final QName IMAGEALIGNSHAPE$38 = new QName("", "imagealignshape");
    private static final QName COLOR2$40 = new QName("", "color2");
    private static final QName STARTARROW$42 = new QName("", "startarrow");
    private static final QName STARTARROWWIDTH$44 = new QName("", "startarrowwidth");
    private static final QName STARTARROWLENGTH$46 = new QName("", "startarrowlength");
    private static final QName ENDARROW$48 = new QName("", "endarrow");
    private static final QName ENDARROWWIDTH$50 = new QName("", "endarrowwidth");
    private static final QName ENDARROWLENGTH$52 = new QName("", "endarrowlength");
    private static final QName HREF$54 = new QName("urn:schemas-microsoft-com:office:office", "href");
    private static final QName ALTHREF$56 = new QName("urn:schemas-microsoft-com:office:office", "althref");
    private static final QName TITLE$58 = new QName("urn:schemas-microsoft-com:office:office", "title");
    private static final QName FORCEDASH$60 = new QName("urn:schemas-microsoft-com:office:office", "forcedash");
    private static final QName ID2$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", TtmlNode.ATTR_ID);
    private static final QName INSETPEN$64 = new QName("", "insetpen");
    private static final QName RELID$66 = new QName("urn:schemas-microsoft-com:office:office", "relid");

    public CTStrokeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild addNewBottom() {
        CTStrokeChild add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BOTTOM$6);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild addNewColumn() {
        CTStrokeChild add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(COLUMN$8);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild addNewLeft() {
        CTStrokeChild add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LEFT$0);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild addNewRight() {
        CTStrokeChild add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(RIGHT$4);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild addNewTop() {
        CTStrokeChild add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TOP$2);
        }
        return add_element_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALTHREF$56);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild getBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrokeChild find_element_user = get_store().find_element_user(BOTTOM$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR$16);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getColor2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR2$40);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild getColumn() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrokeChild find_element_user = get_store().find_element_user(COLUMN$8, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getDashstyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DASHSTYLE$28);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowType$Enum getEndarrow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENDARROW$48);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowLength$Enum getEndarrowlength() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENDARROWLENGTH$52);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowLength$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowWidth$Enum getEndarrowwidth() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENDARROWWIDTH$50);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowWidth$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeEndCap$Enum getEndcap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENDCAP$26);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeEndCap$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STFillType$Enum getFilltype() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLTYPE$30);
            if (simpleValue == null) {
                return null;
            }
            return (STFillType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse$Enum getForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FORCEDASH$60);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getId2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID2$62);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse.Enum getImagealignshape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STImageAspect$Enum getImageaspect() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(IMAGEASPECT$34);
            if (simpleValue == null) {
                return null;
            }
            return (STImageAspect$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getImagesize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(IMAGESIZE$36);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse.Enum getInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSETPEN$64);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeJoinStyle.Enum getJoinstyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(JOINSTYLE$24);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeJoinStyle.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrokeChild find_element_user = get_store().find_element_user(LEFT$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeLineStyle$Enum getLinestyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LINESTYLE$20);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeLineStyle$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public BigDecimal getMiterlimit() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MITERLIMIT$22);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigDecimalValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ON$12);
            if (simpleValue == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY$18);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getRelid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RELID$66);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild getRight() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrokeChild find_element_user = get_store().find_element_user(RIGHT$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getSrc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SRC$32);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowType$Enum getStartarrow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STARTARROW$42);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowLength$Enum getStartarrowlength() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STARTARROWLENGTH$46);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowLength$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowWidth$Enum getStartarrowwidth() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STARTARROWWIDTH$44);
            if (simpleValue == null) {
                return null;
            }
            return (STStrokeArrowWidth$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public CTStrokeChild getTop() {
        synchronized (monitor()) {
            check_orphaned();
            CTStrokeChild find_element_user = get_store().find_element_user(TOP$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public String getWeight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(WEIGHT$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetAlthref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALTHREF$56) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$6) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$16) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetColor2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR2$40) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetColumn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLUMN$8) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetDashstyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DASHSTYLE$28) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetEndarrow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENDARROW$48) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetEndarrowlength() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENDARROWLENGTH$52) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetEndarrowwidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENDARROWWIDTH$50) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetEndcap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENDCAP$26) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetFilltype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLTYPE$30) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetForcedash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEDASH$60) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$54) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$10) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetId2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID2$62) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetImagealignshape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IMAGEALIGNSHAPE$38) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetImageaspect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IMAGEASPECT$34) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetImagesize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IMAGESIZE$36) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetInsetpen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPEN$64) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetJoinstyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(JOINSTYLE$24) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$0) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetLinestyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINESTYLE$20) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetMiterlimit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MITERLIMIT$22) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$12) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$18) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetRelid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RELID$66) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$4) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetSrc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SRC$32) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetStartarrow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STARTARROW$42) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetStartarrowlength() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STARTARROWLENGTH$46) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetStartarrowwidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STARTARROWWIDTH$44) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$58) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$2) != 0;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public boolean isSetWeight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WEIGHT$14) != null;
        }
        return z;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setAlthref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$56;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setBottom(CTStrokeChild cTStrokeChild) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BOTTOM$6;
            CTStrokeChild find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTStrokeChild) get_store().add_element_user(qName);
            }
            find_element_user.set(cTStrokeChild);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setColor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setColor2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$40;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setColumn(CTStrokeChild cTStrokeChild) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLUMN$8;
            CTStrokeChild find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTStrokeChild) get_store().add_element_user(qName);
            }
            find_element_user.set(cTStrokeChild);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setDashstyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DASHSTYLE$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setEndarrow(STStrokeArrowType$Enum sTStrokeArrowType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROW$48;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setEndarrowlength(STStrokeArrowLength$Enum sTStrokeArrowLength$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROWLENGTH$52;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowLength$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setEndarrowwidth(STStrokeArrowWidth$Enum sTStrokeArrowWidth$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROWWIDTH$50;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowWidth$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setEndcap(STStrokeEndCap$Enum sTStrokeEndCap$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDCAP$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeEndCap$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setFilltype(STFillType$Enum sTFillType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLTYPE$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTFillType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setForcedash(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$60;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setId2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$62;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setImagealignshape(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGEALIGNSHAPE$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setImageaspect(STImageAspect$Enum sTImageAspect$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGEASPECT$34;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTImageAspect$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setImagesize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGESIZE$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setInsetpen(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$64;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setJoinstyle(STStrokeJoinStyle.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JOINSTYLE$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setLeft(CTStrokeChild cTStrokeChild) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            CTStrokeChild find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTStrokeChild) get_store().add_element_user(qName);
            }
            find_element_user.set(cTStrokeChild);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setLinestyle(STStrokeLineStyle$Enum sTStrokeLineStyle$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINESTYLE$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeLineStyle$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setMiterlimit(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MITERLIMIT$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setRelid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$66;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setRight(CTStrokeChild cTStrokeChild) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$4;
            CTStrokeChild find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTStrokeChild) get_store().add_element_user(qName);
            }
            find_element_user.set(cTStrokeChild);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setSrc(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$32;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setStartarrow(STStrokeArrowType$Enum sTStrokeArrowType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROW$42;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowType$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setStartarrowlength(STStrokeArrowLength$Enum sTStrokeArrowLength$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROWLENGTH$46;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowLength$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setStartarrowwidth(STStrokeArrowWidth$Enum sTStrokeArrowWidth$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROWWIDTH$44;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTStrokeArrowWidth$Enum);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public void setTop(CTStrokeChild cTStrokeChild) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOP$2;
            CTStrokeChild find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTStrokeChild) get_store().add_element_user(qName);
            }
            find_element_user.set(cTStrokeChild);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void setWeight(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEIGHT$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALTHREF$56);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$6, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$16);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetColor2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR2$40);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetColumn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLUMN$8, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetDashstyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DASHSTYLE$28);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetEndarrow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENDARROW$48);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetEndarrowlength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENDARROWLENGTH$52);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetEndarrowwidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENDARROWWIDTH$50);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetEndcap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENDCAP$26);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetFilltype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLTYPE$30);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetForcedash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEDASH$60);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$54);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$10);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetId2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID2$62);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetImagealignshape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IMAGEALIGNSHAPE$38);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetImageaspect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IMAGEASPECT$34);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetImagesize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IMAGESIZE$36);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetInsetpen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPEN$64);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetJoinstyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(JOINSTYLE$24);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$0, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetLinestyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINESTYLE$20);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetMiterlimit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MITERLIMIT$22);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$12);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$18);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetRelid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RELID$66);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$4, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetSrc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SRC$32);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetStartarrow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STARTARROW$42);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetStartarrowlength() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STARTARROWLENGTH$46);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetStartarrowwidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STARTARROWWIDTH$44);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$58);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$2, 0);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void unsetWeight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WEIGHT$14);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetAlthref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ALTHREF$56);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STColorType xgetColor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(COLOR$16);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STColorType xgetColor2() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(COLOR2$40);
        }
        return sTColorType;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetDashstyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(DASHSTYLE$28);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowType xgetEndarrow() {
        STStrokeArrowType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ENDARROW$48);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowLength xgetEndarrowlength() {
        STStrokeArrowLength find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ENDARROWLENGTH$52);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowWidth xgetEndarrowwidth() {
        STStrokeArrowWidth find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ENDARROWWIDTH$50);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeEndCap xgetEndcap() {
        STStrokeEndCap find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ENDCAP$26);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STFillType xgetFilltype() {
        STFillType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(FILLTYPE$30);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public schemasMicrosoftComOfficeOffice.STTrueFalse xgetForcedash() {
        schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(FORCEDASH$60);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(HREF$54);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$10);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STRelationshipId xgetId2() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID2$62);
        }
        return sTRelationshipId;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse xgetImagealignshape() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(IMAGEALIGNSHAPE$38);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STImageAspect xgetImageaspect() {
        STImageAspect find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(IMAGEASPECT$34);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetImagesize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(IMAGESIZE$36);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse xgetInsetpen() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(INSETPEN$64);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeJoinStyle xgetJoinstyle() {
        STStrokeJoinStyle sTStrokeJoinStyle;
        synchronized (monitor()) {
            check_orphaned();
            sTStrokeJoinStyle = (STStrokeJoinStyle) get_store().find_attribute_user(JOINSTYLE$24);
        }
        return sTStrokeJoinStyle;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeLineStyle xgetLinestyle() {
        STStrokeLineStyle find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(LINESTYLE$20);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlDecimal xgetMiterlimit() {
        XmlDecimal xmlDecimal;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimal = (XmlDecimal) get_store().find_attribute_user(MITERLIMIT$22);
        }
        return xmlDecimal;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ON$12);
        }
        return sTTrueFalse;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetOpacity() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY$18);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public schemasMicrosoftComOfficeOffice.STRelationshipId xgetRelid() {
        schemasMicrosoftComOfficeOffice.STRelationshipId find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(RELID$66);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetSrc() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(SRC$32);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowType xgetStartarrow() {
        STStrokeArrowType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(STARTARROW$42);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowLength xgetStartarrowlength() {
        STStrokeArrowLength find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(STARTARROWLENGTH$46);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public STStrokeArrowWidth xgetStartarrowwidth() {
        STStrokeArrowWidth find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(STARTARROWWIDTH$44);
        }
        return find_attribute_user;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TITLE$58);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public XmlString xgetWeight() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(WEIGHT$14);
        }
        return xmlString;
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetAlthref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$56;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetColor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$16;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetColor2(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$40;
            STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qName);
            if (sTColorType2 == null) {
                sTColorType2 = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorType2.set(sTColorType);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetDashstyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DASHSTYLE$28;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetEndarrow(STStrokeArrowType sTStrokeArrowType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROW$48;
            STStrokeArrowType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowType);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetEndarrowlength(STStrokeArrowLength sTStrokeArrowLength) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROWLENGTH$52;
            STStrokeArrowLength find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowLength) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowLength);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetEndarrowwidth(STStrokeArrowWidth sTStrokeArrowWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDARROWWIDTH$50;
            STStrokeArrowWidth find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowWidth) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowWidth);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetEndcap(STStrokeEndCap sTStrokeEndCap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENDCAP$26;
            STStrokeEndCap find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeEndCap) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeEndCap);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetFilltype(STFillType sTFillType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLTYPE$30;
            STFillType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STFillType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTFillType);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetForcedash(schemasMicrosoftComOfficeOffice.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEDASH$60;
            schemasMicrosoftComOfficeOffice.STTrueFalse find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STTrueFalse) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetId2(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$62;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetImagealignshape(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGEALIGNSHAPE$38;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetImageaspect(STImageAspect sTImageAspect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGEASPECT$34;
            STImageAspect find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STImageAspect) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTImageAspect);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetImagesize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IMAGESIZE$36;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetInsetpen(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INSETPEN$64;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetJoinstyle(STStrokeJoinStyle sTStrokeJoinStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JOINSTYLE$24;
            STStrokeJoinStyle sTStrokeJoinStyle2 = (STStrokeJoinStyle) typeStore.find_attribute_user(qName);
            if (sTStrokeJoinStyle2 == null) {
                sTStrokeJoinStyle2 = (STStrokeJoinStyle) get_store().add_attribute_user(qName);
            }
            sTStrokeJoinStyle2.set(sTStrokeJoinStyle);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetLinestyle(STStrokeLineStyle sTStrokeLineStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINESTYLE$20;
            STStrokeLineStyle find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeLineStyle) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeLineStyle);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetMiterlimit(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MITERLIMIT$22;
            XmlDecimal xmlDecimal2 = (XmlDecimal) typeStore.find_attribute_user(qName);
            if (xmlDecimal2 == null) {
                xmlDecimal2 = (XmlDecimal) get_store().add_attribute_user(qName);
            }
            xmlDecimal2.set(xmlDecimal);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$12;
            STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
            if (sTTrueFalse2 == null) {
                sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalse2.set(sTTrueFalse);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$18;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetRelid(schemasMicrosoftComOfficeOffice.STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$66;
            schemasMicrosoftComOfficeOffice.STRelationshipId find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (schemasMicrosoftComOfficeOffice.STRelationshipId) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTRelationshipId);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetSrc(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$32;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetStartarrow(STStrokeArrowType sTStrokeArrowType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROW$42;
            STStrokeArrowType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowType);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetStartarrowlength(STStrokeArrowLength sTStrokeArrowLength) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROWLENGTH$46;
            STStrokeArrowLength find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowLength) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowLength);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetStartarrowwidth(STStrokeArrowWidth sTStrokeArrowWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STARTARROWWIDTH$44;
            STStrokeArrowWidth find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STStrokeArrowWidth) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTStrokeArrowWidth);
        }
    }

    @Override // schemasMicrosoftComVml.CTStroke
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

    @Override // schemasMicrosoftComVml.CTStroke
    public void xsetWeight(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WEIGHT$14;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
