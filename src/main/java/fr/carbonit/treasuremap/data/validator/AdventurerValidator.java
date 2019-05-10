package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.data.DataAction;
import fr.carbonit.treasuremap.data.DataOrientation;
import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public class AdventurerValidator implements Validator {

    /* Index */
    private final static int SIZE = 5;
    public final static int NAME = 0;
    public final static int X = 1;
    public final static int Y = 2;
    public final static int ORIENTATION = 3;
    public final static int COMMANDS = 4;

    @Override
    public void validate(List<String> parameters) throws MapFileException {
        if(parameters.size() != SIZE) {
            throw new MapFileException("Adventurer configuration line is incorrect.");
        }

        String x = parameters.get(X);
        String y = parameters.get(Y);
        String orientation = parameters.get(ORIENTATION);
        String commands = parameters.get(COMMANDS);

        /* Position Validation */
        CoordinateValidator.validate(x, y);

        /* Orientation Validation */
        try {
            DataOrientation.valueOf(orientation);
        } catch(IllegalArgumentException e) {
            throw new MapFileException("Invalid Orientation: "+orientation);
        }

        /* Commands Validation */
        try {
            for(int i = 0; i < commands.length(); i++) {
                DataAction.valueOf(commands.charAt(i)+"");
            }
        } catch(IllegalArgumentException e) {
            throw new MapFileException("Invalid commands: "+commands);
        }
    }



}
