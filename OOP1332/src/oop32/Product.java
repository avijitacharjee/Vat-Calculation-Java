/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop32;

/**
 *
 * @author DELL
 */
public class Product {
    String name;
    double price;
    int quantity;
    Category category;
    public Product(String name, double price, int quantity,Category category)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category= category;
    }
    
}
