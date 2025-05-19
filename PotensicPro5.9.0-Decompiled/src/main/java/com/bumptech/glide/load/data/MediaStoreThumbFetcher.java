package com.bumptech.glide.load.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaStoreThumbFetcher implements DataFetcher<InputStream> {
    private static final ThumbnailStreamOpenerFactory DEFAULT_FACTORY = new ThumbnailStreamOpenerFactory();
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher<InputStream> defaultFetcher;
    private final ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;

    interface ThumbnailQuery {
        Cursor queryPath(Context context, Uri uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i, int i2) {
        this(context, uri, dataFetcher, i, i2, DEFAULT_FACTORY);
    }

    MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i, int i2, ThumbnailStreamOpenerFactory thumbnailStreamOpenerFactory) {
        this.context = context;
        this.mediaStoreUri = uri;
        this.defaultFetcher = dataFetcher;
        this.width = i;
        this.height = i2;
        this.factory = thumbnailStreamOpenerFactory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }

    private InputStream openThumbInputStream(ThumbnailStreamOpener thumbnailStreamOpener) {
        InputStream inputStream;
        try {
            inputStream = thumbnailStreamOpener.open(this.context, this.mediaStoreUri);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e);
            }
            inputStream = null;
        }
        int orientation = inputStream != null ? thumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri) : -1;
        return orientation != -1 ? new ExifOrientationStream(inputStream, orientation) : inputStream;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        this.defaultFetcher.cleanup();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public String getId() {
        return this.mediaStoreUri.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMediaStoreVideo(Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }

    static class FileService {
        FileService() {
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long length(File file) {
            return file.length();
        }

        public File get(String str) {
            return new File(str);
        }
    }

    static class ThumbnailStreamOpener {
        private static final FileService DEFAULT_SERVICE = new FileService();
        private ThumbnailQuery query;
        private final FileService service;

        public ThumbnailStreamOpener(ThumbnailQuery thumbnailQuery) {
            this(DEFAULT_SERVICE, thumbnailQuery);
        }

        public ThumbnailStreamOpener(FileService fileService, ThumbnailQuery thumbnailQuery) {
            this.service = fileService;
            this.query = thumbnailQuery;
        }

        public int getOrientation(Context context, Uri uri) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    int orientation = new ImageHeaderParser(inputStream).getOrientation();
                    if (inputStream == null) {
                        return orientation;
                    }
                    try {
                        inputStream.close();
                        return orientation;
                    } catch (IOException unused) {
                        return orientation;
                    }
                } catch (IOException e) {
                    if (Log.isLoggable(MediaStoreThumbFetcher.TAG, 3)) {
                        Log.d(MediaStoreThumbFetcher.TAG, "Failed to open uri: " + uri, e);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return -1;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x001e A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.io.InputStream open(android.content.Context r3, android.net.Uri r4) throws java.io.FileNotFoundException {
            /*
                r2 = this;
                com.bumptech.glide.load.data.MediaStoreThumbFetcher$ThumbnailQuery r0 = r2.query
                android.database.Cursor r4 = r0.queryPath(r3, r4)
                r0 = 0
                if (r4 == 0) goto L1b
                boolean r1 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L14
                if (r1 == 0) goto L1b
                android.net.Uri r1 = r2.parseThumbUri(r4)     // Catch: java.lang.Throwable -> L14
                goto L1c
            L14:
                r3 = move-exception
                if (r4 == 0) goto L1a
                r4.close()
            L1a:
                throw r3
            L1b:
                r1 = r0
            L1c:
                if (r4 == 0) goto L21
                r4.close()
            L21:
                if (r1 == 0) goto L2b
                android.content.ContentResolver r3 = r3.getContentResolver()
                java.io.InputStream r0 = r3.openInputStream(r1)
            L2b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener.open(android.content.Context, android.net.Uri):java.io.InputStream");
        }

        private Uri parseThumbUri(Cursor cursor) {
            String string = cursor.getString(0);
            if (!TextUtils.isEmpty(string)) {
                File file = this.service.get(string);
                if (this.service.exists(file) && this.service.length(file) > 0) {
                    return Uri.fromFile(file);
                }
            }
            return null;
        }
    }

    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";

        ImageThumbnailQuery() {
        }

        @Override // com.bumptech.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";

        VideoThumbnailQuery() {
        }

        @Override // com.bumptech.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class ThumbnailStreamOpenerFactory {
        ThumbnailStreamOpenerFactory() {
        }

        public ThumbnailStreamOpener build(Uri uri, int i, int i2) {
            if (!MediaStoreThumbFetcher.isMediaStoreUri(uri) || i > 512 || i2 > MediaStoreThumbFetcher.MINI_HEIGHT) {
                return null;
            }
            if (MediaStoreThumbFetcher.isMediaStoreVideo(uri)) {
                return new ThumbnailStreamOpener(new VideoThumbnailQuery());
            }
            return new ThumbnailStreamOpener(new ImageThumbnailQuery());
        }
    }
}
