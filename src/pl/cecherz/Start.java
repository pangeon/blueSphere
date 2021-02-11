package pl.cecherz;

import pl.cecherz.geometry.exceptions.UnknownFigureType;
import pl.cecherz.utils.CommandReader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.out.println("Application is running \n");

        /* TODO: Change exceptions handling */
        try {
            CommandReader.getInstance().invokeUserInterfaceInCMD();
        } catch (UnknownFigureType e) {
            System.out.println("Failed: Bad command");
        } catch (InputMismatchException e) {
            System.out.println("Failed: You must enter only digits");
        } catch (NullPointerException e) {
            System.out.println("Close application");
        }
    }
}
