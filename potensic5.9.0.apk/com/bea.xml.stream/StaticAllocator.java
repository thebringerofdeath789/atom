package com.bea.xml.stream;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Characters;
import aavax.xml.stream.events.Comment;
import aavax.xml.stream.events.DTD;
import aavax.xml.stream.events.EndDocument;
import aavax.xml.stream.events.EndElement;
import aavax.xml.stream.events.EntityReference;
import aavax.xml.stream.events.Namespace;
import aavax.xml.stream.events.ProcessingInstruction;
import aavax.xml.stream.events.StartDocument;
import aavax.xml.stream.events.StartElement;
import aavax.xml.stream.events.XMLEvent;
import aavax.xml.stream.util.XMLEventAllocator;
import aavax.xml.stream.util.XMLEventConsumer;
import com.bea.xml.stream.events.CharactersEvent;
import com.bea.xml.stream.events.CommentEvent;
import com.bea.xml.stream.events.DTDEvent;
import com.bea.xml.stream.events.EndDocumentEvent;
import com.bea.xml.stream.events.EndElementEvent;
import com.bea.xml.stream.events.EntityReferenceEvent;
import com.bea.xml.stream.events.ProcessingInstructionEvent;
import com.bea.xml.stream.events.StartDocumentEvent;
import com.bea.xml.stream.events.StartElementEvent;
import com.bea.xml.stream.util.ElementTypeNames;
import java.util.Iterator;

/* loaded from: classes.dex */
public class StaticAllocator implements XMLEventAllocator {
    public static final String FEATURE_STAX_ENTITIES = "aavax.xml.stream.entities";
    public static final String FEATURE_STAX_NOTATIONS = "aavax.xml.stream.notations";
    StartElementEvent startElement = new StartElementEvent();
    EndElementEvent endElement = new EndElementEvent();
    CharactersEvent characters = new CharactersEvent();
    CharactersEvent cData = new CharactersEvent("", true);
    CharactersEvent space = new CharactersEvent();
    CommentEvent comment = new CommentEvent();
    EntityReferenceEvent entity = new EntityReferenceEvent();

    /* renamed from: pi */
    ProcessingInstructionEvent f1791pi = new ProcessingInstructionEvent();
    StartDocumentEvent startDoc = new StartDocumentEvent();
    EndDocumentEvent endDoc = new EndDocumentEvent();
    DTDEvent dtd = new DTDEvent();

    public String toString() {
        return "Static Allocator";
    }

    @Override // aavax.xml.stream.util.XMLEventAllocator
    public XMLEventAllocator newInstance() {
        return new StaticAllocator();
    }

    public StartElement allocateStartElement(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.startElement.reset();
        this.startElement.setName(new QName(xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), EventFactory.checkPrefix(xMLStreamReader.getPrefix())));
        Iterator attributes = XMLEventAllocatorBase.getAttributes(xMLStreamReader);
        while (attributes.hasNext()) {
            this.startElement.addAttribute((Attribute) attributes.next());
        }
        Iterator namespaces = XMLEventAllocatorBase.getNamespaces(xMLStreamReader);
        while (namespaces.hasNext()) {
            this.startElement.addAttribute((Namespace) namespaces.next());
        }
        return this.startElement;
    }

    public EndElement allocateEndElement(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.endElement.reset();
        this.endElement.setName(new QName(xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), EventFactory.checkPrefix(xMLStreamReader.getPrefix())));
        Iterator namespaces = XMLEventAllocatorBase.getNamespaces(xMLStreamReader);
        while (namespaces.hasNext()) {
            this.endElement.addNamespace((Namespace) namespaces.next());
        }
        return this.endElement;
    }

    public Characters allocateCharacters(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.characters.setData(xMLStreamReader.getText());
        return this.characters;
    }

    public Characters allocateCData(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.cData.setData(xMLStreamReader.getText());
        return this.cData;
    }

    public Characters allocateSpace(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.space.setSpace(true);
        this.space.setData(xMLStreamReader.getText());
        return this.space;
    }

    public EntityReference allocateEntityReference(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.entity.setName(xMLStreamReader.getLocalName());
        this.entity.setReplacementText(xMLStreamReader.getText());
        return this.entity;
    }

    public ProcessingInstruction allocatePI(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.f1791pi.setTarget(xMLStreamReader.getPITarget());
        this.f1791pi.setData(xMLStreamReader.getPIData());
        return this.f1791pi;
    }

    public Comment allocateComment(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.comment.setData(xMLStreamReader.getText());
        return this.comment;
    }

    public StartDocument allocateStartDocument(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        allocateXMLDeclaration(xMLStreamReader);
        return this.startDoc;
    }

    public EndDocument allocateEndDocument(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        return this.endDoc;
    }

    public DTD allocateDTD(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.dtd.setDTD(xMLStreamReader.getText());
        return this.dtd;
    }

    public StartDocument allocateXMLDeclaration(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        this.startDoc.clear();
        String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
        String version = xMLStreamReader.getVersion();
        boolean isStandalone = xMLStreamReader.isStandalone();
        if (characterEncodingScheme != null && version != null && !isStandalone) {
            this.startDoc.setEncoding(characterEncodingScheme);
            this.startDoc.setVersion(version);
            this.startDoc.setStandalone(isStandalone);
            return this.startDoc;
        }
        if (version != null && characterEncodingScheme != null) {
            this.startDoc.setEncoding(characterEncodingScheme);
            this.startDoc.setVersion(version);
            return this.startDoc;
        }
        if (characterEncodingScheme != null) {
            this.startDoc.setEncoding(characterEncodingScheme);
        }
        return this.startDoc;
    }

    @Override // aavax.xml.stream.util.XMLEventAllocator
    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        switch (xMLStreamReader.getEventType()) {
            case 1:
                return allocateStartElement(xMLStreamReader);
            case 2:
                return allocateEndElement(xMLStreamReader);
            case 3:
                return allocatePI(xMLStreamReader);
            case 4:
                return allocateCharacters(xMLStreamReader);
            case 5:
                return allocateComment(xMLStreamReader);
            case 6:
                return allocateCharacters(xMLStreamReader);
            case 7:
                return allocateStartDocument(xMLStreamReader);
            case 8:
                return allocateEndDocument(xMLStreamReader);
            case 9:
                return allocateEntityReference(xMLStreamReader);
            case 10:
            default:
                throw new XMLStreamException(new StringBuffer().append("Unable to allocate event[").append(ElementTypeNames.getEventTypeString(xMLStreamReader.getEventType())).append("]").toString());
            case 11:
                return allocateDTD(xMLStreamReader);
            case 12:
                return allocateCData(xMLStreamReader);
        }
    }

    @Override // aavax.xml.stream.util.XMLEventAllocator
    public void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException {
        xMLEventConsumer.add(allocate(xMLStreamReader));
    }
}