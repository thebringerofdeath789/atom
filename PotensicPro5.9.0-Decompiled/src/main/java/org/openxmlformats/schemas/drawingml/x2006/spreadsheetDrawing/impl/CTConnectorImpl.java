package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;

/* loaded from: classes5.dex */
public class CTConnectorImpl extends XmlComplexContentImpl implements CTConnector {
    private static final QName NVCXNSPPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvCxnSpPr");
    private static final QName SPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
    private static final QName STYLE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", TtmlNode.TAG_STYLE);
    private static final QName MACRO$6 = new QName("", "macro");
    private static final QName FPUBLISHED$8 = new QName("", "fPublished");

    public CTConnectorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTConnectorNonVisual addNewNvCxnSpPr() {
        CTConnectorNonVisual cTConnectorNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectorNonVisual = (CTConnectorNonVisual) get_store().add_element_user(NVCXNSPPR$0);
        }
        return cTConnectorNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$2);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTShapeStyle addNewStyle() {
        CTShapeStyle cTShapeStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeStyle = (CTShapeStyle) get_store().add_element_user(STYLE$4);
        }
        return cTShapeStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public boolean getFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public String getMacro() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MACRO$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTConnectorNonVisual getNvCxnSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnectorNonVisual cTConnectorNonVisual = (CTConnectorNonVisual) get_store().find_element_user(NVCXNSPPR$0, 0);
            if (cTConnectorNonVisual == null) {
                return null;
            }
            return cTConnectorNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$2, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public CTShapeStyle getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeStyle cTShapeStyle = (CTShapeStyle) get_store().find_element_user(STYLE$4, 0);
            if (cTShapeStyle == null) {
                return null;
            }
            return cTShapeStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public boolean isSetFPublished() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FPUBLISHED$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public boolean isSetMacro() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MACRO$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void setFPublished(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void setMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void setNvCxnSpPr(CTConnectorNonVisual cTConnectorNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVCXNSPPR$0;
            CTConnectorNonVisual cTConnectorNonVisual2 = (CTConnectorNonVisual) typeStore.find_element_user(qName, 0);
            if (cTConnectorNonVisual2 == null) {
                cTConnectorNonVisual2 = (CTConnectorNonVisual) get_store().add_element_user(qName);
            }
            cTConnectorNonVisual2.set(cTConnectorNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$2;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void setStyle(CTShapeStyle cTShapeStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$4;
            CTShapeStyle cTShapeStyle2 = (CTShapeStyle) typeStore.find_element_user(qName, 0);
            if (cTShapeStyle2 == null) {
                cTShapeStyle2 = (CTShapeStyle) get_store().add_element_user(qName);
            }
            cTShapeStyle2.set(cTShapeStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void unsetFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FPUBLISHED$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void unsetMacro() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MACRO$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public XmlBoolean xgetFPublished() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public XmlString xgetMacro() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(MACRO$6);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void xsetFPublished(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector
    public void xsetMacro(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$6;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlString2.set(xmlString);
        }
    }
}
