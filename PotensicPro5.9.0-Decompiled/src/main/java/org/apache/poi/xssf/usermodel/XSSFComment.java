package org.apache.poi.xssf.usermodel;

import java.math.BigInteger;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.CommentsTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import schemasMicrosoftComVml.CTShape;

/* loaded from: classes5.dex */
public class XSSFComment implements Comment {
    private final CTComment _comment;
    private final CommentsTable _comments;
    private XSSFRichTextString _str;
    private final CTShape _vmlShape;

    public XSSFComment(CommentsTable commentsTable, CTComment cTComment, CTShape cTShape) {
        this._comment = cTComment;
        this._comments = commentsTable;
        this._vmlShape = cTShape;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public String getAuthor() {
        return this._comments.getAuthor((int) this._comment.getAuthorId());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAuthor(String str) {
        this._comment.setAuthorId(this._comments.findAuthor(str));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getColumn() {
        return new CellReference(this._comment.getRef()).getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getRow() {
        return new CellReference(this._comment.getRef()).getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public boolean isVisible() {
        String style;
        CTShape cTShape = this._vmlShape;
        return (cTShape == null || (style = cTShape.getStyle()) == null || style.indexOf("visibility:visible") == -1) ? false : true;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setVisible(boolean z) {
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            cTShape.setStyle(z ? "position:absolute;visibility:visible" : "position:absolute;visibility:hidden");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setColumn(int i) {
        String ref = this._comment.getRef();
        this._comment.setRef(new CellReference(getRow(), i).formatAsString());
        this._comments.referenceUpdated(ref, this._comment);
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            cTShape.getClientDataArray(0).setColumnArray(new BigInteger[]{new BigInteger(String.valueOf(i))});
            this._vmlShape.getClientDataList().toString();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setRow(int i) {
        String ref = this._comment.getRef();
        this._comment.setRef(new CellReference(i, getColumn()).formatAsString());
        this._comments.referenceUpdated(ref, this._comment);
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            cTShape.getClientDataArray(0).setRowArray(0, new BigInteger(String.valueOf(i)));
            this._vmlShape.getClientDataList().toString();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public XSSFRichTextString getString() {
        if (this._str == null && this._comment.getText() != null) {
            this._str = new XSSFRichTextString(this._comment.getText());
        }
        return this._str;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setString(RichTextString richTextString) {
        if (!(richTextString instanceof XSSFRichTextString)) {
            throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
        }
        XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
        this._str = xSSFRichTextString;
        this._comment.setText(xSSFRichTextString.getCTRst());
    }

    public void setString(String str) {
        setString(new XSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public ClientAnchor getClientAnchor() {
        int[] iArr = new int[8];
        String[] split = this._vmlShape.getClientDataArray(0).getAnchorArray(0).split(",");
        int length = split.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            iArr[i2] = Integer.parseInt(split[i].trim());
            i++;
            i2++;
        }
        return new XSSFClientAnchor(iArr[1] * 9525, iArr[3] * 9525, iArr[5] * 9525, iArr[7] * 9525, iArr[0], iArr[2], iArr[4], iArr[6]);
    }

    protected CTComment getCTComment() {
        return this._comment;
    }

    protected CTShape getCTShape() {
        return this._vmlShape;
    }
}
