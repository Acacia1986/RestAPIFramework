package acacia.rest.api.implement.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetParaFromProperties {
    private  static Logger logger = LoggerFactory.getLogger(GetParaFromProperties.class);
    private static final String PATH =".\\src\\main\\resources\\Config.properties";

    /**
     * Read data from properties with parameter's name
     * @param dataName
     * @return
     */
    public static String getData(String dataName) {
        Properties pps = new Properties();
        try {
            pps.load(new FileInputStream(PATH));
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("Did not find the config.properties file at src/main/resources/config.properties.");

        }
        String result = pps.getProperty(dataName);
        return result;
    }

    @Test
    public void getPara(){
        String url = getData("BASE_URL");
        String url2 = getData("LOGIN_URL");
        System.out.println(url+url2);
    }


}
