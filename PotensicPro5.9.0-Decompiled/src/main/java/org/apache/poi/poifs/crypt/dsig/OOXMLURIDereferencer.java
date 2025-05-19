package org.apache.poi.poifs.crypt.dsig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import javax.xml.crypto.Data;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.URIReference;
import javax.xml.crypto.URIReferenceException;
import javax.xml.crypto.XMLCryptoContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class OOXMLURIDereferencer implements URIDereferencer, SignatureConfig.SignatureConfigurable {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) OOXMLURIDereferencer.class);
    private URIDereferencer baseUriDereferencer;
    private SignatureConfig signatureConfig;

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }

    public Data dereference(URIReference uRIReference, XMLCryptoContext xMLCryptoContext) throws URIReferenceException {
        if (this.baseUriDereferencer == null) {
            this.baseUriDereferencer = this.signatureConfig.getSignatureFactory().getURIDereferencer();
        }
        Objects.requireNonNull(uRIReference, "URIReference cannot be null");
        Objects.requireNonNull(xMLCryptoContext, "XMLCrytoContext cannot be null");
        try {
            URI uri = new URI(uRIReference.getURI());
            PackagePart findPart = findPart(uri);
            if (findPart == null) {
                LOG.log(1, "cannot resolve, delegating to base DOM URI dereferencer", uri);
                return this.baseUriDereferencer.dereference(uRIReference, xMLCryptoContext);
            }
            try {
                InputStream inputStream = findPart.getInputStream();
                if (findPart.getPartName().toString().endsWith(".rels")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read();
                        if (read == -1) {
                            break;
                        }
                        if (read != 10 && read != 13) {
                            byteArrayOutputStream.write(read);
                        }
                    }
                    inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
                return new OctetStreamData(inputStream, uri.toString(), (String) null);
            } catch (IOException e) {
                throw new URIReferenceException("I/O error: " + e.getMessage(), e);
            }
        } catch (URISyntaxException e2) {
            throw new URIReferenceException("could not URL decode the uri: " + uRIReference.getURI(), e2);
        }
    }

    private PackagePart findPart(URI uri) {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "dereference", uri);
        String path = uri.getPath();
        if (path == null || "".equals(path)) {
            pOILogger.log(1, "illegal part name (expected)", uri);
            return null;
        }
        try {
            return this.signatureConfig.getOpcPackage().getPart(PackagingURIHelper.createPartName(path));
        } catch (InvalidFormatException unused) {
            LOG.log(5, "illegal part name (not expected)", uri);
            return null;
        }
    }
}
