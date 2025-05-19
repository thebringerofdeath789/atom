package xyz.doikki.videoplayer.ijk;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.util.InternalZipConstants;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* loaded from: classes6.dex */
public class RawDataSourceProvider implements IMediaDataSource {
    private AssetFileDescriptor mDescriptor;
    private byte[] mMediaBytes;

    public RawDataSourceProvider(AssetFileDescriptor assetFileDescriptor) {
        this.mDescriptor = assetFileDescriptor;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        long j2 = 1 + j;
        byte[] bArr2 = this.mMediaBytes;
        if (j2 >= bArr2.length) {
            return -1;
        }
        if (i2 + j >= bArr2.length) {
            int length = (int) (bArr2.length - j);
            if (length > bArr.length) {
                length = bArr.length;
            }
            i2 = length - 1;
        }
        System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() throws IOException {
        long length = this.mDescriptor.getLength();
        if (this.mMediaBytes == null) {
            this.mMediaBytes = readBytes(this.mDescriptor.createInputStream());
        }
        return length;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() throws IOException {
        AssetFileDescriptor assetFileDescriptor = this.mDescriptor;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.mDescriptor = null;
        this.mMediaBytes = null;
    }

    private byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static RawDataSourceProvider create(Context context, Uri uri) {
        try {
            return new RawDataSourceProvider(context.getContentResolver().openAssetFileDescriptor(uri, InternalZipConstants.READ_MODE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
