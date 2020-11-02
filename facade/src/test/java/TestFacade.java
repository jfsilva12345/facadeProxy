

import co.edu.unicauca.facade.domain.order.Customer;
import co.edu.unicauca.facade.domain.order.Dish;
import co.edu.unicauca.facade.domain.order.OrderFacade;
import co.edu.unicauca.facade.domain.order.Stat;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel2402, jfsilva
 */
public class TestFacade {

    @Test
    public void testCreateOrder() {
        OrderFacade facade = new OrderFacade();
        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        facade.addDish(new Dish(2, "Hamburguesa sencilla ", 4000), 3);
        facade.addDish(new Dish(3, "Jugo hit ", 1000), 2);
        assertEquals("Hamburguesa vegetariana",
                facade.getOrder().getDetails().get(0).getDish().getName());
        assertEquals(Stat.NEW, facade.getOrder().getState());
        facade.changeState(Stat.FINALIZED);
        assertEquals(Stat.FINALIZED, facade.getOrder().getState());
        assertEquals(3, facade.totalDishes());
        assertEquals(24000, facade.calculateTotal());
        facade.cancelOrder();
        facade.changeState(Stat.CANCELLED);
    }

}
