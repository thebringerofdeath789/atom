package org.apache.poi.poifs.crypt.dsig.services;

import org.apache.poi.poifs.crypt.dsig.SignatureConfig;

/* loaded from: classes5.dex */
public interface TimeStampService extends SignatureConfig.SignatureConfigurable {
    byte[] timeStamp(byte[] bArr, RevocationData revocationData) throws Exception;
}
