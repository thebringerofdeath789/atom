package org.apache.xmlbeans.impl.piccolo.xml;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.Locale;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.DrawingSelectionRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes5.dex */
public class Piccolo implements Parser, Locator, XMLReader {
    public static final short CDATA = 257;
    public static final short CLOSE_TAG = 264;
    public static final short DTD_START = 267;
    public static final short DTD_START_SKIPEXTERNAL = 268;
    public static final short EMPTY_TAG = 265;
    public static final short ENTITY_REF = 293;
    public static final short EQ = 262;
    public static final short FIXED = 273;
    public static final short IMPLIED = 272;
    public static final short MODIFIER = 306;
    public static final short NAME = 260;
    public static final short OPEN_TAG = 263;
    public static final short PI = 259;
    public static final short PUBLIC = 270;
    public static final short REQUIRED = 271;
    public static final short SKIPPED_ENTITY_REF = 297;
    public static final short STRING = 261;
    public static final short SYSTEM = 269;
    public static final short TAG_END = 258;
    public static final short WHITESPACE = 266;
    public static final short XML_DOC_OR_TEXT_DECL = 317;
    public static final short XML_TEXT_DECL = 316;
    public static final short YYERRCODE = 256;
    static final short YYFINAL = 3;
    static final short YYMAXTOKEN = 317;
    static final int YYSTACKSIZE = 500;
    static final int YYTABLESIZE = 508;
    int attributeType;
    ContentHandler contentHandler;
    DeclHandler declHandler;
    DocumentEntity docEntity;
    DocumentHandler documentHandler;
    DTDHandler dtdHandler;
    String dtdName;
    String dtdPubID;
    String dtdSysID;
    ElementDefinition elementDefinition;
    ErrorHandler errorHandler;
    boolean fExternalGeneralEntities;
    boolean fExternalParameterEntities;
    boolean fLexicalParameterEntities;
    boolean fNamespacePrefixes;
    boolean fNamespaces;
    boolean fResolveDTDURIs;
    LexicalHandler lexHandler;
    PiccoloLexer lexer;
    StringBuffer modelBuffer;
    private char[] oneCharBuffer;
    boolean parsingInProgress;
    String pubID;
    int saxVersion;
    private StartLocator startLocator;
    int statemax;
    int stateptr;
    int stateptrmax;
    int[] statestk;
    String sysID;
    int valptr;
    String[] valstk;
    int yychar;
    boolean yydebug;
    int yyerrflag;
    String yylval;
    int yym;
    int yyn;
    int yynerrs;
    String yys;
    int yystate;
    String yytext;
    String yyval;
    static final short[] yylhs = {-1, 0, 0, 1, 1, 1, 5, 5, 3, 3, 3, 4, 4, 7, 7, 7, 8, 8, 9, 9, 2, 2, 2, 2, 2, 2, 12, 12, 14, 14, 10, 10, 10, 13, 13, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 15, 15, 20, 20, 21, 21, 22, 22, 16, 16, 16, 16, 16, 16, 18, 18, 17, 23, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 19, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 34, 34, 36, 36, 35, 35, 35, 35, 31, 31, 33, 33, 32, 32, 32, 32, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
    static final short[] yylen = {2, 4, 3, 1, 1, 0, 1, 1, 1, 3, 2, 2, 0, 1, 1, 1, 1, 2, 0, 1, 4, 3, 4, 3, 6, 2, 2, 4, 7, 9, 3, 3, 5, 3, 5, 0, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 3, 2, 3, 2, 0, 4, 7, 7, 11, 8, 8, 11, 7, 9, 4, 3, 0, 3, 5, 5, 5, 5, 7, 7, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 5, 7, 1, 5, 7, 1, 1, 1, 1, 6, 5, 10, 2, 2, 2, 2, 5, 5, 1, 4, 3, 3, 3, 2, 4, 2, 4, 2, 1, 1, 1, 0, 0, 4, 4, 5, 4, 2, 2, 2, 2, 2};
    static final short[] yydefred = {0, 3, 4, 0, 0, 14, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 8, 13, 0, 0, 15, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 2, 0, 25, 10, 0, 6, 7, 35, 0, 26, 35, 122, 119, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 9, EscherAggregate.ST_FLOWCHARTMANUALINPUT, 121, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 0, 120, 16, 30, 0, 0, 31, 0, 1, 11, 0, 0, 0, 21, 35, 0, 0, 0, 40, 36, 37, 38, 39, 41, 63, 0, 23, 0, 0, 0, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 0, 17, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 35, 51, 0, 0, 22, 27, EscherAggregate.ST_FLOWCHARTPREPARATION, EscherAggregate.ST_FLOWCHARTDOCUMENT, 0, EscherAggregate.ST_FLOWCHARTMULTIDOCUMENT, 0, 0, 0, 0, 32, 0, 0, 0, 0, 62, 0, 0, 0, 0, 16, 48, 50, 0, 0, 0, 0, 0, EscherAggregate.ST_FLOWCHARTTERMINATOR, 0, 0, 33, 0, 24, 0, 0, 0, 47, 49, 45, 46, 51, 0, 0, 0, 64, 61, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 88, 89, 0, 0, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 52, 0, 93, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, EscherAggregate.ST_FLOWCHARTDECISION, EscherAggregate.ST_FLOWCHARTPROCESS, EscherAggregate.ST_FLOWCHARTINPUTOUTPUT, 94, 95, 73, 0, 0, 74, 75, 76, 77, 78, 79, 80, 0, 0, 29, 53, 0, 54, 0, 0, 0, 0, 59, 0, 0, 0, 0, EscherAggregate.ST_CURVEDUPARROW, 0, 0, 0, 0, 0, 0, 85, 0, 0, 0, 0, 0, 56, 57, 0, 0, 0, EscherAggregate.ST_UTURNARROW, 0, EscherAggregate.ST_CURVEDRIGHTARROW, EscherAggregate.ST_CURVEDLEFTARROW, EscherAggregate.ST_CURVEDDOWNARROW, 0, 0, EscherAggregate.ST_ELLIPSERIBBON, 83, 0, 0, 71, 65, 67, 0, 72, 66, 68, 0, 0, 0, 60, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 90, 0, 98, 0, 0, 81, 0, 0, 69, 70, 55, 58, 0, 0, 0, 0, 0, 84, 82, 0, 92};
    static final short[] yydgoto = {3, 4, 12, 26, 23, 30, 18, 59, EscherAggregate.ST_CURVEDUPARROW, 46, 15, 27, 16, 79, 17, 60, 61, 62, 63, 64, 89, 90, EscherAggregate.ST_FLOWCHARTPREPARATION, 65, 92, 138, 202, EscherProperties.GEOTEXT__TIGHTORTRACK, EscherAggregate.ST_TEXTCASCADEUP, EscherAggregate.ST_TEXTSLANTDOWN, EscherAggregate.ST_TEXTCANUP, EscherAggregate.ST_ACCENTBORDERCALLOUT90, 190, 182, EscherAggregate.ST_SUN, EscherAggregate.ST_MOON, EscherAggregate.ST_BRACKETPAIR};
    static final short[] yysindex = {-120, 0, 0, 0, EscherAggregate.ST_ACCENTBORDERCALLOUT90, 0, 0, 0, 0, -213, -166, 0, -250, -248, EscherAggregate.ST_ACCENTBORDERCALLOUT90, 0, -10, -206, -119, -239, -188, -248, -250, 0, -248, 0, 0, -41, 0, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, EscherAggregate.ST_TEXTDEFLATETOP, -237, 0, InterfaceHdrRecord.sid, 0, 0, -194, -194, -194, 0, 0, -10, -223, -194, 0, 0, 0, 0, 0, 0, 0, -7, 0, 18, EscherAggregate.ST_CURVEDRIGHTARROW, EscherAggregate.ST_FLOWCHARTPREPARATION, 0, 127, 0, -194, -194, 0, -194, -194, -137, -146, -88, -54, 77, 0, 77, -194, -194, -209, 0, 0, -24, -194, 0, 0, 0, 0, EscherAggregate.ST_TEXTRINGINSIDE, 0, -108, -76, -53, -15, 0, -135, -117, -194, -79, 0, -194, 77, -66, -59, 0, 0, 0, 43, -139, -194, -147, -32, 0, -194, -194, 0, -194, 0, 204, ViewSourceRecord.sid, 232, 0, 0, 0, 0, 0, -264, -194, -194, 0, 0, 0, 15, 76, -194, -194, 210, -194, -194, -194, -133, -103, -86, 0, 0, -194, 0, 0, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_ACTIONBUTTONDOCUMENT, EscherAggregate.ST_ACTIONBUTTONDOCUMENT, -194, 0, 16, -235, 35, -194, -194, -192, 97, 92, 0, -103, 0, 0, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_CLOUDCALLOUT, -55, -55, 55, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_CLOUDCALLOUT, -194, -194, -194, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 0, 0, 0, 0, 0, 0, -194, -194, 0, 0, 0, 0, 0, 0, 0, -194, -194, 0, 0, -194, 0, 123, 130, -194, -194, 0, -194, -55, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_CLOUDCALLOUT, 0, -194, -194, -194, 49, -251, EscherAggregate.ST_FLOWCHARTTERMINATOR, 0, 135, -39, 44, EscherAggregate.ST_TEXTRINGOUTSIDE, 67, 0, 0, 68, 76, EscherAggregate.ST_TEXTARCHUPCURVE, 0, -28, 0, 0, 0, -194, -55, 0, 0, -194, -194, 0, 0, 0, -194, 0, 0, 0, -194, -194, -194, 0, 89, -194, -55, -194, 0, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 135, EscherAggregate.ST_CURVEDLEFTARROW, EscherAggregate.ST_FLOWCHARTPROCESS, 148, EscherAggregate.ST_TEXTCURVEUP, 0, 135, 0, -194, 65, 0, -194, -194, 0, 0, 0, 0, -194, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADELEFT, 119, EscherAggregate.ST_TEXTCIRCLEPOUR, 0, 0, 131, 0};
    static final short[] yyrindex = {191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, EscherProperties.LINESTYLE__LINETYPE, 0, 0, 52, 0, 0, 202, 0, EscherProperties.LINESTYLE__LINETYPE, 0, 0, EscherProperties.LINESTYLE__LINETYPE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, EscherAggregate.ST_TEXTDEFLATEINFLATEDEFLATE, 0, 0, 0, 208, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 0, 0, 0, -50, 0, -12, 193, 193, 0, 0, 0, 0, 202, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -153, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 208, 0, 0, -178, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 202, 0, 0, 0, 202, 0, 31, 160, 0, 0, 202, 0, 0, -25, -25, 0, 0, -178, 0, 0, 208, 0, 202, 202, 0, 0, 0, 0, 0, 0, 0, -13, 17, -263, EscherAggregate.ST_TEXTFADEUP, 0, 0, -263, -263, EscherAggregate.ST_ACTIONBUTTONMOVIE, -186, EscherAggregate.ST_ACTIONBUTTONMOVIE, 0, 0, 0, 0, 0, 0, 0, BookBoolRecord.sid, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 0, -164, 0, -258, -200, 0, EscherAggregate.ST_TEXTINFLATETOP, -164, -164, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 208, 0, 0, 0, 0, 0, 0, -124, 0, 0, 0, EscherAggregate.ST_TEXTINFLATETOP, BookBoolRecord.sid, 0, 0, 0, 0, 0, 0, 0, 0, 202, 202, 0, 42, BookBoolRecord.sid, 0, -252, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 176, 0, 0, BookBoolRecord.sid, EscherAggregate.ST_TEXTINFLATETOP, 0, 0, 0, 0, EscherAggregate.ST_TEXTINFLATETOP, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final short NDATA = 300;
    static final short[] yygindex = {0, 0, EscherProperties.LINESTYLE__LINEESTARTARROWLENGTH, NDATA, EscherProperties.GEOMETRY__ADJUST2VALUE, 27, 125, EscherProperties.GEOTEXT__TIGHTORTRACK, -19, -51, 0, 46, 0, 28, 0, 0, 0, 0, 0, 0, EscherProperties.FILL__SHAPEORIGINY, EscherProperties.FILL__SHADETYPE, 369, 0, 0, 0, 344, 66, 0, 370, 371, -130, -152, -128, EscherProperties.GEOTEXT__STRETCHCHARHEIGHT, -174, 267};
    public static final short RBRACKET_END = 281;
    public static final short DOUBLE_RBRACKET_END = 282;
    public static final short PERCENT = 283;
    public static final short ENUMERATION = 284;
    public static final short RPAREN = 275;
    public static final short NOTATION_START = 280;
    public static final short LBRACKET = 276;
    public static final short PIPE = 277;
    public static final short LPAREN = 274;
    public static final short ID = 286;
    public static final short ENTITY_DECL_START = 278;
    public static final short ATTLIST_START = 279;
    public static final short IDREF = 287;
    public static final short NOTATION = 285;
    public static final short IDREFS = 288;
    static final short[] yytable = {45, 48, EscherAggregate.ST_TEXTCIRCLEPOUR, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 217, 157, 191, EscherAggregate.ST_TEXTWAVE3, EscherAggregate.ST_CLOUDCALLOUT, 5, EscherAggregate.ST_TEXTBUTTONPOUR, 5, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 6, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 7, 8, EscherAggregate.ST_CLOUDCALLOUT, 8, EscherAggregate.ST_CLOUDCALLOUT, EscherAggregate.ST_TEXTCANDOWN, 76, 176, 99, 191, StreamIDRecord.sid, EscherProperties.GEOTEXT__REVERSEROWORDER, 43, EscherAggregate.ST_CURVEDDOWNARROW, 219, 220, 73, 80, 81, 82, EscherAggregate.ST_FLOWCHARTINPUTOUTPUT, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 44, 88, 91, 217, 120, EscherAggregate.ST_TEXTCANDOWN, 43, 176, EscherAggregate.ST_TEXTCURVEUP, EscherAggregate.ST_TEXTCURVEDOWN, 19, DBCellRecord.sid, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 216, 11, 32, 11, EscherAggregate.ST_CLOUDCALLOUT, 99, 100, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, EscherAggregate.ST_UTURNARROW, EscherAggregate.ST_CURVEDRIGHTARROW, 18, EscherProperties.GEOTEXT__HASTEXTEFFECT, 31, 219, 220, 206, EscherAggregate.ST_ELLIPSERIBBON2, 260, 71, 88, 33, 140, 43, 119, 73, EscherAggregate.ST_ELLIPSERIBBON2, 66, EscherAggregate.ST_ELLIPSERIBBON2, 43, 68, 18, 86, 87, 84, DBCellRecord.sid, 271, 216, 127, 47, 99, 129, 18, EscherAggregate.ST_TEXTDEFLATEBOTTOM, EscherAggregate.ST_TEXTDEFLATETOP, 20, 86, 87, EscherAggregate.ST_TEXTFADEUP, 18, 135, EscherAggregate.ST_BORDERCALLOUT90, 83, 85, EscherAggregate.ST_BRACEPAIR, 141, 19, EscherAggregate.ST_TEXTRINGINSIDE, 19, 210, EscherAggregate.ST_TEXTARCHDOWNCURVE, 204, 18, EscherAggregate.ST_ELLIPSERIBBON2, 18, EscherAggregate.ST_CLOUDCALLOUT, 208, 209, EscherAggregate.ST_TEXTWAVE4, 160, 73, 73, 19, 19, 19, 19, EscherAggregate.ST_TEXTINFLATETOP, 18, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADELEFT, 43, EscherAggregate.ST_FLOWCHARTDECISION, 73, ScenarioProtectRecord.sid, 222, 223, EscherAggregate.ST_FLOWCHARTTERMINATOR, 18, EscherAggregate.ST_ELLIPSERIBBON, 34, EscherAggregate.ST_CURVEDLEFTARROW, 35, 126, InterfaceHdrRecord.sid, 133, 36, 37, 38, 39, 18, EscherAggregate.ST_TEXTFADEDOWN, 18, 136, 137, 122, 19, EscherAggregate.ST_TEXTARCHUPCURVE, 146, 148, 73, 19, 234, 69, DrawingGroupRecord.sid, EscherAggregate.ST_TEXTSLANTUP, 134, 70, 72, 236, DrawingSelectionRecord.sid, 238, 134, EscherAggregate.ST_TEXTBUTTONPOUR, EscherAggregate.ST_ELLIPSERIBBON2, EscherAggregate.ST_TEXTDEFLATEINFLATEDEFLATE, 177, InterfaceEndRecord.sid, 40, 41, 73, 35, EscherAggregate.ST_CALLOUT90, 128, 42, ViewSourceRecord.sid, 228, 123, 35, MergeCellsRecord.sid, EscherAggregate.ST_ACCENTCALLOUT90, 259, 73, 232, 233, 262, 263, 1, 97, 2, 35, 35, 35, 35, 35, 266, 267, 177, EscherAggregate.ST_FLOWCHARTPROCESS, 269, 124, 272, 130, 214, 73, 73, 35, 35, 35, 131, 5, EscherAggregate.ST_ACCENTCALLOUT90, RBRACKET_END, 35, 35, DOUBLE_RBRACKET_END, PERCENT, 8, 139, 73, 35, ENUMERATION, 264, 42, 42, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 265, EscherProperties.GEOTEXT__STRETCHTOFITSHAPE, EscherAggregate.ST_FLOWCHARTMANUALINPUT, 51, 52, 53, 54, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS, 73, 5, 42, EscherAggregate.ST_CLOUDCALLOUT, 125, 257, 14, 258, 8, 73, 5, EscherAggregate.ST_CLOUDCALLOUT, 55, 56, 22, 24, 14, 8, 11, 57, 51, 52, 53, 24, 22, 58, 24, 43, 43, 51, 52, 53, 205, EscherAggregate.ST_ELLIPSERIBBON2, 161, 5, 67, 55, 56, 73, 43, EscherAggregate.ST_ELLIPSERIBBON2, 8, 11, 57, 93, 55, 56, 44, 44, 58, 207, 11, 57, 51, 52, 53, 94, 91, 58, 5, 44, 13, EscherProperties.GEOTEXT__CHARBOUNDINGBOX, 28, 29, 91, 8, 73, 35, 21, 55, 56, EscherProperties.GEOTEXT__SCALETEXTONPATH, EscherProperties.GEOTEXT__STRETCHCHARHEIGHT, EscherProperties.GEOTEXT__NOMEASUREALONGPATH, 35, 11, 57, 51, 52, 53, 239, 132, 58, EscherProperties.GEOTEXT__SMALLCAPSFONT, 255, RPAREN, 35, 35, 35, 73, 73, NOTATION_START, 5, EscherAggregate.ST_TEXTINFLATEBOTTOM, 55, 56, 17, 17, 73, 8, 11, 57, 35, 35, 35, 49, 212, 58, 50, 35, 35, 51, 52, 53, 211, 34, 35, 35, BookBoolRecord.sid, 73, LBRACKET, 36, 95, 38, 39, 73, PIPE, ExtendedFormatRecord.sid, 55, 56, 34, 73, 35, EscherProperties.GEOTEXT__HASTEXTEFFECT, 11, 57, 36, 230, 38, 39, 34, 58, 35, 273, 231, LPAREN, 36, EscherProperties.GEOTEXT__ROTATECHARACTERS, 38, 39, ID, EscherProperties.GEOTEXT__KERNCHARACTERS, LPAREN, 40, 41, 34, 268, 35, 256, 42, EscherProperties.GEOTEXT__BOLDFONT, 36, ENTITY_DECL_START, 38, 39, 73, ATTLIST_START, 96, 40, 41, EscherProperties.GEOTEXT__ITALICFONT, 252, 253, 187, 42, 188, 189, 98, 40, 41, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, IDREF, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, LPAREN, 42, NOTATION, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 73, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 74, 75, 121, 40, 41, 18, 5, 18, IDREFS, 42, 6, EscherProperties.GEOTEXT__REVERSEROWORDER, 7, 8, 9, 10, 5, 97, 12, 18, 5, 192, 5, 5, 5, 5, 18, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 73, EscherAggregate.ST_TEXTRINGOUTSIDE, 19, 18, EscherAggregate.ST_FLOWCHARTINTERNALSTORAGE, 18, 73, EscherAggregate.ST_TEXTDEFLATEINFLATE, 193, 77, 78, 18, 73, 16, 18, 77, 78, 25, 11, 194, 195, 196, 197, EscherAggregate.ST_ACTIONBUTTONDOCUMENT, EscherAggregate.ST_ACTIONBUTTONSOUND, EscherAggregate.ST_ACTIONBUTTONMOVIE, 201, 73, 5, 43, 77, 78, 77, 78, 73, EscherAggregate.ST_FLOWCHARTDOCUMENT, EscherAggregate.ST_FLOWCHARTMULTIDOCUMENT, 77, EscherAggregate.ST_TEXTBUTTONCURVE, EscherAggregate.ST_TEXTARCHDOWNPOUR, 203, EscherAggregate.ST_TEXTCASCADEDOWN, 156, 270, 261};
    public static final short EMPTY = 309;
    public static final short ANY = 310;
    public static final short COMMA = 312;
    public static final short COMMENT = 301;
    public static final short INCLUDE = 304;
    public static final short IGNORE = 305;
    public static final short PREFIXED_NAME = 298;
    public static final short UNPREFIXED_NAME = 299;
    public static final short PCDATA = 307;
    public static final short IGNORED_CONDITIONAL_START = 303;
    public static final short INTERNAL_ENTITY_REF = 295;
    public static final short EXTERNAL_ENTITY_REF = 296;
    public static final short XML_DOC_DECL = 315;
    public static final short ENTITY_END = 294;
    public static final short CONDITIONAL_START = 302;
    public static final short ELEMENT_DECL_START = 308;
    public static final short STAR = 311;
    public static final short QUESTION = 313;
    public static final short PLUS = 314;
    public static final short ENTITY = 289;
    public static final short ENTITIES = 290;
    public static final short NMTOKEN = 291;
    public static final short NMTOKENS = 292;
    static final short[] yycheck = {19, 20, 266, 266, EscherAggregate.ST_CALLOUT90, 135, EscherAggregate.ST_TEXTWAVE3, 135, 266, 259, LPAREN, 259, RPAREN, 263, PIPE, 265, 266, RPAREN, 266, PIPE, EscherAggregate.ST_TEXTCIRCLEPOUR, 258, EscherAggregate.ST_TEXTCIRCLEPOUR, RPAREN, 176, 177, PIPE, 266, 79, EscherAggregate.ST_ACCENTBORDERCALLOUT90, 182, 266, 51, 52, 53, 86, 87, LBRACKET, 57, 58, 214, 92, EscherAggregate.ST_TEXTSLANTUP, 266, EscherAggregate.ST_TEXTSLANTUP, EMPTY, ANY, 260, EscherAggregate.ST_CALLOUT90, COMMA, EscherAggregate.ST_CALLOUT90, COMMENT, 258, COMMENT, COMMA, 74, 75, 266, 77, 78, COMMA, COMMA, 16, DBCellRecord.sid, 216, NDATA, 266, EscherProperties.GEOTEXT__HASTEXTEFFECT, 41, 88, LBRACKET, 122, 266, 92, 266, RPAREN, 30, PIPE, 266, 33, 258, INCLUDE, IGNORE, 56, 214, 259, 214, EscherAggregate.ST_CLOUDCALLOUT, LBRACKET, RPAREN, EscherAggregate.ST_FLOWCHARTPROCESS, PIPE, EscherAggregate.ST_TEXTRINGOUTSIDE, EscherAggregate.ST_TEXTARCHUPCURVE, 260, INCLUDE, IGNORE, 148, LBRACKET, EscherAggregate.ST_FLOWCHARTMANUALINPUT, EscherAggregate.ST_TEXTBUTTONPOUR, 55, 56, EscherAggregate.ST_TEXTCASCADEUP, 123, 258, 125, 260, NDATA, 128, 161, RPAREN, COMMA, PIPE, 260, EscherAggregate.ST_TEXTDEFLATEINFLATE, EscherAggregate.ST_TEXTDEFLATEINFLATEDEFLATE, 136, 137, 266, 266, LPAREN, RPAREN, LBRACKET, PIPE, EscherAggregate.ST_TEXTARCHUPCURVE, COMMA, 146, EscherAggregate.ST_TEXTBUTTONCURVE, 266, 84, 266, EscherAggregate.ST_SUN, EscherAggregate.ST_MOON, EscherAggregate.ST_BRACKETPAIR, 89, 260, PERCENT, 257, LBRACKET, 259, 258, 193, DOUBLE_RBRACKET_END, 263, 264, 265, 266, COMMA, DOUBLE_RBRACKET_END, LPAREN, PREFIXED_NAME, UNPREFIXED_NAME, 261, PCDATA, 127, 128, 129, 266, COMMA, 211, 36, StreamIDRecord.sid, 266, IGNORED_CONDITIONAL_START, 40, 41, BookBoolRecord.sid, 219, 220, IGNORED_CONDITIONAL_START, LPAREN, 260, EscherAggregate.ST_TEXTARCHDOWNCURVE, 260, 194, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 266, 259, 266, 260, COMMENT, 202, 203, 261, 266, 206, LPAREN, EscherProperties.GEOTEXT__REVERSEROWORDER, 266, 210, 211, EscherProperties.GEOTEXT__TIGHTORTRACK, EscherProperties.GEOTEXT__STRETCHTOFITSHAPE, XML_DOC_DECL, 71, 317, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, RBRACKET_END, DOUBLE_RBRACKET_END, EscherProperties.GEOTEXT__SMALLCAPSFONT, 255, 260, 260, 258, 261, 260, LBRACKET, 266, 266, 266, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, LBRACKET, 259, LPAREN, 271, COMMENT, CONDITIONAL_START, LPAREN, RPAREN, 266, 258, 266, ELEMENT_DECL_START, NOTATION_START, EscherProperties.GEOTEXT__NOMEASUREALONGPATH, RBRACKET_END, DOUBLE_RBRACKET_END, 258, 253, LPAREN, 260, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, RBRACKET_END, 266, 266, 259, ENTITY_END, 258, 261, RPAREN, 4, PIPE, 266, 266, 259, 266, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 12, 13, 14, 266, COMMENT, CONDITIONAL_START, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, 21, 22, ELEMENT_DECL_START, 24, RBRACKET_END, DOUBLE_RBRACKET_END, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, 258, 258, 261, 259, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 266, ENTITY_END, 266, 266, COMMENT, CONDITIONAL_START, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, RBRACKET_END, DOUBLE_RBRACKET_END, ELEMENT_DECL_START, 258, COMMENT, CONDITIONAL_START, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, RBRACKET_END, 258, ELEMENT_DECL_START, 259, ENTITY_END, 4, 261, 316, 317, 266, 266, 266, 259, 12, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 271, 272, 273, 266, COMMENT, CONDITIONAL_START, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, RPAREN, DOUBLE_RBRACKET_END, ELEMENT_DECL_START, 260, 260, 263, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, 266, 266, 269, 259, 261, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, EMPTY, ANY, 266, 266, COMMENT, CONDITIONAL_START, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 21, 258, ELEMENT_DECL_START, 24, COMMENT, CONDITIONAL_START, ENTITY_DECL_START, ATTLIST_START, NOTATION_START, 261, 257, ELEMENT_DECL_START, 259, PCDATA, 266, 261, 263, 264, 265, 266, 266, 261, 258, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 257, 266, 259, COMMA, COMMENT, CONDITIONAL_START, 263, 258, 265, 266, 257, ELEMENT_DECL_START, 259, RPAREN, 258, PIPE, 263, RPAREN, 265, 266, RPAREN, 260, PIPE, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 257, STAR, 259, 258, COMMENT, 261, 263, 258, 265, 266, 266, 258, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 271, 272, 273, STAR, COMMENT, QUESTION, PLUS, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 257, RPAREN, 259, PIPE, COMMENT, 260, 263, 266, 265, 266, 269, 270, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, RPAREN, 259, PIPE, STAR, COMMENT, 263, PIPE, 265, 266, 267, 268, 259, RPAREN, 0, PIPE, 263, 257, 265, 266, 267, 268, 258, ENTITY_END, INTERNAL_ENTITY_REF, EXTERNAL_ENTITY_REF, 266, 261, 258, PCDATA, COMMENT, LBRACKET, 266, 261, LPAREN, 269, 270, RPAREN, 266, PCDATA, 260, 269, 270, 14, COMMENT, NOTATION, ID, IDREF, IDREFS, ENTITY, ENTITIES, NMTOKEN, NMTOKENS, 266, COMMENT, 266, 269, 270, 269, 270, 266, 88, 88, 269, 270, 134, 160, 135, 135, 259, EscherProperties.GEOTEXT__HASTEXTEFFECT};
    static final String[] yyname = {"end-of-file", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "CDATA", "TAG_END", "PI", "NAME", "STRING", "EQ", "OPEN_TAG", "CLOSE_TAG", "EMPTY_TAG", "WHITESPACE", "DTD_START", "DTD_START_SKIPEXTERNAL", "SYSTEM", "PUBLIC", "REQUIRED", "IMPLIED", "FIXED", "LPAREN", "RPAREN", "LBRACKET", "PIPE", "ENTITY_DECL_START", "ATTLIST_START", "NOTATION_START", "RBRACKET_END", "DOUBLE_RBRACKET_END", "PERCENT", "ENUMERATION", "NOTATION", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", XmlErrorCodes.NMTOKEN, "NMTOKENS", "ENTITY_REF", "ENTITY_END", "INTERNAL_ENTITY_REF", "EXTERNAL_ENTITY_REF", "SKIPPED_ENTITY_REF", "PREFIXED_NAME", "UNPREFIXED_NAME", "NDATA", "COMMENT", "CONDITIONAL_START", "IGNORED_CONDITIONAL_START", "INCLUDE", "IGNORE", "MODIFIER", "PCDATA", "ELEMENT_DECL_START", "EMPTY", "ANY", "STAR", "COMMA", "QUESTION", "PLUS", "XML_DOC_DECL", "XML_TEXT_DECL", "XML_DOC_OR_TEXT_DECL"};
    static final String[] yyrule = {"$accept : document", "document : xml_decl dtd body epilog", "document : xml_decl body epilog", "xml_decl : XML_DOC_DECL", "xml_decl : XML_DOC_OR_TEXT_DECL", "xml_decl :", "xml_text_decl : XML_TEXT_DECL", "xml_text_decl : XML_DOC_OR_TEXT_DECL", "body : EMPTY_TAG", "body : OPEN_TAG content CLOSE_TAG", "body : misc body", "epilog : misc epilog", "epilog :", "misc : WHITESPACE", "misc : PI", "misc : COMMENT", "ws : WHITESPACE", "ws : ws WHITESPACE", "opt_ws :", "opt_ws : ws", "dtd : DTD_START NAME opt_ws TAG_END", "dtd : dtd_only_internal_start dtd_content RBRACKET_END", "dtd : dtd_with_external xml_text_decl dtd_content ENTITY_END", "dtd : dtd_with_external dtd_content ENTITY_END", "dtd : DTD_START_SKIPEXTERNAL NAME ws external_id opt_ws TAG_END", "dtd : misc dtd", "dtd_with_external : dtd_with_external_start TAG_END", "dtd_with_external : dtd_with_external_start LBRACKET dtd_content RBRACKET_END", "dtd_with_external_start : DTD_START NAME ws SYSTEM ws STRING opt_ws", "dtd_with_external_start : DTD_START NAME ws PUBLIC ws STRING ws STRING opt_ws", "dtd_only_internal_start : DTD_START NAME LBRACKET", "dtd_only_internal_start : DTD_START_SKIPEXTERNAL NAME LBRACKET", "dtd_only_internal_start : DTD_START_SKIPEXTERNAL NAME ws external_id LBRACKET", "external_id : SYSTEM ws STRING", "external_id : PUBLIC ws STRING ws STRING", "dtd_content :", "dtd_content : dtd_content dtd_conditional", "dtd_content : dtd_content dtd_entity", "dtd_content : dtd_content dtd_attlist", "dtd_content : dtd_content dtd_notation", "dtd_content : dtd_content misc", "dtd_content : dtd_content dtd_element", "dtd_content : dtd_content INTERNAL_ENTITY_REF dtd_content", "dtd_content : dtd_content EXTERNAL_ENTITY_REF dtd_content", "dtd_content : dtd_content EXTERNAL_ENTITY_REF xml_text_decl dtd_content", "dtd_conditional : CONDITIONAL_START dtd_include dtd_content DOUBLE_RBRACKET_END", "dtd_conditional : CONDITIONAL_START dtd_ignore ignored_dtd_content DOUBLE_RBRACKET_END", "dtd_include : INCLUDE opt_ws LBRACKET", "dtd_include : ws dtd_include", "dtd_ignore : IGNORE opt_ws LBRACKET", "dtd_ignore : ws dtd_ignore", "ignored_dtd_content :", "ignored_dtd_content : ignored_dtd_content IGNORED_CONDITIONAL_START ignored_dtd_content DOUBLE_RBRACKET_END", "dtd_entity : ENTITY_DECL_START ws NAME ws STRING opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws NAME ws external_id opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws NAME ws external_id ws NDATA ws NAME opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME ws STRING opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME ws external_id opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME external_id ws NDATA ws NAME opt_ws TAG_END", "dtd_notation : NOTATION_START ws NAME ws external_id opt_ws TAG_END", "dtd_notation : NOTATION_START ws NAME ws PUBLIC ws STRING opt_ws TAG_END", "dtd_attlist : attlist_start att_def_list opt_ws TAG_END", "attlist_start : ATTLIST_START ws NAME", "att_def_list :", "att_def_list : att_def_list ws att_def", "att_def : PREFIXED_NAME ws att_type ws REQUIRED", "att_def : UNPREFIXED_NAME ws att_type ws REQUIRED", "att_def : PREFIXED_NAME ws att_type ws IMPLIED", "att_def : UNPREFIXED_NAME ws att_type ws IMPLIED", "att_def : PREFIXED_NAME ws att_type ws FIXED ws STRING", "att_def : UNPREFIXED_NAME ws att_type ws FIXED ws STRING", "att_def : PREFIXED_NAME ws att_type ws STRING", "att_def : UNPREFIXED_NAME ws att_type ws STRING", "att_type : CDATA", "att_type : ID", "att_type : IDREF", "att_type : IDREFS", "att_type : ENTITY", "att_type : ENTITIES", "att_type : NMTOKEN", "att_type : NMTOKENS", "att_type : LPAREN opt_ws word_list opt_ws RPAREN", "att_type : NOTATION ws LPAREN opt_ws word_list opt_ws RPAREN", "word_list : NAME", "word_list : word_list opt_ws PIPE opt_ws NAME", "dtd_element : ELEMENT_DECL_START ws NAME ws element_spec opt_ws TAG_END", "element_spec : EMPTY", "element_spec : ANY", "element_spec : element_spec_mixed", "element_spec : element_spec_children", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws RPAREN STAR", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws RPAREN", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws PIPE opt_ws word_list opt_ws RPAREN STAR", "element_spec_mixed : WHITESPACE element_spec_mixed", "element_spec_children : element_choice element_modifier", "element_spec_children : element_seq element_modifier", "element_spec_children : WHITESPACE element_spec_children", "element_cp_pipe_list : element_cp opt_ws PIPE opt_ws element_cp", "element_cp_pipe_list : element_cp opt_ws PIPE opt_ws element_cp_pipe_list", "element_cp_comma_list : element_cp", "element_cp_comma_list : element_cp opt_ws COMMA element_cp_comma_list", "element_cp : NAME element_modifier opt_ws", "element_cp : element_choice element_modifier opt_ws", "element_cp : element_seq element_modifier opt_ws", "element_cp : WHITESPACE element_cp", "element_choice : LPAREN element_cp_pipe_list opt_ws RPAREN", "element_choice : WHITESPACE element_choice", "element_seq : LPAREN element_cp_comma_list opt_ws RPAREN", "element_seq : WHITESPACE element_seq", "element_modifier : QUESTION", "element_modifier : STAR", "element_modifier : PLUS", "element_modifier :", "content :", "content : content INTERNAL_ENTITY_REF content ENTITY_END", "content : content EXTERNAL_ENTITY_REF content ENTITY_END", "content : content EXTERNAL_ENTITY_REF xml_text_decl content ENTITY_END", "content : content OPEN_TAG content CLOSE_TAG", "content : content EMPTY_TAG", "content : content PI", "content : content COMMENT", "content : content WHITESPACE", "content : content CDATA"};

    void debug(String str) {
        if (this.yydebug) {
            System.out.println(str);
        }
    }

    final void state_push(int i) {
        try {
            int i2 = this.stateptr + 1;
            this.stateptr = i2;
            this.statestk[i2] = i;
        } catch (ArrayIndexOutOfBoundsException unused) {
            int[] iArr = this.statestk;
            int length = iArr.length;
            int[] iArr2 = new int[length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            this.statestk = iArr2;
            iArr2[this.stateptr] = i;
        }
    }

    final int state_pop() {
        int[] iArr = this.statestk;
        int i = this.stateptr;
        this.stateptr = i - 1;
        return iArr[i];
    }

    final void state_drop(int i) {
        this.stateptr -= i;
    }

    final int state_peek(int i) {
        return this.statestk[this.stateptr - i];
    }

    final boolean init_stacks() {
        this.stateptr = -1;
        val_init();
        return true;
    }

    void dump_stacks(int i) {
        System.out.println(new StringBuffer().append("=index==state====value=     s:").append(this.stateptr).append("  v:").append(this.valptr).toString());
        for (int i2 = 0; i2 < i; i2++) {
            System.out.println(new StringBuffer().append(StringUtils.SPACE).append(i2).append("    ").append(this.statestk[i2]).append("      ").append(this.valstk[i2]).toString());
        }
        System.out.println("======================");
    }

    final void val_init() {
        this.yyval = new String();
        this.yylval = new String();
        this.valptr = -1;
    }

    final void val_push(String str) {
        try {
            int i = this.valptr + 1;
            this.valptr = i;
            this.valstk[i] = str;
        } catch (ArrayIndexOutOfBoundsException unused) {
            String[] strArr = this.valstk;
            int length = strArr.length;
            String[] strArr2 = new String[length * 2];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            this.valstk = strArr2;
            strArr2[this.valptr] = str;
        }
    }

    final String val_pop() {
        String[] strArr = this.valstk;
        int i = this.valptr;
        this.valptr = i - 1;
        return strArr[i];
    }

    final void val_drop(int i) {
        this.valptr -= i;
    }

    final String val_peek(int i) {
        return this.valstk[this.valptr - i];
    }

    public Piccolo() {
        this.statestk = new int[500];
        this.valstk = new String[500];
        this.documentHandler = null;
        this.dtdHandler = null;
        this.errorHandler = null;
        this.contentHandler = null;
        this.saxVersion = 0;
        this.attributeType = -1;
        this.modelBuffer = new StringBuffer(100);
        this.elementDefinition = null;
        this.pubID = null;
        this.sysID = null;
        this.dtdName = null;
        this.dtdPubID = null;
        this.dtdSysID = null;
        this.lexer = new PiccoloLexer(this);
        this.docEntity = new DocumentEntity();
        this.lexHandler = null;
        this.declHandler = null;
        this.parsingInProgress = false;
        this.fNamespaces = true;
        this.fNamespacePrefixes = false;
        this.fResolveDTDURIs = true;
        this.fExternalGeneralEntities = true;
        this.fExternalParameterEntities = true;
        this.fLexicalParameterEntities = true;
        this.oneCharBuffer = new char[1];
    }

    public Piccolo(Piccolo piccolo) {
        this.statestk = new int[500];
        this.valstk = new String[500];
        this.documentHandler = null;
        this.dtdHandler = null;
        this.errorHandler = null;
        this.contentHandler = null;
        this.saxVersion = 0;
        this.attributeType = -1;
        this.modelBuffer = new StringBuffer(100);
        this.elementDefinition = null;
        this.pubID = null;
        this.sysID = null;
        this.dtdName = null;
        this.dtdPubID = null;
        this.dtdSysID = null;
        this.lexer = new PiccoloLexer(this);
        this.docEntity = new DocumentEntity();
        this.lexHandler = null;
        this.declHandler = null;
        this.parsingInProgress = false;
        this.fNamespaces = true;
        this.fNamespacePrefixes = false;
        this.fResolveDTDURIs = true;
        this.fExternalGeneralEntities = true;
        this.fExternalParameterEntities = true;
        this.fLexicalParameterEntities = true;
        this.oneCharBuffer = new char[1];
        boolean z = piccolo.fNamespaces;
        this.fNamespaces = z;
        this.fNamespacePrefixes = piccolo.fNamespacePrefixes;
        this.fExternalGeneralEntities = piccolo.fExternalGeneralEntities;
        this.fExternalParameterEntities = piccolo.fExternalParameterEntities;
        this.fLexicalParameterEntities = piccolo.fLexicalParameterEntities;
        this.lexer.enableNamespaces(z);
        this.fResolveDTDURIs = piccolo.fResolveDTDURIs;
    }

    private void reset() {
        this.modelBuffer.setLength(0);
        this.dtdSysID = null;
        this.dtdPubID = null;
        this.dtdName = null;
        this.sysID = null;
        this.pubID = null;
        this.elementDefinition = null;
    }

    private void validateParseState() throws SAXException {
        if (!this.fNamespaces && !this.fNamespacePrefixes) {
            throw new FatalParsingException("The 'namespaces' and 'namespace-prefixes' features must not both be false");
        }
    }

    public void setDebug(boolean z) {
        this.yydebug = z;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws IOException, SAXException {
        try {
            try {
                try {
                    reset();
                    validateParseState();
                } catch (IllegalCharException e) {
                    reportFatalError(e.getMessage(), e);
                } catch (FatalParsingException e2) {
                    reportFatalError(e2.getMessage(), e2.getException());
                }
            } catch (FileFormatException e3) {
                reportFatalError(e3.getMessage(), e3);
            }
            try {
                this.docEntity.reset(inputSource);
                this.lexer.reset(this.docEntity);
                reportStartDocument();
                yyparse();
            } catch (Throwable th) {
                reportStartDocument();
                throw th;
            }
        } finally {
            reportEndDocument();
        }
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void parse(String str) throws IOException, SAXException {
        try {
            try {
                try {
                    reset();
                    validateParseState();
                } catch (IllegalCharException e) {
                    reportFatalError(e.getMessage(), e);
                } catch (FatalParsingException e2) {
                    reportFatalError(e2.getMessage(), e2.getException());
                }
            } catch (FileFormatException e3) {
                reportFatalError(e3.getMessage(), e3);
            }
            try {
                this.docEntity.reset(str);
                this.lexer.reset(this.docEntity);
                reportStartDocument();
                yyparse();
            } catch (Throwable th) {
                reportStartDocument();
                throw th;
            }
        } finally {
            reportEndDocument();
        }
    }

    @Override // org.xml.sax.Parser
    public void setDocumentHandler(DocumentHandler documentHandler) {
        this.documentHandler = documentHandler;
        if (documentHandler != null) {
            this.saxVersion = 1;
            this.fNamespaces = false;
            this.lexer.enableNamespaces(false);
            this.fNamespacePrefixes = true;
            this.documentHandler.setDocumentLocator(this);
            return;
        }
        this.saxVersion = 0;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        this.dtdHandler = dTDHandler;
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        this.lexer.entityManager.setResolver(entityResolver);
    }

    @Override // org.xml.sax.Parser, org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override // org.xml.sax.Parser
    public void setLocale(Locale locale) throws SAXException {
        if (!"en".equals(locale.getLanguage())) {
            throw new SAXException("Only English (EN) locales are supported");
        }
    }

    @Override // org.xml.sax.Locator
    public int getColumnNumber() {
        return this.lexer.getColumnNumber();
    }

    @Override // org.xml.sax.Locator
    public int getLineNumber() {
        return this.lexer.getLineNumber();
    }

    @Override // org.xml.sax.Locator
    public String getPublicId() {
        return this.lexer.getPublicID();
    }

    @Override // org.xml.sax.Locator
    public String getSystemId() {
        return this.lexer.getSystemID();
    }

    private class StartLocator implements Locator {
        @Override // org.xml.sax.Locator
        public String getPublicId() {
            return null;
        }

        @Override // org.xml.sax.Locator
        public String getSystemId() {
            return null;
        }

        private StartLocator() {
        }

        @Override // org.xml.sax.Locator
        public int getLineNumber() {
            return Piccolo.this.lexer.tokenStartLine;
        }

        @Override // org.xml.sax.Locator
        public int getColumnNumber() {
            return Piccolo.this.lexer.tokenStartColumn;
        }
    }

    public Locator getStartLocator() {
        if (this.startLocator == null) {
            this.startLocator = new StartLocator();
        }
        return this.startLocator;
    }

    public String getVersion() {
        return this.lexer.getVersion();
    }

    public String getEncoding() {
        return this.lexer.getEncoding();
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
        if (contentHandler != null) {
            if (this.saxVersion == 1) {
                this.fNamespaces = true;
                this.lexer.enableNamespaces(true);
                this.fNamespacePrefixes = false;
            }
            this.saxVersion = 2;
            this.contentHandler.setDocumentLocator(this);
            return;
        }
        this.saxVersion = 0;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        return this.lexer.entityManager.getResolver();
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) throws SAXNotSupportedException, SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces")) {
            return this.fNamespaces;
        }
        if (str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            return this.fNamespacePrefixes;
        }
        if (str.equals("http://xml.org/sax/features/external-general-entities")) {
            return this.fExternalGeneralEntities;
        }
        if (str.equals("http://xml.org/sax/features/external-parameter-entities")) {
            return this.fExternalGeneralEntities;
        }
        if (str.equals("http://xml.org/sax/features/lexical-handler/parameter-entities")) {
            return this.fLexicalParameterEntities;
        }
        if (str.equals("http://xml.org/sax/features/string-interning")) {
            return true;
        }
        if (str.equals("http://xml.org/sax/features/is-standalone")) {
            return this.docEntity.isStandalone();
        }
        if (str.equals("http://xml.org/sax/features/resolve-dtd-uris")) {
            return this.fResolveDTDURIs;
        }
        if (str.equals("http://xml.org/sax/features/use-attributes2") || str.equals("http://xml.org/sax/features/validation") || str.equals("http://xml.org/sax/features/use-locator2") || str.equals("http://xml.org/sax/features/use-entity2") || str.equals("http://xml.org/sax/features/use-locator2")) {
            return false;
        }
        throw new SAXNotRecognizedException(str);
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z) throws SAXNotSupportedException, SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces")) {
            if (this.parsingInProgress) {
                throw new SAXNotSupportedException("Can't change namespace settings while parsing");
            }
            this.fNamespaces = z;
            this.lexer.enableNamespaces(z);
            return;
        }
        if (str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            if (this.parsingInProgress) {
                throw new SAXNotSupportedException("Can't change namespace settings while parsing");
            }
            this.fNamespacePrefixes = z;
            return;
        }
        if (str.equals("http://xml.org/sax/features/external-general-entities")) {
            this.fExternalGeneralEntities = z;
            return;
        }
        if (str.equals("http://xml.org/sax/features/external-parameter-entities")) {
            this.fExternalParameterEntities = z;
            return;
        }
        if (str.equals("http://xml.org/sax/features/lexical-handler/parameter-entities")) {
            this.fLexicalParameterEntities = z;
            return;
        }
        if (str.equals("http://xml.org/sax/features/resolve-dtd-uris")) {
            this.fResolveDTDURIs = z;
            return;
        }
        if (str.equals("http://xml.org/sax/features/validation")) {
            if (z) {
                throw new SAXNotSupportedException("validation is not supported");
            }
            return;
        }
        if (str.equals("http://xml.org/sax/features/string-interning")) {
            if (!z) {
                throw new SAXNotSupportedException("strings are always internalized");
            }
        } else {
            if (!str.equals("http://xml.org/sax/features/use-attributes2") && !str.equals("http://xml.org/sax/features/validation") && !str.equals("http://xml.org/sax/features/use-locator2") && !str.equals("http://xml.org/sax/features/use-entity2") && !str.equals("http://xml.org/sax/features/use-locator2")) {
                throw new SAXNotRecognizedException(str);
            }
            if (z) {
                throw new SAXNotSupportedException(str);
            }
        }
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/declaration-handler")) {
            return this.declHandler;
        }
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            return this.lexHandler;
        }
        throw new SAXNotRecognizedException(str);
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals("http://xml.org/sax/properties/declaration-handler")) {
            try {
                this.declHandler = (DeclHandler) obj;
            } catch (ClassCastException unused) {
                throw new SAXNotSupportedException("property value is not a DeclHandler");
            }
        } else {
            if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
                try {
                    this.lexHandler = (LexicalHandler) obj;
                    return;
                } catch (ClassCastException unused2) {
                    throw new SAXNotSupportedException("property value is not a LexicalHandler");
                }
            }
            throw new SAXNotRecognizedException(str);
        }
    }

    void reportCdata() throws SAXException {
        reportCdata(this.lexer.cdataBuffer, this.lexer.cdataStart, this.lexer.cdataLength);
    }

    void reportCdata(char c) throws SAXException {
        char[] cArr = this.oneCharBuffer;
        cArr[0] = c;
        reportCdata(cArr, 0, 1);
    }

    void reportCdata(char[] cArr, int i, int i2) throws SAXException {
        int i3 = this.saxVersion;
        if (i3 == 1) {
            this.documentHandler.characters(cArr, i, i2);
        } else {
            if (i3 != 2) {
                return;
            }
            this.contentHandler.characters(cArr, i, i2);
        }
    }

    void reportWhitespace() throws SAXException {
        reportWhitespace(this.lexer.cdataBuffer, this.lexer.cdataStart, this.lexer.cdataLength);
    }

    void reportWhitespace(char[] cArr, int i, int i2) throws SAXException {
        int i3 = this.saxVersion;
        if (i3 == 1) {
            this.documentHandler.characters(cArr, i, i2);
        } else {
            if (i3 != 2) {
                return;
            }
            this.contentHandler.characters(cArr, i, i2);
        }
    }

    void reportError(String str) throws SAXException {
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.error(new SAXParseException(str, getPublicId(), getSystemId(), getLineNumber(), getColumnNumber()));
        }
    }

    void reportFatalError(String str) throws SAXException {
        reportFatalError(str, null);
    }

    void reportFatalError(String str, Exception exc) throws SAXException {
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            if (str != null) {
                str = new StringBuffer().append(str).append("\n").append(stringWriter.toString()).toString();
            } else {
                str = stringWriter.toString();
            }
        }
        SAXParseException sAXParseException = new SAXParseException(str, getPublicId(), getSystemId(), getLineNumber(), getColumnNumber(), exc);
        ErrorHandler errorHandler = this.errorHandler;
        if (errorHandler != null) {
            errorHandler.fatalError(sAXParseException);
            return;
        }
        throw sAXParseException;
    }

    void reportSkippedEntity(String str) throws SAXException {
        if (this.saxVersion == 2) {
            this.contentHandler.skippedEntity(str);
        }
    }

    void reportPI(String str, String str2) throws SAXException {
        int i = this.saxVersion;
        if (i == 1) {
            this.documentHandler.processingInstruction(str, str2);
        } else {
            if (i != 2) {
                return;
            }
            this.contentHandler.processingInstruction(str, str2);
        }
    }

    void reportUnparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        DTDHandler dTDHandler = this.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.unparsedEntityDecl(str, str2, resolveSystemID(str3), str4);
        }
    }

    void reportNotationDecl(String str, String str2, String str3) throws SAXException {
        DTDHandler dTDHandler = this.dtdHandler;
        if (dTDHandler != null) {
            dTDHandler.notationDecl(str, str2, resolveSystemID(str3));
        }
    }

    void reportStartTag(String str, String str2, String str3) throws SAXException {
        int i = this.saxVersion;
        if (i == 1) {
            this.documentHandler.startElement(str3, this.lexer.attribs);
        } else {
            if (i != 2) {
                return;
            }
            this.contentHandler.startElement(str, str2, str3, this.lexer.attribs);
        }
    }

    void reportEndTag(String str, String str2, String str3) throws SAXException {
        int i = this.saxVersion;
        if (i == 1) {
            this.documentHandler.endElement(str3);
        } else {
            if (i != 2) {
                return;
            }
            this.contentHandler.endElement(str, str2, str3);
        }
    }

    void reportStartPrefixMapping(String str, String str2) throws SAXException {
        if (this.saxVersion == 2) {
            this.contentHandler.startPrefixMapping(str, str2);
        }
    }

    void reportEndPrefixMapping(String str) throws SAXException {
        if (this.saxVersion == 2) {
            this.contentHandler.endPrefixMapping(str);
        }
    }

    void reportStartDocument() throws SAXException {
        this.parsingInProgress = true;
        int i = this.saxVersion;
        if (i == 1) {
            this.documentHandler.startDocument();
        } else {
            if (i != 2) {
                return;
            }
            this.contentHandler.startDocument();
        }
    }

    void reportEndDocument() throws SAXException {
        this.parsingInProgress = false;
        int i = this.saxVersion;
        if (i == 1) {
            this.documentHandler.endDocument();
        } else {
            if (i != 2) {
                return;
            }
            this.contentHandler.endDocument();
        }
    }

    void reportStartDTD(String str, String str2, String str3) throws SAXException {
        LexicalHandler lexicalHandler = this.lexHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startDTD(str, str2, str3);
        }
    }

    void reportEndDTD() throws SAXException {
        LexicalHandler lexicalHandler = this.lexHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endDTD();
        }
    }

    void reportStartEntity(String str) throws SAXException {
        if (this.lexHandler != null) {
            if (this.fLexicalParameterEntities || str.charAt(0) != '%') {
                this.lexHandler.startEntity(str);
            }
        }
    }

    void reportEndEntity(String str) throws SAXException {
        if (this.lexHandler != null) {
            if (this.fLexicalParameterEntities || str.charAt(0) != '%') {
                this.lexHandler.endEntity(str);
            }
        }
    }

    void reportStartCdata() throws SAXException {
        LexicalHandler lexicalHandler = this.lexHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
        }
    }

    void reportEndCdata() throws SAXException {
        LexicalHandler lexicalHandler = this.lexHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endCDATA();
        }
    }

    void reportComment(char[] cArr, int i, int i2) throws SAXException {
        LexicalHandler lexicalHandler = this.lexHandler;
        if (lexicalHandler != null) {
            lexicalHandler.comment(cArr, i, i2);
        }
    }

    private void addAttributeDefinition(String str, int i, int i2, String str2) throws SAXException, IOException {
        String str3;
        if (this.fNamespaces) {
            if (str == "xmlns" && str2 != null) {
                str2.intern();
            }
            str3 = str;
        } else {
            str3 = "";
        }
        saveAttributeDefinition("", str3, str, i, i2, str2);
    }

    private void addPrefixedAttributeDefinition(String str, int i, int i2, String str2) throws SAXException, IOException {
        String str3;
        String str4;
        if (this.fNamespaces) {
            int indexOf = str.indexOf(58);
            int length = str.length();
            str.getChars(0, length, this.lexer.cbuf, 0);
            String convert = this.lexer.stringConverter.convert(this.lexer.cbuf, 0, indexOf);
            int i3 = indexOf + 1;
            str4 = this.lexer.stringConverter.convert(this.lexer.cbuf, i3, length - i3);
            str3 = convert;
        } else {
            str3 = "";
            str4 = str3;
        }
        saveAttributeDefinition(str3, str4, str, i, i2, str2);
    }

    private void saveAttributeDefinition(String str, String str2, String str3, int i, int i2, String str4) throws SAXException, IOException {
        String valueTypeString;
        if (str4 != null) {
            if (i == 9 || i == 10) {
                try {
                    str4 = this.lexer.normalizeValue(str4);
                } catch (DuplicateKeyException unused) {
                    return;
                }
            }
            str4 = this.lexer.rescanAttributeValue(str4);
        }
        String str5 = str4;
        if (this.declHandler != null) {
            if (i == 2) {
                this.modelBuffer.insert(0, "NOTATION (");
                this.modelBuffer.append(PropertyUtils.MAPPED_DELIM2);
                valueTypeString = this.modelBuffer.toString();
            } else if (i == 1) {
                this.modelBuffer.insert(0, PropertyUtils.MAPPED_DELIM);
                this.modelBuffer.append(PropertyUtils.MAPPED_DELIM2);
                valueTypeString = this.modelBuffer.toString();
            } else {
                valueTypeString = AttributeDefinition.getValueTypeString(i);
            }
            this.declHandler.attributeDecl(this.elementDefinition.getName(), str3, valueTypeString, AttributeDefinition.getDefaultTypeString(i2), str5);
            this.modelBuffer.setLength(0);
        }
        this.elementDefinition.addAttribute(new AttributeDefinition(str, str2, str3, i, null, i2, str5));
    }

    private String resolveSystemID(String str) {
        if (!this.fResolveDTDURIs) {
            return str;
        }
        try {
            return EntityManager.resolveSystemID(this.docEntity.getSystemID(), str);
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    private int yylex() throws IOException, SAXException {
        try {
            int yylex = this.lexer.yylex();
            this.yylval = this.lexer.stringValue;
            this.lexer.stringValue = null;
            return yylex;
        } catch (IOException e) {
            while (this.lexer.currentEntity == null && this.lexer.entityStack.size() > 0) {
                PiccoloLexer piccoloLexer = this.lexer;
                piccoloLexer.currentEntity = (Entity) piccoloLexer.entityStack.pop();
                try {
                    if (this.lexer.yymoreStreams()) {
                        this.lexer.yypopStream();
                    }
                } catch (IOException unused) {
                }
            }
            throw e;
        } catch (SAXException e2) {
            while (this.lexer.currentEntity == null && this.lexer.entityStack.size() > 0) {
                PiccoloLexer piccoloLexer2 = this.lexer;
                piccoloLexer2.currentEntity = (Entity) piccoloLexer2.entityStack.pop();
                try {
                    if (this.lexer.yymoreStreams()) {
                        this.lexer.yypopStream();
                    }
                } catch (IOException unused2) {
                }
            }
            throw e2;
        }
    }

    void yyerror(String str) throws SAXException {
        if (this.yychar <= 0) {
            throw new FatalParsingException(new StringBuffer().append("Unexpected end of file after ").append(this.yylval).toString());
        }
        throw new FatalParsingException(new StringBuffer().append("Unexpected element: ").append(yyname[this.yychar]).toString());
    }

    void yylexdebug(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        String str = i2 <= 317 ? yyname[i2] : null;
        if (str == null) {
            str = "illegal-symbol";
        }
        debug(new StringBuffer().append("state ").append(i).append(", reading ").append(i2).append(" (").append(str).append(")").toString());
    }

    int yyparse() throws SAXException, IOException {
        init_stacks();
        this.yynerrs = 0;
        this.yyerrflag = 0;
        int i = -1;
        this.yychar = -1;
        this.yystate = 0;
        state_push(0);
        while (true) {
            this.yyn = yydefred[this.yystate];
            boolean z = true;
            while (true) {
                if (this.yyn == 0) {
                    if (this.yychar < 0) {
                        this.yychar = yylex();
                    }
                    short[] sArr = yysindex;
                    int i2 = this.yystate;
                    short s = sArr[i2];
                    this.yyn = s;
                    if (s != 0) {
                        int i3 = this.yychar;
                        int i4 = s + i3;
                        this.yyn = i4;
                        if (i4 >= 0 && i4 <= YYTABLESIZE && yycheck[i4] == i3) {
                            short s2 = yytable[i4];
                            this.yystate = s2;
                            state_push(s2);
                            val_push(this.yylval);
                            this.yychar = i;
                            int i5 = this.yyerrflag;
                            if (i5 > 0) {
                                this.yyerrflag = i5 - 1;
                            }
                            z = false;
                        }
                    }
                    short s3 = yyrindex[i2];
                    this.yyn = s3;
                    if (s3 != 0) {
                        int i6 = this.yychar;
                        int i7 = s3 + i6;
                        this.yyn = i7;
                        if (i7 >= 0 && i7 <= YYTABLESIZE && yycheck[i7] == i6) {
                            this.yyn = yytable[i7];
                            z = true;
                        }
                    }
                    if (this.yyerrflag == 0) {
                        yyerror("syntax error");
                        this.yynerrs++;
                    }
                    if (this.yyerrflag < 3) {
                        this.yyerrflag = 3;
                        while (true) {
                            short s4 = yysindex[state_peek(0)];
                            this.yyn = s4;
                            if (s4 != 0) {
                                int i8 = s4 + 256;
                                this.yyn = i8;
                                if (i8 >= 0 && i8 <= YYTABLESIZE && yycheck[i8] == 256) {
                                    short s5 = yytable[i8];
                                    this.yystate = s5;
                                    state_push(s5);
                                    val_push(this.yylval);
                                    z = false;
                                }
                            }
                            state_pop();
                            val_pop();
                        }
                    } else {
                        if (this.yychar == 0) {
                            return 1;
                        }
                        this.yychar = i;
                    }
                    this.yyn = yydefred[this.yystate];
                }
            }
            if (z) {
                short s6 = yylen[this.yyn];
                this.yym = s6;
                if (s6 > 0) {
                    this.yyval = val_peek(s6 - 1);
                }
                int i9 = this.yyn;
                if (i9 == 46) {
                    this.lexer.yybegin(21);
                } else if (i9 == 47) {
                    this.lexer.yybegin(21);
                } else if (i9 == 49) {
                    this.lexer.yybegin(28);
                } else if (i9 != 121) {
                    switch (i9) {
                        case 20:
                            this.dtdName = val_peek(2);
                            this.lexer.yybegin(0);
                            reportStartDTD(this.dtdName, null, null);
                            reportEndDTD();
                            break;
                        case 21:
                            this.lexer.yybegin(0);
                            reportEndDTD();
                            break;
                        case 22:
                            this.lexer.yybegin(0);
                            reportEndDTD();
                            break;
                        case 23:
                            this.lexer.yybegin(0);
                            reportEndDTD();
                            break;
                        case 24:
                            this.dtdName = val_peek(4);
                            this.lexer.yybegin(0);
                            reportStartDTD(this.dtdName, this.pubID, this.sysID);
                            reportEndDTD();
                            break;
                        default:
                            switch (i9) {
                                case 26:
                                    this.lexer.pushEntity("[dtd]", this.dtdPubID, this.dtdSysID, false, true);
                                    this.lexer.yybegin(21);
                                    break;
                                case 27:
                                    this.lexer.pushEntity("[dtd]", this.dtdPubID, this.dtdSysID, false, true);
                                    this.lexer.yybegin(21);
                                    break;
                                case 28:
                                    this.dtdName = this.lexer.normalizeValue(val_peek(5));
                                    this.dtdPubID = null;
                                    String normalizeValue = this.lexer.normalizeValue(val_peek(1));
                                    this.dtdSysID = normalizeValue;
                                    reportStartDTD(this.dtdName, this.dtdPubID, normalizeValue);
                                    break;
                                case 29:
                                    this.dtdName = val_peek(7);
                                    this.dtdPubID = this.lexer.normalizeValue(val_peek(3));
                                    String normalizeValue2 = this.lexer.normalizeValue(val_peek(1));
                                    this.dtdSysID = normalizeValue2;
                                    reportStartDTD(this.dtdName, this.dtdPubID, normalizeValue2);
                                    break;
                                case 30:
                                    String val_peek = val_peek(1);
                                    this.dtdName = val_peek;
                                    reportStartDTD(val_peek, null, null);
                                    break;
                                case 31:
                                    String val_peek2 = val_peek(1);
                                    this.dtdName = val_peek2;
                                    reportStartDTD(val_peek2, null, null);
                                    break;
                                case 32:
                                    String val_peek3 = val_peek(3);
                                    this.dtdName = val_peek3;
                                    reportStartDTD(val_peek3, this.pubID, this.sysID);
                                    break;
                                case 33:
                                    this.pubID = null;
                                    this.sysID = this.lexer.normalizeValue(val_peek(0));
                                    break;
                                case 34:
                                    this.pubID = this.lexer.normalizeValue(val_peek(2));
                                    this.sysID = this.lexer.normalizeValue(val_peek(0));
                                    break;
                                default:
                                    switch (i9) {
                                        case 53:
                                            this.lexer.entityManager.putInternal(val_peek(4), val_peek(2), 0);
                                            DeclHandler declHandler = this.declHandler;
                                            if (declHandler != null) {
                                                declHandler.internalEntityDecl(val_peek(4), val_peek(2));
                                                break;
                                            }
                                            break;
                                        case 54:
                                            try {
                                                this.lexer.entityManager.putExternal(this.lexer.currentEntity, val_peek(4), this.pubID, this.sysID, 0);
                                                DeclHandler declHandler2 = this.declHandler;
                                                if (declHandler2 != null) {
                                                    declHandler2.externalEntityDecl(val_peek(4), this.pubID, resolveSystemID(this.sysID));
                                                    break;
                                                }
                                            } catch (MalformedURLException e) {
                                                reportFatalError(new StringBuffer().append("Invalid system identifier: ").append(this.sysID).append("; ").append(e.getMessage()).toString());
                                                break;
                                            }
                                            break;
                                        case 55:
                                            try {
                                                this.lexer.entityManager.putUnparsed(this.lexer.currentEntity, val_peek(8), this.pubID, this.sysID, val_peek(2), 0);
                                                reportUnparsedEntityDecl(val_peek(8), this.pubID, this.sysID, val_peek(2));
                                                break;
                                            } catch (MalformedURLException e2) {
                                                reportFatalError(new StringBuffer().append("Invalid system identifier: ").append(this.sysID).append("; ").append(e2.getMessage()).toString());
                                                break;
                                            }
                                        case 56:
                                            this.lexer.entityManager.putInternal(val_peek(4), val_peek(2), 1);
                                            DeclHandler declHandler3 = this.declHandler;
                                            if (declHandler3 != null) {
                                                declHandler3.internalEntityDecl(new StringBuffer().append("%").append(val_peek(4)).toString(), val_peek(2));
                                                break;
                                            }
                                            break;
                                        case 57:
                                            try {
                                                this.lexer.entityManager.putExternal(this.lexer.currentEntity, val_peek(4), this.pubID, this.sysID, 1);
                                                DeclHandler declHandler4 = this.declHandler;
                                                if (declHandler4 != null) {
                                                    declHandler4.externalEntityDecl(new StringBuffer().append("%").append(val_peek(4)).toString(), this.pubID, resolveSystemID(this.sysID));
                                                    break;
                                                }
                                            } catch (MalformedURLException e3) {
                                                reportFatalError(new StringBuffer().append("Invalid system identifier: ").append(this.sysID).append("; ").append(e3.getMessage()).toString());
                                                break;
                                            }
                                            break;
                                        case 58:
                                            try {
                                                this.lexer.entityManager.putUnparsed(this.lexer.currentEntity, val_peek(7), this.pubID, this.sysID, val_peek(2), 1);
                                                reportUnparsedEntityDecl(val_peek(7), this.pubID, this.sysID, val_peek(2));
                                                break;
                                            } catch (MalformedURLException e4) {
                                                reportFatalError(new StringBuffer().append("Invalid system identifier: ").append(this.sysID).append("; ").append(e4.getMessage()).toString());
                                                break;
                                            }
                                        case 59:
                                            reportNotationDecl(val_peek(4), this.pubID, this.sysID);
                                            break;
                                        case 60:
                                            reportNotationDecl(val_peek(6), this.lexer.normalizeValue(val_peek(2)), null);
                                            break;
                                        case 61:
                                            this.lexer.defineElement(this.elementDefinition.getName(), this.elementDefinition);
                                            break;
                                        case 62:
                                            ElementDefinition element = this.lexer.getElement(val_peek(0));
                                            this.elementDefinition = element;
                                            if (element == null) {
                                                this.elementDefinition = new ElementDefinition(val_peek(0));
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (i9) {
                                                case 65:
                                                    this.lexer.yybegin(23);
                                                    addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 2, null);
                                                    break;
                                                case 66:
                                                    this.lexer.yybegin(23);
                                                    addAttributeDefinition(val_peek(4), this.attributeType, 2, null);
                                                    break;
                                                case 67:
                                                    this.lexer.yybegin(23);
                                                    addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 1, null);
                                                    break;
                                                case 68:
                                                    this.lexer.yybegin(23);
                                                    addAttributeDefinition(val_peek(4), this.attributeType, 1, null);
                                                    break;
                                                case 69:
                                                    this.lexer.yybegin(23);
                                                    addPrefixedAttributeDefinition(val_peek(6), this.attributeType, 3, val_peek(0));
                                                    break;
                                                case 70:
                                                    this.lexer.yybegin(23);
                                                    addAttributeDefinition(val_peek(6), this.attributeType, 3, val_peek(0));
                                                    break;
                                                case 71:
                                                    this.lexer.yybegin(23);
                                                    addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 0, val_peek(0));
                                                    break;
                                                case 72:
                                                    this.lexer.yybegin(23);
                                                    addAttributeDefinition(val_peek(4), this.attributeType, 0, val_peek(0));
                                                    break;
                                                case 73:
                                                    this.attributeType = 3;
                                                    break;
                                                case 74:
                                                    this.attributeType = 4;
                                                    break;
                                                case 75:
                                                    this.attributeType = 5;
                                                    break;
                                                case 76:
                                                    this.attributeType = 6;
                                                    break;
                                                case 77:
                                                    this.attributeType = 7;
                                                    break;
                                                case 78:
                                                    this.attributeType = 8;
                                                    break;
                                                case 79:
                                                    this.attributeType = 9;
                                                    break;
                                                case 80:
                                                    this.attributeType = 10;
                                                    break;
                                                case 81:
                                                    this.attributeType = 1;
                                                    break;
                                                case 82:
                                                    this.attributeType = 2;
                                                    break;
                                                case 83:
                                                    if (this.declHandler != null) {
                                                        this.modelBuffer.append(val_peek(0));
                                                        break;
                                                    }
                                                    break;
                                                case 84:
                                                    if (this.declHandler != null) {
                                                        this.modelBuffer.append('|');
                                                        this.modelBuffer.append(val_peek(0));
                                                        break;
                                                    }
                                                    break;
                                                case 85:
                                                    DeclHandler declHandler5 = this.declHandler;
                                                    if (declHandler5 != null) {
                                                        declHandler5.elementDecl(val_peek(4), val_peek(2));
                                                        break;
                                                    }
                                                    break;
                                                case 86:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "EMPTY";
                                                        break;
                                                    }
                                                    break;
                                                case 87:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "ANY";
                                                        break;
                                                    }
                                                    break;
                                                case 88:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 89:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 90:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "(#PCDATA)*";
                                                        break;
                                                    }
                                                    break;
                                                case 91:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "(#PCDATA)";
                                                        break;
                                                    }
                                                    break;
                                                case 92:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append("(#PCDATA|").append(this.modelBuffer.toString()).append(")*").toString();
                                                        break;
                                                    }
                                                    break;
                                                case 93:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 94:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(1)).append(val_peek(0)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 95:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(1)).append(val_peek(0)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 96:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 97:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(4)).append("|").append(val_peek(0)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 98:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(4)).append("|").append(val_peek(0)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 99:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 100:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(3)).append(",").append(val_peek(0)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 101:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(2)).append(val_peek(1)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 102:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(2)).append(val_peek(1)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 103:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append(val_peek(2)).append(val_peek(1)).toString();
                                                        break;
                                                    }
                                                    break;
                                                case 104:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 105:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append("(").append(val_peek(2)).append(")").toString();
                                                        break;
                                                    }
                                                    break;
                                                case 106:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 107:
                                                    if (this.declHandler != null) {
                                                        this.yyval = new StringBuffer().append("(").append(val_peek(2)).append(")").toString();
                                                        break;
                                                    }
                                                    break;
                                                case 108:
                                                    if (this.declHandler != null) {
                                                        this.yyval = val_peek(0);
                                                        break;
                                                    }
                                                    break;
                                                case 109:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "?";
                                                        break;
                                                    }
                                                    break;
                                                case 110:
                                                    if (this.declHandler != null) {
                                                        this.yyval = WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD;
                                                        break;
                                                    }
                                                    break;
                                                case 111:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "+";
                                                        break;
                                                    }
                                                    break;
                                                case 112:
                                                    if (this.declHandler != null) {
                                                        this.yyval = "";
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i9) {
                                                        case 114:
                                                            this.lexer.setTokenize(false);
                                                            break;
                                                        case 115:
                                                            this.lexer.setTokenize(false);
                                                            break;
                                                        case 116:
                                                            this.lexer.setTokenize(false);
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    reportWhitespace();
                }
                state_drop(this.yym);
                this.yystate = state_peek(0);
                val_drop(this.yym);
                short s7 = yylhs[this.yyn];
                this.yym = s7;
                int i10 = this.yystate;
                if (i10 == 0 && s7 == 0) {
                    this.yystate = 3;
                    state_push(3);
                    val_push(this.yyval);
                    if (this.yychar < 0) {
                        this.yychar = yylex();
                    }
                    if (this.yychar == 0) {
                        return 0;
                    }
                } else {
                    short s8 = yygindex[s7];
                    this.yyn = s8;
                    if (s8 != 0) {
                        int i11 = s8 + i10;
                        this.yyn = i11;
                        if (i11 >= 0 && i11 <= YYTABLESIZE && yycheck[i11] == i10) {
                            this.yystate = yytable[i11];
                            state_push(this.yystate);
                            val_push(this.yyval);
                        }
                    }
                    this.yystate = yydgoto[s7];
                    state_push(this.yystate);
                    val_push(this.yyval);
                }
                i = -1;
            }
        }
    }
}
