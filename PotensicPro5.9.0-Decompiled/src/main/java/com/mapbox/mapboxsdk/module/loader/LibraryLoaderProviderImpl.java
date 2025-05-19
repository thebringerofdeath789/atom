package com.mapbox.mapboxsdk.module.loader;

import com.mapbox.mapboxsdk.LibraryLoader;
import com.mapbox.mapboxsdk.LibraryLoaderProvider;

/* loaded from: classes3.dex */
public class LibraryLoaderProviderImpl implements LibraryLoaderProvider {
    @Override // com.mapbox.mapboxsdk.LibraryLoaderProvider
    public LibraryLoader getDefaultLibraryLoader() {
        return new SystemLibraryLoader();
    }

    private static class SystemLibraryLoader extends LibraryLoader {
        private SystemLibraryLoader() {
        }

        @Override // com.mapbox.mapboxsdk.LibraryLoader
        public void load(String str) {
            System.loadLibrary(str);
        }
    }
}
