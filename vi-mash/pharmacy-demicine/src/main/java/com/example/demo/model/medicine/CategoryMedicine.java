package com.example.demo.model.medicine;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CategoryMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "categoryMedicine")
    private Set<Medicine> medicine;

    public CategoryMedicine() {
    }

    public CategoryMedicine(Integer id, String name, Set<Medicine> medicine) {
        this.id = id;
        this.name = name;
        this.medicine = medicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(Set<Medicine> medicine) {
        this.medicine = medicine;
    }
}
