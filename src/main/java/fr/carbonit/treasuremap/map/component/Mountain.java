package fr.carbonit.treasuremap.map.component;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.Coordinate;

public class Mountain implements Component {
    private final Coordinate coordinate;

    public Mountain(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    @Override
    public Type getType() {
        return Type.M;
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public void setPoints(int points) {
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
