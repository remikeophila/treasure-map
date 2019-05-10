package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public class MountainValidator implements Validator {
    private final static int SIZE = 2;
    public final static int X = 0;
    public final static int Y = 1;
    @Override
    public void validate(List<String> parameters) throws MapFileException {
        if(parameters.size() != SIZE) {
            throw new MapFileException("Mountain configuration line is incorrect.");
        }
        String x = parameters.get(X);
        String y = parameters.get(Y);

        /* Position Validation */
        CoordinateValidator.validate(x, y);
    }
}
