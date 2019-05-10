package fr.carbonit.treasuremap.map;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    @Test
    public void addPositive() {
        Coordinate coordinate = new Coordinate(5, 7);
        coordinate.add(new Coordinate(2, 3));
        assertEquals(7, coordinate.getX());
        assertEquals(10, coordinate.getY());
    }

    @Test
    public void negativeAdd() {
        Coordinate coordinate = new Coordinate(2, 3);
        coordinate.add(new Coordinate(-2, -1));
        assertEquals(0, coordinate.getX());
        assertEquals(2, coordinate.getY());
    }
}
