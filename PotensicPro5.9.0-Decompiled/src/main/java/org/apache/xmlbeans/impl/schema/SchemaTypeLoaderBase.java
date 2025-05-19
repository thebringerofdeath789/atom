package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String USER_AGENT;
    private static final Method _pathCompiler;
    private static final Method _queryCompiler;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlOptions;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase;

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderBase = class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase");
        }
        $assertionsDisabled = true;
        USER_AGENT = new StringBuffer().append("XMLBeans/").append(XmlBeans.getVersion()).append(" (").append(XmlBeans.getTitle()).append(")").toString();
        Class[] clsArr = new Class[2];
        Class cls = class$java$lang$String;
        if (cls == null) {
            cls = class$("java.lang.String");
            class$java$lang$String = cls;
        }
        clsArr[0] = cls;
        Class cls2 = class$org$apache$xmlbeans$XmlOptions;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = cls2;
        }
        clsArr[1] = cls2;
        _pathCompiler = getMethod("org.apache.xmlbeans.impl.store.Path", "compilePath", clsArr);
        Class[] clsArr2 = new Class[2];
        Class cls3 = class$java$lang$String;
        if (cls3 == null) {
            cls3 = class$("java.lang.String");
            class$java$lang$String = cls3;
        }
        clsArr2[0] = cls3;
        Class cls4 = class$org$apache$xmlbeans$XmlOptions;
        if (cls4 == null) {
            cls4 = class$("org.apache.xmlbeans.XmlOptions");
            class$org$apache$xmlbeans$XmlOptions = cls4;
        }
        clsArr2[1] = cls4;
        _queryCompiler = getMethod("org.apache.xmlbeans.impl.store.Query", "compileQuery", clsArr2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static Method getMethod(String str, String str2, Class[] clsArr) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (Exception unused) {
            throw new IllegalStateException(new StringBuffer().append("Cannot find ").append(str).append(".").append(str2).append(".  verify that xmlstore ").append("(from xbean.jar) is on classpath").toString());
        }
    }

    private static Object invokeMethod(Method method, Object[] objArr) {
        try {
            return method.invoke(method, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            IllegalStateException illegalStateException = new IllegalStateException(cause.getMessage());
            illegalStateException.initCause(cause);
            throw illegalStateException;
        } catch (Exception e2) {
            IllegalStateException illegalStateException2 = new IllegalStateException(e2.getMessage());
            illegalStateException2.initCause(e2);
            throw illegalStateException2;
        }
    }

    private static String doCompilePath(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_pathCompiler, new Object[]{str, xmlOptions});
    }

    private static String doCompileQuery(String str, XmlOptions xmlOptions) {
        return (String) invokeMethod(_queryCompiler, new Object[]{str, xmlOptions});
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        SchemaType.Ref findTypeRef = findTypeRef(qName);
        if (findTypeRef == null) {
            return null;
        }
        SchemaType schemaType = findTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        SchemaType.Ref findDocumentTypeRef = findDocumentTypeRef(qName);
        if (findDocumentTypeRef == null) {
            return null;
        }
        SchemaType schemaType = findDocumentTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        SchemaType.Ref findAttributeTypeRef = findAttributeTypeRef(qName);
        if (findAttributeTypeRef == null) {
            return null;
        }
        SchemaType schemaType = findAttributeTypeRef.get();
        if ($assertionsDisabled || schemaType != null) {
            return schemaType;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        SchemaModelGroup.Ref findModelGroupRef = findModelGroupRef(qName);
        if (findModelGroupRef == null) {
            return null;
        }
        SchemaModelGroup schemaModelGroup = findModelGroupRef.get();
        if ($assertionsDisabled || schemaModelGroup != null) {
            return schemaModelGroup;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        SchemaAttributeGroup.Ref findAttributeGroupRef = findAttributeGroupRef(qName);
        if (findAttributeGroupRef == null) {
            return null;
        }
        SchemaAttributeGroup schemaAttributeGroup = findAttributeGroupRef.get();
        if ($assertionsDisabled || schemaAttributeGroup != null) {
            return schemaAttributeGroup;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        SchemaGlobalElement.Ref findElementRef = findElementRef(qName);
        if (findElementRef == null) {
            return null;
        }
        SchemaGlobalElement schemaGlobalElement = findElementRef.get();
        if ($assertionsDisabled || schemaGlobalElement != null) {
            return schemaGlobalElement;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        SchemaGlobalAttribute.Ref findAttributeRef = findAttributeRef(qName);
        if (findAttributeRef == null) {
            return null;
        }
        SchemaGlobalAttribute schemaGlobalAttribute = findAttributeRef.get();
        if ($assertionsDisabled || schemaGlobalAttribute != null) {
            return schemaGlobalAttribute;
        }
        throw new AssertionError();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.newInstance(this, schemaType, xmlOptions);
        }
        return Locale.newInstance(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, str, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, str, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLInputStream, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLInputStream, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLStreamReader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLStreamReader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.put(XmlOptions.DOCUMENT_SOURCE_NAME, file.toURI().normalize().toString());
        } else if (!xmlOptions.hasOption(XmlOptions.DOCUMENT_SOURCE_NAME)) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.put(XmlOptions.DOCUMENT_SOURCE_NAME, file.toURI().normalize().toString());
            xmlOptions = xmlOptions2;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, schemaType, xmlOptions);
        } finally {
            fileInputStream.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:6:0x0028, B:8:0x003e, B:19:0x0059, B:32:0x0063, B:25:0x006d), top: B:5:0x0028 }] */
    @Override // org.apache.xmlbeans.SchemaTypeLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.xmlbeans.XmlObject parse(java.net.URL r8, org.apache.xmlbeans.SchemaType r9, org.apache.xmlbeans.XmlOptions r10) throws org.apache.xmlbeans.XmlException, java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "DOCUMENT_SOURCE_NAME"
            if (r10 != 0) goto L11
            org.apache.xmlbeans.XmlOptions r10 = new org.apache.xmlbeans.XmlOptions
            r10.<init>()
            java.lang.String r1 = r8.toString()
            r10.put(r0, r1)
            goto L24
        L11:
            boolean r1 = r10.hasOption(r0)
            if (r1 != 0) goto L24
            org.apache.xmlbeans.XmlOptions r1 = new org.apache.xmlbeans.XmlOptions
            r1.<init>(r10)
            java.lang.String r10 = r8.toString()
            r1.put(r0, r10)
            r10 = r1
        L24:
            r0 = 0
            r1 = 0
            r2 = r1
            r3 = r2
        L28:
            java.net.URLConnection r4 = r8.openConnection()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "User-Agent"
            java.lang.String r6 = org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase.USER_AGENT     // Catch: java.lang.Throwable -> L7b
            r4.addRequestProperty(r5, r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "Accept"
        */
        //  java.lang.String r6 = "application/xml, text/xml, */*"
        /*
            r4.addRequestProperty(r5, r6)     // Catch: java.lang.Throwable -> L7b
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch: java.lang.Throwable -> L7b
            if (r5 == 0) goto L6b
            r3 = r4
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L7b
            int r5 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L7b
            r6 = 301(0x12d, float:4.22E-43)
            if (r5 == r6) goto L50
            r6 = 302(0x12e, float:4.23E-43)
            if (r5 != r6) goto L4e
            goto L50
        L4e:
            r5 = r1
            goto L51
        L50:
            r5 = 1
        L51:
            if (r5 == 0) goto L57
            r6 = 5
            if (r2 <= r6) goto L57
            r5 = r1
        L57:
            if (r5 == 0) goto L6a
            java.lang.String r6 = "Location"
            java.lang.String r3 = r3.getHeaderField(r6)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L63
            r3 = r1
            goto L6b
        L63:
            java.net.URL r8 = new java.net.URL     // Catch: java.lang.Throwable -> L7b
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L7b
            int r2 = r2 + 1
        L6a:
            r3 = r5
        L6b:
            if (r3 != 0) goto L28
            java.io.InputStream r0 = r4.getInputStream()     // Catch: java.lang.Throwable -> L7b
            org.apache.xmlbeans.XmlObject r8 = r7.parse(r0, r9, r10)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L7a
            r0.close()
        L7a:
            return r8
        L7b:
            r8 = move-exception
            if (r0 == 0) goto L81
            r0.close()
        L81:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase.parse(java.net.URL, org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.XmlOptions):org.apache.xmlbeans.XmlObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    @Override // org.apache.xmlbeans.SchemaTypeLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.xmlbeans.XmlObject parse(java.io.InputStream r4, org.apache.xmlbeans.SchemaType r5, org.apache.xmlbeans.XmlOptions r6) throws org.apache.xmlbeans.XmlException, java.io.IOException {
        /*
            r3 = this;
            org.apache.xmlbeans.XmlFactoryHook r0 = org.apache.xmlbeans.XmlFactoryHook.ThreadContext.getHook()
            if (r6 == 0) goto L1b
            java.lang.String r1 = "LOAD_MESSAGE_DIGEST"
            boolean r1 = r6.hasOption(r1)
            if (r1 == 0) goto L1b
            java.lang.String r1 = "SHA"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch: java.security.NoSuchAlgorithmException -> L1b
            java.security.DigestInputStream r2 = new java.security.DigestInputStream
            r2.<init>(r4, r1)
            r4 = r2
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r0 == 0) goto L23
            org.apache.xmlbeans.XmlObject r4 = r0.parse(r3, r4, r5, r6)
            return r4
        L23:
            org.apache.xmlbeans.XmlObject r4 = org.apache.xmlbeans.impl.store.Locale.parseToXmlObject(r3, r4, r5, r6)
            if (r2 == 0) goto L38
            org.apache.xmlbeans.XmlDocumentProperties r5 = r4.documentProperties()
            java.security.MessageDigest r6 = r2.getMessageDigest()
            byte[] r6 = r6.digest()
            r5.setMessageDigest(r6)
        L38:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase.parse(java.io.InputStream, org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.XmlOptions):org.apache.xmlbeans.XmlObject");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, reader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, reader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, node, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, node, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.newXmlSaxHandler(this, schemaType, xmlOptions);
        }
        return Locale.newSaxHandler(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return Locale.newDomImplementation(this, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
        return new ValidatingXMLInputStream(xMLInputStream, this, schemaType, xmlOptions);
    }

    public String compilePath(String str) {
        return compilePath(str, null);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compilePath(String str, XmlOptions xmlOptions) {
        return doCompilePath(str, xmlOptions);
    }

    public String compileQuery(String str) {
        return compileQuery(str, null);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compileQuery(String str, XmlOptions xmlOptions) {
        return doCompileQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForSignature(String str) {
        String substring;
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            indexOf = str.length();
            substring = "";
        } else {
            substring = str.substring(indexOf + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < indexOf) {
            int indexOf2 = str.indexOf(58, i);
            int indexOf3 = str.indexOf(124, i);
            if (indexOf2 < 0 || (indexOf3 >= 0 && indexOf2 >= indexOf3)) {
                indexOf2 = indexOf3;
            }
            if (indexOf2 < 0 || indexOf2 > indexOf) {
                indexOf2 = indexOf;
            }
            arrayList.add(str.substring(i, indexOf2));
            i = indexOf2 + 1;
        }
        SchemaType schemaType = null;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str2 = (String) arrayList.get(size);
            if (str2.length() < 1) {
                throw new IllegalArgumentException();
            }
            int i2 = (str2.length() < 2 || str2.charAt(1) != '=') ? 1 : 2;
            char charAt = str2.charAt(0);
            if (charAt == 'I') {
                if (schemaType == null) {
                    throw new IllegalArgumentException();
                }
                if (schemaType.getSimpleVariety() != 3) {
                    return null;
                }
                SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
                if (anonymousTypes.length != 1) {
                    return null;
                }
                schemaType = anonymousTypes[0];
            } else if (charAt != 'M') {
                if (charAt != 'Q') {
                    if (charAt != 'R') {
                        if (charAt == 'T') {
                            if (schemaType != null) {
                                throw new IllegalArgumentException();
                            }
                            schemaType = findType(QNameHelper.forLNS(str2.substring(i2), substring));
                            if (schemaType == null) {
                                return null;
                            }
                        } else {
                            if (charAt != 'U') {
                                switch (charAt) {
                                    case 'A':
                                        break;
                                    case 'B':
                                        if (schemaType == null) {
                                            throw new IllegalArgumentException();
                                        }
                                        if (schemaType.getSimpleVariety() != 1) {
                                            return null;
                                        }
                                        SchemaType[] anonymousTypes2 = schemaType.getAnonymousTypes();
                                        if (anonymousTypes2.length != 1) {
                                            return null;
                                        }
                                        schemaType = anonymousTypes2[0];
                                        break;
                                    case 'C':
                                        break;
                                    case 'D':
                                        if (schemaType != null) {
                                            throw new IllegalArgumentException();
                                        }
                                        schemaType = findDocumentType(QNameHelper.forLNS(str2.substring(i2), substring));
                                        if (schemaType == null) {
                                            return null;
                                        }
                                        break;
                                    case 'E':
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            }
                            if (schemaType != null) {
                                if (schemaType.getContentType() < 3) {
                                    return null;
                                }
                                SchemaType[] anonymousTypes3 = schemaType.getAnonymousTypes();
                                String substring2 = str2.substring(i2);
                                for (int i3 = 0; i3 < anonymousTypes3.length; i3++) {
                                    SchemaField containerField = anonymousTypes3[i3].getContainerField();
                                    if (containerField != null && !containerField.isAttribute() && containerField.getName().getLocalPart().equals(substring2)) {
                                        schemaType = anonymousTypes3[i3];
                                    }
                                }
                                return null;
                            }
                            SchemaGlobalElement findElement = findElement(QNameHelper.forLNS(str2.substring(i2), substring));
                            if (findElement == null) {
                                return null;
                            }
                            schemaType = findElement.getType();
                        }
                    }
                    if (schemaType != null) {
                        throw new IllegalArgumentException();
                    }
                    schemaType = findAttributeType(QNameHelper.forLNS(str2.substring(i2), substring));
                    if (schemaType == null) {
                        return null;
                    }
                }
                if (schemaType != null) {
                    if (schemaType.isSimpleType()) {
                        return null;
                    }
                    SchemaType[] anonymousTypes4 = schemaType.getAnonymousTypes();
                    String substring3 = str2.substring(i2);
                    for (int i4 = 0; i4 < anonymousTypes4.length; i4++) {
                        SchemaField containerField2 = anonymousTypes4[i4].getContainerField();
                        if (containerField2 != null && containerField2.isAttribute() && containerField2.getName().getLocalPart().equals(substring3)) {
                            schemaType = anonymousTypes4[i4];
                        }
                    }
                    return null;
                }
                SchemaGlobalAttribute findAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i2), substring));
                if (findAttribute == null) {
                    return null;
                }
                schemaType = findAttribute.getType();
            } else {
                if (schemaType == null) {
                    throw new IllegalArgumentException();
                }
                try {
                    int parseInt = Integer.parseInt(str2.substring(i2));
                    if (schemaType.getSimpleVariety() != 2) {
                        return null;
                    }
                    SchemaType[] anonymousTypes5 = schemaType.getAnonymousTypes();
                    if (anonymousTypes5.length <= parseInt) {
                        return null;
                    }
                    schemaType = anonymousTypes5[parseInt];
                } catch (Exception unused) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return schemaType;
    }
}
