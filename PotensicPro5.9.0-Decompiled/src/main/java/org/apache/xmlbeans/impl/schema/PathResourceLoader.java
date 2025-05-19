package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.xmlbeans.ResourceLoader;

/* loaded from: classes5.dex */
public class PathResourceLoader implements ResourceLoader {
    private ResourceLoader[] _path;

    public PathResourceLoader(ResourceLoader[] resourceLoaderArr) throws IOException {
        ResourceLoader[] resourceLoaderArr2 = new ResourceLoader[resourceLoaderArr.length];
        this._path = resourceLoaderArr2;
        System.arraycopy(resourceLoaderArr, 0, resourceLoaderArr2, 0, resourceLoaderArr2.length);
    }

    public PathResourceLoader(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            try {
                arrayList.add(new FileResourceLoader(file));
            } catch (IOException unused) {
            }
        }
        this._path = (ResourceLoader[]) arrayList.toArray(new ResourceLoader[arrayList.size()]);
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        int i = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i >= resourceLoaderArr.length) {
                return null;
            }
            InputStream resourceAsStream = resourceLoaderArr[i].getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            i++;
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
        int i = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i >= resourceLoaderArr.length) {
                return;
            }
            try {
                resourceLoaderArr[i].close();
            } catch (Exception unused) {
            }
            i++;
        }
    }
}
