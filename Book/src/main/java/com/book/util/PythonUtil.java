package com.book.util;

import org.python.util.PythonInterpreter;
import java.util.Properties;

/**
 * description: python代码工具
 *
 * @author bai
 * @version 1.0.0
 * @date 2022/06/28 08:56:38
 */
public class PythonUtil {

    public static PythonInterpreter getPython() {
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        return new PythonInterpreter();
    }

    public static void main(String[] args) {
        getPython().exec("python");
        getPython().exec("import findspark");
    }
}
