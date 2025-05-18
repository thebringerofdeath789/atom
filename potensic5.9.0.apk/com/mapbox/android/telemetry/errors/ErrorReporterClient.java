package com.mapbox.android.telemetry.errors;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mapbox.android.core.FileUtils;
import com.mapbox.android.core.crashreporter.MapboxUncaughtExceptionHanlder;
import com.mapbox.android.telemetry.BuildConfig;
import com.mapbox.android.telemetry.CrashEvent;
import com.mapbox.android.telemetry.MapboxTelemetry;
import com.mapbox.android.telemetry.TelemetryListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class ErrorReporterClient {
    private static final String CRASH_REPORTER_CLIENT_USER_AGENT = "mapbox-android-crash";
    private static final String LOG_TAG = "CrashReporterClient";
    private File[] crashReports;
    private final SharedPreferences sharedPreferences;
    private final MapboxTelemetry telemetry;
    private final HashSet<String> crashHashSet = new HashSet<>();
    private final HashMap<CrashEvent, File> eventFileHashMap = new HashMap<>();
    private int fileCursor = 0;
    private boolean isDebug = false;

    ErrorReporterClient(SharedPreferences sharedPreferences, MapboxTelemetry mapboxTelemetry, File[] fileArr) {
        this.sharedPreferences = sharedPreferences;
        this.telemetry = mapboxTelemetry;
        this.crashReports = fileArr;
    }

    static ErrorReporterClient create(Context context) {
        return new ErrorReporterClient(context.getSharedPreferences(MapboxUncaughtExceptionHanlder.MAPBOX_CRASH_REPORTER_PREFERENCES, 0), new MapboxTelemetry(context, "", String.format("%s/%s", CRASH_REPORTER_CLIENT_USER_AGENT, BuildConfig.VERSION_NAME)), new File[0]);
    }

    ErrorReporterClient loadFrom(File file) {
        this.fileCursor = 0;
        File[] listAllFiles = FileUtils.listAllFiles(file);
        this.crashReports = listAllFiles;
        Arrays.sort(listAllFiles, new FileUtils.LastModifiedComparator());
        return this;
    }

    ErrorReporterClient debug(boolean z) {
        this.isDebug = z;
        return this;
    }

    boolean isEnabled() {
        try {
            return this.sharedPreferences.getBoolean(MapboxUncaughtExceptionHanlder.MAPBOX_PREF_ENABLE_CRASH_REPORTER, true);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.toString());
            return false;
        }
    }

    boolean hasNextEvent() {
        return this.fileCursor < this.crashReports.length;
    }

    boolean isDuplicate(CrashEvent crashEvent) {
        return this.crashHashSet.contains(crashEvent.getHash());
    }

    CrashEvent nextEvent() {
        try {
            if (!hasNextEvent()) {
                throw new IllegalStateException("No more events can be read");
            }
            try {
                File file = this.crashReports[this.fileCursor];
                CrashEvent parseJsonCrashEvent = parseJsonCrashEvent(FileUtils.readFromFile(file));
                if (parseJsonCrashEvent.isValid()) {
                    this.eventFileHashMap.put(parseJsonCrashEvent, file);
                }
                return parseJsonCrashEvent;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("File cannot be read: " + e.toString());
            }
        } finally {
            this.fileCursor++;
        }
    }

    boolean send(CrashEvent crashEvent) {
        if (crashEvent.isValid()) {
            return sendSync(crashEvent, new AtomicBoolean(this.isDebug), new CountDownLatch(1));
        }
        return false;
    }

    boolean delete(CrashEvent crashEvent) {
        File file = this.eventFileHashMap.get(crashEvent);
        return file != null && file.delete();
    }

    boolean sendSync(CrashEvent crashEvent, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        setupTelemetryListener(atomicBoolean, countDownLatch);
        this.telemetry.push(crashEvent);
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
            if (atomicBoolean.get()) {
                this.crashHashSet.add(crashEvent.getHash());
            }
            return atomicBoolean.get();
        } catch (InterruptedException unused) {
            if (atomicBoolean.get()) {
                this.crashHashSet.add(crashEvent.getHash());
            }
            return false;
        } catch (Throwable th) {
            if (atomicBoolean.get()) {
                this.crashHashSet.add(crashEvent.getHash());
            }
            throw th;
        }
    }

    private void setupTelemetryListener(final AtomicBoolean atomicBoolean, final CountDownLatch countDownLatch) {
        this.telemetry.addTelemetryListener(new TelemetryListener() { // from class: com.mapbox.android.telemetry.errors.ErrorReporterClient.1
            @Override // com.mapbox.android.telemetry.TelemetryListener
            public void onHttpResponse(boolean z, int i) {
                Log.d(ErrorReporterClient.LOG_TAG, "Response: " + i);
                atomicBoolean.set(z);
                countDownLatch.countDown();
                ErrorReporterClient.this.telemetry.removeTelemetryListener(this);
            }

            @Override // com.mapbox.android.telemetry.TelemetryListener
            public void onHttpFailure(String str) {
                Log.d(ErrorReporterClient.LOG_TAG, "Response: " + str);
                countDownLatch.countDown();
                ErrorReporterClient.this.telemetry.removeTelemetryListener(this);
            }
        });
    }

    private static CrashEvent parseJsonCrashEvent(String str) {
        try {
            return (CrashEvent) new GsonBuilder().create().fromJson(str, CrashEvent.class);
        } catch (JsonSyntaxException e) {
            Log.e(LOG_TAG, e.toString());
            return new CrashEvent(null, null);
        }
    }
}