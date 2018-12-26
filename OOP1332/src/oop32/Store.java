/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop32;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */

class Store {
    ArrayList<Product> product; 
    
    public Store()
    {
        product = new ArrayList();
    }
    public void addProduct(Product product)
    {
        this.product.add(product);
    }
    public double getVat()
    {
        double vat=0;
        for (Product product1 : product)
        {
            vat+=product1.price*product1.quantity*product1.category.vat/100;
        }
        //System.out.println("Total vat is: "+vat);
        return vat;
        
    }
    public double getTotalAmount()
    {
        double amount=0;
        for (Product product1 : product)
        {
            amount+=product1.price*product1.quantity;
        }
        return amount;
    }
    
}