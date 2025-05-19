package com.bea.xml.stream;

import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;

/* loaded from: classes.dex */
public class SubReader extends ReaderDelegate {
    private int depth;
    private boolean open;

    public SubReader(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        super(xMLStreamReader);
        this.depth = 0;
        this.open = true;
        if (!xMLStreamReader.isStartElement()) {
            throw new XMLStreamException("Unable to instantiate a subReader because the underlying reader was not on a start element.");
        }
        this.open = true;
        this.depth++;
    }

    @Override // com.bea.xml.stream.ReaderDelegate, aavax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        if (this.depth <= 0) {
            this.open = false;
        }
        int next = super.next();
        if (isStartElement()) {
            this.depth++;
        }
        if (isEndElement()) {
            this.depth--;
        }
        return next;
    }

    public int nextElement() throws XMLStreamException {
        next();
        while (hasNext() && !isStartElement() && !isEndElement()) {
            next();
        }
        return super.getEventType();
    }

    @Override // com.bea.xml.stream.ReaderDelegate, aavax.xml.stream.XMLStreamReader
    public boolean hasNext() throws XMLStreamException {
        if (this.open) {
            return super.hasNext();
        }
        return false;
    }

    public boolean moveToStartElement() throws XMLStreamException {
        if (isStartElement()) {
            return true;
        }
        while (hasNext()) {
            if (isStartElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToStartElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToStartElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToStartElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public boolean moveToEndElement() throws XMLStreamException {
        if (isEndElement()) {
            return true;
        }
        while (hasNext()) {
            if (isEndElement()) {
                return true;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str) throws XMLStreamException {
        if (str == null) {
            return false;
        }
        while (moveToEndElement()) {
            if (str.equals(getLocalName())) {
                return true;
            }
            if (!hasNext()) {
                return false;
            }
            next();
        }
        return false;
    }

    public boolean moveToEndElement(String str, String str2) throws XMLStreamException {
        if (str != null && str2 != null) {
            while (moveToEndElement(str)) {
                if (str2.equals(getNamespaceURI())) {
                    return true;
                }
                if (!hasNext()) {
                    return false;
                }
                next();
            }
        }
        return false;
    }

    public static void print(XMLStreamReader xMLStreamReader, int i) throws XMLStreamException {
        System.out.print(new StringBuffer().append("[").append(i).append("]Sub: ").append(ElementTypeNames.getEventTypeString(xMLStreamReader.getEventType())).toString());
        if (xMLStreamReader.hasName()) {
            System.out.println(new StringBuffer().append("->").append(xMLStreamReader.getLocalName()).toString());
        } else if (xMLStreamReader.hasText()) {
            System.out.println(new StringBuffer().append("->[").append(xMLStreamReader.getText()).append("]").toString());
        } else {
            System.out.println();
        }
    }

    public static void sub(XMLStreamReader xMLStreamReader, int i) throws Exception {
        while (xMLStreamReader.hasNext()) {
            print(xMLStreamReader, i);
            xMLStreamReader.next();
        }
    }

    public static void main(String[] strArr) throws Exception {
        MXParser mXParser = new MXParser();
        mXParser.setInput(new FileReader(strArr[0]));
        mXParser.moveToStartElement();
        mXParser.next();
        while (mXParser.moveToStartElement()) {
            System.out.println(new StringBuffer().append("SE->").append(mXParser.getName()).toString());
            sub(mXParser.subReader(), 1);
        }
    }
}
