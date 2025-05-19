package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;

/* loaded from: classes5.dex */
public class XSLFTableStyles extends POIXMLDocumentPart implements Iterable<XSLFTableStyle> {
    private List<XSLFTableStyle> _styles;
    private CTTableStyleList _tblStyleLst;

    public XSLFTableStyles() {
    }

    public XSLFTableStyles(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTTableStyleList parse = CTTableStyleList.Factory.parse(getPackagePart().getInputStream());
        this._tblStyleLst = parse;
        CTTableStyle[] tblStyleArray = parse.getTblStyleArray();
        this._styles = new ArrayList(tblStyleArray.length);
        for (CTTableStyle cTTableStyle : tblStyleArray) {
            this._styles.add(new XSLFTableStyle(cTTableStyle));
        }
    }

    public CTTableStyleList getXmlObject() {
        return this._tblStyleLst;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableStyle> iterator() {
        return this._styles.iterator();
    }

    public List<XSLFTableStyle> getStyles() {
        return Collections.unmodifiableList(this._styles);
    }
}
