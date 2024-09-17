package com.aubay.rh_quizz.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role",schema = "public")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(unique = true, name = "name", length = 250, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getUsers() {
        return this.users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public void addUser(UserEntity user) {
        this.users.add(user);
    }
}
