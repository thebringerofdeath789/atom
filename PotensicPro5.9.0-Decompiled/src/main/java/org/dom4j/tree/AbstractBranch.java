package org.dom4j.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Branch;
import org.dom4j.Comment;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;

/* loaded from: classes5.dex */
public abstract class AbstractBranch extends AbstractNode implements Branch {
    protected static final int DEFAULT_CONTENT_LIST_SIZE = 5;

    protected abstract void addNode(int i, Node node);

    protected abstract void addNode(Node node);

    protected abstract void childAdded(Node node);

    protected abstract void childRemoved(Node node);

    protected abstract List contentList();

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    protected abstract boolean removeNode(Node node);

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean hasContent() {
        return nodeCount() > 0;
    }

    @Override // org.dom4j.Branch
    public List content() {
        return new ContentListFacade(this, contentList());
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        List contentList = contentList();
        if (contentList == null) {
            return "";
        }
        int size = contentList.size();
        if (size < 1) {
            return "";
        }
        String contentAsText = getContentAsText(contentList.get(0));
        if (size == 1) {
            return contentAsText;
        }
        StringBuffer stringBuffer = new StringBuffer(contentAsText);
        for (int i = 1; i < size; i++) {
            stringBuffer.append(getContentAsText(contentList.get(i)));
        }
        return stringBuffer.toString();
    }

    protected String getContentAsText(Object obj) {
        if (!(obj instanceof Node)) {
            return obj instanceof String ? (String) obj : "";
        }
        Node node = (Node) obj;
        short nodeType = node.getNodeType();
        return (nodeType == 3 || nodeType == 4 || nodeType == 5) ? node.getText() : "";
    }

    protected String getContentAsStringValue(Object obj) {
        if (!(obj instanceof Node)) {
            return obj instanceof String ? (String) obj : "";
        }
        Node node = (Node) obj;
        short nodeType = node.getNodeType();
        return (nodeType == 1 || nodeType == 3 || nodeType == 4 || nodeType == 5) ? node.getStringValue() : "";
    }

    public String getTextTrim() {
        String text = getText();
        StringBuffer stringBuffer = new StringBuffer();
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken());
            if (stringTokenizer.hasMoreTokens()) {
                stringBuffer.append(StringUtils.SPACE);
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.dom4j.Branch
    public void setProcessingInstructions(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            addNode((ProcessingInstruction) it.next());
        }
    }

    @Override // org.dom4j.Branch
    public Element addElement(String str) {
        Element createElement = getDocumentFactory().createElement(str);
        add(createElement);
        return createElement;
    }

    @Override // org.dom4j.Branch
    public Element addElement(String str, String str2) {
        Element createElement = getDocumentFactory().createElement(str, str2);
        add(createElement);
        return createElement;
    }

    @Override // org.dom4j.Branch
    public Element addElement(QName qName) {
        Element createElement = getDocumentFactory().createElement(qName);
        add(createElement);
        return createElement;
    }

    public Element addElement(String str, String str2, String str3) {
        return addElement(getDocumentFactory().createQName(str, Namespace.get(str2, str3)));
    }

    @Override // org.dom4j.Branch
    public void add(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            add((Element) node);
            return;
        }
        if (nodeType == 7) {
            add((ProcessingInstruction) node);
        } else if (nodeType == 8) {
            add((Comment) node);
        } else {
            invalidNodeTypeAddException(node);
        }
    }

    @Override // org.dom4j.Branch
    public boolean remove(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            return remove((Element) node);
        }
        if (nodeType == 7) {
            return remove((ProcessingInstruction) node);
        }
        if (nodeType == 8) {
            return remove((Comment) node);
        }
        invalidNodeTypeAddException(node);
        return false;
    }

    @Override // org.dom4j.Branch
    public void add(Comment comment) {
        addNode(comment);
    }

    @Override // org.dom4j.Branch
    public void add(Element element) {
        addNode(element);
    }

    @Override // org.dom4j.Branch
    public void add(ProcessingInstruction processingInstruction) {
        addNode(processingInstruction);
    }

    @Override // org.dom4j.Branch
    public boolean remove(Comment comment) {
        return removeNode(comment);
    }

    @Override // org.dom4j.Branch
    public boolean remove(Element element) {
        return removeNode(element);
    }

    @Override // org.dom4j.Branch
    public boolean remove(ProcessingInstruction processingInstruction) {
        return removeNode(processingInstruction);
    }

    @Override // org.dom4j.Branch
    public Element elementByID(String str) {
        int nodeCount = nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            Node node = node(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String elementID = elementID(element);
                if (elementID != null && elementID.equals(str)) {
                    return element;
                }
                Element elementByID = element.elementByID(str);
                if (elementByID != null) {
                    return elementByID;
                }
            }
        }
        return null;
    }

    @Override // org.dom4j.Branch
    public void appendContent(Branch branch) {
        int nodeCount = branch.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            add((Node) branch.node(i).clone());
        }
    }

    @Override // org.dom4j.Branch
    public Node node(int i) {
        Object obj = contentList().get(i);
        if (obj instanceof Node) {
            return (Node) obj;
        }
        if (obj instanceof String) {
            return getDocumentFactory().createText(obj.toString());
        }
        return null;
    }

    @Override // org.dom4j.Branch
    public int nodeCount() {
        return contentList().size();
    }

    @Override // org.dom4j.Branch
    public int indexOf(Node node) {
        return contentList().indexOf(node);
    }

    @Override // org.dom4j.Branch
    public Iterator nodeIterator() {
        return contentList().iterator();
    }

    protected String elementID(Element element) {
        return element.attributeValue("ID");
    }

    protected List createContentList() {
        return new ArrayList(5);
    }

    protected List createContentList(int i) {
        return new ArrayList(i);
    }

    protected BackedList createResultList() {
        return new BackedList(this, contentList());
    }

    protected List createSingleResultList(Object obj) {
        BackedList backedList = new BackedList(this, contentList(), 1);
        backedList.addLocal(obj);
        return backedList;
    }

    protected List createEmptyList() {
        return new BackedList(this, contentList(), 0);
    }

    protected void contentRemoved() {
        List contentList = contentList();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            Object obj = contentList.get(i);
            if (obj instanceof Node) {
                childRemoved((Node) obj);
            }
        }
    }

    protected void invalidNodeTypeAddException(Node node) {
        throw new IllegalAddException(new StringBuffer().append("Invalid node type. Cannot add node: ").append(node).append(" to this branch: ").append(this).toString());
    }
}
