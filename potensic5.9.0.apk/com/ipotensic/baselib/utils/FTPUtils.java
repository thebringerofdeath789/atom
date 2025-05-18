package com.ipotensic.baselib.utils;

import com.ipotensic.baselib.DDLog;
import java.io.File;
import java.io.FileInputStream;
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
            DDLog.m1685e("FTP", "连接...FTP服务器...");
            this.ftpClient.connect(this.hostName, this.port.intValue());
            if (this.enterLocalPassiveMode) {
                this.ftpClient.setRemoteVerificationEnabled(false);
                this.ftpClient.enterLocalPassiveMode();
                this.ftpClient.disconnect();
            }
            this.ftpClient.login(this.userName, this.passWord);
            if (!FTPReply.isPositiveCompletion(this.ftpClient.getReplyCode())) {
                DDLog.m1685e("FTP", "连接...FTP服务器...失败: ");
                return false;
            }
            DDLog.m1685e("FTP", "连接...FTP服务器...成功:");
            return true;
        } catch (Exception e) {
            DDLog.m1685e(e.getMessage(), e + "");
            return true;
        }
    }

    public void uploadFile(String str, File file) {
        try {
            uploadFile(str, new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
            DDLog.m1685e("FTP", e.getMessage() + "  " + e);
        }
    }

    public void uploadFile(final String str, final InputStream inputStream) {
        new Thread(new Runnable() { // from class: com.ipotensic.baselib.utils.FTPUtils.1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x00a4, code lost:
            
                if (r5 != false) goto L41;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0120, code lost:
            
                r0 = "失败 ";
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0121, code lost:
            
                com.ipotensic.baselib.DDLog.m1685e("FTP", r2.append(r0).toString());
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
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 407
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.utils.FTPUtils.RunnableC19211.run():void");
            }
        }).start();
    }
}