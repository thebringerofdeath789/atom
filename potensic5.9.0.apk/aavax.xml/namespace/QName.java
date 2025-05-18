package aavax.xml.namespace;

import java.io.Serializable;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes.dex */
public class QName implements Serializable {
    private String localPart;
    private String namespaceURI;
    private String prefix;

    public QName(String str) {
        this("", str);
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str, String str2, String str3) {
        if (str2 == null) {
            throw new IllegalArgumentException("Local part not allowed to be null");
        }
        str = str == null ? "" : str;
        str3 = str3 == null ? "" : str3;
        this.namespaceURI = str;
        this.localPart = str2;
        this.prefix = str3;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String toString() {
        if (this.namespaceURI.equals("")) {
            return this.localPart;
        }
        return new StringBuffer().append("{").append(this.namespaceURI).append(StringSubstitutor.DEFAULT_VAR_END).append(this.localPart).toString();
    }

    public static QName valueOf(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (str.charAt(0) == '{') {
            int indexOf = str.indexOf(125);
            if (indexOf == -1) {
                throw new IllegalArgumentException("invalid QName literal");
            }
            if (indexOf == str.length() - 1) {
                throw new IllegalArgumentException("invalid QName literal");
            }
            return new QName(str.substring(1, indexOf), str.substring(indexOf + 1));
        }
        return new QName(str);
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QName)) {
            return false;
        }
        QName qName = (QName) obj;
        return this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI);
    }
}