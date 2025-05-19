package org.dom4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dom4j.tree.QNameCache;
import org.dom4j.util.SingletonStrategy;

/* loaded from: classes5.dex */
public class QName implements Serializable {
    static /* synthetic */ Class class$org$dom4j$tree$QNameCache;
    private static SingletonStrategy singleton;
    private DocumentFactory documentFactory;
    private int hashCode;
    private String name;
    private transient Namespace namespace;
    private String qualifiedName;

    static {
        Class<?> cls = null;
        try {
            try {
                cls = Class.forName(System.getProperty("org.dom4j.QName.singleton.strategy", "org.dom4j.util.SimpleSingleton"));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            cls = Class.forName("org.dom4j.util.SimpleSingleton");
        }
        try {
            SingletonStrategy singletonStrategy = (SingletonStrategy) cls.newInstance();
            singleton = singletonStrategy;
            Class cls2 = class$org$dom4j$tree$QNameCache;
            if (cls2 == null) {
                cls2 = class$("org.dom4j.tree.QNameCache");
                class$org$dom4j$tree$QNameCache = cls2;
            }
            singletonStrategy.setSingletonClassName(cls2.getName());
        } catch (Exception unused3) {
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public QName(String str) {
        this(str, Namespace.NO_NAMESPACE);
    }

    public QName(String str, Namespace namespace) {
        this.name = str == null ? "" : str;
        this.namespace = namespace == null ? Namespace.NO_NAMESPACE : namespace;
    }

    public QName(String str, Namespace namespace, String str2) {
        this.name = str == null ? "" : str;
        this.qualifiedName = str2;
        this.namespace = namespace == null ? Namespace.NO_NAMESPACE : namespace;
    }

    public static QName get(String str) {
        return getCache().get(str);
    }

    public static QName get(String str, Namespace namespace) {
        return getCache().get(str, namespace);
    }

    public static QName get(String str, String str2, String str3) {
        if ((str2 == null || str2.length() == 0) && str3 == null) {
            return get(str);
        }
        if (str2 == null || str2.length() == 0) {
            return getCache().get(str, Namespace.get(str3));
        }
        if (str3 == null) {
            return get(str);
        }
        return getCache().get(str, Namespace.get(str2, str3));
    }

    public static QName get(String str, String str2) {
        if (str2 == null) {
            return getCache().get(str);
        }
        return getCache().get(str, str2);
    }

    public static QName get(String str, Namespace namespace, String str2) {
        return getCache().get(str, namespace, str2);
    }

    public String getName() {
        return this.name;
    }

    public String getQualifiedName() {
        if (this.qualifiedName == null) {
            String namespacePrefix = getNamespacePrefix();
            if (namespacePrefix != null && namespacePrefix.length() > 0) {
                this.qualifiedName = new StringBuffer().append(namespacePrefix).append(":").append(this.name).toString();
            } else {
                this.qualifiedName = this.name;
            }
        }
        return this.qualifiedName;
    }

    public Namespace getNamespace() {
        return this.namespace;
    }

    public String getNamespacePrefix() {
        Namespace namespace = this.namespace;
        return namespace == null ? "" : namespace.getPrefix();
    }

    public String getNamespaceURI() {
        Namespace namespace = this.namespace;
        return namespace == null ? "" : namespace.getURI();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = getName().hashCode() ^ getNamespaceURI().hashCode();
            this.hashCode = hashCode;
            if (hashCode == 0) {
                this.hashCode = 47806;
            }
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            if (hashCode() == qName.hashCode()) {
                return getName().equals(qName.getName()) && getNamespaceURI().equals(qName.getNamespaceURI());
            }
        }
        return false;
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [name: ").append(getName()).append(" namespace: \"").append(getNamespace()).append("\"]").toString();
    }

    public DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.namespace.getPrefix());
        objectOutputStream.writeObject(this.namespace.getURI());
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String str = (String) objectInputStream.readObject();
        String str2 = (String) objectInputStream.readObject();
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.get(str, str2);
    }

    private static QNameCache getCache() {
        return (QNameCache) singleton.instance();
    }
}
