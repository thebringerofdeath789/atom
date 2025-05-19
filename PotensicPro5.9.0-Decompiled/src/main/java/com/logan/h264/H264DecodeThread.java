package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H264DecodeThread extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private ConcurrentLinkedQueue<byte[]> frameNal = new ConcurrentLinkedQueue<>();
    private Object lock = new Object();
    private boolean isStart = false;

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        if (this.isStart) {
            if (this.frameNal.size() < 20) {
                this.frameNal.offer(bArr);
            } else {
                this.frameNal.clear();
                H264Player.flush();
            }
        }
    }

    @Override // com.logan.h264.IDecoder
    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.h264.IDecoder
    public void release(OnResultListener onResultListener) {
        this.decodeListener = onResultListener;
        this.isStart = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] hexStringToByte = ParseUtil.hexStringToByte("000000016764001fac2c6a81001269b808080810d5fab01197ca80d3d69a930d030ea3740000000168ee31b21b2c6a81001269b808080810d5fab01197");
        boolean isHardDecode = SPHelper.getInstance().isHardDecode();
        if (H264Player.init(isHardDecode, hexStringToByte, hexStringToByte.length) != 0) {
            DDLog.e("解码失败 切换解码 是否硬解码:" + (!isHardDecode));
            H264Player.init(!isHardDecode, hexStringToByte, hexStringToByte.length);
        }
        DDLog.e("开始解码");
        this.isStart = true;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (this.isStart) {
            while (this.isStart && this.frameNal.size() > 0) {
                try {
                    byte[] poll = this.frameNal.poll();
                    if (!z) {
                        if (poll.length > 5 && poll[0] == 0 && poll[1] == 0 && poll[2] == 0 && poll[3] == 1 && poll[4] == 103) {
                            try {
                                H264Player.decode(poll, poll.length);
                                z2 = true;
                            } catch (Exception unused) {
                                z2 = true;
                            }
                        }
                        if (poll.length > 5 && poll[0] == 0 && poll[1] == 0 && poll[2] == 0 && poll[3] == 1 && poll[4] == 104) {
                            try {
                                H264Player.decode(poll, poll.length);
                                z3 = true;
                            } catch (Exception unused2) {
                                z3 = true;
                            }
                        }
                        if (z2 && z3 && poll.length > 5 && poll[0] == 0 && poll[1] == 0 && poll[2] == 0 && poll[3] == 1 && poll[4] == 6) {
                            try {
                                H264Player.decode(poll, poll.length);
                                z = true;
                            } catch (Exception unused3) {
                                z = true;
                            }
                        }
                    } else {
                        H264Player.decode(poll, poll.length);
                    }
                } catch (Exception unused4) {
                }
            }
            Thread.sleep(2L);
        }
        this.frameNal.clear();
        H264Player.destroy();
        OnResultListener<Boolean> onResultListener = this.decodeListener;
        if (onResultListener != null) {
            onResultListener.onSuccess(true);
        }
        DDLog.e("退出解码");
    }
}
