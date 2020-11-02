/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.access;

import co.edu.unicauca.facade.domain.order.Order;

/**
 *
 * @author daniel2402, jfsilva
 */
public interface IOrderRepository {
    public void createOrder(Order order);
}
