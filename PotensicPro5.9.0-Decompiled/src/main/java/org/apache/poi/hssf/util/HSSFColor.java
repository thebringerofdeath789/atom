package org.apache.poi.hssf.util;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.ss.usermodel.Color;

/* loaded from: classes5.dex */
public class HSSFColor implements Color {
    private static Map<Integer, HSSFColor> indexHash;

    public String getHexString() {
        return BLACK.hexString;
    }

    public short getIndex() {
        return (short) 8;
    }

    public static final Map<Integer, HSSFColor> getIndexHash() {
        if (indexHash == null) {
            indexHash = Collections.unmodifiableMap(createColorsByIndexMap());
        }
        return indexHash;
    }

    public static final Hashtable<Integer, HSSFColor> getMutableIndexHash() {
        return createColorsByIndexMap();
    }

    private static Hashtable<Integer, HSSFColor> createColorsByIndexMap() {
        HSSFColor[] allColors = getAllColors();
        Hashtable<Integer, HSSFColor> hashtable = new Hashtable<>((allColors.length * 3) / 2);
        for (HSSFColor hSSFColor : allColors) {
            Integer valueOf = Integer.valueOf(hSSFColor.getIndex());
            if (hashtable.containsKey(valueOf)) {
                throw new RuntimeException("Dup color index (" + valueOf + ") for colors (" + hashtable.get(valueOf).getClass().getName() + "),(" + hSSFColor.getClass().getName() + ")");
            }
            hashtable.put(valueOf, hSSFColor);
        }
        for (HSSFColor hSSFColor2 : allColors) {
            Integer index2 = getIndex2(hSSFColor2);
            if (index2 != null) {
                hashtable.containsKey(index2);
                hashtable.put(index2, hSSFColor2);
            }
        }
        return hashtable;
    }

