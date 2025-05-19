package org.dom4j.tree;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.xml.sax.EntityResolver;

/* loaded from: classes5.dex */
public class DefaultDocument extends AbstractDocument {
    protected static final Iterator EMPTY_ITERATOR;
    protected static final List EMPTY_LIST;
    private List content;
    private DocumentType docType;
    private DocumentFactory documentFactory = DocumentFactory.getInstance();
    private transient EntityResolver entityResolver;
    private String name;
    private Element rootElement;

    static {
        List list = Collections.EMPTY_LIST;
        EMPTY_LIST = list;
        EMPTY_ITERATOR = list.iterator();
    }

    public DefaultDocument() {
    }

    public DefaultDocument(String str) {
        this.name = str;
    }

    public DefaultDocument(Element element) {
        this.rootElement = element;
    }

    public DefaultDocument(DocumentType documentType) {
        this.docType = documentType;
    }

    public DefaultDocument(Element element, DocumentType documentType) {
        this.rootElement = element;
        this.docType = documentType;
    }

    public DefaultDocument(String str, Element element, DocumentType documentType) {
        this.name = str;
        this.rootElement = element;
        this.docType = documentType;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return this.name;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        this.name = str;
    }

    @Override // org.dom4j.Document
    public Element getRootElement() {
        return this.rootElement;
    }

    @Override // org.dom4j.Document
    public DocumentType getDocType() {
        return this.docType;
    }

    @Override // org.dom4j.Document
    public void setDocType(DocumentType documentType) {
        this.docType = documentType;
    }

    @Override // org.dom4j.Document
    public Document addDocType(String str, String str2, String str3) {
        setDocType(getDocumentFactory().createDocType(str, str2, str3));
        return this;
    }

    @Override // org.dom4j.tree.AbstractDocument, org.dom4j.Document
    public String getXMLEncoding() {
        return this.encoding;
    }

    @Override // org.dom4j.Document
    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    @Override // org.dom4j.Document
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Object clone() {
        DefaultDocument defaultDocument = (DefaultDocument) super.clone();
        defaultDocument.rootElement = null;
        defaultDocument.content = null;
        defaultDocument.appendContent(this);
        return defaultDocument;
    }

    @Override // org.dom4j.Branch
    public List processingInstructions() {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof ProcessingInstruction) {
                createResultList.add(obj);
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Branch
    public List processingInstructions(String str) {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof ProcessingInstruction) {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
                if (str.equals(processingInstruction.getName())) {
                    createResultList.add(processingInstruction);
                }
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Branch
    public ProcessingInstruction processingInstruction(String str) {
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof ProcessingInstruction) {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) obj;
                if (str.equals(processingInstruction.getName())) {
                    return processingInstruction;
                }
            }
        }
        return null;
    }

    @Override // org.dom4j.Branch
    public boolean removeProcessingInstruction(String str) {
        Iterator it = contentList().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ((next instanceof ProcessingInstruction) && str.equals(((ProcessingInstruction) next).getName())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // org.dom4j.Branch
    public void setContent(List list) {
        this.rootElement = null;
        contentRemoved();
        if (list instanceof ContentListFacade) {
            list = ((ContentListFacade) list).getBackingList();
        }
        if (list == null) {
            this.content = null;
            return;
        }
        int size = list.size();
        List createContentList = createContentList(size);
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj instanceof Node) {
                Node node = (Node) obj;
                Document document = node.getDocument();
                if (document != null && document != this) {
                    node = (Node) node.clone();
                }
                if (node instanceof Element) {
                    if (this.rootElement == null) {
                        this.rootElement = (Element) node;
                    } else {
                        throw new IllegalAddException(new StringBuffer().append("A document may only contain one root element: ").append(list).toString());
                    }
                }
                createContentList.add(node);
                childAdded(node);
            }
        }
        this.content = createContentList;
    }

    @Override // org.dom4j.Branch
    public void clearContent() {
        contentRemoved();
        this.content = null;
        this.rootElement = null;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected List contentList() {
        if (this.content == null) {
            List createContentList = createContentList();
            this.content = createContentList;
            Element element = this.rootElement;
            if (element != null) {
                createContentList.add(element);
            }
        }
        return this.content;
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void addNode(Node node) {
        if (node != null) {
            Document document = node.getDocument();
            if (document != null && document != this) {
                throw new IllegalAddException(this, node, new StringBuffer().append("The Node already has an existing document: ").append(document).toString());
            }
            contentList().add(node);
            childAdded(node);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void addNode(int i, Node node) {
        if (node != null) {
            Document document = node.getDocument();
            if (document != null && document != this) {
                throw new IllegalAddException(this, node, new StringBuffer().append("The Node already has an existing document: ").append(document).toString());
            }
            contentList().add(i, node);
            childAdded(node);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected boolean removeNode(Node node) {
        if (node == this.rootElement) {
            this.rootElement = null;
        }
        if (!contentList().remove(node)) {
            return false;
        }
        childRemoved(node);
        return true;
    }

    @Override // org.dom4j.tree.AbstractDocument
    protected void rootElementAdded(Element element) {
        this.rootElement = element;
        element.setDocument(this);
    }

    @Override // org.dom4j.tree.AbstractNode
    protected DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }
}
