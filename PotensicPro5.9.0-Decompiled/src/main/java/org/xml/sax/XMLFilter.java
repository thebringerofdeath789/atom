package org.xml.sax;

/* loaded from: classes6.dex */
public interface XMLFilter extends XMLReader {
    XMLReader getParent();

    void setParent(XMLReader xMLReader);
}
