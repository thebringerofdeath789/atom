package org.apache.xmlbeans;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes5.dex */
public interface SchemaCodePrinter {
    void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem) throws IOException;

    void printType(Writer writer, SchemaType schemaType) throws IOException;

    void printTypeImpl(Writer writer, SchemaType schemaType) throws IOException;
}
