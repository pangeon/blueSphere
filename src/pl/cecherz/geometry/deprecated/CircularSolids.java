package pl.cecherz.geometry.deprecated;

import pl.cecherz.geometry.logic.RotatingSolids;

class CircularSolids {
    private static final double PI = Math.PI;
    private double radius;

    public CircularSolids(double radius) {
        this.radius = radius;
    }
    public static CircularSolids from(RotatingSolids rotatingSolid) {
        return new CircularSolids(rotatingSolid.getRadius());
    }
    /** Circle **/
    public double calcCircleArea() { return PI*Math.pow(radius, 2); }
    public double calcCircleCircuit() { return 2*PI*radius; }

    /** Sphere **/
    public double calcSphereSurface() { return 4*(PI*Math.pow(radius, 2)); }
    public double calcSphereVolume() { return 4*(PI * Math.pow(radius, 3)/3); }

    /** Utils **/
    String getParameters() {
        return "radius: " + radius;
    }

}
