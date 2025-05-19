package org.apache.xmlbeans.impl.xb.ltgfmt;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface TestsDocument extends XmlObject {
    public static final SchemaType type;

    Tests addNewTests();

    Tests getTests();

    void setTests(Tests tests);

    /* renamed from: org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    static {
        Class cls;
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("tests5621doctype");
    }

    public interface Tests extends XmlObject {
        public static final SchemaType type;

        TestCase addNewTest();

        TestCase getTestArray(int i);

        TestCase[] getTestArray();

        TestCase insertNewTest(int i);

        void removeTest(int i);

        void setTestArray(int i, TestCase testCase);

        void setTestArray(TestCase[] testCaseArr);

        int sizeOfTestArray();

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument$Tests");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$TestsDocument$Tests;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("tests9d6eelemtype");
        }

        public static final class Factory {
            public static Tests newInstance() {
                return (Tests) XmlBeans.getContextTypeLoader().newInstance(Tests.type, null);
            }

            public static Tests newInstance(XmlOptions xmlOptions) {
                return (Tests) XmlBeans.getContextTypeLoader().newInstance(Tests.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static TestsDocument newInstance() {
            return (TestsDocument) XmlBeans.getContextTypeLoader().newInstance(TestsDocument.type, null);
        }

        public static TestsDocument newInstance(XmlOptions xmlOptions) {
            return (TestsDocument) XmlBeans.getContextTypeLoader().newInstance(TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(String str) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(str, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(str, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(File file) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(file, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(file, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(URL url) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(url, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(url, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(inputStream, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(Reader reader) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(reader, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(reader, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(Node node) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(node, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(node, TestsDocument.type, xmlOptions);
        }

        public static TestsDocument parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TestsDocument.type, (XmlOptions) null);
        }

        public static TestsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (TestsDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, TestsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TestsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, TestsDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
