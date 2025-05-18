package com.bea.xml.stream.events;

import aavax.xml.stream.events.EndDocument;
import java.io.Writer;

/* loaded from: classes.dex */
public class EndDocumentEvent extends BaseEvent implements EndDocument {
    @Override // com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) {
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    public String toString() {
        return "<? EndDocument ?>";
    }

    public EndDocumentEvent() {
        init();
    }

    protected void init() {
        setEventType(8);
    }
}