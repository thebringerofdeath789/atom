package com.bea.xml.stream.samples;

import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.events.XMLEvent;
import java.io.FileReader;

/* loaded from: classes.dex */
public class AllocEventParser {
    private static String filename;

    private static void printUsage() {
        System.out.println("usage: java com.bea.xml.stream.samples.AllocEventParse <xmlfile>");
    }

    public static void main(String[] strArr) throws Exception {
        try {
            filename = strArr[0];
        } catch (ArrayIndexOutOfBoundsException unused) {
            printUsage();
            System.exit(0);
        }
        System.setProperty("aavax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
        System.setProperty("aavax.xml.stream.XMLOutputFactory", "com.bea.xml.stream.XMLOutputFactoryBase");
        System.setProperty("aavax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
        XMLInputFactory newInstance = XMLInputFactory.newInstance();
        newInstance.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.FALSE);
        XMLEventReader createXMLEventReader = newInstance.createXMLEventReader(new FileReader(filename));
        while (createXMLEventReader.hasNext()) {
            XMLEvent nextEvent = createXMLEventReader.nextEvent();
            System.out.println(new StringBuffer().append("ID:").append(nextEvent.hashCode()).append("[").append(nextEvent).append("]").toString());
        }
    }
}
