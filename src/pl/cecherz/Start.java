package pl.cecherz;

import pl.cecherz.geometry.exceptions.NegativeArgumentException;
import pl.cecherz.geometry.exceptions.UnknownFigureType;
import pl.cecherz.utils.CommandReader;

public class Start {
    public static void main(String[] args) {
        System.out.println("Application is running \n");

        try {
            CommandReader.getInstance().invokeCalculations();
        } catch (UnknownFigureType | NegativeArgumentException unknownFigureType) {
            unknownFigureType.printStackTrace();
        }
    }
}
