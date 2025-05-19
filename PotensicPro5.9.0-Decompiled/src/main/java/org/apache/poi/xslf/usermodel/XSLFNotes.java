package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;

/* loaded from: classes5.dex */
public final class XSLFNotes extends XSLFSheet {
    private CTNotesSlide _notes;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "notes";
    }

    XSLFNotes() {
        CTNotesSlide prototype = prototype();
        this._notes = prototype;
        setCommonSlideData(prototype.getCSld());
    }

    XSLFNotes(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTNotesSlide notes = NotesDocument.Factory.parse(getPackagePart().getInputStream()).getNotes();
        this._notes = notes;
        setCommonSlideData(notes.getCSld());
    }

    private static CTNotesSlide prototype() {
        CTNotesSlide newInstance = CTNotesSlide.Factory.newInstance();
        newInstance.addNewCSld().addNewSpTree();
        return newInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesSlide getXmlObject() {
        return this._notes;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getMasterSheet().getTheme();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFNotesMaster getMasterSheet() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
                return (XSLFNotesMaster) pOIXMLDocumentPart;
            }
        }
        return null;
    }
}
