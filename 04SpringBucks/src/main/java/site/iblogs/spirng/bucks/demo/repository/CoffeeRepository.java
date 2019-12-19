package site.iblogs.spirng.bucks.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.iblogs.spirng.bucks.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
