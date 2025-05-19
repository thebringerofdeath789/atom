package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.FlightConfig;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class UdpClient {
    private static volatile UdpClient instance;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;
    private OnUdpSocketListener socketListener;
    private DatagramSocket udpSocket;
    private final String IP = "192.168.42.30";
    private final int PORT = FlightConfig.PORT;
    private boolean isConnected = false;
    private byte[] readBytesTotal = new byte[1048576];
    private byte[] readBytes = new byte[2048];
    private byte[] lock = new byte[1];
    private int totalReadLen = 0;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    public interface OnUdpSocketListener {
        void onConnected();

        void onDisconnected();

        void onReceivedData(byte[] bArr);
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

    public void connect(OnUdpSocketListener onUdpSocketListener) {
        this.socketListener = onUdpSocketListener;
        if (this.isConnected) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: com.logan.h264.UdpClient.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (UdpClient.this.lock) {
                        InetAddress byName = InetAddress.getByName("192.168.42.30");
                        UdpClient.this.udpSocket = new DatagramSocket();
                        UdpClient.this.udpSocket.connect(byName, FlightConfig.PORT);
                        UdpClient udpClient = UdpClient.this;
                        udpClient.isConnected = udpClient.udpSocket.isConnected();
                        if (UdpClient.this.isConnected) {
                            UdpClient.this.socketListener.onConnected();
                            UdpClient.this.startRead();
                            UdpClient.this.sendData("hello".getBytes());
                        } else {
                            UdpClient.this.socketListener.onDisconnected();
                        }
                    }
                } catch (Exception e) {
                    DDLog.w("连接错误:" + e.getMessage());
                    UdpClient.this.isConnected = false;
                    UdpClient.this.socketListener.onDisconnected();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRead() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.h264.UdpClient.2
            @Override // java.lang.Runnable
            public void run() {
                while (UdpClient.this.isConnected) {
                    try {
                        UdpClient.this.receivePacket = new DatagramPacket(UdpClient.this.readBytes, UdpClient.this.readBytes.length);
                        UdpClient.this.udpSocket.receive(UdpClient.this.receivePacket);
                        if (UdpClient.this.receivePacket.getData() != null) {
                            int length = UdpClient.this.receivePacket.getLength();
                            byte[] copyOf = Arrays.copyOf(UdpClient.this.readBytes, length);
                            if (copyOf.length <= 5 || copyOf[0] != 0 || copyOf[1] != 0 || copyOf[2] != 1 || (copyOf[3] != -96 && copyOf[3] != -95)) {
                                System.arraycopy(copyOf, 0, UdpClient.this.readBytesTotal, UdpClient.this.totalReadLen, copyOf.length);
                                UdpClient.this.totalReadLen += length;
                            } else {
                                if (UdpClient.this.totalReadLen != 0) {
                                    byte[] bArr = new byte[UdpClient.this.totalReadLen];
                                    System.arraycopy(UdpClient.this.readBytesTotal, 0, bArr, 0, UdpClient.this.totalReadLen);
                                    UdpClient.this.socketListener.onReceivedData(bArr);
                                }
                                UdpClient.this.totalReadLen = 0;
                                System.arraycopy(copyOf, 0, UdpClient.this.readBytesTotal, 0, copyOf.length);
                                UdpClient.this.totalReadLen += length;
                            }
                        }
                    } catch (Exception e) {
                        DDLog.w("读取错误:" + e.getMessage());
                    }
                }
            }
        });
    }

    public void sendData(final byte[] bArr) {
        DDLog.w("发送握手 isconnect:" + this.isConnected);
        if (this.isConnected) {
            this.threadPool.execute(new Runnable() { // from class: com.logan.h264.UdpClient.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (UdpClient.this.lock) {
                            DDLog.w("发送握手1");
                            InetAddress byName = InetAddress.getByName("192.168.42.30");
                            UdpClient udpClient = UdpClient.this;
                            byte[] bArr2 = bArr;
                            udpClient.sendPacket = new DatagramPacket(bArr2, bArr2.length, byName, FlightConfig.PORT);
                            UdpClient.this.udpSocket.send(UdpClient.this.sendPacket);
                            DDLog.w("数据已发送:" + ParseUtil.byteToHexString(bArr, 20));
                        }
                    } catch (Exception e) {
                        DDLog.w("发送错误:" + e.getMessage());
                    }
                }
            });
        }
    }

    public void disConnect() {
        this.threadPool.execute(new Runnable() { // from class: com.logan.h264.UdpClient.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UdpClient.this.lock) {
                    UdpClient.this.isConnected = false;
                    if (UdpClient.this.udpSocket != null) {
                        UdpClient.this.udpSocket.close();
                        UdpClient.this.udpSocket = null;
                    }
                    UdpClient.this.socketListener.onDisconnected();
                }
            }
        });
    }

    public void setSocketListener(OnUdpSocketListener onUdpSocketListener) {
        this.socketListener = onUdpSocketListener;
    }
}
