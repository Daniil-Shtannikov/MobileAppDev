package Отработка_первое;

class Animal2 {
    public void move() {
        System.out.println("Animal is moving");
    }
}

class Fish extends Animal2 {
    @Override
    public void move() {
        System.out.println("Fish is swimming");
    }
}

class Bird extends Animal2 {
    @Override
    public void move() {
        System.out.println("Bird is flying");
    }
}

class Dog2 extends Animal2 {
    @Override
    public void move() {
        System.out.println("Dog is running");
    }
}

public class AnimalMove {
    public static void main(String[] args) {

        }
    }

