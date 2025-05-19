package org.apache.xmlbeans;

import aavax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface XmlFactoryHook {
    DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions);

    XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlSaxHandler newXmlSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, XMLStreamException;

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException;

    public static final class ThreadContext {
        private static ThreadLocal threadHook = new ThreadLocal();

        public static XmlFactoryHook getHook() {
            SoftReference softReference = (SoftReference) threadHook.get();
            if (softReference == null) {
                return null;
            }
            return (XmlFactoryHook) softReference.get();
        }

        public static void setHook(XmlFactoryHook xmlFactoryHook) {
            threadHook.set(new SoftReference(xmlFactoryHook));
        }

        private ThreadContext() {
        }
    }
}
