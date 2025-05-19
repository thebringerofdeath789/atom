package org.apache.xmlbeans.impl.piccolo.xml;

import com.camera.JCameraView;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.logan.user.model.UserConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.nntp.NNTPReply;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

/* loaded from: classes5.dex */
final class XMLDeclParser {
    public static final int ENCODING = 4;
    public static final int GOT_ENCODING = 5;
    public static final int GOT_STANDALONE = 7;
    public static final int GOT_VERSION = 3;
    public static final int NO_DECLARATION = -1;
    public static final int STANDALONE = 6;
    public static final int SUCCESS = 1;
    public static final int VERSION = 2;
    public static final int XML_DECL = 1;
    public static final int YYEOF = -1;
    public static final int YYINITIAL = 0;
    private static final int YY_BUFFERSIZE = 0;
    private static final int YY_ILLEGAL_STATE = 1;
    private static final int YY_NO_MATCH = 2;
    private static final int YY_PUSHBACK_2BIG = 3;
    private static final int YY_SKIP_2BIG = 4;
    private static final int YY_UNKNOWN_ERROR = 0;
    private static final String yy_packed0 = "\u0006\t\u0001\n$\t\u0001\u000b\u0001\f\u0005\u000b\u0001\r5\u000b\u0001\u000e\u0003\u000b\u0001\u000f\u0015\u000b\u0001\u0010\u0005\u000b\u0001\r5\u000b\u0001\u0011\u0003\u000b\u0001\u0012\u0015\u000b\u0001\u0013\u0005\u000b\u0001\r5\u000b\u0001\u0014\u0003\u000b\u0001\u0015\u0015\u000b\u0001\u0016\u0005\u000b\u0001\r#\u000b2\u0000\u0001\u0017$\u0000\u0001\u0018\u0005\u0000\u0001\u0019\u0003\u0000\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c8\u0000\u0001\u001d\u0011\u0000\u0003\u001e\u0002\u0000\n\u001e\u0001\u0000\u0001\u001f\u0002\u001e\u0001\u0000\u0005\u001e\u0001\u0000\u000e\u001e\u0003\u0000\u0003 \u0002\u0000\n \u0001\u0000\u0001!\u0002 \u0001\u0000\u0005 \u0001\u0000\u000e \u0001\u0000\u0001\"\u0005\u0000\u0001\u0019\u0004\u0000\u0001\u001b\u0001\u0000\u0001\u001c \u0000\u0001#\u0003\u0000\n#\u0005\u0000\u0005#\u0001\u0000\u0001$\u0002#\u0002\u0000\u0001#\u0001%\u0001#\u0001&\u0001\u0000\u0001#\u0002\u0000\u0001#\u0004\u0000\u0001'\u0003\u0000\n'\u0005\u0000\u0005'\u0001\u0000\u0001(\u0002'\u0002\u0000\u0001'\u0001)\u0001'\u0001*\u0001\u0000\u0001'\u0002\u0000\u0001'\u0001\u0000\u0001+\u0005\u0000\u0001\u0019\u0006\u0000\u0001\u001c-\u0000\u0001,\u0018\u0000\u0001-\u0011\u0000\u0001.\u0018\u0000\u0001/\u0001\u0000\u00010\u0005\u0000\u0001\u0019+\u0000\u00011.\u0000\u00012/\u0000\u000133\u0000\u00014\u0013\u0000\u0003\u001e\u0002\u0000\n\u001e\u00015\u0003\u001e\u0001\u0000\u0005\u001e\u0001\u0000\u000e\u001e\u0003\u0000\u0003\u001e\u0002\u0000\n\u001e\u00015\u0001\u001e\u00016\u0001\u001e\u0001\u0000\u0005\u001e\u0001\u0000\u000e\u001e\u0003\u0000\u0003 \u0002\u0000\n \u0001\u0000\u0003 \u00015\u0005 \u0001\u0000\u000e \u0003\u0000\u0003 \u0002\u0000\n \u0001\u0000\u0001 \u00017\u0001 \u00015\u0005 \u0001\u0000\u000e \u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0001#\u00019\u0003#\u0001:\b#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0005#\u0001;\b#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0005#\u0001<\b#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u000e'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0001'\u0001=\u0003'\u0001>\b'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0005'\u0001?\b'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0005'\u0001@\b'\u0010\u0000\u0001A&\u0000\u0001B.\u0000\u0001C&\u0000\u0001D'\u0000\u0001E.\u0000\u0001F4\u0000\u0001G.\u0000\u0001H\u0012\u0000\u0003\u001e\u0002\u0000\n\u001e\u00015\u0002\u001e\u0001I\u0001\u0000\u0005\u001e\u0001\u0000\u000e\u001e\u0003\u0000\u0003 \u0002\u0000\n \u0001\u0000\u0002 \u0001J\u00015\u0005 \u0001\u0000\u000e \u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0002#\u0001K\u000b#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0003#\u0001L\n#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0007#\u0001M\u0006#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\n#\u0001N\u0003#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0002'\u0001O\u000b'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0003'\u0001P\n'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0007'\u0001Q\u0006'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\n'\u0001R\u0003'\u0012\u0000\u0001S&\u0000\u0001T2\u0000\u0001S\"\u0000\u0001U&\u0000\u0001V.\u0000\u0001W,\u0000\u0001X+\u0000\u0001Y\u001c\u0000\u0003\u001e\u0002\u0000\n\u001e\u0001Z\u0003\u001e\u0001\u0000\u0005\u001e\u0001\u0000\u000e\u001e\u0003\u0000\u0003 \u0002\u0000\n \u0001\u0000\u0003 \u0001Z\u0005 \u0001\u0000\u000e \u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0001[\u0002#\u0001\u0000\u0005#\u0001\u0000\u0003#\u0001\\\u0001]\t#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0006#\u0001%\u0007#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\b#\u0001^\u0005#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0003#\u0001_\n#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0001`\u0002'\u00018\u0005'\u0001\u0000\u0003'\u0001a\u0001b\t'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0006'\u0001)\u0007'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\b'\u0001c\u0005'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0003'\u0001d\n'\u0012\u0000\u0001e.\u0000\u0001e\u0015\u0000\u0001f8\u0000\u0001g3\u0000\u0001h*\u0000\u0001i\u0016\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\t#\u0001j\u0004#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0001[\u0002#\u0001\u0000\u0005#\u0001\u0000\u0004#\u0001]\t#\u0004\u0000\u0002#\u0002\u0000\n#\u0001k\u0003#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\b#\u0001l\u0005#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0004#\u0001m\t#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\t'\u0001n\u0004'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0001`\u0002'\u00018\u0005'\u0001\u0000\u0004'\u0001b\t'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u0001k\u0005'\u0001\u0000\u000e'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\b'\u0001o\u0005'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0004'\u0001p\t'\u0010\u0000\u0001q)\u0000\u0001r6\u0000\u0001s\u0013\u0000\u0002#\u0002\u0000\n#\u0001t\u0003#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002#\u0002\u0000\n#\u0001u\u0003#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0004#\u0001v\t#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u0001t\u0005'\u0001\u0000\u000e'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u0001u\u0005'\u0001\u0000\u000e'\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0004'\u0001w\t'\u0011\u0000\u0001x*\u0000\u0001y#\u0000\u0001z$\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u000b#\u0001{\u0002#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u000b'\u0001|\u0002'\u0001\u0000\u0001x\u0001}A\u0000\u0001~!\u0000\u0001\u007f\u001e\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\f#\u0001\u0080\u0001#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\f'\u0001\u0081\u0001'\u0001\u0000\u0001}*\u0000\u0001~\u0001\u00829\u0000\u0001\u0083\u001d\u0000\u0002#\u0002\u0000\n#\u00018\u0003#\u0001\u0000\u0005#\u0001\u0000\u0003#\u0001\u0084\n#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u00018\u0005'\u0001\u0000\u0003'\u0001\u0085\n'\u0001\u0000\u0001\u00825\u0000\u0001\u0086\"\u0000\u0002#\u0002\u0000\n#\u00018\u0001\u0087\u0002#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0001\u0088\u0002'\u00018\u0005'\u0001\u0000\u000e'\u0001\u0000\u0001\u0086\u0001\u0089,\u0000\u0002#\u0002\u0000\n#\u0001\u008a\u0003#\u0001\u0000\u0005#\u0001\u0000\u000e#\u0004\u0000\u0002'\u0002\u0000\n'\u0001\u0000\u0003'\u0001\u008a\u0005'\u0001\u0000\u000e'\u0001\u0000\u0001\u0089)\u0000";
    private String xmlEncoding;
    private boolean xmlStandalone;
    private boolean xmlStandaloneDeclared;
    private String xmlVersion;
    private boolean yy_atBOL;
    private boolean yy_atEOF;
    private char[] yy_buffer;
    private char[] yy_buffer_l;
    private int yy_currentPos;
    private int yy_currentPos_l;
    private int yy_endRead;
    private int yy_endRead_l;
    private int yy_lexical_state;
    private int yy_markedPos;
    private int yy_markedPos_l;
    private boolean yy_prev_sawCR;
    private int yy_pushbackPos;
    private Reader yy_reader;
    private char[] yy_saved_buffer;
    private boolean yy_sawCR;
    private int yy_startRead;
    private int yy_startRead_l;
    private int yy_state;
    private int yychar;
    private char[] yycmap_l;
    private int yycolumn;
    private int yycolumn_next;
    private int yyline;
    private int yyline_next;
    private static final String yycmap_packed = "\t\u0000\u0001\u0001\u0001\u0001\u0002\u0000\u0001\u0001\u0012\u0000\u0001\u0001\u0001\u0000\u0001\u0012\u0004\u0000\u0001\u0016\u0005\u0000\u0001 \u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0013\u0003\u0005\u0001(\u0001&\u0001\u0005\u0001!\u0001)\u0001\u0003\u0001\u0000\u0001\u0006\u0001\u0002\u0001\u001c\u0001\u0007\u0001\u0000\u0001#\u0001\u0004\u0001$\u0002\u0004\u0001\u001f\u0002\u0004\u0001%\u0005\u0004\u0001'\u0003\u0004\u0001\"\u0001\u001e\u0001\u001d\u0005\u0004\u0004\u0000\u0001\u0005\u0001\u0000\u0001\u001b\u0001\u0004\u0001\u0017\u0001\u0018\u0001\f\u0001\u0004\u0001\u0019\u0001\u0004\u0001\u000f\u0002\u0004\u0001\n\u0001\t\u0001\u0011\u0001\u0010\u0002\u0004\u0001\r\u0001\u000e\u0001\u001a\u0001\u0004\u0001\u000b\u0001\u0004\u0001\b\u0001*\u0001\u0004ﾅ\u0000";
    private static final char[] yycmap = yy_unpack_cmap(yycmap_packed);
    private static final int[] yy_rowMap = {0, 43, 86, 129, 172, FTPReply.NAME_SYSTEM_TYPE, JCameraView.BUTTON_STATE_ONLY_RECORDER, UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER, 344, 387, 344, NNTPReply.NO_SUCH_ARTICLE_FOUND, 473, 516, 559, 602, 645, 688, 731, 774, 817, 860, 903, NNTPReply.NO_SUCH_ARTICLE_FOUND, 473, 946, FTPSClient.DEFAULT_FTPS_DATA_PORT, AnalyticsListener.EVENT_DRM_SESSION_MANAGER_ERROR, 344, 1075, 1118, 1161, 1204, 602, 1247, 1290, 1333, 1376, 1419, 1462, 1505, 1548, 731, 1591, 1634, 1677, 1720, 860, 1763, 1806, 1849, 1892, 344, 1935, 1978, 344, 2021, 2064, 2107, 2150, 2193, 2236, 2279, 2322, 2365, 2408, 2451, 2494, 2537, 2580, 2623, 2666, 2709, 2752, 2795, 2838, 2881, 2924, 2967, 3010, 3053, 3096, 344, 3139, 3182, 3225, 3268, 3311, 3354, 344, 3397, 3440, 3483, 3526, 3569, 3612, 3655, 3698, 3741, 3784, 344, 3225, 3827, 3870, 3913, 3956, 344, 3999, 4042, 4085, 4128, 4171, 4214, 4257, 4300, 344, 344, 4343, 4386, 4429, 4472, 4515, 4558, 4601, 4644, 4687, 4730, 4773, 4816, 4859, 4902, 4945, 4988, 5031, 5074, 5117, 5160, 344};
    private static final int[] yytrans = yy_unpack();
    private static final String[] YY_ERROR_MSG = {"Unkown internal scanner error", "Internal error: unknown state", "Error: could not match input", "Error: pushback value was too large", "Error: skip value was too large"};
    private static final byte[] YY_ATTRIBUTE = {0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 2, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 5, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 9};

