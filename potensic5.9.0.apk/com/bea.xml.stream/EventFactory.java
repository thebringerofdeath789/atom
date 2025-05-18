package com.bea.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLEventFactory;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Characters;
import aavax.xml.stream.events.Comment;
import aavax.xml.stream.events.DTD;
import aavax.xml.stream.events.EndDocument;
import aavax.xml.stream.events.EndElement;
import aavax.xml.stream.events.EntityDeclaration;
import aavax.xml.stream.events.EntityReference;
import aavax.xml.stream.events.Namespace;
import aavax.xml.stream.events.ProcessingInstruction;
import aavax.xml.stream.events.StartDocument;
import aavax.xml.stream.events.StartElement;
import com.bea.xml.stream.events.CharactersEvent;
import com.bea.xml.stream.events.CommentEvent;
import com.bea.xml.stream.events.DTDEvent;
import com.bea.xml.stream.events.EndDocumentEvent;
import com.bea.xml.stream.events.EndElementEvent;
import com.bea.xml.stream.events.EntityReferenceEvent;
import com.bea.xml.stream.events.ProcessingInstructionEvent;
import com.bea.xml.stream.events.StartDocumentEvent;
import com.bea.xml.stream.events.StartElementEvent;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public class EventFactory extends XMLEventFactory {
    private Location location;

    public static String checkPrefix(String str) {
        return str == null ? "" : str;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Attribute createAttribute(QName qName, String str) {
        return new AttributeBase(qName, str);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Attribute createAttribute(String str, String str2) {
        return new AttributeBase("", str, str2);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Attribute createAttribute(String str, String str2, String str3, String str4) {
        return new AttributeBase(str, str2, str3, str4, "CDATA");
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Namespace createNamespace(String str) {
        return new NamespaceBase(str);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Namespace createNamespace(String str, String str2) {
        Objects.requireNonNull(str, "The prefix of a namespace may not be set to null");
        return new NamespaceBase(str, str2);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartElement createStartElement(QName qName, Iterator it, Iterator it2) {
        StartElementEvent startElementEvent = new StartElementEvent(qName);
        while (it != null && it.hasNext()) {
            startElementEvent.addAttribute((Attribute) it.next());
        }
        while (it2 != null && it2.hasNext()) {
            startElementEvent.addNamespace((Namespace) it2.next());
        }
        return startElementEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3) {
        return new StartElementEvent(new QName(str2, str3, str));
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2) {
        StartElementEvent startElementEvent = new StartElementEvent(new QName(str2, str3, checkPrefix(str)));
        while (it != null && it.hasNext()) {
            startElementEvent.addAttribute((Attribute) it.next());
        }
        while (it2 != null && it2.hasNext()) {
            startElementEvent.addNamespace((Namespace) it2.next());
        }
        return startElementEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext) {
        StartElementEvent startElementEvent = new StartElementEvent(new QName(str2, str3, checkPrefix(str)));
        while (it != null && it.hasNext()) {
            startElementEvent.addAttribute((Attribute) it.next());
        }
        while (it2 != null && it2.hasNext()) {
            startElementEvent.addNamespace((Namespace) it2.next());
        }
        startElementEvent.setNamespaceContext(namespaceContext);
        return startElementEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public EndElement createEndElement(QName qName, Iterator it) {
        EndElementEvent endElementEvent = new EndElementEvent(qName);
        while (it != null && it.hasNext()) {
            endElementEvent.addNamespace((Namespace) it.next());
        }
        return endElementEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public EndElement createEndElement(String str, String str2, String str3) {
        return new EndElementEvent(new QName(str2, str3, checkPrefix(str)));
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public EndElement createEndElement(String str, String str2, String str3, Iterator it) {
        EndElementEvent endElementEvent = new EndElementEvent(new QName(str2, str3, checkPrefix(str)));
        while (it.hasNext()) {
            endElementEvent.addNamespace((Namespace) it.next());
        }
        return endElementEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Characters createCharacters(String str) {
        return new CharactersEvent(str);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Characters createCData(String str) {
        return new CharactersEvent(str, true);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument() {
        return new StartDocumentEvent();
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str, String str2, boolean z) {
        StartDocumentEvent startDocumentEvent = new StartDocumentEvent();
        startDocumentEvent.setEncoding(str);
        startDocumentEvent.setVersion(str2);
        startDocumentEvent.setStandalone(z);
        return startDocumentEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str, String str2) {
        StartDocumentEvent startDocumentEvent = new StartDocumentEvent();
        startDocumentEvent.setEncoding(str);
        startDocumentEvent.setVersion(str2);
        return startDocumentEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str) {
        StartDocumentEvent startDocumentEvent = new StartDocumentEvent();
        startDocumentEvent.setEncoding(str);
        return startDocumentEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public EndDocument createEndDocument() {
        return new EndDocumentEvent();
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration) {
        return new EntityReferenceEvent(str, entityDeclaration);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Characters createSpace(String str) {
        CharactersEvent charactersEvent = new CharactersEvent(str);
        charactersEvent.setSpace(true);
        return charactersEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Characters createIgnorableSpace(String str) {
        CharactersEvent charactersEvent = new CharactersEvent(str);
        charactersEvent.setSpace(true);
        charactersEvent.setIgnorable(true);
        return charactersEvent;
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public Comment createComment(String str) {
        return new CommentEvent(str);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new ProcessingInstructionEvent(str, str2);
    }

    @Override // aavax.xml.stream.XMLEventFactory
    public DTD createDTD(String str) {
        return new DTDEvent(str);
    }
}