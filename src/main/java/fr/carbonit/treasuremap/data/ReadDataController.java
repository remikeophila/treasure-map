package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.exception.MapFileException;
import fr.carbonit.treasuremap.map.Map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Control the data flow:
 *  - Read the input file
 *  - Retrieve results
 *  - Write the output file
 */
public class ReadDataController {

    public static Map execute(String inputFilePath) throws IOException {
        List<FileData> data = parseInputFile(inputFilePath);
        return DataMapper.map(data);
    }

    private static List<FileData> parseLines(List<String> list) {
        List<FileData> data = new ArrayList<>();
        for(String line: list){
            FileData fileData = new FileData(line);
            data.add(fileData);
        }

        return data;
    }

    private static List<FileData> parseInputFile(String inputFilePath) {
        List<String> list;

        try (Stream<String> stream = Files.lines(Paths.get(inputFilePath))) {
            list = stream
                    .filter(line -> !line.startsWith("#"))
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new MapFileException("Unable to open the input file: "+inputFilePath);
        }

        return parseLines(list);
    }
}
