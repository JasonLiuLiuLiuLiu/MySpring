package site.iblogs.spirng.bucks.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import site.iblogs.spirng.bucks.demo.model.Coffee;
import site.iblogs.spirng.bucks.demo.model.CoffeeOrder;
import site.iblogs.spirng.bucks.demo.model.OrderState;
import site.iblogs.spirng.bucks.demo.repository.CoffeeRepository;
import site.iblogs.spirng.bucks.demo.service.CoffeeOrderService;
import site.iblogs.spirng.bucks.demo.service.CoffeeService;

import java.util.Optional;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService coffeeOrderService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void  run(ApplicationArguments args) throws Exception{

        log.info("all coffee:{}",coffeeRepository.findAll());

        Optional<Coffee> latte=coffeeService.findOneCoffee("Latte");
        if(latte.isPresent())
        {
            CoffeeOrder order =coffeeOrderService.createOrder("Li lei",latte.get());
            log.info("update INIT to PAID:{}",coffeeOrderService.updateState(order, OrderState.PAID));
            log.info("update PAID to INIT:{}",coffeeOrderService.updateState(order,OrderState.INIT));

        }

    }

}
