package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public final class RawResourceDataSource extends BaseDataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private final String packageName;
    private final Resources resources;
    private Uri uri;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(Throwable th) {
            super(th);
        }
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse(new StringBuilder(26).append("rawresource:///").append(i).toString());
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.resources = context.getResources();
        this.packageName = context.getPackageName();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        int parseInt;
        Uri uri = dataSpec.uri;
        this.uri = uri;
        if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) Assertions.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = Integer.parseInt((String) Assertions.checkNotNull(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } else if (TextUtils.equals("android.resource", uri.getScheme())) {
            String str = (String) Assertions.checkNotNull(uri.getPath());
            if (str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                str = str.substring(1);
            }
            String host = uri.getHost();
            String valueOf = String.valueOf(TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(":"));
            String valueOf2 = String.valueOf(str);
            parseInt = this.resources.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), "raw", this.packageName);
            if (parseInt == 0) {
                throw new RawResourceDataSourceException("Resource not found.");
            }
        } else {
            throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
        }
        transferInitializing(dataSpec);
        try {
            AssetFileDescriptor openRawResourceFd = this.resources.openRawResourceFd(parseInt);
            this.assetFileDescriptor = openRawResourceFd;
            if (openRawResourceFd == null) {
                String valueOf3 = String.valueOf(uri);
                throw new RawResourceDataSourceException(new StringBuilder(String.valueOf(valueOf3).length() + 24).append("Resource is compressed: ").append(valueOf3).toString());
            }
            long length = openRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
            this.inputStream = fileInputStream;
            if (length != -1) {
                try {
                    if (dataSpec.position > length) {
                        throw new DataSourceException(0);
                    }
                } catch (IOException e) {
                    throw new RawResourceDataSourceException(e);
                }
            }
            long startOffset = openRawResourceFd.getStartOffset();
            long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
            if (skip != dataSpec.position) {
                throw new DataSourceException(0);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.bytesRemaining = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.bytesRemaining = size;
                    if (size < 0) {
                        throw new DataSourceException(0);
                    }
                }
            } else {
                long j = length - skip;
                this.bytesRemaining = j;
                if (j < 0) {
                    throw new DataSourceException(0);
                }
            }
            if (dataSpec.length != -1) {
                long j2 = this.bytesRemaining;
                this.bytesRemaining = j2 == -1 ? dataSpec.length : Math.min(j2, dataSpec.length);
            }
            this.opened = true;
            transferStarted(dataSpec);
            return dataSpec.length != -1 ? dataSpec.length : this.bytesRemaining;
        } catch (Resources.NotFoundException e2) {
            throw new RawResourceDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
        if (read == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException(new EOFException());
        }
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - read;
        }
        bytesTransferred(read);
        return read;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            try {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                }
            } catch (Throwable th) {
                this.inputStream = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.assetFileDescriptor = null;
                        if (this.opened) {
                            this.opened = false;
                            transferEnded();
                        }
                        throw th;
                    } catch (IOException e2) {
                        throw new RawResourceDataSourceException(e2);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                }
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException(e3);
        }
    }
}
