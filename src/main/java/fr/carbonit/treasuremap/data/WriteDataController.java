package fr.carbonit.treasuremap.data;

import fr.carbonit.treasuremap.map.component.Component;
import fr.carbonit.treasuremap.map.Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Write the output file
 */
public class WriteDataController {
    private final Map map;
    private final String outputFilePath;

    public WriteDataController(Map map, String outputFilePath) {
        this.map = map;
        this.outputFilePath = outputFilePath;
    }

    public void execute() throws IOException {
        try(PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            writeMapData(output);
            writeComponentsData(output);
            writeAdventurer(output);
        }
    }

    private void writeComponentsData(PrintWriter printWriter) {
        for(Component component: map.getComponents()) {
            StringBuilder sb = new StringBuilder();
            sb.append(component.getType().name()+ " - " + component.coordinate().getX()+ " - "+component.coordinate().getY());
            if(component.isWalkable()) {
                sb.append(" - "+component.getPoints());
            }
            printWriter.println(sb.toString());
        }
    }

    private void writeMapData(PrintWriter printWriter) {
        printWriter.println("C"+" - "+map.getWidth()+" - "+map.getHeight());
    }

    private void writeAdventurer(PrintWriter printWriter) {

        printWriter.println("A"
                +" - " +map.getMoveable().coordinate().getX()
                +" - "+map.getMoveable().coordinate().getY()
                +" - "+map.getMoveable().getOrientation()
                +" - "+map.getMoveable().getPoints());
    }
}
