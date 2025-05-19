package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.Record;

/* loaded from: classes4.dex */
public final class WorkbookRecordList implements Iterable<Record> {
    private List<Record> records = new ArrayList();
    private int protpos = 0;
    private int bspos = 0;
    private int tabpos = 0;
    private int fontpos = 0;
    private int xfpos = 0;
    private int backuppos = 0;
    private int namepos = 0;
    private int supbookpos = 0;
    private int externsheetPos = 0;
    private int palettepos = -1;

    public void setRecords(List<Record> list) {
        this.records = list;
    }

    public int size() {
        return this.records.size();
    }

    public Record get(int i) {
        return this.records.get(i);
    }

    public void add(int i, Record record) {
        this.records.add(i, record);
        if (getProtpos() >= i) {
            setProtpos(this.protpos + 1);
        }
        if (getBspos() >= i) {
            setBspos(this.bspos + 1);
        }
        if (getTabpos() >= i) {
            setTabpos(this.tabpos + 1);
        }
        if (getFontpos() >= i) {
            setFontpos(this.fontpos + 1);
        }
        if (getXfpos() >= i) {
            setXfpos(this.xfpos + 1);
        }
        if (getBackuppos() >= i) {
            setBackuppos(this.backuppos + 1);
        }
        if (getNamepos() >= i) {
            setNamepos(this.namepos + 1);
        }
        if (getSupbookpos() >= i) {
            setSupbookpos(this.supbookpos + 1);
        }
        if (getPalettepos() != -1 && getPalettepos() >= i) {
            setPalettepos(this.palettepos + 1);
        }
        if (getExternsheetPos() >= i) {
            setExternsheetPos(getExternsheetPos() + 1);
        }
    }

    public List<Record> getRecords() {
        return this.records;
    }

    @Override // java.lang.Iterable
    public Iterator<Record> iterator() {
        return this.records.iterator();
    }

    public void remove(Object obj) {
        Iterator<Record> it = this.records.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == obj) {
                remove(i);
                return;
            }
            i++;
        }
    }

    public void remove(int i) {
        this.records.remove(i);
        if (getProtpos() >= i) {
            setProtpos(this.protpos - 1);
        }
        if (getBspos() >= i) {
            setBspos(this.bspos - 1);
        }
        if (getTabpos() >= i) {
            setTabpos(this.tabpos - 1);
        }
        if (getFontpos() >= i) {
            setFontpos(this.fontpos - 1);
        }
        if (getXfpos() >= i) {
            setXfpos(this.xfpos - 1);
        }
        if (getBackuppos() >= i) {
            setBackuppos(this.backuppos - 1);
        }
        if (getNamepos() >= i) {
            setNamepos(getNamepos() - 1);
        }
        if (getSupbookpos() >= i) {
            setSupbookpos(getSupbookpos() - 1);
        }
        if (getPalettepos() != -1 && getPalettepos() >= i) {
            setPalettepos(this.palettepos - 1);
        }
        if (getExternsheetPos() >= i) {
            setExternsheetPos(getExternsheetPos() - 1);
        }
    }

    public int getProtpos() {
        return this.protpos;
    }

    public void setProtpos(int i) {
        this.protpos = i;
    }

    public int getBspos() {
        return this.bspos;
    }

    public void setBspos(int i) {
        this.bspos = i;
    }

    public int getTabpos() {
        return this.tabpos;
    }

    public void setTabpos(int i) {
        this.tabpos = i;
    }

    public int getFontpos() {
        return this.fontpos;
    }

    public void setFontpos(int i) {
        this.fontpos = i;
    }

    public int getXfpos() {
        return this.xfpos;
    }

    public void setXfpos(int i) {
        this.xfpos = i;
    }

    public int getBackuppos() {
        return this.backuppos;
    }

    public void setBackuppos(int i) {
        this.backuppos = i;
    }

    public int getPalettepos() {
        return this.palettepos;
    }

    public void setPalettepos(int i) {
        this.palettepos = i;
    }

    public int getNamepos() {
        return this.namepos;
    }

    public int getSupbookpos() {
        return this.supbookpos;
    }

    public void setNamepos(int i) {
        this.namepos = i;
    }

    public void setSupbookpos(int i) {
        this.supbookpos = i;
    }

    public int getExternsheetPos() {
        return this.externsheetPos;
    }

    public void setExternsheetPos(int i) {
        this.externsheetPos = i;
    }
}
