package com.example.demo.model.guide;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "guide")
    private Set<ImageGuide> imageGuides;

    public Guide() {
    }

    public Guide(Integer id, String title, String content, Set<ImageGuide> imageGuides) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageGuides = imageGuides;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<ImageGuide> getImageGuides() {
        return imageGuides;
    }

    public void setImageGuides(Set<ImageGuide> imageGuides) {
        this.imageGuides = imageGuides;
    }
}
