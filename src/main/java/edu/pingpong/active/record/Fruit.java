package edu.pingpong.active.record;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="fruits")
//@JsonPropertyOrder({"name", "description"})
public class Fruit extends PanacheEntity {

    @NotBlank
    @Column
    public String name;

    @NotEmpty
    @Column
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
