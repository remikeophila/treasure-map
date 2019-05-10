package fr.carbonit.treasuremap.map.component.character.command;

import fr.carbonit.treasuremap.map.Coordinate;
import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.component.character.Moveable;

public class Forward implements Command {

    public void execute(Map map) {
        map.getMoveable().forward();
    }

    @Override
    public Coordinate getNextPosition(Moveable adventurer) {
        Coordinate coordinate = new Coordinate(
                adventurer.coordinate().getX(),
                adventurer.coordinate().getY()
        );
        coordinate.add(adventurer.getOrientation().stepForward());
        return coordinate;
    }

    @Override
    public boolean canPickUp() {
        return true;
    }
}
