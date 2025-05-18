package com.mapbox.android.telemetry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.CertificatePinner;

/* loaded from: classes3.dex */
class CertificatePinnerFactory {
    private static final Map<Environment, Map<String, List<String>>> CERTIFICATES_PINS = new HashMap<Environment, Map<String, List<String>>>() { // from class: com.mapbox.android.telemetry.CertificatePinnerFactory.1
        {
            put(Environment.STAGING, StagingCertificatePins.CERTIFICATE_PINS);
            put(Environment.COM, ComCertificatePins.CERTIFICATE_PINS);
            put(Environment.CHINA, ChinaCertificatePins.CERTIFICATE_PINS);
        }
    };
    private static final String SHA256_PIN_FORMAT = "sha256/%s";

    CertificatePinnerFactory() {
    }

    CertificatePinner provideCertificatePinnerFor(Environment environment, CertificateBlacklist certificateBlacklist) {
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        addCertificatesPins(removeBlacklistedPins(provideCertificatesPinsFor(environment), certificateBlacklist), builder);
        return builder.build();
    }

    Map<String, List<String>> provideCertificatesPinsFor(Environment environment) {
        return CERTIFICATES_PINS.get(environment);
    }

    private void addCertificatesPins(Map<String, List<String>> map, CertificatePinner.Builder builder) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builder.add(entry.getKey(), String.format(SHA256_PIN_FORMAT, it.next()));
            }
        }
    }

    private Map<String, List<String>> removeBlacklistedPins(Map<String, List<String>> map, CertificateBlacklist certificateBlacklist) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null) {
                map.put(entry.getKey(), removeBlacklistedHashes(certificateBlacklist, value));
            }
        }
        return map;
    }

    private List<String> removeBlacklistedHashes(CertificateBlacklist certificateBlacklist, List<String> list) {
        for (String str : list) {
            if (certificateBlacklist.isBlacklisted(str)) {
                list.remove(str);
            }
        }
        return list;
    }
}