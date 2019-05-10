package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataMapperTest {

    @Test
    public void createSimpleMap() {
        List<FileData> fileData = Arrays.asList(
                new FileData("C - 5 - 5"),
                new FileData("M - 3 - 4"),
                new FileData("T - 1 - 1 - 1"),
                new FileData("A - Jean-Albert - 3 - 4 - N - ADD")
        );
        DataMapper.map(fileData);
    }

    @Test(expected = MapFileException.class)
    public void noAdventurer() {
        List<FileData> fileData = Arrays.asList(
                new FileData("C - 5 - 5"),
                new FileData("M - 3 - 4"),
                new FileData("T - 1 - 1 - 1")
        );
        DataMapper.map(fileData);
    }

    @Test(expected = MapFileException.class)
    public void noMap() {
        List<FileData> fileData = Arrays.asList(
                new FileData("M - 3 - 4"),
                new FileData("T - 1 - 1 - 1"),
                new FileData("A - Jean-Albert - 3 - 4 - N - ADD")
        );
        DataMapper.map(fileData);
    }
}
