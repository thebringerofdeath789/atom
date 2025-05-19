package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode$Enum;

/* loaded from: classes5.dex */
public class CTShapePropertiesImpl extends XmlComplexContentImpl implements CTShapeProperties {
    private static final QName XFRM$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "xfrm");
    private static final QName CUSTGEOM$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "custGeom");
    private static final QName PRSTGEOM$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstGeom");
    private static final QName NOFILL$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
    private static final QName SOLIDFILL$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
    private static final QName GRADFILL$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
    private static final QName BLIPFILL$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
    private static final QName PATTFILL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
    private static final QName GRPFILL$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
    private static final QName LN$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ln");
    private static final QName EFFECTLST$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
    private static final QName EFFECTDAG$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
    private static final QName SCENE3D$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
    private static final QName SP3D$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");
    private static final QName EXTLST$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName BWMODE$30 = new QName("", "bwMode");

    public CTShapePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$12);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTCustomGeometry2D addNewCustGeom() {
        CTCustomGeometry2D cTCustomGeometry2D;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomGeometry2D = (CTCustomGeometry2D) get_store().add_element_user(CUSTGEOM$2);
        }
        return cTCustomGeometry2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTEffectContainer addNewEffectDag() {
        CTEffectContainer add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EFFECTDAG$22);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTEffectList addNewEffectLst() {
        CTEffectList cTEffectList;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectList = (CTEffectList) get_store().add_element_user(EFFECTLST$20);
        }
        return cTEffectList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$28);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(GRADFILL$10);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(GRPFILL$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTLineProperties addNewLn() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LN$18);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$6);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(PATTFILL$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTPresetGeometry2D addNewPrstGeom() {
        CTPresetGeometry2D cTPresetGeometry2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetGeometry2D = (CTPresetGeometry2D) get_store().add_element_user(PRSTGEOM$4);
        }
        return cTPresetGeometry2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTScene3D addNewScene3D() {
        CTScene3D add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SCENE3D$24);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$8);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTShape3D addNewSp3D() {
        CTShape3D add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SP3D$26);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTTransform2D addNewXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().add_element_user(XFRM$0);
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$12, 0);
            if (cTBlipFillProperties == null) {
                return null;
            }
            return cTBlipFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public STBlackWhiteMode$Enum getBwMode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWMODE$30);
            if (simpleValue == null) {
                return null;
            }
            return (STBlackWhiteMode$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTCustomGeometry2D getCustGeom() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomGeometry2D cTCustomGeometry2D = (CTCustomGeometry2D) get_store().find_element_user(CUSTGEOM$2, 0);
            if (cTCustomGeometry2D == null) {
                return null;
            }
            return cTCustomGeometry2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTEffectContainer getEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectContainer find_element_user = get_store().find_element_user(EFFECTDAG$22, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTEffectList getEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectList cTEffectList = (CTEffectList) get_store().find_element_user(EFFECTLST$20, 0);
            if (cTEffectList == null) {
                return null;
            }
            return cTEffectList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$28, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFillProperties cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$10, 0);
            if (cTGradientFillProperties == null) {
                return null;
            }
            return cTGradientFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTGroupFillProperties getGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupFillProperties find_element_user = get_store().find_element_user(GRPFILL$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTLineProperties getLn() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LN$18, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$6, 0);
            if (cTNoFillProperties == null) {
                return null;
            }
            return cTNoFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFillProperties find_element_user = get_store().find_element_user(PATTFILL$14, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTPresetGeometry2D getPrstGeom() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresetGeometry2D cTPresetGeometry2D = (CTPresetGeometry2D) get_store().find_element_user(PRSTGEOM$4, 0);
            if (cTPresetGeometry2D == null) {
                return null;
            }
            return cTPresetGeometry2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTScene3D getScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTScene3D find_element_user = get_store().find_element_user(SCENE3D$24, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$8, 0);
            if (cTSolidColorFillProperties == null) {
                return null;
            }
            return cTSolidColorFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTShape3D getSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTShape3D find_element_user = get_store().find_element_user(SP3D$26, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public CTTransform2D getXfrm() {
        synchronized (monitor()) {
            check_orphaned();
            CTTransform2D cTTransform2D = (CTTransform2D) get_store().find_element_user(XFRM$0, 0);
            if (cTTransform2D == null) {
                return null;
            }
            return cTTransform2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetBwMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetCustGeom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTGEOM$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetEffectDag() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTDAG$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetEffectLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetLn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LN$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetPrstGeom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTGEOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetScene3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCENE3D$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetSp3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SP3D$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public boolean isSetXfrm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(XFRM$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIPFILL$12;
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
            if (cTBlipFillProperties2 == null) {
                cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBlackWhiteMode$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTGEOM$2;
            CTCustomGeometry2D cTCustomGeometry2D2 = (CTCustomGeometry2D) typeStore.find_element_user(qName, 0);
            if (cTCustomGeometry2D2 == null) {
                cTCustomGeometry2D2 = (CTCustomGeometry2D) get_store().add_element_user(qName);
            }
            cTCustomGeometry2D2.set(cTCustomGeometry2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setEffectDag(CTEffectContainer cTEffectContainer) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTDAG$22;
            CTEffectContainer find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTEffectContainer) get_store().add_element_user(qName);
            }
            find_element_user.set(cTEffectContainer);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setEffectLst(CTEffectList cTEffectList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTLST$20;
            CTEffectList cTEffectList2 = (CTEffectList) typeStore.find_element_user(qName, 0);
            if (cTEffectList2 == null) {
                cTEffectList2 = (CTEffectList) get_store().add_element_user(qName);
            }
            cTEffectList2.set(cTEffectList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$28;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRADFILL$10;
            CTGradientFillProperties cTGradientFillProperties2 = (CTGradientFillProperties) typeStore.find_element_user(qName, 0);
            if (cTGradientFillProperties2 == null) {
                cTGradientFillProperties2 = (CTGradientFillProperties) get_store().add_element_user(qName);
            }
            cTGradientFillProperties2.set(cTGradientFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPFILL$16;
            CTGroupFillProperties find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTGroupFillProperties) get_store().add_element_user(qName);
            }
            find_element_user.set(cTGroupFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setLn(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LN$18;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOFILL$6;
            CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) typeStore.find_element_user(qName, 0);
            if (cTNoFillProperties2 == null) {
                cTNoFillProperties2 = (CTNoFillProperties) get_store().add_element_user(qName);
            }
            cTNoFillProperties2.set(cTNoFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTFILL$14;
            CTPatternFillProperties find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTPatternFillProperties) get_store().add_element_user(qName);
            }
            find_element_user.set(cTPatternFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRSTGEOM$4;
            CTPresetGeometry2D cTPresetGeometry2D2 = (CTPresetGeometry2D) typeStore.find_element_user(qName, 0);
            if (cTPresetGeometry2D2 == null) {
                cTPresetGeometry2D2 = (CTPresetGeometry2D) get_store().add_element_user(qName);
            }
            cTPresetGeometry2D2.set(cTPresetGeometry2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setScene3D(CTScene3D cTScene3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCENE3D$24;
            CTScene3D find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTScene3D) get_store().add_element_user(qName);
            }
            find_element_user.set(cTScene3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOLIDFILL$8;
            CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) typeStore.find_element_user(qName, 0);
            if (cTSolidColorFillProperties2 == null) {
                cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().add_element_user(qName);
            }
            cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setSp3D(CTShape3D cTShape3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SP3D$26;
            CTShape3D find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTShape3D) get_store().add_element_user(qName);
            }
            find_element_user.set(cTShape3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void setXfrm(CTTransform2D cTTransform2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XFRM$0;
            CTTransform2D cTTransform2D2 = (CTTransform2D) typeStore.find_element_user(qName, 0);
            if (cTTransform2D2 == null) {
                cTTransform2D2 = (CTTransform2D) get_store().add_element_user(qName);
            }
            cTTransform2D2.set(cTTransform2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetBwMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetCustGeom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTGEOM$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTDAG$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetLn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LN$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetPrstGeom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTGEOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCENE3D$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SP3D$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void unsetXfrm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XFRM$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public STBlackWhiteMode xgetBwMode() {
        STBlackWhiteMode find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(BWMODE$30);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties
    public void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BWMODE$30;
            STBlackWhiteMode find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBlackWhiteMode) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBlackWhiteMode);
        }
    }
}
