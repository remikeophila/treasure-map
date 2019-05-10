package fr.carbonit.treasuremap.map.component.character;

import fr.carbonit.treasuremap.map.component.Component;

public interface Moveable extends Component {
    void forward();
    void right();
    void left();
    void pickupTreasure(Component treasure);
    Orientation getOrientation();
    String getName();
}
