package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;

/* loaded from: classes.dex */
public class FileDescriptorStringLoader extends StringLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<String> {

    public static class Factory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, ParcelFileDescriptor> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorStringLoader((ModelLoader<Uri, ParcelFileDescriptor>) genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public FileDescriptorStringLoader(Context context) {
        this((ModelLoader<Uri, ParcelFileDescriptor>) Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }

    public FileDescriptorStringLoader(ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(modelLoader);
    }
}
