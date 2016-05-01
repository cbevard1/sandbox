package sandbox.jms;

import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class MyProjectMessageListenerContainer<T extends MyProjectMessageListenerContainer.Consumer> extends SimpleMessageListenerContainer {
    /**
     * Constructor for my project message listener container
     * @param connectionFactory
     * @param processor
     * @param queueName
     */
    public MyProjectMessageListenerContainer (ConnectionFactory connectionFactory, T processor, String queueName) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(processor);
        messageListenerAdapter.setDefaultListenerMethod("onMessage");

        this.setMessageListener(messageListenerAdapter);
        this.setConnectionFactory(connectionFactory);
        this.setDestinationName(queueName);
    }

    /**
     * Interface for consumer classes. With an interface we won't have to use static methods to know the default listener method.
     */
    public interface Consumer {
        public void onMessage(String message);
    }
}
