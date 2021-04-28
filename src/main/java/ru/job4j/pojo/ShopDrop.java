package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i == index && i != products.length - 1) {
                for (int ind = i; ind < products.length - 1; ind++) {
                    products[ind] = products[ind + 1];
                }
                products[products.length - 1] = null;
            } else if (i == index && i == products.length - 1) {
                products[i] = null;
            }
        }
        return products;
    }
    }