package org.apache.poi.xslf.usermodel;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.XSLFSlideShow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

/* loaded from: classes5.dex */
public class XMLSlideShow extends POIXMLDocument {
    private static POILogger _logger = POILogFactory.getLogger((Class<?>) XMLSlideShow.class);
    private XSLFCommentAuthors _commentAuthors;
    private Map<String, XSLFSlideMaster> _masters;
    private XSLFNotesMaster _notesMaster;
    private List<XSLFPictureData> _pictures;
    private CTPresentation _presentation;
    private List<XSLFSlide> _slides;
    private XSLFTableStyles _tableStyles;

    public XMLSlideShow() {
        this(empty());
    }

    public XMLSlideShow(OPCPackage oPCPackage) {
        super(oPCPackage);
        try {
            if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
                rebase(getPackage());
            }
            load(XSLFFactory.getInstance());
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    public XMLSlideShow(InputStream inputStream) throws IOException {
        this(PackageHelper.open(inputStream));
    }

    static final OPCPackage empty() {
        InputStream resourceAsStream = XMLSlideShow.class.getResourceAsStream("empty.pptx");
        if (resourceAsStream == null) {
            throw new RuntimeException("Missing resource 'empty.pptx'");
        }
        try {
            return OPCPackage.open(resourceAsStream);
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Deprecated
    public XSLFSlideShow _getXSLFSlideShow() throws OpenXML4JException, IOException, XmlException {
        return new XSLFSlideShow(getPackage());
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            this._presentation = PresentationDocument.Factory.parse(getCorePart().getInputStream()).getPresentation();
            HashMap hashMap = new HashMap();
            this._masters = new HashMap();
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlide) {
                    hashMap.put(pOIXMLDocumentPart.getPackageRelationship().getId(), (XSLFSlide) pOIXMLDocumentPart);
                } else if (pOIXMLDocumentPart instanceof XSLFSlideMaster) {
                    this._masters.put(pOIXMLDocumentPart.getPackageRelationship().getId(), (XSLFSlideMaster) pOIXMLDocumentPart);
                } else if (pOIXMLDocumentPart instanceof XSLFTableStyles) {
                    this._tableStyles = (XSLFTableStyles) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
                    this._notesMaster = (XSLFNotesMaster) pOIXMLDocumentPart;
                } else if (pOIXMLDocumentPart instanceof XSLFCommentAuthors) {
                    this._commentAuthors = (XSLFCommentAuthors) pOIXMLDocumentPart;
                }
            }
            this._slides = new ArrayList();
            if (this._presentation.isSetSldIdLst()) {
                for (CTSlideIdListEntry cTSlideIdListEntry : this._presentation.getSldIdLst().getSldIdArray()) {
                    XSLFSlide xSLFSlide = (XSLFSlide) hashMap.get(cTSlideIdListEntry.getId2());
                    if (xSLFSlide == null) {
                        _logger.log(5, "Slide with r:id " + cTSlideIdListEntry.getId() + " was defined, but didn't exist in package, skipping");
                    } else {
                        this._slides.add(xSLFSlide);
                    }
                }
            }
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        HashMap hashMap = new HashMap();
        hashMap.put(STRelationshipId.type.getName().getNamespaceURI(), InternalZipConstants.READ_MODE);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this._presentation.save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        return Collections.unmodifiableList(getPackage().getPartsByName(Pattern.compile("/ppt/embeddings/.*?")));
    }

    public List<XSLFPictureData> getAllPictures() {
        if (this._pictures == null) {
            List<PackagePart> partsByName = getPackage().getPartsByName(Pattern.compile("/ppt/media/.*?"));
            this._pictures = new ArrayList(partsByName.size());
            Iterator<PackagePart> it = partsByName.iterator();
            while (it.hasNext()) {
                this._pictures.add(new XSLFPictureData(it.next(), null));
            }
        }
        return Collections.unmodifiableList(this._pictures);
    }

    public XSLFSlide createSlide(XSLFSlideLayout xSLFSlideLayout) {
        CTSlideIdList sldIdLst;
        int i = 1;
        int i2 = 256;
        if (this._presentation.isSetSldIdLst()) {
            sldIdLst = this._presentation.getSldIdLst();
            for (CTSlideIdListEntry cTSlideIdListEntry : sldIdLst.getSldIdArray()) {
                i2 = (int) Math.max(cTSlideIdListEntry.getId() + 1, i2);
                i++;
            }
        } else {
            sldIdLst = this._presentation.addNewSldIdLst();
        }
        XSLFSlide xSLFSlide = (XSLFSlide) createRelationship(XSLFRelation.SLIDE, XSLFFactory.getInstance(), i);
        CTSlideIdListEntry addNewSldId = sldIdLst.addNewSldId();
        addNewSldId.setId(i2);
        addNewSldId.setId2(xSLFSlide.getPackageRelationship().getId());
        xSLFSlideLayout.copyLayout(xSLFSlide);
        xSLFSlide.addRelation(xSLFSlideLayout.getPackageRelationship().getId(), xSLFSlideLayout);
        xSLFSlide.getPackagePart().addRelationship(xSLFSlideLayout.getPackagePart().getPartName(), TargetMode.INTERNAL, xSLFSlideLayout.getPackageRelationship().getRelationshipType());
        this._slides.add(xSLFSlide);
        return xSLFSlide;
    }

    public XSLFSlide createSlide() {
        XSLFSlideLayout layout = this._masters.get(this._presentation.getSldMasterIdLst().getSldMasterIdArray(0).getId2()).getLayout(SlideLayout.BLANK);
        if (layout == null) {
            throw new IllegalArgumentException("Blank layout was not found");
        }
        return createSlide(layout);
    }

    public XSLFNotes getNotesSlide(XSLFSlide xSLFSlide) {
        XSLFNotes notes = xSLFSlide.getNotes();
        return notes == null ? createNotesSlide(xSLFSlide) : notes;
    }

    private XSLFNotes createNotesSlide(XSLFSlide xSLFSlide) {
        if (this._notesMaster == null) {
            createNotesMaster();
        }
        XSLFNotes xSLFNotes = (XSLFNotes) createRelationship(XSLFRelation.NOTES, XSLFFactory.getInstance(), XSLFRelation.SLIDE.getFileNameIndex(xSLFSlide).intValue());
        xSLFNotes.addRelation(this._notesMaster.getPackageRelationship().getId(), this._notesMaster);
        xSLFNotes.getPackagePart().addRelationship(this._notesMaster.getPackagePart().getPartName(), TargetMode.INTERNAL, this._notesMaster.getPackageRelationship().getRelationshipType());
        xSLFSlide.addRelation(xSLFNotes.getPackageRelationship().getId(), xSLFNotes);
        xSLFSlide.getPackagePart().addRelationship(xSLFNotes.getPackagePart().getPartName(), TargetMode.INTERNAL, xSLFNotes.getPackageRelationship().getRelationshipType());
        xSLFNotes.addRelation(xSLFSlide.getPackageRelationship().getId(), xSLFSlide);
        xSLFNotes.getPackagePart().addRelationship(xSLFSlide.getPackagePart().getPartName(), TargetMode.INTERNAL, xSLFSlide.getPackageRelationship().getRelationshipType());
        xSLFNotes.importContent(this._notesMaster);
        return xSLFNotes;
    }

    public void createNotesMaster() {
        Integer num = 1;
        this._notesMaster = (XSLFNotesMaster) createRelationship(XSLFRelation.NOTES_MASTER, XSLFFactory.getInstance(), 1);
        this._presentation.addNewNotesMasterIdLst().addNewNotesMasterId().setId(this._notesMaster.getPackageRelationship().getId());
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFTheme) {
                arrayList.add(XSLFRelation.THEME.getFileNameIndex(pOIXMLDocumentPart));
            }
        }
        if (!arrayList.isEmpty()) {
            Boolean bool = false;
            Integer num2 = num;
            while (num.intValue() <= arrayList.size()) {
                if (!arrayList.contains(num)) {
                    bool = true;
                    num2 = num;
                }
                num = Integer.valueOf(num.intValue() + 1);
            }
            num = !bool.booleanValue() ? Integer.valueOf(arrayList.size() + 1) : num2;
        }
        XSLFTheme xSLFTheme = (XSLFTheme) createRelationship(XSLFRelation.THEME, XSLFFactory.getInstance(), num.intValue());
        xSLFTheme.importTheme(getSlides()[0].getTheme());
        this._notesMaster.addRelation(xSLFTheme.getPackageRelationship().getId(), xSLFTheme);
        this._notesMaster.getPackagePart().addRelationship(xSLFTheme.getPackagePart().getPartName(), TargetMode.INTERNAL, xSLFTheme.getPackageRelationship().getRelationshipType());
    }

    public XSLFNotesMaster getNotesMaster() {
        return this._notesMaster;
    }

    public XSLFSlideMaster[] getSlideMasters() {
        return (XSLFSlideMaster[]) this._masters.values().toArray(new XSLFSlideMaster[this._masters.size()]);
    }

    public XSLFSlide[] getSlides() {
        List<XSLFSlide> list = this._slides;
        return (XSLFSlide[]) list.toArray(new XSLFSlide[list.size()]);
    }

    public XSLFCommentAuthors getCommentAuthors() {
        return this._commentAuthors;
    }

    public void setSlideOrder(XSLFSlide xSLFSlide, int i) {
        int indexOf = this._slides.indexOf(xSLFSlide);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Slide not found");
        }
        if (indexOf == i) {
            return;
        }
        List<XSLFSlide> list = this._slides;
        list.add(i, list.remove(indexOf));
        CTSlideIdList sldIdLst = this._presentation.getSldIdLst();
        CTSlideIdListEntry[] sldIdArray = sldIdLst.getSldIdArray();
        CTSlideIdListEntry cTSlideIdListEntry = sldIdArray[indexOf];
        if (indexOf < i) {
            System.arraycopy(sldIdArray, indexOf + 1, sldIdArray, indexOf, i - indexOf);
        } else {
            System.arraycopy(sldIdArray, i, sldIdArray, i + 1, indexOf - i);
        }
        sldIdArray[i] = cTSlideIdListEntry;
        sldIdLst.setSldIdArray(sldIdArray);
    }

    public XSLFSlide removeSlide(int i) {
        XSLFSlide remove = this._slides.remove(i);
        removeRelation(remove);
        this._presentation.getSldIdLst().removeSldId(i);
        return remove;
    }

    public Dimension getPageSize() {
        CTSlideSize sldSz = this._presentation.getSldSz();
        return new Dimension((int) Units.toPoints(sldSz.getCx()), (int) Units.toPoints(sldSz.getCy()));
    }

    public void setPageSize(Dimension dimension) {
        CTSlideSize newInstance = CTSlideSize.Factory.newInstance();
        newInstance.setCx(Units.toEMU(dimension.getWidth()));
        newInstance.setCy(Units.toEMU(dimension.getHeight()));
        this._presentation.setSldSz(newInstance);
    }

    @Internal
    public CTPresentation getCTPresentation() {
        return this._presentation;
    }

    public int addPicture(byte[] bArr, int i) {
        XSLFPictureData findPictureData = findPictureData(bArr);
        POIXMLRelation pOIXMLRelation = XSLFPictureData.RELATIONS[i];
        if (findPictureData == null) {
            XSLFPictureData xSLFPictureData = (XSLFPictureData) createRelationship(XSLFPictureData.RELATIONS[i], XSLFFactory.getInstance(), this._pictures.size() + 1, true);
            this._pictures.add(xSLFPictureData);
            try {
                OutputStream outputStream = xSLFPictureData.getPackagePart().getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return this._pictures.size() - 1;
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }
        return this._pictures.indexOf(findPictureData);
    }

    XSLFPictureData findPictureData(byte[] bArr) {
        long calculateChecksum = IOUtils.calculateChecksum(bArr);
        for (XSLFPictureData xSLFPictureData : getAllPictures()) {
            if (xSLFPictureData.getChecksum() == calculateChecksum) {
                return xSLFPictureData;
            }
        }
        return null;
    }

    public XSLFTableStyles getTableStyles() {
        return this._tableStyles;
    }

    CTTextParagraphProperties getDefaultParagraphStyle(int i) {
        XmlObject[] selectPath = this._presentation.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:defaultTextStyle/a:lvl" + (i + 1) + "pPr");
        if (selectPath.length == 1) {
            return (CTTextParagraphProperties) selectPath[0];
        }
        return null;
    }
}
