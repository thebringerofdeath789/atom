package org.apache.xmlbeans.impl.jam.provider;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.JamService;
import org.apache.xmlbeans.impl.jam.JamServiceFactory;
import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.apache.xmlbeans.impl.jam.internal.JamClassLoaderImpl;
import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
import org.apache.xmlbeans.impl.jam.internal.JamServiceImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.parser.ParserClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.reflect.ReflectClassBuilder;

/* loaded from: classes5.dex */
public class JamServiceFactoryImpl extends JamServiceFactory {
    private static final String PREFIX = "[JamServiceFactoryImpl]";
    public static final String USE_NEW_PARSER = "JamServiceFactoryImpl.use-new-parser";

    @Override // org.apache.xmlbeans.impl.jam.JamServiceFactory
    public JamServiceParams createServiceParams() {
        return new JamServiceContextImpl();
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceFactory
    public JamService createService(JamServiceParams jamServiceParams) throws IOException {
        if (!(jamServiceParams instanceof JamServiceContextImpl)) {
            throw new IllegalArgumentException("JamServiceParams must be instantiated by this JamServiceFactory.");
        }
        JamServiceContextImpl jamServiceContextImpl = (JamServiceContextImpl) jamServiceParams;
        jamServiceContextImpl.setClassLoader(createClassLoader(jamServiceContextImpl));
        return new JamServiceImpl((ElementContext) jamServiceParams, getSpecifiedClasses(jamServiceContextImpl));
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceFactory
    public JamClassLoader createSystemJamClassLoader() {
        JamServiceParams createServiceParams = createServiceParams();
        createServiceParams.setUseSystemClasspath(true);
        try {
            return createService(createServiceParams).getClassLoader();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.JamServiceFactory
    public JamClassLoader createJamClassLoader(ClassLoader classLoader) {
        JamServiceParams createServiceParams = createServiceParams();
        createServiceParams.setUseSystemClasspath(false);
        createServiceParams.setPropertyInitializer(null);
        createServiceParams.addClassLoader(classLoader);
        try {
            return createService(createServiceParams).getClassLoader();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
    }

    protected String[] getSpecifiedClasses(JamServiceContext jamServiceContext) throws IOException {
        return jamServiceContext.getAllClassnames();
    }

    protected JamClassLoader createClassLoader(JamServiceContext jamServiceContext) throws IOException {
        return new JamClassLoaderImpl((ElementContext) jamServiceContext, createBuilder(jamServiceContext), jamServiceContext.getInitializer());
    }

    protected JamClassBuilder createBuilder(JamServiceContext jamServiceContext) throws IOException {
        JamLogger logger = jamServiceContext.getLogger();
        ArrayList arrayList = new ArrayList();
        JamClassBuilder baseBuilder = jamServiceContext.getBaseBuilder();
        if (baseBuilder != null) {
            arrayList.add(baseBuilder);
        }
        JamClassBuilder createSourceBuilder = createSourceBuilder(jamServiceContext);
        if (logger.isVerbose(this)) {
            logger.verbose("added classbuilder for sources");
        }
        if (createSourceBuilder != null) {
            arrayList.add(createSourceBuilder);
        }
        JamClassBuilder createClassfileBuilder = createClassfileBuilder(jamServiceContext);
        if (logger.isVerbose(this)) {
            logger.verbose("added classbuilder for custom classpath");
        }
        if (createClassfileBuilder != null) {
            arrayList.add(createClassfileBuilder);
        }
        ClassLoader[] reflectionClassLoaders = jamServiceContext.getReflectionClassLoaders();
        for (int i = 0; i < reflectionClassLoaders.length; i++) {
            if (logger.isVerbose(this)) {
                logger.verbose(new StringBuffer().append("added classbuilder for classloader ").append(reflectionClassLoaders[i].getClass()).toString());
            }
            arrayList.add(new ReflectClassBuilder(reflectionClassLoaders[i]));
        }
        int size = arrayList.size();
        JamClassBuilder[] jamClassBuilderArr = new JamClassBuilder[size];
        arrayList.toArray(jamClassBuilderArr);
        CompositeJamClassBuilder compositeJamClassBuilder = new CompositeJamClassBuilder(jamClassBuilderArr);
        compositeJamClassBuilder.init((ElementContext) jamServiceContext);
        if (logger.isVerbose(this)) {
            logger.verbose(new StringBuffer().append("returning a composite of ").append(size).append(" class builders.").toString());
            compositeJamClassBuilder.build("java.lang", "Object");
            compositeJamClassBuilder.build("javax.ejb", "SessionBean");
        }
        return compositeJamClassBuilder;
    }

    protected JamClassBuilder createSourceBuilder(JamServiceContext jamServiceContext) throws IOException {
        File[] sourceFiles = jamServiceContext.getSourceFiles();
        if (sourceFiles == null || sourceFiles.length == 0) {
            if (!jamServiceContext.isVerbose(this)) {
                return null;
            }
            jamServiceContext.verbose("[JamServiceFactoryImpl]no source files present, skipping source ClassBuilder");
            return null;
        }
        if (jamServiceContext.getProperty(USE_NEW_PARSER) == null) {
            return new JavadocClassBuilder();
        }
        return new ParserClassBuilder(jamServiceContext);
    }

    protected JamClassBuilder createClassfileBuilder(JamServiceContext jamServiceContext) throws IOException {
        ResourcePath inputClasspath = jamServiceContext.getInputClasspath();
        if (inputClasspath == null) {
            return null;
        }
        return new ReflectClassBuilder(new URLClassLoader(inputClasspath.toUrlPath()));
    }
}
