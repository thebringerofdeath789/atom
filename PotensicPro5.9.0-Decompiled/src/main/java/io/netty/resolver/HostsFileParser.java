package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes4.dex */
public final class HostsFileParser {
    private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
    private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
    private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
    private static final Pattern WHITESPACES = Pattern.compile("[ \t]+");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HostsFileParser.class);

    private static File locateHostsFile() {
        if (PlatformDependent.isWindows()) {
            File file = new File(System.getenv("SystemRoot") + WINDOWS_HOSTS_FILE_RELATIVE_PATH);
            return !file.exists() ? new File("C:\\Windows\\system32\\drivers\\etc\\hosts") : file;
        }
        return new File(X_PLATFORMS_HOSTS_FILE_PATH);
    }

    public static HostsFileEntries parseSilently() {
        File locateHostsFile = locateHostsFile();
        try {
            return parse(locateHostsFile);
        } catch (IOException e) {
            logger.warn("Failed to load and parse hosts file at " + locateHostsFile.getPath(), (Throwable) e);
            return HostsFileEntries.EMPTY;
        }
    }

    public static HostsFileEntries parse() throws IOException {
        return parse(locateHostsFile());
    }

    public static HostsFileEntries parse(File file) throws IOException {
        ObjectUtil.checkNotNull(file, StringLookupFactory.KEY_FILE);
        if (file.exists() && file.isFile()) {
            return parse(new BufferedReader(new FileReader(file)));
        }
        return HostsFileEntries.EMPTY;
    }

    public static HostsFileEntries parse(Reader reader) throws IOException {
        byte[] createByteArrayFromIpAddressString;
        ObjectUtil.checkNotNull(reader, "reader");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf(35);
                if (indexOf != -1) {
                    readLine = readLine.substring(0, indexOf);
                }
                String trim = readLine.trim();
                if (!trim.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : WHITESPACES.split(trim)) {
                        if (!str.isEmpty()) {
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() >= 2 && (createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString((String) arrayList.get(0))) != null) {
                        for (int i = 1; i < arrayList.size(); i++) {
                            String str2 = (String) arrayList.get(i);
                            String lowerCase = str2.toLowerCase(Locale.ENGLISH);
                            InetAddress byAddress = InetAddress.getByAddress(str2, createByteArrayFromIpAddressString);
                            if (byAddress instanceof Inet4Address) {
                                Inet4Address inet4Address = (Inet4Address) hashMap.put(lowerCase, (Inet4Address) byAddress);
                                if (inet4Address != null) {
                                    hashMap.put(lowerCase, inet4Address);
                                }
                            } else {
                                Inet6Address inet6Address = (Inet6Address) hashMap2.put(lowerCase, (Inet6Address) byAddress);
                                if (inet6Address != null) {
                                    hashMap2.put(lowerCase, inet6Address);
                                }
                            }
                        }
                    }
                }
            }
            return (hashMap.isEmpty() && hashMap2.isEmpty()) ? HostsFileEntries.EMPTY : new HostsFileEntries(hashMap, hashMap2);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                logger.warn("Failed to close a reader", (Throwable) e);
            }
        }
    }

    private HostsFileParser() {
    }
}
