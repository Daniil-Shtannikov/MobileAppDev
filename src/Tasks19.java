class Device {
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " device is turned on");
    }

    public void turnOff() {
        System.out.println(brand + " device is turned off");
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println("Taking a photo with " + getBrand() + " smartphone");
    }

    private String getBrand() {
        return super.toString();
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void code() {
        System.out.println("Coding on " + getBrand() + " laptop");
    }

    private String getBrand() {
        return super.toString();
    }
}
public class Tasks19 {
    public static void main(String[] args){

    }
}
