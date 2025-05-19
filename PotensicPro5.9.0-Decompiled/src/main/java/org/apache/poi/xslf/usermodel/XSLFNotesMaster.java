package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

/* loaded from: classes5.dex */
public class XSLFNotesMaster extends XSLFSheet {
    private CTNotesMaster _slide;
    private XSLFTheme _theme;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSheet getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "notesMaster";
    }

    XSLFNotesMaster() {
        this._slide = prototype();
    }

    protected XSLFNotesMaster(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTNotesMaster notesMaster = NotesMasterDocument.Factory.parse(getPackagePart().getInputStream()).getNotesMaster();
        this._slide = notesMaster;
        setCommonSlideData(notesMaster.getCSld());
    }

    private static CTNotesMaster prototype() {
        InputStream resourceAsStream = XSLFNotesMaster.class.getResourceAsStream("notesMaster.xml");
        try {
            if (resourceAsStream == null) {
                throw new POIXMLException("Missing resource 'notesMaster.xml'");
            }
            try {
                return NotesMasterDocument.Factory.parse(resourceAsStream).getNotesMaster();
            } finally {
                resourceAsStream.close();
            }
        } catch (Exception e) {
            throw new POIXMLException("Can't initialize NotesMaster", e);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesMaster getXmlObject() {
        return this._slide;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            Iterator<POIXMLDocumentPart> it = getRelations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                POIXMLDocumentPart next = it.next();
                if (next instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) next;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap != null) {
                        this._theme.initColorMap(clrMap);
                    }
                }
            }
        }
        return this._theme;
    }
}
