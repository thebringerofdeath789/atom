package org.apache.xmlbeans.impl.tool;

import java.util.Map;
import org.apache.xmlbeans.SchemaTypeSystem;

/* loaded from: classes5.dex */
public interface SchemaCompilerExtension {
    String getExtensionName();

    void schemaCompilerExtension(SchemaTypeSystem schemaTypeSystem, Map map);
}
