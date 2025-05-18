package com.mapbox.android.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.mapbox.android.telemetry.Event;
import com.mapbox.android.telemetry.TelemetryEnabler;
import com.mapbox.android.telemetry.errors.ErrorReporterEngine;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class MapboxTelemetry implements FullQueueCallback, ServiceTaskCallback {
    private static final String LOG_TAG = "MapboxTelemetry";
    private static final String NON_NULL_APPLICATION_CONTEXT_REQUIRED = "Non-null application context required.";
    private CopyOnWriteArraySet<AttachmentListener> attachmentListeners;
    private CertificateBlacklist certificateBlacklist;
    private Clock clock;
    private ConfigurationClient configurationClient;
    private final ExecutorService executorService;
    private Callback httpCallback;
    private final EventsQueue queue;
    private final SchedulerFlusher schedulerFlusher;
    private TelemetryClient telemetryClient;
    private final TelemetryEnabler telemetryEnabler;
    private CopyOnWriteArraySet<TelemetryListener> telemetryListeners;
    private String userAgent;
    private static AtomicReference<String> sAccessToken = new AtomicReference<>("");
    static Context applicationContext = null;

    public MapboxTelemetry(Context context, String str, String str2) {
        this.clock = null;
        this.telemetryListeners = null;
        this.attachmentListeners = null;
        initializeContext(context);
        ExecutorService create = ExecutorServiceFactory.create("MapboxTelemetryExecutor", 3, 20L);
        this.executorService = create;
        setAccessToken(context, str, create);
        this.userAgent = str2;
        this.schedulerFlusher = new SchedulerFlusherFactory(applicationContext, obtainAlarmReceiver()).supply();
        this.telemetryEnabler = new TelemetryEnabler(true);
        initializeTelemetryListeners();
        initializeAttachmentListeners();
        this.httpCallback = getHttpCallback(this.telemetryListeners);
        this.queue = EventsQueue.create(this, create);
    }

    MapboxTelemetry(Context context, String str, String str2, EventsQueue eventsQueue, TelemetryClient telemetryClient, Callback callback, SchedulerFlusher schedulerFlusher, Clock clock, TelemetryEnabler telemetryEnabler, ExecutorService executorService) {
        this.clock = null;
        this.telemetryListeners = null;
        this.attachmentListeners = null;
        initializeContext(context);
        setAccessToken(context, str, executorService);
        this.userAgent = str2;
        this.telemetryClient = telemetryClient;
        this.schedulerFlusher = schedulerFlusher;
        this.clock = clock;
        this.telemetryEnabler = telemetryEnabler;
        initializeTelemetryListeners();
        initializeAttachmentListeners();
        this.httpCallback = callback;
        this.executorService = executorService;
        this.queue = eventsQueue;
    }

    @Override // com.mapbox.android.telemetry.FullQueueCallback
    public void onFullQueue(List<Event> list) {
        if (!TelemetryEnabler.State.ENABLED.equals(this.telemetryEnabler.obtainTelemetryState()) || TelemetryUtils.adjustWakeUpMode(applicationContext)) {
            return;
        }
        sendEvents(list, false);
    }

    @Override // com.mapbox.android.telemetry.ServiceTaskCallback
    public void onTaskRemoved() {
        flushEnqueuedEvents();
        unregisterTelemetry();
    }

    public boolean push(Event event) {
        if (sendEventIfWhitelisted(event)) {
            return true;
        }
        return pushToQueue(event);
    }

    public boolean enable() {
        if (!TelemetryEnabler.isEventsEnabled(applicationContext)) {
            return false;
        }
        startTelemetry();
        return true;
    }

    public boolean disable() {
        if (!TelemetryEnabler.isEventsEnabled(applicationContext)) {
            return false;
        }
        stopTelemetry();
        return true;
    }

    public boolean updateSessionIdRotationInterval(SessionInterval sessionInterval) {
        final long obtainInterval = sessionInterval.obtainInterval();
        executeRunnable(new Runnable() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences.Editor edit = TelemetryUtils.obtainSharedPreferences(MapboxTelemetry.applicationContext).edit();
                    edit.putLong(MapboxTelemetryConstants.SESSION_ROTATION_INTERVAL_MILLIS, TimeUnit.HOURS.toMillis(obtainInterval));
                    edit.apply();
                } catch (Throwable th) {
                    Log.e(MapboxTelemetry.LOG_TAG, th.toString());
                }
            }
        });
        return true;
    }

    public void updateDebugLoggingEnabled(boolean z) {
        TelemetryClient telemetryClient = this.telemetryClient;
        if (telemetryClient != null) {
            telemetryClient.updateDebugLoggingEnabled(z);
        }
    }

    public void updateUserAgent(String str) {
        if (isUserAgentValid(str)) {
            this.telemetryClient.updateUserAgent(TelemetryUtils.createFullUserAgent(str, applicationContext));
        }
    }

    public boolean updateAccessToken(String str) {
        if (!isAccessTokenValid(str) || !updateTelemetryClient(str)) {
            return false;
        }
        sAccessToken.set(str);
        return true;
    }

    public boolean addTelemetryListener(TelemetryListener telemetryListener) {
        return this.telemetryListeners.add(telemetryListener);
    }

    public boolean removeTelemetryListener(TelemetryListener telemetryListener) {
        return this.telemetryListeners.remove(telemetryListener);
    }

    public boolean addAttachmentListener(AttachmentListener attachmentListener) {
        return this.attachmentListeners.add(attachmentListener);
    }

    public boolean removeAttachmentListener(AttachmentListener attachmentListener) {
        return this.attachmentListeners.remove(attachmentListener);
    }

    boolean isQueueEmpty() {
        return this.queue.isEmpty();
    }

    boolean checkRequiredParameters(String str, String str2) {
        boolean areRequiredParametersValid = areRequiredParametersValid(str, str2);
        if (areRequiredParametersValid) {
            initializeTelemetryClient();
        }
        return areRequiredParametersValid;
    }

    private void initializeContext(Context context) {
        if (applicationContext == null) {
            if (context != null && context.getApplicationContext() != null) {
                applicationContext = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException(NON_NULL_APPLICATION_CONTEXT_REQUIRED);
        }
    }

    private boolean areRequiredParametersValid(String str, String str2) {
        return isAccessTokenValid(str) && isUserAgentValid(str2);
    }

    private boolean isAccessTokenValid(String str) {
        if (TelemetryUtils.isEmpty(str)) {
            return false;
        }
        sAccessToken.set(str);
        return true;
    }

    private boolean isUserAgentValid(String str) {
        if (TelemetryUtils.isEmpty(str)) {
            return false;
        }
        this.userAgent = str;
        return true;
    }

    private void initializeTelemetryClient() {
        if (this.configurationClient == null) {
            Context context = applicationContext;
            this.configurationClient = new ConfigurationClient(context, TelemetryUtils.createFullUserAgent(this.userAgent, context), sAccessToken.get(), new OkHttpClient());
        }
        if (this.certificateBlacklist == null) {
            this.certificateBlacklist = new CertificateBlacklist(applicationContext, this.configurationClient);
        }
        if (this.telemetryClient == null) {
            this.telemetryClient = createTelemetryClient(sAccessToken.get(), this.userAgent);
        }
    }

    private TelemetryClient createTelemetryClient(String str, String str2) {
        TelemetryClient obtainTelemetryClient = getTelemetryClientFactory(str, str2).obtainTelemetryClient(applicationContext);
        this.telemetryClient = obtainTelemetryClient;
        return obtainTelemetryClient;
    }

    TelemetryClientFactory getTelemetryClientFactory(String str, String str2) {
        return new TelemetryClientFactory(str, TelemetryUtils.createFullUserAgent(str2, applicationContext), new Logger(), this.certificateBlacklist);
    }

    private boolean updateTelemetryClient(String str) {
        TelemetryClient telemetryClient = this.telemetryClient;
        if (telemetryClient == null) {
            return false;
        }
        telemetryClient.updateAccessToken(str);
        return true;
    }

    private AlarmReceiver obtainAlarmReceiver() {
        return new AlarmReceiver(new SchedulerCallback() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.2
            @Override // com.mapbox.android.telemetry.SchedulerCallback
            public void onError() {
            }

            @Override // com.mapbox.android.telemetry.SchedulerCallback
            public void onPeriodRaised() {
                MapboxTelemetry.this.flushEnqueuedEvents();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void flushEnqueuedEvents() {
        final List<Event> flush = this.queue.flush();
        if (flush.isEmpty()) {
            return;
        }
        executeRunnable(new Runnable() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MapboxTelemetry.this.sendEvents(flush, false);
                } catch (Throwable th) {
                    Log.e(MapboxTelemetry.LOG_TAG, th.toString());
                }
            }
        });
    }

    private boolean isNetworkConnected() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sendEvents(List<Event> list, boolean z) {
        if (isNetworkConnected() && checkRequiredParameters(sAccessToken.get(), this.userAgent)) {
            this.telemetryClient.sendEvents(list, this.httpCallback, z);
        }
    }

    private void initializeTelemetryListeners() {
        this.telemetryListeners = new CopyOnWriteArraySet<>();
    }

    private void initializeAttachmentListeners() {
        this.attachmentListeners = new CopyOnWriteArraySet<>();
    }

    private boolean pushToQueue(Event event) {
        if (TelemetryEnabler.State.ENABLED.equals(this.telemetryEnabler.obtainTelemetryState())) {
            return this.queue.push(event);
        }
        return false;
    }

    private void unregisterTelemetry() {
        this.schedulerFlusher.unregister();
    }

    /* renamed from: com.mapbox.android.telemetry.MapboxTelemetry$7 */
    static /* synthetic */ class C30837 {
        static final /* synthetic */ int[] $SwitchMap$com$mapbox$android$telemetry$Event$Type;

        static {
            int[] iArr = new int[Event.Type.values().length];
            $SwitchMap$com$mapbox$android$telemetry$Event$Type = iArr;
            try {
                iArr[Event.Type.TURNSTILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mapbox$android$telemetry$Event$Type[Event.Type.CRASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mapbox$android$telemetry$Event$Type[Event.Type.VIS_ATTACHMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private synchronized boolean sendEventIfWhitelisted(Event event) {
        boolean z;
        z = false;
        int i = C30837.$SwitchMap$com$mapbox$android$telemetry$Event$Type[event.obtainType().ordinal()];
        if (i == 1 || i == 2) {
            final List singletonList = Collections.singletonList(event);
            executeRunnable(new Runnable() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MapboxTelemetry.this.sendEvents(singletonList, true);
                    } catch (Throwable th) {
                        Log.e(MapboxTelemetry.LOG_TAG, th.toString());
                    }
                }
            });
        } else if (i == 3) {
            sendAttachment(event);
        }
        z = true;
        return z;
    }

    private void startTelemetry() {
        if (TelemetryEnabler.State.ENABLED.equals(this.telemetryEnabler.obtainTelemetryState())) {
            startAlarm();
            enableLocationCollector(true);
        }
    }

    private void startAlarm() {
        this.schedulerFlusher.register();
        this.schedulerFlusher.schedule(obtainClock().giveMeTheElapsedRealtime());
    }

    private Clock obtainClock() {
        if (this.clock == null) {
            this.clock = new Clock();
        }
        return this.clock;
    }

    private void stopTelemetry() {
        if (TelemetryEnabler.State.ENABLED.equals(this.telemetryEnabler.obtainTelemetryState())) {
            flushEnqueuedEvents();
            unregisterTelemetry();
            enableLocationCollector(false);
        }
    }

    private synchronized void enableLocationCollector(final boolean z) {
        executeRunnable(new Runnable() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences.Editor edit = TelemetryUtils.obtainSharedPreferences(MapboxTelemetry.applicationContext).edit();
                    edit.putBoolean(MapboxTelemetryConstants.LOCATION_COLLECTOR_ENABLED, z);
                    edit.apply();
                } catch (Throwable th) {
                    Log.e(MapboxTelemetry.LOG_TAG, th.toString());
                }
            }
        });
    }

    private static synchronized void setAccessToken(Context context, String str, ExecutorService executorService) {
        synchronized (MapboxTelemetry.class) {
            if (TelemetryUtils.isEmpty(str)) {
                return;
            }
            if (sAccessToken.getAndSet(str).isEmpty()) {
                ErrorReporterEngine.sendErrorReports(context, executorService);
            }
        }
    }

    private void executeRunnable(Runnable runnable) {
        try {
            this.executorService.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e(LOG_TAG, e.toString());
        }
    }

    private void sendAttachment(Event event) {
        if (checkNetworkAndParameters().booleanValue()) {
            this.telemetryClient.sendAttachment(convertEventToAttachment(event), this.attachmentListeners);
        }
    }

    private Attachment convertEventToAttachment(Event event) {
        return (Attachment) event;
    }

    private Boolean checkNetworkAndParameters() {
        return Boolean.valueOf(isNetworkConnected() && checkRequiredParameters(sAccessToken.get(), this.userAgent));
    }

    private static Callback getHttpCallback(final Set<TelemetryListener> set) {
        return new Callback() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.6
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((TelemetryListener) it.next()).onHttpFailure(iOException.getMessage());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body != null) {
                    body.close();
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((TelemetryListener) it.next()).onHttpResponse(response.isSuccessful(), response.code());
                }
            }
        };
    }

    private static final class ExecutorServiceFactory {
        private ExecutorServiceFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized ExecutorService create(String str, int i, long j) {
            ThreadPoolExecutor threadPoolExecutor;
            synchronized (ExecutorServiceFactory.class) {
                threadPoolExecutor = new ThreadPoolExecutor(0, i, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory(str));
            }
            return threadPoolExecutor;
        }

        private static ThreadFactory threadFactory(final String str) {
            return new ThreadFactory() { // from class: com.mapbox.android.telemetry.MapboxTelemetry.ExecutorServiceFactory.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, str);
                }
            };
        }
    }

    @Deprecated
    public synchronized boolean setBaseUrl(String str) {
        if (!isValidUrl(str) || !checkNetworkAndParameters().booleanValue()) {
            return false;
        }
        this.telemetryClient.setBaseUrl(str);
        return true;
    }

    private static boolean isValidUrl(String str) {
        return (str == null || str.isEmpty() || !Pattern.compile("^[a-z0-9]+([\\-.][a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(/.*)?$").matcher(str).matches()) ? false : true;
    }

    public boolean isCnRegion() {
        if (checkRequiredParameters(sAccessToken.get(), this.userAgent)) {
            return this.telemetryClient.isCnRegion();
        }
        return false;
    }

    public synchronized void setCnRegion(boolean z) {
        if (isCnRegion() == z) {
            return;
        }
        this.telemetryClient = getTelemetryClientFactory(sAccessToken.get(), this.userAgent).obtainTelemetryClient(z ? Environment.CHINA : Environment.COM, applicationContext);
    }
}