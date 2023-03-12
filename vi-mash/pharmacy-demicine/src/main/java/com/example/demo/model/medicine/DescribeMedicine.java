package com.example.demo.model.medicine;

import javax.persistence.*;

@Entity
public class DescribeMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ingredient;

    private String uses;

    private String usesObject;

    private String expiry;

    private String dosage;

    private String preserve;

    @OneToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    public DescribeMedicine() {
    }

    public DescribeMedicine(Integer id, String ingredient, String uses, String usesObject, String expiry, String dosage, String preserve, Medicine medicine) {
        this.id = id;
        this.ingredient = ingredient;
        this.uses = uses;
        this.usesObject = usesObject;
        this.expiry = expiry;
        this.dosage = dosage;
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

    public String getUsesObject() {
        return usesObject;
    }

    public void setUsesObject(String usesObject) {
        this.usesObject = usesObject;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
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
