package org.apache.xmlbeans.impl.soap;

import java.util.Locale;

/* loaded from: classes5.dex */
public interface SOAPFault extends SOAPBodyElement {
    Detail addDetail() throws SOAPException;

    Detail getDetail();

    String getFaultActor();

    String getFaultCode();

    Name getFaultCodeAsName();

    String getFaultString();

    Locale getFaultStringLocale();

    void setFaultActor(String str) throws SOAPException;

    void setFaultCode(String str) throws SOAPException;

    void setFaultCode(Name name) throws SOAPException;

    void setFaultString(String str) throws SOAPException;

    void setFaultString(String str, Locale locale) throws SOAPException;
}
