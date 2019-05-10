package fr.carbonit.treasuremap.map;

import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.component.Mountain;
import fr.carbonit.treasuremap.map.component.Treasure;
import fr.carbonit.treasuremap.map.component.character.Adventurer;
import fr.carbonit.treasuremap.map.component.character.AdventurerOrientation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapTest {
    private Map map = null;
    private Component treasure = new Treasure(1, 2, 2);
    private Adventurer adventurer = new Adventurer(1,1, AdventurerOrientation.EAST, "Harry");

    @Before
    public void init() {
        List<Component> components = new ArrayList<>();
        components.add(treasure);
        this.map = new Map(5, 5,
                adventurer,
                components,
                Collections.emptyList());
    }

    @Test
    public void buildMap() {
        List<Component> components = new ArrayList<>();
        components.add(treasure);
        new Map(5, 5,
                adventurer,
                components,
                Collections.emptyList());
    }

    @Test
    public void validateCorrectNextPosition() {
        Coordinate nextCoordinate = new Coordinate(2, 1);
        map.validateNextPosition(nextCoordinate);
    }

    @Test(expected = MapException.class)
    public void validateIncorrectNextPosition() {
        Coordinate nextCoordinate = new Coordinate(1, 10);
        map.validateNextPosition(nextCoordinate);
    }

    @Test
    public void removeTreasureFromComponents() {
        int size = map.getComponents().size();
        map.removeComponent(treasure);
        assertEquals(size-1 , map.getComponents().size());
    }

    @Test
    public void removeNonExistingFromComponents() {
        int size = map.getComponents().size();
        map.removeComponent(new Mountain(1, 1));
        assertEquals(size , map.getComponents().size());
    }
}
