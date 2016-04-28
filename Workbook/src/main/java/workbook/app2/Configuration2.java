package workbook.app2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import workbook.app2.consumer.Consumer2;
import workbook.app2.producer.Producer2;
import workbook.app2.domain.Processor2POJO;
import workbook.jms.configuration.GenericConsumer;

/**
 * Created by cbevard1 on 4/27/16.
 */
@Configuration
public class Configuration2 extends GenericConsumer<Consumer2> {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration2.class);
        context.registerShutdownHook();

        Producer2 producer2 = context.getBean(Producer2.class);
        producer2.sendMessage(new Processor2POJO());
    }

    @Bean
    @Value("${queueName2}")
    public String queueName(String queueName) {
        return queueName;
    }

    @Bean
    @Qualifier("processor2")
    public Consumer2 processor2() {
        return new Consumer2();
    }

    @Bean
    public Producer2 producer2(JmsTemplate jmsTemplate, String queueName) {
        return new Producer2(jmsTemplate, queueName);
    }
}