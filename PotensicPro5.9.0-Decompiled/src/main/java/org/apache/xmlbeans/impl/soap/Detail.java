package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

/* loaded from: classes5.dex */
public interface Detail extends SOAPFaultElement {
    DetailEntry addDetailEntry(Name name) throws SOAPException;

    Iterator getDetailEntries();
}
