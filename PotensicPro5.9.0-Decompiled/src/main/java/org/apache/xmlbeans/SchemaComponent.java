package org.apache.xmlbeans;

import aavax.xml.namespace.QName;

/* loaded from: classes5.dex */
public interface SchemaComponent {
    public static final int ANNOTATION = 8;
    public static final int ATTRIBUTE = 3;
    public static final int ATTRIBUTE_GROUP = 4;
    public static final int ELEMENT = 1;
    public static final int IDENTITY_CONSTRAINT = 5;
    public static final int MODEL_GROUP = 6;
    public static final int NOTATION = 7;
    public static final int TYPE = 0;

    Ref getComponentRef();

    int getComponentType();

    QName getName();

    String getSourceName();

    SchemaTypeSystem getTypeSystem();

    /* renamed from: org.apache.xmlbeans.SchemaComponent$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$SchemaComponent;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    public static abstract class Ref {
        static final /* synthetic */ boolean $assertionsDisabled;
        public String _handle;
        private volatile SchemaComponent _schemaComponent;
        private SchemaTypeSystem _schemaTypeSystem;

        public abstract int getComponentType();

        static {
            if (AnonymousClass1.class$org$apache$xmlbeans$SchemaComponent == null) {
                AnonymousClass1.class$org$apache$xmlbeans$SchemaComponent = AnonymousClass1.class$("org.apache.xmlbeans.SchemaComponent");
            } else {
                Class cls = AnonymousClass1.class$org$apache$xmlbeans$SchemaComponent;
            }
            $assertionsDisabled = true;
        }

        protected Ref(SchemaComponent schemaComponent) {
            this._schemaComponent = schemaComponent;
        }

        protected Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            if (!$assertionsDisabled && str == null) {
                throw new AssertionError();
            }
            this._schemaTypeSystem = schemaTypeSystem;
            this._handle = str;
        }

        public final SchemaTypeSystem getTypeSystem() {
            return this._schemaTypeSystem;
        }

        public final SchemaComponent getComponent() {
            String str;
            if (this._schemaComponent == null && this._handle != null) {
                synchronized (this) {
                    if (this._schemaComponent == null && (str = this._handle) != null) {
                        this._schemaComponent = this._schemaTypeSystem.resolveHandle(str);
                        this._schemaTypeSystem = null;
                    }
                }
            }
            return this._schemaComponent;
        }
    }
}
