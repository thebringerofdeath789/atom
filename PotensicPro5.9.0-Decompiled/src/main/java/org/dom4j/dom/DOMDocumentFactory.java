package org.dom4j.dom;

import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Namespace;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Text;
import org.dom4j.util.SingletonStrategy;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;

/* loaded from: classes5.dex */
public class DOMDocumentFactory extends DocumentFactory implements DOMImplementation {
    static /* synthetic */ Class class$org$dom4j$dom$DOMDocumentFactory;
    private static SingletonStrategy singleton;

    static {
        Class<?> cls = null;
        try {
            try {
                cls = Class.forName(System.getProperty("org.dom4j.dom.DOMDocumentFactory.singleton.strategy", "org.dom4j.util.SimpleSingleton"));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            cls = Class.forName("org.dom4j.util.SimpleSingleton");
        }
        try {
            SingletonStrategy singletonStrategy = (SingletonStrategy) cls.newInstance();
            singleton = singletonStrategy;
            Class cls2 = class$org$dom4j$dom$DOMDocumentFactory;
            if (cls2 == null) {
                cls2 = class$("org.dom4j.dom.DOMDocumentFactory");
                class$org$dom4j$dom$DOMDocumentFactory = cls2;
            }
            singletonStrategy.setSingletonClassName(cls2.getName());
        } catch (Exception unused3) {
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static DocumentFactory getInstance() {
        return (DOMDocumentFactory) singleton.instance();
    }

    @Override // org.dom4j.DocumentFactory
    public Document createDocument() {
        DOMDocument dOMDocument = new DOMDocument();
        dOMDocument.setDocumentFactory(this);
        return dOMDocument;
    }

    @Override // org.dom4j.DocumentFactory
    public DocumentType createDocType(String str, String str2, String str3) {
        return new DOMDocumentType(str, str2, str3);
    }

    @Override // org.dom4j.DocumentFactory
    public Element createElement(QName qName) {
        return new DOMElement(qName);
    }

    public Element createElement(QName qName, int i) {
        return new DOMElement(qName, i);
    }

    @Override // org.dom4j.DocumentFactory
    public Attribute createAttribute(Element element, QName qName, String str) {
        return new DOMAttribute(qName, str);
    }

    @Override // org.dom4j.DocumentFactory
    public CDATA createCDATA(String str) {
        return new DOMCDATA(str);
    }

    @Override // org.dom4j.DocumentFactory
    public Comment createComment(String str) {
        return new DOMComment(str);
    }

    @Override // org.dom4j.DocumentFactory
    public Text createText(String str) {
        return new DOMText(str);
    }

    public Entity createEntity(String str) {
        return new DOMEntityReference(str);
    }

    @Override // org.dom4j.DocumentFactory
    public Entity createEntity(String str, String str2) {
        return new DOMEntityReference(str, str2);
    }

    @Override // org.dom4j.DocumentFactory
    public Namespace createNamespace(String str, String str2) {
        return new DOMNamespace(str, str2);
    }

    @Override // org.dom4j.DocumentFactory
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new DOMProcessingInstruction(str, str2);
    }

    @Override // org.dom4j.DocumentFactory
    public ProcessingInstruction createProcessingInstruction(String str, Map map) {
        return new DOMProcessingInstruction(str, map);
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        if ("XML".equalsIgnoreCase(str) || "Core".equalsIgnoreCase(str)) {
            return str2 == null || str2.length() == 0 || "1.0".equals(str2) || "2.0".equals(str2);
        }
        return false;
    }

    @Override // org.w3c.dom.DOMImplementation
    public org.w3c.dom.DocumentType createDocumentType(String str, String str2, String str3) throws DOMException {
        return new DOMDocumentType(str, str2, str3);
    }

    @Override // org.w3c.dom.DOMImplementation
    public org.w3c.dom.Document createDocument(String str, String str2, org.w3c.dom.DocumentType documentType) throws DOMException {
        DOMDocument dOMDocument;
        if (documentType != null) {
            dOMDocument = new DOMDocument(asDocumentType(documentType));
        } else {
            dOMDocument = new DOMDocument();
        }
        dOMDocument.addElement(createQName(str2, str));
        return dOMDocument;
    }

    protected DOMDocumentType asDocumentType(org.w3c.dom.DocumentType documentType) {
        if (documentType instanceof DOMDocumentType) {
            return (DOMDocumentType) documentType;
        }
        return new DOMDocumentType(documentType.getName(), documentType.getPublicId(), documentType.getSystemId());
    }
}
