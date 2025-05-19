package com.ipotensic.potensicpro.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/* loaded from: classes2.dex */
public abstract class TCPClient {
    private boolean _isConnected = false;
    private String ip;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private ReadThread mReadThread;
    private Socket mSocket;
    private SocketAddress mSocketAddress;
    private int port;

    protected abstract void onDataReceive(byte[] bArr, int i);

    public TCPClient(String str, int i) {
        this.ip = str;
        this.port = i;
    }

    public void connect() {
        try {
            Socket socket = new Socket();
            this.mSocket = socket;
            socket.setKeepAlive(true);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.ip, this.port);
            this.mSocketAddress = inetSocketAddress;
            this.mSocket.connect(inetSocketAddress, 3000);
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mInputStream = this.mSocket.getInputStream();
            ReadThread readThread = new ReadThread();
            this.mReadThread = readThread;
            readThread.start();
            this._isConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        ReadThread readThread = this.mReadThread;
        if (readThread != null) {
            readThread.interrupt();
        }
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
                this.mSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this._isConnected = false;
    }

    public boolean isConnected() {
        return this._isConnected;
    }

    public void send(byte[] bArr) {
        try {
            this.mOutputStream.write(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadThread extends Thread {
        private ReadThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (!isInterrupted()) {
                try {
                    if (TCPClient.this.mInputStream == null) {
                        return;
                    }
                    int available = TCPClient.this.mInputStream.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        int read = TCPClient.this.mInputStream.read(bArr);
                        if (read > 0) {
                            TCPClient.this.onDataReceive(bArr, read);
                        }
                    } else {
                        Thread.sleep(50L);
                    }
                } catch (Throwable th) {
                    System.out.println(th.getMessage());
                    return;
                }
            }
        }
    }
}
