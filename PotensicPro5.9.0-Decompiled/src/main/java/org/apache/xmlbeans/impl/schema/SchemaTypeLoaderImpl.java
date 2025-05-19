package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* loaded from: classes5.dex */
public class SchemaTypeLoaderImpl extends SchemaTypeLoaderBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Object CACHED_NOT_FOUND;
    private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY;
    public static String METADATA_PACKAGE_LOAD;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl;
    private Map _attributeCache;
    private Map _attributeGroupCache;
    private Map _attributeTypeCache;
    private ClassLoader _classLoader;
    private Map _classLoaderTypeSystems;
    private Map _classnameCache;
    private Map _classpathTypeSystems;
    private Map _documentCache;
    private Map _elementCache;
    private Map _idConstraintCache;
    private Map _modelGroupCache;
    private ResourceLoader _resourceLoader;
    private SchemaTypeLoader[] _searchPath;
    private Map _typeCache;

    static {
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl");
        }
        $assertionsDisabled = true;
        METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
        CACHED_NOT_FOUND = new Object();
        EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];
        if (SystemCache.get() instanceof SystemCache) {
            SystemCache.set(new SchemaTypeLoaderCache());
        }
    }

    private static class SchemaTypeLoaderCache extends SystemCache {
        static final /* synthetic */ boolean $assertionsDisabled;
        private ThreadLocal _cachedTypeSystems;

        static {
            if (SchemaTypeLoaderImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl == null) {
                SchemaTypeLoaderImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl = SchemaTypeLoaderImpl.class$("org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl");
            } else {
                Class cls = SchemaTypeLoaderImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeLoaderImpl;
            }
            $assertionsDisabled = true;
        }

        private SchemaTypeLoaderCache() {
            this._cachedTypeSystems = new ThreadLocal() { // from class: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl.SchemaTypeLoaderCache.1
                @Override // java.lang.ThreadLocal
                protected Object initialValue() {
                    return new ArrayList();
                }
            };
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
            SchemaTypeLoaderImpl schemaTypeLoaderImpl;
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    schemaTypeLoaderImpl = null;
                    i = -1;
                    break;
                }
                schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) ((SoftReference) arrayList.get(i)).get();
                if (schemaTypeLoaderImpl != null) {
                    if (schemaTypeLoaderImpl._classLoader == classLoader) {
                        boolean z = $assertionsDisabled;
                        break;
                    }
                } else {
                    if (!$assertionsDisabled && i <= -1) {
                        throw new AssertionError();
                    }
                    arrayList.remove(i);
                    i--;
                }
                i++;
            }
            if (i > 0) {
                Object obj = arrayList.get(0);
                arrayList.set(0, arrayList.get(i));
                arrayList.set(i, obj);
            }
            return schemaTypeLoaderImpl;
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
            if (!$assertionsDisabled && (!(schemaTypeLoader instanceof SchemaTypeLoaderImpl) || ((SchemaTypeLoaderImpl) schemaTypeLoader)._classLoader != classLoader)) {
                throw new AssertionError();
            }
            ArrayList arrayList = (ArrayList) this._cachedTypeSystems.get();
            if (arrayList.size() > 0) {
                Object obj = arrayList.get(0);
                arrayList.set(0, new SoftReference(schemaTypeLoader));
                arrayList.add(obj);
                return;
            }
            arrayList.add(new SoftReference(schemaTypeLoader));
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static SchemaTypeLoaderImpl getContextTypeLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) SystemCache.get().getFromTypeLoaderCache(contextClassLoader);
        if (schemaTypeLoaderImpl != null) {
            return schemaTypeLoaderImpl;
        }
        SchemaTypeLoaderImpl schemaTypeLoaderImpl2 = new SchemaTypeLoaderImpl(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get()}, null, contextClassLoader);
        SystemCache.get().addToTypeLoaderCache(schemaTypeLoaderImpl2, contextClassLoader);
        return schemaTypeLoaderImpl2;
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        SchemaTypeLoader[] array;
        if (schemaTypeLoaderArr == null) {
            array = EMPTY_SCHEMATYPELOADER_ARRAY;
        } else {
            SubLoaderList subLoaderList = new SubLoaderList();
            for (int i = 0; i < schemaTypeLoaderArr.length; i++) {
                if (schemaTypeLoaderArr[i] == null) {
                    throw new IllegalArgumentException(new StringBuffer().append("searchPath[").append(i).append("] is null").toString());
                }
                if (schemaTypeLoaderArr[i] instanceof SchemaTypeLoaderImpl) {
                    SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl) schemaTypeLoaderArr[i];
                    if (schemaTypeLoaderImpl._classLoader == null && schemaTypeLoaderImpl._resourceLoader == null) {
                        int i2 = 0;
                        while (true) {
                            SchemaTypeLoader[] schemaTypeLoaderArr2 = schemaTypeLoaderImpl._searchPath;
                            if (i2 < schemaTypeLoaderArr2.length) {
                                subLoaderList.add(schemaTypeLoaderArr2[i2]);
                                i2++;
                            }
                        }
                    } else {
                        subLoaderList.add(schemaTypeLoaderImpl);
                    }
                } else {
                    subLoaderList.add(schemaTypeLoaderArr[i]);
                }
            }
            array = subLoaderList.toArray();
        }
        if (array.length == 1 && resourceLoader == null && classLoader == null) {
            return array[0];
        }
        return new SchemaTypeLoaderImpl(array, resourceLoader, classLoader);
    }

    private static class SubLoaderList {
        private Map seen;
        private List theList;

        private SubLoaderList() {
            this.theList = new ArrayList();
            this.seen = new IdentityHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean add(SchemaTypeLoader schemaTypeLoader) {
            if (this.seen.containsKey(schemaTypeLoader)) {
                return false;
            }
            this.theList.add(schemaTypeLoader);
            this.seen.put(schemaTypeLoader, null);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SchemaTypeLoader[] toArray() {
            return (SchemaTypeLoader[]) this.theList.toArray(SchemaTypeLoaderImpl.EMPTY_SCHEMATYPELOADER_ARRAY);
        }
    }

    private SchemaTypeLoaderImpl(SchemaTypeLoader[] schemaTypeLoaderArr, ResourceLoader resourceLoader, ClassLoader classLoader) {
        if (schemaTypeLoaderArr == null) {
            this._searchPath = EMPTY_SCHEMATYPELOADER_ARRAY;
        } else {
            this._searchPath = schemaTypeLoaderArr;
        }
        this._resourceLoader = resourceLoader;
        this._classLoader = classLoader;
        initCaches();
    }

    private final void initCaches() {
        this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
        this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
        this._elementCache = Collections.synchronizedMap(new HashMap());
        this._attributeCache = Collections.synchronizedMap(new HashMap());
        this._modelGroupCache = Collections.synchronizedMap(new HashMap());
        this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
        this._idConstraintCache = Collections.synchronizedMap(new HashMap());
        this._typeCache = Collections.synchronizedMap(new HashMap());
        this._documentCache = Collections.synchronizedMap(new HashMap());
        this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
        this._classnameCache = Collections.synchronizedMap(new HashMap());
    }

    SchemaTypeSystemImpl typeSystemForComponent(String str, QName qName) {
        String stringBuffer = new StringBuffer().append(str).append(QNameHelper.hexsafedir(qName)).append(".xsb").toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        String crackEntry = resourceLoader != null ? crackEntry(resourceLoader, stringBuffer) : null;
        ClassLoader classLoader = this._classLoader;
        if (classLoader != null) {
            crackEntry = crackEntry(classLoader, stringBuffer);
        }
        if (crackEntry != null) {
            return (SchemaTypeSystemImpl) typeSystemForName(crackEntry);
        }
        return null;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        SchemaTypeSystemImpl typeSystemOnClassloader;
        SchemaTypeSystemImpl typeSystemOnClasspath;
        if (this._resourceLoader != null && (typeSystemOnClasspath = getTypeSystemOnClasspath(str)) != null) {
            return typeSystemOnClasspath;
        }
        if (this._classLoader == null || (typeSystemOnClassloader = getTypeSystemOnClassloader(str)) == null) {
            return null;
        }
        return typeSystemOnClassloader;
    }

    SchemaTypeSystemImpl typeSystemForClassname(String str, String str2) {
        String crackEntry;
        String crackEntry2;
        String stringBuffer = new StringBuffer().append(str).append(str2.replace('.', '/')).append(".xsb").toString();
        ResourceLoader resourceLoader = this._resourceLoader;
        if (resourceLoader != null && (crackEntry2 = crackEntry(resourceLoader, stringBuffer)) != null) {
            return getTypeSystemOnClasspath(crackEntry2);
        }
        ClassLoader classLoader = this._classLoader;
        if (classLoader == null || (crackEntry = crackEntry(classLoader, stringBuffer)) == null) {
            return null;
        }
        return getTypeSystemOnClassloader(crackEntry);
    }

    SchemaTypeSystemImpl getTypeSystemOnClasspath(String str) {
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classpathTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(this._resourceLoader, str, this);
        this._classpathTypeSystems.put(str, schemaTypeSystemImpl2);
        return schemaTypeSystemImpl2;
    }

    SchemaTypeSystemImpl getTypeSystemOnClassloader(String str) {
        XBeanDebug.trace(1, new StringBuffer().append("Finding type system ").append(str).append(" on classloader").toString(), 0);
        SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl) this._classLoaderTypeSystems.get(str);
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        XBeanDebug.trace(1, new StringBuffer().append("Type system ").append(str).append(" not cached - consulting field").toString(), 0);
        SchemaTypeSystemImpl forName = SchemaTypeSystemImpl.forName(str, this._classLoader);
        this._classLoaderTypeSystems.put(str, forName);
        return forName;
    }

    static String crackEntry(ResourceLoader resourceLoader, String str) {
        InputStream resourceAsStream = resourceLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    static String crackEntry(ClassLoader classLoader, String str) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            return null;
        }
        return crackPointer(resourceAsStream);
    }

    static String crackPointer(InputStream inputStream) {
        return SchemaTypeSystemImpl.crackPointer(inputStream);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        int i = 0;
        while (true) {
            SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
            if (i >= schemaTypeLoaderArr.length) {
                return typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/namespace/").toString(), new QName(str, "xmlns")) != null;
            }
            if (schemaTypeLoaderArr[i].isNamespaceDefined(str)) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._typeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref ref = (SchemaType.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/type/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findTypeRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered type ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._typeCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        SchemaTypeSystemImpl typeSystemForClassname;
        String replace = str.replace('$', '.');
        Object obj = this._classnameCache.get(replace);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType schemaType = (SchemaType) obj;
        if (schemaType == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (schemaType = schemaTypeLoaderArr[i].typeForClassname(replace)) != null) {
                    break;
                }
                i++;
            }
            if (schemaType == null && (typeSystemForClassname = typeSystemForClassname(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/javaname/").toString(), replace)) != null) {
                schemaType = typeSystemForClassname.typeForClassname(replace);
                if (!$assertionsDisabled && schemaType == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered type ").append(replace).append(" but does not return it").toString());
                }
            }
            this._classnameCache.put(replace, schemaType == null ? CACHED_NOT_FOUND : schemaType);
        }
        return schemaType;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._documentCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref ref = (SchemaType.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findDocumentTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/element/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findDocumentTypeRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered element ").append(QNameHelper.pretty(qName)).append(" but does not contain document type").toString());
                }
            }
            this._documentCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._attributeTypeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaType.Ref ref = (SchemaType.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findAttributeTypeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/attribute/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findAttributeTypeRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered attribute ").append(QNameHelper.pretty(qName)).append(" but does not contain attribute type").toString());
                }
            }
            this._attributeTypeCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._elementCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalElement.Ref ref = (SchemaGlobalElement.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findElementRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/element/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findElementRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered element ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._elementCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._attributeCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaGlobalAttribute.Ref ref = (SchemaGlobalAttribute.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findAttributeRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/attribute/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findAttributeRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered attribute ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._attributeCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._modelGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaModelGroup.Ref ref = (SchemaModelGroup.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findModelGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/modelgroup/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findModelGroupRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered model group ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._modelGroupCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._attributeGroupCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaAttributeGroup.Ref ref = (SchemaAttributeGroup.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findAttributeGroupRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/attributegroup/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findAttributeGroupRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered attribute group ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._attributeGroupCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        SchemaTypeSystemImpl typeSystemForComponent;
        Object obj = this._idConstraintCache.get(qName);
        if (obj == CACHED_NOT_FOUND) {
            return null;
        }
        SchemaIdentityConstraint.Ref ref = (SchemaIdentityConstraint.Ref) obj;
        if (ref == null) {
            int i = 0;
            while (true) {
                SchemaTypeLoader[] schemaTypeLoaderArr = this._searchPath;
                if (i >= schemaTypeLoaderArr.length || (ref = schemaTypeLoaderArr[i].findIdentityConstraintRef(qName)) != null) {
                    break;
                }
                i++;
            }
            if (ref == null && (typeSystemForComponent = typeSystemForComponent(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/identityconstraint/").toString(), qName)) != null) {
                ref = typeSystemForComponent.findIdentityConstraintRef(qName);
                if (!$assertionsDisabled && ref == null) {
                    throw new AssertionError(new StringBuffer().append("Type system registered identity constraint ").append(QNameHelper.pretty(qName)).append(" but does not return it").toString());
                }
            }
            this._idConstraintCache.put(qName, ref == null ? CACHED_NOT_FOUND : ref);
        }
        return ref;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        ClassLoader classLoader;
        if (!str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = new StringBuffer().append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str).toString();
        }
        ResourceLoader resourceLoader = this._resourceLoader;
        InputStream resourceAsStream = resourceLoader != null ? resourceLoader.getResourceAsStream(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/src").append(str).toString()) : null;
        return (resourceAsStream != null || (classLoader = this._classLoader) == null) ? resourceAsStream : classLoader.getResourceAsStream(new StringBuffer().append("schema").append(METADATA_PACKAGE_LOAD).append("/src").append(str).toString());
    }
}
