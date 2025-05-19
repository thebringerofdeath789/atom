package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* loaded from: classes5.dex */
public class SchemaDocumentImpl extends XmlComplexContentImpl implements SchemaDocument {
    private static final QName SCHEMA$0 = new QName("http://www.w3.org/2001/XMLSchema", "schema");

    public SchemaDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema getSchema() {
        synchronized (monitor()) {
            check_orphaned();
            SchemaDocument.Schema schema = (SchemaDocument.Schema) get_store().find_element_user(SCHEMA$0, 0);
            if (schema == null) {
                return null;
            }
            return schema;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public void setSchema(SchemaDocument.Schema schema) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCHEMA$0;
            SchemaDocument.Schema schema2 = (SchemaDocument.Schema) typeStore.find_element_user(qName, 0);
            if (schema2 == null) {
                schema2 = (SchemaDocument.Schema) get_store().add_element_user(qName);
            }
            schema2.set(schema);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema addNewSchema() {
        SchemaDocument.Schema schema;
        synchronized (monitor()) {
            check_orphaned();
            schema = (SchemaDocument.Schema) get_store().add_element_user(SCHEMA$0);
        }
        return schema;
    }

    public static class SchemaImpl extends OpenAttrsImpl implements SchemaDocument.Schema {
        private static final QName INCLUDE$0 = new QName("http://www.w3.org/2001/XMLSchema", "include");
        private static final QName IMPORT$2 = new QName("http://www.w3.org/2001/XMLSchema", "import");
        private static final QName REDEFINE$4 = new QName("http://www.w3.org/2001/XMLSchema", "redefine");
        private static final QName ANNOTATION$6 = new QName("http://www.w3.org/2001/XMLSchema", JamXmlElements.ANNOTATION);
        private static final QName SIMPLETYPE$8 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
        private static final QName COMPLEXTYPE$10 = new QName("http://www.w3.org/2001/XMLSchema", "complexType");
        private static final QName GROUP$12 = new QName("http://www.w3.org/2001/XMLSchema", "group");
        private static final QName ATTRIBUTEGROUP$14 = new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup");
        private static final QName ELEMENT$16 = new QName("http://www.w3.org/2001/XMLSchema", "element");
        private static final QName ATTRIBUTE$18 = new QName("http://www.w3.org/2001/XMLSchema", "attribute");
        private static final QName NOTATION$20 = new QName("http://www.w3.org/2001/XMLSchema", "notation");
        private static final QName TARGETNAMESPACE$22 = new QName("", "targetNamespace");
        private static final QName VERSION$24 = new QName("", OutputKeys.VERSION);
        private static final QName FINALDEFAULT$26 = new QName("", "finalDefault");
        private static final QName BLOCKDEFAULT$28 = new QName("", "blockDefault");
        private static final QName ATTRIBUTEFORMDEFAULT$30 = new QName("", "attributeFormDefault");
        private static final QName ELEMENTFORMDEFAULT$32 = new QName("", "elementFormDefault");
        private static final QName ID$34 = new QName("", TtmlNode.ATTR_ID);
        private static final QName LANG$36 = new QName("http://www.w3.org/XML/1998/namespace", "lang");

        public SchemaImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include[] getIncludeArray() {
            IncludeDocument.Include[] includeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(INCLUDE$0, arrayList);
                includeArr = new IncludeDocument.Include[arrayList.size()];
                arrayList.toArray(includeArr);
            }
            return includeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include getIncludeArray(int i) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().find_element_user(INCLUDE$0, i);
                if (include == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfIncludeArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(INCLUDE$0);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(IncludeDocument.Include[] includeArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(includeArr, INCLUDE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(int i, IncludeDocument.Include include) {
            synchronized (monitor()) {
                check_orphaned();
                IncludeDocument.Include include2 = (IncludeDocument.Include) get_store().find_element_user(INCLUDE$0, i);
                if (include2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                include2.set(include);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include insertNewInclude(int i) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().insert_element_user(INCLUDE$0, i);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include addNewInclude() {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().add_element_user(INCLUDE$0);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeInclude(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(INCLUDE$0, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import[] getImportArray() {
            ImportDocument.Import[] importArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(IMPORT$2, arrayList);
                importArr = new ImportDocument.Import[arrayList.size()];
                arrayList.toArray(importArr);
            }
            return importArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import getImportArray(int i) {
            ImportDocument.Import r4;
            synchronized (monitor()) {
                check_orphaned();
                r4 = (ImportDocument.Import) get_store().find_element_user(IMPORT$2, i);
                if (r4 == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return r4;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfImportArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(IMPORT$2);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(ImportDocument.Import[] importArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(importArr, IMPORT$2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(int i, ImportDocument.Import r5) {
            synchronized (monitor()) {
                check_orphaned();
                ImportDocument.Import r4 = (ImportDocument.Import) get_store().find_element_user(IMPORT$2, i);
                if (r4 == null) {
                    throw new IndexOutOfBoundsException();
                }
                r4.set(r5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import insertNewImport(int i) {
            ImportDocument.Import r4;
            synchronized (monitor()) {
                check_orphaned();
                r4 = (ImportDocument.Import) get_store().insert_element_user(IMPORT$2, i);
            }
            return r4;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import addNewImport() {
            ImportDocument.Import r1;
            synchronized (monitor()) {
                check_orphaned();
                r1 = (ImportDocument.Import) get_store().add_element_user(IMPORT$2);
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeImport(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(IMPORT$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine[] getRedefineArray() {
            RedefineDocument.Redefine[] redefineArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(REDEFINE$4, arrayList);
                redefineArr = new RedefineDocument.Redefine[arrayList.size()];
                arrayList.toArray(redefineArr);
            }
            return redefineArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine getRedefineArray(int i) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().find_element_user(REDEFINE$4, i);
                if (redefine == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfRedefineArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(REDEFINE$4);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(RedefineDocument.Redefine[] redefineArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(redefineArr, REDEFINE$4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(int i, RedefineDocument.Redefine redefine) {
            synchronized (monitor()) {
                check_orphaned();
                RedefineDocument.Redefine redefine2 = (RedefineDocument.Redefine) get_store().find_element_user(REDEFINE$4, i);
                if (redefine2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                redefine2.set(redefine);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine insertNewRedefine(int i) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().insert_element_user(REDEFINE$4, i);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine addNewRedefine() {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().add_element_user(REDEFINE$4);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeRedefine(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(REDEFINE$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation[] getAnnotationArray() {
            AnnotationDocument.Annotation[] annotationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ANNOTATION$6, arrayList);
                annotationArr = new AnnotationDocument.Annotation[arrayList.size()];
                arrayList.toArray(annotationArr);
            }
            return annotationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation getAnnotationArray(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$6, i);
                if (annotation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAnnotationArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ANNOTATION$6);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(annotationArr, ANNOTATION$6);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(int i, AnnotationDocument.Annotation annotation) {
            synchronized (monitor()) {
                check_orphaned();
                AnnotationDocument.Annotation annotation2 = (AnnotationDocument.Annotation) get_store().find_element_user(ANNOTATION$6, i);
                if (annotation2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                annotation2.set(annotation);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation insertNewAnnotation(int i) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().insert_element_user(ANNOTATION$6, i);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation addNewAnnotation() {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().add_element_user(ANNOTATION$6);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAnnotation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ANNOTATION$6, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType[] getSimpleTypeArray() {
            TopLevelSimpleType[] topLevelSimpleTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(SIMPLETYPE$8, arrayList);
                topLevelSimpleTypeArr = new TopLevelSimpleType[arrayList.size()];
                arrayList.toArray(topLevelSimpleTypeArr);
            }
            return topLevelSimpleTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType getSimpleTypeArray(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$8, i);
                if (topLevelSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfSimpleTypeArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(SIMPLETYPE$8);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(topLevelSimpleTypeArr, SIMPLETYPE$8);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(int i, TopLevelSimpleType topLevelSimpleType) {
            synchronized (monitor()) {
                check_orphaned();
                TopLevelSimpleType topLevelSimpleType2 = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$8, i);
                if (topLevelSimpleType2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                topLevelSimpleType2.set(topLevelSimpleType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType insertNewSimpleType(int i) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().insert_element_user(SIMPLETYPE$8, i);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType addNewSimpleType() {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(SIMPLETYPE$8);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeSimpleType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$8, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType[] getComplexTypeArray() {
            TopLevelComplexType[] topLevelComplexTypeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(COMPLEXTYPE$10, arrayList);
                topLevelComplexTypeArr = new TopLevelComplexType[arrayList.size()];
                arrayList.toArray(topLevelComplexTypeArr);
            }
            return topLevelComplexTypeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType getComplexTypeArray(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$10, i);
                if (topLevelComplexType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfComplexTypeArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(COMPLEXTYPE$10);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(topLevelComplexTypeArr, COMPLEXTYPE$10);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(int i, TopLevelComplexType topLevelComplexType) {
            synchronized (monitor()) {
                check_orphaned();
                TopLevelComplexType topLevelComplexType2 = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$10, i);
                if (topLevelComplexType2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                topLevelComplexType2.set(topLevelComplexType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType insertNewComplexType(int i) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().insert_element_user(COMPLEXTYPE$10, i);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType addNewComplexType() {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(COMPLEXTYPE$10);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeComplexType(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(COMPLEXTYPE$10, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup[] getGroupArray() {
            NamedGroup[] namedGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(GROUP$12, arrayList);
                namedGroupArr = new NamedGroup[arrayList.size()];
                arrayList.toArray(namedGroupArr);
            }
            return namedGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup getGroupArray(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().find_element_user(GROUP$12, i);
                if (namedGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfGroupArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(GROUP$12);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(NamedGroup[] namedGroupArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(namedGroupArr, GROUP$12);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(int i, NamedGroup namedGroup) {
            synchronized (monitor()) {
                check_orphaned();
                NamedGroup namedGroup2 = (NamedGroup) get_store().find_element_user(GROUP$12, i);
                if (namedGroup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                namedGroup2.set(namedGroup);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup insertNewGroup(int i) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().insert_element_user(GROUP$12, i);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup addNewGroup() {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().add_element_user(GROUP$12);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(GROUP$12, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup[] getAttributeGroupArray() {
            NamedAttributeGroup[] namedAttributeGroupArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ATTRIBUTEGROUP$14, arrayList);
                namedAttributeGroupArr = new NamedAttributeGroup[arrayList.size()];
                arrayList.toArray(namedAttributeGroupArr);
            }
            return namedAttributeGroupArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup getAttributeGroupArray(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$14, i);
                if (namedAttributeGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeGroupArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ATTRIBUTEGROUP$14);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(namedAttributeGroupArr, ATTRIBUTEGROUP$14);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(int i, NamedAttributeGroup namedAttributeGroup) {
            synchronized (monitor()) {
                check_orphaned();
                NamedAttributeGroup namedAttributeGroup2 = (NamedAttributeGroup) get_store().find_element_user(ATTRIBUTEGROUP$14, i);
                if (namedAttributeGroup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                namedAttributeGroup2.set(namedAttributeGroup);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup insertNewAttributeGroup(int i) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().insert_element_user(ATTRIBUTEGROUP$14, i);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup addNewAttributeGroup() {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(ATTRIBUTEGROUP$14);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttributeGroup(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ATTRIBUTEGROUP$14, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement[] getElementArray() {
            TopLevelElement[] topLevelElementArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ELEMENT$16, arrayList);
                topLevelElementArr = new TopLevelElement[arrayList.size()];
                arrayList.toArray(topLevelElementArr);
            }
            return topLevelElementArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement getElementArray(int i) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().find_element_user(ELEMENT$16, i);
                if (topLevelElement == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfElementArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ELEMENT$16);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(TopLevelElement[] topLevelElementArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(topLevelElementArr, ELEMENT$16);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(int i, TopLevelElement topLevelElement) {
            synchronized (monitor()) {
                check_orphaned();
                TopLevelElement topLevelElement2 = (TopLevelElement) get_store().find_element_user(ELEMENT$16, i);
                if (topLevelElement2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                topLevelElement2.set(topLevelElement);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement insertNewElement(int i) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().insert_element_user(ELEMENT$16, i);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement addNewElement() {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().add_element_user(ELEMENT$16);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeElement(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ELEMENT$16, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute[] getAttributeArray() {
            TopLevelAttribute[] topLevelAttributeArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ATTRIBUTE$18, arrayList);
                topLevelAttributeArr = new TopLevelAttribute[arrayList.size()];
                arrayList.toArray(topLevelAttributeArr);
            }
            return topLevelAttributeArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute getAttributeArray(int i) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().find_element_user(ATTRIBUTE$18, i);
                if (topLevelAttribute == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ATTRIBUTE$18);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(TopLevelAttribute[] topLevelAttributeArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(topLevelAttributeArr, ATTRIBUTE$18);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(int i, TopLevelAttribute topLevelAttribute) {
            synchronized (monitor()) {
                check_orphaned();
                TopLevelAttribute topLevelAttribute2 = (TopLevelAttribute) get_store().find_element_user(ATTRIBUTE$18, i);
                if (topLevelAttribute2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                topLevelAttribute2.set(topLevelAttribute);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute insertNewAttribute(int i) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().insert_element_user(ATTRIBUTE$18, i);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute addNewAttribute() {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().add_element_user(ATTRIBUTE$18);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttribute(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ATTRIBUTE$18, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation[] getNotationArray() {
            NotationDocument.Notation[] notationArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(NOTATION$20, arrayList);
                notationArr = new NotationDocument.Notation[arrayList.size()];
                arrayList.toArray(notationArr);
            }
            return notationArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation getNotationArray(int i) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().find_element_user(NOTATION$20, i);
                if (notation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfNotationArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(NOTATION$20);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(NotationDocument.Notation[] notationArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(notationArr, NOTATION$20);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(int i, NotationDocument.Notation notation) {
            synchronized (monitor()) {
                check_orphaned();
                NotationDocument.Notation notation2 = (NotationDocument.Notation) get_store().find_element_user(NOTATION$20, i);
                if (notation2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                notation2.set(notation);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation insertNewNotation(int i) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().insert_element_user(NOTATION$20, i);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation addNewNotation() {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().add_element_user(NOTATION$20);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeNotation(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(NOTATION$20, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getTargetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGETNAMESPACE$22);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlAnyURI xgetTargetNamespace() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(TARGETNAMESPACE$22);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetTargetNamespace() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(TARGETNAMESPACE$22) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setTargetNamespace(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TARGETNAMESPACE$22;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetTargetNamespace(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TARGETNAMESPACE$22;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetTargetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(TARGETNAMESPACE$22);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getVersion() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VERSION$24);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlToken xgetVersion() {
            XmlToken xmlToken;
            synchronized (monitor()) {
                check_orphaned();
                xmlToken = (XmlToken) get_store().find_attribute_user(VERSION$24);
            }
            return xmlToken;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetVersion() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(VERSION$24) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setVersion(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VERSION$24;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetVersion(XmlToken xmlToken) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VERSION$24;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
                }
                xmlToken2.set(xmlToken);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetVersion() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(VERSION$24);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getFinalDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FullDerivationSet xgetFinalDefault() {
            FullDerivationSet fullDerivationSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                fullDerivationSet = (FullDerivationSet) typeStore.find_attribute_user(qName);
                if (fullDerivationSet == null) {
                    fullDerivationSet = (FullDerivationSet) get_default_attribute_value(qName);
                }
            }
            return fullDerivationSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetFinalDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(FINALDEFAULT$26) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setFinalDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetFinalDefault(FullDerivationSet fullDerivationSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FINALDEFAULT$26;
                FullDerivationSet fullDerivationSet2 = (FullDerivationSet) typeStore.find_attribute_user(qName);
                if (fullDerivationSet2 == null) {
                    fullDerivationSet2 = (FullDerivationSet) get_store().add_attribute_user(qName);
                }
                fullDerivationSet2.set(fullDerivationSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetFinalDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(FINALDEFAULT$26);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getBlockDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public BlockSet xgetBlockDefault() {
            BlockSet blockSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                blockSet = (BlockSet) typeStore.find_attribute_user(qName);
                if (blockSet == null) {
                    blockSet = (BlockSet) get_default_attribute_value(qName);
                }
            }
            return blockSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetBlockDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(BLOCKDEFAULT$28) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setBlockDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetBlockDefault(BlockSet blockSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLOCKDEFAULT$28;
                BlockSet blockSet2 = (BlockSet) typeStore.find_attribute_user(qName);
                if (blockSet2 == null) {
                    blockSet2 = (BlockSet) get_store().add_attribute_user(qName);
                }
                blockSet2.set(blockSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetBlockDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(BLOCKDEFAULT$28);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getAttributeFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return (FormChoice.Enum) simpleValue.getEnumValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetAttributeFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                formChoice = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qName);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetAttributeFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeFormDefault(FormChoice.Enum r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetAttributeFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ATTRIBUTEFORMDEFAULT$30;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
                }
                formChoice2.set(formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetAttributeFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ATTRIBUTEFORMDEFAULT$30);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getElementFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return (FormChoice.Enum) simpleValue.getEnumValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetElementFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                formChoice = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qName);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetElementFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ELEMENTFORMDEFAULT$32) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementFormDefault(FormChoice.Enum r4) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetElementFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ELEMENTFORMDEFAULT$32;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qName);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qName);
                }
                formChoice2.set(formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetElementFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ELEMENTFORMDEFAULT$32);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getId() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$34);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlID xgetId() {
            XmlID xmlID;
            synchronized (monitor()) {
                check_orphaned();
                xmlID = (XmlID) get_store().find_attribute_user(ID$34);
            }
            return xmlID;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(ID$34) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$34;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$34;
                XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
                if (xmlID2 == null) {
                    xmlID2 = (XmlID) get_store().add_attribute_user(qName);
                }
                xmlID2.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(ID$34);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getLang() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LANG$36);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlLanguage xgetLang() {
            XmlLanguage xmlLanguage;
            synchronized (monitor()) {
                check_orphaned();
                xmlLanguage = (XmlLanguage) get_store().find_attribute_user(LANG$36);
            }
            return xmlLanguage;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetLang() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(LANG$36) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setLang(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$36;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetLang(XmlLanguage xmlLanguage) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LANG$36;
                XmlLanguage xmlLanguage2 = (XmlLanguage) typeStore.find_attribute_user(qName);
                if (xmlLanguage2 == null) {
                    xmlLanguage2 = (XmlLanguage) get_store().add_attribute_user(qName);
                }
                xmlLanguage2.set(xmlLanguage);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(LANG$36);
            }
        }
    }
}
