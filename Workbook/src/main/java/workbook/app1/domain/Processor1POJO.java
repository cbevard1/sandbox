package workbook.app1.domain;

/**
 * Created by cbevard1 on 4/27/16.
 */
public class Processor1POJO {
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
        return "Processor1POJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
