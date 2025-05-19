package org.apache.xmlbeans.xml.stream;

/* loaded from: classes5.dex */
public interface ChangePrefixMapping extends XMLEvent {
    String getNewNamespaceUri();

    String getOldNamespaceUri();

    String getPrefix();
}
