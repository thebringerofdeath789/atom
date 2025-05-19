package com.bea.xml.stream.events;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class NamedEvent extends BaseEvent {
    private QName name;

    @Override // com.bea.xml.stream.events.BaseEvent
    protected abstract void doWriteAsEncodedUnicode(Writer writer) throws IOException, XMLStreamException;

    public NamedEvent() {
    }

    public NamedEvent(QName qName) {
        this.name = qName;
    }

    public NamedEvent(String str) {
        this.name = new QName(str);
    }

    public NamedEvent(String str, String str2, String str3) {
        this.name = new QName(str2, str3, str);
    }

    public QName getName() {
        return this.name;
    }

    public void setName(QName qName) {
        this.name = qName;
    }

    public String nameAsString() {
        if ("".equals(this.name.getNamespaceURI())) {
            return this.name.getLocalPart();
        }
        if (this.name.getPrefix() != null && !this.name.getPrefix().equals("")) {
            return new StringBuffer().append("['").append(this.name.getNamespaceURI()).append("']:").append(this.name.getPrefix()).append(":").append(this.name.getLocalPart()).toString();
        }
        return new StringBuffer().append("['").append(this.name.getNamespaceURI()).append("']:").append(this.name.getLocalPart()).toString();
    }
}
