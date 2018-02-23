package com.game.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Test data Class.
 *
 * @author yogesh.kadam
 */
public class PropertiesTestData {

    public static final Properties getPropertiesFromMissingComputerPlayerConfigFile() {
        String filePath = "src/test/resources/missingComputerPlayerconfig.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromMissingkeysConfigFile() {
        String filePath = "src/test/resources/missingkeysconfig.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromMissingvaluesforsomekeysConfigFile() {
        String filePath = "src/test/resources/missingvaluesforsomekeysconfig.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromMultipleCharacterplayerSignConfigFile() {
        String filePath = "src/test/resources/multipleCharacterplayerSignconfig.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromNonNumericPlayfieldsizeConfigFile() {
        String filePath = "src/test/resources/nonNumericPlayfieldsizeconfig.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromPlayfieldsizeNotBetween3And10ConfigFile() {
        String filePath = "src/test/resources/playfieldsizeNotBetween3And10config.properties";

        return loadProperties(filePath);
    }

    public static final Properties getPropertiesFromValidConfigFile() {
        String filePath = "src/test/resources/validconfig.properties";

        return loadProperties(filePath);
    }

    /**
     * load the configuration from provided config properties file path.
     *
     * @return Properties
     */
    private static Properties loadProperties(String path) {

        InputStream input = null;
        Properties prop = new Properties();

        try {
            input = new FileInputStream(path);

            // load a properties file
            prop.load(input);

        } catch (IOException e) {
            System.out.println("Problem in loading config property file: ");
            System.out.println("Exception: " + e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Unexpected error occurred: " + e);
                }
            }
        }
        return prop;
    }
}
