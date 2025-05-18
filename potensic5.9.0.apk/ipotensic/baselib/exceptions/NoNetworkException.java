package com.ipotensic.baselib.exceptions;

import com.ipotensic.baselib.R;
import com.ipotensic.baselib.configs.PhoneConfig;

/* loaded from: classes2.dex */
public class NoNetworkException extends Exception {
    @Override // java.lang.Throwable
    public String getMessage() {
        return PhoneConfig.applicationContext.getResources().getString(R.string.please_check_the_network);
    }
}