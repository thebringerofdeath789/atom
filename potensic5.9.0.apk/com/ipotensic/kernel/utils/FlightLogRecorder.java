package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.CommonUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class FlightLogRecorder {
    private static volatile FlightLogRecorder instance;
    private String fileName;
    private OnReleaseListener releaseListener;
    private Thread writeThread;
    private final String FILE_TAIL = LocalFileManager.LOG_TAIL;
    private final String FILE_TAIL1 = ".fc";
    private boolean isStart = false;
    private final Queue<byte[]> dataQueue = new LinkedBlockingQueue();
    private int saveNum = 0;
    private final int FLIGHT_CTRL_LOG_UNIT_LENGTH = 512;
    private String lastFlightType = null;

    public interface OnReleaseListener {
        void onRelease();
    }

    private FlightLogRecorder() {
    }

    public static FlightLogRecorder getInstance() {
        if (instance == null) {
            synchronized (FlightLogRecorder.class) {
                if (instance == null) {
                    FlightLogRecorder flightLogRecorder = new FlightLogRecorder();
                    instance = flightLogRecorder;
                    return flightLogRecorder;
                }
            }
        }
        return instance;
    }

    public boolean isStart() {
        return this.isStart;
    }

    public String getLastFlightType() {
        return this.lastFlightType;
    }

    public void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        if (this.writeThread == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.ipotensic.kernel.utils.FlightLogRecorder.1
                /* JADX WARN: Removed duplicated region for block: B:63:0x0183  */
                /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 402
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.utils.FlightLogRecorder.RunnableC24941.run():void");
                }
            });
            this.writeThread = thread;
            thread.start();
        }
    }

    public void write(byte[] bArr) {
        if (bArr != null && this.isStart && this.dataQueue.size() < 5) {
            if (FlightRevData.get().getFlightRevFpvData().getFunctionCode() == 10) {
                byte[] bArr2 = new byte[4];
                ParseUtil.intSmallByteArr(this.saveNum, bArr2, 0);
                byte[] concatAll = ParseUtil.concatAll(bArr2, new byte[]{FlightRevData.get().getFlightRevFlightInfoData().getSatellitesNumByte()}, FlightRevData.get().getFlightRevBatteryData().getVoltageBytes(), bArr, FlightRevData.get().getFlightRevStateData().getFlightInfoBytes());
                if (concatAll.length < 128) {
                    concatAll = ParseUtil.concatAll(concatAll, new byte[128 - concatAll.length]);
                }
                this.dataQueue.offer(concatAll);
                this.saveNum++;
                return;
            }
            if (FlightRevData.get().getFlightRevFpvData().getFunctionCode() == 12) {
                byte[] bArr3 = new byte[5];
                ParseUtil.intSmallByteArr(this.saveNum, bArr3, 0);
                byte[] concatAll2 = ParseUtil.concatAll(bArr3, bArr);
                if (concatAll2.length < 512) {
                    concatAll2 = ParseUtil.concatAll(concatAll2, new byte[512 - concatAll2.length]);
                }
                this.dataQueue.offer(concatAll2);
                this.saveNum++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNewFcVersion() {
        return FlightConfig.is_Atom_Series() && CommonUtil.hasNewVersion("3.2.5", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion());
    }

    public void stop(OnReleaseListener onReleaseListener) {
        this.releaseListener = onReleaseListener;
        if (this.writeThread == null) {
            if (onReleaseListener != null) {
                onReleaseListener.onRelease();
            }
            this.releaseListener = null;
        }
        DDLog.m1684e("停止存储日志");
        this.isStart = false;
    }
}