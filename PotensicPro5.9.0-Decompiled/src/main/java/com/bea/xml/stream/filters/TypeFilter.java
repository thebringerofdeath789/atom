package com.bea.xml.stream.filters;

import aavax.xml.stream.EventFilter;
import aavax.xml.stream.StreamFilter;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.XMLEvent;

/* loaded from: classes.dex */
public class TypeFilter implements EventFilter, StreamFilter {
    protected boolean[] types = new boolean[20];

    public void addType(int i) {
        this.types[i] = true;
    }

    @Override // aavax.xml.stream.EventFilter
    public boolean accept(XMLEvent xMLEvent) {
        return this.types[xMLEvent.getEventType()];
    }

    @Override // aavax.xml.stream.StreamFilter
    public boolean accept(XMLStreamReader xMLStreamReader) {
        return this.types[xMLStreamReader.getEventType()];
    }
}
