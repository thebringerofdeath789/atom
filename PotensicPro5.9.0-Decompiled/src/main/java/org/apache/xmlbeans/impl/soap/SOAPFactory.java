package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public abstract class SOAPFactory {
    private static final String DEFAULT_SF = "org.apache.axis.soap.SOAPFactoryImpl";
    private static final String SF_PROPERTY = "javax.xml.soap.SOAPFactory";

    public abstract Detail createDetail() throws SOAPException;

    public abstract SOAPElement createElement(String str) throws SOAPException;

    public abstract SOAPElement createElement(String str, String str2, String str3) throws SOAPException;

    public abstract SOAPElement createElement(Name name) throws SOAPException;

    public abstract Name createName(String str) throws SOAPException;

    public abstract Name createName(String str, String str2, String str3) throws SOAPException;

    public static SOAPFactory newInstance() throws SOAPException {
        try {
            return (SOAPFactory) FactoryFinder.find(SF_PROPERTY, DEFAULT_SF);
        } catch (Exception e) {
            throw new SOAPException(new StringBuffer().append("Unable to create SOAP Factory: ").append(e.getMessage()).toString());
        }
    }
}
