package site.iblogs.spirng.bucks.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import site.iblogs.spirng.bucks.demo.model.Coffee;
import site.iblogs.spirng.bucks.demo.repository.CoffeeRepository;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Slf4j
@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Optional<Coffee> findOneCoffee(String name)
    {
        ExampleMatcher matcher=ExampleMatcher.matching()
                .withMatcher("name",exact().ignoreCase());
        Optional<Coffee> coffee=coffeeRepository.findOne(Example.of(Coffee.builder().name(name).build(),matcher));
        log.info("coffee fund:{}",coffee);
        return coffee;
    }

}
