package com.example.demo.repository.model.guide;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class ImgUrlGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;

    @ManyToOne
    @JoinColumn(name = "guide_id",referencedColumnName = "id")
    @JsonManagedReference
    private Guide guide;

    public ImgUrlGuide() {
    }

    public ImgUrlGuide(Integer id, String url, Guide guide) {
        this.id = id;
        this.url = url;
        this.guide = guide;
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

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }
}
