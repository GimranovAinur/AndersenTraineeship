package andersen.course.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomNumberProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void produce() {
        int random = ThreadLocalRandom.current().nextInt(10, 1000);
        this.kafkaTemplate.sendDefault(String.valueOf(random));
        System.out.println(String.format("produced %d", random));
    }

}
