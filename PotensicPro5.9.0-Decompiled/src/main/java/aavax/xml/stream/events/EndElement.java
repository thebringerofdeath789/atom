package aavax.xml.stream.events;

import aavax.xml.namespace.QName;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface EndElement extends XMLEvent {
    QName getName();

    Iterator getNamespaces();
}
