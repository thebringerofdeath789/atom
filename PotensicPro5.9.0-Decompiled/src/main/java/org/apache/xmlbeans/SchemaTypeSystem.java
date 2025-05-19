package org.apache.xmlbeans;

import java.io.File;

/* loaded from: classes5.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    SchemaAnnotation[] annotations();

    SchemaAttributeGroup[] attributeGroups();

    SchemaType[] attributeTypes();

    SchemaType[] documentTypes();

    ClassLoader getClassLoader();

    String getName();

    SchemaGlobalAttribute[] globalAttributes();

    SchemaGlobalElement[] globalElements();

    SchemaType[] globalTypes();

    SchemaModelGroup[] modelGroups();

    void resolve();

    SchemaComponent resolveHandle(String str);

    void save(Filer filer);

    void saveToDirectory(File file);

    SchemaType typeForHandle(String str);
}
