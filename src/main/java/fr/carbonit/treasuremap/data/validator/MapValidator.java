package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.List;

public class MapValidator implements Validator {
    private final static int SIZE = 2;
    public final static int WIDTH = 0;
    public final static int HEIGHT = 1;

    @Override
    public void validate(List<String> parameters) throws MapFileException {
        if(parameters.size() != SIZE) {
            throw new MapFileException("Map configuration line is incorrect.");
        }
        String width = parameters.get(WIDTH);
        String height = parameters.get(HEIGHT);
        CoordinateValidator.validate(width, height);
    }
}
