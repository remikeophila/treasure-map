package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;
import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.component.character.Moveable;
import fr.carbonit.treasuremap.map.component.character.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataMapper {

    public static Map map(List<FileData> fileDataList) {
        /* All components without the adventurer */
        List<FileData> filteredData = fileDataList.stream()
                .filter(data -> data.getType() != Type.A && data.getType() != Type.C)
                .collect(Collectors.toList());

        List<Component> components = createComponents(filteredData);
        Moveable adventurer = createAdventurer(fileDataList);
        List<Command> commands = createCommands(fileDataList);

        return createMap(fileDataList, components, adventurer, commands);
    }

    private static FileData getAdventurerFileData(List<FileData> fileDataList) {
        Optional<FileData> optional = fileDataList.stream().filter(data -> data.getType() == Type.A).findFirst();
        if(!optional.isPresent()) {
            throw new MapFileException("Didn't find any adventurer configuration in the input file");
        }
        return optional.get();
    }

    private static List<Command> createCommands(List<FileData> fileDataList) {
        return ComponentCreators.createCommands(getAdventurerFileData(fileDataList));
    }

    private static Moveable createAdventurer(List<FileData> fileDataList) {
        return ComponentCreators.createAdventurer(getAdventurerFileData(fileDataList));
    }

    private static List<Component> createComponents(List<FileData> fileDataList) {
        List<Component> componentList = new ArrayList<>();
        for (FileData fileData : fileDataList) {
            switch (fileData.getType()) {
                case M:
                    componentList.add(
                            ComponentCreators.createMountain(fileData)
                    );
                    break;
                case T:
                    componentList.add(
                            ComponentCreators.createTreasure(fileData)
                    );
                default:
            }
        }
        return componentList;
    }

    private static Map createMap(List<FileData> fileDataList,
                                 List<Component> components,
                                 Moveable adventurer,
                                 List<Command> commands) {
        Optional<FileData> optional = fileDataList.stream().filter(data -> data.getType() == Type.C).findAny();
        if(!optional.isPresent()) {
            throw new MapFileException("Didn't find any map configuration in the input file");
        }
        return ComponentCreators.createMap(optional.get(), components, adventurer, commands);
    }




}
