package pl.sda.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.sda.springbootstart.dao.BookDao;
import pl.sda.springbootstart.model.Book;
import pl.sda.springbootstart.producers.MessageProducer;

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootStartApplication.class, args);
//		MessageProducer messageProducer = context.getBean(MessageProducer.class);
//
//		messageProducer.printMessage();

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book();
        book.setIsbn("197324913");
        book.setAuthor("Pablo Picasso");
        book.setTitle("Dao Zabrao");
        book.setPages(123);

        bookDao.save(book);

        context.close();

	}

}
