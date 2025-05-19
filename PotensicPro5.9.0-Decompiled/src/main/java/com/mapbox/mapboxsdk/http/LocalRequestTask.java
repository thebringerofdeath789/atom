package com.mapbox.mapboxsdk.http;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
class LocalRequestTask extends AsyncTask<String, Void, byte[]> {
    private static final String TAG = "Mbgl-LocalRequestTask";
    private OnLocalRequestResponse requestResponse;

    public interface OnLocalRequestResponse {
        void onResponse(byte[] bArr);
    }

    LocalRequestTask(OnLocalRequestResponse onLocalRequestResponse) {
        this.requestResponse = onLocalRequestResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public byte[] doInBackground(String... strArr) {
        return loadFile(Mapbox.getApplicationContext().getAssets(), "integration/" + strArr[0].substring(8).replaceAll("%20", StringUtils.SPACE).replaceAll("%2c", ","));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(byte[] bArr) {
        OnLocalRequestResponse onLocalRequestResponse;
        super.onPostExecute((LocalRequestTask) bArr);
        if (bArr == null || (onLocalRequestResponse = this.requestResponse) == null) {
            return;
        }
        onLocalRequestResponse.onResponse(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static byte[] loadFile(AssetManager assetManager, String str) {
        byte[] bArr;
        ?? r0 = 0;
        byte[] bArr2 = null;
        InputStream inputStream = null;
        try {
            try {
                InputStream open = assetManager.open(str);
                try {
                    bArr2 = new byte[open.available()];
                    open.read(bArr2);
                    r0 = bArr2;
                    if (open != null) {
                        try {
                            open.close();
                            r0 = bArr2;
                        } catch (IOException e) {
                            logFileError(e);
                            r0 = bArr2;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    byte[] bArr3 = bArr2;
                    inputStream = open;
                    bArr = bArr3;
                    logFileError(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            logFileError(e3);
                        }
                    }
                    r0 = bArr;
                    return r0;
                } catch (Throwable th) {
                    th = th;
                    r0 = open;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            logFileError(e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bArr = null;
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void logFileError(Exception exc) {
        Logger.e(TAG, "Load file failed", exc);
        MapStrictMode.strictModeViolation("Load file failed", exc);
    }
}
