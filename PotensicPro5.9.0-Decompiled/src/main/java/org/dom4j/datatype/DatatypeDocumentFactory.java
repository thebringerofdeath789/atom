package org.dom4j.datatype;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
public class DatatypeDocumentFactory extends DocumentFactory {
    private static final boolean DO_INTERN_QNAME = false;
    private static final Namespace XSI_NAMESPACE;
    private static final QName XSI_NO_SCHEMA_LOCATION;
    private static final QName XSI_SCHEMA_LOCATION;
    protected static transient DatatypeDocumentFactory singleton = new DatatypeDocumentFactory();
    private SAXReader xmlSchemaReader = new SAXReader();
    private boolean autoLoadSchema = true;
    private SchemaParser schemaBuilder = new SchemaParser(this);

    static {
        Namespace namespace = Namespace.get("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        XSI_NAMESPACE = namespace;
        XSI_SCHEMA_LOCATION = QName.get("schemaLocation", namespace);
        XSI_NO_SCHEMA_LOCATION = QName.get("noNamespaceSchemaLocation", namespace);
    }

    public static DocumentFactory getInstance() {
        return singleton;
    }

    public void loadSchema(Document document) {
        this.schemaBuilder.build(document);
    }

    public void loadSchema(Document document, Namespace namespace) {
        this.schemaBuilder.build(document, namespace);
    }

    public DatatypeElementFactory getElementFactory(QName qName) {
        DocumentFactory documentFactory = qName.getDocumentFactory();
        if (documentFactory instanceof DatatypeElementFactory) {
            return (DatatypeElementFactory) documentFactory;
        }
        return null;
    }

    @Override // org.dom4j.DocumentFactory
    public Attribute createAttribute(Element element, QName qName, String str) {
        if (this.autoLoadSchema && qName.equals(XSI_NO_SCHEMA_LOCATION)) {
            loadSchema(element != null ? element.getDocument() : null, str);
        } else if (this.autoLoadSchema && qName.equals(XSI_SCHEMA_LOCATION)) {
            loadSchema(element != null ? element.getDocument() : null, str.substring(str.indexOf(32) + 1), element.getNamespaceForURI(str.substring(0, str.indexOf(32))));
        }
        return super.createAttribute(element, qName, str);
    }

    protected void loadSchema(Document document, String str) {
        try {
            EntityResolver entityResolver = document.getEntityResolver();
            if (entityResolver == null) {
                throw new InvalidSchemaException(new StringBuffer().append("No EntityResolver available for resolving URI: ").append(str).toString());
            }
            InputSource resolveEntity = entityResolver.resolveEntity(null, str);
            if (entityResolver == null) {
                throw new InvalidSchemaException(new StringBuffer().append("Could not resolve the URI: ").append(str).toString());
            }
            loadSchema(this.xmlSchemaReader.read(resolveEntity));
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("Failed to load schema: ").append(str).toString());
            System.out.println(new StringBuffer().append("Caught: ").append(e).toString());
            e.printStackTrace();
            throw new InvalidSchemaException(new StringBuffer().append("Failed to load schema: ").append(str).toString());
        }
    }

    protected void loadSchema(Document document, String str, Namespace namespace) {
        try {
            EntityResolver entityResolver = document.getEntityResolver();
            if (entityResolver == null) {
                throw new InvalidSchemaException(new StringBuffer().append("No EntityResolver available for resolving URI: ").append(str).toString());
            }
            InputSource resolveEntity = entityResolver.resolveEntity(null, str);
            if (entityResolver == null) {
                throw new InvalidSchemaException(new StringBuffer().append("Could not resolve the URI: ").append(str).toString());
            }
            loadSchema(this.xmlSchemaReader.read(resolveEntity), namespace);
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("Failed to load schema: ").append(str).toString());
            System.out.println(new StringBuffer().append("Caught: ").append(e).toString());
            e.printStackTrace();
            throw new InvalidSchemaException(new StringBuffer().append("Failed to load schema: ").append(str).toString());
        }
    }
}
