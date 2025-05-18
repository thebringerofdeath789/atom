package com.bea.xml.stream.samples;

import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Namespace;
import com.bea.xml.stream.XMLEventAllocatorBase;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.Sax2Dom;

/* loaded from: classes.dex */
public class EventParse {
    private static String filename;

    private static void printUsage() {
        System.out.println("usage: java com.bea.xml.stream.samples.EventParse <xmlfile>");
    }

    public static void main(String[] strArr) throws Exception {
        try {
            filename = strArr[0];
        } catch (ArrayIndexOutOfBoundsException unused) {
            printUsage();
            System.exit(0);
        }
        System.setProperty("aavax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        XMLInputFactory newInstance = XMLInputFactory.newInstance();
        System.out.println(new StringBuffer().append("FACTORY: ").append(newInstance).toString());
        newInstance.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.FALSE);
        XMLStreamReader createXMLStreamReader = newInstance.createXMLStreamReader(new FileReader(filename));
        System.out.println(new StringBuffer().append("READER:  ").append(createXMLStreamReader).append("\n").toString());
        while (createXMLStreamReader.hasNext()) {
            printEvent(createXMLStreamReader);
            createXMLStreamReader.next();
        }
    }

    public static final String getEventTypeString(int i) {
        return ElementTypeNames.getEventTypeString(i);
    }

    private static void printEvent(XMLStreamReader xMLStreamReader) {
        System.out.print(new StringBuffer().append("EVENT:[").append(xMLStreamReader.getLocation().getLineNumber()).append("][").append(xMLStreamReader.getLocation().getColumnNumber()).append("] ").toString());
        System.out.print(getEventTypeString(xMLStreamReader.getEventType()));
        System.out.print(" [");
        int eventType = xMLStreamReader.getEventType();
        if (eventType == 9) {
            System.out.print(new StringBuffer().append(xMLStreamReader.getLocalName()).append("=").toString());
            if (xMLStreamReader.hasText()) {
                System.out.print(new StringBuffer().append("[").append(xMLStreamReader.getText()).append("]").toString());
            }
        } else if (eventType != 12) {
            switch (eventType) {
                case 1:
                    System.out.print("<");
                    printName(xMLStreamReader);
                    printNamespaces(XMLEventAllocatorBase.getNamespaces(xMLStreamReader));
                    printAttributes(xMLStreamReader);
                    System.out.print(">");
                    break;
                case 2:
                    System.out.print("</");
                    printName(xMLStreamReader);
                    printNamespaces(XMLEventAllocatorBase.getNamespaces(xMLStreamReader));
                    System.out.print(">");
                    break;
                case 3:
                    System.out.print("<?");
                    if (xMLStreamReader.hasText()) {
                        System.out.print(xMLStreamReader.getText());
                    }
                    System.out.print("?>");
                    break;
                case 4:
                case 6:
                    System.out.print(new String(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength()));
                    break;
                case 5:
                    System.out.print("<!--");
                    if (xMLStreamReader.hasText()) {
                        System.out.print(xMLStreamReader.getText());
                    }
                    System.out.print("-->");
                    break;
                case 7:
                    System.out.print("<?xml");
                    System.out.print(new StringBuffer().append(" version='").append(xMLStreamReader.getVersion()).append("'").toString());
                    System.out.print(new StringBuffer().append(" encoding='").append(xMLStreamReader.getCharacterEncodingScheme()).append("'").toString());
                    if (xMLStreamReader.isStandalone()) {
                        System.out.print(" standalone='yes'");
                    } else {
                        System.out.print(" standalone='no'");
                    }
                    System.out.print("?>");
                    break;
            }
        } else {
            System.out.print("<![CDATA[");
            if (xMLStreamReader.hasText()) {
                System.out.print(xMLStreamReader.getText());
            }
            System.out.print("]]>");
        }
        System.out.println("]");
    }

    private static void printEventType(int i) {
        System.out.print(new StringBuffer().append("EVENT TYPE(").append(i).append("):").toString());
        System.out.println(getEventTypeString(i));
    }

    private static void printName(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.hasName()) {
            printName(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName());
        }
    }

    private static void printName(String str, String str2, String str3) {
        if (str2 != null && !"".equals(str2)) {
            System.out.print(new StringBuffer().append("['").append(str2).append("']:").toString());
        }
        if (str != null) {
            System.out.print(new StringBuffer().append(str).append(":").toString());
        }
        if (str3 != null) {
            System.out.print(str3);
        }
    }

    private static void printValue(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.hasText()) {
            System.out.println(new StringBuffer().append("HAS VALUE: ").append(xMLStreamReader.getText()).toString());
        } else {
            System.out.println("HAS NO VALUE");
        }
    }

    private static void printAttributes(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.getAttributeCount() > 0) {
            Iterator attributes = XMLEventAllocatorBase.getAttributes(xMLStreamReader);
            while (attributes.hasNext()) {
                System.out.print(StringUtils.SPACE);
                printAttribute((Attribute) attributes.next());
            }
        }
    }

    private static void printAttribute(Attribute attribute) {
        printName(attribute.getName().getPrefix(), attribute.getName().getNamespaceURI(), attribute.getName().getLocalPart());
        System.out.print(new StringBuffer().append("='").append(attribute.getValue()).append("'").toString());
    }

    private static void printNamespaces(Iterator it) {
        while (it.hasNext()) {
            System.out.print(StringUtils.SPACE);
            printNamespace((Namespace) it.next());
        }
    }

    private static void printNamespace(Namespace namespace) {
        if (namespace.isDefaultNamespaceDeclaration()) {
            System.out.print(new StringBuffer().append("xmlns='").append(namespace.getNamespaceURI()).append("'").toString());
        } else {
            System.out.print(new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(namespace.getPrefix()).append("='").append(namespace.getNamespaceURI()).append("'").toString());
        }
    }
}