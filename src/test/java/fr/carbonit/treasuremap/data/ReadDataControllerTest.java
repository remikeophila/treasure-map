package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;
import org.junit.Test;

import java.io.IOException;

public class ReadDataControllerTest {
    private final String correctFile1 = this.getClass().getClassLoader().getResource("correct1.txt").getPath();
    private final String incorrectFile1 = this.getClass().getClassLoader().getResource("incorrect1.txt").getPath();

    @Test
    public void correctFile() throws IOException {
        ReadDataController.execute(correctFile1);
    }

    @Test(expected = MapFileException.class)
    public void incorrectFile() throws IOException {
        ReadDataController.execute(incorrectFile1);
    }
}
