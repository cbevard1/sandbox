package sandbox.app1.consumer;

import sandbox.jms.MyProjectMessageListenerContainer;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class App1JmsProcessor implements MyProjectMessageListenerContainer.Consumer {
    public void onMessage(String message) {
        System.out.println("processor 1 got a new message: " + message);
    }
}
