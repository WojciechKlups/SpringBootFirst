package pl.sda.springbootstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootstart.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
