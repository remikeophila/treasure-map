package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public interface Validator {
    /**
     * Validate an input line from the input file
     * @param parameters Line parsed parameters from input file
     * @throws MapFileException
     */
    void validate(List<String> parameters) throws MapFileException;
}
