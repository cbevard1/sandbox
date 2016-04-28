package workbook.app1.producer;

import org.springframework.jms.core.JmsTemplate;
import workbook.app1.domain.Processor1POJO;
import workbook.jms.producer.AbstractProducer;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class Producer1 extends AbstractProducer<Processor1POJO> {
    public Producer1(JmsTemplate jmsTemplate, String queueName) {
        super(jmsTemplate, queueName);
    }
}
