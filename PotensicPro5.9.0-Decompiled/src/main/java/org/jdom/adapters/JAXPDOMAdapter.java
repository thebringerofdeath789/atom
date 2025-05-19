package org.jdom.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.jdom.JDOMException;
import org.jdom.input.BuilderErrorHandler;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class JAXPDOMAdapter extends AbstractDOMAdapter {
    private static final String CVS_ID = "@(#) $RCSfile: JAXPDOMAdapter.java,v $ $Revision: 1.12 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";
    static /* synthetic */ Class class$java$io$InputStream;
    static /* synthetic */ Class class$org$xml$sax$ErrorHandler;

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
            Class.forName("javax.xml.transform.Transformer");
            Class<?> cls = Class.forName("javax.xml.parsers.DocumentBuilderFactory");
            Object invoke = cls.getMethod("newInstance", null).invoke(null, null);
            cls.getMethod("setValidating", Boolean.TYPE).invoke(invoke, new Boolean(z));
            cls.getMethod("setNamespaceAware", Boolean.TYPE).invoke(invoke, Boolean.TRUE);
            Object invoke2 = cls.getMethod("newDocumentBuilder", null).invoke(invoke, null);
            Class<?> cls2 = invoke2.getClass();
            Class<?>[] clsArr = new Class[1];
            Class<?> cls3 = class$org$xml$sax$ErrorHandler;
            if (cls3 == null) {
                cls3 = class$("org.xml.sax.ErrorHandler");
                class$org$xml$sax$ErrorHandler = cls3;
            }
            clsArr[0] = cls3;
            cls2.getMethod("setErrorHandler", clsArr).invoke(invoke2, new BuilderErrorHandler());
            Class<?>[] clsArr2 = new Class[1];
            Class<?> cls4 = class$java$io$InputStream;
            if (cls4 == null) {
                cls4 = class$("java.io.InputStream");
                class$java$io$InputStream = cls4;
            }
            clsArr2[0] = cls4;
            return (Document) cls2.getMethod("parse", clsArr2).invoke(invoke2, inputStream);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof IOException) {
                throw ((IOException) targetException);
            }
            throw new JDOMException(targetException.getMessage(), targetException);
        } catch (Exception e2) {
            throw new JDOMException("Reflection failed while parsing a document with JAXP", e2);
        }
    }

    @Override // org.jdom.adapters.AbstractDOMAdapter, org.jdom.adapters.DOMAdapter
    public Document createDocument() throws JDOMException {
        try {
            Class.forName("javax.xml.transform.Transformer");
            Class<?> cls = Class.forName("javax.xml.parsers.DocumentBuilderFactory");
            Object invoke = cls.getMethod("newDocumentBuilder", null).invoke(cls.getMethod("newInstance", null).invoke(null, null), null);
            return (Document) invoke.getClass().getMethod("newDocument", null).invoke(invoke, null);
        } catch (Exception e) {
            throw new JDOMException("Reflection failed while creating new JAXP document", e);
        }
    }
}
