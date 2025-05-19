package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.Tag;
import java.io.StringWriter;
import java.util.StringTokenizer;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;

/* loaded from: classes5.dex */
public class LineDelimitedTagParser extends JavadocTagParser {
    private static final String LINE_DELIMS = "\n\f\r";
    private static final String VALUE_QUOTE = "\"";

    @Override // org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser
    public void parse(MAnnotatedElement mAnnotatedElement, Tag tag) {
        if (mAnnotatedElement == null) {
            throw new IllegalArgumentException("null tagText");
        }
        if (tag == null) {
            throw new IllegalArgumentException("null tagName");
        }
        MAnnotation[] createAnnotations = createAnnotations(mAnnotatedElement, tag);
        StringTokenizer stringTokenizer = new StringTokenizer(tag.text(), LINE_DELIMS);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf > 0) {
                String trim = nextToken.substring(0, indexOf).trim();
                if (indexOf < nextToken.length() - 1) {
                    String trim2 = nextToken.substring(indexOf + 1).trim();
                    if (trim2.startsWith(VALUE_QUOTE)) {
                        trim2 = parseQuotedValue(trim2.substring(1), stringTokenizer);
                    }
                    setValue(createAnnotations, trim, trim2);
                }
            }
        }
    }

    private String parseQuotedValue(String str, StringTokenizer stringTokenizer) {
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int indexOf = str.indexOf(VALUE_QUOTE);
            if (indexOf == -1) {
                stringWriter.write(str);
                if (!stringTokenizer.hasMoreTokens()) {
                    return stringWriter.toString();
                }
                stringWriter.write(10);
                str = stringTokenizer.nextToken().trim();
            } else {
                stringWriter.write(str.substring(0, indexOf).trim());
                return stringWriter.toString();
            }
        }
    }
}
