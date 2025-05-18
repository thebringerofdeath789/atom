package com.logan.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.camera.CameraLogRecorder;
import com.logan.factory.DecodeTransaction;
import com.logan.factory.DecoderFactory;
import com.logan.flight.DataReceiver;
import com.logan.flight.data.FlightSendData;
import com.logan.h264.IDecoder;
import com.logan.usb.kuxinwei.FactorDataParser;
import com.logan.usb.parser_new.AsyncUsbParser;
import com.logan.usb.parser_new.Frame;
import com.logan.usb.parser_new.UsbBytes;
import com.logan.usb.utils.UsbDataWrapper;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class AOAEngine {
    private static volatile AOAEngine instance;
    private Thread accessoryThread;
    private Context context;
    private IDecoder h264Decoder;
    private UsbManager usbManager;
    private final String TAG = "DDLog-AOAENGINE";
    private final String ACTION_USB_PERMISSION = "com.logan.aoa.USB_PERMISSION";
    private volatile boolean isAccessoryConnected = false;
    private final AtomicBoolean Quit = new AtomicBoolean(true);
    private UsbAccessory Accessory = null;
    private ParcelFileDescriptor parcelFileDescriptor = null;
    private FileDescriptor fileDescriptor = null;
    private FileInputStream inputStream = null;
    private FileOutputStream outputStream = null;
    private AsyncUsbParser usbParser = null;
    private final Set<IEngineCallback> callbacks = new CopyOnWriteArraySet();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable connectRunnable = null;
    private final BroadcastReceiver usbAttachedReceiver = new BroadcastReceiver() { // from class: com.logan.usb.AOAEngine.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            DDLog.m1685e("DDLog-AOAENGINE", "onReceive: " + action);
            if ("android.hardware.usb.action.USB_ACCESSORY_DETACHED".equals(intent.getAction())) {
                DDLog.m1685e("DDLog-AOAENGINE", "收到广播:断开 " + action);
                AOAEngine.this.Quit.set(true);
                AOAEngine.this.Accessory = null;
                return;
            }
            if ("android.hardware.usb.action.USB_ACCESSORY_ATTACHED".equals(intent.getAction())) {
                DDLog.m1685e("DDLog-AOAENGINE", "收到广播:连接 " + action);
                return;
            }
            if ("android.hardware.usb.action.USB_STATE".equals(intent.getAction())) {
                if (intent.getExtras().getBoolean("connected")) {
                    DDLog.m1685e("DDLog-AOAENGINE", "收到广播:插入0 " + action);
                    DDLog.m1685e("DDLog-AOAENGINE", "收到广播:插入1 " + AOAEngine.this.connectRunnable);
                    if (AOAEngine.this.connectRunnable == null) {
                        AOAEngine.this.connectRunnable = new Runnable() { // from class: com.logan.usb.AOAEngine.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AOAEngine.this.isRunning()) {
                                    return;
                                }
                                AOAEngine.this.start();
                                AOAEngine.this.handler.postDelayed(this, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                            }
                        };
                    }
                    AOAEngine.this.handler.removeCallbacks(AOAEngine.this.connectRunnable);
                    AOAEngine.this.handler.postDelayed(AOAEngine.this.connectRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
                DDLog.m1685e("DDLog-AOAENGINE", "收到广播:拔出 " + action);
                AOAEngine.this.Quit.set(true);
                AOAEngine.this.Accessory = null;
                if (AOAEngine.this.connectRunnable != null) {
                    AOAEngine.this.handler.removeCallbacks(AOAEngine.this.connectRunnable);
                    AOAEngine.this.connectRunnable = null;
                    DDLog.m1685e("DDLog-AOAENGINE", "清空 runnable ");
                }
            }
        }
    };
    private final BroadcastReceiver mPermissionReceiver = new BroadcastReceiver() { // from class: com.logan.usb.AOAEngine.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AOAEngine.this.context.unregisterReceiver(AOAEngine.this.mPermissionReceiver);
            DDLog.m1683d("DDLog-AOAENGINE", "接收权限同意广播: ");
            if (intent.getBooleanExtra("permission", false)) {
                AOAEngine.this.connect(false);
            }
        }
    };
    private final Runnable accessoryRunnable = new Runnable() { // from class: com.logan.usb.AOAEngine.5
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                Process.setThreadPriority(-1);
                if (AOAEngine.this.isRunning()) {
                    return;
                }
                DDLog.m1685e("DDLog-AOAENGINE", "已连接上");
                try {
                    AOAEngine aOAEngine = AOAEngine.this;
                    aOAEngine.parcelFileDescriptor = aOAEngine.usbManager.openAccessory(AOAEngine.this.Accessory);
                } catch (Exception e) {
                    DDLog.m1684e("打开aoa报错:" + e);
                }
                if (AOAEngine.this.parcelFileDescriptor == null) {
                    DDLog.m1685e("DDLog-AOAENGINE", "不能打开AOA");
                    AOAEngine.this.callConnectError();
                    return;
                }
                AOAEngine aOAEngine2 = AOAEngine.this;
                aOAEngine2.fileDescriptor = aOAEngine2.parcelFileDescriptor.getFileDescriptor();
                AOAEngine.this.inputStream = new FileInputStream(AOAEngine.this.fileDescriptor);
                AOAEngine.this.outputStream = new FileOutputStream(AOAEngine.this.fileDescriptor);
                AOAEngine.this.isAccessoryConnected = true;
                AOAEngine.this.Quit.set(false);
                AOAEngine.this.sendBytes.clear();
                PhoneConfig.threadPool.execute(AOAEngine.this.sendRunnable);
                try {
                    DDLog.m1684e("send test data");
                    byte[] wrap = UsbDataWrapper.wrap(new byte[]{0}, UsbConfig.USB_TYPE_APP_TO_FPV);
                    AOAEngine.this.outputStream.write(wrap, 0, wrap.length);
                    z = true;
                } catch (Exception e2) {
                    DDLog.m1684e("send test data:" + e2.getMessage());
                    AOAEngine.this.Quit.set(true);
                    z = false;
                }
                if (z) {
                    AOAEngine.this.callConnected();
                    AOAEngine.this.usbParser = new AsyncUsbParser();
                    AOAEngine.this.usbParser.init(AOAEngine.this.frameOutputListener);
                    AOAEngine.this.usbParser.start();
                }
                long currentTimeMillis = System.currentTimeMillis();
                DDLog.m1684e("开始读取数据...");
                FactorDataParser.get().setResultListener(new FactorDataParser.OnFactoryDataResultListener() { // from class: com.logan.usb.AOAEngine.5.1
                    @Override // com.logan.usb.kuxinwei.FactorDataParser.OnFactoryDataResultListener
                    public void onDataOutput(byte[] bArr) {
                        if (AOAEngine.this.h264Decoder == null) {
                            AOAEngine.this.h264Decoder = DecoderFactory.newDecoder(UsbConfig.USB_TYPE_LIVE_VIEW_NEW);
                            if (AOAEngine.this.h264Decoder != null) {
                                AOAEngine.this.h264Decoder.start();
                            }
                        }
                        if (AOAEngine.this.h264Decoder != null && AOAEngine.this.h264Decoder.isStart() && PhoneConfig.isKernelActivityRunning) {
                            AOAEngine.this.h264Decoder.decode(bArr);
                        }
                    }
                });
                while (!AOAEngine.this.Quit.get()) {
                    try {
                        UsbBytes usbBytes = new UsbBytes();
                        usbBytes.len = AOAEngine.this.inputStream.read(usbBytes.data);
                        if (currentTimeMillis > System.currentTimeMillis()) {
                            currentTimeMillis = 0;
                        }
                        if (System.currentTimeMillis() - currentTimeMillis >= 500) {
                            try {
                                AOAEngine.this.usbParser.put(usbBytes);
                            } catch (Exception e3) {
                                DDLog.m1684e("解析出错1：" + e3);
                            }
                        }
                    } catch (Exception e4) {
                        DDLog.m1685e("DDLog-AOAENGINE", "遥控器通道断开：" + e4.getMessage());
                    }
                }
                AOAEngine.this.Quit.set(true);
                AOAEngine.this.sendBytes.clear();
                if (AOAEngine.this.usbParser != null) {
                    AOAEngine.this.usbParser.release();
                    AOAEngine.this.usbParser = null;
                }
                DDLog.m1685e("DDLog-AOAENGINE", "usb读取结束");
                if (AOAEngine.this.h264Decoder != null) {
                    AOAEngine.this.h264Decoder.release(null);
                    AOAEngine.this.h264Decoder = null;
                }
                DDLog.m1683d("DDLog-AOAENGINE", "exiting reader thread");
                if (AOAEngine.this.parcelFileDescriptor != null) {
                    try {
                        AOAEngine.this.parcelFileDescriptor.close();
                    } catch (Exception unused) {
                        DDLog.m1685e("DDLog-AOAENGINE", "Unable to close ParcelFD");
                    }
                }
                if (AOAEngine.this.inputStream != null) {
                    try {
                        AOAEngine.this.inputStream.close();
                    } catch (Exception unused2) {
                        DDLog.m1685e("DDLog-AOAENGINE", "Unable to close InputStream");
                    }
                }
                if (AOAEngine.this.outputStream != null) {
                    try {
                        AOAEngine.this.outputStream.close();
                    } catch (Exception unused3) {
                        DDLog.m1685e("DDLog-AOAENGINE", "Unable to close OutputStream");
                    }
                }
                AOAEngine.this.isAccessoryConnected = false;
                AOAEngine.this.Quit.set(true);
                AOAEngine.this.accessoryThread = null;
                DDLog.m1685e("DDLog-AOAENGINE", "释放完成");
                if (z) {
                    AOAEngine.this.callConnectClosed();
                }
                if (AOAEngine.this.connectRunnable != null && z) {
                    AOAEngine.this.handler.removeCallbacks(AOAEngine.this.connectRunnable);
                    AOAEngine.this.connectRunnable = null;
                }
                try {
                    Thread.sleep(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    if (ActivityHelper.getInstance().isAppInForeground()) {
                        AOAEngine.this.start();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } catch (Exception unused4) {
            }
        }
    };
    private final ConcurrentLinkedQueue<byte[]> sendBytes = new ConcurrentLinkedQueue<>();
    private final Runnable sendRunnable = new Runnable() { // from class: com.logan.usb.AOAEngine.11
        @Override // java.lang.Runnable
        public void run() {
            while (!AOAEngine.this.Quit.get()) {
                if (AOAEngine.this.isAccessoryConnected && AOAEngine.this.outputStream != null) {
                    try {
                        if (!AOAEngine.this.sendBytes.isEmpty()) {
                            byte[] bArr = (byte[]) AOAEngine.this.sendBytes.poll();
                            AOAEngine.this.outputStream.write(bArr, 0, bArr.length);
                            AOAEngine.this.outputStream.flush();
                        } else {
                            Thread.sleep(1L);
                        }
                    } catch (Exception e) {
                        DDLog.m1684e("usb发送错误:" + e.getMessage());
                    }
                }
            }
        }
    };
    public final AsyncUsbParser.OnFrameOutputListener frameOutputListener = new AsyncUsbParser.OnFrameOutputListener() { // from class: com.logan.usb.AOAEngine.12
        private DecodeTransaction decodeTransaction = new DecodeTransaction();

        @Override // com.logan.usb.parser_new.AsyncUsbParser.OnFrameOutputListener
        public void onInitFinished() {
            FlightSendData.get().release();
        }

        @Override // com.logan.usb.parser_new.AsyncUsbParser.OnFrameOutputListener
        public void onLiveView(Frame frame) {
            if (AOAEngine.this.h264Decoder == null) {
                AOAEngine.this.h264Decoder = DecoderFactory.newDecoder((byte) frame.getFrom());
                if (AOAEngine.this.h264Decoder != null) {
                    AOAEngine.this.h264Decoder.start();
                }
            }
            if (AOAEngine.this.h264Decoder != null && AOAEngine.this.h264Decoder.isStart() && PhoneConfig.isKernelActivityRunning) {
                AOAEngine.this.h264Decoder.decode(frame.getData());
            }
        }

        @Override // com.logan.usb.parser_new.AsyncUsbParser.OnFrameOutputListener
        public void onFrameOutput(Frame frame) {
            DataReceiver.getInstance().onDataParsed(frame);
        }
    };

    public interface IEngineCallback {
        void onUsbAccessoryConnectError();

        void onUsbAccessoryConnected();

        void onUsbAccessoryDisconnected();
    }

    public interface OnAoaTestListener {
        void onConnectCount(int i);

        void onDataRate(long j);

        void onRevAvailableDataCount(int i);
    }

    public static native void init();

    public static native void parse(byte[] bArr, int i);

    public static native void reset();

    private AOAEngine() {
        DDLog.m1685e("DDLog-AOAENGINE", "创建AOAEngine");
    }

    public static AOAEngine getInstance() {
        if (instance == null) {
            synchronized (AOAEngine.class) {
                if (instance == null) {
                    AOAEngine aOAEngine = new AOAEngine();
                    instance = aOAEngine;
                    return aOAEngine;
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
        this.usbManager = (UsbManager) context.getSystemService("usb");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.logan.aoa.USB_PERMISSION");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        if (Build.VERSION.SDK_INT >= 26) {
            this.context.registerReceiver(this.usbAttachedReceiver, intentFilter, 2);
        } else {
            this.context.registerReceiver(this.usbAttachedReceiver, intentFilter);
        }
        ActivityHelper.getInstance().setActivityActiveListener(new ActivityHelper.OnActivityActiveListener() { // from class: com.logan.usb.AOAEngine.1
            @Override // com.ipotensic.baselib.ActivityHelper.OnActivityActiveListener
            public void onBackground() {
                if (AOAEngine.this.isRunning()) {
                    AOAEngine.this.interruptAoaConnect();
                }
            }

            @Override // com.ipotensic.baselib.ActivityHelper.OnActivityActiveListener
            public void onForeground() {
                if (AOAEngine.this.isRunning()) {
                    return;
                }
                AOAEngine.this.start();
            }
        });
    }

    public void interruptAoaConnect() {
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.logan.usb.AOAEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AOAEngine.this.isRunning()) {
                        AOAEngine.this.Quit.set(true);
                        if (AOAEngine.this.parcelFileDescriptor != null) {
                            AOAEngine.this.parcelFileDescriptor.close();
                            AOAEngine.this.parcelFileDescriptor = null;
                        }
                        if (AOAEngine.this.inputStream != null) {
                            AOAEngine.this.inputStream.close();
                            AOAEngine.this.inputStream = null;
                        }
                        if (AOAEngine.this.outputStream != null) {
                            AOAEngine.this.outputStream.close();
                            AOAEngine.this.outputStream = null;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void addConnectListener(IEngineCallback iEngineCallback) {
        if (!this.callbacks.contains(iEngineCallback)) {
            this.callbacks.add(iEngineCallback);
        }
        if (isRunning()) {
            iEngineCallback.onUsbAccessoryConnected();
        } else {
            iEngineCallback.onUsbAccessoryDisconnected();
        }
    }

    public IDecoder getH264DecodeThread() {
        return this.h264Decoder;
    }

    public void removeListener(IEngineCallback iEngineCallback) {
        if (this.callbacks.contains(iEngineCallback)) {
            this.callbacks.remove(iEngineCallback);
        }
    }

    public synchronized void start() {
        UsbAccessory[] accessoryList = this.usbManager.getAccessoryList();
        if (accessoryList != null) {
            boolean z = this.Accessory == null;
            this.Accessory = accessoryList[0];
            DDLog.m1685e("DDLog-AOAENGINE", "找到AOA设备start mAccessory: " + this.Accessory);
            connect(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void connect(boolean z) {
        if (isRunning()) {
            return;
        }
        if (this.Accessory != null) {
            DDLog.m1685e("DDLog-AOAENGINE", "是否有权限:" + this.usbManager.hasPermission(this.Accessory));
            if (!this.usbManager.hasPermission(this.Accessory)) {
                if (z) {
                    try {
                        if (PhoneConfig.isAoaAbnormalPhone()) {
                            this.usbManager.requestPermission(this.Accessory, PendingIntent.getBroadcast(this.context, 0, new Intent("com.logan.aoa.USB_PERMISSION"), 67108864));
                        }
                    } catch (Exception unused) {
                    }
                }
                return;
            }
            DDLog.m1685e("DDLog-AOAENGINE", "connect: 开启通道。。。");
            if (this.accessoryThread == null) {
                if (!PhoneConfig.isConnectFlightWifi()) {
                    Thread thread = new Thread(this.accessoryRunnable, "Reader Thread");
                    this.accessoryThread = thread;
                    thread.start();
                }
            } else {
                DDLog.m1683d("DDLog-AOAENGINE", "reader thread already started");
            }
        } else {
            DDLog.m1683d("DDLog-AOAENGINE", "accessory is null");
        }
    }

    public void onDestroy() {
        ActivityHelper.getInstance().setActivityActiveListener(null);
        this.Quit.set(true);
        this.context.unregisterReceiver(this.usbAttachedReceiver);
        Runnable runnable = this.connectRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.connectRunnable = null;
        }
        DDLog.m1685e("DDLog-AOAENGINE", "完全退出");
    }

    public boolean isRunning() {
        return !this.Quit.get();
    }

    public void resetCameraBuffer() {
        AsyncUsbParser asyncUsbParser = this.usbParser;
        if (asyncUsbParser != null) {
            asyncUsbParser.resetCameraBuffer();
        }
    }

    public void switchDecoder() {
        IDecoder iDecoder;
        try {
            if (this.Quit.get() || (iDecoder = this.h264Decoder) == null) {
                return;
            }
            iDecoder.release(new OnResultListener<Boolean>() { // from class: com.logan.usb.AOAEngine.6
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    AOAEngine.this.h264Decoder = null;
                }
            });
        } catch (Exception unused) {
        }
    }

    public void releaseDecoder() {
        IDecoder iDecoder = this.h264Decoder;
        if (iDecoder != null) {
            iDecoder.release(new OnResultListener<Boolean>() { // from class: com.logan.usb.AOAEngine.7
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    AOAEngine.this.h264Decoder = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callConnected() {
        this.handler.post(new Runnable() { // from class: com.logan.usb.AOAEngine.8
            @Override // java.lang.Runnable
            public void run() {
                UsbConfig.isUsbConnected = true;
                UsbConfig.isInit = false;
                CameraLogRecorder.get().start();
                Iterator it = AOAEngine.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((IEngineCallback) it.next()).onUsbAccessoryConnected();
                }
                EventDispatcher.get().sendEvent(EventID.EVENT_AOA_CONNECTED);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callConnectClosed() {
        this.handler.post(new Runnable() { // from class: com.logan.usb.AOAEngine.9
            @Override // java.lang.Runnable
            public void run() {
                UsbConfig.isUsbConnected = false;
                UsbConfig.isInit = false;
                CameraLogRecorder.get().release();
                Iterator it = AOAEngine.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((IEngineCallback) it.next()).onUsbAccessoryDisconnected();
                }
                EventDispatcher.get().sendEvent(EventID.EVENT_AOA_DISCONNECT);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callConnectError() {
        this.handler.post(new Runnable() { // from class: com.logan.usb.AOAEngine.10
            @Override // java.lang.Runnable
            public void run() {
                UsbConfig.isUsbConnected = false;
                UsbConfig.isInit = false;
                CameraLogRecorder.get().release();
                Iterator it = AOAEngine.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((IEngineCallback) it.next()).onUsbAccessoryConnectError();
                }
            }
        });
    }

    public synchronized void send(byte[] bArr, byte b) {
        if (!this.Quit.get() && this.isAccessoryConnected && this.outputStream != null) {
            byte[] wrap = UsbDataWrapper.wrap(bArr, b);
            if (b == UsbConfig.USB_TYPE_APP_TO_CAMERA) {
                DDLog.m1684e("发送相机数据：" + ParseUtil.byteToHexString(wrap, 50));
            } else if (b == UsbConfig.USB_TYPE_APP_TO_FLIGHT) {
                DDLog.m1684e("发送飞控数据：" + ParseUtil.byteToHexString(wrap, 20));
            } else if (b == UsbConfig.USB_TYPE_APP_TO_REMOTER) {
                DDLog.m1684e("发送遥控器数据：" + ParseUtil.byteToHexString(wrap, 20));
            }
            this.sendBytes.offer(wrap);
        }
    }

    static {
        System.loadLibrary("native-lib");
    }

    public static void output(int i, byte[] bArr) {
        DDLog.m1684e("输出数据 数据类型 ：" + i + " , size : " + bArr.length + " , data : " + ParseUtil.byteToHexString(bArr, 10));
    }

    static boolean is_usb_frame_head(byte[] bArr, int i) {
        return bArr[i] == -2 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 0 && bArr[i + 4] == 0 && bArr[i + 5] == 0 && bArr[i + 6] == 0;
    }
}