package fr.carbonit.treasuremap.map.component.character.command;


import fr.carbonit.treasuremap.map.Coordinate;
import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.component.character.Moveable;

public interface Command {
    void execute(Map map);
    Coordinate getNextPosition(Moveable adventurer);
    boolean canPickUp();
}
