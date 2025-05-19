package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper> {
    private static final String TAG = "IVML";
    private final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
    private final ModelLoader<A, InputStream> streamLoader;

    public ImageVideoModelLoader(ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2) {
        if (modelLoader == null) {
            Objects.requireNonNull(modelLoader2, "At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = modelLoader;
        this.fileDescriptorLoader = modelLoader2;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<ImageVideoWrapper> getResourceFetcher(A a, int i, int i2) {
        ModelLoader<A, InputStream> modelLoader = this.streamLoader;
        DataFetcher<InputStream> resourceFetcher = modelLoader != null ? modelLoader.getResourceFetcher(a, i, i2) : null;
        ModelLoader<A, ParcelFileDescriptor> modelLoader2 = this.fileDescriptorLoader;
        DataFetcher<ParcelFileDescriptor> resourceFetcher2 = modelLoader2 != null ? modelLoader2.getResourceFetcher(a, i, i2) : null;
        if (resourceFetcher == null && resourceFetcher2 == null) {
            return null;
        }
        return new ImageVideoFetcher(resourceFetcher, resourceFetcher2);
    }

    static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper> {
        private final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
        private final DataFetcher<InputStream> streamFetcher;

        public ImageVideoFetcher(DataFetcher<InputStream> dataFetcher, DataFetcher<ParcelFileDescriptor> dataFetcher2) {
            this.streamFetcher = dataFetcher;
            this.fileDescriptorFetcher = dataFetcher2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bumptech.glide.load.model.ImageVideoWrapper loadData(com.bumptech.glide.Priority r6) throws java.lang.Exception {
            /*
                r5 = this;
                com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> r0 = r5.streamFetcher
                r1 = 2
                r2 = 0
                java.lang.String r3 = "IVML"
                if (r0 == 0) goto L21
                java.lang.Object r0 = r0.loadData(r6)     // Catch: java.lang.Exception -> Lf
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> Lf
                goto L22
            Lf:
                r0 = move-exception
                boolean r4 = android.util.Log.isLoggable(r3, r1)
                if (r4 == 0) goto L1b
                java.lang.String r4 = "Exception fetching input stream, trying ParcelFileDescriptor"
                android.util.Log.v(r3, r4, r0)
            L1b:
                com.bumptech.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L20
                goto L21
            L20:
                throw r0
            L21:
                r0 = r2
            L22:
                com.bumptech.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L3e
                java.lang.Object r6 = r4.loadData(r6)     // Catch: java.lang.Exception -> L2e
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch: java.lang.Exception -> L2e
                r2 = r6
                goto L3e
            L2e:
                r6 = move-exception
                boolean r1 = android.util.Log.isLoggable(r3, r1)
                if (r1 == 0) goto L3a
                java.lang.String r1 = "Exception fetching ParcelFileDescriptor"
                android.util.Log.v(r3, r1, r6)
            L3a:
                if (r0 == 0) goto L3d
                goto L3e
            L3d:
                throw r6
            L3e:
                com.bumptech.glide.load.model.ImageVideoWrapper r6 = new com.bumptech.glide.load.model.ImageVideoWrapper
                r6.<init>(r0, r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.ImageVideoModelLoader.ImageVideoFetcher.loadData(com.bumptech.glide.Priority):com.bumptech.glide.load.model.ImageVideoWrapper");
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public String getId() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                return dataFetcher.getId();
            }
            return this.fileDescriptorFetcher.getId();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cancel();
            }
        }
    }
}
