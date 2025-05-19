package com.mapbox.android.core;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes3.dex */
public class MapboxSdkInfoForUserAgentGenerator {
    private static final String EMPTY_STRING = "";
    private static final String LOG_TAG = "MapboxUAGenerator";
    private static final String MAPBOX_IDENTIFIER = "mapbox";
    private static final String SDK_VERSIONS_FOLDER = "sdk_versions";
    private static final String USER_AGENT_SDK_VERSION_FORMAT = " %s (%s%s)";
    private static MapboxSdkInfoForUserAgentGenerator userAgentGenerator;
    private String sdkInfoForUserAgent;
    private static final Object lock = new Object();
    private static final Locale DEFAULT_LOCALE = Locale.US;

    private MapboxSdkInfoForUserAgentGenerator(AssetManager assetManager) {
        this.sdkInfoForUserAgent = getMapboxSdkIdentifiersForUserAgent(assetManager);
    }

    public static MapboxSdkInfoForUserAgentGenerator getInstance(AssetManager assetManager) {
        if (userAgentGenerator == null) {
            synchronized (lock) {
                userAgentGenerator = new MapboxSdkInfoForUserAgentGenerator(assetManager);
            }
        }
        return userAgentGenerator;
    }

    String getMapboxSdkIdentifiersForUserAgent(AssetManager assetManager) {
        StringBuilder sb = new StringBuilder("");
        try {
            String[] list = assetManager.list(SDK_VERSIONS_FOLDER);
            if (list != null) {
                for (String str : list) {
                    if (str.contains("mapbox")) {
                        InputStream inputStream = null;
                        try {
                            try {
                                inputStream = assetManager.open(SDK_VERSIONS_FOLDER + File.separator + str);
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    readLine = "";
                                }
                                StringBuilder sb2 = new StringBuilder("");
                                while (true) {
                                    String readLine2 = bufferedReader.readLine();
                                    if (readLine2 == null) {
                                        break;
                                    }
                                    sb2.append("; ");
                                    sb2.append(readLine2);
                                }
                                bufferedReader.close();
                                sb.append(String.format(DEFAULT_LOCALE, USER_AGENT_SDK_VERSION_FORMAT, readLine, str, sb2.toString()));
                            } finally {
                            }
                        } catch (IOException e) {
                            Log.e(LOG_TAG, e.toString());
                        }
                        FileUtils.closeQuietly(inputStream);
                    }
                }
            }
        } catch (IOException e2) {
            Log.e(LOG_TAG, e2.toString());
        }
        return sb.toString().trim();
    }

    public String getSdkInfoForUserAgent() {
        return this.sdkInfoForUserAgent;
    }
}
