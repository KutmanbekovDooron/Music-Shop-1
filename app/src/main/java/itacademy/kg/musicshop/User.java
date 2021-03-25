package itacademy.kg.musicshop;

public class User {
    String name;
    String thingsName;
    int amount;
    int quantity;

    public User(String name, String thingsName, int amount, int quantity) {
        this.name = name;
        this.thingsName = thingsName;
        this.amount = amount;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", thingsName='" + thingsName + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
