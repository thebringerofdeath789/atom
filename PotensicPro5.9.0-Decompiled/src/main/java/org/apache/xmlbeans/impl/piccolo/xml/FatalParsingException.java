package org.apache.xmlbeans.impl.piccolo.xml;

import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
class FatalParsingException extends SAXException {
    FatalParsingException(String str) {
        super(str);
    }

    FatalParsingException(String str, Exception exc) {
        super(str, exc);
    }
}
