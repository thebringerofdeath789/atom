package org.jdom.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.jdom.JDOMException;
import org.jdom.input.BuilderErrorHandler;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class XML4JDOMAdapter extends AbstractDOMAdapter {
    private static final String CVS_ID = "@(#) $RCSfile: XML4JDOMAdapter.java,v $ $Revision: 1.17 $ $Date: 2004/02/06 09:28:31 $ $Name: jdom_1_0 $";
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$xml$sax$ErrorHandler;
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
            Class<?> cls = Class.forName("org.apache.xerces.parsers.DOMParser");
            Object newInstance = cls.newInstance();
            Class<?>[] clsArr = new Class[2];
            Class<?> cls2 = class$java$lang$String;
            if (cls2 == null) {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            clsArr[0] = cls2;
            clsArr[1] = Boolean.TYPE;
            Method method = cls.getMethod("setFeature", clsArr);
            method.invoke(newInstance, "http://xml.org/sax/features/validation", new Boolean(z));
            method.invoke(newInstance, "http://xml.org/sax/features/namespaces", new Boolean(false));
            if (z) {
                Class<?>[] clsArr2 = new Class[1];
                Class<?> cls3 = class$org$xml$sax$ErrorHandler;
                if (cls3 == null) {
                    cls3 = class$("org.xml.sax.ErrorHandler");
                    class$org$xml$sax$ErrorHandler = cls3;
                }
                clsArr2[0] = cls3;
                cls.getMethod("setErrorHandler", clsArr2).invoke(newInstance, new BuilderErrorHandler());
            }
            Class<?>[] clsArr3 = new Class[1];
            Class<?> cls4 = class$org$xml$sax$InputSource;
            if (cls4 == null) {
                cls4 = class$("org.xml.sax.InputSource");
                class$org$xml$sax$InputSource = cls4;
            }
            clsArr3[0] = cls4;
            cls.getMethod("parse", clsArr3).invoke(newInstance, new InputSource(inputStream));
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
            return (Document) Class.forName("org.apache.xerces.dom.DocumentImpl").newInstance();
        } catch (Exception e) {
            throw new JDOMException(new StringBuffer(String.valueOf(e.getClass().getName())).append(": ").append(e.getMessage()).append(" while creating document").toString(), e);
        }
    }
}
