package jxl.biff;

import common.Logger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import jxl.WorkbookSettings;
import jxl.format.Format;
import jxl.read.biff.Record;

/* loaded from: classes4.dex */
public class FormatRecord extends WritableRecordData implements DisplayFormat, Format {
    public static final BiffType biff7;
    public static final BiffType biff8;
    static /* synthetic */ Class class$jxl$biff$FormatRecord;
    private static String[] dateStrings;
    public static Logger logger;
    private byte[] data;
    private boolean date;
    private java.text.Format format;
    private String formatString;
    private int indexCode;
    private boolean initialized;
    private boolean number;
    private WorkbookSettings settings;

    @Override // jxl.biff.DisplayFormat
    public boolean isBuiltIn() {
        return false;
    }

    static {
        Class cls = class$jxl$biff$FormatRecord;
        if (cls == null) {
            cls = class$("jxl.biff.FormatRecord");
            class$jxl$biff$FormatRecord = cls;
        }
        logger = Logger.getLogger(cls);
        dateStrings = new String[]{"dd", "mm", "yy", "hh", "ss", "m/", "/d"};
        biff8 = new BiffType();
        biff7 = new BiffType();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static class BiffType {
        private BiffType() {
        }
    }

    FormatRecord(String str, int i) {
        super(Type.FORMAT);
        this.formatString = str;
        this.indexCode = i;
        this.initialized = true;
    }

    protected FormatRecord() {
        super(Type.FORMAT);
        this.initialized = false;
    }

    protected FormatRecord(FormatRecord formatRecord) {
        super(Type.FORMAT);
        this.initialized = false;
        this.formatString = formatRecord.formatString;
        this.date = formatRecord.date;
        this.number = formatRecord.number;
    }

    public FormatRecord(Record record, WorkbookSettings workbookSettings, BiffType biffType) {
        super(record);
        byte[] data = getRecord().getData();
        int i = 0;
        this.indexCode = IntegerHelper.getInt(data[0], data[1]);
        this.initialized = true;
        if (biffType == biff8) {
            int i2 = IntegerHelper.getInt(data[2], data[3]);
            if (data[4] == 0) {
                this.formatString = StringHelper.getString(data, i2, 5, workbookSettings);
            } else {
                this.formatString = StringHelper.getUnicodeString(data, i2, 5);
            }
        } else {
            int i3 = data[2];
            byte[] bArr = new byte[i3];
            System.arraycopy(data, 3, bArr, 0, i3);
            this.formatString = new String(bArr);
        }
        this.date = false;
        this.number = false;
        while (true) {
            String[] strArr = dateStrings;
            if (i >= strArr.length) {
                break;
            }
            String str = strArr[i];
            if (this.formatString.indexOf(str) != -1 || this.formatString.indexOf(str.toUpperCase()) != -1) {
                break;
            } else {
                i++;
            }
        }
        this.date = true;
        if (this.date) {
            return;
        }
        if (this.formatString.indexOf(35) == -1 && this.formatString.indexOf(48) == -1) {
            return;
        }
        this.number = true;
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr = new byte[(this.formatString.length() * 2) + 3 + 2];
        this.data = bArr;
        IntegerHelper.getTwoBytes(this.indexCode, bArr, 0);
        IntegerHelper.getTwoBytes(this.formatString.length(), this.data, 2);
        byte[] bArr2 = this.data;
        bArr2[4] = 1;
        StringHelper.getUnicodeBytes(this.formatString, bArr2, 5);
        return this.data;
    }

    @Override // jxl.biff.DisplayFormat
    public int getFormatIndex() {
        return this.indexCode;
    }

    @Override // jxl.biff.DisplayFormat
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // jxl.biff.DisplayFormat
    public void initialize(int i) {
        this.indexCode = i;
        this.initialized = true;
    }

    protected final String replace(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        while (indexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(indexOf + str2.length()));
            str = stringBuffer.toString();
            indexOf = str.indexOf(str2);
        }
        return str;
    }

    protected final void setFormatString(String str) {
        this.formatString = str;
    }

    public final boolean isDate() {
        return this.date;
    }

    public final boolean isNumber() {
        return this.number;
    }

    public final NumberFormat getNumberFormat() {
        java.text.Format format = this.format;
        if (format != null && (format instanceof NumberFormat)) {
            return (NumberFormat) format;
        }
        try {
            this.format = new DecimalFormat(replace(replace(replace(replace(replace(this.formatString, "E+", "E"), "_)", ""), "_", ""), "[Red]", ""), "\\", ""));
        } catch (IllegalArgumentException unused) {
            this.format = new DecimalFormat("#.###");
        }
        return (NumberFormat) this.format;
    }

