package workbook.jms.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

/**
 * Created by cbevard1 on 4/27/16.
 */
@Configuration
public abstract class GenericConsumer<T extends GenericConsumer.Consumer> {
    @Bean
    ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(T processor) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(processor);
        messageListenerAdapter.setDefaultListenerMethod("onMessage");

        return messageListenerAdapter;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter, String queueName) {
        SimpleMessageListenerContainer simpleMsgLisContainer = new SimpleMessageListenerContainer();
        simpleMsgLisContainer.setMessageListener(messageListenerAdapter);
        simpleMsgLisContainer.setConnectionFactory(connectionFactory);
        simpleMsgLisContainer.setDestinationName(queueName);

        return simpleMsgLisContainer;
    }

    /**
     * Interface for consumer classes. With an interface we won't have to use static methods to know the default listener method.
     */
    public interface Consumer {
        public void onMessage(String message);
    }
}
