package workbook.app1.consumer;

import workbook.jms.configuration.GenericConsumer;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class Consumer1 implements GenericConsumer.Consumer {
    public void onMessage(String message) {
        System.out.println("processor 1 got a new message: " + message);
    }
}
