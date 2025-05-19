package jxl.biff;

import com.logan.flight.FlightConfig;
import common.Assert;
import common.Logger;

/* loaded from: classes4.dex */
public abstract class BaseCompoundFile {
    protected static final int BIG_BLOCK_DEPOT_BLOCKS_POS = 76;
    protected static final int BIG_BLOCK_SIZE = 512;
    private static final int CHILD_POS = 76;
    private static final int COLOUR_POS = 67;
    public static final String COMP_OBJ_NAME = "\u0001CompObj";
    public static final int DIRECTORY_PS_TYPE = 1;
    public static final String DOCUMENT_SUMMARY_INFORMATION_NAME = "\u0005DocumentSummaryInformation";
    protected static final int EXTENSION_BLOCK_POS = 68;
    public static final int FILE_PS_TYPE = 2;
    protected static final byte[] IDENTIFIER;
    private static final int NEXT_POS = 72;
    public static final int NONE_PS_TYPE = 0;
    protected static final int NUM_BIG_BLOCK_DEPOT_BLOCKS_POS = 44;
    protected static final int NUM_EXTENSION_BLOCK_POS = 72;
    protected static final int NUM_SMALL_BLOCK_DEPOT_BLOCKS_POS = 64;
    private static final int PREVIOUS_POS = 68;
    protected static final int PROPERTY_STORAGE_BLOCK_SIZE = 128;
    public static final String ROOT_ENTRY_NAME = "Root Entry";
    public static final int ROOT_ENTRY_PS_TYPE = 5;
    protected static final int ROOT_START_BLOCK_POS = 48;
    private static final int SIZE_OF_NAME_POS = 64;
    private static final int SIZE_POS = 120;
    protected static final int SMALL_BLOCK_DEPOT_BLOCK_POS = 60;
    protected static final int SMALL_BLOCK_SIZE = 64;
    protected static final int SMALL_BLOCK_THRESHOLD = 4096;
    public static final String[] STANDARD_PROPERTY_SETS;
    private static final int START_BLOCK_POS = 116;
    public static final String SUMMARY_INFORMATION_NAME = "\u0005SummaryInformation";
    private static final int TYPE_POS = 66;
    public static final String WORKBOOK_NAME = "Workbook";
    static /* synthetic */ Class class$jxl$biff$BaseCompoundFile;
    private static Logger logger;

    static {
        Class cls = class$jxl$biff$BaseCompoundFile;
        if (cls == null) {
            cls = class$("jxl.biff.BaseCompoundFile");
            class$jxl$biff$BaseCompoundFile = cls;
        }
        logger = Logger.getLogger(cls);
        IDENTIFIER = new byte[]{-48, -49, 17, -32, -95, FlightConfig.ATOM, 26, -31};
        STANDARD_PROPERTY_SETS = new String[]{ROOT_ENTRY_NAME, WORKBOOK_NAME, "\u0005SummaryInformation", "\u0005DocumentSummaryInformation"};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public class PropertyStorage {
        public int child;
        public int colour;
        public byte[] data;
        public String name;
        public int next;
        public int previous;
        public int size;
        public int startBlock;
        public int type;

        public PropertyStorage(byte[] bArr) {
            this.data = bArr;
            int i = 64;
            int i2 = IntegerHelper.getInt(bArr[64], bArr[65]);
            if (i2 > 64) {
                BaseCompoundFile.logger.warn("property set name exceeds max length - truncating");
            } else {
                i = i2;
            }
            byte[] bArr2 = this.data;
            this.type = bArr2[66];
            this.colour = bArr2[67];
            this.startBlock = IntegerHelper.getInt(bArr2[116], bArr2[117], bArr2[118], bArr2[119]);
            byte[] bArr3 = this.data;
            this.size = IntegerHelper.getInt(bArr3[120], bArr3[121], bArr3[122], bArr3[123]);
            byte[] bArr4 = this.data;
            this.previous = IntegerHelper.getInt(bArr4[68], bArr4[69], bArr4[70], bArr4[71]);
            byte[] bArr5 = this.data;
            this.next = IntegerHelper.getInt(bArr5[72], bArr5[73], bArr5[74], bArr5[75]);
            byte[] bArr6 = this.data;
            this.child = IntegerHelper.getInt(bArr6[76], bArr6[77], bArr6[78], bArr6[79]);
            int i3 = i > 2 ? (i - 1) / 2 : 0;
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i4 = 0; i4 < i3; i4++) {
                stringBuffer.append((char) this.data[i4 * 2]);
            }
            this.name = stringBuffer.toString();
        }

        public PropertyStorage(String str) {
            this.data = new byte[128];
            Assert.verify(str.length() < 32);
            IntegerHelper.getTwoBytes((str.length() + 1) * 2, this.data, 64);
            for (int i = 0; i < str.length(); i++) {
                this.data[i * 2] = (byte) str.charAt(i);
            }
        }

        public void setType(int i) {
            this.type = i;
            this.data[66] = (byte) i;
        }

        public void setStartBlock(int i) {
            this.startBlock = i;
            IntegerHelper.getFourBytes(i, this.data, 116);
        }

        public void setSize(int i) {
            this.size = i;
            IntegerHelper.getFourBytes(i, this.data, 120);
        }

        public void setPrevious(int i) {
            this.previous = i;
            IntegerHelper.getFourBytes(i, this.data, 68);
        }

        public void setNext(int i) {
            this.next = i;
            IntegerHelper.getFourBytes(i, this.data, 72);
        }

        public void setChild(int i) {
            this.child = i;
            IntegerHelper.getFourBytes(i, this.data, 76);
        }

        public void setColour(int i) {
            int i2 = i == 0 ? 0 : 1;
            this.colour = i2;
            this.data[67] = (byte) i2;
        }
    }

    protected BaseCompoundFile() {
    }
}
