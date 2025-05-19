package org.jdom.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.jdom.JDOMException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class OracleV2DOMAdapter extends AbstractDOMAdapter {
    private static final String CVS_ID = "@(#) $RCSfile: OracleV2DOMAdapter.java,v $ $Revision: 1.18 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";
    static /* synthetic */ Class class$org$xml$sax$InputSource;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.jdom.adapters.AbstractDOMAdapter, org.jdom.adapters.DOMAdapter
    public Document getDocument(InputStream inputStream, boolean z) throws IOException, JDOMException {
        try {
            Class<?> cls = Class.forName("oracle.xml.parser.v2.DOMParser");
            Object newInstance = cls.newInstance();
            Class<?>[] clsArr = new Class[1];
            Class<?> cls2 = class$org$xml$sax$InputSource;
            if (cls2 == null) {
                cls2 = class$("org.xml.sax.InputSource");
                class$org$xml$sax$InputSource = cls2;
            }
            clsArr[0] = cls2;
            cls.getMethod("parse", clsArr).invoke(newInstance, new InputSource(inputStream));
            return (Document) cls.getMethod("getDocument", null).invoke(newInstance, null);
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
            return (Document) Class.forName("oracle.xml.parser.v2.XMLDocument").newInstance();
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer(String.valueOf(e.getClass().getName())).append(": ").append(e.getMessage()).append(" when creating document").toString(), e);
        }
    }
}
