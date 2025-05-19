package com.bea.xml.stream;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLEventWriter;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamWriter;
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
import aavax.xml.stream.util.XMLEventConsumer;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public class XMLEventWriterBase implements XMLEventWriter, XMLEventConsumer {
    XMLStreamWriter writer;

    public void addEndDocument(EndDocument endDocument) throws XMLStreamException {
    }

    public XMLEventWriterBase(XMLStreamWriter xMLStreamWriter) {
        this.writer = xMLStreamWriter;
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void flush() throws XMLStreamException {
        this.writer.flush();
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void close() throws XMLStreamException {
        this.writer.close();
    }

    private void addStartElement(StartElement startElement) throws XMLStreamException {
        String prefix = startElement.getName().getPrefix();
        String namespaceURI = startElement.getName().getNamespaceURI();
        this.writer.writeStartElement(prefix, startElement.getName().getLocalPart(), namespaceURI);
        Iterator namespaces = startElement.getNamespaces();
        while (namespaces.hasNext()) {
            writeNamespace((Namespace) namespaces.next());
        }
        Iterator attributes = startElement.getAttributes();
        while (attributes.hasNext()) {
            writeAttribute((Attribute) attributes.next());
        }
    }

    private void addEndElement(EndElement endElement) throws XMLStreamException {
        endElement.getName().getPrefix();
        endElement.getName().getNamespaceURI();
        endElement.getName().getLocalPart();
        this.writer.writeEndElement();
    }

    public void addCharacters(Characters characters) throws XMLStreamException {
        if (characters.isCData()) {
            this.writer.writeCData(characters.getData());
        } else {
            this.writer.writeCharacters(characters.getData());
        }
    }

    public void addEntityReference(EntityReference entityReference) throws XMLStreamException {
        this.writer.writeEntityRef(entityReference.getName());
    }

    public void addProcessingInstruction(ProcessingInstruction processingInstruction) throws XMLStreamException {
        this.writer.writeProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
    }

    public void addComment(Comment comment) throws XMLStreamException {
        this.writer.writeComment(comment.getText());
    }

    public void addStartDocument(StartDocument startDocument) throws XMLStreamException {
        String characterEncodingScheme = startDocument.getCharacterEncodingScheme();
        String version = startDocument.getVersion();
        startDocument.isStandalone();
        this.writer.writeStartDocument(characterEncodingScheme, version);
    }

    private void writeAttribute(Attribute attribute) throws XMLStreamException {
        this.writer.writeAttribute(attribute.getName().getNamespaceURI(), attribute.getName().getLocalPart(), attribute.getValue());
    }

    public void addAttribute(Attribute attribute) throws XMLStreamException {
        writeAttribute(attribute);
    }

    public void writeNamespace(Namespace namespace) throws XMLStreamException {
        if (namespace.isDefaultNamespaceDeclaration()) {
            this.writer.writeDefaultNamespace(namespace.getNamespaceURI());
        } else {
            this.writer.writeNamespace(namespace.getPrefix(), namespace.getNamespaceURI());
        }
    }

    public void addNamespace(Namespace namespace) throws XMLStreamException {
        writeNamespace(namespace);
    }

    public void addDTD(DTD dtd) throws XMLStreamException {
        this.writer.writeDTD(dtd.getDocumentTypeDeclaration());
    }

    @Override // aavax.xml.stream.XMLEventWriter, aavax.xml.stream.util.XMLEventConsumer
    public void add(XMLEvent xMLEvent) throws XMLStreamException {
        switch (xMLEvent.getEventType()) {
            case 1:
                addStartElement((StartElement) xMLEvent);
                return;
            case 2:
                addEndElement((EndElement) xMLEvent);
                return;
            case 3:
                addProcessingInstruction((ProcessingInstruction) xMLEvent);
                return;
            case 4:
                addCharacters((Characters) xMLEvent);
                return;
            case 5:
                addComment((Comment) xMLEvent);
                return;
            case 6:
            case 12:
            default:
                throw new XMLStreamException(new StringBuffer().append("Unable to add event[").append(ElementTypeNames.getEventTypeString(xMLEvent.getEventType())).append("]").toString());
            case 7:
                addStartDocument((StartDocument) xMLEvent);
                return;
            case 8:
                addEndDocument((EndDocument) xMLEvent);
                return;
            case 9:
                addEntityReference((EntityReference) xMLEvent);
                return;
            case 10:
                addAttribute((Attribute) xMLEvent);
                return;
            case 11:
                addDTD((DTD) xMLEvent);
                return;
            case 13:
                addNamespace((Namespace) xMLEvent);
                return;
        }
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void add(XMLEventReader xMLEventReader) throws XMLStreamException {
        while (xMLEventReader.hasNext()) {
            add(xMLEventReader.nextEvent());
        }
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public String getPrefix(String str) throws XMLStreamException {
        return this.writer.getPrefix(str);
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void setPrefix(String str, String str2) throws XMLStreamException {
        this.writer.setPrefix(str, str2);
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void setDefaultNamespace(String str) throws XMLStreamException {
        this.writer.setDefaultNamespace(str);
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.writer.setNamespaceContext(namespaceContext);
    }

    @Override // aavax.xml.stream.XMLEventWriter
    public NamespaceContext getNamespaceContext() {
        return this.writer.getNamespaceContext();
    }

    public static void main(String[] strArr) throws Exception {
        System.setProperty("aavax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        System.setProperty("aavax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
        XMLEventWriterBase xMLEventWriterBase = new XMLEventWriterBase(new XMLWriterBase(new OutputStreamWriter(System.out)));
        MXParser mXParser = new MXParser();
        mXParser.setConfigurationContext(new ConfigurationContextBase());
        mXParser.setInput(new FileReader(strArr[0]));
        XMLEventReaderBase xMLEventReaderBase = new XMLEventReaderBase(mXParser);
        while (xMLEventReaderBase.hasNext()) {
            XMLEvent nextEvent = xMLEventReaderBase.nextEvent();
            System.out.println(new StringBuffer().append("about to add:[").append(nextEvent).append("];").toString());
            xMLEventWriterBase.add(nextEvent);
        }
        xMLEventWriterBase.flush();
    }
}
