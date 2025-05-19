package org.apache.xmlbeans.impl.jam.internal.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;

/* loaded from: classes5.dex */
public class ReflectClassBuilder extends JamClassBuilder implements JamClassPopulator {
    private ClassLoader mLoader;
    private ReflectTigerDelegate mTigerDelegate = null;

    public ReflectClassBuilder(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("null rcl");
        }
        this.mLoader = classLoader;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public void init(ElementContext elementContext) {
        super.init(elementContext);
        initDelegate(elementContext);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        assertInitialized();
        if (getLogger().isVerbose(this)) {
            getLogger().verbose(new StringBuffer().append("trying to build '").append(str).append("' '").append(str2).append("'").toString());
        }
        try {
            Class<?> loadClass = this.mLoader.loadClass(str.trim().length() > 0 ? new StringBuffer().append(str).append('.').append(str2).toString() : str2);
            MClass createClassToBuild = createClassToBuild(str, str2, null, this);
            createClassToBuild.setArtifact(loadClass);
            return createClassToBuild;
        } catch (ClassNotFoundException e) {
            getLogger().verbose(e, this);
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassPopulator
    public void populate(MClass mClass) {
        assertInitialized();
        Class cls = (Class) mClass.getArtifact();
        mClass.setModifiers(cls.getModifiers());
        mClass.setIsInterface(cls.isInterface());
        ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
        if (reflectTigerDelegate != null) {
            mClass.setIsEnumType(reflectTigerDelegate.isEnum(cls));
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            mClass.setSuperclass(superclass.getName());
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            mClass.addInterface(cls2.getName());
        }
        Field[] fieldArr = null;
        try {
            fieldArr = cls.getFields();
        } catch (Exception unused) {
        }
        if (fieldArr != null) {
            for (Field field : fieldArr) {
                populate(mClass.addNewField(), field);
            }
        }
        for (Method method : cls.getDeclaredMethods()) {
            populate(mClass.addNewMethod(), method);
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.populateAnnotationTypeIfNecessary(cls, mClass, this);
        }
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            populate(mClass.addNewConstructor(), constructor);
        }
        ReflectTigerDelegate reflectTigerDelegate3 = this.mTigerDelegate;
        if (reflectTigerDelegate3 != null) {
            reflectTigerDelegate3.extractAnnotations(mClass, cls);
        }
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        if (declaredClasses != null) {
            for (int i = 0; i < declaredClasses.length; i++) {
                ReflectTigerDelegate reflectTigerDelegate4 = this.mTigerDelegate;
                if (reflectTigerDelegate4 == null || (reflectTigerDelegate4.getEnclosingConstructor(declaredClasses[i]) == null && this.mTigerDelegate.getEnclosingMethod(declaredClasses[i]) == null)) {
                    String name = declaredClasses[i].getName();
                    String substring = name.substring(name.lastIndexOf(36) + 1);
                    char charAt = substring.charAt(0);
                    if ('0' > charAt || charAt > '9') {
                        MClass addNewInnerClass = mClass.addNewInnerClass(substring);
                        addNewInnerClass.setArtifact(declaredClasses[i]);
                        populate(addNewInnerClass);
                    }
                }
            }
        }
    }

    private void initDelegate(ElementContext elementContext) {
        this.mTigerDelegate = ReflectTigerDelegate.create(elementContext);
    }

    private void populate(MField mField, Field field) {
        mField.setArtifact(field);
        mField.setSimpleName(field.getName());
        mField.setType(field.getType().getName());
        mField.setModifiers(field.getModifiers());
        ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
        if (reflectTigerDelegate != null) {
            reflectTigerDelegate.extractAnnotations(mField, field);
        }
    }

    private void populate(MConstructor mConstructor, Constructor constructor) {
        mConstructor.setArtifact(constructor);
        mConstructor.setSimpleName(constructor.getName());
        mConstructor.setModifiers(constructor.getModifiers());
        addThrows(mConstructor, constructor.getExceptionTypes());
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            MParameter addParameter = addParameter(mConstructor, i, parameterTypes[i]);
            ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
            if (reflectTigerDelegate != null) {
                reflectTigerDelegate.extractAnnotations(addParameter, constructor, i);
            }
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.extractAnnotations(mConstructor, constructor);
        }
    }

    private void populate(MMethod mMethod, Method method) {
        mMethod.setArtifact(method);
        mMethod.setSimpleName(method.getName());
        mMethod.setModifiers(method.getModifiers());
        mMethod.setReturnType(method.getReturnType().getName());
        addThrows(mMethod, method.getExceptionTypes());
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            MParameter addParameter = addParameter(mMethod, i, parameterTypes[i]);
            ReflectTigerDelegate reflectTigerDelegate = this.mTigerDelegate;
            if (reflectTigerDelegate != null) {
                reflectTigerDelegate.extractAnnotations(addParameter, method, i);
            }
        }
        ReflectTigerDelegate reflectTigerDelegate2 = this.mTigerDelegate;
        if (reflectTigerDelegate2 != null) {
            reflectTigerDelegate2.extractAnnotations(mMethod, method);
        }
    }

    private void addThrows(MInvokable mInvokable, Class[] clsArr) {
        for (Class cls : clsArr) {
            mInvokable.addException(cls.getName());
        }
    }

    private MParameter addParameter(MInvokable mInvokable, int i, Class cls) {
        MParameter addNewParameter = mInvokable.addNewParameter();
        addNewParameter.setSimpleName(new StringBuffer().append("param").append(i).toString());
        addNewParameter.setType(cls.getName());
        return addNewParameter;
    }
}
