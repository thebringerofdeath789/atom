package org.apache.xmlbeans.impl.jam.xml;

import aavax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamService;
import org.apache.xmlbeans.impl.jam.JamServiceFactory;
import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.JamServiceImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;

/* loaded from: classes5.dex */
public class JamXmlUtils {
    private static final JamXmlUtils INSTANCE = new JamXmlUtils();

    public static final JamXmlUtils getInstance() {
        return INSTANCE;
    }

    private JamXmlUtils() {
    }

    public JamService createService(InputStream inputStream) throws IOException, XMLStreamException {
        if (inputStream == null) {
            throw new IllegalArgumentException("null stream");
        }
        JamServiceFactory jamServiceFactory = JamServiceFactory.getInstance();
        JamServiceParams createServiceParams = jamServiceFactory.createServiceParams();
        CachedClassBuilder cachedClassBuilder = new CachedClassBuilder();
        createServiceParams.addClassBuilder(cachedClassBuilder);
        JamService createService = jamServiceFactory.createService(createServiceParams);
        new JamXmlReader(cachedClassBuilder, inputStream, (ElementContext) createServiceParams).read();
        List asList = Arrays.asList(cachedClassBuilder.getClassNames());
        asList.addAll(Arrays.asList(createService.getClassNames()));
        String[] strArr = new String[asList.size()];
        asList.toArray(strArr);
        ((JamServiceImpl) createService).setClassNames(strArr);
        return createService;
    }

    public void toXml(JClass[] jClassArr, Writer writer) throws IOException, XMLStreamException {
        if (jClassArr == null) {
            throw new IllegalArgumentException("null classes");
        }
        if (writer == null) {
            throw new IllegalArgumentException("null writer");
        }
        JamXmlWriter jamXmlWriter = new JamXmlWriter(writer);
        jamXmlWriter.begin();
        for (JClass jClass : jClassArr) {
            jamXmlWriter.write(jClass);
        }
        jamXmlWriter.end();
    }
}
