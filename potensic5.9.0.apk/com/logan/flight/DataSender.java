package com.logan.flight;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.netty.handler.OnConnectStateListener;
import com.logan.flight.CustomClient;
import com.logan.flight.UdpClient;
import com.logan.flight.listeners.OnCloseListener;
import com.logan.upgrade.local.flight.UpgradeManager;
import com.logan.usb.AOAEngine;

/* loaded from: classes.dex */
public class DataSender {
    private static volatile DataSender instance;

    private DataSender() {
    }

    public static DataSender getInstance() {
        if (instance == null) {
            synchronized (DataSender.class) {
                if (instance == null) {
                    DataSender dataSender = new DataSender();
                    instance = dataSender;
                    return dataSender;
                }
            }
        }
        return instance;
    }

    public void connect(final OnConnectStateListener onConnectStateListener) {
        if (PhoneConfig.isUdp) {
            UdpClient.getInstance().connect("192.168.29.1", FlightConfig.PORT_UDP);
            UdpClient.getInstance().setSocketListener(new UdpClient.OnUdpSocketListener() { // from class: com.logan.flight.DataSender.1
                @Override // com.logan.flight.UdpClient.OnUdpSocketListener
                public void onConnected() {
                    DDLog.m1684e("飞控连接成功aaa");
                    onConnectStateListener.onClientStatusConnectChanged(1);
                }

                @Override // com.logan.flight.UdpClient.OnUdpSocketListener
                public void onDisconnected() {
                    DDLog.m1684e("飞控连接断开bbb");
                    onConnectStateListener.onClientStatusConnectChanged(0);
                }
            });
        } else {
            CustomClient.getInstance().connect("192.168.29.1", FlightConfig.PORT);
            CustomClient.getInstance().setSocketListener(new CustomClient.OnCustomSocketListener() { // from class: com.logan.flight.DataSender.2
                @Override // com.logan.flight.CustomClient.OnCustomSocketListener
                public void onConnected() {
                    DDLog.m1684e("飞控连接成功aaa");
                    onConnectStateListener.onClientStatusConnectChanged(1);
                }

                @Override // com.logan.flight.CustomClient.OnCustomSocketListener
                public void onDisconnected() {
                    DDLog.m1684e("飞控连接断开bbb");
                    onConnectStateListener.onClientStatusConnectChanged(0);
                }
            });
        }
    }

    public void close(OnCloseListener onCloseListener) {
        if (PhoneConfig.isUdp) {
            UdpClient.getInstance().disConnect(onCloseListener);
        } else {
            CustomClient.getInstance().close(onCloseListener);
        }
    }

    public void sendData(byte b, byte[] bArr) {
        String str;
        if (UsbConfig.isUsbConnected) {
            if (UpgradeManager.getInstance().isUpgradeStart()) {
                return;
            }
            AOAEngine.getInstance().send(bArr, b);
        } else if (FlightConfig.isConnectFlightSocket) {
            if (bArr[4] == 3) {
                str = "设置";
            } else {
                str = bArr[4] == 6 ? "指点飞行" : "";
            }
            DDLog.m1684e("发送" + str + "数据:" + ParseUtil.byteToHexString(bArr));
            if (PhoneConfig.isUdp) {
                UdpClient.getInstance().send(bArr);
            } else {
                CustomClient.getInstance().send(bArr);
            }
        }
    }

    public void sendUpgradeData(byte b, byte[] bArr) {
        if (UsbConfig.isUsbConnected) {
            AOAEngine.getInstance().send(bArr, b);
        } else if (FlightConfig.isConnectFlightSocket) {
            sendData(b, bArr);
        }
    }
}