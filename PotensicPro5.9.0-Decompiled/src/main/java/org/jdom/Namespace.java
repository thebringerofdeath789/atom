package org.jdom;

import java.util.HashMap;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public final class Namespace {
    private static final String CVS_ID = "@(#) $RCSfile: Namespace.java,v $ $Revision: 1.41 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    public static final Namespace NO_NAMESPACE;
    public static final Namespace XML_NAMESPACE;
    private static HashMap namespaces;
    private String prefix;
    private String uri;

    static {
        Namespace namespace = new Namespace("", "");
        NO_NAMESPACE = namespace;
        Namespace namespace2 = new Namespace("xml", "http://www.w3.org/XML/1998/namespace");
        XML_NAMESPACE = namespace2;
        HashMap hashMap = new HashMap();
        namespaces = hashMap;
        hashMap.put("&", namespace);
        namespaces.put("xml&http://www.w3.org/XML/1998/namespace", namespace2);
    }

    public static Namespace getNamespace(String str, String str2) {
        if (str == null || str.trim().equals("")) {
            str = "";
        }
        if (str2 == null || str2.trim().equals("")) {
            str2 = "";
        }
        String stringBuffer = new StringBuffer(64).append(str).append(Typography.amp).append(str2).toString();
        Namespace namespace = (Namespace) namespaces.get(stringBuffer);
        if (namespace != null) {
            return namespace;
        }
        String checkNamespacePrefix = Verifier.checkNamespacePrefix(str);
        if (checkNamespacePrefix != null) {
            throw new IllegalNameException(str, "Namespace prefix", checkNamespacePrefix);
        }
        String checkNamespaceURI = Verifier.checkNamespaceURI(str2);
        if (checkNamespaceURI != null) {
            throw new IllegalNameException(str2, "Namespace URI", checkNamespaceURI);
        }
        if (!str.equals("") && str2.equals("")) {
            throw new IllegalNameException("", "namespace", "Namespace URIs must be non-null and non-empty Strings");
        }
        if (str.equals("xml")) {
            throw new IllegalNameException(str, "Namespace prefix", "The xml prefix can only be bound to http://www.w3.org/XML/1998/namespace");
        }
        if (str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throw new IllegalNameException(str2, "Namespace URI", "The http://www.w3.org/XML/1998/namespace must be bound to the xml prefix.");
        }
        Namespace namespace2 = new Namespace(str, str2);
        namespaces.put(stringBuffer, namespace2);
        return namespace2;
    }

    public static Namespace getNamespace(String str) {
        return getNamespace("", str);
    }

    private Namespace(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getURI() {
        return this.uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Namespace) {
            return this.uri.equals(((Namespace) obj).uri);
        }
        return false;
    }

    public String toString() {
        return new StringBuffer("[Namespace: prefix \"").append(this.prefix).append("\" is mapped to URI \"").append(this.uri).append("\"]").toString();
    }

    public int hashCode() {
        return this.uri.hashCode();
    }
}
