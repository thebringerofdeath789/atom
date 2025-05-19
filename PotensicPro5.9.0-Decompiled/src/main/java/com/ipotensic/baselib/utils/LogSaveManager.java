package com.ipotensic.baselib.utils;

import android.os.Process;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class LogSaveManager {
    private static LogSaveManager INSTANCE;
    private String logPath;
    private int mPId;
    private LogDumper mLogDumper = null;
    private final long LOG_INTERVAL = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR;
    private final String LOG_NAME_HEAD = "APP_LOG_";

    public static LogSaveManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LogSaveManager();
        }
        return INSTANCE;
    }

    private LogSaveManager() {
    }

    public void start() {
        this.mPId = Process.myPid();
        this.logPath = LocalFileManager.getInstance().getLogDir();
        LogDumper logDumper = this.mLogDumper;
        if (logDumper == null) {
            this.mLogDumper = new LogDumper(String.valueOf(this.mPId), this.logPath);
        } else if (logDumper.isRunning()) {
            stop();
        }
        try {
            LogDumper logDumper2 = this.mLogDumper;
            if (logDumper2 != null) {
                logDumper2.start();
            }
        } catch (Exception e) {
            DDLog.e("app log存储失败:" + e);
        }
    }

    public boolean isRunning() {
        LogDumper logDumper = this.mLogDumper;
        return logDumper != null && logDumper.isRunning();
    }

    public void stop() {
        LogDumper logDumper = this.mLogDumper;
        if (logDumper != null) {
            logDumper.stopLogs();
            this.mLogDumper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restart() {
        stop();
        start();
    }

    private class LogDumper extends Thread {
        private String cmd;
        private Process logcatProc;
        private String mPID;
        private BufferedReader mReader = null;
        private boolean mRunning = true;
        private FileOutputStream out;
        private long startTime;

        public LogDumper(String str, String str2) {
            this.cmd = null;
            this.out = null;
            this.mPID = str;
            try {
                this.out = new FileOutputStream(new File(str2, "APP_LOG_" + FormatUtil.formatCurTime() + ".log"), true);
                this.startTime = System.currentTimeMillis();
                this.out.write("V5.9.0(574) \n".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
                DDLog.e("app log 存储失败 1 ：" + e.getMessage());
            }
            this.cmd = "logcat *:e *:w | grep \"(" + this.mPID + ")\"";
        }

        public void stopLogs() {
            this.mRunning = false;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            String readLine;
            try {
                try {
                    this.logcatProc = Runtime.getRuntime().exec(this.cmd);
                    this.mReader = new BufferedReader(new InputStreamReader(this.logcatProc.getInputStream()), 1024);
                    while (this.mRunning && (readLine = this.mReader.readLine()) != null && this.mRunning) {
                        if (readLine.length() != 0) {
                            if (this.out != null && readLine.contains(this.mPID)) {
                                this.out.write((readLine + "\n").getBytes());
                            }
                            if (this.startTime > System.currentTimeMillis()) {
                                this.startTime = 0L;
                            }
                            if (System.currentTimeMillis() - this.startTime >= org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR) {
                                LogSaveManager.this.restart();
                            }
                        }
                    }
                    Process process = this.logcatProc;
                    if (process != null) {
                        process.destroy();
                        this.logcatProc = null;
                    }
                    BufferedReader bufferedReader = this.mReader;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            this.mReader = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    fileOutputStream = this.out;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    DDLog.i("log 存储失败：" + e2.getMessage());
                    Process process2 = this.logcatProc;
                    if (process2 != null) {
                        process2.destroy();
                        this.logcatProc = null;
                    }
                    BufferedReader bufferedReader2 = this.mReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            this.mReader = null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    FileOutputStream fileOutputStream2 = this.out;
                    if (fileOutputStream2 == null) {
                        return;
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        this.out = null;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        this.out = null;
                    }
                    this.out = null;
                }
            } catch (Throwable th) {
                Process process3 = this.logcatProc;
                if (process3 != null) {
                    process3.destroy();
                    this.logcatProc = null;
                }
                BufferedReader bufferedReader3 = this.mReader;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        this.mReader = null;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                FileOutputStream fileOutputStream3 = this.out;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    this.out = null;
                    throw th;
                }
                throw th;
            }
        }
    }
}
