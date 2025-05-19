package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final int[] pct = new int[256];
    private final byte[] block = new byte[256];
    private GifHeader header = new GifHeader();

    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public int getDelay(int i) {
        if (i < 0 || i >= this.header.frameCount) {
            return -1;
        }
        return this.header.frames.get(i).delay;
    }

    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i);
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        return this.header.loopCount;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount == 0) {
            return 0;
        }
        return this.header.loopCount + 1;
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "unable to decode frame, frameCount=" + this.header.frameCount + " framePointer=" + this.framePointer);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i2 = this.framePointer - 1;
            GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
            int[] iArr = gifFrame.lct != null ? gifFrame.lct : this.header.gct;
            this.act = iArr;
            if (iArr == null) {
                String str2 = TAG;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No Valid Color Table");
                }
                this.status = 1;
                return null;
            }
            if (gifFrame.transparency) {
                int[] iArr2 = this.act;
                System.arraycopy(iArr2, 0, this.pct, 0, iArr2.length);
                int[] iArr3 = this.pct;
                this.act = iArr3;
                iArr3[gifFrame.transIndex] = 0;
            }
            return setPixels(gifFrame, gifFrame2);
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
        return null;
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.mainPixels = new byte[gifHeader.width * gifHeader.height];
        this.mainScratch = new int[gifHeader.width * gifHeader.height];
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.mainPixels = new byte[this.header.width * this.header.height];
            this.mainScratch = new int[this.header.width * this.header.height];
            this.savePrevious = false;
            Iterator<GifFrame> it = this.header.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r17.header.bgIndex == r18.transIndex) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap setPixels(com.bumptech.glide.gifdecoder.GifFrame r18, com.bumptech.glide.gifdecoder.GifFrame r19) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.setPixels(com.bumptech.glide.gifdecoder.GifFrame, com.bumptech.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28, types: [short] */
    /* JADX WARN: Type inference failed for: r2v30 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        short s;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        int i3 = gifFrame == null ? this.header.width * this.header.height : gifFrame.ih * gifFrame.iw;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i3) {
            this.mainPixels = new byte[i3];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int read = read();
        int i4 = 1;
        int i5 = 1 << read;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = read + 1;
        int i9 = (1 << i8) - 1;
        for (int i10 = 0; i10 < i5; i10++) {
            this.prefix[i10] = 0;
            this.suffix[i10] = (byte) i10;
        }
        int i11 = -1;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        while (true) {
            if (i15 >= i3) {
                break;
            }
            if (i16 == 0) {
                i16 = readBlock();
                if (i16 <= 0) {
                    this.status = 3;
                    break;
                }
                i17 = 0;
            }
            i19 += (this.block[i17] & 255) << i18;
            i18 += 8;
            i17 += i4;
            i16 += i11;
            int i24 = i13;
            int i25 = i12;
            int i26 = i23;
            int i27 = i21;
            while (i18 >= i25) {
                int i28 = i19 & i14;
                i19 >>= i25;
                i18 -= i25;
                if (i28 != i5) {
                    if (i28 > i24) {
                        i = i8;
                        this.status = 3;
                    } else {
                        i = i8;
                        if (i28 != i6) {
                            if (i26 == -1) {
                                this.pixelStack[i22] = this.suffix[i28];
                                i26 = i28;
                                i27 = i26;
                                i22++;
                                i8 = i;
                            } else {
                                if (i28 >= i24) {
                                    i2 = i6;
                                    this.pixelStack[i22] = (byte) i27;
                                    s = i26;
                                    i22++;
                                } else {
                                    i2 = i6;
                                    s = i28;
                                }
                                while (s >= i5) {
                                    this.pixelStack[i22] = this.suffix[s];
                                    s = this.prefix[s];
                                    i22++;
                                    i5 = i5;
                                }
                                int i29 = i5;
                                byte[] bArr2 = this.suffix;
                                int i30 = bArr2[s] & 255;
                                int i31 = i22 + 1;
                                int i32 = i7;
                                byte b = (byte) i30;
                                this.pixelStack[i22] = b;
                                if (i24 < 4096) {
                                    this.prefix[i24] = (short) i26;
                                    bArr2[i24] = b;
                                    i24++;
                                    if ((i24 & i14) == 0 && i24 < 4096) {
                                        i25++;
                                        i14 += i24;
                                    }
                                }
                                i22 = i31;
                                while (i22 > 0) {
                                    i22--;
                                    this.mainPixels[i20] = this.pixelStack[i22];
                                    i15++;
                                    i20++;
                                }
                                i26 = i28;
                                i5 = i29;
                                i6 = i2;
                                i7 = i32;
                                i27 = i30;
                                i8 = i;
                            }
                        }
                    }
                    i13 = i24;
                    i12 = i25;
                    i23 = i26;
                    i8 = i;
                    i21 = i27;
                    break;
                }
                i25 = i8;
                i24 = i7;
                i14 = i9;
                i26 = -1;
            }
            i13 = i24;
            i12 = i25;
            i21 = i27;
            i23 = i26;
            i6 = i6;
            i4 = 1;
            i11 = -1;
        }
        for (int i33 = i20; i33 < i3; i33++) {
            this.mainPixels[i33] = 0;
        }
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    private int readBlock() {
        int read = read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                int i2 = read - i;
                try {
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(TAG, "Error Reading Block", e);
                    this.status = 1;
                }
            }
        }
        return i;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        int i = this.header.width;
        int i2 = this.header.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider.obtain(i, i2, config);
        if (obtain == null) {
            obtain = Bitmap.createBitmap(this.header.width, this.header.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private static void setAlpha(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
