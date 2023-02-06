package com.book.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * description: cmd命令工具
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/28 23:37:49
 */
public class CmdUtil {

    public static Map<Integer, String> getCmd(String userId,String num) {
        List<String> strings = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        String exe = "python";
        String script = "D:\\IDEA\\study\\keshe\\Book\\src\\main\\java\\com\\book\\python\\test.py";
        String[] arr = new String[]{exe, script, String.valueOf(userId), String.valueOf(num)};
        try {
            Process process = Runtime.getRuntime().exec(arr);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                strings.add(line);
                System.out.println(line);
            }
            in.close();
            process.waitFor();
            String s = strings.get(0);
            String[] split = s.split("\\|");
            for (int i = 0; i < split.length; i++) {
                String bookId = split[i].split(",")[1];
                String recommend= split[i].split(",")[2];
                map.put(Integer.valueOf(bookId),recommend);
            }
            return map;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> cmd = getCmd("18", "15");
        Set<Integer> bookId = cmd.keySet();
        for (Integer integer : bookId) {
            System.out.println(integer);
        }
    }

    public static void fileupload(String[] str) {
        try {
            Process process = Runtime.getRuntime().exec(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
