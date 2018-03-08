package com.game.validation;

import com.game.data.PropertiesTestData;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link ConfigValidation} class.
 */
public class ConfigValidationTest {

    @Test
    public void validate_missingSomeKeysInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromMissingComputerPlayerConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_missingkeysconfigInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromMissingkeysConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_missingvaluesforsomekeysconfigInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromMissingvaluesforsomekeysConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_multipleCharacterplayerSignconfigInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromMultipleCharacterplayerSignConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_nonNumericPlayfieldsizeconfigInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromNonNumericPlayfieldsizeConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_playfieldsizeNotBetween3And10configInConfigFile_validationFails() {
        Properties prop = PropertiesTestData.getPropertiesFromPlayfieldsizeNotBetween3And10ConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertFalse(isValid);
    }

    @Test
    public void validate_validConfigFile_validationSucceed() {
        Properties prop = PropertiesTestData.getPropertiesFromValidConfigFile();
        boolean isValid = ConfigValidation.validate(prop);

        assertTrue(isValid);
    }
}
