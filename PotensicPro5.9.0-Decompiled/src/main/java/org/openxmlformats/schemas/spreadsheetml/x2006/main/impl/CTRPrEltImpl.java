package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes6.dex */
public class CTRPrEltImpl extends XmlComplexContentImpl implements CTRPrElt {
    private static final QName RFONT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rFont");
    private static final QName CHARSET$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "charset");
    private static final QName FAMILY$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY);
    private static final QName B$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
    private static final QName I$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", Complex.DEFAULT_SUFFIX);
    private static final QName STRIKE$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "strike");
    private static final QName OUTLINE$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outline");
    private static final QName SHADOW$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "shadow");
    private static final QName CONDENSE$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "condense");
    private static final QName EXTEND$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extend");
    private static final QName COLOR$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", TtmlNode.ATTR_TTS_COLOR);
    private static final QName SZ$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sz");
    private static final QName U$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "u");
    private static final QName VERTALIGN$26 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertAlign");
    private static final QName SCHEME$28 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scheme");

    public CTRPrEltImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewB() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(B$6);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty addNewCharset() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(CHARSET$2);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$20);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewCondense() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(CONDENSE$16);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewExtend() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(EXTEND$18);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty addNewFamily() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(FAMILY$4);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewI() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(I$8);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewOutline() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(OUTLINE$12);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName addNewRFont() {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().add_element_user(RFONT$0);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme addNewScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().add_element_user(SCHEME$28);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewShadow() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(SHADOW$14);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewStrike() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(STRIKE$10);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize addNewSz() {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().add_element_user(SZ$22);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty addNewU() {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().add_element_user(U$24);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty addNewVertAlign() {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().add_element_user(VERTALIGN$26);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getBArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(B$6, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getBArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(B$6, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getBList() {
        1BList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty getCharsetArray(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(CHARSET$2, i);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty[] getCharsetArray() {
        CTIntProperty[] cTIntPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHARSET$2, arrayList);
            cTIntPropertyArr = new CTIntProperty[arrayList.size()];
            arrayList.toArray(cTIntPropertyArr);
        }
        return cTIntPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTIntProperty> getCharsetList() {
        1CharsetList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CharsetList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor getColorArray(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(COLOR$20, i);
            if (cTColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor[] getColorArray() {
        CTColor[] cTColorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLOR$20, arrayList);
            cTColorArr = new CTColor[arrayList.size()];
            arrayList.toArray(cTColorArr);
        }
        return cTColorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTColor> getColorList() {
        1ColorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getCondenseArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(CONDENSE$16, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getCondenseArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CONDENSE$16, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getCondenseList() {
        1CondenseList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CondenseList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getExtendArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(EXTEND$18, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getExtendArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTEND$18, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getExtendList() {
        1ExtendList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtendList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty getFamilyArray(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(FAMILY$4, i);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty[] getFamilyArray() {
        CTIntProperty[] cTIntPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FAMILY$4, arrayList);
            cTIntPropertyArr = new CTIntProperty[arrayList.size()];
            arrayList.toArray(cTIntPropertyArr);
        }
        return cTIntPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTIntProperty> getFamilyList() {
        1FamilyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FamilyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getIArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(I$8, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getIArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I$8, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getIList() {
        1IList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getOutlineArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(OUTLINE$12, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getOutlineArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OUTLINE$12, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getOutlineList() {
        1OutlineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OutlineList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName getRFontArray(int i) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().find_element_user(RFONT$0, i);
            if (cTFontName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName[] getRFontArray() {
        CTFontName[] cTFontNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RFONT$0, arrayList);
            cTFontNameArr = new CTFontName[arrayList.size()];
            arrayList.toArray(cTFontNameArr);
        }
        return cTFontNameArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontName> getRFontList() {
        1RFontList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RFontList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme getSchemeArray(int i) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().find_element_user(SCHEME$28, i);
            if (cTFontScheme == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme[] getSchemeArray() {
        CTFontScheme[] cTFontSchemeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEME$28, arrayList);
            cTFontSchemeArr = new CTFontScheme[arrayList.size()];
            arrayList.toArray(cTFontSchemeArr);
        }
        return cTFontSchemeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontScheme> getSchemeList() {
        1SchemeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SchemeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getShadowArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(SHADOW$14, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getShadowArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADOW$14, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getStrikeArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(STRIKE$10, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getStrikeArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STRIKE$10, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getStrikeList() {
        1StrikeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrikeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize getSzArray(int i) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().find_element_user(SZ$22, i);
            if (cTFontSize == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize[] getSzArray() {
        CTFontSize[] cTFontSizeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SZ$22, arrayList);
            cTFontSizeArr = new CTFontSize[arrayList.size()];
            arrayList.toArray(cTFontSizeArr);
        }
        return cTFontSizeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontSize> getSzList() {
        1SzList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SzList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty getUArray(int i) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().find_element_user(U$24, i);
            if (cTUnderlineProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty[] getUArray() {
        CTUnderlineProperty[] cTUnderlinePropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(U$24, arrayList);
            cTUnderlinePropertyArr = new CTUnderlineProperty[arrayList.size()];
            arrayList.toArray(cTUnderlinePropertyArr);
        }
        return cTUnderlinePropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTUnderlineProperty> getUList() {
        1UList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1UList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty getVertAlignArray(int i) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().find_element_user(VERTALIGN$26, i);
            if (cTVerticalAlignFontProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty[] getVertAlignArray() {
        CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VERTALIGN$26, arrayList);
            cTVerticalAlignFontPropertyArr = new CTVerticalAlignFontProperty[arrayList.size()];
            arrayList.toArray(cTVerticalAlignFontPropertyArr);
        }
        return cTVerticalAlignFontPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTVerticalAlignFontProperty> getVertAlignList() {
        1VertAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VertAlignList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewB(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(B$6, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty insertNewCharset(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(CHARSET$2, i);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor insertNewColor(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().insert_element_user(COLOR$20, i);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewCondense(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(CONDENSE$16, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewExtend(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(EXTEND$18, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty insertNewFamily(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(FAMILY$4, i);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewI(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(I$8, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewOutline(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(OUTLINE$12, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName insertNewRFont(int i) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().insert_element_user(RFONT$0, i);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme insertNewScheme(int i) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().insert_element_user(SCHEME$28, i);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewShadow(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(SHADOW$14, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewStrike(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(STRIKE$10, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize insertNewSz(int i) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().insert_element_user(SZ$22, i);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty insertNewU(int i) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().insert_element_user(U$24, i);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty insertNewVertAlign(int i) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().insert_element_user(VERTALIGN$26, i);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeCharset(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHARSET$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeColor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeCondense(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONDENSE$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeExtend(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeFamily(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FAMILY$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeI(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeOutline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINE$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeRFont(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RFONT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeScheme(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEME$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeStrike(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRIKE$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeSz(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZ$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeU(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(U$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeVertAlign(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTALIGN$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setBArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(B$6, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setBArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, B$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCharsetArray(int i, CTIntProperty cTIntProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTIntProperty cTIntProperty2 = (CTIntProperty) get_store().find_element_user(CHARSET$2, i);
            if (cTIntProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTIntProperty2.set(cTIntProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCharsetArray(CTIntProperty[] cTIntPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTIntPropertyArr, CHARSET$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setColorArray(int i, CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor2 = (CTColor) get_store().find_element_user(COLOR$20, i);
            if (cTColor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setColorArray(CTColor[] cTColorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTColorArr, COLOR$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCondenseArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(CONDENSE$16, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCondenseArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, CONDENSE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setExtendArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(EXTEND$18, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setExtendArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, EXTEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setFamilyArray(int i, CTIntProperty cTIntProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTIntProperty cTIntProperty2 = (CTIntProperty) get_store().find_element_user(FAMILY$4, i);
            if (cTIntProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTIntProperty2.set(cTIntProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setFamilyArray(CTIntProperty[] cTIntPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTIntPropertyArr, FAMILY$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setIArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(I$8, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setIArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, I$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setOutlineArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(OUTLINE$12, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setOutlineArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, OUTLINE$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setRFontArray(int i, CTFontName cTFontName) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontName cTFontName2 = (CTFontName) get_store().find_element_user(RFONT$0, i);
            if (cTFontName2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontName2.set(cTFontName);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setRFontArray(CTFontName[] cTFontNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontNameArr, RFONT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSchemeArray(int i, CTFontScheme cTFontScheme) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontScheme cTFontScheme2 = (CTFontScheme) get_store().find_element_user(SCHEME$28, i);
            if (cTFontScheme2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontScheme2.set(cTFontScheme);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSchemeArray(CTFontScheme[] cTFontSchemeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontSchemeArr, SCHEME$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setShadowArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(SHADOW$14, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setShadowArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, SHADOW$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setStrikeArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(STRIKE$10, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setStrikeArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, STRIKE$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSzArray(int i, CTFontSize cTFontSize) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontSize cTFontSize2 = (CTFontSize) get_store().find_element_user(SZ$22, i);
            if (cTFontSize2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontSize2.set(cTFontSize);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSzArray(CTFontSize[] cTFontSizeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontSizeArr, SZ$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setUArray(int i, CTUnderlineProperty cTUnderlineProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTUnderlineProperty cTUnderlineProperty2 = (CTUnderlineProperty) get_store().find_element_user(U$24, i);
            if (cTUnderlineProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTUnderlineProperty2.set(cTUnderlineProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setUArray(CTUnderlineProperty[] cTUnderlinePropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTUnderlinePropertyArr, U$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setVertAlignArray(int i, CTVerticalAlignFontProperty cTVerticalAlignFontProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalAlignFontProperty cTVerticalAlignFontProperty2 = (CTVerticalAlignFontProperty) get_store().find_element_user(VERTALIGN$26, i);
            if (cTVerticalAlignFontProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTVerticalAlignFontProperty2.set(cTVerticalAlignFontProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setVertAlignArray(CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTVerticalAlignFontPropertyArr, VERTALIGN$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfBArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(B$6);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfCharsetArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CHARSET$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfColorArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(COLOR$20);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfCondenseArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CONDENSE$16);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfExtendArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(EXTEND$18);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfFamilyArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FAMILY$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfIArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(I$8);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfOutlineArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(OUTLINE$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfRFontArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RFONT$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfSchemeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SCHEME$28);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfShadowArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SHADOW$14);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfStrikeArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(STRIKE$10);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfSzArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SZ$22);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfUArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(U$24);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfVertAlignArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(VERTALIGN$26);
        }
        return count_elements;
    }
}
