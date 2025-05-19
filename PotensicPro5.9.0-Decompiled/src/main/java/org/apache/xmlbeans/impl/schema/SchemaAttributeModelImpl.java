package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaLocalAttribute;

/* loaded from: classes5.dex */
public class SchemaAttributeModelImpl implements SchemaAttributeModel {
    private static final SchemaLocalAttribute[] EMPTY_SLA_ARRAY = new SchemaLocalAttribute[0];
    private Map attrMap;
    private int wcProcess;
    private QNameSet wcSet;

    public SchemaAttributeModelImpl() {
        this.attrMap = new LinkedHashMap();
        this.wcSet = null;
        this.wcProcess = 0;
    }

    public SchemaAttributeModelImpl(SchemaAttributeModel schemaAttributeModel) {
        this.attrMap = new LinkedHashMap();
        if (schemaAttributeModel == null) {
            this.wcSet = null;
            this.wcProcess = 0;
            return;
        }
        SchemaLocalAttribute[] attributes = schemaAttributeModel.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            this.attrMap.put(attributes[i].getName(), attributes[i]);
        }
        if (schemaAttributeModel.getWildcardProcess() != 0) {
            this.wcSet = schemaAttributeModel.getWildcardSet();
            this.wcProcess = schemaAttributeModel.getWildcardProcess();
        }
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute[] getAttributes() {
        return (SchemaLocalAttribute[]) this.attrMap.values().toArray(EMPTY_SLA_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute getAttribute(QName qName) {
        return (SchemaLocalAttribute) this.attrMap.get(qName);
    }

    public void addAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        this.attrMap.put(schemaLocalAttribute.getName(), schemaLocalAttribute);
    }

    public void removeProhibitedAttribute(QName qName) {
        this.attrMap.remove(qName);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public QNameSet getWildcardSet() {
        QNameSet qNameSet = this.wcSet;
        return qNameSet == null ? QNameSet.EMPTY : qNameSet;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        this.wcSet = qNameSet;
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public int getWildcardProcess() {
        return this.wcProcess;
    }

    public void setWildcardProcess(int i) {
        this.wcProcess = i;
    }
}
