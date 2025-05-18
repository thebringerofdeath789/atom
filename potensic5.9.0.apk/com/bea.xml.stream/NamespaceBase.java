package com.bea.xml.stream;

import aavax.xml.stream.events.Namespace;
import org.apache.xmlbeans.impl.common.Sax2Dom;

/* loaded from: classes.dex */
public class NamespaceBase extends AttributeBase implements Namespace {
    boolean declaresDefaultNamespace;

    @Override // com.bea.xml.stream.AttributeBase, aavax.xml.stream.events.XMLEvent
    public int getEventType() {
        return 13;
    }

    @Override // com.bea.xml.stream.AttributeBase, aavax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return false;
    }

    @Override // com.bea.xml.stream.AttributeBase, aavax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return true;
    }

    public NamespaceBase(String str, String str2) {
        super("xmlns", str, str2);
        this.declaresDefaultNamespace = false;
        this.declaresDefaultNamespace = false;
    }

    public NamespaceBase(String str) {
        super("xmlns", "", str);
        this.declaresDefaultNamespace = false;
        this.declaresDefaultNamespace = true;
    }

    @Override // aavax.xml.stream.events.Namespace
    public String getPrefix() {
        return this.declaresDefaultNamespace ? "" : super.getLocalName();
    }

    @Override // com.bea.xml.stream.AttributeBase, aavax.xml.stream.events.Namespace
    public String getNamespaceURI() {
        return super.getValue();
    }

    @Override // aavax.xml.stream.events.Namespace
    public boolean isDefaultNamespaceDeclaration() {
        return this.declaresDefaultNamespace;
    }

    @Override // com.bea.xml.stream.AttributeBase
    public String toString() {
        if (this.declaresDefaultNamespace) {
            return new StringBuffer().append("xmlns='").append(getNamespaceURI()).append("'").toString();
        }
        return new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(getPrefix()).append("='").append(getNamespaceURI()).append("'").toString();
    }
}