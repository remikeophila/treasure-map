package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MountainValidatorTest {
    private final MountainValidator mountainValidator = new MountainValidator();

    @Test
    public void correctMountainLine() {
        List<String> mountainLine = Arrays.asList("1", "1");
        mountainValidator.validate(mountainLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectParametersNumber() {
        List<String> mountainLine = Arrays.asList("1", "1", "1");
        mountainValidator.validate(mountainLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectSize() {
        List<String> mapLine = Arrays.asList("-1", "1");
        mountainValidator.validate(mapLine);
    }
}
