package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileDataTest {
    @Test
    public void correctMapDataLineAndType() {
        String line = "C - 3 - 4";
        FileData fileData = new FileData(line);
        assertEquals(fileData.getType(), Type.C);
    }

    @Test
    public void correctMapDataLineAndParametersNumber() {
        String line = "C - 3 - 4";
        FileData fileData = new FileData(line);
        assertEquals(2, fileData.getParameters().size());
    }

    @Test
    public void correctMountainDataLineAndType() {
        String line = "M - 3 - 4";
        FileData fileData = new FileData(line);
        assertEquals(fileData.getType(), Type.M);
    }

    @Test
    public void correctMountainDataLineAndParametersNumber() {
        String line = "M - 3 - 4";
        FileData fileData = new FileData(line);
        assertEquals(2, fileData.getParameters().size());
    }

    @Test
    public void correctTreasureDataLineAndType() {
        String line = "T - 3 - 4 - 2";
        FileData fileData = new FileData(line);
        assertEquals(fileData.getType(), Type.T);
    }

    @Test
    public void correctTreasureDataLineAndParametersNumber() {
        String line = "T - 3 - 4 - 2";
        FileData fileData = new FileData(line);
        assertEquals(3, fileData.getParameters().size());
    }

    @Test
    public void correctAdventurerDataLineAndType() {
        String line = "A - Jean-Marc - 3 - 4 - N - ADD";
        FileData fileData = new FileData(line);
        assertEquals(fileData.getType(), Type.A);
    }


    @Test(expected = MapFileException.class)
    public void invalidDelimiter() {
        String line = "C | 3 | 4";
        new FileData(line);
    }

    @Test(expected = MapFileException.class)
    public void invalidType() {
        String line = "F - 3 - 4";
        new FileData(line);
    }
}
