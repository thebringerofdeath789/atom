package org.apache.poi.poifs.crypt.dsig.facets;

import javax.xml.crypto.MarshalException;
import org.apache.xmlbeans.XmlException;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class Office2010SignatureFacet extends SignatureFacet {
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(Document document) throws MarshalException {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties");
        if (elementsByTagNameNS.getLength() != 1) {
            throw new MarshalException("no XAdES-BES extension present");
        }
        try {
            QualifyingPropertiesType parse = QualifyingPropertiesType.Factory.parse(elementsByTagNameNS.item(0));
            UnsignedPropertiesType unsignedProperties = parse.getUnsignedProperties();
            if (unsignedProperties == null) {
                unsignedProperties = parse.addNewUnsignedProperties();
            }
            if (unsignedProperties.getUnsignedSignatureProperties() == null) {
                unsignedProperties.addNewUnsignedSignatureProperties();
            }
            elementsByTagNameNS.item(0).getParentNode().replaceChild(document.importNode(parse.getDomNode().getFirstChild(), true), elementsByTagNameNS.item(0));
        } catch (XmlException e) {
            throw new MarshalException(e);
        }
    }
}
