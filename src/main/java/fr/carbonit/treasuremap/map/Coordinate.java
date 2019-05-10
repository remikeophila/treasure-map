package fr.carbonit.treasuremap.map;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void add(Coordinate coordinateToAdd) {
        this.x = this.x + coordinateToAdd.getX();
        this.y = this.y + coordinateToAdd.getY();
    }
}
