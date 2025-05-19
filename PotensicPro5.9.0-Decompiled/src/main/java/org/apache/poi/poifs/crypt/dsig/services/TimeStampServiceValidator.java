package org.apache.poi.poifs.crypt.dsig.services;

import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes5.dex */
public interface TimeStampServiceValidator {
    void validate(List<X509Certificate> list, RevocationData revocationData) throws Exception;
}
