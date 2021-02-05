package pl.cecherz.geometry;

public class RotatingSolids {
    private static final double PI = Math.PI;
    private double radius;
    private double height;

    private RotatingSolids(double radius, double height) throws NegativeArgumentException {
        this.radius = radius;
        this.height = height;

        if(radius < 0 || height < 0) {
            throw new NegativeArgumentException();
        }
    }
    private RotatingSolids(double radius) throws NegativeArgumentException {
        this.radius = radius;
        if(radius < 0) {
            throw new NegativeArgumentException();
        }
    }

    public RotatingSolids() {}

    /** Circle **/
    public static class Circle {
        private double radius = 0;

        public Circle setRadius(double radius) {
            this.radius = radius;

            return this;
        }
        public double calcArea() { return PI*Math.pow(radius, 2); }
        public double calcCircuit() { return 2*PI*radius; }
        public RotatingSolids build() throws NegativeArgumentException {
            return new RotatingSolids(radius);
        }
    }

    /** Sphere **/
    public static class Sphere {
        private double radius = 0;

        public Sphere setRadius(double radius) {
            this.radius = radius;
            return this;
        }
        public double calcSurface() { return 4*(PI*Math.pow(radius, 2)); }
        public double calcVolume() { return 4*(PI * Math.pow(radius, 3)/3); }
        public RotatingSolids build() throws NegativeArgumentException {
            return new RotatingSolids(radius);
        }
    }

    /** Cylinder **/
    public static class Cylinder {
        private double radius = 1;
        private double height = 1;

        public Cylinder setRadius(double radius) {
            this.radius = radius;
            return this;
        }
        public Cylinder setHeight(double height) {
            this.height = height;
            return this;
        }
        public double calcSurface() { return (2*PI*radius)*(radius+height);}
        public double calcVolume() { return (PI*Math.pow(radius, 2))*height; }
        public RotatingSolids build() throws NegativeArgumentException {
            return new RotatingSolids(radius, height);
        }
    }

    /** Cone **/
    public static class Cone {
        private double radius = 1;
        private double height = 1;

        public Cone setRadius(double radius) {
            this.radius = radius;
            return this;
        }
        public Cone setHeight(double height) {
            this.height = height;
            return this;
        }
        public double calcSurface() {
            return (PI*radius)*(Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2))) + (PI*Math.pow(radius, 2));
        }
        public double calcVolume() { return (PI*Math.pow(radius, 2))*height / 3; }

        public RotatingSolids build() throws NegativeArgumentException {
            return new RotatingSolids(radius, height);
        }
    }

    public double getRadius() {
        return radius;
    }

    /** Utils **/
    String getParameters(boolean isCircle) {
        if (isCircle) return "radius: " + radius;
        else return "radius: " + radius + "\nheight: " + height;
    }
}

