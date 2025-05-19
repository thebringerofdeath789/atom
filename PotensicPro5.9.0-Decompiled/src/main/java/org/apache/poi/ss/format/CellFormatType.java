package org.apache.poi.ss.format;

/* loaded from: classes5.dex */
public enum CellFormatType {
    GENERAL { // from class: org.apache.poi.ss.format.CellFormatType.1
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellGeneralFormatter();
        }
    },
    NUMBER { // from class: org.apache.poi.ss.format.CellFormatType.2
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellNumberFormatter(str);
        }
    },
    DATE { // from class: org.apache.poi.ss.format.CellFormatType.3
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return c == '\'' || (c <= 127 && Character.isLetter(c));
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellDateFormatter(str);
        }
    },
    ELAPSED { // from class: org.apache.poi.ss.format.CellFormatType.4
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellElapsedFormatter(str);
        }
    },
    TEXT { // from class: org.apache.poi.ss.format.CellFormatType.5
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellTextFormatter(str);
        }
    };

    abstract CellFormatter formatter(String str);

    abstract boolean isSpecial(char c);
}
