package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.map.component.character.AdventurerOrientation;

public enum DataOrientation {
    N(AdventurerOrientation.NORTH), /* NORTH */
    S(AdventurerOrientation.SOUTH), /* SOUTH*/
    E(AdventurerOrientation.EAST), /* EAST */
    O(AdventurerOrientation.WEST); /* WEST */

    private final AdventurerOrientation adventurerOrientation;

    DataOrientation(AdventurerOrientation adventurerOrientation) {
        this.adventurerOrientation = adventurerOrientation;
    }

    public AdventurerOrientation getAdventurerOrientation() {
        return adventurerOrientation;
    }
}
