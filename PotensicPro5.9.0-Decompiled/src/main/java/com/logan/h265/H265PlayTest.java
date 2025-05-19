package com.logan.h265;

import android.os.Environment;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.h264.H264Player;
import com.logan.nativeapp.DDLog;
import com.logan.nativeapp.H265Frame;
import com.logan.nativeapp.H265ToByteProvider;
import com.logan.nativeapp.H265Type;
import com.logan.nativeapp.SpsParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class H265PlayTest {
    public void test() {
        File file = new File(Environment.getExternalStorageDirectory(), "h265_1920_1080.h265");
        if (!file.exists()) {
            DDLog.e("文件不存在");
            return;
        }
        H265ToByteProvider h265ToByteProvider = new H265ToByteProvider();
        h265ToByteProvider.init(file.getAbsolutePath());
        h265ToByteProvider.parse();
        testSoft(h265ToByteProvider.getFrames());
    }

    private void testSoft(final ArrayList<H265Frame> arrayList) {
        new Thread(new Runnable() { // from class: com.logan.h265.H265PlayTest.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SpsParser spsParser = new SpsParser();
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = arrayList.iterator();
                    byte[] bArr = null;
                    long j = currentTimeMillis;
                    boolean z = false;
                    byte[] bArr2 = null;
                    byte[] bArr3 = null;
                    while (true) {
                        if (it.hasNext()) {
                            H265Frame h265Frame = (H265Frame) it.next();
                            try {
                                if (h265Frame.getNalType() == H265Type.TYPE_IDR || h265Frame.getNalType() == H265Type.TYPE_SS) {
                                    if (System.currentTimeMillis() - j < 39) {
                                        Thread.sleep(39 - (System.currentTimeMillis() - j));
                                    }
                                    j = System.currentTimeMillis();
                                }
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            if (h265Frame.getNalType() == H265Type.TYPE_VPS) {
                                bArr2 = h265Frame.getData();
                            } else if (h265Frame.getNalType() == H265Type.TYPE_SPS) {
                                bArr3 = h265Frame.getData();
                            } else if (h265Frame.getNalType() == H265Type.TYPE_PPS) {
                                bArr = h265Frame.getData();
                            }
                            if (!z && bArr2 != null && bArr3 != null && bArr != null) {
                                int length = bArr3.length - 4;
                                byte[] bArr4 = new byte[length];
                                System.arraycopy(bArr3, 4, bArr4, 0, length);
                                DDLog.e("开始解析");
                                int[] h265VideoWidthAndHeight = spsParser.getH265VideoWidthAndHeight(bArr4, length);
                                DDLog.e("解析完成");
                                if (h265VideoWidthAndHeight == null) {
                                    DDLog.e("解析错误");
                                    break;
                                }
                                DDLog.e("width:" + h265VideoWidthAndHeight[0]);
                                DDLog.e("height:" + h265VideoWidthAndHeight[1]);
                                byte[] concatAll = ParseUtil.concatAll(bArr2, bArr3, bArr);
                                H264Player.init(false, concatAll, concatAll.length);
                                z = true;
                            }
                            if (z) {
                                if (h265Frame.getNalType() == H265Type.TYPE_IDR) {
                                    byte[] concatAll2 = ParseUtil.concatAll(bArr2, bArr3, bArr, h265Frame.getData());
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    H264Player.decode(concatAll2, concatAll2.length);
                                    DDLog.e("IDR解码时间:" + (System.currentTimeMillis() - currentTimeMillis2));
                                }
                                if (h265Frame.getNalType() == H265Type.TYPE_SS) {
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    H264Player.decode(h265Frame.getData(), h265Frame.getData().length);
                                    DDLog.e("SS解码时间:" + (System.currentTimeMillis() - currentTimeMillis3));
                                }
                            }
                        }
                    }
                    H264Player.destroy();
                }
            }
        }).start();
    }

    private void testHard(final ArrayList<H265Frame> arrayList) {
        new Thread(new Runnable() { // from class: com.logan.h265.H265PlayTest.2
            /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x009b A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0110 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0027 A[ADDED_TO_REGION, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 307
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.h265.H265PlayTest.AnonymousClass2.run():void");
            }
        }).start();
    }
}
