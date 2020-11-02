/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.app.client;

import co.edu.unicauca.facade.domain.order.Customer;
import co.edu.unicauca.facade.domain.order.Dish;
import co.edu.unicauca.facade.domain.order.IOrderService;
import co.edu.unicauca.facade.domain.order.OrderFacade;
import co.edu.unicauca.facade.domain.order.OrderServiceLogger;
import co.edu.unicauca.facade.domain.order.ProxyClient;
import co.edu.unicauca.facade.domain.order.Stat;

/**
 *
 * @author daniel2402, jfsilva
 */
public class ClientMain {

    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        //El objeto proxy. Se le pasa el objeto real por el constructor
        IOrderService orderProxy = new OrderServiceLogger(facade);
 
        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        facade.addDish(new Dish(2, "Hamburguesa sencilla", 4000), 3);
        facade.addDish(new Dish(3, "Jugo hit", 1000), 2);
        System.out.println("Pedido creado");
        facade.changeState(Stat.CONFIRMED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(Stat.DISPACHED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(Stat.FINALIZED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        System.out.println("El valor total del pedido es: " + facade.calculateTotal());
        System.out.println("Total de platos pedidos: " + facade.totalDishes());
        
    
        System.out.println("Pedido grabado con éxito en la base de datos");
        
        ProxyClient client = new ProxyClient(orderProxy);
        client.createOrder();
    }
}
