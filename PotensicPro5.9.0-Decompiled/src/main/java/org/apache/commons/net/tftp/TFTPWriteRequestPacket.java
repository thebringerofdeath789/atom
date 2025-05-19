package org.apache.commons.net.tftp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class TFTPWriteRequestPacket extends TFTPRequestPacket {
    public TFTPWriteRequestPacket(InetAddress inetAddress, int i, String str, int i2) {
        super(inetAddress, i, 2, str, i2);
    }

    TFTPWriteRequestPacket(DatagramPacket datagramPacket) throws TFTPPacketException {
        super(2, datagramPacket);
    }

    @Override // org.apache.commons.net.tftp.TFTPPacket
    public String toString() {
        return super.toString() + " WRQ " + getFilename() + StringUtils.SPACE + TFTP.getModeName(getMode());
    }
}
