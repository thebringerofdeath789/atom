package org.apache.poi.openxml4j.opc.internal;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/* loaded from: classes5.dex */
public final class ContentType {
    private static final Pattern patternParams;
    private static final Pattern patternTypeSubType = Pattern.compile("^([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)$");
    private static final Pattern patternTypeSubTypeParams;
    private Hashtable<String, String> parameters;
    private String subType;
    private String type;

    static {
        String str = "([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+\"?)";
        patternTypeSubTypeParams = Pattern.compile("^([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)(;" + str + ")*$");
        patternParams = Pattern.compile(";" + str);
    }

    public ContentType(String str) throws InvalidFormatException {
        Matcher matcher = patternTypeSubType.matcher(str);
        matcher = matcher.matches() ? matcher : patternTypeSubTypeParams.matcher(str);
        if (!matcher.matches()) {
            throw new InvalidFormatException("The specified content type '" + str + "' is not compliant with RFC 2616: malformed content type.");
        }
        if (matcher.groupCount() >= 2) {
            this.type = matcher.group(1);
            this.subType = matcher.group(2);
            this.parameters = new Hashtable<>(1);
            if (matcher.groupCount() >= 5) {
                Matcher matcher2 = patternParams.matcher(str.substring(matcher.end(2)));
                while (matcher2.find()) {
                    this.parameters.put(matcher2.group(1), matcher2.group(2));
                }
            }
        }
    }

    public final String toString() {
        return toString(true);
    }

    public final String toString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getType());
        stringBuffer.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
        stringBuffer.append(getSubType());
        if (z) {
            for (String str : this.parameters.keySet()) {
                stringBuffer.append(";");
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(this.parameters.get(str));
            }
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof ContentType) || toString().equalsIgnoreCase(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public boolean hasParameters() {
        Hashtable<String, String> hashtable = this.parameters;
        return (hashtable == null || hashtable.isEmpty()) ? false : true;
    }

    public String[] getParameterKeys() {
        Hashtable<String, String> hashtable = this.parameters;
        return hashtable == null ? new String[0] : (String[]) hashtable.keySet().toArray(new String[this.parameters.size()]);
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public String getParameters(String str) {
        return getParameter(str);
    }
}
