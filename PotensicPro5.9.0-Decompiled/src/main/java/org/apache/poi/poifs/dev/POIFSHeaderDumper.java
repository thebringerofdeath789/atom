package org.apache.poi.poifs.dev;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IntList;

/* loaded from: classes5.dex */
public class POIFSHeaderDumper {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        for (String str : strArr) {
            viewFile(str);
        }
    }

    public static void viewFile(String str) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(str);
        HeaderBlock headerBlock = new HeaderBlock(fileInputStream);
        displayHeader(headerBlock);
        POIFSBigBlockSize bigBlockSize = headerBlock.getBigBlockSize();
        RawDataBlockList rawDataBlockList = new RawDataBlockList(fileInputStream, bigBlockSize);
        displayRawBlocksSummary(rawDataBlockList);
        displayBATReader(new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), rawDataBlockList));
        SmallBlockTableReader.getSmallDocumentBlocks(bigBlockSize, rawDataBlockList, new PropertyTable(headerBlock, rawDataBlockList).getRoot(), headerBlock.getSBATStart());
    }

    public static void displayHeader(HeaderBlock headerBlock) throws Exception {
        System.out.println("Header Details:");
        System.out.println(" Block size: " + headerBlock.getBigBlockSize().getBigBlockSize());
        System.out.println(" BAT (FAT) header blocks: " + headerBlock.getBATArray().length);
        System.out.println(" BAT (FAT) block count: " + headerBlock.getBATCount());
        System.out.println(" XBAT (FAT) block count: " + headerBlock.getXBATCount());
        System.out.println(" XBAT (FAT) block 1 at: " + headerBlock.getXBATIndex());
        System.out.println(" SBAT (MiniFAT) block count: " + headerBlock.getSBATCount());
        System.out.println(" SBAT (MiniFAT) block 1 at: " + headerBlock.getSBATStart());
        System.out.println(" Property table at: " + headerBlock.getPropertyStart());
        System.out.println("");
    }

    public static void displayRawBlocksSummary(RawDataBlockList rawDataBlockList) throws Exception {
        System.out.println("Raw Blocks Details:");
        System.out.println(" Number of blocks: " + rawDataBlockList.blockCount());
        Method declaredMethod = rawDataBlockList.getClass().getSuperclass().getDeclaredMethod("get", Integer.TYPE);
        declaredMethod.setAccessible(true);
        for (int i = 0; i < Math.min(16, rawDataBlockList.blockCount()); i++) {
            ListManagedBlock listManagedBlock = (ListManagedBlock) declaredMethod.invoke(rawDataBlockList, Integer.valueOf(i));
            int min = Math.min(48, listManagedBlock.getData().length);
            byte[] bArr = new byte[min];
            System.arraycopy(listManagedBlock.getData(), 0, bArr, 0, min);
            System.out.println(" Block #" + i + ":");
            System.out.println(HexDump.dump(bArr, 0L, 0));
        }
        System.out.println("");
    }

    public static void displayBATReader(BlockAllocationTableReader blockAllocationTableReader) throws Exception {
        System.out.println("Sectors, as referenced from the FAT:");
        Field declaredField = blockAllocationTableReader.getClass().getDeclaredField("_entries");
        declaredField.setAccessible(true);
        IntList intList = (IntList) declaredField.get(blockAllocationTableReader);
        for (int i = 0; i < intList.size(); i++) {
            int i2 = intList.get(i);
            String num = Integer.toString(i2);
            if (i2 == -2) {
                num = "End Of Chain";
            } else if (i2 == -4) {
                num = "DI Fat Block";
            } else if (i2 == -3) {
                num = "Normal Fat Block";
            } else if (i2 == -1) {
                num = "Block Not Used (Free)";
            }
            System.out.println("  Block  # " + i + " -> " + num);
        }
        System.out.println("");
    }
}
