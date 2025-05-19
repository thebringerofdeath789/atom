package jxl.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.Font;
import jxl.format.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class XML {
    private String encoding;
    private OutputStream out;
    private Workbook workbook;

    public XML(Workbook workbook, OutputStream outputStream, String str, boolean z) throws IOException {
        this.encoding = str;
        this.workbook = workbook;
        this.out = outputStream;
        if (str == null || !str.equals("UnicodeBig")) {
            this.encoding = InternalZipConstants.CHARSET_UTF8;
        }
        if (z) {
            writeFormattedXML();
        } else {
            writeXML();
        }
    }

    private void writeXML() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.out, this.encoding));
            bufferedWriter.write("<?xml version=\"1.0\" ?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<!DOCTYPE workbook SYSTEM \"workbook.dtd\">");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("<workbook>");
            bufferedWriter.newLine();
            for (int i = 0; i < this.workbook.getNumberOfSheets(); i++) {
                Sheet sheet = this.workbook.getSheet(i);
                bufferedWriter.write("  <sheet>");
                bufferedWriter.newLine();
                bufferedWriter.write(new StringBuffer().append("    <name><![CDATA[").append(sheet.getName()).append("]]></name>").toString());
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < sheet.getRows(); i2++) {
                    bufferedWriter.write(new StringBuffer().append("    <row number=\"").append(i2).append("\">").toString());
                    bufferedWriter.newLine();
                    Cell[] row = sheet.getRow(i2);
                    for (int i3 = 0; i3 < row.length; i3++) {
                        if (row[i3].getType() != CellType.EMPTY) {
                            bufferedWriter.write(new StringBuffer().append("      <col number=\"").append(i3).append("\">").toString());
                            bufferedWriter.write(new StringBuffer().append("<![CDATA[").append(row[i3].getContents()).append("]]>").toString());
                            bufferedWriter.write("</col>");
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.write("    </row>");
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("  </sheet>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</workbook>");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }

    private void writeFormattedXML() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.out, this.encoding));
            bufferedWriter.write("<?xml version=\"1.0\" ?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<!DOCTYPE workbook SYSTEM \"formatworkbook.dtd\">");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("<workbook>");
            bufferedWriter.newLine();
            for (int i = 0; i < this.workbook.getNumberOfSheets(); i++) {
                Sheet sheet = this.workbook.getSheet(i);
                bufferedWriter.write("  <sheet>");
                bufferedWriter.newLine();
                bufferedWriter.write(new StringBuffer().append("    <name><![CDATA[").append(sheet.getName()).append("]]></name>").toString());
                bufferedWriter.newLine();
                for (int i2 = 0; i2 < sheet.getRows(); i2++) {
                    bufferedWriter.write(new StringBuffer().append("    <row number=\"").append(i2).append("\">").toString());
                    bufferedWriter.newLine();
                    Cell[] row = sheet.getRow(i2);
                    for (int i3 = 0; i3 < row.length; i3++) {
                        if (row[i3].getType() != CellType.EMPTY || row[i3].getCellFormat() != null) {
                            CellFormat cellFormat = row[i3].getCellFormat();
                            bufferedWriter.write(new StringBuffer().append("      <col number=\"").append(i3).append("\">").toString());
                            bufferedWriter.newLine();
                            bufferedWriter.write("        <data>");
                            bufferedWriter.write(new StringBuffer().append("<![CDATA[").append(row[i3].getContents()).append("]]>").toString());
                            bufferedWriter.write("</data>");
                            bufferedWriter.newLine();
                            if (row[i3].getCellFormat() != null) {
                                bufferedWriter.write(new StringBuffer().append("        <format wrap=\"").append(cellFormat.getWrap()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                align=\"").append(cellFormat.getAlignment().getDescription()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                valign=\"").append(cellFormat.getVerticalAlignment().getDescription()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                orientation=\"").append(cellFormat.getOrientation().getDescription()).append("\"").toString());
                                bufferedWriter.write(">");
                                bufferedWriter.newLine();
                                Font font = cellFormat.getFont();
                                bufferedWriter.write(new StringBuffer().append("          <font name=\"").append(font.getName()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                point_size=\"").append(font.getPointSize()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                bold_weight=\"").append(font.getBoldWeight()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                italic=\"").append(font.isItalic()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                underline=\"").append(font.getUnderlineStyle().getDescription()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                colour=\"").append(font.getColour().getDescription()).append("\"").toString());
                                bufferedWriter.newLine();
                                bufferedWriter.write(new StringBuffer().append("                script=\"").append(font.getScriptStyle().getDescription()).append("\"").toString());
                                bufferedWriter.write(" />");
                                bufferedWriter.newLine();
                                if (cellFormat.getBackgroundColour() != Colour.DEFAULT_BACKGROUND || cellFormat.getPattern() != Pattern.NONE) {
                                    bufferedWriter.write(new StringBuffer().append("          <background colour=\"").append(cellFormat.getBackgroundColour().getDescription()).append("\"").toString());
                                    bufferedWriter.newLine();
                                    bufferedWriter.write(new StringBuffer().append("                      pattern=\"").append(cellFormat.getPattern().getDescription()).append("\"").toString());
                                    bufferedWriter.write(" />");
                                    bufferedWriter.newLine();
                                }
                                if (cellFormat.getBorder(Border.TOP) != BorderLineStyle.NONE || cellFormat.getBorder(Border.BOTTOM) != BorderLineStyle.NONE || cellFormat.getBorder(Border.LEFT) != BorderLineStyle.NONE || cellFormat.getBorder(Border.RIGHT) != BorderLineStyle.NONE) {
                                    bufferedWriter.write(new StringBuffer().append("          <border top=\"").append(cellFormat.getBorder(Border.TOP).getDescription()).append("\"").toString());
                                    bufferedWriter.newLine();
                                    bufferedWriter.write(new StringBuffer().append("                  bottom=\"").append(cellFormat.getBorder(Border.BOTTOM).getDescription()).append("\"").toString());
                                    bufferedWriter.newLine();
                                    bufferedWriter.write(new StringBuffer().append("                  left=\"").append(cellFormat.getBorder(Border.LEFT).getDescription()).append("\"").toString());
                                    bufferedWriter.newLine();
                                    bufferedWriter.write(new StringBuffer().append("                  right=\"").append(cellFormat.getBorder(Border.RIGHT).getDescription()).append("\"").toString());
                                    bufferedWriter.write(" />");
                                    bufferedWriter.newLine();
                                }
                                if (!cellFormat.getFormat().getFormatString().equals("")) {
                                    bufferedWriter.write("          <format_string string=\"");
                                    bufferedWriter.write(cellFormat.getFormat().getFormatString());
                                    bufferedWriter.write("\" />");
                                    bufferedWriter.newLine();
                                }
                                bufferedWriter.write("        </format>");
                                bufferedWriter.newLine();
                            }
                            bufferedWriter.write("      </col>");
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.write("    </row>");
                    bufferedWriter.newLine();
                }
                bufferedWriter.write("  </sheet>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</workbook>");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
    }
}
