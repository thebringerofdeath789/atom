package com.bea.xml.stream.filters;

import aavax.xml.namespace.QName;
import aavax.xml.stream.EventFilter;
import aavax.xml.stream.StreamFilter;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.EndElement;
import aavax.xml.stream.events.StartElement;
import aavax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public class NameFilter implements EventFilter, StreamFilter {
    private QName name;

    public NameFilter(QName qName) {
        this.name = qName;
    }

    @Override // aavax.xml.stream.EventFilter
    public boolean accept(XMLEvent xMLEvent) {
        QName name;
        if (!xMLEvent.isStartElement() && !xMLEvent.isEndElement()) {
            return false;
        }
        if (xMLEvent.isStartElement()) {
            name = ((StartElement) xMLEvent).getName();
        } else {
            name = ((EndElement) xMLEvent).getName();
        }
        return this.name.equals(name);
    }

    @Override // aavax.xml.stream.StreamFilter
    public boolean accept(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.isStartElement() || xMLStreamReader.isEndElement()) {
            return this.name.equals(new QName(xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName()));
        }
        return false;
    }
}