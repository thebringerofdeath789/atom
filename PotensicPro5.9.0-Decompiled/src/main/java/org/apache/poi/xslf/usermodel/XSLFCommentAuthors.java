package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

/* loaded from: classes5.dex */
public class XSLFCommentAuthors extends POIXMLDocumentPart {
    private final CTCommentAuthorList _authors;

    XSLFCommentAuthors() {
        this._authors = CmAuthorLstDocument.Factory.newInstance().addNewCmAuthorLst();
    }

    XSLFCommentAuthors(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this._authors = CmAuthorLstDocument.Factory.parse(getPackagePart().getInputStream()).getCmAuthorLst();
    }

    public CTCommentAuthorList getCTCommentAuthorsList() {
        return this._authors;
    }

    public CTCommentAuthor getAuthorById(long j) {
        for (CTCommentAuthor cTCommentAuthor : this._authors.getCmAuthorArray()) {
            if (cTCommentAuthor.getId() == j) {
                return cTCommentAuthor;
            }
        }
        return null;
    }
}
