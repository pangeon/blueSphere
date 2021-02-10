package pl.cecherz.utils;
import pl.cecherz.geometry.exceptions.NegativeArgumentException;
import pl.cecherz.geometry.exceptions.UnknownFigureType;
import pl.cecherz.geometry.printers.RotatingSolidsPrinter;

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

    /* TODO: Exiting the program too complicated */
    public void invokeCalculations() throws UnknownFigureType, NegativeArgumentException {
        double radius = 0, height = 0, outerRadius = 0;
        printMassage("Click any key and after enter to continue...");

        while (isStopApplication().equals("start")) {
            switch (invokeCommand()) {
                case circuit -> {
                    radius = CMD.nextDouble();
                    RotatingSolidsPrinter.showCircleData(radius);
                }
                case sphere -> {
                    radius = CMD.nextDouble();
                    RotatingSolidsPrinter.showSphereData(radius);
                }
                case cylinder -> {
                    radius = CMD.nextDouble();
                    height = CMD.nextDouble();
                    RotatingSolidsPrinter.showCylinderData(radius, height);
                }
                case cone -> {
                    radius = CMD.nextDouble();
                    height = CMD.nextDouble();
                    RotatingSolidsPrinter.showConeData(radius, height);
                }
                case torus -> {
                    radius = CMD.nextDouble();
                    outerRadius = CMD.nextDouble();
                    RotatingSolidsPrinter.showTorusData(radius, outerRadius);
                }
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
            case "tor" ->{
                printMassage("Enter torus radius (r) and outer radius (R):");
                return FigureNames.torus;
            }
            default -> throw new UnknownFigureType();
        }
    }

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
}
