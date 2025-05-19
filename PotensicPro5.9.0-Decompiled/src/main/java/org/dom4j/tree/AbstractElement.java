package org.dom4j.tree;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.CharacterData;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.IllegalAddException;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Text;
import org.dom4j.Visitor;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;

/* loaded from: classes5.dex */
public abstract class AbstractElement extends AbstractBranch implements Element {
    private static final DocumentFactory DOCUMENT_FACTORY = DocumentFactory.getInstance();
    protected static final Iterator EMPTY_ITERATOR;
    protected static final List EMPTY_LIST;
    protected static final boolean USE_STRINGVALUE_SEPARATOR = false;
    protected static final boolean VERBOSE_TOSTRING = false;

    protected abstract List attributeList();

    protected abstract List attributeList(int i);

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 1;
    }

    public void setData(Object obj) {
    }

    static {
        List list = Collections.EMPTY_LIST;
        EMPTY_LIST = list;
        EMPTY_ITERATOR = list.iterator();
    }

    @Override // org.dom4j.Element
    public boolean isRootElement() {
        Document document = getDocument();
        return document != null && document.getRootElement() == this;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        setQName(getDocumentFactory().createQName(str));
    }

    public void setNamespace(Namespace namespace) {
        setQName(getDocumentFactory().createQName(getName(), namespace));
    }

    public String getXPathNameStep() {
        String namespaceURI = getNamespaceURI();
        if (namespaceURI == null || namespaceURI.length() == 0) {
            return getName();
        }
        String namespacePrefix = getNamespacePrefix();
        if (namespacePrefix == null || namespacePrefix.length() == 0) {
            return new StringBuffer().append("*[name()='").append(getName()).append("']").toString();
        }
        return getQualifiedName();
    }

    @Override // org.dom4j.Node
    public String getPath(Element element) {
        if (this == element) {
            return ".";
        }
        Element parent = getParent();
        if (parent == null) {
            return new StringBuffer().append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(getXPathNameStep()).toString();
        }
        if (parent == element) {
            return getXPathNameStep();
        }
        return new StringBuffer().append(parent.getPath(element)).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(getXPathNameStep()).toString();
    }

    @Override // org.dom4j.Node
    public String getUniquePath(Element element) {
        int indexOf;
        Element parent = getParent();
        if (parent == null) {
            return new StringBuffer().append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(getXPathNameStep()).toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (parent != element) {
            stringBuffer.append(parent.getUniquePath(element));
            stringBuffer.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
        }
        stringBuffer.append(getXPathNameStep());
        List elements = parent.elements(getQName());
        if (elements.size() > 1 && (indexOf = elements.indexOf(this)) >= 0) {
            stringBuffer.append("[");
            stringBuffer.append(Integer.toString(indexOf + 1));
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        try {
            StringWriter stringWriter = new StringWriter();
            XMLWriter xMLWriter = new XMLWriter(stringWriter, new OutputFormat());
            xMLWriter.write((Element) this);
            xMLWriter.flush();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(new StringBuffer().append("IOException while generating textual representation: ").append(e.getMessage()).toString());
        }
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        new XMLWriter(writer, new OutputFormat()).write((Element) this);
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
        int attributeCount = attributeCount();
        for (int i = 0; i < attributeCount; i++) {
            visitor.visit(attribute(i));
        }
        int nodeCount = nodeCount();
        for (int i2 = 0; i2 < nodeCount; i2++) {
            node(i2).accept(visitor);
        }
    }

    public String toString() {
        String namespaceURI = getNamespaceURI();
        if (namespaceURI != null && namespaceURI.length() > 0) {
            return new StringBuffer().append(super.toString()).append(" [Element: <").append(getQualifiedName()).append(" uri: ").append(namespaceURI).append(" attributes: ").append(attributeList()).append("/>]").toString();
        }
        return new StringBuffer().append(super.toString()).append(" [Element: <").append(getQualifiedName()).append(" attributes: ").append(attributeList()).append("/>]").toString();
    }

    @Override // org.dom4j.Element
    public Namespace getNamespace() {
        return getQName().getNamespace();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getQName().getName();
    }

    @Override // org.dom4j.Element
    public String getNamespacePrefix() {
        return getQName().getNamespacePrefix();
    }

    public String getNamespaceURI() {
        return getQName().getNamespaceURI();
    }

    @Override // org.dom4j.Element
    public String getQualifiedName() {
        return getQName().getQualifiedName();
    }

    public Object getData() {
        return getText();
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Node node(int i) {
        Object obj;
        if (i >= 0) {
            List contentList = contentList();
            if (i < contentList.size() && (obj = contentList.get(i)) != null) {
                if (obj instanceof Node) {
                    return (Node) obj;
                }
                return getDocumentFactory().createText(obj.toString());
            }
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public int indexOf(Node node) {
        return contentList().indexOf(node);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public int nodeCount() {
        return contentList().size();
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Iterator nodeIterator() {
        return contentList().iterator();
    }

    @Override // org.dom4j.Element
    public Element element(String str) {
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                Element element = (Element) obj;
                if (str.equals(element.getName())) {
                    return element;
                }
            }
        }
        return null;
    }

    @Override // org.dom4j.Element
    public Element element(QName qName) {
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                Element element = (Element) obj;
                if (qName.equals(element.getQName())) {
                    return element;
                }
            }
        }
        return null;
    }

    public Element element(String str, Namespace namespace) {
        return element(getDocumentFactory().createQName(str, namespace));
    }

    @Override // org.dom4j.Element
    public List elements() {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                createResultList.addLocal(obj);
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Element
    public List elements(String str) {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                Element element = (Element) obj;
                if (str.equals(element.getName())) {
                    createResultList.addLocal(element);
                }
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Element
    public List elements(QName qName) {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Element) {
                Element element = (Element) obj;
                if (qName.equals(element.getQName())) {
                    createResultList.addLocal(element);
                }
            }
        }
        return createResultList;
    }

    public List elements(String str, Namespace namespace) {
        return elements(getDocumentFactory().createQName(str, namespace));
    }

    @Override // org.dom4j.Element
    public Iterator elementIterator() {
        return elements().iterator();
    }

    @Override // org.dom4j.Element
    public Iterator elementIterator(String str) {
        return elements(str).iterator();
    }

    @Override // org.dom4j.Element
    public Iterator elementIterator(QName qName) {
        return elements(qName).iterator();
    }

    public Iterator elementIterator(String str, Namespace namespace) {
        return elementIterator(getDocumentFactory().createQName(str, namespace));
    }

    @Override // org.dom4j.Element
    public List attributes() {
        return new ContentListFacade(this, attributeList());
    }

    @Override // org.dom4j.Element
    public Iterator attributeIterator() {
        return attributeList().iterator();
    }

    @Override // org.dom4j.Element
    public Attribute attribute(int i) {
        return (Attribute) attributeList().get(i);
    }

    @Override // org.dom4j.Element
    public int attributeCount() {
        return attributeList().size();
    }

    public Attribute attribute(String str) {
        List attributeList = attributeList();
        int size = attributeList.size();
        for (int i = 0; i < size; i++) {
            Attribute attribute = (Attribute) attributeList.get(i);
            if (str.equals(attribute.getName())) {
                return attribute;
            }
        }
        return null;
    }

    public Attribute attribute(QName qName) {
        List attributeList = attributeList();
        int size = attributeList.size();
        for (int i = 0; i < size; i++) {
            Attribute attribute = (Attribute) attributeList.get(i);
            if (qName.equals(attribute.getQName())) {
                return attribute;
            }
        }
        return null;
    }

    public Attribute attribute(String str, Namespace namespace) {
        return attribute(getDocumentFactory().createQName(str, namespace));
    }

    public void setAttributes(Attributes attributes, NamespaceStack namespaceStack, boolean z) {
        int length = attributes.getLength();
        if (length > 0) {
            DocumentFactory documentFactory = getDocumentFactory();
            if (length == 1) {
                String qName = attributes.getQName(0);
                if (z || !qName.startsWith("xmlns")) {
                    String uri = attributes.getURI(0);
                    String localName = attributes.getLocalName(0);
                    add(documentFactory.createAttribute(this, namespaceStack.getAttributeQName(uri, localName, qName), attributes.getValue(0)));
                    return;
                }
                return;
            }
            List attributeList = attributeList(length);
            attributeList.clear();
            for (int i = 0; i < length; i++) {
                String qName2 = attributes.getQName(i);
                if (z || !qName2.startsWith("xmlns")) {
                    String uri2 = attributes.getURI(i);
                    String localName2 = attributes.getLocalName(i);
                    Attribute createAttribute = documentFactory.createAttribute(this, namespaceStack.getAttributeQName(uri2, localName2, qName2), attributes.getValue(i));
                    attributeList.add(createAttribute);
                    childAdded(createAttribute);
                }
            }
        }
    }

    @Override // org.dom4j.Element
    public String attributeValue(String str) {
        Attribute attribute = attribute(str);
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override // org.dom4j.Element
    public String attributeValue(QName qName) {
        Attribute attribute = attribute(qName);
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override // org.dom4j.Element
    public String attributeValue(String str, String str2) {
        String attributeValue = attributeValue(str);
        return attributeValue != null ? attributeValue : str2;
    }

    @Override // org.dom4j.Element
    public String attributeValue(QName qName, String str) {
        String attributeValue = attributeValue(qName);
        return attributeValue != null ? attributeValue : str;
    }

    @Override // org.dom4j.Element
    public void setAttributeValue(String str, String str2) {
        addAttribute(str, str2);
    }

    @Override // org.dom4j.Element
    public void setAttributeValue(QName qName, String str) {
        addAttribute(qName, str);
    }

    @Override // org.dom4j.Element
    public void add(Attribute attribute) {
        if (attribute.getParent() != null) {
            throw new IllegalAddException((Element) this, (Node) attribute, new StringBuffer().append("The Attribute already has an existing parent \"").append(attribute.getParent().getQualifiedName()).append("\"").toString());
        }
        if (attribute.getValue() == null) {
            Attribute attribute2 = attribute(attribute.getQName());
            if (attribute2 != null) {
                remove(attribute2);
                return;
            }
            return;
        }
        attributeList().add(attribute);
        childAdded(attribute);
    }

    @Override // org.dom4j.Element
    public boolean remove(Attribute attribute) {
        List attributeList = attributeList();
        boolean remove = attributeList.remove(attribute);
        if (remove) {
            childRemoved(attribute);
            return remove;
        }
        Attribute attribute2 = attribute(attribute.getQName());
        if (attribute2 == null) {
            return remove;
        }
        attributeList.remove(attribute2);
        return true;
    }

    @Override // org.dom4j.Branch
    public List processingInstructions() {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof ProcessingInstruction) {
                createResultList.addLocal(obj);
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
                    createResultList.addLocal(processingInstruction);
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

    @Override // org.dom4j.Element
    public Node getXPathResult(int i) {
        Node node = node(i);
        return (node == null || node.supportsParent()) ? node : node.asXPathResult(this);
    }

    public Element addAttribute(String str, String str2) {
        Attribute attribute = attribute(str);
        if (str2 != null) {
            if (attribute == null) {
                add(getDocumentFactory().createAttribute(this, str, str2));
            } else if (attribute.isReadOnly()) {
                remove(attribute);
                add(getDocumentFactory().createAttribute(this, str, str2));
            } else {
                attribute.setValue(str2);
            }
        } else if (attribute != null) {
            remove(attribute);
        }
        return this;
    }

    public Element addAttribute(QName qName, String str) {
        Attribute attribute = attribute(qName);
        if (str != null) {
            if (attribute == null) {
                add(getDocumentFactory().createAttribute(this, qName, str));
            } else if (attribute.isReadOnly()) {
                remove(attribute);
                add(getDocumentFactory().createAttribute(this, qName, str));
            } else {
                attribute.setValue(str);
            }
        } else if (attribute != null) {
            remove(attribute);
        }
        return this;
    }

    @Override // org.dom4j.Element
    public Element addCDATA(String str) {
        addNewNode(getDocumentFactory().createCDATA(str));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addComment(String str) {
        addNewNode(getDocumentFactory().createComment(str));
        return this;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Element addElement(String str) {
        Namespace namespaceForPrefix;
        String str2;
        Element createElement;
        DocumentFactory documentFactory = getDocumentFactory();
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
            namespaceForPrefix = getNamespaceForPrefix(substring);
            if (namespaceForPrefix == null) {
                throw new IllegalAddException(new StringBuffer().append("No such namespace prefix: ").append(substring).append(" is in scope on: ").append(this).append(" so cannot add element: ").append(str).toString());
            }
        } else {
            namespaceForPrefix = getNamespaceForPrefix("");
            str2 = str;
        }
        if (namespaceForPrefix != null) {
            createElement = documentFactory.createElement(documentFactory.createQName(str2, namespaceForPrefix));
        } else {
            createElement = documentFactory.createElement(str);
        }
        addNewNode(createElement);
        return createElement;
    }

    @Override // org.dom4j.Element
    public Element addEntity(String str, String str2) {
        addNewNode(getDocumentFactory().createEntity(str, str2));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addNamespace(String str, String str2) {
        addNewNode(getDocumentFactory().createNamespace(str, str2));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addProcessingInstruction(String str, String str2) {
        addNewNode(getDocumentFactory().createProcessingInstruction(str, str2));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addProcessingInstruction(String str, Map map) {
        addNewNode(getDocumentFactory().createProcessingInstruction(str, map));
        return this;
    }

    public Element addText(String str) {
        addNewNode(getDocumentFactory().createText(str));
        return this;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public void add(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            add((Element) node);
            return;
        }
        if (nodeType == 2) {
            add((Attribute) node);
            return;
        }
        if (nodeType == 3) {
            add((Text) node);
            return;
        }
        if (nodeType == 4) {
            add((CDATA) node);
            return;
        }
        if (nodeType == 5) {
            add((Entity) node);
            return;
        }
        if (nodeType == 7) {
            add((ProcessingInstruction) node);
            return;
        }
        if (nodeType == 8) {
            add((Comment) node);
        } else if (nodeType == 13) {
            add((Namespace) node);
        } else {
            invalidNodeTypeAddException(node);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public boolean remove(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            return remove((Element) node);
        }
        if (nodeType == 2) {
            return remove((Attribute) node);
        }
        if (nodeType == 3) {
            return remove((Text) node);
        }
        if (nodeType == 4) {
            return remove((CDATA) node);
        }
        if (nodeType == 5) {
            return remove((Entity) node);
        }
        if (nodeType == 7) {
            return remove((ProcessingInstruction) node);
        }
        if (nodeType == 8) {
            return remove((Comment) node);
        }
        if (nodeType != 13) {
            return false;
        }
        return remove((Namespace) node);
    }

    @Override // org.dom4j.Element
    public void add(CDATA cdata) {
        addNode(cdata);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public void add(Comment comment) {
        addNode(comment);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public void add(Element element) {
        addNode(element);
    }

    @Override // org.dom4j.Element
    public void add(Entity entity) {
        addNode(entity);
    }

    @Override // org.dom4j.Element
    public void add(Namespace namespace) {
        addNode(namespace);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public void add(ProcessingInstruction processingInstruction) {
        addNode(processingInstruction);
    }

    @Override // org.dom4j.Element
    public void add(Text text) {
        addNode(text);
    }

    @Override // org.dom4j.Element
    public boolean remove(CDATA cdata) {
        return removeNode(cdata);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public boolean remove(Comment comment) {
        return removeNode(comment);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public boolean remove(Element element) {
        return removeNode(element);
    }

    @Override // org.dom4j.Element
    public boolean remove(Entity entity) {
        return removeNode(entity);
    }

    @Override // org.dom4j.Element
    public boolean remove(Namespace namespace) {
        return removeNode(namespace);
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public boolean remove(ProcessingInstruction processingInstruction) {
        return removeNode(processingInstruction);
    }

    @Override // org.dom4j.Element
    public boolean remove(Text text) {
        return removeNode(text);
    }

    @Override // org.dom4j.Element
    public boolean hasMixedContent() {
        List contentList = contentList();
        if (contentList != null && !contentList.isEmpty() && contentList.size() >= 2) {
            Class<?> cls = null;
            Iterator it = contentList.iterator();
            while (it.hasNext()) {
                Class<?> cls2 = it.next().getClass();
                if (cls2 != cls) {
                    if (cls != null) {
                        return true;
                    }
                    cls = cls2;
                }
            }
        }
        return false;
    }

    @Override // org.dom4j.Element
    public boolean isTextOnly() {
        List contentList = contentList();
        if (contentList != null && !contentList.isEmpty()) {
            for (Object obj : contentList) {
                if (!(obj instanceof CharacterData) && !(obj instanceof String)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setText(String str) {
        List contentList = contentList();
        if (contentList != null) {
            Iterator it = contentList.iterator();
            while (it.hasNext()) {
                short nodeType = ((Node) it.next()).getNodeType();
                if (nodeType == 3 || nodeType == 4 || nodeType == 5) {
                    it.remove();
                }
            }
        }
        addText(str);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getStringValue() {
        List contentList = contentList();
        int size = contentList.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return getContentAsStringValue(contentList.get(0));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            String contentAsStringValue = getContentAsStringValue(contentList.get(i));
            if (contentAsStringValue.length() > 0) {
                stringBuffer.append(contentAsStringValue);
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.dom4j.Branch
    public void normalize() {
        List contentList = contentList();
        int i = 0;
        while (true) {
            Text text = null;
            while (i < contentList.size()) {
                Node node = (Node) contentList.get(i);
                if (node instanceof Text) {
                    Text text2 = (Text) node;
                    if (text != null) {
                        text.appendText(text2.getText());
                        remove(text2);
                    } else {
                        String text3 = text2.getText();
                        if (text3 == null || text3.length() <= 0) {
                            remove(text2);
                        } else {
                            i++;
                            text = text2;
                        }
                    }
                } else {
                    if (node instanceof Element) {
                        ((Element) node).normalize();
                    }
                    i++;
                }
            }
            return;
        }
    }

    @Override // org.dom4j.Element
    public String elementText(String str) {
        Element element = element(str);
        if (element != null) {
            return element.getText();
        }
        return null;
    }

    @Override // org.dom4j.Element
    public String elementText(QName qName) {
        Element element = element(qName);
        if (element != null) {
            return element.getText();
        }
        return null;
    }

    @Override // org.dom4j.Element
    public String elementTextTrim(String str) {
        Element element = element(str);
        if (element != null) {
            return element.getTextTrim();
        }
        return null;
    }

    @Override // org.dom4j.Element
    public String elementTextTrim(QName qName) {
        Element element = element(qName);
        if (element != null) {
            return element.getTextTrim();
        }
        return null;
    }

    @Override // org.dom4j.Element
    public void appendAttributes(Element element) {
        int attributeCount = element.attributeCount();
        for (int i = 0; i < attributeCount; i++) {
            Attribute attribute = element.attribute(i);
            if (attribute.supportsParent()) {
                addAttribute(attribute.getQName(), attribute.getValue());
            } else {
                add(attribute);
            }
        }
    }

    @Override // org.dom4j.Element
    public Element createCopy() {
        Element createElement = createElement(getQName());
        createElement.appendAttributes(this);
        createElement.appendContent(this);
        return createElement;
    }

    @Override // org.dom4j.Element
    public Element createCopy(String str) {
        Element createElement = createElement(str);
        createElement.appendAttributes(this);
        createElement.appendContent(this);
        return createElement;
    }

    @Override // org.dom4j.Element
    public Element createCopy(QName qName) {
        Element createElement = createElement(qName);
        createElement.appendAttributes(this);
        createElement.appendContent(this);
        return createElement;
    }

    @Override // org.dom4j.Element
    public QName getQName(String str) {
        String str2;
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            str2 = "";
        }
        Namespace namespaceForPrefix = getNamespaceForPrefix(str2);
        if (namespaceForPrefix != null) {
            return getDocumentFactory().createQName(str, namespaceForPrefix);
        }
        return getDocumentFactory().createQName(str);
    }

    @Override // org.dom4j.Element
    public Namespace getNamespaceForPrefix(String str) {
        Namespace namespaceForPrefix;
        if (str == null) {
            str = "";
        }
        if (str.equals(getNamespacePrefix())) {
            return getNamespace();
        }
        if (str.equals("xml")) {
            return Namespace.XML_NAMESPACE;
        }
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Namespace) {
                Namespace namespace = (Namespace) obj;
                if (str.equals(namespace.getPrefix())) {
                    return namespace;
                }
            }
        }
        Element parent = getParent();
        if (parent != null && (namespaceForPrefix = parent.getNamespaceForPrefix(str)) != null) {
            return namespaceForPrefix;
        }
        if (str == null || str.length() <= 0) {
            return Namespace.NO_NAMESPACE;
        }
        return null;
    }

    @Override // org.dom4j.Element
    public Namespace getNamespaceForURI(String str) {
        if (str == null || str.length() <= 0) {
            return Namespace.NO_NAMESPACE;
        }
        if (str.equals(getNamespaceURI())) {
            return getNamespace();
        }
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Namespace) {
                Namespace namespace = (Namespace) obj;
                if (str.equals(namespace.getURI())) {
                    return namespace;
                }
            }
        }
        return null;
    }

    @Override // org.dom4j.Element
    public List getNamespacesForURI(String str) {
        BackedList createResultList = createResultList();
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if ((obj instanceof Namespace) && ((Namespace) obj).getURI().equals(str)) {
                createResultList.addLocal(obj);
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Element
    public List declaredNamespaces() {
        BackedList createResultList = createResultList();
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Namespace) {
                createResultList.addLocal(obj);
            }
        }
        return createResultList;
    }

    @Override // org.dom4j.Element
    public List additionalNamespaces() {
        List contentList = contentList();
        int size = contentList.size();
        BackedList createResultList = createResultList();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Namespace) {
                Namespace namespace = (Namespace) obj;
                if (!namespace.equals(getNamespace())) {
                    createResultList.addLocal(namespace);
                }
            }
        }
        return createResultList;
    }

    public List additionalNamespaces(String str) {
        List contentList = contentList();
        BackedList createResultList = createResultList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Namespace) {
                Namespace namespace = (Namespace) obj;
                if (!str.equals(namespace.getURI())) {
                    createResultList.addLocal(namespace);
                }
            }
        }
        return createResultList;
    }

    public void ensureAttributesCapacity(int i) {
        if (i > 1) {
            List attributeList = attributeList();
            if (attributeList instanceof ArrayList) {
                ((ArrayList) attributeList).ensureCapacity(i);
            }
        }
    }

    protected Element createElement(String str) {
        return getDocumentFactory().createElement(str);
    }

    protected Element createElement(QName qName) {
        return getDocumentFactory().createElement(qName);
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void addNode(Node node) {
        if (node.getParent() != null) {
            throw new IllegalAddException((Element) this, node, new StringBuffer().append("The Node already has an existing parent of \"").append(node.getParent().getQualifiedName()).append("\"").toString());
        }
        addNewNode(node);
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void addNode(int i, Node node) {
        if (node.getParent() != null) {
            throw new IllegalAddException((Element) this, node, new StringBuffer().append("The Node already has an existing parent of \"").append(node.getParent().getQualifiedName()).append("\"").toString());
        }
        addNewNode(i, node);
    }

    protected void addNewNode(Node node) {
        contentList().add(node);
        childAdded(node);
    }

    protected void addNewNode(int i, Node node) {
        contentList().add(i, node);
        childAdded(node);
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected boolean removeNode(Node node) {
        boolean remove = contentList().remove(node);
        if (remove) {
            childRemoved(node);
        }
        return remove;
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void childAdded(Node node) {
        if (node != null) {
            node.setParent(this);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected void childRemoved(Node node) {
        if (node != null) {
            node.setParent(null);
            node.setDocument(null);
        }
    }

    @Override // org.dom4j.tree.AbstractNode
    protected DocumentFactory getDocumentFactory() {
        DocumentFactory documentFactory;
        QName qName = getQName();
        return (qName == null || (documentFactory = qName.getDocumentFactory()) == null) ? DOCUMENT_FACTORY : documentFactory;
    }

    protected List createAttributeList() {
        return createAttributeList(5);
    }

    protected List createAttributeList(int i) {
        return new ArrayList(i);
    }

    protected Iterator createSingleIterator(Object obj) {
        return new SingleIterator(obj);
    }
}
