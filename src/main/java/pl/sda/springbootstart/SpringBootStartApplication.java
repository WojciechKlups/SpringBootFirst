package pl.sda.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.sda.springbootstart.producers.MessageProducer;

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootStartApplication.class, args);
		MessageProducer messageProducer = context.getBean(MessageProducer.class);

		messageProducer.printMessage();

		context.close();

	}

}
