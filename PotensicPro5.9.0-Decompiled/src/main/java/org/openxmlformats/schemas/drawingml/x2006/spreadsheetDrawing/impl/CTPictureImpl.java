package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPictureNonVisual;

/* loaded from: classes5.dex */
public class CTPictureImpl extends XmlComplexContentImpl implements CTPicture {
    private static final QName NVPICPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvPicPr");
    private static final QName BLIPFILL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "blipFill");
    private static final QName SPPR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
    private static final QName STYLE$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", TtmlNode.TAG_STYLE);
    private static final QName MACRO$8 = new QName("", "macro");
    private static final QName FPUBLISHED$10 = new QName("", "fPublished");

    public CTPictureImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$2);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTPictureNonVisual addNewNvPicPr() {
        CTPictureNonVisual cTPictureNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureNonVisual = (CTPictureNonVisual) get_store().add_element_user(NVPICPR$0);
        }
        return cTPictureNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$4);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTShapeStyle addNewStyle() {
        CTShapeStyle cTShapeStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeStyle = (CTShapeStyle) get_store().add_element_user(STYLE$6);
        }
        return cTShapeStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$2, 0);
            if (cTBlipFillProperties == null) {
                return null;
            }
            return cTBlipFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public boolean getFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public String getMacro() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTPictureNonVisual getNvPicPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPictureNonVisual cTPictureNonVisual = (CTPictureNonVisual) get_store().find_element_user(NVPICPR$0, 0);
            if (cTPictureNonVisual == null) {
                return null;
            }
            return cTPictureNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$4, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public CTShapeStyle getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeStyle cTShapeStyle = (CTShapeStyle) get_store().find_element_user(STYLE$6, 0);
            if (cTShapeStyle == null) {
                return null;
            }
            return cTShapeStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public boolean isSetFPublished() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FPUBLISHED$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public boolean isSetMacro() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MACRO$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIPFILL$2;
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
            if (cTBlipFillProperties2 == null) {
                cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setFPublished(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setNvPicPr(CTPictureNonVisual cTPictureNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVPICPR$0;
            CTPictureNonVisual cTPictureNonVisual2 = (CTPictureNonVisual) typeStore.find_element_user(qName, 0);
            if (cTPictureNonVisual2 == null) {
                cTPictureNonVisual2 = (CTPictureNonVisual) get_store().add_element_user(qName);
            }
            cTPictureNonVisual2.set(cTPictureNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$4;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void setStyle(CTShapeStyle cTShapeStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$6;
            CTShapeStyle cTShapeStyle2 = (CTShapeStyle) typeStore.find_element_user(qName, 0);
            if (cTShapeStyle2 == null) {
                cTShapeStyle2 = (CTShapeStyle) get_store().add_element_user(qName);
            }
            cTShapeStyle2.set(cTShapeStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void unsetFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FPUBLISHED$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void unsetMacro() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MACRO$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public XmlBoolean xgetFPublished() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$10;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public XmlString xgetMacro() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            xmlString = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString == null) {
                xmlString = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void xsetFPublished(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$10;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture
    public void xsetMacro(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
