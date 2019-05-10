package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.data.validator.AdventurerValidator;
import fr.carbonit.treasuremap.data.validator.MapValidator;
import fr.carbonit.treasuremap.data.validator.MountainValidator;
import fr.carbonit.treasuremap.data.validator.TreasureValidator;
import fr.carbonit.treasuremap.map.*;
import fr.carbonit.treasuremap.map.component.character.Adventurer;
import fr.carbonit.treasuremap.map.component.character.AdventurerOrientation;
import fr.carbonit.treasuremap.map.component.character.Moveable;
import fr.carbonit.treasuremap.map.component.character.command.Command;
import fr.carbonit.treasuremap.map.component.character.command.Forward;
import fr.carbonit.treasuremap.map.component.character.command.Left;
import fr.carbonit.treasuremap.map.component.character.command.Right;
import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.component.Mountain;
import fr.carbonit.treasuremap.map.component.Treasure;

import java.util.ArrayList;
import java.util.List;

public class ComponentCreators {
    public static Component createTreasure(FileData fileData) {
        int x = Integer.parseInt(fileData.getParameters().get(TreasureValidator.X));
        int y = Integer.parseInt(fileData.getParameters().get(TreasureValidator.Y));
        int value = Integer.parseInt(fileData.getParameters().get(TreasureValidator.VALUE));
        return new Treasure(x, y, value);
    }

    public static Component createMountain(FileData fileData) {
        int x = Integer.parseInt(fileData.getParameters().get(MountainValidator.X));
        int y = Integer.parseInt(fileData.getParameters().get(MountainValidator.Y));
        return new Mountain(x, y);
    }

    public static Moveable createAdventurer(FileData fileData) {
        int x = Integer.parseInt(fileData.getParameters().get(AdventurerValidator.X));
        int y = Integer.parseInt(fileData.getParameters().get(AdventurerValidator.Y));

        DataOrientation dataOrientation =
                DataOrientation.valueOf(fileData.getParameters().get(AdventurerValidator.ORIENTATION));
        AdventurerOrientation adventurerOrientation = dataOrientation.getAdventurerOrientation();

        String adventurerName = fileData.getParameters().get(AdventurerValidator.NAME);
        return new Adventurer(x, y, adventurerOrientation, adventurerName);
    }

    public static List<Command> createCommands(FileData fileData) {
        List<Command> commands = new ArrayList<>();
        String commandsString = fileData.getParameters().get(AdventurerValidator.COMMANDS);
        for (int i = 0; i < commandsString.length(); i++) {
            DataAction dataAction = DataAction.valueOf(commandsString.charAt(i) + "");
            switch (dataAction) {
                case A:
                    commands.add(
                            new Forward()
                    );
                    break;
                case D:
                    commands.add(
                            new Right()
                    );
                    break;
                case G:
                    commands.add(
                            new Left()
                    );
                    break;
            }
        }

        return commands;
    }

    public static Map createMap(FileData fileData,
                                List<Component> components,
                                Moveable adventurer,
                                List<Command> commands) {
        int width = Integer.parseInt(fileData.getParameters().get(MapValidator.WIDTH));
        int height = Integer.parseInt(fileData.getParameters().get(MapValidator.HEIGHT));

        return new Map(width, height, adventurer, components, commands);
    }
}
