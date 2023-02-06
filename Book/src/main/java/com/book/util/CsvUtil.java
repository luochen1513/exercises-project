package com.book.util;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 * description: xls转csv工具
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/28 23:37:49
 */
public class CsvUtil {

    public static String getCsv(String path, String name) {
        String start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        Date start1 = new Date();
        System.out.println("start:" + start);
        String buffer = "";
        try {
            File file = new File(path);
            // 设置读文件编码
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding("UTF-8");
            // 从文件流中获取Excel工作区对象(WorkBook)
            Workbook wb = Workbook.getWorkbook(file, setEncode);
            Sheet sheet = wb.getSheet(0);
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < 6; j++) {
                    Cell cell = sheet.getCell(j, i);
                    buffer += cell.getContents().replaceAll("\n", " ") + ",";
                }
                buffer = buffer.substring(0, buffer.lastIndexOf(",")).toString();
                buffer = new String(buffer.getBytes("GB2312"), "GB2312");
                buffer += "\n";
            }
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
        String str = name.split("\\.")[0];
        String savePath = "D:\\IDEA\\study\\keshe\\Book\\src\\main\\resources\\data\\" + str + "1.csv";
        File saveCSV = new File(savePath);
        try {
            if (!saveCSV.exists()) {
                saveCSV.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveCSV));
            writer.write(buffer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String end = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("end:" + end);
        Date end1 = new Date();
        long time = end1.getTime() - start1.getTime();
        System.out.println("time:" + time + "ms");
        System.out.println(savePath);
        return savePath;
    }

    public static void main(String[] args) {
        getCsv("D:\\IDEA\\study\\keshe\\Book\\src\\main\\resources\\data\\GoodBooks.xls", "GoodBooks.xls");
    }

    public static void encodingCsv(String path, String name) throws IOException {
//        String SOURCE_ENCODING = "GBK";
        String TARGET_ENCODING = "UTF-8";
        FileInputStream fin = null;
        FileOutputStream fout = null;
        FileChannel fcin = null;
        FileChannel fcout = null;
        File source = new File(path);
        String str = name.split("\\.")[0];
        String savePath = "D:\\IDEA\\study\\keshe\\Book\\src\\main\\resources\\data\\" + str + ".csv";
        File target = new File(savePath);
        try {
            fin = new FileInputStream(source);
            fout = new FileOutputStream(target);
            fcin = fin.getChannel();
            fcout = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (true) {
                buffer.clear();
                int r = fcin.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                String encoding = "GB2312";
                fcout.write(ByteBuffer.wrap(Charset.forName(encoding).decode(buffer).toString().getBytes(TARGET_ENCODING)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (fcin != null) {
                fcin.close();
            }
            if (fout != null)
                fout.close();
            if (fcout != null)
                fcout.close();
        }
    }
}