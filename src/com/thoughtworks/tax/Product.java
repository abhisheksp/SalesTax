package com.thoughtworks.tax;

import java.util.Set;

public class Product {

    private String name;
    private double price;
    private String category;
    private boolean isImported;

    public Product(double price, String chocolate, String category, boolean isImported) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.isImported = isImported;
    }

    public double tax(int taxPercent) {
        return taxPercent * 12.49 / 100;
    }
}
