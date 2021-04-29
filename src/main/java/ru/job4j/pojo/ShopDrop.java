package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int ind = index; ind < products.length - 1; ind++) {
            products[ind] = products[ind + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}