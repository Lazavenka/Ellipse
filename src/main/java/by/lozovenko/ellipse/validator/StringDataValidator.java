package by.lozovenko.ellipse.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StringDataValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String FLOATING_POINT_NUMBER_REGEX = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";

    public static final String DELIMITER_REGEX = "\\s+";

    public boolean validate(String stringData) {
        if (stringData == null) {
            LOGGER.debug("Input line is NULL!");
            return false;
        }
        String[] lexemes = stringData.split(DELIMITER_REGEX);

        for (String lexeme : lexemes) {
            if (!lexeme.matches(FLOATING_POINT_NUMBER_REGEX)) {
                LOGGER.debug("Incorrect floating point number format in lexeme: {}", lexeme);
                LOGGER.debug("Incorrect data line: {}", stringData);
                return false;
            }
        }
        LOGGER.debug("The data line {} is valid.", stringData);
        return true;
    }
}
