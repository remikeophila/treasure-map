package fr.carbonit.treasuremap.map.component;

import fr.carbonit.treasuremap.data.Type;
import fr.carbonit.treasuremap.map.Coordinate;

/**
 * A component is a object contained in the map
 */
public interface Component {
    /**
     * Component type
     * @return An Enum @{{@link Type}} representing the component Type
     */
    Type getType();

    /**
     * Component Coordinates @{{@link Coordinate}}
     * @return component coordinates
     */
    Coordinate coordinate();

    /**
     * Points the component have
     * @return points contained in the component
     */
    int getPoints();
    void setPoints(int points);

    /**
     * Check if a movable object can walk through this component
     * For example, an adventurer cannot walk on a mountain, but can walk on a treasure
     * @return True if the component, False if not
     */
    boolean isWalkable();
}
