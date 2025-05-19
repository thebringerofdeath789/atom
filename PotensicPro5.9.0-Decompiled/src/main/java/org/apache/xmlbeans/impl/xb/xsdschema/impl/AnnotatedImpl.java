package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;

/* loaded from: classes5.dex */
public class AnnotatedImpl extends OpenAttrsImpl implements Annotated {
    private static final QName ANNOTATION$0 = new QName("http://www.w3.org/2001/XMLSchema", JamXmlElements.ANNOTATION);
    private static final QName ID$2 = new QName("", TtmlNode.ATTR_ID);

    public AnnotatedImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public AnnotationDocument.Annotation getAnnotation() {
        synchronized (monitor()) {
            check_orphaned();
            AnnotationDocument.Annotation annotation = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$0, 0);
            if (annotation == null) {
                return null;
            }
            return annotation;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public boolean isSetAnnotation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ANNOTATION$0) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void setAnnotation(AnnotationDocument.Annotation annotation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANNOTATION$0;
            AnnotationDocument.Annotation annotation2 = (AnnotationDocument.Annotation) typeStore.find_element_user(qName, 0);
            if (annotation2 == null) {
                annotation2 = (AnnotationDocument.Annotation) get_store().add_element_user(qName);
            }
            annotation2.set(annotation);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public AnnotationDocument.Annotation addNewAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$0);
        }
        return annotation;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void unsetAnnotation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANNOTATION$0, 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$2);
        }
        return xmlID;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Annotated
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }
}
