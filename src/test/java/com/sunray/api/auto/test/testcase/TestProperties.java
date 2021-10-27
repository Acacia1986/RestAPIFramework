package com.sunray.api.auto.test.testcase;
import com.sunray.api.auto.test.common.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.IOException;

@Slf4j
public class TestProperties {



    @Test
    public void testProperties()  {

        String value = null;
        try {
            value = FileUtil.getPropertiesFile("src/main/resources/configuration/ShijiAPIDefaultValue.properties","token");

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("----------------" + value);

      }

}
