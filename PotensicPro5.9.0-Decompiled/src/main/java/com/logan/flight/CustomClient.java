package com.logan.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.listeners.OnCloseListener;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class CustomClient {
    private static volatile CustomClient instance;
    private SocketAddress address;
    private OnCustomSocketListener socketListener;
    private final int TIMEOUT = 3000;
    private Socket socket = null;
    private InputStream reader = null;
    private OutputStream writer = null;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    private volatile ByteBuf buffer = Unpooled.buffer(2048);
    private final byte[] result = new byte[1024];
    private final byte[] sendLock = new byte[1];
    private boolean isConnecting = false;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    public interface OnCustomSocketListener {
        void onConnected();

        void onDisconnected();
    }

    private CustomClient() {
    }

    public void setSocketListener(OnCustomSocketListener onCustomSocketListener) {
        this.socketListener = onCustomSocketListener;
    }

    public static CustomClient getInstance() {
        if (instance == null) {
            synchronized (CustomClient.class) {
                if (instance == null) {
                    CustomClient customClient = new CustomClient();
                    instance = customClient;
                    return customClient;
                }
            }
        }
        return instance;
    }

    public void connect(final String str, final int i) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.CustomClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (CustomClient.this.isConnecting) {
                    return;
                }
                CustomClient.this.isConnecting = true;
                if (!CustomClient.this.isConnected.get()) {
                    try {
                        DDLog.w("开始连接socket");
                        CustomClient.this.socket = new Socket();
                        CustomClient.this.address = new InetSocketAddress(str, i);
                        if (CustomClient.this.socket != null && !CustomClient.this.socket.isConnected()) {
                            CustomClient.this.socket.connect(CustomClient.this.address, 3000);
                            CustomClient.this.isConnected.set(true);
                            if (CustomClient.this.socketListener != null) {
                                CustomClient.this.socketListener.onConnected();
                            }
                            CustomClient.this.startSendThread();
                            CustomClient.this.startReceiveThread();
                        } else {
                            CustomClient.this.close(null);
                        }
                    } catch (Exception e) {
                        DDLog.w("socket连接失败:" + e.getMessage());
                        CustomClient.this.close(null);
                    }
                }
                CustomClient.this.isConnecting = false;
            }
        });
    }

    public boolean isConnect() {
        return this.isConnected.get();
    }

    public void close(final OnCloseListener onCloseListener) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.CustomClient.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CustomClient.this.sendLock) {
                    try {
                        CustomClient.this.isConnected.set(false);
                        CustomClient.this.sendLock.notify();
                        if (CustomClient.this.reader != null) {
                            CustomClient.this.reader.close();
                            CustomClient.this.reader = null;
                        }
                        if (CustomClient.this.writer != null) {
                            CustomClient.this.writer.close();
                            CustomClient.this.writer = null;
                        }
                        if (CustomClient.this.socket != null) {
                            DDLog.w("关闭socket");
                            CustomClient.this.socket.close();
                            CustomClient.this.socket = null;
                        }
                    } catch (Exception e) {
                        DDLog.e("socket断开错误:" + e.toString());
                    }
                    if (CustomClient.this.socketListener != null) {
                        CustomClient.this.socketListener.onDisconnected();
                    }
                    OnCloseListener onCloseListener2 = onCloseListener;
                    if (onCloseListener2 != null) {
                        onCloseListener2.onClosed();
                    }
                }
            }
        });
    }

    public void send(byte[] bArr) {
        synchronized (this.sendLock) {
            if (this.buffer.readableBytes() > 1536) {
                this.buffer.clear();
            }
            this.buffer.writeBytes(bArr, 0, bArr.length);
            this.sendLock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] getWroteBytes() {
        if (this.buffer.writerIndex() <= 0) {
            return null;
        }
        byte[] bArr = new byte[this.buffer.writerIndex()];
        this.buffer.getBytes(0, bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSendThread() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.CustomClient.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CustomClient.this.sendLock) {
                    try {
                        CustomClient customClient = CustomClient.this;
                        customClient.writer = customClient.socket.getOutputStream();
                        while (CustomClient.this.socket != null && CustomClient.this.isConnected.get() && CustomClient.this.writer != null) {
                            byte[] wroteBytes = CustomClient.this.getWroteBytes();
                            if (wroteBytes != null) {
                                CustomClient.this.writer.write(wroteBytes);
                                CustomClient.this.writer.flush();
                                CustomClient.this.buffer.clear();
                            }
                            CustomClient.this.sendLock.wait();
                        }
                        CustomClient.this.buffer.clear();
                        DDLog.w("socket发送线程结束");
                    } catch (Exception e) {
                        DDLog.e("socket发送错误:" + e.getMessage());
                        CustomClient.this.close(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReceiveThread() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.CustomClient.4
            @Override // java.lang.Runnable
            public void run() {
                int read;
                try {
                    CustomClient customClient = CustomClient.this;
                    customClient.reader = customClient.socket.getInputStream();
                    while (CustomClient.this.reader != null && CustomClient.this.isConnected.get() && (read = CustomClient.this.reader.read(CustomClient.this.result)) != -1) {
                        DataParser.getInstance().write(CustomClient.this.result, read);
                        DDLog.w("收到数据:" + ParseUtil.byteToHexString(CustomClient.this.result, read));
                    }
                    DDLog.w("socket接收线程结束");
                } catch (Exception e) {
                    DDLog.e("socket断开 " + e.getMessage());
                    CustomClient.this.close(null);
                }
            }
        });
    }
}
