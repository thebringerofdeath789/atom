package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public abstract class SOAPConnectionFactory {
    private static final String DEFAULT_SOAP_CONNECTION_FACTORY = "org.apache.axis.soap.SOAPConnectionFactoryImpl";
    private static final String SF_PROPERTY = "javax.xml.soap.SOAPConnectionFactory";

    public abstract SOAPConnection createConnection() throws SOAPException;

    public static SOAPConnectionFactory newInstance() throws SOAPException, UnsupportedOperationException {
        try {
            return (SOAPConnectionFactory) FactoryFinder.find(SF_PROPERTY, DEFAULT_SOAP_CONNECTION_FACTORY);
        } catch (Exception e) {
            throw new SOAPException(new StringBuffer().append("Unable to create SOAP connection factory: ").append(e.getMessage()).toString());
        }
    }
}
