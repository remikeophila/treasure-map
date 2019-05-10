package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MapValidatorTest {
    @Test
    public void correctAdventurerLine() {
        List<String> mapLine = Arrays.asList("5", "5");
        MapValidator mapValidator = new MapValidator();
        mapValidator.validate(mapLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectParametersNumber() {
        List<String> mapLine = Arrays.asList("5", "5", "5");
        MapValidator mapValidator = new MapValidator();
        mapValidator.validate(mapLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectSize() {
        List<String> mapLine = Arrays.asList("-5", "5");
        MapValidator mapValidator = new MapValidator();
        mapValidator.validate(mapLine);
    }

}
