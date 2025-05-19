package org.apache.commons.net.ftp.parser;

import java.io.File;
import java.text.ParseException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;

/* loaded from: classes4.dex */
public class OS400FTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    private static final String DEFAULT_DATE_FORMAT = "yy/MM/dd HH:mm:ss";
    private static final String REGEX = "(\\S+)\\s+(?:(\\d+)\\s+)?(?:(\\S+)\\s+(\\S+)\\s+)?(\\*STMF|\\*DIR|\\*FILE|\\*MEM)\\s+(?:(\\S+)\\s*)?";

    public OS400FTPEntryParser() {
        this(null);
    }

    public OS400FTPEntryParser(FTPClientConfig fTPClientConfig) {
        super(REGEX);
        configure(fTPClientConfig);
    }

    @Override // org.apache.commons.net.ftp.FTPFileEntryParser
    public FTPFile parseFTPEntry(String str) {
        int i;
        int lastIndexOf;
        FTPFile fTPFile = new FTPFile();
        fTPFile.setRawListing(str);
        if (!matches(str)) {
            return null;
        }
        String group = group(1);
        String group2 = group(2);
        int i2 = 3;
        String str2 = (isNullOrEmpty(group(3)) && isNullOrEmpty(group(4))) ? "" : group(3) + StringUtils.SPACE + group(4);
        String group3 = group(5);
        String group4 = group(6);
        try {
            fTPFile.setTimestamp(super.parseTimestamp(str2));
        } catch (ParseException unused) {
        }
        if (group3.equalsIgnoreCase("*STMF")) {
            if (isNullOrEmpty(group2) || isNullOrEmpty(group4)) {
                return null;
            }
            i = 1;
            i2 = 0;
        } else {
            if (group3.equalsIgnoreCase("*DIR")) {
                if (isNullOrEmpty(group2) || isNullOrEmpty(group4)) {
                    return null;
                }
                i = 1;
            } else {
                if (group3.equalsIgnoreCase("*FILE")) {
                    if (group4 == null || !group4.toUpperCase().endsWith(".SAVF")) {
                        return null;
                    }
                } else if (!group3.equalsIgnoreCase("*MEM")) {
                    i = 1;
                } else {
                    if (isNullOrEmpty(group4) || !isNullOrEmpty(group2) || !isNullOrEmpty(str2)) {
                        return null;
                    }
                    group4 = group4.replace('/', File.separatorChar);
                }
                i = 0;
            }
            i2 = i;
        }
        fTPFile.setType(i2);
        fTPFile.setUser(group);
        try {
            fTPFile.setSize(Long.parseLong(group2));
        } catch (NumberFormatException unused2) {
        }
        if (group4.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            group4 = group4.substring(0, group4.length() - 1);
        }
        if (i != 0 && (lastIndexOf = group4.lastIndexOf(47)) > -1) {
            group4 = group4.substring(lastIndexOf + 1);
        }
        fTPFile.setName(group4);
        return fTPFile;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    @Override // org.apache.commons.net.ftp.parser.ConfigurableFTPFileEntryParserImpl
    protected FTPClientConfig getDefaultConfiguration() {
        return new FTPClientConfig(FTPClientConfig.SYST_OS400, DEFAULT_DATE_FORMAT, null);
    }
}
