package io.netty.handler.ssl.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public final class SelfSignedCertificate {
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private final File privateKey;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelfSignedCertificate.class);
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));

    public SelfSignedCertificate() throws CertificateException {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER);
    }

    public SelfSignedCertificate(Date date, Date date2) throws CertificateException {
        this("example.com", date, date2);
    }

    public SelfSignedCertificate(String str) throws CertificateException {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER);
    }

    public SelfSignedCertificate(String str, Date date, Date date2) throws CertificateException {
        this(str, ThreadLocalInsecureRandom.current(), 1024, date, date2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i) throws CertificateException {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SelfSignedCertificate(java.lang.String r5, java.security.SecureRandom r6, int r7, java.util.Date r8, java.util.Date r9) throws java.security.cert.CertificateException {
        /*
            r4 = this;
            java.lang.String r0 = "Failed to close a file: "
            r4.<init>()
            java.lang.String r1 = "RSA"
            java.security.KeyPairGenerator r1 = java.security.KeyPairGenerator.getInstance(r1)     // Catch: java.security.NoSuchAlgorithmException -> Laf
            r1.initialize(r7, r6)     // Catch: java.security.NoSuchAlgorithmException -> Laf
            java.security.KeyPair r7 = r1.generateKeyPair()     // Catch: java.security.NoSuchAlgorithmException -> Laf
            java.lang.String[] r5 = io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.generate(r5, r7, r6, r8, r9)     // Catch: java.lang.Throwable -> L17
            goto L23
        L17:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = io.netty.handler.ssl.util.SelfSignedCertificate.logger
            java.lang.String r3 = "Failed to generate a self-signed X.509 certificate using sun.security.x509:"
            r2.debug(r3, r1)
            java.lang.String[] r5 = io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator.generate(r5, r7, r6, r8, r9)     // Catch: java.lang.Throwable -> L9f
        L23:
            java.io.File r6 = new java.io.File
            r8 = 0
            r8 = r5[r8]
            r6.<init>(r8)
            r4.certificate = r6
            java.io.File r8 = new java.io.File
            r9 = 1
            r5 = r5[r9]
            r8.<init>(r5)
            r4.privateKey = r8
            java.security.PrivateKey r5 = r7.getPrivate()
            r4.key = r5
            r5 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L75
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L75
            java.lang.String r5 = "X509"
            java.security.cert.CertificateFactory r5 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.security.cert.Certificate r5 = r5.generateCertificate(r7)     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            r4.cert = r5     // Catch: java.lang.Exception -> L6f java.lang.Throwable -> L7e
            r7.close()     // Catch: java.io.IOException -> L55
            goto L6e
        L55:
            r5 = move-exception
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.handler.ssl.util.SelfSignedCertificate.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append(r0)
            java.io.File r8 = r4.certificate
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.warn(r7, r5)
        L6e:
            return
        L6f:
            r5 = move-exception
            goto L78
        L71:
            r6 = move-exception
            r7 = r5
            r5 = r6
            goto L7f
        L75:
            r6 = move-exception
            r7 = r5
            r5 = r6
        L78:
            java.security.cert.CertificateEncodingException r6 = new java.security.cert.CertificateEncodingException     // Catch: java.lang.Throwable -> L7e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L7e
            throw r6     // Catch: java.lang.Throwable -> L7e
        L7e:
            r5 = move-exception
        L7f:
            if (r7 == 0) goto L9e
            r7.close()     // Catch: java.io.IOException -> L85
            goto L9e
        L85:
            r6 = move-exception
            io.netty.util.internal.logging.InternalLogger r7 = io.netty.handler.ssl.util.SelfSignedCertificate.logger
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r8 = r8.append(r0)
            java.io.File r9 = r4.certificate
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.warn(r8, r6)
        L9e:
            throw r5
        L9f:
            r5 = move-exception
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.handler.ssl.util.SelfSignedCertificate.logger
            java.lang.String r7 = "Failed to generate a self-signed X.509 certificate using Bouncy Castle:"
            r6.debug(r7, r5)
            java.security.cert.CertificateException r6 = new java.security.cert.CertificateException
            java.lang.String r7 = "No provider succeeded to generate a self-signed certificate. See debug log for the root cause."
            r6.<init>(r7, r5)
            throw r6
        Laf:
            r5 = move-exception
            java.lang.Error r6 = new java.lang.Error
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.util.SelfSignedCertificate.<init>(java.lang.String, java.security.SecureRandom, int, java.util.Date, java.util.Date):void");
    }

    public File certificate() {
        return this.certificate;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public PrivateKey key() {
        return this.key;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    static String[] newSelfSignedCertificate(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws IOException, CertificateEncodingException {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(privateKey.getEncoded());
        try {
            try {
                String str2 = "-----BEGIN PRIVATE KEY-----\n" + Base64.encode(wrappedBuffer, true).toString(CharsetUtil.US_ASCII) + "\n-----END PRIVATE KEY-----\n";
                wrappedBuffer.release();
                File createTempFile = File.createTempFile("keyutil_" + str + NameUtil.USCORE, ".key");
                createTempFile.deleteOnExit();
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                try {
                    fileOutputStream.write(str2.getBytes(CharsetUtil.US_ASCII));
                    fileOutputStream.close();
                    wrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
                    try {
                        try {
                            String str3 = "-----BEGIN CERTIFICATE-----\n" + Base64.encode(wrappedBuffer, true).toString(CharsetUtil.US_ASCII) + "\n-----END CERTIFICATE-----\n";
                            wrappedBuffer.release();
                            File createTempFile2 = File.createTempFile("keyutil_" + str + NameUtil.USCORE, ".crt");
                            createTempFile2.deleteOnExit();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile2);
                            try {
                                fileOutputStream2.write(str3.getBytes(CharsetUtil.US_ASCII));
                                fileOutputStream2.close();
                                return new String[]{createTempFile2.getPath(), createTempFile.getPath()};
                            } catch (Throwable th) {
                                safeClose(createTempFile2, fileOutputStream2);
                                safeDelete(createTempFile2);
                                safeDelete(createTempFile);
                                throw th;
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    safeClose(createTempFile, fileOutputStream);
                    safeDelete(createTempFile);
                    throw th2;
                }
            } finally {
            }
        } finally {
        }
    }

    private static void safeDelete(File file) {
        if (file.delete()) {
            return;
        }
        logger.warn("Failed to delete a file: " + file);
    }

    private static void safeClose(File file, OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            logger.warn("Failed to close a file: " + file, (Throwable) e);
        }
    }
}
