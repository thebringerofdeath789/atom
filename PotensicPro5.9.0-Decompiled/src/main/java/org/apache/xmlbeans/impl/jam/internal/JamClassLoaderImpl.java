package org.apache.xmlbeans.impl.jam.internal;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.internal.elements.ArrayClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.internal.elements.PackageImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.UnresolvedClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
import org.apache.xmlbeans.impl.jam.visitor.TraversingMVisitor;

/* loaded from: classes5.dex */
public class JamClassLoaderImpl implements JamClassLoader {
    private JamClassBuilder mBuilder;
    private ElementContext mContext;
    private MVisitor mInitializer;
    private Map mName2Package = new HashMap();
    private Map mFd2ClassCache = new HashMap();
    private Stack mInitializeStack = new Stack();
    private boolean mAlreadyInitializing = false;

    public JamClassLoaderImpl(ElementContext elementContext, JamClassBuilder jamClassBuilder, MVisitor mVisitor) {
        this.mInitializer = null;
        if (jamClassBuilder == null) {
            throw new IllegalArgumentException("null builder");
        }
        if (elementContext == null) {
            throw new IllegalArgumentException("null builder");
        }
        this.mBuilder = jamClassBuilder;
        this.mInitializer = mVisitor != null ? new TraversingMVisitor(mVisitor) : null;
        this.mContext = elementContext;
        initCache();
    }

    @Override // org.apache.xmlbeans.impl.jam.JamClassLoader
    public final JClass loadClass(String str) {
        String substring;
        String substring2;
        String trim = str.trim();
        JClass cacheGet = cacheGet(trim);
        if (cacheGet != null) {
            return cacheGet;
        }
        if (trim.indexOf(91) != -1) {
            String normalizeArrayName = ArrayClassImpl.normalizeArrayName(trim);
            JClass cacheGet2 = cacheGet(normalizeArrayName);
            if (cacheGet2 == null) {
                cacheGet2 = ArrayClassImpl.createClassForFD(normalizeArrayName, this);
                cachePut(cacheGet2, normalizeArrayName);
            }
            cachePut(cacheGet2, trim);
            return cacheGet2;
        }
        int indexOf = trim.indexOf(36);
        String str2 = "";
        if (indexOf != -1) {
            ((ClassImpl) loadClass(trim.substring(0, indexOf))).ensureLoaded();
            JClass cacheGet3 = cacheGet(trim);
            int lastIndexOf = trim.lastIndexOf(46);
            if (cacheGet3 != null) {
                return cacheGet3;
            }
            if (lastIndexOf == -1) {
                substring2 = trim;
            } else {
                str2 = trim.substring(0, lastIndexOf);
                substring2 = trim.substring(lastIndexOf + 1);
            }
            UnresolvedClassImpl unresolvedClassImpl = new UnresolvedClassImpl(str2, substring2, this.mContext);
            this.mContext.warning(new StringBuffer().append("failed to resolve class ").append(trim).toString());
            cachePut(unresolvedClassImpl);
            return unresolvedClassImpl;
        }
        int lastIndexOf2 = trim.lastIndexOf(46);
        if (lastIndexOf2 == -1) {
            substring = trim;
        } else {
            str2 = trim.substring(0, lastIndexOf2);
            substring = trim.substring(lastIndexOf2 + 1);
        }
        MClass build = this.mBuilder.build(str2, substring);
        if (build == null) {
            UnresolvedClassImpl unresolvedClassImpl2 = new UnresolvedClassImpl(str2, substring, this.mContext);
            this.mContext.warning(new StringBuffer().append("failed to resolve class ").append(trim).toString());
            cachePut(unresolvedClassImpl2);
            return unresolvedClassImpl2;
        }
        cachePut(build);
        return build;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamClassLoader
    public JPackage getPackage(String str) {
        JPackage jPackage = (JPackage) this.mName2Package.get(str);
        if (jPackage != null) {
            return jPackage;
        }
        PackageImpl packageImpl = new PackageImpl(this.mContext, str);
        this.mName2Package.put(str, packageImpl);
        return packageImpl;
    }

    private void initCache() {
        PrimitiveClassImpl.mapNameToPrimitive(this.mContext, this.mFd2ClassCache);
        this.mFd2ClassCache.put("void", new VoidClassImpl(this.mContext));
    }

    private void cachePut(JClass jClass) {
        this.mFd2ClassCache.put(jClass.getFieldDescriptor().trim(), new WeakReference(jClass));
    }

    private void cachePut(JClass jClass, String str) {
        this.mFd2ClassCache.put(str, new WeakReference(jClass));
    }

    private JClass cacheGet(String str) {
        Object obj = this.mFd2ClassCache.get(str.trim());
        if (obj == null) {
            return null;
        }
        if (obj instanceof JClass) {
            return (JClass) obj;
        }
        if (obj instanceof WeakReference) {
            Object obj2 = ((WeakReference) obj).get();
            if (obj2 == null) {
                this.mFd2ClassCache.remove(str.trim());
                return null;
            }
            return (JClass) obj2;
        }
        throw new IllegalStateException();
    }

    public void initialize(ClassImpl classImpl) {
        MVisitor mVisitor = this.mInitializer;
        if (mVisitor != null) {
            if (this.mAlreadyInitializing) {
                this.mInitializeStack.push(classImpl);
                return;
            }
            classImpl.accept(mVisitor);
            while (!this.mInitializeStack.isEmpty()) {
                ((ClassImpl) this.mInitializeStack.pop()).accept(this.mInitializer);
            }
            this.mAlreadyInitializing = false;
        }
    }

    public Collection getResolvedClasses() {
        return Collections.unmodifiableCollection(this.mFd2ClassCache.values());
    }

    public void addToCache(JClass jClass) {
        cachePut((MClass) jClass);
    }
}
