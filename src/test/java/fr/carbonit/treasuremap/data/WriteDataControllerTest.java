package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.component.Treasure;
import fr.carbonit.treasuremap.map.component.character.Adventurer;
import fr.carbonit.treasuremap.map.component.character.AdventurerOrientation;
import fr.carbonit.treasuremap.map.component.character.command.Command;
import fr.carbonit.treasuremap.map.component.character.command.Forward;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class WriteDataControllerTest {
    @Rule
    public TemporaryFolder temporaryFolder= new TemporaryFolder();

    private WriteDataController writeDataController;

    private Map getDefaultMap() {
        Component treasure = new Treasure(1, 2, 2);
        Adventurer adventurer = new Adventurer(1,1, AdventurerOrientation.EAST, "Harry");
        List<Component> components = new ArrayList<>();
        components.add(treasure);
        List<Command> commands = Arrays.asList(new Forward());
        return new Map(5, 5, adventurer, components, commands);
    }

    @Test
    public void writeDataAndCheckIfFileExists() throws IOException {
        String outputPath = temporaryFolder.getRoot()+"/out.txt";
        WriteDataController writeDataController = new WriteDataController(
                getDefaultMap(),
                outputPath
                );
        writeDataController.execute();
        assertTrue(Files.exists(Paths.get(outputPath)));
    }


}
