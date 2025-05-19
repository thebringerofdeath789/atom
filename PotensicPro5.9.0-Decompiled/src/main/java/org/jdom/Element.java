package org.jdom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;

/* loaded from: classes5.dex */
public class Element extends Content implements Parent {
    private static final String CVS_ID = "@(#) $RCSfile: Element.java,v $ $Revision: 1.152 $ $Date: 2004/09/03 06:35:39 $ $Name: jdom_1_0 $";
    private static final int INITIAL_ARRAY_SIZE = 5;
    protected transient List additionalNamespaces;
    AttributeList attributes;
    ContentList content;
    protected String name;
    protected transient Namespace namespace;

    protected Element() {
        this.attributes = new AttributeList(this);
        this.content = new ContentList(this);
    }

    public Element(String str, Namespace namespace) {
        this.attributes = new AttributeList(this);
        this.content = new ContentList(this);
        setName(str);
        setNamespace(namespace);
    }

    public Element(String str) {
        this(str, (Namespace) null);
    }

    public Element(String str, String str2) {
        this(str, Namespace.getNamespace("", str2));
    }

    public Element(String str, String str2, String str3) {
        this(str, Namespace.getNamespace(str2, str3));
    }

    public String getName() {
        return this.name;
    }

    public Element setName(String str) {
        String checkElementName = Verifier.checkElementName(str);
        if (checkElementName != null) {
            throw new IllegalNameException(str, "element", checkElementName);
        }
        this.name = str;
        return this;
    }

    public Namespace getNamespace() {
        return this.namespace;
    }

    public Element setNamespace(Namespace namespace) {
        if (namespace == null) {
            namespace = Namespace.NO_NAMESPACE;
        }
        this.namespace = namespace;
        return this;
    }

    public String getNamespacePrefix() {
        return this.namespace.getPrefix();
    }

    public String getNamespaceURI() {
        return this.namespace.getURI();
    }

