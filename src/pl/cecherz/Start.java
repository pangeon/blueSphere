package pl.cecherz;

import pl.cecherz.geometry.NegativeArgumentException;

import static pl.cecherz.geometry.RotatingSolidsPrinter.*;

public class Start {
    public static void main(String[] args) {
        System.out.println("Application is running \n");

        try {
            buildCircle(6);
            buildSphere(9);
            buildCylinder(6, 8);
            buildCone(6, 9);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }
}
