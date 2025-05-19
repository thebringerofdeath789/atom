package org.apache.poi.xslf.model.geom;

import com.ipotensic.baselib.share2.ShareContentType;
import java.io.InputStream;
import java.util.LinkedHashMap;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;

/* loaded from: classes5.dex */
public class PresetGeometries extends LinkedHashMap<String, CustomGeometry> {
    private static PresetGeometries _inst;

    private PresetGeometries() {
        try {
            InputStream resourceAsStream = XMLSlideShow.class.getResourceAsStream("presetShapeDefinitions.xml");
            try {
                read(resourceAsStream);
            } finally {
                resourceAsStream.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void read(InputStream inputStream) throws Exception {
        for (XmlObject xmlObject : XmlObject.Factory.parse(inputStream).selectPath(ShareContentType.FILE)) {
            String localName = xmlObject.getDomNode().getLocalName();
            CTCustomGeometry2D parse = CTCustomGeometry2D.Factory.parse(xmlObject.toString());
            if (containsKey(localName)) {
                System.out.println("Duplicate definoition of " + localName);
            }
            put(localName, new CustomGeometry(parse));
        }
    }

    public static PresetGeometries getInstance() {
        if (_inst == null) {
            _inst = new PresetGeometries();
        }
        return _inst;
    }
}
