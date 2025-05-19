package org.apache.commons.net.tftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes4.dex */
public class TFTPClient extends TFTP {
    public static final int DEFAULT_MAX_TIMEOUTS = 5;
    private long totalBytesReceived = 0;
    private long totalBytesSent = 0;
    private int __maxTimeouts = 5;

    public void setMaxTimeouts(int i) {
        if (i < 1) {
            this.__maxTimeouts = 1;
        } else {
            this.__maxTimeouts = i;
        }
    }

    public int getMaxTimeouts() {
        return this.__maxTimeouts;
    }

    public long getTotalBytesReceived() {
        return this.totalBytesReceived;
    }

    public long getTotalBytesSent() {
        return this.totalBytesSent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x014d, code lost:
    
        if (r13 == (r11 != 0 ? r11 - 1 : 65535)) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01c3, code lost:
    
        r7.setBlockNumber(r13);
        r12 = r12 + r14;
        r22 = r2;
        r19.totalBytesReceived += r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01d1, code lost:
    
        if (r14 == 512) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01d3, code lost:
    
        bufferedSend(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01d9, code lost:
    
        return r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01e2 A[LOOP:1: B:8:0x0037->B:36:0x01e2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c3 A[EDGE_INSN: B:37:0x01c3->B:38:0x01c3 BREAK  A[LOOP:1: B:8:0x0037->B:36:0x01e2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int receiveFile(java.lang.String r20, int r21, java.io.OutputStream r22, java.net.InetAddress r23, int r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.TFTPClient.receiveFile(java.lang.String, int, java.io.OutputStream, java.net.InetAddress, int):int");
    }

    public int receiveFile(String str, int i, OutputStream outputStream, String str2, int i2) throws UnknownHostException, IOException {
        return receiveFile(str, i, outputStream, InetAddress.getByName(str2), i2);
    }

    public int receiveFile(String str, int i, OutputStream outputStream, InetAddress inetAddress) throws IOException {
        return receiveFile(str, i, outputStream, inetAddress, 69);
    }

    public int receiveFile(String str, int i, OutputStream outputStream, String str2) throws UnknownHostException, IOException {
        return receiveFile(str, i, outputStream, InetAddress.getByName(str2), 69);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016f A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendFile(java.lang.String r19, int r20, java.io.InputStream r21, java.net.InetAddress r22, int r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.tftp.TFTPClient.sendFile(java.lang.String, int, java.io.InputStream, java.net.InetAddress, int):void");
    }

    public void sendFile(String str, int i, InputStream inputStream, String str2, int i2) throws UnknownHostException, IOException {
        sendFile(str, i, inputStream, InetAddress.getByName(str2), i2);
    }

    public void sendFile(String str, int i, InputStream inputStream, InetAddress inetAddress) throws IOException {
        sendFile(str, i, inputStream, inetAddress, 69);
    }

    public void sendFile(String str, int i, InputStream inputStream, String str2) throws UnknownHostException, IOException {
        sendFile(str, i, inputStream, InetAddress.getByName(str2), 69);
    }
}
