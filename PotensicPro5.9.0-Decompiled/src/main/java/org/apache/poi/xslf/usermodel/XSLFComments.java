package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;

/* loaded from: classes5.dex */
public class XSLFComments extends POIXMLDocumentPart {
    private final CTCommentList _comments;

    XSLFComments() {
        this._comments = CmLstDocument.Factory.newInstance().addNewCmLst();
    }

    XSLFComments(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        this._comments = CmLstDocument.Factory.parse(getPackagePart().getInputStream()).getCmLst();
    }

    public CTCommentList getCTCommentsList() {
        return this._comments;
    }

    public int getNumberOfComments() {
        return this._comments.sizeOfCmArray();
    }

    public CTComment getCommentAt(int i) {
        return this._comments.getCmArray(i);
    }
}
