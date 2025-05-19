package jxl.biff.formula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import jxl.biff.WorkbookMethods;

/* loaded from: classes4.dex */
class Yylex {
    private final int YYINITIAL;
    private final int YYSTRING;
    private final int YY_BOL;
    private final int YY_BUFFER_SIZE;
    private final int YY_END;
    private final int YY_EOF;
    private final int YY_E_INTERNAL;
    private final int YY_E_MATCH;
    private final int YY_F;
    private final int YY_NOT_ACCEPT;
    private final int YY_NO_ANCHOR;
    private final int YY_NO_STATE;
    private final int YY_START;
    private boolean emptyString;
    private ExternalSheet externalSheet;
    private WorkbookMethods nameTable;
    private int[] yy_acpt;
    private boolean yy_at_bol;
    private char[] yy_buffer;
    private int yy_buffer_end;
    private int yy_buffer_index;
    private int yy_buffer_read;
    private int yy_buffer_start;
    private int[] yy_cmap;
    private boolean yy_eof_done;
    private String[] yy_error_string;
    private boolean yy_last_was_cr;
    private int yy_lexical_state;
    private int[][] yy_nxt;
    private BufferedReader yy_reader;
    private int[] yy_rmap;
    private final int[] yy_state_dtrans;
    private int yychar;
    private int yyline;

    int getPos() {
        return this.yychar;
    }

    void setExternalSheet(ExternalSheet externalSheet) {
        this.externalSheet = externalSheet;
    }

    void setNameTable(WorkbookMethods workbookMethods) {
        this.nameTable = workbookMethods;
    }

    Yylex(Reader reader) {
        this();
        if (reader == null) {
            throw new Error("Error: Bad input stream initializer.");
        }
        this.yy_reader = new BufferedReader(reader);
    }

