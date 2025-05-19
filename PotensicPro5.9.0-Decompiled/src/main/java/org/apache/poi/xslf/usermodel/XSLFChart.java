package org.apache.poi.xslf.usermodel;

import aavax.xml.namespace.QName;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

/* loaded from: classes5.dex */
public final class XSLFChart extends POIXMLDocumentPart {
    private CTChart chart;
    private CTChartSpace chartSpace;

    protected XSLFChart(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTChartSpace chartSpace = ChartSpaceDocument.Factory.parse(packagePart.getInputStream()).getChartSpace();
        this.chartSpace = chartSpace;
        this.chart = chartSpace.getChart();
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chart;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        HashMap hashMap = new HashMap();
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/main", "a");
        hashMap.put("http://schemas.openxmlformats.org/drawingml/2006/chart", "c");
        hashMap.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", InternalZipConstants.READ_MODE);
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.chartSpace.save(outputStream, xmlOptions);
        outputStream.close();
    }
}
