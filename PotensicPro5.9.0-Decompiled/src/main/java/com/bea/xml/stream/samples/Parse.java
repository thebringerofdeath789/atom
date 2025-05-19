package com.bea.xml.stream.samples;

import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.events.Attribute;
import aavax.xml.stream.events.Namespace;
import com.bea.xml.stream.XMLEventAllocatorBase;
import com.bea.xml.stream.util.ElementTypeNames;
import java.io.FileReader;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Parse {
    private static String filename;

    private static void printUsage() {
        System.out.println("usage: java com.bea.xml.stream.samples.Parse <xmlfile>");
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
        XMLStreamReader createXMLStreamReader = newInstance.createXMLStreamReader(new FileReader(filename));
        System.out.println(new StringBuffer().append("READER:  ").append(createXMLStreamReader).append("\n").toString());
        int eventType = createXMLStreamReader.getEventType();
        System.out.println("PARSER STATE BEFORE FIRST next(): ");
        printEventType(eventType);
        printName(createXMLStreamReader);
        printValue(createXMLStreamReader);
        System.out.println("-----------------------------");
        while (createXMLStreamReader.hasNext()) {
            printEventType(createXMLStreamReader.next());
            printName(createXMLStreamReader);
            printValue(createXMLStreamReader);
            if (createXMLStreamReader.isStartElement()) {
                printAttributes(createXMLStreamReader);
                printNamespaces(createXMLStreamReader);
            }
            System.out.println("-----------------------------");
        }
    }

    public static final String getEventTypeString(int i) {
        return ElementTypeNames.getEventTypeString(i);
    }

    private static void printEventType(int i) {
        System.out.print(new StringBuffer().append("EVENT TYPE(").append(i).append("):").toString());
        System.out.println(getEventTypeString(i));
    }

    private static void printName(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.hasName()) {
            System.out.println(new StringBuffer().append("HAS NAME: ").append(xMLStreamReader.getLocalName()).toString());
        } else {
            System.out.println("HAS NO NAME");
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
            System.out.println("\nHAS ATTRIBUTES: ");
            Iterator attributes = XMLEventAllocatorBase.getAttributes(xMLStreamReader);
            while (attributes.hasNext()) {
                Attribute attribute = (Attribute) attributes.next();
                System.out.println("");
                printAttribute(attribute);
            }
            return;
        }
        System.out.println("HAS NO ATTRIBUTES");
    }

    private static void printAttribute(Attribute attribute) {
        System.out.println(new StringBuffer().append("PREFIX: ").append(attribute.getName().getPrefix()).toString());
        System.out.println(new StringBuffer().append("NAMESP: ").append(attribute.getName().getNamespaceURI()).toString());
        System.out.println(new StringBuffer().append("NAME:   ").append(attribute.getName().getLocalPart()).toString());
        System.out.println(new StringBuffer().append("VALUE:  ").append(attribute.getValue()).toString());
        System.out.println(new StringBuffer().append("TYPE:   ").append(attribute.getDTDType()).toString());
    }

    private static void printNamespaces(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader.getNamespaceCount() > 0) {
            System.out.println("\nHAS NAMESPACES: ");
            Iterator namespaces = XMLEventAllocatorBase.getNamespaces(xMLStreamReader);
            while (namespaces.hasNext()) {
                Namespace namespace = (Namespace) namespaces.next();
                System.out.println("");
                printNamespace(namespace);
            }
            return;
        }
        System.out.println("HAS NO NAMESPACES");
    }

    private static void printNamespace(Namespace namespace) {
        System.out.println(new StringBuffer().append("PREFIX: ").append(namespace.getName().getPrefix()).toString());
        System.out.println(new StringBuffer().append("NAMESP: ").append(namespace.getName().getNamespaceURI()).toString());
        System.out.println(new StringBuffer().append("NAME:   ").append(namespace.getName().getLocalPart()).toString());
        System.out.println(new StringBuffer().append("VALUE:  ").append(namespace.getValue()).toString());
        System.out.println(new StringBuffer().append("TYPE:   ").append(namespace.getDTDType()).toString());
    }
}
