package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TreasureValidatorTest {
    private final TreasureValidator treasureValidator = new TreasureValidator();

    @Test
    public void correctTreasureLine() {
        List<String> treasureLine = Arrays.asList("1", "1", "1");
        treasureValidator.validate(treasureLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectPoint() {
        List<String> treasureLine = Arrays.asList("1", "1", "Z");
        treasureValidator.validate(treasureLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectParametersNumber() {
        List<String> treasureLine = Arrays.asList("1", "1");
        treasureValidator.validate(treasureLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectSize() {
        List<String> mapLine = Arrays.asList("-1", "1", "1");
        treasureValidator.validate(mapLine);
    }
}
