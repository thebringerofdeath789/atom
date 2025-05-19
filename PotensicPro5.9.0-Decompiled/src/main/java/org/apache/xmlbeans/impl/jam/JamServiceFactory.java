package org.apache.xmlbeans.impl.jam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.xmlbeans.impl.jam.internal.JamPrinter;
import org.apache.xmlbeans.impl.jam.provider.JamServiceFactoryImpl;

/* loaded from: classes5.dex */
public abstract class JamServiceFactory {
    private static final JamServiceFactory DEFAULT = new JamServiceFactoryImpl();

    public abstract JamClassLoader createJamClassLoader(ClassLoader classLoader);

    public abstract JamService createService(JamServiceParams jamServiceParams) throws IOException;

    public abstract JamServiceParams createServiceParams();

    public abstract JamClassLoader createSystemJamClassLoader();

    public static JamServiceFactory getInstance() {
        return DEFAULT;
    }

    protected JamServiceFactory() {
    }

    public static void main(String[] strArr) {
        try {
            JamServiceParams createServiceParams = getInstance().createServiceParams();
            for (String str : strArr) {
                createServiceParams.includeSourcePattern(new File[]{new File(".")}, str);
            }
            JamService createService = getInstance().createService(createServiceParams);
            JamPrinter newInstance = JamPrinter.newInstance();
            PrintWriter printWriter = new PrintWriter(System.out);
            JamClassIterator classes = createService.getClasses();
            while (classes.hasNext()) {
                printWriter.println("-------- ");
                newInstance.print(classes.nextClass(), printWriter);
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.flush();
        System.err.flush();
    }
}
