package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* loaded from: classes5.dex */
public class CommentsTable extends POIXMLDocumentPart {
    private Map<String, CTComment> commentRefs;
    private CTComments comments;

    public CommentsTable() {
        CTComments newInstance = CTComments.Factory.newInstance();
        this.comments = newInstance;
        newInstance.addNewCommentList();
        this.comments.addNewAuthors().addAuthor("");
    }

    public CommentsTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.comments = CommentsDocument.Factory.parse(inputStream).getComments();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CommentsDocument newInstance = CommentsDocument.Factory.newInstance();
        newInstance.setComments(this.comments);
        newInstance.save(outputStream, DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public void referenceUpdated(String str, CTComment cTComment) {
        Map<String, CTComment> map = this.commentRefs;
        if (map != null) {
            map.remove(str);
            this.commentRefs.put(cTComment.getRef(), cTComment);
        }
    }

    public int getNumberOfComments() {
        return this.comments.getCommentList().sizeOfCommentArray();
    }

    public int getNumberOfAuthors() {
        return this.comments.getAuthors().sizeOfAuthorArray();
    }

    public String getAuthor(long j) {
        return this.comments.getAuthors().getAuthorArray((int) j);
    }

    public int findAuthor(String str) {
        String[] authorArray = this.comments.getAuthors().getAuthorArray();
        for (int i = 0; i < authorArray.length; i++) {
            if (authorArray[i].equals(str)) {
                return i;
            }
        }
        return addNewAuthor(str);
    }

    public XSSFComment findCellComment(String str) {
        CTComment cTComment = getCTComment(str);
        if (cTComment == null) {
            return null;
        }
        return new XSSFComment(this, cTComment, null);
    }

    public CTComment getCTComment(String str) {
        if (this.commentRefs == null) {
            this.commentRefs = new HashMap();
            for (CTComment cTComment : this.comments.getCommentList().getCommentArray()) {
                this.commentRefs.put(cTComment.getRef(), cTComment);
            }
        }
        return this.commentRefs.get(str);
    }

    @Deprecated
    public CTComment newComment() {
        return newComment("A1");
    }

    public CTComment newComment(String str) {
        CTComment addNewComment = this.comments.getCommentList().addNewComment();
        addNewComment.setRef(str);
        addNewComment.setAuthorId(0L);
        Map<String, CTComment> map = this.commentRefs;
        if (map != null) {
            map.put(addNewComment.getRef(), addNewComment);
        }
        return addNewComment;
    }

    public boolean removeComment(String str) {
        CTCommentList commentList = this.comments.getCommentList();
        if (commentList != null) {
            CTComment[] commentArray = commentList.getCommentArray();
            for (int i = 0; i < commentArray.length; i++) {
                if (str.equals(commentArray[i].getRef())) {
                    commentList.removeComment(i);
                    Map<String, CTComment> map = this.commentRefs;
                    if (map == null) {
                        return true;
                    }
                    map.remove(str);
                    return true;
                }
            }
        }
        return false;
    }

    private int addNewAuthor(String str) {
        int sizeOfAuthorArray = this.comments.getAuthors().sizeOfAuthorArray();
        this.comments.getAuthors().insertAuthor(sizeOfAuthorArray, str);
        return sizeOfAuthorArray;
    }

    public CTComments getCTComments() {
        return this.comments;
    }
}
