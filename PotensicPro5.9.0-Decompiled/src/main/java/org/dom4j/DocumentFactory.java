package org.dom4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.dom4j.rule.Pattern;
import org.dom4j.tree.AbstractDocument;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultCDATA;
import org.dom4j.tree.DefaultComment;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultDocumentType;
import org.dom4j.tree.DefaultElement;
import org.dom4j.tree.DefaultEntity;
import org.dom4j.tree.DefaultProcessingInstruction;
import org.dom4j.tree.DefaultText;
import org.dom4j.tree.QNameCache;
import org.dom4j.util.SimpleSingleton;
import org.dom4j.util.SingletonStrategy;
import org.dom4j.xpath.DefaultXPath;
import org.dom4j.xpath.XPathPattern;
import org.jaxen.VariableContext;

/* loaded from: classes5.dex */
public class DocumentFactory implements Serializable {
    static /* synthetic */ Class class$org$dom4j$DocumentFactory;
    private static SingletonStrategy singleton;
    protected transient QNameCache cache;
    private Map xpathNamespaceURIs;

    private static SingletonStrategy createSingleton() {
        SingletonStrategy simpleSingleton;
        String str = "org.dom4j.DocumentFactory";
        try {
            str = System.getProperty("org.dom4j.factory", "org.dom4j.DocumentFactory");
        } catch (Exception unused) {
        }
        try {
            simpleSingleton = (SingletonStrategy) Class.forName(System.getProperty("org.dom4j.DocumentFactory.singleton.strategy", "org.dom4j.util.SimpleSingleton")).newInstance();
        } catch (Exception unused2) {
            simpleSingleton = new SimpleSingleton();
        }
        simpleSingleton.setSingletonClassName(str);
        return simpleSingleton;
    }

    public DocumentFactory() {
        init();
    }

    public static synchronized DocumentFactory getInstance() {
        DocumentFactory documentFactory;
        synchronized (DocumentFactory.class) {
            if (singleton == null) {
                singleton = createSingleton();
            }
            documentFactory = (DocumentFactory) singleton.instance();
        }
        return documentFactory;
    }

    public Document createDocument() {
        DefaultDocument defaultDocument = new DefaultDocument();
        defaultDocument.setDocumentFactory(this);
        return defaultDocument;
    }

    public Document createDocument(String str) {
        Document createDocument = createDocument();
        if (createDocument instanceof AbstractDocument) {
            ((AbstractDocument) createDocument).setXMLEncoding(str);
        }
        return createDocument;
    }

    public Document createDocument(Element element) {
        Document createDocument = createDocument();
        createDocument.setRootElement(element);
        return createDocument;
    }

    public DocumentType createDocType(String str, String str2, String str3) {
        return new DefaultDocumentType(str, str2, str3);
    }

    public Element createElement(QName qName) {
        return new DefaultElement(qName);
    }

    public Element createElement(String str) {
        return createElement(createQName(str));
    }

    public Element createElement(String str, String str2) {
        return createElement(createQName(str, str2));
    }

    public Attribute createAttribute(Element element, QName qName, String str) {
        return new DefaultAttribute(qName, str);
    }

    public Attribute createAttribute(Element element, String str, String str2) {
        return createAttribute(element, createQName(str), str2);
    }

    public CDATA createCDATA(String str) {
        return new DefaultCDATA(str);
    }

    public Comment createComment(String str) {
        return new DefaultComment(str);
    }

    public Text createText(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Adding text to an XML document must not be null");
        }
        return new DefaultText(str);
    }

    public Entity createEntity(String str, String str2) {
        return new DefaultEntity(str, str2);
    }

    public Namespace createNamespace(String str, String str2) {
        return Namespace.get(str, str2);
    }

    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new DefaultProcessingInstruction(str, str2);
    }

    public ProcessingInstruction createProcessingInstruction(String str, Map map) {
        return new DefaultProcessingInstruction(str, map);
    }

    public QName createQName(String str, Namespace namespace) {
        return this.cache.get(str, namespace);
    }

    public QName createQName(String str) {
        return this.cache.get(str);
    }

    public QName createQName(String str, String str2, String str3) {
        return this.cache.get(str, Namespace.get(str2, str3));
    }

    public QName createQName(String str, String str2) {
        return this.cache.get(str, str2);
    }

    public XPath createXPath(String str) throws InvalidXPathException {
        DefaultXPath defaultXPath = new DefaultXPath(str);
        Map map = this.xpathNamespaceURIs;
        if (map != null) {
            defaultXPath.setNamespaceURIs(map);
        }
        return defaultXPath;
    }

    public XPath createXPath(String str, VariableContext variableContext) {
        XPath createXPath = createXPath(str);
        createXPath.setVariableContext(variableContext);
        return createXPath;
    }

    public NodeFilter createXPathFilter(String str, VariableContext variableContext) {
        XPath createXPath = createXPath(str);
        createXPath.setVariableContext(variableContext);
        return createXPath;
    }

    public NodeFilter createXPathFilter(String str) {
        return createXPath(str);
    }

    public Pattern createPattern(String str) {
        return new XPathPattern(str);
    }

    public List getQNames() {
        return this.cache.getQNames();
    }

    public Map getXPathNamespaceURIs() {
        return this.xpathNamespaceURIs;
    }

    public void setXPathNamespaceURIs(Map map) {
        this.xpathNamespaceURIs = map;
    }

    protected static DocumentFactory createSingleton(String str) {
        try {
            Class cls = class$org$dom4j$DocumentFactory;
            if (cls == null) {
                cls = class$("org.dom4j.DocumentFactory");
                class$org$dom4j$DocumentFactory = cls;
            }
            return (DocumentFactory) Class.forName(str, true, cls.getClassLoader()).newInstance();
        } catch (Throwable unused) {
            System.out.println(new StringBuffer().append("WARNING: Cannot load DocumentFactory: ").append(str).toString());
            return new DocumentFactory();
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected QName intern(QName qName) {
        return this.cache.intern(qName);
    }

    protected QNameCache createQNameCache() {
        return new QNameCache(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    protected void init() {
        this.cache = createQNameCache();
    }
}
