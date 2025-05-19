package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public abstract class SOAPConnection {
    public abstract SOAPMessage call(SOAPMessage sOAPMessage, Object obj) throws SOAPException;

    public abstract void close() throws SOAPException;
}
