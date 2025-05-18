package com.mapbox.android.core.crashreporter;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class CrashReportBuilder {
    private static final String OS_VERSION_FORMAT = "Android-%s";
    private static final String STACK_TRACE_ELEMENT_FORMAT = "%s.%s(%s:%d)";
    private static final String THREAD_DETAILS_FORMAT = "tid:%s|name:%s|priority:%s";
    private final Context applicationContext;
    private final List<Throwable> causalChain = new ArrayList(4);
    private boolean isSilent;
    private final String sdkIdentifier;
    private final String sdkVersion;
    private Thread uncaughtExceptionThread;

    private CrashReportBuilder(Context context, String str, String str2) {
        this.applicationContext = context;
        this.sdkIdentifier = str;
        this.sdkVersion = str2;
    }

    public static CrashReport fromJson(String str) throws IllegalArgumentException {
        try {
            return new CrashReport(str);
        } catch (JSONException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    static CrashReportBuilder setup(Context context, String str, String str2) {
        return new CrashReportBuilder(context, str, str2);
    }

    CrashReportBuilder isSilent(boolean z) {
        this.isSilent = z;
        return this;
    }

    CrashReportBuilder addCausalChain(List<Throwable> list) {
        this.causalChain.addAll(list);
        return this;
    }

    CrashReportBuilder addExceptionThread(Thread thread) {
        this.uncaughtExceptionThread = thread;
        return this;
    }

    CrashReport build() {
        CrashReport crashReport = new CrashReport(new GregorianCalendar());
        crashReport.put("sdkIdentifier", this.sdkIdentifier);
        crashReport.put("sdkVersion", this.sdkVersion);
        crashReport.put("osVersion", String.format(OS_VERSION_FORMAT, Build.VERSION.RELEASE));
        crashReport.put("model", Build.MODEL);
        crashReport.put("device", Build.DEVICE);
        crashReport.put("isSilent", Boolean.toString(this.isSilent));
        crashReport.put("stackTraceHash", getStackTraceHash(this.causalChain));
        crashReport.put("stackTrace", getStackTrace(this.causalChain));
        Thread thread = this.uncaughtExceptionThread;
        if (thread != null) {
            crashReport.put("threadDetails", String.format(THREAD_DETAILS_FORMAT, Long.valueOf(thread.getId()), this.uncaughtExceptionThread.getName(), Integer.valueOf(this.uncaughtExceptionThread.getPriority())));
        }
        crashReport.put("appId", this.applicationContext.getPackageName());
        crashReport.put("appVersion", getAppVersion(this.applicationContext));
        return crashReport;
    }

    String getStackTrace(List<Throwable> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            for (StackTraceElement stackTraceElement : it.next().getStackTrace()) {
                if (stackTraceElement.getClassName().startsWith(this.sdkIdentifier)) {
                    sb.append(String.format(Locale.US, STACK_TRACE_ELEMENT_FORMAT, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()))).append('\n');
                }
            }
        }
        return sb.toString();
    }

    static String getStackTraceHash(List<Throwable> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            for (StackTraceElement stackTraceElement : it.next().getStackTrace()) {
                sb.append(stackTraceElement.getClassName());
                sb.append(stackTraceElement.getMethodName());
            }
        }
        return Integer.toHexString(sb.toString().hashCode());
    }

    private static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "unknown";
        }
    }
}