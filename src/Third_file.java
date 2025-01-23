import java.util.ArrayList;
import java.util.List;

//2. Наследование: Класс "Работник" и "Менеджер"
class Person {
    private String name;
    private int age;
    private final String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}

class Worker extends Person {
    private double salary;

    public Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

}

class Manager extends Worker {
    private final List<Worker> workers;

    public Manager(String name, int age, String gender, double salary) {
        super(name, age, gender, salary);
        this.workers = new ArrayList<>();
    }

    public void addSubordinate(Worker worker) {
        workers.add(worker);
    }

    public List<Worker> getworkers() {
        return workers;
    }
}

public class Third_file
{

    public static void main(String[] args) {
        Person person = new Person("John", 30, "Male");
        person.displayInfo();
        person.increaseAge();
        person.changeName("Maks");
        person.displayInfo();

        Worker worker1 = new Worker("Bob", 25, "Male", 50000);
        Worker worker2 = new Worker("Charlie", 30, "Male", 55000);

        worker1.displayInfo();
        worker2.displayInfo();

        Manager manager = new Manager("Alice", 40, "Female", 80000);
        manager.addSubordinate(worker1);
        manager.addSubordinate(worker2);
    }
}

