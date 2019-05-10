package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public interface Validator {
    void validate(List<String> parameters) throws MapFileException;
}
