package com.logan.user.view;

/* loaded from: classes3.dex */
public interface IFlightLogView {
    void fileIsExist();

    void missFiles();

    void notFrequentlyUpload();

    void someFileMd5Err(String str);

    void tokenError();

    void uploadError(Exception exc);

    void uploadSuccess();
}
