package site.iblogs.spirng.bucks.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.spirng.bucks.demo.model.Coffee;
import site.iblogs.spirng.bucks.demo.model.CoffeeOrder;
import site.iblogs.spirng.bucks.demo.model.OrderState;
import site.iblogs.spirng.bucks.demo.repository.CoffeeOrderRepository;
import site.iblogs.spirng.bucks.demo.repository.CoffeeRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrder createOrder(String customer, Coffee... coffee) {
       CoffeeOrder order = CoffeeOrder.builder().customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved=coffeeOrderRepository.save(order);
        log.info("new Order:{}",saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order,OrderState state)
    {
        if(state.compareTo(order.getState())<=0)
        {
            log.warn("Wrong state order:{},{}",state,order.getState());
            return false;
        }
        order.setState(state);
        coffeeOrderRepository.save(order);
        log.info("update order:{}",order);
        return true;
    }
}
