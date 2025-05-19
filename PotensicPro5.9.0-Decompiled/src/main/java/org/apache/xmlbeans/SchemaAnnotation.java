package org.apache.xmlbeans;

import aavax.xml.namespace.QName;

/* loaded from: classes5.dex */
public interface SchemaAnnotation extends SchemaComponent {

    public interface Attribute {
        QName getName();

        String getValue();

        String getValueUri();
    }

    XmlObject[] getApplicationInformation();

    Attribute[] getAttributes();

    XmlObject[] getUserInformation();
}
