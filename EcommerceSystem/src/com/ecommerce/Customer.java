package com.ecommerce;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerID;
    private String name;
    private List<Product> shoppingCart;

    // Constructor
    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add a product to the shopping cart
    public void addProductToCart(Product product) {
        shoppingCart.add(product);
        System.out.println(product.getName() + " added to the shopping cart.");
    }

    // Remove a product from the shopping cart
    public void removeProductFromCart(Product product) {
        shoppingCart.remove(product);
        System.out.println(product.getName() + " removed from the shopping cart.");
    }

    // Calculate the total cost of the products in the shopping cart
    public double calculateTotal() {
        return shoppingCart.stream().mapToDouble(Product::getPrice).sum();
    }

    // Get shopping cart details
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
    

    // Display customer details
    @Override
    public String toString() {
        return "Customer Id: " + customerID + ", Name: " + name;
    }
}
