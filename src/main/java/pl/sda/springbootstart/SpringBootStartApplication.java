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

        Book book1 = bookDao.get(1L);
        System.out.println(book1);

        Book book2 = new Book();
        book2.setIsbn("92384798");
        book2.setAuthor("Jan Kowalski");
        book2.setTitle("Abecadlo");
        book2.setPages(213);

        bookDao.save(book2);

        Book book3 = bookDao.get(2L);
        System.out.println(book3);

 //       bookDao.delete(2L);

        book3.setAuthor("Grzegorz Nowak");
        book3.setTitle("Abecadlo 2.0");
        bookDao.update(book3);


        context.close();

	}

}
