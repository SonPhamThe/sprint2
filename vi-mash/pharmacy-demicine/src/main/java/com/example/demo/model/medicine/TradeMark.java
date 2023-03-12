package com.example.demo.model.medicine;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TradeMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "tradeMark")
    private Set<Medicine> medicines;

    public TradeMark() {
    }

    public TradeMark(Integer id, String content, Set<Medicine> medicines) {
        this.id = id;
        this.content = content;
        this.medicines = medicines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }
}
