package com.bea.xml.stream.events;

import aavax.xml.stream.events.EntityDeclaration;
import aavax.xml.stream.events.EntityReference;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class EntityReferenceEvent extends BaseEvent implements EntityReference {

    /* renamed from: ed */
    private EntityDeclaration f1792ed;
    private String name;
    private String replacementText;

    public String getBaseURI() {
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

    public EntityReferenceEvent() {
        init();
    }

    public EntityReferenceEvent(String str, EntityDeclaration entityDeclaration) {
        init();
        this.name = str;
        this.f1792ed = entityDeclaration;
    }

    public String getReplacementText() {
        return this.f1792ed.getReplacementText();
    }

    @Override // aavax.xml.stream.events.EntityReference
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReplacementText(String str) {
        this.replacementText = str;
    }

    @Override // aavax.xml.stream.events.EntityReference
    public EntityDeclaration getDeclaration() {
        return this.f1792ed;
    }

    protected void init() {
        setEventType(9);
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) throws IOException {
        writer.write(38);
        writer.write(getName());
        writer.write(59);
    }

    @Override // com.bea.xml.stream.events.BaseEvent
    public String toString() {
        String replacementText = getReplacementText();
        if (replacementText == null) {
            replacementText = "";
        }
        return new StringBuffer().append("&").append(getName()).append(":='").append(replacementText).append("'").toString();
    }
}