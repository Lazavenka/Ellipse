package by.lozovenko.ellipse.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDataValidatorTest {
    StringDataValidator validator = new StringDataValidator();

    @Test
    public void testValidate() {
        String stringData = "0.255 0.222 535.777 33435";
        boolean actual = validator.validate(stringData);

        assertTrue(actual);
    }

    @Test
    public void testValidateIncorrectData() {
        String stringData = "0.255 0.222 53gd5.777 33435";
        boolean actual = validator.validate(stringData);

        assertFalse(actual);
    }
    @Test(description = "Another invalid data.")
    public void testValidateIncorrectDataAnother() {
        String stringData = "0.255 0.222  33,435";
        boolean actual = validator.validate(stringData);

        assertFalse(actual);
    }
}