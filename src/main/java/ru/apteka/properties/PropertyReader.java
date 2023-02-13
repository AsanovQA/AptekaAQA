package ru.apteka.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private FileInputStream fis;
    Properties property = new Properties();
    public PropertyReader(String path) {
        try {
            fis = new FileInputStream(path);
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getPropertyByKey(String propertyName) {
        return property.getProperty(propertyName);
    }
}
