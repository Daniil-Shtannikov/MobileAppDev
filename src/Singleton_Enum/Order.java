package Singleton_Enum;

public class Order {
    private Status status;

    public Order() {
        this.status = Status.NEW;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status newStatus) {
        if (newStatus == Status.DELIVERED && this.status == Status.CANCELLED) {
            throw new IllegalArgumentException("Нельзя доставить отмененный заказ.");
        }
        this.status = newStatus;
    }
}
