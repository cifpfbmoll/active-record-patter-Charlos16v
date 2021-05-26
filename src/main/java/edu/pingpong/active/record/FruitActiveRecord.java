package edu.pingpong.active.record;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

// Single bean instance
@ApplicationScoped
public class FruitActiveRecord {

    public List<Fruit> getData() {
        return Fruit.findAll().list();
    }

    public Optional<Fruit> getFruit(String name) {
        return Fruit.find("name", name).firstResultOptional();
    }

    public void addFruit(Fruit fruit) {
        fruit.persist();
    }

    public void removeFruit(String name) {
        Fruit.delete("name", name);
    }
}
