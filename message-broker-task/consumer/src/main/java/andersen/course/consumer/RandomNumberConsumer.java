package andersen.course.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberConsumer {

    @KafkaListener(topics = "random-number")
    public void consume(String message) {
        System.out.println(String.format("consumed %s", message));
    }
}
