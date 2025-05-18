package com.mapbox.android.core.crashreporter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.mapbox.android.core.FileUtils;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class MapboxUncaughtExceptionHanlder implements Thread.UncaughtExceptionHandler, SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String CRASH_FILENAME_FORMAT = "%s/%s.crash";
    private static final int DEFAULT_EXCEPTION_CHAIN_DEPTH = 2;
    private static final int DEFAULT_MAX_REPORTS = 10;
    public static final String MAPBOX_CRASH_REPORTER_PREFERENCES = "MapboxCrashReporterPrefs";
    public static final String MAPBOX_PREF_ENABLE_CRASH_REPORTER = "mapbox.crash.enable";
    private static final String TAG = "MbUncaughtExcHandler";
    private final Context applicationContext;
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private int exceptionChainDepth;
    private final AtomicBoolean isEnabled = new AtomicBoolean(true);
    private final String mapboxPackage;
    private final String version;

    MapboxUncaughtExceptionHanlder(Context context, SharedPreferences sharedPreferences, String str, String str2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Invalid package name: " + str + " or version: " + str2);
        }
        this.applicationContext = context;
        this.mapboxPackage = str;
        this.version = str2;
        this.exceptionChainDepth = 2;
        this.defaultExceptionHandler = uncaughtExceptionHandler;
        initializeSharedPreferences(sharedPreferences);
    }

    public static void install(Context context, String str, String str2) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context context2 = context;
        Thread.setDefaultUncaughtExceptionHandler(new MapboxUncaughtExceptionHanlder(context2, context2.getSharedPreferences(MAPBOX_CRASH_REPORTER_PREFERENCES, 0), str, str2, Thread.getDefaultUncaughtExceptionHandler()));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.isEnabled.get()) {
            List<Throwable> causalChain = getCausalChain(th);
            if (isMapboxCrash(causalChain)) {
                try {
                    CrashReport build = CrashReportBuilder.setup(this.applicationContext, this.mapboxPackage, this.version).addExceptionThread(thread).addCausalChain(causalChain).build();
                    ensureDirectoryWritable(this.applicationContext, this.mapboxPackage);
                    FileUtils.writeToFile(FileUtils.getFile(this.applicationContext, getReportFileName(this.mapboxPackage, build.getDateString())), build.toJson());
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Log.i(TAG, "Default exception handler is null");
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (MAPBOX_PREF_ENABLE_CRASH_REPORTER.equals(str)) {
            try {
                this.isEnabled.set(sharedPreferences.getBoolean(MAPBOX_PREF_ENABLE_CRASH_REPORTER, false));
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    boolean isEnabled() {
        return this.isEnabled.get();
    }

    void setExceptionChainDepth(int i) {
        this.exceptionChainDepth = i;
    }

    boolean isMapboxCrash(List<Throwable> list) {
        Iterator<Throwable> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            for (StackTraceElement stackTraceElement : it.next().getStackTrace()) {
                if (isMapboxStackTraceElement(stackTraceElement)) {
                    return true;
                }
            }
        }
    }

    List<Throwable> getCausalChain(Throwable th) {
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        while (th != null) {
            i++;
            if (isMidOrLowLevelException(i)) {
                arrayList.add(th);
            }
            th = th.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean isMapboxStackTraceElement(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName().startsWith(this.mapboxPackage);
    }

    private boolean isMidOrLowLevelException(int i) {
        return i >= this.exceptionChainDepth;
    }

    static void ensureDirectoryWritable(Context context, String str) {
        File file = FileUtils.getFile(context, str);
        if (!file.exists()) {
            file.mkdir();
        }
        File[] listAllFiles = FileUtils.listAllFiles(file);
        if (listAllFiles.length >= 10) {
            FileUtils.deleteFirst(listAllFiles, new FileUtils.LastModifiedComparator(), 9);
        }
    }

    static String getReportFileName(String str, String str2) {
        return String.format(CRASH_FILENAME_FORMAT, str, str2);
    }

    private void initializeSharedPreferences(SharedPreferences sharedPreferences) {
        try {
            this.isEnabled.set(sharedPreferences.getBoolean(MAPBOX_PREF_ENABLE_CRASH_REPORTER, true));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }
}