    public XMLDeclParser(char[] cArr, int i, int i2) throws IOException {
        this.yy_lexical_state = 0;
        this.yy_buffer = new char[0];
        this.yy_saved_buffer = null;
        this.yy_atBOL = true;
        this.xmlVersion = null;
        this.xmlEncoding = null;
        this.xmlStandalone = false;
        this.xmlStandaloneDeclared = false;
        this.yy_sawCR = false;
        this.yy_prev_sawCR = false;
        this.yyline_next = 0;
        this.yycolumn_next = 0;
        yyreset(cArr, i, i2);
    }

    public XMLDeclParser() {
        this.yy_lexical_state = 0;
        this.yy_buffer = new char[0];
        this.yy_saved_buffer = null;
        this.yy_atBOL = true;
        this.xmlVersion = null;
        this.xmlEncoding = null;
        this.xmlStandalone = false;
        this.xmlStandaloneDeclared = false;
        this.yy_sawCR = false;
        this.yy_prev_sawCR = false;
        this.yyline_next = 0;
        this.yycolumn_next = 0;
    }

    public void reset(char[] cArr, int i, int i2) throws IOException {
        this.xmlEncoding = null;
        this.xmlVersion = null;
        this.xmlStandalone = false;
        this.xmlStandaloneDeclared = false;
        yyreset(cArr, i, i2);
    }

