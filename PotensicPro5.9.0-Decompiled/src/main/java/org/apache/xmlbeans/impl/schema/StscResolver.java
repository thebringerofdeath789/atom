package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;

/* loaded from: classes5.dex */
public class StscResolver {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscResolver;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscResolver == null) {
            class$org$apache$xmlbeans$impl$schema$StscResolver = class$("org.apache.xmlbeans.impl.schema.StscResolver");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void resolveAll() {
        StscState stscState = StscState.get();
        for (SchemaType schemaType : stscState.documentTypes()) {
            resolveSubstitutionGroup((SchemaTypeImpl) schemaType);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType2 = (SchemaType) arrayList.get(i);
            resolveType((SchemaTypeImpl) schemaType2);
            arrayList.addAll(Arrays.asList(schemaType2.getAnonymousTypes()));
        }
        resolveIdentityConstraints();
    }

    public static boolean resolveType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isResolved()) {
            return true;
        }
        if (schemaTypeImpl.isResolving()) {
            StscState.get().error("Cyclic dependency error", 13, schemaTypeImpl.getParseObject());
            return false;
        }
        schemaTypeImpl.startResolving();
        if (schemaTypeImpl.isDocumentType()) {
            resolveDocumentType(schemaTypeImpl);
        } else if (schemaTypeImpl.isAttributeType()) {
            resolveAttributeType(schemaTypeImpl);
        } else if (schemaTypeImpl.isSimpleType()) {
            StscSimpleTypeResolver.resolveSimpleType(schemaTypeImpl);
        } else {
            StscComplexTypeResolver.resolveComplexType(schemaTypeImpl);
        }
        schemaTypeImpl.finishResolving();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0082 -> B:20:0x0083). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r8) {
        /*
            boolean r0 = org.apache.xmlbeans.impl.schema.StscResolver.$assertionsDisabled
            if (r0 != 0) goto L11
            boolean r0 = r8.isDocumentType()
            if (r0 == 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L11:
            boolean r0 = r8.isSGResolved()
            r1 = 1
            if (r0 == 0) goto L19
            return r1
        L19:
            boolean r0 = r8.isSGResolving()
            if (r0 == 0) goto L30
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            r1 = 13
            org.apache.xmlbeans.XmlObject r8 = r8.getParseObject()
            java.lang.String r2 = "Cyclic dependency error"
            r0.error(r2, r1, r8)
            r8 = 0
            return r8
        L30:
            r8.startResolvingSGs()
            org.apache.xmlbeans.XmlObject r0 = r8.getParseObject()
            org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement r0 = (org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement) r0
            aavax.xml.namespace.QName r2 = new aavax.xml.namespace.QName
            java.lang.String r3 = r8.getTargetNamespace()
            java.lang.String r4 = r0.getName()
            r2.<init>(r3, r4)
            boolean r3 = r0.isSetSubstitutionGroup()
            r4 = 0
            if (r3 == 0) goto L82
            org.apache.xmlbeans.impl.schema.StscState r3 = org.apache.xmlbeans.impl.schema.StscState.get()
            aavax.xml.namespace.QName r5 = r0.getSubstitutionGroup()
            java.lang.String r6 = r8.getChameleonNamespace()
            java.lang.String r7 = r8.getTargetNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r3.findDocumentType(r5, r6, r7)
            if (r3 != 0) goto L73
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            aavax.xml.namespace.QName r6 = r0.getSubstitutionGroup()
            org.apache.xmlbeans.XmlQName r0 = r0.xgetSubstitutionGroup()
            r5.notFoundError(r6, r1, r0, r1)
            goto L83
        L73:
            boolean r5 = resolveSubstitutionGroup(r3)
            if (r5 != 0) goto L7a
            goto L82
        L7a:
            aavax.xml.namespace.QName r0 = r0.getSubstitutionGroup()
            r8.setSubstitutionGroup(r0)
            goto L83
        L82:
            r3 = r4
        L83:
            if (r3 == 0) goto Lca
            r3.addSubstitutionGroupMember(r2)
            aavax.xml.namespace.QName r0 = r3.getSubstitutionGroup()
            if (r0 != 0) goto L8f
            goto Lca
        L8f:
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            aavax.xml.namespace.QName r5 = r3.getSubstitutionGroup()
            java.lang.String r3 = r3.getChameleonNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r0.findDocumentType(r5, r3, r4)
            boolean r0 = org.apache.xmlbeans.impl.schema.StscResolver.$assertionsDisabled
            if (r0 != 0) goto Lc3
            if (r3 == 0) goto La6
            goto Lc3
        La6:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Could not find document type for: "
            java.lang.StringBuffer r0 = r0.append(r1)
            aavax.xml.namespace.QName r1 = r3.getSubstitutionGroup()
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        Lc3:
            boolean r0 = resolveSubstitutionGroup(r3)
            if (r0 != 0) goto L83
            goto L82
        Lca:
            r8.finishResolvingSGs()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscResolver.resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):boolean");
    }

    public static void resolveDocumentType(SchemaTypeImpl schemaTypeImpl) {
        SchemaLocalElementImpl schemaLocalElementImpl;
        SchemaTypeImpl findDocumentType;
        boolean z = $assertionsDisabled;
        if (!z && !schemaTypeImpl.isResolving()) {
            throw new AssertionError();
        }
        if (!z && !schemaTypeImpl.isDocumentType()) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) StscTranslator.translateElement((Element) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.isChameleon(), null, null, arrayList, schemaTypeImpl);
        if (schemaGlobalElementImpl != null) {
            StscState.get().addGlobalElement(schemaGlobalElementImpl);
            SchemaLocalElementImpl schemaLocalElementImpl2 = new SchemaLocalElementImpl();
            schemaLocalElementImpl2.setParticleType(4);
            StscTranslator.copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl2);
            schemaLocalElementImpl2.setMinOccurs(BigInteger.ONE);
            schemaLocalElementImpl2.setMaxOccurs(BigInteger.ONE);
            schemaLocalElementImpl2.setTransitionNotes(QNameSet.EMPTY, true);
            schemaLocalElementImpl = schemaLocalElementImpl2;
        } else {
            schemaLocalElementImpl = null;
        }
        Map buildContentPropertyModelByQName = StscComplexTypeResolver.buildContentPropertyModelByQName(schemaLocalElementImpl, schemaTypeImpl);
        if (schemaTypeImpl.getSubstitutionGroup() == null) {
            findDocumentType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        } else {
            findDocumentType = StscState.get().findDocumentType(schemaTypeImpl.getSubstitutionGroup(), schemaTypeImpl.isChameleon() ? schemaTypeImpl.getTargetNamespace() : null, null);
        }
        schemaTypeImpl.setBaseTypeRef(findDocumentType.getRef());
        schemaTypeImpl.setBaseDepth(findDocumentType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(3);
        schemaTypeImpl.setContentModel(schemaLocalElementImpl, new SchemaAttributeModelImpl(), buildContentPropertyModelByQName, Collections.EMPTY_MAP, false);
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveAttributeType(SchemaTypeImpl schemaTypeImpl) {
        boolean z = $assertionsDisabled;
        if (!z && !schemaTypeImpl.isResolving()) {
            throw new AssertionError();
        }
        if (!z && !schemaTypeImpl.isAttributeType()) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) StscTranslator.translateAttribute((Attribute) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), null, schemaTypeImpl.isChameleon(), arrayList, schemaTypeImpl, null, false);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        if (schemaGlobalAttributeImpl != null) {
            StscState.get().addGlobalAttribute(schemaGlobalAttributeImpl);
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            StscTranslator.copyGlobalAttributeToLocalAttribute(schemaGlobalAttributeImpl, schemaLocalAttributeImpl);
            schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        }
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(1);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, Collections.EMPTY_MAP, StscComplexTypeResolver.buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl), false);
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    private static SchemaType.Ref[] makeRefArray(Collection collection) {
        SchemaType.Ref[] refArr = new SchemaType.Ref[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            refArr[i] = ((SchemaType) it.next()).getRef();
            i++;
        }
        return refArr;
    }

    public static void resolveIdentityConstraints() {
        StscState stscState = StscState.get();
        SchemaIdentityConstraintImpl[] idConstraints = stscState.idConstraints();
        for (int i = 0; i < idConstraints.length; i++) {
            if (!idConstraints[i].isResolved()) {
                KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) idConstraints[i].getParseObject();
                QName refer = keyref.getRefer();
                SchemaIdentityConstraintImpl findIdConstraint = stscState.findIdConstraint(refer, idConstraints[i].getChameleonNamespace(), idConstraints[i].getTargetNamespace());
                if (findIdConstraint == null) {
                    stscState.notFoundError(refer, 5, keyref, true);
                } else {
                    if (findIdConstraint.getConstraintCategory() == 2) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEYREF_REFERS_TO_KEYREF, (Object[]) null, idConstraints[i].getParseObject());
                    }
                    if (findIdConstraint.getFields().length != idConstraints[i].getFields().length) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEY_KEYREF_FIELD_COUNT_EQ, (Object[]) null, idConstraints[i].getParseObject());
                    }
                    idConstraints[i].setReferencedKey(findIdConstraint.getRef());
                }
            }
        }
    }
}
