package javax.xml.transform.sax;

import javax.xml.transform.Templates;
import org.xml.sax.ContentHandler;

/* loaded from: classes4.dex */
public interface TemplatesHandler extends ContentHandler {
    String getSystemId();

    Templates getTemplates();

    void setSystemId(String str);
}
