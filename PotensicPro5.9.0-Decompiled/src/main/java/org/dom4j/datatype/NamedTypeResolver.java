package org.dom4j.datatype;

import com.sun.msv.datatype.xsd.XSDatatype;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;

/* loaded from: classes5.dex */
class NamedTypeResolver {
    protected DocumentFactory documentFactory;
    protected Map complexTypeMap = new HashMap();
    protected Map simpleTypeMap = new HashMap();
    protected Map typedElementMap = new HashMap();
    protected Map elementFactoryMap = new HashMap();

    NamedTypeResolver(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    void registerComplexType(QName qName, DocumentFactory documentFactory) {
        this.complexTypeMap.put(qName, documentFactory);
    }

    void registerSimpleType(QName qName, XSDatatype xSDatatype) {
        this.simpleTypeMap.put(qName, xSDatatype);
    }

    void registerTypedElement(Element element, QName qName, DocumentFactory documentFactory) {
        this.typedElementMap.put(element, qName);
        this.elementFactoryMap.put(element, documentFactory);
    }

    void resolveElementTypes() {
        for (Element element : this.typedElementMap.keySet()) {
            QName qNameOfSchemaElement = getQNameOfSchemaElement(element);
            QName qName = (QName) this.typedElementMap.get(element);
            if (this.complexTypeMap.containsKey(qName)) {
                qNameOfSchemaElement.setDocumentFactory((DocumentFactory) this.complexTypeMap.get(qName));
            } else if (this.simpleTypeMap.containsKey(qName)) {
                XSDatatype xSDatatype = (XSDatatype) this.simpleTypeMap.get(qName);
                DocumentFactory documentFactory = (DocumentFactory) this.elementFactoryMap.get(element);
                if (documentFactory instanceof DatatypeElementFactory) {
                    ((DatatypeElementFactory) documentFactory).setChildElementXSDatatype(qNameOfSchemaElement, xSDatatype);
                }
            }
        }
    }

    void resolveNamedTypes() {
        resolveElementTypes();
    }

    private QName getQNameOfSchemaElement(Element element) {
        return getQName(element.attributeValue("name"));
    }

    private QName getQName(String str) {
        return this.documentFactory.createQName(str);
    }
}
