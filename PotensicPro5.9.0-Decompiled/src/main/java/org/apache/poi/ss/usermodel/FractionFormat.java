package org.apache.poi.ss.usermodel;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.format.SimpleFraction;
import org.apache.poi.ss.formula.eval.NotImplementedException;

/* loaded from: classes5.dex */
public class FractionFormat extends Format {
    private static final Pattern DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");
    private static final int MAX_DENOM_POW = 4;
    private final int exactDenom;
    private final int maxDenom;
    private final String wholePartFormatString;

    public FractionFormat(String str, String str2) {
        int i;
        this.wholePartFormatString = str;
        Matcher matcher = DENOM_FORMAT_PATTERN.matcher(str2);
        int i2 = -1;
        if (matcher.find()) {
            if (matcher.group(2) != null) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(2));
                    i2 = parseInt == 0 ? -1 : parseInt;
                    i = -1;
                } catch (NumberFormatException unused) {
                }
            } else if (matcher.group(1) != null) {
                i = (int) Math.pow(10.0d, matcher.group(1).length() > 4 ? 4 : r6);
            } else {
                i = -1;
                i2 = 100;
            }
            this.exactDenom = (i2 <= 0 || i > 0) ? i2 : 100;
            this.maxDenom = i;
        }
        i = -1;
        this.exactDenom = (i2 <= 0 || i > 0) ? i2 : 100;
        this.maxDenom = i;
    }

    public String format(Number number) {
        SimpleFraction buildFractionMaxDenominator;
        double doubleValue = number.doubleValue();
        boolean z = doubleValue < 0.0d;
        double abs = Math.abs(doubleValue);
        double floor = Math.floor(abs);
        double d = abs - floor;
        double d2 = floor + d;
        if (d2 == 0.0d || abs < 1 / Math.max(this.exactDenom, this.maxDenom)) {
            return SessionDescription.SUPPORTED_SDP_VERSION;
        }
        if (((int) d) + floor == d2) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("-");
            }
            sb.append(Integer.toString((int) floor));
            return sb.toString();
        }
        try {
            int i = this.exactDenom;
            if (i > 0) {
                buildFractionMaxDenominator = SimpleFraction.buildFractionExactDenominator(d, i);
            } else {
                buildFractionMaxDenominator = SimpleFraction.buildFractionMaxDenominator(d, this.maxDenom);
            }
            StringBuilder sb2 = new StringBuilder();
            if (z) {
                sb2.append("-");
            }
            if ("".equals(this.wholePartFormatString)) {
                sb2.append((buildFractionMaxDenominator.getDenominator() * ((int) floor)) + buildFractionMaxDenominator.getNumerator()).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(buildFractionMaxDenominator.getDenominator());
                return sb2.toString();
            }
            if (buildFractionMaxDenominator.getNumerator() == 0) {
                sb2.append(Integer.toString((int) floor));
                return sb2.toString();
            }
            if (buildFractionMaxDenominator.getNumerator() == buildFractionMaxDenominator.getDenominator()) {
                sb2.append(Integer.toString(((int) floor) + 1));
                return sb2.toString();
            }
            if (floor > 0.0d) {
                sb2.append(Integer.toString((int) floor)).append(StringUtils.SPACE);
            }
            sb2.append(buildFractionMaxDenominator.getNumerator()).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(buildFractionMaxDenominator.getDenominator());
            return sb2.toString();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Double.toString(doubleValue);
        }
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(format((Number) obj));
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new NotImplementedException("Reverse parsing not supported");
    }
}