    public Namespace getNamespace(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("xml")) {
            return Namespace.XML_NAMESPACE;
        }
        if (str.equals(getNamespacePrefix())) {
            return getNamespace();
        }
        if (this.additionalNamespaces != null) {
            for (int i = 0; i < this.additionalNamespaces.size(); i++) {
                Namespace namespace = (Namespace) this.additionalNamespaces.get(i);
                if (str.equals(namespace.getPrefix())) {
                    return namespace;
                }
            }
        }
        if (this.parent instanceof Element) {
            return ((Element) this.parent).getNamespace(str);
        }
        return null;
    }

    public String getQualifiedName() {
        if (this.namespace.getPrefix().equals("")) {
            return getName();
        }
        return new StringBuffer(this.namespace.getPrefix()).append(NameUtil.COLON).append(this.name).toString();
    }

    public void addNamespaceDeclaration(Namespace namespace) {
        String checkNamespaceCollision = Verifier.checkNamespaceCollision(namespace, this);
        if (checkNamespaceCollision != null) {
            throw new IllegalAddException(this, namespace, checkNamespaceCollision);
        }
        if (this.additionalNamespaces == null) {
            this.additionalNamespaces = new ArrayList(5);
        }
        this.additionalNamespaces.add(namespace);
    }

    public void removeNamespaceDeclaration(Namespace namespace) {
        List list = this.additionalNamespaces;
        if (list == null) {
            return;
        }
        list.remove(namespace);
    }

    public List getAdditionalNamespaces() {
        List list = this.additionalNamespaces;
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(list);
    }

    @Override // org.jdom.Content
    public String getValue() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Content content : getContent()) {
            if ((content instanceof Element) || (content instanceof Text)) {
                stringBuffer.append(content.getValue());
            }
        }
        return stringBuffer.toString();
    }

    public boolean isRootElement() {
        return this.parent instanceof Document;
    }

    @Override // org.jdom.Parent
    public int getContentSize() {
        return this.content.size();
    }

    @Override // org.jdom.Parent
    public int indexOf(Content content) {
        return this.content.indexOf(content);
    }

    public String getText() {
        if (this.content.size() == 0) {
            return "";
        }
        if (this.content.size() == 1) {
            Object obj = this.content.get(0);
            return obj instanceof Text ? ((Text) obj).getText() : "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        for (int i = 0; i < this.content.size(); i++) {
            Object obj2 = this.content.get(i);
            if (obj2 instanceof Text) {
                stringBuffer.append(((Text) obj2).getText());
                z = true;
            }
        }
        return !z ? "" : stringBuffer.toString();
    }

    public String getTextTrim() {
        return getText().trim();
    }

    public String getTextNormalize() {
        return Text.normalizeString(getText());
    }

    public String getChildText(String str) {
        Element child = getChild(str);
        if (child == null) {
            return null;
        }
        return child.getText();
    }

    public String getChildTextTrim(String str) {
        Element child = getChild(str);
        if (child == null) {
            return null;
        }
        return child.getTextTrim();
    }

    public String getChildTextNormalize(String str) {
        Element child = getChild(str);
        if (child == null) {
            return null;
        }
        return child.getTextNormalize();
    }

    public String getChildText(String str, Namespace namespace) {
        Element child = getChild(str, namespace);
        if (child == null) {
            return null;
        }
        return child.getText();
    }

    public String getChildTextTrim(String str, Namespace namespace) {
        Element child = getChild(str, namespace);
        if (child == null) {
            return null;
        }
        return child.getTextTrim();
    }

    public String getChildTextNormalize(String str, Namespace namespace) {
        Element child = getChild(str, namespace);
        if (child == null) {
            return null;
        }
        return child.getTextNormalize();
    }

    public Element setText(String str) {
        this.content.clear();
        if (str != null) {
            addContent(new Text(str));
        }
        return this;
    }

    @Override // org.jdom.Parent
    public List getContent() {
        return this.content;
    }

    @Override // org.jdom.Parent
    public List getContent(Filter filter) {
        return this.content.getView(filter);
    }

    @Override // org.jdom.Parent
    public List removeContent() {
        ArrayList arrayList = new ArrayList(this.content);
        this.content.clear();
        return arrayList;
    }

    @Override // org.jdom.Parent
    public List removeContent(Filter filter) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.content.getView(filter).iterator();
        while (it.hasNext()) {
            arrayList.add((Content) it.next());
            it.remove();
        }
        return arrayList;
    }

    public Element setContent(Collection collection) {
        this.content.clearAndSet(collection);
        return this;
    }

    public Element setContent(int i, Content content) {
        this.content.set(i, content);
        return this;
    }

    public Parent setContent(int i, Collection collection) {
        this.content.remove(i);
        this.content.addAll(i, collection);
        return this;
    }

    public Element addContent(String str) {
        return addContent(new Text(str));
    }

    public Element addContent(Content content) {
        this.content.add(content);
        return this;
    }

    public Element addContent(Collection collection) {
        this.content.addAll(collection);
        return this;
    }

    public Element addContent(int i, Content content) {
        this.content.add(i, content);
        return this;
    }

    public Element addContent(int i, Collection collection) {
        this.content.addAll(i, collection);
        return this;
    }

    @Override // org.jdom.Parent
    public List cloneContent() {
        int contentSize = getContentSize();
        ArrayList arrayList = new ArrayList(contentSize);
        for (int i = 0; i < contentSize; i++) {
            arrayList.add(getContent(i).clone());
        }
        return arrayList;
    }

    @Override // org.jdom.Parent
    public Content getContent(int i) {
        return (Content) this.content.get(i);
    }

    @Override // org.jdom.Parent
    public boolean removeContent(Content content) {
        return this.content.remove(content);
    }

    @Override // org.jdom.Parent
    public Content removeContent(int i) {
        return (Content) this.content.remove(i);
    }

    public Element setContent(Content content) {
        this.content.clear();
        this.content.add(content);
        return this;
    }

    public boolean isAncestor(Element element) {
        for (Parent parent = element.getParent(); parent instanceof Element; parent = ((Element) parent).getParent()) {
            if (parent == this) {
                return true;
            }
        }
        return false;
    }

    public List getAttributes() {
        return this.attributes;
    }

    public Attribute getAttribute(String str) {
        return getAttribute(str, Namespace.NO_NAMESPACE);
    }

    public Attribute getAttribute(String str, Namespace namespace) {
        return (Attribute) this.attributes.get(str, namespace);
    }

    public String getAttributeValue(String str) {
        return getAttributeValue(str, Namespace.NO_NAMESPACE);
    }

    public String getAttributeValue(String str, String str2) {
        return getAttributeValue(str, Namespace.NO_NAMESPACE, str2);
    }

    public String getAttributeValue(String str, Namespace namespace) {
        return getAttributeValue(str, namespace, null);
    }

    public String getAttributeValue(String str, Namespace namespace, String str2) {
        Attribute attribute = (Attribute) this.attributes.get(str, namespace);
        return attribute == null ? str2 : attribute.getValue();
    }

    public Element setAttributes(List list) {
        this.attributes.clearAndSet(list);
        return this;
    }

    public Element setAttribute(String str, String str2) {
        return setAttribute(new Attribute(str, str2));
    }

    public Element setAttribute(String str, String str2, Namespace namespace) {
        return setAttribute(new Attribute(str, str2, namespace));
    }

    public Element setAttribute(Attribute attribute) {
        this.attributes.add(attribute);
        return this;
    }

    public boolean removeAttribute(String str) {
        return removeAttribute(str, Namespace.NO_NAMESPACE);
    }

    public boolean removeAttribute(String str, Namespace namespace) {
        return this.attributes.remove(str, namespace);
    }

    public boolean removeAttribute(Attribute attribute) {
        return this.attributes.remove(attribute);
    }

    public String toString() {
        StringBuffer append = new StringBuffer(64).append("[Element: <").append(getQualifiedName());
        String namespaceURI = getNamespaceURI();
        if (!namespaceURI.equals("")) {
            append.append(" [Namespace: ").append(namespaceURI).append("]");
        }
        append.append("/>]");
        return append.toString();
    }

    @Override // org.jdom.Content, org.jdom.Parent
    public Object clone() {
        Element element = (Element) super.clone();
        element.content = new ContentList(element);
        element.attributes = new AttributeList(element);
        if (this.attributes != null) {
            for (int i = 0; i < this.attributes.size(); i++) {
                element.attributes.add((Attribute) ((Attribute) this.attributes.get(i)).clone());
            }
        }
        List list = this.additionalNamespaces;
        if (list != null) {
            int size = list.size();
            element.additionalNamespaces = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                element.additionalNamespaces.add(this.additionalNamespaces.get(i2));
            }
        }
        if (this.content != null) {
            for (int i3 = 0; i3 < this.content.size(); i3++) {
                Object obj = this.content.get(i3);
                if (obj instanceof Element) {
                    element.content.add((Element) ((Element) obj).clone());
                } else if (obj instanceof CDATA) {
                    element.content.add((CDATA) ((CDATA) obj).clone());
                } else if (obj instanceof Text) {
                    element.content.add((Text) ((Text) obj).clone());
                } else if (obj instanceof Comment) {
                    element.content.add((Comment) ((Comment) obj).clone());
                } else if (obj instanceof ProcessingInstruction) {
                    element.content.add((ProcessingInstruction) ((ProcessingInstruction) obj).clone());
                } else if (obj instanceof EntityRef) {
                    element.content.add((EntityRef) ((EntityRef) obj).clone());
                }
            }
        }
        if (this.additionalNamespaces != null) {
            ArrayList arrayList = new ArrayList();
            element.additionalNamespaces = arrayList;
            arrayList.addAll(this.additionalNamespaces);
        }
        return element;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.namespace.getPrefix());
        objectOutputStream.writeObject(this.namespace.getURI());
        List list = this.additionalNamespaces;
        if (list == null) {
            objectOutputStream.write(0);
            return;
        }
        int size = list.size();
        objectOutputStream.write(size);
        for (int i = 0; i < size; i++) {
            Namespace namespace = (Namespace) this.additionalNamespaces.get(i);
            objectOutputStream.writeObject(namespace.getPrefix());
            objectOutputStream.writeObject(namespace.getURI());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        int read = objectInputStream.read();
        if (read != 0) {
            this.additionalNamespaces = new ArrayList(read);
            for (int i = 0; i < read; i++) {
                this.additionalNamespaces.add(Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject()));
            }
        }
    }

    @Override // org.jdom.Parent
    public Iterator getDescendants() {
        return new DescendantIterator(this);
    }

    @Override // org.jdom.Parent
    public Iterator getDescendants(Filter filter) {
        return new FilterIterator(new DescendantIterator(this), filter);
    }

    public List getChildren() {
        return this.content.getView(new ElementFilter());
    }

    public List getChildren(String str) {
        return getChildren(str, Namespace.NO_NAMESPACE);
    }

    public List getChildren(String str, Namespace namespace) {
        return this.content.getView(new ElementFilter(str, namespace));
    }

    public Element getChild(String str, Namespace namespace) {
        Iterator it = this.content.getView(new ElementFilter(str, namespace)).iterator();
        if (it.hasNext()) {
            return (Element) it.next();
        }
        return null;
    }

    public Element getChild(String str) {
        return getChild(str, Namespace.NO_NAMESPACE);
    }

    public boolean removeChild(String str) {
        return removeChild(str, Namespace.NO_NAMESPACE);
    }

    public boolean removeChild(String str, Namespace namespace) {
        Iterator it = this.content.getView(new ElementFilter(str, namespace)).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        it.remove();
        return true;
    }

    public boolean removeChildren(String str) {
        return removeChildren(str, Namespace.NO_NAMESPACE);
    }

    public boolean removeChildren(String str, Namespace namespace) {
        Iterator it = this.content.getView(new ElementFilter(str, namespace)).iterator();
        boolean z = false;
        while (it.hasNext()) {
            it.next();
            it.remove();
            z = true;
        }
        return z;
    }
}
