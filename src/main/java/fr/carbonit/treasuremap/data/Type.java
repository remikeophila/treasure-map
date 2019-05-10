package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.data.validator.*;

public enum Type implements Validable {

    /* Carte */
    C {
        @Override
        public Validator getValidator() {
            return new MapValidator();
        }
    },

    /* Montagne */
    M {
        @Override
        public Validator getValidator() {
            return new MountainValidator();
        }
    },

    /* Tresor */
    T {
        @Override
        public Validator getValidator() {
            return new TreasureValidator();
        }
    },

    /* Aventurier */
    A {
        @Override
        public Validator getValidator() {
            return new AdventurerValidator();
        }
    }
}
