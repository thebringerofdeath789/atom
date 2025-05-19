package org.apache.commons.net.chargen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;

/* loaded from: classes4.dex */
public final class CharGenUDPClient extends DatagramSocketClient {
    public static final int CHARGEN_PORT = 19;
    public static final int DEFAULT_PORT = 19;
    public static final int NETSTAT_PORT = 15;
    public static final int QUOTE_OF_DAY_PORT = 17;
    public static final int SYSTAT_PORT = 11;
    private final byte[] __receiveData;
    private final DatagramPacket __receivePacket;
    private final DatagramPacket __sendPacket = new DatagramPacket(new byte[0], 0);

    public CharGenUDPClient() {
        byte[] bArr = new byte[512];
        this.__receiveData = bArr;
        this.__receivePacket = new DatagramPacket(bArr, bArr.length);
    }

    public void send(InetAddress inetAddress, int i) throws IOException {
        this.__sendPacket.setAddress(inetAddress);
        this.__sendPacket.setPort(i);
        this._socket_.send(this.__sendPacket);
    }

    public void send(InetAddress inetAddress) throws IOException {
        send(inetAddress, 19);
    }

    public byte[] receive() throws IOException {
        this._socket_.receive(this.__receivePacket);
        int length = this.__receivePacket.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(this.__receiveData, 0, bArr, 0, length);
        return bArr;
    }
}
