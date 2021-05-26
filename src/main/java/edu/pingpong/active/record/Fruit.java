package edu.pingpong.active.record;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Fruit")
@JsonPropertyOrder({"name", "description"})
public class Fruit extends PanacheEntity {

    @NotBlank
    public String name;

    @NotEmpty
    public String description;

    // Required constructor by the JSON serialization layer
    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
}
