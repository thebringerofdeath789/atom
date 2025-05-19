package org.apache.poi.xslf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class XSLFRelation extends POIXMLRelation {
    private static final POILogger log = POILogFactory.getLogger((Class<?>) XSLFRelation.class);
    protected static final Map<String, XSLFRelation> _table = new HashMap();
    public static final XSLFRelation MAIN = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml", null, null, null);
    public static final XSLFRelation MACRO = new XSLFRelation("application/vnd.ms-powerpoint.slideshow.macroEnabled.main+xml", null, null, null);
    public static final XSLFRelation MACRO_TEMPLATE = new XSLFRelation("application/vnd.ms-powerpoint.template.macroEnabled.main+xml", null, null, null);
    public static final XSLFRelation PRESENTATIONML = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideshow.main+xml", null, null, null);
    public static final XSLFRelation PRESENTATIONML_TEMPLATE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.template.main+xml", null, null, null);
    public static final XSLFRelation PRESENTATION_MACRO = new XSLFRelation("application/vnd.ms-powerpoint.presentation.macroEnabled.main+xml", null, null, null);
    public static final XSLFRelation THEME_MANAGER = new XSLFRelation("application/vnd.openxmlformats-officedocument.themeManager+xml", null, null, null);
    public static final XSLFRelation NOTES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesSlide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesSlide", "/ppt/notesSlides/notesSlide#.xml", XSLFNotes.class);
    public static final XSLFRelation SLIDE = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slide", "/ppt/slides/slide#.xml", XSLFSlide.class);
    public static final XSLFRelation SLIDE_LAYOUT = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout", "/ppt/slideLayouts/slideLayout#.xml", XSLFSlideLayout.class);
    public static final XSLFRelation SLIDE_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster", "/ppt/slideMasters/slideMaster#.xml", XSLFSlideMaster.class);
    public static final XSLFRelation NOTES_MASTER = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.notesMaster+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/notesMaster", "/ppt/notesMasters/notesMaster#.xml", XSLFNotesMaster.class);
    public static final XSLFRelation COMMENTS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/ppt/comments/comment#.xml", XSLFComments.class);
    public static final XSLFRelation COMMENT_AUTHORS = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.commentAuthors+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/commentAuthors", "/ppt/commentAuthors.xml", XSLFCommentAuthors.class);
    public static final XSLFRelation HYPERLINK = new XSLFRelation(null, PackageRelationshipTypes.HYPERLINK_PART, null, null);
    public static final XSLFRelation THEME = new XSLFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/ppt/theme/theme#.xml", XSLFTheme.class);
    public static final XSLFRelation VML_DRAWING = new XSLFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/ppt/drawings/vmlDrawing#.vml", null);
    public static final XSLFRelation CHART = new XSLFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/ppt/charts/chart#.xml", XSLFChart.class);
    public static final XSLFRelation IMAGE_EMF = new XSLFRelation("image/x-emf", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.emf", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_WMF = new XSLFRelation("image/x-wmf", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wmf", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_PICT = new XSLFRelation(ContentTypes.IMAGE_PICT, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.pict", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_JPEG = new XSLFRelation("image/jpeg", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.jpeg", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_PNG = new XSLFRelation(ContentTypes.IMAGE_PNG, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.png", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_DIB = new XSLFRelation("image/dib", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.dib", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_GIF = new XSLFRelation(ContentTypes.IMAGE_GIF, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.gif", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_TIFF = new XSLFRelation(ContentTypes.IMAGE_TIFF, PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.tiff", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_EPS = new XSLFRelation("image/x-eps", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.eps", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_BMP = new XSLFRelation("image/x-ms-bmp", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.bmp", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_WPG = new XSLFRelation("image/x-wpg", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wpg", XSLFPictureData.class);
    public static final XSLFRelation IMAGE_WDP = new XSLFRelation("image/vnd.ms-photo", PackageRelationshipTypes.IMAGE_PART, "/ppt/media/image#.wdp", XSLFPictureData.class);
    public static final XSLFRelation IMAGES = new XSLFRelation(null, PackageRelationshipTypes.IMAGE_PART, null, null);
    public static final XSLFRelation TABLE_STYLES = new XSLFRelation("application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableStyles", "/ppt/tableStyles.xml", XSLFTableStyles.class);

    private XSLFRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        super(str, str2, str3, cls);
        if (cls != null) {
            Map<String, XSLFRelation> map = _table;
            if (map.containsKey(str2)) {
                return;
            }
            map.put(str2, this);
        }
    }

    public static XSLFRelation getInstance(String str) {
        return _table.get(str);
    }
}
