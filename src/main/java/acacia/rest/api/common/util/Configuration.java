package acacia.rest.api.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class provide whole project to get the configuration properties
 * Created by miaomiao on 6/14/2017.
 */
public class Configuration {

    //Create by itself
    protected static Configuration instance = new Configuration();
    private static Logger logger = LoggerFactory.getLogger(Configuration.class);
    private static Properties properties = new Properties();
    private static final  String CONFIG_FILE_NAME = "config.properties";
    static {
        loadFromConfigFile();
    }

    protected static void loadFromConfigFile(){
        String fileName = System.getProperty("config.file",CONFIG_FILE_NAME);
        File  file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }





}

