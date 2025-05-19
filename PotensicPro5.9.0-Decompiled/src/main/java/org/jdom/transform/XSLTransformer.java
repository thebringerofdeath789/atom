package org.jdom.transform;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.jdom.Document;

/* loaded from: classes5.dex */
public class XSLTransformer {
    private static final String CVS_ID = "@(#) $RCSfile: XSLTransformer.java,v $ $Revision: 1.2 $ $Date: 2004/02/06 09:28:32 $ $Name: jdom_1_0 $";
    private Templates templates;

    private XSLTransformer(Source source) throws XSLTransformException {
        try {
            this.templates = TransformerFactory.newInstance().newTemplates(source);
        } catch (TransformerException e) {
            throw new XSLTransformException("Could not construct XSLTransformer", e);
        }
    }

    public XSLTransformer(String str) throws XSLTransformException {
        this(new StreamSource(str));
    }

    public XSLTransformer(InputStream inputStream) throws XSLTransformException {
        this(new StreamSource(inputStream));
    }

    public XSLTransformer(Reader reader) throws XSLTransformException {
        this(new StreamSource(reader));
    }

    public XSLTransformer(File file) throws XSLTransformException {
        this(new StreamSource(file));
    }

    public XSLTransformer(Document document) throws XSLTransformException {
        this(new JDOMSource(document));
    }

    public List transform(List list) throws XSLTransformException {
        JDOMSource jDOMSource = new JDOMSource(list);
        JDOMResult jDOMResult = new JDOMResult();
        try {
            this.templates.newTransformer().transform(jDOMSource, jDOMResult);
            return jDOMResult.getResult();
        } catch (TransformerException e) {
            throw new XSLTransformException("Could not perform transformation", e);
        }
    }

    public Document transform(Document document) throws XSLTransformException {
        JDOMSource jDOMSource = new JDOMSource(document);
        JDOMResult jDOMResult = new JDOMResult();
        try {
            this.templates.newTransformer().transform(jDOMSource, jDOMResult);
            return jDOMResult.getDocument();
        } catch (TransformerException e) {
            throw new XSLTransformException("Could not perform transformation", e);
        }
    }
}
