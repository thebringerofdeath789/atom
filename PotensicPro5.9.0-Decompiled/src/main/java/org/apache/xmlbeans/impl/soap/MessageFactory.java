package org.apache.xmlbeans.impl.soap;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class MessageFactory {
    private static final String DEFAULT_MESSAGE_FACTORY = "org.apache.axis.soap.MessageFactoryImpl";
    private static final String MESSAGE_FACTORY_PROPERTY = "javax.xml.soap.MessageFactory";

    public abstract SOAPMessage createMessage() throws SOAPException;

    public abstract SOAPMessage createMessage(MimeHeaders mimeHeaders, InputStream inputStream) throws IOException, SOAPException;

    public static MessageFactory newInstance() throws SOAPException {
        try {
            return (MessageFactory) FactoryFinder.find(MESSAGE_FACTORY_PROPERTY, DEFAULT_MESSAGE_FACTORY);
        } catch (Exception e) {
            throw new SOAPException(new StringBuffer().append("Unable to create message factory for SOAP: ").append(e.getMessage()).toString());
        }
    }
}
