package org.apache.xmlbeans.impl.jam.xml;

import aavax.xml.stream.XMLStreamException;

/* loaded from: classes5.dex */
public class TunnelledException extends RuntimeException {
    private XMLStreamException mXSE;

    public TunnelledException(XMLStreamException xMLStreamException) {
        this.mXSE = null;
        this.mXSE = xMLStreamException;
    }

    public XMLStreamException getXMLStreamException() {
        return this.mXSE;
    }
}
