package aavax.xml.namespace;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface NamespaceContext {
    String getNamespaceURI(String str);

    String getPrefix(String str);

    Iterator getPrefixes(String str);
}