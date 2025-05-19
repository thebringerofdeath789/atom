package org.apache.xmlbeans.impl.common;

import aavax.xml.stream.XMLOutputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class LoadSaveUtils {
    public static Document xmlText2GenericDom(InputStream inputStream, Document document) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        SAXParser newSAXParser = newInstance.newSAXParser();
        Sax2Dom sax2Dom = new Sax2Dom(document);
        newSAXParser.setProperty("http://xml.org/sax/properties/lexical-handler", sax2Dom);
        newSAXParser.parse(inputStream, sax2Dom);
        return (Document) sax2Dom.getDOM();
    }

    public static void xmlStreamReader2XmlText(XMLStreamReader xMLStreamReader, OutputStream outputStream) throws XMLStreamException {
        XMLStreamWriter createXMLStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
        while (xMLStreamReader.hasNext()) {
            switch (xMLStreamReader.getEventType()) {
                case 1:
                    createXMLStreamWriter.writeStartElement(xMLStreamReader.getPrefix() == null ? "" : xMLStreamReader.getPrefix(), xMLStreamReader.getLocalName(), xMLStreamReader.getNamespaceURI());
                    for (int attributeCount = xMLStreamReader.getAttributeCount() - 1; attributeCount >= 0; attributeCount--) {
                        createXMLStreamWriter.writeAttribute(xMLStreamReader.getAttributePrefix(attributeCount) == null ? "" : xMLStreamReader.getAttributePrefix(attributeCount), xMLStreamReader.getAttributeNamespace(attributeCount), xMLStreamReader.getAttributeLocalName(attributeCount), xMLStreamReader.getAttributeValue(attributeCount));
                    }
                    int namespaceCount = xMLStreamReader.getNamespaceCount();
                    for (int i = 0; i < namespaceCount; i++) {
                        createXMLStreamWriter.writeNamespace(xMLStreamReader.getNamespacePrefix(i), xMLStreamReader.getNamespaceURI(i));
                    }
                    break;
                case 2:
                    createXMLStreamWriter.writeEndElement();
                    break;
                case 3:
                    createXMLStreamWriter.writeProcessingInstruction(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    break;
                case 4:
                    createXMLStreamWriter.writeCharacters(xMLStreamReader.getText());
                    break;
                case 5:
                    createXMLStreamWriter.writeComment(xMLStreamReader.getText());
                    break;
                case 6:
                    createXMLStreamWriter.writeCharacters(xMLStreamReader.getText());
                    break;
                case 7:
                    createXMLStreamWriter.writeStartDocument();
                    break;
                case 8:
                    createXMLStreamWriter.writeEndDocument();
                    break;
                case 9:
                    createXMLStreamWriter.writeEntityRef(xMLStreamReader.getText());
                    break;
                case 10:
                    createXMLStreamWriter.writeAttribute(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), xMLStreamReader.getText());
                    break;
                case 11:
                    createXMLStreamWriter.writeDTD(xMLStreamReader.getText());
                    break;
                case 12:
                    createXMLStreamWriter.writeCData(xMLStreamReader.getText());
                    break;
                case 13:
                    createXMLStreamWriter.writeNamespace(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI());
                    break;
            }
            xMLStreamReader.next();
        }
        createXMLStreamWriter.flush();
    }
}
