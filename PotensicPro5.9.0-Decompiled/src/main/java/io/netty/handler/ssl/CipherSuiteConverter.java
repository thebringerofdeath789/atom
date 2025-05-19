package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.net.imap.IMAPSClient;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
final class CipherSuiteConverter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CipherSuiteConverter.class);
    private static final Pattern JAVA_CIPHERSUITE_PATTERN = Pattern.compile("^(?:TLS|SSL)_((?:(?!_WITH_).)+)_WITH_(.*)_(.*)$");
    private static final Pattern OPENSSL_CIPHERSUITE_PATTERN = Pattern.compile("^(?:((?:(?:EXP-)?(?:(?:DHE|EDH|ECDH|ECDHE|SRP|RSA)-(?:DSS|RSA|ECDSA|PSK)|(?:ADH|AECDH|KRB5|PSK|SRP)))|EXP)-)?(.*)-(.*)$");
    private static final Pattern JAVA_AES_CBC_PATTERN = Pattern.compile("^(AES)_([0-9]+)_CBC$");
    private static final Pattern JAVA_AES_PATTERN = Pattern.compile("^(AES)_([0-9]+)_(.*)$");
    private static final Pattern OPENSSL_AES_CBC_PATTERN = Pattern.compile("^(AES)([0-9]+)$");
    private static final Pattern OPENSSL_AES_PATTERN = Pattern.compile("^(AES)([0-9]+)-(.*)$");
    private static final ConcurrentMap<String, String> j2o = PlatformDependent.newConcurrentHashMap();
    private static final ConcurrentMap<String, Map<String, String>> o2j = PlatformDependent.newConcurrentHashMap();

    private static String toJavaHmacAlgo(String str) {
        return str;
    }

    private static String toOpenSslHmacAlgo(String str) {
        return str;
    }

    static void clearCache() {
        j2o.clear();
        o2j.clear();
    }

    static boolean isJ2OCached(String str, String str2) {
        return str2.equals(j2o.get(str));
    }

    static boolean isO2JCached(String str, String str2, String str3) {
        Map<String, String> map = o2j.get(str);
        if (map == null) {
            return false;
        }
        return str3.equals(map.get(str2));
    }

    static String toOpenSsl(Iterable<String> iterable) {
        String next;
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            String openSsl = toOpenSsl(next);
            if (openSsl != null) {
                next = openSsl;
            }
            sb.append(next);
            sb.append(NameUtil.COLON);
        }
        if (sb.length() <= 0) {
            return "";
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    static String toOpenSsl(String str) {
        String str2 = j2o.get(str);
        return str2 != null ? str2 : cacheFromJava(str);
    }

    private static String cacheFromJava(String str) {
        String openSslUncached = toOpenSslUncached(str);
        if (openSslUncached == null) {
            return null;
        }
        j2o.putIfAbsent(str, openSslUncached);
        String substring = str.substring(4);
        HashMap hashMap = new HashMap(4);
        hashMap.put("", substring);
        hashMap.put("SSL", "SSL_" + substring);
        hashMap.put(IMAPSClient.DEFAULT_PROTOCOL, "TLS_" + substring);
        o2j.put(openSslUncached, hashMap);
        logger.debug("Cipher suite mapping: {} => {}", str, openSslUncached);
        return openSslUncached;
    }

    static String toOpenSslUncached(String str) {
        Matcher matcher = JAVA_CIPHERSUITE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String openSslHandshakeAlgo = toOpenSslHandshakeAlgo(matcher.group(1));
        String openSslBulkCipher = toOpenSslBulkCipher(matcher.group(2));
        String openSslHmacAlgo = toOpenSslHmacAlgo(matcher.group(3));
        if (openSslHandshakeAlgo.isEmpty()) {
            return openSslBulkCipher + NameUtil.HYPHEN + openSslHmacAlgo;
        }
        if (openSslBulkCipher.contains("CHACHA20")) {
            return openSslHandshakeAlgo + NameUtil.HYPHEN + openSslBulkCipher;
        }
        return openSslHandshakeAlgo + NameUtil.HYPHEN + openSslBulkCipher + NameUtil.HYPHEN + openSslHmacAlgo;
    }

    private static String toOpenSslHandshakeAlgo(String str) {
        boolean endsWith = str.endsWith("_EXPORT");
        if (endsWith) {
            str = str.substring(0, str.length() - 7);
        }
        if ("RSA".equals(str)) {
            str = "";
        } else if (str.endsWith("_anon")) {
            str = 'A' + str.substring(0, str.length() - 5);
        }
        if (endsWith) {
            str = str.isEmpty() ? "EXP" : "EXP-" + str;
        }
        return str.replace(NameUtil.USCORE, NameUtil.HYPHEN);
    }

    private static String toOpenSslBulkCipher(String str) {
        if (str.startsWith("AES_")) {
            Matcher matcher = JAVA_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1$2");
            }
            Matcher matcher2 = JAVA_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1$2-$3");
            }
        }
        return "3DES_EDE_CBC".equals(str) ? "DES-CBC3" : ("RC4_128".equals(str) || "RC4_40".equals(str)) ? "RC4" : ("DES40_CBC".equals(str) || "DES_CBC_40".equals(str)) ? "DES-CBC" : "RC2_CBC_40".equals(str) ? "RC2-CBC" : str.replace(NameUtil.USCORE, NameUtil.HYPHEN);
    }

    static String toJava(String str, String str2) {
        Map<String, String> map = o2j.get(str);
        if (map == null && (map = cacheFromOpenSsl(str)) == null) {
            return null;
        }
        String str3 = map.get(str2);
        return str3 == null ? str2 + NameUtil.USCORE + map.get("") : str3;
    }

    private static Map<String, String> cacheFromOpenSsl(String str) {
        String javaUncached = toJavaUncached(str);
        if (javaUncached == null) {
            return null;
        }
        String str2 = "SSL_" + javaUncached;
        String str3 = "TLS_" + javaUncached;
        HashMap hashMap = new HashMap(4);
        hashMap.put("", javaUncached);
        hashMap.put("SSL", str2);
        hashMap.put(IMAPSClient.DEFAULT_PROTOCOL, str3);
        o2j.putIfAbsent(str, hashMap);
        ConcurrentMap<String, String> concurrentMap = j2o;
        concurrentMap.putIfAbsent(str3, str);
        concurrentMap.putIfAbsent(str2, str);
        InternalLogger internalLogger = logger;
        internalLogger.debug("Cipher suite mapping: {} => {}", str3, str);
        internalLogger.debug("Cipher suite mapping: {} => {}", str2, str);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String toJavaUncached(java.lang.String r5) {
        /*
            java.util.regex.Pattern r0 = io.netty.handler.ssl.CipherSuiteConverter.OPENSSL_CIPHERSUITE_PATTERN
            java.util.regex.Matcher r5 = r0.matcher(r5)
            boolean r0 = r5.matches()
            if (r0 != 0) goto Le
            r5 = 0
            return r5
        Le:
            r0 = 1
            java.lang.String r1 = r5.group(r0)
            r2 = 0
            java.lang.String r3 = ""
            if (r1 != 0) goto L1b
            r0 = r2
        L19:
            r1 = r3
            goto L33
        L1b:
            java.lang.String r4 = "EXP-"
            boolean r4 = r1.startsWith(r4)
            if (r4 == 0) goto L29
            r2 = 4
            java.lang.String r1 = r1.substring(r2)
            goto L33
        L29:
            java.lang.String r4 = "EXP"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L32
            goto L19
        L32:
            r0 = r2
        L33:
            java.lang.String r1 = toJavaHandshakeAlgo(r1, r0)
            r2 = 2
            java.lang.String r2 = r5.group(r2)
            java.lang.String r0 = toJavaBulkCipher(r2, r0)
            r2 = 3
            java.lang.String r5 = r5.group(r2)
            java.lang.String r5 = toJavaHmacAlgo(r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = "_WITH_"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            r2 = 95
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "CHACHA20"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L85
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = "_SHA256"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
        L85:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.CipherSuiteConverter.toJavaUncached(java.lang.String):java.lang.String");
    }

    private static String toJavaHandshakeAlgo(String str, boolean z) {
        if (str.isEmpty()) {
            str = "RSA";
        } else if ("ADH".equals(str)) {
            str = "DH_anon";
        } else if ("AECDH".equals(str)) {
            str = "ECDH_anon";
        }
        String replace = str.replace(NameUtil.HYPHEN, NameUtil.USCORE);
        return z ? replace + "_EXPORT" : replace;
    }

    private static String toJavaBulkCipher(String str, boolean z) {
        if (str.startsWith("AES")) {
            Matcher matcher = OPENSSL_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1_$2_CBC");
            }
            Matcher matcher2 = OPENSSL_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1_$2_$3");
            }
        }
        if ("DES-CBC3".equals(str)) {
            return "3DES_EDE_CBC";
        }
        if ("RC4".equals(str)) {
            return z ? "RC4_40" : "RC4_128";
        }
        if ("DES-CBC".equals(str)) {
            return z ? "DES_CBC_40" : "DES_CBC";
        }
        if ("RC2-CBC".equals(str)) {
            return z ? "RC2_CBC_40" : "RC2_CBC";
        }
        return str.replace(NameUtil.HYPHEN, NameUtil.USCORE);
    }

    private CipherSuiteConverter() {
    }
}
