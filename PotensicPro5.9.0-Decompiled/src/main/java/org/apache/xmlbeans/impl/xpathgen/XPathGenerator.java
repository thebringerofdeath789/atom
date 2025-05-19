package org.apache.xmlbeans.impl.xpathgen;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class XPathGenerator {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$xpathgen$XPathGenerator;

    static {
        if (class$org$apache$xmlbeans$impl$xpathgen$XPathGenerator == null) {
            class$org$apache$xmlbeans$impl$xpathgen$XPathGenerator = class$("org.apache.xmlbeans.impl.xpathgen.XPathGenerator");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static String generateXPath(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XPathGenerationException {
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Null node");
        }
        if (namespaceContext == null) {
            throw new IllegalArgumentException("Null namespace context");
        }
        XmlCursor.TokenType currentTokenType = xmlCursor.currentTokenType();
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        int intValue = currentTokenType.intValue();
        if (intValue == 1 || intValue == 3) {
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        }
        if (intValue == 5) {
            int countTextTokens = countTextTokens(xmlCursor);
            xmlCursor.toParent();
            String generateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (countTextTokens == 0) {
                return new StringBuffer().append(generateInternal).append("/text()").toString();
            }
            return new StringBuffer().append(generateInternal).append("/text()[position()=").append(countTextTokens).append(PropertyUtils.INDEXED_DELIM2).toString();
        }
        if (intValue == 6) {
            QName name = xmlCursor.getName();
            xmlCursor.toParent();
            return new StringBuffer().append(generateInternal(xmlCursor, xmlCursor2, namespaceContext)).append('/').append('@').append(qnameToString(name, namespaceContext)).toString();
        }
        if (intValue == 7) {
            QName name2 = xmlCursor.getName();
            xmlCursor.toParent();
            String generateInternal2 = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            String localPart = name2.getLocalPart();
            if (localPart.length() == 0) {
                return new StringBuffer().append(generateInternal2).append("/@xmlns").toString();
            }
            return new StringBuffer().append(generateInternal2).append("/@xmlns:").append(localPart).toString();
        }
        throw new XPathGenerationException(new StringBuffer().append("Cannot generate XPath for cursor position: ").append(currentTokenType.toString()).toString());
    }

    private static String generateInternal(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XPathGenerationException {
        StringBuffer stringBuffer;
        StringBuffer append;
        if (xmlCursor.isStartdoc()) {
            return "";
        }
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        if (!$assertionsDisabled && !xmlCursor.isStart()) {
            throw new AssertionError();
        }
        QName name = xmlCursor.getName();
        XmlCursor newCursor = xmlCursor.newCursor();
        if (!xmlCursor.toParent()) {
            return new StringBuffer().append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(name).toString();
        }
        int i = 0;
        xmlCursor.push();
        if (!xmlCursor.toChild(name)) {
            throw new IllegalStateException(new StringBuffer().append("Must have at least one child with name: ").append(name).toString());
        }
        int i2 = 1;
        do {
            if (xmlCursor.isAtSamePositionAs(newCursor)) {
                i = i2;
            } else {
                i2++;
            }
        } while (xmlCursor.toNextSibling(name));
        xmlCursor.pop();
        newCursor.dispose();
        String generateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        if (i2 == 1) {
            stringBuffer = new StringBuffer();
            append = stringBuffer.append(generateInternal).append('/').append(qnameToString(name, namespaceContext));
        } else {
            stringBuffer = new StringBuffer();
            append = stringBuffer.append(generateInternal).append('/').append(qnameToString(name, namespaceContext)).append(PropertyUtils.INDEXED_DELIM).append(i).append(PropertyUtils.INDEXED_DELIM2);
        }
        return append.toString();
    }

    private static String qnameToString(QName qName, NamespaceContext namespaceContext) throws XPathGenerationException {
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.length() == 0) {
            return localPart;
        }
        String prefix = qName.getPrefix();
        if (prefix != null && prefix.length() > 0 && namespaceURI.equals(namespaceContext.getNamespaceURI(prefix))) {
            return new StringBuffer().append(prefix).append(NameUtil.COLON).append(localPart).toString();
        }
        String prefix2 = namespaceContext.getPrefix(namespaceURI);
        if (prefix2 == null) {
            throw new XPathGenerationException(new StringBuffer().append("Could not obtain a prefix for URI: ").append(namespaceURI).toString());
        }
        if (prefix2.length() == 0) {
            throw new XPathGenerationException(new StringBuffer().append("Can not use default prefix in XPath for URI: ").append(namespaceURI).toString());
        }
        return new StringBuffer().append(prefix2).append(NameUtil.COLON).append(localPart).toString();
    }

    private static int countTextTokens(XmlCursor xmlCursor) {
        XmlCursor newCursor = xmlCursor.newCursor();
        xmlCursor.push();
        xmlCursor.toParent();
        XmlCursor.TokenType firstContentToken = xmlCursor.toFirstContentToken();
        int i = 0;
        int i2 = 0;
        while (!firstContentToken.isEnd()) {
            if (firstContentToken.isText()) {
                if (xmlCursor.comparePosition(newCursor) > 0) {
                    i++;
                } else {
                    i2++;
                }
            } else if (firstContentToken.isStart()) {
                xmlCursor.toEndToken();
            }
            firstContentToken = xmlCursor.toNextToken();
        }
        xmlCursor.pop();
        if (i == 0) {
            return 0;
        }
        return i2;
    }

    public static void main(String[] strArr) throws XmlException {
        NamespaceContext namespaceContext = new NamespaceContext() { // from class: org.apache.xmlbeans.impl.xpathgen.XPathGenerator.1
            @Override // aavax.xml.namespace.NamespaceContext
            public String getPrefix(String str) {
                return null;
            }

            @Override // aavax.xml.namespace.NamespaceContext
            public Iterator getPrefixes(String str) {
                return null;
            }

            @Override // aavax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String str) {
                if ("ns".equals(str)) {
                    return "http://a.com";
                }
                return null;
            }
        };
        XmlCursor newCursor = XmlObject.Factory.parse("<root>\n<ns:a xmlns:ns=\"http://a.com\"><b foo=\"value\">text1<c/>text2<c/>text3<c>text</c>text4</b></ns:a>\n</root>").newCursor();
        newCursor.toFirstContentToken();
        newCursor.toFirstContentToken();
        newCursor.toFirstChild();
        newCursor.toFirstChild();
        newCursor.push();
        System.out.println(generateXPath(newCursor, null, namespaceContext));
        newCursor.pop();
        newCursor.toNextSibling();
        newCursor.toNextSibling();
        newCursor.push();
        System.out.println(generateXPath(newCursor, null, namespaceContext));
        newCursor.pop();
        XmlCursor newCursor2 = newCursor.newCursor();
        newCursor2.toParent();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor2.toParent();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.toFirstContentToken();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.toParent();
        newCursor.toPrevToken();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.toParent();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.toFirstAttribute();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.toParent();
        newCursor.toParent();
        newCursor.toNextToken();
        newCursor.push();
        System.out.println(generateXPath(newCursor, newCursor2, namespaceContext));
        newCursor.pop();
        newCursor.push();
        System.out.println(generateXPath(newCursor, null, namespaceContext));
        newCursor.pop();
    }
}
