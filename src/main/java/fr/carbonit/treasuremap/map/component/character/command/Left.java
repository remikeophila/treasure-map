package fr.carbonit.treasuremap.map.component.character.command;

import fr.carbonit.treasuremap.map.Coordinate;
import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.component.character.Moveable;

public class Left implements Command {

    public void execute(Map map) {
        map.getMoveable().left();
    }

    @Override
    public Coordinate getNextPosition(Moveable adventurer) {
        return adventurer.coordinate();
    }

    @Override
    public boolean canPickUp() {
        return false;
    }
}
