package jxl.write.biff;

import common.Assert;
import common.Logger;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.biff.BaseCompoundFile;
import jxl.biff.IntegerHelper;
import jxl.read.biff.BiffException;

/* loaded from: classes4.dex */
final class CompoundFile extends BaseCompoundFile {
    static /* synthetic */ Class class$jxl$write$biff$CompoundFile;
    private static Logger logger;
    private int additionalPropertyBlocks;
    private ArrayList additionalPropertySets;
    private int bbdPos;
    private int bbdStartBlock;
    private byte[] bigBlockDepot;
    private byte[] excelData;
    private int excelDataBlocks;
    private int excelDataStartBlock;
    private int extensionBlock;
    private int numBigBlockDepotBlocks;
    private int numExtensionBlocks;
    private int numPropertySets;
    private int numRootEntryBlocks;
    private int numSmallBlockDepotBlocks;
    private int numSmallBlockDepotChainBlocks;
    private int numSmallBlocks;
    private OutputStream out;
    private int requiredSize;
    private int rootStartBlock;
    private int sbdStartBlock;
    private int sbdStartBlockChain;
    private int size;
    private HashMap standardPropertySets;

    static {
        Class cls = class$jxl$write$biff$CompoundFile;
        if (cls == null) {
            cls = class$("jxl.write.biff.CompoundFile");
            class$jxl$write$biff$CompoundFile = cls;
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

    private static final class ReadPropertyStorage {
        byte[] data;
        int number;
        BaseCompoundFile.PropertyStorage propertyStorage;

        ReadPropertyStorage(BaseCompoundFile.PropertyStorage propertyStorage, byte[] bArr, int i) {
            this.propertyStorage = propertyStorage;
            this.data = bArr;
            this.number = i;
        }
    }

    public CompoundFile(byte[] bArr, int i, OutputStream outputStream, jxl.read.biff.CompoundFile compoundFile) throws CopyAdditionalPropertySetsException, IOException {
        this.size = i;
        this.excelData = bArr;
        readAdditionalPropertySets(compoundFile);
        this.numRootEntryBlocks = 1;
        ArrayList arrayList = this.additionalPropertySets;
        this.numPropertySets = (arrayList != null ? arrayList.size() : 0) + 4;
        if (this.additionalPropertySets != null) {
            this.numSmallBlockDepotChainBlocks = getBigBlocksRequired(this.numSmallBlocks * 4);
            this.numSmallBlockDepotBlocks = getBigBlocksRequired(this.numSmallBlocks * 64);
            this.numRootEntryBlocks += getBigBlocksRequired(this.additionalPropertySets.size() * 128);
        }
        int bigBlocksRequired = getBigBlocksRequired(i);
        if (i < 4096) {
            this.requiredSize = 4096;
        } else {
            this.requiredSize = bigBlocksRequired * 512;
        }
        this.out = outputStream;
        int i2 = this.requiredSize / 512;
        this.excelDataBlocks = i2;
        this.numBigBlockDepotBlocks = 1;
        int i3 = i2 + 8 + 8 + this.additionalPropertyBlocks + this.numSmallBlockDepotBlocks + this.numSmallBlockDepotChainBlocks + this.numRootEntryBlocks;
        this.numBigBlockDepotBlocks = (int) Math.ceil((i3 + 1) / 128.0d);
        int ceil = (int) Math.ceil((r10 + i3) / 128.0d);
        this.numBigBlockDepotBlocks = ceil;
        int i4 = i3 + ceil;
        if (ceil > 108) {
            this.extensionBlock = 0;
            this.numExtensionBlocks = (int) Math.ceil(((ceil - 109) + 1) / 127.0d);
            int ceil2 = (int) Math.ceil(((r8 + i3) + this.numBigBlockDepotBlocks) / 128.0d);
            this.numBigBlockDepotBlocks = ceil2;
            i4 = i3 + this.numExtensionBlocks + ceil2;
        } else {
            this.extensionBlock = -2;
            this.numExtensionBlocks = 0;
        }
        int i5 = this.numExtensionBlocks;
        this.excelDataStartBlock = i5;
        this.sbdStartBlock = -2;
        if (this.additionalPropertySets != null && this.numSmallBlockDepotBlocks != 0) {
            this.sbdStartBlock = this.excelDataBlocks + i5 + this.additionalPropertyBlocks + 16;
        }
        this.sbdStartBlockChain = -2;
        int i6 = this.sbdStartBlock;
        if (i6 != -2) {
            this.sbdStartBlockChain = i6 + this.numSmallBlockDepotBlocks;
        }
        int i7 = this.sbdStartBlockChain;
        if (i7 != -2) {
            this.bbdStartBlock = i7 + this.numSmallBlockDepotChainBlocks;
        } else {
            this.bbdStartBlock = i5 + this.excelDataBlocks + this.additionalPropertyBlocks + 16;
        }
        int i8 = this.bbdStartBlock + this.numBigBlockDepotBlocks;
        this.rootStartBlock = i8;
        if (i4 != i8 + this.numRootEntryBlocks) {
            logger.warn("Root start block and total blocks are inconsistent  generated file may be corrupt");
            logger.warn(new StringBuffer().append("RootStartBlock ").append(this.rootStartBlock).append(" totalBlocks ").append(i4).toString());
        }
    }

    private void readAdditionalPropertySets(jxl.read.biff.CompoundFile compoundFile) throws CopyAdditionalPropertySetsException, IOException {
        boolean z;
        if (compoundFile == null) {
            return;
        }
        this.additionalPropertySets = new ArrayList();
        this.standardPropertySets = new HashMap();
        int numberOfPropertySets = compoundFile.getNumberOfPropertySets();
        int i = 0;
        for (int i2 = 0; i2 < numberOfPropertySets; i2++) {
            BaseCompoundFile.PropertyStorage propertySet = compoundFile.getPropertySet(i2);
            if (propertySet.name.equalsIgnoreCase(BaseCompoundFile.ROOT_ENTRY_NAME)) {
                this.standardPropertySets.put(BaseCompoundFile.ROOT_ENTRY_NAME, new ReadPropertyStorage(propertySet, null, i2));
                z = true;
            } else {
                z = false;
            }
            for (int i3 = 0; i3 < STANDARD_PROPERTY_SETS.length && !z; i3++) {
                if (propertySet.name.equalsIgnoreCase(STANDARD_PROPERTY_SETS[i3])) {
                    BaseCompoundFile.PropertyStorage findPropertyStorage = compoundFile.findPropertyStorage(propertySet.name);
                    Assert.verify(findPropertyStorage != null);
                    if (findPropertyStorage == propertySet) {
                        this.standardPropertySets.put(STANDARD_PROPERTY_SETS[i3], new ReadPropertyStorage(propertySet, null, i2));
                        z = true;
                    }
                }
            }
            if (!z) {
                try {
                    byte[] stream = propertySet.size > 0 ? compoundFile.getStream(i2) : new byte[0];
                    this.additionalPropertySets.add(new ReadPropertyStorage(propertySet, stream, i2));
                    if (stream.length > 4096) {
                        i += getBigBlocksRequired(stream.length);
                    } else {
                        this.numSmallBlocks += getSmallBlocksRequired(stream.length);
                    }
                } catch (BiffException e) {
                    logger.error(e);
                    throw new CopyAdditionalPropertySetsException();
                }
            }
        }
        this.additionalPropertyBlocks = i;
    }

    public void write() throws IOException {
        writeHeader();
        writeExcelData();
        writeDocumentSummaryData();
        writeSummaryData();
        writeAdditionalPropertySets();
        writeSmallBlockDepot();
        writeSmallBlockDepotChain();
        writeBigBlockDepot();
        writePropertySets();
    }

    private void writeAdditionalPropertySets() throws IOException {
        ArrayList arrayList = this.additionalPropertySets;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = ((ReadPropertyStorage) it.next()).data;
            if (bArr.length > 4096) {
                int bigBlocksRequired = getBigBlocksRequired(bArr.length) * 512;
                this.out.write(bArr, 0, bArr.length);
                int length = bigBlocksRequired - bArr.length;
                this.out.write(new byte[length], 0, length);
            }
        }
    }

    private void writeExcelData() throws IOException {
        this.out.write(this.excelData, 0, this.size);
        this.out.write(new byte[this.requiredSize - this.size]);
    }

    private void writeDocumentSummaryData() throws IOException {
        this.out.write(new byte[4096]);
    }

    private void writeSummaryData() throws IOException {
        this.out.write(new byte[4096]);
    }

    private void writeHeader() throws IOException {
        int i;
        byte[] bArr = new byte[512];
        int i2 = this.numExtensionBlocks * 512;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(IDENTIFIER, 0, bArr, 0, IDENTIFIER.length);
        bArr[24] = 62;
        bArr[26] = 3;
        bArr[28] = -2;
        bArr[29] = -1;
        bArr[30] = 9;
        bArr[32] = 6;
        bArr[57] = 16;
        IntegerHelper.getFourBytes(this.numBigBlockDepotBlocks, bArr, 44);
        IntegerHelper.getFourBytes(this.sbdStartBlockChain, bArr, 60);
        IntegerHelper.getFourBytes(this.numSmallBlockDepotChainBlocks, bArr, 64);
        IntegerHelper.getFourBytes(this.extensionBlock, bArr, 68);
        IntegerHelper.getFourBytes(this.numExtensionBlocks, bArr, 72);
        IntegerHelper.getFourBytes(this.rootStartBlock, bArr, 48);
        int min = Math.min(this.numBigBlockDepotBlocks, 109);
        int i3 = 76;
        int i4 = 0;
        for (int i5 = 0; i5 < min; i5++) {
            IntegerHelper.getFourBytes(this.bbdStartBlock + i5, bArr, i3);
            i3 += 4;
            i4++;
        }
        while (i3 < 512) {
            bArr[i3] = -1;
            i3++;
        }
        this.out.write(bArr);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i = this.numExtensionBlocks;
            if (i6 >= i) {
                break;
            }
            int min2 = Math.min(this.numBigBlockDepotBlocks - i4, 127);
            for (int i8 = 0; i8 < min2; i8++) {
                IntegerHelper.getFourBytes(this.bbdStartBlock + i4 + i8, bArr2, i7);
                i7 += 4;
            }
            i4 += min2;
            IntegerHelper.getFourBytes(i4 == this.numBigBlockDepotBlocks ? -2 : i6 + 1, bArr2, i7);
            i7 += 4;
            i6++;
        }
        if (i > 0) {
            while (i7 < i2) {
                bArr2[i7] = -1;
                i7++;
            }
            this.out.write(bArr2);
        }
    }

