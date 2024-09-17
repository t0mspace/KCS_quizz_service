package com.aubay.rh_quizz.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements UserDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    @Column(name = "id")
    private int id;

    @Nullable
    @Column(name = "username", length = 250, nullable = false)
    private String username;

    @Nullable
    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Nullable
    @Column(name = "token", length = 250, nullable = true)
    private String token;

    @Nullable
    @Column(name = "password", length = 250, nullable = true)
    private String password;

//    @Column(name = "id_role", nullable = false)
//    private int id_role;

    @Nullable
    @Column(name = "is_active", nullable = false)
    private boolean is_active;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false)  // Foreign key column in User table
    private RoleEntity role;

    public UserEntity(int id, String username, String email, String token, String password) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.password = password;
    }

    public UserEntity(String username, String email, String token, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity() {
    }

    public boolean isActive()
    {
        return this.is_active;
    }

    public void enable()
    {
        this.is_active = true;
    }

    public String getUsername() {
        return username;
    }

    public String getByEmail() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public int getId() {
        return id;
    }

    public RoleEntity getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return this.is_active;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
