package fr.carbonit.treasuremap.map;

import fr.carbonit.treasuremap.map.component.character.command.Command;
import fr.carbonit.treasuremap.map.component.Component;

import java.util.Optional;

public class MapController {
    private final Map map;
    public MapController(Map map) {
        this.map = map;
    }

    public void execute() {

        for(Command command: map.getCommands()) {
            Coordinate nextPosition = command.getNextPosition(map.getMoveable());
            Optional<Component> nextComponent = getComponentAt(nextPosition);

            map.validateNextPosition(nextPosition);
            if(!nextComponent.isPresent()) {
                command.execute(map);
            } else if(nextComponent.get().isWalkable()) {
                command.execute(map);

                Component component = nextComponent.get();
                if(command.canPickUp()) {
                    map.getMoveable().pickupTreasure(component);
                }
                if(component.getPoints() == 0) {
                    map.removeComponent(component);
                }
            }
        }
    }


    private Optional<Component> getComponentAt(Coordinate coordinate) {
        for(Component component: map.getComponents()) {
            if(component.coordinate().getX() == coordinate.getX()
                && component.coordinate().getY() == coordinate.getY()) {
                return Optional.of(component);
            }
        }
        return Optional.empty();
    }


}
