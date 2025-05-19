package com.bea.xml.stream;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Namespace;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class EventScanner {
    protected char currentChar;
    protected int currentLine = 0;
    private boolean readEndDocument = false;
    protected Reader reader;

    public EventScanner() {
    }

    public EventScanner(Reader reader) throws IOException {
        setReader(reader);
    }

    public void setReader(Reader reader) throws IOException {
        this.reader = reader;
        read();
        skipSpace();
    }

    protected String readString(char c) throws IOException, XMLStreamException {
        StringBuffer stringBuffer = new StringBuffer();
        while (getChar() != c) {
            if (getChar() == '[' && c == ']') {
                read();
                stringBuffer.append(PropertyUtils.INDEXED_DELIM);
                if (getChar() != ']') {
                    stringBuffer.append(readString(PropertyUtils.INDEXED_DELIM2));
                }
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
                read(PropertyUtils.INDEXED_DELIM2);
            } else {
                stringBuffer.append(getChar());
                read();
            }
        }
        return stringBuffer.toString();
    }

    protected char getChar() {
        return this.currentChar;
    }

    protected void skipSpace() throws IOException {
        while (true) {
            char c = this.currentChar;
            if (!((c == ' ') | (c == '\n') | (c == '\t')) && !(c == '\r')) {
                return;
            } else {
                read();
            }
        }
    }

    protected char read() throws IOException {
        char read = (char) this.reader.read();
        this.currentChar = read;
        if (read == '\n') {
            this.currentLine++;
        }
        return read;
    }

    protected char read(char c) throws XMLStreamException, IOException {
        if (this.currentChar == c) {
            return read();
        }
        throw new XMLStreamException(new StringBuffer().append("Unexpected character '").append(this.currentChar).append("' , expected '").append(c).append("' at line ").append(this.currentLine).toString());
    }

    protected void read(String str) throws XMLStreamException, IOException {
        for (int i = 0; i < str.length(); i++) {
            read(str.charAt(i));
        }
    }

    protected int readType() throws XMLStreamException, IOException {
        read(PropertyUtils.INDEXED_DELIM);
        int eventType = ElementTypeNames.getEventType(readString(PropertyUtils.INDEXED_DELIM2));
        read(PropertyUtils.INDEXED_DELIM2);
        return eventType;
    }

    public EventState readStartElement() throws XMLStreamException, IOException {
        EventState eventState = new EventState(1);
        read(PropertyUtils.INDEXED_DELIM);
        eventState.setName(readName());
        if (getChar() == '[') {
            for (Object obj : readAttributes()) {
                if (obj instanceof Namespace) {
                    eventState.addNamespace(obj);
                } else {
                    eventState.addAttribute(obj);
                }
            }
        }
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public EventState readEndElement() throws XMLStreamException, IOException {
        EventState eventState = new EventState(2);
        read(PropertyUtils.INDEXED_DELIM);
        eventState.setName(readName());
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public EventState readProcessingInstruction() throws XMLStreamException, IOException {
        String str;
        EventState eventState = new EventState(3);
        read(PropertyUtils.INDEXED_DELIM);
        String readString = readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        if (getChar() == ',') {
            read(",[");
            str = readString(PropertyUtils.INDEXED_DELIM2);
            read(PropertyUtils.INDEXED_DELIM2);
        } else {
            str = null;
        }
        eventState.setData(readString);
        eventState.setExtraData(str);
        return eventState;
    }

    public EventState readCharacterData() throws XMLStreamException, IOException {
        EventState eventState = new EventState(4);
        read(PropertyUtils.INDEXED_DELIM);
        eventState.setData(readString(PropertyUtils.INDEXED_DELIM2));
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public EventState readCDATA() throws XMLStreamException, IOException {
        EventState eventState = new EventState(12);
        read(PropertyUtils.INDEXED_DELIM);
        readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public EventState readStartDocument() throws XMLStreamException, IOException {
        EventState eventState = new EventState(7);
        if (getChar() != ';') {
            read(PropertyUtils.INDEXED_DELIM);
            read(PropertyUtils.INDEXED_DELIM);
            String readString = readString(PropertyUtils.INDEXED_DELIM2);
            read(PropertyUtils.INDEXED_DELIM2);
            read(',');
            read(PropertyUtils.INDEXED_DELIM);
            String readString2 = readString(PropertyUtils.INDEXED_DELIM2);
            read(PropertyUtils.INDEXED_DELIM2);
            read(PropertyUtils.INDEXED_DELIM2);
            eventState.setData(readString);
            eventState.setExtraData(readString2);
        }
        return eventState;
    }

    public EventState readDTD() throws XMLStreamException, IOException {
        EventState eventState = new EventState(11);
        read(PropertyUtils.INDEXED_DELIM);
        String readString = readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        eventState.setData(readString);
        return eventState;
    }

    public EventState readEndDocument() throws XMLStreamException {
        return new EventState(8);
    }

    public EventState readComment() throws XMLStreamException, IOException {
        EventState eventState = new EventState(5);
        read(PropertyUtils.INDEXED_DELIM);
        eventState.setData(readString(PropertyUtils.INDEXED_DELIM2));
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public String getPrefix(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public String getName(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1);
    }

    public QName readName() throws XMLStreamException, IOException {
        read(PropertyUtils.INDEXED_DELIM);
        QName readName = readName(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        return readName;
    }

    public QName readName(char c) throws XMLStreamException, IOException {
        String str;
        if (getChar() == '\'') {
            read('\'');
            str = readString('\'');
            read('\'');
            read(NameUtil.COLON);
        } else {
            str = "";
        }
        String readString = readString(c);
        String prefix = getPrefix(readString);
        return new QName(str, getName(readString), prefix != null ? prefix : "");
    }

    public List readAttributes() throws XMLStreamException, IOException {
        ArrayList arrayList = new ArrayList();
        while (getChar() == '[') {
            arrayList.add(readAttribute());
        }
        return arrayList;
    }

    public Attribute readAttribute() throws XMLStreamException, IOException {
        read(PropertyUtils.INDEXED_DELIM);
        read(PropertyUtils.INDEXED_DELIM);
        String readString = readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        QName readName = readName();
        read("=[");
        String readString2 = readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        if (readString.equals("ATTRIBUTE")) {
            return new AttributeBase(readName, readString2);
        }
        if (readString.equals("DEFAULT")) {
            return new NamespaceBase(readString2);
        }
        if (readString.equals("NAMESPACE")) {
            return new NamespaceBase(readName.getLocalPart(), readString2);
        }
        throw new XMLStreamException("Parser Error expected (ATTRIBUTE||DEFAULT|NAMESPACE");
    }

    public EventState readEntityReference() throws XMLStreamException, IOException {
        EventState eventState = new EventState(9);
        read(PropertyUtils.INDEXED_DELIM);
        eventState.setData(readString(PropertyUtils.INDEXED_DELIM2));
        read(PropertyUtils.INDEXED_DELIM2);
        return eventState;
    }

    public EventState readSpace() throws XMLStreamException, IOException {
        EventState eventState = new EventState(6);
        read(PropertyUtils.INDEXED_DELIM);
        String readString = readString(PropertyUtils.INDEXED_DELIM2);
        read(PropertyUtils.INDEXED_DELIM2);
        eventState.setData(readString);
        return eventState;
    }

    public EventState readElement() throws XMLStreamException, IOException {
        EventState readStartElement;
        int readType = readType();
        switch (readType) {
            case 1:
                readStartElement = readStartElement();
                break;
            case 2:
                readStartElement = readEndElement();
                break;
            case 3:
                readStartElement = readProcessingInstruction();
                break;
            case 4:
                readStartElement = readCharacterData();
                break;
            case 5:
                readStartElement = readComment();
                break;
            case 6:
                readStartElement = readSpace();
                break;
            case 7:
                readStartElement = readStartDocument();
                break;
            case 8:
                this.readEndDocument = true;
                readStartElement = readEndDocument();
                break;
            case 9:
                readStartElement = readEntityReference();
                break;
            case 10:
            default:
                throw new XMLStreamException(new StringBuffer().append("Attempt to read unknown element [").append(readType).append("]").toString());
            case 11:
                readStartElement = readDTD();
                break;
            case 12:
                readStartElement = readCDATA();
                break;
        }
        read(';');
        skipSpace();
        return readStartElement;
    }

    public boolean endDocumentIsPresent() {
        return this.readEndDocument;
    }

    public boolean hasNext() throws IOException {
        return this.reader.ready() && !this.readEndDocument;
    }

    public static void main(String[] strArr) throws Exception {
        EventScanner eventScanner = new EventScanner(new FileReader(strArr[0]));
        while (eventScanner.hasNext()) {
            System.out.println(eventScanner.readElement());
        }
    }
}
