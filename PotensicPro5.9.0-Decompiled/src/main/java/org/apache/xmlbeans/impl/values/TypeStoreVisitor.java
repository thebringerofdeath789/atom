package org.apache.xmlbeans.impl.values;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;

/* loaded from: classes5.dex */
public interface TypeStoreVisitor {
    String get_default_text();

    int get_elementflags();

    SchemaField get_schema_field();

    boolean visit(QName qName);
}
