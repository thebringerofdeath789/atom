package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlipCompression;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlipCompression$Enum;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* loaded from: classes5.dex */
public class CTBlipImpl extends XmlComplexContentImpl implements CTBlip {
    private static final QName ALPHABILEVEL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaBiLevel");
    private static final QName ALPHACEILING$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaCeiling");
    private static final QName ALPHAFLOOR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaFloor");
    private static final QName ALPHAINV$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaInv");
    private static final QName ALPHAMOD$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaMod");
    private static final QName ALPHAMODFIX$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaModFix");
    private static final QName ALPHAREPL$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "alphaRepl");
    private static final QName BILEVEL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "biLevel");
    private static final QName BLUR$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blur");
    private static final QName CLRCHANGE$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrChange");
    private static final QName CLRREPL$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "clrRepl");
    private static final QName DUOTONE$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "duotone");
    private static final QName FILLOVERLAY$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillOverlay");
    private static final QName GRAYSCL$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grayscl");
    private static final QName HSL$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hsl");
    private static final QName LUM$30 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lum");
    private static final QName TINT$32 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tint");
    private static final QName EXTLST$34 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName EMBED$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed");
    private static final QName LINK$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "link");
    private static final QName CSTATE$40 = new QName("", "cstate");

    public CTBlipImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
        CTAlphaBiLevelEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHABILEVEL$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect addNewAlphaCeiling() {
        CTAlphaCeilingEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHACEILING$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect addNewAlphaFloor() {
        CTAlphaFloorEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHAFLOOR$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect addNewAlphaInv() {
        CTAlphaInverseEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHAINV$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect addNewAlphaMod() {
        CTAlphaModulateEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHAMOD$8);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect addNewAlphaModFix() {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().add_element_user(ALPHAMODFIX$10);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect addNewAlphaRepl() {
        CTAlphaReplaceEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ALPHAREPL$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect addNewBiLevel() {
        CTBiLevelEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BILEVEL$14);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect addNewBlur() {
        CTBlurEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BLUR$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect addNewClrChange() {
        CTColorChangeEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CLRCHANGE$18);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect addNewClrRepl() {
        CTColorReplaceEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CLRREPL$20);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect addNewDuotone() {
        CTDuotoneEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DUOTONE$22);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$34);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FILLOVERLAY$24);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect addNewGrayscl() {
        CTGrayscaleEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(GRAYSCL$26);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect addNewHsl() {
        CTHSLEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(HSL$28);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect addNewLum() {
        CTLuminanceEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LUM$30);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect addNewTint() {
        CTTintEffect add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TINT$32);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect getAlphaBiLevelArray(int i) {
        CTAlphaBiLevelEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHABILEVEL$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
        CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHABILEVEL$0, arrayList);
            cTAlphaBiLevelEffectArr = new CTAlphaBiLevelEffect[arrayList.size()];
            arrayList.toArray(cTAlphaBiLevelEffectArr);
        }
        return cTAlphaBiLevelEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
        1AlphaBiLevelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaBiLevelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect getAlphaCeilingArray(int i) {
        CTAlphaCeilingEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHACEILING$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
        CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHACEILING$2, arrayList);
            cTAlphaCeilingEffectArr = new CTAlphaCeilingEffect[arrayList.size()];
            arrayList.toArray(cTAlphaCeilingEffectArr);
        }
        return cTAlphaCeilingEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
        1AlphaCeilingList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaCeilingList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect getAlphaFloorArray(int i) {
        CTAlphaFloorEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHAFLOOR$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect[] getAlphaFloorArray() {
        CTAlphaFloorEffect[] cTAlphaFloorEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAFLOOR$4, arrayList);
            cTAlphaFloorEffectArr = new CTAlphaFloorEffect[arrayList.size()];
            arrayList.toArray(cTAlphaFloorEffectArr);
        }
        return cTAlphaFloorEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaFloorEffect> getAlphaFloorList() {
        1AlphaFloorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaFloorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect getAlphaInvArray(int i) {
        CTAlphaInverseEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHAINV$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect[] getAlphaInvArray() {
        CTAlphaInverseEffect[] cTAlphaInverseEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAINV$6, arrayList);
            cTAlphaInverseEffectArr = new CTAlphaInverseEffect[arrayList.size()];
            arrayList.toArray(cTAlphaInverseEffectArr);
        }
        return cTAlphaInverseEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaInverseEffect> getAlphaInvList() {
        1AlphaInvList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaInvList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect getAlphaModArray(int i) {
        CTAlphaModulateEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHAMOD$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect[] getAlphaModArray() {
        CTAlphaModulateEffect[] cTAlphaModulateEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAMOD$8, arrayList);
            cTAlphaModulateEffectArr = new CTAlphaModulateEffect[arrayList.size()];
            arrayList.toArray(cTAlphaModulateEffectArr);
        }
        return cTAlphaModulateEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect getAlphaModFixArray(int i) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().find_element_user(ALPHAMODFIX$10, i);
            if (cTAlphaModulateFixedEffect == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect[] getAlphaModFixArray() {
        CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAMODFIX$10, arrayList);
            cTAlphaModulateFixedEffectArr = new CTAlphaModulateFixedEffect[arrayList.size()];
            arrayList.toArray(cTAlphaModulateFixedEffectArr);
        }
        return cTAlphaModulateFixedEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaModulateFixedEffect> getAlphaModFixList() {
        1AlphaModFixList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaModFixList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaModulateEffect> getAlphaModList() {
        1AlphaModList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaModList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect getAlphaReplArray(int i) {
        CTAlphaReplaceEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ALPHAREPL$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect[] getAlphaReplArray() {
        CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ALPHAREPL$12, arrayList);
            cTAlphaReplaceEffectArr = new CTAlphaReplaceEffect[arrayList.size()];
            arrayList.toArray(cTAlphaReplaceEffectArr);
        }
        return cTAlphaReplaceEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTAlphaReplaceEffect> getAlphaReplList() {
        1AlphaReplList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AlphaReplList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect getBiLevelArray(int i) {
        CTBiLevelEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BILEVEL$14, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect[] getBiLevelArray() {
        CTBiLevelEffect[] cTBiLevelEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BILEVEL$14, arrayList);
            cTBiLevelEffectArr = new CTBiLevelEffect[arrayList.size()];
            arrayList.toArray(cTBiLevelEffectArr);
        }
        return cTBiLevelEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTBiLevelEffect> getBiLevelList() {
        1BiLevelList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BiLevelList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect getBlurArray(int i) {
        CTBlurEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(BLUR$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect[] getBlurArray() {
        CTBlurEffect[] cTBlurEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BLUR$16, arrayList);
            cTBlurEffectArr = new CTBlurEffect[arrayList.size()];
            arrayList.toArray(cTBlurEffectArr);
        }
        return cTBlurEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTBlurEffect> getBlurList() {
        1BlurList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BlurList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect getClrChangeArray(int i) {
        CTColorChangeEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CLRCHANGE$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect[] getClrChangeArray() {
        CTColorChangeEffect[] cTColorChangeEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLRCHANGE$18, arrayList);
            cTColorChangeEffectArr = new CTColorChangeEffect[arrayList.size()];
            arrayList.toArray(cTColorChangeEffectArr);
        }
        return cTColorChangeEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTColorChangeEffect> getClrChangeList() {
        1ClrChangeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClrChangeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect getClrReplArray(int i) {
        CTColorReplaceEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CLRREPL$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect[] getClrReplArray() {
        CTColorReplaceEffect[] cTColorReplaceEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLRREPL$20, arrayList);
            cTColorReplaceEffectArr = new CTColorReplaceEffect[arrayList.size()];
            arrayList.toArray(cTColorReplaceEffectArr);
        }
        return cTColorReplaceEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTColorReplaceEffect> getClrReplList() {
        1ClrReplList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ClrReplList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STBlipCompression$Enum getCstate() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTATE$40;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STBlipCompression$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect getDuotoneArray(int i) {
        CTDuotoneEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(DUOTONE$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect[] getDuotoneArray() {
        CTDuotoneEffect[] cTDuotoneEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DUOTONE$22, arrayList);
            cTDuotoneEffectArr = new CTDuotoneEffect[arrayList.size()];
            arrayList.toArray(cTDuotoneEffectArr);
        }
        return cTDuotoneEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTDuotoneEffect> getDuotoneList() {
        1DuotoneList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DuotoneList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public String getEmbed() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBED$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$34, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect getFillOverlayArray(int i) {
        CTFillOverlayEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(FILLOVERLAY$24, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect[] getFillOverlayArray() {
        CTFillOverlayEffect[] cTFillOverlayEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILLOVERLAY$24, arrayList);
            cTFillOverlayEffectArr = new CTFillOverlayEffect[arrayList.size()];
            arrayList.toArray(cTFillOverlayEffectArr);
        }
        return cTFillOverlayEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTFillOverlayEffect> getFillOverlayList() {
        1FillOverlayList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FillOverlayList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect getGraysclArray(int i) {
        CTGrayscaleEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(GRAYSCL$26, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect[] getGraysclArray() {
        CTGrayscaleEffect[] cTGrayscaleEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRAYSCL$26, arrayList);
            cTGrayscaleEffectArr = new CTGrayscaleEffect[arrayList.size()];
            arrayList.toArray(cTGrayscaleEffectArr);
        }
        return cTGrayscaleEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTGrayscaleEffect> getGraysclList() {
        1GraysclList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GraysclList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect getHslArray(int i) {
        CTHSLEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(HSL$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect[] getHslArray() {
        CTHSLEffect[] cTHSLEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HSL$28, arrayList);
            cTHSLEffectArr = new CTHSLEffect[arrayList.size()];
            arrayList.toArray(cTHSLEffectArr);
        }
        return cTHSLEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTHSLEffect> getHslList() {
        1HslList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HslList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public String getLink() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINK$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect getLumArray(int i) {
        CTLuminanceEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LUM$30, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect[] getLumArray() {
        CTLuminanceEffect[] cTLuminanceEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LUM$30, arrayList);
            cTLuminanceEffectArr = new CTLuminanceEffect[arrayList.size()];
            arrayList.toArray(cTLuminanceEffectArr);
        }
        return cTLuminanceEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTLuminanceEffect> getLumList() {
        1LumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect getTintArray(int i) {
        CTTintEffect find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(TINT$32, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect[] getTintArray() {
        CTTintEffect[] cTTintEffectArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TINT$32, arrayList);
            cTTintEffectArr = new CTTintEffect[arrayList.size()];
            arrayList.toArray(cTTintEffectArr);
        }
        return cTTintEffectArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public List<CTTintEffect> getTintList() {
        1TintList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TintList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i) {
        CTAlphaBiLevelEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHABILEVEL$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaCeilingEffect insertNewAlphaCeiling(int i) {
        CTAlphaCeilingEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHACEILING$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaFloorEffect insertNewAlphaFloor(int i) {
        CTAlphaFloorEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHAFLOOR$4, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaInverseEffect insertNewAlphaInv(int i) {
        CTAlphaInverseEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHAINV$6, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateEffect insertNewAlphaMod(int i) {
        CTAlphaModulateEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHAMOD$8, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaModulateFixedEffect insertNewAlphaModFix(int i) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().insert_element_user(ALPHAMODFIX$10, i);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTAlphaReplaceEffect insertNewAlphaRepl(int i) {
        CTAlphaReplaceEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ALPHAREPL$12, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBiLevelEffect insertNewBiLevel(int i) {
        CTBiLevelEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BILEVEL$14, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTBlurEffect insertNewBlur(int i) {
        CTBlurEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(BLUR$16, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorChangeEffect insertNewClrChange(int i) {
        CTColorChangeEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CLRCHANGE$18, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTColorReplaceEffect insertNewClrRepl(int i) {
        CTColorReplaceEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CLRREPL$20, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTDuotoneEffect insertNewDuotone(int i) {
        CTDuotoneEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(DUOTONE$22, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTFillOverlayEffect insertNewFillOverlay(int i) {
        CTFillOverlayEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(FILLOVERLAY$24, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTGrayscaleEffect insertNewGrayscl(int i) {
        CTGrayscaleEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(GRAYSCL$26, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTHSLEffect insertNewHsl(int i) {
        CTHSLEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(HSL$28, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTLuminanceEffect insertNewLum(int i) {
        CTLuminanceEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LUM$30, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public CTTintEffect insertNewTint(int i) {
        CTTintEffect insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(TINT$32, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetCstate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CSTATE$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetEmbed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EMBED$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$34) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public boolean isSetLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINK$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaBiLevel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHABILEVEL$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaCeiling(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHACEILING$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaFloor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAFLOOR$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaInv(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAINV$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaMod(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAMOD$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaModFix(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAMODFIX$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeAlphaRepl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALPHAREPL$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeBiLevel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BILEVEL$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeBlur(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLUR$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeClrChange(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRCHANGE$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeClrRepl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRREPL$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeDuotone(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DUOTONE$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeFillOverlay(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILLOVERLAY$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeGrayscl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAYSCL$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeHsl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HSL$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeLum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LUM$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void removeTint(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TINT$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaBiLevelArray(int i, CTAlphaBiLevelEffect cTAlphaBiLevelEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaBiLevelEffect find_element_user = get_store().find_element_user(ALPHABILEVEL$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaBiLevelEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaBiLevelEffectArr, ALPHABILEVEL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaCeilingArray(int i, CTAlphaCeilingEffect cTAlphaCeilingEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaCeilingEffect find_element_user = get_store().find_element_user(ALPHACEILING$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaCeilingEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaCeilingEffectArr, ALPHACEILING$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaFloorArray(int i, CTAlphaFloorEffect cTAlphaFloorEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaFloorEffect find_element_user = get_store().find_element_user(ALPHAFLOOR$4, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaFloorEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaFloorEffectArr, ALPHAFLOOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaInvArray(int i, CTAlphaInverseEffect cTAlphaInverseEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaInverseEffect find_element_user = get_store().find_element_user(ALPHAINV$6, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaInverseEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaInverseEffectArr, ALPHAINV$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModArray(int i, CTAlphaModulateEffect cTAlphaModulateEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaModulateEffect find_element_user = get_store().find_element_user(ALPHAMOD$8, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaModulateEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaModulateEffectArr, ALPHAMOD$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModFixArray(int i, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect2 = (CTAlphaModulateFixedEffect) get_store().find_element_user(ALPHAMODFIX$10, i);
            if (cTAlphaModulateFixedEffect2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAlphaModulateFixedEffect2.set(cTAlphaModulateFixedEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAlphaModulateFixedEffectArr, ALPHAMODFIX$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaReplArray(int i, CTAlphaReplaceEffect cTAlphaReplaceEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTAlphaReplaceEffect find_element_user = get_store().find_element_user(ALPHAREPL$12, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAlphaReplaceEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAlphaReplaceEffectArr, ALPHAREPL$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBiLevelArray(int i, CTBiLevelEffect cTBiLevelEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTBiLevelEffect find_element_user = get_store().find_element_user(BILEVEL$14, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBiLevelEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBiLevelEffectArr, BILEVEL$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBlurArray(int i, CTBlurEffect cTBlurEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTBlurEffect find_element_user = get_store().find_element_user(BLUR$16, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTBlurEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setBlurArray(CTBlurEffect[] cTBlurEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBlurEffectArr, BLUR$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrChangeArray(int i, CTColorChangeEffect cTColorChangeEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTColorChangeEffect find_element_user = get_store().find_element_user(CLRCHANGE$18, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTColorChangeEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTColorChangeEffectArr, CLRCHANGE$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrReplArray(int i, CTColorReplaceEffect cTColorReplaceEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTColorReplaceEffect find_element_user = get_store().find_element_user(CLRREPL$20, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTColorReplaceEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTColorReplaceEffectArr, CLRREPL$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setCstate(STBlipCompression$Enum sTBlipCompression$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTATE$40;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTBlipCompression$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setDuotoneArray(int i, CTDuotoneEffect cTDuotoneEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTDuotoneEffect find_element_user = get_store().find_element_user(DUOTONE$22, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTDuotoneEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDuotoneEffectArr, DUOTONE$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setEmbed(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBED$36;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$34;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setFillOverlayArray(int i, CTFillOverlayEffect cTFillOverlayEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTFillOverlayEffect find_element_user = get_store().find_element_user(FILLOVERLAY$24, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFillOverlayEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFillOverlayEffectArr, FILLOVERLAY$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setGraysclArray(int i, CTGrayscaleEffect cTGrayscaleEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTGrayscaleEffect find_element_user = get_store().find_element_user(GRAYSCL$26, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTGrayscaleEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGrayscaleEffectArr, GRAYSCL$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setHslArray(int i, CTHSLEffect cTHSLEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTHSLEffect find_element_user = get_store().find_element_user(HSL$28, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTHSLEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setHslArray(CTHSLEffect[] cTHSLEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTHSLEffectArr, HSL$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINK$38;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLumArray(int i, CTLuminanceEffect cTLuminanceEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTLuminanceEffect find_element_user = get_store().find_element_user(LUM$30, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTLuminanceEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLuminanceEffectArr, LUM$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setTintArray(int i, CTTintEffect cTTintEffect) {
        synchronized (monitor()) {
            check_orphaned();
            CTTintEffect find_element_user = get_store().find_element_user(TINT$32, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTTintEffect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void setTintArray(CTTintEffect[] cTTintEffectArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTintEffectArr, TINT$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaBiLevelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHABILEVEL$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaCeilingArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHACEILING$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaFloorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHAFLOOR$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaInvArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHAINV$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaModArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHAMOD$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaModFixArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHAMODFIX$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfAlphaReplArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ALPHAREPL$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfBiLevelArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BILEVEL$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfBlurArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(BLUR$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfClrChangeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLRCHANGE$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfClrReplArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CLRREPL$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfDuotoneArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(DUOTONE$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfFillOverlayArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILLOVERLAY$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfGraysclArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(GRAYSCL$26);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfHslArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(HSL$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfLumArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LUM$30);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public int sizeOfTintArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TINT$32);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetCstate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CSTATE$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetEmbed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EMBED$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$34, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void unsetLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINK$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STBlipCompression xgetCstate() {
        STBlipCompression find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTATE$40;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBlipCompression) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STRelationshipId xgetEmbed() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBED$36;
            sTRelationshipId = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId == null) {
                sTRelationshipId = (STRelationshipId) get_default_attribute_value(qName);
            }
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public STRelationshipId xgetLink() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINK$38;
            sTRelationshipId = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId == null) {
                sTRelationshipId = (STRelationshipId) get_default_attribute_value(qName);
            }
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetCstate(STBlipCompression sTBlipCompression) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CSTATE$40;
            STBlipCompression find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STBlipCompression) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTBlipCompression);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetEmbed(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EMBED$36;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlip
    public void xsetLink(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINK$38;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }
}
