package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.config.BindingConfigImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.tool.Extension;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* loaded from: classes5.dex */
public class SchemaCompiler {
    private static final String COMPATIBILITY_CONFIG_URI = "http://www.bea.com/2002/09/xbean/config";
    private static final String CONFIG_URI = "http://xml.apache.org/xmlbeans/2004/02/xbean/config";
    private static final Map MAP_COMPATIBILITY_CONFIG_URIS;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeSystem;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;

    public static void printUsage() {
        System.out.println("Compiles a schema into XML Bean classes and metadata.");
        System.out.println("Usage: scomp [opts] [dirs]* [schema.xsd]* [service.wsdl]* [config.xsdconfig]*");
        System.out.println("Options include:");
        System.out.println("    -cp [a;b;c] - classpath");
        System.out.println("    -d [dir] - target binary directory for .class and .xsb files");
        System.out.println("    -src [dir] - target directory for generated .java files");
        System.out.println("    -srconly - do not compile .java files or jar the output.");
        System.out.println("    -out [xmltypes.jar] - the name of the output jar");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -noann - ignore annotations");
        System.out.println("    -novdoc - do not validate contents of <documentation>");
        System.out.println("    -noext - ignore all extension (Pre/Post and Interface) found in .xsdconfig files");
        System.out.println("    -compiler - path to external java compiler");
        System.out.println("    -javasource [version] - generate java source compatible for a Java version (1.4 or 1.5)");
        System.out.println(new StringBuffer().append("    -ms - initial memory for external java compiler (default '").append(CodeGenUtil.DEFAULT_MEM_START).append("')").toString());
        System.out.println(new StringBuffer().append("    -mx - maximum memory for external java compiler (default '").append(CodeGenUtil.DEFAULT_MEM_MAX).append("')").toString());
        System.out.println("    -debug - compile with debug symbols");
        System.out.println("    -quiet - print fewer informational messages");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -version - prints version information");
        System.out.println("    -license - prints license information");
        System.out.println("    -allowmdef \"[ns] [ns] [ns]\" - ignores multiple defs in given namespaces (use ##local for no-namespace)");
        System.out.println("    -catalog [file] -  catalog file for org.apache.xml.resolver.tools.CatalogResolver. (Note: needs resolver.jar from http://xml.apache.org/commons/components/resolver/index.html)");
        System.out.println();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(57:29|(1:31)(1:184)|32|(1:34)(1:183)|(1:36)(1:182)|(1:38)|39|(48:178|179|42|(1:44)(1:177)|45|(1:47)(1:176)|48|(1:50)(1:175)|51|(1:53)(1:174)|54|(1:56)(1:173)|57|(1:59)(1:172)|60|(1:62)(1:171)|63|(1:65)(1:170)|66|(1:68)(1:169)|69|(12:71|72|73|74|75|76|77|78|79|80|81|82)(1:168)|83|(3:87|(4:90|(2:92|93)(2:95|96)|94|88)|97)|98|(1:100)(1:157)|101|(1:103)(1:156)|(1:107)|(20:150|151|152|(1:115)|(1:117)(1:149)|(1:119)|(1:121)|122|(4:124|(2:127|125)|128|129)(1:148)|130|(1:133)|134|(1:136)|137|(1:139)(1:147)|140|(1:142)|(1:144)|145|146)(1:110)|111|(1:115)|(0)(0)|(0)|(0)|122|(0)(0)|130|(1:133)|134|(0)|137|(0)(0)|140|(0)|(0)|145|146)|41|42|(0)(0)|45|(0)(0)|48|(0)(0)|51|(0)(0)|54|(0)(0)|57|(0)(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|69|(0)(0)|83|(4:85|87|(1:88)|97)|98|(0)(0)|101|(0)(0)|(1:107)|(0)|150|151|152|(0)|(0)(0)|(0)|(0)|122|(0)(0)|130|(0)|134|(0)|137|(0)(0)|140|(0)|(0)|145|146) */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02f9, code lost:
    
        r20 = r7;
        r22 = r12;
        java.lang.System.err.println(new java.lang.StringBuffer().append("Error creating temp dir ").append(r0).toString());
        java.lang.System.exit(1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x031d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x038d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028a  */
    /* JADX WARN: Type inference failed for: r0v71, types: [java.util.Set] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r33) {
        /*
            Method dump skipped, instructions count: 1175
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.SchemaCompiler.main(java.lang.String[]):void");
    }

    public static class Parameters {
        private File baseDir;
        private String catalogFile;
        private File classesDir;
        private File[] classpath;
        private String compiler;
        private File[] configFiles;
        private boolean debug;
        private boolean download;
        private EntityResolver entityResolver;
        private Collection errorListener;
        private boolean incrementalSrcGen;
        private File[] javaFiles;
        private String javasource;
        private String memoryInitialSize;
        private String memoryMaximumSize;
        private String name;
        private boolean noAnn;
        private boolean noExt;
        private boolean noPvr;
        private boolean noUpa;
        private boolean noVDoc;
        private boolean nojavac;
        private File outputJar;
        private boolean quiet;

        /* renamed from: repackage, reason: collision with root package name */
        private String f9repackage;
        private SchemaCodePrinter schemaCodePrinter;
        private File srcDir;
        private URL[] urlFiles;
        private boolean verbose;
        private File[] wsdlFiles;
        private File[] xsdFiles;
        private List extensions = Collections.EMPTY_LIST;
        private Set mdefNamespaces = Collections.EMPTY_SET;

        public String getJar() {
            return null;
        }

        public void setJar(String str) {
        }

        public File getBaseDir() {
            return this.baseDir;
        }

        public void setBaseDir(File file) {
            this.baseDir = file;
        }

        public File[] getXsdFiles() {
            return this.xsdFiles;
        }

        public void setXsdFiles(File[] fileArr) {
            this.xsdFiles = fileArr;
        }

        public File[] getWsdlFiles() {
            return this.wsdlFiles;
        }

        public void setWsdlFiles(File[] fileArr) {
            this.wsdlFiles = fileArr;
        }

        public File[] getJavaFiles() {
            return this.javaFiles;
        }

        public void setJavaFiles(File[] fileArr) {
            this.javaFiles = fileArr;
        }

        public File[] getConfigFiles() {
            return this.configFiles;
        }

        public void setConfigFiles(File[] fileArr) {
            this.configFiles = fileArr;
        }

        public URL[] getUrlFiles() {
            return this.urlFiles;
        }

        public void setUrlFiles(URL[] urlArr) {
            this.urlFiles = urlArr;
        }

        public File[] getClasspath() {
            return this.classpath;
        }

        public void setClasspath(File[] fileArr) {
            this.classpath = fileArr;
        }

        public File getOutputJar() {
            return this.outputJar;
        }

        public void setOutputJar(File file) {
            this.outputJar = file;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public File getSrcDir() {
            return this.srcDir;
        }

        public void setSrcDir(File file) {
            this.srcDir = file;
        }

        public File getClassesDir() {
            return this.classesDir;
        }

        public void setClassesDir(File file) {
            this.classesDir = file;
        }

        public boolean isNojavac() {
            return this.nojavac;
        }

        public void setNojavac(boolean z) {
            this.nojavac = z;
        }

        public boolean isQuiet() {
            return this.quiet;
        }

        public void setQuiet(boolean z) {
            this.quiet = z;
        }

        public boolean isVerbose() {
            return this.verbose;
        }

        public void setVerbose(boolean z) {
            this.verbose = z;
        }

        public boolean isDownload() {
            return this.download;
        }

        public void setDownload(boolean z) {
            this.download = z;
        }

        public boolean isNoUpa() {
            return this.noUpa;
        }

        public void setNoUpa(boolean z) {
            this.noUpa = z;
        }

        public boolean isNoPvr() {
            return this.noPvr;
        }

        public void setNoPvr(boolean z) {
            this.noPvr = z;
        }

        public boolean isNoAnn() {
            return this.noAnn;
        }

        public void setNoAnn(boolean z) {
            this.noAnn = z;
        }

        public boolean isNoVDoc() {
            return this.noVDoc;
        }

        public void setNoVDoc(boolean z) {
            this.noVDoc = z;
        }

        public boolean isNoExt() {
            return this.noExt;
        }

        public void setNoExt(boolean z) {
            this.noExt = z;
        }

        public boolean isIncrementalSrcGen() {
            return this.incrementalSrcGen;
        }

        public void setIncrementalSrcGen(boolean z) {
            this.incrementalSrcGen = z;
        }

        public boolean isDebug() {
            return this.debug;
        }

        public void setDebug(boolean z) {
            this.debug = z;
        }

        public String getMemoryInitialSize() {
            return this.memoryInitialSize;
        }

        public void setMemoryInitialSize(String str) {
            this.memoryInitialSize = str;
        }

        public String getMemoryMaximumSize() {
            return this.memoryMaximumSize;
        }

        public void setMemoryMaximumSize(String str) {
            this.memoryMaximumSize = str;
        }

        public String getCompiler() {
            return this.compiler;
        }

        public void setCompiler(String str) {
            this.compiler = str;
        }

        public String getJavaSource() {
            return this.javasource;
        }

        public void setJavaSource(String str) {
            this.javasource = str;
        }

        public Collection getErrorListener() {
            return this.errorListener;
        }

        public void setErrorListener(Collection collection) {
            this.errorListener = collection;
        }

        public String getRepackage() {
            return this.f9repackage;
        }

        public void setRepackage(String str) {
            this.f9repackage = str;
        }

        public List getExtensions() {
            return this.extensions;
        }

        public void setExtensions(List list) {
            this.extensions = list;
        }

        public Set getMdefNamespaces() {
            return this.mdefNamespaces;
        }

        public void setMdefNamespaces(Set set) {
            this.mdefNamespaces = set;
        }

        public String getCatalogFile() {
            return this.catalogFile;
        }

        public void setCatalogFile(String str) {
            this.catalogFile = str;
        }

        public SchemaCodePrinter getSchemaCodePrinter() {
            return this.schemaCodePrinter;
        }

        public void setSchemaCodePrinter(SchemaCodePrinter schemaCodePrinter) {
            this.schemaCodePrinter = schemaCodePrinter;
        }

        public EntityResolver getEntityResolver() {
            return this.entityResolver;
        }

        public void setEntityResolver(EntityResolver entityResolver) {
            this.entityResolver = entityResolver;
        }
    }

    private static SchemaTypeSystem loadTypeSystem(String str, File[] fileArr, File[] fileArr2, URL[] urlArr, File[] fileArr3, File[] fileArr4, ResourceLoader resourceLoader, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Set set, File file, Map map, Collection collection, File file2, EntityResolver entityResolver, File[] fileArr5, String str2) {
        Object[] objArr;
        String str3;
        XmlOptions xmlOptions;
        String str4 = "xsd config";
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
        StscState.start().setErrorListener(xmlErrorWatcher);
        Class cls = class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument");
            class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument = cls;
        }
        SchemaTypeLoader typeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(cls.getClassLoader());
        ArrayList arrayList = new ArrayList();
        if (fileArr != null) {
            int i = 0;
            while (i < fileArr.length) {
                try {
                    xmlOptions = new XmlOptions();
                    xmlOptions.setLoadLineNumbers();
                    xmlOptions.setLoadMessageDigest();
                    xmlOptions.setEntityResolver(entityResolver);
                    str3 = str4;
                } catch (XmlException e) {
                    e = e;
                    str3 = str4;
                } catch (Exception e2) {
                    e = e2;
                    str3 = str4;
                }
                try {
                    XmlObject parse = typeLoaderForClassLoader.parse(fileArr[i], (SchemaType) null, xmlOptions);
                    if (parse instanceof SchemaDocument) {
                        addSchema(fileArr[i].toString(), (SchemaDocument) parse, xmlErrorWatcher, z5, arrayList);
                    } else {
                        StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{fileArr[i], "schema"}, parse);
                    }
                } catch (XmlException e3) {
                    e = e3;
                    xmlErrorWatcher.add(e.getError());
                    i++;
                    str4 = str3;
                } catch (Exception e4) {
                    e = e4;
                    StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"xsd", fileArr[i], e.getMessage()}, fileArr[i]);
                    i++;
                    str4 = str3;
                }
                i++;
                str4 = str3;
            }
        }
        String str5 = str4;
        if (fileArr2 != null) {
            for (int i2 = 0; i2 < fileArr2.length; i2++) {
                try {
                    XmlOptions xmlOptions2 = new XmlOptions();
                    xmlOptions2.setLoadLineNumbers();
                    xmlOptions2.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                    xmlOptions2.setEntityResolver(entityResolver);
                    XmlObject parse2 = typeLoaderForClassLoader.parse(fileArr2[i2], (SchemaType) null, xmlOptions2);
                    if (parse2 instanceof DefinitionsDocument) {
                        addWsdlSchemas(fileArr2[i2].toString(), (DefinitionsDocument) parse2, xmlErrorWatcher, z5, arrayList);
                    } else {
                        StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{fileArr2[i2], "wsdl"}, parse2);
                    }
                } catch (XmlException e5) {
                    xmlErrorWatcher.add(e5.getError());
                } catch (Exception e6) {
                    StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"wsdl", fileArr2[i2], e6.getMessage()}, fileArr2[i2]);
                }
            }
        }
        if (urlArr != null) {
            for (int i3 = 0; i3 < urlArr.length; i3++) {
                try {
                    XmlOptions xmlOptions3 = new XmlOptions();
                    xmlOptions3.setLoadLineNumbers();
                    xmlOptions3.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                    xmlOptions3.setEntityResolver(entityResolver);
                    XmlObject parse3 = typeLoaderForClassLoader.parse(urlArr[i3], (SchemaType) null, xmlOptions3);
                    if (parse3 instanceof DefinitionsDocument) {
                        addWsdlSchemas(urlArr[i3].toString(), (DefinitionsDocument) parse3, xmlErrorWatcher, z5, arrayList);
                    } else if (parse3 instanceof SchemaDocument) {
                        addSchema(urlArr[i3].toString(), (SchemaDocument) parse3, xmlErrorWatcher, z5, arrayList);
                    } else {
                        StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{urlArr[i3], "wsdl or schema"}, parse3);
                    }
                } catch (XmlException e7) {
                    xmlErrorWatcher.add(e7.getError());
                } catch (Exception e8) {
                    StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"url", urlArr[i3], e8.getMessage()}, urlArr[i3]);
                }
            }
        }
        SchemaDocument.Schema[] schemaArr = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        if (fileArr3 != null) {
            if (z6) {
                System.out.println("Pre/Post and Interface extensions will be ignored.");
            }
            for (int i4 = 0; i4 < fileArr3.length; i4++) {
                try {
                    try {
                        XmlOptions xmlOptions4 = new XmlOptions();
                        xmlOptions4.put(XmlOptions.LOAD_LINE_NUMBERS);
                        xmlOptions4.setEntityResolver(entityResolver);
                        xmlOptions4.setLoadSubstituteNamespaces(MAP_COMPATIBILITY_CONFIG_URIS);
                        XmlObject parse4 = typeLoaderForClassLoader.parse(fileArr3[i4], (SchemaType) null, xmlOptions4);
                        if (parse4 instanceof ConfigDocument) {
                            StscState.addInfo(xmlErrorWatcher, new StringBuffer().append("Loading config file ").append(fileArr3[i4]).toString());
                            if (parse4.validate(new XmlOptions().setErrorListener(xmlErrorWatcher))) {
                                ConfigDocument.Config config = ((ConfigDocument) parse4).getConfig();
                                arrayList2.add(config);
                                if (z6) {
                                    try {
                                        config.setExtensionArray(new Extensionconfig[0]);
                                    } catch (XmlException e9) {
                                        e = e9;
                                        xmlErrorWatcher.add(e.getError());
                                    }
                                }
                            }
                        } else {
                            try {
                                objArr = new Object[2];
                            } catch (XmlException e10) {
                                e = e10;
                                xmlErrorWatcher.add(e.getError());
                            }
                            try {
                                objArr[0] = fileArr3[i4];
                                objArr[1] = str5;
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, objArr, parse4);
                            } catch (XmlException e11) {
                                e = e11;
                                xmlErrorWatcher.add(e.getError());
                            }
                        }
                    } catch (XmlException e12) {
                        e = e12;
                    }
                } catch (Exception e13) {
                    StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{str5, fileArr3[i4], e13.getMessage()}, fileArr3[i4]);
                }
            }
        }
        ConfigDocument.Config[] configArr = (ConfigDocument.Config[]) arrayList2.toArray(new ConfigDocument.Config[arrayList2.size()]);
        SchemaTypeLoader build = SchemaTypeLoaderImpl.build(null, resourceLoader, null);
        URI uri = file != null ? file.toURI() : null;
        XmlOptions xmlOptions5 = new XmlOptions();
        if (z) {
            xmlOptions5.setCompileDownloadUrls();
        }
        if (z2) {
            xmlOptions5.setCompileNoUpaRule();
        }
        if (z3) {
            xmlOptions5.setCompileNoPvrRule();
        }
        if (z4) {
            xmlOptions5.setCompileNoAnnotations();
        }
        if (set != null) {
            xmlOptions5.setCompileMdefNamespaces(set);
        }
        xmlOptions5.setCompileNoValidation();
        xmlOptions5.setEntityResolver(entityResolver);
        if (str2 != null) {
            xmlOptions5.setGenerateJavaVersion(str2);
        }
        SchemaTypeSystemCompiler.Parameters parameters = new SchemaTypeSystemCompiler.Parameters();
        parameters.setName(str);
        parameters.setSchemas(schemaArr);
        parameters.setConfig(BindingConfigImpl.forConfigDocuments(configArr, fileArr4, fileArr5));
        parameters.setLinkTo(build);
        parameters.setOptions(xmlOptions5);
        parameters.setErrorListener(xmlErrorWatcher);
        parameters.setJavaize(true);
        parameters.setBaseURI(uri);
        parameters.setSourcesToCopyMap(map);
        parameters.setSchemasDir(file2);
        return SchemaTypeSystemCompiler.compile(parameters);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static void addSchema(String str, SchemaDocument schemaDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List list) {
        StscState.addInfo(xmlErrorWatcher, new StringBuffer().append("Loading schema file ").append(str).toString());
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        if (schemaDocument.validate(errorListener)) {
            list.add(schemaDocument.getSchema());
        }
    }

    private static void addWsdlSchemas(String str, DefinitionsDocument definitionsDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List list) {
        if (wsdlContainsEncoded(definitionsDocument)) {
            StscState.addWarning(xmlErrorWatcher, new StringBuffer().append("The WSDL ").append(str).append(" uses SOAP encoding. SOAP encoding is not compatible with literal XML Schema.").toString(), 60, definitionsDocument);
        }
        StscState.addInfo(xmlErrorWatcher, new StringBuffer().append("Loading wsdl file ").append(str).toString());
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        int i = 0;
        for (XmlObject xmlObject : definitionsDocument.getDefinitions().getTypesArray()) {
            XmlObject[] selectPath = xmlObject.selectPath("declare namespace xs=\"http://www.w3.org/2001/XMLSchema\" xs:schema");
            if (selectPath.length == 0) {
                StscState.addWarning(xmlErrorWatcher, new StringBuffer().append("The WSDL ").append(str).append(" did not have any schema documents in namespace 'http://www.w3.org/2001/XMLSchema'").toString(), 60, definitionsDocument);
            } else {
                for (int i2 = 0; i2 < selectPath.length; i2++) {
                    if ((selectPath[i2] instanceof SchemaDocument.Schema) && selectPath[i2].validate(errorListener)) {
                        i++;
                        list.add(selectPath[i2]);
                    }
                }
            }
        }
        StscState.addInfo(xmlErrorWatcher, new StringBuffer().append("Processing ").append(i).append(" schema(s) in ").append(str).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x02d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean compile(org.apache.xmlbeans.impl.tool.SchemaCompiler.Parameters r47) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.SchemaCompiler.compile(org.apache.xmlbeans.impl.tool.SchemaCompiler$Parameters):boolean");
    }

    private static void runExtensions(List list, SchemaTypeSystem schemaTypeSystem, File file) {
        String absolutePath;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = list.iterator();
        try {
            absolutePath = file.getCanonicalPath();
        } catch (IOException unused) {
            System.out.println("WARNING: Unable to get the path for schema jar file");
            absolutePath = file.getAbsolutePath();
        }
        while (it.hasNext()) {
            Extension extension = (Extension) it.next();
            try {
                SchemaCompilerExtension schemaCompilerExtension = (SchemaCompilerExtension) extension.getClassName().newInstance();
                System.out.println(new StringBuffer().append("Running Extension: ").append(schemaCompilerExtension.getExtensionName()).toString());
                HashMap hashMap = new HashMap();
                for (Extension.Param param : extension.getParams()) {
                    hashMap.put(param.getName(), param.getValue());
                }
                hashMap.put("classesDir", absolutePath);
                schemaCompilerExtension.schemaCompilerExtension(schemaTypeSystem, hashMap);
            } catch (IllegalAccessException unused2) {
                System.out.println(new StringBuffer().append("ILLEGAL ACCESS Exception when attempting to instantiate schema compiler extension: ").append(extension.getClassName().getName()).toString());
                System.out.println("EXTENSION Class was not run");
                return;
            } catch (InstantiationException unused3) {
                System.out.println(new StringBuffer().append("UNABLE to instantiate schema compiler extension:").append(extension.getClassName().getName()).toString());
                System.out.println("EXTENSION Class was not run");
                return;
            }
        }
    }

    private static boolean wsdlContainsEncoded(XmlObject xmlObject) {
        for (XmlObject xmlObject2 : xmlObject.selectPath("declare namespace soap='http://schemas.xmlsoap.org/wsdl/soap/' .//soap:body/@use|.//soap:header/@use|.//soap:fault/@use")) {
            if ("encoded".equals(((SimpleValue) xmlObject2).getStringValue())) {
                return true;
            }
        }
        return false;
    }

    static {
        HashMap hashMap = new HashMap();
        MAP_COMPATIBILITY_CONFIG_URIS = hashMap;
        hashMap.put(COMPATIBILITY_CONFIG_URI, CONFIG_URI);
    }
}
