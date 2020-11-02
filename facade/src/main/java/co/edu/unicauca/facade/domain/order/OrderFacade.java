/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.IOrderRepository;

/**
 *
 * @author daniel2402
 */
public class OrderFacade implements IOrderService {

    private Order order;

    public void createOrder(Customer customer) {
        order = new Order(customer);
        order.setState(Stat.NEW);
    }
    public void addDish(Dish dish, int amount){
        order.addDish(dish, amount);
    }

    public void changeState(Stat state){
        order.setState(state);
    }
    public void cancelOrder(){
        order.setState(Stat.CANCELLED);
    }
    public int calculateTotal(){
        
        return order.calculateTotal();
    }
    public Order getOrder() {
        return order;
    }
    public int totalDishes(){
        
        return order.getDetails().size();
    }

    @Override
    public void save(IOrderRepository repo) {
        
    }
}
