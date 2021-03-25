package itacademy.kg.musicshop;

import java.util.ArrayList;

public class Resourse {

    int image;
    String name;
    String quantity;
    String amount;
    String nameUser;

    public String getNameUser() {
        return nameUser;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getAmount() {
        return amount;
    }

    public Resourse(int image, String name, String quantity, String amount,String nameUser) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
        this.nameUser = nameUser;
    }



}
