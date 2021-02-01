package pl.cecherz;

public class RotatingSolids {
    private final double PI = Math.PI;
    private String solidName;
    private double radius;
    private double height;

    private RotatingSolids(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    public static class Circle {
        private final double PI = Math.PI;
        private double radius = 0;
        private final double height = 1;

        public Circle setRadius(double radius) {
            this.radius = radius;
            return this;
        }
        public double calcArea() {
            double r = new RotatingSolids(radius, height).radius;
            return PI*Math.pow(radius, 2);
        }
        public double calcCircuit() {
            double r = new RotatingSolids(radius, height).radius;
            return 2*PI*r;
        }
        public RotatingSolids build() {
            return new RotatingSolids(radius, height);
        }
    }
}
