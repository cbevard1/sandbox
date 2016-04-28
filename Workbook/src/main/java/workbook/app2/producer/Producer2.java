package workbook.app2.producer;

import org.springframework.jms.core.JmsTemplate;
import workbook.app2.domain.Processor2POJO;
import workbook.jms.producer.AbstractProducer;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class Producer2 extends AbstractProducer<Processor2POJO> {
    public Producer2(JmsTemplate jmsTemplate, String queueName) {
        super(jmsTemplate, queueName);
    }
}
