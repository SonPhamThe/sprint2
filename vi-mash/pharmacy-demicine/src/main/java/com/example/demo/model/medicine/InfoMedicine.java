package com.example.demo.model.medicine;

import javax.persistence.*;

@Entity
public class InfoMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ingredient;

    private String uses;

    private String ageOfUses;

    private String expiry;

    private String preserve;


    @OneToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    public InfoMedicine() {
    }

    public InfoMedicine(Integer id, String ingredient, String uses, String ageOfUses, String expiry, String preserve, Medicine medicine) {
        this.id = id;
        this.ingredient = ingredient;
        this.uses = uses;
        this.ageOfUses = ageOfUses;
        this.expiry = expiry;
        this.preserve = preserve;
        this.medicine = medicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getAgeOfUses() {
        return ageOfUses;
    }

    public void setAgeOfUses(String ageOfUses) {
        this.ageOfUses = ageOfUses;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getPreserve() {
        return preserve;
    }

    public void setPreserve(String preserve) {
        this.preserve = preserve;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
