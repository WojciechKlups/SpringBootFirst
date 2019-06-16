package pl.sda.springbootstart.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sda.springbootstart.model.Car;
import pl.sda.springbootstart.repository.CarRepository;

import java.util.stream.Stream;

@Component
public class Bootstrap implements CommandLineRunner {

    private CarRepository carRepository;

    @Autowired
    public Bootstrap(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCars();

    }

    private void loadCars() {

        Car car = new Car();
        car.setBrand("Opel");
        car.setModel("Astra");
        car.setColor("green");
        car.setPrice(15000.00);

        Car car1 = new Car();
        car1.setBrand("Volkswagen");
        car1.setModel("Golf");
        car1.setColor("black");
        car1.setPrice(18000.00);

        Car car2 = new Car();
        car2.setBrand("Ford");
        car2.setModel("Mustang");
        car2.setColor("red");
        car2.setPrice(19000.00);

        Car car3 = new Car();
        car3.setBrand("Opel");
        car3.setModel("Insignia");
        car3.setColor("yellow");
        car3.setPrice(25000.00);

        Car car4 = new Car();
        car4.setBrand("Skoda");
        car4.setModel("Skoda");
        car4.setColor("blue");
        car4.setPrice(22000.00);

        Car car5 = new Car();
        car5.setBrand("Seat");
        car5.setModel("Ibiza");
        car5.setColor("purple");
        car5.setPrice(35000.00);


        Stream.of(car, car1, car2, car3, car4, car5)
                .forEach(carRepository::save);

    }
}
