package Model;

public class Toy {
    Integer id;
    static Integer count =1;
    String name;
    Integer weight;

    public Toy(String name, Integer weight) {
        this.id = count++;
        this.name = name;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Toy.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.id + " "+ this.name + " "+ this.weight;
    }
}
