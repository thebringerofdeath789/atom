package com.logan.upgrade.local.camera.ftp;

import com.ipotensic.baselib.DDLog;
import java.io.BufferedInputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/* loaded from: classes3.dex */
public class FTPUtils {
    public static final String CAM_USERNAME = "anonymous";
    public static final String FEEDBACK_HOSTNAME = "120.24.60.36";
    public static final String FEEDBACK_USERNAME = "appdepstechtest";
    private static FTPUtils mFTPUtils;
    private FTPClient ftpClient;
    private String ip;
    private Integer port = 21;
    private String userName = "";
    private String passWord = "";
    private final int timeOut = 20;

    public interface UploadProgressListener {
        void onUploadEnd(boolean z);

        void onUploadProgress(long j);
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean connectFtp() {
        try {
            if (this.ftpClient == null) {
                FTPClient fTPClient = new FTPClient();
                this.ftpClient = fTPClient;
                fTPClient.setDefaultTimeout(20000);
                this.ftpClient.setConnectTimeout(20000);
                this.ftpClient.setDataTimeout(20000);
                this.ftpClient.setControlEncoding("utf-8");
            }
            DDLog.e("ftp", "ip = " + this.ip + ", userName = " + this.userName);
            this.ftpClient.connect(this.ip, this.port.intValue());
            this.ftpClient.login(this.userName, "");
            this.ftpClient.setFileType(2);
            if (!FTPReply.isPositiveCompletion(this.ftpClient.getReplyCode())) {
                this.ftpClient.abort();
                this.ftpClient.disconnect();
                DDLog.e("ftp:连接服务器失败");
                return false;
            }
        } catch (Exception e) {
            DDLog.e("ftp:", e.getMessage() + "");
        }
        this.ftpClient.enterLocalPassiveMode();
        this.ftpClient.setRemoteVerificationEnabled(false);
        DDLog.e("ftp:连接服务器成功");
        return true;
    }

    public void uploadFile(final String str, final String str2, final long j, String str3, String str4, final UploadProgressListener uploadProgressListener) {
        this.userName = str3;
        this.ip = str4;
        new Thread(new Runnable() { // from class: com.logan.upgrade.local.camera.ftp.FTPUtils.1
            private BufferedInputStream buffIn;
            private ProgressInputStream progressInput;

            /* JADX WARN: Code restructure failed: missing block: B:25:0x00d2, code lost:
            
                if (r4 != false) goto L54;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x015f, code lost:
            
                r0 = "失败 ";
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0160, code lost:
            
                com.ipotensic.baselib.DDLog.e("FTP", r2.append(r0).toString());
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:78:0x015c, code lost:
            
                if (0 == 0) goto L53;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 425
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.logan.upgrade.local.camera.ftp.FTPUtils.AnonymousClass1.run():void");
            }
        }).start();
    }
}
