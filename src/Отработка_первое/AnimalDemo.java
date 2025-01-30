package Отработка_первое;

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мау!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Муу!");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow()};

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}