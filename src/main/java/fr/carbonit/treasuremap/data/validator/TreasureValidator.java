package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public class TreasureValidator implements Validator {
    private final static int SIZE = 3;
    public final static int X = 0;
    public final static int Y = 1;
    public final static int VALUE = 2;

    @Override
    public void validate(List<String> parameters) throws MapFileException {
        if(parameters.size() != SIZE) {
            throw new MapFileException("Treasure configuration line is incorrect.");
        }
        /* Position Validation */
        String x = parameters.get(X);
        String y = parameters.get(Y);
        CoordinateValidator.validate(x, y);

        /* Value Validation */
        String value = parameters.get(VALUE);
        if(!CoordinateValidator.isInteger(value)) {
            throw new MapFileException("The treasure value is invalid: "+value);
        }
    }
}
