package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;

/* loaded from: classes5.dex */
public class AnnotationDocumentImpl extends XmlComplexContentImpl implements AnnotationDocument {
    private static final QName ANNOTATION$0 = new QName("http://www.w3.org/2001/XMLSchema", JamXmlElements.ANNOTATION);

    public AnnotationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
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

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument
    public AnnotationDocument.Annotation addNewAnnotation() {
        AnnotationDocument.Annotation annotation;
        synchronized (monitor()) {
            check_orphaned();
            annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$0);
        }
        return annotation;
    }

    public static class AnnotationImpl extends OpenAttrsImpl implements AnnotationDocument.Annotation {
        private static final QName APPINFO$0 = new QName("http://www.w3.org/2001/XMLSchema", "appinfo");
        private static final QName DOCUMENTATION$2 = new QName("http://www.w3.org/2001/XMLSchema", "documentation");
        private static final QName ID$4 = new QName("", TtmlNode.ATTR_ID);

        public AnnotationImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo[] getAppinfoArray() {
            AppinfoDocument.Appinfo[] appinfoArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(APPINFO$0, arrayList);
                appinfoArr = new AppinfoDocument.Appinfo[arrayList.size()];
                arrayList.toArray(appinfoArr);
            }
            return appinfoArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo getAppinfoArray(int i) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(APPINFO$0, i);
                if (appinfo == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfAppinfoArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(APPINFO$0);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(AppinfoDocument.Appinfo[] appinfoArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(appinfoArr, APPINFO$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setAppinfoArray(int i, AppinfoDocument.Appinfo appinfo) {
            synchronized (monitor()) {
                check_orphaned();
                AppinfoDocument.Appinfo appinfo2 = (AppinfoDocument.Appinfo) get_store().find_element_user(APPINFO$0, i);
                if (appinfo2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                appinfo2.set(appinfo);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo insertNewAppinfo(int i) {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().insert_element_user(APPINFO$0, i);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public AppinfoDocument.Appinfo addNewAppinfo() {
            AppinfoDocument.Appinfo appinfo;
            synchronized (monitor()) {
                check_orphaned();
                appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(APPINFO$0);
            }
            return appinfo;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeAppinfo(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(APPINFO$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation[] getDocumentationArray() {
            DocumentationDocument.Documentation[] documentationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(DOCUMENTATION$2, arrayList);
                documentationArr = new DocumentationDocument.Documentation[arrayList.size()];
                arrayList.toArray(documentationArr);
            }
            return documentationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation getDocumentationArray(int i) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().find_element_user(DOCUMENTATION$2, i);
                if (documentation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public int sizeOfDocumentationArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(DOCUMENTATION$2);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(DocumentationDocument.Documentation[] documentationArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(documentationArr, DOCUMENTATION$2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setDocumentationArray(int i, DocumentationDocument.Documentation documentation) {
            synchronized (monitor()) {
                check_orphaned();
                DocumentationDocument.Documentation documentation2 = (DocumentationDocument.Documentation) get_store().find_element_user(DOCUMENTATION$2, i);
                if (documentation2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                documentation2.set(documentation);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation insertNewDocumentation(int i) {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().insert_element_user(DOCUMENTATION$2, i);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public DocumentationDocument.Documentation addNewDocumentation() {
            DocumentationDocument.Documentation documentation;
            synchronized (monitor()) {
                check_orphaned();
                documentation = (DocumentationDocument.Documentation) get_store().add_element_user(DOCUMENTATION$2);
            }
            return documentation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void removeDocumentation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(DOCUMENTATION$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public String getId() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public XmlID xgetId() {
            XmlID xmlID;
            synchronized (monitor()) {
                check_orphaned();
                xmlID = (XmlID) get_store().find_attribute_user(ID$4);
            }
            return xmlID;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ID$4) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$4;
                XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
                if (xmlID2 == null) {
                    xmlID2 = (XmlID) get_store().add_attribute_user(qName);
                }
                xmlID2.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument.Annotation
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ID$4);
            }
        }
    }
}
