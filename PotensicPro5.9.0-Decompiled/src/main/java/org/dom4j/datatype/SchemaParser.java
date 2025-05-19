package org.dom4j.datatype;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sun.msv.datatype.xsd.DatatypeFactory;
import com.sun.msv.datatype.xsd.TypeIncubator;
import com.sun.msv.datatype.xsd.XSDatatype;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.dom4j.util.AttributeHelper;
import org.relaxng.datatype.DatatypeException;
import org.relaxng.datatype.ValidationContext;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
public class SchemaParser {
    private static final QName XSD_ALL;
    private static final QName XSD_ATTRIBUTE;
    private static final QName XSD_CHOICE;
    private static final QName XSD_COMPLEXTYPE;
    private static final QName XSD_ELEMENT;
    private static final QName XSD_INCLUDE;
    private static final Namespace XSD_NAMESPACE;
    private static final QName XSD_RESTRICTION;
    private static final QName XSD_SEQUENCE;
    private static final QName XSD_SIMPLETYPE;
    private Map dataTypeCache;
    private DatatypeDocumentFactory documentFactory;
    private NamedTypeResolver namedTypeResolver;
    private Namespace targetNamespace;

    static {
        Namespace namespace = Namespace.get("xsd", "http://www.w3.org/2001/XMLSchema");
        XSD_NAMESPACE = namespace;
        XSD_ELEMENT = QName.get("element", namespace);
        XSD_ATTRIBUTE = QName.get("attribute", namespace);
        XSD_SIMPLETYPE = QName.get("simpleType", namespace);
        XSD_COMPLEXTYPE = QName.get("complexType", namespace);
        XSD_RESTRICTION = QName.get("restriction", namespace);
        XSD_SEQUENCE = QName.get("sequence", namespace);
        XSD_CHOICE = QName.get("choice", namespace);
        XSD_ALL = QName.get(TtmlNode.COMBINE_ALL, namespace);
        XSD_INCLUDE = QName.get("include", namespace);
    }

    public SchemaParser() {
        this(DatatypeDocumentFactory.singleton);
    }

    public SchemaParser(DatatypeDocumentFactory datatypeDocumentFactory) {
        this.dataTypeCache = new HashMap();
        this.documentFactory = datatypeDocumentFactory;
        this.namedTypeResolver = new NamedTypeResolver(datatypeDocumentFactory);
    }

    public void build(Document document) {
        this.targetNamespace = null;
        internalBuild(document);
    }

    public void build(Document document, Namespace namespace) {
        this.targetNamespace = namespace;
        internalBuild(document);
    }

    private synchronized void internalBuild(Document document) {
        Element rootElement = document.getRootElement();
        if (rootElement != null) {
            Iterator elementIterator = rootElement.elementIterator(XSD_INCLUDE);
            while (elementIterator.hasNext()) {
                String attributeValue = ((Element) elementIterator.next()).attributeValue("schemaLocation");
                EntityResolver entityResolver = document.getEntityResolver();
                if (entityResolver == null) {
                    throw new InvalidSchemaException("No EntityResolver available");
                }
                try {
                    InputSource resolveEntity = entityResolver.resolveEntity(null, attributeValue);
                    if (resolveEntity == null) {
                        throw new InvalidSchemaException(new StringBuffer().append("Could not resolve the schema URI: ").append(attributeValue).toString());
                    }
                    build(new SAXReader().read(resolveEntity));
                } catch (Exception e) {
                    System.out.println(new StringBuffer().append("Failed to load schema: ").append(attributeValue).toString());
                    System.out.println(new StringBuffer().append("Caught: ").append(e).toString());
                    e.printStackTrace();
                    throw new InvalidSchemaException(new StringBuffer().append("Failed to load schema: ").append(attributeValue).toString());
                }
            }
            Iterator elementIterator2 = rootElement.elementIterator(XSD_ELEMENT);
            while (elementIterator2.hasNext()) {
                onDatatypeElement((Element) elementIterator2.next(), this.documentFactory);
            }
            Iterator elementIterator3 = rootElement.elementIterator(XSD_SIMPLETYPE);
            while (elementIterator3.hasNext()) {
                onNamedSchemaSimpleType((Element) elementIterator3.next());
            }
            Iterator elementIterator4 = rootElement.elementIterator(XSD_COMPLEXTYPE);
            while (elementIterator4.hasNext()) {
                onNamedSchemaComplexType((Element) elementIterator4.next());
            }
            this.namedTypeResolver.resolveNamedTypes();
        }
    }

