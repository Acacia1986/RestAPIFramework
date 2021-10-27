package com.sunray.api.auto.test.common.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Slf4j
public class FileUtil {

    private static ResourceBundle resourceBundle;

    public static String getPropertiesFile(String propertiesFilePath,String proName) throws IOException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(propertiesFilePath));
        properties.load(bufferedReader);
        String re = properties.getProperty(proName);
        log.info("Parameter " + proName + " is" + re);
        return re;
    }






}
