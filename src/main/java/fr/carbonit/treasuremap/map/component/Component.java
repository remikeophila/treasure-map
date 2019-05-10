package fr.carbonit.treasuremap.map.component;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.Coordinate;

public interface Component {
    Type getType();
    Coordinate coordinate();
    int getPoints();
    void setPoints(int points);
    boolean isWalkable();
}
