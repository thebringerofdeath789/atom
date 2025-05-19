package com.tencent.mmkv;

/* loaded from: classes3.dex */
public interface MMKVHandler {
    void mmkvLog(MMKVLogLevel level, String file, int line, String function, String message);

    MMKVRecoverStrategic onMMKVCRCCheckFail(String mmapID);

    MMKVRecoverStrategic onMMKVFileLengthError(String mmapID);

    boolean wantLogRedirecting();
}
