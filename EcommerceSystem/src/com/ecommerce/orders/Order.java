package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.List;

public class Order {

    private int orderID;
    private double total;
    private Customer customer;
    private List<Product> products;

    public Order(int orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.total = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    // Generate order summary
    public void orderSummary() {
        System.out.println("Order Id: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products: ");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": $" + product.getPrice() + " USD");
        }
        System.out.println("Total: $" + total + " USD");
    }
}
