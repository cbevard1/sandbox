package workbook.app1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import workbook.app1.consumer.Consumer1;
import workbook.app1.producer.Producer1;
import workbook.app1.domain.Processor1POJO;
import workbook.jms.configuration.GenericConsumer;

/**
 * Created by cbevard1 on 4/27/16.
 */
@Configuration
public class Configuration1 extends GenericConsumer<Consumer1> {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);
        context.registerShutdownHook();

        Producer1 producer1 = context.getBean(Producer1.class);
        producer1.sendMessage(new Processor1POJO());
    }

    @Bean
    @Value("${queueName1}") // since we don't want inject values in the base class we create a String bean to autowire into the base class
    public String queueName(String queueName) {
        return queueName;
    }

    @Bean
    public Consumer1 processor1() {
        return new Consumer1();
    }

    @Bean
    public Producer1 producer1(JmsTemplate jmsTemplate, String queueName) {
        return new Producer1(jmsTemplate, queueName);
    }
}
