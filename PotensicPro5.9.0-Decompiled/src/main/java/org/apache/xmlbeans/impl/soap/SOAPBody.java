package org.apache.xmlbeans.impl.soap;

import java.util.Locale;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public interface SOAPBody extends SOAPElement {
    SOAPBodyElement addBodyElement(Name name) throws SOAPException;

    SOAPBodyElement addDocument(Document document) throws SOAPException;

    SOAPFault addFault() throws SOAPException;

    SOAPFault addFault(Name name, String str) throws SOAPException;

    SOAPFault addFault(Name name, String str, Locale locale) throws SOAPException;

    SOAPFault getFault();

    boolean hasFault();
}
