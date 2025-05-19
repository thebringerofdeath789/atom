package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public interface SOAPEnvelope extends SOAPElement {
    SOAPBody addBody() throws SOAPException;

    SOAPHeader addHeader() throws SOAPException;

    Name createName(String str) throws SOAPException;

    Name createName(String str, String str2, String str3) throws SOAPException;

    SOAPBody getBody() throws SOAPException;

    SOAPHeader getHeader() throws SOAPException;
}
