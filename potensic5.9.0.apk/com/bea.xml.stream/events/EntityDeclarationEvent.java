package com.bea.xml.stream.events;

import aavax.xml.stream.events.EntityDeclaration;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class EntityDeclarationEvent extends BaseEvent implements EntityDeclaration {
    protected final String name;
    protected final String replacementText;

    @Override // aavax.xml.stream.events.EntityDeclaration
    public String getBaseURI() {
        return null;
    }

    @Override // aavax.xml.stream.events.EntityDeclaration
    public String getNotationName() {
        return null;
    }

    @Override // com.bea.xml.stream.events.BaseEvent, aavax.xml.stream.Location
    public String getPublicId() {
        return null;
    }

    @Override // com.bea.xml.stream.events.BaseEvent, aavax.xml.stream.Location
    public String getSystemId() {
        return null;
    }

    public EntityDeclarationEvent(String str, String str2) {
        super(15);
        this.name = str;
        this.replacementText = str2;
    }

    @Override // aavax.xml.stream.events.EntityDeclaration
    public String getReplacementText() {
        return this.replacementText;
    }

    @Override // aavax.xml.stream.events.EntityDeclaration
    public String getName() {
        return this.name;
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) throws IOException {
        writer.write("<!ENTITY ");
        writer.write(getName());
        writer.write(34);
        writer.write(getReplacementText());
        writer.write("\">");
    }
}