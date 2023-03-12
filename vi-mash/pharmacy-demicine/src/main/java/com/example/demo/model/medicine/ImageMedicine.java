package com.example.demo.model.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ImageMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    public ImageMedicine() {
    }

    public ImageMedicine(Integer id, String url, Medicine medicine) {
        this.id = id;
        this.url = url;
        this.medicine = medicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
