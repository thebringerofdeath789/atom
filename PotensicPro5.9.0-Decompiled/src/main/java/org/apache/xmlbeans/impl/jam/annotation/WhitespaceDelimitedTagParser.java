package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.Tag;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;

/* loaded from: classes5.dex */
public class WhitespaceDelimitedTagParser extends JavadocTagParser {
    private boolean isBlank(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }

    @Override // org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser
    public void parse(MAnnotatedElement mAnnotatedElement, Tag tag) {
        MAnnotation[] createAnnotations = createAnnotations(mAnnotatedElement, tag);
        String text = tag.text();
        if (text == null) {
            return;
        }
        String trim = text.trim();
        if (trim.length() == 0) {
            return;
        }
        Properties properties = new Properties();
        parseAssignments(properties, trim);
        if (properties.size() > 0) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                setValue(createAnnotations, str, properties.getProperty(str));
            }
            return;
        }
        setSingleValueText(createAnnotations, tag);
    }

    private void parseAssignments(Properties properties, String str) {
        int i;
        getLogger().verbose(new StringBuffer().append("PARSING LINE ").append(str).toString(), this);
        String removeComments = removeComments(str);
        while (removeComments != null && -1 != removeComments.indexOf("=")) {
            int i2 = 0;
            char charAt = removeComments.charAt(0);
            while (isBlank(charAt)) {
                i2++;
                charAt = removeComments.charAt(i2);
            }
            int i3 = i2;
            while (isLegal(removeComments.charAt(i3))) {
                i3++;
            }
            String substring = removeComments.substring(i2, i3);
            int indexOf = removeComments.indexOf("=");
            if (indexOf == -1) {
                return;
            }
            int i4 = indexOf + 1;
            try {
                charAt = removeComments.charAt(i4);
            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            while (isBlank(charAt)) {
                i4++;
                charAt = removeComments.charAt(i4);
            }
            if (charAt == '\"') {
                i4++;
                i = i4;
                while ('\"' != removeComments.charAt(i)) {
                    i++;
                    if (i >= removeComments.length()) {
                        getLogger().verbose(new StringBuffer().append("missing double quotes on line ").append(removeComments).toString(), this);
                    }
                }
            } else {
                i = i4 + 1;
                while (i < removeComments.length() && isLegal(removeComments.charAt(i))) {
                    i++;
                }
            }
            String substring2 = removeComments.substring(i4, i);
            removeComments = i < removeComments.length() ? removeComments.substring(i + 1) : null;
            getLogger().verbose(new StringBuffer().append("SETTING KEY:").append(substring).append(" VALUE:").append(substring2).toString(), this);
            properties.setProperty(substring, substring2);
        }
    }

    private String removeComments(String str) {
        int length = str.length();
        int indexOf = str.indexOf("//");
        int indexOf2 = str.indexOf("\"");
        if (-1 == indexOf2 || indexOf2 >= indexOf) {
            String str2 = "";
            int i = 0;
            String str3 = str;
            while (i < length && indexOf != -1) {
                indexOf = str.indexOf("//", i);
                if (-1 != indexOf) {
                    if (indexOf <= 0 || str.charAt(indexOf - 1) != ':') {
                        int indexOf3 = str.indexOf(10, indexOf);
                        if (-1 == indexOf3) {
                            indexOf3 = length;
                        }
                        str2 = new StringBuffer().append(str2).append(str.substring(i, indexOf).trim()).append("\n").toString();
                        int i2 = indexOf3;
                        str3 = str.substring(indexOf3);
                        i = i2;
                    } else {
                        i = indexOf + 2;
                    }
                }
            }
            str = new StringBuffer().append(str2).append(str3).toString();
        }
        return str.trim();
    }

    private boolean isLegal(char c) {
        return (isBlank(c) || c == '=') ? false : true;
    }
}
