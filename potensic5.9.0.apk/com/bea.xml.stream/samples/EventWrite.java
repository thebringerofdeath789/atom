package com.bea.xml.stream.samples;

import aavax.xml.stream.XMLEventReader;
import aavax.xml.stream.XMLEventWriter;
import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLOutputFactory;
import java.io.FileReader;

/* loaded from: classes.dex */
public class EventWrite {
    private static String filename;

    private static void printUsage() {
        System.out.println("usage: java com.bea.xml.stream.samples.EventWrite <xmlfile>");
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
        XMLOutputFactory newInstance2 = XMLOutputFactory.newInstance();
        newInstance.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
        XMLEventReader createXMLEventReader = newInstance.createXMLEventReader(new FileReader(filename));
        XMLEventWriter createXMLEventWriter = newInstance2.createXMLEventWriter(System.out);
        createXMLEventWriter.add(createXMLEventReader);
        createXMLEventWriter.flush();
    }
}