    private void onDatatypeElement(Element element, DocumentFactory documentFactory) {
        XSDatatype loadXSDatatypeFromSimpleType;
        String attributeValue = element.attributeValue("name");
        String attributeValue2 = element.attributeValue("type");
        QName qName = getQName(attributeValue);
        DatatypeElementFactory datatypeElementFactory = getDatatypeElementFactory(qName);
        if (attributeValue2 != null) {
            XSDatatype typeByName = getTypeByName(attributeValue2);
            if (typeByName != null) {
                datatypeElementFactory.setChildElementXSDatatype(qName, typeByName);
                return;
            } else {
                this.namedTypeResolver.registerTypedElement(element, getQName(attributeValue2), documentFactory);
                return;
            }
        }
        Element element2 = element.element(XSD_SIMPLETYPE);
        if (element2 != null && (loadXSDatatypeFromSimpleType = loadXSDatatypeFromSimpleType(element2)) != null) {
            datatypeElementFactory.setChildElementXSDatatype(qName, loadXSDatatypeFromSimpleType);
        }
        Element element3 = element.element(XSD_COMPLEXTYPE);
        if (element3 != null) {
            onSchemaComplexType(element3, datatypeElementFactory);
        }
        Iterator elementIterator = element.elementIterator(XSD_ATTRIBUTE);
        if (elementIterator.hasNext()) {
            do {
                onDatatypeAttribute(element, datatypeElementFactory, (Element) elementIterator.next());
            } while (elementIterator.hasNext());
        }
    }

    private void onNamedSchemaComplexType(Element element) {
        Attribute attribute = element.attribute("name");
        if (attribute == null) {
            return;
        }
        QName qName = getQName(attribute.getText());
        DatatypeElementFactory datatypeElementFactory = getDatatypeElementFactory(qName);
        onSchemaComplexType(element, datatypeElementFactory);
        this.namedTypeResolver.registerComplexType(qName, datatypeElementFactory);
    }

    private void onSchemaComplexType(Element element, DatatypeElementFactory datatypeElementFactory) {
        Iterator elementIterator = element.elementIterator(XSD_ATTRIBUTE);
        while (elementIterator.hasNext()) {
            Element element2 = (Element) elementIterator.next();
            QName qName = getQName(element2.attributeValue("name"));
            XSDatatype dataTypeForXsdAttribute = dataTypeForXsdAttribute(element2);
            if (dataTypeForXsdAttribute != null) {
                datatypeElementFactory.setAttributeXSDatatype(qName, dataTypeForXsdAttribute);
            }
        }
        Element element3 = element.element(XSD_SEQUENCE);
        if (element3 != null) {
            onChildElements(element3, datatypeElementFactory);
        }
        Element element4 = element.element(XSD_CHOICE);
        if (element4 != null) {
            onChildElements(element4, datatypeElementFactory);
        }
        Element element5 = element.element(XSD_ALL);
        if (element5 != null) {
            onChildElements(element5, datatypeElementFactory);
        }
    }

    private void onChildElements(Element element, DatatypeElementFactory datatypeElementFactory) {
        Iterator elementIterator = element.elementIterator(XSD_ELEMENT);
        while (elementIterator.hasNext()) {
            onDatatypeElement((Element) elementIterator.next(), datatypeElementFactory);
        }
    }

    private void onDatatypeAttribute(Element element, DatatypeElementFactory datatypeElementFactory, Element element2) {
        String attributeValue = element2.attributeValue("name");
        QName qName = getQName(attributeValue);
        XSDatatype dataTypeForXsdAttribute = dataTypeForXsdAttribute(element2);
        if (dataTypeForXsdAttribute != null) {
            datatypeElementFactory.setAttributeXSDatatype(qName, dataTypeForXsdAttribute);
        } else {
            System.out.println(new StringBuffer().append("Warning: Couldn't find XSDatatype for type: ").append(element2.attributeValue("type")).append(" attribute: ").append(attributeValue).toString());
        }
    }

