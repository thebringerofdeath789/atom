package org.apache.poi.util;

import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface TempFileCreationStrategy {
    File createTempFile(String str, String str2) throws IOException;
}
