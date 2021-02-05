package pl.cecherz.geometry;

public class RotatingSolidsPrinter {

    /** Circle **/
    public static void buildCircle(double radius) throws NegativeArgumentException {
        String infoAboutParameters = new RotatingSolids.Circle().setRadius(radius)
                .build()
                .getParameters(true);
        double circleArea = new RotatingSolids
                .Circle()
                .setRadius(radius)
                .calcArea();
        double circleCircuit = new RotatingSolids
                .Circle()
                .setRadius(radius)
                .calcCircuit();
        System.out.println(infoAboutParameters);
        System.out.println("Circle area is :" + circleArea);
        System.out.println("Circle circuit is: " + circleCircuit + "\n");
    }
    public static void buildCircle(RotatingSolids rotatingSolid, double radius) throws NegativeArgumentException {
        rotatingSolid = new RotatingSolids.Cylinder().setRadius(radius).build();
        String infoAboutParameters = CircularSolids.from(rotatingSolid).getParameters();
        double circleArea = CircularSolids.from(rotatingSolid).calcCircleArea();
        double circleCircuit = CircularSolids.from(rotatingSolid).calcCircleCircuit();
        System.out.println(infoAboutParameters);
        System.out.println("Circle area is :" + circleArea);
        System.out.println("Circle circuit is: " + circleCircuit + "\n");
    }

    /** Sphere **/
    public static void buildSphere(double radius) throws NegativeArgumentException {
        String infoAboutParameters = new RotatingSolids.Sphere().setRadius(radius)
                .build()
                .getParameters(true);
        double sphereSurface = new RotatingSolids.Sphere()
                .setRadius(radius)
                .calcSurface();
        double sphereVolume = new RotatingSolids
                .Sphere()
                .setRadius(radius)
                .calcVolume();
        System.out.println(infoAboutParameters);
        System.out.println("Sphere surface is :" + sphereSurface);
        System.out.println("Sphere volume is: " + sphereVolume + "\n");
    }
    public static void buildSphere(RotatingSolids rotatingSolid, double radius) throws NegativeArgumentException {
        rotatingSolid = new RotatingSolids.Cylinder().setRadius(radius).build();
        String infoAboutParameters = CircularSolids.from(rotatingSolid).getParameters();
        double sphereSurface = CircularSolids.from(rotatingSolid).calcSphereSurface();
        double sphereVolume = CircularSolids.from(rotatingSolid).calcSphereVolume();
        System.out.println(infoAboutParameters);
        System.out.println("Sphere surface is: " + sphereSurface);
        System.out.println("Sphere volume is: " + sphereVolume + "\n");
    }

    /** Cylinder **/
    public static void buildCylinder(double radius, double height) throws NegativeArgumentException {
        String infoAboutParameters = new RotatingSolids.Cylinder()
                .setRadius(radius)
                .setHeight(height)
                .build()
                .getParameters(false);
        double cylinderSurface = new RotatingSolids.Cylinder()
                .setRadius(radius)
                .setHeight(height)
                .calcSurface();
        double cylinderVolume = new RotatingSolids.Cylinder()
                .setRadius(radius)
                .setHeight(height)
                .calcVolume();
        System.out.println(infoAboutParameters);
        System.out.println("Cylinder surface is :" + cylinderSurface);
        System.out.println("Cylinder volume is: " + cylinderVolume + "\n");
    }

    /** Cone **/
    public static void buildCone(double radius, double height) throws NegativeArgumentException {
        String infoAboutParameters = new RotatingSolids.Cone()
                .setRadius(radius)
                .setHeight(height)
                .build()
                .getParameters(false);
        double coneSurface = new RotatingSolids.Cone()
                .setRadius(radius)
                .setHeight(height)
                .calcSurface();
        double coneVolume = new RotatingSolids.Cone()
                .setRadius(radius)
                .setHeight(height)
                .calcVolume();
        System.out.println(infoAboutParameters);
        System.out.println("Cone surface is :" + coneSurface);
        System.out.println("Cone volume is: " + coneVolume + "\n");
    }
}
