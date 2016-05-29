package jc.sas.square;

public class Rectangle {
    double b;
    double c;

    public Rectangle(double b, double c) {
        this.b = b;
        this.c = c;
    }

    public double area() {
        return b * c;
    }
}