    private void checkBbdPos() throws IOException {
        if (this.bbdPos >= 512) {
            this.out.write(this.bigBlockDepot);
            this.bigBlockDepot = new byte[512];
            this.bbdPos = 0;
        }
    }

    private void writeBlockChain(int i, int i2) throws IOException {
        int i3 = i2 - 1;
        int i4 = i + 1;
        while (i3 > 0) {
            int min = Math.min(i3, (512 - this.bbdPos) / 4);
            for (int i5 = 0; i5 < min; i5++) {
                IntegerHelper.getFourBytes(i4, this.bigBlockDepot, this.bbdPos);
                this.bbdPos += 4;
                i4++;
            }
            i3 -= min;
            checkBbdPos();
        }
        IntegerHelper.getFourBytes(-2, this.bigBlockDepot, this.bbdPos);
        this.bbdPos += 4;
        checkBbdPos();
    }

    private void writeAdditionalPropertySetBlockChains() throws IOException {
        ArrayList arrayList = this.additionalPropertySets;
        if (arrayList == null) {
            return;
        }
        int i = this.excelDataStartBlock + this.excelDataBlocks + 16;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ReadPropertyStorage readPropertyStorage = (ReadPropertyStorage) it.next();
            if (readPropertyStorage.data.length > 4096) {
                int bigBlocksRequired = getBigBlocksRequired(readPropertyStorage.data.length);
                writeBlockChain(i, bigBlocksRequired);
                i += bigBlocksRequired;
            }
        }
    }

    private void writeSmallBlockDepotChain() throws IOException {
        if (this.sbdStartBlockChain == -2) {
            return;
        }
        byte[] bArr = new byte[this.numSmallBlockDepotChainBlocks * 512];
        Iterator it = this.additionalPropertySets.iterator();
        int i = 0;
        int i2 = 1;
        while (it.hasNext()) {
            ReadPropertyStorage readPropertyStorage = (ReadPropertyStorage) it.next();
            if (readPropertyStorage.data.length <= 4096 && readPropertyStorage.data.length != 0) {
                int smallBlocksRequired = getSmallBlocksRequired(readPropertyStorage.data.length);
                for (int i3 = 0; i3 < smallBlocksRequired - 1; i3++) {
                    IntegerHelper.getFourBytes(i2, bArr, i);
                    i += 4;
                    i2++;
                }
                IntegerHelper.getFourBytes(-2, bArr, i);
                i += 4;
                i2++;
            }
        }
        this.out.write(bArr);
    }

    private void writeSmallBlockDepot() throws IOException {
        ArrayList arrayList = this.additionalPropertySets;
        if (arrayList == null) {
            return;
        }
        byte[] bArr = new byte[this.numSmallBlockDepotBlocks * 512];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            ReadPropertyStorage readPropertyStorage = (ReadPropertyStorage) it.next();
            if (readPropertyStorage.data.length <= 4096) {
                int smallBlocksRequired = getSmallBlocksRequired(readPropertyStorage.data.length) * 64;
                System.arraycopy(readPropertyStorage.data, 0, bArr, i, readPropertyStorage.data.length);
                i += smallBlocksRequired;
            }
        }
        this.out.write(bArr);
    }

    private void writeBigBlockDepot() throws IOException {
        this.bigBlockDepot = new byte[512];
        this.bbdPos = 0;
        for (int i = 0; i < this.numExtensionBlocks; i++) {
            IntegerHelper.getFourBytes(-3, this.bigBlockDepot, this.bbdPos);
            this.bbdPos += 4;
            checkBbdPos();
        }
        writeBlockChain(this.excelDataStartBlock, this.excelDataBlocks);
        int i2 = this.excelDataStartBlock + this.excelDataBlocks + this.additionalPropertyBlocks;
        int i3 = i2;
        while (i3 < i2 + 7) {
            i3++;
            IntegerHelper.getFourBytes(i3, this.bigBlockDepot, this.bbdPos);
            this.bbdPos += 4;
            checkBbdPos();
        }
        IntegerHelper.getFourBytes(-2, this.bigBlockDepot, this.bbdPos);
        this.bbdPos += 4;
        checkBbdPos();
        int i4 = i2 + 8;
        while (i4 < i2 + 15) {
            i4++;
            IntegerHelper.getFourBytes(i4, this.bigBlockDepot, this.bbdPos);
            this.bbdPos += 4;
            checkBbdPos();
        }
        IntegerHelper.getFourBytes(-2, this.bigBlockDepot, this.bbdPos);
        this.bbdPos += 4;
        checkBbdPos();
        writeAdditionalPropertySetBlockChains();
        int i5 = this.sbdStartBlock;
        if (i5 != -2) {
            writeBlockChain(i5, this.numSmallBlockDepotBlocks);
            writeBlockChain(this.sbdStartBlockChain, this.numSmallBlockDepotChainBlocks);
        }
        for (int i6 = 0; i6 < this.numBigBlockDepotBlocks; i6++) {
            IntegerHelper.getFourBytes(-3, this.bigBlockDepot, this.bbdPos);
            this.bbdPos += 4;
            checkBbdPos();
        }
        writeBlockChain(this.rootStartBlock, this.numRootEntryBlocks);
        int i7 = this.bbdPos;
        if (i7 != 0) {
            while (i7 < 512) {
                this.bigBlockDepot[i7] = -1;
                i7++;
            }
            this.out.write(this.bigBlockDepot);
        }
    }

    private int getBigBlocksRequired(int i) {
        int i2 = i / 512;
        return i % 512 > 0 ? i2 + 1 : i2;
    }

    private int getSmallBlocksRequired(int i) {
        int i2 = i / 64;
        return i % 64 > 0 ? i2 + 1 : i2;
    }

    private void writePropertySets() throws IOException {
        int[] iArr;
        int i;
        int i2;
        int i3;
        ReadPropertyStorage readPropertyStorage;
        int smallBlocksRequired;
        int i4 = 512;
        byte[] bArr = new byte[this.numRootEntryBlocks * 512];
        int i5 = 1;
        if (this.additionalPropertySets != null) {
            iArr = new int[this.numPropertySets];
            for (int i6 = 0; i6 < STANDARD_PROPERTY_SETS.length; i6++) {
                ReadPropertyStorage readPropertyStorage2 = (ReadPropertyStorage) this.standardPropertySets.get(STANDARD_PROPERTY_SETS[i6]);
                if (readPropertyStorage2 != null) {
                    iArr[readPropertyStorage2.number] = i6;
                } else {
                    logger.warn(new StringBuffer().append("Standard property set ").append(STANDARD_PROPERTY_SETS[i6]).append(" not present in source file").toString());
                }
            }
            int length = STANDARD_PROPERTY_SETS.length;
            Iterator it = this.additionalPropertySets.iterator();
            while (it.hasNext()) {
                iArr[((ReadPropertyStorage) it.next()).number] = length;
                length++;
            }
        } else {
            iArr = null;
        }
        if (this.additionalPropertySets != null) {
            i = (getBigBlocksRequired(this.requiredSize) * 512) + 0 + (getBigBlocksRequired(4096) * 512) + (getBigBlocksRequired(4096) * 512);
            Iterator it2 = this.additionalPropertySets.iterator();
            while (it2.hasNext()) {
                ReadPropertyStorage readPropertyStorage3 = (ReadPropertyStorage) it2.next();
                if (readPropertyStorage3.propertyStorage.type != 1) {
                    if (readPropertyStorage3.propertyStorage.size >= 4096) {
                        smallBlocksRequired = getBigBlocksRequired(readPropertyStorage3.propertyStorage.size) * 512;
                    } else {
                        smallBlocksRequired = getSmallBlocksRequired(readPropertyStorage3.propertyStorage.size) * 64;
                    }
                    i += smallBlocksRequired;
                }
            }
        } else {
            i = 0;
        }
        BaseCompoundFile.PropertyStorage propertyStorage = new BaseCompoundFile.PropertyStorage(BaseCompoundFile.ROOT_ENTRY_NAME);
        propertyStorage.setType(5);
        propertyStorage.setStartBlock(this.sbdStartBlock);
        propertyStorage.setSize(i);
        propertyStorage.setPrevious(-1);
        propertyStorage.setNext(-1);
        propertyStorage.setColour(0);
        propertyStorage.setChild(this.additionalPropertySets != null ? iArr[((ReadPropertyStorage) this.standardPropertySets.get(BaseCompoundFile.ROOT_ENTRY_NAME)).propertyStorage.child] : 1);
        System.arraycopy(propertyStorage.data, 0, bArr, 0, 128);
        BaseCompoundFile.PropertyStorage propertyStorage2 = new BaseCompoundFile.PropertyStorage(BaseCompoundFile.WORKBOOK_NAME);
        propertyStorage2.setType(2);
        propertyStorage2.setStartBlock(this.excelDataStartBlock);
        propertyStorage2.setSize(this.requiredSize);
        int i7 = 3;
        if (this.additionalPropertySets != null) {
            ReadPropertyStorage readPropertyStorage4 = (ReadPropertyStorage) this.standardPropertySets.get(BaseCompoundFile.WORKBOOK_NAME);
            i3 = readPropertyStorage4.propertyStorage.previous != -1 ? iArr[readPropertyStorage4.propertyStorage.previous] : -1;
            i2 = readPropertyStorage4.propertyStorage.next != -1 ? iArr[readPropertyStorage4.propertyStorage.next] : -1;
        } else {
            i2 = -1;
            i3 = 3;
        }
        propertyStorage2.setPrevious(i3);
        propertyStorage2.setNext(i2);
        propertyStorage2.setChild(-1);
        System.arraycopy(propertyStorage2.data, 0, bArr, 128, 128);
        BaseCompoundFile.PropertyStorage propertyStorage3 = new BaseCompoundFile.PropertyStorage("\u0005SummaryInformation");
        propertyStorage3.setType(2);
        propertyStorage3.setStartBlock(this.excelDataStartBlock + this.excelDataBlocks);
        propertyStorage3.setSize(4096);
        if (this.additionalPropertySets != null && (readPropertyStorage = (ReadPropertyStorage) this.standardPropertySets.get("\u0005SummaryInformation")) != null) {
            i5 = readPropertyStorage.propertyStorage.previous != -1 ? iArr[readPropertyStorage.propertyStorage.previous] : -1;
            i7 = readPropertyStorage.propertyStorage.next != -1 ? iArr[readPropertyStorage.propertyStorage.next] : -1;
        }
        propertyStorage3.setPrevious(i5);
        propertyStorage3.setNext(i7);
        propertyStorage3.setChild(-1);
        System.arraycopy(propertyStorage3.data, 0, bArr, 256, 128);
        BaseCompoundFile.PropertyStorage propertyStorage4 = new BaseCompoundFile.PropertyStorage("\u0005DocumentSummaryInformation");
        propertyStorage4.setType(2);
        propertyStorage4.setStartBlock(this.excelDataStartBlock + this.excelDataBlocks + 8);
        propertyStorage4.setSize(4096);
        propertyStorage4.setPrevious(-1);
        propertyStorage4.setNext(-1);
        propertyStorage4.setChild(-1);
        System.arraycopy(propertyStorage4.data, 0, bArr, 384, 128);
        ArrayList arrayList = this.additionalPropertySets;
        if (arrayList == null) {
            this.out.write(bArr);
            return;
        }
        int i8 = this.excelDataStartBlock + this.excelDataBlocks + 16;
        Iterator it3 = arrayList.iterator();
        int i9 = 0;
        while (it3.hasNext()) {
            ReadPropertyStorage readPropertyStorage5 = (ReadPropertyStorage) it3.next();
            int i10 = readPropertyStorage5.data.length > 4096 ? i8 : i9;
            BaseCompoundFile.PropertyStorage propertyStorage5 = new BaseCompoundFile.PropertyStorage(readPropertyStorage5.propertyStorage.name);
            propertyStorage5.setType(readPropertyStorage5.propertyStorage.type);
            propertyStorage5.setStartBlock(i10);
            propertyStorage5.setSize(readPropertyStorage5.propertyStorage.size);
            int i11 = readPropertyStorage5.propertyStorage.previous != -1 ? iArr[readPropertyStorage5.propertyStorage.previous] : -1;
            int i12 = readPropertyStorage5.propertyStorage.next != -1 ? iArr[readPropertyStorage5.propertyStorage.next] : -1;
            int i13 = readPropertyStorage5.propertyStorage.child != -1 ? iArr[readPropertyStorage5.propertyStorage.child] : -1;
            propertyStorage5.setPrevious(i11);
            propertyStorage5.setNext(i12);
            propertyStorage5.setChild(i13);
            System.arraycopy(propertyStorage5.data, 0, bArr, i4, 128);
            i4 += 128;
            if (readPropertyStorage5.data.length > 4096) {
                i8 += getBigBlocksRequired(readPropertyStorage5.data.length);
            } else {
                i9 += getSmallBlocksRequired(readPropertyStorage5.data.length);
            }
        }
        this.out.write(bArr);
    }
}
