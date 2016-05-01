package sandbox.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class AbstractProducer<T extends AbstractProducer.JmsMessage> {
    protected String queueName;
    protected JmsTemplate jmsTemplate;

    public AbstractProducer(JmsTemplate jmsTemplate, String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(final T t) throws IOException {
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                try {
                    return session.createTextMessage(t.toJson());
                } catch (IOException e) {
                    throw new JMSException("Error converting toJson :" + t.toString());
                }
            }
        });
    }

    /**
     * Interface for any messages we want to process. Not including the fromJson method because processors use that method
     * and they aren't generic.
     *
     */
    public interface JmsMessage {
        String toJson() throws IOException;
    }
}
