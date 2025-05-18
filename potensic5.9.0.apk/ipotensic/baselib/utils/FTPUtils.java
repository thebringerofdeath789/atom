package com.ipotensic.baselib.utils;

import com.ipotensic.baselib.DDLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/* loaded from: classes2.dex */
public class FTPUtils {
    private static FTPUtils mFTPUtils;
    private FTPClient ftpClient;
    private String hostName = "";
    private Integer port = 21;
    private String userName = "";
    private String passWord = "";
    private final int timeOut = 2;
    private boolean enterLocalPassiveMode = false;

    private FTPUtils() {
    }

    public static FTPUtils getInstance() {
        if (mFTPUtils == null) {
            synchronized (FTPUtils.class) {
                if (mFTPUtils == null) {
                    mFTPUtils = new FTPUtils();
                }
            }
        }
        return mFTPUtils;
    }

    public void initFtpClient(String str, int i, String str2, String str3) {
        this.hostName = str;
        this.port = Integer.valueOf(i);
        this.userName = str2;
        this.passWord = str3;
        FTPClient fTPClient = new FTPClient();
        this.ftpClient = fTPClient;
        fTPClient.setDefaultTimeout(2000);
        this.ftpClient.setConnectTimeout(2000);
        this.ftpClient.setDataTimeout(2000);
        this.ftpClient.setControlEncoding("utf-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean connectFtp() {
        try {
            DDLog.e("FTP", "\u8fde\u63a5...FTP\u670d\u52a1\u5668...");
            this.ftpClient.connect(this.hostName, this.port.intValue());
            if (this.enterLocalPassiveMode) {
                this.ftpClient.setRemoteVerificationEnabled(false);
                this.ftpClient.enterLocalPassiveMode();
                this.ftpClient.disconnect();
            }
            this.ftpClient.login(this.userName, this.passWord);
            if (!FTPReply.isPositiveCompletion(this.ftpClient.getReplyCode())) {
                DDLog.e("FTP", "\u8fde\u63a5...FTP\u670d\u52a1\u5668...\u5931\u8d25: ");
                return false;
            }
            DDLog.e("FTP", "\u8fde\u63a5...FTP\u670d\u52a1\u5668...\u6210\u529f:");
            return true;
        } catch (Exception e) {
            DDLog.e(e.getMessage(), e + "");
            return true;
        }
    }

    public void uploadFile(String str, File file) {
        try {
            uploadFile(str, new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.e("FTP", e.getMessage() + "  " + e);
        }
    }

    public void uploadFile(final String str, final InputStream inputStream) {
        new Thread(new Runnable() { // from class: com.ipotensic.baselib.utils.FTPUtils.1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x00a4, code lost:
            
                if (r5 != false) goto L41;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0120, code lost:
            
                r0 = "\u5931\u8d25 ";
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0121, code lost:
            
                com.ipotensic.baselib.DDLog.e("FTP", r2.append(r0).toString());
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x011d, code lost:
            
                if (r5 == false) goto L40;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                StringBuilder append;
                if (!FTPUtils.this.connectFtp()) {
                    return;
                }
                boolean z = false;
                try {
                    try {
                        FTPClient fTPClient = FTPUtils.this.ftpClient;
                        FTPClient unused = FTPUtils.this.ftpClient;
                        fTPClient.setFileType(2);
                        z = FTPUtils.this.ftpClient.storeFile(new String(str.getBytes("GBK"), "iso-8859-1"), inputStream);
                        inputStream.close();
                        FTPUtils.this.ftpClient.logout();
                        if (FTPUtils.this.ftpClient.isConnected()) {
                            try {
                                FTPUtils.this.ftpClient.disconnect();
                            } catch (IOException e) {
                                DDLog.e(e.getMessage(), e + "");
                            }
                        }
                        InputStream inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                                DDLog.e(e2.getMessage(), e2 + "");
                            }
                        }
                        append = new StringBuilder().append("\u4e0a\u4f20\u6587\u4ef6\u7ed3\u675f...\u7ed3\u679c :");
                    } catch (Throwable th) {
                        if (FTPUtils.this.ftpClient.isConnected()) {
                            try {
                                FTPUtils.this.ftpClient.disconnect();
                            } catch (IOException e3) {
                                DDLog.e(e3.getMessage(), e3 + "");
                            }
                        }
                        InputStream inputStream3 = inputStream;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e4) {
                                DDLog.e(e4.getMessage(), e4 + "");
                            }
                        }
                        DDLog.e("FTP", "\u4e0a\u4f20\u6587\u4ef6\u7ed3\u675f...\u7ed3\u679c :" + (z ? "\u6210\u529f" : "\u5931\u8d25 "));
                        throw th;
                    }
                } catch (Exception e5) {
                    DDLog.e(e5.getMessage(), e5 + "");
                    if (FTPUtils.this.ftpClient.isConnected()) {
                        try {
                            FTPUtils.this.ftpClient.disconnect();
                        } catch (IOException e6) {
                            DDLog.e(e6.getMessage(), e6 + "");
                        }
                    }
                    InputStream inputStream4 = inputStream;
                    if (inputStream4 != null) {
                        try {
                            inputStream4.close();
                        } catch (IOException e7) {
                            DDLog.e(e7.getMessage(), e7 + "");
                        }
                    }
                    append = new StringBuilder().append("\u4e0a\u4f20\u6587\u4ef6\u7ed3\u675f...\u7ed3\u679c :");
                }
            }
        }).start();
    }
}