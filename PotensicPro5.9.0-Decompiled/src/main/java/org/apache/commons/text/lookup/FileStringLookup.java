package org.apache.commons.text.lookup;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
final class FileStringLookup extends AbstractStringLookup {
    static final AbstractStringLookup INSTANCE = new FileStringLookup();

    private FileStringLookup() {
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(String.valueOf(NameUtil.COLON));
        if (split.length < 2) {
            throw IllegalArgumentExceptions.format("Bad file key format [%s], expected format is CharsetName:DocumentPath.", str);
        }
        String str2 = split[0];
        String substringAfter = StringUtils.substringAfter(str, 58);
        try {
            return new String(Files.readAllBytes(Paths.get(substringAfter, new String[0])), str2);
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up file [%s] with charset [%s].", substringAfter, str2);
        }
    }
}
