package com.logan.server.jhttp;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes3.dex */
public class HttpHandler implements Runnable {
    private static OnFailedListener failedListener;
    private IOnHttpRequest mOnRequest;
    private Socket socket;
    private boolean isStart = false;
    private OutputStream out = null;
    byte[] data = new byte[0];

    public interface OnFailedListener {
        void onFailed();
    }

    public HttpHandler(Socket socket, IOnHttpRequest iOnHttpRequest) {
        this.socket = socket;
        this.mOnRequest = iOnHttpRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        handle();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8 A[Catch: all -> 0x023d, Exception -> 0x0240, TryCatch #2 {Exception -> 0x0240, blocks: (B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:3:0x0005, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c1 A[Catch: all -> 0x023d, Exception -> 0x0240, TryCatch #2 {Exception -> 0x0240, blocks: (B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:3:0x0005, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0225 A[Catch: IOException -> 0x0274, TRY_ENTER, TryCatch #5 {IOException -> 0x0274, blocks: (B:66:0x0225, B:67:0x0228, B:69:0x022c, B:70:0x022f, B:72:0x0233, B:113:0x0262, B:114:0x0265, B:116:0x0269, B:117:0x026c, B:119:0x0270, B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:2:0x0005, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022c A[Catch: IOException -> 0x0274, TryCatch #5 {IOException -> 0x0274, blocks: (B:66:0x0225, B:67:0x0228, B:69:0x022c, B:70:0x022f, B:72:0x0233, B:113:0x0262, B:114:0x0265, B:116:0x0269, B:117:0x026c, B:119:0x0270, B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:2:0x0005, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0233 A[Catch: IOException -> 0x0274, TRY_LEAVE, TryCatch #5 {IOException -> 0x0274, blocks: (B:66:0x0225, B:67:0x0228, B:69:0x022c, B:70:0x022f, B:72:0x0233, B:113:0x0262, B:114:0x0265, B:116:0x0269, B:117:0x026c, B:119:0x0270, B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:2:0x0005, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e1 A[Catch: all -> 0x023d, Exception -> 0x0240, TRY_LEAVE, TryCatch #2 {Exception -> 0x0240, blocks: (B:4:0x0005, B:5:0x0038, B:92:0x003f, B:7:0x006f, B:9:0x0081, B:11:0x008a, B:13:0x0091, B:16:0x0098, B:18:0x00c1, B:21:0x00c8, B:25:0x00d8, B:30:0x00de, B:28:0x0110, B:48:0x0119, B:52:0x013d, B:54:0x0149, B:56:0x0151, B:57:0x0160, B:59:0x01c1, B:60:0x01d0, B:62:0x01d6, B:64:0x0217, B:75:0x01e1, B:84:0x01f2, B:86:0x0212, B:90:0x023a), top: B:3:0x0005, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handle() {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.logan.server.jhttp.HttpHandler.handle():void");
    }

    public void stop() {
        this.isStart = false;
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.out = null;
        }
    }

    public static void setFailedListener(OnFailedListener onFailedListener) {
        failedListener = onFailedListener;
    }

    public static class ChunkedOutputStream extends FilterOutputStream {
        public ChunkedOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (i2 == 0) {
                return;
            }
            this.out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
            this.out.write(bArr, i, i2);
            this.out.write("\r\n".getBytes());
        }

        public void finish() throws IOException {
            try {
                this.out.write("0\r\n\r\n".getBytes());
            } catch (Exception unused) {
            }
        }
    }
}
