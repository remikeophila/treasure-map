package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.map.Coordinate;

/**
 * Orientation associated to a @{{@link Moveable}} object
 */
public interface Orientation {
    /**
     * Next orientation if the @{{@link Moveable} rotates on the left side
     * @return Next Orientation after a left rotation
     */
    Orientation left();

    /**
     * Next orientation if the @{{@link Moveable} rotates on the right side
     * @return Next Orientation after a right rotation
     */
    Orientation right();

    /**
     * Step coordinate if the @{@link Moveable} walks a step forward.
     * If the @{{@link Moveable}} makes a step forward to the north, it will return the step coordinate (0, -1)
     * @return A step coordinate
     */
    Coordinate stepForward();
}
