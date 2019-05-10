package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.map.Coordinate;

public interface Orientation {
    Orientation left();
    Orientation right();
    Coordinate stepForward();
}