    public final DateFormat getDateFormat() {
        int i;
        int i2;
        int i3;
        char c;
        int indexOf;
        java.text.Format format = this.format;
        if (format != null && (format instanceof DateFormat)) {
            return (DateFormat) format;
        }
        String str = this.formatString;
        int indexOf2 = str.indexOf("AM/PM");
        while (true) {
            if (indexOf2 == -1) {
                break;
            }
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf2));
            stringBuffer.append('a');
            stringBuffer.append(str.substring(indexOf2 + 5));
            str = stringBuffer.toString();
            indexOf2 = str.indexOf("AM/PM");
        }
        int indexOf3 = str.indexOf("ss.0");
        while (indexOf3 != -1) {
            StringBuffer stringBuffer2 = new StringBuffer(str.substring(0, indexOf3));
            stringBuffer2.append("ss.SSS");
            int i4 = indexOf3 + 4;
            while (i4 < str.length() && str.charAt(i4) == '0') {
                i4++;
            }
            stringBuffer2.append(str.substring(i4));
            str = stringBuffer2.toString();
            indexOf3 = str.indexOf("ss.0");
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (str.charAt(i5) != '\\') {
                stringBuffer3.append(str.charAt(i5));
            }
        }
        String stringBuffer4 = stringBuffer3.toString();
        if (stringBuffer4.charAt(0) == '[' && (indexOf = stringBuffer4.indexOf(93)) != -1) {
            stringBuffer4 = stringBuffer4.substring(indexOf + 1);
        }
        char[] charArray = replace(stringBuffer4, ";@", "").toCharArray();
        for (i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'm') {
                if (i > 0) {
                    int i6 = i - 1;
                    if (charArray[i6] == 'm' || charArray[i6] == 'M') {
                        charArray[i] = charArray[i6];
                    }
                }
                int i7 = i - 1;
                int i8 = i7;
                while (true) {
                    if (i8 <= 0) {
                        i2 = Integer.MAX_VALUE;
                        break;
                    }
                    if (charArray[i8] == 'h') {
                        i2 = i - i8;
                        break;
                    }
                    i8--;
                }
                int i9 = i + 1;
                int i10 = i9;
                while (true) {
                    if (i10 >= charArray.length) {
                        break;
                    }
                    if (charArray[i10] == 'h') {
                        i2 = Math.min(i2, i10 - i);
                        break;
                    }
                    i10++;
                }
                int i11 = i7;
                while (true) {
                    if (i11 <= 0) {
                        break;
                    }
                    if (charArray[i11] == 'H') {
                        i2 = i - i11;
                        break;
                    }
                    i11--;
                }
                int i12 = i9;
                while (true) {
                    if (i12 >= charArray.length) {
                        break;
                    }
                    if (charArray[i12] == 'H') {
                        i2 = Math.min(i2, i12 - i);
                        break;
                    }
                    i12++;
                }
                int i13 = i7;
                while (true) {
                    if (i13 <= 0) {
                        break;
                    }
                    if (charArray[i13] == 's') {
                        i2 = Math.min(i2, i - i13);
                        break;
                    }
                    i13--;
                }
                int i14 = i9;
                while (true) {
                    if (i14 >= charArray.length) {
                        break;
                    }
                    if (charArray[i14] == 's') {
                        i2 = Math.min(i2, i14 - i);
                        break;
                    }
                    i14++;
                }
                int i15 = i7;
                while (true) {
                    if (i15 <= 0) {
                        i3 = Integer.MAX_VALUE;
                        break;
                    }
                    if (charArray[i15] == 'd') {
                        i3 = i - i15;
                        break;
                    }
                    i15--;
                }
                int i16 = i9;
                while (true) {
                    if (i16 >= charArray.length) {
                        break;
                    }
                    if (charArray[i16] == 'd') {
                        i3 = Math.min(i3, i16 - i);
                        break;
                    }
                    i16++;
                }
                while (true) {
                    if (i7 <= 0) {
                        break;
                    }
                    if (charArray[i7] == 'y') {
                        i3 = Math.min(i3, i - i7);
                        break;
                    }
                    i7--;
                }
                while (true) {
                    if (i9 >= charArray.length) {
                        break;
                    }
                    if (charArray[i9] == 'y') {
                        i3 = Math.min(i3, i9 - i);
                        break;
                    }
                    i9++;
                }
                if (i3 < i2) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                } else if (i3 == i2 && i3 != Integer.MAX_VALUE && ((c = charArray[i - i3]) == 'y' || c == 'd')) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                }
            }
        }
        try {
            this.format = new SimpleDateFormat(new String(charArray));
        } catch (IllegalArgumentException unused) {
            this.format = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
        }
        return (DateFormat) this.format;
    }

    public int getIndexCode() {
        return this.indexCode;
    }

    @Override // jxl.format.Format
    public String getFormatString() {
        return this.formatString;
    }

    public int hashCode() {
        return this.formatString.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FormatRecord)) {
            return false;
        }
        FormatRecord formatRecord = (FormatRecord) obj;
        if (this.initialized && formatRecord.initialized) {
            if (this.date == formatRecord.date && this.number == formatRecord.number) {
                return this.formatString.equals(formatRecord.formatString);
            }
            return false;
        }
        return this.formatString.equals(formatRecord.formatString);
    }
}
