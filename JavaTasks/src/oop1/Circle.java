package oop1;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Circle)) return false;

        Circle circle = (Circle) obj;
        return this.color.equals(circle.color) && this.radius == circle.radius;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + color.hashCode();
        long f = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (f ^ f >>> 32);
        return result;
    }

}
