package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* loaded from: classes5.dex */
public class SharedStringsTable extends POIXMLDocumentPart {
    private static final XmlOptions options;
    private SstDocument _sstDoc;
    private int count;
    private final Map<String, Integer> stmap;
    private final List<CTRst> strings;
    private int uniqueCount;

    static {
        XmlOptions xmlOptions = new XmlOptions();
        options = xmlOptions;
        xmlOptions.put(XmlOptions.SAVE_INNER);
        xmlOptions.put(XmlOptions.SAVE_AGGRESSIVE_NAMESPACES);
        xmlOptions.put(XmlOptions.SAVE_USE_DEFAULT_NAMESPACE);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", "http://schemas.openxmlformats.org/spreadsheetml/2006/main"));
    }

    public SharedStringsTable() {
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        SstDocument newInstance = SstDocument.Factory.newInstance();
        this._sstDoc = newInstance;
        newInstance.addNewSst();
    }

    public SharedStringsTable(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException {
        super(packagePart, packageRelationship);
        this.strings = new ArrayList();
        this.stmap = new HashMap();
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            SstDocument parse = SstDocument.Factory.parse(inputStream);
            this._sstDoc = parse;
            CTSst sst = parse.getSst();
            this.count = (int) sst.getCount();
            this.uniqueCount = (int) sst.getUniqueCount();
            int i = 0;
            for (CTRst cTRst : sst.getSiArray()) {
                this.stmap.put(getKey(cTRst), Integer.valueOf(i));
                this.strings.add(cTRst);
                i++;
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    private String getKey(CTRst cTRst) {
        return cTRst.xmlText(options);
    }

    public CTRst getEntryAt(int i) {
        return this.strings.get(i);
    }

    public int getCount() {
        return this.count;
    }

    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public int addEntry(CTRst cTRst) {
        String key = getKey(cTRst);
        this.count++;
        if (this.stmap.containsKey(key)) {
            return this.stmap.get(key).intValue();
        }
        this.uniqueCount++;
        CTRst addNewSi = this._sstDoc.getSst().addNewSi();
        addNewSi.set(cTRst);
        int size = this.strings.size();
        this.stmap.put(key, Integer.valueOf(size));
        this.strings.add(addNewSi);
        return size;
    }

    public List<CTRst> getItems() {
        return this.strings;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveCDataLengthThreshold(SchemaType.SIZE_BIG_INTEGER);
        xmlOptions.setSaveCDataEntityCountThreshold(-1);
        CTSst sst = this._sstDoc.getSst();
        sst.setCount(this.count);
        sst.setUniqueCount(this.uniqueCount);
        this._sstDoc.save(outputStream, xmlOptions);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }
}
