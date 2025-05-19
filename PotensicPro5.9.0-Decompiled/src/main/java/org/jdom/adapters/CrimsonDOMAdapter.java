package org.jdom.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.jdom.JDOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class CrimsonDOMAdapter extends AbstractDOMAdapter {
    private static final String CVS_ID = "@(#) $RCSfile: CrimsonDOMAdapter.java,v $ $Revision: 1.16 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";

    @Override // org.jdom.adapters.AbstractDOMAdapter, org.jdom.adapters.DOMAdapter
    public Document getDocument(InputStream inputStream, boolean z) throws IOException, JDOMException {
        try {
            return (Document) Class.forName("org.apache.crimson.tree.XmlDocument").getMethod("createXmlDocument", Class.forName("java.io.InputStream"), Boolean.TYPE).invoke(null, inputStream, new Boolean(false));
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof SAXParseException) {
                SAXParseException sAXParseException = (SAXParseException) targetException;
                throw new JDOMException(new StringBuffer("Error on line ").append(sAXParseException.getLineNumber()).append(" of XML document: ").append(sAXParseException.getMessage()).toString(), sAXParseException);
            }
            if (targetException instanceof IOException) {
                throw ((IOException) targetException);
            }
            throw new JDOMException(targetException.getMessage(), targetException);
        } catch (Exception e2) {
            throw new JDOMException(new StringBuffer(String.valueOf(e2.getClass().getName())).append(": ").append(e2.getMessage()).toString(), e2);
        }
    }

    @Override // org.jdom.adapters.AbstractDOMAdapter, org.jdom.adapters.DOMAdapter
    public Document createDocument() throws JDOMException {
        try {
            return (Document) Class.forName("org.apache.crimson.tree.XmlDocument").newInstance();
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer(String.valueOf(e.getClass().getName())).append(": ").append(e.getMessage()).append(" when creating document").toString(), e);
        }
    }
}
