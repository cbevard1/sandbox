package sandbox.app1.domain;

import org.codehaus.jackson.map.ObjectMapper;
import sandbox.jms.AbstractProducer;

import java.io.IOException;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class App1POJO implements AbstractProducer.JmsMessage {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "App1POJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String toJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
