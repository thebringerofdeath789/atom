package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.h264.Buffer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class TestDecoder extends IDecoder {
    private Buffer buffer;
    private OnResultListener<Boolean> decodeListener;
    private long decodeTime;
    private FileOutputStream h264OutputStream;
    private long h264Time;
    private FileOutputStream infoOutputStream;
    private long startTime;
    private final String TAG = "DDLog";
    private boolean isStart = false;
    private ConcurrentLinkedQueue<byte[]> frameNal = new ConcurrentLinkedQueue<>();

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        DDLog.e("DDLog", "收到预览数据: size:" + bArr.length + " , payload :" + ParseUtil.byteToHexString(bArr, 100));
        try {
            if (this.h264OutputStream == null) {
                this.h264OutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getLogDir(), "h264.h264"));
            }
            this.h264OutputStream.write(bArr);
        } catch (Exception e) {
            DDLog.e("DDLog", "存储error1:" + e);
        }
        try {
            if (this.infoOutputStream == null) {
                this.infoOutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getLogDir(), "revData.log"));
            }
            String str = "耗时 ： " + (System.currentTimeMillis() - this.startTime) + "     收到h264 ： 长度 : " + bArr.length + " , data:" + ParseUtil.byteToHexString(bArr, 20);
            this.startTime = System.currentTimeMillis();
            this.infoOutputStream.write("\n".getBytes());
            this.infoOutputStream.write(str.getBytes());
        } catch (Exception e2) {
            DDLog.e("DDLog", "存储error:" + e2);
        }
        if (this.buffer == null) {
            this.buffer = new Buffer(new Buffer.OnFrameOutputListener() { // from class: com.logan.h264.TestDecoder.1
                @Override // com.logan.h264.Buffer.OnFrameOutputListener
                public void output(byte[] bArr2) {
                    try {
                        String str2 = "取出完整h264耗时 ： " + (System.currentTimeMillis() - TestDecoder.this.h264Time) + "  , data:" + ParseUtil.byteToHexString(bArr2, 20);
                        DDLog.e("取出完整一帧：" + str2);
                        TestDecoder.this.h264Time = System.currentTimeMillis();
                        TestDecoder.this.infoOutputStream.write("\n\n".getBytes());
                        TestDecoder.this.infoOutputStream.write(str2.getBytes());
                        TestDecoder.this.infoOutputStream.write("\n\n".getBytes());
                    } catch (Exception unused) {
                    }
                    if (TestDecoder.this.frameNal.size() < 30) {
                        TestDecoder.this.frameNal.offer(bArr2);
                    }
                }
            });
        }
        this.buffer.parse(bArr);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.isStart = true;
        initPlayer();
        while (this.isStart) {
            try {
                if (this.frameNal.size() > 0) {
                    byte[] poll = this.frameNal.poll();
                    H264Player.decode(poll, poll.length);
                    try {
                        String str = "解码h264耗时 ： " + (System.currentTimeMillis() - this.decodeTime) + "  , data:" + ParseUtil.byteToHexString(poll, 20);
                        DDLog.e("DDLog", "收到预览数据：" + str);
                        this.decodeTime = System.currentTimeMillis();
                        this.infoOutputStream.write("\n\n".getBytes());
                        this.infoOutputStream.write(str.getBytes());
                        this.infoOutputStream.write("\n\n".getBytes());
                    } catch (Exception unused) {
                    }
                }
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.frameNal.clear();
        H264Player.destroy();
        OnResultListener<Boolean> onResultListener = this.decodeListener;
        if (onResultListener != null) {
            onResultListener.onSuccess(true);
        }
    }

    @Override // com.logan.h264.IDecoder
    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.h264.IDecoder
    public void release(OnResultListener<Boolean> onResultListener) {
        this.isStart = false;
        this.decodeListener = onResultListener;
    }

    private void initPlayer() {
        H264Player.destroy();
        byte[] hexStringToByte = ParseUtil.hexStringToByte("000000016764001fac2c6a81001269b808080810d5fab01197ca80d3d69a930d030ea3740000000168ee31b21b2c6a81001269b808080810d5fab01197");
        boolean isHardDecode = SPHelper.getInstance().isHardDecode();
        if (H264Player.init(isHardDecode, hexStringToByte, hexStringToByte.length) != 0) {
            DDLog.e("DDLog", "解码失败 切换解码 是否硬解码:" + (!isHardDecode));
            H264Player.init(!isHardDecode, hexStringToByte, hexStringToByte.length);
        }
        DDLog.e("DDLog", "开始解码");
    }
}
