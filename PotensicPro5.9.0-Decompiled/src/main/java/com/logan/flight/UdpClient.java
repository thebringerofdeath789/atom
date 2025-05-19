package com.logan.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.listeners.OnCloseListener;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class UdpClient {
    private static volatile UdpClient instance;
    private OnUdpSocketListener socketListener;
    private DatagramSocket udpSocket;
    private boolean isConnected = false;
    private volatile ByteBuf buffer = Unpooled.buffer(2048);
    private final byte[] result = new byte[1024];
    private final byte[] lock = new byte[1];
    private InetAddress ipAddress = null;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    public interface OnUdpSocketListener {
        void onConnected();

        void onDisconnected();
    }

    private UdpClient() {
    }

    public static UdpClient getInstance() {
        if (instance == null) {
            synchronized (UdpClient.class) {
                if (instance == null) {
                    UdpClient udpClient = new UdpClient();
                    instance = udpClient;
                    return udpClient;
                }
            }
        }
        return instance;
    }

    public void connect(final String str, final int i) {
        if (this.isConnected) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.UdpClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (UdpClient.this.lock) {
                        DDLog.w("connect:   " + str + ":" + i);
                        UdpClient.this.ipAddress = InetAddress.getByName(str);
                        UdpClient.this.udpSocket = new DatagramSocket(i);
                        UdpClient.this.udpSocket.setSoTimeout(2000);
                        UdpClient.this.udpSocket.connect(UdpClient.this.ipAddress, i);
                        UdpClient udpClient = UdpClient.this;
                        udpClient.isConnected = udpClient.udpSocket.isConnected();
                        if (UdpClient.this.isConnected) {
                            UdpClient.this.socketListener.onConnected();
                            DDLog.w("udp连接成功");
                            UdpClient.this.startRead();
                            UdpClient.this.startSend(str, i);
                        } else {
                            UdpClient.this.socketListener.onDisconnected();
                            DDLog.w("udp连接失败");
                        }
                    }
                } catch (Exception unused) {
                    UdpClient.this.isConnected = false;
                    UdpClient.this.socketListener.onDisconnected();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRead() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.UdpClient.2
            @Override // java.lang.Runnable
            public void run() {
                while (UdpClient.this.isConnected) {
                    try {
                        DatagramPacket datagramPacket = new DatagramPacket(UdpClient.this.result, UdpClient.this.result.length);
                        UdpClient.this.udpSocket.receive(datagramPacket);
                        if (datagramPacket.getData() == null) {
                            DDLog.w("没有udp数据");
                        } else {
                            int length = datagramPacket.getLength();
                            DDLog.w("udp 接收数据:" + ParseUtil.byteToHexString(UdpClient.this.result, length));
                            DataParser.getInstance().write(UdpClient.this.result, length);
                        }
                    } catch (Exception e) {
                        DDLog.e("接收udp数据失败:" + e.getMessage());
                    }
                }
            }
        });
    }

    public void send(byte[] bArr) {
        synchronized (this.lock) {
            DDLog.w("发送udp数据:" + ParseUtil.byteToHexString(bArr));
            if (this.buffer.readableBytes() > 1536) {
                this.buffer.clear();
            }
            this.buffer.writeBytes(bArr, 0, bArr.length);
            this.lock.notify();
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
    public void startSend(final String str, final int i) {
        if (this.isConnected) {
            this.threadPool.execute(new Runnable() { // from class: com.logan.flight.UdpClient.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (UdpClient.this.lock) {
                        while (UdpClient.this.isConnected) {
                            try {
                                byte[] wroteBytes = UdpClient.this.getWroteBytes();
                                if (wroteBytes != null) {
                                    DDLog.e("开始发送" + ParseUtil.byteToHexString(wroteBytes));
                                    DatagramPacket datagramPacket = new DatagramPacket(wroteBytes, wroteBytes.length, InetAddress.getByName(str), i);
                                    DDLog.w("发送 ip:" + str);
                                    DDLog.w("发送 端口:" + i);
                                    UdpClient.this.udpSocket.send(datagramPacket);
                                    DDLog.e("udp数据已发出" + ParseUtil.byteToHexString(wroteBytes));
                                    UdpClient.this.buffer.clear();
                                }
                                UdpClient.this.lock.wait();
                            } catch (Exception e) {
                                DDLog.e("发送udp数据失败:" + e.getMessage());
                            }
                        }
                    }
                }
            });
        }
    }

    public void disConnect(final OnCloseListener onCloseListener) {
        this.threadPool.execute(new Runnable() { // from class: com.logan.flight.UdpClient.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UdpClient.this.lock) {
                    UdpClient.this.isConnected = false;
                    UdpClient.this.lock.notify();
                    if (UdpClient.this.udpSocket != null) {
                        UdpClient.this.udpSocket.close();
                        UdpClient.this.udpSocket = null;
                    }
                    if (UdpClient.this.socketListener != null) {
                        UdpClient.this.socketListener.onDisconnected();
                    }
                    OnCloseListener onCloseListener2 = onCloseListener;
                    if (onCloseListener2 != null) {
                        onCloseListener2.onClosed();
                    }
                }
            }
        });
    }

    public void setSocketListener(OnUdpSocketListener onUdpSocketListener) {
        this.socketListener = onUdpSocketListener;
    }
}
