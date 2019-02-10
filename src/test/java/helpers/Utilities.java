package helpers;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class Utilities {

    public static String getPropertyValue(Properties properties, String propertyName) {
        if (StringUtils.isBlank(propertyName)) {
            throw new IllegalArgumentException("System property name cannot be null or blank");
        }

        final String propertyValue = properties.getProperty(propertyName);
        if (StringUtils.isNotBlank(propertyValue)) {
            return propertyValue;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Environment variable '%s' does not exist or is blank", propertyValue));
        }
    }

    public static Properties getPropertyFileContent(String propertiesFileName) {
        return new ReadPropFile().getPropertiesValue(propertiesFileName);
    }

}