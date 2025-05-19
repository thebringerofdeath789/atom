package org.apache.commons.text.lookup;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes4.dex */
final class ResourceBundleStringLookup extends AbstractStringLookup {
    static final ResourceBundleStringLookup INSTANCE = new ResourceBundleStringLookup();
    private final String bundleName;

    ResourceBundleStringLookup() {
        this(null);
    }

    ResourceBundleStringLookup(String str) {
        this.bundleName = str;
    }

    ResourceBundle getBundle(String str) {
        return ResourceBundle.getBundle(str);
    }

    String getString(String str, String str2) {
        return getBundle(str).getString(str2);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(SPLIT_STR);
        int length = split.length;
        String str2 = this.bundleName;
        boolean z = str2 == null;
        if (z && length != 2) {
            throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is BundleName:KeyName.", str);
        }
        if (str2 != null && length != 1) {
            throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is KeyName.", str);
        }
        if (z) {
            str2 = split[0];
        }
        String str3 = z ? split[1] : split[0];
        try {
            return getString(str2, str3);
        } catch (MissingResourceException unused) {
            return null;
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up resource bundle [%s] and key [%s].", str2, str3);
        }
    }

    public String toString() {
        return super.toString() + " [bundleName=" + this.bundleName + "]";
    }
}
