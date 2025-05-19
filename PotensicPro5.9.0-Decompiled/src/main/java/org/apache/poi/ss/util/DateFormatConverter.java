package org.apache.poi.ss.util;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.android.accounts.v1.MapboxAccounts;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class DateFormatConverter {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) DateFormatConverter.class);
    private static Map<String, String> tokenConversions = prepareTokenConversions();
    private static Map<String, String> localePrefixes = prepareLocalePrefixes();

    public static class DateFormatTokenizer {
        String format;
        int pos;

        public DateFormatTokenizer(String str) {
            this.format = str;
        }

        public String getNextToken() {
            if (this.pos >= this.format.length()) {
                return null;
            }
            int i = this.pos;
            char charAt = this.format.charAt(i);
            this.pos++;
            if (charAt == '\'') {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) != '\'') {
                    this.pos++;
                }
                if (this.pos < this.format.length()) {
                    this.pos++;
                }
            } else {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) == charAt) {
                    this.pos++;
                }
            }
            return this.format.substring(i, this.pos);
        }

        public static String[] tokenize(String str) {
            ArrayList arrayList = new ArrayList();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken != null) {
                    arrayList.add(nextToken);
                } else {
                    return (String[]) arrayList.toArray(new String[0]);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(this.format);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken != null) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append("[").append(nextToken).append("]");
                } else {
                    return sb.toString();
                }
            }
        }
    }

    private static Map<String, String> prepareTokenConversions() {
        HashMap hashMap = new HashMap();
        hashMap.put("EEEE", "dddd");
        hashMap.put("EEE", "ddd");
        hashMap.put("EE", "ddd");
        hashMap.put("E", "d");
        hashMap.put("Z", "");
        hashMap.put("z", "");
        hashMap.put("a", "am/pm");
        hashMap.put("A", "AM/PM");
        hashMap.put("K", "H");
        hashMap.put("KK", "HH");
        hashMap.put("k", "h");
        hashMap.put("kk", "hh");
        hashMap.put("S", SessionDescription.SUPPORTED_SDP_VERSION);
        hashMap.put("SS", MapboxAccounts.SKU_ID_MAPS_MAUS);
        hashMap.put("SSS", "000");
        return hashMap;
    }

    private static Map<String, String> prepareLocalePrefixes() {
        HashMap hashMap = new HashMap();
        hashMap.put("af", "[$-0436]");
        hashMap.put("am", "[$-45E]");
        hashMap.put("ar_ae", "[$-3801]");
        hashMap.put("ar_bh", "[$-3C01]");
        hashMap.put("ar_dz", "[$-1401]");
        hashMap.put("ar_eg", "[$-C01]");
        hashMap.put("ar_iq", "[$-0801]");
        hashMap.put("ar_jo", "[$-2C01]");
        hashMap.put("ar_kw", "[$-3401]");
        hashMap.put("ar_lb", "[$-3001]");
        hashMap.put("ar_ly", "[$-1001]");
        hashMap.put("ar_ma", "[$-1801]");
        hashMap.put("ar_om", "[$-2001]");
        hashMap.put("ar_qa", "[$-4001]");
        hashMap.put("ar_sa", "[$-0401]");
        hashMap.put("ar_sy", "[$-2801]");
        hashMap.put("ar_tn", "[$-1C01]");
        hashMap.put("ar_ye", "[$-2401]");
        hashMap.put("as", "[$-44D]");
        hashMap.put("az_az", "[$-82C]");
        hashMap.put("az_az", "[$-42C]");
        hashMap.put("be", "[$-0423]");
        hashMap.put("bg", "[$-0402]");
        hashMap.put("bn", "[$-0845]");
        hashMap.put("bn", "[$-0445]");
        hashMap.put("bo", "[$-0451]");
        hashMap.put("bs", "[$-141A]");
        hashMap.put("ca", "[$-0403]");
        hashMap.put("cs", "[$-0405]");
        hashMap.put("cy", "[$-0452]");
        hashMap.put("da", "[$-0406]");
        hashMap.put("de_at", "[$-C07]");
        hashMap.put("de_ch", "[$-0807]");
        hashMap.put("de_de", "[$-0407]");
        hashMap.put("de_li", "[$-1407]");
        hashMap.put("de_lu", "[$-1007]");
        hashMap.put("dv", "[$-0465]");
        hashMap.put("el", "[$-0408]");
        hashMap.put("en_au", "[$-C09]");
        hashMap.put("en_bz", "[$-2809]");
        hashMap.put("en_ca", "[$-1009]");
        hashMap.put("en_cb", "[$-2409]");
        hashMap.put("en_gb", "[$-0809]");
        hashMap.put("en_ie", "[$-1809]");
        hashMap.put("en_in", "[$-4009]");
        hashMap.put("en_jm", "[$-2009]");
        hashMap.put("en_nz", "[$-1409]");
        hashMap.put("en_ph", "[$-3409]");
        hashMap.put("en_tt", "[$-2C09]");
        hashMap.put("en_us", "[$-0409]");
        hashMap.put("en_za", "[$-1C09]");
        hashMap.put("es_ar", "[$-2C0A]");
        hashMap.put("es_bo", "[$-400A]");
        hashMap.put("es_cl", "[$-340A]");
        hashMap.put("es_co", "[$-240A]");
        hashMap.put("es_cr", "[$-140A]");
        hashMap.put("es_do", "[$-1C0A]");
        hashMap.put("es_ec", "[$-300A]");
        hashMap.put("es_es", "[$-40A]");
        hashMap.put("es_gt", "[$-100A]");
        hashMap.put("es_hn", "[$-480A]");
        hashMap.put("es_mx", "[$-80A]");
        hashMap.put("es_ni", "[$-4C0A]");
        hashMap.put("es_pa", "[$-180A]");
        hashMap.put("es_pe", "[$-280A]");
        hashMap.put("es_pr", "[$-500A]");
        hashMap.put("es_py", "[$-3C0A]");
        hashMap.put("es_sv", "[$-440A]");
        hashMap.put("es_uy", "[$-380A]");
        hashMap.put("es_ve", "[$-200A]");
        hashMap.put("et", "[$-0425]");
        hashMap.put("eu", "[$-42D]");
        hashMap.put("fa", "[$-0429]");
        hashMap.put("fi", "[$-40B]");
        hashMap.put("fo", "[$-0438]");
        hashMap.put("fr_be", "[$-80C]");
        hashMap.put("fr_ca", "[$-C0C]");
        hashMap.put("fr_ch", "[$-100C]");
        hashMap.put("fr_fr", "[$-40C]");
        hashMap.put("fr_lu", "[$-140C]");
        hashMap.put("gd", "[$-43C]");
        hashMap.put("gd_ie", "[$-83C]");
        hashMap.put("gn", "[$-0474]");
        hashMap.put("gu", "[$-0447]");
        hashMap.put("he", "[$-40D]");
        hashMap.put("hi", "[$-0439]");
        hashMap.put("hr", "[$-41A]");
        hashMap.put("hu", "[$-40E]");
        hashMap.put("hy", "[$-42B]");
        hashMap.put(TtmlNode.ATTR_ID, "[$-0421]");
        hashMap.put("is", "[$-40F]");
        hashMap.put("it_ch", "[$-0810]");
        hashMap.put("it_it", "[$-0410]");
        hashMap.put("ja", "[$-0411]");
        hashMap.put("kk", "[$-43F]");
        hashMap.put("km", "[$-0453]");
        hashMap.put("kn", "[$-44B]");
        hashMap.put("ko", "[$-0412]");
        hashMap.put("ks", "[$-0460]");
        hashMap.put("la", "[$-0476]");
        hashMap.put("lo", "[$-0454]");
        hashMap.put("lt", "[$-0427]");
        hashMap.put("lv", "[$-0426]");
        hashMap.put("mi", "[$-0481]");
        hashMap.put("mk", "[$-42F]");
        hashMap.put("ml", "[$-44C]");
        hashMap.put("mn", "[$-0850]");
        hashMap.put("mn", "[$-0450]");
        hashMap.put("mr", "[$-44E]");
        hashMap.put("ms_bn", "[$-83E]");
        hashMap.put("ms_my", "[$-43E]");
        hashMap.put("mt", "[$-43A]");
        hashMap.put("my", "[$-0455]");
        hashMap.put("ne", "[$-0461]");
        hashMap.put("nl_be", "[$-0813]");
        hashMap.put("nl_nl", "[$-0413]");
        hashMap.put("no_no", "[$-0814]");
        hashMap.put("or", "[$-0448]");
        hashMap.put("pa", "[$-0446]");
        hashMap.put("pl", "[$-0415]");
        hashMap.put("pt_br", "[$-0416]");
        hashMap.put("pt_pt", "[$-0816]");
        hashMap.put("rm", "[$-0417]");
        hashMap.put("ro", "[$-0418]");
        hashMap.put("ro_mo", "[$-0818]");
        hashMap.put("ru", "[$-0419]");
        hashMap.put("ru_mo", "[$-0819]");
        hashMap.put("sa", "[$-44F]");
        hashMap.put("sb", "[$-42E]");
        hashMap.put("sd", "[$-0459]");
        hashMap.put("si", "[$-45B]");
        hashMap.put("sk", "[$-41B]");
        hashMap.put("sl", "[$-0424]");
        hashMap.put("so", "[$-0477]");
        hashMap.put("sq", "[$-41C]");
        hashMap.put("sr_sp", "[$-C1A]");
        hashMap.put("sr_sp", "[$-81A]");
        hashMap.put("sv_fi", "[$-81D]");
        hashMap.put("sv_se", "[$-41D]");
        hashMap.put("sw", "[$-0441]");
        hashMap.put("ta", "[$-0449]");
        hashMap.put("te", "[$-44A]");
        hashMap.put("tg", "[$-0428]");
        hashMap.put("th", "[$-41E]");
        hashMap.put("tk", "[$-0442]");
        hashMap.put("tn", "[$-0432]");
        hashMap.put("tr", "[$-41F]");
        hashMap.put("ts", "[$-0431]");
        hashMap.put(TtmlNode.TAG_TT, "[$-0444]");
        hashMap.put("uk", "[$-0422]");
        hashMap.put("ur", "[$-0420]");
        hashMap.put("UTF_8", "[$-0000]");
        hashMap.put("uz_uz", "[$-0843]");
        hashMap.put("uz_uz", "[$-0443]");
        hashMap.put("vi", "[$-42A]");
        hashMap.put("xh", "[$-0434]");
        hashMap.put("yi", "[$-43D]");
        hashMap.put("zh_cn", "[$-0804]");
        hashMap.put("zh_hk", "[$-C04]");
        hashMap.put("zh_mo", "[$-1404]");
        hashMap.put("zh_sg", "[$-1004]");
        hashMap.put("zh_tw", "[$-0404]");
        hashMap.put("zu", "[$-0435]");
        hashMap.put("ar", "[$-0401]");
        hashMap.put("bn", "[$-0845]");
        hashMap.put("de", "[$-0407]");
        hashMap.put("en", "[$-0409]");
        hashMap.put("es", "[$-40A]");
        hashMap.put("fr", "[$-40C]");
        hashMap.put("it", "[$-0410]");
        hashMap.put("ms", "[$-43E]");
        hashMap.put("nl", "[$-0413]");
        hashMap.put("nn", "[$-0814]");
        hashMap.put(BooleanUtils.NO, "[$-0414]");
        hashMap.put("pt", "[$-0816]");
        hashMap.put("sr", "[$-C1A]");
        hashMap.put("sv", "[$-41D]");
        hashMap.put("uz", "[$-0843]");
        hashMap.put("zh", "[$-0804]");
        hashMap.put("ga", "[$-43C]");
        hashMap.put("ga_ie", "[$-83C]");
        hashMap.put("in", "[$-0421]");
        hashMap.put("iw", "[$-40D]");
        hashMap.put("", "[$-0409]");
        return hashMap;
    }

    public static String getPrefixForLocale(Locale locale) {
        String lowerCase = locale.toString().toLowerCase();
        String str = localePrefixes.get(lowerCase);
        if (str != null || (str = localePrefixes.get(lowerCase.substring(0, 2))) != null) {
            return str;
        }
        logger.log(7, "Unable to find prefix for " + locale + "(" + locale.getDisplayName() + ") or " + lowerCase.substring(0, 2) + "(" + new Locale(lowerCase.substring(0, 2)).getDisplayName() + ")");
        return "";
    }

    public static String convert(Locale locale, DateFormat dateFormat) {
        return convert(locale, ((SimpleDateFormat) dateFormat).toPattern());
    }

    public static String convert(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefixForLocale(locale));
        DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
        while (true) {
            String nextToken = dateFormatTokenizer.getNextToken();
            if (nextToken != null) {
                if (nextToken.startsWith("'")) {
                    sb.append(nextToken.replaceAll("'", "\""));
                } else if (!Character.isLetter(nextToken.charAt(0))) {
                    sb.append(nextToken);
                } else {
                    String str2 = tokenConversions.get(nextToken);
                    if (str2 != null) {
                        nextToken = str2;
                    }
                    sb.append(nextToken);
                }
            } else {
                sb.append(";@");
                return sb.toString().trim();
            }
        }
    }

    public static String getJavaDatePattern(int i, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i, locale);
        if (dateInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateInstance).toPattern();
        }
        return i != 0 ? i != 1 ? i != 3 ? "MMM d, yyyy" : "d/MM/yy" : "MMMM d, yyyy" : "dddd, MMMM d, yyyy";
    }

    public static String getJavaTimePattern(int i, Locale locale) {
        DateFormat timeInstance = DateFormat.getTimeInstance(i, locale);
        if (timeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) timeInstance).toPattern();
        }
        return i != 3 ? "h:mm:ss a" : "h:mm a";
    }

    public static String getJavaDateTimePattern(int i, Locale locale) {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(i, i, locale);
        if (dateTimeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        }
        return i != 0 ? i != 1 ? i != 3 ? "MMM d, yyyy h:mm:ss a" : "M/d/yy h:mm a" : "MMMM d, yyyy h:mm:ss a" : "dddd, MMMM d, yyyy h:mm:ss a";
    }
}
