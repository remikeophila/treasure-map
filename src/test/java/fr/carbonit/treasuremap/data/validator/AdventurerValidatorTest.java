package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AdventurerValidatorTest {
    @Test
    public void correctAdventurerLine() {
        List<String> adventurerLine = Arrays.asList("Jean-Bernard", "1", "2", "S", "AAD");
        AdventurerValidator adventurerValidator = new AdventurerValidator();
        adventurerValidator.validate(adventurerLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectCoordinate() {
        List<String> adventurerLine = Arrays.asList("Jean-Bernard", "A", "2", "S", "AAD");
        AdventurerValidator adventurerValidator = new AdventurerValidator();
        adventurerValidator.validate(adventurerLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectParametersNumber() {
        List<String> adventurerLine = Arrays.asList("Jean-Bernard", "1", "2", "3", "S", "AAD");
        AdventurerValidator adventurerValidator = new AdventurerValidator();
        adventurerValidator.validate(adventurerLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectOrientation() {
        List<String> adventurerLine = Arrays.asList("Jean-Bernard", "1", "2", "F", "AAD");
        AdventurerValidator adventurerValidator = new AdventurerValidator();
        adventurerValidator.validate(adventurerLine);
    }

    @Test(expected = MapFileException.class)
    public void incorrectCommand() {
        List<String> adventurerLine = Arrays.asList("Jean-Bernard", "1", "2", "S", "RAD");
        AdventurerValidator adventurerValidator = new AdventurerValidator();
        adventurerValidator.validate(adventurerLine);
    }
}
