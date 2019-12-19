package site.iblogs.spirng.bucks.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.iblogs.spirng.bucks.demo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
