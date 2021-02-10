package pl.cecherz.geometry.logic;

import pl.cecherz.geometry.exceptions.MismatchedArgumentsException;
import pl.cecherz.geometry.exceptions.NegativeArgumentException;
import pl.cecherz.geometry.exceptions.UnknownFigureType;

public class RotatingSolids {
    private static final double PI = Math.PI;
    private double radius;
    private double outerRadius;
    private double height;

    /* Circle, Sphere */
    private RotatingSolids(double radius) throws NegativeArgumentException {
        this.radius = radius;
        if(radius < 0) {
            throw new NegativeArgumentException();
        }
    }

    /* Cylinder, Cone */
    private RotatingSolids(double radius, double height) throws NegativeArgumentException {
        this.radius = radius;
        this.height = height;

        if(radius < 0 || height < 0) {
            throw new NegativeArgumentException();
        }
    }

    /* Torus */
    /* TODO: This constructor is unnecessary, torus use two parameters */
    public RotatingSolids(double radius, double outerRadius, boolean isTorus) throws NegativeArgumentException, MismatchedArgumentsException {
        this.radius = radius;
        this.outerRadius = outerRadius;

        if(radius < 0 || outerRadius < 0) {
            throw new NegativeArgumentException();
        }
        if(outerRadius < radius) {
            throw new MismatchedArgumentsException();
        }
    }

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

    /** Torus **/
    public static class Torus {
        private double radius = 1;
        private double outerRadius = 1;

        public Torus setRadius(double radius) {
            this.radius = radius;
            return this;
        }

        public Torus setOuterRadius(double outerRadius) {
            this.outerRadius = outerRadius;
            return this;
        }
        public double calcSurface() { return 4*(PI*PI)*outerRadius*radius; }
        public double calcVolume() { return 2*(PI*PI)*outerRadius*(radius*radius); }

        public RotatingSolids build() throws NegativeArgumentException, MismatchedArgumentsException {
            return new RotatingSolids(radius, outerRadius, true);
        }
    }

    /** Utils **/
    public String getParameters(FigureTypes figureType) throws UnknownFigureType {
        return switch (figureType) {
            case circular -> "radius: " + radius;
            case rolling -> "radius: " + radius + "\nheight: " + height;
            case torus -> "radius: " + radius + "\nouther radius: " + outerRadius;
            default -> throw new UnknownFigureType();
        };
    }
    public double getRadius() {
        return radius;
    }
}

