package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public class SOAPElementFactory {
    private SOAPFactory sf;

    private SOAPElementFactory(SOAPFactory sOAPFactory) {
        this.sf = sOAPFactory;
    }

    public SOAPElement create(Name name) throws SOAPException {
        return this.sf.createElement(name);
    }

    public SOAPElement create(String str) throws SOAPException {
        return this.sf.createElement(str);
    }

    public SOAPElement create(String str, String str2, String str3) throws SOAPException {
        return this.sf.createElement(str, str2, str3);
    }

    public static SOAPElementFactory newInstance() throws SOAPException {
        try {
            return new SOAPElementFactory(SOAPFactory.newInstance());
        } catch (Exception e) {
            throw new SOAPException(new StringBuffer().append("Unable to create SOAP Element Factory: ").append(e.getMessage()).toString());
        }
    }
}
