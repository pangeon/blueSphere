package pl.cecherz;

public class Start {
    public static void main(String[] args) {
        System.out.println("Application is running");
        double circleArea = new RotatingSolids.Circle()
                .setRadius(6)
                .calcArea();
        double circleCircuit = new RotatingSolids
                .Circle()
                .setRadius(6)
                .calcCircuit();
        System.out.println(circleArea);
        System.out.println(circleCircuit);

    }
}
