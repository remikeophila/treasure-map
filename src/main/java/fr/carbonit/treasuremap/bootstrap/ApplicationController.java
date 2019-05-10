package fr.carbonit.treasuremap.bootstrap;

import fr.carbonit.treasuremap.data.ReadDataController;
import fr.carbonit.treasuremap.data.WriteDataController;
import fr.carbonit.treasuremap.map.Map;
import fr.carbonit.treasuremap.map.MapController;

import java.io.IOException;

/**
 * Run the application by:
 *  - Parsing the input file
 *  - Run the simulation
 *  - Write the output file
 */
public class ApplicationController {

    public static void run(String[] args) throws IOException {
        Map map = ReadDataController.execute(args[0]);

        MapController mapController = new MapController(map);
        mapController.execute();

        WriteDataController writeDataController = new WriteDataController(map, args[1]);
        writeDataController.execute();

        System.out.println("Simulation finished successfully. "
                +"Check the result: "+args[1]);
    }
}
