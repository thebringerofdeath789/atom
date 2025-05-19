package org.jdom.filter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jdom.Element;
import org.jdom.Namespace;

/* loaded from: classes5.dex */
public class ElementFilter extends AbstractFilter {
    private static final String CVS_ID = "@(#) $RCSfile: ElementFilter.java,v $ $Revision: 1.18 $ $Date: 2004/09/07 06:37:20 $ $Name: jdom_1_0 $";
    private String name;
    private transient Namespace namespace;

    public ElementFilter() {
    }

    public ElementFilter(String str) {
        this.name = str;
    }

    public ElementFilter(Namespace namespace) {
        this.namespace = namespace;
    }

    public ElementFilter(String str, Namespace namespace) {
        this.name = str;
        this.namespace = namespace;
    }

    @Override // org.jdom.filter.AbstractFilter, org.jdom.filter.Filter
    public boolean matches(Object obj) {
        if (!(obj instanceof Element)) {
            return false;
        }
        Element element = (Element) obj;
        String str = this.name;
        if (str != null && !str.equals(element.getName())) {
            return false;
        }
        Namespace namespace = this.namespace;
        return namespace == null || namespace.equals(element.getNamespace());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementFilter)) {
            return false;
        }
        ElementFilter elementFilter = (ElementFilter) obj;
        String str = this.name;
        if (str == null) {
            if (elementFilter.name == null) {
                z = false;
            }
            return false;
        }
        z = !str.equals(elementFilter.name);
        if (!z) {
            Namespace namespace = this.namespace;
            Namespace namespace2 = elementFilter.namespace;
            if (namespace != null) {
                z2 = !namespace.equals(namespace2);
            } else if (namespace2 == null) {
                z2 = false;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 29;
        Namespace namespace = this.namespace;
        return hashCode + (namespace != null ? namespace.hashCode() : 0);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.namespace.getPrefix());
        objectOutputStream.writeObject(this.namespace.getURI());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.getNamespace((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
    }
}
