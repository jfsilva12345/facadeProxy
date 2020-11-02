/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.domain.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author daniel2402, jfsilva
 */
public class Order {
    public int despatch;
    private Customer customer;
    private Date date;
    private Stat state;
    private ArrayList<Item> details;

    public Order(Customer customer) {
        this.details = new ArrayList<>();
        this.customer = customer;
    }

    public int getDespatch() {
        return despatch;
    }

    public void setDespatch(int despatch) {
        this.despatch = despatch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stat getState() {
        return state;
    }

    public void setState(Stat state) {
        this.state = state;
    }

    public List<Item> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Item> details) {
        this.details = details;
    }
    public void addDish(Dish dish, int amount){
        Item item = new Item(dish, amount);
        this.details.add(item);
        
    }
    public int calculateTotal(){
        int total=0;
         for (int i=0;i<this.details.size();i++) {
             total=total+(this.details.get(i).getAmount()*this.details.get(i).getDish().getPrice());
    }
     
        return total;
    }
}
