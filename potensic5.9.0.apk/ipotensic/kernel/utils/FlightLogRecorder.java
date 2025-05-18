package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import java.io.File;
import java.io.FileOutputStream;
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
                */
                public void run() {
                    FileOutputStream fileOutputStream;
                    DDLog.w("\u5f00\u59cb\u5b58\u50a8\u65e5\u5fd7");
                    String str = null;
                    while (FlightLogRecorder.this.isStart && (str = FlightConfig.getLogName()) == null) {
                        try {
                            Thread.sleep(10L);
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = null;
                        }
                    }
                    LocalFileManager.getInstance().deleteOldLogFiles(LocalFileManager.getInstance().getFlightLogDir());
                    FlightLogRecorder.this.fileName = FormatUtil.getCurTime() + "-" + str + LocalFileManager.ANDROID_TAG + PhoneConfig.deviceBrand + "-FC" + (FlightLogRecorder.this.isNewFcVersion() ? ".fc" : LocalFileManager.LOG_TAIL);
                    FlightLogRecorder.this.lastFlightType = str;
                    DDLog.w("\u5b58\u50a8\u8def\u5f84:" + FlightLogRecorder.this.fileName);
                    LocalFileManager.getInstance().clearOldLogFile();
                    DDLog.w("\u5df2\u6e05\u9664\u65e7\u65e5\u5fd7");
                    FileOutputStream fileOutputStream2 = str != null ? new FileOutputStream(new File(LocalFileManager.getInstance().getFlightLogDir(), FlightLogRecorder.this.fileName)) : null;
                    while (FlightLogRecorder.this.isStart) {
                        try {
                            if (!FlightLogRecorder.this.dataQueue.isEmpty()) {
                                while (FlightLogRecorder.this.dataQueue.size() > 0) {
                                    fileOutputStream2.write((byte[]) FlightLogRecorder.this.dataQueue.remove());
                                    fileOutputStream2.flush();
                                }
                            } else {
                                Thread.sleep(1L);
                            }
                        } catch (Exception e2) {
                            fileOutputStream = fileOutputStream2;
                            e = e2;
                            try {
                                DDLog.e("\u5b58\u50a8\u98de\u884c\u65e5\u5fd7\u51fa\u73b0\u9519\u8bef:" + e.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                FlightLogRecorder.this.isStart = false;
                                FlightLogRecorder.this.writeThread = null;
                                FlightLogRecorder.this.saveNum = 0;
                                if (FlightLogRecorder.this.releaseListener == null) {
                                    return;
                                }
                                FlightLogRecorder.this.releaseListener.onRelease();
                                FlightLogRecorder.this.releaseListener = null;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                FlightLogRecorder.this.isStart = false;
                                FlightLogRecorder.this.writeThread = null;
                                FlightLogRecorder.this.saveNum = 0;
                                if (FlightLogRecorder.this.releaseListener == null) {
                                    FlightLogRecorder.this.releaseListener.onRelease();
                                    FlightLogRecorder.this.releaseListener = null;
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            fileOutputStream = fileOutputStream2;
                            th = th3;
                            if (fileOutputStream != null) {
                            }
                            FlightLogRecorder.this.isStart = false;
                            FlightLogRecorder.this.writeThread = null;
                            FlightLogRecorder.this.saveNum = 0;
                            if (FlightLogRecorder.this.releaseListener == null) {
                            }
                        }
                    }
                    DDLog.w("\u5b58\u50a8\u65e5\u5fd7\u5b8c\u6210");
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    FlightLogRecorder.this.isStart = false;
                    FlightLogRecorder.this.writeThread = null;
                    FlightLogRecorder.this.saveNum = 0;
                    if (FlightLogRecorder.this.releaseListener == null) {
                        return;
                    }
                    FlightLogRecorder.this.releaseListener.onRelease();
                    FlightLogRecorder.this.releaseListener = null;
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
        DDLog.e("\u505c\u6b62\u5b58\u50a8\u65e5\u5fd7");
        this.isStart = false;
    }
}