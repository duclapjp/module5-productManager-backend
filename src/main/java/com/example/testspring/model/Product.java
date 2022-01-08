package com.example.testspring.model;

import javax.persistence.*;

@Table
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private String email;
    private String img;
    public Product() {
    }

    public Product(String code, String name, String description, String email, String img) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.email = email;
        this.img = img;
    }

    public Product(Long id, String code, String name, String description, String email, String img) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.email = email;
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
