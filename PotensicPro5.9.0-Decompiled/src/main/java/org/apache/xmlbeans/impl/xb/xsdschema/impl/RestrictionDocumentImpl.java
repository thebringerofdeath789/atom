package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;

/* loaded from: classes5.dex */
public class RestrictionDocumentImpl extends XmlComplexContentImpl implements RestrictionDocument {
    private static final QName RESTRICTION$0 = new QName("http://www.w3.org/2001/XMLSchema", "restriction");

    public RestrictionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public RestrictionDocument.Restriction getRestriction() {
        synchronized (monitor()) {
            check_orphaned();
            RestrictionDocument.Restriction restriction = (RestrictionDocument.Restriction) get_store().find_element_user(RESTRICTION$0, 0);
            if (restriction == null) {
                return null;
            }
            return restriction;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public void setRestriction(RestrictionDocument.Restriction restriction) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RESTRICTION$0;
            RestrictionDocument.Restriction restriction2 = (RestrictionDocument.Restriction) typeStore.find_element_user(qName, 0);
            if (restriction2 == null) {
                restriction2 = (RestrictionDocument.Restriction) get_store().add_element_user(qName);
            }
            restriction2.set(restriction);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public RestrictionDocument.Restriction addNewRestriction() {
        RestrictionDocument.Restriction restriction;
        synchronized (monitor()) {
            check_orphaned();
            restriction = (RestrictionDocument.Restriction) get_store().add_element_user(RESTRICTION$0);
        }
        return restriction;
    }

    public static class RestrictionImpl extends AnnotatedImpl implements RestrictionDocument.Restriction {
        private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");
        private static final QName MINEXCLUSIVE$2 = new QName("http://www.w3.org/2001/XMLSchema", "minExclusive");
        private static final QName MININCLUSIVE$4 = new QName("http://www.w3.org/2001/XMLSchema", "minInclusive");
        private static final QName MAXEXCLUSIVE$6 = new QName("http://www.w3.org/2001/XMLSchema", "maxExclusive");
        private static final QName MAXINCLUSIVE$8 = new QName("http://www.w3.org/2001/XMLSchema", "maxInclusive");
        private static final QName TOTALDIGITS$10 = new QName("http://www.w3.org/2001/XMLSchema", "totalDigits");
        private static final QName FRACTIONDIGITS$12 = new QName("http://www.w3.org/2001/XMLSchema", "fractionDigits");
        private static final QName LENGTH$14 = new QName("http://www.w3.org/2001/XMLSchema", SessionDescription.ATTR_LENGTH);
        private static final QName MINLENGTH$16 = new QName("http://www.w3.org/2001/XMLSchema", "minLength");
        private static final QName MAXLENGTH$18 = new QName("http://www.w3.org/2001/XMLSchema", "maxLength");
        private static final QName ENUMERATION$20 = new QName("http://www.w3.org/2001/XMLSchema", "enumeration");
        private static final QName WHITESPACE$22 = new QName("http://www.w3.org/2001/XMLSchema", "whiteSpace");
        private static final QName PATTERN$24 = new QName("http://www.w3.org/2001/XMLSchema", "pattern");
        private static final QName BASE$26 = new QName("", TtmlNode.RUBY_BASE);

        public RestrictionImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public LocalSimpleType getSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                LocalSimpleType localSimpleType = (LocalSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
                if (localSimpleType == null) {
                    return null;
                }
                return localSimpleType;
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public boolean isSetSimpleType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(SIMPLETYPE$0) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setSimpleType(LocalSimpleType localSimpleType) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SIMPLETYPE$0;
                LocalSimpleType localSimpleType2 = (LocalSimpleType) typeStore.find_element_user(qName, 0);
                if (localSimpleType2 == null) {
                    localSimpleType2 = (LocalSimpleType) get_store().add_element_user(qName);
                }
                localSimpleType2.set(localSimpleType);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(SIMPLETYPE$0);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void unsetSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(SIMPLETYPE$0, 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMinExclusiveArray() {
            Facet[] facetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MINEXCLUSIVE$2, arrayList);
                facetArr = new Facet[arrayList.size()];
                arrayList.toArray(facetArr);
            }
            return facetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMinExclusiveArray(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(MINEXCLUSIVE$2, i);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinExclusiveArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MINEXCLUSIVE$2);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinExclusiveArray(Facet[] facetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(facetArr, MINEXCLUSIVE$2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinExclusiveArray(int i, Facet facet) {
            synchronized (monitor()) {
                check_orphaned();
                Facet facet2 = (Facet) get_store().find_element_user(MINEXCLUSIVE$2, i);
                if (facet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                facet2.set(facet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMinExclusive(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(MINEXCLUSIVE$2, i);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMinExclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(MINEXCLUSIVE$2);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinExclusive(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MINEXCLUSIVE$2, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMinInclusiveArray() {
            Facet[] facetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MININCLUSIVE$4, arrayList);
                facetArr = new Facet[arrayList.size()];
                arrayList.toArray(facetArr);
            }
            return facetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMinInclusiveArray(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(MININCLUSIVE$4, i);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinInclusiveArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MININCLUSIVE$4);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinInclusiveArray(Facet[] facetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(facetArr, MININCLUSIVE$4);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinInclusiveArray(int i, Facet facet) {
            synchronized (monitor()) {
                check_orphaned();
                Facet facet2 = (Facet) get_store().find_element_user(MININCLUSIVE$4, i);
                if (facet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                facet2.set(facet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMinInclusive(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(MININCLUSIVE$4, i);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMinInclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(MININCLUSIVE$4);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinInclusive(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MININCLUSIVE$4, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMaxExclusiveArray() {
            Facet[] facetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MAXEXCLUSIVE$6, arrayList);
                facetArr = new Facet[arrayList.size()];
                arrayList.toArray(facetArr);
            }
            return facetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMaxExclusiveArray(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(MAXEXCLUSIVE$6, i);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxExclusiveArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MAXEXCLUSIVE$6);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxExclusiveArray(Facet[] facetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(facetArr, MAXEXCLUSIVE$6);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxExclusiveArray(int i, Facet facet) {
            synchronized (monitor()) {
                check_orphaned();
                Facet facet2 = (Facet) get_store().find_element_user(MAXEXCLUSIVE$6, i);
                if (facet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                facet2.set(facet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMaxExclusive(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(MAXEXCLUSIVE$6, i);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMaxExclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(MAXEXCLUSIVE$6);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxExclusive(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MAXEXCLUSIVE$6, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMaxInclusiveArray() {
            Facet[] facetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MAXINCLUSIVE$8, arrayList);
                facetArr = new Facet[arrayList.size()];
                arrayList.toArray(facetArr);
            }
            return facetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMaxInclusiveArray(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(MAXINCLUSIVE$8, i);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxInclusiveArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MAXINCLUSIVE$8);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxInclusiveArray(Facet[] facetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(facetArr, MAXINCLUSIVE$8);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxInclusiveArray(int i, Facet facet) {
            synchronized (monitor()) {
                check_orphaned();
                Facet facet2 = (Facet) get_store().find_element_user(MAXINCLUSIVE$8, i);
                if (facet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                facet2.set(facet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMaxInclusive(int i) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(MAXINCLUSIVE$8, i);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMaxInclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(MAXINCLUSIVE$8);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxInclusive(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MAXINCLUSIVE$8, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
            TotalDigitsDocument.TotalDigits[] totalDigitsArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(TOTALDIGITS$10, arrayList);
                totalDigitsArr = new TotalDigitsDocument.TotalDigits[arrayList.size()];
                arrayList.toArray(totalDigitsArr);
            }
            return totalDigitsArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i) {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(TOTALDIGITS$10, i);
                if (totalDigits == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfTotalDigitsArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(TOTALDIGITS$10);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(totalDigitsArr, TOTALDIGITS$10);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setTotalDigitsArray(int i, TotalDigitsDocument.TotalDigits totalDigits) {
            synchronized (monitor()) {
                check_orphaned();
                TotalDigitsDocument.TotalDigits totalDigits2 = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(TOTALDIGITS$10, i);
                if (totalDigits2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                totalDigits2.set(totalDigits);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i) {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().insert_element_user(TOTALDIGITS$10, i);
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(TOTALDIGITS$10);
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeTotalDigits(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(TOTALDIGITS$10, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getFractionDigitsArray() {
            NumFacet[] numFacetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(FRACTIONDIGITS$12, arrayList);
                numFacetArr = new NumFacet[arrayList.size()];
                arrayList.toArray(numFacetArr);
            }
            return numFacetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getFractionDigitsArray(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(FRACTIONDIGITS$12, i);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfFractionDigitsArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(FRACTIONDIGITS$12);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setFractionDigitsArray(NumFacet[] numFacetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(numFacetArr, FRACTIONDIGITS$12);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setFractionDigitsArray(int i, NumFacet numFacet) {
            synchronized (monitor()) {
                check_orphaned();
                NumFacet numFacet2 = (NumFacet) get_store().find_element_user(FRACTIONDIGITS$12, i);
                if (numFacet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                numFacet2.set(numFacet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewFractionDigits(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(FRACTIONDIGITS$12, i);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewFractionDigits() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(FRACTIONDIGITS$12);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeFractionDigits(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(FRACTIONDIGITS$12, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getLengthArray() {
            NumFacet[] numFacetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(LENGTH$14, arrayList);
                numFacetArr = new NumFacet[arrayList.size()];
                arrayList.toArray(numFacetArr);
            }
            return numFacetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getLengthArray(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(LENGTH$14, i);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfLengthArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(LENGTH$14);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setLengthArray(NumFacet[] numFacetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(numFacetArr, LENGTH$14);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setLengthArray(int i, NumFacet numFacet) {
            synchronized (monitor()) {
                check_orphaned();
                NumFacet numFacet2 = (NumFacet) get_store().find_element_user(LENGTH$14, i);
                if (numFacet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                numFacet2.set(numFacet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewLength(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(LENGTH$14, i);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(LENGTH$14);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeLength(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(LENGTH$14, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getMinLengthArray() {
            NumFacet[] numFacetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MINLENGTH$16, arrayList);
                numFacetArr = new NumFacet[arrayList.size()];
                arrayList.toArray(numFacetArr);
            }
            return numFacetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getMinLengthArray(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(MINLENGTH$16, i);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinLengthArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MINLENGTH$16);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinLengthArray(NumFacet[] numFacetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(numFacetArr, MINLENGTH$16);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinLengthArray(int i, NumFacet numFacet) {
            synchronized (monitor()) {
                check_orphaned();
                NumFacet numFacet2 = (NumFacet) get_store().find_element_user(MINLENGTH$16, i);
                if (numFacet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                numFacet2.set(numFacet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewMinLength(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(MINLENGTH$16, i);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewMinLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(MINLENGTH$16);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinLength(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MINLENGTH$16, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getMaxLengthArray() {
            NumFacet[] numFacetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(MAXLENGTH$18, arrayList);
                numFacetArr = new NumFacet[arrayList.size()];
                arrayList.toArray(numFacetArr);
            }
            return numFacetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getMaxLengthArray(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(MAXLENGTH$18, i);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxLengthArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(MAXLENGTH$18);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxLengthArray(NumFacet[] numFacetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(numFacetArr, MAXLENGTH$18);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxLengthArray(int i, NumFacet numFacet) {
            synchronized (monitor()) {
                check_orphaned();
                NumFacet numFacet2 = (NumFacet) get_store().find_element_user(MAXLENGTH$18, i);
                if (numFacet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                numFacet2.set(numFacet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewMaxLength(int i) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(MAXLENGTH$18, i);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewMaxLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(MAXLENGTH$18);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxLength(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(MAXLENGTH$18, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet[] getEnumerationArray() {
            NoFixedFacet[] noFixedFacetArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(ENUMERATION$20, arrayList);
                noFixedFacetArr = new NoFixedFacet[arrayList.size()];
                arrayList.toArray(noFixedFacetArr);
            }
            return noFixedFacetArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet getEnumerationArray(int i) {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().find_element_user(ENUMERATION$20, i);
                if (noFixedFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfEnumerationArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(ENUMERATION$20);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setEnumerationArray(NoFixedFacet[] noFixedFacetArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(noFixedFacetArr, ENUMERATION$20);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setEnumerationArray(int i, NoFixedFacet noFixedFacet) {
            synchronized (monitor()) {
                check_orphaned();
                NoFixedFacet noFixedFacet2 = (NoFixedFacet) get_store().find_element_user(ENUMERATION$20, i);
                if (noFixedFacet2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                noFixedFacet2.set(noFixedFacet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet insertNewEnumeration(int i) {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().insert_element_user(ENUMERATION$20, i);
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet addNewEnumeration() {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().add_element_user(ENUMERATION$20);
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeEnumeration(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(ENUMERATION$20, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
            WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(WHITESPACE$22, arrayList);
                whiteSpaceArr = new WhiteSpaceDocument.WhiteSpace[arrayList.size()];
                arrayList.toArray(whiteSpaceArr);
            }
            return whiteSpaceArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i) {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(WHITESPACE$22, i);
                if (whiteSpace == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfWhiteSpaceArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(WHITESPACE$22);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(whiteSpaceArr, WHITESPACE$22);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setWhiteSpaceArray(int i, WhiteSpaceDocument.WhiteSpace whiteSpace) {
            synchronized (monitor()) {
                check_orphaned();
                WhiteSpaceDocument.WhiteSpace whiteSpace2 = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(WHITESPACE$22, i);
                if (whiteSpace2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                whiteSpace2.set(whiteSpace);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i) {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().insert_element_user(WHITESPACE$22, i);
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(WHITESPACE$22);
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeWhiteSpace(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(WHITESPACE$22, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern[] getPatternArray() {
            PatternDocument.Pattern[] patternArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(PATTERN$24, arrayList);
                patternArr = new PatternDocument.Pattern[arrayList.size()];
                arrayList.toArray(patternArr);
            }
            return patternArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern getPatternArray(int i) {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().find_element_user(PATTERN$24, i);
                if (pattern == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfPatternArray() {
            int count_elements;
            synchronized (monitor()) {
                check_orphaned();
                count_elements = get_store().count_elements(PATTERN$24);
            }
            return count_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setPatternArray(PatternDocument.Pattern[] patternArr) {
            synchronized (monitor()) {
                check_orphaned();
                arraySetterHelper(patternArr, PATTERN$24);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setPatternArray(int i, PatternDocument.Pattern pattern) {
            synchronized (monitor()) {
                check_orphaned();
                PatternDocument.Pattern pattern2 = (PatternDocument.Pattern) get_store().find_element_user(PATTERN$24, i);
                if (pattern2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                pattern2.set(pattern);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern insertNewPattern(int i) {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().insert_element_user(PATTERN$24, i);
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern addNewPattern() {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().add_element_user(PATTERN$24);
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removePattern(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PATTERN$24, i);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public QName getBase() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BASE$26);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getQNameValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public XmlQName xgetBase() {
            XmlQName xmlQName;
            synchronized (monitor()) {
                check_orphaned();
                xmlQName = (XmlQName) get_store().find_attribute_user(BASE$26);
            }
            return xmlQName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public boolean isSetBase() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(BASE$26) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setBase(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName2 = BASE$26;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
                }
                simpleValue.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void xsetBase(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BASE$26;
                XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
                if (xmlQName2 == null) {
                    xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
                }
                xmlQName2.set(xmlQName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void unsetBase() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(BASE$26);
            }
        }
    }
}
