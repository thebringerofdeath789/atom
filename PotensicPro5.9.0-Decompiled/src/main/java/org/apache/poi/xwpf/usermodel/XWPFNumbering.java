package org.apache.poi.xwpf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

/* loaded from: classes5.dex */
public class XWPFNumbering extends POIXMLDocumentPart {
    protected List<XWPFAbstractNum> abstractNums;
    private CTNumbering ctNumbering;
    boolean isNew;
    protected List<XWPFNum> nums;

    public XWPFNumbering(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, OpenXML4JException {
        super(packagePart, packageRelationship);
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    public XWPFNumbering() {
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.abstractNums = new ArrayList();
        this.nums = new ArrayList();
        this.isNew = true;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            CTNumbering numbering = NumberingDocument.Factory.parse(getPackagePart().getInputStream()).getNumbering();
            this.ctNumbering = numbering;
            for (CTNum cTNum : numbering.getNumArray()) {
                this.nums.add(new XWPFNum(cTNum, this));
            }
            for (CTAbstractNum cTAbstractNum : this.ctNumbering.getAbstractNumArray()) {
                this.abstractNums.add(new XWPFAbstractNum(cTAbstractNum, this));
            }
            this.isNew = false;
        } catch (XmlException unused) {
            throw new POIXMLException();
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "numbering"));
        HashMap hashMap = new HashMap();
        hashMap.put(PackageNamespaces.MARKUP_COMPATIBILITY, "ve");
        hashMap.put("urn:schemas-microsoft-com:office:office", "o");
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        hashMap.put("urn:schemas-microsoft-com:vml", "v");
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        hashMap.put("urn:schemas-microsoft-com:office:word", "w10");
        hashMap.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        hashMap.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctNumbering.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public void setNumbering(CTNumbering cTNumbering) {
        this.ctNumbering = cTNumbering;
    }

    public boolean numExist(BigInteger bigInteger) {
        Iterator<XWPFNum> it = this.nums.iterator();
        while (it.hasNext()) {
            if (it.next().getCTNum().getNumId().equals(bigInteger)) {
                return true;
            }
        }
        return false;
    }

    public BigInteger addNum(XWPFNum xWPFNum) {
        this.ctNumbering.addNewNum();
        this.ctNumbering.setNumArray(this.ctNumbering.sizeOfNumArray() - 1, xWPFNum.getCTNum());
        this.nums.add(xWPFNum);
        return xWPFNum.getCTNum().getNumId();
    }

    public BigInteger addNum(BigInteger bigInteger) {
        CTNum addNewNum = this.ctNumbering.addNewNum();
        addNewNum.addNewAbstractNumId();
        addNewNum.getAbstractNumId().setVal(bigInteger);
        addNewNum.setNumId(BigInteger.valueOf(this.nums.size() + 1));
        this.nums.add(new XWPFNum(addNewNum, this));
        return addNewNum.getNumId();
    }

    public void addNum(BigInteger bigInteger, BigInteger bigInteger2) {
        CTNum addNewNum = this.ctNumbering.addNewNum();
        addNewNum.addNewAbstractNumId();
        addNewNum.getAbstractNumId().setVal(bigInteger);
        addNewNum.setNumId(bigInteger2);
        this.nums.add(new XWPFNum(addNewNum, this));
    }

    public XWPFNum getNum(BigInteger bigInteger) {
        for (XWPFNum xWPFNum : this.nums) {
            if (xWPFNum.getCTNum().getNumId().equals(bigInteger)) {
                return xWPFNum;
            }
        }
        return null;
    }

    public XWPFAbstractNum getAbstractNum(BigInteger bigInteger) {
        for (XWPFAbstractNum xWPFAbstractNum : this.abstractNums) {
            if (xWPFAbstractNum.getAbstractNum().getAbstractNumId().equals(bigInteger)) {
                return xWPFAbstractNum;
            }
        }
        return null;
    }

    public BigInteger getIdOfAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        XWPFAbstractNum xWPFAbstractNum2 = new XWPFAbstractNum((CTAbstractNum) xWPFAbstractNum.getCTAbstractNum().copy(), this);
        for (int i = 0; i < this.abstractNums.size(); i++) {
            xWPFAbstractNum2.getCTAbstractNum().setAbstractNumId(BigInteger.valueOf(i));
            xWPFAbstractNum2.setNumbering(this);
            if (xWPFAbstractNum2.getCTAbstractNum().valueEquals(this.abstractNums.get(i).getCTAbstractNum())) {
                return xWPFAbstractNum2.getCTAbstractNum().getAbstractNumId();
            }
        }
        return null;
    }

    public BigInteger addAbstractNum(XWPFAbstractNum xWPFAbstractNum) {
        int size = this.abstractNums.size();
        if (xWPFAbstractNum.getAbstractNum() != null) {
            this.ctNumbering.addNewAbstractNum().set(xWPFAbstractNum.getAbstractNum());
        } else {
            this.ctNumbering.addNewAbstractNum();
            xWPFAbstractNum.getAbstractNum().setAbstractNumId(BigInteger.valueOf(size));
            this.ctNumbering.setAbstractNumArray(size, xWPFAbstractNum.getAbstractNum());
        }
        this.abstractNums.add(xWPFAbstractNum);
        return xWPFAbstractNum.getCTAbstractNum().getAbstractNumId();
    }

    public boolean removeAbstractNum(BigInteger bigInteger) {
        if (bigInteger.byteValue() >= this.abstractNums.size()) {
            return false;
        }
        this.ctNumbering.removeAbstractNum(bigInteger.byteValue());
        this.abstractNums.remove(bigInteger.byteValue());
        return true;
    }

    public BigInteger getAbstractNumID(BigInteger bigInteger) {
        XWPFNum num = getNum(bigInteger);
        if (num == null || num.getCTNum() == null || num.getCTNum().getAbstractNumId() == null) {
            return null;
        }
        return num.getCTNum().getAbstractNumId().getVal();
    }
}
