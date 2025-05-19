package org.apache.commons.net.bsd;

import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class RLoginClient extends RCommandClient {
    public static final int DEFAULT_PORT = 513;

    public RLoginClient() {
        setDefaultPort(513);
    }

    public void rlogin(String str, String str2, String str3, int i) throws IOException {
        rexec(str, str2, str3 + InternalZipConstants.ZIP_FILE_SEPARATOR + i, false);
    }

    public void rlogin(String str, String str2, String str3) throws IOException {
        rexec(str, str2, str3, false);
    }
}
