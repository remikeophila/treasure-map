package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.component.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AdventurerTest {
    private Adventurer adventurer;

    @Before
    public void init() {
        this.adventurer = new Adventurer(1, 1,
                AdventurerOrientation.EAST,
                "Jean-Claude");
    }

    @Test
    public void left() {
        adventurer.left();
        assertEquals(AdventurerOrientation.NORTH, adventurer.getOrientation());
    }

    @Test
    public void right() {
        adventurer.right();
        assertEquals(AdventurerOrientation.SOUTH, adventurer.getOrientation());
    }

    @Test
    public void multipleRotationLeft() {
        adventurer.left();
        adventurer.left();
        adventurer.left();
        assertEquals(AdventurerOrientation.SOUTH, adventurer.getOrientation());
    }

    @Test
    public void entireRotationLeft() {
        adventurer.left();
        adventurer.left();
        adventurer.left();
        adventurer.left();
        assertEquals(AdventurerOrientation.EAST, adventurer.getOrientation());
    }

    @Test
    public void entireRotationRight() {
        adventurer.right();
        adventurer.right();
        adventurer.right();
        adventurer.right();
        assertEquals(AdventurerOrientation.EAST, adventurer.getOrientation());
    }

    @Test
    public void multipleRotationRight() {
        adventurer.right();
        adventurer.right();
        adventurer.right();
        assertEquals(AdventurerOrientation.NORTH, adventurer.getOrientation());
    }

    @Test
    public void forwardOnX() {
        adventurer.forward();
        assertEquals(2, adventurer.coordinate().getX());
    }

    @Test
    public void forwardOnY() {
        adventurer.right();
        adventurer.forward();
        assertEquals(2, adventurer.coordinate().getY());
    }

    @Test
    public void pickUpTreasureAndCheckAdventurerPoints() {
        Treasure treasure = new Treasure(1, 1, 2);
        int initialPoints = adventurer.getPoints();
        adventurer.pickupTreasure(treasure);
        assertEquals(initialPoints+1, adventurer.getPoints());
    }

    @Test
    public void pickUpTreasureAndCheckTreasurePoints() {
        Treasure treasure = new Treasure(1, 1, 2);
        adventurer.pickupTreasure(treasure);
        assertEquals(1, treasure.getPoints());
    }

    @Test
    public void doNothingOnSetPoints() {
        adventurer.setPoints(20);
        assertEquals(0, adventurer.getPoints());
    }

    @Test
    public void notWalkableCharacter() {
        assertFalse(adventurer.isWalkable());
    }

    @Test
    public void typeCheck() {
        assertEquals(Type.A, adventurer.getType());
    }

}
