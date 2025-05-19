package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaBookmark;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.common.XPath;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.schema.StscImporter;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* loaded from: classes5.dex */
public class StscTranslator {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String FORM_QUALIFIED = "qualified";
    private static final QName WSDL_ARRAYTYPE_NAME;
    public static final RegularExpression XPATH_REGEXP;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaBookmark;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscTranslator;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscTranslator == null) {
            class$org$apache$xmlbeans$impl$schema$StscTranslator = class$("org.apache.xmlbeans.impl.schema.StscTranslator");
        }
        $assertionsDisabled = true;
        WSDL_ARRAYTYPE_NAME = QNameHelper.forLNS(SoapEncSchemaTypeSystem.ARRAY_TYPE, "http://schemas.xmlsoap.org/wsdl/");
        XPATH_REGEXP = new RegularExpression("(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*))))(\\|(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*)))))*", "X");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void addAllDefinitions(StscImporter.SchemaToProcess[] schemaToProcessArr) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < schemaToProcessArr.length; i2++) {
            List redefines = schemaToProcessArr[i2].getRedefines();
            if (redefines != null) {
                List redefineObjects = schemaToProcessArr[i2].getRedefineObjects();
                Iterator it = redefines.iterator();
                Iterator it2 = redefineObjects.iterator();
                while (it.hasNext()) {
                    if (!$assertionsDisabled && !it2.hasNext()) {
                        throw new AssertionError("The array of redefines and redefine objects have to have the same length");
                    }
                    arrayList.add(new RedefinitionHolder((StscImporter.SchemaToProcess) it.next(), (RedefineDocument.Redefine) it2.next()));
                }
            }
        }
        RedefinitionMaster redefinitionMaster = new RedefinitionMaster((RedefinitionHolder[]) arrayList.toArray(new RedefinitionHolder[arrayList.size()]));
        StscState stscState = StscState.get();
        int i3 = 0;
        while (i3 < schemaToProcessArr.length) {
            SchemaDocument.Schema schema = schemaToProcessArr[i3].getSchema();
            String chameleonNamespace = schemaToProcessArr[i3].getChameleonNamespace();
            if (schema.sizeOfNotationArray() > 0) {
                stscState.warning("Schema <notation> is not yet supported for this release.", 51, schema.getNotationArray(i));
            }
            String targetNamespace = schema.getTargetNamespace();
            if (chameleonNamespace == null || targetNamespace != null) {
                chameleonNamespace = targetNamespace;
                z = i;
            } else {
                z = 1;
            }
            if (chameleonNamespace == null) {
                chameleonNamespace = "";
            }
            if (chameleonNamespace.length() > 0 || !isEmptySchema(schema)) {
                stscState.registerContribution(chameleonNamespace, schema.documentProperties().getSourceName());
                stscState.addNewContainer(chameleonNamespace);
            }
            ArrayList arrayList2 = new ArrayList();
            TopLevelComplexType[] complexTypeArray = schema.getComplexTypeArray();
            for (int i4 = i; i4 < complexTypeArray.length; i4++) {
                TopLevelComplexType topLevelComplexType = complexTypeArray[i4];
                RedefinitionHolder[] complexTypeRedefinitions = redefinitionMaster.getComplexTypeRedefinitions(topLevelComplexType.getName(), schemaToProcessArr[i3]);
                for (int i5 = 0; i5 < complexTypeRedefinitions.length; i5++) {
                    if (complexTypeRedefinitions[i5] != null) {
                        TopLevelComplexType redefineComplexType = complexTypeRedefinitions[i5].redefineComplexType(topLevelComplexType.getName());
                        if (!$assertionsDisabled && redefineComplexType == null) {
                            throw new AssertionError();
                        }
                        arrayList2.add(topLevelComplexType);
                        topLevelComplexType = redefineComplexType;
                    }
                }
                SchemaTypeImpl translateGlobalComplexType = translateGlobalComplexType(topLevelComplexType, chameleonNamespace, z, arrayList2.size() > 0);
                stscState.addGlobalType(translateGlobalComplexType, null);
                int size = arrayList2.size() - 1;
                while (size >= 0) {
                    SchemaTypeImpl translateGlobalComplexType2 = translateGlobalComplexType((TopLevelComplexType) arrayList2.remove(size), chameleonNamespace, z, size > 0);
                    stscState.addGlobalType(translateGlobalComplexType2, translateGlobalComplexType);
                    size--;
                    translateGlobalComplexType = translateGlobalComplexType2;
                }
            }
            TopLevelSimpleType[] simpleTypeArray = schema.getSimpleTypeArray();
            for (int i6 = 0; i6 < simpleTypeArray.length; i6++) {
                TopLevelSimpleType topLevelSimpleType = simpleTypeArray[i6];
                RedefinitionHolder[] simpleTypeRedefinitions = redefinitionMaster.getSimpleTypeRedefinitions(topLevelSimpleType.getName(), schemaToProcessArr[i3]);
                for (int i7 = 0; i7 < simpleTypeRedefinitions.length; i7++) {
                    if (simpleTypeRedefinitions[i7] != null) {
                        TopLevelSimpleType redefineSimpleType = simpleTypeRedefinitions[i7].redefineSimpleType(topLevelSimpleType.getName());
                        if (!$assertionsDisabled && redefineSimpleType == null) {
                            throw new AssertionError();
                        }
                        arrayList2.add(topLevelSimpleType);
                        topLevelSimpleType = redefineSimpleType;
                    }
                }
                SchemaTypeImpl translateGlobalSimpleType = translateGlobalSimpleType(topLevelSimpleType, chameleonNamespace, z, arrayList2.size() > 0);
                stscState.addGlobalType(translateGlobalSimpleType, null);
                int size2 = arrayList2.size() - 1;
                while (size2 >= 0) {
                    SchemaTypeImpl translateGlobalSimpleType2 = translateGlobalSimpleType((TopLevelSimpleType) arrayList2.remove(size2), chameleonNamespace, z, size2 > 0);
                    stscState.addGlobalType(translateGlobalSimpleType2, translateGlobalSimpleType);
                    size2--;
                    translateGlobalSimpleType = translateGlobalSimpleType2;
                }
            }
            for (TopLevelElement topLevelElement : schema.getElementArray()) {
                stscState.addDocumentType(translateDocumentType(topLevelElement, chameleonNamespace, z), QNameHelper.forLNS(topLevelElement.getName(), chameleonNamespace));
            }
            for (TopLevelAttribute topLevelAttribute : schema.getAttributeArray()) {
                stscState.addAttributeType(translateAttributeType(topLevelAttribute, chameleonNamespace, z), QNameHelper.forLNS(topLevelAttribute.getName(), chameleonNamespace));
            }
            NamedGroup[] groupArray = schema.getGroupArray();
            for (int i8 = 0; i8 < groupArray.length; i8++) {
                NamedGroup namedGroup = groupArray[i8];
                RedefinitionHolder[] modelGroupRedefinitions = redefinitionMaster.getModelGroupRedefinitions(namedGroup.getName(), schemaToProcessArr[i3]);
                for (int i9 = 0; i9 < modelGroupRedefinitions.length; i9++) {
                    if (modelGroupRedefinitions[i9] != null) {
                        NamedGroup redefineModelGroup = modelGroupRedefinitions[i9].redefineModelGroup(namedGroup.getName());
                        if (!$assertionsDisabled && redefineModelGroup == null) {
                            throw new AssertionError();
                        }
                        arrayList2.add(namedGroup);
                        namedGroup = redefineModelGroup;
                    }
                }
                SchemaModelGroupImpl translateModelGroup = translateModelGroup(namedGroup, chameleonNamespace, z, arrayList2.size() > 0);
                stscState.addModelGroup(translateModelGroup, null);
                int size3 = arrayList2.size() - 1;
                while (size3 >= 0) {
                    SchemaModelGroupImpl translateModelGroup2 = translateModelGroup((NamedGroup) arrayList2.remove(size3), chameleonNamespace, z, size3 > 0);
                    stscState.addModelGroup(translateModelGroup2, translateModelGroup);
                    size3--;
                    translateModelGroup = translateModelGroup2;
                }
            }
            NamedAttributeGroup[] attributeGroupArray = schema.getAttributeGroupArray();
            for (int i10 = 0; i10 < attributeGroupArray.length; i10++) {
                NamedAttributeGroup namedAttributeGroup = attributeGroupArray[i10];
                RedefinitionHolder[] attributeGroupRedefinitions = redefinitionMaster.getAttributeGroupRedefinitions(namedAttributeGroup.getName(), schemaToProcessArr[i3]);
                for (int i11 = 0; i11 < attributeGroupRedefinitions.length; i11++) {
                    if (attributeGroupRedefinitions[i11] != null) {
                        NamedAttributeGroup redefineAttributeGroup = attributeGroupRedefinitions[i11].redefineAttributeGroup(namedAttributeGroup.getName());
                        if (!$assertionsDisabled && redefineAttributeGroup == null) {
                            throw new AssertionError();
                        }
                        arrayList2.add(namedAttributeGroup);
                        namedAttributeGroup = redefineAttributeGroup;
                    }
                }
                SchemaAttributeGroupImpl translateAttributeGroup = translateAttributeGroup(namedAttributeGroup, chameleonNamespace, z, arrayList2.size() > 0);
                stscState.addAttributeGroup(translateAttributeGroup, null);
                int size4 = arrayList2.size() - 1;
                while (size4 >= 0) {
                    SchemaAttributeGroupImpl translateAttributeGroup2 = translateAttributeGroup((NamedAttributeGroup) arrayList2.remove(size4), chameleonNamespace, z, size4 > 0);
                    stscState.addAttributeGroup(translateAttributeGroup2, translateAttributeGroup);
                    size4--;
                    translateAttributeGroup = translateAttributeGroup2;
                }
            }
            for (AnnotationDocument.Annotation annotation : schema.getAnnotationArray()) {
                stscState.addAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(chameleonNamespace), schema, annotation), chameleonNamespace);
            }
            i3++;
            i = 0;
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            ((RedefinitionHolder) arrayList.get(i12)).complainAboutMissingDefinitions();
        }
    }

    private static class RedefinitionHolder {
        private Map agRedefinitions;
        private Map ctRedefinitions;
        private Map mgRedefinitions;
        private String schemaLocation;
        private StscImporter.SchemaToProcess schemaRedefined;
        private Map stRedefinitions;

        RedefinitionHolder(StscImporter.SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            this.stRedefinitions = Collections.EMPTY_MAP;
            this.ctRedefinitions = Collections.EMPTY_MAP;
            this.agRedefinitions = Collections.EMPTY_MAP;
            this.mgRedefinitions = Collections.EMPTY_MAP;
            this.schemaLocation = "";
            this.schemaRedefined = schemaToProcess;
            if (redefine != null) {
                StscState stscState = StscState.get();
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                if (redefine.getSchemaLocation() != null) {
                    this.schemaLocation = redefine.getSchemaLocation();
                }
                TopLevelComplexType[] complexTypeArray = redefine.getComplexTypeArray();
                for (int i = 0; i < complexTypeArray.length; i++) {
                    if (complexTypeArray[i].getName() != null) {
                        if (this.ctRedefinitions.containsKey(complexTypeArray[i].getName())) {
                            stscState.error(new StringBuffer().append("Duplicate type redefinition: ").append(complexTypeArray[i].getName()).toString(), 49, (XmlObject) null);
                        } else {
                            this.ctRedefinitions.put(complexTypeArray[i].getName(), complexTypeArray[i]);
                        }
                    }
                }
                TopLevelSimpleType[] simpleTypeArray = redefine.getSimpleTypeArray();
                for (int i2 = 0; i2 < simpleTypeArray.length; i2++) {
                    if (simpleTypeArray[i2].getName() != null) {
                        if (this.stRedefinitions.containsKey(simpleTypeArray[i2].getName())) {
                            stscState.error(new StringBuffer().append("Duplicate type redefinition: ").append(simpleTypeArray[i2].getName()).toString(), 49, (XmlObject) null);
                        } else {
                            this.stRedefinitions.put(simpleTypeArray[i2].getName(), simpleTypeArray[i2]);
                        }
                    }
                }
                NamedGroup[] groupArray = redefine.getGroupArray();
                for (int i3 = 0; i3 < groupArray.length; i3++) {
                    if (groupArray[i3].getName() != null) {
                        if (this.mgRedefinitions.containsKey(groupArray[i3].getName())) {
                            stscState.error(new StringBuffer().append("Duplicate type redefinition: ").append(groupArray[i3].getName()).toString(), 49, (XmlObject) null);
                        } else {
                            this.mgRedefinitions.put(groupArray[i3].getName(), groupArray[i3]);
                        }
                    }
                }
                NamedAttributeGroup[] attributeGroupArray = redefine.getAttributeGroupArray();
                for (int i4 = 0; i4 < attributeGroupArray.length; i4++) {
                    if (attributeGroupArray[i4].getName() != null) {
                        if (this.agRedefinitions.containsKey(attributeGroupArray[i4].getName())) {
                            stscState.error(new StringBuffer().append("Duplicate type redefinition: ").append(attributeGroupArray[i4].getName()).toString(), 49, (XmlObject) null);
                        } else {
                            this.agRedefinitions.put(attributeGroupArray[i4].getName(), attributeGroupArray[i4]);
                        }
                    }
                }
            }
        }

        public TopLevelSimpleType redefineSimpleType(String str) {
            if (str == null || !this.stRedefinitions.containsKey(str)) {
                return null;
            }
            return (TopLevelSimpleType) this.stRedefinitions.remove(str);
        }

        public TopLevelComplexType redefineComplexType(String str) {
            if (str == null || !this.ctRedefinitions.containsKey(str)) {
                return null;
            }
            return (TopLevelComplexType) this.ctRedefinitions.remove(str);
        }

        public NamedGroup redefineModelGroup(String str) {
            if (str == null || !this.mgRedefinitions.containsKey(str)) {
                return null;
            }
            return (NamedGroup) this.mgRedefinitions.remove(str);
        }

        public NamedAttributeGroup redefineAttributeGroup(String str) {
            if (str == null || !this.agRedefinitions.containsKey(str)) {
                return null;
            }
            return (NamedAttributeGroup) this.agRedefinitions.remove(str);
        }

        public void complainAboutMissingDefinitions() {
            if (this.stRedefinitions.isEmpty() && this.ctRedefinitions.isEmpty() && this.agRedefinitions.isEmpty() && this.mgRedefinitions.isEmpty()) {
                return;
            }
            StscState stscState = StscState.get();
            for (String str : this.stRedefinitions.keySet()) {
                stscState.error(new StringBuffer().append("Redefined simple type ").append(str).append(" not found in ").append(this.schemaLocation).toString(), 60, (XmlObject) this.stRedefinitions.get(str));
            }
            for (String str2 : this.ctRedefinitions.keySet()) {
                stscState.error(new StringBuffer().append("Redefined complex type ").append(str2).append(" not found in ").append(this.schemaLocation).toString(), 60, (XmlObject) this.ctRedefinitions.get(str2));
            }
            for (String str3 : this.agRedefinitions.keySet()) {
                stscState.error(new StringBuffer().append("Redefined attribute group ").append(str3).append(" not found in ").append(this.schemaLocation).toString(), 60, (XmlObject) this.agRedefinitions.get(str3));
            }
            for (String str4 : this.mgRedefinitions.keySet()) {
                stscState.error(new StringBuffer().append("Redefined model group ").append(str4).append(" not found in ").append(this.schemaLocation).toString(), 60, (XmlObject) this.mgRedefinitions.get(str4));
            }
        }
    }

    private static class RedefinitionMaster {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final short ATTRIBUTE_GROUP = 4;
        private static final short COMPLEX_TYPE = 2;
        private static final RedefinitionHolder[] EMPTY_REDEFINTION_HOLDER_ARRAY;
        private static final short MODEL_GROUP = 3;
        private static final short SIMPLE_TYPE = 1;
        private Map agRedefinitions;
        private Map ctRedefinitions;
        private Map mgRedefinitions;
        private Map stRedefinitions;

        private String componentNameFromCode(short s) {
            return s != 1 ? s != 2 ? s != 3 ? s != 4 ? "" : "attribute group" : "model group" : "complex type" : "simple type";
        }

        static {
            if (StscTranslator.class$org$apache$xmlbeans$impl$schema$StscTranslator == null) {
                StscTranslator.class$org$apache$xmlbeans$impl$schema$StscTranslator = StscTranslator.class$("org.apache.xmlbeans.impl.schema.StscTranslator");
            } else {
                Class cls = StscTranslator.class$org$apache$xmlbeans$impl$schema$StscTranslator;
            }
            $assertionsDisabled = true;
            EMPTY_REDEFINTION_HOLDER_ARRAY = new RedefinitionHolder[0];
        }

        RedefinitionMaster(RedefinitionHolder[] redefinitionHolderArr) {
            this.stRedefinitions = Collections.EMPTY_MAP;
            this.ctRedefinitions = Collections.EMPTY_MAP;
            this.agRedefinitions = Collections.EMPTY_MAP;
            this.mgRedefinitions = Collections.EMPTY_MAP;
            if (redefinitionHolderArr.length > 0) {
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                for (int i = 0; i < redefinitionHolderArr.length; i++) {
                    RedefinitionHolder redefinitionHolder = redefinitionHolderArr[i];
                    for (Object obj : redefinitionHolder.stRedefinitions.keySet()) {
                        List list = (List) this.stRedefinitions.get(obj);
                        if (list == null) {
                            list = new ArrayList();
                            this.stRedefinitions.put(obj, list);
                        }
                        list.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj2 : redefinitionHolder.ctRedefinitions.keySet()) {
                        List list2 = (List) this.ctRedefinitions.get(obj2);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.ctRedefinitions.put(obj2, list2);
                        }
                        list2.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj3 : redefinitionHolder.agRedefinitions.keySet()) {
                        List list3 = (List) this.agRedefinitions.get(obj3);
                        if (list3 == null) {
                            list3 = new ArrayList();
                            this.agRedefinitions.put(obj3, list3);
                        }
                        list3.add(redefinitionHolderArr[i]);
                    }
                    for (Object obj4 : redefinitionHolder.mgRedefinitions.keySet()) {
                        List list4 = (List) this.mgRedefinitions.get(obj4);
                        if (list4 == null) {
                            list4 = new ArrayList();
                            this.mgRedefinitions.put(obj4, list4);
                        }
                        list4.add(redefinitionHolderArr[i]);
                    }
                }
            }
        }

        RedefinitionHolder[] getSimpleTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.stRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 1);
        }

        RedefinitionHolder[] getComplexTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.ctRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 2);
        }

        RedefinitionHolder[] getAttributeGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.agRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 4);
        }

        RedefinitionHolder[] getModelGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List list = (List) this.mgRedefinitions.get(str);
            if (list == null) {
                return EMPTY_REDEFINTION_HOLDER_ARRAY;
            }
            return doTopologicalSort(list, schemaToProcess, str, (short) 3);
        }

        private RedefinitionHolder[] doTopologicalSort(List list, StscImporter.SchemaToProcess schemaToProcess, String str, short s) {
            RedefinitionHolder[] redefinitionHolderArr = new RedefinitionHolder[list.size()];
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                RedefinitionHolder redefinitionHolder = (RedefinitionHolder) list.get(i2);
                if (redefinitionHolder.schemaRedefined == schemaToProcess || redefinitionHolder.schemaRedefined.indirectIncludes(schemaToProcess)) {
                    redefinitionHolderArr[i] = redefinitionHolder;
                    i++;
                }
            }
            RedefinitionHolder[] redefinitionHolderArr2 = new RedefinitionHolder[i];
            int[] iArr = new int[i];
            int i3 = 0;
            while (i3 < i - 1) {
                RedefinitionHolder redefinitionHolder2 = redefinitionHolderArr[i3];
                int i4 = i3 + 1;
                for (int i5 = i4; i5 < i; i5++) {
                    if (redefinitionHolder2.schemaRedefined.indirectIncludes(redefinitionHolderArr[i5].schemaRedefined)) {
                        iArr[i3] = iArr[i3] + 1;
                    }
                    if (redefinitionHolderArr[i5].schemaRedefined.indirectIncludes(redefinitionHolder2.schemaRedefined)) {
                        iArr[i5] = iArr[i5] + 1;
                    }
                }
                i3 = i4;
            }
            int i6 = 0;
            boolean z = false;
            while (true) {
                XmlObject xmlObject = null;
                if (i6 >= i) {
                    for (int i7 = 1; i7 < i; i7++) {
                        int i8 = i7 - 1;
                        while (i8 >= 0 && redefinitionHolderArr2[i8] == null) {
                            i8--;
                        }
                        if (!redefinitionHolderArr2[i7].schemaRedefined.indirectIncludes(redefinitionHolderArr2[i8].schemaRedefined)) {
                            StscState.get().error(new StringBuffer().append("Detected multiple redefinitions of ").append(componentNameFromCode(s)).append(" \"").append(str).append("\"; Files involved: ").append(redefinitionHolderArr2[i8].schemaRedefined.getSourceName()).append(", ").append(redefinitionHolderArr2[i7].schemaRedefined.getSourceName()).toString(), 49, locationFromRedefinitionAndCode(redefinitionHolderArr2[i7], str, s));
                            if (s == 1) {
                                redefinitionHolderArr2[i7].redefineSimpleType(str);
                            } else if (s == 2) {
                                redefinitionHolderArr2[i7].redefineComplexType(str);
                            } else if (s == 3) {
                                redefinitionHolderArr2[i7].redefineModelGroup(str);
                            } else if (s == 4) {
                                redefinitionHolderArr2[i7].redefineAttributeGroup(str);
                            }
                            redefinitionHolderArr2[i7] = null;
                        }
                    }
                    return redefinitionHolderArr2;
                }
                int i9 = -1;
                for (int i10 = 0; i10 < i; i10++) {
                    if (iArr[i10] == 0 && i9 < 0) {
                        i9 = i10;
                    }
                }
                if (i9 < 0) {
                    if (!z) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i11 = 0; i11 < i; i11++) {
                            if (redefinitionHolderArr[i11] != null) {
                                stringBuffer.append(redefinitionHolderArr[i11].schemaLocation).append(',').append(' ');
                                if (xmlObject == null) {
                                    xmlObject = locationFromRedefinitionAndCode(redefinitionHolderArr[i11], str, s);
                                }
                            }
                        }
                        StscState.get().error(new StringBuffer().append("Detected circular redefinition of ").append(componentNameFromCode(s)).append(" \"").append(str).append("\"; Files involved: ").append(stringBuffer.toString()).toString(), 60, xmlObject);
                        z = true;
                    }
                    int i12 = i;
                    for (int i13 = 0; i13 < i; i13++) {
                        if (iArr[i13] > 0 && iArr[i13] < i12) {
                            i12 = iArr[i13];
                            i9 = i13;
                        }
                    }
                    iArr[i9] = iArr[i9] - 1;
                } else {
                    if (!$assertionsDisabled && redefinitionHolderArr[i9] == null) {
                        throw new AssertionError();
                    }
                    int i14 = i6 + 1;
                    redefinitionHolderArr2[i6] = redefinitionHolderArr[i9];
                    for (int i15 = 0; i15 < i; i15++) {
                        if (redefinitionHolderArr[i15] != null && redefinitionHolderArr[i15].schemaRedefined.indirectIncludes(redefinitionHolderArr[i9].schemaRedefined)) {
                            iArr[i15] = iArr[i15] - 1;
                        }
                    }
                    redefinitionHolderArr[i9] = null;
                    iArr[i9] = iArr[i9] - 1;
                    i6 = i14;
                }
            }
        }

        private XmlObject locationFromRedefinitionAndCode(RedefinitionHolder redefinitionHolder, String str, short s) {
            if (s == 1) {
                return (XmlObject) redefinitionHolder.stRedefinitions.get(str);
            }
            if (s == 2) {
                return (XmlObject) redefinitionHolder.ctRedefinitions.get(str);
            }
            if (s == 3) {
                return (XmlObject) redefinitionHolder.mgRedefinitions.get(str);
            }
            if (s != 4) {
                return null;
            }
            return (XmlObject) redefinitionHolder.agRedefinitions.get(str);
        }
    }

    private static String findFilename(XmlObject xmlObject) {
        return StscState.get().sourceNameForUri(xmlObject.documentProperties().getSourceName());
    }

    private static SchemaTypeImpl translateDocumentType(TopLevelElement topLevelElement, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setDocumentType(true);
        schemaTypeImpl.setParseContext(topLevelElement, str, z, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelElement));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateAttributeType(TopLevelAttribute topLevelAttribute, String str, boolean z) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setAttributeType(true);
        schemaTypeImpl.setParseContext(topLevelAttribute, str, z, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelAttribute));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalComplexType(TopLevelComplexType topLevelComplexType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelComplexType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelComplexType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelComplexType.xgetName());
        }
        QName forLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(forLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(forLNS)}, topLevelComplexType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setParseContext(topLevelComplexType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelComplexType));
        schemaTypeImpl.setName(QNameHelper.forLNS(name, str));
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelComplexType));
        schemaTypeImpl.setUserData(getUserData(topLevelComplexType));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalSimpleType(TopLevelSimpleType topLevelSimpleType, String str, boolean z, boolean z2) {
        StscState stscState = StscState.get();
        String name = topLevelSimpleType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelSimpleType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelSimpleType.xgetName());
        }
        QName forLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(forLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(forLNS)}, topLevelSimpleType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(topLevelSimpleType, str, z, null, null, z2);
        schemaTypeImpl.setFilename(findFilename(topLevelSimpleType));
        schemaTypeImpl.setName(forLNS);
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelSimpleType));
        schemaTypeImpl.setUserData(getUserData(topLevelSimpleType));
        return schemaTypeImpl;
    }

    static SchemaTypeImpl translateAnonymousSimpleType(SimpleType simpleType, String str, boolean z, String str2, String str3, List list, SchemaType schemaType) {
        StscState stscState = StscState.get();
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(simpleType, str, z, str2, str3, false);
        schemaTypeImpl.setOuterSchemaTypeRef(schemaType.getRef());
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), simpleType));
        schemaTypeImpl.setUserData(getUserData(simpleType));
        list.add(schemaTypeImpl);
        return schemaTypeImpl;
    }

    static FormChoice findElementFormDefault(XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        while (newCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            if (!newCursor.toParent()) {
                return null;
            }
        }
        return ((SchemaDocument.Schema) newCursor.getObject()).xgetElementFormDefault();
    }

    public static boolean uriMatch(String str, String str2) {
        if (str == null) {
            return str2 == null || str2.equals("");
        }
        if (str2 == null) {
            return str.equals("");
        }
        return str.equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void copyGlobalElementToLocalElement(SchemaGlobalElement schemaGlobalElement, SchemaLocalElementImpl schemaLocalElementImpl) {
        schemaLocalElementImpl.setNameAndTypeRef(schemaGlobalElement.getName(), schemaGlobalElement.getType().getRef());
        schemaLocalElementImpl.setNillable(schemaGlobalElement.isNillable());
        schemaLocalElementImpl.setDefault(schemaGlobalElement.getDefaultText(), schemaGlobalElement.isFixed(), ((SchemaGlobalElementImpl) schemaGlobalElement).getParseObject());
        schemaLocalElementImpl.setIdentityConstraints(((SchemaLocalElementImpl) schemaGlobalElement).getIdentityConstraintRefs());
        schemaLocalElementImpl.setBlock(schemaGlobalElement.blockExtension(), schemaGlobalElement.blockRestriction(), schemaGlobalElement.blockSubstitution());
        schemaLocalElementImpl.setAbstract(schemaGlobalElement.isAbstract());
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        schemaLocalElementImpl.setTransitionRules(schemaParticle.acceptedStartNames(), schemaParticle.isSkippable());
        schemaLocalElementImpl.setAnnotation(schemaGlobalElement.getAnnotation());
    }

    public static void copyGlobalAttributeToLocalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl, SchemaLocalAttributeImpl schemaLocalAttributeImpl) {
        schemaLocalAttributeImpl.init(schemaGlobalAttributeImpl.getName(), schemaGlobalAttributeImpl.getTypeRef(), schemaGlobalAttributeImpl.getUse(), schemaGlobalAttributeImpl.getDefaultText(), schemaGlobalAttributeImpl.getParseObject(), schemaGlobalAttributeImpl._defaultValue, schemaGlobalAttributeImpl.isFixed(), schemaGlobalAttributeImpl.getWSDLArrayType(), schemaGlobalAttributeImpl.getAnnotation(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0371 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v32, types: [org.apache.xmlbeans.impl.schema.SchemaLocalElementImpl] */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.apache.xmlbeans.impl.schema.SchemaLocalElementImpl translateElement(org.apache.xmlbeans.impl.xb.xsdschema.Element r22, java.lang.String r23, boolean r24, java.lang.String r25, java.lang.String r26, java.util.List r27, org.apache.xmlbeans.SchemaType r28) {
        /*
            Method dump skipped, instructions count: 1127
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscTranslator.translateElement(org.apache.xmlbeans.impl.xb.xsdschema.Element, java.lang.String, boolean, java.lang.String, java.lang.String, java.util.List, org.apache.xmlbeans.SchemaType):org.apache.xmlbeans.impl.schema.SchemaLocalElementImpl");
    }

    private static SchemaType checkRecursiveGroupReference(QName[] qNameArr, QName qName, SchemaTypeImpl schemaTypeImpl) {
        QName[] groupReferenceContext;
        if (qNameArr.length < 1) {
            return null;
        }
        while (schemaTypeImpl != null && schemaTypeImpl.getName() == null && !schemaTypeImpl.isDocumentType()) {
            if (qName.equals(schemaTypeImpl.getContainerField().getName()) && (groupReferenceContext = schemaTypeImpl.getGroupReferenceContext()) != null && groupReferenceContext.length == qNameArr.length) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= qNameArr.length) {
                        z = true;
                        break;
                    }
                    if ((qNameArr[i] != null || groupReferenceContext[i] != null) && (qNameArr[i] == null || !qNameArr[i].equals(groupReferenceContext[i]))) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return schemaTypeImpl;
                }
            }
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getOuterType();
        }
        return null;
    }

    private static String removeWhitespace(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!XMLChar.isSpace(charAt)) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static boolean checkXPathSyntax(String str) {
        boolean matches;
        if (str == null) {
            return false;
        }
        String removeWhitespace = removeWhitespace(str);
        RegularExpression regularExpression = XPATH_REGEXP;
        synchronized (regularExpression) {
            matches = regularExpression.matches(removeWhitespace);
        }
        return matches;
    }

    private static SchemaIdentityConstraintImpl translateIdentityConstraint(Keybase keybase, String str, boolean z) {
        StscState stscState = StscState.get();
        String xpath = keybase.getSelector() == null ? null : keybase.getSelector().getXpath();
        if (!checkXPathSyntax(xpath)) {
            stscState.error(XmlErrorCodes.SELECTOR_XPATH, new Object[]{xpath}, keybase.getSelector().xgetXpath());
            return null;
        }
        FieldDocument.Field[] fieldArray = keybase.getFieldArray();
        for (int i = 0; i < fieldArray.length; i++) {
            if (!checkXPathSyntax(fieldArray[i].getXpath())) {
                stscState.error(XmlErrorCodes.FIELDS_XPATH, new Object[]{fieldArray[i].getXpath()}, fieldArray[i].xgetXpath());
                return null;
            }
        }
        SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(stscState.getContainer(str));
        schemaIdentityConstraintImpl.setName(QNameHelper.forLNS(keybase.getName(), str));
        schemaIdentityConstraintImpl.setSelector(keybase.getSelector().getXpath());
        schemaIdentityConstraintImpl.setParseContext(keybase, str, z);
        schemaIdentityConstraintImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), keybase));
        schemaIdentityConstraintImpl.setUserData(getUserData(keybase));
        XmlCursor newCursor = keybase.newCursor();
        HashMap hashMap = new HashMap();
        newCursor.getAllNamespaces(hashMap);
        hashMap.remove("");
        schemaIdentityConstraintImpl.setNSMap(hashMap);
        newCursor.dispose();
        int length = fieldArray.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = fieldArray[i2].getXpath();
        }
        schemaIdentityConstraintImpl.setFields(strArr);
        try {
            schemaIdentityConstraintImpl.buildPaths();
            stscState.addIdConstraint(schemaIdentityConstraintImpl);
            schemaIdentityConstraintImpl.setFilename(findFilename(keybase));
            return stscState.findIdConstraint(schemaIdentityConstraintImpl.getName(), str, null);
        } catch (XPath.XPathCompileException e) {
            stscState.error(XmlErrorCodes.INVALID_XPATH, new Object[]{e.getMessage()}, keybase);
            return null;
        }
    }

    public static SchemaModelGroupImpl translateModelGroup(NamedGroup namedGroup, String str, boolean z, boolean z2) {
        String name = namedGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"model group"}, namedGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, namedGroup);
        FormChoice findElementFormDefault = findElementFormDefault(namedGroup);
        FormChoice findAttributeFormDefault = findAttributeFormDefault(namedGroup);
        schemaModelGroupImpl.init(QNameHelper.forLNS(name, str), str, z, findElementFormDefault == null ? null : findElementFormDefault.getStringValue(), findAttributeFormDefault == null ? null : findAttributeFormDefault.getStringValue(), z2, namedGroup, annotation, getUserData(namedGroup));
        schemaModelGroupImpl.setFilename(findFilename(namedGroup));
        return schemaModelGroupImpl;
    }

    public static SchemaAttributeGroupImpl translateAttributeGroup(AttributeGroup attributeGroup, String str, boolean z, boolean z2) {
        String name = attributeGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"attribute group"}, attributeGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, attributeGroup);
        FormChoice findAttributeFormDefault = findAttributeFormDefault(attributeGroup);
        schemaAttributeGroupImpl.init(QNameHelper.forLNS(name, str), str, z, findAttributeFormDefault == null ? null : findAttributeFormDefault.getStringValue(), z2, attributeGroup, annotation, getUserData(attributeGroup));
        schemaAttributeGroupImpl.setFilename(findFilename(attributeGroup));
        return schemaAttributeGroupImpl;
    }

    static FormChoice findAttributeFormDefault(XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        while (newCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            if (!newCursor.toParent()) {
                return null;
            }
        }
        return ((SchemaDocument.Schema) newCursor.getObject()).xgetAttributeFormDefault();
    }

    static SchemaLocalAttributeImpl translateAttribute(Attribute attribute, String str, String str2, boolean z, List list, SchemaType schemaType, SchemaAttributeModel schemaAttributeModel, boolean z2) {
        SchemaLocalAttributeImpl schemaGlobalAttributeImpl;
        QName forLNS;
        SchemaTypeImpl schemaTypeImpl;
        LocalSimpleType localSimpleType;
        SchemaLocalAttributeImpl schemaLocalAttributeImpl;
        int i;
        SchemaTypeImpl schemaTypeImpl2;
        int i2;
        SchemaType schemaType2;
        String str3;
        String str4;
        boolean z3;
        boolean z4;
        boolean z5;
        StscState stscState = StscState.get();
        String name = attribute.getName();
        QName ref = attribute.getRef();
        SOAPArrayType sOAPArrayType = null;
        if (ref != null && name != null) {
            if (name.equals(ref.getLocalPart()) && uriMatch(str, ref.getNamespaceURI())) {
                stscState.warning(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            }
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_NEITHER, (Object[]) null, attribute);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, attribute.xgetName());
        }
        if (z2) {
            schemaGlobalAttributeImpl = new SchemaLocalAttributeImpl();
        } else {
            schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(StscState.get().getContainer(str));
            ((SchemaGlobalAttributeImpl) schemaGlobalAttributeImpl).setParseContext(attribute, str, z);
        }
        SchemaLocalAttributeImpl schemaLocalAttributeImpl2 = schemaGlobalAttributeImpl;
        if (ref != null) {
            if (attribute.getType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"type"}, attribute.xgetType());
            }
            if (attribute.getSimpleType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"<simpleType>"}, attribute.getSimpleType());
            }
            if (attribute.getForm() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"form"}, attribute.xgetForm());
            }
            SchemaGlobalAttributeImpl findGlobalAttribute = stscState.findGlobalAttribute(ref, z ? str : null, str);
            if (findGlobalAttribute == null) {
                stscState.notFoundError(ref, 3, attribute.xgetRef(), true);
                return null;
            }
            int use = findGlobalAttribute.getUse();
            schemaType2 = findGlobalAttribute.getType();
            str3 = findGlobalAttribute.getDefaultText();
            if (str3 != null) {
                z3 = findGlobalAttribute.isFixed();
                if (z3) {
                    str4 = str3;
                    schemaLocalAttributeImpl = schemaLocalAttributeImpl2;
                    i = 2;
                    i2 = use;
                }
            } else {
                z3 = false;
            }
            str4 = null;
            schemaLocalAttributeImpl = schemaLocalAttributeImpl2;
            i = 2;
            i2 = use;
        } else {
            if (z2) {
                FormChoice xgetForm = attribute.xgetForm();
                if (xgetForm != null) {
                    z4 = xgetForm.getStringValue().equals(FORM_QUALIFIED);
                } else if (str2 != null) {
                    z4 = str2.equals(FORM_QUALIFIED);
                } else {
                    FormChoice findAttributeFormDefault = findAttributeFormDefault(attribute);
                    z4 = findAttributeFormDefault != null && findAttributeFormDefault.getStringValue().equals(FORM_QUALIFIED);
                }
                forLNS = z4 ? QNameHelper.forLNS(name, str) : QNameHelper.forLN(name);
            } else {
                forLNS = QNameHelper.forLNS(name, str);
            }
            if (attribute.getType() != null) {
                schemaTypeImpl = stscState.findGlobalType(attribute.getType(), z ? str : null, str);
                if (schemaTypeImpl == null) {
                    stscState.notFoundError(attribute.getType(), 0, attribute.xgetType(), true);
                }
            } else {
                schemaTypeImpl = null;
            }
            if (forLNS.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance")) {
                stscState.error(XmlErrorCodes.NO_XSI, new Object[]{"http://www.w3.org/2001/XMLSchema-instance"}, attribute.xgetName());
            }
            if (forLNS.getNamespaceURI().length() == 0 && forLNS.getLocalPart().equals("xmlns")) {
                stscState.error(XmlErrorCodes.NO_XMLNS, (Object[]) null, attribute.xgetName());
            }
            LocalSimpleType simpleType = attribute.getSimpleType();
            if (schemaTypeImpl == null || simpleType == null) {
                localSimpleType = simpleType;
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$TYPE_ATTR_OR_NESTED_TYPE, (Object[]) null, simpleType);
                localSimpleType = null;
            }
            if (localSimpleType != null) {
                SchemaTypeImpl schemaTypeImpl3 = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl3.setContainerField(schemaLocalAttributeImpl2);
                schemaTypeImpl3.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                list.add(schemaTypeImpl3);
                schemaTypeImpl3.setSimpleType(true);
                schemaTypeImpl2 = schemaTypeImpl3;
                LocalSimpleType localSimpleType2 = localSimpleType;
                schemaLocalAttributeImpl = schemaLocalAttributeImpl2;
                i = 2;
                schemaTypeImpl3.setParseContext(localSimpleType, str, z, null, null, false);
                schemaTypeImpl2.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), localSimpleType2));
                schemaTypeImpl2.setUserData(getUserData(localSimpleType2));
            } else {
                schemaLocalAttributeImpl = schemaLocalAttributeImpl2;
                i = 2;
                schemaTypeImpl2 = schemaTypeImpl;
            }
            if (schemaTypeImpl2 != null || schemaAttributeModel == null || schemaAttributeModel.getAttribute(forLNS) == null) {
                ref = forLNS;
                i2 = i;
                schemaType2 = schemaTypeImpl2;
            } else {
                schemaType2 = schemaAttributeModel.getAttribute(forLNS).getType();
                ref = forLNS;
                i2 = i;
            }
            str3 = null;
            str4 = null;
            z3 = false;
        }
        if (schemaType2 == null) {
            schemaType2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!schemaType2.isSimpleType()) {
            stscState.error("Attributes must have a simple type (not complex).", 46, attribute);
            schemaType2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (attribute.isSetUse()) {
            int translateUseCode = translateUseCode(attribute.xgetUse());
            if (translateUseCode == i || z3) {
                i2 = translateUseCode;
            } else {
                i2 = translateUseCode;
                str3 = null;
            }
        }
        if (attribute.isSetDefault() || attribute.isSetFixed()) {
            if (z3 && !attribute.isSetFixed()) {
                stscState.error("A use of a fixed attribute definition must also be fixed", 9, attribute.xgetFixed());
            }
            boolean isSetFixed = attribute.isSetFixed();
            if (attribute.isSetDefault() && isSetFixed) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_OR_FIXED, (Object[]) null, attribute.xgetFixed());
                isSetFixed = false;
            }
            Object fixed = isSetFixed ? attribute.getFixed() : attribute.getDefault();
            if (str4 == null || str4.equals(fixed)) {
                z5 = isSetFixed;
                str4 = fixed;
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$FIXED_NOT_MATCH, (Object[]) null, attribute.xgetFixed());
                z5 = isSetFixed;
            }
        } else {
            z5 = z3;
            str4 = str3;
        }
        if (!z2) {
            ((SchemaGlobalAttributeImpl) schemaLocalAttributeImpl).setFilename(findFilename(attribute));
        }
        XmlCursor newCursor = attribute.newCursor();
        String attributeText = newCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
        newCursor.dispose();
        if (attributeText != null) {
            try {
                sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(attribute));
            } catch (XmlValueOutOfRangeException unused) {
                stscState.error(XmlErrorCodes.SOAPARRAY, new Object[]{attributeText}, attribute);
            }
        }
        schemaLocalAttributeImpl.init(ref, schemaType2.getRef(), i2, str4, attribute, null, z5, sOAPArrayType, SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), attribute), getUserData(attribute));
        return schemaLocalAttributeImpl;
    }

    static int translateUseCode(Attribute.Use use) {
        if (use == null) {
            return 2;
        }
        String stringValue = use.getStringValue();
        if (stringValue.equals("optional")) {
            return 2;
        }
        if (stringValue.equals("required")) {
            return 3;
        }
        return stringValue.equals("prohibited") ? 1 : 2;
    }

    static BigInteger buildBigInt(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            return null;
        }
        String stringValue = xmlAnySimpleType.getStringValue();
        try {
            BigInteger bigInteger = new BigInteger(stringValue);
            if (bigInteger.signum() >= 0) {
                return bigInteger;
            }
            StscState.get().error(XmlErrorCodes.INVALID_VALUE, new Object[]{stringValue, "nonNegativeInteger"}, xmlAnySimpleType);
            return null;
        } catch (NumberFormatException e) {
            StscState.get().error(XmlErrorCodes.INVALID_VALUE_DETAIL, new Object[]{stringValue, "nonNegativeInteger", e.getMessage()}, xmlAnySimpleType);
            return null;
        }
    }

    static XmlNonNegativeInteger buildNnInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger buildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlNonNegativeIntegerImpl xmlNonNegativeIntegerImpl = new XmlNonNegativeIntegerImpl();
            xmlNonNegativeIntegerImpl.set(buildBigInt);
            xmlNonNegativeIntegerImpl.setImmutable();
            return xmlNonNegativeIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    static XmlPositiveInteger buildPosInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger buildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlPositiveIntegerImpl xmlPositiveIntegerImpl = new XmlPositiveIntegerImpl();
            xmlPositiveIntegerImpl.set(buildBigInt);
            xmlPositiveIntegerImpl.setImmutable();
            return xmlPositiveIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    private static Object getUserData(XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        Class cls = class$org$apache$xmlbeans$SchemaBookmark;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.SchemaBookmark");
            class$org$apache$xmlbeans$SchemaBookmark = cls;
        }
        XmlCursor.XmlBookmark bookmark = newCursor.getBookmark(cls);
        if (bookmark == null || !(bookmark instanceof SchemaBookmark)) {
            return null;
        }
        return ((SchemaBookmark) bookmark).getValue();
    }

    private static boolean isEmptySchema(SchemaDocument.Schema schema) {
        XmlCursor newCursor = schema.newCursor();
        boolean z = !newCursor.toFirstChild();
        newCursor.dispose();
        return z;
    }

    private static boolean isReservedTypeName(QName qName) {
        return BuiltinSchemaTypeSystem.get().findType(qName) != null;
    }
}
