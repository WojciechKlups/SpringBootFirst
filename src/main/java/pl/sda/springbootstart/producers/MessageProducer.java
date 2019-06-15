package pl.sda.springbootstart.producers;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageProducer {

    public void printMessage(){
        System.out.println("Example message " + LocalDateTime.now());
    }
}
