package com.example.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String roleName; // Використовуйте camelCase для змінних

    public Roles() {
    }

    public Roles(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() { // Змінено ім'я методу
        return roleName; // Змінено ім'я поля
    }

    public void setRoleName(String roleName) { // Змінено ім'я методу
        this.roleName = roleName; // Змінено ім'я поля
    }
}
