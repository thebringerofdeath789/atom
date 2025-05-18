package com.mapbox.android.telemetry;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
class CertificateBlacklist implements ConfigurationChangeHandler {
    private static final String BLACKLIST_FILE = "MapboxBlacklist";
    private static final String LOG_TAG = "MapboxBlacklist";
    private final Context context;
    private final List<String> revokedKeys = new CopyOnWriteArrayList();

    CertificateBlacklist(Context context, ConfigurationClient configurationClient) {
        this.context = context;
        configurationClient.addHandler(this);
        if (configurationClient.shouldUpdate()) {
            configurationClient.update();
        } else {
            retrieveBlackList(context.getFilesDir(), false);
        }
    }

    boolean isBlacklisted(String str) {
        return this.revokedKeys.contains(str);
    }

    private void retrieveBlackList(File file, boolean z) {
        if (file.isDirectory()) {
            File file2 = new File(file, "MapboxBlacklist");
            if (file2.exists()) {
                try {
                    List<String> obtainBlacklistContents = obtainBlacklistContents(file2);
                    if (obtainBlacklistContents.isEmpty()) {
                        return;
                    }
                    if (z) {
                        this.revokedKeys.clear();
                    }
                    this.revokedKeys.addAll(obtainBlacklistContents);
                } catch (IOException e) {
                    Log.e("MapboxBlacklist", e.getMessage());
                }
            }
        }
    }

    private boolean saveBlackList(String str) {
        boolean z = false;
        if (!isValidContent(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = this.context.openFileOutput("MapboxBlacklist", 0);
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    z = true;
                } catch (IOException e) {
                    Log.e("MapboxBlacklist", e.getMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e2) {
                Log.e("MapboxBlacklist", e2.getMessage());
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    Log.e("MapboxBlacklist", e3.getMessage());
                }
            }
            throw th;
        }
    }

    private static boolean isValidContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Gson create = new GsonBuilder().create();
        try {
            JsonElement jsonElement = ((JsonObject) create.fromJson(str, JsonObject.class)).get("RevokedCertKeys");
            JsonArray jsonArray = jsonElement.isJsonArray() ? (JsonArray) create.fromJson(jsonElement, JsonArray.class) : null;
            return jsonArray != null && jsonArray.size() > 0;
        } catch (JsonSyntaxException e) {
            Log.e("MapboxBlacklist", e.getMessage());
            return false;
        }
    }

    private List<String> obtainBlacklistContents(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        Gson gson = new Gson();
        List<String> list = null;
        try {
            JsonObject jsonObject = (JsonObject) gson.fromJson((Reader) bufferedReader, JsonObject.class);
            if (jsonObject != null) {
                list = (List) gson.fromJson(jsonObject.getAsJsonArray("RevokedCertKeys").toString(), new TypeToken<List<String>>() { // from class: com.mapbox.android.telemetry.CertificateBlacklist.1
                }.getType());
            }
        } catch (JsonIOException | JsonSyntaxException e) {
            Log.e("MapboxBlacklist", e.getMessage());
        }
        bufferedReader.close();
        return list != null ? list : Collections.emptyList();
    }

    @Override // com.mapbox.android.telemetry.ConfigurationChangeHandler
    public void onUpdate(String str) {
        if (saveBlackList(str)) {
            retrieveBlackList(this.context.getFilesDir(), true);
        }
    }
}