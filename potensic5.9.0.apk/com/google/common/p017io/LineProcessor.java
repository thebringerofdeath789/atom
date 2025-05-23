package com.google.common.p017io;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}