    private static Integer getIndex2(HSSFColor hSSFColor) {
        try {
            try {
                return Integer.valueOf(((Short) hSSFColor.getClass().getDeclaredField("index2").get(hSSFColor)).intValue());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static HSSFColor[] getAllColors() {
        return new HSSFColor[]{new BLACK(), new BROWN(), new OLIVE_GREEN(), new DARK_GREEN(), new DARK_TEAL(), new DARK_BLUE(), new INDIGO(), new GREY_80_PERCENT(), new ORANGE(), new DARK_YELLOW(), new GREEN(), new TEAL(), new BLUE(), new BLUE_GREY(), new GREY_50_PERCENT(), new RED(), new LIGHT_ORANGE(), new LIME(), new SEA_GREEN(), new AQUA(), new LIGHT_BLUE(), new VIOLET(), new GREY_40_PERCENT(), new PINK(), new GOLD(), new YELLOW(), new BRIGHT_GREEN(), new TURQUOISE(), new DARK_RED(), new SKY_BLUE(), new PLUM(), new GREY_25_PERCENT(), new ROSE(), new LIGHT_YELLOW(), new LIGHT_GREEN(), new LIGHT_TURQUOISE(), new PALE_BLUE(), new LAVENDER(), new WHITE(), new CORNFLOWER_BLUE(), new LEMON_CHIFFON(), new MAROON(), new ORCHID(), new CORAL(), new ROYAL_BLUE(), new LIGHT_CORNFLOWER_BLUE(), new TAN()};
    }

    public static final Hashtable<String, HSSFColor> getTripletHash() {
        return createColorsByHexStringMap();
    }

    private static Hashtable<String, HSSFColor> createColorsByHexStringMap() {
        HSSFColor[] allColors = getAllColors();
        Hashtable<String, HSSFColor> hashtable = new Hashtable<>((allColors.length * 3) / 2);
        for (HSSFColor hSSFColor : allColors) {
            String hexString = hSSFColor.getHexString();
            if (hashtable.containsKey(hexString)) {
                throw new RuntimeException("Dup color hexString (" + hexString + ") for color (" + hSSFColor.getClass().getName() + ") -  already taken by (" + hashtable.get(hexString).getClass().getName() + ")");
            }
            hashtable.put(hexString, hSSFColor);
        }
        return hashtable;
    }

    public short[] getTriplet() {
        return BLACK.triplet;
    }

    public static final class BLACK extends HSSFColor {
        public static final String hexString = "0:0:0";
        public static final short index = 8;
        public static final short[] triplet = {0, 0, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 8;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class BROWN extends HSSFColor {
        public static final String hexString = "9999:3333:0";
        public static final short index = 60;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCURVEDOWN, 51, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 60;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static class OLIVE_GREEN extends HSSFColor {
        public static final String hexString = "3333:3333:0";
        public static final short index = 59;
        public static final short[] triplet = {51, 51, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 59;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class DARK_GREEN extends HSSFColor {
        public static final String hexString = "0:3333:0";
        public static final short index = 58;
        public static final short[] triplet = {0, 51, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 58;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class DARK_TEAL extends HSSFColor {
        public static final String hexString = "0:3333:6666";
        public static final short index = 56;
        public static final short[] triplet = {0, 51, EscherAggregate.ST_CURVEDRIGHTARROW};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 56;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class DARK_BLUE extends HSSFColor {
        public static final String hexString = "0:0:8080";
        public static final short index = 18;
        public static final short index2 = 32;
        public static final short[] triplet = {0, 0, 128};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 18;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class INDIGO extends HSSFColor {
        public static final String hexString = "3333:3333:9999";
        public static final short index = 62;
        public static final short[] triplet = {51, 51, EscherAggregate.ST_TEXTCURVEDOWN};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 62;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GREY_80_PERCENT extends HSSFColor {
        public static final String hexString = "3333:3333:3333";
        public static final short index = 63;
        public static final short[] triplet = {51, 51, 51};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 63;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class DARK_RED extends HSSFColor {
        public static final String hexString = "8080:0:0";
        public static final short index = 16;
        public static final short index2 = 37;
        public static final short[] triplet = {128, 0, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 16;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class ORANGE extends HSSFColor {
        public static final String hexString = "FFFF:6666:0";
        public static final short index = 53;
        public static final short[] triplet = {255, EscherAggregate.ST_CURVEDRIGHTARROW, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 53;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class DARK_YELLOW extends HSSFColor {
        public static final String hexString = "8080:8080:0";
        public static final short index = 19;
        public static final short[] triplet = {128, 128, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 19;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GREEN extends HSSFColor {
        public static final String hexString = "0:8080:0";
        public static final short index = 17;
        public static final short[] triplet = {0, 128, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 17;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class TEAL extends HSSFColor {
        public static final String hexString = "0:8080:8080";
        public static final short index = 21;
        public static final short index2 = 38;
        public static final short[] triplet = {0, 128, 128};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 21;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class BLUE extends HSSFColor {
        public static final String hexString = "0:0:FFFF";
        public static final short index = 12;
        public static final short index2 = 39;
        public static final short[] triplet = {0, 0, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 12;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class BLUE_GREY extends HSSFColor {
        public static final String hexString = "6666:6666:9999";
        public static final short index = 54;
        public static final short[] triplet = {EscherAggregate.ST_CURVEDRIGHTARROW, EscherAggregate.ST_CURVEDRIGHTARROW, EscherAggregate.ST_TEXTCURVEDOWN};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 54;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GREY_50_PERCENT extends HSSFColor {
        public static final String hexString = "8080:8080:8080";
        public static final short index = 23;
        public static final short[] triplet = {128, 128, 128};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 23;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class RED extends HSSFColor {
        public static final String hexString = "FFFF:0:0";
        public static final short index = 10;
        public static final short[] triplet = {255, 0, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 10;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_ORANGE extends HSSFColor {
        public static final String hexString = "FFFF:9999:0";
        public static final short index = 52;
        public static final short[] triplet = {255, EscherAggregate.ST_TEXTCURVEDOWN, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 52;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIME extends HSSFColor {
        public static final String hexString = "9999:CCCC:0";
        public static final short index = 50;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCURVEDOWN, 204, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 50;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class SEA_GREEN extends HSSFColor {
        public static final String hexString = "3333:9999:6666";
        public static final short index = 57;
        public static final short[] triplet = {51, EscherAggregate.ST_TEXTCURVEDOWN, EscherAggregate.ST_CURVEDRIGHTARROW};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 57;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class AQUA extends HSSFColor {
        public static final String hexString = "3333:CCCC:CCCC";
        public static final short index = 49;
        public static final short[] triplet = {51, 204, 204};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 49;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_BLUE extends HSSFColor {
        public static final String hexString = "3333:6666:FFFF";
        public static final short index = 48;
        public static final short[] triplet = {51, EscherAggregate.ST_CURVEDRIGHTARROW, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 48;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class VIOLET extends HSSFColor {
        public static final String hexString = "8080:0:8080";
        public static final short index = 20;
        public static final short index2 = 36;
        public static final short[] triplet = {128, 0, 128};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 20;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GREY_40_PERCENT extends HSSFColor {
        public static final String hexString = "9696:9696:9696";
        public static final short index = 55;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCIRCLEPOUR, EscherAggregate.ST_TEXTCIRCLEPOUR, EscherAggregate.ST_TEXTCIRCLEPOUR};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 55;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class PINK extends HSSFColor {
        public static final String hexString = "FFFF:0:FFFF";
        public static final short index = 14;
        public static final short index2 = 33;
        public static final short[] triplet = {255, 0, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 14;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GOLD extends HSSFColor {
        public static final String hexString = "FFFF:CCCC:0";
        public static final short index = 51;
        public static final short[] triplet = {255, 204, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 51;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class YELLOW extends HSSFColor {
        public static final String hexString = "FFFF:FFFF:0";
        public static final short index = 13;
        public static final short index2 = 34;
        public static final short[] triplet = {255, 255, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 13;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class BRIGHT_GREEN extends HSSFColor {
        public static final String hexString = "0:FFFF:0";
        public static final short index = 11;
        public static final short index2 = 35;
        public static final short[] triplet = {0, 255, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 11;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class TURQUOISE extends HSSFColor {
        public static final String hexString = "0:FFFF:FFFF";
        public static final short index = 15;
        public static final short index2 = 35;
        public static final short[] triplet = {0, 255, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 15;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class SKY_BLUE extends HSSFColor {
        public static final String hexString = "0:CCCC:FFFF";
        public static final short index = 40;
        public static final short[] triplet = {0, 204, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 40;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class PLUM extends HSSFColor {
        public static final String hexString = "9999:3333:6666";
        public static final short index = 61;
        public static final short index2 = 25;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCURVEDOWN, 51, EscherAggregate.ST_CURVEDRIGHTARROW};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 61;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class GREY_25_PERCENT extends HSSFColor {
        public static final String hexString = "C0C0:C0C0:C0C0";
        public static final short index = 22;
        public static final short[] triplet = {192, 192, 192};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 22;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class ROSE extends HSSFColor {
        public static final String hexString = "FFFF:9999:CCCC";
        public static final short index = 45;
        public static final short[] triplet = {255, EscherAggregate.ST_TEXTCURVEDOWN, 204};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 45;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class TAN extends HSSFColor {
        public static final String hexString = "FFFF:CCCC:9999";
        public static final short index = 47;
        public static final short[] triplet = {255, 204, EscherAggregate.ST_TEXTCURVEDOWN};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 47;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_YELLOW extends HSSFColor {
        public static final String hexString = "FFFF:FFFF:9999";
        public static final short index = 43;
        public static final short[] triplet = {255, 255, EscherAggregate.ST_TEXTCURVEDOWN};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 43;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_GREEN extends HSSFColor {
        public static final String hexString = "CCCC:FFFF:CCCC";
        public static final short index = 42;
        public static final short[] triplet = {204, 255, 204};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 42;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_TURQUOISE extends HSSFColor {
        public static final String hexString = "CCCC:FFFF:FFFF";
        public static final short index = 41;
        public static final short index2 = 27;
        public static final short[] triplet = {204, 255, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 41;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class PALE_BLUE extends HSSFColor {
        public static final String hexString = "9999:CCCC:FFFF";
        public static final short index = 44;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCURVEDOWN, 204, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 44;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LAVENDER extends HSSFColor {
        public static final String hexString = "CCCC:9999:FFFF";
        public static final short index = 46;
        public static final short[] triplet = {204, EscherAggregate.ST_TEXTCURVEDOWN, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 46;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class WHITE extends HSSFColor {
        public static final String hexString = "FFFF:FFFF:FFFF";
        public static final short index = 9;
        public static final short[] triplet = {255, 255, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 9;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class CORNFLOWER_BLUE extends HSSFColor {
        public static final String hexString = "9999:9999:FFFF";
        public static final short index = 24;
        public static final short[] triplet = {EscherAggregate.ST_TEXTCURVEDOWN, EscherAggregate.ST_TEXTCURVEDOWN, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 24;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LEMON_CHIFFON extends HSSFColor {
        public static final String hexString = "FFFF:FFFF:CCCC";
        public static final short index = 26;
        public static final short[] triplet = {255, 255, 204};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 26;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class MAROON extends HSSFColor {
        public static final String hexString = "8000:0:0";
        public static final short index = 25;
        public static final short[] triplet = {127, 0, 0};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 25;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class ORCHID extends HSSFColor {
        public static final String hexString = "6666:0:6666";
        public static final short index = 28;
        public static final short[] triplet = {EscherAggregate.ST_CURVEDRIGHTARROW, 0, EscherAggregate.ST_CURVEDRIGHTARROW};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 28;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class CORAL extends HSSFColor {
        public static final String hexString = "FFFF:8080:8080";
        public static final short index = 29;
        public static final short[] triplet = {255, 128, 128};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 29;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class ROYAL_BLUE extends HSSFColor {
        public static final String hexString = "0:6666:CCCC";
        public static final short index = 30;
        public static final short[] triplet = {0, EscherAggregate.ST_CURVEDRIGHTARROW, 204};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 30;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class LIGHT_CORNFLOWER_BLUE extends HSSFColor {
        public static final String hexString = "CCCC:CCCC:FFFF";
        public static final short index = 31;
        public static final short[] triplet = {204, 204, 255};

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 31;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return triplet;
        }
    }

    public static final class AUTOMATIC extends HSSFColor {
        public static final short index = 64;
        private static HSSFColor instance = new AUTOMATIC();

        @Override // org.apache.poi.hssf.util.HSSFColor
        public String getHexString() {
            return BLACK.hexString;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short getIndex() {
            return (short) 64;
        }

        @Override // org.apache.poi.hssf.util.HSSFColor
        public short[] getTriplet() {
            return BLACK.triplet;
        }

        public static HSSFColor getInstance() {
            return instance;
        }
    }
}
