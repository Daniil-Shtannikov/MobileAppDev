package Отработка_первое;

abstract class Shape {
    public abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class ShapeArea {
    public static void main(String[] args) {
        Circle circle1 = new Circle(30);
        Rectangle rectangle1 = new Rectangle(5, 6);
        System.out.println("Circle: " + circle1.getArea());
        System.out.println("Circle: " + rectangle1.getArea());
    }
}