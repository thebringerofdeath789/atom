package org.apache.xmlbeans.impl.schema;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* loaded from: classes5.dex */
public class ClassLoaderResourceLoader implements ResourceLoader {
    ClassLoader _classLoader;

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
    }

    public ClassLoaderResourceLoader(ClassLoader classLoader) {
        this._classLoader = classLoader;
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        return this._classLoader.getResourceAsStream(str);
    }
}
