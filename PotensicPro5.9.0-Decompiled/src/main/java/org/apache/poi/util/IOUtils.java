package org.apache.poi.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.CRC32;
import org.apache.poi.EmptyFileException;

/* loaded from: classes5.dex */
public final class IOUtils {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) IOUtils.class);

    private IOUtils() {
    }

    public static byte[] peekFirst8Bytes(InputStream inputStream) throws IOException, EmptyFileException {
        inputStream.mark(8);
        byte[] bArr = new byte[8];
        if (readFully(inputStream, bArr) < 1) {
            throw new EmptyFileException();
        }
        if (inputStream instanceof PushbackInputStream) {
            ((PushbackInputStream) inputStream).unread(bArr);
        } else {
            inputStream.reset();
        }
        return bArr;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        int i = 0;
        while (i != -1) {
            i = inputStream.read(bArr);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(ByteBuffer byteBuffer, int i) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            i3 += read;
        } while (i3 != i2);
        return i3;
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        do {
            int read = readableByteChannel.read(byteBuffer);
            if (read >= 0) {
                i += read;
                if (i == byteBuffer.capacity()) {
                    break;
                }
            } else {
                if (i == 0) {
                    return -1;
                }
                return i;
            }
        } while (byteBuffer.position() != byteBuffer.capacity());
        return i;
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static long calculateChecksum(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, bArr.length);
        return crc32.getValue();
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            logger.log(7, (Object) ("Unable to close resource: " + e), (Throwable) e);
        }
    }
}
