package fr.carbonit.treasuremap.map;

import fr.carbonit.treasuremap.map.component.character.Moveable;
import fr.carbonit.treasuremap.map.component.character.command.Command;
import fr.carbonit.treasuremap.map.component.Component;

import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final Moveable moveable;
    private final List<Component> components;
    private final List<Command> commands;

    public Map(int width, int height,
               Moveable moveable,
               List<Component> components,
               List<Command> commands) {
        this.width = width;
        this.height = height;
        this.moveable = moveable;
        this.components = components;
        this.commands = commands;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void removeComponent(Component component) {
        if(components.contains(component)) {
            components.remove(components.indexOf(component));
        }
    }

    public void validateNextPosition(Coordinate nextCoordinate) {
        if(nextCoordinate.getX() < 0
            || nextCoordinate.getX() >= width
            || nextCoordinate.getY() < 0
            || nextCoordinate.getY() >= height) {
            throw new MapException("Your movements make the adventurer going out of the island "
                    +"and "+getMoveable().getName()+" doesn't know how to swim!");
        }
    }
}
