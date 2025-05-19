package org.apache.commons.text.lookup;

import java.io.PrintStream;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class JavaPlatformStringLookup extends AbstractStringLookup {
    static final JavaPlatformStringLookup INSTANCE = new JavaPlatformStringLookup();
    private static final String KEY_HARDWARE = "hardware";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_OS = "os";
    private static final String KEY_RUNTIME = "runtime";
    private static final String KEY_VERSION = "version";
    private static final String KEY_VM = "vm";

    public static void main(String[] strArr) {
        System.out.println(JavaPlatformStringLookup.class);
        PrintStream printStream = System.out;
        JavaPlatformStringLookup javaPlatformStringLookup = INSTANCE;
        printStream.printf("%s = %s%n", "version", javaPlatformStringLookup.lookup("version"));
        System.out.printf("%s = %s%n", KEY_RUNTIME, javaPlatformStringLookup.lookup(KEY_RUNTIME));
        System.out.printf("%s = %s%n", KEY_VM, javaPlatformStringLookup.lookup(KEY_VM));
        System.out.printf("%s = %s%n", KEY_OS, javaPlatformStringLookup.lookup(KEY_OS));
        System.out.printf("%s = %s%n", KEY_HARDWARE, javaPlatformStringLookup.lookup(KEY_HARDWARE));
        System.out.printf("%s = %s%n", KEY_LOCALE, javaPlatformStringLookup.lookup(KEY_LOCALE));
    }

    private JavaPlatformStringLookup() {
    }

    String getHardware() {
        return "processors: " + Runtime.getRuntime().availableProcessors() + ", architecture: " + getSystemProperty("os.arch") + getSystemProperty("-", "sun.arch.data.model") + getSystemProperty(", instruction sets: ", "sun.cpu.isalist");
    }

    String getLocale() {
        return "default locale: " + Locale.getDefault() + ", platform encoding: " + getSystemProperty("file.encoding");
    }

    String getOperatingSystem() {
        return getSystemProperty("os.name") + StringUtils.SPACE + getSystemProperty("os.version") + getSystemProperty(StringUtils.SPACE, "sun.os.patch.level") + ", architecture: " + getSystemProperty("os.arch") + getSystemProperty("-", "sun.arch.data.model");
    }

    String getRuntime() {
        return getSystemProperty("java.runtime.name") + " (build " + getSystemProperty("java.runtime.version") + ") from " + getSystemProperty("java.vendor");
    }

    private String getSystemProperty(String str) {
        return StringLookupFactory.INSTANCE_SYSTEM_PROPERTIES.lookup(str);
    }

    private String getSystemProperty(String str, String str2) {
        String systemProperty = getSystemProperty(str2);
        return StringUtils.isEmpty(systemProperty) ? "" : str + systemProperty;
    }

    String getVirtualMachine() {
        return getSystemProperty("java.vm.name") + " (build " + getSystemProperty("java.vm.version") + ", " + getSystemProperty("java.vm.info") + ")";
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "locale":
                return getLocale();
            case "os":
                return getOperatingSystem();
            case "vm":
                return getVirtualMachine();
            case "hardware":
                return getHardware();
            case "version":
                return "Java version " + getSystemProperty("java.version");
            case "runtime":
                return getRuntime();
            default:
                throw new IllegalArgumentException(str);
        }
    }
}
