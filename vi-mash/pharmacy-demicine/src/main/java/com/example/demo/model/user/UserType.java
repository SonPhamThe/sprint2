package com.example.demo.model.user;
import javax.persistence.*;
import java.util.Set;

@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "userType")
    private Set<User> users;

    public UserType() {
    }

    public UserType(Integer id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
