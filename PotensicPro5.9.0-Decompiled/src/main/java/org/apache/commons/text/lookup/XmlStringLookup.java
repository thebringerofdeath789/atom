package org.apache.commons.text.lookup;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.InputSource;

/* loaded from: classes4.dex */
final class XmlStringLookup extends AbstractStringLookup {
    static final XmlStringLookup INSTANCE = new XmlStringLookup();

    private XmlStringLookup() {
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(SPLIT_STR);
        if (split.length != 2) {
            throw IllegalArgumentExceptions.format("Bad XML key format [%s]; expected format is DocumentPath:XPath.", str);
        }
        String str2 = split[0];
        String substringAfter = StringUtils.substringAfter(str, 58);
        try {
            InputStream newInputStream = Files.newInputStream(Paths.get(str2, new String[0]), new OpenOption[0]);
            try {
                String evaluate = XPathFactory.newInstance().newXPath().evaluate(substringAfter, new InputSource(newInputStream));
                if (newInputStream != null) {
                    newInputStream.close();
                }
                return evaluate;
            } finally {
            }
        } catch (Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up XML document [%s] and XPath [%s].", str2, substringAfter);
        }
    }
}
