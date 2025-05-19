package com.mapbox.android.telemetry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
class TelemetryClient {
    private static final String ACCESS_TOKEN_QUERY_PARAMETER = "access_token";
    private static final String ATTACHMENTS_ENDPOINT = "/attachments/v1";
    private static final String BOUNDARY = "--01ead4a5-7a67-4703-ad02-589886e00923";
    private static final String EVENTS_ENDPOINT = "/events/v2";
    private static final String EXTRA_DEBUGGING_LOG = "Sending POST to %s with %d event(s) (user agent: %s) with payload: %s";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String LOG_TAG = "TelemetryClient";
    private static final String MAPBOX_AGENT_REQUEST_HEADER = "X-Mapbox-Agent";
    private static final String USER_AGENT_REQUEST_HEADER = "User-Agent";
    private String accessToken;
    private CertificateBlacklist certificateBlacklist;
    private boolean isCnRegion;
    private final Logger logger;
    private String reformedUserAgent;
    private TelemetryClientSettings setting;
    private String userAgent;

    TelemetryClient(String str, String str2, String str3, TelemetryClientSettings telemetryClientSettings, Logger logger, CertificateBlacklist certificateBlacklist, boolean z) {
        this.accessToken = str;
        this.userAgent = str2;
        this.reformedUserAgent = str3;
        this.setting = telemetryClientSettings;
        this.logger = logger;
        this.certificateBlacklist = certificateBlacklist;
        this.isCnRegion = z;
    }

    boolean isCnRegion() {
        return this.isCnRegion;
    }

    void updateAccessToken(String str) {
        this.accessToken = str;
    }

    void updateUserAgent(String str) {
        this.userAgent = str;
    }

    void sendEvents(List<Event> list, Callback callback, boolean z) {
        sendBatch(Collections.unmodifiableList(list), callback, z);
    }

    void sendAttachment(Attachment attachment, final CopyOnWriteArraySet<AttachmentListener> copyOnWriteArraySet) {
        List<FileAttachment> attachments = attachment.getAttachments();
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        MultipartBody.Builder type = new MultipartBody.Builder(BOUNDARY).setType(MultipartBody.FORM);
        for (FileAttachment fileAttachment : attachments) {
            FileData fileData = fileAttachment.getFileData();
            AttachmentMetadata attachmentMetadata = fileAttachment.getAttachmentMetadata();
            arrayList.add(attachmentMetadata);
            type.addFormDataPart(StringLookupFactory.KEY_FILE, attachmentMetadata.getName(), RequestBody.create(fileData.getType(), new File(fileData.getFilePath())));
            arrayList2.add(attachmentMetadata.getFileId());
        }
        type.addFormDataPart("attachments", new Gson().toJson(arrayList));
        RequestBody reverseMultiForm = reverseMultiForm(type);
        HttpUrl build = this.setting.getBaseUrl().newBuilder(ATTACHMENTS_ENDPOINT).addQueryParameter(ACCESS_TOKEN_QUERY_PARAMETER, this.accessToken).build();
        if (isExtraDebuggingNeeded()) {
            this.logger.debug(LOG_TAG, String.format(Locale.US, EXTRA_DEBUGGING_LOG, build, Integer.valueOf(attachments.size()), this.userAgent, arrayList));
        }
        this.setting.getAttachmentClient(this.certificateBlacklist).newCall(new Request.Builder().url(build).header("User-Agent", this.userAgent).addHeader(MAPBOX_AGENT_REQUEST_HEADER, this.reformedUserAgent).post(reverseMultiForm).build()).enqueue(new Callback() { // from class: com.mapbox.android.telemetry.TelemetryClient.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ((AttachmentListener) it.next()).onAttachmentFailure(iOException.getMessage(), arrayList2);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ((AttachmentListener) it.next()).onAttachmentResponse(response.message(), response.code(), arrayList2);
                }
            }
        });
    }

    void updateDebugLoggingEnabled(boolean z) {
        this.setting = this.setting.toBuilder().debugLoggingEnabled(z).build();
    }

    String obtainAccessToken() {
        return this.accessToken;
    }

    TelemetryClientSettings obtainSetting() {
        return this.setting;
    }

    private void sendBatch(List<Event> list, Callback callback, boolean z) {
        String json = (z ? new GsonBuilder().serializeNulls().create() : new Gson()).toJson(list);
        RequestBody create = RequestBody.create(JSON, json);
        HttpUrl build = this.setting.getBaseUrl().newBuilder(EVENTS_ENDPOINT).addQueryParameter(ACCESS_TOKEN_QUERY_PARAMETER, this.accessToken).build();
        if (isExtraDebuggingNeeded()) {
            this.logger.debug(LOG_TAG, String.format(Locale.US, EXTRA_DEBUGGING_LOG, build, Integer.valueOf(list.size()), this.userAgent, json));
        }
        this.setting.getClient(this.certificateBlacklist, list.size()).newCall(new Request.Builder().url(build).header("User-Agent", this.userAgent).addHeader(MAPBOX_AGENT_REQUEST_HEADER, this.reformedUserAgent).post(create).build()).enqueue(callback);
    }

    private boolean isExtraDebuggingNeeded() {
        return this.setting.isDebugLoggingEnabled() || this.setting.getEnvironment().equals(Environment.STAGING);
    }

    private RequestBody reverseMultiForm(MultipartBody.Builder builder) {
        MultipartBody build = builder.build();
        MultipartBody.Builder type = new MultipartBody.Builder(BOUNDARY).setType(MultipartBody.FORM);
        int size = build.size();
        while (true) {
            size--;
            if (size > -1) {
                type.addPart(build.part(size));
            } else {
                return type.build();
            }
        }
    }

    synchronized void setBaseUrl(String str) {
        this.setting = this.setting.toBuilder().baseUrl(TelemetryClientSettings.configureUrlHostname(str)).build();
    }
}
