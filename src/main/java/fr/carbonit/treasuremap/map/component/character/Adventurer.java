package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.Coordinate;

public class Adventurer implements Moveable {
    private final Coordinate coordinate;
    private Orientation orientation;
    private String name;
    private int points;

    public Adventurer(int x, int y, AdventurerOrientation orientation, String name) {
        this.coordinate = new Coordinate(x, y);
        this.orientation = orientation;
        this.name = name;
        this.points = 0;
    }

    @Override
    public Type getType() {
        return Type.A;
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    public void forward() {
        coordinate.add(orientation.stepForward());
    }

    public void left() {
        orientation = orientation.left();
    }

    public void right() {
        orientation = orientation.right();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void pickupTreasure(Component component) {
        points += 1;
        component.setPoints(component.getPoints()-1);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }


}
