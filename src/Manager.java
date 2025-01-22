import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {
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
