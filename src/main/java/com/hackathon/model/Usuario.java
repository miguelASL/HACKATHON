package com.hackathon.model;

import jakarta.persistence.*;

@Entity
@Table(name ="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "tipo")
    private String type;

    @Column(name = "precio")
    private float price;
    private String color;
    @Column(name = "es_gratis")
    private boolean isFree;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre=" + name + '\'' +
                ", tipo=" + type + '\'' +
                ", precio=" + price +
                ", color=" + color + '\'' +
                ", Es gratis? -> " + isFree +
                '}';
    }
}