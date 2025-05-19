package jxl.demo;

import common.Logger;
import jxl.Cell;
import jxl.Range;
import jxl.Workbook;

/* loaded from: classes4.dex */
public class Demo {
    private static final int CSVFormat = 13;
    private static final int XMLFormat = 14;
    static /* synthetic */ Class class$jxl$demo$Demo;
    private static Logger logger;

    static {
        Class cls = class$jxl$demo$Demo;
        if (cls == null) {
            cls = class$("jxl.demo.Demo");
            class$jxl$demo$Demo = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static void displayHelp() {
        System.err.println("Command format:  Demo [-unicode] [-csv] [-hide] excelfile");
        System.err.println("                 Demo -xml [-format]  excelfile");
        System.err.println("                 Demo -readwrite|-rw excelfile output");
        System.err.println("                 Demo -biffdump | -bd | -wa | -write | -formulas | -features | -escher | -escherdg excelfile");
        System.err.println("                 Demo -ps excelfile [property] [output]");
        System.err.println("                 Demo -version | -logtest | -h | -help");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x020f A[Catch: all -> 0x0219, TRY_ENTER, TryCatch #0 {all -> 0x0219, blocks: (B:58:0x020f, B:62:0x021e, B:65:0x022a, B:68:0x0241, B:71:0x0258, B:74:0x026f, B:77:0x0285, B:80:0x0294, B:83:0x02a1, B:85:0x02a5, B:86:0x02aa, B:88:0x02b5, B:90:0x02c2, B:91:0x02d5, B:95:0x02ce), top: B:56:0x020d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r21) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.demo.Demo.main(java.lang.String[]):void");
    }

    private static void findTest(Workbook workbook) {
        logger.info("Find test");
        Cell findCellByName = workbook.findCellByName("named1");
        if (findCellByName != null) {
            logger.info(new StringBuffer().append("named1 contents:  ").append(findCellByName.getContents()).toString());
        }
        Cell findCellByName2 = workbook.findCellByName("named2");
        if (findCellByName2 != null) {
            logger.info(new StringBuffer().append("named2 contents:  ").append(findCellByName2.getContents()).toString());
        }
        Cell findCellByName3 = workbook.findCellByName("namedrange");
        if (findCellByName3 != null) {
            logger.info(new StringBuffer().append("named2 contents:  ").append(findCellByName3.getContents()).toString());
        }
        Range[] findByName = workbook.findByName("namedrange");
        if (findByName != null) {
            logger.info(new StringBuffer().append("namedrange top left contents:  ").append(findByName[0].getTopLeft().getContents()).toString());
            logger.info(new StringBuffer().append("namedrange bottom right contents:  ").append(findByName[0].getBottomRight().getContents()).toString());
        }
        Range[] findByName2 = workbook.findByName("nonadjacentrange");
        if (findByName2 != null) {
            for (int i = 0; i < findByName2.length; i++) {
                logger.info(new StringBuffer().append("nonadjacent top left contents:  ").append(findByName2[i].getTopLeft().getContents()).toString());
                logger.info(new StringBuffer().append("nonadjacent bottom right contents:  ").append(findByName2[i].getBottomRight().getContents()).toString());
            }
        }
        Range[] findByName3 = workbook.findByName("horizontalnonadjacentrange");
        if (findByName3 != null) {
            for (int i2 = 0; i2 < findByName3.length; i2++) {
                logger.info(new StringBuffer().append("horizontalnonadjacent top left contents:  ").append(findByName3[i2].getTopLeft().getContents()).toString());
                logger.info(new StringBuffer().append("horizontalnonadjacent bottom right contents:  ").append(findByName3[i2].getBottomRight().getContents()).toString());
            }
        }
    }
}
