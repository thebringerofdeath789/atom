package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

/* loaded from: classes5.dex */
public interface SOAPHeader extends SOAPElement {
    SOAPHeaderElement addHeaderElement(Name name) throws SOAPException;

    Iterator examineAllHeaderElements();

    Iterator examineHeaderElements(String str);

    Iterator examineMustUnderstandHeaderElements(String str);

    Iterator extractAllHeaderElements();

    Iterator extractHeaderElements(String str);
}
