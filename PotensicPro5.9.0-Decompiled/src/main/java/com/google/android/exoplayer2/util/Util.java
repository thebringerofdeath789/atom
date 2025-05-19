package com.google.android.exoplayer2.util;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.hjq.permissions.Permission;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.nntp.NNTPReply;
import org.apache.commons.net.telnet.TelnetCommand;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.usermodel.HSSFShapeTypes;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class Util {
    private static final int[] CRC32_BYTES_MSBF;
    private static final int[] CRC8_BYTES_MSBF;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static final Pattern ESCAPED_CHARACTER_PATTERN;
    private static final String ISM_DASH_FORMAT_EXTENSION = "format=mpd-time-csf";
    private static final String ISM_HLS_FORMAT_EXTENSION = "format=m3u8-aapl";
    private static final Pattern ISM_URL_PATTERN;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN;
    private static final Pattern XS_DURATION_PATTERN;
    private static final String[] additionalIsoLanguageReplacements;
    private static final String[] isoLegacyTagReplacements;
    private static HashMap<String, String> languageTagReplacementMap;

    public static long addWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T castNonNull(T t) {
        return t;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullTypeArray(T[] tArr) {
        return tArr;
    }

    public static int compareLong(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static String getAdaptiveMimeTypeForContentType(int i) {
        if (i == 0) {
            return MimeTypes.APPLICATION_MPD;
        }
        if (i == 1) {
            return MimeTypes.APPLICATION_SS;
        }
        if (i != 2) {
            return null;
        }
        return MimeTypes.APPLICATION_M3U8;
    }

    public static int getAudioContentTypeForStreamType(int i) {
        if (i != 0) {
            return (i == 1 || i == 2 || i == 4 || i == 5 || i == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioUsageForStreamType(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 1) {
            return 13;
        }
        if (i == 2) {
            return 6;
        }
        int i2 = 4;
        if (i != 4) {
            i2 = 5;
            if (i != 5) {
                return i != 8 ? 1 : 3;
            }
        }
        return i2;
    }

    public static int getPcmEncoding(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i == 24) {
            return 536870912;
        }
        if (i != 32) {
            return 0;
        }
        return C.ENCODING_PCM_32BIT;
    }

    public static int getStreamTypeForAudioUsage(int i) {
        if (i == 13) {
            return 1;
        }
        switch (i) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static boolean isEncodingHighResolutionPcm(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean isEncodingLinearPcm(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean isLinebreak(int i) {
        return i == 10 || i == 13;
    }

    private static boolean shouldEscapeCharacter(char c) {
        return c == '\"' || c == '%' || c == '*' || c == '/' || c == ':' || c == '<' || c == '\\' || c == '|' || c == '>' || c == '?';
    }

    public static long subtractWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static long toUnsignedLong(int i) {
        return i & 4294967295L;
    }

    static {
        int i;
        if ("S".equals(Build.VERSION.CODENAME)) {
            i = 31;
        } else {
            i = "R".equals(Build.VERSION.CODENAME) ? 30 : Build.VERSION.SDK_INT;
        }
        SDK_INT = i;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        DEVICE_DEBUG_INFO = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(str3).length() + String.valueOf(str2).length()).append(str).append(", ").append(str3).append(", ").append(str2).append(", ").append(i).toString();
        EMPTY_BYTE_ARRAY = new byte[0];
        XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        ISM_URL_PATTERN = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        additionalIsoLanguageReplacements = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", TtmlNode.ATTR_ID, "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        isoLegacyTagReplacements = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        CRC32_BYTES_MSBF = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        CRC8_BYTES_MSBF = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, NNTPReply.NEW_NEWSGROUP_LIST_FOLLOWS, TelnetCommand.ABORT, UnknownRecord.BITMAP_00E9, TelnetCommand.WONT, 251, 242, TelnetCommand.AO, 216, NNTPReply.ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY, 214, 209, HSSFShapeTypes.ActionButtonBeginning, HSSFShapeTypes.ActionButtonEnd, 202, NNTPReply.CLOSING_CONNECTION, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, FTPReply.FILE_STATUS, 210, 255, TelnetCommand.EL, TelnetCommand.NOP, TelnetCommand.AYT, FTPReply.ENTERING_PASSIVE_MODE, 228, TelnetCommand.SUSP, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, TelnetCommand.GA, 254, TelnetCommand.EC, 240, FTPReply.ENTERING_EPSV_MODE, FTPReply.CLOSING_DATA_CONNECTION, 235, TelnetCommand.EOF, 193, 198, 207, 200, 221, 218, 211, FTPReply.DIRECTORY_STATUS, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, NNTPReply.ARTICLE_RETRIEVED_BODY_FOLLOWS, 217, 208, FTPReply.NAME_SYSTEM_TYPE, HSSFShapeTypes.ActionButtonBackPrevious, HSSFShapeTypes.ActionButtonReturn, 204, 203, 230, FTPReply.DATA_CONNECTION_OPEN, 232, 239, 250, TelnetCommand.DO, 244, TelnetCommand.BREAK};
    }

    private Util() {
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (Uri uri : uriArr) {
            if (isLocalFileUri(uri)) {
                return requestExternalStoragePermission(activity);
            }
        }
        return false;
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, MediaItem... mediaItemArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            if (mediaItem.playbackProperties != null) {
                if (isLocalFileUri(mediaItem.playbackProperties.uri)) {
                    return requestExternalStoragePermission(activity);
                }
                for (int i = 0; i < mediaItem.playbackProperties.subtitles.size(); i++) {
                    if (isLocalFileUri(mediaItem.playbackProperties.subtitles.get(i).uri)) {
                        return requestExternalStoragePermission(activity);
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkCleartextTrafficPermitted(MediaItem... mediaItemArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            if (mediaItem.playbackProperties != null) {
                if (isTrafficRestricted(mediaItem.playbackProperties.uri)) {
                    return false;
                }
                for (int i = 0; i < mediaItem.playbackProperties.subtitles.size(); i++) {
                    if (isTrafficRestricted(mediaItem.playbackProperties.subtitles.get(i).uri)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || StringLookupFactory.KEY_FILE.equals(scheme);
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (areEqual(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T> void removeRange(List<T> list, int i, int i2) {
        if (i < 0 || i2 > list.size() || i > i2) {
            throw new IllegalArgumentException();
        }
        if (i != i2) {
            list.subList(i, i2).clear();
        }
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int i) {
        Assertions.checkArgument(i <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static <T> T[] nullSafeArrayCopyOfRange(T[] tArr, int i, int i2) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i2 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i, i2);
    }

    public static <T> T[] nullSafeArrayAppend(T[] tArr, T t) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t;
        return (T[]) castNonNullTypeArray(copyOf);
    }

    public static <T> T[] nullSafeArrayConcatenation(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> void nullSafeListToArray(List<T> list, T[] tArr) {
        Assertions.checkState(list.size() == tArr.length);
        list.toArray(tArr);
    }

    public static Handler createHandlerForCurrentLooper() {
        return createHandlerForCurrentLooper(null);
    }

    public static Handler createHandlerForCurrentLooper(Handler.Callback callback) {
        return createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), callback);
    }

    public static Handler createHandlerForCurrentOrMainLooper() {
        return createHandlerForCurrentOrMainLooper(null);
    }

    public static Handler createHandlerForCurrentOrMainLooper(Handler.Callback callback) {
        return createHandler(getCurrentOrMainLooper(), callback);
    }

    public static Handler createHandler(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean postOrRun(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
            return true;
        }
        return handler.post(runnable);
    }

    public static Looper getCurrentOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static ExecutorService newSingleThreadExecutor(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.exoplayer2.util.-$$Lambda$Util$LsFSSGqWIg35Q7Hq-LRlCkVPQ9Y
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.lambda$newSingleThreadExecutor$0(str, runnable);
            }
        });
    }

    public static byte[] readToEnd(DataSource dataSource) throws IOException {
        byte[] bArr = new byte[1024];
        int i = 0;
        int i2 = 0;
        while (i != -1) {
            if (i2 == bArr.length) {
                bArr = Arrays.copyOf(bArr, bArr.length * 2);
            }
            i = dataSource.read(bArr, i2, bArr.length - i2);
            if (i != -1) {
                i2 += i;
            }
        }
        return Arrays.copyOf(bArr, i2);
    }

    public static byte[] readExactly(DataSource dataSource, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = dataSource.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new IllegalStateException(new StringBuilder(56).append("Not enough data could be read: ").append(i2).append(" < ").append(i).toString());
            }
            i2 += read;
        }
        return bArr;
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String getLocaleLanguageTag(Locale locale) {
        return SDK_INT >= 21 ? getLocaleLanguageTagV21(locale) : locale.toString();
    }

    public static String normalizeLanguageCode(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace(NameUtil.USCORE, NameUtil.HYPHEN);
        if (!replace.isEmpty() && !replace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = replace;
        }
        String lowerCase = Ascii.toLowerCase(str);
        String str2 = splitAtFirst(lowerCase, "-")[0];
        if (languageTagReplacementMap == null) {
            languageTagReplacementMap = createIsoLanguageReplacementMap();
        }
        String str3 = languageTagReplacementMap.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(str3);
            String valueOf2 = String.valueOf(lowerCase.substring(str2.length()));
            lowerCase = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            str2 = str3;
        }
        return (BooleanUtils.NO.equals(str2) || Complex.DEFAULT_SUFFIX.equals(str2) || "zh".equals(str2)) ? maybeReplaceLegacyLanguageTags(lowerCase) : lowerCase;
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static String fromUtf8Bytes(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, Charsets.UTF_8);
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static String[] split(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] splitAtFirst(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static long ceilDivide(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int constrainValue(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static long constrainValue(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static float constrainValue(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static int linearSearch(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static int linearSearch(long[] jArr, long j) {
        for (int i = 0; i < jArr.length; i++) {
            if (jArr[i] == j) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchFloor(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    public static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static <T extends Comparable<? super T>> int binarySearchFloor(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int binarySearchFloor(LongArray longArray, long j, boolean z, boolean z2) {
        int i;
        int size = longArray.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (longArray.get(i3) < j) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        if (z && (i = size + 1) < longArray.size() && longArray.get(i) == j) {
            return i;
        }
        if (z2 && size == -1) {
            return 0;
        }
        return size;
    }

    public static int binarySearchCeil(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i2 = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= iArr.length) {
                    break;
                }
            } while (iArr[binarySearch] == i);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(iArr.length - 1, i2) : i2;
    }

    public static int binarySearchCeil(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = ~binarySearch;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(jArr.length - 1, i) : i;
    }

    public static <T extends Comparable<? super T>> int binarySearchCeil(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = ~binarySearch;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (list.get(binarySearch).compareTo(t) == 0);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(list.size() - 1, i) : i;
    }

    public static long minValue(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            throw new NoSuchElementException();
        }
        long j = Long.MAX_VALUE;
        for (int i = 0; i < sparseLongArray.size(); i++) {
            j = Math.min(j, sparseLongArray.valueAt(i));
        }
        return j;
    }

    public static long parseXsDuration(String str) {
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
            String group2 = matcher.group(5);
            double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
            String group3 = matcher.group(7);
            double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
            String group4 = matcher.group(10);
            double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
            String group5 = matcher.group(12);
            double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
            String group6 = matcher.group(14);
            long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
            return isEmpty ? -parseDouble6 : parseDouble6;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw new ParserException(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "));
        }
        int i = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(TimeZones.GMT_ID));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            String valueOf2 = String.valueOf(matcher.group(8));
            gregorianCalendar.set(14, new BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new String("0.")).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i != 0 ? timeInMillis - (i * 60000) : timeInMillis;
    }

    public static long scaleLargeTimestamp(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        return (long) (j * (j2 / j3));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j, long j2) {
        int size = list.size();
        long[] jArr = new long[size];
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < size) {
                jArr[i] = list.get(i).longValue() / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = j / j2;
            while (i < size) {
                jArr[i] = (long) (list.get(i).longValue() * d);
                i++;
            }
        } else {
            long j4 = j / j2;
            while (i < size) {
                jArr[i] = list.get(i).longValue() * j4;
                i++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
            return;
        }
        if (j2 < j && j % j2 == 0) {
            long j4 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
            return;
        }
        double d = j / j2;
        while (i < jArr.length) {
            jArr[i] = (long) (jArr[i] * d);
            i++;
        }
    }

    public static long getMediaDurationForPlayoutDuration(long j, float f) {
        return f == 1.0f ? j : Math.round(j * f);
    }

    public static long getPlayoutDurationForMediaDuration(long j, float f) {
        return f == 1.0f ? j : Math.round(j / f);
    }

    public static int getIntegerCodeForString(String str) {
        int length = str.length();
        Assertions.checkArgument(length <= 4);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i << 8) | str.charAt(i2);
        }
        return i;
    }

    public static long toLong(int i, int i2) {
        return toUnsignedLong(i2) | (toUnsignedLong(i) << 32);
    }

    public static CharSequence truncateAscii(CharSequence charSequence, int i) {
        return charSequence.length() <= i ? charSequence : charSequence.subSequence(0, i);
    }

    public static byte[] getBytesFromHexString(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16)).append(Character.forDigit(bArr[i] & 15, 16));
        }
        return sb.toString();
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        String str3 = Build.VERSION.RELEASE;
        return new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str2).append(" (Linux;Android ").append(str3).append(") ").append(ExoPlayerLibraryInfo.VERSION_SLASHY).toString();
    }

    public static int getCodecCountOfType(String str, int i) {
        int i2 = 0;
        for (String str2 : splitCodecs(str)) {
            if (i == MimeTypes.getTrackTypeOfCodec(str2)) {
                i2++;
            }
        }
        return i2;
    }

    public static String getCodecsOfType(String str, int i) {
        String[] splitCodecs = splitCodecs(str);
        if (splitCodecs.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : splitCodecs) {
            if (i == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String[] splitCodecs(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : split(str.trim(), "(\\s*,\\s*)");
    }

    public static Format getPcmFormat(int i, int i2, int i3) {
        return new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(i2).setSampleRate(i3).setPcmEncoding(i).build();
    }

    public static int getAudioTrackChannelConfig(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return TelnetCommand.WONT;
            case 7:
                return 1276;
            case 8:
                int i2 = SDK_INT;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getPcmFrameSize(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 * 2;
    }

    public static UUID getDrmUuid(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "playready":
                return C.PLAYREADY_UUID;
            case "widevine":
                return C.WIDEVINE_UUID;
            case "clearkey":
                return C.CLEARKEY_UUID;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static int inferContentType(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        String valueOf = String.valueOf(str);
        return inferContentType(valueOf.length() != 0 ? ".".concat(valueOf) : new String("."));
    }

    public static int inferContentType(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && Ascii.equalsIgnoreCase("rtsp", scheme)) {
            return 3;
        }
        String path = uri.getPath();
        if (path == null) {
            return 4;
        }
        return inferContentType(path);
    }

    public static int inferContentType(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        if (lowerCase.endsWith(".mpd")) {
            return 0;
        }
        if (lowerCase.endsWith(".m3u8")) {
            return 2;
        }
        Matcher matcher = ISM_URL_PATTERN.matcher(lowerCase);
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group == null) {
            return 1;
        }
        if (group.contains(ISM_DASH_FORMAT_EXTENSION)) {
            return 0;
        }
        return group.contains(ISM_HLS_FORMAT_EXTENSION) ? 2 : 1;
    }

    public static int inferContentTypeForUriAndMimeType(Uri uri, String str) {
        if (str == null) {
            return inferContentType(uri);
        }
        str.hashCode();
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static Uri fixSmoothStreamingIsmManifestUri(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = ISM_URL_PATTERN.matcher(Ascii.toLowerCase(path));
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static String getStringForTime(StringBuilder sb, Formatter formatter, long j) {
        if (j == C.TIME_UNSET) {
            j = 0;
        }
        String str = j < 0 ? "-" : "";
        long abs = (Math.abs(j) + 500) / 1000;
        long j2 = abs % 60;
        long j3 = (abs / 60) % 60;
        long j4 = abs / 3600;
        sb.setLength(0);
        return j4 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j3), Long.valueOf(j2)).toString();
    }

    public static String escapeFileName(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (shouldEscapeCharacter(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) + length);
        while (i2 > 0) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            if (shouldEscapeCharacter(charAt)) {
                sb.append('%').append(Integer.toHexString(charAt));
                i2--;
            } else {
                sb.append(charAt);
            }
            i = i4;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        return sb.toString();
    }

    public static String unescapeFileName(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '%') {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        int i4 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i4);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (i2 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i, matcher.start()).append((char) Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)), 16));
            i = matcher.end();
            i2--;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        if (sb.length() != i4) {
            return null;
        }
        return sb.toString();
    }

    public static Uri getDataUriForString(String str, String str2) {
        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
        return Uri.parse(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(encodeToString).length()).append("data:").append(str).append(";base64,").append(encodeToString).toString());
    }

    public static void sneakyThrow(Throwable th) {
        sneakyThrowInternal(th);
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th) throws Throwable {
        throw th;
    }

    public static void recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, null, (File) Assertions.checkNotNull(context.getCacheDir()));
    }

    public static int crc32(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static int crc8(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = CRC8_BYTES_MSBF[i3 ^ (bArr[i] & 255)];
            i++;
        }
        return i3;
    }

    public static byte[] gzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static int getBigEndianInt(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    public static String getCountryCode(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.toUpperCase(networkCountryIso);
            }
        }
        return Ascii.toUpperCase(Locale.getDefault().getCountry());
    }

    public static String[] getSystemLanguageCodes() {
        String[] systemLocales = getSystemLocales();
        for (int i = 0; i < systemLocales.length; i++) {
            systemLocales[i] = normalizeLanguageCode(systemLocales[i]);
        }
        return systemLocales;
    }

    public static boolean inflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        if (parsableByteArray2.capacity() < parsableByteArray.bytesLeft()) {
            parsableByteArray2.ensureCapacity(parsableByteArray.bytesLeft() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.bytesLeft());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(parsableByteArray2.getData(), i, parsableByteArray2.capacity() - i);
                if (inflater.finished()) {
                    parsableByteArray2.setLimit(i);
                    return true;
                }
                if (inflater.needsDictionary() || inflater.needsInput()) {
                    break;
                }
                if (i == parsableByteArray2.capacity()) {
                    parsableByteArray2.ensureCapacity(parsableByteArray2.capacity() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Point getCurrentDisplayModeSize(Context context) {
        DisplayManager displayManager;
        Display display = (SDK_INT < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return getCurrentDisplayModeSize(context, display);
    }

    public static Point getCurrentDisplayModeSize(Context context, Display display) {
        String systemProperty;
        int i = SDK_INT;
        if (i <= 29 && display.getDisplayId() == 0 && isTv(context)) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (i < 28) {
                systemProperty = getSystemProperty("sys.display-size");
            } else {
                systemProperty = getSystemProperty("vendor.display-size");
            }
            if (!TextUtils.isEmpty(systemProperty)) {
                try {
                    String[] split = split(systemProperty.trim(), "x");
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(systemProperty);
                Log.e(TAG, valueOf.length() != 0 ? "Invalid display size: ".concat(valueOf) : new String("Invalid display size: "));
            }
        }
        Point point = new Point();
        int i2 = SDK_INT;
        if (i2 >= 23) {
            getDisplaySizeV23(display, point);
        } else if (i2 >= 17) {
            getDisplaySizeV17(display, point);
        } else {
            getDisplaySizeV16(display, point);
        }
        return point;
    }

    public static String getTrackTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? i >= 10000 ? new StringBuilder(20).append("custom (").append(i).append(")").toString() : "?" : "none" : "camera motion" : TtmlNode.TAG_METADATA : "text" : "video" : "audio" : "default";
    }

    public static long getNowUnixTimeMs(long j) {
        if (j == C.TIME_UNSET) {
            return System.currentTimeMillis();
        }
        return j + android.os.SystemClock.elapsedRealtime();
    }

    public static <T> void moveItems(List<T> list, int i, int i2, int i3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i4 = (i2 - i) - 1; i4 >= 0; i4--) {
            arrayDeque.addFirst(list.remove(i + i4));
        }
        list.addAll(Math.min(i3, list.size()), arrayDeque);
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            String valueOf = String.valueOf(str);
            Log.e(TAG, valueOf.length() != 0 ? "Failed to read system property ".concat(valueOf) : new String("Failed to read system property "), e);
            return null;
        }
    }

    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    private static String[] getSystemLocales() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return SDK_INT >= 24 ? getSystemLocalesV24(configuration) : new String[]{getLocaleLanguageTag(configuration.locale)};
    }

    private static String[] getSystemLocalesV24(Configuration configuration) {
        return split(configuration.getLocales().toLanguageTags(), ",");
    }

    private static String getLocaleLanguageTagV21(Locale locale) {
        return locale.toLanguageTag();
    }

    private static HashMap<String, String> createIsoLanguageReplacementMap() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + additionalIsoLanguageReplacements.length);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = additionalIsoLanguageReplacements;
            if (i >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    private static boolean requestExternalStoragePermission(Activity activity) {
        if (activity.checkSelfPermission(Permission.READ_EXTERNAL_STORAGE) == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{Permission.READ_EXTERNAL_STORAGE}, 0);
        return true;
    }

    private static boolean isTrafficRestricted(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) Assertions.checkNotNull(uri.getHost()));
    }

    private static String maybeReplaceLegacyLanguageTags(String str) {
        int i = 0;
        while (true) {
            String[] strArr = isoLegacyTagReplacements;
            if (i >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i])) {
                String valueOf = String.valueOf(strArr[i + 1]);
                String valueOf2 = String.valueOf(str.substring(strArr[i].length()));
                return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            }
            i += 2;
        }
    }
}
