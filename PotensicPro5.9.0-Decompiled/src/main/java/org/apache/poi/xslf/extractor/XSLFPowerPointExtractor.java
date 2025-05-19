package org.apache.poi.xslf.extractor;

import java.io.IOException;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.DrawingParagraph;
import org.apache.poi.xslf.usermodel.DrawingTextBody;
import org.apache.poi.xslf.usermodel.DrawingTextPlaceholder;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
import org.apache.poi.xslf.usermodel.XSLFComments;
import org.apache.poi.xslf.usermodel.XSLFCommonSlideData;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;

/* loaded from: classes5.dex */
public class XSLFPowerPointExtractor extends POIXMLTextExtractor {
    public static final XSLFRelation[] SUPPORTED_TYPES = {XSLFRelation.MAIN, XSLFRelation.MACRO, XSLFRelation.MACRO_TEMPLATE, XSLFRelation.PRESENTATIONML, XSLFRelation.PRESENTATIONML_TEMPLATE, XSLFRelation.PRESENTATION_MACRO};
    private boolean masterByDefault;
    private boolean notesByDefault;
    private boolean slidesByDefault;
    private XMLSlideShow slideshow;

    public XSLFPowerPointExtractor(XMLSlideShow xMLSlideShow) {
        super(xMLSlideShow);
        this.slidesByDefault = true;
        this.notesByDefault = false;
        this.masterByDefault = false;
        this.slideshow = xMLSlideShow;
    }

    public XSLFPowerPointExtractor(XSLFSlideShow xSLFSlideShow) throws XmlException, IOException {
        this(new XMLSlideShow(xSLFSlideShow.getPackage()));
    }

    public XSLFPowerPointExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this(new XSLFSlideShow(oPCPackage));
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSLFPowerPointExtractor <filename.pptx>");
            System.exit(1);
        }
        XSLFPowerPointExtractor xSLFPowerPointExtractor = new XSLFPowerPointExtractor(new XSLFSlideShow(strArr[0]));
        System.out.println(xSLFPowerPointExtractor.getText());
        xSLFPowerPointExtractor.close();
    }

    public void setSlidesByDefault(boolean z) {
        this.slidesByDefault = z;
    }

    public void setNotesByDefault(boolean z) {
        this.notesByDefault = z;
    }

    public void setMasterByDefault(boolean z) {
        this.masterByDefault = z;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        return getText(this.slidesByDefault, this.notesByDefault);
    }

    public String getText(boolean z, boolean z2) {
        return getText(z, z2, this.masterByDefault);
    }

    public String getText(boolean z, boolean z2, boolean z3) {
        CTCommentAuthor authorById;
        StringBuffer stringBuffer = new StringBuffer();
        XSLFSlide[] slides = this.slideshow.getSlides();
        XSLFCommentAuthors commentAuthors = this.slideshow.getCommentAuthors();
        for (XSLFSlide xSLFSlide : slides) {
            try {
                XSLFNotes notes = xSLFSlide.getNotes();
                XSLFComments comments = xSLFSlide.getComments();
                XSLFSlideLayout slideLayout = xSLFSlide.getSlideLayout();
                XSLFSlideMaster slideMaster = slideLayout.getSlideMaster();
                if (z) {
                    extractText(xSLFSlide.getCommonSlideData(), false, stringBuffer);
                    if (z3) {
                        if (slideLayout != null) {
                            extractText(slideLayout.getCommonSlideData(), true, stringBuffer);
                        }
                        if (slideMaster != null) {
                            extractText(slideMaster.getCommonSlideData(), true, stringBuffer);
                        }
                    }
                    if (comments != null) {
                        for (CTComment cTComment : comments.getCTCommentsList().getCmArray()) {
                            if (commentAuthors != null && (authorById = commentAuthors.getAuthorById(cTComment.getAuthorId())) != null) {
                                stringBuffer.append(authorById.getName() + ": ");
                            }
                            stringBuffer.append(cTComment.getText());
                            stringBuffer.append("\n");
                        }
                    }
                }
                if (z2 && notes != null) {
                    extractText(notes.getCommonSlideData(), false, stringBuffer);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return stringBuffer.toString();
    }

    private void extractText(XSLFCommonSlideData xSLFCommonSlideData, boolean z, StringBuffer stringBuffer) {
        for (DrawingTextBody drawingTextBody : xSLFCommonSlideData.getDrawingText()) {
            if (!z || !(drawingTextBody instanceof DrawingTextPlaceholder) || ((DrawingTextPlaceholder) drawingTextBody).isPlaceholderCustom()) {
                for (DrawingParagraph drawingParagraph : drawingTextBody.getParagraphs()) {
                    stringBuffer.append(drawingParagraph.getText());
                    stringBuffer.append("\n");
                }
            }
        }
    }
}
