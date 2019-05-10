package fr.carbonit.treasuremap.map;

import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.component.Mountain;
import fr.carbonit.treasuremap.map.component.Treasure;
import fr.carbonit.treasuremap.map.component.character.Adventurer;
import fr.carbonit.treasuremap.map.component.character.AdventurerOrientation;
import fr.carbonit.treasuremap.map.component.character.command.Command;
import fr.carbonit.treasuremap.map.component.character.command.Forward;
import fr.carbonit.treasuremap.map.component.character.command.Left;
import fr.carbonit.treasuremap.map.component.character.command.Right;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapControllerTest {
    private Adventurer adventurer;
    private List<Command> commands;
    List<Component> defaultComponents;
    private Map map;

    @Before
    public void init() {
        this.adventurer = new Adventurer(1, 1,
                AdventurerOrientation.SOUTH,
                "Jean-Edouard");
        this.commands = new ArrayList<>();
        this.commands.add(new Forward());
        this.defaultComponents = new ArrayList<>();
    }

    @Test
    public void oneMove() {
        this.map = new Map(5, 5, adventurer, defaultComponents, commands);
        int initialX = map.getMoveable().coordinate().getX();
        int initialY = map.getMoveable().coordinate().getY();
        MapController mapController = new MapController(this.map);
        mapController.execute();
        assertEquals(initialX,this.map.getMoveable().coordinate().getX());
        assertEquals(initialY + 1,this.map.getMoveable().coordinate().getY());
    }

    @Test
    public void rightAndDidNotMove() {
        this.map = new Map(5, 5, adventurer, defaultComponents, getCommandList(new Right()));
        int initialX = map.getMoveable().coordinate().getX();
        int initialY = map.getMoveable().coordinate().getY();
        MapController mapController = new MapController(this.map);
        mapController.execute();
        assertEquals(initialX,this.map.getMoveable().coordinate().getX());
        assertEquals(initialY,this.map.getMoveable().coordinate().getY());
    }

    @Test
    public void rightAndPivoted() {
        this.map = new Map(5, 5, adventurer, defaultComponents, getCommandList(new Right()));
        MapController mapController = new MapController(this.map);
        mapController.execute();
        assertEquals(AdventurerOrientation.WEST,this.map.getMoveable().getOrientation());
    }

    @Test
    public void leftAndDidNotMove() {
        this.map = new Map(5, 5, adventurer, defaultComponents, getCommandList(new Left()));
        int initialX = map.getMoveable().coordinate().getX();
        int initialY = map.getMoveable().coordinate().getY();
        MapController mapController = new MapController(this.map);
        mapController.execute();
        assertEquals(initialX,this.map.getMoveable().coordinate().getX());
        assertEquals(initialY,this.map.getMoveable().coordinate().getY());
    }

    @Test
    public void leftAndPivoted() {
        this.map = new Map(5, 5, adventurer, defaultComponents, getCommandList(new Left()));
        MapController mapController = new MapController(this.map);
        mapController.execute();
        assertEquals(AdventurerOrientation.EAST,this.map.getMoveable().getOrientation());
    }



    @Test
    public void moveOnMoutain() {
        this.defaultComponents.add(new Mountain(1,2));
        this.map = new Map(5, 5, adventurer, defaultComponents, commands);
        int initialX = this.map.getMoveable().coordinate().getX();
        int initialY = this.map.getMoveable().coordinate().getY();
        MapController mapController = new MapController(this.map);

        mapController.execute();

        assertEquals(initialX,this.map.getMoveable().coordinate().getY());
        assertEquals(initialY,this.map.getMoveable().coordinate().getY());
    }

    @Test
    public void moveOnTreasureAndStepIn() {
        this.defaultComponents.add(new Treasure(1,2, 1));
        this.map = new Map(5, 5, adventurer, defaultComponents, commands);
        int initialX = this.map.getMoveable().coordinate().getX();
        int initialY = this.map.getMoveable().coordinate().getY();

        MapController mapController = new MapController(this.map);
        mapController.execute();

        assertEquals(initialX,this.map.getMoveable().coordinate().getX());
        assertEquals(initialY + 1,this.map.getMoveable().coordinate().getY());
    }

    @Test
    public void moveOnTreasureAndIncrementedPoints() {
        this.defaultComponents.add(new Treasure(1,2, 1));
        this.map = new Map(5, 5, adventurer, defaultComponents, commands);
        int initialPoints = map.getMoveable().getPoints();

        MapController mapController = new MapController(this.map);
        mapController.execute();

        assertEquals(initialPoints+1, map.getMoveable().getPoints());
    }

    @Test
    public void moveOnTreasureAndPivotLeft() {
        this.defaultComponents.add(new Treasure(1,2, 2));
        this.map = new Map(5, 5, adventurer, defaultComponents,
                getCommandList(new Forward(), new Left()));
        int initialPoints = map.getMoveable().getPoints();

        MapController mapController = new MapController(this.map);
        mapController.execute();

        assertEquals(initialPoints+1, map.getMoveable().getPoints());
    }

    @Test
    public void moveOnTreasureAndPivotRight() {
        this.defaultComponents.add(new Treasure(1,2, 2));
        this.map = new Map(5, 5, adventurer, defaultComponents,
                getCommandList(new Forward(), new Right()));
        int initialPoints = map.getMoveable().getPoints();

        MapController mapController = new MapController(this.map);
        mapController.execute();

        assertEquals(initialPoints+1, map.getMoveable().getPoints());
    }


    private List<Command> getCommandList(Command... commands) {
        List<Command> customCommands = new ArrayList<>();
        for(Command command: commands) {
            customCommands.add(command);
        }
        return customCommands;

    }
}
