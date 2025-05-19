package org.apache.poi.poifs.crypt.dsig.facets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class EnvelopedSignatureFacet extends SignatureFacet {
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature"));
        arrayList.add(newTransform("http://www.w3.org/2001/10/xml-exc-c14n#"));
        list.add(newReference("", arrayList, null, null, null));
    }
}
