package org.dom4j.util;

/* loaded from: classes5.dex */
public class SimpleSingleton implements SingletonStrategy {
    private String singletonClassName = null;
    private Object singletonInstance = null;

    @Override // org.dom4j.util.SingletonStrategy
    public Object instance() {
        return this.singletonInstance;
    }

    @Override // org.dom4j.util.SingletonStrategy
    public void reset() {
        if (this.singletonClassName != null) {
            try {
                try {
                    this.singletonInstance = Thread.currentThread().getContextClassLoader().loadClass(this.singletonClassName).newInstance();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                this.singletonInstance = Class.forName(this.singletonClassName).newInstance();
            }
        }
    }

    @Override // org.dom4j.util.SingletonStrategy
    public void setSingletonClassName(String str) {
        this.singletonClassName = str;
        reset();
    }
}
