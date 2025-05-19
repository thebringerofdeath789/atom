package com.mapbox.android.telemetry;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.mapbox.android.telemetry.TelemetryClientSettings;

/* loaded from: classes3.dex */
class TelemetryClientFactory {
    private static final String LOG_TAG = "TelemetryClientFactory";
    private static final String RETRIEVING_APP_META_DATA_ERROR_MESSAGE = "Failed when retrieving app meta-data: %s";
    private final String accessToken;
    private final CertificateBlacklist certificateBlacklist;
    private final Logger logger;
    private final String userAgent;

    TelemetryClientFactory(String str, String str2, Logger logger, CertificateBlacklist certificateBlacklist) {
        this.accessToken = str;
        this.userAgent = str2;
        this.logger = logger;
        this.certificateBlacklist = certificateBlacklist;
    }

    TelemetryClient obtainTelemetryClient(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return buildClientFrom(new EnvironmentChain().setup().obtainServerInformation(applicationInfo.metaData), context);
            }
        } catch (Exception e) {
            this.logger.error(LOG_TAG, String.format(RETRIEVING_APP_META_DATA_ERROR_MESSAGE, e.getMessage()));
        }
        return buildTelemetryClient(Environment.COM, this.certificateBlacklist, context);
    }

    TelemetryClient obtainTelemetryClient(Environment environment, Context context) {
        if (environment == Environment.CHINA) {
            return buildTelemetryClient(environment, this.certificateBlacklist, context);
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return buildClientFrom(new ComServerInformation().obtainServerInformation(applicationInfo.metaData), context);
            }
        } catch (Exception e) {
            this.logger.error(LOG_TAG, String.format(RETRIEVING_APP_META_DATA_ERROR_MESSAGE, e.getMessage()));
        }
        return buildTelemetryClient(Environment.COM, this.certificateBlacklist, context);
    }

    private TelemetryClient buildTelemetryClient(Environment environment, CertificateBlacklist certificateBlacklist, Context context) {
        return new TelemetryClient(this.accessToken, this.userAgent, TelemetryUtils.createReformedFullUserAgent(context), new TelemetryClientSettings.Builder(context).environment(environment).build(), this.logger, certificateBlacklist, environment == Environment.CHINA);
    }

    private TelemetryClient buildTelemetryClientCustom(ServerInformation serverInformation, CertificateBlacklist certificateBlacklist, Context context) {
        TelemetryClientSettings build = new TelemetryClientSettings.Builder(context).environment(serverInformation.getEnvironment()).baseUrl(TelemetryClientSettings.configureUrlHostname(serverInformation.getHostname())).build();
        String accessToken = serverInformation.getAccessToken();
        if (accessToken == null) {
            accessToken = this.accessToken;
        }
        return new TelemetryClient(accessToken, this.userAgent, TelemetryUtils.createReformedFullUserAgent(context), build, this.logger, certificateBlacklist, serverInformation.getEnvironment() == Environment.CHINA);
    }

    /* renamed from: com.mapbox.android.telemetry.TelemetryClientFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mapbox$android$telemetry$Environment;

        static {
            int[] iArr = new int[Environment.values().length];
            $SwitchMap$com$mapbox$android$telemetry$Environment = iArr;
            try {
                iArr[Environment.STAGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private TelemetryClient buildClientFrom(ServerInformation serverInformation, Context context) {
        Environment environment = serverInformation.getEnvironment();
        if (AnonymousClass1.$SwitchMap$com$mapbox$android$telemetry$Environment[environment.ordinal()] == 1) {
            return buildTelemetryClientCustom(serverInformation, this.certificateBlacklist, context);
        }
        if (!TelemetryUtils.isEmpty(serverInformation.getHostname())) {
            return buildTelemetryClientCustom(serverInformation, this.certificateBlacklist, context);
        }
        return buildTelemetryClient(environment, this.certificateBlacklist, context);
    }
}
