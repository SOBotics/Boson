package org.sobotics.boson.framework.services;

import org.sobotics.boson.framework.utils.StorageUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyService {

    private Properties prop;

    public PropertyService() {
        prop = new Properties();
        try
        {
            prop.load(new FileInputStream(StorageUtils.loginPropertiesFile));
        }
        catch (FileNotFoundException e)
        {
            prop = null;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String name){
        String property;
        if (prop == null)
            property = System.getenv(name);
        else
            property = prop.getProperty(name);
        return property;
    }
}
