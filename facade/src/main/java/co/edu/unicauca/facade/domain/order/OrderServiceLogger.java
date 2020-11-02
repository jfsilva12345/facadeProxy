/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daniel2402, jfsilva
 */
public class OrderServiceLogger implements IOrderService {
 private OrderFacade orderFacade;  

    public OrderServiceLogger(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;

    }

    @Override
    public void save(IOrderRepository repo) {
        Logger logger= LoggerFactory.getLogger(OrderServiceLogger.class); 
       repo.createOrder(orderFacade.getOrder());
       String message = "Pedido guardado en la base de datos";
       logger.info(message);
        
    }
 
}
