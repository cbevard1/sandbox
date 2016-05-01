package sandbox.app1.producer;

import org.springframework.jms.core.JmsTemplate;
import sandbox.app1.domain.App1POJO;
import sandbox.jms.AbstractProducer;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class App1Producer extends AbstractProducer<App1POJO> {
    public App1Producer(JmsTemplate jmsTemplate, String queueName) {
        super(jmsTemplate, queueName);
    }
}
