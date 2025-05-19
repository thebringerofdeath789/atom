package org.apache.commons.text.lookup;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class PropertiesStringLookup extends AbstractStringLookup {
    static final PropertiesStringLookup INSTANCE = new PropertiesStringLookup();
    static final String SEPARATOR = "::";

    static String toPropertyKey(String str, String str2) {
        return AbstractStringLookup.toLookupKey(str, SEPARATOR, str2);
    }

    private PropertiesStringLookup() {
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(SEPARATOR);
        if (split.length < 2) {
            throw IllegalArgumentExceptions.format("Bad properties key format [%s]; expected format is %s.", str, toPropertyKey("DocumentPath", "Key"));
        }
        String str2 = split[0];
        String substringAfter = StringUtils.substringAfter(str, SEPARATOR);
        try {
            Properties properties = new Properties();
            InputStream newInputStream = Files.newInputStream(Paths.get(str2, new String[0]), new OpenOption[0]);
            try {
                properties.load(newInputStream);
                if (newInputStream != null) {
                    newInputStream.close();
                }
                return properties.getProperty(substringAfter);
            } finally {
            }
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up properties [%s] and key [%s].", str2, substringAfter);
        }
    }
}
