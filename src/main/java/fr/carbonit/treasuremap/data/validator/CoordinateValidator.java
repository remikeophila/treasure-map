package fr.carbonit.treasuremap.data.validator;

import fr.carbonit.treasuremap.exception.MapFileException;

public class CoordinateValidator {

    /**
     * Validate a pair of coordinate
     * @param x - X coordinate
     * @param y - Y coordinate
     */
    public static void validate(String x, String y) {
        if(!isInteger(x) || !isInteger(y)) {
            throw new MapFileException("Adventurer position is incorrect: ("+
                    x+", "+y+")");
        }
    }

    /**
     * Check if the string is valid positive numeric value
     * @return true if valid, false if invalid
     */
    public static boolean isInteger(String s) {
        if(s.isEmpty()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            /* No negative integer */
            if(i == 0 && s.charAt(i) == '-') {
                return false;
            }
            if(Character.digit(s.charAt(i),10) < 0) {
                return false;
            }
        }
        return true;
    }
}
