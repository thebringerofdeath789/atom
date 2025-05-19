package org.apache.xmlbeans.impl.config;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* loaded from: classes5.dex */
public class UserTypeImpl implements UserType {
    private String _javaName;
    private QName _name;
    private String _staticHandler;

    static UserTypeImpl newInstance(JamClassLoader jamClassLoader, Usertypeconfig usertypeconfig) {
        UserTypeImpl userTypeImpl = new UserTypeImpl();
        userTypeImpl._name = usertypeconfig.getName();
        userTypeImpl._javaName = usertypeconfig.getJavaname();
        userTypeImpl._staticHandler = usertypeconfig.getStaticHandler();
        return userTypeImpl;
    }

    @Override // org.apache.xmlbeans.UserType
    public String getJavaName() {
        return this._javaName;
    }

    @Override // org.apache.xmlbeans.UserType
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.UserType
    public String getStaticHandler() {
        return this._staticHandler;
    }
}
