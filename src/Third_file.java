//2. Наследование: Класс "Работник" и "Менеджер"

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