    private XSDatatype dataTypeForXsdAttribute(Element element) {
        String attributeValue = element.attributeValue("type");
        if (attributeValue != null) {
            return getTypeByName(attributeValue);
        }
        Element element2 = element.element(XSD_SIMPLETYPE);
        if (element2 == null) {
            throw new InvalidSchemaException(new StringBuffer().append("The attribute: ").append(element.attributeValue("name")).append(" has no type attribute and does not contain a ").append("<simpleType/> element").toString());
        }
        return loadXSDatatypeFromSimpleType(element2);
    }

    private void onNamedSchemaSimpleType(Element element) {
        Attribute attribute = element.attribute("name");
        if (attribute == null) {
            return;
        }
        this.namedTypeResolver.registerSimpleType(getQName(attribute.getText()), loadXSDatatypeFromSimpleType(element));
    }

    private XSDatatype loadXSDatatypeFromSimpleType(Element element) {
        Element element2 = element.element(XSD_RESTRICTION);
        if (element2 != null) {
            String attributeValue = element2.attributeValue(TtmlNode.RUBY_BASE);
            if (attributeValue != null) {
                XSDatatype typeByName = getTypeByName(attributeValue);
                if (typeByName == null) {
                    onSchemaError(new StringBuffer().append("Invalid base type: ").append(attributeValue).append(" when trying to build restriction: ").append(element2).toString());
                    return null;
                }
                return deriveSimpleType(typeByName, element2);
            }
            Element element3 = element.element(XSD_SIMPLETYPE);
            if (element3 == null) {
                onSchemaError(new StringBuffer().append("The simpleType element: ").append(element).append(" must contain a base attribute or simpleType").append(" element").toString());
                return null;
            }
            return loadXSDatatypeFromSimpleType(element3);
        }
        onSchemaError(new StringBuffer().append("No <restriction>. Could not create XSDatatype for simpleType: ").append(element).toString());
        return null;
    }

    private XSDatatype deriveSimpleType(XSDatatype xSDatatype, Element element) {
        TypeIncubator typeIncubator = new TypeIncubator(xSDatatype);
        try {
            Iterator elementIterator = element.elementIterator();
            while (elementIterator.hasNext()) {
                Element element2 = (Element) elementIterator.next();
                typeIncubator.addFacet(element2.getName(), element2.attributeValue("value"), AttributeHelper.booleanValue(element2, "fixed"), (ValidationContext) null);
            }
            return typeIncubator.derive("", (String) null);
        } catch (DatatypeException e) {
            onSchemaError(new StringBuffer().append("Invalid restriction: ").append(e.getMessage()).append(" when trying to build restriction: ").append(element).toString());
            return null;
        }
    }

    private DatatypeElementFactory getDatatypeElementFactory(QName qName) {
        DatatypeElementFactory elementFactory = this.documentFactory.getElementFactory(qName);
        if (elementFactory != null) {
            return elementFactory;
        }
        DatatypeElementFactory datatypeElementFactory = new DatatypeElementFactory(qName);
        qName.setDocumentFactory(datatypeElementFactory);
        return datatypeElementFactory;
    }

    private XSDatatype getTypeByName(String str) {
        XSDatatype xSDatatype = (XSDatatype) this.dataTypeCache.get(str);
        if (xSDatatype == null) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                try {
                    xSDatatype = DatatypeFactory.getTypeByName(str.substring(indexOf + 1));
                } catch (DatatypeException unused) {
                }
            }
            if (xSDatatype == null) {
                try {
                    xSDatatype = DatatypeFactory.getTypeByName(str);
                } catch (DatatypeException unused2) {
                }
            }
            if (xSDatatype == null) {
                xSDatatype = (XSDatatype) this.namedTypeResolver.simpleTypeMap.get(getQName(str));
            }
            if (xSDatatype != null) {
                this.dataTypeCache.put(str, xSDatatype);
            }
        }
        return xSDatatype;
    }

    private QName getQName(String str) {
        Namespace namespace = this.targetNamespace;
        if (namespace == null) {
            return this.documentFactory.createQName(str);
        }
        return this.documentFactory.createQName(str, namespace);
    }

    private void onSchemaError(String str) {
        throw new InvalidSchemaException(str);
    }
}
