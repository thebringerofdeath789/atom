package org.apache.poi.xssf.usermodel;

import androidx.core.net.MailTo;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.util.CellReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;

/* loaded from: classes5.dex */
public class XSSFHyperlink implements Hyperlink {
    private CTHyperlink _ctHyperlink;
    private PackageRelationship _externalRel;
    private String _location;
    private int _type;

    protected XSSFHyperlink(int i) {
        this._type = i;
        this._ctHyperlink = CTHyperlink.Factory.newInstance();
    }

    protected XSSFHyperlink(CTHyperlink cTHyperlink, PackageRelationship packageRelationship) {
        this._ctHyperlink = cTHyperlink;
        this._externalRel = packageRelationship;
        if (cTHyperlink.getLocation() != null) {
            this._type = 2;
            this._location = cTHyperlink.getLocation();
            return;
        }
        PackageRelationship packageRelationship2 = this._externalRel;
        if (packageRelationship2 == null) {
            if (cTHyperlink.getId() != null) {
                throw new IllegalStateException("The hyperlink for cell " + cTHyperlink.getRef() + " references relation " + cTHyperlink.getId() + ", but that didn't exist!");
            }
            this._type = 2;
            return;
        }
        String uri = packageRelationship2.getTargetURI().toString();
        this._location = uri;
        if (uri.startsWith("http://") || this._location.startsWith("https://") || this._location.startsWith("ftp://")) {
            this._type = 1;
        } else if (this._location.startsWith(MailTo.MAILTO_SCHEME)) {
            this._type = 3;
        } else {
            this._type = 4;
        }
    }

    public CTHyperlink getCTHyperlink() {
        return this._ctHyperlink;
    }

    public boolean needsRelationToo() {
        return this._type != 2;
    }

    protected void generateRelationIfNeeded(PackagePart packagePart) {
        if (this._externalRel == null && needsRelationToo()) {
            this._ctHyperlink.setId(packagePart.addExternalRelationship(this._location, XSSFRelation.SHEET_HYPERLINKS.getRelation()).getId());
        }
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public int getType() {
        return this._type;
    }

    public String getCellRef() {
        return this._ctHyperlink.getRef();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        return this._location;
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this._ctHyperlink.getDisplay();
    }

    public String getLocation() {
        return this._ctHyperlink.getLocation();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this._ctHyperlink.setDisplay(str);
    }

    public void setLocation(String str) {
        this._ctHyperlink.setLocation(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        validate(str);
        this._location = str;
        if (this._type == 2) {
            setLocation(str);
        }
    }

    private void validate(String str) {
        int i = this._type;
        if (i == 1 || i == 3 || i == 4) {
            try {
                new URI(str);
            } catch (URISyntaxException e) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Address of hyperlink must be a valid URI");
                illegalArgumentException.initCause(e);
                throw illegalArgumentException;
            }
        }
    }

    protected void setCellReference(String str) {
        this._ctHyperlink.setRef(str);
    }

    protected void setCellReference(CellReference cellReference) {
        setCellReference(cellReference.formatAsString());
    }

    private CellReference buildCellReference() {
        String ref = this._ctHyperlink.getRef();
        if (ref == null) {
            ref = "A1";
        }
        return new CellReference(ref);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstColumn() {
        return buildCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastColumn() {
        return buildCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstRow() {
        return buildCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastRow() {
        return buildCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstColumn(int i) {
        setCellReference(new CellReference(getFirstRow(), i));
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastColumn(int i) {
        setFirstColumn(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstRow(int i) {
        setCellReference(new CellReference(i, getFirstColumn()));
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastRow(int i) {
        setFirstRow(i);
    }

    public String getTooltip() {
        return this._ctHyperlink.getTooltip();
    }

    public void setTooltip(String str) {
        this._ctHyperlink.setTooltip(str);
    }
}
