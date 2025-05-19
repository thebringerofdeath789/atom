package org.apache.commons.net.ftp.parser;

import java.util.regex.Pattern;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFileEntryParser;

/* loaded from: classes4.dex */
public class DefaultFTPFileEntryParserFactory implements FTPFileEntryParserFactory {
    private static final String JAVA_IDENTIFIER = "\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
    private static final String JAVA_QUALIFIED_NAME = "(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
    private static final Pattern JAVA_QUALIFIED_NAME_PATTERN = Pattern.compile(JAVA_QUALIFIED_NAME);

    @Override // org.apache.commons.net.ftp.parser.FTPFileEntryParserFactory
    public FTPFileEntryParser createFileEntryParser(String str) {
        if (str == null) {
            throw new ParserInitializationException("Parser key cannot be null");
        }
        return createFileEntryParser(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.net.ftp.FTPFileEntryParser createFileEntryParser(java.lang.String r5, org.apache.commons.net.ftp.FTPClientConfig r6) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory.createFileEntryParser(java.lang.String, org.apache.commons.net.ftp.FTPClientConfig):org.apache.commons.net.ftp.FTPFileEntryParser");
    }

    @Override // org.apache.commons.net.ftp.parser.FTPFileEntryParserFactory
    public FTPFileEntryParser createFileEntryParser(FTPClientConfig fTPClientConfig) throws ParserInitializationException {
        return createFileEntryParser(fTPClientConfig.getServerSystemKey(), fTPClientConfig);
    }

    public FTPFileEntryParser createUnixFTPEntryParser() {
        return new UnixFTPEntryParser();
    }

    public FTPFileEntryParser createVMSVersioningFTPEntryParser() {
        return new VMSVersioningFTPEntryParser();
    }

    public FTPFileEntryParser createNetwareFTPEntryParser() {
        return new NetwareFTPEntryParser();
    }

    public FTPFileEntryParser createNTFTPEntryParser() {
        return createNTFTPEntryParser(null);
    }

    private FTPFileEntryParser createNTFTPEntryParser(FTPClientConfig fTPClientConfig) {
        if (fTPClientConfig != null && FTPClientConfig.SYST_NT.equals(fTPClientConfig.getServerSystemKey())) {
            return new NTFTPEntryParser(fTPClientConfig);
        }
        FTPClientConfig fTPClientConfig2 = fTPClientConfig != null ? new FTPClientConfig(fTPClientConfig) : null;
        FTPFileEntryParser[] fTPFileEntryParserArr = new FTPFileEntryParser[2];
        NTFTPEntryParser nTFTPEntryParser = new NTFTPEntryParser(fTPClientConfig);
        boolean z = false;
        fTPFileEntryParserArr[0] = nTFTPEntryParser;
        if (fTPClientConfig2 != null && FTPClientConfig.SYST_UNIX_TRIM_LEADING.equals(fTPClientConfig2.getServerSystemKey())) {
            z = true;
        }
        fTPFileEntryParserArr[1] = new UnixFTPEntryParser(fTPClientConfig2, z);
        return new CompositeFileEntryParser(fTPFileEntryParserArr);
    }

    public FTPFileEntryParser createOS2FTPEntryParser() {
        return new OS2FTPEntryParser();
    }

    public FTPFileEntryParser createOS400FTPEntryParser() {
        return createOS400FTPEntryParser(null);
    }

    private FTPFileEntryParser createOS400FTPEntryParser(FTPClientConfig fTPClientConfig) {
        if (fTPClientConfig != null && FTPClientConfig.SYST_OS400.equals(fTPClientConfig.getServerSystemKey())) {
            return new OS400FTPEntryParser(fTPClientConfig);
        }
        FTPClientConfig fTPClientConfig2 = fTPClientConfig != null ? new FTPClientConfig(fTPClientConfig) : null;
        FTPFileEntryParser[] fTPFileEntryParserArr = new FTPFileEntryParser[2];
        OS400FTPEntryParser oS400FTPEntryParser = new OS400FTPEntryParser(fTPClientConfig);
        boolean z = false;
        fTPFileEntryParserArr[0] = oS400FTPEntryParser;
        if (fTPClientConfig2 != null && FTPClientConfig.SYST_UNIX_TRIM_LEADING.equals(fTPClientConfig2.getServerSystemKey())) {
            z = true;
        }
        fTPFileEntryParserArr[1] = new UnixFTPEntryParser(fTPClientConfig2, z);
        return new CompositeFileEntryParser(fTPFileEntryParserArr);
    }

    public FTPFileEntryParser createMVSEntryParser() {
        return new MVSFTPEntryParser();
    }
}
