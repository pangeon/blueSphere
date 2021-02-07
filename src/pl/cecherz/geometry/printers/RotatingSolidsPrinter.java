package pl.cecherz.geometry.printers;

import pl.cecherz.geometry.exceptions.MismatchedArgumentsException;
import pl.cecherz.geometry.exceptions.NegativeArgumentException;
import pl.cecherz.geometry.exceptions.UnknownFigureType;
import pl.cecherz.geometry.logic.FigureTypes;

import static java.lang.System.*;
import static pl.cecherz.geometry.logic.RotatingSolids.*;

public class RotatingSolidsPrinter {

    /** Circle **/
    public static void showCircleData(double radius) throws NegativeArgumentException {
        getInfoAboutCircleParameters(radius);
        printInfoAbout2DFigure("Circle",
                returnCircleArea(radius),
                returnCircleCircuit(radius)
        );
    }

    /** Sphere **/
    public static void showSphereData(double radius) throws NegativeArgumentException {
        getInfoAboutSphereParameters(radius);
        printInfoAbout3DSolid("Sphere",
                returnSphereSurface(radius),
                returnSphereVolume(radius)
        );
    }

    /** Cylinder **/
    public static void showCylinderData(double radius, double height) throws NegativeArgumentException {
        getInfoAboutCylinderParameters(radius, height);
        printInfoAbout3DSolid("Cylinder",
                returnCylinderSurface(radius, height),
                returnCylinderVolume(radius, height)
        );
    }

    /** Cone **/
    public static void showConeData(double radius, double height) throws NegativeArgumentException {
        getInfoAboutConeParameters(radius, height);
        printInfoAbout3DSolid("Cone",
                returnConeSurface(radius, height),
                returnConeVolume(radius, height)
        );
    }
    /** Torus **/
    public static void showTorusData(double radius, double outerRadius) throws NegativeArgumentException {
        getInfoAboutTorusParameters(radius, outerRadius);
        printInfoAbout3DSolid("Torus",
                returnTorusSurface(radius, outerRadius),
                returnTorusVolume(radius, outerRadius)
        );
    }

    /** Utils **/

    /* General */
    private static void printInfoAbout2DFigure(String figureName, double figureArea, double figureCircuit) {
        out.println(figureName + " area is :" + figureArea);
        out.println(figureName + " circuit is: " + figureCircuit + "\n");
    }

    private static void printInfoAbout3DSolid(String solidName, double solidSurface, double solidVolume) {
        out.println(solidName + " surface is: " + solidSurface);
        out.println(solidName + " volume is: " + solidVolume + "\n");
    }

    /* Circle */
    private static void getInfoAboutCircleParameters(double radius) throws NegativeArgumentException {
        try {
            out.println(new Circle()
                    .setRadius(radius)
                    .build()
                    .getParameters(FigureTypes.circular)
            );
        } catch (UnknownFigureType e) {
            e.printStackTrace();
        }
    }

    private static double returnCircleArea(double radius) {
        return new Circle()
                .setRadius(radius)
                .calcArea();
    }

    private static double returnCircleCircuit(double radius) {
        return new Circle()
                .setRadius(radius)
                .calcCircuit();
    }

    /* Sphere */
    private static void getInfoAboutSphereParameters(double radius) throws NegativeArgumentException {
        try {
            out.println(new Sphere()
                    .setRadius(radius)
                    .build()
                    .getParameters(FigureTypes.circular)
            );
        } catch (UnknownFigureType e) {
            e.printStackTrace();
        }
    }

    private static double returnSphereSurface(double radius) {
        return new Sphere()
                .setRadius(radius)
                .calcSurface();
    }

    private static double returnSphereVolume(double radius) {
        return new Sphere()
                .setRadius(radius)
                .calcVolume();
    }

    /* Cylinder */
    private static void getInfoAboutCylinderParameters(double radius, double height) throws NegativeArgumentException {
        try {
            out.println(new Cylinder()
                    .setRadius(radius)
                    .setHeight(height)
                    .build()
                    .getParameters(FigureTypes.rolling)
            );
        } catch (UnknownFigureType e) {
            e.printStackTrace();
        }
    }

    private static double returnCylinderSurface(double radius, double height) {
        return new Cylinder()
                .setRadius(radius)
                .setHeight(height)
                .calcSurface();
    }

    private static double returnCylinderVolume(double radius, double height) {
        return new Cylinder()
                .setRadius(radius)
                .setHeight(height)
                .calcVolume();
    }

    /* Cone */
    private static void getInfoAboutConeParameters(double radius, double height) throws NegativeArgumentException {
        try {
            out.println(new Cone()
                    .setRadius(radius)
                    .setHeight(height)
                    .build()
                    .getParameters(FigureTypes.rolling)
            );
        } catch (UnknownFigureType e) {
            e.printStackTrace();
        }
    }

    private static double returnConeSurface(double radius, double height) {
        return new Cone()
                .setRadius(radius)
                .setHeight(height)
                .calcSurface();
    }

    private static double returnConeVolume(double radius, double height) {
        return new Cone()
                .setRadius(radius)
                .setHeight(height)
                .calcVolume();
    }

    /* Torus */
    private static void getInfoAboutTorusParameters(double radius, double outerRadius) throws NegativeArgumentException {
        try {
            out.println(new Torus()
                    .setRadius(radius)
                    .setOuterRadius(outerRadius)
                    .build()
                    .getParameters(FigureTypes.torus)
            );
        } catch (UnknownFigureType | MismatchedArgumentsException e) {
            e.printStackTrace();
        }
    }

    private static double returnTorusSurface(double radius, double outerRadius) {
        return new Torus()
                .setRadius(radius)
                .setOuterRadius(outerRadius)
                .calcSurface();

    }

    private static double returnTorusVolume(double radius, double outerRadius) {
        return new Torus()
                .setRadius(radius)
                .setOuterRadius(outerRadius)
                .calcVolume();
    }
}
