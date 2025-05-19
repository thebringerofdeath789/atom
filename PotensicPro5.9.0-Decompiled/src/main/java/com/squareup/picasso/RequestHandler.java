package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class RequestHandler {
    public abstract boolean canHandleRequest(Request request);

    int getRetryCount() {
        return 0;
    }

    public abstract Result load(Request request, int i) throws IOException;

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean supportsReplay() {
        return false;
    }

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final InputStream stream;

        public Result(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this((Bitmap) Utils.checkNotNull(bitmap, "bitmap == null"), null, loadedFrom, 0);
        }

        public Result(InputStream inputStream, Picasso.LoadedFrom loadedFrom) {
            this(null, (InputStream) Utils.checkNotNull(inputStream, "stream == null"), loadedFrom, 0);
        }

        Result(Bitmap bitmap, InputStream inputStream, Picasso.LoadedFrom loadedFrom, int i) {
            if (!((inputStream != null) ^ (bitmap != null))) {
                throw new AssertionError();
            }
            this.bitmap = bitmap;
            this.stream = inputStream;
            this.loadedFrom = (Picasso.LoadedFrom) Utils.checkNotNull(loadedFrom, "loadedFrom == null");
            this.exifOrientation = i;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public InputStream getStream() {
            return this.stream;
        }

        public Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        int getExifOrientation() {
            return this.exifOrientation;
        }
    }

    static BitmapFactory.Options createBitmapOptions(Request request) {
        boolean hasSize = request.hasSize();
        boolean z = request.config != null;
        BitmapFactory.Options options = null;
        if (hasSize || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = hasSize;
            if (z) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void calculateInSampleSize(int i, int i2, BitmapFactory.Options options, Request request) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, request);
    }

    static void calculateInSampleSize(int i, int i2, int i3, int i4, BitmapFactory.Options options, Request request) {
        int min;
        double floor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                floor = Math.floor(i3 / i);
            } else if (i == 0) {
                floor = Math.floor(i4 / i2);
            } else {
                int floor2 = (int) Math.floor(i4 / i2);
                int floor3 = (int) Math.floor(i3 / i);
                if (request.centerInside) {
                    min = Math.max(floor2, floor3);
                } else {
                    min = Math.min(floor2, floor3);
                }
            }
            min = (int) floor;
        } else {
            min = 1;
        }
        options.inSampleSize = min;
        options.inJustDecodeBounds = false;
    }
}
