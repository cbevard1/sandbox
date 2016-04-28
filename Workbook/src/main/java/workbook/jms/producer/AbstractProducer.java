package workbook.jms.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class AbstractProducer<T> {
    protected String queueName;
    protected JmsTemplate jmsTemplate;

    public AbstractProducer(JmsTemplate jmsTemplate, String queueName) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(final T t) {
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(t.toString());
            }
        });
    }
}
