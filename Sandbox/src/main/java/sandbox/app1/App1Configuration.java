package sandbox.app1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.core.JmsTemplate;
import sandbox.app1.consumer.App1JmsProcessor;
import sandbox.app1.domain.App1POJO;
import sandbox.app1.producer.App1Producer;
import sandbox.jms.JmsConfiguration;
import sandbox.jms.MyProjectMessageListenerContainer;

import javax.jms.ConnectionFactory;
import java.io.IOException;

/**
 * Created by cbevard1 on 4/27/16.
 */
@Configuration
@Import(JmsConfiguration.class)
public class App1Configuration {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App1Configuration.class);
        context.registerShutdownHook();
    }

    @Value("${queueName1}")
    String queueName1;

    @Bean
    public MyProjectMessageListenerContainer<App1JmsProcessor> getConsumer(ConnectionFactory connectionFactory) {
        App1JmsProcessor app1JmsProcessor = new App1JmsProcessor();
        return new MyProjectMessageListenerContainer<App1JmsProcessor>(connectionFactory, app1JmsProcessor, queueName1);
    }

    @Bean
    public App1Producer producer1(JmsTemplate jmsTemplate) {
        return new App1Producer(jmsTemplate, queueName1);
    }
}
