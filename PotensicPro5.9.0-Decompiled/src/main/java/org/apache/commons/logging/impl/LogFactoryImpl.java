package org.apache.commons.logging.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes4.dex */
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    private static final String PKG_IMPL = "org.apache.commons.logging.impl.";
    private static final int PKG_LEN = 32;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$commons$logging$Log;
    static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$LogFactoryImpl;
    private boolean allowFlawedContext;
    private boolean allowFlawedDiscovery;
    private boolean allowFlawedHierarchy;
    private String diagnosticPrefix;
    private String logClassName;
    protected Class[] logConstructorSignature;
    protected Method logMethod;
    protected Class[] logMethodSignature;
    private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
    private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
    private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
    private static final String LOGGING_IMPL_SIMPLE_LOGGER = "org.apache.commons.logging.impl.SimpleLog";
    private static final String[] classesToDiscover = {LOGGING_IMPL_LOG4J_LOGGER, LOGGING_IMPL_JDK14_LOGGER, LOGGING_IMPL_LUMBERJACK_LOGGER, LOGGING_IMPL_SIMPLE_LOGGER};
    private boolean useTCCL = true;
    protected Hashtable attributes = new Hashtable();
    protected Hashtable instances = new Hashtable();
    protected Constructor logConstructor = null;

    public LogFactoryImpl() {
        Class[] clsArr = new Class[1];
        Class cls = class$java$lang$String;
        if (cls == null) {
            cls = class$("java.lang.String");
            class$java$lang$String = cls;
        }
        clsArr[0] = cls;
        this.logConstructorSignature = clsArr;
        this.logMethod = null;
        Class[] clsArr2 = new Class[1];
        Class cls2 = class$org$apache$commons$logging$LogFactory;
        if (cls2 == null) {
            cls2 = class$(LogFactory.FACTORY_PROPERTY);
            class$org$apache$commons$logging$LogFactory = cls2;
        }
        clsArr2[0] = cls2;
        this.logMethodSignature = clsArr2;
        initDiagnostics();
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Instance created.");
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        return (String[]) this.attributes.keySet().toArray(new String[this.attributes.size()]);
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class cls) throws LogConfigurationException {
        return getInstance(cls.getName());
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) throws LogConfigurationException {
        Log log = (Log) this.instances.get(str);
        if (log != null) {
            return log;
        }
        Log newInstance = newInstance(str);
        this.instances.put(str, newInstance);
        return newInstance;
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        logDiagnostic("Releasing all known loggers");
        this.instances.clear();
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String str, Object obj) {
        if (this.logConstructor != null) {
            logDiagnostic("setAttribute: call too late; configuration already performed.");
        }
        if (obj == null) {
            this.attributes.remove(str);
        } else {
            this.attributes.put(str, obj);
        }
        if (str.equals(LogFactory.TCCL_KEY)) {
            this.useTCCL = obj != null && Boolean.valueOf(obj.toString()).booleanValue();
        }
    }

    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        return LogFactory.getContextClassLoader();
    }

    protected static boolean isDiagnosticsEnabled() {
        return LogFactory.isDiagnosticsEnabled();
    }

    protected static ClassLoader getClassLoader(Class cls) {
        return LogFactory.getClassLoader(cls);
    }

    private void initDiagnostics() {
        String str;
        ClassLoader classLoader = getClassLoader(getClass());
        if (classLoader == null) {
            str = "BOOTLOADER";
        } else {
            try {
                str = objectId(classLoader);
            } catch (SecurityException unused) {
                str = "UNKNOWN";
            }
        }
        this.diagnosticPrefix = new StringBuffer().append("[LogFactoryImpl@").append(System.identityHashCode(this)).append(" from ").append(str).append("] ").toString();
    }

    protected void logDiagnostic(String str) {
        if (isDiagnosticsEnabled()) {
            logRawDiagnostic(new StringBuffer().append(this.diagnosticPrefix).append(str).toString());
        }
    }

    protected String getLogClassName() {
        if (this.logClassName == null) {
            discoverLogImplementation(getClass().getName());
        }
        return this.logClassName;
    }

    protected Constructor getLogConstructor() throws LogConfigurationException {
        if (this.logConstructor == null) {
            discoverLogImplementation(getClass().getName());
        }
        return this.logConstructor;
    }

    protected boolean isJdk13LumberjackAvailable() {
        return isLogLibraryAvailable("Jdk13Lumberjack", LOGGING_IMPL_LUMBERJACK_LOGGER);
    }

    protected boolean isJdk14Available() {
        return isLogLibraryAvailable("Jdk14", LOGGING_IMPL_JDK14_LOGGER);
    }

    protected boolean isLog4JAvailable() {
        return isLogLibraryAvailable("Log4J", LOGGING_IMPL_LOG4J_LOGGER);
    }

    protected Log newInstance(String str) throws LogConfigurationException {
        Log log;
        try {
            Constructor constructor = this.logConstructor;
            if (constructor == null) {
                log = discoverLogImplementation(str);
            } else {
                log = (Log) constructor.newInstance(str);
            }
            Method method = this.logMethod;
            if (method != null) {
                method.invoke(log, this);
            }
            return log;
        } catch (InvocationTargetException e) {
            e = e;
            Throwable targetException = e.getTargetException();
            if (targetException != null) {
                e = targetException;
            }
            throw new LogConfigurationException(e);
        } catch (LogConfigurationException e2) {
            throw e2;
        } catch (Throwable th) {
            handleThrowable(th);
            throw new LogConfigurationException(th);
        }
    }

    private static ClassLoader getContextClassLoaderInternal() throws LogConfigurationException {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.impl.LogFactoryImpl.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return LogFactoryImpl.directGetContextClassLoader();
            }
        });
    }

    private static String getSystemProperty(final String str, final String str2) throws SecurityException {
        return (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.impl.LogFactoryImpl.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(str, str2);
            }
        });
    }

    private ClassLoader getParentClassLoader(final ClassLoader classLoader) {
        try {
            return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.logging.impl.LogFactoryImpl.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return classLoader.getParent();
                }
            });
        } catch (SecurityException unused) {
            logDiagnostic("[SECURITY] Unable to obtain parent classloader");
            return null;
        }
    }

    private boolean isLogLibraryAvailable(String str, String str2) {
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("Checking for '").append(str).append("'.").toString());
        }
        try {
            if (createLogFromClass(str2, getClass().getName(), false) == null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(new StringBuffer().append("Did not find '").append(str).append("'.").toString());
                }
                return false;
            }
            if (!isDiagnosticsEnabled()) {
                return true;
            }
            logDiagnostic(new StringBuffer().append("Found '").append(str).append("'.").toString());
            return true;
        } catch (LogConfigurationException unused) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(new StringBuffer().append("Logging system '").append(str).append("' is available but not useable.").toString());
            }
            return false;
        }
    }

    private String getConfigurationValue(String str) {
        String systemProperty;
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("[ENV] Trying to get configuration for item ").append(str).toString());
        }
        Object attribute = getAttribute(str);
        if (attribute != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(new StringBuffer().append("[ENV] Found LogFactory attribute [").append(attribute).append("] for ").append(str).toString());
            }
            return attribute.toString();
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("[ENV] No LogFactory attribute found for ").append(str).toString());
        }
        try {
            systemProperty = getSystemProperty(str, null);
        } catch (SecurityException unused) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(new StringBuffer().append("[ENV] Security prevented reading system property ").append(str).toString());
            }
        }
        if (systemProperty != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(new StringBuffer().append("[ENV] Found system property [").append(systemProperty).append("] for ").append(str).toString());
            }
            return systemProperty;
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("[ENV] No system property found for property ").append(str).toString());
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("[ENV] No configuration defined for item ").append(str).toString());
        }
        return null;
    }

    private boolean getBooleanConfiguration(String str, boolean z) {
        String configurationValue = getConfigurationValue(str);
        return configurationValue == null ? z : Boolean.valueOf(configurationValue).booleanValue();
    }

    private void initConfiguration() {
        this.allowFlawedContext = getBooleanConfiguration(ALLOW_FLAWED_CONTEXT_PROPERTY, true);
        this.allowFlawedDiscovery = getBooleanConfiguration(ALLOW_FLAWED_DISCOVERY_PROPERTY, true);
        this.allowFlawedHierarchy = getBooleanConfiguration(ALLOW_FLAWED_HIERARCHY_PROPERTY, true);
    }

    private Log discoverLogImplementation(String str) throws LogConfigurationException {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Discovering a Log implementation...");
        }
        initConfiguration();
        Log log = null;
        String findUserSpecifiedLogClassName = findUserSpecifiedLogClassName();
        if (findUserSpecifiedLogClassName != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic(new StringBuffer().append("Attempting to load user-specified log class '").append(findUserSpecifiedLogClassName).append("'...").toString());
            }
            Log createLogFromClass = createLogFromClass(findUserSpecifiedLogClassName, str, true);
            if (createLogFromClass != null) {
                return createLogFromClass;
            }
            StringBuffer stringBuffer = new StringBuffer("User-specified log class '");
            stringBuffer.append(findUserSpecifiedLogClassName);
            stringBuffer.append("' cannot be found or is not useable.");
            informUponSimilarName(stringBuffer, findUserSpecifiedLogClassName, LOGGING_IMPL_LOG4J_LOGGER);
            informUponSimilarName(stringBuffer, findUserSpecifiedLogClassName, LOGGING_IMPL_JDK14_LOGGER);
            informUponSimilarName(stringBuffer, findUserSpecifiedLogClassName, LOGGING_IMPL_LUMBERJACK_LOGGER);
            informUponSimilarName(stringBuffer, findUserSpecifiedLogClassName, LOGGING_IMPL_SIMPLE_LOGGER);
            throw new LogConfigurationException(stringBuffer.toString());
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("No user-specified Log implementation; performing discovery using the standard supported logging implementations...");
        }
        int i = 0;
        while (true) {
            String[] strArr = classesToDiscover;
            if (i >= strArr.length || log != null) {
                break;
            }
            log = createLogFromClass(strArr[i], str, true);
            i++;
        }
        if (log != null) {
            return log;
        }
        throw new LogConfigurationException("No suitable Log implementation");
    }

    private void informUponSimilarName(StringBuffer stringBuffer, String str, String str2) {
        if (!str.equals(str2) && str.regionMatches(true, 0, str2, 0, PKG_LEN + 5)) {
            stringBuffer.append(" Did you mean '");
            stringBuffer.append(str2);
            stringBuffer.append("'?");
        }
    }

    private String findUserSpecifiedLogClassName() {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.Log'");
        }
        String str = (String) getAttribute(LOG_PROPERTY);
        if (str == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.log'");
            }
            str = (String) getAttribute(LOG_PROPERTY_OLD);
        }
        if (str == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.Log'");
            }
            try {
                str = getSystemProperty(LOG_PROPERTY, null);
            } catch (SecurityException e) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(new StringBuffer().append("No access allowed to system property 'org.apache.commons.logging.Log' - ").append(e.getMessage()).toString());
                }
            }
        }
        if (str == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.log'");
            }
            try {
                str = getSystemProperty(LOG_PROPERTY_OLD, null);
            } catch (SecurityException e2) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(new StringBuffer().append("No access allowed to system property 'org.apache.commons.logging.log' - ").append(e2.getMessage()).toString());
                }
            }
        }
        return str != null ? str.trim() : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0179 A[LOOP:0: B:5:0x003a->B:24:0x0179, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e8 A[EDGE_INSN: B:25:0x01e8->B:26:0x01e8 BREAK  A[LOOP:0: B:5:0x003a->B:24:0x0179], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01eb A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.logging.Log createLogFromClass(java.lang.String r17, java.lang.String r18, boolean r19) throws org.apache.commons.logging.LogConfigurationException {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.createLogFromClass(java.lang.String, java.lang.String, boolean):org.apache.commons.logging.Log");
    }

    private ClassLoader getBaseClassLoader() throws LogConfigurationException {
        Class cls = class$org$apache$commons$logging$impl$LogFactoryImpl;
        if (cls == null) {
            cls = class$(LogFactory.FACTORY_DEFAULT);
            class$org$apache$commons$logging$impl$LogFactoryImpl = cls;
        }
        ClassLoader classLoader = getClassLoader(cls);
        if (!this.useTCCL) {
            return classLoader;
        }
        ClassLoader contextClassLoaderInternal = getContextClassLoaderInternal();
        ClassLoader lowestClassLoader = getLowestClassLoader(contextClassLoaderInternal, classLoader);
        if (lowestClassLoader == null) {
            if (this.allowFlawedContext) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[WARNING] the context classloader is not part of a parent-child relationship with the classloader that loaded LogFactoryImpl.");
                }
                return contextClassLoaderInternal;
            }
            throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
        }
        if (lowestClassLoader != contextClassLoaderInternal) {
            if (this.allowFlawedContext) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Warning: the context classloader is an ancestor of the classloader that loaded LogFactoryImpl; it should be the same or a descendant. The application using commons-logging should ensure the context classloader is used correctly.");
                }
            } else {
                throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
            }
        }
        return lowestClassLoader;
    }

    private ClassLoader getLowestClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
        if (classLoader == null) {
            return classLoader2;
        }
        if (classLoader2 == null) {
            return classLoader;
        }
        ClassLoader classLoader3 = classLoader;
        while (classLoader3 != null) {
            if (classLoader3 == classLoader2) {
                return classLoader;
            }
            classLoader3 = getParentClassLoader(classLoader3);
        }
        ClassLoader classLoader4 = classLoader2;
        while (classLoader4 != null) {
            if (classLoader4 == classLoader) {
                return classLoader2;
            }
            classLoader4 = getParentClassLoader(classLoader4);
        }
        return null;
    }

    private void handleFlawedDiscovery(String str, ClassLoader classLoader, Throwable th) {
        Throwable targetException;
        Throwable exception;
        if (isDiagnosticsEnabled()) {
            logDiagnostic(new StringBuffer().append("Could not instantiate Log '").append(str).append("' -- ").append(th.getClass().getName()).append(": ").append(th.getLocalizedMessage()).toString());
            if ((th instanceof InvocationTargetException) && (targetException = ((InvocationTargetException) th).getTargetException()) != null) {
                logDiagnostic(new StringBuffer().append("... InvocationTargetException: ").append(targetException.getClass().getName()).append(": ").append(targetException.getLocalizedMessage()).toString());
                if ((targetException instanceof ExceptionInInitializerError) && (exception = ((ExceptionInInitializerError) targetException).getException()) != null) {
                    StringWriter stringWriter = new StringWriter();
                    exception.printStackTrace(new PrintWriter((Writer) stringWriter, true));
                    logDiagnostic(new StringBuffer().append("... ExceptionInInitializerError: ").append(stringWriter.toString()).toString());
                }
            }
        }
        if (!this.allowFlawedDiscovery) {
            throw new LogConfigurationException(th);
        }
    }

    private void handleFlawedHierarchy(ClassLoader classLoader, Class cls) throws LogConfigurationException {
        Class cls2 = class$org$apache$commons$logging$Log;
        if (cls2 == null) {
            cls2 = class$(LOG_PROPERTY);
            class$org$apache$commons$logging$Log = cls2;
        }
        String name = cls2.getName();
        Class<?>[] interfaces = cls.getInterfaces();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= interfaces.length) {
                break;
            }
            if (name.equals(interfaces[i].getName())) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            if (isDiagnosticsEnabled()) {
                try {
                    Class cls3 = class$org$apache$commons$logging$Log;
                    if (cls3 == null) {
                        cls3 = class$(LOG_PROPERTY);
                        class$org$apache$commons$logging$Log = cls3;
                    }
                    logDiagnostic(new StringBuffer().append("Class '").append(cls.getName()).append("' was found in classloader ").append(objectId(classLoader)).append(". It is bound to a Log interface which is not").append(" the one loaded from classloader ").append(objectId(getClassLoader(cls3))).toString());
                } catch (Throwable th) {
                    handleThrowable(th);
                    logDiagnostic(new StringBuffer().append("Error while trying to output diagnostics about bad class '").append(cls).append("'").toString());
                }
            }
            if (!this.allowFlawedHierarchy) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Terminating logging for this context ");
                stringBuffer.append("due to bad log hierarchy. ");
                stringBuffer.append("You have more than one version of '");
                Class cls4 = class$org$apache$commons$logging$Log;
                if (cls4 == null) {
                    cls4 = class$(LOG_PROPERTY);
                    class$org$apache$commons$logging$Log = cls4;
                }
                stringBuffer.append(cls4.getName());
                stringBuffer.append("' visible.");
                if (isDiagnosticsEnabled()) {
                    logDiagnostic(stringBuffer.toString());
                }
                throw new LogConfigurationException(stringBuffer.toString());
            }
            if (isDiagnosticsEnabled()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Warning: bad log hierarchy. ");
                stringBuffer2.append("You have more than one version of '");
                Class cls5 = class$org$apache$commons$logging$Log;
                if (cls5 == null) {
                    cls5 = class$(LOG_PROPERTY);
                    class$org$apache$commons$logging$Log = cls5;
                }
                stringBuffer2.append(cls5.getName());
                stringBuffer2.append("' visible.");
                logDiagnostic(stringBuffer2.toString());
                return;
            }
            return;
        }
        if (!this.allowFlawedDiscovery) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Terminating logging for this context. ");
            stringBuffer3.append("Log class '");
            stringBuffer3.append(cls.getName());
            stringBuffer3.append("' does not implement the Log interface.");
            if (isDiagnosticsEnabled()) {
                logDiagnostic(stringBuffer3.toString());
            }
            throw new LogConfigurationException(stringBuffer3.toString());
        }
        if (isDiagnosticsEnabled()) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("[WARNING] Log class '");
            stringBuffer4.append(cls.getName());
            stringBuffer4.append("' does not implement the Log interface.");
            logDiagnostic(stringBuffer4.toString());
        }
    }
}
