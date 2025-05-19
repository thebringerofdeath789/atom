package org.apache.xmlbeans.impl.common;

import aavax.xml.stream.XMLStreamReader;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public final class XmlStreamUtils {
    public static String getName(int i) {
        switch (i) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
                return "ATTRIBUTE";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
            case 13:
                return "NAMESPACE";
            default:
                return "UNKNOWN_EVENT_TYPE";
        }
    }

    public static String printEvent(XMLStreamReader xMLStreamReader) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("EVENT:[").append(xMLStreamReader.getLocation().getLineNumber()).append("][").append(xMLStreamReader.getLocation().getColumnNumber()).append("] ").toString());
        stringBuffer.append(getName(xMLStreamReader.getEventType()));
        stringBuffer.append(" [");
        int eventType = xMLStreamReader.getEventType();
        if (eventType == 9) {
            stringBuffer.append(new StringBuffer().append(xMLStreamReader.getLocalName()).append("=").toString());
            if (xMLStreamReader.hasText()) {
                stringBuffer.append(new StringBuffer().append("[").append(xMLStreamReader.getText()).append("]").toString());
            }
        } else if (eventType != 12) {
            int i = 0;
            switch (eventType) {
                case 1:
                    stringBuffer.append("<");
                    printName(xMLStreamReader, stringBuffer);
                    for (int i2 = 0; i2 < xMLStreamReader.getNamespaceCount(); i2++) {
                        stringBuffer.append(StringUtils.SPACE);
                        String namespacePrefix = xMLStreamReader.getNamespacePrefix(i2);
                        if ("xmlns".equals(namespacePrefix)) {
                            stringBuffer.append(new StringBuffer().append("xmlns=\"").append(xMLStreamReader.getNamespaceURI(i2)).append("\"").toString());
                        } else {
                            stringBuffer.append(new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(namespacePrefix).toString());
                            stringBuffer.append("=\"");
                            stringBuffer.append(xMLStreamReader.getNamespaceURI(i2));
                            stringBuffer.append("\"");
                        }
                    }
                    while (i < xMLStreamReader.getAttributeCount()) {
                        stringBuffer.append(StringUtils.SPACE);
                        printName(xMLStreamReader.getAttributePrefix(i), xMLStreamReader.getAttributeNamespace(i), xMLStreamReader.getAttributeLocalName(i), stringBuffer);
                        stringBuffer.append("=\"");
                        stringBuffer.append(xMLStreamReader.getAttributeValue(i));
                        stringBuffer.append("\"");
                        i++;
                    }
                    stringBuffer.append(">");
                    break;
                case 2:
                    stringBuffer.append("</");
                    printName(xMLStreamReader, stringBuffer);
                    while (i < xMLStreamReader.getNamespaceCount()) {
                        stringBuffer.append(StringUtils.SPACE);
                        String namespacePrefix2 = xMLStreamReader.getNamespacePrefix(i);
                        if ("xmlns".equals(namespacePrefix2)) {
                            stringBuffer.append(new StringBuffer().append("xmlns=\"").append(xMLStreamReader.getNamespaceURI(i)).append("\"").toString());
                        } else {
                            stringBuffer.append(new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(namespacePrefix2).toString());
                            stringBuffer.append("=\"");
                            stringBuffer.append(xMLStreamReader.getNamespaceURI(i));
                            stringBuffer.append("\"");
                        }
                        i++;
                    }
                    stringBuffer.append(">");
                    break;
                case 3:
                    String pITarget = xMLStreamReader.getPITarget();
                    if (pITarget == null) {
                        pITarget = "";
                    }
                    String pIData = xMLStreamReader.getPIData();
                    String str = pIData != null ? pIData : "";
                    stringBuffer.append("<?");
                    stringBuffer.append(new StringBuffer().append(pITarget).append(StringUtils.SPACE).append(str).toString());
                    stringBuffer.append("?>");
                    break;
                case 4:
                case 6:
                    stringBuffer.append(new String(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength()));
                    break;
                case 5:
                    stringBuffer.append("<!--");
                    if (xMLStreamReader.hasText()) {
                        stringBuffer.append(xMLStreamReader.getText());
                    }
                    stringBuffer.append("-->");
                    break;
                case 7:
                    stringBuffer.append("<?xml");
                    stringBuffer.append(new StringBuffer().append(" version='").append(xMLStreamReader.getVersion()).append("'").toString());
                    stringBuffer.append(new StringBuffer().append(" encoding='").append(xMLStreamReader.getCharacterEncodingScheme()).append("'").toString());
                    if (xMLStreamReader.isStandalone()) {
                        stringBuffer.append(" standalone='yes'");
                    } else {
                        stringBuffer.append(" standalone='no'");
                    }
                    stringBuffer.append("?>");
                    break;
            }
        } else {
            stringBuffer.append("<![CDATA[");
            if (xMLStreamReader.hasText()) {
                stringBuffer.append(xMLStreamReader.getText());
            }
            stringBuffer.append("]]>");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private static void printName(String str, String str2, String str3, StringBuffer stringBuffer) {
        if (str2 != null && !"".equals(str2)) {
            stringBuffer.append(new StringBuffer().append("['").append(str2).append("']:").toString());
        }
        if (str != null && !"".equals(str)) {
            stringBuffer.append(new StringBuffer().append(str).append(":").toString());
        }
        if (str3 != null) {
            stringBuffer.append(str3);
        }
    }

    private static void printName(XMLStreamReader xMLStreamReader, StringBuffer stringBuffer) {
        if (xMLStreamReader.hasName()) {
            printName(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), stringBuffer);
        }
    }

    public static int getType(String str) {
        if (str.equals("START_ELEMENT")) {
            return 1;
        }
        if (str.equals("SPACE")) {
            return 6;
        }
        if (str.equals("END_ELEMENT")) {
            return 2;
        }
        if (str.equals("PROCESSING_INSTRUCTION")) {
            return 3;
        }
        if (str.equals("CHARACTERS")) {
            return 4;
        }
        if (str.equals("COMMENT")) {
            return 5;
        }
        if (str.equals("START_DOCUMENT")) {
            return 7;
        }
        if (str.equals("END_DOCUMENT")) {
            return 8;
        }
        if (str.equals("ATTRIBUTE")) {
            return 10;
        }
        if (str.equals("DTD")) {
            return 11;
        }
        if (str.equals("CDATA")) {
            return 12;
        }
        return str.equals("NAMESPACE") ? 13 : -1;
    }
}
