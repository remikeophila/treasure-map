package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.map.Coordinate;

public enum AdventurerOrientation implements Orientation {
    NORTH {
        public AdventurerOrientation left() {
            return WEST;
        }

        public AdventurerOrientation right() {
            return EAST;
        }

        public Coordinate stepForward() {
            return new Coordinate(0, -1);
        }
    },
    SOUTH{
        public AdventurerOrientation left() {
            return EAST;
        }

        public AdventurerOrientation right() {
            return WEST;
        }

        public Coordinate stepForward() {
            return new Coordinate(0, 1);
        }
    },
    EAST{
        public AdventurerOrientation left() {
            return NORTH;
        }

        public AdventurerOrientation right() {
            return SOUTH;
        }

        public Coordinate stepForward() {
            return new Coordinate(1, 0);
        }
    },
    WEST{
        public AdventurerOrientation left() {
            return SOUTH;
        }

        public AdventurerOrientation right() {
            return NORTH;
        }

        public Coordinate stepForward() {
            return new Coordinate(-1, 0);
        }
    }
}
