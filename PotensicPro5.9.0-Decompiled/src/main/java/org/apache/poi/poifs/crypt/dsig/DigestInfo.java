package org.apache.poi.poifs.crypt.dsig;

import java.io.Serializable;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* loaded from: classes5.dex */
public class DigestInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public final String description;
    public final byte[] digestValue;
    public final HashAlgorithm hashAlgo;

    public DigestInfo(byte[] bArr, HashAlgorithm hashAlgorithm, String str) {
        this.digestValue = bArr;
        this.hashAlgo = hashAlgorithm;
        this.description = str;
    }
}
