package pl.sda.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.sda.springbootstart.dao.BookDao;
import pl.sda.springbootstart.model.Book;
import pl.sda.springbootstart.producers.MessageProducer;
import pl.sda.springbootstart.repository.CarRepository;

import java.sql.SQLOutput;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootStartApplication.class, args);
//		MessageProducer messageProducer = context.getBean(MessageProducer.class);
//
//		messageProducer.printMessage();
//
//        BookDao bookDao = context.getBean(BookDao.class);
//
//        Book book = new Book();
//        book.setIsbn("197324913");
//        book.setAuthor("Pablo Picasso");
//        book.setTitle("Dao Zabrao");
//        book.setPages(123);
//
//        bookDao.save(book);
//
//        Book book1 = bookDao.get(1L);
//        System.out.println(book1);
//
//        Book book2 = new Book();
//        book2.setIsbn("92384798");
//        book2.setAuthor("Jan Kowalski");
//        book2.setTitle("Abecadlo");
//        book2.setPages(213);
//
//        bookDao.save(book2);
//
//        Book book3 = bookDao.get(8L);
//        System.out.println(book3);
//
// //       bookDao.delete(2L);
//
//        book3.setAuthor("Grzegorz Nowak");
//        book3.setTitle("Abecadlo 2.0");
//        bookDao.update(book3);
//

            CarRepository carRepository = context.getBean(CarRepository.class);
            //wszystkie auta
            carRepository.findAll().forEach(System.out::println);

            System.out.println("==========================================");

            //wszystkie auta marki Opel
            carRepository.findAllByBrand("Opel").forEach(System.out::println);

            System.out.println("============================================");

            //wszystkie auta z ceną pomiędzy xxx a xxx
            carRepository.findAllByPriceBetween(15000.00, 19000.00).forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie auta danej marki i modelu
            carRepository.findAllByBrandAndModel("Opel", "Astra").forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie auta z ceną wyższą od...
            carRepository.findAllByPriceGreaterThan(21000.00).forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie auta koloru xxx
            carRepository.findAllByColor("blue").forEach(System.out::println);
            System.out.println("============================================");

            //pierwszy samochód ze wskazaną ceną
            carRepository.findFirstByPrice(35000.00).forEach(System.out::println);
            System.out.println("============================================");

            //pierwsze 3 samachody danej marki
            carRepository.findFirst3ByBrand("Opel").forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody danej marki z podaną ceną
            carRepository.findAllByBrandAndPrice("Ford", 19000.00).forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody posortowane po cenie
            carRepository.findAllByOrderByPriceAsc().forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody dwóch podanych marek
            carRepository.findAllByBrandOrBrand("Opel", "Skoda").forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody jednego modelu spośród 3 podanych
            carRepository.findAllByModelIn(Arrays.asList("Astra", "Skoda", "Golf")).forEach(System.out::println);
            System.out.println("============================================");
            //wszystkie samochody z modelem zaczynającym sie na literę...
            carRepository.findAllByModelStartsWith("Mu").forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody z marką kończącą się na "a"
            carRepository.findAllByBrandEndsWith("el").forEach(System.out::println);
            System.out.println("============================================");

            //wszystkie samochody z marką zawierającą literę...
            carRepository.findAllByBrandContains("pe").forEach(System.out::println);
            System.out.println("============================================");


            //wszystkie samochody z marką zaczynającą się na literę ... oraz ceną większą niż ... posortowane po modelu rosnąco
            carRepository.findCarByBrandAndPriceParams("O%", 16000.00);
            System.out.println("============================================");

            //wszystkie samochody z daną marką i modelem oraz ceną mniejszą niż... posortowane po cenie malejąco
            carRepository.findCarByBrandAndModelAndPriceParams("Opel", "Astra", 16000.000);
            System.out.println("============================================");

            context.close();

	}

}