    public String getXMLVersion() {
        return this.xmlVersion;
    }

    public String getXMLEncoding() {
        return this.xmlEncoding;
    }

    public boolean isXMLStandaloneDeclared() {
        return this.xmlStandaloneDeclared;
    }

    public boolean isXMLStandalone() {
        return this.xmlStandalone;
    }

    public int getCharsRead() {
        return this.yychar + yylength();
    }

    XMLDeclParser(Reader reader) {
        this.yy_lexical_state = 0;
        this.yy_buffer = new char[0];
        this.yy_saved_buffer = null;
        this.yy_atBOL = true;
        this.xmlVersion = null;
        this.xmlEncoding = null;
        this.xmlStandalone = false;
        this.xmlStandaloneDeclared = false;
        this.yy_sawCR = false;
        this.yy_prev_sawCR = false;
        this.yyline_next = 0;
        this.yycolumn_next = 0;
        this.yy_reader = reader;
    }

    XMLDeclParser(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
    }

    private static int[] yy_unpack() {
        int[] iArr = new int[5203];
        yy_unpack(yy_packed0, 0, iArr);
        return iArr;
    }

    private static int yy_unpack(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            int i5 = i4 + 1;
            int charAt2 = str.charAt(i4) - 1;
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i5;
            i = i2;
        }
        return i;
    }

    private static char[] yy_unpack_cmap(String str) {
        int i;
        char[] cArr = new char[65536];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 144) {
            int i4 = i2 + 1;
            int charAt = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i = i3 + 1;
                cArr[i3] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i3 = i;
            }
            i2 = i5;
            i3 = i;
        }
        return cArr;
    }

    private boolean yy_refill() throws IOException {
        int i = this.yy_startRead;
        if (i > 0) {
            char[] cArr = this.yy_buffer;
            System.arraycopy(cArr, i, cArr, 0, this.yy_endRead - i);
            int i2 = this.yy_endRead;
            int i3 = this.yy_startRead;
            this.yy_endRead = i2 - i3;
            this.yy_currentPos -= i3;
            this.yy_markedPos -= i3;
            this.yy_pushbackPos -= i3;
            this.yy_startRead = 0;
        }
        int i4 = this.yy_markedPos;
        char[] cArr2 = this.yy_buffer;
        if (i4 >= cArr2.length || this.yy_currentPos >= cArr2.length) {
            char[] cArr3 = new char[cArr2.length * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.yy_buffer = cArr3;
        }
        Reader reader = this.yy_reader;
        char[] cArr4 = this.yy_buffer;
        int i5 = this.yy_endRead;
        int read = reader.read(cArr4, i5, cArr4.length - i5);
        if (read < 0) {
            return true;
        }
        this.yy_endRead += read;
        return false;
    }

    public final void yyclose() throws IOException {
        this.yy_atEOF = true;
        this.yy_endRead = this.yy_startRead;
        Reader reader = this.yy_reader;
        if (reader != null) {
            reader.close();
        }
    }

    public final void yyreset(Reader reader) throws IOException {
        yyclose();
        char[] cArr = this.yy_saved_buffer;
        if (cArr != null) {
            this.yy_buffer = cArr;
            this.yy_saved_buffer = null;
        }
        this.yy_reader = reader;
        this.yy_atBOL = true;
        this.yy_atEOF = false;
        this.yy_startRead = 0;
        this.yy_endRead = 0;
        this.yy_pushbackPos = 0;
        this.yy_markedPos = 0;
        this.yy_currentPos = 0;
        this.yycolumn = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.yy_lexical_state = 0;
        this.yy_state = 0;
        this.yy_sawCR = false;
        this.yycolumn_next = 0;
        this.yyline_next = 0;
    }

    public final void yyreset(char[] cArr, int i, int i2) throws IOException {
        yyclose();
        if (this.yy_saved_buffer == null) {
            this.yy_saved_buffer = this.yy_buffer;
        }
        this.yy_buffer = cArr;
        this.yy_reader = null;
        this.yy_atBOL = true;
        this.yy_atEOF = true;
        this.yy_startRead = i;
        this.yy_pushbackPos = i;
        this.yy_markedPos = i;
        this.yy_currentPos = i;
        int i3 = i + i2;
        this.yy_endRead = i3;
        this.yycolumn = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.yy_lexical_state = 0;
        this.yy_state = 0;
        this.yy_sawCR = false;
        this.yycolumn_next = 0;
        this.yyline_next = 0;
        this.yy_endRead_l = i3;
        this.yy_buffer_l = cArr;
    }

    public final int yystate() {
        return this.yy_lexical_state;
    }

    public final void yybegin(int i) {
        this.yy_lexical_state = i;
    }

    public final String yytext() {
        char[] cArr = this.yy_buffer;
        int i = this.yy_startRead;
        return new String(cArr, i, this.yy_markedPos - i);
    }

    public final String yytext(int i, int i2) {
        return new String(this.yy_buffer, this.yy_startRead + i, i2);
    }

    public final void yynextAction() {
        this.yyline = this.yyline_next;
        this.yycolumn = this.yycolumn_next;
        int i = this.yy_markedPos;
        this.yy_startRead = i;
        this.yy_currentPos = i;
    }

    public final int yynextChar() throws IOException {
        char c;
        int i = this.yy_markedPos;
        if (i < this.yy_endRead) {
            char[] cArr = this.yy_buffer;
            this.yy_markedPos = i + 1;
            c = cArr[i];
        } else {
            if (this.yy_atEOF) {
                return -1;
            }
            boolean yy_refill = yy_refill();
            char[] cArr2 = this.yy_buffer;
            this.yy_buffer_l = cArr2;
            this.yy_endRead_l = this.yy_endRead;
            if (yy_refill) {
                return -1;
            }
            int i2 = this.yy_markedPos;
            this.yy_markedPos = i2 + 1;
            c = cArr2[i2];
        }
        yy_doCount(c);
        return c;
    }

    public final int yynextBufferChar() throws IOException {
        char[] cArr = this.yy_buffer;
        int i = this.yy_markedPos;
        this.yy_markedPos = i + 1;
        char c = cArr[i];
        yy_doCount(c);
        return c;
    }

    private final int yy_doCount(int i) {
        if (i != 10) {
            if (i == 13) {
                this.yyline_next++;
                this.yycolumn_next = 0;
                this.yy_sawCR = true;
            } else {
                this.yy_sawCR = false;
                this.yycolumn_next++;
            }
        } else if (this.yy_sawCR) {
            this.yy_sawCR = false;
        } else {
            this.yyline_next++;
            this.yycolumn_next = 0;
        }
        return i;
    }

    public final char yycharat(int i) {
        return this.yy_buffer[this.yy_startRead + i];
    }

    public final int yybufferLeft() {
        return this.yy_endRead - this.yy_markedPos;
    }

    public final void yyskip(int i) {
        int i2 = this.yy_markedPos + i;
        this.yy_markedPos = i2;
        this.yy_markedPos_l = i2;
        if (i2 > this.yy_endRead) {
            yy_ScanError(4);
        }
    }

    public final int yylength() {
        return this.yy_markedPos - this.yy_startRead;
    }

    private void yy_ScanError(int i) {
        String str;
        try {
            str = YY_ERROR_MSG[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = YY_ERROR_MSG[0];
        }
        throw new Error(str);
    }

    private void yypushback(int i) {
        if (i > yylength()) {
            yy_ScanError(3);
        }
        this.yy_markedPos -= i;
        this.yyline_next = this.yyline;
        this.yycolumn_next = this.yycolumn;
        this.yy_sawCR = this.yy_prev_sawCR;
        for (int i2 = this.yy_startRead; i2 < this.yy_markedPos; i2++) {
            yy_doCount(this.yy_buffer[i2]);
        }
    }

    public int parse() throws IOException, FileFormatException {
        char c;
        this.yy_endRead_l = this.yy_endRead;
        this.yy_buffer_l = this.yy_buffer;
        this.yycmap_l = yycmap;
        int[] iArr = yytrans;
        int[] iArr2 = yy_rowMap;
        byte[] bArr = YY_ATTRIBUTE;
        this.yy_pushbackPos = -1;
        int i = -1;
        while (true) {
            int i2 = this.yy_markedPos;
            this.yy_markedPos_l = i2;
            this.yychar += i2 - this.yy_startRead;
            this.yy_startRead = i2;
            this.yy_currentPos = i2;
            this.yy_currentPos_l = i2;
            this.yy_startRead_l = i2;
            this.yy_state = this.yy_lexical_state;
            int i3 = -1;
            boolean z = false;
            while (true) {
                int i4 = this.yy_currentPos_l;
                if (i4 < this.yy_endRead_l) {
                    char[] cArr = this.yy_buffer_l;
                    this.yy_currentPos_l = i4 + 1;
                    c = cArr[i4];
                } else if (this.yy_atEOF) {
                    c = 65535;
                } else {
                    this.yy_currentPos = i4;
                    this.yy_markedPos = this.yy_markedPos_l;
                    this.yy_pushbackPos = i;
                    boolean yy_refill = yy_refill();
                    int i5 = this.yy_currentPos;
                    this.yy_currentPos_l = i5;
                    this.yy_markedPos_l = this.yy_markedPos;
                    char[] cArr2 = this.yy_buffer;
                    this.yy_buffer_l = cArr2;
                    this.yy_endRead_l = this.yy_endRead;
                    int i6 = this.yy_pushbackPos;
                    if (yy_refill) {
                        c = 65535;
                        i = i6;
                    } else {
                        this.yy_currentPos_l = i5 + 1;
                        c = cArr2[i5];
                        i = i6;
                    }
                }
                int i7 = iArr[iArr2[this.yy_state] + this.yycmap_l[c]];
                if (i7 != -1) {
                    this.yy_state = i7;
                    byte b = bArr[i7];
                    if ((b & 2) == 2) {
                        i = this.yy_currentPos_l;
                    }
                    if ((b & 1) == 1) {
                        z = (b & 4) == 4;
                        this.yy_markedPos_l = this.yy_currentPos_l;
                        if ((b & 8) == 8) {
                            i3 = i7;
                        } else {
                            i3 = i7;
                        }
                    }
                }
            }
            this.yy_markedPos = this.yy_markedPos_l;
            if (z) {
                this.yy_markedPos = i;
            }
            if (i3 == 28) {
                return 1;
            }
            if (i3 == 52) {
                this.xmlVersion = yytext(1, yylength() - 2);
                yybegin(3);
            } else if (i3 == 55) {
                this.xmlEncoding = yytext(1, yylength() - 2);
                yybegin(5);
            } else if (i3 == 82) {
                this.xmlStandalone = false;
                yybegin(7);
            } else if (i3 == 89) {
                this.xmlVersion = "1.0";
                yybegin(3);
            } else if (i3 == 106) {
                this.xmlEncoding = "UTF-8";
                yybegin(5);
            } else if (i3 == 124) {
                yybegin(2);
            } else if (i3 == 129) {
                yybegin(4);
            } else if (i3 == 100) {
                this.xmlStandalone = true;
                yybegin(7);
            } else if (i3 == 101) {
                yybegin(1);
            } else if (i3 == 115) {
                this.xmlEncoding = "UTF-16";
                yybegin(5);
            } else if (i3 == 116) {
                this.xmlEncoding = "US-ASCII";
                yybegin(5);
            } else if (i3 == 136) {
                this.xmlStandaloneDeclared = true;
                yybegin(6);
            } else if (i3 != 137) {
                switch (i3) {
                    case 8:
                    case 9:
                        return -1;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        throw new FileFormatException("XML Declaration not well-formed", -1, -1);
                    default:
                        switch (i3) {
                            case 139:
                            case 140:
                            case 141:
                            case 142:
                            case 143:
                            case 144:
                            case 145:
                            case 146:
                            case 147:
                            case 148:
                            case 149:
                            case 150:
                            case 151:
                            case 152:
                            case 153:
                            case 154:
                                continue;
                            default:
                                if (c == 65535 && this.yy_startRead == this.yy_currentPos) {
                                    this.yy_atEOF = true;
                                    return -1;
                                }
                                yy_ScanError(2);
                                break;
                        }
                }
            } else {
                this.xmlEncoding = "ISO-8859-1";
                yybegin(5);
            }
        }
    }
}
