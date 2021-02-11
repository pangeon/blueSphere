package pl.cecherz.utils;
import pl.cecherz.geometry.exceptions.NegativeArgumentException;
import pl.cecherz.geometry.exceptions.UnknownFigureType;

import pl.cecherz.geometry.printers.RotatingSolidsPrinter;

import java.util.Objects;
import java.util.Scanner;

public class CommandReader {
    /** Singleton pattern **/
    private static CommandReader instance;

    private CommandReader(){};

    private static class SingletonHolder {
        private static final CommandReader INSTANCE;

        static {
            INSTANCE = new CommandReader();
        }
    }

    public static CommandReader getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /** Programme logic **/
    private static final Scanner CMD = new Scanner(System.in);

    public void invokeUserInterfaceInCMD() throws UnknownFigureType {
        printMassage("Click enter to continue...");

        // TODO: Exiting the program too complicated
        while (isStopApplication().equals("start")) {
            switch (Objects.requireNonNull(invokeCommand())) {
                case circuit -> calcCircuit();
                case sphere -> calcSphere();
                case cylinder -> calcCylinder();
                case cone -> calcCone();
                case torus -> calcTorus();
            }
        }
    }

    private FigureNames invokeCommand() throws UnknownFigureType {
        printMassage(
            """
            ------------------------------------------
            Welcome in BlueSphere
            Choose solid want you use to calculation
            (cir) - circle
            (sph) - sphere
            (cyl) - cylinder
            (con) - cone
            (tor) - torus
            
            (exit) - close application
            ------------------------------------------
            """
        );
        switch(CMD.nextLine()) {
            case "cir" -> {
                printMassage("Enter circle radius (r):");
                return FigureNames.circuit;
            }
            case "sph" -> {
                printMassage("Enter sphere radius (r):");
                return FigureNames.sphere;
            }
            case "cyl" -> {
                printMassage("Enter cylinder radius (r) and height (h):");
                return FigureNames.cylinder;
            }
            case "con" -> {
                printMassage("Enter cone radius (r) and height (h):");
                return FigureNames.cone;
            }
            case "tor" -> {
                printMassage("Enter torus radius (r) and outer radius (R):");
                return FigureNames.torus;
            }
            case "exit" -> {
                CMD.close();
                return null;
            }
            default -> throw new UnknownFigureType();
        }
    }

    /** Utils **/
    /* TODO: Exiting the program too complicated */
    private String isStopApplication() {
        if (CMD.nextLine().equals("exit")) {
            CMD.close();
        }
        return "start";
    }

    private void printMassage(String massage) {
        System.out.println(massage);
    }

    private void calcCircuit() {
        double radius = CMD.nextDouble();
        try {
            RotatingSolidsPrinter.showCircleData(radius);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }

    private void calcSphere() {
        double radius = CMD.nextDouble();
        try {
            RotatingSolidsPrinter.showSphereData(radius);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }

    private void calcCylinder() {
        double radius = CMD.nextDouble();
        double height = CMD.nextDouble();
        try {
            RotatingSolidsPrinter.showCylinderData(radius, height);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }

    private void calcCone() {
        double radius = CMD.nextDouble();
        double height = CMD.nextDouble();
        try {
            RotatingSolidsPrinter.showConeData(radius, height);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }

    private void calcTorus() {
        double radius = CMD.nextDouble();
        double outerRadius = CMD.nextDouble();
        try {
            RotatingSolidsPrinter.showTorusData(radius, outerRadius);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
    }
}
