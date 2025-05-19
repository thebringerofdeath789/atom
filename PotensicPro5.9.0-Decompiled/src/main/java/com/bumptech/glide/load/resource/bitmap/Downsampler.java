package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.util.ByteArrayPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class Downsampler implements BitmapDecoder<InputStream> {
    private static final int MARK_POSITION = 5242880;
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Downsampler AT_LEAST = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        protected int getSampleSize(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.2
        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        protected int getSampleSize(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }
    };
    public static final Downsampler NONE = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.3
        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        protected int getSampleSize(int i, int i2, int i3, int i4) {
            return 0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }
    };

    protected abstract int getSampleSize(int i, int i2, int i3, int i4);

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) {
        int i3;
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        byte[] bytes2 = byteArrayPool.getBytes();
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bytes2);
        ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(obtain);
        try {
            obtain.mark(MARK_POSITION);
            try {
                try {
                    int orientation = new ImageHeaderParser(obtain).getOrientation();
                    try {
                        obtain.reset();
                    } catch (IOException e) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e);
                        }
                    }
                    i3 = orientation;
                } catch (IOException e2) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot determine the image orientation from header", e2);
                    }
                    try {
                        obtain.reset();
                    } catch (IOException e3) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e3);
                        }
                    }
                    i3 = 0;
                }
                defaultOptions.inTempStorage = bytes;
                int[] dimensions = getDimensions(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions);
                int i4 = dimensions[0];
                int i5 = dimensions[1];
                Bitmap downsampleWithSize = downsampleWithSize(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions, bitmapPool, i4, i5, getRoundedSampleSize(TransformationUtils.getExifOrientationDegrees(i3), i4, i5, i, i2), decodeFormat);
                IOException exception = obtain.getException();
                if (exception != null) {
                    throw new RuntimeException(exception);
                }
                Bitmap bitmap = null;
                if (downsampleWithSize != null) {
                    bitmap = TransformationUtils.rotateImageExif(downsampleWithSize, bitmapPool, i3);
                    if (!downsampleWithSize.equals(bitmap) && !bitmapPool.put(downsampleWithSize)) {
                        downsampleWithSize.recycle();
                    }
                }
                return bitmap;
            } finally {
            }
        } finally {
            byteArrayPool.releaseBytes(bytes);
            byteArrayPool.releaseBytes(bytes2);
            obtain.release();
            releaseOptions(defaultOptions);
        }
    }

    private int getRoundedSampleSize(int i, int i2, int i3, int i4, int i5) {
        int sampleSize;
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i == 90 || i == 270) {
            sampleSize = getSampleSize(i3, i2, i4, i5);
        } else {
            sampleSize = getSampleSize(i2, i3, i4, i5);
        }
        return Math.max(1, sampleSize == 0 ? 0 : Integer.highestOneBit(sampleSize));
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2, int i3, DecodeFormat decodeFormat) {
        Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = config;
        if ((options.inSampleSize == 1 || 19 <= Build.VERSION.SDK_INT) && shouldUsePool(markEnforcingInputStream)) {
            double d = i3;
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(i / d), (int) Math.ceil(i2 / d), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    private static boolean shouldUsePool(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                return TYPES_THAT_USE_POOL.contains(new ImageHeaderParser(inputStream).getType());
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot determine the image type from header", e);
                }
                try {
                    inputStream.reset();
                    return false;
                } catch (IOException e2) {
                    if (!Log.isLoggable(TAG, 5)) {
                        return false;
                    }
                    Log.w(TAG, "Cannot reset the input stream", e2);
                    return false;
                }
            }
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e3) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot reset the input stream", e3);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (android.util.Log.isLoggable(com.bumptech.glide.load.resource.bitmap.Downsampler.TAG, 5) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        android.util.Log.w(com.bumptech.glide.load.resource.bitmap.Downsampler.TAG, "Cannot reset the input stream", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005a, code lost:
    
        if (android.util.Log.isLoggable(com.bumptech.glide.load.resource.bitmap.Downsampler.TAG, 5) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap.Config getConfig(java.io.InputStream r7, com.bumptech.glide.load.DecodeFormat r8) {
        /*
            java.lang.String r0 = "Cannot reset the input stream"
            java.lang.String r1 = "Downsampler"
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888
            if (r8 == r2) goto L74
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r8 == r2) goto L74
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r2 != r3) goto L13
            goto L74
        L13:
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            r7.mark(r3)
            r3 = 5
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r2 = r4.hasAlpha()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r7.reset()     // Catch: java.io.IOException -> L27
            goto L5d
        L27:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5d
        L2e:
            android.util.Log.w(r1, r0, r7)
            goto L5d
        L32:
            r8 = move-exception
            goto L65
        L34:
            r4 = move-exception
            boolean r5 = android.util.Log.isLoggable(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "Cannot determine whether the image has alpha or not from header for format "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L32
            java.lang.StringBuilder r8 = r5.append(r8)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L32
            android.util.Log.w(r1, r8, r4)     // Catch: java.lang.Throwable -> L32
        L51:
            r7.reset()     // Catch: java.io.IOException -> L55
            goto L5d
        L55:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5d
            goto L2e
        L5d:
            if (r2 == 0) goto L62
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L64
        L62:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L64:
            return r7
        L65:
            r7.reset()     // Catch: java.io.IOException -> L69
            goto L73
        L69:
            r7 = move-exception
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L73
            android.util.Log.w(r1, r0, r7)
        L73:
            throw r8
        L74:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.getConfig(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap decodeStream(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(MARK_POSITION);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markEnforcingInputStream, null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return decodeStream;
    }

    private static void setInBitmap(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }
}
