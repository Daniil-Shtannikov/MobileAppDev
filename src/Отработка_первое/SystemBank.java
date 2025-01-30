package Отработка_первое;

interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class CreditCard implements PaymentSystem {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " using Credit Card");
    }
}

class PayPal implements PaymentSystem {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " using PayPal");
    }
}
public class SystemBank {
    public static void main(String[] args){

    }
}
