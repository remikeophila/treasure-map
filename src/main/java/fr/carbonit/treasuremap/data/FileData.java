package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;

import java.util.Arrays;
import java.util.List;

public class FileData implements Data {
    private final Type type;
    private final List<String> parameters;

    public FileData(String line) {
        String[] data = line.split(" - ");

        if(data.length < 2) {
            throw new MapFileException("Invalid line: "+line);
        }

        try {
            this.type = Type.valueOf(data[0]);
        } catch (IllegalArgumentException e) {
            throw new MapFileException("Invalid component value for "+data[0]+" on line: "+line);
        }

        List<String> parameters = Arrays.asList(data).subList(1, data.length);

        type.getValidator().validate(parameters);

        this.parameters = parameters;
    }


    public Type getType() {
        return type;
    }

    public List<String> getParameters() {
        return parameters;
    }

}
