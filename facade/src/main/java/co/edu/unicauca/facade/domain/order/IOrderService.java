/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.IOrderRepository;

/**
 *
 * @author daniel2402, jfsilva
 */
public interface IOrderService {
    
    public void save(IOrderRepository repo);
}
