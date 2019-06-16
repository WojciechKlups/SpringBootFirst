package pl.sda.springbootstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.springbootstart.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByPriceBetween(double price1, double price2);

    List<Car> findAllByBrandAndModel(String brand, String model);

    List<Car> findAllByPriceGreaterThan(double price);

    List<Car> findAllByColor(String color);

    List<Car> findFirstByPrice(double price);

    List<Car> findFirst3ByBrand(String brand);

    List<Car> findAllByBrandAndPrice(String brand, double price);

    List<Car> findAllByOrderByPriceAsc();

    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    List<Car> findAllByModelIn(List<String> cars);

    List<Car> findAllByModelStartsWith(String start);

    List<Car> findAllByBrandEndsWith(String end);

    List<Car> findAllByBrandContains(String contain);

    @Query("select c from Car c where c.brand like :start and c.price > :price order by c.model asc")
    Car findCarByBrandAndPriceParams(
            @Param("start") String start,
            @Param("price") Double price);

    @Query("select c from Car c where c.brand like :brand and c.model like :model and c.price < :price order by c.price desc")
    Car findCarByBrandAndModelAndPriceParams(
            @Param("brand") String brand,
            @Param("model") String model,
            @Param("price") Double price);

}




