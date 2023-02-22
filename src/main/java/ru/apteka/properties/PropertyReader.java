package ru.apteka.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties property = new Properties();
    public PropertyReader(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getPropertyByKey(String propertyName) {
        return property.getProperty(propertyName);
    }
}
