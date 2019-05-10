package fr.carbonit.treasuremap.map.component;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.Coordinate;

public class Treasure implements Component {
    private final Coordinate coordinate;
    private int point;

    public Treasure(int x, int y, int point) {
        this.coordinate = new Coordinate(x, y);
        this.point = point;
    }

    @Override
    public Type getType() {
        return Type.T;
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public int getPoints() {
        return point;
    }

    @Override
    public void setPoints(int points) {
        this.point = points;
    }
}
