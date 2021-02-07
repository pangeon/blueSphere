package pl.cecherz;

import pl.cecherz.geometry.exceptions.NegativeArgumentException;

import static pl.cecherz.geometry.printers.RotatingSolidsPrinter.*;

public class Start {
    public static void main(String[] args) {
        System.out.println("Application is running \n");

        try {
            showCircleData( 6);
            showSphereData(9);
            showCylinderData(6, 8);
            showConeData(6, 9);
            showTorusData(5, 8);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }
}
