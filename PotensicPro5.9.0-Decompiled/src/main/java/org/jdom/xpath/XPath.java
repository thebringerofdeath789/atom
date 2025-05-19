package org.jdom.xpath;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;
import org.jdom.JDOMException;
import org.jdom.Namespace;

/* loaded from: classes5.dex */
public abstract class XPath implements Serializable {
    private static final String CVS_ID = "@(#) $RCSfile: XPath.java,v $ $Revision: 1.15 $ $Date: 2004/02/06 09:28:32 $ $Name: jdom_1_0 $";
    private static final String DEFAULT_XPATH_CLASS = "org.jdom.xpath.JaxenXPath";
    private static final String XPATH_CLASS_PROPERTY = "org.jdom.xpath.class";
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$jdom$xpath$XPath;
    private static Constructor constructor;

    public abstract void addNamespace(Namespace namespace);

    public abstract String getXPath();

    public abstract Number numberValueOf(Object obj) throws JDOMException;

    public abstract List selectNodes(Object obj) throws JDOMException;

    public abstract Object selectSingleNode(Object obj) throws JDOMException;

    public abstract void setVariable(String str, Object obj);

    public abstract String valueOf(Object obj) throws JDOMException;

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static XPath newInstance(String str) throws JDOMException {
        String str2 = DEFAULT_XPATH_CLASS;
        try {
            if (constructor == null) {
                try {
                    str2 = System.getProperty(XPATH_CLASS_PROPERTY, DEFAULT_XPATH_CLASS);
                } catch (SecurityException unused) {
                }
                setXPathClass(Class.forName(str2));
            }
            return (XPath) constructor.newInstance(str);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof JDOMException) {
                throw ((JDOMException) targetException);
            }
            throw new JDOMException(targetException.toString(), targetException);
        } catch (JDOMException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JDOMException(e3.toString(), e3);
        }
    }

    public static void setXPathClass(Class cls) throws JDOMException {
        if (cls == null) {
            throw new IllegalArgumentException("aClass");
        }
        try {
            Class cls2 = class$org$jdom$xpath$XPath;
            if (cls2 == null) {
                cls2 = class$("org.jdom.xpath.XPath");
                class$org$jdom$xpath$XPath = cls2;
            }
            if (cls2.isAssignableFrom(cls) && !Modifier.isAbstract(cls.getModifiers())) {
                Class<?>[] clsArr = new Class[1];
                Class<?> cls3 = class$java$lang$String;
                if (cls3 == null) {
                    cls3 = class$("java.lang.String");
                    class$java$lang$String = cls3;
                }
                clsArr[0] = cls3;
                constructor = cls.getConstructor(clsArr);
                return;
            }
            throw new JDOMException(new StringBuffer(String.valueOf(cls.getName())).append(" is not a concrete JDOM XPath implementation").toString());
        } catch (JDOMException e) {
            throw e;
        } catch (Exception e2) {
            throw new JDOMException(e2.toString(), e2);
        }
    }

    public void addNamespace(String str, String str2) {
        addNamespace(Namespace.getNamespace(str, str2));
    }

    public static List selectNodes(Object obj, String str) throws JDOMException {
        return newInstance(str).selectNodes(obj);
    }

    public static Object selectSingleNode(Object obj, String str) throws JDOMException {
        return newInstance(str).selectSingleNode(obj);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new XPathString(getXPath());
    }

    private static final class XPathString implements Serializable {
        private String xPath;

        public XPathString(String str) {
            this.xPath = null;
            this.xPath = str;
        }

        private Object readResolve() throws ObjectStreamException {
            try {
                return XPath.newInstance(this.xPath);
            } catch (JDOMException e) {
                throw new InvalidObjectException(new StringBuffer("Can't create XPath object for expression \"").append(this.xPath).append("\": ").append(e.toString()).toString());
            }
        }
    }
}
