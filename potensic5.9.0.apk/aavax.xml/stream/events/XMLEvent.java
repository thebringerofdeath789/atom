package aavax.xml.stream.events;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLStreamConstants;
import aavax.xml.stream.XMLStreamException;
import java.io.Writer;

/* loaded from: classes.dex */
public interface XMLEvent extends XMLStreamConstants {
    Characters asCharacters();

    EndElement asEndElement();

    StartElement asStartElement();

    int getEventType();

    Location getLocation();

    QName getSchemaType();

    boolean isAttribute();

    boolean isCharacters();

    boolean isEndDocument();

    boolean isEndElement();

    boolean isEntityReference();

    boolean isNamespace();

    boolean isProcessingInstruction();

    boolean isStartDocument();

    boolean isStartElement();

    void writeAsEncodedUnicode(Writer writer) throws XMLStreamException;
}