    Yylex(InputStream inputStream) {
        this();
        if (inputStream == null) {
            throw new Error("Error: Bad input stream initializer.");
        }
        this.yy_reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    private Yylex() {
        this.YY_BUFFER_SIZE = 512;
        this.YY_F = -1;
        this.YY_NO_STATE = -1;
        this.YY_NOT_ACCEPT = 0;
        this.YY_START = 1;
        this.YY_END = 2;
        this.YY_NO_ANCHOR = 4;
        this.YY_BOL = 65536;
        this.YY_EOF = 65537;
        this.yy_eof_done = false;
        this.YYSTRING = 1;
        this.YYINITIAL = 0;
        this.yy_state_dtrans = new int[]{0, 31};
        this.yy_last_was_cr = false;
        this.YY_E_INTERNAL = 0;
        this.YY_E_MATCH = 1;
        this.yy_error_string = new String[]{"Error: Internal error.\n", "Error: Unmatched input.\n"};
        this.yy_acpt = new int[]{0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 4, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 4, 0};
        this.yy_cmap = unpackFromString(1, 65538, "14:8,25:3,14:21,25,15,28,14,11,14:2,13,26,27,3,1,8,2,10,4,9:10,16,14,7,6,5,14:2,22,12:3,20,21,12:5,23,12:5,18,24,17,19,12:5,14:6,12:26,14:65413,0:2")[0];
        this.yy_rmap = unpackFromString(1, 78, "0,1:5,2,1,3,1,4,1:8,5,6,1,7,8,9,10,11,12,10,13,14,15,1,16,17,10,1:2,18,19,20,21,22,7,23,24,25,26,27,28,29,30,31,32,33,34,9,35,36,11,37,38,39,40,41,42,43,14,44,45,46,47,48,49,50,51,52,53")[0];
        this.yy_nxt = unpackFromString(54, 29, "1,2,3,4,5,6,7,8,9,10,33,39,33,41,-1:2,11,69,33:3,77,33:3,12,13,14,15,-1:35,16,-1:27,17,18,-1:31,10,43,-1:27,19,-1:6,72,-1:21,34,35,45,35,-1:2,46,47,35:8,-1,21,-1:11,22,-1:29,36,-1,36,-1:4,36:8,-1:13,24,-1:28,42,35,-1,35,-1:2,46,-1,35:8,-1,21,-1:11,26,-1:28,27,-1:6,63,-1:22,37,-1,37,-1:4,37:8,-1:13,30,-1:19,1,38:27,32,-1:9,19,20,45,20,-1:2,46,47,20:8,-1,21,-1:11,34,42,-1,42,-1:3,72,42:8,-1:5,38:27,-1:11,48,-1,48,-1:4,48:8,-1:13,42,35,-1,35,-1:2,46,-1,35:3,25,35:4,-1,21,-1:3,41:12,49,41:15,-1:9,42:2,-1,42,-1:4,42:8,-1:13,42,35,-1,35,-1:2,46,-1,35:3,28,35:4,-1,21,-1:11,19,-1:29,50,71,50,-1:4,50:8,-1:14,23,51,23,-1:4,23:8,-1:13,19,52,45,52,-1:3,47,52:8,-1:19,53,-1:22,24,55,56,55,-1:4,55:8,-1:14,23,-1,23,-1:4,23:8,-1:13,19,-1,45,-1:4,47,-1:22,57,74,57,-1:4,57:8,-1:13,26,58,59,58,-1:4,58:8,-1:13,24,-1,56,-1:26,27,60,61,60,-1:3,62,60:8,-1:13,26,-1,59,-1:26,27,-1,61,-1:4,62,-1:21,27,-1:29,29,64,29,-1:4,29:8,-1:14,65,75,65,-1:4,65:8,-1:14,29,-1,29,-1:4,29:8,-1:13,30,66,67,66,-1:4,66:8,-1:13,30,-1,67,-1:26,34,35,45,35,-1:2,46,47,35:2,40,35:5,-1,21,-1:11,19,20,45,20,-1:2,46,47,20,68,20:6,-1,21,-1:11,42,35,-1,35,-1:2,46,-1,35:7,44,-1,21,-1:12,50,-1,50,-1:4,50:8,-1:14,54,73,54,-1:4,54:8,-1:14,54,-1,54,-1:4,54:8,-1:14,57,-1,57,-1:4,57:8,-1:14,65,-1,65,-1:4,65:8,-1:13,34,35,45,35,-1:2,46,47,35:6,70,35,-1,21,-1:11,19,20,45,20,-1:2,46,47,20:5,76,20:2,-1,21,-1:2");
        this.yy_buffer = new char[512];
        this.yy_buffer_read = 0;
        this.yy_buffer_index = 0;
        this.yy_buffer_start = 0;
        this.yy_buffer_end = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.yy_at_bol = true;
        this.yy_lexical_state = 0;
    }

    private void yybegin(int i) {
        this.yy_lexical_state = i;
    }

    private int yy_advance() throws IOException {
        int i = this.yy_buffer_index;
        if (i < this.yy_buffer_read) {
            char[] cArr = this.yy_buffer;
            this.yy_buffer_index = i + 1;
            return cArr[i];
        }
        int i2 = this.yy_buffer_start;
        if (i2 != 0) {
            int i3 = 0;
            while (i2 < this.yy_buffer_read) {
                char[] cArr2 = this.yy_buffer;
                cArr2[i3] = cArr2[i2];
                i2++;
                i3++;
            }
            this.yy_buffer_end -= this.yy_buffer_start;
            this.yy_buffer_start = 0;
            this.yy_buffer_read = i3;
            this.yy_buffer_index = i3;
            BufferedReader bufferedReader = this.yy_reader;
            char[] cArr3 = this.yy_buffer;
            int read = bufferedReader.read(cArr3, i3, cArr3.length - i3);
            if (-1 == read) {
                return 65537;
            }
            this.yy_buffer_read += read;
        }
        while (true) {
            int i4 = this.yy_buffer_index;
            if (i4 >= this.yy_buffer_read) {
                char[] cArr4 = this.yy_buffer;
                if (i4 >= cArr4.length) {
                    this.yy_buffer = yy_double(cArr4);
                }
                BufferedReader bufferedReader2 = this.yy_reader;
                char[] cArr5 = this.yy_buffer;
                int i5 = this.yy_buffer_read;
                int read2 = bufferedReader2.read(cArr5, i5, cArr5.length - i5);
                if (-1 == read2) {
                    return 65537;
                }
                this.yy_buffer_read += read2;
            } else {
                char[] cArr6 = this.yy_buffer;
                this.yy_buffer_index = i4 + 1;
                return cArr6[i4];
            }
        }
    }

    private void yy_move_end() {
        int i = this.yy_buffer_end;
        int i2 = this.yy_buffer_start;
        if (i > i2 && '\n' == this.yy_buffer[i - 1]) {
            this.yy_buffer_end = i - 1;
        }
        int i3 = this.yy_buffer_end;
        if (i3 <= i2 || '\r' != this.yy_buffer[i3 - 1]) {
            return;
        }
        this.yy_buffer_end = i3 - 1;
    }

    private void yy_mark_start() {
        int i = this.yy_buffer_start;
        while (true) {
            int i2 = this.yy_buffer_index;
            if (i < i2) {
                char[] cArr = this.yy_buffer;
                if ('\n' == cArr[i] && !this.yy_last_was_cr) {
                    this.yyline++;
                }
                if ('\r' == cArr[i]) {
                    this.yyline++;
                    this.yy_last_was_cr = true;
                } else {
                    this.yy_last_was_cr = false;
                }
                i++;
            } else {
                this.yychar = (this.yychar + i2) - this.yy_buffer_start;
                this.yy_buffer_start = i2;
                return;
            }
        }
    }

    private void yy_mark_end() {
        this.yy_buffer_end = this.yy_buffer_index;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (2029 != r3[r0 - 1]) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void yy_to_mark() {
        /*
            r5 = this;
            int r0 = r5.yy_buffer_end
            r5.yy_buffer_index = r0
            int r1 = r5.yy_buffer_start
            r2 = 1
            if (r0 <= r1) goto L2b
            r1 = 13
            char[] r3 = r5.yy_buffer
            int r4 = r0 + (-1)
            char r4 = r3[r4]
            if (r1 == r4) goto L2c
            r1 = 10
            int r4 = r0 + (-1)
            char r4 = r3[r4]
            if (r1 == r4) goto L2c
            r1 = 2028(0x7ec, float:2.842E-42)
            int r4 = r0 + (-1)
            char r4 = r3[r4]
            if (r1 == r4) goto L2c
            r1 = 2029(0x7ed, float:2.843E-42)
            int r0 = r0 - r2
            char r0 = r3[r0]
            if (r1 != r0) goto L2b
            goto L2c
        L2b:
            r2 = 0
        L2c:
            r5.yy_at_bol = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.biff.formula.Yylex.yy_to_mark():void");
    }

    private String yytext() {
        char[] cArr = this.yy_buffer;
        int i = this.yy_buffer_start;
        return new String(cArr, i, this.yy_buffer_end - i);
    }

    private int yylength() {
        return this.yy_buffer_end - this.yy_buffer_start;
    }

    private char[] yy_double(char[] cArr) {
        char[] cArr2 = new char[cArr.length * 2];
        for (int i = 0; i < cArr.length; i++) {
            cArr2[i] = cArr[i];
        }
        return cArr2;
    }

    private void yy_error(int i, boolean z) {
        System.out.print(this.yy_error_string[i]);
        System.out.flush();
        if (z) {
            throw new Error("Fatal Error.\n");
        }
    }

    private int[][] unpackFromString(int i, int i2, String str) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i, i2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (i3 != 0) {
                    iArr[i5][i6] = i4;
                    i3--;
                } else {
                    int indexOf = str.indexOf(44);
                    String substring = indexOf == -1 ? str : str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    int indexOf2 = substring.indexOf(58);
                    if (indexOf2 == -1) {
                        iArr[i5][i6] = Integer.parseInt(substring);
                    } else {
                        int parseInt = Integer.parseInt(substring.substring(indexOf2 + 1));
                        i4 = Integer.parseInt(substring.substring(0, indexOf2));
                        iArr[i5][i6] = i4;
                        i3 = parseInt - 1;
                    }
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x0018, code lost:
    
        r1 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public jxl.biff.formula.ParseItem yylex() throws java.io.IOException, jxl.biff.formula.FormulaException {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.biff.formula.Yylex.yylex():jxl.biff.formula.ParseItem");
    }
}
