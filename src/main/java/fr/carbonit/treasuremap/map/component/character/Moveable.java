package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.map.component.Component;

/**
 * A moveable object is an object which can move in the @{{@link fr.carbonit.treasuremap.map.Map}}
 */
public interface Moveable extends Component {
    /**
     * Step Forward
     */
    void forward();

    /**
     * Rotate Right
     */
    void right();

    /**
     * Rotate left
     */
    void left();

    /**
     * Pick the treasure in parameter. The moveable points will be incremented.
     * @param treasure
     */
    void pickupTreasure(Component treasure);

    /**
     * Moveable @{{@link Orientation}}
     * @return
     */
    Orientation getOrientation();

    /**
     * Character name
     * @return Character name
     */
    String getName();
}
