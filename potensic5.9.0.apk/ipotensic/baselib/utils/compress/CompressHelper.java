package com.ipotensic.baselib.utils.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

/* loaded from: classes2.dex */
public class CompressHelper {
    private static volatile CompressHelper INSTANCE;
    private Bitmap.Config bitmapConfig;
    private Bitmap.CompressFormat compressFormat;
    private Context context;
    private String destinationDirectoryPath;
    private String fileName;
    private String fileNamePrefix;
    private float maxHeight;
    private float maxWidth;
    private int quality;

    public static CompressHelper getDefault(Context context) {
        if (INSTANCE == null) {
            synchronized (CompressHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CompressHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    private CompressHelper(Context context) {
        this.maxWidth = 720.0f;
        this.maxHeight = 960.0f;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.quality = 80;
        this.context = context;
        this.destinationDirectoryPath = context.getCacheDir().getPath() + File.pathSeparator + "CompressHelper";
    }

    public File compressToFile(File file) {
        return BitmapUtil.compressImage(this.context, Uri.fromFile(file), this.maxWidth, this.maxHeight, this.compressFormat, this.bitmapConfig, this.quality, this.destinationDirectoryPath, this.fileNamePrefix, this.fileName);
    }

    public Bitmap compressToBitmap(File file) {
        return BitmapUtil.getScaledBitmap(this.context, Uri.fromFile(file), this.maxWidth, this.maxHeight, this.bitmapConfig);
    }

    public static class Builder {
        private CompressHelper mCompressHelper;

        public Builder(Context context) {
            this.mCompressHelper = new CompressHelper(context);
        }

        public Builder setMaxWidth(float f) {
            this.mCompressHelper.maxWidth = f;
            return this;
        }

        public Builder setMaxHeight(float f) {
            this.mCompressHelper.maxHeight = f;
            return this;
        }

        public Builder setCompressFormat(Bitmap.CompressFormat compressFormat) {
            this.mCompressHelper.compressFormat = compressFormat;
            return this;
        }

        public Builder setBitmapConfig(Bitmap.Config config) {
            this.mCompressHelper.bitmapConfig = config;
            return this;
        }

        public Builder setQuality(int i) {
            this.mCompressHelper.quality = i;
            return this;
        }

        public Builder setDestinationDirectoryPath(String str) {
            this.mCompressHelper.destinationDirectoryPath = str;
            return this;
        }

        public Builder setFileNamePrefix(String str) {
            this.mCompressHelper.fileNamePrefix = str;
            return this;
        }

        public Builder setFileName(String str) {
            this.mCompressHelper.fileName = str;
            return this;
        }

        public CompressHelper build() {
            return this.mCompressHelper;
        }
    }
}