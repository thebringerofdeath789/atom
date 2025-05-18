package com.bea.xml.stream.events;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Namespace;
import aavax.xml.stream.events.StartElement;
import aavax.xml.stream.events.XMLEvent;
import com.bea.xml.stream.util.EmptyIterator;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class StartElementEvent extends NamedEvent implements StartElement {
    private List attributes;
    private NamespaceContext context;
    private List namespaces;

    public StartElementEvent() {
    }

    public StartElementEvent(QName qName) {
        super(qName);
        init();
    }

    public void reset() {
        List list = this.attributes;
        if (list != null) {
            list.clear();
        }
        List list2 = this.namespaces;
        if (list2 != null) {
            list2.clear();
        }
        if (this.context != null) {
            this.context = null;
        }
    }

    public StartElementEvent(StartElement startElement) {
        super(startElement.getName());
        init();
        setName(startElement.getName());
        Iterator attributes = startElement.getAttributes();
        while (attributes.hasNext()) {
            addAttribute((Attribute) attributes.next());
        }
        startElement.getNamespaces();
        Iterator namespaces = startElement.getNamespaces();
        while (namespaces.hasNext()) {
            addNamespace((Namespace) namespaces.next());
        }
    }

    protected void init() {
        setEventType(1);
    }

    @Override // aavax.xml.stream.events.StartElement
    public Iterator getAttributes() {
        List list = this.attributes;
        return list == null ? EmptyIterator.emptyIterator : list.iterator();
    }

    @Override // aavax.xml.stream.events.StartElement
    public Iterator getNamespaces() {
        List list = this.namespaces;
        return list == null ? EmptyIterator.emptyIterator : list.iterator();
    }

    @Override // aavax.xml.stream.events.StartElement
    public Attribute getAttributeByName(QName qName) {
        if (qName == null) {
            return null;
        }
        Iterator attributes = getAttributes();
        while (attributes.hasNext()) {
            Attribute attribute = (Attribute) attributes.next();
            if (attribute.getName().equals(qName)) {
                return attribute;
            }
        }
        return null;
    }

    public void setAttributes(List list) {
        this.attributes = list;
    }

    public void addAttribute(Attribute attribute) {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
        }
        this.attributes.add(attribute);
    }

    public void addNamespace(Namespace namespace) {
        if (this.namespaces == null) {
            this.namespaces = new ArrayList();
        }
        this.namespaces.add(namespace);
    }

    @Override // aavax.xml.stream.events.StartElement
    public String getNamespaceURI(String str) {
        NamespaceContext namespaceContext = this.context;
        if (namespaceContext == null) {
            return null;
        }
        return namespaceContext.getNamespaceURI(str);
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) {
        this.context = namespaceContext;
    }

    @Override // aavax.xml.stream.events.StartElement
    public NamespaceContext getNamespaceContext() {
        return this.context;
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    public String toString() {
        String stringBuffer = new StringBuffer().append("<").append(nameAsString()).toString();
        Iterator attributes = getAttributes();
        while (attributes.hasNext()) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(StringUtils.SPACE).append(attributes.next().toString()).toString();
        }
        Iterator namespaces = getNamespaces();
        while (namespaces.hasNext()) {
            stringBuffer = new StringBuffer().append(stringBuffer).append(StringUtils.SPACE).append(namespaces.next().toString()).toString();
        }
        return new StringBuffer().append(stringBuffer).append(">").toString();
    }

    @Override // com.bea.xml.stream.events.NamedEvent, com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException {
        writer.write(60);
        QName name = getName();
        String prefix = name.getPrefix();
        if (prefix != null && prefix.length() > 0) {
            writer.write(prefix);
            writer.write(58);
        }
        writer.write(name.getLocalPart());
        Iterator namespaces = getNamespaces();
        while (namespaces.hasNext()) {
            writer.write(32);
            ((XMLEvent) namespaces.next()).writeAsEncodedUnicode(writer);
        }
        Iterator attributes = getAttributes();
        while (attributes.hasNext()) {
            writer.write(32);
            ((XMLEvent) attributes.next()).writeAsEncodedUnicode(writer);
        }
        writer.write(62);
    }
}