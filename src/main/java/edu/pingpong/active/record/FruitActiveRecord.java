package edu.pingpong.active.record;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Single bean instance
@ApplicationScoped
public class FruitActiveRecord {

    public FruitActiveRecord() {}

    public Set<Fruit> getData() {
        Stream<Fruit> fruits = Fruit.streamAll();
        return fruits.collect(Collectors.toSet());
    }

    public Optional<Fruit> getFruit(String name) {
        return name.isBlank()?
                Optional.ofNullable(null) :
                Fruit.find("name", name).firstResultOptional();
    }

    public void addFruit(Fruit fruit) {
        fruit.persistAndFlush();
    }

    public void removeFruit(String name) {
        Fruit fruit = Fruit.find("name", name).firstResult();
        fruit.delete();
    }
}
