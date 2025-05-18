package aavax.xml.stream.events;

import aavax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface Attribute extends XMLEvent {
    String getDTDType();

    QName getName();

    String getValue();

    boolean isSpecified();
}